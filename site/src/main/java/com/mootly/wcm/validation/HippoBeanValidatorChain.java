package com.mootly.wcm.validation;

import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

public interface HippoBeanValidatorChain {
	
	
	
	void setValidators(List<HippoBeanValidator> listOfHippoBeanValidator);
	List<HippoBeanValidator> getOfValidators();
	
	HippoBeanValidationResponse execute(Map<String,HippoBean> mapOfBeans);
}
