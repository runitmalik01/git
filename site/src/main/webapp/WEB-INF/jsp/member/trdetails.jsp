<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="trdetails" />
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
	<fmt:message key="tr.details.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmtrdetails" action="${actionUrl}" method="post"
			name="frmtrdetails">
			
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
						<label for="tax_ID"><small><fmt:message
									key="tax.id.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="tax_ID" name="tax_ID"
							type="text" 
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="article_dtaa"><small><fmt:message
									key="article.dtaa.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="article_dtaa" name="article_dtaa"
							type="text" 
							value=" " />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
			
				<div class="span4">
					<div class="rowlabel">
						<label for="totaltax_fsi"><small><fmt:message
									key="total.tax.fsi.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="totaltax_fsi" name="totaltax_fsi"
							type="text"
							 class="decimal"
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="relief90_91"><small><fmt:message
									key="relief.90.91.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="relief90_91" name="relief90_91" type="text"
							maxlength="14"   class="decimal"
							value=" " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="relief91"><small><fmt:message
									key="relief.90.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="relief91" name="relief91" type="text"
							maxlength="14"   class="decimal"
							value=" " />
					</div>
				</div>
			</div>
		
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefTaxrebate" role="button" class="btn orange">Save</a>
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
							href="${scriptName}/<c:out value="${taxreliefdetail.canonicalUUID}"/>/trdetailsedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${taxreliefdetail.canonicalUUID}"/>/trdetailssdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.total_TaxFsi}" /></td>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.rebate9091}" /></td>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.rebate90}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/trdetailsnew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmtrdetails"
	screenConfigurationDocumentName="taxrelief"
	formSubmitButtonId="myModalHrefTaxrebate" />
