package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.IncCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.BusProfExclSpecProf;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.HP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.LTCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.LossRemAftSetOff;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.OthSrcExclRaceHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.OthSrcRaceHorse;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.STCG;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.Salary;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.TotalCurYr;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA.TotalLossSetOff;

import java.math.BigInteger;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class CurrentYearLossesSchedules extends XmlCalculation{
	private static Logger log = LoggerFactory.getLogger(DeductionVIASchedules .class);


	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public ScheduleCYLA getScheduleCYLA(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		Map<String,Object> resultMapLosses = lossesCalc(financialYear,inputBeans);

		ScheduleCYLA scheduleCYLA = new ScheduleCYLA();
		Salary salary = new Salary();
		IncCYLA incCYLA = new IncCYLA();
		incCYLA.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(longsalarytotal));
		incCYLA.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncome").toString())));
		incCYLA.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncome").toString())));
		incCYLA.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSalaryIncome").toString())));
		salary.setIncCYLA(incCYLA);
		scheduleCYLA.setSalary(salary);

		HP hP = new HP();
		IncCYLA inCCYLA = new IncCYLA();
		if(houseIncomeTotal>0){
			inCCYLA.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(houseIncomeTotal));
		}else
			inCCYLA.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		inCCYLA.setBusLossSetoff(new BigInteger("0"));
		inCCYLA.setHPlossCurYrSetoff(new BigInteger("0"));
		inCCYLA.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftHI").toString())));
		inCCYLA.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedHouseIncome").toString())));
		hP.setIncCYLA(inCCYLA);
		scheduleCYLA.setHP(hP);

		BusProfExclSpecProf busProfExclSpecProf = new BusProfExclSpecProf();
		IncCYLA iNCCYLA = new IncCYLA();
		iNCCYLA.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		iNCCYLA.setBusLossSetoff(new BigInteger("0"));
		iNCCYLA.setHPlossCurYrSetoff(new BigInteger("0"));
		iNCCYLA.setOthSrcLossNoRaceHorseSetoff(new BigInteger("0"));
		iNCCYLA.setIncOfCurYrAfterSetOff(new BigInteger("0"));
		busProfExclSpecProf.setIncCYLA(iNCCYLA);
		scheduleCYLA.setBusProfExclSpecProf(busProfExclSpecProf);

		STCG sTCG = new STCG();
		IncCYLA incCYLAforSTCG = new IncCYLA();
		long STCGain = 0; //initialize Short Term Cpital Gain because Capital Gain screen is not completed
		if(STCGain>0){
			incCYLAforSTCG.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(STCGain));
		}else
			incCYLAforSTCG.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforSTCG.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftSTC").toString())));
		incCYLAforSTCG.setBusLossSetoff(new BigInteger("0"));
		incCYLAforSTCG.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftSTC").toString())));
		incCYLAforSTCG.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSTCGain").toString())));
		sTCG.setIncCYLA(incCYLAforSTCG);
		scheduleCYLA.setSTCG(sTCG);

		LTCG lTCG = new LTCG();
		IncCYLA incCYLAforLTCG = new IncCYLA();
		long LTCGain = 0; //initialize Short Term Cpital Gain because Capital Gain screen is not completed
		if(LTCGain>0){
			incCYLAforLTCG.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(LTCGain));
		}else
			incCYLAforLTCG.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforLTCG.setBusLossSetoff(new BigInteger("0"));
		incCYLAforLTCG.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftLTC").toString())));
		incCYLAforLTCG.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftLTC").toString())));
		incCYLAforLTCG.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedLTCGain").toString())));
		lTCG.setIncCYLA(incCYLAforLTCG);
		scheduleCYLA.setLTCG(lTCG);

		OthSrcExclRaceHorse othSrcExclRaceHorse = new OthSrcExclRaceHorse();
		IncCYLA incCYLAforOtherRaceHorse = new IncCYLA();
		if(otherincome>0){
			incCYLAforOtherRaceHorse.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(otherincome));
		}else
			incCYLAforOtherRaceHorse.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setBusLossSetoff(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftOI").toString())));
		incCYLAforOtherRaceHorse.setOthSrcLossNoRaceHorseSetoff(new BigInteger("0"));
		incCYLAforOtherRaceHorse.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedOtherIncome").toString())));
		othSrcExclRaceHorse.setIncCYLA(incCYLAforOtherRaceHorse);
		scheduleCYLA.setOthSrcExclRaceHorse(othSrcExclRaceHorse);

		OthSrcRaceHorse othSrcRaceHorse = new OthSrcRaceHorse();
		IncCYLA incCYLAforRaceHorse = new IncCYLA();
		long SrcRaceHorse = 0;//initialize Maintaining Race Horse Income because it is not included in other sources screen
		if(SrcRaceHorse>0){
			incCYLAforRaceHorse.setIncOfCurYrUnderThatHead(indianCurrencyHelper.longToBigInteger(SrcRaceHorse));
		}else
			incCYLAforRaceHorse.setIncOfCurYrUnderThatHead(new BigInteger("0"));
		incCYLAforRaceHorse.setBusLossSetoff(new BigInteger("0"));
		incCYLAforRaceHorse.setHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseIncomeAftRH").toString())));
		incCYLAforRaceHorse.setOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedOtherIncomeAftHR").toString())));
		incCYLAforRaceHorse.setIncOfCurYrAfterSetOff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedmaintainingRaceHorseIncome").toString())));
		othSrcRaceHorse.setIncCYLA(incCYLAforRaceHorse);
		scheduleCYLA.setOthSrcRaceHorse(othSrcRaceHorse);

		TotalCurYr totalCurYr = new TotalCurYr();
		if(houseIncomeTotal<0){
		totalCurYr.setTotHPlossCurYr(indianCurrencyHelper.longToBigInteger(houseIncomeTotal));
		}else
			totalCurYr.setTotHPlossCurYr(new BigInteger("0"));
		totalCurYr.setTotBusLoss(new BigInteger("0"));
		if(otherincome<0){
			totalCurYr.setTotOthSrcLossNoRaceHorse(indianCurrencyHelper.longToBigInteger(otherincome).multiply(new BigInteger("-1")));
		}else
			totalCurYr.setTotOthSrcLossNoRaceHorse(new BigInteger("0"));
		scheduleCYLA.setTotalCurYr(totalCurYr);

		TotalLossSetOff totalLossSetOff = new TotalLossSetOff();
		totalLossSetOff.setTotHPlossCurYrSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalHPLossSetoff").toString())));
		totalLossSetOff.setTotBusLossSetoff(new BigInteger("0"));
		totalLossSetOff.setTotOthSrcLossNoRaceHorseSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalOILossSetoff").toString())));
		scheduleCYLA.setTotalLossSetOff(totalLossSetOff);

		LossRemAftSetOff lossRemAftSetOff = new LossRemAftSetOff();
		lossRemAftSetOff.setBalHPlossCurYrAftSetoff(totalCurYr.getTotHPlossCurYr().subtract(totalLossSetOff.getTotHPlossCurYrSetoff()));
		lossRemAftSetOff.setBalBusLossAftSetoff(new BigInteger("0"));
		lossRemAftSetOff.setBalOthSrcLossNoRaceHorseAftSetoff(totalCurYr.getTotOthSrcLossNoRaceHorse().subtract(totalLossSetOff.getTotOthSrcLossNoRaceHorseSetoff()));
		scheduleCYLA.setLossRemAftSetOff(lossRemAftSetOff);

		return scheduleCYLA;

	}

}
