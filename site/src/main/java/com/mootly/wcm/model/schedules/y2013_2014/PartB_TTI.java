package com.mootly.wcm.model.schedules.y2013_2014;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.HashMap;
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
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
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
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.beans.compound.TaxReliefDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.services.ScreenCalculatorService;
import com.mootly.wcm.services.y2013_2014.XmlCalculation;

import in.gov.incometaxindiaefiling.y2013_2014.ComputationOfTaxLiability;
import in.gov.incometaxindiaefiling.y2013_2014.ComputationOfTaxLiability.TaxPayableOnDeemedTI;
import in.gov.incometaxindiaefiling.y2013_2014.IntrstPay;
import in.gov.incometaxindiaefiling.y2013_2014.Refund;
import in.gov.incometaxindiaefiling.y2013_2014.Refund.DepositToBankAccount;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleTR.TotTaxreliefClaimed;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ITR4STaxComputation;
import in.gov.incometaxindiaefiling.y2013_2014.ITRScheduleAMT;
import in.gov.incometaxindiaefiling.y2013_2014.ITRScheduleAMTC;
import in.gov.incometaxindiaefiling.y2013_2014.PartBTI;
import in.gov.incometaxindiaefiling.y2013_2014.PartBTTI;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleFA;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleSI;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleTR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2013_2014.TaxPaid;
import in.gov.incometaxindiaefiling.y2013_2014.TaxPayableOnTI;
import in.gov.incometaxindiaefiling.y2013_2014.TaxRelief;
import in.gov.incometaxindiaefiling.y2013_2014.TaxesPaid;

public class PartB_TTI {

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
	ScheduleSIDocument scheduleSIDocument= null;
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
	IncomeFromFirmsDocument incomeFromFirmsDocument = null;

	public PartB_TTI(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation,
			TaxReliefDocument taxReliefDocument, AdvanceTaxDocument advanceTaxDocument, SelfAssesmetTaxDocument selfAssesmetTaxDocument,
			TdsFromothersDocument tdsFromothersDocument, ScheduleSIDocument scheduleSIDocument, CapitalAssetDocument capitalAssetDocument,
			ImmovablePropertyDocument immovablePropertyDocument, NatureInvestmentDocument natureInvestmentDocument, SigningAuthorityAccountsDocument signingAuthorityAccountsDocument,
			DetailOfTrustDocument detailOfTrustDocument, ForeignBankAccountDocument foreignBankAccountDocument, FinancialInterestDocument financialInterestDocument, TcsDocument tcsDocument,
			IncBusinessProfessionDoc incBusinessProfessionDoc,ProfitAndLossDocument profitAndLossDocument, OtherInformationDocument otherInformationDocument, ScheduleDPMDocument scheduleDPMDocument,
			ScheduleDOADocument scheduleDOADocument, ScheduleESRDocument scheduleESRDocument, DeductionSchedTenADocumemt deductionSchedTenADocumemt,ScheduleAMTCDocument scheduleAMTCDocument,
			IncomeFromFirmsDocument incomeFromFirmsDocument ){
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
		this.incomeFromFirmsDocument = incomeFromFirmsDocument;


	}

