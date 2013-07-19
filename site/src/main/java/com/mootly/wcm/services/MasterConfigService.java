package com.mootly.wcm.services;

public interface MasterConfigService {
	
	boolean getBoolean(String propertyName);
	
	String getString(String propertyName);
	
	Integer getInteger(String propertyName);
	
	String[] getArray(String propertyName,String separator);
	String[] getArray(String propertyName);
}
