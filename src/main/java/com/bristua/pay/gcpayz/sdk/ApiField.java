package com.bristua.pay.gcpayz.sdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据结构属性注解
 * @author richsjeson@gmail.com
 * @site https://www.gcpayz.com
 * @date 2021-06-08 11:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface ApiField {

    /**
     * JSON属性映射名称
     **/
    String value() default "";

}
