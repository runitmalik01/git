<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="immProp">
	<fmt:message key="immProp" />
</c:set>
<hippo-gogreen:title title="${trdetails}" />
<hst:actionURL var="actionUrl" />
<%
ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>

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
	<fmt:message key="immovable.property.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmImmProp" action="${actionUrl}" method="post"
			name="frmImmProp">
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="country_code"><small><fmt:message
									key="foreign.country.name" /> </small> </label>
					</div>
					<div class="rowlabel">
						<select id="country_code" name="country_code" class="uprcase" onchange="getCountryName()">
						<option value="">-Select-</option>
						<c:forEach var="countryList" items="${objHashMapcountry}">
							<option
								<c:if test="${childBean.country_Code == countryList.key}">selected</c:if>
								value="${countryList.key}">${countryList.value}</option>
						</c:forEach>
					</select>
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="address_property"><small><fmt:message
									key="address.property.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="address_property" name="address_property"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Property}"/></c:if>" />
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
			<input type="hidden" id="country_name" name="country_name">
		
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHreffrmImmProp" role="button" class="btn orange">Save</a>
				</div>  
			
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
				<th><b><fmt:message key="total.investmentitr2" /> </b></th>
				
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.immovablePropertyDetailList}"
					var="immProp">
					<tr>
						<td><c:out value="${immProp.country_Code}" />
						</td>
						<td><c:out value="${immProp.address_Property}" />
						</td>
						<td><c:out value="${immProp.total_Investment}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${immProp.canonicalUUID}"/>/immovablepropertyedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${immProp.canonicalUUID}"/>/immovablepropertydelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
				
				</c:forEach>
				<tr>
					<td colspan="2" align="center"><b>Total</b></td>
					<td><w4india:inr value="${parentBean.investment_Total}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/immovablepropertynew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>
<script type="text/javascript">
$("#country_code").change(function(){
	if($("#country_code").val()!=null){
	<c:forEach var="countryList" items="${objHashMapcountry}">
	  if($("#country_code").val()=='<c:out value="${countryList.key}"/>'){
		  $("#country_name").val('<c:out value="${countryList.value}"/>');
	  }
    </c:forEach>

	}
});

</script>
<res:client-validation formId="frmImmProp"
	screenConfigurationDocumentName="immovableproperty"
	formSubmitButtonId="myModalHreffrmImmProp" />
