package com.mootly.wcm.member;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleBFLA;
import in.gov.incometaxindiaefiling.y2012_2013.ScheduleCYLA;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.AdjustmentOfLossesDoc;
import com.mootly.wcm.beans.BroughtFwdLossesDocument;
import com.mootly.wcm.beans.CapitalAssetDocument;
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
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.compound.AdjustmentOfLossesCom;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.CurrentYearLossesSchedules;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleBFLA;

/*
 * Author:Dhananjay Panwar
 * Date:09-oct-2013
 * Description
 */
@PrimaryBean(primaryBeanClass=BroughtFwdLossesDocument.class)
@FormFields(fieldNames={"salariesincomesetoff","salariescurrentsetoff","hpincomesetoff","hpbflasetoff","hpbfdsetoff",
		"hpbflus35setoff","hpcurrentsetoff","businessincomesetoff","businessbflasetoff","businessbfdsetoff",
		"businessbflus35setoff","businesscurrentsetoff","speculativeincomesetoff","speculativebflasetoff","speculativebfdsetoff",
		"speculativebflus35setoff","speculativecurrentsetoff","specifiedincomesetoff","specifiedbflasetoff","specifiedbfdsetoff",
		"specifiedbflus35setoff","specifiedcurrentsetoff","stgcincomesetoff","stgcbflasetoff","stgcbfdsetoff",
		"stgcbflus35setoff","stgccurrentsetoff","ltgcincomesetoff","ltgcbflasetoff","ltgcbfdsetoff",
		"ltgcbflus35setoff","ltgccurrentsetoff","otherincomesetoff","otherbflasetoff","otherbfdsetoff",
		"otherbflus35setoff","othercurrentsetoff","horseincomesetoff","horsebflasetoff","horsebfdsetoff",
		"horsebflus35setoff","horsecurrentsetoff","totalbflasetoff","totalbfdsetoff","totalbflus35setoff","currentsetoff"})

