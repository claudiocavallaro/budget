package com.example.testdb.demodb.utils;

public class Utils {

	public static PropertyService getProperty() {
		return ContextAccessor.getBean(PropertyService.class);
	}
}
