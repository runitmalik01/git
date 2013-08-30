
/**
 * 
 * User: pankaj
 * Date: 
 * 
 */


package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;

public abstract class ProfitAndLossVariables extends BaseDocument implements ContentNodeBinder, FormMapFiller{
	
	private Double sales_GrossBusiness;
	private Double union_ExciseDuties;
	private Double service_Tax;
	private Double vat_SalesTax;
	private Double any_OtherTax;
	private Double total_DutyTaxCess;
	private Double rent;
	private Double commission;
	private Double dividend;
	private Double interest;
	private Double profit_FixedAsset;
	private Double profit_InvestmentSTT;
	private Double profit_OtherInvestment;
	private Double profit_CurrencyFluctuation;
	private Double agricultural_Income;
	private Double any_OtherIncome;
	private Double total_OtherIncome;
	private Double closing_Stocks;
	private Double total_CreditAccount;
	private Double opening_Stocks;
	private Double purchases;
	private Double custom_Duty;
	private Double counter_vailingDuty;
	private Double special_addtionalDuty;
	private Double union_ExciseDuty;
	private Double service_TaxPL;
	private Double anyOther_TaxPaid;
	private Double total;
	private Double freight;
	private Double consumption_Stores;
	private Double power_Fuels;
	private Double rents_PL;
	
	private Double repairs_Buildings;
	private Double repairs_Machinery;
	private Double salaries_Wages;
	private Double bonus_PL;
	private Double reimbursement_MedicalExpenses;
	private Double leave_Encasement;
	private Double leave_TravelBenefits;
	private Double approved_SuperannuationFund;
	private Double recog_ProvidendFund;
	private Double recog_GratuityFund;
	private Double any_OtherFund;
	private Double any_otherBenefit;
	private Double total_Compensation;
	private Double medical_Insurance;
	private Double life_Insurance;
	private Double keyman_Insurance;
	private Double other_Insurance;
	private Double totalExpense_Insurance;
	private Double staff_WelfareExpense;
	private Double entertainment_PL;
	private Double hospitality_PL;
	private Double club_Expenses;
	private Double festivalCeleb_Expenses;
	private Double scholarship_PL;
	private Double gifts_PL;
	private Double donation_PL;
	private Double union_ExciseDuty2;
	private Double service_Tax2;
	private Double vat_Salestax2;
	private Double cess_PL;
	private Double anyOther_RateInclSTT;
	private Double totalRates_TaxesPaid;
	
	private Double audit_Fee;
	private Double other_Expenses;
	private Double bad_Debts;
	private Double bad_DoubtfulDebts;
	private Double other_Provisions;
	private Double profitBefore_InterestTaxes;
	private Double interest_PL;
	private Double depreciation_PL;
	private Double profit_BeforeTaxes;
	private Double prov_CurrentTax;
	private Double prov_DeferredTax;
	private Double profit_AfterTax;
	private Double balance_PreviousYear;
	private Double amount_Appropriation;
	private Double transReserves_Surplus;
	private Double balanceCarried_BalanceSheet;
	private Double gross_Recepients;
	private Double gross_Profit;
	private Double expenses_NoAccount;
	private Double net_Profit;
	
	
	
	//for personal information
	public  Double getSales_GrossBusiness() {
		if (sales_GrossBusiness == null) sales_GrossBusiness = getProperty("mootlywcm:sales_GrossBusiness");
		return sales_GrossBusiness;
	}
	public  Double getUnion_ExciseDuties() {
		if (union_ExciseDuties == null) union_ExciseDuties = getProperty("mootlywcm:union_ExciseDuties");
		return union_ExciseDuties;
	}
	public  Double getservice_Tax() {
		if (service_Tax == null) service_Tax = getProperty("mootlywcm:service_Tax");
		return service_Tax;
	}
	public  Double getVat_SalesTax() {
		if (vat_SalesTax == null) vat_SalesTax = getProperty("mootlywcm:vat_SalesTax");
		return vat_SalesTax;
	}
	public  Double getAny_OtherTax() {
		if (any_OtherTax == null) any_OtherTax = getProperty("mootlywcm:any_OtherTax");
		return any_OtherTax;
	}
	public  Double getTotal_DutyTaxCess() {
		if (total_DutyTaxCess == null) total_DutyTaxCess = getProperty("mootlywcm:total_DutyTaxCess");
		return total_DutyTaxCess;
	}
	public  Double getRent() {
		if (rent == null) rent = getProperty("mootlywcm:rent");
		return rent;
	}
	public  Double getCommission() {
		if (commission == null) commission = getProperty("mootlywcm:commission");
		return commission;
	}
	public Double getInterest() {
		if (interest == null) interest = getProperty("mootlywcm:interest");
		return interest;
	}
	public  Double getDividends() {
		if (dividend== null) dividend = getProperty("mootlywcm:dividend");
		return dividend;
	}
	public  Double getProfit_FixedAsset() {
		if (profit_FixedAsset== null) profit_FixedAsset = getProperty("mootlywcm:profit_FixedAsset");
		return profit_FixedAsset;
	}
	public  Double getProfit_InvestmentSTT() {
		if (profit_InvestmentSTT== null) profit_InvestmentSTT = getProperty("mootlywcm:profit_InvestmentSTT");
		return profit_InvestmentSTT;
	}
	public  Double getProfit_OtherInvestment() {
		if (profit_OtherInvestment== null) profit_OtherInvestment = getProperty("mootlywcm:profit_OtherInvestment");
		return profit_OtherInvestment;
	}
	public  Double getProfit_CurrencyFluctuation() {
		if (profit_CurrencyFluctuation== null) profit_CurrencyFluctuation = getProperty("mootlywcm:profit_CurrencyFluctuation");
		return profit_CurrencyFluctuation;
	}

