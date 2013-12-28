
/**
 * 
 * User: pankaj
 * Date: 
 * Time: 
 * 
 */


package com.mootly.wcm.beans;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:profitandlossdocument")
public class ProfitAndLossDocument extends ProfitAndLossVariables{
	static final public String NAMESPACE = "mootlywcm:profitandlossdocument";
	static final public String NODE_NAME = "profitandlossdocument";
	
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;
		if (!(formMap.getField("isAccountMaintain").getValue().isEmpty())){
			setIsAccountMaintain(formMap.getField("isAccountMaintain").getValue());
		}
		
		double val_Sales_GrossBusiness=0.0d;
		if (formMap.getField("sales_GrossBusiness").getValue().isEmpty()){
			setSales_GrossBusiness(val_Sales_GrossBusiness);
		}
		else{
			String strSales_GrossBusiness=formMap.getField("sales_GrossBusiness").getValue();
			val_Sales_GrossBusiness= Double.parseDouble(strSales_GrossBusiness);
			setSales_GrossBusiness(val_Sales_GrossBusiness);
		}
		double val_Union_ExciseDuties=0.0d;
		if (formMap.getField("union_ExciseDuties").getValue().isEmpty()) {
			setUnion_ExciseDuties(val_Union_ExciseDuties);
		}
		else{
			String strUnion_ExciseDuties=formMap.getField("union_ExciseDuties").getValue();
			val_Union_ExciseDuties= Double.parseDouble(strUnion_ExciseDuties);
			setUnion_ExciseDuties(val_Union_ExciseDuties);
		}
		double val_Service_Tax=0.0d;
		if (formMap.getField("service_Tax").getValue().isEmpty()) {
			setService_Tax(val_Service_Tax);
		}
		else{
			String service_TaxStr=formMap.getField("service_Tax").getValue();
			val_Service_Tax= Double.parseDouble(service_TaxStr);
			setService_Tax(val_Service_Tax);
		}
		double val_vat_SalesTax=0.0d;
		if (formMap.getField("vat_SalesTax").getValue().isEmpty()){
			setVat_SalesTax(val_vat_SalesTax);
		}
		else{
			String vat_SalesTaxStr=formMap.getField("vat_SalesTax").getValue();
			val_vat_SalesTax= Double.parseDouble(vat_SalesTaxStr);

			setVat_SalesTax(val_vat_SalesTax);
		}
         double val_any_OtherTax=0.0d;
		if (formMap.getField("any_OtherTax").getValue().isEmpty()){
			setVat_SalesTax(val_any_OtherTax);
		}
		else{
			String any_OtherTaxStr=formMap.getField("any_OtherTax").getValue();
			val_any_OtherTax= Double.parseDouble(any_OtherTaxStr);

			setVat_SalesTax(val_any_OtherTax);
		}
          double val_total_DutyTaxCess=0.0d;
		if (formMap.getField("total_DutyTaxCess").getValue().isEmpty()) {
			setTotal_DutyTaxCess(val_total_DutyTaxCess);
		}
		else{
			String total_DutyTaxCessStr=formMap.getField("total_DutyTaxCess").getValue();
			val_total_DutyTaxCess= Double.parseDouble(total_DutyTaxCessStr);
			setTotal_DutyTaxCess(val_total_DutyTaxCess);
		}
		double val_Rent=0.0d;
		if (formMap.getField("rent").getValue().isEmpty()){
			setRent(val_Rent);
		}
		else{
			String rentStr=formMap.getField("rent").getValue();
			val_Rent= Double.parseDouble(rentStr);
			setRent(val_Rent);
		}
		double val_commission=0.0d;
		if (formMap.getField("commission").getValue().isEmpty()) {
			setCommission(val_commission);
		}
		else{
			String commissionStr=formMap.getField("commission").getValue();
			val_commission= Double.parseDouble(commissionStr);
			setCommission(val_commission);
		} 
		double val_dividend=0.0d; 
		if (formMap.getField("dividend").getValue().isEmpty()){
			setDividend(val_dividend);
		}
		else{
			String dividendStr=formMap.getField("dividend").getValue();
			val_dividend= Double.parseDouble(dividendStr);
			setDividend(val_dividend);
		}
		double val_Interest=0.0d;
		if (formMap.getField("interest").getValue().isEmpty()) {
			setInterest(val_Interest);
		}
		else{
			String interestStr=formMap.getField("interest").getValue();
			val_Interest= Double.parseDouble(interestStr);
			setInterest(val_Interest);
		}
		double val_Profit_FixedAsset=0.0d;
		if (formMap.getField("profit_FixedAsset").getValue().isEmpty()){
			setProfit_FixedAsset(val_Profit_FixedAsset);
		}
		else{
			String profit_FixedAssetStr=formMap.getField("profit_FixedAsset").getValue();
			val_Profit_FixedAsset= Double.parseDouble(profit_FixedAssetStr);
			setProfit_FixedAsset(val_Profit_FixedAsset);
		}
		double val_Profit_InvestmentSTT=0.0d;
		if (formMap.getField("profit_InvestmentSTT").getValue().isEmpty()){
			setProfit_InvestmentSTT(val_Profit_InvestmentSTT);
		}
		else{
			String profit_InvestmentSTTStr=formMap.getField("profit_InvestmentSTT").getValue();
			val_Profit_InvestmentSTT= Double.parseDouble(profit_InvestmentSTTStr);
			 setProfit_InvestmentSTT(val_Profit_InvestmentSTT);
		}
		double val_profit_OtherInvestment=0.0d;
		if (formMap.getField("profit_OtherInvestment").getValue().isEmpty()){
			setProfit_OtherInvestment(val_profit_OtherInvestment);
		}
		else{
			String profit_OtherInvestmentStr=formMap.getField("profit_OtherInvestment").getValue();
			val_profit_OtherInvestment= Double.parseDouble(profit_OtherInvestmentStr);
			setProfit_OtherInvestment(val_profit_OtherInvestment);
		}
		double val_profit_CurrencyFluctuation=0.0d;
		if (formMap.getField("profit_CurrencyFluctuation").getValue().isEmpty()) {
			setProfit_CurrencyFluctuation(val_profit_CurrencyFluctuation);
		}
		else{
			String profit_CurrencyFluctuationStr=formMap.getField("profit_CurrencyFluctuation").getValue();
			val_profit_CurrencyFluctuation= Double.parseDouble(profit_CurrencyFluctuationStr);
			setProfit_CurrencyFluctuation(val_profit_CurrencyFluctuation);
		}
		double val_agricultural_Income=0.0d;
		if (formMap.getField("agricultural_Income").getValue().isEmpty()) {
			setAgricultural_Income(val_agricultural_Income);
		}
		else{
			String agricultural_IncomeStr=formMap.getField("agricultural_Income").getValue();
			val_agricultural_Income= Double.parseDouble(agricultural_IncomeStr);
			setAgricultural_Income(val_agricultural_Income);
		}
		double val_any_OtherIncome=0.0d;
		if (formMap.getField("any_OtherIncome").getValue().isEmpty()){
			setAny_OtherIncome(val_any_OtherIncome);
		}
		else{
			String any_OtherIncomeStr=formMap.getField("any_OtherIncome").getValue();
			val_any_OtherIncome= Double.parseDouble(any_OtherIncomeStr);
			setAny_OtherIncome(val_any_OtherIncome);
		}
		double val_total_OtherIncome=0.0d;
		if (formMap.getField("total_OtherIncome").getValue().isEmpty()){
			setTotal_OtherIncome(val_total_OtherIncome);
		}
		else{
			String total_OtherIncomeStr=formMap.getField("total_OtherIncome").getValue();
			val_total_OtherIncome= Double.parseDouble(total_OtherIncomeStr);
			setTotal_OtherIncome(val_total_OtherIncome);
		}
		double val_closing_Stocks=0.0d;
		if (formMap.getField("closing_Stocks").getValue().isEmpty()) {
			setClosing_Stocks(val_closing_Stocks);
		}
		else{
			String closing_StocksStr=formMap.getField("closing_Stocks").getValue();
			val_closing_Stocks= Double.parseDouble(closing_StocksStr);
			setClosing_Stocks(val_closing_Stocks);
		}
		double val_total_CreditAccount=0.0d;
		if (formMap.getField("total_CreditAccount").getValue().isEmpty()) {
			setTotal_CreditAccount(val_total_CreditAccount);	
		}
		else{
			String total_CreditAccountStr=formMap.getField("total_CreditAccount").getValue();
			val_total_CreditAccount= Double.parseDouble(total_CreditAccountStr);
			setTotal_CreditAccount(val_total_CreditAccount);
		}
		double val_opening_Stocks=0.0d;
		if (formMap.getField("opening_Stocks").getValue().isEmpty()) {
			setOpening_Stocks(val_opening_Stocks);
		}
		else{
			String opening_StocksStr=formMap.getField("opening_Stocks").getValue();
			val_opening_Stocks= Double.parseDouble(opening_StocksStr);
			setOpening_Stocks(val_opening_Stocks);
		}
		double val_purchases=0.0d;
		if (formMap.getField("purchases").getValue().isEmpty()) {
			setPurchases(val_purchases);
		}
		else{
			String purchasesStr=formMap.getField("purchases").getValue();
			val_purchases= Double.parseDouble(purchasesStr);
			setPurchases(val_purchases);
		}
		double val_custom_Duty=0.0d;
		if (formMap.getField("custom_Duty").getValue().isEmpty()) {
			setCustom_Duty(val_custom_Duty);
		}
		else{
			String custom_DutyStr=formMap.getField("custom_Duty").getValue();
			val_custom_Duty= Double.parseDouble(custom_DutyStr);
			setCustom_Duty(val_custom_Duty);
		}
		double val_counter_vailingDuty=0.0d;
		if (formMap.getField("counter_vailingDuty").getValue().isEmpty()){
			setCounter_vailingDuty(val_counter_vailingDuty);
		}
		else{
			String counter_vailingDutyStr=formMap.getField("counter_vailingDuty").getValue();
			val_counter_vailingDuty= Double.parseDouble(counter_vailingDutyStr);
			setCounter_vailingDuty(val_counter_vailingDuty);
		}
		double val_special_addtionalDuty=0.0d;
		if (formMap.getField("special_addtionalDuty").getValue().isEmpty()){
			setSpecial_addtionalDuty(val_special_addtionalDuty);
		}
		else{
			String special_addtionalDutyStr=formMap.getField("special_addtionalDuty").getValue();
			val_special_addtionalDuty= Double.parseDouble(special_addtionalDutyStr);
			setSpecial_addtionalDuty(val_special_addtionalDuty);
		} 
		double val_union_ExciseDuty=0.0d; 
		if (formMap.getField("union_ExciseDuty").getValue().isEmpty()){
			setUnion_ExciseDuty(val_union_ExciseDuty);
		}
		else{
			String union_ExciseDutyStr=formMap.getField("union_ExciseDuty").getValue();
			val_union_ExciseDuty= Double.parseDouble(union_ExciseDutyStr);
			 setUnion_ExciseDuty(val_union_ExciseDuty);
		}
		double val_service_TaxPL=0.0d;
		if (formMap.getField("service_TaxPL").getValue().isEmpty()){
			setService_TaxPL(val_service_TaxPL);
		}
		else{
			String service_TaxPLStr=formMap.getField("service_TaxPL").getValue();
			val_service_TaxPL= Double.parseDouble(service_TaxPLStr);
			setService_TaxPL(val_service_TaxPL);
		}
		double val_vat_SalesTaxPL=0.0d;
		if (formMap.getField("vat_SalesTaxPL").getValue().isEmpty()){
			setVat_SalesTaxPL(val_vat_SalesTaxPL);
		}
		else{
			String vat_SalesTaxPLStr=formMap.getField("vat_SalesTaxPL").getValue();
			val_vat_SalesTaxPL= Double.parseDouble(vat_SalesTaxPLStr);
			setVat_SalesTaxPL(val_vat_SalesTaxPL);
		}
		double val_anyOther_TaxPaid=0.0d;
		if (formMap.getField("anyOther_TaxPaid").getValue().isEmpty()){
			setAnyOther_TaxPaid(val_anyOther_TaxPaid);
		}
		else{
			String anyOther_TaxPaidStr=formMap.getField("anyOther_TaxPaid").getValue();
			val_anyOther_TaxPaid= Double.parseDouble(anyOther_TaxPaidStr);
			setAnyOther_TaxPaid(val_anyOther_TaxPaid);
		}
		double val_total=0.0d;
		if (formMap.getField("total").getValue().isEmpty()){
			setTotal(val_total);
		}
		else{
			String totalStr=formMap.getField("total").getValue();
			val_total= Double.parseDouble(totalStr);
			setTotal(val_total);
		}
		double val_freight=0.0d;
		if (formMap.getField("freight").getValue().isEmpty()){
			setFreight(val_freight);
		}
		else{
			String freightStr=formMap.getField("freight").getValue();
			val_freight= Double.parseDouble(freightStr);
			setFreight(val_freight);
		}
		double val_consumption_Stores=0.0d;
		if (formMap.getField("consumption_Stores").getValue().isEmpty()){
			setConsumption_Stores(val_consumption_Stores);
		}
		else{
			String consumption_StoresStr=formMap.getField("consumption_Stores").getValue();
			val_consumption_Stores= Double.parseDouble(consumption_StoresStr);
			setConsumption_Stores(val_consumption_Stores);
		}
		double val_power_Fuels=0.0d;
		if (formMap.getField("power_Fuels").getValue().isEmpty()){
			setPower_Fuels(val_power_Fuels);
		}
		else{
			String power_FuelsStr=formMap.getField("power_Fuels").getValue();
			val_power_Fuels= Double.parseDouble(power_FuelsStr);
			setPower_Fuels(val_power_Fuels);
		}
		double val_rents_PL=0.0d;
		if (formMap.getField("rents_PL").getValue().isEmpty()){
			setRents_PL(val_rents_PL);
		}
		else{
			String rents_PLStr=formMap.getField("rents_PL").getValue();
			val_rents_PL= Double.parseDouble(rents_PLStr);
			setRents_PL(val_rents_PL);
		}
		double val_repairs_Buildings=0.0d;
		if (formMap.getField("repairs_Buildings").getValue().isEmpty()){
			setRepairs_Buildings(val_repairs_Buildings);
		}
		else{
			String repairs_BuildingsStr=formMap.getField("repairs_Buildings").getValue();
			val_repairs_Buildings= Double.parseDouble(repairs_BuildingsStr);
			setRepairs_Buildings(val_repairs_Buildings);
		}
		double val_repairs_Machinery=0.0d;
		if (formMap.getField("repairs_Machinery").getValue().isEmpty()){
			setRepairs_Machinery(val_repairs_Machinery);
		}
		else{
			String repairs_MachineryStr=formMap.getField("repairs_Machinery").getValue();
			val_repairs_Machinery= Double.parseDouble(repairs_MachineryStr);
			setRepairs_Machinery(val_repairs_Machinery);
		}
		double val_salaries_Wages=0.0d;
		if (formMap.getField("salaries_Wages").getValue().isEmpty()){
			setSalaries_Wages(val_salaries_Wages);
		}
		else{
			String salaries_WagesStr=formMap.getField("salaries_Wages").getValue();
			val_salaries_Wages= Double.parseDouble(salaries_WagesStr);
			setSalaries_Wages(val_salaries_Wages);
		}
		double val_bonus_PL=0.0d;
		if (formMap.getField("bonus_PL").getValue().isEmpty()){
			setBonus_PL(val_bonus_PL);
		}
		else{
			String bonus_PLStr=formMap.getField("bonus_PL").getValue();
			val_bonus_PL= Double.parseDouble(bonus_PLStr);
			setBonus_PL(val_bonus_PL);
		}
		double val_reimbursement_MedicalExpenses=0.0d;
		if (formMap.getField("reimbursement_MedicalExpenses").getValue().isEmpty()){
			setReimbursement_MedicalExpenses(val_reimbursement_MedicalExpenses);
		}
		else{
			String reimbursement_MedicalExpensesStr=formMap.getField("reimbursement_MedicalExpenses").getValue();
			val_reimbursement_MedicalExpenses= Double.parseDouble(reimbursement_MedicalExpensesStr);
			setReimbursement_MedicalExpenses(val_reimbursement_MedicalExpenses);
		}
		
