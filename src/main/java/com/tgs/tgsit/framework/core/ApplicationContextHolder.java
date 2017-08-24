package com.tgs.tgsit.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextHolder 以静态变量保存 Spring ApplicationContext, 可在任何代码任何地方任何时候中取出
 * ApplicaitonContext.
 * 
 * @author
 * @version 1.0
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory.getLogger(ApplicationContextHolder.class);

	/**
	 * 实现 ApplicationContextAware 接口, 注入Context到静态变量中.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		logger.debug("注入 ApplicationContext 到 ApplicationContextHolder:" + applicationContext);

		if (ApplicationContextHolder.applicationContext != null) {
			logger.warn("ApplicationContextHolder 中的 ApplicationContext 被覆盖, 原有 ApplicationContext 为:" + ApplicationContextHolder.applicationContext);
		}
		ApplicationContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 取得存储在静态变量中的 ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
	 * 
	 * @param <T>
	 * @param name
	 *            - Bean's name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 清除 ApplicationContextHolder 中的 ApplicationContext 为 Null.
	 */
	public static void clear() {
		logger.debug("清除 ApplicationContextHolder 中的 ApplicationContext:" + applicationContext);
		applicationContext = null;
	}

	/**
	 * 实现 DisposableBean 接口,在 Context 关闭时清理静态变量.
	 */
	@Override
	public void destroy() throws Exception {
		ApplicationContextHolder.clear();
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext 未注入,请在 applicationContext.xml 中定义 ApplicationContextHolder");
		}
	}

}
