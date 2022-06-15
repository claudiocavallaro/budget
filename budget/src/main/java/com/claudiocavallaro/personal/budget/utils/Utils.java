package com.claudiocavallaro.personal.budget.utils;

public class Utils {

	public static PropertyService getProperty() {
		return ContextAccessor.getBean(PropertyService.class);
	}
}
