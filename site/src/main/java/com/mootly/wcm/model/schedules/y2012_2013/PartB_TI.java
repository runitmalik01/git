package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.compound.FormSixteenDetail;
import com.mootly.wcm.beans.compound.SalaryIncomeDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

import in.gov.incometaxindiaefiling.y2012_2013.CapGain;
import in.gov.incometaxindiaefiling.y2012_2013.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.IncFromOS;
import in.gov.incometaxindiaefiling.y2012_2013.LongTerm;
import in.gov.incometaxindiaefiling.y2012_2013.LossSummaryDetail;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI.ProfBusGain;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.TotalBFLossSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.CurrentAYloss;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.TotalLossSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleHP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleS;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;
import in.gov.incometaxindiaefiling.y2012_2013.ShortTerm;

public class PartB_TI {

	FormSixteenDocument formSixteenDocument = null;
	SalaryIncomeDocument salaryIncomeDocument = null;
	HouseProperty housePropertyDocument = null;
	OtherSourcesDocument otherSourcesDocument = null;
	DeductionDocument deductionDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;

	public PartB_TI(FormSixteenDocument formSixteenDocument, SalaryIncomeDocument salaryIncomeDocument, HouseProperty housePropertyDocument ,
			OtherSourcesDocument otherSourcesDocument, DeductionDocument deductionDocument, MemberPersonalInformation memberPersonalInformation){
		this.formSixteenDocument = formSixteenDocument;
		this.salaryIncomeDocument = salaryIncomeDocument;
		this.housePropertyDocument = housePropertyDocument;
		this.otherSourcesDocument = otherSourcesDocument;
		this.deductionDocument = deductionDocument;
		this.memberPersonalInformation = memberPersonalInformation;
	}

