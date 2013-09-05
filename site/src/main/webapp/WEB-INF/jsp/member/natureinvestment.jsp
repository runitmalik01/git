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
<%
ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>
<h4>
	<fmt:message key="nature.investment.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmNatureInvest" action="${actionUrl}" method="post"
			name="frmNatureInvest">
			
			<fieldset>
			<legend>Enter Details</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="country_code"><small><fmt:message
									key="foreign.country.code" /> </small> </label>
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
						<label for="nature_asset"><small><fmt:message
									key="nature.asset.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="nature_asset" name="nature_asset" maxlength="100"
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
						<input id="total_investment" name="total_investment" maxlength="14"
							type="text" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_Investment}"/></c:if>" />
					</div>
				</div>
			</div>
			
		
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger">Cancel</a>&nbsp;
					<a id="myModalHrefNatureInvst" role="button" class="btn btn-success">Save</a>
				</div>  
			<input type="hidden" id="country_name" name="country_name">
			</div>
			</fieldset>
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
						<td><c:out value="${natureInvest.country_Name}" />
						</td>
						<td><c:out value="${natureInvest.nature_Asset}" />
						</td>
						<td><c:out value="${natureInvest.total_Investment}" />
						</td>
						
						<td><a class="btn btn-danger"
							href="${scriptName}/<c:out value="${natureInvest.canonicalUUID}"/>/natureinvestmentedit"><small><i class="icon-trash icon-white"></i>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-primary" href="${scriptName}/<c:out value="${natureInvest.canonicalUUID}"/>/natureinvestmentdelete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
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
			class="btn btn-info">Add New</a>
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
<res:client-validation formId="frmNatureInvest"
	screenConfigurationDocumentName="natureinvestment"
	formSubmitButtonId="myModalHrefNatureInvst" />