	public  Double getAgricultural_Income() {
		if (agricultural_Income== null) agricultural_Income = getProperty("mootlywcm:agricultural_Income");
		return agricultural_Income;
	}
	public  Double getAny_OtherIncome() {
		if (any_OtherIncome== null) any_OtherIncome = getProperty("mootlywcm:any_OtherIncome");
		return any_OtherIncome;
	}
	public  Double getTotal_OtherIncome() {
		if (total_OtherIncome== null) total_OtherIncome = getProperty("mootlywcm:total_OtherIncome");
		return total_OtherIncome;
	}
	public  Double getClosing_Stocks() {
		if (closing_Stocks== null) closing_Stocks = getProperty("mootlywcm:closing_Stocks");
		return closing_Stocks;
	}
	public  Double getTotal_CreditAccount() {
		if (total_CreditAccount== null) total_CreditAccount = getProperty("mootlywcm:total_CreditAccount");
		return total_CreditAccount;
	}
	public  Double getOpening_Stocks() {
		if (opening_Stocks== null) opening_Stocks = getProperty("mootlywcm:opening_Stocks");
		return opening_Stocks;
	}
	public  Double getPurchases() {
		if (purchases== null) purchases = getProperty("mootlywcm:purchases");
		return purchases;
	}
	public  Double getCustom_Duty() {
		if (custom_Duty== null) custom_Duty = getProperty("mootlywcm:custom_Duty");
		return custom_Duty;
	}
	public  Double getCounter_vailingDuty() {
		if (counter_vailingDuty== null) counter_vailingDuty = getProperty("mootlywcm:counter_vailingDuty");
		return counter_vailingDuty;
	}
	public  Double getSpecial_addtionalDuty() {
		if (special_addtionalDuty== null) special_addtionalDuty = getProperty("mootlywcm:special_addtionalDuty");
		return special_addtionalDuty;
	}
	public  Double getUnion_ExciseDuty() {
		if (union_ExciseDuty== null) union_ExciseDuty = getProperty("mootlywcm:union_ExciseDuty");
		return union_ExciseDuty;
	}
	public  Double getService_TaxPL() {
		if (service_TaxPL== null) service_TaxPL = getProperty("mootlywcm:service_TaxPL");
		return service_TaxPL;
	}
	public  Double getAnyOther_TaxPaid() {
		if (anyOther_TaxPaid== null) anyOther_TaxPaid = getProperty("mootlywcm:anyOther_TaxPaid");
		return anyOther_TaxPaid;
	}
	public  Double getTotal() {
		if (total== null) total = getProperty("mootlywcm:total");
		return total;
	}
	public  Double getFreight() {
		if (freight== null) freight = getProperty("mootlywcm:freight");
		return freight;
	}
	public  Double getConsumption_Stores() {
		if (consumption_Stores== null) consumption_Stores = getProperty("mootlywcm:consumption_Stores");
		return consumption_Stores;
	}
	public  Double getPower_Fuels() {
		if (power_Fuels== null) power_Fuels = getProperty("mootlywcm:power_Fuels");
		return power_Fuels;
	}
	public  Double getRents_PL() {
		if (rents_PL== null) rents_PL = getProperty("mootlywcm:rents_PL");
		return rents_PL;
	}
	public  Double getRepairs_Buildings() {
		if (repairs_Buildings== null) repairs_Buildings = getProperty("mootlywcm:repairs_Buildings");
		return repairs_Buildings;
	}
	public  Double getRepairs_Machinery() {
		if (repairs_Machinery== null) repairs_Machinery = getProperty("mootlywcm:repairs_Machinery");
		return repairs_Machinery;
	}
	public  Double getSalaries_Wages() {
		if (salaries_Wages== null) salaries_Wages = getProperty("mootlywcm:salaries_Wages");
		return salaries_Wages;
	}
	public  Double getBonus_PL() {
		if (bonus_PL== null) bonus_PL = getProperty("mootlywcm:bonus_PL");
		return bonus_PL;
	}
	public  Double getReimbursement_MedicalExpenses() {
		if (reimbursement_MedicalExpenses== null) reimbursement_MedicalExpenses = getProperty("mootlywcm:reimbursement_MedicalExpenses");
		return reimbursement_MedicalExpenses;
	}
	public  Double getLeave_Encasement() {
		if (leave_Encasement== null) leave_Encasement = getProperty("mootlywcm:leave_Encasement");
		return leave_Encasement;
	}
	public  Double getLeave_TravelBenefits() {
		if (leave_TravelBenefits== null) leave_TravelBenefits = getProperty("mootlywcm:leave_TravelBenefits");
		return leave_TravelBenefits;
	}
	public  Double getApproved_SuperannuationFund() {
		if (approved_SuperannuationFund== null) approved_SuperannuationFund = getProperty("mootlywcm:approved_SuperannuationFund");
		return approved_SuperannuationFund;
	}
	public  Double getRecog_ProvidendFund() {
		if (recog_ProvidendFund== null) recog_ProvidendFund = getProperty("mootlywcm:recog_ProvidendFund");
		return recog_ProvidendFund;
	}
	public  Double getRecog_GratuityFund() {
		if (recog_GratuityFund== null) recog_GratuityFund = getProperty("mootlywcm:recog_GratuityFund");
		return recog_GratuityFund;
	}
	public  Double getAny_OtherFund() {
		if (any_OtherFund== null) any_OtherFund = getProperty("mootlywcm:any_OtherFund");
		return any_OtherFund;
	}
	public  Double getAny_otherBenefit() {
		if (any_otherBenefit== null) any_otherBenefit = getProperty("mootlywcm:any_otherBenefit");
		return any_otherBenefit;
	}
	public  Double getTotal_Compensation() {
		if (total_Compensation== null) total_Compensation = getProperty("mootlywcm:total_Compensation");
		return total_Compensation;
	}
	public  Double getMedical_Insurance() {
		if (medical_Insurance== null) medical_Insurance = getProperty("mootlywcm:medical_Insurance");
		return medical_Insurance;
	}
	public  Double getLife_Insurance() {
		if (life_Insurance== null) life_Insurance = getProperty("mootlywcm:life_Insurance");
		return life_Insurance;
	}
	public  Double getKeyman_Insurance() {
		if (keyman_Insurance== null) keyman_Insurance = getProperty("mootlywcm:keyman_Insurance");
		return keyman_Insurance;
	}
	public  Double getOther_Insurance() {
		if (other_Insurance== null) other_Insurance = getProperty("mootlywcm:other_Insurance");
		return other_Insurance;
	}
	public  Double getTotalExpense_Insurance() {
		if (totalExpense_Insurance == null) totalExpense_Insurance = getProperty("mootlywcm:totalExpense_Insurance");
		return totalExpense_Insurance;
	}
	public  Double getStaff_WelfareExpense() {
		if (staff_WelfareExpense == null) staff_WelfareExpense = getProperty("mootlywcm:staff_WelfareExpense");
		return staff_WelfareExpense;
	}
	public  Double getEntertainment_PL() {
		if (entertainment_PL == null) entertainment_PL = getProperty("mootlywcm:entertainment_PL");
		return entertainment_PL;
	}
	public  Double getHospitality_PL() {
		if (hospitality_PL == null) hospitality_PL = getProperty("mootlywcm:hospitality_PL");
		return hospitality_PL;
	}
	public  Double getClub_Expenses() {
		if (club_Expenses == null) club_Expenses = getProperty("mootlywcm:club_Expenses");
		return club_Expenses;
	}
	public  Double getFestivalCeleb_Expenses() {
		if (festivalCeleb_Expenses == null) festivalCeleb_Expenses = getProperty("mootlywcm:festivalCeleb_Expenses");
		return festivalCeleb_Expenses;
	}
	public  Double getScholarship_PL() {
		if (scholarship_PL == null) scholarship_PL = getProperty("mootlywcm:scholarship_PL");
		return scholarship_PL;
	}
	public Double getGifts_PL() {
		if (gifts_PL == null) gifts_PL = getProperty("mootlywcm:gifts_PL");
		return gifts_PL;
	}
	public  Double getDonation_PL() {
		if (donation_PL== null) donation_PL = getProperty("mootlywcm:donation_PL");
		return donation_PL;
	}
	public  Double getUnion_ExciseDuty2() {
		if (union_ExciseDuty2== null) union_ExciseDuty2 = getProperty("mootlywcm:union_ExciseDuty2");
		return union_ExciseDuty2;
	}
	public  Double getService_Tax2() {
		if (service_Tax2== null) service_Tax2 = getProperty("mootlywcm:service_Tax2");
		return service_Tax2;
	}
	public  Double getVat_Salestax2() {
		if (vat_Salestax2== null) vat_Salestax2 = getProperty("mootlywcm:vat_Salestax2");
		return vat_Salestax2;
	}
	public  Double getCess_PL() {
		if (cess_PL== null) cess_PL = getProperty("mootlywcm:cess_PL");
		return cess_PL;
	}

