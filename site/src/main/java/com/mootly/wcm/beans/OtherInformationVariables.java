
/**
 *
 * @author Dhananjay
 * Date:10-sep-2013
 *
 */


package com.mootly.wcm.beans;
import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;

public abstract class OtherInformationVariables extends BaseDocument implements ContentNodeBinder, FormMapFiller{

	private String accounting_employed;
	private String method_accounting;
	private String raw_material;
	private String finished_goods;
	private String stock_valuation;
	private Double profit_deviation;
	private Double loss_deviation;
	private Double item_section28;
	private Double proforma_credits;
	private Double escalation_claims;
	private Double other_income;
	private Double capital_receipt;
	private Double total_amount;
	private Double premiumpaid_damage;
	private Double premiumpaid_health;
	private Double sumpaid_bonus;
	private Double interest_borrowed;
	private Double discount_zerocoupon;
	private Double contributions_provident;
	private Double contributions_superannuation;
	private Double contributions_gratuity;
	private Double contributions_other;
	private Double amount_debts;
	private Double provision_debts;
	private Double amount_transferred;
	private Double expenditure_promoting;
	private Double sum_received;
	private Double other_disallowance;
	private Double totalamount_disallowable;
	private Double expenditure_personal;
	private Double expenditure_advertisement;
	private Double expenditure_penalty;
	private Double other_penalty;
	private Double expenditure_incurred;
	private Double amount_liability;
	private Double amount_expenditure;
	private Double other_amountus37;
	private Double totalamount_disallowableus37;
	private Double amountdisallowable_us40A;
	private Double amount_ratelevied;
	private Double amount_wealthtax;
	private Double amount_commission;
	private Double other_disallowance2;
	private Double amount_disallowanceus40;
	private Double amountdisallowable_us40B;
	private Double amount_persons;
	private Double amount_excesstwth;
	private Double provision_gratuity;
	private Double sumpaid_assessee;
	private Double anyother_disallowance;
	private Double totalamount_disallowanceus40;
	private Double sum_naturetax;
	private Double sumpayable_provident;
	private Double sumpayable_employee;
	private Double sumpayable_institution;
	private Double sumpayable_bank;
	private Double sumpayable_encashment;
	private Double totalamount_us43;
	private Double sum_naturetax43b;
	private Double sumpayable_provident43b;
	private Double sumpayable_employee43b;
	private Double sumpayable_institution43b;
	private Double sumpayable_bank43b;
	private Double sumpayable_encashment43b;
	private Double totalamount_us43b;
	private Double union_excise;
	private Double service_tax;
	private Double vat_tax;
	private Double other_tax;
	private Double totalamount_outstanding;
	private Double amount_deemed;
	private Double amount_profit;
	private Double amount_income;


	//getter and setter methods
	public String getAccounting_employed() {
		if(accounting_employed == null) accounting_employed = getProperty("mootlywcm:accounting_employed");
		return accounting_employed;
	}

	public final void setAccounting_employed(String accounting_employed){
		this.accounting_employed = accounting_employed;
	}

	public String getMethod_accounting() {
		if(method_accounting == null) method_accounting = getProperty("mootlywcm:method_accounting");
		return method_accounting;
	}

	public final void setMethod_accounting(String method_accounting){
		this.method_accounting = method_accounting;
	}

	public String getRaw_material() {
		if(raw_material == null) raw_material = getProperty("mootlywcm:raw_material");
		return raw_material;
	}

	public final void setRaw_material(String raw_material){
		this.raw_material = raw_material;
	}

	public String getFinished_goods() {
		if(finished_goods == null) finished_goods = getProperty("mootlywcm:finished_goods");
		return finished_goods;
	}

	public final void setFinished_goods(String finished_goods){
		this.finished_goods = finished_goods;
	}

	public String getStock_valuation() {
		if(stock_valuation == null) stock_valuation = getProperty("mootlywcm:stock_valuation");
		return stock_valuation;
	}

	public final void setStock_valuation(String stock_valuation){
		this.stock_valuation = stock_valuation;
	}

	public  Double getProfit_deviation() {
		if (profit_deviation == null) profit_deviation = getProperty("mootlywcm:profit_deviation");
		return profit_deviation;
	}

