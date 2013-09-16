<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="foreignincome" />
</c:set>
<hippo-gogreen:title title="${foreignincome}" />
<hst:actionURL var="actionUrl" />
<%
ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<h4>
		<fmt:message key="foreign.income.itr2" />
	</h4>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmforeignincome" action="${actionUrl}" method="post"
				name="frmforeignincome">

				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="country_code"><small><fmt:message
										key="foreign.country.name" /> </small> </label>
						</div>
						<div class="rowlabel">
							<select id="country_code" name="country_code" class="uprcase"
								onchange="getCountryName()">
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
							<label for="taxpayer_ID"><small><fmt:message
										key="foreign.taxpayer.id" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="taxpayer_ID" name="taxpayer_ID" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.taxpayer_ID}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="income_salary"><small><fmt:message
										key="foreign.income.salary" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="income_salary" name="income_salary" type="text"
								maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_Salary}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="income_house"><small><fmt:message
										key="foreign.income.house" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="income_house" name="income_house" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_House}"/></c:if>" />
						</div>
					</div>
					<%-- <div class="span4">
						<div class="rowlabel">
							<label for="income_business"><small><fmt:message
										key="foreign.income.business" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="income_business" name="income_business" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_Business}"/></c:if>" />
						</div>
					</div>--%>
					<div class="span4">
						<div class="rowlabel">
							<label for="income_capitalgain"><small><fmt:message
										key="foreign.income.capitalgain" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="income_capitalgain" name="income_capitalgain"
								type="text" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_Capitalgain}"/></c:if>" />
						</div>
					</div>
					
					
						<div class="span4">
							<div class="rowlabel">
								<label for="income_othersources"><small><fmt:message
											key="foreign.income.othersources" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="income_othersources" name="income_othersources"
									type="text" maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_Othersources}"/></c:if>" />
							</div>
						</div>
</div><div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="income_total"><small><fmt:message
											key="foreign.income.total" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="income_total" name="income_total" type="text" readonly="readonly"
									maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_Total}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="isDtaa"><small><fmt:message
											key="foreign.is.dtaa.applicable" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="isDtaa" name="isDtaa">
								<option value="">-Select-</option>
								<option value="Yes"<c:if test="${not empty childBean.isDtaaCountry && childBean.isDtaaCountry =='Yes'}">selected</c:if>>Yes</option></option>
								<option value="No"<c:if test="${not empty childBean.isDtaaCountry && childBean.isDtaaCountry =='No'}">selected</c:if>>No</option></option>
								</select>
							</div>
						</div>
						
						<div class="span4">
							<div class="rowlabel">
								<label for="dtaa_CountryIncome"><small><fmt:message
											key="foreign.income.dtaa" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="dtaa_CountryIncome" name="dtaa_CountryIncome" type="text" readonly="readonly"
									maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.dtaa_CountryIncome}"/></c:if>" />
							</div>
						</div></div>
						<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="Nodtaa_CountryIncome"><small><fmt:message    
											key="foreign.income.Nodtaa" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="Nodtaa_CountryIncome" name="Nodtaa_CountryIncome" type="text" readonly="readonly"
									maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.nodtaa_CountryIncome}"/></c:if>" />
							</div>
						</div>
					</div>
				</div>
				<input type="hidden" id="country_name" name="country_name">
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}" class="btn btn-danger">Cancel</a>&nbsp; <a
							id="myModalHrefforeignincome" role="button" class="btn btn-success">Save</a>
					</div>
				</div>

			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b><fmt:message key="foreign.country.name" /> </b></th>
					<th><b><fmt:message key="foreign.taxpayer.id" /> </b></th>

					
					<th><b><fmt:message key="foreign.income.itr2" /> </b>
					</th>
					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.foreignIncomeDetailList}"
						var="foreignIncome">
						<tr>
							<td><c:out value="${foreignIncome.country_Name}" /></td>
							<td><c:out value="${foreignIncome.taxpayer_ID}" /></td>
							
							<td><w4india:inr value="${foreignIncome.income_Total}" /></td>

							<td><a class="btn btn-danger" style="color: black"
								href="${scriptName}/<c:out value="${foreignIncome.canonicalUUID}"/>/foreignincomeedit"><small><i class="icon-pencil icon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-primary" style="color: black"
								href="${scriptName}/<c:out value="${foreignIncome.canonicalUUID}"/>/foreignincomedelete" data-confirm=""
								><small><i class="icon-trash icon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="2" align="center"><b><fmt:message key="foreign.totalincome.outside" /></b>
						</td>
						<td><w4india:inr value="${parentBean.total_Amount}" />
						</td>
						
					</tr>
				</c:if>
			</table>
			<table>
			</div>
<a href="${scriptName}/foreignincomenew" class="btn btn-info" style="color: black">Add
	New</a>
			
			
			</table>

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
<res:calc screenCalc="foreignincome" formId="frmforeignincome"></res:calc>
<res:client-validation formId="frmforeignincome"
	screenConfigurationDocumentName="foreignincome"
	formSubmitButtonId="myModalHrefforeignincome" />
