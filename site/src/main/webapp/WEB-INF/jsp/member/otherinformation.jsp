<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<w4india:itrmenu></w4india:itrmenu>

<c:set var="otherinformation">
	<fmt:message key="itr4.other.information" />
</c:set>
<hippo-gogreen:title title="${otherinformation}" />

<hst:actionURL var="actionUrl" />
<hst:link var="mainSiteMapRefId" />
<fmt:message key="itr4.other.information" var="title" />
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
<w4india:titleandnav title="${title}" subTitle="Other Information aka Schedule OI&nbsp;-&nbsp;This Schedule is optional in a case not liable for audit under section 44AB."/>
<div class="page type-page">
	<form id="frmOtherInformation" action="${actionUrl}" method="post"
		name="frmOtherInformation">
		<fieldset>
			<legend class="header-color">
				<small>Enter Details</small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="accounting_employed"><small><fmt:message
									key="oi.employed.itr4" /></small> </label>
					</div>
					<select id="accounting_employed" name="accounting_employed">
						<option value="">-SELECT-</option>
						<option value="MERC"
							<c:if test="${not empty parentBean.accounting_employed && parentBean.accounting_employed =='MERC'}">selected</c:if>>MERCANTILE</option>
						<option value="CASH"
							<c:if test="${not empty parentBean.accounting_employed && parentBean.accounting_employed =='CASH'}">selected</c:if>>CASH</option>
					</select>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="method_accounting"><small>Is there any
								change in method of accounting</small> </label>
					</div>
					<select id="method_accounting" name="method_accounting">
						<option value="">-SELECT-</option>
						<option value="Y"
							<c:if test="${not empty parentBean.method_accounting && parentBean.method_accounting =='Y'}">selected</c:if>>YES</option>
						<option value="N"
							<c:if test="${not empty parentBean.method_accounting && parentBean.method_accounting =='N'}">selected</c:if>>NO</option>
					</select>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="profit_deviation"><small>Effect on the
								profit because of deviation</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="profit_deviation" name="profit_deviation"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_deviation}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Method of
				valuation of closing stock employed in the previous year</small></legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="raw_material"><abbr
							title="If at cost or market rate whichever is less write 1, if at cost write 2, if at market rate write 3"><small>Raw
									Material</small> </abbr> </label>
					</div>
					<select id="raw_material" name="raw_material">
						<option value="">-SELECT-</option>
						<option value="1"
							<c:if test="${not empty parentBean.raw_material && parentBean.raw_material =='1'}">selected</c:if>>1</option>
						<option value="2"
							<c:if test="${not empty parentBean.raw_material && parentBean.raw_material =='2'}">selected</c:if>>2</option>
						<option value="3"
							<c:if test="${not empty parentBean.raw_material && parentBean.raw_material =='3'}">selected</c:if>>3</option>
					</select>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="finished_goods"><abbr
							title="If at cost or market rate whichever is less write 1, if at cost write 2, if at market rate write 3"><small>Finished
									goods</small> </abbr> </label>
					</div>
					<select id="finished_goods" name="finished_goods">
						<option value="">-SELECT-</option>
						<option value="1"
							<c:if test="${not empty parentBean.finished_goods && parentBean.finished_goods =='1'}">selected</c:if>>1</option>
						<option value="2"
							<c:if test="${not empty parentBean.finished_goods && parentBean.finished_goods =='2'}">selected</c:if>>2</option>
						<option value="3"
							<c:if test="${not empty parentBean.finished_goods && parentBean.finished_goods =='3'}">selected</c:if>>3</option>
					</select>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="stock_valuation"><small><fmt:message
									key="oi.valuation.itr4" /></small> </label>
					</div>
					<select id="stock_valuation" name="stock_valuation">
						<option value="">-SELECT-</option>
						<option value="Y"
							<c:if test="${not empty parentBean.stock_valuation && parentBean.stock_valuation =='Y'}">selected</c:if>>YES</option>
						<option value="N"
							<c:if test="${not empty parentBean.stock_valuation && parentBean.stock_valuation =='N'}">selected</c:if>>NO</option>
					</select>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="loss_deviation"><small>Effect on the
								profit or loss because of deviation</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="loss_deviation" name="loss_deviation"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.loss_deviation}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amounts not
				credited to the profit and loss account, being></small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="item_section28"><small><fmt:message
									key="oi.section28.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="item_section28" name="item_section28"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.item_section28}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="proforma_credits"><small><fmt:message
									key="oi.proforma.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="proforma_credits" name="proforma_credits"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.proforma_credits}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="escalation_claims"><small><fmt:message
									key="oi.claims.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="escalation_claims" name="escalation_claims"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.escalation_claims}"/>" />
					</div>
				</div>
			</div>

			<div class="row show-grid">
				<div class="col-md-3">
					<div class="other_income">
						<label for="other_income"><small>Any other item of
								income</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="other_income" name="other_income"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_income}"/>" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="capital_receipt">
						<label for="capital_receipt"><small>Capital
								receipt, if any</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="capital_receipt" name="capital_receipt"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.capital_receipt}"/>" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="total_amount">
						<label for="total_amount"><small>Total Amount</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly" id="total_amount"
							name="total_amount"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_amount}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amounts
				debited to the profit and loss account, to the extent disallowable
				u/s 36</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="premiumpaid_damage"><small><fmt:message
									key="oi.damage.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="premiumpaid_damage"
							name="premiumpaid_damage" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.premiumpaid_damage}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="premiumpaid_health"><small>Premium
								paid for insurance on the health of employees</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="premiumpaid_health"
							name="premiumpaid_health" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.premiumpaid_health}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpaid_bonus"><small><fmt:message
									key="oi.sumpaid.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpaid_bonus" name="sumpaid_bonus"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpaid_bonus}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="interest_borrowed"><small><fmt:message
									key="oi.borrowed.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="interest_borrowed" name="interest_borrowed"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.interest_borrowed}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="discount_zerocoupon"><small><fmt:message
									key="oi.zerocoupon.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="discount_zerocoupon"
							name="discount_zerocoupon" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.discount_zerocoupon}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="contributions_provident"><small><fmt:message
									key="oi.contributions.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="contributions_provident"
							name="contributions_provident" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.contributions_provident}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="contributions_superannuation"><small>Amount
								of contributions to an approved superannuation fund</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="contributions_superannuation"
							name="contributions_superannuation" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.contributions_superannuation}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="contributions_gratuity"><small>Amount
								of contributions to an approved gratuity</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="contributions_gratuity"
							name="contributions_gratuity" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.contributions_gratuity}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="contributions_other"><small>Amount of
								contributions to any other fund</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="contributions_other"
							name="contributions_other" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.contributions_other}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_debts"><small>Amount of bad and
								doubtful debts</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_debts" name="amount_debts"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_debts}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="provision_debts"><small>Provision for
								bad and doubtful debts</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="provision_debts" name="provision_debts"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.provision_debts}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_transferred"><small>Amount
								transferred to any special reserve</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_transferred"
							name="amount_transferred" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_transferred}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="expenditure_promoting"><small>Expenditure
								for the purposes of promoting family planning amongst employees</small>
						</label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="expenditure_promoting"
							name="expenditure_promoting" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenditure_promoting}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<label for="sum_received"><small><fmt:message
								key="oi.sumreceived.itr4" /> </small> </label>
				</div>
				<div class="col-md-2">
					<input type="text" id="sum_received" name="sum_received"
						maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sum_received}"/>" />
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="other_disallowance"><small>Any other
								disallowance</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="other_disallowance"
							name="other_disallowance" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_disallowance}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="totalamount_disallowable"><small>Total
								amount disallowable under section 36</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly"
							id="totalamount_disallowable" name="totalamount_disallowable"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_disallowable}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amounts
				debited to the profit and loss account, to the extent disallowable
				under section 37</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="expenditure_personal"><small>Expenditure
								of personal nature</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="expenditure_personal"
							name="expenditure_personal" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenditure_personal}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="expenditure_advertisement"><small><fmt:message
									key="oi.advertisement.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="expenditure_advertisement"
							name="expenditure_advertisement" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenditure_advertisement}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="expenditure_penalty"><small><fmt:message
									key="oi.penalty.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="expenditure_penalty"
							name="expenditure_penalty" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenditure_penalty}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="other_penalty"><small>Any other
								penalty or fine</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="other_penalty" name="other_penalty"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_penalty}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="expenditure_incurred"><small><fmt:message
									key="oi.incurred.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="expenditure_incurred"
							name="expenditure_incurred" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenditure_incurred}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_liability"><small>Amount of any
								liability of a contingent nature</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_liability" name="amount_liability"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_liability}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_expenditure"><small><fmt:message
									key="oi.expenditure.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_expenditure"
							name="amount_expenditure" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_expenditure}"/>" />
					</div>
				</div>
			</div>

			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="other_amountus37"><small>Any other
								amount not allowable under section 37</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="other_amountus37" name="other_amountus37"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_amountus37}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="totalamount_disallowableus37"><small>Total
								amount disallowable under section 37</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly"
							id="totalamount_disallowableus37"
							name="totalamount_disallowableus37" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_disallowableus37}"/>" />
					</div>
				</div>
			</div>

		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amounts
				debited to the profit and loss account, to the extent disallowable
				under section 40</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amountdisallowable_us40A"><small><fmt:message
									key="oi.us40A.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amountdisallowable_us40A"
							name="amountdisallowable_us40A" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amountdisallowable_us40A}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_ratelevied"><small><fmt:message
									key="oi.ratelevied.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_ratelevied" name="amount_ratelevied"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_ratelevied}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_wealthtax"><small>Amount paid
								as wealth tax</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_wealthtax" name="amount_wealthtax"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_wealthtax}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_commission"><small><fmt:message
									key="oi.commission.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_commission" name="amount_commission"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_commission}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="other_disallowance2"><small>Any other
								disallowance</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="other_disallowance2"
							name="other_disallowance2" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_disallowance2}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="amount_disallowanceus40"><small>Total
								amount disallowable under section 40</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly"
							id="amount_disallowanceus40" name="amount_disallowanceus40"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_disallowanceus40}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Any amount
				disallowed under section 40 in any preceding previous year but
				allowable during the previous year</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amountdisallowable_us40B"><small><fmt:message
									key="oi.us40B.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amountdisallowable_us40B"
							name="amountdisallowable_us40B" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amountdisallowable_us40B}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amounts
				debited to the profit and loss account, to the extent disallowable
				under section 40A</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_persons"><small><fmt:message
									key="oi.persons.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_persons" name="amount_persons"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_persons}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="amount_excesstwth"><small><fmt:message
									key="oi.excesstwth.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="amount_excesstwth" name="amount_excesstwth"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_excesstwth}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="provision_gratuity"><small>Provision
								for payment of gratuity</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="provision_gratuity" maxlength="14"
							name="provision_gratuity"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.provision_gratuity}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpaid_assessee"><small><fmt:message
									key="oi.assessee.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpaid_assessee" name="sumpaid_assessee"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpaid_assessee}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="anyother_disallowance"><small>Any
								other disallowance</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="anyother_disallowance"
							name="anyother_disallowance" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.anyother_disallowance}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="totalamount_disallowanceus40"><small>Total
								amount disallowable under section 40A</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly"
							id="totalamount_disallowanceus40"
							name="totalamount_disallowanceus40"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_disallowanceus40}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Any amount
				disallowed under section 43B in any preceding previous year but
				allowable during the previous year</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sum_naturetax"><small><fmt:message
									key="oi.naturetax.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sum_naturetax" name="sum_naturetax"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sum_naturetax}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_provident"><small><fmt:message
									key="oi.provident.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_provident"
							name="sumpayable_provident" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_provident}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_employee"><small><fmt:message
									key="oi.employee.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_employee"
							name="sumpayable_employee" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_employee}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_institution"><small><fmt:message
									key="oi.institution.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_institution"
							name="sumpayable_institution" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_institution}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_bank"><small><fmt:message
									key="oi.bank.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_bank" name="sumpayable_bank"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_bank}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_encashment"><small>Any sum
								payable towards leave encashment</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_encashment"
							name="sumpayable_encashment" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_encashment}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="totalamount_us43"><small>Total amount
								allowable under section 43B</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" readonly="readonly" id="totalamount_us43"
							name="totalamount_us43"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_us43}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Any amount
				debited to profit and loss account of the previous year but
				disallowable under section 43B</small></legend>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sum_naturetax43b"><small>Any sum in
								the nature of tax, duty, cess or fee under any law</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sum_naturetax43b" name="sum_naturetax43b"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sum_naturetax43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_provident43b"><small><fmt:message
									key="oi.provident43b.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_provident43b"
							name="sumpayable_provident43b" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_provident43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_employee43b"><small><fmt:message
									key="oi.employee43b.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_employee43b" maxlength="14"
							name="sumpayable_employee43b"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_employee43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_institution43b"><small><fmt:message
									key="oi.institution43b.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_institution43b" maxlength="14"
							name="sumpayable_institution43b"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_institution43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_bank43b"><small><fmt:message
									key="oi.bank43b.itr4" /></small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_bank43b"
							name="sumpayable_bank43b" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_bank43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="sumpayable_encashment43b"><small>Any
								sum payable towards leave encashment</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" id="sumpayable_encashment43b"
							name="sumpayable_encashment43b" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.sumpayable_encashment43b}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-9">
					<div class="rowlabel">
						<label for="totalamount_us43b"><small>Total amount
								disallowable under Section 43B</small> </label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<input type="text" readonly="readonly" id="totalamount_us43b"
							name="totalamount_us43b"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_us43b}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color"><small>Amount of
				credit outstanding in the accounts in respect of</small></legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="union_excise"><small>Union Excise Duty</small>
						</label>
					</div>
					<div class="rowlabel">
						<input type="text" id="union_excise" name="union_excise"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.union_excise}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="service_tax"><small>Service tax</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="service_tax" name="service_tax"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.service_tax}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="vat_tax"><small>VAT/sales tax</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="vat_tax" name="vat_tax" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.vat_tax}"/>" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="other_tax"><small>Any other tax</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="other_tax" name="other_tax" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_tax}"/>" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="totalamount_outstanding"><small>Total
								amount outstanding</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" readonly="readonly"
							id="totalamount_outstanding" name="totalamount_outstanding"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalamount_outstanding}"/>" />
					</div>
				</div>
			</div>
		</fieldset>
		<table>
			<tr>
				<td>
					<div class="rowlabel">
						<label for="amount_deemed"><small>Amounts deemed
								to be profits and gains under section 33AB or 33ABA or 33AC</small> </label>
					</div>
				</td>
				<td>
					<div class="rowlabel">
						<input type="text" id="amount_deemed" name="amount_deemed"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_deemed}"/>" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="rowlabel">
						<label for="amount_profit"><small>Any amount of
								profit chargeable to tax under section 41</small> </label>
					</div>
				</td>
				<td>
					<div class="rowlabel">
						<input type="text" id="amount_profit" name="amount_profit"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_profit}"/>" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="rowlabel">
						<label for="amount_income"><small><fmt:message
									key="oi.income.itr4" /></small> </label>
					</div>
				</td>
				<td>
					<div class="rowlabel">
						<input type="text" id="amount_income" name="amount_income"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amount_income}"/>" />
					</div>
				</td>
			</tr>
		</table>

		<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<a href="${scriptName}" class="btn btn-default btn-danger"
					style="color: black">Cancel</a>&nbsp; <a
					id="myModalOtherInformation" role="button"
					class="btn btn-default btn-success" style="color: black">Save</a>
			</div>
		</div>

	</form>
</div>
</div>
</div>
<res:calc screenCalc="otherinformation" formId="frmOtherInformation"></res:calc>
<res:client-validation formId="frmOtherInformation"
	screenConfigurationDocumentName="otherinformation"
	formSubmitButtonId="myModalOtherInformation" />