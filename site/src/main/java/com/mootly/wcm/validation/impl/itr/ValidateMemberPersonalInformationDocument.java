package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.components.accounting.InvoicePayment;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.VerificationStatus;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateMemberPersonalInformationDocument extends ValidateITRDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateMemberPersonalInformationDocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			MemberPersonalInformation memberPersonalInfo = getTheBean(mapOfBeans, MemberPersonalInformation.class); //(MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (memberPersonalInfo == null || memberPersonalInfo.getDitVerificationStatus() == null || memberPersonalInfo.getDitVerificationStatus() != VerificationStatus.VERIFIED) {
				response.addRestrictedAction(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY);
				response.addRestrictedAction(PAGE_ACTION.DOWNLOAD_ITR_XML);
				response.addRestrictedAction(PAGE_ACTION.EMAIL_ITR_XML_AND_SUMMARY);
				response.addRestrictedAction(PAGE_ACTION.SYNC_TDS_FROM_DIT);
				response.addRestrictedAction(PAGE_ACTION.EFILE);
				response.addRestrictedAction(PAGE_ACTION.DOWNLOAD_ITR_SUMMARY);
				response.addRestrictedAction(PAGE_ACTION.RETRIEVE_ITRV_BY_ACKNO);
				
				
				response.addRestrictedComponent(InvoicePayment.class);
				
				
			}
		}
		catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
	
}
