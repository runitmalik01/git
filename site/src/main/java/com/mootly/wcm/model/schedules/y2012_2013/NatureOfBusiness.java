package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.NatOfBus;
import in.gov.incometaxindiaefiling.y2012_2013.NatOfBus.Business;
import in.gov.incometaxindiaefiling.y2012_2013.NatOfBus.Business.Trade;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.beans.compound.NatureBusinessDetail;

public class NatureOfBusiness {

	NatureBusinessDocument natureBusinessDocument = null;

	public NatureOfBusiness (NatureBusinessDocument natureBusinessDocument){
		this.natureBusinessDocument = natureBusinessDocument;
	}

	public NatOfBus getNatOfBus(ITR itr){

		NatOfBus natOfBus = new NatOfBus();
		boolean hasAValidNatBus = false;

		if(natureBusinessDocument != null){
			List<NatureBusinessDetail> natureBusinessDetails = natureBusinessDocument.getNatureBusinessDetailList();
			if (natureBusinessDetails != null && natureBusinessDetails.size() > 0 ){
				for (NatureBusinessDetail natureBusinessDetail:natureBusinessDetails)  {
					Business business = new Business();
					business.setCode(natureBusinessDetail.getBusiness_Code());
					Trade trade = new Trade();
					trade.getTradeName().add(natureBusinessDetail.getTradeName_Proprietorship());
					if(StringUtils.isNotBlank(natureBusinessDetail.getTradeName_ProprietorshipSec())){
						trade.getTradeName().add(natureBusinessDetail.getTradeName_ProprietorshipSec());
					}
					if(StringUtils.isNotBlank(natureBusinessDetail.getTradeName_ProprietorshipLast())){
						trade.getTradeName().add(natureBusinessDetail.getTradeName_ProprietorshipLast());
					}
					business.setTrade(trade);
					natOfBus.getBusiness().add(business);
					if(!hasAValidNatBus) hasAValidNatBus = true;
				}
			}
		}
		if(hasAValidNatBus){
			return natOfBus;
		}else
			return null;

	}
}
