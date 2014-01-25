<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="FinInterest">
	<fmt:message key="financial.interest.itr2" />
</c:set>
<hippo-gogreen:title title="${FinInterest}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<%
		ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
		SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
		request.setAttribute("objHashMapcountry", objHashMapcountry);
	%>
	<div class="page-header">
		<h2 class="title page-title">Schedule FA-B</h2>
		<h4>
			<small>Schedule FA-(B)&nbsp;-&nbsp;The resident assessee is
				the owner of record or holder of legal title of any financial
				account,irrespective of whether he is the beneficiary or not or if
				the owner of record or holder of title as an agent, nominee,
				attorney, a corporation, a trust. Investment has to be filled up
				after converting it into Indian currency.</small>
		</h4>
	</div>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmtFinancialInterest" action="${actionUrl}" method="post"
				name="frmtFinancialInterest">
				<legend class="header-color">
					<small><fmt:message key="financial.interest.itr2" /></small>
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
							<label for="nature_entity"><small><fmt:message
										key="nature.entity.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="nature_entity" name="nature_entity" maxlength="100"
								type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Entity}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_entity"><small><fmt:message
										key="name.entity.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_entity" name="name_entity" maxlength="125"
								type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nature_Entity}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_entity"><small><fmt:message
										key="address.entity.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_entity" name="address_entity" maxlength="100"
								type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Entity}"/></c:if>" />
						</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="total_investment"><small><fmt:message
										key="total.investment.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="total_investment" name="total_investment" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_Investment}"/></c:if>" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefFinInterest" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
					<input type="hidden" id="country_name" name="country_name">
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="foreign.country.name" /> </b></th>
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
							<td><c:out value="${foreignbank.country_Name}" /></td>
							<td><c:out value="${foreignbank.name_Entity}" /></td>
							<td><c:out value="${foreignbank.nature_Entity}" /></td>
							<td><c:out value="${foreignbank.address_Entity}" /></td>
							<td><c:out value="${foreignbank.total_Investment}" /></td>

							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>&nbsp;
							</a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/financialinterestdelete"><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
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
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add
					New</small></a>
		</c:otherwise>
	</c:choose>
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

<res:client-validation formId="frmtFinancialInterest"
	screenConfigurationDocumentName="financialinterest"
	formSubmitButtonId="myModalHrefFinInterest" />
