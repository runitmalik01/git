
/**
 *
 * @author Dhananjay
 * Date:10-sep-2013
 *
 */


package com.mootly.wcm.beans;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:otherinformationdocument")
public class OtherInformationDocument extends OtherInformationVariables{
	static final public String NAMESPACE = "mootlywcm:otherinformationdocument";
	static final public String NODE_NAME = "otherinformationdocument";

	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		if (formMap == null) return;

		if (!(formMap.getField("accounting_employed").getValue().isEmpty())){
			setAccounting_employed(formMap.getField("accounting_employed").getValue());
		}
		if (!(formMap.getField("method_accounting").getValue().isEmpty())){
			setMethod_accounting(formMap.getField("method_accounting").getValue());
		}
		if (!(formMap.getField("raw_material").getValue().isEmpty())){
			setRaw_material(formMap.getField("raw_material").getValue());
		}
		if (!(formMap.getField("finished_goods").getValue().isEmpty())){
			setFinished_goods(formMap.getField("finished_goods").getValue());
		}
		if (!(formMap.getField("stock_valuation").getValue().isEmpty())){
			setStock_valuation(formMap.getField("stock_valuation").getValue());
		}
		double val_profit_deviation=0.0d;
		if (formMap.getField("profit_deviation").getValue().isEmpty()){
			setProfit_deviation(val_profit_deviation);
		}
		else{
			String strprofit_deviation=formMap.getField("profit_deviation").getValue();
			val_profit_deviation= Double.parseDouble(strprofit_deviation);
			setProfit_deviation(val_profit_deviation);
		}
		double val_loss_deviation=0.0d;
		if (formMap.getField("loss_deviation").getValue().isEmpty()) {
			setLoss_deviation(val_loss_deviation);
		}
		else{
			String strloss_deviation=formMap.getField("loss_deviation").getValue();
			val_loss_deviation= Double.parseDouble(strloss_deviation);
			setLoss_deviation(val_loss_deviation);
		}
		double val_item_section28=0.0d;
		if (formMap.getField("item_section28").getValue().isEmpty()) {
			setItem_section28(val_item_section28);
		}
		else{
			String Stritem_section28=formMap.getField("item_section28").getValue();
			val_item_section28= Double.parseDouble(Stritem_section28);
			setItem_section28(val_item_section28);
		}
		double val_proforma_credits=0.0d;
		if (formMap.getField("proforma_credits").getValue().isEmpty()){
			setProforma_credits(val_proforma_credits);
		}
		else{
			String proforma_creditsStr=formMap.getField("proforma_credits").getValue();
			val_proforma_credits= Double.parseDouble(proforma_creditsStr);
			setProforma_credits(val_proforma_credits);
		}
		double val_escalation_claims=0.0d;
		if (formMap.getField("escalation_claims").getValue().isEmpty()){
			setEscalation_claims(val_escalation_claims);
		}
		else{
			String escalation_claimsStr=formMap.getField("escalation_claims").getValue();
			val_escalation_claims= Double.parseDouble(escalation_claimsStr);
			setEscalation_claims(val_escalation_claims);
		}
		double val_other_income=0.0d;
		if (formMap.getField("other_income").getValue().isEmpty()) {
			setOther_income(val_other_income);
		}
		else{
			String other_incomeStr=formMap.getField("other_income").getValue();
			val_other_income= Double.parseDouble(other_incomeStr);
			setOther_income(val_other_income);
		}
		double val_capital_receipt=0.0d;
		if (formMap.getField("capital_receipt").getValue().isEmpty()){
			setCapital_receipt(val_capital_receipt);
		}
		else{
			String capital_receiptStr=formMap.getField("capital_receipt").getValue();
			val_capital_receipt= Double.parseDouble(capital_receiptStr);
			setCapital_receipt(val_capital_receipt);
		}
		double val_total_amount=0.0d;
		if (formMap.getField("total_amount").getValue().isEmpty()) {
			setTotal_amount(val_total_amount);
		}
		else{
			String total_amountStr=formMap.getField("total_amount").getValue();
			val_total_amount= Double.parseDouble(total_amountStr);
			setTotal_amount(val_total_amount);
		}
		double val_premiumpaid_damage=0.0d;
		if (formMap.getField("premiumpaid_damage").getValue().isEmpty()){
			setPremiumpaid_damage(val_premiumpaid_damage);
		}
		else{
			String premiumpaid_damageStr=formMap.getField("premiumpaid_damage").getValue();
			val_premiumpaid_damage= Double.parseDouble(premiumpaid_damageStr);
			setPremiumpaid_damage(val_premiumpaid_damage);
		}
		double val_premiumpaid_health=0.0d;
		if (formMap.getField("premiumpaid_health").getValue().isEmpty()) {
			setPremiumpaid_health(val_premiumpaid_health);
		}
		else{
			String premiumpaid_healthStr=formMap.getField("premiumpaid_health").getValue();
			val_premiumpaid_health= Double.parseDouble(premiumpaid_healthStr);
			setPremiumpaid_health(val_premiumpaid_health);
		}
		double val_sumpaid_bonus=0.0d;
		if (formMap.getField("sumpaid_bonus").getValue().isEmpty()){
			setSumpaid_bonus(val_sumpaid_bonus);
		}
		else{
			String sumpaid_bonusStr=formMap.getField("sumpaid_bonus").getValue();
			val_sumpaid_bonus= Double.parseDouble(sumpaid_bonusStr);
			setSumpaid_bonus(val_sumpaid_bonus);
		}
		double val_interest_borrowed=0.0d;
		if (formMap.getField("interest_borrowed").getValue().isEmpty()){
			setInterest_borrowed(val_interest_borrowed);
		}
		else{
			String interest_borrowedStr=formMap.getField("interest_borrowed").getValue();
			val_interest_borrowed= Double.parseDouble(interest_borrowedStr);
			setInterest_borrowed(val_interest_borrowed);
		}
		double val_discount_zerocoupon=0.0d;
		if (formMap.getField("discount_zerocoupon").getValue().isEmpty()){
			setDiscount_zerocoupon(val_discount_zerocoupon);
		}
		else{
			String discount_zerocouponStr=formMap.getField("discount_zerocoupon").getValue();
			val_discount_zerocoupon= Double.parseDouble(discount_zerocouponStr);
			setDiscount_zerocoupon(val_discount_zerocoupon);
		}
		double val_contributions_provident=0.0d;
		if (formMap.getField("contributions_provident").getValue().isEmpty()) {
			setContributions_provident(val_contributions_provident);
		}
		else{
			String contributions_providentStr=formMap.getField("contributions_provident").getValue();
			val_contributions_provident= Double.parseDouble(contributions_providentStr);
			setContributions_provident(val_contributions_provident);
		}
		double val_contributions_superannuation=0.0d;
		if (formMap.getField("contributions_superannuation").getValue().isEmpty()) {
			setContributions_superannuation(val_contributions_superannuation);
		}
		else{
			String contributions_superannuationStr=formMap.getField("contributions_superannuation").getValue();
			val_contributions_superannuation= Double.parseDouble(contributions_superannuationStr);
			setContributions_superannuation(val_contributions_superannuation);
		}
		double val_contributions_gratuity=0.0d;
		if (formMap.getField("contributions_gratuity").getValue().isEmpty()){
			setContributions_gratuity(val_contributions_gratuity);
		}
		else{
			String contributions_gratuityStr=formMap.getField("contributions_gratuity").getValue();
			val_contributions_gratuity= Double.parseDouble(contributions_gratuityStr);
			setContributions_gratuity(val_contributions_gratuity);
		}
		double val_contributions_other=0.0d;
		if (formMap.getField("contributions_other").getValue().isEmpty()){
			setContributions_other(val_contributions_other);
		}
		else{
			String contributions_otherStr=formMap.getField("contributions_other").getValue();
			val_contributions_other= Double.parseDouble(contributions_otherStr);
			setContributions_other(val_contributions_other);
		}
		double val_amount_debts=0.0d;
		if (formMap.getField("amount_debts").getValue().isEmpty()) {
			setAmount_debts(val_amount_debts);
		}
		else{
			String amount_debtsStr=formMap.getField("amount_debts").getValue();
			val_amount_debts= Double.parseDouble(amount_debtsStr);
			setAmount_debts(val_amount_debts);
		}
		double val_provision_debts=0.0d;
		if (formMap.getField("provision_debts").getValue().isEmpty()) {
			setProvision_debts(val_provision_debts);
		}
		else{
			String provision_debtsStr=formMap.getField("provision_debts").getValue();
			val_provision_debts= Double.parseDouble(provision_debtsStr);
			setProvision_debts(val_provision_debts);
		}
		double val_amount_transferred=0.0d;
		if (formMap.getField("amount_transferred").getValue().isEmpty()) {
			setAmount_transferred(val_amount_transferred);
		}
		else{
			String amount_transferredStr=formMap.getField("amount_transferred").getValue();
			val_amount_transferred= Double.parseDouble(amount_transferredStr);
			setAmount_transferred(val_amount_transferred);
		}
		double val_expenditure_promoting=0.0d;
		if (formMap.getField("expenditure_promoting").getValue().isEmpty()) {
			setExpenditure_promoting(val_expenditure_promoting);
		}
		else{
			String expenditure_promotingStr=formMap.getField("expenditure_promoting").getValue();
			val_expenditure_promoting= Double.parseDouble(expenditure_promotingStr);
			setExpenditure_promoting(val_expenditure_promoting);
		}
		double val_sum_received=0.0d;
		if (formMap.getField("sum_received").getValue().isEmpty()) {
			setSum_received(val_sum_received);
		}
		else{
			String sum_receivedStr=formMap.getField("sum_received").getValue();
			val_sum_received= Double.parseDouble(sum_receivedStr);
			setSum_received(val_sum_received);
		}
		double val_other_disallowance=0.0d;
		if (formMap.getField("other_disallowance").getValue().isEmpty()){
			setOther_disallowance(val_other_disallowance);
		}
		else{
			String other_disallowanceStr=formMap.getField("other_disallowance").getValue();
			val_other_disallowance= Double.parseDouble(other_disallowanceStr);
			setOther_disallowance(val_other_disallowance);
		}
		double val_totalamount_disallowable=0.0d;
		if (formMap.getField("totalamount_disallowable").getValue().isEmpty()){
			setTotalamount_disallowable(val_totalamount_disallowable);
		}
		else{
			String totalamount_disallowableStr=formMap.getField("totalamount_disallowable").getValue();
			val_totalamount_disallowable= Double.parseDouble(totalamount_disallowableStr);
			setTotalamount_disallowable(val_totalamount_disallowable);
		}
		double val_expenditure_personal=0.0d;
		if (formMap.getField("expenditure_personal").getValue().isEmpty()){
			setExpenditure_personal(val_expenditure_personal);
		}
		else{
			String expenditure_personalStr=formMap.getField("expenditure_personal").getValue();
			val_expenditure_personal= Double.parseDouble(expenditure_personalStr);
			setExpenditure_personal(val_expenditure_personal);
		}
		double val_expenditure_advertisement=0.0d;
		if (formMap.getField("expenditure_advertisement").getValue().isEmpty()){
			setExpenditure_advertisement(val_expenditure_advertisement);
		}
		else{
			String expenditure_advertisementStr=formMap.getField("expenditure_advertisement").getValue();
			val_expenditure_advertisement= Double.parseDouble(expenditure_advertisementStr);
			setExpenditure_advertisement(val_expenditure_advertisement);
		}
		double val_expenditure_penalty=0.0d;
		if (formMap.getField("expenditure_penalty").getValue().isEmpty()){
			setExpenditure_penalty(val_expenditure_penalty);
		}
		else{
			String expenditure_penaltyStr=formMap.getField("expenditure_penalty").getValue();
			val_expenditure_penalty= Double.parseDouble(expenditure_penaltyStr);
			setExpenditure_penalty(val_expenditure_penalty);
		}
		double val_other_penalty=0.0d;
		if (formMap.getField("other_penalty").getValue().isEmpty()){
			setOther_penalty(val_other_penalty);
		}
		else{
			String other_penaltyStr=formMap.getField("other_penalty").getValue();
			val_other_penalty= Double.parseDouble(other_penaltyStr);
			setOther_penalty(val_other_penalty);
		}
		double val_expenditure_incurred=0.0d;
		if (formMap.getField("expenditure_incurred").getValue().isEmpty()){
			setExpenditure_incurred(val_expenditure_incurred);
		}
		else{
			String expenditure_incurredStr=formMap.getField("expenditure_incurred").getValue();
			val_expenditure_incurred= Double.parseDouble(expenditure_incurredStr);
			setExpenditure_incurred(val_expenditure_incurred);
		}
		double val_amount_liability=0.0d;
		if (formMap.getField("amount_liability").getValue().isEmpty()){
			setAmount_liability(val_amount_liability);
		}
		else{
			String amount_liabilityStr=formMap.getField("amount_liability").getValue();
			val_amount_liability= Double.parseDouble(amount_liabilityStr);
			setAmount_liability(val_amount_liability);
		}
		double val_amount_expenditure=0.0d;
		if (formMap.getField("amount_expenditure").getValue().isEmpty()){
			setAmount_expenditure(val_amount_expenditure);
		}
		else{
			String amount_expenditureStr=formMap.getField("amount_expenditure").getValue();
			val_amount_expenditure= Double.parseDouble(amount_expenditureStr);
			setAmount_expenditure(val_amount_expenditure);
		}
		double val_other_amountus37=0.0d;
		if (formMap.getField("other_amountus37").getValue().isEmpty()){
			setOther_amountus37(val_other_amountus37);
		}
		else{
			String other_amountus37Str=formMap.getField("other_amountus37").getValue();
			val_other_amountus37= Double.parseDouble(other_amountus37Str);
			setOther_amountus37(val_other_amountus37);
		}
		double val_totalamount_disallowableus37=0.0d;
		if (formMap.getField("totalamount_disallowableus37").getValue().isEmpty()){
			setTotalamount_disallowableus37(val_totalamount_disallowableus37);
		}
		else{
			String totalamount_disallowableus37Str=formMap.getField("totalamount_disallowableus37").getValue();
			val_totalamount_disallowableus37= Double.parseDouble(totalamount_disallowableus37Str);
			setTotalamount_disallowableus37(val_totalamount_disallowableus37);
		}
		double val_amountdisallowable_us40A=0.0d;
		if (formMap.getField("amountdisallowable_us40A").getValue().isEmpty()){
			setAmountdisallowable_us40A(val_amountdisallowable_us40A);
		}
		else{
			String amountdisallowable_us40AStr=formMap.getField("amountdisallowable_us40A").getValue();
			val_amountdisallowable_us40A= Double.parseDouble(amountdisallowable_us40AStr);
			setAmountdisallowable_us40A(val_amountdisallowable_us40A);
		}
		double val_amount_ratelevied=0.0d;
		if (formMap.getField("amount_ratelevied").getValue().isEmpty()){
			setAmount_ratelevied(val_amount_ratelevied);
		}
		else{
			String amount_rateleviedStr=formMap.getField("amount_ratelevied").getValue();
			val_amount_ratelevied= Double.parseDouble(amount_rateleviedStr);
			setAmount_ratelevied(val_amount_ratelevied);
		}
		double val_amount_wealthtax=0.0d;
		if (formMap.getField("amount_wealthtax").getValue().isEmpty()){
			setAmount_wealthtax(val_amount_wealthtax);
		}
		else{
			String amount_wealthtaxStr=formMap.getField("amount_wealthtax").getValue();
			val_amount_wealthtax= Double.parseDouble(amount_wealthtaxStr);
			setAmount_wealthtax(val_amount_wealthtax);
		}
		double val_amount_commission=0.0d;
		if (formMap.getField("amount_commission").getValue().isEmpty()){
			setAmount_commission(val_amount_commission);
		}
		else{
			String amount_commissionStr=formMap.getField("amount_commission").getValue();
			val_amount_commission= Double.parseDouble(amount_commissionStr);
			setAmount_commission(val_amount_commission);
		}

