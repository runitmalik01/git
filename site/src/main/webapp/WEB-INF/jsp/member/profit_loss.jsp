<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="p_l">
	<fmt:message key="p_l" />
</c:set>
<hippo-gogreen:title title="${p_l}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />

<h4>
	<fmt:message key="profit.loss.itr4" />
</h4>
		<form id="frmProfitAndLoss" action="${actionUrl}" method="post"
			name="frmProfitAndLoss">
			<div class="row-fluid show-grid">
				<div class="span8">
							<div class="rowlabel">
								<label for="isAccountMaintain"><small><fmt:message
											key="foreign.is.dtaa.applicable" /> </small> </label>
							</div></div>
							<div class="span3">
							<div class="rowlabel">
								<select id="isAccountMaintain" name="isAccountMaintain">
								<option value="">-Select-</option>
								<option value="Yes">Yes</option>
								<option value="No">No</option>
								</select>
							</div>
						</div></div>
			<div id="Account_Maintain">
		<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="sales_GrossBusiness"><small><fmt:message
									key="sales.Gross.Business.itr4" /> </small> </label>
					</div></div>
					<div class="span3">
					<div class="rowlabel">
						<input id="sales_GrossBusiness" name="sales_GrossBusiness" 
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sales_GrossBusiness}"/>" />
					</div>
				</div>
				</div>
				<fieldset>
				<legend><fmt:message key="profitLoss.fieldset.two.itr4"/></legend>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="union_ExciseDuties"><small><fmt:message
									key="union.Excise.Duties.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="union_ExciseDuties" name="union_ExciseDuties"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.union_ExciseDuties}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="service_Tax"><small><fmt:message
									key="service.Tax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="service_Tax" name="service_Tax"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.service_Tax}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="vat_SalesTax"><small><fmt:message
									key="vat.Sales.Tax.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="vat_SalesTax" name="vat_SalesTax"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.vat_SalesTax}"/>" />
					</div>
				</div>
				</div>
			</fieldset>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="any_OtherTax"><small><fmt:message
									key="any.OtherTax.Tax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="any_OtherTax" name="any_OtherTax"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.any_OtherTax}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="total_DutyTaxCess"><small><fmt:message
									key="total.Duty.Tax.Cess.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_DutyTaxCess" name="total_DutyTaxCess" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_DutyTaxCess}"/>" />
					</div>
				</div>
				
			</div>
			<fieldset>
			<legend>Other Income</legend>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="rent"><small><fmt:message
									key="rent.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="rent" name="rent"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.rent}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="commission"><small><fmt:message
									key="commission.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="commission" name="commission"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.commission}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="dividend"><small><fmt:message
									key="dividend.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="dividend" name="dividend"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dividend}"/>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="interest"><small><fmt:message
									key="interest.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="interest" name="interest"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.interest}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="profit_FixedAsset"><small><fmt:message
									key="profit.FixedAsset.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_FixedAsset" name="profit_FixedAsset"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_FixedAsset}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="profit_InvestmentSTT"><small><fmt:message
									key="profit.InvestmentSTT.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_InvestmentSTT" name="profit_InvestmentSTT"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_InvestmentSTT}"/>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="profit_OtherInvestment"><small><fmt:message
									key="profit.OtherInvestment.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_OtherInvestment" name="profit_OtherInvestment"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_OtherInvestment}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="profit_CurrencyFluctuation"><small><fmt:message
									key="profit.CurrencyFluctuation.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_CurrencyFluctuation" name="profit_CurrencyFluctuation"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_CurrencyFluctuation}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="agricultural_Income"><small><fmt:message
									key="agricultural.Income.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="agricultural_Income" name="agricultural_Income"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.agricultural_Income}"/>" />
					</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="any_OtherIncome"><small><fmt:message
									key="any.OtherIncome.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="any_OtherIncome" name="any_OtherIncome"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.any_OtherIncome}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="total_OtherIncome"><small><fmt:message
									key="total.OtherIncome.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_OtherIncome" name="total_OtherIncome"  readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_OtherIncome}"/>" />
					</div>
				</div>
				</div>
			</div>
			</fieldset>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="closing_Stocks"><small><fmt:message
									key="closing.Stocks.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="closing_Stocks" name="closing_Stocks"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.closing_Stocks}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="total_CreditAccount"><small><fmt:message
									key="total.CreditAccount.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_CreditAccount" name="total_CreditAccount" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_CreditAccount}"/>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="opening_Stocks"><small><fmt:message
									key="opening.Stocks.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="opening_Stocks" name="opening_Stocks"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.opening_Stocks}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="purchases"><small><fmt:message
									key="purchases.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="purchases" name="purchases"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.purchases}"/>" />
					</div>
				</div>
			
			</div>
			<fieldset>
			<legend><fmt:message key="duties.taxes.paid.pl.itr4"/></legend>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="custom_Duty"><small><fmt:message
									key="custom.Duty.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="custom_Duty" name="custom_Duty"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.custom_Duty}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="counter_vailingDuty"><small><fmt:message
									key="counter.vailingDuty.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="counter_vailingDuty" name="counter_vailingDuty"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.counter_vailingDuty}"/>" />
					</div>
				</div>
			<div class="span4">
					<div class="rowlabel">
						<label for="special_addtionalDuty"><small><fmt:message
									key="special.addtionalDuty.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="special_addtionalDuty" name="special_addtionalDuty"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.special_addtionalDuty}"/>" />
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="union_ExciseDuty"><small><fmt:message
									key="union_ExciseDuty.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="union_ExciseDuty" name="union_ExciseDuty"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.union_ExciseDuty}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="service_TaxPL"><small><fmt:message
									key="service.Tax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="service_TaxPL" name="service_TaxPL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.service_TaxPL}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="vat_SalesTaxPL"><small><fmt:message
									key="vat.SalesTax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="vat_SalesTaxPL" name="vat_SalesTaxPL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.vat_SalesTaxPL}"/>" />
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="anyOther_TaxPaid"><small><fmt:message
									key="anyOther.TaxPaid.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="anyOther_TaxPaid" name="anyOther_TaxPaid"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.anyOther_TaxPaid}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="total"><small><fmt:message
									key="total.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total" name="total"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total}"/>" />
					</div>
				</div>
				</div>
			</fieldset>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="freight"><small><fmt:message
									key="freight.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="freight" name="freight"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.freight}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="consumption_Stores"><small><fmt:message
									key="consumption.Stores.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="consumption_Stores" name="consumption_Stores"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.consumption_Stores}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="power_Fuels"><small><fmt:message
									key="power_Fuels.Stores.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="power_Fuels" name="power_Fuels"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.power_Fuels}"/>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="rents_PL"><small><fmt:message
									key="rents_PL.Stores.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="rents_PL" name="rents_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.rents_PL}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="repairs_Buildings"><small><fmt:message
									key="repairs.buildings.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="repairs_Buildings" name="repairs_Buildings"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.repairs_Buildings}"/>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="repairs_Machinery"><small><fmt:message
									key="repairs.Machinery.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="repairs_Machinery" name="repairs_Machinery"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.repairs_Machinery}"/>" />
					</div>
				</div>
			</div>
			<fieldset>
			<legend> <fmt:message key="compensation.to.employees.pl.itr4"/></legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="salaries_Wages"><small><fmt:message
									key="salaries.Wages.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="salaries_Wages" name="salaries_Wages"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.salaries_Wages}"/>" />
					</div>
				</div>
			
				<div class="span4">
					<div class="rowlabel">
						<label for="bonus_PL"><small><fmt:message
									key="bonus.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="bonus_PL" name="bonus_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.bonus_PL}"/>" />
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="reimbursement_MedicalExpenses"><small><fmt:message
									key="reimbursement.MedicalExpenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="reimbursement_MedicalExpenses" name="reimbursement_MedicalExpenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.reimbursement_MedicalExpenses}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="leave_Encasement"><small><fmt:message
									key="leave.Encasement.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="leave_Encasement" name="leave_Encasement"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.leave_Encasement}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="leave_TravelBenefits"><small><fmt:message
									key="leave.TravelBenefits.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="leave_TravelBenefits" name="leave_TravelBenefits"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.leave_TravelBenefits}"/>" />
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="approved_SuperannuationFund"><small><fmt:message
									key="approved.SuperannuationFund.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="approved_SuperannuationFund" name="approved_SuperannuationFund"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.approved_SuperannuationFund}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="recog_ProvidendFund"><small><fmt:message
									key="recog.ProvidendFund.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="recog_ProvidendFund" name="recog_ProvidendFund"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.recog_ProvidendFund}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="recog_GratuityFund"><small><fmt:message
									key="recog.gratuityFund.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="recog_GratuityFund" name="recog_GratuityFund"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.recog_GratuityFund}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="any_OtherFund"><small><fmt:message
									key="any.OtherFund.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="any_OtherFund" name="any_OtherFund"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.any_OtherFund}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="any_otherBenefit"><small><fmt:message
									key="any.otherBenefit.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="any_otherBenefit" name="any_otherBenefit"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.any_otherBenefit}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="total_Compensation"><small><fmt:message
									key="total.Compensation.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_Compensation" name="total_Compensation" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_Compensation}" />"/>
					</div>
				</div>
				</div>
				
			</fieldset>
			<fieldset>
			<legend>Insurance</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="medical_Insurance"><small><fmt:message
									key="medical.Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="medical_Insurance" name="medical_Insurance"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.medical_Insurance}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="life_Insurance"><small><fmt:message
									key="life.Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="life_Insurance" name="life_Insurance"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.life_Insurance}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="keyman_Insurance"><small><fmt:message
									key="keyman_Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="keyman_Insurance" name="keyman_Insurance"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.keyman_Insurance}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="other_Insurance"><small><fmt:message
									key="other.Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="other_Insurance" name="other_Insurance"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_Insurance}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="totalExpense_Insurance"><small><fmt:message
									key="totalExpense.Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="totalExpense_Insurance" name="totalExpense_Insurance" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalExpense_Insurance}" />"/>
					</div>
				</div>
				</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="staff_WelfareExpense"><small><fmt:message
									key="staff.WelfareExpense.Insurance.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="staff_WelfareExpense" name="staff_WelfareExpense"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.staff_WelfareExpense}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="entertainment_PL"><small><fmt:message
									key="entertainment.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="entertainment_PL" name="entertainment_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.entertainment_PL}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="hospitality_PL"><small><fmt:message
									key="hospitality.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="hospitality_PL" name="hospitality_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.hospitality_PL}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="conference_PL"><small><fmt:message
									key="conference.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="conference_PL" name="conference_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.conference_PL}"/>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="sales_Promotion"><small><fmt:message
									key="sales.Promotion.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="sales_Promotion" name="sales_Promotion"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sales_Promotion}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="advertisement_PL"><small><fmt:message
									key="advertisement.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="advertisement_PL" name="advertisement_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.advertisement_PL}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="commission_PL"><small><fmt:message
									key="commission.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="commission_PL" name="commission_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.commission_PL}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="boarding_Lodging"><small><fmt:message
									key="boarding.Lodging.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="boarding_Lodging" name="boarding_Lodging"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.boarding_Lodging}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="travelling_Expenses"><small><fmt:message
									key="travelling.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="travelling_Expenses" name="travelling_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.travelling_Expenses}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="conveyance_Expenses"><small><fmt:message
									key="conveyance.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="conveyance_Expenses" name="conveyance_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.conveyance_Expenses}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="telephone_Expenses"><small><fmt:message
									key="telephone.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="telephone_Expenses" name="telephone_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.telephone_Expenses}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="guestHouse_Expenses"><small><fmt:message
									key="guestHouse.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="guestHouse_Expenses" name="guestHouse_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.guestHouse_Expenses}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="club_Expenses"><small><fmt:message
									key="club.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="club_Expenses" name="club_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.club_Expenses}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="festivalCeleb_Expenses"><small><fmt:message
									key="festivalCeleb.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="festivalCeleb_Expenses" name="festivalCeleb_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.festivalCeleb_Expenses}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="scholarship_PL"><small><fmt:message
									key="scholarship.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="scholarship_PL" name="scholarship_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.scholarship_PL}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="gifts_PL"><small><fmt:message
									key="gifts.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="gifts_PL" name="gifts_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.gifts_PL}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="donation_PL"><small><fmt:message
									key="donation.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="donation_PL" name="donation_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.donation_PL}" />"/>
					</div>
				</div>
				
				</div>
				<fieldset>
				<legend><fmt:message key="rates.taxes.paid.govt.itr4"></fmt:message> </legend>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="union_ExciseDuty2"><small><fmt:message
									key="union_ExciseDuty2.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="union_ExciseDuty2" name="union_ExciseDuty2"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.union_ExciseDuty2}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="service_Tax2"><small><fmt:message
									key="service.Tax2.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="service_Tax2" name="service_Tax2"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.service_Tax2}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="vat_Salestax2"><small><fmt:message
									key="vat.Salestax2.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="vat_Salestax2" name="vat_Salestax2"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.vat_Salestax2}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="cess_PL"><small><fmt:message
									key="cess_PL.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="cess_PL" name="cess_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.cess_PL}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="anyOther_RateInclSTT"><small><fmt:message
									key="anyOther_RateInclSTT.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="anyOther_RateInclSTT" name="anyOther_RateInclSTT"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.anyOther_RateInclSTT}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="totalRates_TaxesPaid"><small><fmt:message
									key="totalRates_TaxesPaid.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="totalRates_TaxesPaid" name="totalRates_TaxesPaid" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalRates_TaxesPaid}" />"/>
					</div>
				</div>
				</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="audit_Fee"><small><fmt:message
									key="audit.Fee.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="audit_Fee" name="audit_Fee"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.audit_Fee}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="other_Expenses"><small><fmt:message
									key="other.Expenses.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="other_Expenses" name="other_Expenses"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_Expenses}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="bad_Debts"><small><fmt:message
									key="bad.Debts.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="bad_Debts" name="bad_Debts"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.bad_Debts}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="bad_DoubtfulDebts"><small><fmt:message
									key="bad.DoubtfulDebts.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="bad_DoubtfulDebts" name="bad_DoubtfulDebts"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.bad_DoubtfulDebts}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="other_Provisions"><small><fmt:message
									key="other.Provisions.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="other_Provisions" name="other_Provisions"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_Provisions}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="profitBefore_InterestTaxes"><small><fmt:message
									key="profitBefore.InterestTaxes.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profitBefore_InterestTaxes" name="profitBefore_InterestTaxes" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profitBefore_InterestTaxes}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
					<div class="rowlabel">
						<label for="interest_PL"><small><fmt:message
									key="interest_PL.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="interest_PL" name="interest_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.interest_PL}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="depreciation_PL"><small><fmt:message
									key="depreciation_PL.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="depreciation_PL" name="depreciation_PL"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.depreciation_PL}" />"/>
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="profit_BeforeTaxes"><small><fmt:message
									key="profit_BeforeTaxes.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_BeforeTaxes" name="profit_BeforeTaxes" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_BeforeTaxes}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="prov_CurrentTax"><small><fmt:message
									key="Prov.CurrentTax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="prov_CurrentTax" name="prov_CurrentTax"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.prov_CurrentTax}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="prov_DeferredTax"><small><fmt:message
									key="prov.DeferredTax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="prov_DeferredTax" name="prov_DeferredTax"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.prov_DeferredTax}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="profit_AfterTax"><small><fmt:message
									key="profit.AfterTax.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="profit_AfterTax" name="profit_AfterTax" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_AfterTax}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="balance_PreviousYear"><small><fmt:message
									key="balance_PreviousYear.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="balance_PreviousYear" name="balance_PreviousYear"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.balance_PreviousYear}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="amount_Appropriation"><small><fmt:message
									key="amount_Appropriation.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="amount_Appropriation" name="amount_Appropriation" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_Appropriation}" />"/>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="transReserves_Surplus"><small><fmt:message
									key="transReserves.Surplus.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="transReserves_Surplus" name="transReserves_Surplus"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.transReserves_Surplus}" />"/>
					</div>
				</div>
				</div>
				<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="balanceCarried_BalanceSheet"><small><fmt:message
									key="balanceCarried_BalanceSheet.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="balanceCarried_BalanceSheet" name="balanceCarried_BalanceSheet" readonly="readonly"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.balanceCarried_BalanceSheet}" />"/>
					</div>
				</div>
				</div>
				</div>
				<div id="NoAccount_Maintain">
				<fieldset>
				<legend><fmt:message key ="noAccounts.PL.itr4"></fmt:message> </legend>
				<div class="row-fluid show-grid">
				<div class="span5">
					<div class="rowlabel">
						<label for="gross_Recepients"><small><fmt:message
									key="gross.Recepients.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="gross_Recepients" name="gross_Recepients"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.gross_Recepients}" />"/>
					</div>
				</div>
				<div class="span5">
					<div class="rowlabel">
						<label for="gross_Profit"><small><fmt:message
									key="gross.Profit.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="gross_Profit" name="gross_Profit"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.gross_Profit}" />"/>
					</div>
				</div>
				</div>
				
				<div class="row-fluid show-grid">
				<div class="span5">
					<div class="rowlabel">
						<label for="expenses_NoAccount"><small><fmt:message
									key="expenses.NoAccount.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="expenses_NoAccount" name="expenses_NoAccount"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenses_NoAccount}" />"/>
					</div>
				</div>
				
				
				<div class="span5">
					<div class="rowlabel">
						<label for="net_Profit"><small><fmt:message
									key="Net_Profit.NoAccount.pl.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="net_Profit" name="net_Profit"
							type="text" maxlength="14" 
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.net_Profit}" />"/>
					</div>
				</div>
				</div>
				</fieldset>
				</div>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
					<a id="myModalProfitAndLoss" role="button" class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>
		</form>
</div>

<script type="text/javascript">
$('#isAccountMaintain').change(function(){
	var val_Accountmaintain = $('#isAccountMaintain').val();
	if (val_Accountmaintain == "Yes"){
		$('#Account_Maintain').show();
		$('#NoAccount_Maintain').hide();
	}
	if (val_Accountmaintain == "No"){
		$('#NoAccount_Maintain').show();
		$('#Account_Maintain').hide();
	}
	
})
</script>
<res:calc screenCalc="profitandloss" formId="frmProfitAndLoss"></res:calc>
<res:client-validation formId="frmProfitAndLoss"
	screenConfigurationDocumentName="profitandloss"
	formSubmitButtonId="myModalProfitAndLoss" />
	
