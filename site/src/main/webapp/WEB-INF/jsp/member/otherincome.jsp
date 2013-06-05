<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="otherincometitle">
	<fmt:message key="member.otherincome.title" />
</c:set>
<hippo-gogreen:title title="${otherincometitle}" />


<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page type-page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</h3>
<form name="oi" id="frmIncomeinfo" action="${actionUrl}" method="post">
	<fieldset>
		<legend>
			<fmt:message key="member.interest.tax" />
		</legend>
		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="Gov_income "><fmt:message
							key="member.income.gov" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Gov_income"
						title="Enter income from Govt." class="decimal"
						value="${parentBean.gov_income}" id="Gov_income" onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Kissanpatra "><fmt:message
							key="member.income.kissan" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Kissan" maxlength="14"
						value="${parentBean.kissan}" class="numberinput decimal" id="Kissan"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Bank_interest "><fmt:message
							key="member.bank.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Bank_detail_fdr" maxlength="14"
						value="${parentBean.bank_detail_fdr}" class="numberinput decimal"
						id="Bank_detail_fdr" onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Bank_interest "><fmt:message
							key="member.bank.interest1" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Bank_detail_saving" maxlength="14"
						value="${parentBean.bank_detail_saving}"
						class="numberinput decimal" id="Bank_detail_saving" onchange="cal1()" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">

			<div class="span3">
				<div class="rowlabel">
					<label for="Indira"><fmt:message
							key="member.interest.indiravikas" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Indira" maxlength="14"
						value="${parentBean.indira}" class="numberinput decimal" id="Indira"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="intnsc"><fmt:message key="member.interest.nsc" />
					</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="intnsc" maxlength="14"
						value="${parentBean.intnsc}" class="numberinput decimal" id="intnsc"
						onchange="cal1()" />
				</div>
			</div>

			<div class="span3">
				<div class="rowlabel">
					<label for="Otherint "><fmt:message
							key="member.other.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Otherint" maxlength="14"
						value="${parentBean.otherint}" class="numberinput decimal" id="Otherint"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Totalint "><fmt:message
							key="member.total.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Totalint" value="${parentBean.totalint}"
						class="decimal" id="Totalint" onchange="cal1()" readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>
			<fmt:message key="member.otherincome.message1" />
		</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="Family_pension"><fmt:message
							key="member.family.pension" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Family_pension"
						value="${parentBean.family_pension}" maxlength="14"
						class="numberinput decimal" id="Family_pension" onchange="cal2()" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="Dividends"><fmt:message key="member.dividends" />
					</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Dividends" value="${parentBean.dividends}"
						maxlength="14" class="numberinput decimal" id="Dividends"
						onchange="cal2()" />
				</div>
			</div>


			<%--<c:if test="${empty hideHorseIncome }">
					<td><label for="Lottery_horse_income"><fmt:message
								key="member.income.lottery" /> </label>
					</td>
					<td><input type="hidden" name="Lottery_horse_income"
						value="${parentBean.lottery_horse_income}" maxlength="14"
						class="numberinput" id="a3" onchange="cal2()" />
					</td>
				</c:if> --%>
			<div class="span4">
				<div class="rowlabel">
					<label for="Income_rent_machine"><fmt:message
							key="member.income.rental" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Income_rent_machine"
						value="${parentBean.income_rent_machine}"
						class="numberinput decimal" id="Income_rent_machine" onchange="cal2()"
						maxlength="14" />
				</div>
			</div>
		</div>

		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="Income_rent_machine"><fmt:message
							key="member.income.maintain" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Income_maintain"
						value="${parentBean.income_maintain}" class="numberinput decimal"
						id="Income_maintain" onchange="cal2()" maxlength="14" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Income_other "><fmt:message
							key="member.income.other" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Income_other" maxlength="14"
						value="${parentBean.income_other}" class="numberinput decimal"
						id="Income_other" onchange="cal2()" />
				</div>
			</div>

			<div class="span3">
				<div class="rowlabel">
					<label for="Deduction_57 "><fmt:message
							key="member.income.deduct" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Deduction_57"
						value="${parentBean.deduction_57}" class="numberinput decimal"
						id="Deduction_57" onchange="cal2()" maxlength="14" />
				</div>
			</div>
			<div class="span2">
				<div class="rowlabel">
					<label for="TotalOther_income "><fmt:message
							key="member.income.totalother" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="TotalOther_income"
						value="${parentBean.totalOther_income}" id="TotalOther_income" onchange="cal2()"
						class="decimal" readonly="readonly" />
				</div>
			</div>
		</div>

	</fieldset>
	<fieldset>
		<legend>
			<fmt:message key="member.income.expenses" />
		</legend>
		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="Familypension_deduction "><fmt:message
							key="member.income.deductfamily" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Familypension_deduction" maxlength="14"
						class="numberinput decimal"
						value="${parentBean.familypension_deduction}" id="Familypension_deduction"
						onchange="cal3()" readonly="readonly" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Otherdeduction "><fmt:message
							key="member.income.others" /> </label>
				</div>

				<div class="rowlabel">
					<input type="text" name="Otherdeduction" maxlength="14"
						value="${parentBean.otherdeduction}" class="numberinput decimal"
						id="Otherdeduction" onchange="cal3()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">


					<label for="depreciation"><fmt:message
							key="member.income.depreciation" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="depreciation" maxlength="14"
						value="${parentBean.depreciation}" class="numberinput decimal"
						id="depreciation" onchange="cal3()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="totalexpense "><fmt:message
							key="member.total.expenses" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="totalexpense" maxlength="14"
						value="${parentBean.totalexpense}" id="totalexpense" onchange="cal3()"
						class="decimal" readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend>
			<fmt:message key="member.income.taxfree" />
		</legend>
		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="Dividends_uti"><fmt:message
							key="member.div.uti" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Dividends_uti"
						value="${parentBean.dividends_uti}" class="numberinput decimal"
						maxlength="14" id="Dividends_uti" onchange="cal4()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Interest_income"><fmt:message
							key="member.income.intincome" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Interest_income"
						value="${parentBean.interest_income}" class="numberinput decimal"
						id="Interest_income" onchange="cal4()" maxlength="14" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Dividends_mutualfund"><fmt:message
							key="member.div.mutual" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Dividends_mutualfund"
						value="${parentBean.dividends_mutualfund}"
						class="numberinput decimal" id="Dividends_mutualfund" onchange="cal4()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Agriculture_income"><fmt:message
							key="member.income.agriculture" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Agriculture_income"
						value="${parentBean.agriculture_income}"
						class=" decimal" id="Agriculture_income" onchange="cal4()"
						maxlength="14" />
				</div>
			</div>
		</div>
		
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="Dividends_indian_companies"><fmt:message
							key="member.div.indian" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Dividends_indian_companies"
						value="${parentBean.dividends_indian_companies }"
						class=" decimal" id="Dividends_indian_companies" onchange="cal4()"
						maxlength="14" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="Other_income "><fmt:message
							key="member.other.income" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Otherincome"
						value="${parentBean.otherincome}" maxlength="14"
						class="decimal" id="Otherincome" onchange="cal4()" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="Total_taxfree_income "><fmt:message
							key="member.total.otherincome" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Total_taxfree_income"
						value="${parentBean.total_taxfree_income}"
						class="decimal" id="Total_taxfree_income" onchange="cal4()"
						maxlength="14" readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<div class="row-fluid show-grid">
		<div class="span4">
			<div class="rowlabel">
				<label for="Taxable_income "><fmt:message
						key="member.taxable.income" /> </label>
			</div>
			<div class="rowlabel">
				<input type="text" name="Taxable_income" class="decimal"
					value="${parentBean.taxable_income}" id="Taxable_income" onblur="cal5()"
					readonly="readonly" />
			</div>
		</div>
	</div>

	<div class="row-fluid show-grid">
		<div class="span4 offset8 decimal">

			<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;<input
				type="submit" value="Save" style="color: orange">

		</div>
	</div>
</form>
</div>
<res:client-validation formId="frmIncomeinfo" screenConfigurationDocumentName="otherincome" formSubmitButtonId="myModalHrefFormSixteen" />
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>

		$(document).ready(function() {
		$('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
         });
                 var statekey=$("#statekey").val();
                if(statekey!=null){
                 $("#pi_state").val(statekey);
                  };
                  
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:calc screenCalc="otherincome" formId="frmIncomeinfo"></res:calc>
<res:client-validation formId="frmdataSlryInc"
	screenConfigurationDocumentName="salaryincome"
	formSubmitButtonId="myModalHrefSlryInc" />
