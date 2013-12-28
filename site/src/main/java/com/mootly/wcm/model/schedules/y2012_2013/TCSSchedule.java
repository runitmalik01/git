package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTCS;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTCS.TCS;

import java.util.List;

import com.mootly.wcm.beans.TcsDocument;
import com.mootly.wcm.beans.compound.TcsDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TCSSchedule {

	TcsDocument tcsDocument = null;

	public TCSSchedule(TcsDocument tcsDocument){
		this.tcsDocument = tcsDocument;
	}

	public ScheduleTCS getScheduleTCS(ITR itr){

		ScheduleTCS scheduleTCS = new ScheduleTCS();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		boolean hasAValidTCS = false;
		if(tcsDocument != null){
			List<TcsDetail> tcsDetails = tcsDocument.getTcsDetailList();
			if (tcsDetails != null && tcsDetails.size() > 0 ){
				for (TcsDetail tcsDetail:tcsDetails) {
					TCS tCS = new TCS();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tcsDetail.getName());
					employerOrDeductorOrCollectDetl.setTAN(tcsDetail.getTan());
					tCS.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tCS.setAmtTCSClaimedThisYear(indianCurrencyHelper.bigIntegerRound(tcsDetail.getTaxCredited()));
					tCS.setTotalTCS(indianCurrencyHelper.bigIntegerRound(tcsDetail.getTotaltax()));
					scheduleTCS.getTCS().add(tCS);
					if(!hasAValidTCS) hasAValidTCS = true;
				}
			}
		}
		if(hasAValidTCS){
			return scheduleTCS;
		}else
			return null;
	}
}
