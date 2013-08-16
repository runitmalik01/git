package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.Address;
import in.gov.incometaxindiaefiling.y2012_2013.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.AssesseeRep;
import in.gov.incometaxindiaefiling.y2012_2013.FilingStatus;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartAGEN1;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTTI;
import in.gov.incometaxindiaefiling.y2012_2013.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.Address.Phone;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class PartA_Gen1 {
	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	HouseProperty housePropertyDocument = null;
	OtherSourcesDocument otherSourcesDocument = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;
	TaxReliefDocument taxReliefDocument = null;
	AdvanceTaxDocument advanceTaxDocument = null;
	SelfAssesmetTaxDocument selfAssesmetTaxDocument = null;
	TdsFromothersDocument tdsFromothersDocument = null;

	public PartA_Gen1(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation,
			TaxReliefDocument taxReliefDocument, AdvanceTaxDocument advanceTaxDocument, SelfAssesmetTaxDocument selfAssesmetTaxDocument,
			TdsFromothersDocument tdsFromothersDocument) {
		this.memberPersonalInformation = memberPersonalInformation;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public PartAGEN1 getPartAGEN1(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PartAGEN1 partAGEN1 = new PartAGEN1();
		PersonalInfo personalInfo = new PersonalInfo();
		AssesseeName assesseeName = new AssesseeName();
		Address address= new Address();
		FilingStatus filingstatus = new FilingStatus();

		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, housePropertyDocument, otherSourcesDocument, deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument, tdsFromothersDocument );
		PartBTTI partBTTI = partB_TTI.getPartBTTI(itr, financialYear, inputBeans);

		assesseeName.setFirstName(memberPersonalInformation.getFirstName().toUpperCase());
		assesseeName.setSurNameOrOrgName(memberPersonalInformation.getLastName().toUpperCase());
		assesseeName.setMiddleName(memberPersonalInformation.getMiddleName().toUpperCase());
		personalInfo.setAssesseeName(assesseeName);
		personalInfo.setPAN(memberPersonalInformation.getPAN().toUpperCase());
		address.setResidenceNo(memberPersonalInformation.getFlatDoorBuilding().toUpperCase());
		address.setRoadOrStreet(memberPersonalInformation.getRoadStreet().toUpperCase());
		address.setLocalityOrArea(memberPersonalInformation.getAreaLocality().toUpperCase());
		address.setCityOrTownOrDistrict(memberPersonalInformation.getTownCityDistrict().toUpperCase());
		address.setStateCode(memberPersonalInformation.getState().toUpperCase());
		address.setCountryCode(memberPersonalInformation.getCountry().toUpperCase());
		address.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPinCode()));
		if(!(memberPersonalInformation.getStdCode().isEmpty()) && !(memberPersonalInformation.getPhone().isEmpty())){
			Phone phone = new Phone();
			phone.setSTDcode(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getStdCode()));
			phone.setPhoneNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getPhone()));
			address.setPhone(phone);
		}
		address.setMobileNo(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getMobile()));
		address.setMobileNoSec(indianCurrencyHelper.bigIntegerRoundStr(memberPersonalInformation.getMobile1()));
		address.setEmailAddress(memberPersonalInformation.getEmail());
		personalInfo.setAddress(address);
		personalInfo.setDOB(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getDOB()));
		if(memberPersonalInformation.getEmploye_category()!=null){
			personalInfo.setEmployerCategory(memberPersonalInformation.getEmploye_category());
		}

		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());
		partAGEN1.setPersonalInfo(personalInfo);

		if(memberPersonalInformation.getWard_circle()!=null){
			filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getWard_circle());
		}
		filingstatus.setReturnFileSec(Long.parseLong(memberPersonalInformation.getReturnSection()));
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setPortugeseCC5A(memberPersonalInformation.getPortugesecivil());

        BigInteger balTaxPayable = partBTTI.getTaxPaid().getBalTaxPayable();

		if (balTaxPayable.compareTo(BigInteger.ZERO) > 0){
			filingstatus.setTaxStatus("TP");
		}else
			if (partBTTI.getRefund().getRefundDue().compareTo(BigInteger.ZERO) > 0){
				filingstatus.setTaxStatus("TR");
			}else
				filingstatus.setTaxStatus("NT");

		if (memberPersonalInformation.getReturnType().equals("R")) {
			filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
			filingstatus.setOrigRetFiledDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getOriginalAckDate()));

			if(memberPersonalInformation.getDefective().equals("Y")){
				filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
				filingstatus.setNoticeDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getNoticeDate()));
				filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());
			}
		}
		filingstatus.setAsseseeRepFlg(memberPersonalInformation.getIsRepresentative());
		if(memberPersonalInformation.getIsRepresentative().equals("Y")){
			AssesseeRep assesseeRep = new AssesseeRep();
			assesseeRep.setRepName(memberPersonalInformation.getName_Representative());
			assesseeRep.setRepAddress(memberPersonalInformation.getAddress_Representative());
			assesseeRep.setRepPAN(memberPersonalInformation.getPan_Representative());
			filingstatus.setAssesseeRep(assesseeRep);
		}


		partAGEN1.setFilingStatus(filingstatus);
		return partAGEN1;

	}
}
