package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.DedUs10Detail;
import in.gov.incometaxindiaefiling.y2012_2013.DedUs10Detail.Undertaking;
import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule10AA;
import in.gov.incometaxindiaefiling.y2012_2013.Schedule10AA.DeductSEZ;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_Schedule10AA {

	public DeductionSchedTenADocumemt deductionSchedTenADocumemt;

	public ITR_Schedule10AA(DeductionSchedTenADocumemt deductionSchedTenADocumemt) {
		// TODO Auto-generated constructor stub
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
	}

	public Schedule10AA getITRSchedule10aa(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){
		IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
		boolean hasAVaild10AA = false;
		Schedule10AA schedule10aa = new Schedule10AA();
		Schedule10AA.DeductSEZ deductSEZ = new DeductSEZ();
		DedUs10Detail dedUs10Detail = new DedUs10Detail();
		DedUs10Detail.Undertaking undertaking = new Undertaking();
		Double dedSecTanAA =0d;
		List<BigInteger> underTakingList = new ArrayList<BigInteger>();
		if(deductionSchedTenADocumemt!=null){
			if(deductionSchedTenADocumemt.getScheduleTenADetailList()!=null && deductionSchedTenADocumemt.getScheduleTenADetailList().size()>0){
				for(DeductionSchedTenADetail aDetail:deductionSchedTenADocumemt.getScheduleTenADetailList()){
					if(aDetail.getScheduleName().equalsIgnoreCase("10aa")){
						underTakingList.add(currencyHelper.bigIntegerRound(aDetail.getAmount()));
						dedSecTanAA += aDetail.getAmount();
						if(!hasAVaild10AA) hasAVaild10AA = true;
					}
				}
			}
		}
		undertaking.getDedFromUndertaking().addAll(underTakingList);
		dedUs10Detail.setTotalDedUs10Sub(currencyHelper.bigIntegerRound(dedSecTanAA));
		deductSEZ.setDedUs10Detail(dedUs10Detail);
		schedule10aa.setDeductSEZ(deductSEZ);

		if(hasAVaild10AA){
			return schedule10aa;
		}else
			return null;

	}
}
