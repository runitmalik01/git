package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidatePensionDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidatePensionDocument.class);
	

	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) mapOfBeans.get(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
			if (salaryIncomeDocument != null) {
				List<SalaryIncomeDetail> salaryIncomeDetails =  salaryIncomeDocument.getSalaryIncomeDetailList();
				if ( salaryIncomeDetails != null && salaryIncomeDetails.size() > 0) {
					for (SalaryIncomeDetail salaryIncomeDetail:salaryIncomeDetails) {
						if ( salaryIncomeDetail.getEmploye_category() ==  null || "".equals(salaryIncomeDetail.getEmploye_category()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.employeeCategory");
							response.addError(hippoBeanValidationError);
						}
						if ( salaryIncomeDetail.getName_employer() ==  null || "".equals(salaryIncomeDetail.getName_employer()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.employerName");
							response.addError(hippoBeanValidationError);
						}
						if ( salaryIncomeDetail.getName_employee() ==  null || "".equals(salaryIncomeDetail.getName_employee()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.employeeName");
							response.addError(hippoBeanValidationError);
						}
					
						if ( salaryIncomeDetail.getPan_employee() ==  null || "".equals(salaryIncomeDetail.getPan_employee())) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.employeePan");
							response.addError(hippoBeanValidationError);
						}
						
						if ( salaryIncomeDetail.getAddress()==  null || "".equals(salaryIncomeDetail.getAddress())) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.address");
							response.addError(hippoBeanValidationError);
						}
						if ( salaryIncomeDetail.getCity() ==  null || "".equals(salaryIncomeDetail.getCity())) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.city");
							response.addError(hippoBeanValidationError);
						}
						if ( salaryIncomeDetail.getState() ==  null || "".equals(salaryIncomeDetail.getState())) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.state");
							response.addError(hippoBeanValidationError);
						}
						if ( salaryIncomeDetail.getPin() ==  null || "".equals(salaryIncomeDetail.getPin())) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.pin");
							response.addError(hippoBeanValidationError);
						}

						if ( salaryIncomeDetail.getTdsPension() !=  null && salaryIncomeDetail.getTan_employer() == null) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.pension.empty.tan_deductor");
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
