package qjm.data.synch.hbase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.annotation.Clipping;
import qjm.data.synch.annotation.Column;
import qjm.data.synch.annotation.Family;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 通过反射序列化对象
 * @param <T> this class
 */
public abstract class HbaseSerializationReflect<T> implements HbaseSerialization<T> {

    public T deserializing(Result result) {
        // 得到类对象
        Class clazz = this.getClass();
        //得到类中的所有属性集合
        Field[] fields = clazz.getDeclaredFields();

        //遍历属性
        for (Field field:fields) {
            //判断属性是否需要转换
            if(field.getAnnotation(Clipping.class) != null){
                continue;
            }

            // 设置些属性是可以访问的
            field.setAccessible(true);

            try {
                //获取属性值
                byte[] arr = result.getValue(Bytes.toBytes(getFamilyName(clazz, field)), Bytes.toBytes(getColumnName(field)));

                if (arr != null) {
                    Class cla = field.getType();
                    //将二进制数组转为值,并设置
                    field.set(this, byteArrayto(cla, arr));
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return (T) this;
    }

    public Put serializing() {
        Put put = new Put(getKey());

        // 得到类对象
        Class clazz = this.getClass();
        //得到类中的所有属性集合
        Field[] fields = clazz.getDeclaredFields();

        //遍历属性
        for (Field field:fields) {
            //判断属性是否需要转换
            if(field.getAnnotation(Clipping.class) != null){
                continue;
            }

            // 设置些属性是可以访问的
            field.setAccessible(true);
            try {
                //获取属性值
                Object val = field.get(this);
                if (val != null){
                    Class cla = field.getType();
                    //将值转为二进制数组
                    byte[] arr = toByteArray(cla, val);

                    put.add(Bytes.toBytes(getFamilyName(clazz, field)), Bytes.toBytes(getColumnName(field)), arr);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
        return put;
    }

    /**
     * 获取列簇
     * @param clazz
     * @param field
     * @return
     */
    private String getFamilyName(Class clazz, Field field){
        //获取默认列簇
        String defualtFamily = null;
        Family family = (Family) clazz.getAnnotation(Family.class);
        if(family != null){
            defualtFamily = family.value();
        }

        //获取列指定列簇
        String familyName;
        Family familyField = field.getAnnotation(Family.class);
        if (familyField != null){
            familyName = familyField.value();
        }else {
            familyName = defualtFamily;
        }

        //判断是否有列簇
        if(familyName == null){
            throw new RuntimeException("Family name is not null");
        }

        return familyName;
    }

    /**
     * 获取属性名
     * @param field
     * @return
     */
    private String getColumnName(Field field){
        Column column = field.getAnnotation(Column.class);
        if(column != null){
            return column.value();
        }else {
            return field.getName();
        }
    }

    /**
     * 将值转换为二进制数组
     * @param clazz
     * @param obj
     * @return
     */
    private <T> byte[] toByteArray(Class<T> clazz, Object obj){
        if(clazz == String.class){//字符串
            String value = (String) obj;
            return value.getBytes();
        }else if (clazz == int.class || clazz == Integer.class){//整型
            Integer value = (Integer) obj;
            return Bytes.toBytes(value);
        }else if(clazz == double.class || clazz == Double.class){//双精度
            Double value = (Double) obj;
            return Bytes.toBytes(value);
        }else if(clazz == float.class || clazz == Float.class){//单精度
            Float value = (Float) obj;
            return Bytes.toBytes(value);
        }else if(clazz == long.class || clazz == Long.class) {//长整型
            Long value = (Long) obj;
            return Bytes.toBytes(value);
        }else if(clazz == Date.class) {//日期
            Date value = (Date) obj;
            return Bytes.toBytes(value.getTime());
        }else {//不能转换的类型
            throw new RuntimeException("Can't conversion type: " + clazz);
        }
    }

    /**
     * 将二进制数组转换为值
     * @param clazz
     * @param bytes
     * @return
     */
    private <T> T byteArrayto(Class<T> clazz, byte[] bytes){
        if(clazz == String.class){//字符串
            return (T) Bytes.toString(bytes);
        }else if (clazz == int.class || clazz == Integer.class){//整型
            return (T) Integer.valueOf(Bytes.toInt(bytes));
        }else if(clazz == double.class || clazz == Double.class){//双精度
            return (T) Double.valueOf(Bytes.toDouble(bytes));
        }else if(clazz == float.class || clazz == Float.class){//单精度
            return (T) Float.valueOf(Bytes.toFloat(bytes));
        }else if(clazz == long.class || clazz == Long.class) {//长整型
            return (T) Long.valueOf(Bytes.toLong(bytes));
        }else if(clazz == Date.class) {//日期
            return (T) new Date(Bytes.toLong(bytes));
        }else {//不能转换的类型
            throw new RuntimeException("Can't conversion type: " + clazz);
        }
    }
}
