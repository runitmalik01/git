<%@include file="../includes/tags.jspf"%>
<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="tds2" />
</c:set>
<hippo-gogreen:title title="${tds2}" />

<hst:actionURL var="actionUrl" />
<script type="text/javascript">
	function keyup() {
		var x = document.getElementById("tan_employer");
		x.value = x.value.toUpperCase();
	}
</script>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:link var="mainSiteMapRefId" />

<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan);
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="tdsfromsalary" action="${actionUrl}" method="post"
			name="tdsfromsalary">
			<h2>Enter Details</h2>
			<table class="personal_info">
				<tr height="30px">
					<td class="label"><fmt:message key="tds.tan.emoloyer" /></td>
					<td class="input"><input type="text" name="tan_employer"
						onkeyup="keyup()" id="tan_employer"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Employer}"/></c:if>"
						id="cost" maxlength="10"
						title="This field accept first four alphabate next five numeric then single alphabate"
						placeholder="10 Characters" />
					</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.name.employer" /></td>
					<td class="input"><input type="text" name="name_employer"
						id="sale"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Employer}"/></c:if>"
						maxlength="14" required="required" maxlength="125"
						title="Please fill alphabets only" />
					</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.income.chargeable" />
					</td>
					<td class="input"><input type="text" name="income_chargeable"
						required="required" maxlength="14"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_Chargeable}"/></c:if>"
						id="income_chargeable">
					</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.total.tax.deducted" />
					</td>
					<td class="input"><input type="text" name="total_taxdeducted"
						maxlength="14"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_TaxDeducted}"/></c:if>"
						required="required" id="consideration" />
					</td>
				</tr>

			</table>
			<a href="${redirectURLToSamePage}" class="button olive">Cancel</a><input
				type="submit" class="button orange" id="myModalHref" value="Save">

		</form>

	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b>TAN of Employer</b></th>
				<th><b>Name of Employer</b></th>
				<th><b>Income Chargeable under head salaries</b></th>
				<th><b>Total tax Deducted</b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.tdsSalaryDetailList}"
					var="tdsfromsalarydetail">
					<tr>
						<td><c:out value="${tdsfromsalarydetail.tan_Employer}" /></td>

						<td><c:out value="${tdsfromsalarydetail.name_Employer}" /></td>
						<td><c:out value="${tdsfromsalarydetail.income_Chargeable}" />
						</td>
						<td><c:out value="${tdsfromsalarydetail.total_TaxDeducted}" />
						</td>

						<td><a
							href="${redirectURLToSamePage}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/tdsfromsalaryedit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/tdsfromsalarydelete"><small>Delete</small>
						</a></td>

					</tr>
				</c:forEach>
				<tr>
					<td><fmt:message key="tds.amount.total.deducted" /></td>
					<td><input type="text" name="total_value"
						value="${parentBean.total_Amount}"></td>
				</tr>
			</c:if>
		</table>
		<a href="${redirectURLToSamePage}/tdsfromsalarynew" class="button orange">Add
			New</a>

	</c:otherwise>
</c:choose>

<res:client-validation formId="tdsfromsalary"
	screenConfigurationDocumentName="tdsfromsalary"
	formSubmitButtonId="myModalHref" />