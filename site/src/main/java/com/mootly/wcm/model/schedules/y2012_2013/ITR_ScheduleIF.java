package com.mootly.wcm.model.schedules.y2012_2013;

import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleIF;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleIF.PartnerFirmDetails;

import com.mootly.wcm.beans.FirmsPartnerDocument;
import com.mootly.wcm.beans.compound.FirmsPartnerDetail;

public class ITR_ScheduleIF {

	FirmsPartnerDocument firmsPartnerDocument = null;

	public ITR_ScheduleIF(FirmsPartnerDocument firmsPartnerDocument){
		this.firmsPartnerDocument = firmsPartnerDocument;
	}

	public ScheduleIF getScheduleIF(ITR itr){

		ScheduleIF scheduleIF = new ScheduleIF();
		boolean hasAValidFirm = false;

		long totPrftShr = 0;
		long totFrmCapBal = 0;
		if(firmsPartnerDocument != null){
			List<FirmsPartnerDetail> firmsPartnerDetails = firmsPartnerDocument.getFirmsPartnerDetailList();
			if ( firmsPartnerDetails != null && firmsPartnerDetails.size() > 0 ){
				for (FirmsPartnerDetail firmsPartnerDetail:firmsPartnerDetails)  {
					PartnerFirmDetails partnerFirmDetails = new PartnerFirmDetails();
					partnerFirmDetails.setFirmName(firmsPartnerDetail.getName_Firm());
					partnerFirmDetails.setFirmPAN(firmsPartnerDetail.getPan_Firm());
					partnerFirmDetails.setProfitSharePercent(Double.parseDouble(firmsPartnerDetail.getPerShare_InProfit()));
					partnerFirmDetails.setProfitShareAmt(firmsPartnerDetail.getAmountShare_InProfit().longValue());
					totPrftShr = totPrftShr + firmsPartnerDetail.getAmountShare_InProfit().longValue();
					partnerFirmDetails.setFirmCapBalOn31Mar(firmsPartnerDetail.getCapital_Balance().longValue());
					totFrmCapBal = totFrmCapBal + firmsPartnerDetail.getCapital_Balance().longValue();
					scheduleIF.getPartnerFirmDetails().add(partnerFirmDetails);
					if(!hasAValidFirm) hasAValidFirm = true;
				}
			}
		}
		scheduleIF.setTotalProfitShareAmt(totPrftShr);
		scheduleIF.setTotalFirmCapBalOn31Mar(totFrmCapBal);

		if(hasAValidFirm){
			return scheduleIF;
		}else
			return null;
	}
}