	public PartBTTI getPartBTTI(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		PartBTTI partBTTI = new PartBTTI();
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");

		//getting PartB_TI required in the calculation of PartB_TTI
		PartB_TI partB_TI = new PartB_TI(formSixteenDocument, salaryIncomeDocument, housePropertyDocument, otherSourcesDocument, deductionDocument, memberPersonalInformation,
				scheduleSIDocument, capitalAssetDocument, incBusinessProfessionDoc, profitAndLossDocument, otherInformationDocument,
				scheduleDPMDocument, scheduleDOADocument, scheduleESRDocument, deductionSchedTenADocumemt, incomeFromFirmsDocument);
		PartBTI partBTI = partB_TI.getPartBTI(itr, financialYear, inputBeans);

		//getting Deduction Schedule required in the calculation of PARTB_TTI
		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument, memberPersonalInformation, otherSourcesDocument);
		ScheduleVIA scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans);

		Map<String,String[]> requestParameterMap = new HashMap<String, String[]>(); //not being used any where

		XmlCalculation xmlCalculation   = new XmlCalculation();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+xmlCalculation);

		long aggregateIncome = 0;
		aggregateIncome = partBTI.getAggregateIncome().longValue();
		if(aggregateIncome<=0)
			aggregateIncome =0;
		long totalIncome = partBTI.getTotalIncome().longValue();
		long incomeTaxSplRate = partBTI.getIncChargeTaxSplRate111A112().longValue();
		long totIncSubSplRate = totalIncome - incomeTaxSplRate;

		Map<String,Object> resultMap = xmlCalculation.taxCalc(financialYear, inputBeans, aggregateIncome);
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"+resultMap);
		Double slabRate = Double.parseDouble(resultMap.get("slabRate").toString());
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+slabRate);
		boolean hasTaxableInc = false;
		if(totIncSubSplRate > indianCurrencyHelper.longRound(slabRate)){
			hasTaxableInc = true;
		}
		double agricultureIncome = 0;
		if(otherSourcesDocument!=null){
			if(otherSourcesDocument.getAgriculture_income() > 5000){
				agricultureIncome = otherSourcesDocument.getAgriculture_income();
			}else
				agricultureIncome = 0;
		}
		ComputationOfTaxLiability computationOfTaxLiability = new ComputationOfTaxLiability();

		TaxPayableOnDeemedTI taxPayableOnDeemedTI = new TaxPayableOnDeemedTI();

		if(itrSelection.equals("ITR4")){

			//getting ScheduleAMT required in PARTB_TTI
			ITR_ScheduleAMT iTR_ScheduleAMT = new ITR_ScheduleAMT(deductionDocument, deductionSchedTenADocumemt);
			ITRScheduleAMT itrScheduleAMT = iTR_ScheduleAMT.getITItrScheduleAMT(itr, financialYear, inputBeans, scheduleVIA, partBTI);

			taxPayableOnDeemedTI.setTaxDeemedTISec115JC(itrScheduleAMT.getTaxPayableUnderSec115JC());
			taxPayableOnDeemedTI.setEducationCess((taxPayableOnDeemedTI.getTaxDeemedTISec115JC().multiply(new BigInteger("3"))).divide(new BigInteger("100")));
			taxPayableOnDeemedTI.setTotalTax(taxPayableOnDeemedTI.getTaxDeemedTISec115JC().add(taxPayableOnDeemedTI.getEducationCess()));
			computationOfTaxLiability.setTaxPayableOnDeemedTI(taxPayableOnDeemedTI);
		}else{
			taxPayableOnDeemedTI.setTaxDeemedTISec115JC(new BigInteger("0"));
			taxPayableOnDeemedTI.setEducationCess(new BigInteger("0"));
			taxPayableOnDeemedTI.setTotalTax(taxPayableOnDeemedTI.getTaxDeemedTISec115JC().add(taxPayableOnDeemedTI.getEducationCess()));
			computationOfTaxLiability.setTaxPayableOnDeemedTI(taxPayableOnDeemedTI);
		}
		TaxPayableOnTI taxPayableOnTI = new TaxPayableOnTI();
		taxPayableOnTI.setTaxAtNormalRatesOnAggrInc(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));

		ITRScheduleSI iTRScheduleSI = new ITRScheduleSI(scheduleSIDocument, capitalAssetDocument, otherSourcesDocument, formSixteenDocument, salaryIncomeDocument,
				housePropertyDocument, memberPersonalInformation);
		ScheduleSI scheduleSI = iTRScheduleSI.getScheduleSI(itr, financialYear);
		taxPayableOnTI.setTaxAtSpecialRates(scheduleSI.getTotSplRateIncTax());

		taxPayableOnTI.setTaxOnAggregateInc(new BigInteger("0"));//Don't know need to consult(i think this is for ITR4)
		if(agricultureIncome > 5000){
			if(hasTaxableInc){
				double salbRateAddAggInc = slabRate + agricultureIncome;
				Map<String,Object> resultMapForAggInc = xmlCalculation.taxCalc(financialYear, inputBeans, indianCurrencyHelper.longRound(salbRateAddAggInc));
				taxPayableOnTI.setRebateOnAgriInc(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapForAggInc.get("txtTax").toString())));
			}else
				taxPayableOnTI.setRebateOnAgriInc(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMap.get("txtTax").toString())));
		}else
			taxPayableOnTI.setRebateOnAgriInc(new BigInteger("0"));
		taxPayableOnTI.setTaxPayableOnTotInc((taxPayableOnTI.getTaxAtNormalRatesOnAggrInc().add(taxPayableOnTI.getTaxAtSpecialRates())).subtract(taxPayableOnTI.getRebateOnAgriInc()));
		computationOfTaxLiability.setTaxPayableOnTI(taxPayableOnTI);

		computationOfTaxLiability.setRebateUs88E(new BigInteger("0"));//Don't know need to consult
		computationOfTaxLiability.setBalTaxPayable(taxPayableOnTI.getTaxPayableOnTotInc().subtract(computationOfTaxLiability.getRebateUs88E()));
		computationOfTaxLiability.setSurchargeOnTaxPayable(new BigInteger("0"));
		computationOfTaxLiability.setEducationCess((taxPayableOnTI.getTaxPayableOnTotInc().multiply(new BigInteger("3"))).divide(new BigInteger("100")));
		computationOfTaxLiability.setGrossTaxLiability(taxPayableOnTI.getTaxPayableOnTotInc().add(computationOfTaxLiability.getEducationCess()));

		if(taxPayableOnDeemedTI.getTotalTax().longValue() >= computationOfTaxLiability.getGrossTaxLiability().longValue()){
			computationOfTaxLiability.setGrossTaxPayable(taxPayableOnDeemedTI.getTotalTax());
		}else{
			computationOfTaxLiability.setGrossTaxPayable(computationOfTaxLiability.getGrossTaxLiability());
		}

		if(computationOfTaxLiability.getGrossTaxLiability().longValue() > taxPayableOnDeemedTI.getTotalTax().longValue() && itrSelection.equals("ITR4")){
			ITR_ScheduleAMTC iTR_ScheduleAMTC = new ITR_ScheduleAMTC(scheduleAMTCDocument);
			ITRScheduleAMTC itrScheduleAMTC = iTR_ScheduleAMTC.getScheduleAMTC(itr, financialYear, inputBeans, taxPayableOnDeemedTI.getTotalTax(), computationOfTaxLiability.getGrossTaxLiability());
			computationOfTaxLiability.setCreditUS115JD(itrScheduleAMTC.getTaxSection115JD());
		}else
			computationOfTaxLiability.setCreditUS115JD(new BigInteger("0"));

		computationOfTaxLiability.setCreditUS115JD(new BigInteger("0"));
		computationOfTaxLiability.setTaxPayAfterCreditUs115JD(computationOfTaxLiability.getGrossTaxPayable().subtract(computationOfTaxLiability.getCreditUS115JD()));

		// Getting values of relief, Taxes, TDS
		BigInteger relief89 =new BigInteger ("0");
		BigInteger relief89Total =new BigInteger ("0");
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList() ;
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					if(formSixteenDetail.getRelief_2()!=null){
						relief89=indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getRelief_2());
						relief89Total=relief89Total.add(relief89);
					}
				}
			}
		}
		BigInteger relief90 = new BigInteger("0");
		BigInteger relief91 = new BigInteger("0");
		if(taxReliefDocument!=null){
			if(taxReliefDocument.getRebate9091() != null)
				relief90 = indianCurrencyHelper.bigIntegerRound(taxReliefDocument.getRebate9091());
			if(taxReliefDocument.getRebate90() != null)
				relief91 = indianCurrencyHelper.bigIntegerRound(taxReliefDocument.getRebate90());
		}

		TaxRelief taxRelief = new TaxRelief();
		taxRelief.setSection89(relief89Total);
		taxRelief.setSection90(relief90);
		taxRelief.setSection91(relief91);
		taxRelief.setTotTaxRelief(taxRelief.getSection89().add(taxRelief.getSection90()).add(taxRelief.getSection91()));
		computationOfTaxLiability.setTaxRelief(taxRelief);

		BigInteger netTaxLiability = new BigInteger("0");
		netTaxLiability = computationOfTaxLiability.getGrossTaxLiability().subtract(taxRelief.getTotTaxRelief());
		if(netTaxLiability.compareTo(BigInteger.ZERO) > 0){
			computationOfTaxLiability.setNetTaxLiability(netTaxLiability);
		}else
			computationOfTaxLiability.setNetTaxLiability(new BigInteger("0"));

		// Interest Calculation

		Map<String,Object> resultMapINTEREST = xmlCalculation.interestCalc(financialYear, inputBeans, computationOfTaxLiability.getNetTaxLiability());

		IntrstPay intrstPay = new IntrstPay();
		intrstPay.setIntrstPayUs234A(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intA").toString())));
		intrstPay.setIntrstPayUs234B(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intB").toString())));
		intrstPay.setIntrstPayUs234C(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("ic").toString())));
		intrstPay.setTotalIntrstPay(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapINTEREST.get("intt").toString())));
		computationOfTaxLiability.setIntrstPay(intrstPay);

		computationOfTaxLiability.setAggregateTaxInterestLiability(computationOfTaxLiability.getNetTaxLiability().add(intrstPay.getTotalIntrstPay()));
		partBTTI.setComputationOfTaxLiability(computationOfTaxLiability);

		TaxPaid taxPaid = getTaxPaid(itr, financialYear, inputBeans, computationOfTaxLiability.getAggregateTaxInterestLiability());
		partBTTI.setTaxPaid(taxPaid);

		Refund refund = getRefund(itr, financialYear, inputBeans, computationOfTaxLiability.getAggregateTaxInterestLiability());

		partBTTI.setRefund(refund);

		FADetailsSchedule fADetailsSchedule = new FADetailsSchedule(immovablePropertyDocument, natureInvestmentDocument, signingAuthorityAccountsDocument,
				detailOfTrustDocument, foreignBankAccountDocument, financialInterestDocument);
		ScheduleFA scheduleFA = fADetailsSchedule.getScheduleFA(itr);
		if(scheduleFA != null){
			partBTTI.setAssetOutIndiaFlag("YES");
		}else
			partBTTI.setAssetOutIndiaFlag("NO");

		return partBTTI;
	}

	public TaxPaid getTaxPaid(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans, BigInteger tax){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		BigInteger advanceTax = new BigInteger("0");
		if(advanceTaxDocument!=null){
			advanceTax=indianCurrencyHelper.bigIntegerRound(advanceTaxDocument.getTotal_Amount());
		}

		BigInteger bigTdsSalary=new BigInteger ("0");
		BigInteger bigTotalTdsSalary=new BigInteger ("0");
		Double TDSSalary = 0d;
		if( formSixteenDocument!=null){
			List<FormSixteenDetail> listOfFormSixteenDetail = formSixteenDocument.getFormSixteenDetailList();
			if ( listOfFormSixteenDetail != null && listOfFormSixteenDetail.size() > 0 ){
				for(FormSixteenDetail formSixteenDetail:listOfFormSixteenDetail){
					Double tds1 = 0d;
					Double tds2 = 0d;
					if(formSixteenDetail.getDed_ent_1()!=null)
						tds1 = formSixteenDetail.getDed_ent_1();
					if(formSixteenDetail.getDed_ent_3()!=null)
						tds2 = formSixteenDetail.getDed_ent_3();
					TDSSalary =tds1 + tds2;
					bigTdsSalary=indianCurrencyHelper.bigIntegerRound(TDSSalary);
					bigTotalTdsSalary= bigTotalTdsSalary.add(bigTdsSalary);
				}
			}
		}
		BigInteger TdsPension = new BigInteger("0");
		BigInteger TotalTdsPension = new BigInteger("0");
		if( salaryIncomeDocument!=null){
			List<SalaryIncomeDetail> listOfSalaryIncomeDetail = salaryIncomeDocument.getSalaryIncomeDetailList();
			if ( listOfSalaryIncomeDetail != null && listOfSalaryIncomeDetail.size() > 0 ){
				for(SalaryIncomeDetail salaryIncomeDetail:listOfSalaryIncomeDetail){
					if(salaryIncomeDetail.getTdsPension()!=null){
						TdsPension=indianCurrencyHelper.bigIntegerRound(salaryIncomeDetail.getTdsPension());
						TotalTdsPension= TotalTdsPension.add(TdsPension);
					}
				}
			}
		}

		BigInteger bigTotalTdsOther=new BigInteger ("0");
		if(tdsFromothersDocument!=null){
			bigTotalTdsOther=indianCurrencyHelper.bigIntegerRound(tdsFromothersDocument.getTotal_Amount());
		}

		BigInteger bigTotalTds=bigTotalTdsSalary.add(bigTotalTdsOther).add(TotalTdsPension);

		BigInteger selfAssessmentTax = new BigInteger("0");
		if(selfAssesmetTaxDocument!=null){
			selfAssessmentTax = indianCurrencyHelper.bigIntegerRound(selfAssesmetTaxDocument.getTotal_Amount());
		}
		BigInteger tcsTotal = new BigInteger("0");
		if(tcsDocument!=null){
			tcsTotal = indianCurrencyHelper.bigIntegerRound(tcsDocument.getTotal());
		}
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");
		TaxPaid taxPaid = new TaxPaid();
		TaxesPaid taxesPaid = new TaxesPaid();
		taxesPaid.setAdvanceTax(advanceTax);
		taxesPaid.setTDS(bigTotalTds);
		taxesPaid.setSelfAssessmentTax(selfAssessmentTax);
		if(itrSelection.equals("ITR4S") || itrSelection.equals("ITR4")){
			taxesPaid.setTCS(tcsTotal);
			taxesPaid.setTotalTaxesPaid(taxesPaid.getAdvanceTax().add(taxesPaid.getSelfAssessmentTax()).add(taxesPaid.getTDS()).add(taxesPaid.getTCS()));

		}else{
			taxesPaid.setTotalTaxesPaid(taxesPaid.getAdvanceTax().add(taxesPaid.getSelfAssessmentTax()).add(taxesPaid.getTDS()));
		}
		taxPaid.setTaxesPaid(taxesPaid);

		BigInteger taxPayORRef = new BigInteger("0");
		taxPayORRef = tax.subtract(taxesPaid.getTotalTaxesPaid());
		long roundOfftaxPayORRef = indianCurrencyHelper.roundOffNearestTenth(taxPayORRef.longValue());
		if(BigInteger.valueOf(roundOfftaxPayORRef).compareTo(BigInteger.ZERO) > 0){
			taxPaid.setBalTaxPayable(BigInteger.valueOf(roundOfftaxPayORRef));
		}else
			taxPaid.setBalTaxPayable(new BigInteger("0"));

		return taxPaid;
	}

	public Refund getRefund(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans, BigInteger tax){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Refund refund = new Refund();
		TaxPaid taxPaid = getTaxPaid(itr, financialYear, inputBeans, tax);
		BigInteger taxesPaid = taxPaid.getTaxesPaid().getTotalTaxesPaid();

		BigInteger taxPayORRef = new BigInteger("0");
		taxPayORRef = tax.subtract(taxesPaid);
		long roundOfftaxPayORRef = indianCurrencyHelper.roundOffNearestTenth(taxPayORRef.longValue());

		if(BigInteger.valueOf(roundOfftaxPayORRef).compareTo(BigInteger.ZERO) < 0){
			refund.setRefundDue(BigInteger.valueOf(roundOfftaxPayORRef).multiply(new BigInteger("-1")));
		}else
			refund.setRefundDue(new BigInteger("0"));
		refund.setBankAccountNumber(memberPersonalInformation.getBD_ACC_NUMBER().toUpperCase());
		refund.setEcsRequired(memberPersonalInformation.getBD_ECS());
		DepositToBankAccount depositToBankAccount = new DepositToBankAccount();
		depositToBankAccount.setBankAccountType(memberPersonalInformation.getBD_TYPE_ACC().toUpperCase());
		depositToBankAccount.setIFSCCode(memberPersonalInformation.getFlexField("flex_string_IFSCCode", "").toUpperCase());
		refund.setDepositToBankAccount(depositToBankAccount);

		return refund;
	}
}
