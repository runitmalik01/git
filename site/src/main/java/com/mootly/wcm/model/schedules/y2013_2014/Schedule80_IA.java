package com.mootly.wcm.model.schedules.y2013_2014;

import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.Schedule80IA;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Schedule80_IA {

	DeductionDocument deductionDocument = null;

	public Schedule80_IA(DeductionDocument deductionDocument){
		this.deductionDocument = deductionDocument;
	}

	public Schedule80IA getSchedule80IA(ITR itr){

		Schedule80IA schedule80IA = new Schedule80IA();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		BigInteger infrastructure = new BigInteger("0");
		BigInteger telecommunication = new BigInteger("0");
		BigInteger industrialpark = new BigInteger("0");
		BigInteger powergenerating = new BigInteger("0");
		BigInteger revivalpower = new BigInteger("0");
		if(deductionDocument != null){
			List<DeductionDocumentDetail> deductionDocumentDetail =  deductionDocument.getDeductionDocumentDetailList();
			if ( deductionDocumentDetail != null && deductionDocumentDetail.size() > 0 ){
				for(DeductionDocumentDetail deductionDocumentDetails:deductionDocumentDetail){
					if(deductionDocumentDetails.getSection().equals("80ia")){
						if(deductionDocumentDetails.getHead().equals("infrastructure")){
							infrastructure = infrastructure.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("telecommunication")){
							telecommunication = telecommunication.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialpark")){
							industrialpark = industrialpark.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("powergenerating")){
							powergenerating = powergenerating.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("revivalpower")){
							revivalpower = revivalpower.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
					}
				}
			}
		}

		schedule80IA.setDeductProfUs80IA4I(infrastructure);
		schedule80IA.setDeductProfUs80IA4Ii(telecommunication);
		schedule80IA.setDeductProfUs80IA4Iii(industrialpark);
		schedule80IA.setDeductProfUs80IA4Iv(powergenerating);
		schedule80IA.setDeductProfUs80IA4V(revivalpower);
		schedule80IA.setTotSchedule80IA(schedule80IA.getDeductProfUs80IA4I().add(schedule80IA.getDeductProfUs80IA4Ii()).add(schedule80IA.getDeductProfUs80IA4Iii())
				.add(schedule80IA.getDeductProfUs80IA4Iv()).add(schedule80IA.getDeductProfUs80IA4V()));

		return schedule80IA;
	}
}
