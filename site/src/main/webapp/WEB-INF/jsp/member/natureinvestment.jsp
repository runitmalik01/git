<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="immProp">
	<fmt:message key="immProp" />
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
	<fmt:message key="nature.investment.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmNatureInvest" action="${actionUrl}" method="post"
			name="frmNatureInvest">
			
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
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.country_Code}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="nature_asset"><small><fmt:message
									key="nature.asset.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="nature_asset" name="nature_asset"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nature_Asset}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="total_investment"><small><fmt:message
									key="total.investmentitr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="total_investment" name="total_investment"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_Investment}"/></c:if>" />
					</div>
				</div>
			</div>
			
		
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefNatureInvst" role="button" class="btn orange">Save</a>
				</div>  
			
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="foreign.country.code" /> </b>
				</th>
				<th><b><fmt:message key="nature.asset.itr2" /> </b>
				</th>
				<th><b><fmt:message key="total.investmentitr2" /> </b></th>
				
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.natureInvestmentDetailList}"
					var="natureInvest">
					<tr>
						<td><c:out value="${natureInvest.country_Code}" />
						</td>
						<td><c:out value="${natureInvest.nature_Asset}" />
						</td>
						<td><c:out value="${natureInvest.total_Investment}" />
						</td>
						
						<td><a
							href="${scriptName}/<c:out value="${natureInvest.canonicalUUID}"/>/natureinvestmentedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${natureInvest.canonicalUUID}"/>/natureinvestmentdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2"><b>Total</b></td>
					<td><w4india:inr value="${parentBean.investment_Total}" /></td>
				
				</tr>
				
			</c:if>
		</table>
		<a href="${scriptName}/natureinvestmentnew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmNatureInvest"
	screenConfigurationDocumentName="natureinvestment"
	formSubmitButtonId="myModalHrefNatureInvst" />
