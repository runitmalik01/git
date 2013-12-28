package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITR4ScheduleUD;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleUD;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.UnabsorbedDepreciationDocument;
import com.mootly.wcm.beans.compound.UnabsorbedDepreciationDetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR4_ScheduleUD {

	UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = null;

	public ITR4_ScheduleUD(UnabsorbedDepreciationDocument unabsorbedDepreciationDocument){
		this.unabsorbedDepreciationDocument = unabsorbedDepreciationDocument;
	}

	public ITR4ScheduleUD getITR4ScheduleUD(ITR itr,FinancialYear financialYear,Map<String, HippoBean> inputBeans){
		
		com.mootly.wcm.member.ScheduleUD schUD = new com.mootly.wcm.member.ScheduleUD();
		Map<String, Map<String, Double>> mapYearAndAmounts= new TreeMap<String, Map<String, Double>>();
		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		ScheduleCYLA scheduleCYLA = currentYearLossesSchedules.getScheduleCYLA(itr, financialYear, inputBeans);
		BigInteger maxAmountDepreciation =  scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff().add(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff())
				.add(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff()).
				add(scheduleCYLA.getOthSrcExclRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff()).add(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		TreeMap<String, Double> mapOfclaimedAmountDepreciation = schUD.DepreciationAmountAndYear(unabsorbedDepreciationDocument);
		if(maxAmountDepreciation != null && mapOfclaimedAmountDepreciation != null ){
			mapYearAndAmounts = schUD.AdjustDepreciation(maxAmountDepreciation.doubleValue(), mapOfclaimedAmountDepreciation);	
		}
		
		
		
		ITR4ScheduleUD iTR4ScheduleUD = new ITR4ScheduleUD();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasAValidUD = false;
		double totalCarryFwdNextYr = 0d;
		
		if(unabsorbedDepreciationDocument != null){
			List<UnabsorbedDepreciationDetail> unabsorbedDepreciationDetails = unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList();
			if ( unabsorbedDepreciationDetails != null && unabsorbedDepreciationDetails.size() > 0 ){
				for (UnabsorbedDepreciationDetail unabsorbedDepreciationDetail:unabsorbedDepreciationDetails)  {
					ScheduleUD scheduleUD = new ScheduleUD();
					scheduleUD.setAssYr(unabsorbedDepreciationDetail.getAssessYear());
					scheduleUD.setAmtBFUD(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDetail.getAmtUADepreciation()));
					//scheduleUD.setAmtDeprSOCY(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDetail.getAmtDepCurrYear()));
					if(!mapYearAndAmounts.isEmpty()){
						for(String keyYear:mapYearAndAmounts.keySet()){
							if(keyYear.matches(unabsorbedDepreciationDetail.getAssessYear())){
								scheduleUD.setBalCFNY(indianCurrencyHelper.bigIntegerRound(mapYearAndAmounts.get(keyYear).get("carryFwdAmount")));
								scheduleUD.setAmtDeprSOCY(indianCurrencyHelper.bigIntegerRound(mapYearAndAmounts.get(keyYear).get("offeredDepreciation")));
								totalCarryFwdNextYr = totalCarryFwdNextYr + mapYearAndAmounts.get(keyYear).get("carryFwdAmount");
							}
						}
					}
					//scheduleUD.setBalCFNY(indianCurrencyHelper.bigIntegerRound());
					iTR4ScheduleUD.getScheduleUD().add(scheduleUD);
					if(!hasAValidUD) hasAValidUD = true;
				}
				iTR4ScheduleUD.setTotalBalCFNY(indianCurrencyHelper.bigIntegerRound(totalCarryFwdNextYr));
			}
		}
		if(hasAValidUD){
			return iTR4ScheduleUD;
		}else
			return null;
	}
}
