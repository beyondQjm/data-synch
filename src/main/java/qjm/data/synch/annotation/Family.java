package qjm.data.synch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 列簇
 * <p>用于指定属性列簇</p>
 * <p>当用在类上时，指定类所有属性默认列簇</p>
 * <p>当用在属性上时，指定该属性所属列簇</p>
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Family {
    String value();
}