		double val_leave_Encasement=0.0d;
		if (formMap.getField("leave_Encasement").getValue().isEmpty()){
			setLeave_Encasement(val_leave_Encasement);
		}
		else{
			String leave_EncasementStr=formMap.getField("leave_Encasement").getValue();
			val_leave_Encasement= Double.parseDouble(leave_EncasementStr);
			setLeave_Encasement(val_leave_Encasement);
		}
		double val_leave_TravelBenefits=0.0d;
		if (formMap.getField("leave_TravelBenefits").getValue().isEmpty()){
			setLeave_TravelBenefits(val_leave_TravelBenefits);
		}
		else{
			String leave_TravelBenefitsStr=formMap.getField("leave_TravelBenefits").getValue();
			val_leave_TravelBenefits= Double.parseDouble(leave_TravelBenefitsStr);
			setLeave_TravelBenefits(val_leave_TravelBenefits);
		}
		double val_approved_SuperannuationFund=0.0d;
		if (formMap.getField("approved_SuperannuationFund").getValue().isEmpty()){
			setApproved_SuperannuationFund(val_approved_SuperannuationFund);
		}
		else{
			String approved_SuperannuationFundStr=formMap.getField("approved_SuperannuationFund").getValue();
			val_approved_SuperannuationFund= Double.parseDouble(approved_SuperannuationFundStr);
			setApproved_SuperannuationFund(val_approved_SuperannuationFund);
		}
		double val_recog_ProvidendFund=0.0d;
		if (formMap.getField("recog_ProvidendFund").getValue().isEmpty()){
			setRecog_ProvidendFund(val_recog_ProvidendFund);
		}
		else{
			String recog_ProvidendFundStr=formMap.getField("recog_ProvidendFund").getValue();
			val_recog_ProvidendFund= Double.parseDouble(recog_ProvidendFundStr);
			setRecog_ProvidendFund(val_recog_ProvidendFund);
		}
		double val_recog_gratuityFund=0.0d;
		log.info("TTTTTTTTTTTTTTTTTTTTTTYYYYYYYYYYYYYYYYYYYYYYYYYYY"+formMap.getField("recog_GratuityFund").getValue().isEmpty());
		if (formMap.getField("recog_GratuityFund").getValue().isEmpty()){
			setRecog_GratuityFund(val_recog_gratuityFund);
		}
		else{
			String recog_gratuityFundStr=formMap.getField("recog_GratuityFund").getValue();
			val_recog_gratuityFund= Double.parseDouble(recog_gratuityFundStr);
			setRecog_GratuityFund(val_recog_gratuityFund);
		}
		double val_any_OtherFundStr=0.0d;
		if (formMap.getField("any_OtherFund").getValue().isEmpty()){
			setAny_OtherFund(val_any_OtherFundStr);
		}
		else{
			String any_OtherFundStr=formMap.getField("any_OtherFund").getValue();
			val_any_OtherFundStr= Double.parseDouble(any_OtherFundStr);
			setAny_OtherFund(val_any_OtherFundStr);
		}
		double val_any_otherBenefit=0.0d;
		if (formMap.getField("any_otherBenefit").getValue().isEmpty()){
			setAny_otherBenefit(val_any_otherBenefit);
		}
		else{
			String any_otherBenefitStr=formMap.getField("any_otherBenefit").getValue();
			val_any_otherBenefit= Double.parseDouble(any_otherBenefitStr);
			setAny_otherBenefit(val_any_otherBenefit);
		}
		double val_total_Compensation=0.0d;
		if (formMap.getField("total_Compensation").getValue().isEmpty()){
			setTotal_Compensation(val_total_Compensation);
		}
		else{
			String total_CompensationStr=formMap.getField("total_Compensation").getValue();
			val_total_Compensation= Double.parseDouble(total_CompensationStr);
			setTotal_Compensation(val_total_Compensation);
		}
		double val_medical_Insurance=0.0d;
		if (formMap.getField("medical_Insurance").getValue().isEmpty()){
			setBonus_PL(val_medical_Insurance);
		}
		else{
			String medical_InsuranceStr=formMap.getField("medical_Insurance").getValue();
			val_medical_Insurance= Double.parseDouble(medical_InsuranceStr);
			setBonus_PL(val_medical_Insurance);
		}
		double val_life_Insurance=0.0d;
		if (formMap.getField("life_Insurance").getValue().isEmpty()){
			setLife_Insurance(val_life_Insurance);
		}
		else{
			String life_InsuranceStr=formMap.getField("life_Insurance").getValue();
			val_life_Insurance= Double.parseDouble(life_InsuranceStr);
			setLife_Insurance(val_life_Insurance);
		}
		double val_keyman_Insurance=0.0d;
		if (formMap.getField("keyman_Insurance").getValue().isEmpty()) {
			setKeyman_Insurance(val_keyman_Insurance);
		}
		else{
			String keyman_InsuranceStr=formMap.getField("keyman_Insurance").getValue();
			val_keyman_Insurance= Double.parseDouble(keyman_InsuranceStr);
			setKeyman_Insurance(val_keyman_Insurance);
		}
		double val_other_Insurance=0.0d;
		if (formMap.getField("other_Insurance").getValue().isEmpty()) {
			setOther_Insurance(val_other_Insurance);
		}
		else{
			String other_InsuranceStr=formMap.getField("other_Insurance").getValue();
			val_other_Insurance= Double.parseDouble(other_InsuranceStr);
			setOther_Insurance(val_other_Insurance);
		}
		double val_totalExpense_Insurance=0.0d;
		if (formMap.getField("totalExpense_Insurance").getValue().isEmpty()){
			setTotalExpense_Insurance(val_totalExpense_Insurance);
		}
		else{
			String totalExpense_InsuranceStr=formMap.getField("totalExpense_Insurance").getValue();
			val_totalExpense_Insurance= Double.parseDouble(totalExpense_InsuranceStr);
			setTotalExpense_Insurance(val_totalExpense_Insurance);
		}
         double val_staff_WelfareExpense=0.0d;
		if (formMap.getField("staff_WelfareExpense").getValue().isEmpty()){
			setStaff_WelfareExpense(val_staff_WelfareExpense);
		}
		else{
			String staff_WelfareExpenseStr=formMap.getField("staff_WelfareExpense").getValue();
			val_staff_WelfareExpense= Double.parseDouble(staff_WelfareExpenseStr);
			setStaff_WelfareExpense(val_staff_WelfareExpense);
		}
          double val_entertainment_PL=0.0d;
		if (formMap.getField("entertainment_PL").getValue().isEmpty()) {
			setEntertainment_PL(val_entertainment_PL);
		}
		else{
			String entertainment_PLStr=formMap.getField("entertainment_PL").getValue();
			val_entertainment_PL= Double.parseDouble(entertainment_PLStr);
			setEntertainment_PL(val_entertainment_PL);
		}
		double val_hospitality_PL=0.0d;
		if (formMap.getField("hospitality_PL").getValue().isEmpty()){
			setHospitality_PL(val_hospitality_PL);
		}
		else{
			String hospitality_PLStr=formMap.getField("hospitality_PL").getValue();
			val_hospitality_PL= Double.parseDouble(hospitality_PLStr);
			setHospitality_PL(val_hospitality_PL);
		}
		
		
		double val_conference_PL=0.0d;
		if (formMap.getField("conference_PL").getValue().isEmpty()){
			setConference_PL(val_conference_PL);
		}
		else{
			String conference_PLStr=formMap.getField("conference_PL").getValue();
			val_conference_PL= Double.parseDouble(conference_PLStr);
			setConference_PL(val_conference_PL);
		}
		double val_sales_Promotion=0.0d;
		if (formMap.getField("sales_Promotion").getValue().isEmpty()){
			setSales_Promotion(val_sales_Promotion);
		}
		else{
			String sales_PromotionStr=formMap.getField("sales_Promotion").getValue();
			val_sales_Promotion= Double.parseDouble(sales_PromotionStr);
			setSales_Promotion(val_sales_Promotion);
		}
		double val_advertisement_PL=0.0d;
		if (formMap.getField("advertisement_PL").getValue().isEmpty()){
			setAdvertisement_PL(val_advertisement_PL);
		}
		else{
			String advertisement_PLStr=formMap.getField("advertisement_PL").getValue();
			val_advertisement_PL= Double.parseDouble(advertisement_PLStr);
			setAdvertisement_PL(val_advertisement_PL);
		}
		double val_commission_PL=0.0d;
		if (formMap.getField("commission_PL").getValue().isEmpty()){
			setCommission_PL(val_commission_PL);
		}
		else{
			String commission_PLStr=formMap.getField("commission_PL").getValue();
			val_commission_PL= Double.parseDouble(commission_PLStr);
			setCommission_PL(val_commission_PL);
		}
		double val_boarding_Lodging=0.0d;
		if (formMap.getField("boarding_Lodging").getValue().isEmpty()){
			setBoarding_Lodging(val_boarding_Lodging);
		}
		else{
			String boarding_LodgingStr=formMap.getField("boarding_Lodging").getValue();
			val_boarding_Lodging= Double.parseDouble(boarding_LodgingStr);
			setBoarding_Lodging(val_boarding_Lodging);
		}
		double val_travelling_Expenses=0.0d;
		if (formMap.getField("travelling_Expenses").getValue().isEmpty()){
			setTravelling_Expenses(val_travelling_Expenses);
		}
		else{
			String travelling_ExpensesStr=formMap.getField("travelling_Expenses").getValue();
			val_travelling_Expenses= Double.parseDouble(travelling_ExpensesStr);
			setTravelling_Expenses(val_travelling_Expenses);
		}
		double val_conveyance_Expenses=0.0d;
		if (formMap.getField("conveyance_Expenses").getValue().isEmpty()){
			setConveyance_Expenses(val_conveyance_Expenses);
		}
		else{
			String conveyance_ExpensesStr=formMap.getField("conveyance_Expenses").getValue();
			val_conveyance_Expenses= Double.parseDouble(conveyance_ExpensesStr);
			setConveyance_Expenses(val_conveyance_Expenses);
		}
		double val_telephone_Expenses=0.0d;
		if (formMap.getField("telephone_Expenses").getValue().isEmpty()) {
			setTelephone_Expenses(val_telephone_Expenses);
		}
		else{
			String telephone_ExpensesStr=formMap.getField("telephone_Expenses").getValue();
			val_telephone_Expenses= Double.parseDouble(telephone_ExpensesStr);
			setTelephone_Expenses(val_telephone_Expenses);
		}
		double val_guestHouse_Expenses=0.0d;
		if (formMap.getField("guestHouse_Expenses").getValue().isEmpty()) {
			setGuestHouse_Expenses(val_guestHouse_Expenses);
		}
		else{
			String guestHouse_ExpensesStr=formMap.getField("guestHouse_Expenses").getValue();
			val_guestHouse_Expenses= Double.parseDouble(guestHouse_ExpensesStr);
			setGuestHouse_Expenses(val_guestHouse_Expenses);
		}
		
		
		
