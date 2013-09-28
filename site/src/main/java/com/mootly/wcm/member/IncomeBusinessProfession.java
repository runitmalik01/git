package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.DeductionSchedTenADocumemt;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.ScheduleDOADocument;
import com.mootly.wcm.beans.ScheduleDPMDocument;
import com.mootly.wcm.beans.ScheduleESRDocument;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.schedules.y2012_2013.ITR4_ScheduleBP;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will take value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=IncBusinessProfessionDoc.class)
@AdditionalBeans(additionalBeansToLoad={IncBusinessProfessionDoc.class,ProfitAndLossDocument.class,OtherInformationDocument.class,
		ScheduleDPMDocument.class,ScheduleDOADocument.class,ScheduleESRDocument.class,DeductionSchedTenADocumemt.class})
@FormFields(fieldNames={"profitBeforeTax","profitLoss_SpecualtiveBusiness","profitLoss_SpecifiedBusiness","incomeCredited_ProfitLossAcc","profitLoss_IncludeSchPL","shareIncome_Firms","shareIncome_Firms_AOP","exemptIncome_AnyOther","total_ExemptIncome",
		"balance","expenseDebit_HeadsInc","expenseDebit_ExemptInc","total_Expense","adjusted_ProfitLoss","depreAllow_us32_1_ii","depreAllow_us32_1_i",
		"depreciation_total","plAfter_AdjustDepr","amountDebit_sec36","amountDebit_sec37","amountDebit_sec40","amountDebit_sec40A","amountDebit_sec43B","interestDisallow_sec23",
		"deemedIncome_Sec41","deemedIncome_Sec33AB","addItem_sec28to44DA","anyIncNotInclude_PLAcc","totalIncome_sec","deductionAllow_Sec32_1_iii","amountDed_Sec35","amountDisAllow_Sec40",
		"amountDisAllow_Sec43B","amountDebited_ToProfitLoss","amountAllow_Deduction","excessAmountAllow_Deduction","anyOtherAmountAllow_Deduction","total_Deduction","income_AfterDed","section44AD",
		"section44AE","section44AF","section44B","section44BB","section44BBA","section44BBB","section44D","section44DA","chapter_XII_G","firstSchedule_ITAct","total_Sections","plBefore_DedUs10A",
		"deduction_Sec10A","deduction_Sec10AA","deduction_total10","netPL_otherthanSpeculative_SpecifiedBuss","netPL_otherthanSpeculative_SpecifiedBuss1","netPl_FromBP","computeInc_SpeculativeBuss","addAccordance_28to44DA",
		"dedAccordance_28to44DA","pl_SpeculativeBuss","netPLFrom_SPecifiedInc","additionAcc28to44D","dedAcc28to44DEx35AD","pl_SpecifiedBuss","dedAcc35AD","pl_SpecifiedBussNet","incomeChargeable_PL","depreciation_PL","netPL_FromBussProf"
})


