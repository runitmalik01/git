package com.mootly.wcm.model.schedules.y2012_2013;

import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ScheduleEI;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.compound.CapitalAssetDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ExemptIncomeSchedule {
	OtherSourcesDocument otherSourcesDocument = null;
	CapitalAssetDocument capitalAssetDocument = null;
	
	public ExemptIncomeSchedule(OtherSourcesDocument otherSourcesDocument, CapitalAssetDocument capitalAssetDocument){
		this.otherSourcesDocument=otherSourcesDocument;
		this.capitalAssetDocument=capitalAssetDocument;
	}
	public ScheduleEI scheduleEI(){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleEI scheduleEI = new ScheduleEI();
		scheduleEI.setInterestInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getBank_detail_fdr()));
		scheduleEI.setDividendInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getDividends()));
		scheduleEI.setLTCGWhereSTTPaid(indianCurrencyHelper.bigIntegerRound(0d));
		
		/* commented for now.. waiting to complete capital gain module
		 * List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
		for(CapitalAssetDetail capitalAssetDetail:capitalAssetDetails){
			System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+indianCurrencyHelper.bigIntegerRoundStr(capitalAssetDetail.getCapitalGainTaxLT()));
			scheduleEI.setLTCGWhereSTTPaid(indianCurrencyHelper.bigIntegerRoundStr(capitalAssetDetail.getCapitalGainTaxLT()));
		}
		 */
		
		scheduleEI.setNetAgriIncOrOthrIncRule7(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getAgriculture_income()));
		scheduleEI.setOthers(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getOtherincome()));
		scheduleEI.setTotalExemptInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getTotal_taxfree_income()));
			return scheduleEI;
	}
}
