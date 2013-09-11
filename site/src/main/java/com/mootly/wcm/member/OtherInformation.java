package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.FormFields;
import com.mootly.wcm.annotations.PrimaryBean;
import com.mootly.wcm.beans.OtherInformationDocument;
import com.mootly.wcm.beans.ProfitAndLossDocument;
import com.mootly.wcm.components.ITReturnComponent;

/*
 * Author:Dhananjay Panwar
 * Date:10-sep-2013
 * Description
 */
@PrimaryBean(primaryBeanClass=OtherInformationDocument.class)
@FormFields(fieldNames={"accounting_employed","method_accounting","profit_deviation","raw_material","finished_goods","stock_valuation","loss_deviation",
		"item_section28","proforma_credits","escalation_claims","other_income","capital_receipt","total_amount","premiumpaid_damage","premiumpaid_health",
		"sumpaid_bonus","interest_borrowed","discount_zerocoupon","contributions_provident","contributions_superannuation","contributions_gratuity","contributions_other",
		"amount_debts","provision_debts","amount_transferred","expenditure_promoting","sum_received","other_disallowance","totalamount_disallowable","expenditure_personal",
		"expenditure_advertisement","expenditure_penalty","other_penalty","expenditure_incurred","amount_liability","amount_expenditure","other_amountus37",
		"totalamount_disallowableus37","amountdisallowable_us40A","amount_ratelevied","amount_wealthtax","amount_commission","other_disallowance2","amount_disallowanceus40",
		"amountdisallowable_us40B","amount_persons","amount_excesstwth","provision_gratuity","sumpaid_assessee","anyother_disallowance","totalamount_disallowanceus40",
		"sum_naturetax","sumpayable_provident","sumpayable_employee","sumpayable_institution","sumpayable_bank","sumpayable_encashment","totalamount_us43","sum_naturetax43b",
		"sumpayable_provident43b","sumpayable_employee43b","sumpayable_institution43b","sumpayable_bank43b","sumpayable_encashment43b","totalamount_us43b",
		"union_excise","service_tax","vat_tax","other_tax","totalamount_outstanding","amount_deemed","amount_profit","amount_income"})

public class OtherInformation extends ITReturnComponent {

	private static final Logger log = LoggerFactory.getLogger(OtherInformation.class);

	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {

		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}




