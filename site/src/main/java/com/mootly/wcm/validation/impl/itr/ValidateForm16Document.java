package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateForm16Document implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateForm16Document.class);
	
	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			FormSixteenDocument formSixteenDocument = (FormSixteenDocument) mapOfBeans.get(FormSixteenDocument.class.getSimpleName().toLowerCase());
			if (formSixteenDocument != null) {
				List<FormSixteenDetail> formSixteenDetails =  formSixteenDocument.getFormSixteenDetailList();
				if ( formSixteenDetails != null && formSixteenDetails.size() > 0) {
					for (FormSixteenDetail formSixteenDetail:formSixteenDetails) {
						if ( formSixteenDetail.getEmploye_category() ==  null || "".equals(formSixteenDetail.getEmploye_category()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.form16.empty.employeeCategory");
							response.addError(hippoBeanValidationError);
						}
					}
				}
				/*
				String stateCode = memberPersonalInformation.getState();
				ITRForm itrForm = memberPersonalInformation.getSelectedITRForm();
				FinancialYear currentFinancialYear = FinancialYear.getByDisplayName(memberPersonalInformation.getFinancialYear()); 
				boolean isPastDue = currentFinancialYear.isIncomeTaxPastDue(itrForm, stateCode);
				FilingSection filingSection =  memberPersonalInformation.getFilingSection();
				if (filingSection == FilingSection.BeforeDueDate_139_1 && isPastDue) {
					HippoBeanValidationWarning warning = new HippoBeanValidationWarning("warning.pastDue.section.before");
					warning.setMessageArgs(new String[]{FilingSection.BeforeDueDate_139_1.getDesc(),FilingSection.AfterDueDate_139_4.getDesc()});
					response.addWarning(warning);
				}
				else if (filingSection == FilingSection.AfterDueDate_139_4 && !isPastDue) {
					HippoBeanValidationWarning warning = new HippoBeanValidationWarning("warning.not.pastDue.section.after");
					warning.setMessageArgs(new String[]{FilingSection.AfterDueDate_139_4.getDesc(),FilingSection.BeforeDueDate_139_1.getDesc()});
					response.addWarning(warning);
				}
				*/
			}
			
		}catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
	
}
