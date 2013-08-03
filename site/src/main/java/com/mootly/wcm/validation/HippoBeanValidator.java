package com.mootly.wcm.validation;

import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

public interface HippoBeanValidator {
	
	boolean validate(Map<String,HippoBean> mapOfBeans,HippoBeanValidationResponse response);
	
}
