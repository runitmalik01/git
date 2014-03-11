<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="foreignasset">
	<fmt:message key="foreign.asset.itr2" />
</c:set>
<hippo-gogreen:title title="${foreignasset}" />
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
			<w4india:titleandnav title="Schedule FA-A"
				subTitle="This schedule is to be filled up by assessee who is <strong>resident</strong>
				not be filled up by <strong>'not ordinarily resident'</strong>
				or <strong>'non-resident'</strong>. Mention the details of foreign
				bank accounts, financial interest in any entityin Indian currency
				and account located outside India in which the assessee has signing
				authority." />
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
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					<fmt:message key="${checkForNRI}" />
				</div>
			</c:if>
			<c:choose>
				<c:when
					test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
					<form id="frmtForeignBankDetail" action="${actionUrl}"
						method="post" name="frmtForeignBankDetail">

						<legend class="header-color">
							<small><fmt:message key="foreign.asset.itr2" /></small>
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
									<label for="name_bank"><small><fmt:message
												key="name.bank.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="name_bank" name="name_bank" maxlength="125"
										type="text" class="uprcase"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Bank}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="address_bank"><small><fmt:message
												key="address.bank.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="address_bank" name="address_bank" maxlength="200"
										type="text" class="uprcase"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address_Bank}"/></c:if>" />
								</div>
							</div>
						</div>
						<div class="row show-grid">

							<div class="col-md-4">
								<div class="rowlabel">
									<label for="name_account"><small><fmt:message
												key="name.account.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="name_account" name="name_account" maxlength="125"
										type="text" class="uprcase" class="decimal"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Account}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="account_no"><small><fmt:message
												key="account.no.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="account_no" name="account_no" type="text"
										maxlength="17" class="uprcase"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.account_No}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="peak_balance"><small><fmt:message
												key="balance.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="peak_balance" name="peak_balance" type="text"
										maxlength="14" class="decimal uprcase"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.peak_Balance}"/></c:if>" />
								</div>
							</div>
						</div>
						<input type="hidden" id="country_name" name="country_name">
						<div class="row show-grid">
							<div class="col-md-4 col-md-offset-8 decimal">
								<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
								<a id="myModalHrefForeignBankDetail" role="button"
									class="btn btn-default btn-success">Save</a>
							</div>

						</div>
					</form>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-responsive">
						<tr align="center">
							<th><b><fmt:message key="foreign.country.name" /> </b></th>
							<th><b><fmt:message key="name.bank.itr2" /> </b></th>
							<th><b><fmt:message key="name.account.itr2" /> </b></th>
							<th><b><fmt:message key="account.no.itr2" /> </b></th>
							<th><b><fmt:message key="balance.itr2" /> </b></th>
							<th><b>Actions</b></th>
						</tr>
						<c:if test="${not empty parentBean}">
							<c:forEach items="${parentBean.foreignBankAccountDetailList}"
								var="foreignbank">
								<tr>
									<td><c:out value="${foreignbank.country_Name}" /></td>
									<td><c:out value="${foreignbank.name_Bank}" /></td>
									<td><c:out value="${foreignbank.name_Account}" /></td>
									<td><c:out value="${foreignbank.account_No}" /></td>
									<td><w4india:inr value="${foreignbank.peak_Balance}" /></td>
									<td><a class="btn btn-default btn-primary "
										href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/foreignbankdetailedit"><small><i
												class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
											&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
										href="${scriptName}/<c:out value="${foreignbank.canonicalUUID}"/>/foreignbankdetaildelete"
										data-confirm=""><small><i
												class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
									</a></td>
								</tr>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" align="center"></<b><fmt:message
											key="tds.amount.total" /></b></td>
								<td><w4india:inr value="${parentBean.total_peakBalance}" /></td>

							</tr>

						</c:if>
					</table>
					<a href="${scriptName}/foreignbankdetailnew"
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


<res:client-validation formId="frmtForeignBankDetail"
	screenConfigurationDocumentName="foreignbankdetail"
	formSubmitButtonId="myModalHrefForeignBankDetail" />