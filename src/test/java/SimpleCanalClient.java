import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.net.InetSocketAddress;
import java.util.List;

/**
 * canal测试类
 */
public class SimpleCanalClient {
    static final Log LOG = LogFactory.getLog(SimpleCanalClient.class);

    public static void main(String args[]) {
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
                    printEntry(message.getEntries());
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

    private static void printEntry(List<Entry> entrys) {
        //循环事件
        for (Entry entry : entrys) {
            if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
                continue;
            }

            RowChange rowChage = null;
            try {
                rowChage = RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }

            //输出事件信息
            EventType eventType = rowChage.getEventType();
            LOG.info(String.format("\n================&gt; binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            //解析事件
            for (RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == EventType.DELETE) {
                    LOG.info("\n-------&gt; delete");
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == EventType.INSERT) {
                    LOG.info("\n-------&gt; insert");
                    printColumn(rowData.getAfterColumnsList());
                } else {
                    //LOG.info("\n-------&gt; before");
                    //printColumn(rowData.getBeforeColumnsList());
                    LOG.info("\n-------&gt; after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private static void printColumn(List<Column> columns) {
        for (Column column : columns) {

            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

}
