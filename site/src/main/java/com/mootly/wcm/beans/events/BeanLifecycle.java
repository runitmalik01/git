package com.mootly.wcm.beans.events;

public interface BeanLifecycle<T> {
	//we can do few operation when a bean is created, this could be either the parent bean or child bean
	void beforeCreate(T hippoBean);
	void afterCreate(T hippoBean);
	
	boolean beforeSaveNewBean(T hippoBean);
	void afterSaveNewBean(T hippoBean);
	
	
	boolean beforeUpdate(T hippoBean);
	void afterUpdate(T hippoBean);
}
