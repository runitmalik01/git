package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.ScheduleIT;
import in.gov.incometaxindiaefiling.y2013_2014.TaxPayment;

import java.math.BigInteger;
import java.util.List;

import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.SelfAssesmetTaxDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.beans.compound.SelfAssesmentTaxDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TaxesDocumentScheduleIT {

	AdvanceTaxDocument advanceTaxDocument = null;
	SelfAssesmetTaxDocument selfAssesmetTaxDocument = null;

	public TaxesDocumentScheduleIT(AdvanceTaxDocument advanceTaxDocument, SelfAssesmetTaxDocument selfAssesmetTaxDocument) {
		this.advanceTaxDocument = advanceTaxDocument;
		this.selfAssesmetTaxDocument = selfAssesmetTaxDocument;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public ScheduleIT getScheduleIT(ITR itr){

		ScheduleIT scheduleIT = new ScheduleIT();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasAValidTax = false;
		if(advanceTaxDocument!=null){
			List<AdvanceTaxDetail> advanceTaxDetails = advanceTaxDocument.getAdvanceTaxDetailList();
			if (advanceTaxDetails != null && advanceTaxDetails.size() > 0 ){
				/*
				 * this loop will take care of AdvanceTax Screen
				 */
				for (AdvanceTaxDetail advanceTaxDetail:advanceTaxDetails) {
					TaxPayment taxPayment = new TaxPayment();
					taxPayment.setBSRCode(advanceTaxDetail.getP_BSR());
					taxPayment.setDateDep(indianCurrencyHelper.gregorianCalendar(advanceTaxDetail.getP_Date()));
					taxPayment.setSrlNoOfChaln(indianCurrencyHelper.bigIntegerRoundStr(advanceTaxDetail.getP_Serial()));
					taxPayment.setAmt(indianCurrencyHelper.bigIntegerRound(advanceTaxDetail.getP_Amount()));
					scheduleIT.getTaxPayment().add(taxPayment);
					if(!hasAValidTax) hasAValidTax = true;
				}
			}
		}
		/*
		 * this loop will take care of SelfAssessment Screen
		 */
		if(selfAssesmetTaxDocument!=null){
			List<SelfAssesmentTaxDetail> selfAssesmentTaxDetails = selfAssesmetTaxDocument.getSelfAssesmentDetailList();
			if (selfAssesmentTaxDetails != null && selfAssesmentTaxDetails.size() > 0 ){
				for (SelfAssesmentTaxDetail selfAssesmentTaxDetail:selfAssesmentTaxDetails) {
					TaxPayment taxPayment = new TaxPayment();
					taxPayment.setBSRCode(selfAssesmentTaxDetail.getP_BSR());
					taxPayment.setDateDep(indianCurrencyHelper.gregorianCalendar(selfAssesmentTaxDetail.getP_Date()));
					taxPayment.setSrlNoOfChaln(indianCurrencyHelper.bigIntegerRoundStr(selfAssesmentTaxDetail.getP_Serial()));
					taxPayment.setAmt(indianCurrencyHelper.bigIntegerRound(selfAssesmentTaxDetail.getP_Amount()));
					scheduleIT.getTaxPayment().add(taxPayment);
					if(!hasAValidTax) hasAValidTax = true;
				}
			}
		}
		if(hasAValidTax){
			return scheduleIT;
		}else
			return null;
	}

}
