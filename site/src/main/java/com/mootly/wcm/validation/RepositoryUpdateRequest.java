package com.mootly.wcm.validation;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;

public class RepositoryUpdateRequest {
	final PAGE_ACTION pageAction;
	
	final FormMap parentFormMap;
	final FormMap childFormMap;
	
	final Class<? extends HippoBean> parentBeanClass;
	final Class<? extends HippoBean> childBeanClass;
	
	final String childUuid;
	
	final String parentBeanAbsolutePath;
	final String parentBeanNameSpace;
	final String parentBeanNodeName;
	
	public RepositoryUpdateRequest(	final PAGE_ACTION pageAction,final FormMap parentFormMap,final FormMap childFormMap,final Class<? extends HippoBean> parentBeanClass,final Class<? extends HippoBean> childBeanClass,
									final String childUuid,final String parentBeanAbsolutePath,final String parentBeanNameSpace,final String parentBeanNodeName) {
		this.pageAction = pageAction;
		this.parentFormMap = parentFormMap;
		this.childFormMap = childFormMap;
		
		this.parentBeanClass = parentBeanClass;
		this.childBeanClass  = childBeanClass;
		
		this.childUuid = childUuid;
		
		this.parentBeanAbsolutePath = parentBeanAbsolutePath;
		this.parentBeanNameSpace = parentBeanNameSpace;
		this.parentBeanNodeName = parentBeanNodeName;
	}

	public String getParentBeanNodeName() {
		return parentBeanNodeName;
	}

	public String getChildUuid() {
		return childUuid;
	}


	public PAGE_ACTION getPageAction() {
		return pageAction;
	}

	public FormMap getParentFormMap() {
		return parentFormMap;
	}

	public FormMap getChildFormMap() {
		return childFormMap;
	}

	public final Class<? extends HippoBean> getParentBeanClass() {
		return parentBeanClass;
	}

	public final Class<? extends HippoBean> getChildBeanClass() {
		return childBeanClass;
	}

	public String getParentBeanAbsolutePath() {
		return parentBeanAbsolutePath;
	}

	public String getParentBeanNameSpace() {
		return parentBeanNameSpace;
	}
	
}
