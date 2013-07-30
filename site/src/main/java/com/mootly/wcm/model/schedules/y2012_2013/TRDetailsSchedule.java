package com.mootly.wcm.model.schedules.y2012_2013;

import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleFSI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTR.TotTaxreliefClaimed;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleTR1;

import com.mootly.wcm.beans.TaxReliefDocument;
import com.mootly.wcm.beans.compound.TaxReliefDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TRDetailsSchedule {
	TaxReliefDocument taxReliefDocument = null;
	
	public TRDetailsSchedule (TaxReliefDocument taxRelief){
		this.taxReliefDocument=taxRelief;
		
	}
	public ScheduleTR1 scheduleTR1(ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleTR1 scheduleTR1 = new ScheduleTR1();
		List<TaxReliefDetail> taxReliefDetails = taxReliefDocument.getTaxReliefDetailList();
		for(TaxReliefDetail taxReliefDetail:taxReliefDetails){
			ScheduleTR scheduleTR = new ScheduleTR();
			scheduleTR.setCountryCode(taxReliefDetail.getCountry_Code());
			scheduleTR.setCountryName(taxReliefDetail.getCountry_Name());
			scheduleTR.setTaxIdentificationNo(taxReliefDetail.getTax_ID());
			scheduleTR.setRelavantArticleDTAA(taxReliefDetail.getArticle_dtaa());
			scheduleTR.setTotalTaxpaid(indianCurrencyHelper.bigIntegerRound(taxReliefDetail.getTotaltax_fsi()));
			TotTaxreliefClaimed totTaxreliefClaimed= new TotTaxreliefClaimed();
			totTaxreliefClaimed.setReliefClaimed90Or90A(indianCurrencyHelper.bigIntegerRound(taxReliefDetail.getRelief90_91()));
			totTaxreliefClaimed.setReliefClaimedUs91(indianCurrencyHelper.bigIntegerRound(taxReliefDetail.getRelief91()));
			scheduleTR.setTotTaxreliefClaimed(totTaxreliefClaimed);
			
			scheduleTR1.getScheduleTR().add(scheduleTR);
			scheduleTR1.setTaxPaidOutsideIndiaDTAA(indianCurrencyHelper.bigIntegerRound(taxReliefDocument.getTaxPaidDtaa()));
			scheduleTR1.setTaxPaidOutsideIndiaNotDTAA(indianCurrencyHelper.bigIntegerRound(taxReliefDocument.getTaxPaidNoDtaa()));
		}
		return scheduleTR1;
	}
    
}