		double val_club_Expenses=0.0d;
		if (formMap.getField("club_Expenses").getValue().isEmpty()) {
			setClub_Expenses(val_club_Expenses);
		}
		else{
			String club_ExpensesStr=formMap.getField("club_Expenses").getValue();
			val_club_Expenses= Double.parseDouble(club_ExpensesStr);
			setClub_Expenses(val_club_Expenses);
		} 
		double val_festivalCeleb_Expenses=0.0d; 
		if (formMap.getField("festivalCeleb_Expenses").getValue().isEmpty()){
			setFestivalCeleb_Expenses(val_festivalCeleb_Expenses);
		}
		else{
			String festivalCeleb_ExpensesStr=formMap.getField("festivalCeleb_Expenses").getValue();
			val_festivalCeleb_Expenses= Double.parseDouble(festivalCeleb_ExpensesStr);
			setFestivalCeleb_Expenses(val_festivalCeleb_Expenses);
		}
		double val_scholarship_PL=0.0d;
		if (formMap.getField("scholarship_PL").getValue().isEmpty()) {
			setScholarship_PL(val_scholarship_PL);
		}
		else{
			String scholarship_PLStr=formMap.getField("scholarship_PL").getValue();
			val_scholarship_PL= Double.parseDouble(scholarship_PLStr);
			setScholarship_PL(val_scholarship_PL);
		}
		
	
		double val_gifts_PL=0.0d;
		if (formMap.getField("gifts_PL").getValue().isEmpty()){
			setGifts_PL(val_gifts_PL);
		}
		else{
			String gifts_PLStr=formMap.getField("gifts_PL").getValue();
			val_gifts_PL= Double.parseDouble(gifts_PLStr);
			setGifts_PL(val_gifts_PL);
		}
		double val_donation_PL=0.0d;
		if (formMap.getField("donation_PL").getValue().isEmpty()){
			setDonation_PL(val_donation_PL);
		}
		else{
			String donation_PLStr=formMap.getField("donation_PL").getValue();
			val_donation_PL= Double.parseDouble(donation_PLStr);
			 setDonation_PL(val_donation_PL);
		}
		double val_union_ExciseDuty2=0.0d;
		if (formMap.getField("union_ExciseDuty2").getValue().isEmpty()){
			setUnion_ExciseDuty2(val_union_ExciseDuty2);
		}
		else{
			String union_ExciseDuty2Str=formMap.getField("union_ExciseDuty2").getValue();
			val_union_ExciseDuty2= Double.parseDouble(union_ExciseDuty2Str);
			setUnion_ExciseDuty2(val_union_ExciseDuty2);
		}
		double val_service_Tax2=0.0d;
		if (formMap.getField("service_Tax2").getValue().isEmpty()) {
			setService_Tax2(val_service_Tax2);
		}
		else{
			String service_Tax2Str=formMap.getField("service_Tax2").getValue();
			val_service_Tax2= Double.parseDouble(service_Tax2Str);
			setService_Tax2(val_service_Tax2);
		}
		double val_vat_Salestax2=0.0d;
		if (formMap.getField("vat_Salestax2").getValue().isEmpty()) {
			setVat_Salestax2(val_vat_Salestax2);
		}
		else{
			String vat_Salestax2Str=formMap.getField("vat_Salestax2").getValue();
			val_vat_Salestax2= Double.parseDouble(vat_Salestax2Str);
			setVat_Salestax2(val_vat_Salestax2);
		}
		double val_cess_PL=0.0d;
		if (formMap.getField("cess_PL").getValue().isEmpty()){
			setCess_PL(val_cess_PL);
		}
		else{
			String cess_PLStr=formMap.getField("cess_PL").getValue();
			val_cess_PL= Double.parseDouble(cess_PLStr);
			setCess_PL(val_cess_PL);
		}
		double val_anyOther_RateInclSTT=0.0d;
		if (formMap.getField("anyOther_RateInclSTT").getValue().isEmpty()){
			setAnyOther_RateInclSTT(val_anyOther_RateInclSTT);
		}
		else{
			String anyOther_RateInclSTTStr=formMap.getField("anyOther_RateInclSTT").getValue();
			val_anyOther_RateInclSTT= Double.parseDouble(anyOther_RateInclSTTStr);
			setAnyOther_RateInclSTT(val_anyOther_RateInclSTT);
		}
		double val_totalRates_TaxesPaid=0.0d;
		if (formMap.getField("totalRates_TaxesPaid").getValue().isEmpty()) {
			setTotalRates_TaxesPaid(val_totalRates_TaxesPaid);
		}
		else{
			String totalRates_TaxesPaidStr=formMap.getField("totalRates_TaxesPaid").getValue();
			val_totalRates_TaxesPaid= Double.parseDouble(totalRates_TaxesPaidStr);
			setTotalRates_TaxesPaid(val_totalRates_TaxesPaid);
		}
		double val_audit_Fee=0.0d;
		if (formMap.getField("audit_Fee").getValue().isEmpty()) {
			setAudit_Fee(val_audit_Fee);
		}
		else{
			String audit_FeeStr=formMap.getField("audit_Fee").getValue();
			val_audit_Fee= Double.parseDouble(audit_FeeStr);
			setAudit_Fee(val_audit_Fee);
		}
		double val_other_ExpensesStr=0.0d;
		if (formMap.getField("other_Expenses").getValue().isEmpty()) {
			setOther_Expenses(val_other_ExpensesStr);
		}
		else{
			String other_ExpensesStr=formMap.getField("other_Expenses").getValue();
			val_other_ExpensesStr= Double.parseDouble(other_ExpensesStr);
			setOther_Expenses(val_other_ExpensesStr);
		}
		double val_bad_Debts=0.0d;
		if (formMap.getField("bad_Debts").getValue().isEmpty()){
			setBad_Debts(val_bad_Debts);
		}
		else{
			String bad_DebtsStr=formMap.getField("bad_Debts").getValue();
			val_bad_Debts= Double.parseDouble(bad_DebtsStr);
			setBad_Debts(val_bad_Debts);
		}
         double val_bad_DoubtfulDebts=0.0d;
		if (formMap.getField("bad_DoubtfulDebts").getValue().isEmpty()){
			setBad_DoubtfulDebts(val_bad_DoubtfulDebts);
		}
		else{
			String bad_DoubtfulDebtsStr=formMap.getField("bad_DoubtfulDebts").getValue();
			val_bad_DoubtfulDebts= Double.parseDouble(bad_DoubtfulDebtsStr);
			setBad_DoubtfulDebts(val_bad_DoubtfulDebts);
		}
          double val_other_Provisions=0.0d;
		if (formMap.getField("other_Provisions").getValue().isEmpty()) {
			setOther_Provisions(val_other_Provisions);
		}
		else{
			String other_ProvisionsStr=formMap.getField("other_Provisions").getValue();
			val_other_Provisions= Double.parseDouble(other_ProvisionsStr);
			setOther_Provisions(val_other_Provisions);
		}
		double val_profitBefore_InterestTaxes=0.0d;
		if (formMap.getField("profitBefore_InterestTaxes").getValue().isEmpty()){
			setProfitBefore_InterestTaxes(val_profitBefore_InterestTaxes);
		}
		else{
			String profitBefore_InterestTaxesStr=formMap.getField("profitBefore_InterestTaxes").getValue();
			val_profitBefore_InterestTaxes= Double.parseDouble(profitBefore_InterestTaxesStr);
			setProfitBefore_InterestTaxes(val_profitBefore_InterestTaxes);
		}
		double val_interest_PL=0.0d;
		if (formMap.getField("interest_PL").getValue().isEmpty()) {
			setInterest_PL(val_interest_PL);
		}
		else{
			String interest_PLStr=formMap.getField("interest_PL").getValue();
			val_interest_PL= Double.parseDouble(interest_PLStr);
			setInterest_PL(val_interest_PL);
		} 
		double val_depreciation_PL=0.0d; 
		if (formMap.getField("depreciation_PL").getValue().isEmpty()){
			setDepreciation_PL(val_depreciation_PL);
		}
		else{
			String depreciation_PLStr=formMap.getField("depreciation_PL").getValue();
			val_depreciation_PL= Double.parseDouble(depreciation_PLStr);
			setDepreciation_PL(val_depreciation_PL);
		}
		double val_profit_BeforeTaxes=0.0d;
		if (formMap.getField("profit_BeforeTaxes").getValue().isEmpty()) {
			setProfit_BeforeTaxes(val_profit_BeforeTaxes);
		}
		else{
			String profit_BeforeTaxesStr=formMap.getField("profit_BeforeTaxes").getValue();
			val_profit_BeforeTaxes= Double.parseDouble(profit_BeforeTaxesStr);
			setProfit_BeforeTaxes(val_profit_BeforeTaxes);
		}
		double val_prov_CurrentTax=0.0d;
		if (formMap.getField("prov_CurrentTax").getValue().isEmpty()){
			setProv_CurrentTax(val_prov_CurrentTax);
		}
		else{
			String prov_CurrentTaxStr=formMap.getField("prov_CurrentTax").getValue();
			val_prov_CurrentTax= Double.parseDouble(prov_CurrentTaxStr);
			setProv_CurrentTax(val_prov_CurrentTax);
		}
		double val_prov_DeferredTax=0.0d;
		if (formMap.getField("prov_DeferredTax").getValue().isEmpty()){
			setProv_DeferredTax(val_prov_DeferredTax);
		}
		else{
			String prov_DeferredTaxStr=formMap.getField("prov_DeferredTax").getValue();
			val_prov_DeferredTax= Double.parseDouble(prov_DeferredTaxStr);
			 setProv_DeferredTax(val_prov_DeferredTax);
		}
		double val_profit_AfterTax=0.0d;
		if (formMap.getField("profit_AfterTax").getValue().isEmpty()){
			setProfit_AfterTax(val_profit_AfterTax);
		}
		else{
			String profit_AfterTaxStr=formMap.getField("profit_AfterTax").getValue();
			val_profit_AfterTax= Double.parseDouble(profit_AfterTaxStr);
			setProfit_AfterTax(val_profit_AfterTax);
		}
		double val_balance_PreviousYear=0.0d;
		log.info("pppppppppppppppppppppppppppppp"+formMap.getField("balance_PreviousYear"));
		log.info("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+formMap.getField("balance_PreviousYear").getValue());
		if (formMap.getField("balance_PreviousYear").getValue().isEmpty()) {
			setBalance_PreviousYear(val_balance_PreviousYear);
		}
		else{
			String balance_PreviousYearStr=formMap.getField("balance_PreviousYear").getValue();
			log.info("JJJJJJJJJJJJJJJJJJ"+balance_PreviousYearStr);
			val_balance_PreviousYear= Double.parseDouble(balance_PreviousYearStr);
			setBalance_PreviousYear(val_balance_PreviousYear);
		}
		double val_amount_Appropriation=0.0d;
		if (formMap.getField("amount_Appropriation").getValue().isEmpty()) {
			setAmount_Appropriation(val_amount_Appropriation);
		}
		else{
			String amount_AppropriationStr=formMap.getField("amount_Appropriation").getValue();
			val_amount_Appropriation= Double.parseDouble(amount_AppropriationStr);
			setAmount_Appropriation(val_amount_Appropriation);
		}
		double val_transReserves_Surplus=0.0d;
		if (formMap.getField("transReserves_Surplus").getValue().isEmpty()){
			setTransReserves_Surplus(val_transReserves_Surplus);
		}
		else{
			String transReserves_SurplusStr=formMap.getField("transReserves_Surplus").getValue();
			val_transReserves_Surplus= Double.parseDouble(transReserves_SurplusStr);
			setTransReserves_Surplus(val_transReserves_Surplus);
		}
		double val_balanceCarried_BalanceSheet=0.0d;
		if (formMap.getField("balanceCarried_BalanceSheet").getValue().isEmpty()){
			setBalanceCarried_BalanceSheet(val_balanceCarried_BalanceSheet);
		}
		else{
			String balanceCarried_BalanceSheetStr=formMap.getField("balanceCarried_BalanceSheet").getValue();
			val_balanceCarried_BalanceSheet= Double.parseDouble(balanceCarried_BalanceSheetStr);
			setBalanceCarried_BalanceSheet(val_balanceCarried_BalanceSheet);
		}
		double val_gross_Recepients=0.0d;
		if (formMap.getField("gross_Recepients").getValue().isEmpty()) {
			setGross_Recepients(val_gross_Recepients);
		}
		else{
			String gross_RecepientsStr=formMap.getField("gross_Recepients").getValue();
			val_gross_Recepients= Double.parseDouble(gross_RecepientsStr);
			setGross_Recepients(val_gross_Recepients);
		}
		double val_gross_Profit=0.0d;
		if (formMap.getField("gross_Profit").getValue().isEmpty()) {
			setGross_Profit(val_gross_Profit);	
		}
		else{
			String gross_ProfitStr=formMap.getField("gross_Profit").getValue();
			val_gross_Profit= Double.parseDouble(gross_ProfitStr);
			setGross_Profit(val_gross_Profit);
		}
		double val_expenses_NoAccount=0.0d;
		if (formMap.getField("expenses_NoAccount").getValue().isEmpty()) {
			setExpenses_NoAccount(val_expenses_NoAccount);
		}
		else{
			String expenses_NoAccountStr=formMap.getField("expenses_NoAccount").getValue();
			val_expenses_NoAccount= Double.parseDouble(expenses_NoAccountStr);
			setExpenses_NoAccount(val_expenses_NoAccount);
		}
		double val_net_Profit=0.0d;
		if (formMap.getField("net_Profit").getValue().isEmpty()) {
			setNet_Profit(val_net_Profit);
		}
		else{
			String net_ProfitStr=formMap.getField("net_Profit").getValue();
			val_net_Profit= Double.parseDouble(net_ProfitStr);
			setNet_Profit(val_net_Profit);
		}
		
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
	
	
}
