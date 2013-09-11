package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
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
	public ScheduleEI getScheduleEI(ITR itr){
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		ScheduleEI scheduleEI = new ScheduleEI();
		if(otherSourcesDocument != null){
			scheduleEI.setInterestInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getBank_detail_fdr()));
			scheduleEI.setDividendInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getDividends()));
			scheduleEI.setNetAgriIncOrOthrIncRule7(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getAgriculture_income()));
			scheduleEI.setOthers(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getOtherincome()));
		}else{
			scheduleEI.setInterestInc(new BigInteger("0"));
			scheduleEI.setDividendInc(new BigInteger("0"));
			scheduleEI.setNetAgriIncOrOthrIncRule7(new BigInteger("0"));
			scheduleEI.setOthers(new BigInteger("0"));
		}
		BigInteger LTCGEI = new BigInteger("0");
		if(capitalAssetDocument != null){
			List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
			if ( capitalAssetDetails != null && capitalAssetDetails.size() > 0 ){
				for(CapitalAssetDetail capitalAssetDetail:capitalAssetDetails){
					if(capitalAssetDetail.getCapitalGainTaxLT() != null && capitalAssetDetail.getAssetType().equals("SHARES") && capitalAssetDetail.getSstCharge().equals("Y")){
						LTCGEI = LTCGEI.add(indianCurrencyHelper.bigIntegerRound(capitalAssetDetail.getCapitalGain()));
					}
				}
			}
		}
		scheduleEI.setLTCGWhereSTTPaid(LTCGEI);

		scheduleEI.setTotalExemptInc(scheduleEI.getInterestInc().add(scheduleEI.getDividendInc()).add(scheduleEI.getNetAgriIncOrOthrIncRule7())
				.add(scheduleEI.getOthers()).add(scheduleEI.getLTCGWhereSTTPaid()));
		if(scheduleEI.getTotalExemptInc().longValue() > 0 ){
			return scheduleEI;
		}else
			return null;

	}
}
