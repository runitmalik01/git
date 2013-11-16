package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.DedUs10Detail;
import in.gov.incometaxindiaefiling.y2013_2014.DedUs10Detail.Undertaking;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.Schedule10A;
import in.gov.incometaxindiaefiling.y2013_2014.Schedule10A.DeductSEZ;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class ITR_Schedule10A {

	public DeductionSchedTenADocumemt deductionSchedTenADocumemt;

	public ITR_Schedule10A(DeductionSchedTenADocumemt deductionSchedTenADocumemt) {
		// TODO Auto-generated constructor stub
		this.deductionSchedTenADocumemt = deductionSchedTenADocumemt;
	}

	public Schedule10A getITRSchedule10a(ITR itr, FinancialYear financialYear, Map<String,HippoBean> inputBeans){
		IndianCurrencyHelper currencyHelper = new IndianCurrencyHelper();
		boolean hasAVaild10A = false;
		Schedule10A schedule10a = new Schedule10A();
		Schedule10A.DeductSEZ deductSEZ = new DeductSEZ();
		DedUs10Detail dedUs10Detail = new DedUs10Detail();
		DedUs10Detail.Undertaking undertaking = new Undertaking();
		Double dedSecTanA = 0d;
		List<BigInteger> underTakingList = new ArrayList<BigInteger>();
		if(deductionSchedTenADocumemt!=null){
			if(deductionSchedTenADocumemt.getScheduleTenADetailList()!=null && deductionSchedTenADocumemt.getScheduleTenADetailList().size()>0){
				for(DeductionSchedTenADetail aDetail:deductionSchedTenADocumemt.getScheduleTenADetailList()){
					if(aDetail.getScheduleName().equalsIgnoreCase("10a")){
						underTakingList.add(currencyHelper.bigIntegerRound(aDetail.getAmount()));
						dedSecTanA += aDetail.getAmount();
						if(!hasAVaild10A) hasAVaild10A= true;
					}
				}
			}
		}
		undertaking.getDedFromUndertaking().addAll(underTakingList);
		dedUs10Detail.setTotalDedUs10Sub(currencyHelper.bigIntegerRound(dedSecTanA));
		deductSEZ.setDedUs10Detail(dedUs10Detail);
		schedule10a.setDeductSEZ(deductSEZ);
		schedule10a.setTotalDedUs10A(currencyHelper.bigIntegerRound(dedSecTanA));

		if(hasAVaild10A){
			return schedule10a;
		}else
			return null;

	}
}
