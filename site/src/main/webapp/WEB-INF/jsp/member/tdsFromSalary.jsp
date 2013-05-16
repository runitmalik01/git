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
<h4>
	<fmt:message key="member.tds.from.salary" />
</h4>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:link var="mainSiteMapRefId" />

<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdata" action="${actionUrl}" method="post"
			name="tdsfromsalary">
			<fieldset>
				<legend style="color: black">Enter Details</legend>
			<div class="row-fluid show-grid" >
						<div class="span4">
			            <div class="rowlabel"><label for="tan_employer"><small><fmt:message key="tds.tan.emoloyer" /></small></label></div>
			          	<div class="rowlabel"><input id="tan_employer" name="tan_employer" type="text" maxlength="10" onkeyup="keyup()"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Employer}"/></c:if>"/></div>
			          </div>
			          <div class="span4">
			            <div class="rowlabel"><label for="name_employer"><small><fmt:message key="tds.name.employer" /></small></label></div>
			          	<div class="rowlabel"><input id="name_employer" name="name_employer" type="text" maxlength="125"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Employer}"/></c:if>"/></div>
			          </div></div>
			          <div class="row-fluid show-grid" >
			           <div class="span4">
			            <div class="rowlabel"><label for="income_chargeable"><small><fmt:message key="tds.income.chargeable" /></small></label></div>
			          	<div class="rowlabel"><input id="income_chargeable" name="income_chargeable" type="text" maxlength="14"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_Chargeable}"/></c:if>"/></div>
			          </div>
			           <div class="span4">
			            <div class="rowlabel"><label for="total_taxdeducted"><small><fmt:message key="tds.total.tax.deducted" /></small></label></div>
			          	<div class="rowlabel"><input id="total_taxdeducted" name="total_taxdeducted" type="text" maxlength="14" class=" decimal"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_TaxDeducted}"/></c:if>"/></div>
			          </div></div>
			</fieldset>
			<div class="row-fluid show-grid">
					<div class="span4 offset7 decimal">
						<a href="${scriptName}?tab=tdsfromsalary" class="button olive">Cancel</a>&nbsp; <a
   					 href="javascript:void(0)" id="myModalHref" class="button orange">Save</a>
   					 
                     <res:client-validation formId="frmdata"
	                  screenConfigurationDocumentName="tdsfromsalary" formSubmitButtonId="myModalHref" />
	                  
					</div>
				</div>
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
