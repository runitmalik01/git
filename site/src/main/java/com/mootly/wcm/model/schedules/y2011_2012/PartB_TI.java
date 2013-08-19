package com.mootly.wcm.model.schedules.y2011_2012;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

import in.gov.incometaxindiaefiling.y2011_2012.CapGain;
import in.gov.incometaxindiaefiling.y2011_2012.DeductUndChapVIA;
import in.gov.incometaxindiaefiling.y2011_2012.ITR;
import in.gov.incometaxindiaefiling.y2011_2012.IncFromOS;
import in.gov.incometaxindiaefiling.y2011_2012.LongTerm;
import in.gov.incometaxindiaefiling.y2011_2012.LossSummaryDetail;
import in.gov.incometaxindiaefiling.y2011_2012.PartBTI;
import in.gov.incometaxindiaefiling.y2011_2012.PartBTI.ProfBusGain;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleBFLA.TotalBFLossSetOff;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleCFL.CurrentAYloss;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleCYLA.TotalLossSetOff;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleHP;
import in.gov.incometaxindiaefiling.y2011_2012.ScheduleS;
import in.gov.incometaxindiaefiling.y2011_2012.ShortTerm;

public class PartB_TI {

	OtherSourcesDocument otherSourcesDocument = null;

	public PartB_TI(OtherSourcesDocument otherSourcesDocument){
		this.otherSourcesDocument = otherSourcesDocument;
	}

	public PartBTI getPartBTI(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PartBTI partBTI = new PartBTI();
		//Getting value of Total Salary Income
		ScheduleS scheduleS = new ScheduleS();
		BigInteger incomeSalaries= new BigInteger("0");
		incomeSalaries = scheduleS.getTotIncUnderHeadSalaries();
		partBTI.setSalaries(incomeSalaries);
		//Getting value of Total House Income
		ScheduleHP scheduleHP = new ScheduleHP();
		BigInteger incomeHP = new BigInteger("0");
		incomeHP = BigInteger.valueOf(scheduleHP.getTotalIncomeChargeableUnHP());
		if(incomeHP.compareTo(BigInteger.ZERO) > 0){
		partBTI.setIncomeFromHP(incomeHP);
		}else
			partBTI.setIncomeFromHP(new BigInteger("0"));
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
		longTerm.setLongTermIndexation(indianCurrencyHelper.bigIntegerRound(0D));
		longTerm.setLongTermWOIndexation(indianCurrencyHelper.bigIntegerRound(0D));
		longTerm.setTotalLongTerm(new BigInteger("0"));
		capGain.setLongTerm(longTerm);
		capGain.setTotalCapGains(new BigInteger("0"));
		partBTI.setCapGain(capGain);
		//Other Income
		IncFromOS incFromOS = new IncFromOS();
		incFromOS.setOtherSrcThanOwnRaceHorse(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getTaxable_income()));
		//incFromOS.setWinLotteriesRacesGambling(new BigInteger("0"));//waiting for input from otherincome screen
		incFromOS.setFromOwnRaceHorse(new BigInteger("0"));//waiting for input from otherincome screen
		BigInteger winLotteriesRacesGambling = new BigInteger("0"); //incFromOS.getWinLotteriesRacesGambling();
		BigInteger fromOwnRaceHorse = incFromOS.getFromOwnRaceHorse();
		BigInteger longOtherSrcThanOwnRaceHorse = incFromOS.getOtherSrcThanOwnRaceHorse();
		BigInteger totalOtherIncome = longOtherSrcThanOwnRaceHorse.add(fromOwnRaceHorse.add(winLotteriesRacesGambling));
		if(totalOtherIncome.compareTo(new BigInteger("0")) > 0 ){
			incFromOS.setTotIncFromOS( new BigInteger(String.valueOf(totalOtherIncome)) );
		}else {
			incFromOS.setTotIncFromOS(new BigInteger("0"));
		}
		partBTI.setIncFromOS(incFromOS);

		//total of SalaryIncome+HouseIncome+CapitalGain+OtherIncome
		partBTI.setTotalTI(partBTI.getSalaries().add(partBTI.getIncomeFromHP()).add(capGain.getTotalCapGains()).add(incFromOS.getTotIncFromOS()));
		//total of 2vii and 3vii of Schedule CYLA
		TotalLossSetOff totalLossSetOff = new TotalLossSetOff();
		partBTI.setCurrentYearLoss(totalLossSetOff.getTotHPlossCurYrSetoff().add(totalLossSetOff.getTotOthSrcLossNoRaceHorseSetoff()));
        //totalTI - CurrentYearLoss
		partBTI.setBalanceAfterSetoffLosses(partBTI.getTotalTI().subtract(partBTI.getCurrentYearLoss()));
        // 2vii of Schedule BFLA
		TotalBFLossSetOff totalBFLossSetOff = new TotalBFLossSetOff();
		partBTI.setBalanceAfterSetoffLosses(totalBFLossSetOff.getTotBFLossSetoff());
        //BalanceAfterSetoffLosses - BalanceAfterSetoffLosses
		partBTI.setGrossTotalIncome(partBTI.getBalanceAfterSetoffLosses().subtract(partBTI.getBroughtFwdLossesSetoff()));

		//partBTI.setIncChargeableTaxSplRates (new BigInteger("0"));//Waiting for Schedule SI
		//Total Deduction
		DeductUndChapVIA deductUndChapVIA = new DeductUndChapVIA();
		partBTI.setDeductionsUnderScheduleVIA(deductUndChapVIA.getTotalChapVIADeductions());
		//GrossTotalIncome - Deduction
		partBTI.setTotalIncome(partBTI.getGrossTotalIncome().subtract(partBTI.getDeductionsUnderScheduleVIA()));

		//partBTI.setIncChargeTaxSplRate111A112(new BigInteger("0"));//Waiting for Schedule SI
		//Agriculture Income taking from Other Income Screen
		partBTI.setNetAgricultureIncomeOrOtherIncomeForRate(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getAgriculture_income()));
		//TotalIncome - IncChargeTaxSplRate111A112 + Agriculture Income
		//partBTI.setAggregateIncome(partBTI.getTotalIncome().subtract(partBTI.getIncChargeTaxSplRate111A112()).add(partBTI.getNetAgricultureIncomeOrOtherIncomeForRate()));

		XmlCalculation xmlCalculation = new XmlCalculation();
		Map<String,Object> resultMapLosses = xmlCalculation.lossesCalc(financialYear, inputBeans);
		Double currYrHILoss = Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString());
		Double currYrLTCLoss = Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString());
		Double currYrRaceHrsLoss = Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString());
		Double currYrSTCLoss = Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString());
		Double totalCurrYrLoss = currYrHILoss + currYrLTCLoss + currYrRaceHrsLoss + currYrSTCLoss;
		partBTI.setLossesOfCurrentYearCarriedFwd(indianCurrencyHelper.bigIntegerRound(totalCurrYrLoss));


		return partBTI;
	}
}
