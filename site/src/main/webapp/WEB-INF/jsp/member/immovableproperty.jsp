<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="immProp">
	<fmt:message key="immProp" />
</c:set>
<hippo-gogreen:title title="${immProp}" />
<hst:actionURL var="actionUrl" />
<%
	ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>

<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<w4india:titleandnav title="Schedule FA-C" subTitle="Schedule FA-C&nbsp;-&nbsp;The total investment at cost in
				immovable property held during the year after converting it into
				Indian currency."/>
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty checkForNRI}">
	    <div class="alert alert-danger alert-dismissable">
	        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			     <fmt:message key="${checkForNRI}" />
	    </div>
	</c:if>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmImmProp" action="${actionUrl}" method="post"
				name="frmImmProp">
				<legend class="header-color">
					<small><fmt:message key="immovable.property.itr2" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
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
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_property"><small><fmt:message
										key="address.property.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_property" name="address_property"
								maxlength="200" class="uprcase" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Property}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="total_investment"><small><fmt:message
										key="total.investmentitr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="total_investment" name="total_investment"
								maxlength="14" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_Investment}"/></c:if>" />
						</div>
					</div>
				</div>
				<input type="hidden" id="country_name" name="country_name">

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHreffrmImmProp" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>

				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="foreign.country.name" /> </b></th>
					<th><b><fmt:message key="address.property.itr2" /> </b></th>
					<th><b><fmt:message key="total.investmentitr2" /> </b></th>

					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.immovablePropertyDetailList}"
						var="immProp">
						<tr>
							<td><c:out value="${immProp.country_Name}" /></td>
							<td><c:out value="${immProp.address_Property}" /></td>
							<td><c:out value="${immProp.total_Investment}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${immProp.canonicalUUID}"/>/immovablepropertyedit"><small><i
										class="glyphicon glyphicon-pencil"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${immProp.canonicalUUID}"/>/immovablepropertydelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash"></i>Delete</small>
							</a></td>
						</tr>

					</c:forEach>
					<tr>
						<td colspan="2" align="center"><b>Total</b></td>
						<td><w4india:inr value="${parentBean.investment_Total}" /></td>
					</tr>
				</c:if>
			</table>
			<a href="${scriptName}/immovablepropertynew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<script type="text/javascript">
	$("#country_code")
			.ready(
					function() {
						if ($("#country_code").val() != null) {
							<c:forEach var="countryList" items="${objHashMapcountry}">
							if ($("#country_code").val() == '<c:out value="${countryList.key}"/>') {
								$("#country_name")
										.val(
												'<c:out value="${countryList.value}"/>');
							}
							</c:forEach>

						}
					});

	$("#country_code")
			.change(
					function() {
						if ($("#country_code").val() != null) {
							<c:forEach var="countryList" items="${objHashMapcountry}">
							if ($("#country_code").val() == '<c:out value="${countryList.key}"/>') {
								$("#country_name")
										.val(
												'<c:out value="${countryList.value}"/>');
							}
							</c:forEach>

						}
					});
</script>
<res:client-validation formId="frmImmProp"
	screenConfigurationDocumentName="immovableproperty"
	formSubmitButtonId="myModalHreffrmImmProp" />
