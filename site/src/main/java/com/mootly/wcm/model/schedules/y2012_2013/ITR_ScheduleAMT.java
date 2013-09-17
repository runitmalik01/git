package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.AdjustmentSec115JC;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ITRScheduleAMT;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;

import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_ScheduleAMT {

	public DeductionDocument deductionDocument;
	public DeductionSchedTenADocumemt deductionSchedTenADocumemt;
	
	public ITR_ScheduleAMT(DeductionDocument deductionDocument,DeductionSchedTenADocumemt deductionSchedTenADocumemt) {
		// TODO Auto-generated constructor stub
		this.deductionDocument = deductionDocument;
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
	}
	
	public ITRScheduleAMT getITItrScheduleAMT(ITR itr, FinancialYear financialYear, Map<String, HippoBean> inputBeans,ScheduleVIA  scheduleVIA,PartBTI partBTI){
		IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
		ITRScheduleAMT itrScheduleAMT = new ITRScheduleAMT();
		AdjustmentSec115JC adjustmentSec115JC = new AdjustmentSec115JC();
		Double dedSecTanAA = 0d;
		Double taxPaybleUnderSec115JC = 0d;
		Double maxAllowed = 2000000d; //20 Lacs
		
		if(deductionSchedTenADocumemt!=null){			
			if(deductionSchedTenADocumemt.getScheduleTenADetailList()!=null && deductionSchedTenADocumemt.getScheduleTenADetailList().size()>0){
				for(DeductionSchedTenADetail aDetail:deductionSchedTenADocumemt.getScheduleTenADetailList()){
					if(aDetail.getScheduleName().equalsIgnoreCase("10aa")){
						dedSecTanAA += aDetail.getAmount();
					}
				}
			}
		}
		
		adjustmentSec115JC.setDeductClaimSec10AA(currencyHelper.bigIntegerRound(dedSecTanAA));
		adjustmentSec115JC.setDeductClaimSec6A(scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions());
		adjustmentSec115JC.setTotal(adjustmentSec115JC.getDeductClaimSec10AA().add(adjustmentSec115JC.getDeductClaimSec6A()));
		
		itrScheduleAMT.setTotalIncItem11(partBTI.getTotalIncome());
		itrScheduleAMT.setAdjustmentSec115JC(adjustmentSec115JC);
		itrScheduleAMT.setAdjustedUnderSec115JC(itrScheduleAMT.getTotalIncItem11().add(itrScheduleAMT.getAdjustmentSec115JC().getTotal()));
		if(itrScheduleAMT.getAdjustedUnderSec115JC().doubleValue() > maxAllowed){
			taxPaybleUnderSec115JC = itrScheduleAMT.getAdjustedUnderSec115JC().doubleValue() * 0.815d;
		}
		itrScheduleAMT.setTaxPayableUnderSec115JC(currencyHelper.bigIntegerRound(taxPaybleUnderSec115JC));
		
		return itrScheduleAMT;
	}
}
