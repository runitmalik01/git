<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="trustdetails">
	<fmt:message key="trustdetails" />
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
	<fmt:message key="detail.of.trusts.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmtrustdetails" action="${actionUrl}" method="post"
			name="frmtrustdetails">
			
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
						<label for="name_trust"><small><fmt:message
									key="name.trust.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_trust" name="name_trust"
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="address_trust"><small><fmt:message
									key="address.trust.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_trust" name="address_trust"
							type="text" 
							value=" " />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			
				<div class="span4">
					<div class="rowlabel">
						<label for="name_othertrust"><small><fmt:message
									key="name.other.trust.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_othertrust" name="name_othertrust"
							type="text"
							 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="address_othertrust"><small><fmt:message
									key="address.other.trust.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_othertrust" name="address_othertrust" type="text"
							
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="name_settlor"><small><fmt:message
									key="name.settlor.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_settlor" name="name_settlor" type="text"
						
							value=" " />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
		<div class="span4">
					<div class="rowlabel">
						<label for="address_settlor"><small><fmt:message
									key="address.settlor.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_settlor" name="address_settlor" type="text"
						
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="name_beneficiaries"><small><fmt:message
									key="name.beneficiaries.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_beneficiaries" name="name_beneficiaries" type="text"
						
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="address_beneficiaries"><small><fmt:message
									key="address.beneficiaries.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_beneficiaries" name="address_beneficiaries" type="text"
						
							value=" " />
					</div>
				</div>
				</div>
				<!--  
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefTaxrebate" role="button" class="btn orange">Save</a>
				</div> -->
			<div><input type="submit"></div>
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
				<c:forEach items="${parentBean.taxReliefDetailList}"
					var="taxrelief">
					<tr>
						<td><c:out value="${taxrelief.country_Code}" />
						</td>
						<td><c:out value="${taxrelief.tax_ID}" />
						</td>
						<td><c:out value="${taxrelief.article_dtaa}" />
						</td>
						<td><w4india:inr value="${taxrelief.totaltax_fsi}" />
						</td>
						<td><w4india:inr value="${taxrelief.relief90_91}" />
						</td>
						<td><w4india:inr value="${taxrelief.relief91}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trustdetailedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trustdetaildelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				
				
			</c:if>
		</table>
		<a href="${scriptName}/trustdetailnew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmtrdetails"
	screenConfigurationDocumentName="taxrelief"
	formSubmitButtonId="myModalHrefTaxrebate" />
