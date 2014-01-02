package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateStartAppDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateStartAppDocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			MemberPersonalInformation memberPersonalInfo = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			String selectedPackage = memberPersonalInfo.getFlexField("flex_string_ITRForm", "");
			if(selectedPackage.equals("ITR2") || selectedPackage.equals("ITR3")|| selectedPackage.equals("ITR4") ){
			if (memberPersonalInfo != null) {
				
				if(!memberPersonalInfo.getIsRepresentative().isEmpty() && memberPersonalInfo.getIsRepresentative().equals("Y")){
					if(memberPersonalInfo.getName_Representative().isEmpty()){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.name_Representative");
						response.addError(hippoBeanValidationError);
					}
					if(memberPersonalInfo.getAddress_Representative().isEmpty()){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.address_Representative");
						response.addError(hippoBeanValidationError);
					}
					if(memberPersonalInfo.getPan_Representative().isEmpty()){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.pan_Representative");
						response.addError(hippoBeanValidationError);
					}
				}
			}
			}
			
			if(selectedPackage.equals("ITR4S")){
				if (memberPersonalInfo != null) {
					
					if(!memberPersonalInfo.getIsTaxPreparebyTRP().isEmpty() && memberPersonalInfo.getIsTaxPreparebyTRP().equals("Y")){
						if(memberPersonalInfo.getTrpname().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.trpname");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getTrpreimbursement() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.trpreimbursement");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getTrpnumber().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.trpnumber");
							response.addError(hippoBeanValidationError);
						}
					}
				}
				
			
			}
			if(selectedPackage.equals("ITR4")){
				if (memberPersonalInfo != null) {
					
					if(!memberPersonalInfo.getIsLiable_FurnishSec92E().isEmpty() && memberPersonalInfo.getIsLiable_FurnishSec92E().equals("Y")){
						if(memberPersonalInfo.getDate_FurnishAuditReportStr().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.date_FurnishAuditReport");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getName_AuditorSign_Report() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.name_AuditorSign_Report");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getMembershipNo_auditor().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.membershipNo_auditor");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getName_auditorFirm().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.name_auditorFirm");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getPan_Firm().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.pan_Firm");
							response.addError(hippoBeanValidationError);
						}
						if(memberPersonalInfo.getDate_AuditReportStr().isEmpty()){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.memberPersonalInfo.empty.date_AuditReportStr");
							response.addError(hippoBeanValidationError);
						}
						
					}
				}
				
			
			}
		}
		catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
	
}
