package com.mootly.wcm.beans.events;

import java.util.List;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;

import com.mootly.wcm.components.ITReturnComponentHelper;

public interface BeanLifecycle<T> {
	//we can do few operation when a bean is created, this could be either the parent bean or child bean
	void beforeCreate(T hippoBean);
	void afterCreate(T hippoBean);
	
	boolean beforeSaveNewBean(T hippoBean);
	void afterSaveNewBean(T hippoBean);
	
	void beforeFillParentBeanMap(T hippoBean);
	void beforeFillChildBeanMap(T hippoBean);
	
	void afterFillParentBeanMap(T hippoBean);
	void afterFillChildBeanMap(T hippoBean);
	
	boolean validateChildBean(T hippoBean,boolean isNew,List<String> errors,List<String> warnings); //this will return a list of all validation error messages a return of NULL represents pass in validation
	boolean validateParentBean(T hippoBean,boolean isNew,List<String> errors,List<String> warnings); //this will return a list of all validation error messages a return of NULL represents pass in validation
	
	boolean beforeUpdate(T hippoBean);
	void afterUpdate(T beanBeforeUpdate,T beanAfterUpdate,WorkflowPersistenceManager wpm,String baseAbsolutePathToReturnDocuments,ITReturnComponentHelper itReturnComponentHelper);

	
	void afterUpdateChild(T parentBeanBeforeUpdate,T parentBeanAfterUpdate,T childBeanBeforeUpdate,T childBeanAfterUpdate, WorkflowPersistenceManager wpm,ITReturnComponentHelper itReturnComponentHelper);
}
