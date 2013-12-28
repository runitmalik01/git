package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.EmployerOrDeductorOrCollectDetl;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleTDS2;
import in.gov.incometaxindiaefiling.y2013_2014.TDSonOthThanSal;
import in.gov.incometaxindiaefiling.y2013_2014.TDSonOthThanSals;

import java.util.ArrayList;
import java.util.List;

import com.mootly.wcm.beans.TdsFromothersDocument;
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
	 * @return This method will return ScheduleTDS2 for ITR2
	 * @author Dhananjay
	 */

	public ScheduleTDS2 getScheduleTDS2(ITR itr){

		ScheduleTDS2 scheduleTDS2 = new ScheduleTDS2();

		List<TDSonOthThanSal> tDSonOthThanSalList = getTDSonOthThanSal();
		if(tDSonOthThanSalList != null && tDSonOthThanSalList.size() > 0){
			for(TDSonOthThanSal tDSonOthThanSal : tDSonOthThanSalList){
				scheduleTDS2.getTDSonOthThanSal().add(tDSonOthThanSal);
			}
			return scheduleTDS2;
		}else
			return null;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return This method will return TDSonOthThanSalaries for ITR4S
	 * @author Dhananjay
	 */

	public TDSonOthThanSals getTDSonOthThanSals(ITR itr){
		TDSonOthThanSals tDSonOthThanSals = new TDSonOthThanSals();

		List<TDSonOthThanSal> tDSonOthThanSalList = getTDSonOthThanSal();
		if(tDSonOthThanSalList != null && tDSonOthThanSalList.size() > 0){
			for(TDSonOthThanSal tDSonOthThanSal : tDSonOthThanSalList){
				tDSonOthThanSals.getTDSonOthThanSal().add(tDSonOthThanSal);
			}
			return tDSonOthThanSals;
		}else
			return null;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return This method will return a list of TDS Other than Salaries
	 * @author Dhananjay
	 */

	public List<TDSonOthThanSal> getTDSonOthThanSal(){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		List<TDSonOthThanSal> tDSonOthThanSalList = new ArrayList<TDSonOthThanSal>();
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
					//scheduleTDS2.getTDSonOthThanSal().add(tdsonOthThanSal);
					tDSonOthThanSalList.add(tdsonOthThanSal);
				}
			}
		}
		return tDSonOthThanSalList;
	}

}
