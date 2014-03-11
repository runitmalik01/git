<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="b_p">
	Schedule BP
</c:set>
<hippo-gogreen:title title="${b_p}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<fmt:message key="income.bp.itr4" var="subTitle"/>
	<w4india:titleandnav title="Schedule BP" subTitle="Schedule BP&nbsp;-&nbsp;${subTitle}"/>
	
	<hst:link var="mainSiteMapRefId" />
	<form id="frmIncomeBP" action="${actionUrl}" method="post"
		name="frmIncomeBP">
		<fieldset>
			<legend class="header-color">
				<small><fmt:message
						key="income.from.BP.otherthan.speculative" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="profitBeforeTax"><small><fmt:message
									key="profitBeforeTax.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="profitBeforeTax" name="profitBeforeTax" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${profitBeforeTax}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="profitLoss_SpecualtiveBusiness"><small><fmt:message
									key="profitLoss_SpecualtiveBusiness.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="profitLoss_SpecualtiveBusiness"
							name="profitLoss_SpecualtiveBusiness" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profitLoss_SpecualtiveBusiness}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="profitLoss_SpecifiedBusiness"><small><fmt:message
									key="profitLoss_SpecifiedBusiness.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="profitLoss_SpecifiedBusiness"
							name="profitLoss_SpecifiedBusiness" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profitLoss_SpecifiedBusiness}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="incomeCredited_ProfitLossAcc"><small><fmt:message
									key="incomeCredited_ProfitLossAcc.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="incomeCredited_ProfitLossAcc"
							name="incomeCredited_ProfitLossAcc" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.incomeCredited_ProfitLossAcc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="profitLoss_IncludeSchPL"><small><fmt:message
									key="profitLoss_IncludeSchPL.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="profitLoss_IncludeSchPL" name="profitLoss_IncludeSchPL"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${profitLoss_IncludeSchPL}" />" />
					</div>
				</div>
			</div>
			<fieldset>
				<legend class="header-color">
					<small><fmt:message key="income.credited.to.PL" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="shareIncome_Firms"><small><fmt:message
										key="shareIncome_Firms.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="shareIncome_Firms" name="shareIncome_Firms"
								type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.shareIncome_Firms}" />" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="shareIncome_Firms_AOP"><small><fmt:message
										key="shareIncome_Firms_AOP.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="shareIncome_Firms_AOP" name="shareIncome_Firms_AOP"
								type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.shareIncome_Firms_AOP}" />" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="exemptIncome_AnyOther"><small><fmt:message
										key="exemptIncome_AnyOther.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="exemptIncome_AnyOther" name="exemptIncome_AnyOther"
								type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.exemptIncome_AnyOther}" />" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="total_ExemptIncome"><small><fmt:message
										key="total_ExemptIncome.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="total_ExemptIncome" name="total_ExemptIncome"
								readonly="readonly" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_ExemptIncome}" />" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="balance"><small><b><fmt:message
											key="balance.bp.itr4" /> </b> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="balance" name="balance" readonly="readonly"
								type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${BalancePLOthThanSpecBus}" />" />
						</div>
					</div>
				</div>
			</fieldset>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="expenseDebit_HeadsInc"><small><fmt:message
									key="expenseDebit_HeadsInc.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="expenseDebit_HeadsInc" name="expenseDebit_HeadsInc"
							type="text" maxlength="14"
							value="${parentBean.expenseDebit_HeadsInc}" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="expenseDebit_ExemptInc"><small><fmt:message
									key="expenseDebit_ExemptInc.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="expenseDebit_ExemptInc" name="expenseDebit_ExemptInc"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.expenseDebit_ExemptInc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="total_Expense"><small><fmt:message
									key="total_Expense.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="total_Expense" name="total_Expense" readonly="readonly"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_Expense}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="adjusted_ProfitLoss"><small><fmt:message
									key="adjusted_ProfitLoss.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="adjusted_ProfitLoss" name="adjusted_ProfitLoss"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${AdjustedPLOthThanSpecBus}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="depreciation_PL"><small><fmt:message
									key="depreciation_PL.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="depreciation_PL" name="depreciation_PL" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${depreciation_PL}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="depreAllow_us32_1_i"><small><fmt:message
									key="depreAllow_us32_1_i.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="depreAllow_us32_1_i" name="depreAllow_us32_1_i"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${depreAllow_us32_1_ii}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="depreAllow_us32_1_ii"><small><fmt:message
									key="depreAllow_us32_1_ii.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="depreAllow_us32_1_ii" name="depreAllow_us32_1_ii"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.depreAllow_us32_1_ii}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="depreciation_total"><small><fmt:message
									key="depreciation_total.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="depreciation_total" name="depreciation_total"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${TotDeprAllowITAct}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="plAfter_AdjustDepr"><small><fmt:message
									key="plAfter_AdjustDepr.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="plAfter_AdjustDepr" name="plAfter_AdjustDepr"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${AdjustPLAfterDeprOthSpecInc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDebit_sec36"><small><fmt:message
									key="amountDebit_sec36.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDebit_sec36" name="amountDebit_sec36" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDebit_sec36}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDebit_sec37"><small><fmt:message
									key="amountDebit_sec37.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDebit_sec37" name="amountDebit_sec37" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDebit_sec37}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDebit_sec40"><small><fmt:message
									key="amountDebit_sec40.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDebit_sec40" name="amountDebit_sec40" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDebit_sec40}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDebit_sec40A"><small><fmt:message
									key="amountDebit_sec40A.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDebit_sec40A" name="amountDebit_sec40A"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDebit_sec40A}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDebit_sec43B"><small><fmt:message
									key="amountDebit_sec43B.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDebit_sec43B" name="amountDebit_sec43B"
							type="text" maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDebit_sec43B}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="interestDisallow_sec23"><small><fmt:message
									key="interestDisallow_sec23.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="interestDisallow_sec23" name="interestDisallow_sec23"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.interestDisallow_sec23}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="deemedIncome_Sec41"><small><fmt:message
									key="deemedIncome_Sec41.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="deemedIncome_Sec41" name="deemedIncome_Sec41"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deemedIncome_Sec41}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="deemedIncome_Sec33AB"><small><fmt:message
									key="deemedIncome_Sec33AB.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="deemedIncome_Sec33AB" name="deemedIncome_Sec33AB"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deemedIncome_Sec33AB}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="addItem_sec28to44DA"><small><fmt:message
									key="addItem_sec28to44DA.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="addItem_sec28to44DA" name="addItem_sec28to44DA"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.addItem_sec28to44DA}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="anyIncNotInclude_PLAcc"><small><fmt:message
									key="anyIncNotInclude_PLAcc.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="anyIncNotInclude_PLAcc" name="anyIncNotInclude_PLAcc"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.anyIncNotInclude_PLAcc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="totalIncome_sec"><small><fmt:message
									key="totalIncome_sec.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="totalIncome_sec" name="totalIncome_sec"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${TotAfterAddToPLDeprOthSpecInc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="deductionAllow_Sec32_1_iii"><small><fmt:message
									key="deductionAllow_Sec32_1_iii.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="deductionAllow_Sec32_1_iii"
							name="deductionAllow_Sec32_1_iii" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deductionAllow_Sec32_1_iii}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDed_Sec35"><small><fmt:message
									key="amountDed_Sec35.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDed_Sec35" name="amountDed_Sec35" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDed_Sec35}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDisAllow_Sec40"><small><fmt:message
									key="amountDisAllow_Sec40.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDisAllow_Sec40" name="amountDisAllow_Sec40"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDisAllow_Sec40}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="amountDisAllow_Sec43B"><small><fmt:message
									key="amountDisAllow_Sec43B.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="amountDisAllow_Sec43B" name="amountDisAllow_Sec43B"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${amountDisAllow_Sec43B}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small><fmt:message key="deduction.section.35AC" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="amountDebited_ToProfitLoss"><small><fmt:message
									key="amountDebited_ToProfitLoss.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="amountDebited_ToProfitLoss"
							name="amountDebited_ToProfitLoss" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amountDebited_ToProfitLoss}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="amountAllow_Deduction"><small><fmt:message
									key="amountAllow_Deduction.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="amountAllow_Deduction" name="amountAllow_Deduction"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amountAllow_Deduction}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="excessAmountAllow_Deduction"><small><fmt:message
									key="excessAmountAllow_Deduction.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="excessAmountAllow_Deduction"
							name="excessAmountAllow_Deduction" type="text" maxlength="14"
							readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.excessAmountAllow_Deduction}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="anyOtherAmountAllow_Deduction"><small><fmt:message
									key="anyOtherAmountAllow_Deduction.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="anyOtherAmountAllow_Deduction"
							name="anyOtherAmountAllow_Deduction" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.anyOtherAmountAllow_Deduction}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="total_Deduction"><small><fmt:message
									key="total_Deduction.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_Deduction" name="total_Deduction" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${TotDeductionAmts}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="income_AfterDed"><small><fmt:message
									key="income_AfterDed.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_AfterDed" name="income_AfterDed" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${PLAftAdjDedBusOthThanSpec}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small><fmt:message key="profit.gains.of.business" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44AD"><small><fmt:message
									key="section44AD.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44AD" name="section44AD" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44AD}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44AE"><small><fmt:message
									key="section44AD.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44AE" name="section44AE" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44AE}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44AF"><small><fmt:message
									key="section44AF.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44AF" name="section44AF" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44AF}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44B"><small><fmt:message
									key="section44B.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44B" name="section44B" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44B}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44BB"><small><fmt:message
									key="section44BB.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44BB" name="section44BB" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44BB}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44BBA"><small><fmt:message
									key="section44BBA.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44BBA" name="section44BBA" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44BBA}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44BBB"><small><fmt:message
									key="section44BBB.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44BBB" name="section44BBB" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44BBB}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44D"><small><fmt:message
									key="section44D.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44D" name="section44D" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44D}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="section44DA"><small><fmt:message
									key="section44DA.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="section44DA" name="section44DA" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.section44DA}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="chapter_XII_G"><small><fmt:message
									key="chapter_XII_G.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="chapter_XII_G" name="chapter_XII_G" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.chapter_XII_G}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="firstSchedule_ITAct"><small><fmt:message
									key="firstSchedule_ITAct.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="firstSchedule_ITAct" name="firstSchedule_ITAct"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.firstSchedule_ITAct}" />" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="total_Sections"><small><fmt:message
									key="total_Sections.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_Sections" name="total_Sections" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_Sections}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small><fmt:message key="Deduction.under.section" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="plBefore_DedUs10A"><small><fmt:message
									key="plBefore_DedUs10A.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="plBefore_DedUs10A" name="plBefore_DedUs10A" type="text"
							maxlength="14" readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${ProfitLossBfrDeductUs10S}" />" />
					</div>
				</div>

				<div class="col-md-6">
					<div class="rowlabel">
						<label for="deduction_Sec10A"><small><fmt:message
									key="deduction_Sec10A.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="deduction_Sec10A" name="deduction_Sec10A" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${deduction_Sec10A}" />" />
					</div>
				</div>
			</div>

			<div class="row show-grid">
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="deduction_Sec10AA"><small><fmt:message
									key="deduction_Sec10AA.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="deduction_Sec10AA" name="deduction_Sec10AA" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${deduction_Sec10AA}" />" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="deduction_total10"><small><fmt:message
									key="deduction_total10.bp.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="deduction_total10" name="deduction_total10"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deduction_total10}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<div class="row show-grid">
			<div class="col-md-8">
				<div class="rowlabel">
					<label for="netPL_FromBussProf"><small>Net profit
							or loss from business or profession other than speculative
							business and specified business </small> </label>
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<input id="netPL_FromBussProf" name="netPL_FromBussProf"
						readonly="readonly" type="text" maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${NetPLAftAdjBusOthThanSpec}" />" />
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-6">
				<div class="rowlabel">
					<label for="netPL_otherthanSpeculative_SpecifiedBuss"><small><fmt:message
								key="netPL_otherthanSpeculative_SpecifiedBuss.bp.itr4" /> </small> </label>
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<input id="netPL_otherthanSpeculative_SpecifiedBuss"
						name="netPL_otherthanSpeculative_SpecifiedBuss" type="text"
						maxlength="14"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.netPL_otherthanSpeculative_SpecifiedBuss}" />" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<input id="netPL_otherthanSpeculative_SpecifiedBuss1"
						name="netPL_otherthanSpeculative_SpecifiedBuss1" type="text"
						maxlength="14" readonly="readonly"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${NetPLBusOthThanSpec7A7B7C}" />" />
				</div>
			</div>
		</div>
		<fieldset>
			<legend class="header-color">
				<small><fmt:message
						key="compute.income.speculative.business" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="netPl_FromBP"><small><fmt:message
									key="netPl_FromBP.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="netPl_FromBP" name="netPl_FromBP" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${netPl_FromBP}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="addAccordance_28to44DA"><small><fmt:message
									key="addAccordance_28to44DA.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="addAccordance_28to44DA" name="addAccordance_28to44DA"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.addAccordance_28to44DA}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="dedAccordance_28to44DA"><small><fmt:message
									key="dedAccordance_28to44DA.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="dedAccordance_28to44DA" name="dedAccordance_28to44DA"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dedAccordance_28to44DA}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="pl_SpeculativeBuss"><small><fmt:message
									key="pl_SpeculativeBuss.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="pl_SpeculativeBuss" name="pl_SpeculativeBuss"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${AdjustedPLFrmSpecuBus}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small><fmt:message
						key="compute.business.speculative.business"></fmt:message></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="netPLFrom_SPecifiedInc"><small><fmt:message
									key="netPLFrom_SPecifiedInc.pl.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="netPLFrom_SPecifiedInc" name="netPLFrom_SPecifiedInc"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${netPLFrom_SPecifiedInc}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="additionAcc28to44D"><small><fmt:message
									key="additionAcc28to44D.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="additionAcc28to44D" name="additionAcc28to44D"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.additionAcc28to44D}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="dedAcc28to44DEx35AD"><small><fmt:message
									key="dedAcc28to44DEx35AD.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="dedAcc28to44DEx35AD" name="dedAcc28to44DEx35AD"
							type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dedAcc28to44DEx35AD}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="pl_SpecifiedBuss"><small><fmt:message
									key="pl_SpecifiedBuss.pl.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="pl_SpecifiedBuss" name="pl_SpecifiedBuss"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${ProfitLossSpecifiedBusiness}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="dedAcc35AD"><small><fmt:message
									key="dedAcc35AD.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="dedAcc35AD" name="dedAcc35AD" type="text"
							maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dedAcc35AD}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="pl_SpecifiedBussNet"><small><fmt:message
									key="pl_SpecifiedBussNet.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="pl_SpecifiedBussNet" name="pl_SpecifiedBussNet"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${PLFrmSpecifiedBus}" />" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="incomeChargeable_PL"><small><fmt:message
									key="incomeChargeable_PL.bp.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<input id="incomeChargeable_PL" name="incomeChargeable_PL"
							readonly="readonly" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${IncChrgUnHdProftGain}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
				<a id="myModalProfitAndLoss" role="button"
					class="btn btn-default btn-success">Save</a>
			</div>
		</div>
	</form>
</div>
</div>
</div>

<res:calc screenCalc="incbusinessprofession" formId="frmIncomeBP" />
<res:client-validation formId="frmIncomeBP"
	screenConfigurationDocumentName="incomebusinessprofession"
	formSubmitButtonId="myModalProfitAndLoss" />

