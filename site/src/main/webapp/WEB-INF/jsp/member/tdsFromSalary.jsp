<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds1">
	<fmt:message key="tds1" />
</c:set>
<hippo-gogreen:title title="${tds1}" />
<hst:actionURL var="actionUrl" />
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
		<form id="frmdatatdssalary" action="${actionUrl}" method="post"
			name="tdsfromsalary">
			<div id="error" class="alert alert-error" style="display:none;">TAN's fourth alphabet should be first alphabet of Name of Employer</div>
			<fieldset>
				<legend style="color: black">Enter Details</legend>
			<div class="row-fluid show-grid" >
						<div class="span4">
			            <div class="rowlabel"><label for="tan_employertds"><small><fmt:message key="tds.tan.emoloyer" /></small></label></div>
			          	<div class="rowlabel"><input id="tan_employertds" name="tan_employertds" type="text" maxlength="10" onkeyup="keyup()"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Employer}"/></c:if>"/></div>
			          </div>
			          <div class="span4">
			            <div class="rowlabel"><label for="name_employertds"><small><fmt:message key="tds.name.employer" /></small></label></div>
			          	<div class="rowlabel"><input id="name_employertds" name="name_employertds" type="text" maxlength="125"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Employer}"/></c:if>"/></div>
			          </div></div>
			          <div class="row-fluid show-grid" >
			           <div class="span4">
			            <div class="rowlabel"><label for="income_chargeabletds"><small><fmt:message key="tds.income.chargeable" /></small></label></div>
			          	<div class="rowlabel"><input id="income_chargeabletds" name="income_chargeabletds" type="text" maxlength="14" class=" decimal"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_Chargeable}"/></c:if>"/></div>
			          </div>
			           <div class="span4">
			            <div class="rowlabel"><label for="total_taxdeductedtds"><small><fmt:message key="tds.total.tax.deducted" /></small></label></div>
			          	<div class="rowlabel"><input id="total_taxdeductedtds" name="total_taxdeductedtds" type="text" maxlength="14" class=" decimal"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_TaxDeducted}"/></c:if>"/></div>
			          </div></div>
			</fieldset>
			
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_TDS_SALARY%>" class="button olive">Cancel</a>&nbsp;
								<a id="myModalHreftds" role="button" class="btn orange">Save</a>
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
							href="${scriptName}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/tdsfromsalaryedit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a href="${scriptName}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/tdsfromsalarydelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>

					</tr>
				</c:forEach>
				<tr>
					<td><fmt:message key="tds.amount.total.deducted" /></td>
					<td><input type="text" name="total_value"
						value="${parentBean.total_Amount}"></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/tdsfromsalarynew" class="button orange">Add
			New</a>

	</c:otherwise>
</c:choose>
<res:client-validation  screenConfigurationDocumentName="tdsfromsalary" formId="frmdatatdssalary" formSubmitButtonId="myModalHreftds" fieldOneID="tan_employertds" fieldTwoID="name_employertds" validationType="tan"></res:client-validation>
<script type="text/javascript">

function checkdelete(){
    var re=confirm("Do You want to Delete it");
      if (re) return true;
      else return false;
            }</script>