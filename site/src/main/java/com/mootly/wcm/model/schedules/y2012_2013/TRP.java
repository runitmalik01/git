package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.TaxReturnPreparer;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class TRP {

	MemberPersonalInformation memberPersonalInformation = null;

	public TRP(MemberPersonalInformation memberPersonalInformation){
		this.memberPersonalInformation = memberPersonalInformation;
	}

	public TaxReturnPreparer getTaxReturnPreparer(ITR itr){

		TaxReturnPreparer taxReturnPreparer = new TaxReturnPreparer();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasValidTRP = false;

		if(memberPersonalInformation != null){
			if(memberPersonalInformation.getIsTaxPreparebyTRP().equals("Y")){
				if(!(memberPersonalInformation.getTrpnumber().isEmpty()))
					taxReturnPreparer.setIdentificationNoOfTRP(memberPersonalInformation.getTrpnumber());
				if(!(memberPersonalInformation.getTrpname().isEmpty()))
					taxReturnPreparer.setNameOfTRP(memberPersonalInformation.getTrpname());
				if(memberPersonalInformation.getTrpreimbursement() != null)
					taxReturnPreparer.setReImbFrmGov(indianCurrencyHelper.bigIntegerRound(memberPersonalInformation.getTrpreimbursement()));
				if(!hasValidTRP) hasValidTRP = true;
			}
		}
		if(hasValidTRP){
			return taxReturnPreparer;
		}else
			return null;
	}

}