	public final void  setProfit_deviation(Double profit_deviation) {
		this.profit_deviation = profit_deviation;
	}

	public  Double getLoss_deviation() {
		if (loss_deviation == null) loss_deviation = getProperty("mootlywcm:loss_deviation");
		return loss_deviation;
	}

	public final void  setLoss_deviation(Double loss_deviation) {
		this.loss_deviation = loss_deviation;
	}
	public  Double getItem_section28() {
		if (item_section28 == null) item_section28 = getProperty("mootlywcm:item_section28");
		return item_section28;
	}

	public final void  setItem_section28(Double item_section28) {
		this.item_section28 = item_section28;
	}
	public  Double getProforma_credits() {
		if (proforma_credits == null) proforma_credits = getProperty("mootlywcm:proforma_credits");
		return proforma_credits;
	}

	public final void  setProforma_credits(Double proforma_credits) {
		this.proforma_credits = proforma_credits;
	}
	public  Double getEscalation_claims() {
		if (escalation_claims == null) escalation_claims = getProperty("mootlywcm:escalation_claims");
		return escalation_claims;
	}
	public final void  setEscalation_claims(Double escalation_claims) {
		this.escalation_claims = escalation_claims;
	}
	public  Double getOther_income() {
		if (other_income == null) other_income = getProperty("mootlywcm:other_income");
		return other_income;
	}

	public final void  setOther_income(Double other_income) {
		this.other_income = other_income;
	}
	public  Double getCapital_receipt() {
		if (capital_receipt == null) capital_receipt = getProperty("mootlywcm:capital_receipt");
		return capital_receipt;
	}

	public final void  setCapital_receipt(Double capital_receipt) {
		this.capital_receipt = capital_receipt;
	}
	public  Double getTotal_amount() {
		if (total_amount == null) total_amount = getProperty("mootlywcm:total_amount");
		return total_amount;
	}

	public final void  setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public  Double getPremiumpaid_damage() {
		if (premiumpaid_damage == null) premiumpaid_damage = getProperty("mootlywcm:premiumpaid_damage");
		return premiumpaid_damage;
	}

	public final void  setPremiumpaid_damage(Double premiumpaid_damage) {
		this.premiumpaid_damage = premiumpaid_damage;
	}
	public  Double getPremiumpaid_health() {
		if (premiumpaid_health == null) premiumpaid_health = getProperty("mootlywcm:premiumpaid_health");
		return premiumpaid_health;
	}

	public final void  setPremiumpaid_health(Double premiumpaid_health) {
		this.premiumpaid_health = premiumpaid_health;
	}
	public  Double getSumpaid_bonus() {
		if (sumpaid_bonus == null) sumpaid_bonus = getProperty("mootlywcm:sumpaid_bonus");
		return sumpaid_bonus;
	}

	public final void  setSumpaid_bonus(Double sumpaid_bonus) {
		this.sumpaid_bonus = sumpaid_bonus;
	}
	public  Double getInterest_borrowed() {
		if (interest_borrowed == null) interest_borrowed = getProperty("mootlywcm:interest_borrowed");
		return interest_borrowed;
	}

	public final void  setInterest_borrowed(Double interest_borrowed) {
		this.interest_borrowed = interest_borrowed;
	}
	public  Double getDiscount_zerocoupon() {
		if (discount_zerocoupon == null) discount_zerocoupon = getProperty("mootlywcm:discount_zerocoupon");
		return discount_zerocoupon;
	}

	public final void  setDiscount_zerocoupon(Double discount_zerocoupon) {
		this.discount_zerocoupon = discount_zerocoupon;
	}
	public  Double getContributions_provident() {
		if (contributions_provident == null) contributions_provident = getProperty("mootlywcm:contributions_provident");
		return contributions_provident;
	}

	public final void  setContributions_provident(Double contributions_provident) {
		this.contributions_provident = contributions_provident;
	}
	public  Double getContributions_superannuation() {
		if (contributions_superannuation == null) contributions_superannuation = getProperty("mootlywcm:contributions_superannuation");
		return contributions_superannuation;
	}