	public  Double getAnyOther_RateInclSTT() {
		if (anyOther_RateInclSTT== null) anyOther_RateInclSTT = getProperty("mootlywcm:anyOther_RateInclSTT");
		return anyOther_RateInclSTT;
	}
	public  Double getTotalRates_TaxesPaid() {
		if (totalRates_TaxesPaid== null) totalRates_TaxesPaid = getProperty("mootlywcm:totalRates_TaxesPaid");
		return totalRates_TaxesPaid;
	}
	public  Double getAudit_Fee() {
		if (audit_Fee== null) audit_Fee = getProperty("mootlywcm:audit_Fee");
		return audit_Fee;
	}
	public  Double getBad_Debts() {
		if (bad_Debts== null) bad_Debts = getProperty("mootlywcm:bad_Debts");
		return bad_Debts;
	}
	public  Double getBad_DoubtfulDebts() {
		if (bad_DoubtfulDebts== null) bad_DoubtfulDebts = getProperty("mootlywcm:bad_DoubtfulDebts");
		return bad_DoubtfulDebts;
	}
	public  Double getOther_Provisions() {
		if (other_Provisions== null) other_Provisions = getProperty("mootlywcm:other_Provisions");
		return other_Provisions;
	}
	public  Double getProfitBefore_InterestTaxes() {
		if (profitBefore_InterestTaxes== null) profitBefore_InterestTaxes = getProperty("mootlywcm:profitBefore_InterestTaxes");
		return profitBefore_InterestTaxes;
	}
	public  Double getInterest_PL() {
		if (interest_PL== null) interest_PL = getProperty("mootlywcm:custom_Duty");
		return interest_PL;
	}
	public  Double getDepreciation_PL() {
		if (depreciation_PL== null) depreciation_PL = getProperty("mootlywcm:depreciation_PL");
		return depreciation_PL;
	}
	public  Double getProfit_BeforeTaxes() {
		if (profit_BeforeTaxes== null) profit_BeforeTaxes = getProperty("mootlywcm:profit_BeforeTaxes");
		return profit_BeforeTaxes;
	}
	public  Double getProv_CurrentTax() {
		if (prov_CurrentTax== null) prov_CurrentTax = getProperty("mootlywcm:prov_CurrentTax");
		return prov_CurrentTax;
	}
	public  Double getProv_DeferredTax() {
		if (prov_DeferredTax== null) prov_DeferredTax = getProperty("mootlywcm:prov_DeferredTax");
		return prov_DeferredTax;
	}
	public  Double getProfit_AfterTax() {
		if (profit_AfterTax== null) profit_AfterTax = getProperty("mootlywcm:profit_AfterTax");
		return profit_AfterTax;
	}
	public  Double getBalance_PreviousYear() {
		if (balance_PreviousYear== null) balance_PreviousYear = getProperty("mootlywcm:balance_PreviousYear");
		return balance_PreviousYear;
	}
	public  Double getAmount_Appropriation() {
		if (amount_Appropriation== null) amount_Appropriation = getProperty("mootlywcm:amount_Appropriation");
		return amount_Appropriation;
	}
	public  Double getTransReserves_Surplus() {
		if (transReserves_Surplus== null) transReserves_Surplus = getProperty("mootlywcm:transReserves_Surplus");
		return transReserves_Surplus;
	}
	public  Double getBalanceCarried_BalanceSheet() {
		if (balanceCarried_BalanceSheet== null) balanceCarried_BalanceSheet = getProperty("mootlywcm:balanceCarried_BalanceSheet");
		return balanceCarried_BalanceSheet;
	}
	public  Double getGross_Recepients() {
		if (gross_Recepients== null) gross_Recepients = getProperty("mootlywcm:gross_Recepients");
		return gross_Recepients;
	}
	public  Double getGross_Profit() {
		if (gross_Profit== null) gross_Profit = getProperty("mootlywcm:gross_Profit");
		return gross_Profit;
	}
	public  Double getExpenses_NoAccount() {
		if (expenses_NoAccount== null) expenses_NoAccount = getProperty("mootlywcm:expenses_NoAccount");
		return expenses_NoAccount;
	}
	public  Double getNet_Profit() {
		if (net_Profit== null) net_Profit = getProperty("mootlywcm:net_Profit");
		return net_Profit;
	}
	
