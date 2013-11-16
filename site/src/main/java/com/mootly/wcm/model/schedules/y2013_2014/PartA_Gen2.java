package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.AuditInfo;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;
import in.gov.incometaxindiaefiling.y2013_2014.NatOfBus;
import in.gov.incometaxindiaefiling.y2013_2014.PartAGEN2;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.NatureBusinessDocument;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class PartA_Gen2 {
	MemberPersonalInformation memberPersonalInformation = null;
	NatureBusinessDocument natureBusinessDocument = null;

	public PartA_Gen2(MemberPersonalInformation memberPersonalInformation, NatureBusinessDocument natureBusinessDocument){
		this.memberPersonalInformation = memberPersonalInformation;
		this.natureBusinessDocument = natureBusinessDocument;
	}

	public PartAGEN2 getPartAGen2(ITR itr){

		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		PartAGEN2 partAGEN2 = new PartAGEN2();
		AuditInfo auditInfo = new AuditInfo();
		auditInfo.setLiableSec44AAflg(memberPersonalInformation.getIsLiable_ManageAcc());
		auditInfo.setLiableSec44ABflg(memberPersonalInformation.getIsLiable_ForAudit());
		if(memberPersonalInformation.getIsLiable_ForAudit().equals("Y")){
			auditInfo.setAudFrmName(memberPersonalInformation.getName_auditorFirm());
			auditInfo.setAudFrmPAN(memberPersonalInformation.getPan_Firm());
			auditInfo.setAuditDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getDate_AuditReport()));
			auditInfo.setAuditorMemNo(memberPersonalInformation.getMembershipNo_auditor());
			auditInfo.setAuditorName(memberPersonalInformation.getName_AuditorSign_Report());
			auditInfo.setAuditReportFurnishDate(indianCurrencyHelper.gregorianCalendar(memberPersonalInformation.getDate_FurnishAuditReport()));
		}
		auditInfo.setRepSec92EFlag(memberPersonalInformation.getIsLiable_FurnishSec92E());
		partAGEN2.setAuditInfo(auditInfo);

		NatureOfBusiness natureOfBusiness = new NatureOfBusiness(natureBusinessDocument);
		NatOfBus natOfBus = natureOfBusiness.getNatOfBus(itr);
		partAGEN2.setNatOfBus(natOfBus);

		return partAGEN2;

	}
}
