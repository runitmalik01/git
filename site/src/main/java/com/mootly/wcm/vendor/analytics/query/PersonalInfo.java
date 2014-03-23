package com.mootly.wcm.vendor.analytics.query;

import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;

public interface PersonalInfo {
	Class<? extends HippoDocumentBean> getPrimaryBeanClass();
	Class<? extends HippoDocumentBean> getChildBeanClass();
	
	String[] reportingFields();
}