	public final void  setContributions_superannuation(Double contributions_superannuation) {
		this.contributions_superannuation = contributions_superannuation;
	}

	public  Double getContributions_gratuity() {
		if (contributions_gratuity == null) contributions_gratuity = getProperty("mootlywcm:contributions_gratuity");
		return contributions_gratuity;
	}
	public final void  setContributions_gratuity(Double contributions_gratuity) {
		this.contributions_gratuity = contributions_gratuity;
	}

	public  Double getContributions_other() {
		if (contributions_other == null) contributions_other = getProperty("mootlywcm:contributions_other");
		return contributions_other;
	}
	public final void  setContributions_other(Double contributions_other) {
		this.contributions_other = contributions_other;
	}

	public  Double getAmount_debts() {
		if (amount_debts == null) amount_debts = getProperty("mootlywcm:amount_debts");
		return amount_debts;
	}
	public final void  setAmount_debts(Double amount_debts) {
		this.amount_debts = amount_debts;
	}

	public  Double getProvision_debts() {
		if (provision_debts == null) provision_debts = getProperty("mootlywcm:provision_debts");
		return provision_debts;
	}
	public final void  setProvision_debts(Double provision_debts) {
		this.provision_debts = provision_debts;
	}

	public  Double getAmount_transferred() {
		if (amount_transferred == null) amount_transferred = getProperty("mootlywcm:amount_transferred");
		return amount_transferred;
	}
	public final void  setAmount_transferred(Double amount_transferred) {
		this.amount_transferred = amount_transferred;
	}

	public  Double getExpenditure_promoting() {
		if (expenditure_promoting == null) expenditure_promoting = getProperty("mootlywcm:expenditure_promoting");
		return expenditure_promoting;
	}
	public final void  setExpenditure_promoting(Double expenditure_promoting) {
		this.expenditure_promoting = expenditure_promoting;
	}

	public  Double getSum_received() {
		if (sum_received == null) sum_received = getProperty("mootlywcm:sum_received");
		return sum_received;
	}
	public final void  setSum_received(Double sum_received) {
		this.sum_received = sum_received;
	}

	public  Double getOther_disallowance() {
		if (other_disallowance == null) other_disallowance = getProperty("mootlywcm:other_disallowance");
		return other_disallowance;
	}
	public final void  setOther_disallowance(Double other_disallowance) {
		this.other_disallowance = other_disallowance;
	}

	public  Double getTotalamount_disallowable() {
		if (totalamount_disallowable == null) totalamount_disallowable = getProperty("mootlywcm:totalamount_disallowable");
		return totalamount_disallowable;
	}
	public final void  setTotalamount_disallowable(Double totalamount_disallowable) {
		this.totalamount_disallowable = totalamount_disallowable;
	}

	public  Double getExpenditure_personal() {
		if (expenditure_personal == null) expenditure_personal = getProperty("mootlywcm:expenditure_personal");
		return expenditure_personal;
	}
	public final void  setExpenditure_personal(Double expenditure_personal) {
		this.expenditure_personal = expenditure_personal;
	}

	public  Double getExpenditure_advertisement() {
		if (expenditure_advertisement == null) expenditure_advertisement = getProperty("mootlywcm:expenditure_advertisement");
		return expenditure_advertisement;
	}
	public final void  setExpenditure_advertisement(Double expenditure_advertisement) {
		this.expenditure_advertisement = expenditure_advertisement;
	}

	public  Double getExpenditure_penalty() {
		if (expenditure_penalty == null) expenditure_penalty = getProperty("mootlywcm:expenditure_penalty");
		return expenditure_penalty;
	}
	public final void  setExpenditure_penalty(Double expenditure_penalty) {
		this.expenditure_penalty = expenditure_penalty;
	}

	public  Double getOther_penalty() {
		if (other_penalty == null) other_penalty = getProperty("mootlywcm:other_penalty");
		return other_penalty;
	}
	public final void  setOther_penalty(Double other_penalty) {
		this.other_penalty = other_penalty;
	}

	public  Double getExpenditure_incurred() {
		if (expenditure_incurred == null) expenditure_incurred = getProperty("mootlywcm:expenditure_incurred");
		return expenditure_incurred;
	}
	public final void  setExpenditure_incurred(Double expenditure_incurred) {
		this.expenditure_incurred = expenditure_incurred;
	}

