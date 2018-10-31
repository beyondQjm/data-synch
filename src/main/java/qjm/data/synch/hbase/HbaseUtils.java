package qjm.data.synch.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * hbase封装工具
 */
public class HbaseUtils {
    private Configuration config = null;
    private Connection connection = null;

    public HbaseUtils() {
        try {
            config = HBaseConfiguration.create();// 配置
            connection = ConnectionFactory.createConnection(config);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     * @return
     * @throws IOException
     */
    public Connection getConnection() throws IOException {
        return connection;
    }

    /**
     * 创建新连接
     * @return
     * @throws IOException
     */
    public Connection newConnection() throws IOException {
        return ConnectionFactory.createConnection(config);
    }

    /**
     * 关闭连接
     */
    public void close(){
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加数据
     * @param tableName 表名
     * @param serialization
     * @throws IOException
     */
    public void putData(String tableName, HbaseSerialization serialization) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = serialization.serializing();
        //插入数据
        table.put(put);
        table.close();
    }

    /**
     * 添加数据
     * @param serialization
     * @throws IOException
     */
    public void putData(HbaseSerialization serialization) throws IOException {
        putData(getTableName(serialization), serialization);
    }

    /**
     * 获取表名
     * @param serialization
     * @throws IOException
     */
    public String getTableName(HbaseSerialization serialization) throws IOException {
        return getTableName(serialization.getClass());
    }

    /**
     * 获取表名
     * @param clazz
     * @throws IOException
     */
    public <T extends HbaseSerialization> String getTableName(Class<T> clazz) throws IOException {
        qjm.data.synch.annotation.Table table = clazz.getAnnotation(qjm.data.synch.annotation.Table.class);
        if (table != null){
            return table.value();
        }else {
            String className = clazz.getSimpleName();
            return className.substring(0,1).toLowerCase() + className.substring(1);
        }
    }

    /**
     * 添加数据
     * @param tableName 表名
     * @param serializations
     * @throws IOException
     */
    public void putData(String tableName, List<? extends HbaseSerialization> serializations) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        List<Put> put = new ArrayList<Put>();
        for (HbaseSerialization serialization:serializations){
            put.add(serialization.serializing());
        }
        //插入数据
        table.put(put);
        table.close();
    }

    /**
     * 添加数据
     * @param serializations
     * @throws IOException
     */
    public void putData(List<? extends HbaseSerialization> serializations) throws IOException {
        if (serializations != null && serializations.size() >0){
            putData(getTableName(serializations.get(0)),serializations);
        }
    }

    /**
     *  获取数据
     * @throws Exception
     */
    public <T extends HbaseSerialization> List<T> scanData(String tableName, Scan scan, Class<T> clazz) throws Exception {
        Table table = connection.getTable(TableName.valueOf(tableName));
        ResultScanner scanner = table.getScanner(scan);

        List<T> list = new ArrayList<T>();
        for (Result result : scanner) {
            T modle = clazz.newInstance();
            modle.deserializing(result);
            list.add(modle);
        }
        table.close();
        return list;
    }

    /**
     *  获取数据
     * @throws Exception
     */
    public <T extends HbaseSerialization> List<T> scanData(Scan scan, Class<T> clazz) throws Exception {
        return scanData(getTableName(clazz), scan, clazz);
    }

    /**
     *  获取数据
     * @throws Exception
     */
    public <T extends HbaseSerialization> T getData(String tableName, Get get, Class<T> clazz) throws Exception {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Result result = table.get(get);

        T modle = clazz.newInstance();
        modle.deserializing(result);

        table.close();
        return modle;
    }

    /**
     *  获取数据
     * @throws Exception
     */
    public <T extends HbaseSerialization> T getData(Get get, Class<T> clazz) throws Exception {
        return getData(getTableName(clazz), get, clazz);
    }

    /**
     * 删除数据
     */
    public void deleteData(String tableName, Delete delete) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        table.delete(delete);
        table.close();
    }

}
