package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.CarryFwdLossDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.LossSummaryDetail;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.AdjTotBFLossInBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.CurrentAYloss;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrev2NdYearFromAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.LossCFFromPrevYrToAY;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalLossCFSummary;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCFL.TotalOfBFLossesEarlierYrs;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;
import com.mootly.wcm.utils.XmlCalculation;

public class CarryFwdLossesSchedules extends XmlCalculation {
	private static Logger log = LoggerFactory.getLogger(DeductionVIASchedules .class);

	AdjustmentOfLossesDoc document = null;

	public CarryFwdLossesSchedules(AdjustmentOfLossesDoc document) {
		this.document = document;
	}


	/**
	 * 2012-2013 Financial Year,HstResponse,HstRequest
	 * @param itr
	 * @return
	 */

	public ScheduleCFL getScheduleCFL(ITR itr, FinancialYear financialYear,Map<String,HippoBean> inputBeans){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		Map<String,Object> resultMapLosses = lossesCalc(financialYear,inputBeans);

		ScheduleCFL scheduleCFL = new ScheduleCFL();
		/*
		List<AdjustmentOfLossesCom> lossesDetails = document.getAdjustmentOfLossesList();

		// incomplete need to put some logic to make it short
		LossCFFromPrevYrToAY lossCFFromPrevYrToAY = new LossCFFromPrevYrToAY();
		LossCFFromPrev2NdYearFromAY lossCFFromPrev2NdYearFromAY = new LossCFFromPrev2NdYearFromAY();
		for (AdjustmentOfLossesCom adjustmentOfLossesCom:lossesDetails)  {
			CarryFwdLossDetail carryFwdLossDetail = new CarryFwdLossDetail();
			carryFwdLossDetail.setDateOfFiling(indianCurrencyHelper.gregorianCalendar(adjustmentOfLossesCom.getDateOfFilingYear()));
			if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
				carryFwdLossDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}else
				carryFwdLossDetail.setHPLossCF(new BigInteger("0"));
			if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
				carryFwdLossDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}else
				carryFwdLossDetail.setLTCGLossCF(new BigInteger("0"));
			if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
				carryFwdLossDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}else
				carryFwdLossDetail.setSTCGLossCF(new BigInteger("0"));
			if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
				carryFwdLossDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(adjustmentOfLossesCom.getAmount()));
			}else
				carryFwdLossDetail.setOthSrcLossRaceHorseCF(new BigInteger("0"));
			carryFwdLossDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
			carryFwdLossDetail.setLossFrmSpecBusCF(new BigInteger("0"));

			int AssessmentYearDifference = indianCurrencyHelper.diffBtwAssessmentYear(request, adjustmentOfLossesCom.getAssessmentYear());
			if(AssessmentYearDifference==1){
				lossCFFromPrevYrToAY.setCarryFwdLossDetail(carryFwdLossDetail);
				scheduleCFL.setLossCFFromPrevYrToAY(lossCFFromPrevYrToAY);
			}
			if(AssessmentYearDifference==2){
				lossCFFromPrev2NdYearFromAY.setCarryFwdLossDetail(carryFwdLossDetail);
				scheduleCFL.setLossCFFromPrev2NdYearFromAY(lossCFFromPrev2NdYearFromAY);
			}

		}
		//end
		 */
		TotalOfBFLossesEarlierYrs totalOfBFLossesEarlierYrs = new TotalOfBFLossesEarlierYrs();
		LossSummaryDetail lossSummaryDetail = new LossSummaryDetail();
		lossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		lossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(totalHPLoss));
		lossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		lossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalLTCLoss));
		lossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(totalMaintainingRaceHorseLoss));
		lossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(totalSTCLoss));
		totalOfBFLossesEarlierYrs.setLossSummaryDetail(lossSummaryDetail);
		scheduleCFL.setTotalOfBFLossesEarlierYrs(totalOfBFLossesEarlierYrs);

		AdjTotBFLossInBFLA adjTotBFLossInBFLA = new AdjTotBFLossInBFLA();
		LossSummaryDetail adjlossSummaryDetail = new LossSummaryDetail();
		adjlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		adjlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedHouseLoss").toString())));
		adjlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		adjlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedLTCLoss").toString())));
		adjlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedRaceHorseLoss").toString())));
		adjlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("balancedSTCLoss").toString())));
		adjTotBFLossInBFLA.setLossSummaryDetail(adjlossSummaryDetail);
		scheduleCFL.setAdjTotBFLossInBFLA(adjTotBFLossInBFLA);

		CurrentAYloss currentAYloss = new CurrentAYloss();
		LossSummaryDetail currYrlossSummaryDetail = new LossSummaryDetail();
		currYrlossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		currYrlossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearHouseIncomeLoss").toString())));
		currYrlossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		currYrlossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearLTCLoss").toString())));
		currYrlossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearRaceHorseLoss").toString())));
		currYrlossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("currYearSTCLoss").toString())));
		currentAYloss.setLossSummaryDetail(currYrlossSummaryDetail);
		scheduleCFL.setCurrentAYloss(currentAYloss);

		TotalLossCFSummary totalLossCFSummary = new TotalLossCFSummary();
		LossSummaryDetail toallossSummaryDetail = new LossSummaryDetail();

		toallossSummaryDetail.setHPLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdHouseIncomeLoss").toString())));
		toallossSummaryDetail.setBusLossOthThanSpecLossCF(new BigInteger("0"));
		toallossSummaryDetail.setLossFrmSpecBusCF(new BigInteger("0"));
		toallossSummaryDetail.setLTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdLTCLoss").toString())));
		toallossSummaryDetail.setOthSrcLossRaceHorseCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdRaceHorseLoss").toString())));
		toallossSummaryDetail.setSTCGLossCF(indianCurrencyHelper.bigIntegerRound(Double.parseDouble(resultMapLosses.get("cryFwdSTCLoss").toString())));
		totalLossCFSummary.setLossSummaryDetail(toallossSummaryDetail);
		scheduleCFL.setTotalLossCFSummary(totalLossCFSummary);

		return scheduleCFL;
	}

}
