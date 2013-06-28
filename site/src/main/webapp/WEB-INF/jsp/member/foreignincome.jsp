<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="foreignincome" />
</c:set>
<hippo-gogreen:title title="${foreignincome}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<h4>
	<fmt:message key="foreign.income.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmforeignincome" action="${actionUrl}" method="post"
			name="frmforeignincome">
			
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="country_code"><small><fmt:message
									key="foreign.country.code" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="country_code" name="country_code" class="uprcase"
							type="text" 
							value="" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="taxpayer_ID"><small><fmt:message
									key="foreign.taxpayer.id" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="taxpayer_ID" name="taxpayer_ID"
							type="text" 
							value="" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="income_salary"><small><fmt:message
									key="foreign.income.salary" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_salary" name="income_salary"
							type="text" maxlength="14" 
							value="" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="income_house"><small><fmt:message
									key="foreign.income.house" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_house" name="income_house"
							type="text" maxlength="14"
							 class="decimal"
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="income_business"><small><fmt:message
									key="foreign.income.business" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_business" name="income_business" type="text"
							maxlength="14"  class="decimal"
							value="" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="income_capitalgain"><small><fmt:message
									key="foreign.income.capitalgain" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_capitalgain" name="income_capitalgain" type="text"
							maxlength="14"  class="decimal"
							value="" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="income_othersources"><small><fmt:message
									key="foreign.income.othersources" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_othersources" name="income_othersources" type="text"
							maxlength="14"  class="decimal"
							value="" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="income_total"><small><fmt:message
									key="foreign.income.total" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_total" name="income_total" type="text"
							maxlength="14"  class="decimal"
							value="" />
					</div>
				</div>
			</div>
		<!--  		<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefTdsOther" role="button" class="btn orange">Save</a>
				</div>-->
			</div>
			<div><input type="submit" name= "Save"></div>
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="foreign.country.code" /> </b>
				</th>
				<th><b><fmt:message key="foreign.taxpayer.id" /> </b>
				</th>
				<th><b><fmt:message key="tds.total.tax.deducted" /> </b></th>
				<th><b><fmt:message key="foreign.income.salary" /> </b></th>
				<th><b><fmt:message key="foreign.income.house" /> </b>
				</th>
				<th><b><fmt:message key="foreign.income.business" /> </b>
				</th>
				<th><b><fmt:message key="foreign.income.capitalgain" /> </b></th>
				<th><b><fmt:message key="foreign.income.othersources" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.foreignIncomeDetailList}"
					var="foreignIncome">
					<tr>
						<td><c:out value="${foreignIncome.country_Code}" />
						</td>
						<td><c:out value="${foreignIncome.taxpayer_ID}" />
						</td>
						<td><w4india:inr value="${foreignIncome.income_Salary}" />
						</td>
						<td><w4india:inr value="${foreignIncome.income_House}" />
						</td>
						<td><c:out value="${foreignIncome.income_Business}" />
						</td>
						<td><c:out value="${foreignIncome.income_Capitalgain}" />
						</td>
						<td><w4india:inr value="${foreignIncome.income_Othersources}" />
						</td>
						<td><w4india:inr value="${foreignIncome.income_Total}" />
						</td>
						<td>
					<td><a
							href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.total_Amount}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/foreignincomenew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>
<script type="text/javascript">
function calculate(){
	var amt= document.getElementById("total_taxdeductedtdsoth").value;
	document.getElementById("amounttdsoth").value = amt;
}
</script>


<res:client-validation formId="frmdataTdsOther"
	screenConfigurationDocumentName="tdsfromothers"
	formSubmitButtonId="myModalHrefTdsOther" fieldOneID="tan_deductortdsoth" fieldTwoID="name_deductortdsoth" validationType="tan"/>
