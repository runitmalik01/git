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
		boolean hasValidEI = false;
		if(otherSourcesDocument != null){
			scheduleEI.setInterestInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getBank_detail_fdr()));
			scheduleEI.setDividendInc(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getDividends()));
			scheduleEI.setNetAgriIncOrOthrIncRule7(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getAgriculture_income()));
			scheduleEI.setOthers(indianCurrencyHelper.bigIntegerRound(otherSourcesDocument.getOtherincome()));
	if(!hasValidEI) hasValidEI = true;
		}else{
			scheduleEI.setInterestInc(new BigInteger("0"));
			scheduleEI.setDividendInc(new BigInteger("0"));
			scheduleEI.setNetAgriIncOrOthrIncRule7(new BigInteger("0"));
			scheduleEI.setOthers(new BigInteger("0"));
		}
		if(capitalAssetDocument != null){

			/* commented for now.. waiting to complete capital gain module
			 * List<CapitalAssetDetail> capitalAssetDetails = capitalAssetDocument.getCapitalAssetDetailList();
			for(CapitalAssetDetail capitalAssetDetail:capitalAssetDetails){
				System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+indianCurrencyHelper.bigIntegerRoundStr(capitalAssetDetail.getCapitalGainTaxLT()));
				scheduleEI.setLTCGWhereSTTPaid(indianCurrencyHelper.bigIntegerRoundStr(capitalAssetDetail.getCapitalGainTaxLT()));
			}
			 */
			scheduleEI.setLTCGWhereSTTPaid(new BigInteger("0"));// need to discuss
			if(!hasValidEI) hasValidEI = true;
		}else{
			scheduleEI.setLTCGWhereSTTPaid(new BigInteger("0"));
		}
		scheduleEI.setTotalExemptInc(scheduleEI.getInterestInc().add(scheduleEI.getDividendInc()).add(scheduleEI.getNetAgriIncOrOthrIncRule7())
				.add(scheduleEI.getOthers()).add(scheduleEI.getLTCGWhereSTTPaid()));
		if( hasValidEI && scheduleEI.getTotalExemptInc().longValue() > 0 ){
			return scheduleEI;
		}else
			return null;

	}
}
