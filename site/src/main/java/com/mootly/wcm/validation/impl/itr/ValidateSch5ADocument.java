package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScheduleFiveADocument;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateSch5ADocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateSch5ADocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			ScheduleFiveADocument fiveAdocument = (ScheduleFiveADocument) mapOfBeans.get(ScheduleFiveADocument.class.getSimpleName().toLowerCase());
			MemberPersonalInformation memberPersonalInfo = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			String selectedPackage = memberPersonalInfo.getFlexField("flex_string_ITRForm", "");
			if(!selectedPackage.equals("ITR1")){
			if (fiveAdocument != null) {
				
				if(!memberPersonalInfo.getPortugesecivil().isEmpty() && memberPersonalInfo.getPortugesecivil().equals("Y")){
					if(fiveAdocument.getName_Spouse().isEmpty()){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.fiveA.empty.name_Spouse");
						response.addError(hippoBeanValidationError);
					}
					if(fiveAdocument.getPan_Spouse().isEmpty()){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.fiveA.empty.pan_Spouse");
						response.addError(hippoBeanValidationError);
					}
				}
			}
				
			}
			
		}catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
	
}
