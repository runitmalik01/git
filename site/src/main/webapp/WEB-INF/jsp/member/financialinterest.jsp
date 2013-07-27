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
<%
ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>
<h4>
	<fmt:message key="financial.interest.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmtFinancialInterest" action="${actionUrl}" method="post"
			name="frmtFinancialInterest">
			
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
						<label for="nature_entity"><small><fmt:message
									key="nature.entity.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="nature_entity" name="nature_entity"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Entity}"/></c:if>" />
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
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nature_Entity}"/></c:if>" />
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
							 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Entity}"/></c:if>" />
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
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_Investment}"/></c:if>" />
					</div>
				</div>
			</div>
	
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefFinInterest" role="button" class="btn orange">Save</a>
				</div>  
			<input type="hidden" id="country_name" name="country_name">
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="foreign.country.name" /> </b>
				</th>
				<th><b><fmt:message key="nature.entity.itr2" /> </b></th>
				<th><b><fmt:message key="name.entity.itr2" /> </b></th>
				<th><b><fmt:message key="address.entity.itr2" /> </b></th>
				<th><b><fmt:message key="total.investment.itr2" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.financialInterestDetailList}"
					var="foreignbank">
					<tr>
						<td><c:out value="${foreignbank.country_Name}" />
						</td>
						<td><c:out value="${foreignbank.name_Entity}" />
						</td>
						<td><c:out value="${foreignbank.nature_Entity}" />
						</td>
						<td><c:out value="${foreignbank.address_Entity}" />
						</td>
						<td><c:out value="${foreignbank.total_Investment}" />
						</td>
						
						<td><a
							href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="center"><b>Total</b></td>
					<td><w4india:inr value="${parentBean.investment_Total}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/financialinterestnew"
class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>
<script type="text/javascript">
$("#country_code").ready(function(){
	if($("#country_code").val()!=null){
	<c:forEach var="countryList" items="${objHashMapcountry}">
	  if($("#country_code").val()=='<c:out value="${countryList.key}"/>'){
		  $("#country_name").val('<c:out value="${countryList.value}"/>');
	  }
    </c:forEach>

	}
});
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

<res:client-validation formId="frmtFinancialInterest"
	screenConfigurationDocumentName="financialinterest"
	formSubmitButtonId="myModalHrefFinInterest" />
