package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;
import com.mootly.wcm.validation.HippoBeanValidatorChain;

public class ITRValidatorChain implements HippoBeanValidatorChain {
	
	final List<HippoBeanValidator> listOfHippoBeanValidator;
	
	public ITRValidatorChain (List<HippoBeanValidator> listOfHippoBeanValidator) {
		this.listOfHippoBeanValidator = listOfHippoBeanValidator;
	}

	@Override
	public void setValidators(List<HippoBeanValidator> listOfHippoBeanValidator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HippoBeanValidator> getOfValidators() {
		// TODO Auto-generated method stub
		return listOfHippoBeanValidator;
	}

	@Override
	public HippoBeanValidationResponse execute(FinancialYear financialYear,ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans, Map<String,Object> additionalData,Annotation[] annotations) {
		// TODO Auto-generated method stub
		if (listOfHippoBeanValidator == null && listOfHippoBeanValidator.size() == 0) return null;
		HippoBeanValidationResponse validationResponse = new HippoBeanValidationResponse();
		for (HippoBeanValidator aValidatorBean:listOfHippoBeanValidator) {
			aValidatorBean.validate(financialYear,pageAction, mapOfBeans,additionalData,annotations, validationResponse);	
			if (!validationResponse.getHasErrors()) {
				break;
			}			
		}	
		return validationResponse;
	}	
}
