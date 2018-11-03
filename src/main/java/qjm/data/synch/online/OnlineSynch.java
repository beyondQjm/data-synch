package qjm.data.synch.online;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.hbase.HbaseSerialization;
import qjm.data.synch.hbase.HbaseUtils;
import qjm.data.synch.modle.Employee;
import qjm.data.synch.service.SqlDataService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * 实时同步数据
 */
public class OnlineSynch {
    static final Log LOG = LogFactory.getLog(OnlineSynch.class);

    SqlDataService sqlDataService = new SqlDataService("SqlMapConfig.xml");
    HbaseUtils hbaseUtils = new HbaseUtils();

    /**
     * 从关系型数据库同步数据到hbase
     */
    public void synchToHbase(){
        // 创建链接
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress("192.168.135.132",
                        11111),
                "example",
                "",
                ""
        );
        int batchSize = 1000;
        Long batchId  = null;
        try {
            connector.connect();
            //指定监听数据库
            connector.subscribe("grg_hr\\..*");
            connector.rollback();
            while (true) {
                // 获取指定数量的数据
                Message message = connector.getWithoutAck(batchSize);
                batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    LOG.info("waitting...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                } else {
                    LOG.info(String.format("\nmessage[batchId=%s,size=%s]", batchId, size));
                    handleEntry(message.getEntries());
                }

                connector.ack(batchId); // 提交确认
            }
        } catch (Exception e) {
            // 处理失败, 回滚数据
            if (batchId != null) connector.rollback(batchId);

            LOG.error("Error: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            connector.disconnect();
        }
    }

    /**
     * 处理
     * @param entries
     */
    private void handleEntry(List<Entry> entries) {
        //循环事件
        for (Entry entry : entries) {
            if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
                continue;
            }

            RowChange rowChange = null;
            try {
                rowChange = RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }

            //输出事件信息
            CanalEntry.EventType eventType = rowChange.getEventType();
            Header header = entry.getHeader();
            LOG.info(String.format("\n================&gt; binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    header.getLogfileName(), header.getLogfileOffset(),
                    header.getSchemaName(), header.getTableName(),
                    eventType));

            //解析事件
            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                if (eventType == EventType.DELETE) {
                    LOG.info("\n-------&gt; delete");
                    deleteData(header.getTableName(), rowData.getBeforeColumnsList());
                } else if (eventType == EventType.INSERT) {
                    LOG.info("\n-------&gt; insert");
                    updateData(header.getTableName(), rowData.getAfterColumnsList());
                } else if (eventType == EventType.UPDATE) {
                    //LOG.info("\n-------&gt; before");
                    //printColumn(rowData.getBeforeColumnsList());
                    LOG.info("\n-------&gt; after");
                    updateData(header.getTableName(),rowData.getAfterColumnsList());
                }
            }
        }
    }

    /**
     * 更新数据
     */
    private void updateData(String tableName, List<Column> columns){
        /**
         * 1. 获取主键
         * 2. 根据主键查询
         * 3. 更新到hbase
         */
        //获取主键
        Long key = getKey(columns);

        HbaseSerialization serialization = null;
        //根据不同表做处理
        if(tableName.equals("hr_employee")){
            //serialization = sqlDataService.getEmployeeById(key);
            serialization = sqlDataService.getById(key, Employee.class);
        }

        if (serialization != null){
            try {
                Employee employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
                LOG.info("before : \n"+employee);

                hbaseUtils.putData(serialization);

                employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
                LOG.info("before : \n"+employee);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
    }

    /**
     * 删除数据
     */
    private void deleteData(String tableName, List<Column> columns){
        /**
         * 1. 获取主键
         * 2. 根据主键删除hbase数据
         */
        //获取主键
        Long key = getKey(columns);

        Class clazz = null;
        //根据不同表做处理
        if(tableName.equals("hr_employee")){
            clazz = Employee.class;
        }

        try {
            Employee employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
            LOG.info("before : \n"+employee);

            hbaseUtils.deleteData(clazz, new Delete(Bytes.toBytes(key)));

            employee = hbaseUtils.getData(new Get(Bytes.toBytes(key)), Employee.class);
            LOG.info("after : \n"+employee);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }

    /**
     * 获取主键
     * @return
     */
    private Long getKey(List<Column> columns){
        try{
            for (Column column : columns) {
                if(column.getName().equals("id")){
                    return Long.valueOf(column.getValue());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException("Not found primary key !");
        }
        throw  new RuntimeException("Not found primary key !");
    }

}
