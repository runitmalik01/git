package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.IncBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.TotalBFLossSetOff;

import java.math.BigInteger;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.BroughtFwdLossesDocument;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class ITR4_ScheduleBFLA extends XmlCalculation{
	private static Logger log = LoggerFactory.getLogger(ITR4_ScheduleBFLA .class);

	BroughtFwdLossesDocument broughtFwdLossesDocument = null;

	public ITR4_ScheduleBFLA(BroughtFwdLossesDocument broughtFwdLossesDocument){
		this.broughtFwdLossesDocument = broughtFwdLossesDocument;
	}


	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public ScheduleBFLA getScheduleBFLA(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		Map<String,Object> resultMapLosses = lossesCalc(financialYear,inputBeans);

		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		ScheduleCYLA scheduleCYLA = currentYearLossesSchedules.getScheduleCYLA(itr, financialYear, inputBeans);

		// For HP
		ScheduleBFLA scheduleBFLA = new ScheduleBFLA();
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP hPBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.HP();
		IncBFLA incBFLA = new IncBFLA();
		incBFLA.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalHPLoss){
			incBFLA.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalHPLoss));
		}else{
			incBFLA.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLA.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getHpbfdsetoff()));
			incBFLA.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getHpbflus35setoff()));
		}else{
			incBFLA.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
			incBFLA.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		}
		incBFLA.setIncOfCurYrAfterSetOffBFLosses(incBFLA.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLA.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLA.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLA.getBFAllUs35Cl4Setoff()));
		hPBFLA.setIncBFLA(incBFLA);
		scheduleBFLA.setHP(hPBFLA);

		// for BusProfExclSpecProf
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf busProfExclSpecProfBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.BusProfExclSpecProf();
		IncBFLA incBFLAForBusiness = new IncBFLA();
		incBFLAForBusiness.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalNonSpeculationBusinessLoss){
			incBFLAForBusiness.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalNonSpeculationBusinessLoss));
		}else{
			incBFLAForBusiness.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForBusiness.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getBusinessbfdsetoff()));
			incBFLAForBusiness.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getBusinessbflus35setoff()));
		}else{
			incBFLAForBusiness.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
			incBFLAForBusiness.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		}
		incBFLAForBusiness.setIncOfCurYrAfterSetOffBFLosses(incBFLAForBusiness.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForBusiness.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForBusiness.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForBusiness.getBFAllUs35Cl4Setoff()));
		busProfExclSpecProfBFLA.setIncBFLA(incBFLAForBusiness);
		scheduleBFLA.setBusProfExclSpecProf(busProfExclSpecProfBFLA);

		// for SpeculativeInc
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.SpeculativeInc speculativeInc = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.SpeculativeInc();
		IncBFLA incBFLAForSpecInc = new IncBFLA();
		incBFLAForSpecInc.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalSpeculationBusinessLoss){
			incBFLAForSpecInc.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalSpeculationBusinessLoss));
		}else{
			incBFLAForSpecInc.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForSpecInc.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getSpeculativebfdsetoff()));
			incBFLAForSpecInc.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getSpeculativebflus35setoff()));
		}else{
			incBFLAForSpecInc.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
			incBFLAForSpecInc.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		}
		incBFLAForSpecInc.setIncOfCurYrAfterSetOffBFLosses(incBFLAForSpecInc.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForSpecInc.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForSpecInc.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForSpecInc.getBFAllUs35Cl4Setoff()));
		speculativeInc.setIncBFLA(incBFLAForSpecInc);
		scheduleBFLA.setSpeculativeInc(speculativeInc);

		// for SpecifiedInc
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.SpecifiedInc specifiedInc = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.SpecifiedInc();
		IncBFLA incBFLAForSpecifiedInc = new IncBFLA();
		incBFLAForSpecifiedInc.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalLossFrmSpecifiedBuss){
			incBFLAForSpecifiedInc.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalLossFrmSpecifiedBuss));
		}else{
			incBFLAForSpecifiedInc.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForSpecifiedInc.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getSpecifiedbfdsetoff()));
			incBFLAForSpecifiedInc.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getSpecifiedbflus35setoff()));
		}else{
			incBFLAForSpecifiedInc.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
			incBFLAForSpecifiedInc.setBFAllUs35Cl4Setoff(new BigInteger("0"));
		}
		incBFLAForSpecifiedInc.setIncOfCurYrAfterSetOffBFLosses(incBFLAForSpecifiedInc.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForSpecifiedInc.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForSpecifiedInc.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForSpecifiedInc.getBFAllUs35Cl4Setoff()));
		specifiedInc.setIncBFLA(incBFLAForSpecifiedInc);
		scheduleBFLA.setSpecifiedInc(specifiedInc);

		// for STCG
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG sTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.STCG();
		IncBFLA incBFLAForSTCG = new IncBFLA();
		incBFLAForSTCG.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalSTCLoss) {
			incBFLAForSTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalSTCLoss));
		}else{
			incBFLAForSTCG.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForSTCG.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getStgcbfdsetoff()));
			incBFLAForSTCG.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getStgcbflus35setoff()));
		}else{
			incBFLAForSTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
			incBFLAForSTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		}
		incBFLAForSTCG.setIncOfCurYrAfterSetOffBFLosses(incBFLAForSTCG.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForSTCG.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForSTCG.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForSTCG.getBFAllUs35Cl4Setoff()));
		sTCGBFLA.setIncBFLA(incBFLAForSTCG);
		scheduleBFLA.setSTCG(sTCGBFLA);

		// for LTCG
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG lTCGBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.LTCG();
		IncBFLA incBFLAForLTCG = new IncBFLA();
		incBFLAForLTCG.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalLTCLoss){
			incBFLAForLTCG.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalLTCLoss));
		}else{
			incBFLAForLTCG.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForLTCG.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getLtgcbflus35setoff()));
			incBFLAForLTCG.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getLtgcbfdsetoff()));
		}else{
			incBFLAForLTCG.setBFAllUs35Cl4Setoff(new BigInteger("0"));
			incBFLAForLTCG.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		}
		incBFLAForLTCG.setIncOfCurYrAfterSetOffBFLosses(incBFLAForLTCG.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForLTCG.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForLTCG.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForLTCG.getBFAllUs35Cl4Setoff()));
		lTCGBFLA.setIncBFLA(incBFLAForLTCG);
		scheduleBFLA.setLTCG(lTCGBFLA);

		// for OthSrcExclRaceHorse
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse othSrcExclRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcExclRaceHorse();
		IncBFLA incBFLAForOthrSrc = new IncBFLA();
		incBFLAForOthrSrc.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getOthSrcExclRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		incBFLAForOthrSrc.setBFlossPrevYrUndSameHeadSetoff(new BigInteger("0"));
		if(broughtFwdLossesDocument != null){
			incBFLAForOthrSrc.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getOtherbflus35setoff()));
			incBFLAForOthrSrc.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getOtherbfdsetoff()));
		}else{
			incBFLAForOthrSrc.setBFAllUs35Cl4Setoff(new BigInteger("0"));
			incBFLAForOthrSrc.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		}
		incBFLAForOthrSrc.setIncOfCurYrAfterSetOffBFLosses(incBFLAForOthrSrc.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForOthrSrc.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForOthrSrc.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForOthrSrc.getBFAllUs35Cl4Setoff()));
		othSrcExclRaceHorseBFLA.setIncBFLA(incBFLAForOthrSrc);
		scheduleBFLA.setOthSrcExclRaceHorse(othSrcExclRaceHorseBFLA);

		//for OthSrcRaceHorse
		in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse othSrcRaceHorseBFLA = new in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA.OthSrcRaceHorse();
		IncBFLA incBFLAForRaceHorse = new IncBFLA();
		incBFLAForRaceHorse.setIncOfCurYrUndHeadFromCYLA(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		if(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue() > totalMaintainingRaceHorseLoss){
			incBFLAForRaceHorse.setBFlossPrevYrUndSameHeadSetoff(indianCurrencyHelper.bigIntegerRound(totalMaintainingRaceHorseLoss));
		}else{
			incBFLAForRaceHorse.setBFlossPrevYrUndSameHeadSetoff(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		}
		if(broughtFwdLossesDocument != null){
			incBFLAForRaceHorse.setBFAllUs35Cl4Setoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getHorsebflus35setoff()));
			incBFLAForRaceHorse.setBFUnabsorbedDeprSetoff(indianCurrencyHelper.bigIntegerRound(broughtFwdLossesDocument.getHorsebfdsetoff()));
		}else{
			incBFLAForRaceHorse.setBFAllUs35Cl4Setoff(new BigInteger("0"));
			incBFLAForRaceHorse.setBFUnabsorbedDeprSetoff(new BigInteger("0"));
		}
		incBFLAForRaceHorse.setIncOfCurYrAfterSetOffBFLosses(incBFLAForRaceHorse.getIncOfCurYrUndHeadFromCYLA().subtract(incBFLAForRaceHorse.getBFlossPrevYrUndSameHeadSetoff()).subtract(incBFLAForRaceHorse.getBFUnabsorbedDeprSetoff())
				.subtract(incBFLAForRaceHorse.getBFAllUs35Cl4Setoff()));
		othSrcRaceHorseBFLA.setIncBFLA(incBFLAForRaceHorse);
		scheduleBFLA.setOthSrcRaceHorse(othSrcRaceHorseBFLA);

		// Total
		TotalBFLossSetOff totalBFLossSetOff = new TotalBFLossSetOff();
		totalBFLossSetOff.setTotBFLossSetoff(incBFLA.getBFlossPrevYrUndSameHeadSetoff().add(incBFLAForBusiness.getBFlossPrevYrUndSameHeadSetoff()).add(incBFLAForSpecInc.getBFlossPrevYrUndSameHeadSetoff())
				.add(incBFLAForSpecifiedInc.getBFlossPrevYrUndSameHeadSetoff()).add(incBFLAForSTCG.getBFlossPrevYrUndSameHeadSetoff()).add(incBFLAForLTCG.getBFlossPrevYrUndSameHeadSetoff())
				.add(incBFLAForOthrSrc.getBFlossPrevYrUndSameHeadSetoff()).add(incBFLAForRaceHorse.getBFlossPrevYrUndSameHeadSetoff()));
		totalBFLossSetOff.setTotUnabsorbedDeprSetoff(incBFLA.getBFUnabsorbedDeprSetoff().add(incBFLAForBusiness.getBFUnabsorbedDeprSetoff()).add(incBFLAForSpecInc.getBFUnabsorbedDeprSetoff())
				.add(incBFLAForSpecifiedInc.getBFUnabsorbedDeprSetoff()).add(incBFLAForSTCG.getBFUnabsorbedDeprSetoff()).add(incBFLAForLTCG.getBFUnabsorbedDeprSetoff())
				.add(incBFLAForOthrSrc.getBFUnabsorbedDeprSetoff()).add(incBFLAForRaceHorse.getBFUnabsorbedDeprSetoff()));
		totalBFLossSetOff.setTotAllUs35Cl4Setoff(incBFLA.getBFAllUs35Cl4Setoff().add(incBFLAForBusiness.getBFAllUs35Cl4Setoff()).add(incBFLAForSpecInc.getBFAllUs35Cl4Setoff())
				.add(incBFLAForSpecifiedInc.getBFAllUs35Cl4Setoff()).add(incBFLAForSTCG.getBFAllUs35Cl4Setoff()).add(incBFLAForLTCG.getBFAllUs35Cl4Setoff())
				.add(incBFLAForOthrSrc.getBFAllUs35Cl4Setoff()).add(incBFLAForRaceHorse.getBFAllUs35Cl4Setoff()));
		scheduleBFLA.setTotalBFLossSetOff(totalBFLossSetOff);
		scheduleBFLA.setIncomeOfCurrYrAftCYLABFLA(incBFLA.getIncOfCurYrAfterSetOffBFLosses().add(incBFLAForBusiness.getIncOfCurYrAfterSetOffBFLosses())
				.add(incBFLAForSpecInc.getIncOfCurYrAfterSetOffBFLosses()).add(incBFLAForSpecifiedInc.getIncOfCurYrAfterSetOffBFLosses())
				.add(incBFLAForSTCG.getIncOfCurYrAfterSetOffBFLosses()).add(incBFLAForLTCG.getIncOfCurYrAfterSetOffBFLosses()).add(incBFLAForOthrSrc.getIncOfCurYrAfterSetOffBFLosses())
				.add(incBFLAForRaceHorse.getIncOfCurYrAfterSetOffBFLosses()));

		return scheduleBFLA;
	}
}
