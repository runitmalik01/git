package com.mootly.wcm.validation.impl.itr;

import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ITRForm;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidationWarning;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidateSectionAndDueDate implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidateSectionAndDueDate.class);
	
	@Override
	public boolean validate(Map<String,HippoBean> mapOfBeans, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			if (memberPersonalInformation != null) {
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
			}
			
		}catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
	
}