	public  Double getAmount_liability() {
		if (amount_liability == null) amount_liability = getProperty("mootlywcm:amount_liability");
		return amount_liability;
	}
	public final void  setAmount_liability(Double amount_liability) {
		this.amount_liability = amount_liability;
	}

	public  Double getAmount_expenditure() {
		if (amount_expenditure == null) amount_expenditure = getProperty("mootlywcm:amount_expenditure");
		return amount_expenditure;
	}
	public final void  setAmount_expenditure(Double amount_expenditure) {
		this.amount_expenditure = amount_expenditure;
	}

	public  Double getOther_amountus37() {
		if (other_amountus37 == null) other_amountus37 = getProperty("mootlywcm:other_amountus37");
		return other_amountus37;
	}
	public final void  setOther_amountus37(Double other_amountus37) {
		this.other_amountus37 = other_amountus37;
	}

	public  Double getTotalamount_disallowableus37() {
		if (totalamount_disallowableus37 == null) totalamount_disallowableus37 = getProperty("mootlywcm:totalamount_disallowableus37");
		return totalamount_disallowableus37;
	}
	public final void  setTotalamount_disallowableus37(Double totalamount_disallowableus37) {
		this.totalamount_disallowableus37 = totalamount_disallowableus37;
	}

	public  Double getAmountdisallowable_us40A() {
		if (amountdisallowable_us40A == null) amountdisallowable_us40A = getProperty("mootlywcm:amountdisallowable_us40A");
		return amountdisallowable_us40A;
	}
	public final void  setAmountdisallowable_us40A(Double amountdisallowable_us40A) {
		this.amountdisallowable_us40A = amountdisallowable_us40A;
	}

	public  Double getAmount_ratelevied() {
		if (amount_ratelevied == null) amount_ratelevied = getProperty("mootlywcm:amount_ratelevied");
		return amount_ratelevied;
	}
	public final void  setAmount_ratelevied(Double amount_ratelevied) {
		this.amount_ratelevied = amount_ratelevied;
	}

	public  Double getAmount_wealthtax() {
		if (amount_wealthtax == null) amount_wealthtax = getProperty("mootlywcm:amount_wealthtax");
		return amount_wealthtax;
	}
	public final void  setAmount_wealthtax(Double amount_wealthtax) {
		this.amount_wealthtax = amount_wealthtax;
	}

	public  Double getAmount_commission() {
		if (amount_commission == null) amount_commission = getProperty("mootlywcm:amount_commission");
		return amount_commission;
	}
	public final void  setAmount_commission(Double amount_commission) {
		this.amount_commission = amount_commission;
	}

	public  Double getOther_disallowance2() {
		if (other_disallowance2 == null) other_disallowance2 = getProperty("mootlywcm:other_disallowance2");
		return other_disallowance2;
	}
	public final void  setOther_disallowance2(Double other_disallowance2) {
		this.other_disallowance2 = other_disallowance2;
	}

	public  Double getAmount_disallowanceus40() {
		if (amount_disallowanceus40 == null) amount_disallowanceus40 = getProperty("mootlywcm:amount_disallowanceus40");
		return amount_disallowanceus40;
	}
	public final void  setAmount_disallowanceus40(Double amount_disallowanceus40) {
		this.amount_disallowanceus40 = amount_disallowanceus40;
	}

	public  Double getAmountdisallowable_us40B() {
		if (amountdisallowable_us40B == null) amountdisallowable_us40B = getProperty("mootlywcm:amountdisallowable_us40B");
		return amountdisallowable_us40B;
	}
	public final void  setAmountdisallowable_us40B(Double amountdisallowable_us40B) {
		this.amountdisallowable_us40B = amountdisallowable_us40B;
	}

	public  Double getAmount_persons() {
		if (amount_persons == null) amount_persons = getProperty("mootlywcm:amount_persons");
		return amount_persons;
	}
	public final void  setAmount_persons(Double amount_persons) {
		this.amount_persons = amount_persons;
	}