public class BroughtFwdLosses extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(BroughtFwdLosses.class);

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		SalaryIncomeDocument salaryIncomeDocument = (SalaryIncomeDocument) request.getAttribute(SalaryIncomeDocument.class.getSimpleName().toLowerCase());
		FormSixteenDocument formSixteenDocument = (FormSixteenDocument) request.getAttribute(FormSixteenDocument.class.getSimpleName().toLowerCase());
		HouseProperty houseProperty = (HouseProperty) request.getAttribute(HouseProperty.class.getSimpleName().toLowerCase());
		OtherSourcesDocument otherSourcesDocument = (OtherSourcesDocument) request.getAttribute(OtherSourcesDocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument scheduleDPMDocument = (ScheduleDPMDocument) request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ScheduleDOADocument scheduleDOADocument = (ScheduleDOADocument) request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt deductionSchedTenADocumemt = (DeductionSchedTenADocumemt) request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());
		OtherInformationDocument otherInformationDocument = (OtherInformationDocument) request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument profitAndLossDocument = (ProfitAndLossDocument) request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		IncBusinessProfessionDoc incBusinessProfessionDoc = (IncBusinessProfessionDoc) request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		ScheduleESRDocument scheduleESRDocument = (ScheduleESRDocument) request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase());
		AdjustmentOfLossesDoc adjustmentOfLossesDoc = (AdjustmentOfLossesDoc) request.getAttribute(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase());
		CapitalAssetDocument capitalAssetDocument = (CapitalAssetDocument) request.getAttribute(CapitalAssetDocument.class.getSimpleName().toLowerCase());
		IncomeFromFirmsDocument incomeFromFirmsDocument = (IncomeFromFirmsDocument) request.getAttribute(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase());
		BroughtFwdLossesDocument broughtFwdLossesDocument = (BroughtFwdLossesDocument) request.getAttribute(BroughtFwdLossesDocument.class.getSimpleName().toLowerCase());

		ITR itr = new ITR();
		Map<String, HippoBean> inputBeans = new HashMap<String, HippoBean>();
		inputBeans.put(MemberPersonalInformation.class.getSimpleName().toLowerCase(),memberPersonalInformation);
		inputBeans.put(SalaryIncomeDocument.class.getSimpleName().toLowerCase(),salaryIncomeDocument);
		inputBeans.put(FormSixteenDocument.class.getSimpleName().toLowerCase(),formSixteenDocument);
		inputBeans.put(HouseProperty.class.getSimpleName().toLowerCase(),houseProperty);
		inputBeans.put(OtherSourcesDocument.class.getSimpleName().toLowerCase(),otherSourcesDocument);
		inputBeans.put(AdjustmentOfLossesDoc.class.getSimpleName().toLowerCase(),adjustmentOfLossesDoc);
		inputBeans.put(OtherInformationDocument.class.getSimpleName().toLowerCase(),otherInformationDocument);
		inputBeans.put(ProfitAndLossDocument.class.getSimpleName().toLowerCase(),profitAndLossDocument);
		inputBeans.put(ScheduleESRDocument.class.getSimpleName().toLowerCase(),scheduleESRDocument);
		inputBeans.put(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase(),deductionSchedTenADocumemt);
		inputBeans.put(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase(),incBusinessProfessionDoc);
		inputBeans.put(ScheduleDPMDocument.class.getSimpleName().toLowerCase(),scheduleDPMDocument);
		inputBeans.put(ScheduleDOADocument.class.getSimpleName().toLowerCase(),scheduleDOADocument);
		inputBeans.put(CapitalAssetDocument.class.getSimpleName().toLowerCase(),capitalAssetDocument);
		inputBeans.put(IncomeFromFirmsDocument.class.getSimpleName().toLowerCase(),incomeFromFirmsDocument);
		inputBeans.put(BroughtFwdLossesDocument.class.getSimpleName().toLowerCase(),broughtFwdLossesDocument);

		CurrentYearLossesSchedules currentYearLossesSchedules = new CurrentYearLossesSchedules();
		ScheduleCYLA scheduleCYLA = currentYearLossesSchedules.getScheduleCYLA(itr, getFinancialYear(), inputBeans);

		request.setAttribute("SalaryIncomeAftSetOff", scheduleCYLA.getSalary().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("HPIncomeAftSetOff", scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("BusinessIncomeAftSetOff", scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("SpeculativeIncomeAftSetOff", scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("SpecifiedIncomeAftSetOff", scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("STCGIncomeAftSetOff", scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("LTCGIncomeAftSetOff", scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("OtherIncomeAftSetOff", scheduleCYLA.getOthSrcExclRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());
		request.setAttribute("RaceHorseIncomeAftSetOff", scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());

		Double hpLoss = 0d; Double ltcLoss = 0d; Double stcLoss = 0d; Double maintainingRaceHorseLoss = 0d;
		Double lossFrmSpecifiedBuss = 0d; Double nonSpeculationBusinessLoss = 0d; Double speculationBusinessLoss = 0d;

		if(adjustmentOfLossesDoc != null){
			List<AdjustmentOfLossesCom> listofAdjustmentOfLossesCom = adjustmentOfLossesDoc.getAdjustmentOfLossesList() ;
			if ( listofAdjustmentOfLossesCom != null && listofAdjustmentOfLossesCom.size() > 0 ){
				for(AdjustmentOfLossesCom adjustmentOfLossesCom:listofAdjustmentOfLossesCom){
					if(adjustmentOfLossesCom.getNameOfHead().equals("House Property Loss")){
						hpLoss =hpLoss + adjustmentOfLossesCom.getAmount();
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Long Term Capital Loss")){
						ltcLoss = ltcLoss + adjustmentOfLossesCom.getAmount();
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Short Term Capital Loss")){
						stcLoss = stcLoss + adjustmentOfLossesCom.getAmount();
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Owning and Maintaining Race Horses")){
						maintainingRaceHorseLoss = maintainingRaceHorseLoss + adjustmentOfLossesCom.getAmount();
					}
					//added for ITR4
					if(adjustmentOfLossesCom.getNameOfHead().equals("Loss From Specified Business")){
						lossFrmSpecifiedBuss = lossFrmSpecifiedBuss + adjustmentOfLossesCom.getAmount();
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Non Speculation Business Loss")){
						nonSpeculationBusinessLoss = nonSpeculationBusinessLoss + adjustmentOfLossesCom.getAmount();
					}
					if(adjustmentOfLossesCom.getNameOfHead().equals("Speculation Business Loss")){
						speculationBusinessLoss = speculationBusinessLoss + adjustmentOfLossesCom.getAmount();
					}
				}
			}
		}
		if(scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>hpLoss){
			request.setAttribute("hpLoss", hpLoss);
		}else
			request.setAttribute("hpLoss", scheduleCYLA.getHP().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>nonSpeculationBusinessLoss){
			request.setAttribute("nonSpeculationBusinessLoss", nonSpeculationBusinessLoss);
		}else
			request.setAttribute("nonSpeculationBusinessLoss", scheduleCYLA.getBusProfExclSpecProf().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>speculationBusinessLoss){
			request.setAttribute("speculationBusinessLoss", speculationBusinessLoss);
		}else
			request.setAttribute("speculationBusinessLoss", scheduleCYLA.getSpeculativeInc().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>lossFrmSpecifiedBuss){
			request.setAttribute("lossFrmSpecifiedBuss", lossFrmSpecifiedBuss);
		}else
			request.setAttribute("lossFrmSpecifiedBuss", scheduleCYLA.getSpecifiedInc().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>stcLoss){
			request.setAttribute("stcLoss", stcLoss);
		}else
			request.setAttribute("stcLoss", scheduleCYLA.getSTCG().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>ltcLoss){
			request.setAttribute("ltcLoss", ltcLoss);
		}else
			request.setAttribute("ltcLoss", scheduleCYLA.getLTCG().getIncCYLA().getIncOfCurYrAfterSetOff());

		if(scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff().doubleValue()>maintainingRaceHorseLoss){
			request.setAttribute("maintainingRaceHorseLoss", maintainingRaceHorseLoss);
		}else
			request.setAttribute("maintainingRaceHorseLoss", scheduleCYLA.getOthSrcRaceHorse().getIncCYLA().getIncOfCurYrAfterSetOff());

		ITR4_ScheduleBFLA iTR4_ScheduleBFLA = new ITR4_ScheduleBFLA(broughtFwdLossesDocument);
		ScheduleBFLA scheduleBFLA = iTR4_ScheduleBFLA.getScheduleBFLA(itr, getFinancialYear(), inputBeans);

		request.setAttribute("hpTotal", scheduleBFLA.getHP().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("biTotal", scheduleBFLA.getBusProfExclSpecProf().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("siTotal", scheduleBFLA.getSpeculativeInc().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("spiTotal", scheduleBFLA.getSpecifiedInc().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("stcgTotal", scheduleBFLA.getSTCG().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("ltcgTotal", scheduleBFLA.getLTCG().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("oiTotal", scheduleBFLA.getOthSrcExclRaceHorse().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());
		request.setAttribute("rhTotal", scheduleBFLA.getOthSrcRaceHorse().getIncBFLA().getIncOfCurYrAfterSetOffBFLosses());

		request.setAttribute("broughtfwdlossesSetOff", scheduleBFLA.getTotalBFLossSetOff().getTotBFLossSetoff());
		request.setAttribute("broughtfwdlossesDepSetOff", scheduleBFLA.getTotalBFLossSetOff().getTotUnabsorbedDeprSetoff());
		request.setAttribute("broughtfwdlossesus34SetOff", scheduleBFLA.getTotalBFLossSetOff().getTotAllUs35Cl4Setoff());
		request.setAttribute("currYearIncAftSetOff", scheduleBFLA.getIncomeOfCurrYrAftCYLABFLA());

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}




