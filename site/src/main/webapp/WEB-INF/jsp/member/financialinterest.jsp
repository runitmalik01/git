<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="FinancialInterest">
	<fmt:message key="FinancialInterest" />
</c:set>
<hippo-gogreen:title title="${trdetails}" />
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
	<fmt:message key="financial.interest.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmtFinancialInterest" action="${actionUrl}" method="post"
			name="frmtFinancialInterest">
			
			<h2>Enter Details</h2>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="country_code"><small><fmt:message
									key="foreign.country.code" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="country_code" name="country_code" 
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="nature_entity"><small><fmt:message
									key="nature.entity.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="nature_entity" name="nature_entity"
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="name_entity"><small><fmt:message
									key="name.entity.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_entity" name="name_entity"
							type="text" 
							value=" " />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			
				<div class="span4">
					<div class="rowlabel">
						<label for="address_entity"><small><fmt:message
									key="address.entity.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_entity" name="address_entity"
							type="text"
							 
							value=" " />
					</div>
				</div>
				
				<div class="span4">
					<div class="rowlabel">
						<label for="total_investment"><small><fmt:message
									key="total.investment.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_investment" name="total_investment" type="text"
							maxlength="14"   class="decimal"
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
							href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
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
		<a href="${scriptName}/financialinterestnew"
class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmtrdetails"
	screenConfigurationDocumentName="taxrelief"
	formSubmitButtonId="myModalHrefTaxrebate" />
