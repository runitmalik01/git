package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidationSelfAssessmentDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidationSelfAssessmentDocument.class);


	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			SelfAssesmetTaxDocument selfAssesmetTaxDocument = (SelfAssesmetTaxDocument) mapOfBeans.get(SelfAssesmetTaxDocument.class.getSimpleName().toLowerCase());
			if (selfAssesmetTaxDocument != null) {
				List<SelfAssesmentTaxDetail> selfAssesmentTaxDetails =  selfAssesmetTaxDocument.getSelfAssesmentDetailList();
				if ( selfAssesmentTaxDetails != null && selfAssesmentTaxDetails.size() > 0) {
					for (SelfAssesmentTaxDetail selfAssesmentTaxDetail:selfAssesmentTaxDetails) {
						if ( selfAssesmentTaxDetail.getP_BSR() ==  null || "".equals(selfAssesmentTaxDetail.getP_BSR()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.bsrCode");
							response.addError(hippoBeanValidationError);
						}
						if ( selfAssesmentTaxDetail.getDateStr() ==  null || "".equals(selfAssesmentTaxDetail.getDateStr()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.date");
							response.addError(hippoBeanValidationError);
						}
						if ( selfAssesmentTaxDetail.getP_Serial() ==  null || "".equals(selfAssesmentTaxDetail.getP_Serial()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.serialNo.");
							response.addError(hippoBeanValidationError);
						}
						if ( selfAssesmentTaxDetail.getP_Amount() ==  null || "".equals(selfAssesmentTaxDetail.getP_Amount()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.amount.");
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
