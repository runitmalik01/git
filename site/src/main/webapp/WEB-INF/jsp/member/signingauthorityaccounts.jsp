<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="SignAuth">
	<fmt:message key="SignAuth" />
</c:set>
<hippo-gogreen:title title="${SignAuth}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<div class="page-header">
		<h2 class="title page-title">Schedule FA-E</h2>
		<h4>
			<small>Schedule FA-(E)&nbsp;-&nbsp;The details of investment
				in the accounts in which you have signing authority and which has
				not been included in any other part of Schedule FA & filled up
				investment held during the year after converting it into Indian
				currency. </small>
		</h4>
	</div>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmtSigningAuthority" action="${actionUrl}" method="post"
				name="frmtSigningAuthority">
				<legend class="header-color">
					<small><fmt:message key="signing.authority.itr2" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_institution"><small><fmt:message
										key="name.institution.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_institution" name="name_institution"
								maxlength="125" class="uprcase" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Institution}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_institution"><small><fmt:message
										key="address.institution.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_institution" name="address_institution"
								maxlength="200" class="uprcase" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Institution}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_accountholder"><small><fmt:message
										key="name.account.holder.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_accountholder" name="name_accountholder"
								maxlength="125" class="uprcase" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Accountholder}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="account_number"><small><fmt:message
										key="account.number.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="account_number" name="account_number" type="text"
								maxlength="17"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.account_Number}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="peak_balance"><small><fmt:message
										key="peak.balance.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="peak_balance" name="peak_balance" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.peak_Balance}"/></c:if>" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefSignAccount" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>

				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="name.institution.itr2" /> </b></th>
					<th><b><fmt:message key="address.institution.itr2" /> </b></th>
					<th><b><fmt:message key="name.account.holder.itr2" /> </b></th>
					<th><b><fmt:message key="account.number.itr2" /> </b></th>
					<th><b><fmt:message key="peak.balance.itr2" /> </b></th>

					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.signingAuthorityAccountsDetailList}"
						var="foreignbank">
						<tr>
							<td><c:out value="${foreignbank.name_Institution}" /></td>
							<td><c:out value="${foreignbank.address_Institution}" /></td>
							<td><c:out value="${foreignbank.name_Accountholder}" /></td>
							<td><c:out value="${foreignbank.account_Number}" /></td>

							<td><w4india:inr value="${foreignbank.peak_Balance}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/signingauthorityaccountsedit"><small>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/signingauthorityaccountsdelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" align="center"><b>Total</b></td>
						<td><w4india:inr value="${parentBean.balance_Peak}" /></td>

					</tr>

				</c:if>
			</table>
			<a href="${scriptName}/signingauthorityaccountsnew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>


<res:client-validation formId="frmtSigningAuthority"
	screenConfigurationDocumentName="signingauthorityaccount"
	formSubmitButtonId="myModalHrefSignAccount" />
