package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.IncomeFromFirmsDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateSchBPADocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateSchBPADocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		
			try {
				if (response == null) response = new HippoBeanValidationResponse();
				IncomeFromFirmsDocument incFromFirmsDoc = (IncomeFromFirmsDocument) mapOfBeans.get(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase());
				MemberPersonalInformation memberPersonalInfo = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
				String selectedPackage = memberPersonalInfo.getFlexField("flex_string_ITRForm", "");
				if(selectedPackage.equals("ITR3")){
				if(incFromFirmsDoc == null){
					HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.incFromFirmsDoc.empty.xml_download");
					response.addError(hippoBeanValidationError);
				}
				if (incFromFirmsDoc != null) {
					List<IncomeFromFirmsDetail> incFromFirmsDetails =  incFromFirmsDoc.getIncFromFirmsDetailList();
					if(incFromFirmsDetails == null ){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.incFromFirmsDoc.empty.xml_download");
						response.addError(hippoBeanValidationError);
					}
				}
				}
		}catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}

	}
