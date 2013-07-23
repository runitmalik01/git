<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="tds2">
	<fmt:message key="member.advancetax.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hippo-gogreen:title title="${tds2}" />

<hst:actionURL var="actionUrl" />

<h4>
	<fmt:message key="member.tds.selfassesment.tax" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdataSelfTax" action="${actionUrl}" method="post"
			name="selfassementtax">

			<fieldset>
				<legend style="color: black">Enter Details</legend>
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="bsr_codeself"><abbr
								title=" Basic Statistical Return Code"><small><fmt:message
											key="tds.bsr.code" /> </small> </abbr> </label>
						</div>
						<div class="rowlabel">
							<input id="bsr_codeself" name="bsr_codeself" type="text"
								maxlength="7"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="date_creditself"><small><fmt:message
										key="tds.date.credit" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="date_creditself" name="date_creditself" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid" id="ul_revised_input">
					<div class="span4">
						<div class="rowlabel">
							<label for="Serial_challanself"><small><fmt:message
										key="tds.serial.challan" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="Serial_challanself" name="Serial_challanself"
								type="text" maxlength="5"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="amountself"><small><fmt:message
										key="tds.amount.selfassesment" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="amountself" name="amountself" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.p_Amount}"/></c:if>" />
						</div>
					</div>
				</div>
			</fieldset>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_SELF_ASSESSMENT%>" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
					<a id="myModalHrefSelfTax" role="button" class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>
		</form>

	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="tds.bsr.code" /> </b>
				</th>
				<th><b><fmt:message key="tds.date.credit" /> </b>
				</th>
				<th><b><fmt:message key="tds.serial.challan" /> </b>
				</th>
				<th><b><fmt:message key="tds.amount.selfassesment" /> </b>
				</th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.selfAssesmentDetailList}"
					var="selfassesmentdetail">
					<tr>
						<td><c:out value="${selfassesmentdetail.p_BSR}" />
						</td>
						<td><c:out value="${selfassesmentdetail.dateStr}" />
						</td>
						<td><c:out value="${selfassesmentdetail.p_Serial}" />
						</td>
						<td><w4india:inr value="${selfassesmentdetail.p_Amount}" />
						</td>
						<td><a class="btn btn-primary"
							href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxedit"><small><i class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;&nbsp;<a class="btn btn-danger" href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxdelete" id="delete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
					</tr>
			</c:forEach>
				<tr>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td ><w4india:inr value="${parentBean.total_Amount}" /></td>
			</c:if>
		</table>
		<a href="${scriptName}/selfassesmenttaxnew" class="btn btn-info" style="color: black">Add New</a>
	</c:otherwise>
</c:choose>

<res:client-validation formId="frmdataSelfTax"
	screenConfigurationDocumentName="selfassementtax"
	formSubmitButtonId="myModalHrefSelfTax" />
	<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    $(document).ready(function() {

    var AY='<c:out value="${assessmentYear}"/>'.split("-", 4);
	itrFinYrMax="31/03/"+AY[1];
	itrFinYrMin="01/04/"+AY[0];
	$( ".indiandateSelfAssesment" ).datepicker( "option", "minDate", itrFinYrMin );
			$( ".indiandateSelfAssesment" ).datepicker( "option", "maxDate", itrFinYrMax );
			});

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
