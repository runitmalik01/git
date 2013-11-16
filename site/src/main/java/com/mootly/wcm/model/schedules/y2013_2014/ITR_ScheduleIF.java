package com.mootly.wcm.model.schedules.y2013_2014;

import java.util.List;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleIF;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleIF.PartnerFirmDetails;

import com.mootly.wcm.beans.FirmsPartnerDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.FirmsPartnerDetail;

public class ITR_ScheduleIF {

	FirmsPartnerDocument firmsPartnerDocument = null;
	MemberPersonalInformation memberPersonalInformation = null;

	public ITR_ScheduleIF(FirmsPartnerDocument firmsPartnerDocument, MemberPersonalInformation memberPersonalInformation){
		this.firmsPartnerDocument = firmsPartnerDocument;
		this.memberPersonalInformation = memberPersonalInformation;
	}

	public ScheduleIF getScheduleIF(ITR itr){

		ScheduleIF scheduleIF = new ScheduleIF();
		boolean hasAValidFirm = false;
		String itrSelection =  memberPersonalInformation.getFlexField("flex_string_ITRForm", "");

		long totPrftShr = 0;
		long totFrmCapBal = 0;
		if(firmsPartnerDocument != null){
			List<FirmsPartnerDetail> firmsPartnerDetails = firmsPartnerDocument.getFirmsPartnerDetailList();
			if ( firmsPartnerDetails != null && firmsPartnerDetails.size() > 0 ){
				for (FirmsPartnerDetail firmsPartnerDetail:firmsPartnerDetails)  {
					PartnerFirmDetails partnerFirmDetails = new PartnerFirmDetails();
					partnerFirmDetails.setFirmName(firmsPartnerDetail.getName_Firm());
					partnerFirmDetails.setFirmPAN(firmsPartnerDetail.getPan_Firm());
					if(itrSelection.equals("ITR3")){
						partnerFirmDetails.setIsLiableToAudit(firmsPartnerDetail.getIsLiableToAudit());
					}
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
