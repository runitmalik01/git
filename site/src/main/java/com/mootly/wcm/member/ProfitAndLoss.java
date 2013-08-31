package com.mootly.wcm.member;


import java.util.ArrayList;
import java.util.List;

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
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.beans.TdsFromothersDocument;
import com.mootly.wcm.beans.compound.TdsOthersDetail;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.FinancialYear;

/*
 * Author:Pankaj Singh
 * Date:
 * Description
 */
@PrimaryBean(primaryBeanClass=ProfitAndLossDocument.class)
@FormFields(fieldNames={"isAccountMaintain","sales_GrossBusiness","union_ExciseDuties","service_Tax","vat_SalesTax","any_OtherTax","total_DutyTaxCess",
		"rent","commission","dividend","interest","profit_FixedAsset","profit_InvestmentSTT","profit_OtherInvestment","profit_CurrencyFluctuation","agricultural_Income","any_OtherIncome",
		"total_OtherIncome","closing_Stocks","total_CreditAccount","opening_Stocks","purchases","custom_Duty","counter_vailingDuty","special_addtionalDuty","union_ExciseDuty","service_TaxPL",
		"vat_SalesTaxPL","anyOther_TaxPaid","total","freight","consumption_Stores","power_Fuels","rents_PL","repairs_Buildings","repairs_Machinery","salaries_Wages","bonus_PL",
		"reimbursement_MedicalExpenses","leave_Encasement","leave_TravelBenefits","approved_SuperannuationFund","recog_ProvidendFund","recog_GratuityFund","any_OtherFund","any_otherBenefit",
		"total_Compensation","medical_Insurance","life_Insurance","keyman_Insurance","other_Insurance","totalExpense_Insurance","staff_WelfareExpense","entertainment_PL","hospitality_PL",
		"conference_PL","sales_Promotion","advertisement_PL","commission_PL","boarding_Lodging","travelling_Expenses","conveyance_Expenses","telephone_Expenses","guestHouse_Expenses",
		"club_Expenses","festivalCeleb_Expenses","scholarship_PL","gifts_PL","donation_PL","union_ExciseDuty2","service_Tax2","vat_Salestax2","cess_PL","anyOther_RateInclSTT","totalRates_TaxesPaid",
		"audit_Fee","other_Expenses","bad_Debts","bad_DoubtfulDebts","other_Provisions","profitBefore_InterestTaxes","interest_PL","depreciation_PL","profit_BeforeTaxes","prov_CurrentTax","prov_DeferredTax",
		"profit_AfterTax","balance_PreviousYear","amount_Appropriation","transReserves_Surplus","balanceCarried_BalanceSheet","gross_Recepients","gross_Profit","expenses_NoAccount","net_Profit"
		
})

public class ProfitAndLoss extends ITReturnComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TdsFromSalary.class);
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do before render of schedule PL profit and Loss");
		}
		
	
	}
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if(log.isInfoEnabled()){
			log.info("this is do action of schedule PL profit and Loss");
		}
		
	} }
	
	
	

