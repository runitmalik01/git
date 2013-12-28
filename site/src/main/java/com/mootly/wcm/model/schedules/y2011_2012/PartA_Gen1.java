package com.mootly.wcm.model.schedules.y2011_2012;

import in.gov.incometaxindiaefiling.y2011_2012.Address;
import in.gov.incometaxindiaefiling.y2011_2012.Address.Phone;
import in.gov.incometaxindiaefiling.y2011_2012.AssesseeName;
import in.gov.incometaxindiaefiling.y2011_2012.FilingStatus;
import in.gov.incometaxindiaefiling.y2011_2012.ITR;
import in.gov.incometaxindiaefiling.y2011_2012.PartAGEN1;
import in.gov.incometaxindiaefiling.y2011_2012.PersonalInfo;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class PartA_Gen1 {
	MemberPersonalInformation document = null;

	public PartA_Gen1(MemberPersonalInformation document) {
		this.document = document;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public PartAGEN1 getPartAGEN1(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PartAGEN1 partAGEN1 = new PartAGEN1();
		PersonalInfo personalInfo = new PersonalInfo();
		AssesseeName assesseeName = new AssesseeName();
		Address address= new Address();
		FilingStatus filingstatus = new FilingStatus();

		assesseeName.setFirstName(document.getFirstName().toUpperCase());
		assesseeName.setSurNameOrOrgName(document.getLastName().toUpperCase());
		assesseeName.setMiddleName(document.getMiddleName().toUpperCase());
		personalInfo.setAssesseeName(assesseeName);
		personalInfo.setPAN(document.getPAN().toUpperCase());
		address.setResidenceNo(document.getFlatDoorBuilding().toUpperCase());
		address.setRoadOrStreet(document.getRoadStreet().toUpperCase());
		address.setLocalityOrArea(document.getAreaLocality().toUpperCase());
		address.setCityOrTownOrDistrict(document.getTownCityDistrict().toUpperCase());
		address.setStateCode(document.getState().toUpperCase());
		//address.setCountryCode(document.getCountry().toUpperCase());
		address.setPinCode(indianCurrencyHelper.bigIntegerRoundStr(document.getPinCode()));
		if(!(document.getStdCode().isEmpty()) && !(document.getPhone().isEmpty())){
			Phone phone = new Phone();
			phone.setSTDcode(indianCurrencyHelper.bigIntegerRoundStr(document.getStdCode()));
			phone.setPhoneNo(indianCurrencyHelper.bigIntegerRoundStr(document.getPhone()));
			address.setPhone(phone);
		}
		address.setMobileNo(indianCurrencyHelper.bigIntegerRoundStr(document.getMobile()));
		//address.setMobileNoSec(indianCurrencyHelper.bigIntegerRoundStr(document.getMobile1()));
		address.setEmailAddress(document.getEmail());
		personalInfo.setAddress(address);
		personalInfo.setDOB(indianCurrencyHelper.gregorianCalendar(document.getDOB()));
		if(document.getEmploye_category()!=null){
			personalInfo.setEmployerCategory(document.getEmploye_category());
		}

		personalInfo.setGender(document.getSex());
		personalInfo.setStatus(document.getFilingStatus());
		partAGEN1.setPersonalInfo(personalInfo);

		if(document.getWard_circle()!=null){
			filingstatus.setDesigOfficerWardorCircle(document.getWard_circle());
		}
		filingstatus.setReturnFileSec(Long.parseLong(document.getReturnSection()));
		filingstatus.setReturnType(document.getReturnType());
		filingstatus.setResidentialStatus(document.getResidentCategory());
		//filingstatus.setPortugeseCC5A(document.getPortugesecivil());
		//Commented because calculation is not completed
		/*
		if (BalTaxPayable.compareTo(BigInteger.ZERO) > 0){
			filingstatus.setTaxStatus("TP");
		}else
			if (BalTaxPayable.compareTo(BigInteger.ZERO) < 0){
				filingstatus.setTaxStatus("TR");
			}else
				filingstatus.setTaxStatus("NT");
       */
		//filingstatus.setPortugeseCC5A(memberPersonalInformation.getPortugesecivil());

		if (document.getReturnType().equals("R")) {
			filingstatus.setAckNoOriginalReturn(document.getOriginalAckNo());
			filingstatus.setOrigRetFiledDate(indianCurrencyHelper.gregorianCalendar(document.getOriginalAckDate()));

			if(document.getDefective().equals("Y")){
				filingstatus.setNoticeNo(document.getNoticeNo());
				filingstatus.setNoticeDate(indianCurrencyHelper.gregorianCalendar(document.getNoticeDate()));
				filingstatus.setReceiptNo(document.getReceiptNo());
			}
		}

		partAGEN1.setFilingStatus(filingstatus);
		return partAGEN1;

	}
}
