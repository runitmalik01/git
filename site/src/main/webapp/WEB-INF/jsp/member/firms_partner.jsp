<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="firm">
Partnership In Firms
</c:set>
<hippo-gogreen:title title="${firm}" />
<hst:actionURL var="actionUrl" />

<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<w4india:titleandnav title="Schedule IF" subTitle="It has to be filled
				for each firm in which you are partner,amount of share in the profit
				of the firm and amount of capital balance (including the capital on
				which you are entitled for an interest) in the firm in which you are
				partner."/>
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty InCorrectPan}">
		<div class="alert alert-danger">

			<fmt:message key="not.valid.Pan">
			</fmt:message>
		</div>
	</c:if>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmFirm_Partner" action="${actionUrl}" method="post"
				name="frmFirm_Partner">
				<legend class="header-color">
					<small><fmt:message key="firms.partner.details.itr4" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="isLiableToAudit"><small>Is Firm
									liable to audit </small> </label>
						</div>
						<div class="rowlabel">
							<select id="isLiableToAudit" name="isLiableToAudit">
								<option value="">-Select-</option>
								<option value="Y"
									<c:if test="${not empty childBean.isLiableToAudit && childBean.isLiableToAudit =='Y'}">selected</c:if>>Yes</option>
								<option value="N"
									<c:if test="${not empty childBean.isLiableToAudit && childBean.isLiableToAudit =='N'}">selected</c:if>>No</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_Firm"><small><fmt:message
										key="name.Firm.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_Firm" name="name_Firm" type="text" maxlength="75"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Firm}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="firm_Pan"><small><fmt:message
										key="pan.Firms.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="firm_Pan" name="firm_Pan" type="text" maxlength="10"
								class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_Firm}"/></c:if>" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-4">
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


					<div class="col-md-4">
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
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="capital_Balance"><small><fmt:message
										key="capital.balance.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="capital_Balance" name="capital_Balance" type="text"
								maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.capital_Balance}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalFirmPartner" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="name.Firm.itr4" /> </b></th>
					<th><b><fmt:message key="pan.Firms.itr4" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.firmsPartnerDetailList}"
						var="firmPartner">
						<tr>
							<td><c:out value="${firmPartner.name_Firm}" /></td>
							<td><c:out value="${firmPartner.pan_Firm}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${firmPartner.canonicalUUID}"/>/firmspartneredit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${firmPartner.canonicalUUID}"/>/firmspartnerdelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>

					</c:forEach>

				</c:if>
			</table>
			<a href="${scriptName}/firmspartnernew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add
					New</small></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>

<res:client-validation formId="frmFirm_Partner"
	screenConfigurationDocumentName="firmspartner"
	formSubmitButtonId="myModalFirmPartner" />