		double val_other_disallowance2=0.0d;
		if (formMap.getField("other_disallowance2").getValue().isEmpty()){
			setOther_disallowance2(val_other_disallowance2);
		}
		else{
			String other_disallowance2Str=formMap.getField("other_disallowance2").getValue();
			val_other_disallowance2= Double.parseDouble(other_disallowance2Str);
			setOther_disallowance2(val_other_disallowance2);
		}
		double val_amount_disallowanceus40=0.0d;
		if (formMap.getField("amount_disallowanceus40").getValue().isEmpty()){
			setAmount_disallowanceus40(val_amount_disallowanceus40);
		}
		else{
			String amount_disallowanceus40Str=formMap.getField("amount_disallowanceus40").getValue();
			val_amount_disallowanceus40= Double.parseDouble(amount_disallowanceus40Str);
			setAmount_disallowanceus40(val_amount_disallowanceus40);
		}
		double val_amountdisallowable_us40B=0.0d;
		if (formMap.getField("amountdisallowable_us40B").getValue().isEmpty()){
			setAmountdisallowable_us40B(val_amountdisallowable_us40B);
		}
		else{
			String amountdisallowable_us40BStr=formMap.getField("amountdisallowable_us40B").getValue();
			val_amountdisallowable_us40B= Double.parseDouble(amountdisallowable_us40BStr);
			setAmountdisallowable_us40B(val_amountdisallowable_us40B);
		}
		double val_amount_persons=0.0d;
		if (formMap.getField("amount_persons").getValue().isEmpty()){
			setAmount_persons(val_amount_persons);
		}
		else{
			String amount_personsStr=formMap.getField("amount_persons").getValue();
			val_amount_persons= Double.parseDouble(amount_personsStr);
			setAmount_persons(val_amount_persons);
		}
		double val_amount_excesstwth=0.0d;
		if (formMap.getField("amount_excesstwth").getValue().isEmpty()){
			setAmount_excesstwth(val_amount_excesstwth);
		}
		else{
			String amount_excesstwthStr=formMap.getField("amount_excesstwth").getValue();
			val_amount_excesstwth= Double.parseDouble(amount_excesstwthStr);
			setAmount_excesstwth(val_amount_excesstwth);
		}
		double val_provision_gratuity=0.0d;
		if (formMap.getField("provision_gratuity").getValue().isEmpty()){
			setProvision_gratuity(val_provision_gratuity);
		}
		else{
			String provision_gratuityStr=formMap.getField("provision_gratuity").getValue();
			val_provision_gratuity= Double.parseDouble(provision_gratuityStr);
			setProvision_gratuity(val_provision_gratuity);
		}
		double val_sumpaid_assessee=0.0d;
		if (formMap.getField("sumpaid_assessee").getValue().isEmpty()){
			setSumpaid_assessee(val_sumpaid_assessee);
		}
		else{
			String sumpaid_assesseeStr=formMap.getField("sumpaid_assessee").getValue();
			val_sumpaid_assessee= Double.parseDouble(sumpaid_assesseeStr);
			setSumpaid_assessee(val_sumpaid_assessee);
		}
		double val_anyother_disallowance=0.0d;
		if (formMap.getField("anyother_disallowance").getValue().isEmpty()){
			setAnyother_disallowance(val_anyother_disallowance);
		}
		else{
			String anyother_disallowanceStr=formMap.getField("anyother_disallowance").getValue();
			val_anyother_disallowance= Double.parseDouble(anyother_disallowanceStr);
			setAnyother_disallowance(val_anyother_disallowance);
		}
		double val_totalamount_disallowanceus40=0.0d;
		if (formMap.getField("totalamount_disallowanceus40").getValue().isEmpty()){
			setTotalamount_disallowanceus40(val_totalamount_disallowanceus40);
		}
		else{
			String totalamount_disallowanceus40Str=formMap.getField("totalamount_disallowanceus40").getValue();
			val_totalamount_disallowanceus40= Double.parseDouble(totalamount_disallowanceus40Str);
			setTotalamount_disallowanceus40(val_totalamount_disallowanceus40);
		}
		double val_sum_naturetax=0.0d;
		if (formMap.getField("sum_naturetax").getValue().isEmpty()){
			setSum_naturetax(val_sum_naturetax);
		}
		else{
			String sum_naturetaxStr=formMap.getField("sum_naturetax").getValue();
			val_sum_naturetax= Double.parseDouble(sum_naturetaxStr);
			setSum_naturetax(val_sum_naturetax);
		}
		double val_sumpayable_provident=0.0d;
		if (formMap.getField("sumpayable_provident").getValue().isEmpty()) {
			setSumpayable_provident(val_sumpayable_provident);
		}
		else{
			String sumpayable_providentStr=formMap.getField("sumpayable_provident").getValue();
			val_sumpayable_provident= Double.parseDouble(sumpayable_providentStr);
			setSumpayable_provident(val_sumpayable_provident);
		}
		double val_sumpayable_employee=0.0d;
		if (formMap.getField("sumpayable_employee").getValue().isEmpty()) {
			setSumpayable_employee(val_sumpayable_employee);
		}
		else{
			String sumpayable_employeeStr=formMap.getField("sumpayable_employee").getValue();
			val_sumpayable_employee= Double.parseDouble(sumpayable_employeeStr);
			setSumpayable_employee(val_sumpayable_employee);
		}
		double val_sumpayable_institution=0.0d;
		if (formMap.getField("sumpayable_institution").getValue().isEmpty()){
			setSumpayable_institution(val_sumpayable_institution);
		}
		else{
			String sumpayable_institutionStr=formMap.getField("sumpayable_institution").getValue();
			val_sumpayable_institution= Double.parseDouble(sumpayable_institutionStr);
			setSumpayable_institution(val_sumpayable_institution);
		}
		double val_sumpayable_bank=0.0d;
		if (formMap.getField("sumpayable_bank").getValue().isEmpty()){
			setSumpayable_bank(val_sumpayable_bank);
		}
		else{
			String sumpayable_bankStr=formMap.getField("sumpayable_bank").getValue();
			val_sumpayable_bank= Double.parseDouble(sumpayable_bankStr);
			setSumpayable_bank(val_sumpayable_bank);
		}
		double val_sumpayable_encashment=0.0d;
		if (formMap.getField("sumpayable_encashment").getValue().isEmpty()) {
			setSumpayable_encashment(val_sumpayable_encashment);
		}
		else{
			String sumpayable_encashmentStr=formMap.getField("sumpayable_encashment").getValue();
			val_sumpayable_encashment= Double.parseDouble(sumpayable_encashmentStr);
			setSumpayable_encashment(val_sumpayable_encashment);
		}
		double val_totalamount_us43=0.0d;
		if (formMap.getField("totalamount_us43").getValue().isEmpty()){
			setTotalamount_us43(val_totalamount_us43);
		}
		else{
			String totalamount_us43Str=formMap.getField("totalamount_us43").getValue();
			val_totalamount_us43= Double.parseDouble(totalamount_us43Str);
			setTotalamount_us43(val_totalamount_us43);
		}
		double val_sum_naturetax43b=0.0d;
		if (formMap.getField("sum_naturetax43b").getValue().isEmpty()){
			setSum_naturetax43b(val_sum_naturetax43b);
		}
		else{
			String sum_naturetax43bStr=formMap.getField("sum_naturetax43b").getValue();
			val_sum_naturetax43b= Double.parseDouble(sum_naturetax43bStr);
			setSum_naturetax43b(val_sum_naturetax43b);
		}
		double val_sumpayable_provident43b=0.0d;
		if (formMap.getField("sumpayable_provident43b").getValue().isEmpty()){
			setSumpayable_provident43b(val_sumpayable_provident43b);
		}
		else{
			String sumpayable_provident43bStr=formMap.getField("sumpayable_provident43b").getValue();
			val_sumpayable_provident43b= Double.parseDouble(sumpayable_provident43bStr);
			setSumpayable_provident43b(val_sumpayable_provident43b);
		}
		double val_sumpayable_employee43b=0.0d;
		if (formMap.getField("sumpayable_employee43b").getValue().isEmpty()){
			setSumpayable_employee43b(val_sumpayable_employee43b);
		}
		else{
			String sumpayable_employee43bStr=formMap.getField("sumpayable_employee43b").getValue();
			val_sumpayable_employee43b= Double.parseDouble(sumpayable_employee43bStr);
			setSumpayable_employee43b(val_sumpayable_employee43b);
		}
		double val_sumpayable_institution43b=0.0d;
		if (formMap.getField("sumpayable_institution43b").getValue().isEmpty()){
			setSumpayable_institution43b(val_sumpayable_institution43b);
		}
		else{
			String sumpayable_institution43bStr=formMap.getField("sumpayable_institution43b").getValue();
			val_sumpayable_institution43b= Double.parseDouble(sumpayable_institution43bStr);
			setSumpayable_institution43b(val_sumpayable_institution43b);
		}
		double val_sumpayable_bank43b=0.0d;
		if (formMap.getField("sumpayable_bank43b").getValue().isEmpty()){
			setSumpayable_bank43b(val_sumpayable_bank43b);
		}
		else{
			String sumpayable_bank43bStr=formMap.getField("sumpayable_bank43b").getValue();
			val_sumpayable_bank43b= Double.parseDouble(sumpayable_bank43bStr);
			setSumpayable_bank43b(val_sumpayable_bank43b);
		}
		double val_sumpayable_encashment43b=0.0d;
		if (formMap.getField("sumpayable_encashment43b").getValue().isEmpty()){
			setSumpayable_encashment43b(val_sumpayable_encashment43b);
		}
		else{
			String sumpayable_encashment43bStr=formMap.getField("sumpayable_encashment43b").getValue();
			val_sumpayable_encashment43b= Double.parseDouble(sumpayable_encashment43bStr);
			setSumpayable_encashment43b(val_sumpayable_encashment43b);
		}
		double val_totalamount_us43b=0.0d;
		if (formMap.getField("totalamount_us43b").getValue().isEmpty()){
			setTotalamount_us43b(val_totalamount_us43b);
		}
		else{
			String totalamount_us43bStr=formMap.getField("totalamount_us43b").getValue();
			val_totalamount_us43b= Double.parseDouble(totalamount_us43bStr);
			setTotalamount_us43b(val_totalamount_us43b);
		}
		double val_union_excise=0.0d;
		if (formMap.getField("union_excise").getValue().isEmpty()) {
			setUnion_excise(val_union_excise);
		}
		else{
			String union_exciseStr=formMap.getField("union_excise").getValue();
			val_union_excise= Double.parseDouble(union_exciseStr);
			setUnion_excise(val_union_excise);
		}
		double val_service_tax=0.0d;
		if (formMap.getField("service_tax").getValue().isEmpty()) {
			setService_tax(val_service_tax);
		}
		else{
			String service_taxStr=formMap.getField("service_tax").getValue();
			val_service_tax= Double.parseDouble(service_taxStr);
			setService_tax(val_service_tax);
		}
		double val_vat_tax=0.0d;
		if (formMap.getField("vat_tax").getValue().isEmpty()) {
			setVat_tax(val_vat_tax);
		}
		else{
			String vat_taxStr=formMap.getField("vat_tax").getValue();
			val_vat_tax= Double.parseDouble(vat_taxStr);
			setVat_tax(val_vat_tax);
		}
		double val_other_tax=0.0d;
		if (formMap.getField("other_tax").getValue().isEmpty()){
			setOther_tax(val_other_tax);
		}
		else{
			String other_taxStr=formMap.getField("other_tax").getValue();
			val_other_tax= Double.parseDouble(other_taxStr);
			setOther_tax(val_other_tax);
		}
		double val_totalamount_outstanding=0.0d;
		if (formMap.getField("totalamount_outstanding").getValue().isEmpty()) {
			setTotalamount_outstanding(val_totalamount_outstanding);
		}
		else{
			String totalamount_outstandingStr=formMap.getField("totalamount_outstanding").getValue();
			val_totalamount_outstanding= Double.parseDouble(totalamount_outstandingStr);
			setTotalamount_outstanding(val_totalamount_outstanding);
		}
		double val_amount_deemed=0.0d;
		if (formMap.getField("amount_deemed").getValue().isEmpty()){
			setAmount_deemed(val_amount_deemed);
		}
		else{
			String amount_deemedStr=formMap.getField("amount_deemed").getValue();
			val_amount_deemed= Double.parseDouble(amount_deemedStr);
			setAmount_deemed(val_amount_deemed);
		}
		double val_amount_profit=0.0d;
		if (formMap.getField("amount_profit").getValue().isEmpty()){
			setAmount_profit(val_amount_profit);
		}
		else{
			String amount_profitStr=formMap.getField("amount_profit").getValue();
			val_amount_profit= Double.parseDouble(amount_profitStr);
			setAmount_profit(val_amount_profit);
		}
		double val_amount_income=0.0d;
		if (formMap.getField("amount_income").getValue().isEmpty()){
			setAmount_income(val_amount_income);
		}
		else{
			String amount_incomeStr=formMap.getField("amount_income").getValue();
			val_amount_income= Double.parseDouble(amount_incomeStr);
			setAmount_income(val_amount_income);
		}

	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}


}
