package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidationAdvanceTaxDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidationAdvanceTaxDocument.class);
	ITRValidationChecks iTRValidationChecks;

	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			AdvanceTaxDocument advanceTaxDocument = (AdvanceTaxDocument) mapOfBeans.get(AdvanceTaxDocument.class.getSimpleName().toLowerCase());
			if (advanceTaxDocument != null) {
				List<AdvanceTaxDetail> advanceTaxDetails =  advanceTaxDocument.getAdvanceTaxDetailList();
				if ( advanceTaxDetails != null && advanceTaxDetails.size() > 0) {
					for (AdvanceTaxDetail advanceTaxDetail:advanceTaxDetails) {
						if ( advanceTaxDetail.getP_BSR() ==  null || "".equals(advanceTaxDetail.getP_BSR()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.bsrCode");
							response.addError(hippoBeanValidationError);
						}
						if ( advanceTaxDetail.getDateStr() ==  null || "".equals(advanceTaxDetail.getDateStr()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.date");
							response.addError(hippoBeanValidationError);
						}
						if ( advanceTaxDetail.getP_Serial() ==  null || "".equals(advanceTaxDetail.getP_Serial()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.serialNo.");
							response.addError(hippoBeanValidationError);
						}
						if ( advanceTaxDetail.getP_Amount() ==  null || "".equals(advanceTaxDetail.getP_Amount()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.advanceTax.empty.amount.");
							response.addError(hippoBeanValidationError);
						}
						
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
