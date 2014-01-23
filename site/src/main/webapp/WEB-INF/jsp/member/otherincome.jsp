<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="otherincometitle">
	<fmt:message key="member.otherincome.title" />
</c:set>
<hippo-gogreen:title title="${otherincometitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<style>
label {
	font-size: smaller;
	9
	px
}
</style>
<div class="page type-page">
	<w4india:itrmenu />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty Max_allowed_ITR1}">
		<div class="alert alert-danger">
			<fmt:message key="${Max_allowed_ITR1}" />
		</div>
	</c:if>
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>
				<h2 class="page-title">Other Sources Income</h2>
			</c:otherwise>
		</c:choose>
	</h3>
	<form name="oi" id="frmIncomeinfo" action="${actionUrl}" method="post">
		<fieldset>
			<legend class="header-color">
				<small> <fmt:message key="member.interest.tax" /></small>
			</legend>

			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Gov_income "><fmt:message
								key="member.income.gov" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Gov_income"
							title="Enter income from Govt." class="decimal" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.gov_income}"/>"
							id="Gov_income" onchange="cal1()" />

					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Kissanpatra "><fmt:message
								key="member.income.kissan" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Kissan" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.kissan}"/>"
							id="Kissan" onchange="cal1()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Bank_interest "><fmt:message
								key="member.bank.interest" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Bank_detail_fdr" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.bank_detail_fdr}" />"
							class="decimal" id="Bank_detail_fdr" onchange="cal1()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Bank_interest "><fmt:message
								key="member.bank.interest1" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Bank_detail_saving" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.bank_detail_saving}"/>"
							class=" decimal" id="Bank_detail_saving" onchange="cal1()" />
					</div>
				</div>
			</div>
			<div class="row show-grid">

				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Indira"><fmt:message
								key="member.interest.indiravikas" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Indira" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.indira}" />"
							class=" decimal" id="Indira" onchange="cal1()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="intnsc"><fmt:message key="member.interest.nsc" />
						</label>
					</div>
					<div class="rowlabel">
						<input type="text" name="intnsc" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.intnsc}" />"
							class=" decimal" id="intnsc" onchange="cal1()" />
					</div>
				</div>

				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Otherint "><fmt:message
								key="member.other.interest" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Otherint" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.otherint}" />"
							class="decimal" id="Otherint" onchange="cal1()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Totalint "><fmt:message
								key="member.total.interest" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Totalint"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalint}"/>"
							class="decimal" id="Totalint" onchange="cal1()"
							readonly="readonly" />
					</div>
				</div>
			</div>
		</fieldset>

		<fieldset>
			<legend class="header-color">
				<small> <fmt:message key="member.otherincome.message1" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Family_pension"><fmt:message
								key="member.family.pension" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Family_pension"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.family_pension}"/>"
							maxlength="14" class=" decimal" id="Family_pension"
							onchange="cal2()" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Dividends"><fmt:message key="member.dividends" />
						</label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Dividends"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dividends}"/>"
							maxlength="14" class=" decimal" id="Dividends" onchange="cal2()" />
					</div>
				</div>

				<!--

			<c:if test="${not empty  ITR2}">
					<td><label for="Lottery_horse_income"><fmt:message
								key="member.income.lottery" /> </label>
					</td>
					<td><input type="text" name="Lottery_horse_income"
						value="${parentBean.lottery_horse_income}" maxlength="14"
						class="" id="a3" onchange="cal2()" />
					</td>
				</c:if>
				 -->

				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Income_rent_machine"><fmt:message
								key="member.income.rental" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Income_rent_machine"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.income_rent_machine}"/>"
							class=" decimal" id="Income_rent_machine" onchange="cal2()"
							maxlength="14" />
					</div>
				</div>
			</div>

			<div class="row show-grid">

				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Income_other "><fmt:message
								key="member.income.other" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Income_other" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.income_other}"/>"
							class=" decimal" id="Income_other" onchange="cal2()" />
					</div>
				</div>

				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Deduction_57 "><fmt:message
								key="member.income.deduct" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Deduction_57"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deduction_57}"/>"
							class=" decimal" id="Deduction_57" onchange="cal2()"
							maxlength="14" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="TotalOther_income "><fmt:message
								key="member.income.totalother" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="TotalOther_income"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalOther_income}" />"
							id="TotalOther_income" onchange="cal2()" class="decimal"
							readonly="readonly" />
					</div>
				</div>
			</div>

		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small> <fmt:message key="member.income.expenses" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Familypension_deduction "><fmt:message
								key="member.income.deductfamily" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Familypension_deduction" maxlength="14"
							class=" decimal"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.familypension_deduction}"/>"
							id="Familypension_deduction" onchange="cal3()"
							readonly="readonly" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Otherdeduction "><fmt:message
								key="member.income.others" /> </label>
					</div>

					<div class="rowlabel">
						<input type="text" name="Otherdeduction" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.otherdeduction}" />"
							class=" decimal" id="Otherdeduction" onchange="cal3()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="depreciation"><fmt:message
								key="member.income.depreciation" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="depreciation" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.depreciation}"/>"
							class=" decimal" id="depreciation" onchange="cal3()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="totalexpense "><fmt:message
								key="member.total.expenses" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="totalexpense" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.totalexpense}"/>"
							id="totalexpense" onchange="cal3()" class="decimal"
							readonly="readonly" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend class="header-color">
				<small> <fmt:message key="member.income.taxfree" /></small>
			</legend>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Dividends_uti"><fmt:message
								key="member.div.uti" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Dividends_uti"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dividends_uti}" />"
							class=" decimal" maxlength="14" id="Dividends_uti"
							onchange="cal4()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Interest_income"><fmt:message
								key="member.income.intincome" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Interest_income"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.interest_income}"/>"
							class=" decimal" id="Interest_income" onchange="cal4()"
							maxlength="14" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Dividends_mutualfund"><fmt:message
								key="member.div.mutual" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Dividends_mutualfund"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dividends_mutualfund}"/>"
							class=" decimal" id="Dividends_mutualfund" onchange="cal4()" />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="Agriculture_income"><fmt:message
								key="member.income.agriculture" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Agriculture_income"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.agriculture_income}"/>"
							class=" decimal" id="Agriculture_income" onchange="cal4()"
							maxlength="14" />
					</div>
				</div>
			</div>

			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Dividends_indian_companies"><fmt:message
								key="member.div.indian" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Dividends_indian_companies"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.dividends_indian_companies }"/>"
							class=" decimal" id="Dividends_indian_companies"
							onchange="cal4()" maxlength="14" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Other_income ">Others(including exempt income
							of minor child) </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Otherincome"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.otherincome}"/>"
							maxlength="14" class="decimal" id="Otherincome" onchange="cal4()" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Total_taxfree_income "><fmt:message
								key="member.total.otherincome" /> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="Total_taxfree_income"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total_taxfree_income}"/>"
							class="decimal" id="Total_taxfree_income" onchange="cal4()"
							maxlength="14" readonly="readonly" />
					</div>
				</div>
			</div>
		</fieldset>
		<!-- this jsp is added for only -->
		<c:if test="${not empty  ITR2}">
			<jsp:include page="otherIncome_add.jsp"></jsp:include>
		</c:if>
		<div class="row show-grid">
			<c:if test="${(not empty ITR3_4)}">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="profit_FirmAOP_BOI ">Share in the profit of
							firm/AOP/BOI etc. </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="profit_FirmAOP_BOI" class="decimal"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.profit_FirmAOP_BOI}"/>"
							id="profit_FirmAOP_BOI" />
					</div>
				</div>
			</c:if>

			<div class="col-md-4">
				<div class="rowlabel">
					<label for="Taxable_income "><fmt:message
							key="member.taxable.income" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Taxable_income" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.taxable_income}"/>"
						id="Taxable_income" onblur="cal5()" readonly="readonly" />
				</div>
			</div>
		</div>

		<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
				<a id="myModalHrefothrInc" role="button"
					class="btn btn-default btn-success">Save</a>

			</div>
		</div>
	</form>
</div>
<res:client-validation formId="frmIncomeinfo"
	screenConfigurationDocumentName="otherincome"
	formSubmitButtonId="myModalHrefFormSixteen" />
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>

		$(document).ready(function() {

                 var statekey=$("#statekey").val();
                if(statekey!=null){
                 $("#pi_state").val(statekey);
                  };

		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:calc screenCalc="otherincome" formId="frmIncomeinfo"></res:calc>
<res:client-validation formId="frmIncomeinfo"
	screenConfigurationDocumentName="otherincome"
	formSubmitButtonId="myModalHrefothrInc" />