	// set method for otherincome document

	public final void  setSales_GrossBusiness(Double sales_GrossBusiness) {
		this.sales_GrossBusiness = sales_GrossBusiness;
	}
	public final void setUnion_ExciseDuties(Double union_ExciseDuties) {
		this.union_ExciseDuties = union_ExciseDuties;
	}
	public final void setService_Tax(Double service_Tax) {
		this.service_Tax = service_Tax;
	}
	public final void setVat_SalesTax(Double vat_SalesTax) {
		this.vat_SalesTax = vat_SalesTax;
	}
	public final void setAny_OtherTax(Double any_OtherTax) {
		this.any_OtherTax = any_OtherTax;
	}
	public final void setTotal_DutyTaxCess(Double total_DutyTaxCess) {
		this.total_DutyTaxCess = total_DutyTaxCess;
	}
	public final void setRent(Double rent) {
		this.rent = rent;
	}
	public final void setCommission(Double commission) {
		this.commission = commission;
	}
	public void setDividend(Double dividend) {
		this.dividend = dividend;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public void setProfit_FixedAsset(Double profit_FixedAsset) {
		this.profit_FixedAsset = profit_FixedAsset;
	}
	public final void setProfit_InvestmentSTT(Double profit_InvestmentSTT) {
		this.profit_InvestmentSTT = profit_InvestmentSTT;
	}
	
	public void setProfit_OtherInvestment(Double profit_OtherInvestment) {
		this.profit_OtherInvestment = profit_OtherInvestment;
	}
	public final void setProfit_CurrencyFluctuation(Double profit_CurrencyFluctuation) {
		this.profit_CurrencyFluctuation = profit_CurrencyFluctuation;
	}
	public void setAgricultural_Income(Double agricultural_Income) {
		this.agricultural_Income = agricultural_Income;
	}
	public void setAny_OtherIncome(Double any_OtherIncome) {
		this.any_OtherIncome = any_OtherIncome;
	}
	public void setTotal_OtherIncome(Double total_OtherIncome) {
		this.total_OtherIncome = total_OtherIncome;
	}
	public void setOther_Expenses(Double other_Expenses) {
		this.other_Expenses = other_Expenses;
	}
	public void setTotal_CreditAccount(Double total_CreditAccount) {
		this.total_CreditAccount = total_CreditAccount;
	}
	public void setOpening_Stocks(Double opening_Stocks) {
		this.opening_Stocks = opening_Stocks;
	}
	public void setPurchases(Double purchases) {
		this.purchases = purchases;
	}
	public void setCustom_Duty(Double custom_Duty) {
		this.custom_Duty = custom_Duty;
	}
	public void setCounter_vailingDuty(Double counter_vailingDuty) {
		this.counter_vailingDuty = counter_vailingDuty;
	}
	public void setSpecial_addtionalDuty(Double special_addtionalDuty) {
		this.special_addtionalDuty = special_addtionalDuty;
	}
	public void setUnion_ExciseDuty(Double union_ExciseDuty) {
		this.union_ExciseDuty = union_ExciseDuty;
	}
	public void setService_TaxPL(Double service_TaxPL) {
		this.service_TaxPL = service_TaxPL;
	}
	public void setAnyOther_TaxPaid(Double anyOther_TaxPaid) {
		this.anyOther_TaxPaid = anyOther_TaxPaid;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public void setConsumption_Stores(Double consumption_Stores) {
		this.consumption_Stores = consumption_Stores;
	}
	public void setRepairs_Buildings(Double repairs_Buildings) {
		this.repairs_Buildings = repairs_Buildings;
	}
	public void setRents_PL(Double rents_PL) {
		this.rents_PL = rents_PL;
	}
	public void setRepairs_Machinery(Double repairs_Machinery) {
		this.repairs_Machinery = repairs_Machinery;
	}
	public void setSalaries_Wages(Double salaries_Wages) {
		this.salaries_Wages = salaries_Wages;
	}
	public void setBonus_PL(Double bonus_PL) {
		this.bonus_PL = bonus_PL;
	}
	public void setPower_Fuels(Double power_Fuels) {
		this.power_Fuels = power_Fuels;
	}
	public void setReimbursement_MedicalExpenses(Double reimbursement_MedicalExpenses) {
		this.reimbursement_MedicalExpenses = reimbursement_MedicalExpenses;
	}
	public void setLeave_Encasement(Double leave_Encasement) {
		this.leave_Encasement = leave_Encasement;
	}
	public void setLeave_TravelBenefits(Double leave_TravelBenefits) {
		this.leave_TravelBenefits = leave_TravelBenefits;
	}
	public void setApproved_SuperannuationFund(Double approved_SuperannuationFund) {
		this.approved_SuperannuationFund = approved_SuperannuationFund;
	}
	public void setRecog_ProvidendFund(Double recog_ProvidendFund) {
		this.recog_ProvidendFund = recog_ProvidendFund;
	}
	public void setRecog_GratuityFund(Double recog_GratuityFund) {
		this.recog_GratuityFund = recog_GratuityFund;
	}
	public void setAny_OtherFund(Double any_OtherFund) {
		this.any_OtherFund = any_OtherFund;
	}
	public void setAny_otherBenefit(Double any_otherBenefit) {
		this.any_otherBenefit = any_otherBenefit;
	}
	public void setTotal_Compensation(Double total_Compensation) {
		this.total_Compensation = total_Compensation;
	}
	public void setMedical_Insurance(Double medical_Insurance) {
		this.medical_Insurance = medical_Insurance;
	}
	public void setLife_Insurance(Double life_Insurance) {
		this.life_Insurance = life_Insurance;
	}
	public void setKeyman_Insurance(Double keyman_Insurance) {
		this.keyman_Insurance = keyman_Insurance;
	}
	public void setOther_Insurance(Double other_Insurance) {
		this.other_Insurance = other_Insurance;
	}
	
	public final void setTotalExpense_Insurance(Double totalExpense_Insurance) {
		this.totalExpense_Insurance = totalExpense_Insurance;
	}
	public final void setStaff_WelfareExpense(Double staff_WelfareExpense) {
		this.staff_WelfareExpense = staff_WelfareExpense;
	}
	public final void setEntertainment_PL(Double entertainment_PL) {
		this.entertainment_PL = entertainment_PL;
	}
	public final void setHospitality_PL(Double hospitality_PL) {
		this.hospitality_PL = hospitality_PL;
	}
	public final void setClub_Expenses(Double club_Expenses) {
		this.club_Expenses = club_Expenses;
	}
	public final void setFestivalCeleb_Expenses(Double festivalCeleb_Expenses) {
		this.festivalCeleb_Expenses = festivalCeleb_Expenses;
	}
	public final void setScholarship_PL(Double scholarship_PL) {
		this.scholarship_PL = scholarship_PL;
	}
	public void setGifts_PL(Double gifts_PL) {
		this.gifts_PL = gifts_PL;
	}
	public void setDonation_PL(Double donation_PL) {
		this.donation_PL = donation_PL;
	}
	public void setUnion_ExciseDuty2(Double union_ExciseDuty2) {
		this.union_ExciseDuty2 = union_ExciseDuty2;
	}
	public final void setService_Tax2(Double service_Tax2) {
		this.service_Tax2 = service_Tax2;
	}
	
	public void setVat_Salestax2(Double vat_Salestax2) {
		this.vat_Salestax2 = vat_Salestax2;
	}
	public final void setCess_PL(Double cess_PL) {
		this.cess_PL = cess_PL;
	}
	public void setAnyOther_RateInclSTT(Double anyOther_RateInclSTT) {
		this.anyOther_RateInclSTT = anyOther_RateInclSTT;
	}
	public void setTotalRates_TaxesPaid(Double totalRates_TaxesPaid) {
		this.totalRates_TaxesPaid = totalRates_TaxesPaid;
	}
	public void setAudit_Fee(Double audit_Fee) {
		this.audit_Fee = audit_Fee;
	}
	
	// doubt in above method
	public void setBad_Debts(Double bad_Debts) {
		this.bad_Debts = bad_Debts;
	}
	public void setBad_DoubtfulDebts(Double bad_DoubtfulDebts) {
		this.bad_DoubtfulDebts = bad_DoubtfulDebts;
	}
	public void setOther_Provisions(Double other_Provisions) {
		this.other_Provisions = other_Provisions;
	}
	public void setProfitBefore_InterestTaxes(Double profitBefore_InterestTaxes) {
		this.profitBefore_InterestTaxes = profitBefore_InterestTaxes;
	}
	public void setInterest_PL(Double interest_PL) {
		this.interest_PL = interest_PL;
	}
	public void setDepreciation_PL(Double depreciation_PL) {
		this.depreciation_PL = depreciation_PL;
	}
	public void setProfit_BeforeTaxes(Double profit_BeforeTaxes) {
		this.profit_BeforeTaxes = profit_BeforeTaxes;
	}
	public void setProv_CurrentTax(Double prov_CurrentTax) {
		this.prov_CurrentTax = prov_CurrentTax;
	}
	public void setProv_DeferredTax(Double prov_DeferredTax) {
		this.prov_DeferredTax = prov_DeferredTax;
	}
	public void setProfit_AfterTax(Double profit_AfterTax) {
		this.profit_AfterTax = profit_AfterTax;
	}
	public void setBalance_PreviousYear(Double balance_PreviousYear) {
		this.balance_PreviousYear = balance_PreviousYear;
	}
	public void setAmount_Appropriation(Double amount_Appropriation) {
		this.amount_Appropriation = amount_Appropriation;
	}
	public void setTransReserves_Surplus(Double transReserves_Surplus) {
		this.transReserves_Surplus = transReserves_Surplus;
	}
	public void setBalanceCarried_BalanceSheet(Double balanceCarried_BalanceSheet) {
		this.balanceCarried_BalanceSheet = balanceCarried_BalanceSheet;
	}
	public void setGross_Recepients(Double gross_Recepients) {
		this.gross_Recepients = gross_Recepients;
	}
	
	public void setGross_Profit(Double gross_Profit) {
		this.gross_Profit = gross_Profit;
	}
	public void setExpenses_NoAccount(Double expenses_NoAccount) {
		this.expenses_NoAccount = expenses_NoAccount;
	}
	public void setClosing_Stocks(Double closing_Stocks) {
		this.closing_Stocks = closing_Stocks;
	}
	public void setNet_Profit(Double net_Profit) {
		this.net_Profit = net_Profit;
	}
	
	
	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub   
		try{
		ProfitAndLossDocument objProfitAndLossDocument= (ProfitAndLossDocument) content;
		node.setProperty("mootlywcm:sales_GrossBusiness",objProfitAndLossDocument.getSales_GrossBusiness());
		node.setProperty("mootlywcm:union_ExciseDuties", objProfitAndLossDocument.getUnion_ExciseDuties());
		node.setProperty("mootlywcm:service_Tax", objProfitAndLossDocument.getservice_Tax());
		node.setProperty("mootlywcm:vat_SalesTax", objProfitAndLossDocument.getVat_SalesTax());
		node.setProperty("mootlywcm:any_OtherTax", objProfitAndLossDocument.getAny_OtherTax());
		node.setProperty("mootlywcm:total_DutyTaxCess", objProfitAndLossDocument.getTotal_DutyTaxCess());
		node.setProperty("mootlywcm:rent", objProfitAndLossDocument.getRent());
		node.setProperty("mootlywcm:commission", objProfitAndLossDocument.getCommission());
		node.setProperty("mootlywcm:dividend", objProfitAndLossDocument.getDividends());
		node.setProperty("mootlywcm:interest", objProfitAndLossDocument.getInterest());
		node.setProperty("mootlywcm:profit_FixedAsset", objProfitAndLossDocument.getProfit_FixedAsset());
		node.setProperty("mootlywcm:profit_InvestmentSTT", objProfitAndLossDocument.getProfit_InvestmentSTT());
		node.setProperty("mootlywcm:profit_OtherInvestment", objProfitAndLossDocument.getProfit_OtherInvestment());
		node.setProperty("mootlywcm:profit_CurrencyFluctuation", objProfitAndLossDocument.getProfit_CurrencyFluctuation());
		node.setProperty("mootlywcm:agricultural_Income", objProfitAndLossDocument.getAgricultural_Income());
		node.setProperty("mootlywcm:any_OtherIncome", objProfitAndLossDocument.getAny_OtherIncome());
		node.setProperty("mootlywcm:total_OtherIncome", objProfitAndLossDocument.getTotal_OtherIncome());
		node.setProperty("mootlywcm:closing_Stocks", objProfitAndLossDocument.getClosing_Stocks());
		node.setProperty("mootlywcm:total_CreditAccount", objProfitAndLossDocument.getTotal_CreditAccount());
		node.setProperty("mootlywcm:opening_Stocks", objProfitAndLossDocument.getOpening_Stocks());
		node.setProperty("mootlywcm:purchases", objProfitAndLossDocument.getPurchases());
		node.setProperty("mootlywcm:custom_Duty", objProfitAndLossDocument.getCustom_Duty());
		node.setProperty("mootlywcm:counter_vailingDuty", objProfitAndLossDocument.getCounter_vailingDuty());
		node.setProperty("mootlywcm:special_addtionalDuty", objProfitAndLossDocument.getSpecial_addtionalDuty());
		node.setProperty("mootlywcm:union_ExciseDuty", objProfitAndLossDocument.getUnion_ExciseDuty());
		node.setProperty("mootlywcm:service_TaxPL", objProfitAndLossDocument.getService_TaxPL());
		node.setProperty("mootlywcm:anyOther_TaxPaid", objProfitAndLossDocument.getAnyOther_TaxPaid());
		node.setProperty("mootlywcm:total", objProfitAndLossDocument.getTotal());
		
		node.setProperty("mootlywcm:freight",objProfitAndLossDocument.getFreight());
		node.setProperty("mootlywcm:consumption_Stores", objProfitAndLossDocument.getConsumption_Stores());
		node.setProperty("mootlywcm:power_Fuels", objProfitAndLossDocument.getPower_Fuels());
		node.setProperty("mootlywcm:rents_PL", objProfitAndLossDocument.getRents_PL());
		node.setProperty("mootlywcm:repairs_Buildings", objProfitAndLossDocument.getRepairs_Buildings());
		node.setProperty("mootlywcm:repairs_Machinery", objProfitAndLossDocument.getRepairs_Machinery());
		node.setProperty("mootlywcm:salaries_Wages", objProfitAndLossDocument.getSalaries_Wages());
		node.setProperty("mootlywcm:bonus_PL", objProfitAndLossDocument.getBonus_PL());
		node.setProperty("mootlywcm:reimbursement_MedicalExpenses", objProfitAndLossDocument.getReimbursement_MedicalExpenses());
		node.setProperty("mootlywcm:leave_Encasement", objProfitAndLossDocument.getLeave_Encasement());
		node.setProperty("mootlywcm:leave_TravelBenefits", objProfitAndLossDocument.getLeave_TravelBenefits());
		node.setProperty("mootlywcm:approved_SuperannuationFund", objProfitAndLossDocument.getApproved_SuperannuationFund());
		node.setProperty("mootlywcm:recog_ProvidendFund", objProfitAndLossDocument.getRecog_ProvidendFund());
		node.setProperty("mootlywcm:recog_GratuityFund", objProfitAndLossDocument.getRecog_GratuityFund());
		node.setProperty("mootlywcm:any_OtherFund", objProfitAndLossDocument.getAny_OtherFund());
		node.setProperty("mootlywcm:any_otherBenefit", objProfitAndLossDocument.getAny_otherBenefit());
		node.setProperty("mootlywcm:total_Compensation", objProfitAndLossDocument.getTotal_Compensation());
		node.setProperty("mootlywcm:medical_Insurance", objProfitAndLossDocument.getMedical_Insurance());
		node.setProperty("mootlywcm:life_Insurance", objProfitAndLossDocument.getLife_Insurance());
		node.setProperty("mootlywcm:keyman_Insurance", objProfitAndLossDocument.getKeyman_Insurance());
		node.setProperty("mootlywcm:other_Insurance", objProfitAndLossDocument.getOther_Insurance());
		node.setProperty("mootlywcm:totalExpense_Insurance", objProfitAndLossDocument.getTotalExpense_Insurance());
		node.setProperty("mootlywcm:staff_WelfareExpense", objProfitAndLossDocument.getStaff_WelfareExpense());
		node.setProperty("mootlywcm:entertainment_PL", objProfitAndLossDocument.getEntertainment_PL());
		node.setProperty("mootlywcm:hospitality_PL", objProfitAndLossDocument.getHospitality_PL());
		node.setProperty("mootlywcm:club_Expenses", objProfitAndLossDocument.getClub_Expenses());
		node.setProperty("mootlywcm:festivalCeleb_Expenses", objProfitAndLossDocument.getFestivalCeleb_Expenses());
		node.setProperty("mootlywcm:scholarship_PL", objProfitAndLossDocument.getScholarship_PL());
		
		node.setProperty("mootlywcm:gifts_PL",objProfitAndLossDocument.getGifts_PL());
		node.setProperty("mootlywcm:donation_PL", objProfitAndLossDocument.getDonation_PL());
		node.setProperty("mootlywcm:union_ExciseDuty2", objProfitAndLossDocument.getUnion_ExciseDuty2());
		node.setProperty("mootlywcm:service_Tax2", objProfitAndLossDocument.getService_Tax2());
		node.setProperty("mootlywcm:vat_Salestax2", objProfitAndLossDocument.getVat_Salestax2());
		node.setProperty("mootlywcm:cess_PL", objProfitAndLossDocument.getCess_PL());
		node.setProperty("mootlywcm:anyOther_RateInclSTT", objProfitAndLossDocument.getAnyOther_RateInclSTT());
		node.setProperty("mootlywcm:totalRates_TaxesPaid", objProfitAndLossDocument.getTotalRates_TaxesPaid());
		node.setProperty("mootlywcm:audit_Fee", objProfitAndLossDocument.getAudit_Fee());
		node.setProperty("mootlywcm:interest", objProfitAndLossDocument.getInterest());
		// doubt line above
		node.setProperty("mootlywcm:bad_Debts", objProfitAndLossDocument.getBad_Debts());
		node.setProperty("mootlywcm:bad_DoubtfulDebts", objProfitAndLossDocument.getBad_DoubtfulDebts());
		node.setProperty("mootlywcm:other_Provisions", objProfitAndLossDocument.getOther_Provisions());
		node.setProperty("mootlywcm:profitBefore_InterestTaxes", objProfitAndLossDocument.getProfitBefore_InterestTaxes());
		node.setProperty("mootlywcm:interest_PL", objProfitAndLossDocument.getInterest_PL());
		node.setProperty("mootlywcm:depreciation_PL", objProfitAndLossDocument.getDepreciation_PL());
		node.setProperty("mootlywcm:profit_BeforeTaxes", objProfitAndLossDocument.getProfit_BeforeTaxes());
		node.setProperty("mootlywcm:prov_CurrentTax", objProfitAndLossDocument.getProv_CurrentTax());
		node.setProperty("mootlywcm:prov_DeferredTax", objProfitAndLossDocument.getProv_DeferredTax());
		node.setProperty("mootlywcm:profit_AfterTax", objProfitAndLossDocument.getProfit_AfterTax());
		node.setProperty("mootlywcm:balance_PreviousYear", objProfitAndLossDocument.getBalance_PreviousYear());
		log.info("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"+objProfitAndLossDocument.getBalance_PreviousYear());
		// it is alrady there abobalance_PreviousYear
		node.setProperty("mootlywcm:amount_Appropriation", objProfitAndLossDocument.getAmount_Appropriation());
		node.setProperty("mootlywcm:transReserves_Surplus", objProfitAndLossDocument.getTransReserves_Surplus());
		node.setProperty("mootlywcm:balanceCarried_BalanceSheet", objProfitAndLossDocument.getBalanceCarried_BalanceSheet());
		node.setProperty("mootlywcm:gross_Recepients", objProfitAndLossDocument.getGross_Recepients());
		node.setProperty("mootlywcm:gross_Profit", objProfitAndLossDocument.getGross_Profit());
		node.setProperty("mootlywcm:expenses_NoAccount", objProfitAndLossDocument.getExpenses_NoAccount());
		node.setProperty("mootlywcm:net_Profit", objProfitAndLossDocument.getNet_Profit());
		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}	
}
