package qjm.data.synch.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import qjm.data.synch.annotation.Family;

import java.io.IOException;
import java.lang.reflect.Field;
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

    /**
     * 删除数据
     */
    public <T extends HbaseSerialization> void deleteData(Class<T> clazz, Delete delete) throws IOException {
        deleteData(getTableName(clazz), delete);
    }

    /**
     * 创建一个表
     *
     * @throws Exception
     */
    public <T extends HbaseSerialization> void createTable(Class<T> clazz) throws Exception {
        // 创建表管理类
        HBaseAdmin admin = new HBaseAdmin(config); // hbase表管理
        createTable(clazz, admin);
        admin.close();
    }

    /**
     * 创建表
     *
     * @throws Exception
     */
    private <T extends HbaseSerialization> void createTable(Class<T> clazz, HBaseAdmin hBaseAdmin) throws IOException {

        // 创建表描述类
        TableName tableName = TableName.valueOf(getTableName(clazz)); // 表名称
        HTableDescriptor desc = new HTableDescriptor(tableName);

        // 创建列族的描述类
        List<String> families = getFamilies(clazz);
        if(families.size() == 0){
            throw new RuntimeException("Can't  found family");
        }
        for(String fam : families){
            HColumnDescriptor family = new HColumnDescriptor(fam); // 列族
            // 将列族添加到表中
            desc.addFamily(family);
        }

        //创建
        hBaseAdmin.createTable(desc);
    }

    /**
     * 获取所有列簇
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends HbaseSerialization> List<String> getFamilies(Class<T> clazz){
        List<String> families = new ArrayList();

        //获取默认列簇
        Family family = clazz.getAnnotation(Family.class);
        if(family != null){
            families.add(family.value());
        }

        //得到类中的所有属性集合
        Field[] fields = clazz.getDeclaredFields();
        //遍历属性
        for (Field field:fields) {
            Family fam = field.getAnnotation(Family.class);
            if(fam != null){
                if(!families.contains(fam.value())){
                    families.add(fam.value());
                }
            }
        }

        return families;
    }

    /**
     * 检查表是否存在
     * @param tableName
     * @return
     */
    public boolean tableExists(String tableName) throws IOException {
        HBaseAdmin hbaseAdmin = new HBaseAdmin(config);
        boolean exist = hbaseAdmin.tableExists(tableName);
        hbaseAdmin.close();
        return exist;
    }

    /**
     * 检查表是否存在
     * @return
     */
    public <T extends HbaseSerialization> boolean tableExists(Class<T> clazz) throws IOException {
        return tableExists(getTableName(clazz));
    }

    /**
     * 检查表是否存在
     */
    public <T extends HbaseSerialization> void checkAndCreateTable(Class<T> clazz) throws IOException {
        HBaseAdmin hbaseAdmin = new HBaseAdmin(config);
        boolean exist = hbaseAdmin.tableExists(getTableName(clazz));
       if (!exist){
           createTable(clazz, hbaseAdmin);
           hbaseAdmin.close();
       }
    }
}
