package com.tgs.tgsit.framework.jdbc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tgs.tgsit.framework.annotation.jdbc.DataSource;

import java.lang.reflect.Method;

@Aspect
@Order(1)
@Component
public class DataSourceAspect {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

	/**
	 * 前置通知 用于拦截Service层业务操作
	 * 
	 * @param point
	 */
	@Before("@annotation(com.tgs.tgsit.framework.annotation.jdbc.DataSource)")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();

		Class<? extends Object> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

		try {
			Method m = classz.getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				DataSourceHolder.setDataSourceType(data.value());
			}
		}
		catch (Exception e) {
			logger.error("DataSourceAspect before error", e);
		}
	}

}
