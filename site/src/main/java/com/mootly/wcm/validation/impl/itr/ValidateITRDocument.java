package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public abstract class ValidateITRDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateITRDocument.class);
	
	final public MemberPersonalInformation getMemberPersonalInformation(Map<String,HippoBean> mapOfBeans) {
		//return (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		return  getTheBean(mapOfBeans,MemberPersonalInformation.class);
	}
	
	final <T extends HippoBean>  T getTheBean (Map<String,HippoBean> mapOfBeans,Class<? extends T> inClass) {
		if (mapOfBeans != null && mapOfBeans.containsKey(inClass.getSimpleName().toLowerCase()))  {
			return (T) mapOfBeans.get(inClass.getSimpleName().toLowerCase());
		}
		else {
			return null;
		}
	}
	
	@Override
	public abstract boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response);
	
}
