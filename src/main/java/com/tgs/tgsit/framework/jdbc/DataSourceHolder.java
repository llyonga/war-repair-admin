package com.tgs.tgsit.framework.jdbc;

import org.springframework.util.Assert;

public class DataSourceHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDataSourceType(String dataSourceType) {
		Assert.notNull(dataSourceType, "Target data 'dataSourceType' cannot be null");
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
