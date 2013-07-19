<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="tds2" />
</c:set>
<hippo-gogreen:title title="${tds2}" />
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
	<fmt:message key="member.tds.from.others" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdataTdsOther" action="${actionUrl}" method="post"
			name="tdsfromothers">
			<div id="error" class="alert alert-error" style="display:none;">TAN's fourth alphabet should be first alphabet of Name of Deductor</div>
			<h2>Enter Details</h2>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="tan_deductortdsoth"><small><fmt:message
									key="tds.tan.deductor" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="tan_deductortdsoth" name="tan_deductortdsoth" class="uprcase"
							type="text" onchange="keyup()" onblur=" keyup()" maxlength="10"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Deductor}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="name_deductortdsoth"><small><fmt:message
									key="tds.name.deductor" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_deductortdsoth" name="name_deductortdsoth"
							type="text" maxlength="125" class="uprcase"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Deductor}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="tds_certificatetdsoth"><small><fmt:message
									key="tds.unique.certificate" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="tds_certificatetdsoth" name="tds_certificatetdsoth"
							type="text" maxlength="8" class="uprcase"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tds_Certificate}"/></c:if>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="financial_yeartdsoth"><small><fmt:message
									key="tds.financial.year" /> </small> </label>
					</div>
					<div class="rowlabel">
						<select id="financial_yeartdsoth" name="financial_yeartdsoth" class="uprcase"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.financial_Year}"/></c:if>">
							<c:if test="${empty childBean.financial_Year}">
								<option value="">Select</option>
							</c:if>
							<option value="${eight}"
								<c:if test="${not empty childBean.financial_Year && childBean.financial_Year =='eight'}">selected</c:if>>${eight}</option>
							<option value="${nine}">${nine}</option>
							<option value="${ten}">${ten}</option>
							<option value="${eleven}">${eleven}</option>
							<option value="${twelve}">${twelve}</option>
							<option value="${thirteen}">${thirteen}</option>
							<option value="${forteen}">${forteen}</option>
							<option value="${fifteen}">${fifteen}</option>

						</select>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="total_taxdeductedtdsoth"><small><fmt:message
									key="tds.total.tax.deducted" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_taxdeductedtdsoth" name="total_taxdeductedtdsoth"
							type="text" maxlength="14" onblur="calculate()"
							onchange="calculate" class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.total_TaxDeductor}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="amounttdsoth"><small><fmt:message
									key="tds.amount.claimed" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="amounttdsoth" name="amounttdsoth" type="text"
							maxlength="14" readonly  class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.p_Amount}"/></c:if>" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_TDS_OTHERS%>" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefTdsOther" role="button" class="btn orange">Save</a>
				</div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="tds.tan.deductor" /> </b>
				</th>
				<th><b><fmt:message key="tds.name.deductor" /> </b>
				</th>
				<th><b><fmt:message key="tds.total.tax.deducted" /> </b></th>
				<th><b><fmt:message key="tds.amount.claimed" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.tdsSalaryDetailList}"
					var="tdsfromothersdetail">
					<tr>
						<td><c:out value="${tdsfromothersdetail.tan_Deductor}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.name_Deductor}" />
						</td>
						<td><w4india:inr value="${tdsfromothersdetail.total_TaxDeductor}" />
						</td>
						<td><w4india:inr value="${tdsfromothersdetail.p_Amount}" />
						</td>
						<td><a class="btn btn-primary" href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersedit"><small><i class="icon-pencil icon-white"></i>Edit</small>&nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-danger" href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersdelete" id="delete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
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
		<a href="${scriptName}/tdsfromothersnew"
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
