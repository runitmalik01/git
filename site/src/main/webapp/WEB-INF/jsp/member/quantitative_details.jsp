<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="qDetails">
	<fmt:message key="qDetails" />
</c:set>
<hippo-gogreen:title title="${qDetails}" />
<hst:actionURL var="actionUrl" />


<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />

<h4>
	<fmt:message key="quantitative.details.itr4" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmQuantitativeDetails" action="${actionUrl}" method="post"
			name="frmQuantitativeDetails">
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="item_Name"><small><fmt:message
									key="item.Name.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="item_Name" name="item_Name"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.itemUnit_Code}"/></c:if>" />
					</div>
				</div>
			
				<div class="span4">
					<div class="rowlabel">
						<label for="itemUnit_Code"><small><fmt:message
									key="item.unit.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<select id="itemUnit_Code" name="itemUnit_Code" class="uprcase" onchange="getCountryName()">
					
					</div>
				</div>
			
				<div class="span4">
					<div class="rowlabel">
						<label for="opening_Stock"><small><fmt:message
									key="opening.Stock.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="opening_Stock" name="opening_Stock"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.opening_Stock}"/></c:if>" />
					</div>
				</div>
			</div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="purchage"><small><fmt:message
									key="purchage.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="purchage" name="purchage"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.purchage}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="sales_Qty"><small><fmt:message
									key="sales.Qty.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="sales_Qty" name="sales_Qty"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.sales_Qty}"/></c:if>" />
					</div>
				</div>
					<div class="span4">
					<div class="rowlabel">
						<label for="closing_Stock"><small><fmt:message
									key="closing.Stock.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="closing_Stock" name="closing_Stock"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.closing_Stock}"/></c:if>" />
					</div>
				</div>
			<div>
			<div>
			<div class="span4">
					<div class="rowlabel">
						<label for="shortage_IfAny"><small><fmt:message
									key="shortage.IfAny.quant.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="shortage_IfAny" name="shortage_IfAny"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.shortage_IfAny}"/></c:if>" />
					</div>
				</div>
			</div>
			
			</div>
			<input type="text" id="itemUnit_Name" name="itemUnit_Name">
		
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger">Cancel</a>&nbsp;
					<a id="myModalHreffrmImmProp" role="button" class="btn btn-success">Save</a>
				</div>  
			<div><input type="submit"></div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="foreign.country.name" /> </b>
				</th>
				<th><b><fmt:message key="address.property.itr2" /> </b>
				</th>
				
				
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.quantitativeUnitDetailList}"
					var="QuantitativeDetails">
					<tr>
						<td><c:out value="" />
						</td>
						<td><c:out value="" />
						</td>
						<td><c:out value="" />
						</td>
						<td><a class="btn btn-danger"
							href="${scriptName}/<c:out value="${QuantitativeDetails.canonicalUUID}"/>/quantitativedetailsedit"><small><i class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-primary" href="${scriptName}/<c:out value="${QuantitativeDetails.canonicalUUID}"/>/quantitativedetailsdelete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
						</tr>
				
				</c:forEach>
				
			</c:if>
		</table>
		<a href="${scriptName}/quantitativedetailsnew"
			class="btn btn-info">Add New</a>
	</c:otherwise>
</c:choose>
</div>

<res:client-validation formId="frmImmProp"
	screenConfigurationDocumentName="immovableproperty"
	formSubmitButtonId="myModalHreffrmImmProp" />
