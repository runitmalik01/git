package com.mootly.wcm.model.schedules.y2012_2013;

import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80IC;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule80IC.DeductInNorthEast;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.compound.DeductionDocumentDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class Schedule80_IC {

	DeductionDocument deductionDocument = null;

	public Schedule80_IC(DeductionDocument deductionDocument){
		this.deductionDocument = deductionDocument;

	}

	public Schedule80IC getSchedule80IC(ITR itr){

		Schedule80IC schedule80IC = new Schedule80IC();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();

		BigInteger industrials = new BigInteger("0");
		BigInteger industrialhp = new BigInteger("0");
		BigInteger industrialu = new BigInteger("0");
		BigInteger industrialne_a = new BigInteger("0");
		BigInteger industrialne_ap = new BigInteger("0");
		BigInteger industrialne_m = new BigInteger("0");
		BigInteger industrialne_mz = new BigInteger("0");
		BigInteger industrialne_me = new BigInteger("0");
		BigInteger industrialne_n = new BigInteger("0");
		BigInteger industrialne_t = new BigInteger("0");
		if(deductionDocument != null){
			List<DeductionDocumentDetail> deductionDocumentDetail =  deductionDocument.getDeductionDocumentDetailList();
			if ( deductionDocumentDetail != null && deductionDocumentDetail.size() > 0 ){
				for(DeductionDocumentDetail deductionDocumentDetails:deductionDocumentDetail){
					if(deductionDocumentDetails.getSection().equals("80ic")){
						if(deductionDocumentDetails.getHead().equals("industrials")){
							industrials = industrials.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialhp")){
							industrialhp = industrialhp.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialu")){
							industrialu = industrialu.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_a")){
							industrialne_a = industrialne_a.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_ap")){
							industrialne_ap = industrialne_ap.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_m")){
							industrialne_m = industrialne_m.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_mz")){
							industrialne_mz = industrialne_mz.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_me")){
							industrialne_me = industrialne_me.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_n")){
							industrialne_n = industrialne_n.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
						if(deductionDocumentDetails.getHead().equals("industrialne_t")){
							industrialne_t = industrialne_t.add(indianCurrencyHelper.bigIntegerRound(deductionDocumentDetails.getInvestment()));
						}
					}
				}
			}
		}

		schedule80IC.setDeductInSikkim(industrials);
		schedule80IC.setDeductInHimachalP(industrialhp);
		schedule80IC.setDeductInUttaranchal(industrialu);
		DeductInNorthEast deductInNorthEast = new DeductInNorthEast();
		deductInNorthEast.setAssam(industrialne_a);
		deductInNorthEast.setArunachalPradesh(industrialne_ap);
		deductInNorthEast.setManipur(industrialne_m);
		deductInNorthEast.setMizoram(industrialne_mz);
		deductInNorthEast.setMeghalaya(industrialne_me);
		deductInNorthEast.setNagaland(industrialne_n);
		deductInNorthEast.setTripura(industrialne_t);
		deductInNorthEast.setTotDeductInNorthEast(deductInNorthEast.getAssam().add(deductInNorthEast.getArunachalPradesh()).add(deductInNorthEast.getManipur())
				.add(deductInNorthEast.getMizoram()).add(deductInNorthEast.getMeghalaya()).add(deductInNorthEast.getNagaland()).add(deductInNorthEast.getTripura()));
		schedule80IC.setDeductInNorthEast(deductInNorthEast);
		schedule80IC.setTotSchedule80IC(schedule80IC.getDeductInSikkim().add(schedule80IC.getDeductInHimachalP()).add(schedule80IC.getDeductInUttaranchal())
				.add(deductInNorthEast.getTotDeductInNorthEast()));

		return schedule80IC;
	}
}
