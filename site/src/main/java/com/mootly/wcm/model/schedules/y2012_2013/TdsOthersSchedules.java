package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AddressDetail;
import in.gov.incometaxindiaefiling.y2012_2013.CoOwners;
import in.gov.incometaxindiaefiling.y2012_2013.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PropertyDetails;
import in.gov.incometaxindiaefiling.y2012_2013.Rentdetails;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleHP;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTDS2;
import in.gov.incometaxindiaefiling.y2012_2013.TDSonOthThanSal;

import java.math.BigInteger;
import java.util.List;

import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.HouseIncomeDetail;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TdsOthersSchedules {

	TdsFromothersDocument document = null;

	public TdsOthersSchedules(TdsFromothersDocument document) {
		this.document = document;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public ScheduleTDS2 getScheduleTDS2(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleTDS2 scheduleTDS2 = new ScheduleTDS2();
		boolean hasAValidTDS = false;
		if(document!=null){
			List<TdsOthersDetail> tdsOthersDetails = document.getTdsSalaryDetailList();
			if (tdsOthersDetails != null && tdsOthersDetails.size() > 0 ){
				for (TdsOthersDetail tdsOthersDetail:tdsOthersDetails)  {
					TDSonOthThanSal tdsonOthThanSal = new TDSonOthThanSal();
					EmployerOrDeductorOrCollectDetl employerOrDeductorOrCollectDetl = new EmployerOrDeductorOrCollectDetl();
					employerOrDeductorOrCollectDetl.setTAN(tdsOthersDetail.getTan_Deductor().toUpperCase());
					employerOrDeductorOrCollectDetl.setEmployerOrDeductorOrCollecterName(tdsOthersDetail.getName_Deductor().toUpperCase());
					tdsonOthThanSal.setEmployerOrDeductorOrCollectDetl(employerOrDeductorOrCollectDetl);
					tdsonOthThanSal.setTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getTotal_TaxDeductor()));
					tdsonOthThanSal.setClaimOutOfTotTDSOnAmtPaid(indianCurrencyHelper.bigIntegerRound(tdsOthersDetail.getP_Amount()));
					scheduleTDS2.getTDSonOthThanSal().add(tdsonOthThanSal);
					if(!hasAValidTDS) hasAValidTDS = true;
				}
			}
		}
		if(hasAValidTDS){
			return scheduleTDS2;
		}else
			return null;

	}

}
