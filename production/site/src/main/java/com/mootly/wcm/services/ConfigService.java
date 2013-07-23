package com.mootly.wcm.services;

public interface ConfigService {
	String[] getArray(String propertyKey);
	
	String getString(String propertyKey);
	String getString(String propertyKey,String defaultValue);

	Boolean getBoolean(String propertyKey);
	Boolean getBoolean(String propertyKey,Boolean defaultValue);

	
	Integer getInteger(String propertyKey);
}
