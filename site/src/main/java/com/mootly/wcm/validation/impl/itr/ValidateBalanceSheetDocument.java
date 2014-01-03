package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.BalanceSheetDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateBalanceSheetDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateBalanceSheetDocument.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			BalanceSheetDocument balanceSheetDoc = (BalanceSheetDocument) mapOfBeans.get(BalanceSheetDocument.class.getSimpleName().toLowerCase());
			MemberPersonalInformation memberPersonalInfo = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			String selectedPackage = memberPersonalInfo.getFlexField("flex_string_ITRForm", "");
			
			if(selectedPackage.equals("ITR4")){
				if (balanceSheetDoc != null) {
					
					if(!balanceSheetDoc.getRegularAccOrNoCase().isEmpty() && balanceSheetDoc.getRegularAccOrNoCase().equals("N")){
						if(balanceSheetDoc.getTotalSundryDebtor() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.totalSundryDebtor");
							response.addError(hippoBeanValidationError);
						}
						if(balanceSheetDoc.getTotalSundryCreditor() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.totalSundryCreditor");
							response.addError(hippoBeanValidationError);
						}
						if(balanceSheetDoc.getTotalStockTrade() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.totalStockTrade");
							response.addError(hippoBeanValidationError);
						}
						if(balanceSheetDoc.getCashBalance() == null){
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.balanceSheetDoc.empty.cashBalance");
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
