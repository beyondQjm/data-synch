package qjm.data.synch.hbase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;

/**
 * hbase对象序列化接口
 */
public interface HbaseSerialization<T> {

    /**
     * 反序列化
     * @param result
     * @return
     */
    public T deserializing(Result result);

    /**
     * 序列化
     * @return
     */
    public Put serializing();

    /**
     * 获取主键
     * @return
     */
    public byte[] getKey();

}