	public  Double getAmount_excesstwth() {
		if (amount_excesstwth == null) amount_excesstwth = getProperty("mootlywcm:amount_excesstwth");
		return amount_excesstwth;
	}
	public final void  setAmount_excesstwth(Double amount_excesstwth) {
		this.amount_excesstwth = amount_excesstwth;
	}

	public  Double getProvision_gratuity() {
		if (provision_gratuity == null) provision_gratuity = getProperty("mootlywcm:provision_gratuity");
		return provision_gratuity;
	}
	public final void  setProvision_gratuity(Double provision_gratuity) {
		this.provision_gratuity = provision_gratuity;
	}

	public  Double getSumpaid_assessee() {
		if (sumpaid_assessee == null) sumpaid_assessee = getProperty("mootlywcm:sumpaid_assessee");
		return sumpaid_assessee;
	}
	public final void  setSumpaid_assessee(Double sumpaid_assessee) {
		this.sumpaid_assessee = sumpaid_assessee;
	}

	public  Double getAnyother_disallowance() {
		if (anyother_disallowance == null) anyother_disallowance = getProperty("mootlywcm:anyother_disallowance");
		return anyother_disallowance;
	}
	public final void  setAnyother_disallowance(Double anyother_disallowance) {
		this.anyother_disallowance = anyother_disallowance;
	}

	public  Double getTotalamount_disallowanceus40() {
		if (totalamount_disallowanceus40 == null) totalamount_disallowanceus40 = getProperty("mootlywcm:totalamount_disallowanceus40");
		return totalamount_disallowanceus40;
	}
	public final void  setTotalamount_disallowanceus40(Double totalamount_disallowanceus40) {
		this.totalamount_disallowanceus40 = totalamount_disallowanceus40;
	}

	public  Double getSum_naturetax() {
		if (sum_naturetax == null) sum_naturetax = getProperty("mootlywcm:sum_naturetax");
		return sum_naturetax;
	}
	public final void  setSum_naturetax(Double sum_naturetax) {
		this.sum_naturetax = sum_naturetax;
	}

	public  Double getSumpayable_provident() {
		if (sumpayable_provident == null) sumpayable_provident = getProperty("mootlywcm:sumpayable_provident");
		return sumpayable_provident;
	}
	public final void  setSumpayable_provident(Double sumpayable_provident) {
		this.sumpayable_provident = sumpayable_provident;
	}

	public  Double getSumpayable_employee() {
		if (sumpayable_employee == null) sumpayable_employee = getProperty("mootlywcm:sumpayable_employee");
		return sumpayable_employee;
	}
	public final void  setSumpayable_employee(Double sumpayable_employee) {
		this.sumpayable_employee = sumpayable_employee;
	}

	public  Double getSumpayable_institution() {
		if (sumpayable_institution == null) sumpayable_institution = getProperty("mootlywcm:sumpayable_institution");
		return sumpayable_institution;
	}
	public final void  setSumpayable_institution(Double sumpayable_institution) {
		this.sumpayable_institution = sumpayable_institution;
	}

	public  Double getSumpayable_bank() {
		if (sumpayable_bank == null) sumpayable_bank = getProperty("mootlywcm:sumpayable_bank");
		return sumpayable_bank;
	}
	public final void  setSumpayable_bank(Double sumpayable_bank) {
		this.sumpayable_bank = sumpayable_bank;
	}

	public  Double getSumpayable_encashment() {
		if (sumpayable_encashment == null) sumpayable_encashment = getProperty("mootlywcm:sumpayable_encashment");
		return sumpayable_encashment;
	}
	public final void  setSumpayable_encashment(Double sumpayable_encashment) {
		this.sumpayable_encashment = sumpayable_encashment;
	}

	public  Double getTotalamount_us43() {
		if (totalamount_us43 == null) totalamount_us43 = getProperty("mootlywcm:totalamount_us43");
		return totalamount_us43;
	}
	public final void  setTotalamount_us43(Double totalamount_us43) {
		this.totalamount_us43 = totalamount_us43;
	}

	public  Double getSum_naturetax43b() {
		if (sum_naturetax43b == null) sum_naturetax43b = getProperty("mootlywcm:sum_naturetax43b");
		return sum_naturetax43b;
	}
	public final void  setSum_naturetax43b(Double sum_naturetax43b) {
		this.sum_naturetax43b = sum_naturetax43b;
	}

