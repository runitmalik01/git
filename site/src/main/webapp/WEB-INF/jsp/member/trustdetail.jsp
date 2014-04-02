<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="trustdetails">
	Details Of Trust
</c:set>
<hippo-gogreen:title title="${trustdetails}" />
<%
	ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
%>

<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<w4india:titleandnav title="Detail of Trust" subTitle="Detail of Trust aka Schedule FA-(F)&nbsp;-&nbsp;The details of trusts
				under the laws of a country outside India in which you are a trustee
				has to be filled up."/>
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
			<form id="frmtrustdetails" action="${actionUrl}" method="post"
				name="frmtrustdetails">

				<legend class="header-color">
					<small><fmt:message key="detail.trusts.itr2" /></small>
				</legend>

				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="country_code"><small><fmt:message
										key="foreign.country.code" /> </small> </label>
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
							<label for="name_trust"><small><fmt:message
										key="name.trust.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_trust" name="name_trust" class="uprcase"
								type="text" maxlength="125"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Trust}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_trust"><small><fmt:message
										key="address.trust.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_trust" name="address_trust" type="text"
								maxlength="200" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Trust}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_othertrust"><small>Name of Other
									trustees </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_othertrust" name="name_othertrust" type="text"
								class="uprcase" maxlength="125"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Othertrust}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_othertrust"><small>Address of
									Other trustees </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_othertrust" name="address_othertrust"
								type="text" maxlength="200" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Othertrust}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_settlor"><small><fmt:message
										key="name.settlor.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_settlor" name="name_settlor" type="text"
								maxlength="125" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Settlor}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_settlor"><small><fmt:message
										key="address.settlor.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_settlor" name="address_settlor" type="text"
								maxlength="200" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Settlor}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="name_beneficiaries"><small><fmt:message
										key="name.beneficiaries.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="name_beneficiaries" name="name_beneficiaries"
								type="text" maxlength="125" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Beneficiaries}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="address_beneficiaries"><small><fmt:message
										key="address.beneficiaries.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="address_beneficiaries" name="address_beneficiaries"
								type="text" maxlength="200" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Beneficiaries}"/></c:if>" />
						</div>
					</div>
				</div>
				<input type="hidden" id="country_name" name="country_name">
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefTrustDetail" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>

				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="foreign.country.name" /> </b></th>
					<th><b><fmt:message key="name.trust.itr2" /> </b></th>
					<th><b>Name of Other Trust</b></th>
					<th><b><fmt:message key="name.settlor.itr2" /> </b></th>
					<th><b><fmt:message key="name.beneficiaries.itr2" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.detailofTrustDetailList}"
						var="taxrelief">
						<tr>
							<td><c:out value="${taxrelief.country_Name}" /></td>
							<td><c:out value="${taxrelief.name_Trust}" /></td>
							<td><c:out value="${taxrelief.name_Othertrust}" /></td>
							<td><c:out value="${taxrelief.name_Settlor}" /></td>
							<td><c:out value="${taxrelief.name_Beneficiaries}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trustdetailedit"><small><i
										class=" glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trustdetaildelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>


				</c:if>
			</table>
			<a href="${scriptName}/trustdetailnew"
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

<res:client-validation formId="frmtrustdetails"
	screenConfigurationDocumentName="trustdetail"
	formSubmitButtonId="myModalHrefTrustDetail" />
