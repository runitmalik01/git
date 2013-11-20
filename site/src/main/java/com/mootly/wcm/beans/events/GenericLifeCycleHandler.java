package com.mootly.wcm.beans.events;

import java.util.List;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.components.ITReturnComponentHelper;

public class GenericLifeCycleHandler implements BeanLifecycle<HippoBean>{

	@Override
	public void beforeCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCreate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beforeSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterSaveNewBean(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFillParentBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFillChildBeanMap(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean validateChildBean(HippoBean hippoBean, boolean isNew,
			List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean validateParentBean(HippoBean hippoBean, boolean isNew,
			List<String> errors, List<String> warnings) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean beforeUpdate(HippoBean hippoBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterUpdate(HippoBean beanBeforeUpdate,
			HippoBean beanAfterUpdate, WorkflowPersistenceManager wpm,
			String baseAbsolutePathToReturnDocuments,ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterUpdateChild(HippoBean parentBeanBeforeUpdate,
			HippoBean parentBeanAfterUpdate, HippoBean childBeanBeforeUpdate,
			HippoBean childBeanAfterUpdate, WorkflowPersistenceManager wpm,
			ITReturnComponentHelper itReturnComponentHelper) {
		// TODO Auto-generated method stub
		
	}


}
