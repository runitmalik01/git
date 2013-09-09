package com.mootly.wcm.member;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.ChildBean;
import com.mootly.wcm.annotations.DataTypeValidationFields;
import com.mootly.wcm.annotations.DataTypeValidationHelper;
import com.mootly.wcm.annotations.DataTypeValidationType;
import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.annotations.RequiredFields;
import com.mootly.wcm.beans.AdvanceTaxDocument;
import com.mootly.wcm.beans.IncBusinessProfessionDoc;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.ScreenConfigDocument;
import com.mootly.wcm.beans.compound.AdvanceTaxDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.utils.GoGreenUtil;

/*
 * Author:Pankaj Singh
 * Date:13/3/2013
 * Description:It will take value from Tdsfromsalary.jsp and pass it to bean
 */
@PrimaryBean(primaryBeanClass=IncBusinessProfessionDoc.class)

@FormFields(fieldNames={"profitBeforeTax","profitLoss_SpecualtiveBusiness","profitLoss_SpecifiedBusiness","incomeCredited_ProfitLossAcc","profitLoss_IncludeSchPL","shareIncome_Firms","shareIncome_Firms_AOP","exemptIncome_AnyOther",
		"balance","expenseDebit_HeadsInc","expenseDebit_ExemptInc","total_Expense","adjusted_ProfitLoss","depreAllow_us32_1_ii","depreAllow_us32_1_i",
		"depreciation_total","plAfter_AdjustDepr","amountDebit_sec36","amountDebit_sec37","amountDebit_sec40","amountDebit_sec40A","amountDebit_sec43B","interestDisallow_sec23",
		"deemedIncome_Sec41","deemedIncome_Sec33AB","addItem_sec28to44DA","anyIncNotInclude_PLAcc","totalIncome_sec","deductionAllow_Sec32_1_iii","amountDed_Sec35","amountDisAllow_Sec40",
		"amountDisAllow_Sec43B","amountDebited_ToProfitLoss","amountAllow_Deduction","excessAmountAllow_Deduction","anyOtherAmountAllow_Deduction","total_Deduction","income_AfterDed","section44AD",
		"section44AE","section44AF","section44B","section44BB","section44BBA","section44BBB","section44D","section44DA","chapter_XII_G","firstSchedule_ITAct","total_Sections","plBefore_DedUs10A",
		"deduction_Sec10A","deduction_Sec10AA","deduction_total10","netPL_otherthanSpeculative_SpecifiedBuss","netPl_FromBP","computeInc_SpeculativeBuss","addAccordance_28to44DA",
		"dedAccordance_28to44DA","pl_SpeculativeBuss","netPLFrom_SPecifiedInc","additionAcc28to44D","dedAcc28to44DEx35AD","pl_SpecifiedBuss","dedAcc35AD","pl_SpecifiedBussNet","incomeChargeable_PL","depreciation_PL"
	})


public class IncomeBusinessProfession extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
		log.info("this is do before of income form business or profession in itr4");
		}
		ScreenConfigDocument screenConfigDocument = getSiteContentBaseBean(request).getBean("configuration/screenconfigs/incomebusinessprofession");
		request.setAttribute("screenConfigDocument", screenConfigDocument);
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do Action of income form business or profession in itr4");
			}
	} 
}