	public PartBTI getPartBTI(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		PartBTI partBTI = new PartBTI();

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		XmlCalculation xmlCalculation = new XmlCalculation();
		Map<String,Object> resultMapLosses = xmlCalculation.lossesCalc(financialYear, inputBeans);

		//Getting value of Total Salary Income
		BigInteger incomeSalaries= new BigInteger("0");
		if(formSixteenDocument != null){
			List<FormSixteenDetail> formSixteenDetails = formSixteenDocument.getFormSixteenDetailList();
			if ( formSixteenDetails != null && formSixteenDetails.size() > 0 ){
				for (FormSixteenDetail formSixteenDetail:formSixteenDetails)  {
					incomeSalaries= incomeSalaries.add(indianCurrencyHelper.bigIntegerRound(formSixteenDetail.getIncome_chargable_tax()));
				}
			}
		}
		if(salaryIncomeDocument!=null){
			incomeSalaries = incomeSalaries.add(indianCurrencyHelper.bigIntegerRound(salaryIncomeDocument.getTotal()));
		}
		partBTI.setSalaries(incomeSalaries);
		System.out.println("value of salary"+incomeSalaries);

		//Getting value of Total House Income
		BigInteger incomeHP = new BigInteger("0");
		if(housePropertyDocument != null){
			incomeHP = indianCurrencyHelper.bigIntegerRound(housePropertyDocument.getTotal_HouseIncome());
		}
		if(incomeHP.compareTo(BigInteger.ZERO) > 0){
			partBTI.setIncomeFromHP(incomeHP);
		}else
			partBTI.setIncomeFromHP(new BigInteger("0"));
		System.out.println("value of HouseProperty"+incomeHP);

		//ProfBusGain not required in ITR2
		ProfBusGain profBusGain = new ProfBusGain();
		profBusGain.setProfGainNoSpecBus(0);
		profBusGain.setProfGainSpecBus(new BigInteger("0"));
		profBusGain.setProfGainSpecifiedBus(new BigInteger("0"));
		profBusGain.setTotProfBusGain(new BigInteger("0"));
		partBTI.setProfBusGain(profBusGain);

		//Capital Gain HardCoded Values because CapitalGain Screen is not completed
		CapGain capGain = new CapGain();
		ShortTerm shortTerm = new ShortTerm();
		shortTerm.setShortTermOther(0);
		shortTerm.setShortTermUs111A(0);
		shortTerm.setTotalShortTerm(0);
		capGain.setShortTerm(shortTerm);
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTermIndexation(0);
		longTerm.setLongTermWOIndexation(0);
		longTerm.setTotalLongTerm(new BigInteger("0"));
		capGain.setLongTerm(longTerm);
		capGain.setTotalCapGains(new BigInteger("0"));
		partBTI.setCapGain(capGain);

		//Getting values of other income
		IncFromOS incFromOS = new IncFromOS();
		double incomeOtherThanRaceHorse = 0;
		double incomeFromLotteries = 0;
		double incomeFromRaceHorse = 0;
		double agricultureIncome = 0;
		if(otherSourcesDocument!=null){
			incomeOtherThanRaceHorse = otherSourcesDocument.getTotalint() + otherSourcesDocument.getTotalOther_income() - otherSourcesDocument.getTotalexpense();
			incomeFromRaceHorse = otherSourcesDocument.getBalance();
			incomeFromLotteries = otherSourcesDocument.getLotteryOrhorse_income();
			agricultureIncome = otherSourcesDocument.getAgriculture_income();
		}
		if(incomeOtherThanRaceHorse > 0){
			incFromOS.setOtherSrcThanOwnRaceHorse(indianCurrencyHelper.longRound(incomeOtherThanRaceHorse));
		}else
			incFromOS.setOtherSrcThanOwnRaceHorse(0);
		incFromOS.setWinLotteriesRacesGambling(indianCurrencyHelper.bigIntegerRound(incomeFromLotteries));
		if(incomeFromRaceHorse > 0){
			incFromOS.setFromOwnRaceHorse(indianCurrencyHelper.bigIntegerRound(incomeFromRaceHorse));
		}else
			incFromOS.setFromOwnRaceHorse(new BigInteger("0"));
		incFromOS.setTotIncFromOS(BigInteger.valueOf(incFromOS.getOtherSrcThanOwnRaceHorse()).add(incFromOS.getWinLotteriesRacesGambling()).add(incFromOS.getFromOwnRaceHorse()));
		partBTI.setIncFromOS(incFromOS);

		//total of SalaryIncome+HouseIncome+CapitalGain+OtherIncome
		partBTI.setTotalTI(partBTI.getSalaries().add(partBTI.getIncomeFromHP()).add(capGain.getTotalCapGains()).add(incFromOS.getTotIncFromOS()));

		//total of 2vii and 3vii of Schedule CYLA
		partBTI.setCurrentYearLoss(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalHPLossSetoff").toString())+Double.parseDouble(resultMapLosses.get("totalOILossSetoff").toString())));

		//totalTI - CurrentYearLoss
		partBTI.setBalanceAfterSetoffLosses(partBTI.getTotalTI().subtract(partBTI.getCurrentYearLoss()));

		// 2vii of Schedule BFLA
		partBTI.setBroughtFwdLossesSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalBFLossSetOff").toString())));

		//BalanceAfterSetoffLosses - BroughtFrwdLossesSetoff
		partBTI.setGrossTotalIncome(partBTI.getBalanceAfterSetoffLosses().subtract(partBTI.getBroughtFwdLossesSetoff()));

		partBTI.setIncChargeableTaxSplRates(new BigInteger("0"));//Waiting for Schedule SI

		//Total Deduction (Should not be greater than GrossTotalIncome - IncChargableTaxSplRates)
		DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument, memberPersonalInformation,otherSourcesDocument);
		ScheduleVIA scheduleVIA = deductionVIASchedules.getScheduleVIA(itr, financialYear, inputBeans);
		BigInteger totEligibleDeduction = new BigInteger("0");
		totEligibleDeduction = scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions();
		BigInteger diffGrossIncNIncChargeable = new BigInteger("0");
		diffGrossIncNIncChargeable = partBTI.getGrossTotalIncome().subtract(partBTI.getIncChargeableTaxSplRates());
		if(diffGrossIncNIncChargeable.longValue() > totEligibleDeduction.longValue()){
			partBTI.setDeductionsUnderScheduleVIA(totEligibleDeduction);
		}else
			partBTI.setDeductionsUnderScheduleVIA(diffGrossIncNIncChargeable);

		//GrossTotalIncome - Deduction
		partBTI.setTotalIncome(partBTI.getGrossTotalIncome().subtract(partBTI.getDeductionsUnderScheduleVIA()));

		partBTI.setIncChargeTaxSplRate111A112(new BigInteger("0"));//Waiting for Schedule SI

		//Agriculture Income taking from Other Income Screen
		partBTI.setNetAgricultureIncomeOrOtherIncomeForRate(indianCurrencyHelper.bigIntegerRound(agricultureIncome));

		//TotalIncome - IncChargeTaxSplRate111A112 + Agriculture Income
		partBTI.setAggregateIncome((partBTI.getTotalIncome().subtract(partBTI.getIncChargeTaxSplRate111A112())).add(partBTI.getNetAgricultureIncomeOrOtherIncomeForRate()));

		Double currYrHILoss = Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString());
		Double currYrLTCLoss = Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString());
		Double currYrRaceHrsLoss = Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString());
		Double currYrSTCLoss = Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString());
		Double totalCurrYrLoss = currYrHILoss + currYrLTCLoss + currYrRaceHrsLoss + currYrSTCLoss;
		partBTI.setLossesOfCurrentYearCarriedFwd(indianCurrencyHelper.bigIntegerRound(totalCurrYrLoss));

		return partBTI;
	}
}
