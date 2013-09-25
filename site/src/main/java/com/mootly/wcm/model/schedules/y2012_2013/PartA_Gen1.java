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
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.DetailOfTrustDocument;
import com.mootly.wcm.beans.FinancialInterestDocument;
import com.mootly.wcm.beans.ForeignBankAccountDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.ImmovablePropertyDocument;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureInvestmentDocument;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleAMTCDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.SigningAuthorityAccountsDocument;
import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.TcsDocument;
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
	ScheduleSIDocument scheduleSIDocument = null;
	CapitalAssetDocument capitalAssetDocument = null;
	ImmovablePropertyDocument immovablePropertyDocument = null;
	NatureInvestmentDocument natureInvestmentDocument= null;
	SigningAuthorityAccountsDocument signingAuthorityAccountsDocument = null;
	DetailOfTrustDocument detailOfTrustDocument = null;
	ForeignBankAccountDocument foreignBankAccountDocument = null;
	FinancialInterestDocument financialInterestDocument = null;
	TcsDocument tcsDocument = null;
	IncBusinessProfessionDoc incBusinessProfessionDoc = null;
	ProfitAndLossDocument profitAndLossDocument = null;
	OtherInformationDocument otherInformationDocument = null;
	ScheduleDPMDocument scheduleDPMDocument = null;
	ScheduleDOADocument scheduleDOADocument = null;
	ScheduleESRDocument scheduleESRDocument = null;
	DeductionSchedTenADocumemt deductionSchedTenADocumemt = null;
	ScheduleAMTCDocument scheduleAMTCDocument = null;


	public PartA_Gen1(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation,
			TaxReliefDocument taxReliefDocument, AdvanceTaxDocument advanceTaxDocument, SelfAssesmetTaxDocument selfAssesmetTaxDocument,
			TdsFromothersDocument tdsFromothersDocument, ScheduleSIDocument scheduleSIDocument, CapitalAssetDocument capitalAssetDocument,
			ImmovablePropertyDocument immovablePropertyDocument, NatureInvestmentDocument natureInvestmentDocument, SigningAuthorityAccountsDocument signingAuthorityAccountsDocument,
			DetailOfTrustDocument detailOfTrustDocument, ForeignBankAccountDocument foreignBankAccountDocument, FinancialInterestDocument financialInterestDocument, TcsDocument tcsDocument,
			IncBusinessProfessionDoc incBusinessProfessionDoc,ProfitAndLossDocument profitAndLossDocument, OtherInformationDocument otherInformationDocument, ScheduleDPMDocument scheduleDPMDocument,
			ScheduleDOADocument scheduleDOADocument, ScheduleESRDocument scheduleESRDocument, DeductionSchedTenADocumemt deductionSchedTenADocumemt,ScheduleAMTCDocument scheduleAMTCDocument) {
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
		this.housePropertyDocument = housePropertyDocument;
		this.otherSourcesDocument = otherSourcesDocument;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
		this.taxReliefDocument = taxReliefDocument;
		this.advanceTaxDocument = advanceTaxDocument;
		this.selfAssesmetTaxDocument = selfAssesmetTaxDocument;
		this.tdsFromothersDocument = tdsFromothersDocument;
		this.scheduleSIDocument = scheduleSIDocument;
		this.capitalAssetDocument = capitalAssetDocument;
		this.immovablePropertyDocument = immovablePropertyDocument;
		this.natureInvestmentDocument = natureInvestmentDocument;
		this.signingAuthorityAccountsDocument = signingAuthorityAccountsDocument;
		this.detailOfTrustDocument = detailOfTrustDocument;
		this.foreignBankAccountDocument = foreignBankAccountDocument;
		this.financialInterestDocument = financialInterestDocument;
		this.tcsDocument = tcsDocument;
		this.incBusinessProfessionDoc = incBusinessProfessionDoc;
		this.profitAndLossDocument = profitAndLossDocument;
		this.otherInformationDocument = otherInformationDocument;
		this.scheduleDPMDocument = scheduleDPMDocument;
		this.scheduleDOADocument = scheduleDOADocument;
		this.scheduleESRDocument = scheduleESRDocument;
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
		this.scheduleAMTCDocument = scheduleAMTCDocument;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public PartAGEN1 getPartAGEN1(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){

		PartAGEN1 partAGEN1 = new PartAGEN1();
		PartB_TTI partB_TTI = new PartB_TTI(formSixteenDocument, salaryIncomeDocument, housePropertyDocument, otherSourcesDocument,
				deductionDocument, memberPersonalInformation, taxReliefDocument, advanceTaxDocument, selfAssesmetTaxDocument,
				tdsFromothersDocument, scheduleSIDocument, capitalAssetDocument, immovablePropertyDocument, natureInvestmentDocument,
				signingAuthorityAccountsDocument, detailOfTrustDocument, foreignBankAccountDocument, financialInterestDocument, tcsDocument,
				incBusinessProfessionDoc,profitAndLossDocument, otherInformationDocument, scheduleDPMDocument, scheduleDOADocument,
				scheduleESRDocument, deductionSchedTenADocumemt,scheduleAMTCDocument);
		PartBTTI partBTTI = partB_TTI.getPartBTTI(itr, financialYear, inputBeans);

		BigInteger taxPaybale = new BigInteger("0");
		taxPaybale = partBTTI.getTaxPaid().getBalTaxPayable();
		BigInteger taxRefundable = new BigInteger("0");
		taxRefundable = partBTTI.getRefund().getRefundDue();

		PersonalInfo personalInfo = getPersonalInfo(itr);
		partAGEN1.setPersonalInfo(personalInfo);

		FilingStatus filingStatus = getFilingStatus(itr, taxPaybale, taxRefundable);
		partAGEN1.setFilingStatus(filingStatus);

		return partAGEN1;

	}

	public PersonalInfo getPersonalInfo(ITR itr){

		PersonalInfo personalInfo = new PersonalInfo();
		AssesseeName assesseeName = new AssesseeName();
		Address address= new Address();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		if(!(memberPersonalInformation.getFirstName().isEmpty()))
			assesseeName.setFirstName(memberPersonalInformation.getFirstName().toUpperCase());
		assesseeName.setSurNameOrOrgName(memberPersonalInformation.getLastName().toUpperCase());
		if(!(memberPersonalInformation.getMiddleName().isEmpty()))
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

		return personalInfo;
	}

	public FilingStatus getFilingStatus(ITR itr, BigInteger taxPaybale, BigInteger taxRefundable){

		FilingStatus filingstatus = new FilingStatus();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		if(!(memberPersonalInformation.getWard_circle().isEmpty())){
			filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getWard_circle());
		}
		filingstatus.setReturnFileSec(Long.parseLong(memberPersonalInformation.getReturnSection()));
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		filingstatus.setPortugeseCC5A(memberPersonalInformation.getPortugesecivil());

		if (taxPaybale.compareTo(BigInteger.ZERO) > 0){
			filingstatus.setTaxStatus("TP");
		}else
			if (taxRefundable.compareTo(BigInteger.ZERO) > 0){
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
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
		if(itrSelection.equals("ITR2") || itrSelection.equals("ITR4")){
			filingstatus.setAsseseeRepFlg(memberPersonalInformation.getIsRepresentative());
			if(memberPersonalInformation.getIsRepresentative().equals("Y")){
				AssesseeRep assesseeRep = new AssesseeRep();
				assesseeRep.setRepName(memberPersonalInformation.getName_Representative());
				assesseeRep.setRepAddress(memberPersonalInformation.getAddress_Representative());
				assesseeRep.setRepPAN(memberPersonalInformation.getPan_Representative());
				filingstatus.setAssesseeRep(assesseeRep);
			}
		}

		return filingstatus;
	}
}
