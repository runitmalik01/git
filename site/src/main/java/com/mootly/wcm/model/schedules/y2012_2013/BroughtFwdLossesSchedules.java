package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.IncBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.TotalBFLossSetOff;

import java.math.BigInteger;
import java.util.Map;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class BroughtFwdLossesSchedules extends XmlCalculation{
	private static Logger log = LoggerFactory.getLogger(DeductionVIASchedules .class);


	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public ScheduleBFLA getScheduleBFLA(ITR itr, HstRequest request,HstResponse response){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		Map<String,Object> resultMapLosses = lossesCalc(request, response);

		ScheduleBFLA scheduleBFLA = new ScheduleBFLA();
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP hPBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP();
		IncBFLA incBFLA = new IncBFLA();
		incBFLA.setIncOfCurYrUndHeadFromCYLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedHouseIncome").toString())));
		incBFLA.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseLoss").toString())));
		incBFLA.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLA.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLA.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("HouseIncomeAftBFLA").toString())));
		hPBFLA.setIncBFLA(incBFLA);
		scheduleBFLA.setHP(hPBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf busProfExclSpecProfBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf();
		IncBFLA incBFLAForBusiness = new IncBFLA();
		incBFLAForBusiness.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForBusiness.setBFlossPrevYrUndSameHeadSetoff(new BigInteger("0"));
		incBFLAForBusiness.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForBusiness.setIncOfCurYrAfterSetOffBFLosses(new BigInteger("0"));
		incBFLAForBusiness.setIncOfCurYrUndHeadFromCYLA(new BigInteger("0"));
		busProfExclSpecProfBFLA.setIncBFLA(incBFLAForBusiness);
		scheduleBFLA.setBusProfExclSpecProf(busProfExclSpecProfBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG sTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG();
		IncBFLA incBFLAForSTCG = new IncBFLA();
		incBFLAForSTCG.setIncOfCurYrUndHeadFromCYLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSTCGain").toString())));
		incBFLAForSTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedSTCLoss").toString())));
		incBFLAForSTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForSTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForSTCG.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("STCGainAftBFLA").toString())));
		sTCGBFLA.setIncBFLA(incBFLAForSTCG);
		scheduleBFLA.setSTCG(sTCGBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG lTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG();
		IncBFLA incBFLAForLTCG = new IncBFLA();
		incBFLAForLTCG.setIncOfCurYrUndHeadFromCYLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedLTCGain").toString())));
		incBFLAForLTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedLTCLoss").toString())));
		incBFLAForLTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForLTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForLTCG.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("LTCGainAftBFLA").toString())));
		lTCGBFLA.setIncBFLA(incBFLAForLTCG);
		scheduleBFLA.setLTCG(lTCGBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse othSrcExclRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse();
		IncBFLA incBFLAForOthrSrc = new IncBFLA();
		incBFLAForOthrSrc.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForOthrSrc.setBFlossPrevYrUndSameHeadSetoff(new BigInteger("0"));
		incBFLAForOthrSrc.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForOthrSrc.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedOtherIncome").toString())));
		incBFLAForOthrSrc.setIncOfCurYrUndHeadFromCYLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedOtherIncome").toString())));
		othSrcExclRaceHorseBFLA.setIncBFLA(incBFLAForOthrSrc);
		scheduleBFLA.setOthSrcExclRaceHorse(othSrcExclRaceHorseBFLA);

		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse othSrcRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse();
		IncBFLA incBFLAForRaceHorse = new IncBFLA();
		incBFLAForRaceHorse.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		incBFLAForRaceHorse.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedRaceHorseLoss").toString())));
		incBFLAForRaceHorse.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		incBFLAForRaceHorse.setIncOfCurYrAfterSetOffBFLosses(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("RaceHorseIncomeAftBFLA").toString())));
		incBFLAForRaceHorse.setIncOfCurYrUndHeadFromCYLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedmaintainingRaceHorseIncome").toString())));
		othSrcRaceHorseBFLA.setIncBFLA(incBFLAForRaceHorse);
		scheduleBFLA.setOthSrcRaceHorse(othSrcRaceHorseBFLA);

		TotalBFLossSetOff totalBFLossSetOff = new TotalBFLossSetOff();
		totalBFLossSetOff.setTotAllUs35Cl4Setoff(new BigInteger("0"));
		totalBFLossSetOff.setTotBFLossSetoff(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalBFLossSetOff").toString())));
		totalBFLossSetOff.setTotUnabsorbedDeprSetoff(new BigInteger("0"));
		scheduleBFLA.setTotalBFLossSetOff(totalBFLossSetOff);

		scheduleBFLA.setIncomeOfCurrYrAftCYLABFLA(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("totalIncomeAftBFLoss").toString())).add(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("adjustedSalaryIncome").toString()))));

		return scheduleBFLA;
	}

}
