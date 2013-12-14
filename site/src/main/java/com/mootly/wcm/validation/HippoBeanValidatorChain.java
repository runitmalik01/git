package com.mootly.wcm.validation;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;

public interface HippoBeanValidatorChain {
	
	
	
	void setValidators(List<HippoBeanValidator> listOfHippoBeanValidator);
	List<HippoBeanValidator> getOfValidators();
	
	HippoBeanValidationResponse execute(FinancialYear financialYear,ITReturnScreen.PAGE_ACTION pageAction,  Map<String,HippoBean> mapOfBeans, Map<String,Object> additionalData,Annotation[] annotations);
}
