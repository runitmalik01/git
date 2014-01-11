package com.mootly.wcm.member;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PartBTI;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleVIA;

import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.CapitalAssetDocument;
import com.mootly.wcm.beans.DeductionDocument;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.FormSixteenDocument;
import com.mootly.wcm.beans.HouseProperty;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.IncomeFromFirmsDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.OtherSourcesDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.beans.ScheduleAMTDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScheduleSIDocument;
import com.mootly.wcm.beans.compound.DeductionSchedTenADetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.DeductionVIASchedules;
import com.mootly.wcm.model.schedules.y2012_2013.PartB_TI;

@PrimaryBean(primaryBeanClass=ScheduleAMTDocument.class)
@RequiredBeans(requiredBeans=MemberPersonalInformation.class)
@AdditionalBeans(additionalBeansToLoad={DeductionDocument.class,DeductionSchedTenADocumemt.class,OtherSourcesDocument.class,SalaryIncomeDocument.class,
		HouseProperty.class,FormSixteenDocument.class,ScheduleSIDocument.class,CapitalAssetDocument.class, IncomeFromFirmsDocument.class})
@FormFields(fieldNames={"totalIncomeItem13","dedClaimChapSix","dedClaimTenAA","totalAdjustment","incUndSec115JC","taxPayUndSec115JC"})
public class ITRScheduleAMT extends ITReturnComponent{

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		DeductionSchedTenADocumemt tenADocumemt = (DeductionSchedTenADocumemt) request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		if(tenADocumemt!=null){
			Double dedSecTanAA = 0d;
			if(tenADocumemt.getScheduleTenADetailList()!=null && tenADocumemt.getScheduleTenADetailList().size()>0){
				for(DeductionSchedTenADetail aDetail:tenADocumemt.getScheduleTenADetailList()){
					if(aDetail.getScheduleName().equalsIgnoreCase("10aa")){
						dedSecTanAA += aDetail.getAmount();
						request.setAttribute("dedSecTanAA", dedSecTanAA);
					}
				}
			}
		}
		Map<String, HippoBean> inputBeans = new HashMap<String, HippoBean>();
		inputBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(), (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()));
		inputBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(), (OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(HouseProperty.class.getSimpleName().toLowerCase(), (HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()));
		inputBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(), (FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(), (SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase(), (IncBusinessProfessionDoc)request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()));
		inputBeans.put(ProfitAndLossDocument.class.getSimpleName().toLowerCase(), (ProfitAndLossDocument)request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(OtherInformationDocument.class.getSimpleName().toLowerCase(), (OtherInformationDocument)request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleDPMDocument.class.getSimpleName().toLowerCase(), (ScheduleDPMDocument)request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleDOADocument.class.getSimpleName().toLowerCase(), (ScheduleDOADocument)request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(ScheduleESRDocument.class.getSimpleName().toLowerCase(), (ScheduleESRDocument)request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase()));
		inputBeans.put(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase(), (DeductionSchedTenADocumemt)request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()));
		inputBeans.put(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase(), (IncomeFromFirmsDocument)request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase()));

		DeductionDocument deductionDocument = (DeductionDocument) request.getAttribute(DeductionDocument.class.getSimpleName().toLowerCase());
		ITR itr = new ITR();
		if(deductionDocument!=null){
			DeductionVIASchedules deductionVIASchedules = new DeductionVIASchedules(deductionDocument,
					(MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()),
					(OtherSourcesDocument)(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()));
			ScheduleVIA  scheduleVIA = deductionVIASchedules.getScheduleVIA(itr,  getITRInitData(request).getFinancialYear(), inputBeans);
			request.setAttribute("dedUnderChapSix", scheduleVIA.getDeductUndChapVIA().getTotalChapVIADeductions());
		}
		PartB_TI partB_TI = new	PartB_TI((FormSixteenDocument)request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase()),
				(SalaryIncomeDocument)request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase()),
				(HouseProperty)request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase()),
				(OtherSourcesDocument)(OtherSourcesDocument)request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase()),
				deductionDocument, (MemberPersonalInformation)request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase()),
				(ScheduleSIDocument)request.getAttribute(ScheduleSIDocument.class.getSimpleName().toLowerCase()), (CapitalAssetDocument)request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase()),
				(IncBusinessProfessionDoc)request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase()),(ProfitAndLossDocument)request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase()),
				(OtherInformationDocument)request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase()),(ScheduleDPMDocument)request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase()),
				(ScheduleDOADocument)request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase()),(ScheduleESRDocument)request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase()),
				(DeductionSchedTenADocumemt)request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase()), (IncomeFromFirmsDocument)request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase()));
		PartBTI partBTI = partB_TI.getPartBTI(itr,  getITRInitData(request).getFinancialYear(), inputBeans);
		request.setAttribute("partBTIitem13", partBTI.getTotalIncome());
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}

}