	public  Double getSumpayable_provident43b() {
		if (sumpayable_provident43b == null) sumpayable_provident43b = getProperty("mootlywcm:sumpayable_provident43b");
		return sumpayable_provident43b;
	}
	public final void  setSumpayable_provident43b(Double sumpayable_provident43b) {
		this.sumpayable_provident43b = sumpayable_provident43b;
	}

	public  Double getSumpayable_employee43b() {
		if (sumpayable_employee43b == null) sumpayable_employee43b = getProperty("mootlywcm:sumpayable_employee43b");
		return sumpayable_employee43b;
	}
	public final void  setSumpayable_employee43b(Double sumpayable_employee43b) {
		this.sumpayable_employee43b = sumpayable_employee43b;
	}

	public  Double getSumpayable_institution43b() {
		if (sumpayable_institution43b == null) sumpayable_institution43b = getProperty("mootlywcm:sumpayable_institution43b");
		return sumpayable_institution43b;
	}
	public final void  setSumpayable_institution43b(Double sumpayable_institution43b) {
		this.sumpayable_institution43b = sumpayable_institution43b;
	}

	public  Double getSumpayable_bank43b() {
		if (sumpayable_bank43b == null) sumpayable_bank43b = getProperty("mootlywcm:sumpayable_bank43b");
		return sumpayable_bank43b;
	}
	public final void  setSumpayable_bank43b(Double sumpayable_bank43b) {
		this.sumpayable_bank43b = sumpayable_bank43b;
	}

	public  Double getSumpayable_encashment43b() {
		if (sumpayable_encashment43b == null) sumpayable_encashment43b = getProperty("mootlywcm:sumpayable_encashment43b");
		return sumpayable_encashment43b;
	}
	public final void  setSumpayable_encashment43b(Double sumpayable_encashment43b) {
		this.sumpayable_encashment43b = sumpayable_encashment43b;
	}

	public  Double getTotalamount_us43b() {
		if (totalamount_us43b == null) totalamount_us43b = getProperty("mootlywcm:totalamount_us43b");
		return totalamount_us43b;
	}
	public final void  setTotalamount_us43b(Double totalamount_us43b) {
		this.totalamount_us43b = totalamount_us43b;
	}

	public  Double getUnion_excise() {
		if (union_excise == null) union_excise = getProperty("mootlywcm:union_excise");
		return union_excise;
	}
	public final void  setUnion_excise(Double union_excise) {
		this.union_excise = union_excise;
	}

	public  Double getService_tax() {
		if (service_tax == null) service_tax = getProperty("mootlywcm:service_tax");
		return service_tax;
	}
	public final void  setService_tax(Double service_tax) {
		this.service_tax = service_tax;
	}

	public  Double getVat_tax() {
		if (vat_tax == null) vat_tax = getProperty("mootlywcm:vat_tax");
		return vat_tax;
	}
	public final void  setVat_tax(Double vat_tax) {
		this.vat_tax = vat_tax;
	}

	public  Double getOther_tax() {
		if (other_tax == null) other_tax = getProperty("mootlywcm:other_tax");
		return other_tax;
	}
	public final void  setOther_tax(Double other_tax) {
		this.other_tax = other_tax;
	}

	public  Double getTotalamount_outstanding() {
		if (totalamount_outstanding == null) totalamount_outstanding = getProperty("mootlywcm:totalamount_outstanding");
		return totalamount_outstanding;
	}
	public final void  setTotalamount_outstanding(Double totalamount_outstanding) {
		this.totalamount_outstanding = totalamount_outstanding;
	}

	public  Double getAmount_deemed() {
		if (amount_deemed == null) amount_deemed = getProperty("mootlywcm:amount_deemed");
		return amount_deemed;
	}
	public final void  setAmount_deemed(Double amount_deemed) {
		this.amount_deemed = amount_deemed;
	}

	public  Double getAmount_profit() {
		if (amount_profit == null) amount_profit = getProperty("mootlywcm:amount_profit");
		return amount_profit;
	}
	public final void  setAmount_profit(Double amount_profit) {
		this.amount_profit = amount_profit;
	}

