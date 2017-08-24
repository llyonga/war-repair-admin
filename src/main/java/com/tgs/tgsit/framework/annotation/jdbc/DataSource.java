package com.tgs.tgsit.framework.annotation.jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 读写分离数据源注解<br>
 * 注意：当与@Cache注解同时使用时，需要放到Cache注解下面
 * 
 * @author
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

	public static final String MASTER = "MASTER";
	public static final String SLAVE = "SLAVE";

	String value() default MASTER;

}