public class IncomeBusinessProfession extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of income form business or profession in itr4");
		}



	}
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before of income form business or profession in itr4");
		}
		ScreenConfigDocument screenConfigDocument = getSiteContentBaseBean(request).getBean("configuration/screenconfigs/incomebusinessprofession");
		request.setAttribute("screenConfigDocument", screenConfigDocument);
		// code that fetch value from various schedule and show on screen
		IncBusinessProfessionDoc objIncBusinessProfessionDoc = (IncBusinessProfessionDoc) request.getAttribute(IncBusinessProfessionDoc.class.getSimpleName().toLowerCase());
		ProfitAndLossDocument objProfitAndLossDocumentDoc = (ProfitAndLossDocument) request.getAttribute(ProfitAndLossDocument.class.getSimpleName().toLowerCase());
		OtherInformationDocument objOtherInformationDocument = (OtherInformationDocument) request.getAttribute(OtherInformationDocument.class.getSimpleName().toLowerCase());
		ScheduleDPMDocument objScheduleDPMDocument = (ScheduleDPMDocument) request.getAttribute(ScheduleDPMDocument.class.getSimpleName().toLowerCase());
		ScheduleDOADocument objScheduleDOADocument = (ScheduleDOADocument) request.getAttribute(ScheduleDOADocument.class.getSimpleName().toLowerCase());
		ScheduleESRDocument objScheduleESRDocument = (ScheduleESRDocument) request.getAttribute(ScheduleESRDocument.class.getSimpleName().toLowerCase());
		DeductionSchedTenADocumemt objDeductionSchedTenADocumemt = (DeductionSchedTenADocumemt) request.getAttribute(DeductionSchedTenADocumemt.class.getSimpleName().toLowerCase());


		ITR4_ScheduleBP objITR4_ScheduleBP = new ITR4_ScheduleBP(objIncBusinessProfessionDoc ,objProfitAndLossDocumentDoc,
				objOtherInformationDocument,objScheduleDPMDocument,objScheduleDOADocument,
				objScheduleESRDocument,objDeductionSchedTenADocumemt);
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+objITR4_ScheduleBP);
		if(objITR4_ScheduleBP != null){

			long profitBeforeTax = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getProfBfrTaxPL();
			long profitLoss_IncludeSchPL =objITR4_ScheduleBP .getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getPLUs44SChapXIIG().longValue();
			long total_ExemptIncome = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getIncCredPL().getTotExempIncPL();
			long depreciation_PL = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getDepreciationDebPLCosAct().longValue();
			long depreAllow_us32_1_ii = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getDepreciationAllowITAct32().getDepreciationAllowUs321Ii().longValue();
			long amountDebit_sec36 = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDebPLDisallowUs36().longValue();
			long amountDebit_sec37 = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDebPLDisallowUs37().longValue();
			long amountDebit_sec40 = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDebPLDisallowUs40().longValue();
			long amountDebit_sec40A = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDebPLDisallowUs40A().longValue();
			long amountDebit_sec43B = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDebPLDisallowUs43B().longValue();
			long amountDed_Sec35 = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getDebPLUs35ExcessAmt().longValue();
			long amountDisAllow_Sec40 = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDisallUs40NowAllow().longValue();
			long amountDisAllow_Sec43B = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getAmtDisallUs43BNowAllow().longValue();
			long deduction_Sec10A = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getDeductionUs10S().getSection10A().longValue();
			long deduction_Sec10AA = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getBusinessIncOthThanSpec().getDeductionUs10S().getSection10AA().longValue();
			long netPl_FromBP =  objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getSpecBusinessInc().getNetPLFrmSpecBus();
			long netPLFrom_SPecifiedInc = objITR4_ScheduleBP.getITR4ScheduleBP(null, null, null).getSpecifiedBusinessInc().getNetPLFrmSpecifiedBus();


			// set the get value in request
			request.setAttribute("profitBeforeTax", profitBeforeTax);
			request.setAttribute("profitLoss_IncludeSchPL", profitLoss_IncludeSchPL);
			request.setAttribute("total_ExemptIncome", total_ExemptIncome);
			request.setAttribute("depreciation_PL", depreciation_PL);
			request.setAttribute("depreAllow_us32_1_ii", depreAllow_us32_1_ii);
			request.setAttribute("amountDebit_sec36", amountDebit_sec36);
			request.setAttribute("amountDebit_sec37", amountDebit_sec37);
			request.setAttribute("amountDebit_sec40", amountDebit_sec40);
			request.setAttribute("amountDebit_sec40A", amountDebit_sec40A);
			request.setAttribute("amountDebit_sec43B", amountDebit_sec43B);
			request.setAttribute("amountDed_Sec35", amountDed_Sec35);
			request.setAttribute("amountDisAllow_Sec40", amountDisAllow_Sec40);
			request.setAttribute("amountDisAllow_Sec43B", amountDisAllow_Sec43B);
			request.setAttribute("deduction_Sec10A", deduction_Sec10A);
			request.setAttribute("deduction_Sec10AA", deduction_Sec10AA);
			request.setAttribute("netPl_FromBP", netPl_FromBP);
			request.setAttribute("netPLFrom_SPecifiedInc", netPLFrom_SPecifiedInc);

		}
	}
}




