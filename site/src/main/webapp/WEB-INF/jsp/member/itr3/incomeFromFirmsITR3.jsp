<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="incFirms">
	<fmt:message key="incFirms" />
</c:set>
<hippo-gogreen:title title="${incFirms}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />
<c:if test="${not empty InCorrectPan}">
<div class="alert alert-error">

<fmt:message key="not.valid.Pan"> </fmt:message>
</div>

</c:if>

<c:if test="${not empty ITR1_FIRM_PAN}">
		<div class="alert alert-error">
			<fmt:message key="${ITR1_FIRM_PAN}" />
		</div>
	</c:if>

<h4>
	<fmt:message key="member.income.from.firms.itr3" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmIncFirms" action="${actionUrl}" method="post"
			name="frmIncFirms">

		<fieldset>
			<legend style="color: green; font-weight: bold;">Enter Details</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="firm_PAN"><small><fmt:message
									key="firm_PAN.schBP.ITR3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="firm_PAN" name="firm_PAN" class="uprcase"
							type="text" maxlength="10"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.firm_PAN}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="salary_BonusRcv"><small><fmt:message
									key="salary_BonusRcv.schBP.itr3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="salary_BonusRcv" name="salary_BonusRcv"
							type="text" maxlength="14" class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.salary_BonusRcv}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="interest_Rcv"><small><fmt:message
									key="interest_Rcv.schBP.itr3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="interest_Rcv" name="interest_Rcv"
							type="text" maxlength="14" class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.interest_Rcv}"/></c:if>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">

				<div class="span4">
					<div class="rowlabel">
						<label for="total_SalaryAndInterest"><small><fmt:message
									key="total_SalaryAndInterest.schBP.itr3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_SalaryAndInterest" name="total_SalaryAndInterest"
							type="text" maxlength="14" readonly="readonly"
							class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.total_SalaryAndInterest}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="expenses_RelTotal"><small><fmt:message
									key="expenses_RelTotal.schBP.itr3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="expenses_RelTotal" name="expenses_RelTotal" type="text"
							maxlength="14"  class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.expenses_RelTotal}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="netIncome"><small><fmt:message
									key="netIncome.schBP.itr3" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="netIncome" name="netIncome" type="text"
							maxlength="14"   class="decimal" readonly="readonly"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.netIncome}"/></c:if>" />
					</div>
				</div>
			</div></fieldset>

			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
					<a id="myModalIncFirms" role="button" class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered">
			<tr align="center">
				<th><b><fmt:message key="firm_PAN.schBP.ITR3" /> </b>
				</th>
				<th align="left"><b>Salary, Bonus, Commission</b>
				</th>
				<th align="left"><b><fmt:message key="interest_Rcv.schBP.itr3" /> </b></th>
				<th><b><fmt:message key="total_SalaryAndInterest.schBP.itr3" /> </b></th>
				<th align="left"><b><fmt:message key="expenses_RelTotal.schBP.itr3" /> </b></th>
				<th><b><fmt:message key="netIncome.schBP.itr3" /> </b></th>

				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.incFromFirmsDetailList}"
					var="incFromFirms">
					<tr>
						<td><c:out value="${incFromFirms.firm_PAN}" />
						</td>
						<td><w4india:inr value="${incFromFirms.salary_BonusRcv}" />
						</td>
						<td><w4india:inr value="${incFromFirms.interest_Rcv}" />
						</td>
						<td><w4india:inr value="${incFromFirms.total_SalaryAndInterest}" />
						</td>
						<td><w4india:inr value="${incFromFirms.expenses_RelTotal}" />
						</td>
						<td><w4india:inr value="${incFromFirms.netIncome}" />
						</td>
						<td><a class="btn btn-primary" href="${scriptName}/<c:out value="${incFromFirms.canonicalUUID}"/>/incomefromfirmsItr3edit"><small><i class="icon-pencil icon-white"></i>Edit</small>&nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-danger" href="${scriptName}/<c:out value="${incFromFirms.canonicalUUID}"/>/incomefromfirmsItr3delete" id="delete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="1"><b>Total</b></td>
					<td><w4india:inr value="${parentBean.val_Salary}" /></td>
					<td><w4india:inr value="${parentBean.val_InterestRcv}" /></td>
					<td><w4india:inr value="${parentBean.val_salaryAndIntrst}" /></td>
					<td><w4india:inr value="${parentBean.val_Expense}" /></td>
					<td><w4india:inr value="${parentBean.val_NetIncome}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/incomefromfirmsItr3new"
			class="btn btn-info" style="color: black">Add New</a>
	</c:otherwise>
</c:choose>
</div>

<script>
$(document).ready( function() {
	var linkURL = '<c:out value="${fn:substringBefore(scriptName,pan)}${pan}${itrFolderSuffix}/${pan}/firmspartner.html"/>';
	$("#panError").attr("href",linkURL);
});

</script>

<res:calc screenCalc="incfromfirms" formId="frmIncFirms"></res:calc>
<res:client-validation formId="frmIncFirms"
	screenConfigurationDocumentName="incfromfirms"
	formSubmitButtonId="myModalIncFirms"/>

