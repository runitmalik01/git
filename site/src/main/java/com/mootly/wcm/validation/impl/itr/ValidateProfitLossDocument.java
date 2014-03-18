package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateProfitLossDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateProfitLossDocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			ProfitAndLossDocument profitAndLossDoc = (ProfitAndLossDocument) mapOfBeans.get(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
			MemberPersonalInformation memberPersonalInfo = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			String selectedPackage = memberPersonalInfo.getFlexField("flex_string_ITRForm", "");
			
			if(selectedPackage.equals("ITR4")){
				if (profitAndLossDoc != null) {
					
					if(!profitAndLossDoc.getIsAccountMaintain().isEmpty() && profitAndLossDoc.getIsAccountMaintain().equals("N")){
						if(profitAndLossDoc.getGross_Recepients() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.gross_Recepients");
							response.addError(hippoBeanValidationError);
						}
						if(profitAndLossDoc.getGross_Profit() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.gross_Profit");
							response.addError(hippoBeanValidationError);
						}
						if(profitAndLossDoc.getExpenses_NoAccount() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.expenses_NoAccount");
							response.addError(hippoBeanValidationError);
						}
						if(profitAndLossDoc.getNet_Profit() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.net_Profit");
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
