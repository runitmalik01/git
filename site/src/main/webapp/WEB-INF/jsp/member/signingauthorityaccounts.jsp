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
	<fmt:message key="signing.authority.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmtSigningAuthority" action="${actionUrl}" method="post"
			name="frmtSigningAuthority">
			
			<h2>Enter Details</h2>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="name_institution"><small><fmt:message
									key="name.institution.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_institution" name="name_institution" 
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="address_institution"><small><fmt:message
									key="address.institution.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_institution" name="address_institution"
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="name_accountholder"><small><fmt:message
									key="name.account.holder.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_accountholder" name="name_accountholder"
							type="text" 
							value=" " />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			
				<div class="span4">
					<div class="rowlabel">
						<label for="account_number"><small><fmt:message
									key="account.number.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="account_number" name="account_number" type="text"
							
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="peak_balance"><small><fmt:message
									key="peak.balance.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="peak_balance" name="peak_balance" type="text"
							maxlength="14" class="decimal"
							value=" " />
					</div>
				</div>
			</div>
		<!-- 
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefTaxrebate" role="button" class="btn orange">Save</a>
				</div>  -->
			<input type="submit" value="save">
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
				<th><b><fmt:message key="tds.total.tax.deducted" /> </b></th>
				<th><b><fmt:message key="tds.amount.claimed" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.foreignAssetDetailList}"
					var="foreignbank">
					<tr>
						<td><c:out value="${foreignbank.country_Code}" />
						</td>
						<td><c:out value="${foreignbank.name_Bank}" />
						</td>
						<td><c:out value="${foreignbank.address_Bank}" />
						</td>
						<td><c:out value="${foreignbank.name_Account}" />
						</td>
						<td><c:out value="${foreignbank.account_No}" />
						</td>
						<td><w4india:inr value="${foreignbank.peak_Balance}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/signingauthorityaccountsedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/signingauthorityaccountsdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.total_peakBalance}" /></td>
					
				</tr>
				
			</c:if>
		</table>
		<a href="${scriptName}/signingauthorityaccountsnew"
class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmtrdetails"
	screenConfigurationDocumentName="taxrelief"
	formSubmitButtonId="myModalHrefTaxrebate" />
