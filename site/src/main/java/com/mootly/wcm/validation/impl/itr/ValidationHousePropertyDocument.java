package com.mootly.wcm.validation.impl.itr;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.validation.HippoBeanValidationError;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;

public class ValidationHousePropertyDocument implements HippoBeanValidator{
	Logger logger = LoggerFactory.getLogger(ValidationHousePropertyDocument.class);
	ITRValidationChecks iTRValidationChecks;

	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		// TODO Auto-generated method stub
		//
		try {
			if (response == null) response = new HippoBeanValidationResponse();
			HouseProperty houseProperty = (HouseProperty) mapOfBeans.get(HouseProperty.class.getSimpleName().toLowerCase());
			MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
			String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
			int checkForSelfOccupiedProp = 0 ;
			if (houseProperty != null) {
				List<HouseIncomeDetail> houseIncomeDetails =  houseProperty.getHouseIncomeDetailList();
				if(itrSelection.equals("ITR1")){
					if(houseIncomeDetails.size()>1){
						HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.singleChild");
						response.addError(hippoBeanValidationError);
					}
				}
				if ( houseIncomeDetails != null && houseIncomeDetails.size() > 0) {
					for (HouseIncomeDetail houseIncomeDetail:houseIncomeDetails) {
						if ( houseIncomeDetail.getAddress() ==  null || "".equals(houseIncomeDetail.getAddress()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.address");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getCity() ==  null || "".equals(houseIncomeDetail.getCity()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.city");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getStates() ==  null || "".equals(houseIncomeDetail.getStates()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.states");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getPin() ==  null || "".equals(houseIncomeDetail.getPin()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.pin");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getLetOut() ==  null || "".equals(houseIncomeDetail.getLetOut()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.letOut");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getCoowned() ==  null || "".equals(houseIncomeDetail.getCoowned()) ) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.empty.coowned");
							response.addError(hippoBeanValidationError);
						}
						if ( houseIncomeDetail.getProperty_share() !=  null && Integer.parseInt(houseIncomeDetail.getProperty_share()) > 100) {
							HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.maxLength.property_share");
							response.addError(hippoBeanValidationError);
						}
						if(houseIncomeDetail.getLetOut() != null && houseIncomeDetail.getLetOut().equals("S")){
							checkForSelfOccupiedProp = checkForSelfOccupiedProp + 1;
						}
					}
				}
				if(checkForSelfOccupiedProp > 1){
					HippoBeanValidationError hippoBeanValidationError = new HippoBeanValidationError("err.houseincome.maxLength.selfOccupiedProperty");
					response.addError(hippoBeanValidationError);
				}
			}

		}catch (Exception ex) {
			logger.warn("WARN",ex);
		}
		return false;
	}
}
