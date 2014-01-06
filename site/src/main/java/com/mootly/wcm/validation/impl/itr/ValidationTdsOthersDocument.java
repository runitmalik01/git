package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidationTdsOthersDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidationTdsOthersDocument.class);
	

	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			TdsFromothersDocument tdsFromothersDocument = (TdsFromothersDocument) mapOfBeans.get(TdsFromothersDocument.class.getSimpleName().toLowerCase());
			if (tdsFromothersDocument != null) {
				List<TdsOthersDetail> tdsOthersDetails =  tdsFromothersDocument.getTdsSalaryDetailList();
				if ( tdsOthersDetails != null && tdsOthersDetails.size() > 0) {
					for (TdsOthersDetail tdsOthersDetail:tdsOthersDetails) {
						if ( tdsOthersDetail.getTan_Deductor() ==  null || "".equals(tdsOthersDetail.getTan_Deductor()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.TAN");
							response.addError(hippoBeanValidationError);
						}
						if ( tdsOthersDetail.getName_Deductor() ==  null || "".equals(tdsOthersDetail.getName_Deductor()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.name");
							response.addError(hippoBeanValidationError);
						}
						if ( tdsOthersDetail.getTds_Certificate() ==  null || "".equals(tdsOthersDetail.getTds_Certificate()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.tdsCertificate");
							response.addError(hippoBeanValidationError);
						}
						if ( tdsOthersDetail.getFinancial_Year() ==  null || "".equals(tdsOthersDetail.getFinancial_Year()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.financialYear");
							response.addError(hippoBeanValidationError);
						}
						if ( tdsOthersDetail.getTotal_TaxDeductor() ==  null) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.taxDeductor");
							response.addError(hippoBeanValidationError);
						}
						if ( tdsOthersDetail.getP_Amount() ==  null) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.tdsOther.empty.amount");
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
