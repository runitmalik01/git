package com.mootly.wcm.model.schedules.y2013_2014;

import java.util.List;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ITR4ScheduleUD;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleUD;

import com.mootly.wcm.beans.UnabsorbedDepreciationDocument;
import com.mootly.wcm.beans.compound.UnabsorbedDepreciationDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR4_ScheduleUD {

	UnabsorbedDepreciationDocument unabsorbedDepreciationDocument = null;

	public ITR4_ScheduleUD(UnabsorbedDepreciationDocument unabsorbedDepreciationDocument){
		this.unabsorbedDepreciationDocument = unabsorbedDepreciationDocument;
	}

	public ITR4ScheduleUD getITR4ScheduleUD(ITR itr){

		ITR4ScheduleUD iTR4ScheduleUD = new ITR4ScheduleUD();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasAValidUD = false;

		if(unabsorbedDepreciationDocument != null){
			List<UnabsorbedDepreciationDetail> unabsorbedDepreciationDetails = unabsorbedDepreciationDocument.getUnabsorbedDepreciationDetailList();
			if ( unabsorbedDepreciationDetails != null && unabsorbedDepreciationDetails.size() > 0 ){
				for (UnabsorbedDepreciationDetail unabsorbedDepreciationDetail:unabsorbedDepreciationDetails)  {
					ScheduleUD scheduleUD = new ScheduleUD();
					scheduleUD.setAssYr(unabsorbedDepreciationDetail.getAssessYear());
					scheduleUD.setAmtBFUD(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDetail.getAmtUADepreciation()));
					scheduleUD.setAmtDeprSOCY(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDetail.getAmtDepCurrYear()));
					scheduleUD.setBalCFNY(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDetail.getBalanceCarry()));
					iTR4ScheduleUD.getScheduleUD().add(scheduleUD);
					if(!hasAValidUD) hasAValidUD = true;
				}
				iTR4ScheduleUD.setTotalBalCFNY(indianCurrencyHelper.bigIntegerRound(unabsorbedDepreciationDocument.getTotal3()));
			}
		}
		if(hasAValidUD){
			return iTR4ScheduleUD;
		}else
			return null;
	}
}