	public  Double getAmount_income() {
		if (amount_income == null) amount_income = getProperty("mootlywcm:amount_income");
		return amount_income;
	}
	public final void  setAmount_income(Double amount_income) {
		this.amount_income = amount_income;
	}


	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try{

			OtherInformationDocument otherInformationDocument= (OtherInformationDocument) content;
			node.setProperty("mootlywcm:accounting_employed",otherInformationDocument.getAccounting_employed());
			node.setProperty("mootlywcm:method_accounting",otherInformationDocument.getMethod_accounting());
			node.setProperty("mootlywcm:profit_deviation", otherInformationDocument.getProfit_deviation());
			node.setProperty("mootlywcm:raw_material", otherInformationDocument.getRaw_material());
			node.setProperty("mootlywcm:finished_goods", otherInformationDocument.getFinished_goods());
			node.setProperty("mootlywcm:stock_valuation", otherInformationDocument.getStock_valuation());
			node.setProperty("mootlywcm:loss_deviation", otherInformationDocument.getLoss_deviation());
			node.setProperty("mootlywcm:item_section28", otherInformationDocument.getItem_section28());
			node.setProperty("mootlywcm:proforma_credits", otherInformationDocument.getProforma_credits());
			node.setProperty("mootlywcm:escalation_claims", otherInformationDocument.getEscalation_claims());
			node.setProperty("mootlywcm:other_income", otherInformationDocument.getOther_income());
			node.setProperty("mootlywcm:capital_receipt", otherInformationDocument.getCapital_receipt());
			node.setProperty("mootlywcm:total_amount", otherInformationDocument.getTotal_amount());
			node.setProperty("mootlywcm:premiumpaid_damage", otherInformationDocument.getPremiumpaid_damage());
			node.setProperty("mootlywcm:premiumpaid_health", otherInformationDocument.getPremiumpaid_health());
			node.setProperty("mootlywcm:sumpaid_bonus", otherInformationDocument.getSumpaid_bonus());
			node.setProperty("mootlywcm:interest_borrowed", otherInformationDocument.getInterest_borrowed());
			node.setProperty("mootlywcm:discount_zerocoupon", otherInformationDocument.getDiscount_zerocoupon());
			node.setProperty("mootlywcm:contributions_provident", otherInformationDocument.getContributions_provident());
			node.setProperty("mootlywcm:contributions_superannuation", otherInformationDocument.getContributions_superannuation());
			node.setProperty("mootlywcm:contributions_gratuity", otherInformationDocument.getContributions_gratuity());
			node.setProperty("mootlywcm:contributions_other", otherInformationDocument.getContributions_other());
			node.setProperty("mootlywcm:amount_debts", otherInformationDocument.getAmount_debts());
			node.setProperty("mootlywcm:provision_debts", otherInformationDocument.getProvision_debts());
			node.setProperty("mootlywcm:amount_transferred", otherInformationDocument.getAmount_transferred());
			node.setProperty("mootlywcm:expenditure_promoting", otherInformationDocument.getExpenditure_promoting());
			node.setProperty("mootlywcm:sum_received", otherInformationDocument.getSum_received());
			node.setProperty("mootlywcm:other_disallowance", otherInformationDocument.getOther_disallowance());
			node.setProperty("mootlywcm:totalamount_disallowable", otherInformationDocument.getTotalamount_disallowable());
			node.setProperty("mootlywcm:expenditure_personal",otherInformationDocument.getExpenditure_personal());
			node.setProperty("mootlywcm:expenditure_advertisement", otherInformationDocument.getExpenditure_advertisement());
			node.setProperty("mootlywcm:expenditure_penalty", otherInformationDocument.getExpenditure_penalty());
			node.setProperty("mootlywcm:other_penalty", otherInformationDocument.getOther_penalty());
			node.setProperty("mootlywcm:expenditure_incurred", otherInformationDocument.getExpenditure_incurred());
			node.setProperty("mootlywcm:amount_liability", otherInformationDocument.getAmount_liability());
			node.setProperty("mootlywcm:amount_expenditure", otherInformationDocument.getAmount_expenditure());
			node.setProperty("mootlywcm:other_amountus37", otherInformationDocument.getOther_amountus37());
			node.setProperty("mootlywcm:totalamount_disallowableus37", otherInformationDocument.getTotalamount_disallowableus37());
			node.setProperty("mootlywcm:amountdisallowable_us40A", otherInformationDocument.getAmountdisallowable_us40A());
			node.setProperty("mootlywcm:amount_ratelevied", otherInformationDocument.getAmount_ratelevied());
			node.setProperty("mootlywcm:amount_wealthtax", otherInformationDocument.getAmount_wealthtax());
			node.setProperty("mootlywcm:amount_commission", otherInformationDocument.getAmount_commission());
			node.setProperty("mootlywcm:other_disallowance2", otherInformationDocument.getOther_disallowance2());
			node.setProperty("mootlywcm:amount_disallowanceus40", otherInformationDocument.getAmount_disallowanceus40());
			node.setProperty("mootlywcm:amountdisallowable_us40B", otherInformationDocument.getAmountdisallowable_us40B());
			node.setProperty("mootlywcm:amount_persons", otherInformationDocument.getAmount_persons());
			node.setProperty("mootlywcm:amount_excesstwth", otherInformationDocument.getAmount_excesstwth());
			node.setProperty("mootlywcm:provision_gratuity", otherInformationDocument.getProvision_gratuity());
			node.setProperty("mootlywcm:sumpaid_assessee", otherInformationDocument.getSumpaid_assessee());
			node.setProperty("mootlywcm:anyother_disallowance", otherInformationDocument.getAnyother_disallowance());
			node.setProperty("mootlywcm:totalamount_disallowanceus40", otherInformationDocument.getTotalamount_disallowanceus40());
			node.setProperty("mootlywcm:sum_naturetax", otherInformationDocument.getSum_naturetax());
			node.setProperty("mootlywcm:sumpayable_provident", otherInformationDocument.getSumpayable_provident());
			node.setProperty("mootlywcm:sumpayable_employee", otherInformationDocument.getSumpayable_employee());
			node.setProperty("mootlywcm:sumpayable_institution", otherInformationDocument.getSumpayable_institution());
			node.setProperty("mootlywcm:sumpayable_bank", otherInformationDocument.getSumpayable_bank());
			node.setProperty("mootlywcm:sumpayable_encashment", otherInformationDocument.getSumpayable_encashment());
			node.setProperty("mootlywcm:totalamount_us43", otherInformationDocument.getTotalamount_us43());
			node.setProperty("mootlywcm:sum_naturetax43b", otherInformationDocument.getSum_naturetax43b());
			node.setProperty("mootlywcm:sumpayable_provident43b", otherInformationDocument.getSumpayable_provident43b());
			node.setProperty("mootlywcm:sumpayable_employee43b", otherInformationDocument.getSumpayable_employee43b());
			node.setProperty("mootlywcm:sumpayable_institution43b", otherInformationDocument.getSumpayable_institution43b());
			node.setProperty("mootlywcm:sumpayable_bank43b", otherInformationDocument.getSumpayable_bank43b());
			node.setProperty("mootlywcm:sumpayable_encashment43b", otherInformationDocument.getSumpayable_encashment43b());
			node.setProperty("mootlywcm:totalamount_us43b", otherInformationDocument.getTotalamount_us43b());
			node.setProperty("mootlywcm:union_excise", otherInformationDocument.getUnion_excise());
			node.setProperty("mootlywcm:service_tax", otherInformationDocument.getService_tax());
			node.setProperty("mootlywcm:vat_tax",otherInformationDocument.getVat_tax());
			node.setProperty("mootlywcm:other_tax", otherInformationDocument.getOther_tax());
			node.setProperty("mootlywcm:totalamount_outstanding", otherInformationDocument.getTotalamount_outstanding());
			node.setProperty("mootlywcm:amount_deemed", otherInformationDocument.getAmount_deemed());
			node.setProperty("mootlywcm:amount_profit", otherInformationDocument.getAmount_profit());
			node.setProperty("mootlywcm:amount_income", otherInformationDocument.getAmount_income());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
