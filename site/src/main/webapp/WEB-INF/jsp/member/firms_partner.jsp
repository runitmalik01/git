<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="firm">
	<fmt:message key="firm" />
</c:set>
<hippo-gogreen:title title="${firm}" />
<hst:actionURL var="actionUrl" />

<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />

	<h4>
		<fmt:message key="firms.partner.details.itr4" />
	</h4>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmFirm_Partner" action="${actionUrl}" method="post"
				name="frmFirm_Partner">
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="name_Firm"><small><fmt:message
										key="name.Firm.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_Firm" name="name_Firm" type="text" maxlength="75"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Firm}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="pan_Firm"><small><fmt:message
										key="pan.Firms.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="pan_Firm" name="pan_Firm" type="text" maxlength="10"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_Firm}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="perShare_InProfit"><small><fmt:message
										key="perShare.InProfit.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="perShare_InProfit" name="perShare_InProfit"
								type="text" maxlength="3"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.perShare_InProfit}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">

					<div class="span4">
						<div class="rowlabel">
							<label for="amountShare_InProfit"><small><fmt:message
										key="amount.share.inprofit.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="amountShare_InProfit" name="amountShare_InProfit"
								type="text" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amountShare_InProfit}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="capital_Balance"><small><fmt:message
										key="capital.balance.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="capital_Balance" name="capital_Balance" type="text" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.capital_Balance}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}" class="btn btn-danger">Cancel</a>&nbsp; <a
							id="myModalFirmPartner" role="button" class="btn btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b><fmt:message key="name.Firm.itr4" /> </b></th>
					<th><b><fmt:message key="pan.Firms.itr4" /> </b></th>
					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.firmsPartnerDetailList}"
						var="firmPartner">
						<tr>
							<td><c:out value="${firmPartner.name_Firm}" /></td>
							<td><c:out value="${firmPartner.pan_Firm}" /></td>
							<td><a class="btn btn-danger"
								href="${scriptName}/<c:out value="${firmPartner.canonicalUUID}"/>/firmspartneredit"><small><i
										class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp; </a>&nbsp;<a
								class="btn btn-primary"
								href="${scriptName}/<c:out value="${firmPartner.canonicalUUID}"/>/firmspartnerdelete"
								data-confirm=""><small><i
										class="icon-trash icon-white"></i>Delete</small> </a></td>
						</tr>

					</c:forEach>

				</c:if>
			</table>
			<a href="${scriptName}/firmspartnernew" class="btn btn-info">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>

<res:client-validation formId="frmFirm_Partner"
	screenConfigurationDocumentName="firmspartner"
	formSubmitButtonId="myModalFirmPartner" />
