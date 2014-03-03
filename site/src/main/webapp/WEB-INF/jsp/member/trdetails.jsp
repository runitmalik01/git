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
	<w4india:itrmenu />
	<fmt:message
					key="tr.details.itr2" var="subTitle"/>
	<w4india:titleandnav title="Relief under Section 90/90A/91" subTitle="Schedule TR&nbsp;-&nbsp;${subTitle}&nbsp;i.e details of tax paid outside
				India on the income declared in Schedule FSI, Tax Payer
				Identification Number (TIN) of the assessee in the country where tax
				has been paid is to be filled up."/>
	<hst:link var="mainSiteMapRefId" />
	<%
		ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
		SortedSet<Map.Entry<String,String>> objHashMapcountry = ObjValueListService.getCountry();
		request.setAttribute("objHashMapcountry", objHashMapcountry);
	%>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmtrdetails" action="${actionUrl}" method="post"
				name="frmtrdetails">
				<legend class="header-color">
					<small>Enter Details</small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="country_code"><small><fmt:message
										key="foreign.country.name" /> </small> </label>
						</div>

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

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="tax_ID"><small><fmt:message
										key="tax.id.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="tax_ID" name="tax_ID" maxlength="16" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tax_ID}"/></c:if>" />
						</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="article_dtaa"><small><fmt:message
										key="article.dtaa.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="article_dtaa" name="article_dtaa" type="text"
								maxlength="16"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.article_dtaa}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="totaltax_fsi"><small><fmt:message
										key="total.tax.fsi.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="totaltax_fsi" name="totaltax_fsi" type="text"
								class="decimal" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.totaltax_fsi}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="relief90_91"><small><fmt:message
										key="relief.90.91.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="relief90_91" name="relief90_91" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief90_91}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="relief91"><small><fmt:message
										key="relief.91.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="relief91" name="relief91" type="text" maxlength="14"
								class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.relief91}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="isDtaa"><small><fmt:message
										key="foreign.is.dtaa.applicable" /> </small> </label>
						</div>
						<div class="rowlabel">
							<select id="isDtaaCountry" name="isDtaaCountry">
								<option value="">-Select-</option>
								<option value="Yes"
									<c:if test="${not empty childBean.isDtaaCountry && childBean.isDtaaCountry =='Yes'}">selected</c:if>>Yes</option>
								</option>
								<option value="No"
									<c:if test="${not empty childBean.isDtaaCountry && childBean.isDtaaCountry =='No'}">selected</c:if>>No</option>
								</option>
							</select>
						</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="dtaa_CountryTax"><small><fmt:message
										key="foreign.dtaa.totaltax" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="dtaa_CountryTax" name="dtaa_CountryTax" type="text"
								readonly="readonly" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.dtaa_CountryTax}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="Nodtaa_CountryTax"><small><fmt:message
										key="foreign.Nodtaa.totaltax" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="Nodtaa_CountryTax" name="Nodtaa_CountryTax"
								type="text" readonly="readonly" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.nodtaa_CountryTax}"/></c:if>" />
						</div>

					</div>
				</div>
				<input type="hidden" id="country_name" name="country_name">
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefTaxrebate" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>

				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="foreign.country.name" /> </b></th>
					<th><b><fmt:message key="tax.id.itr2" /> </b></th>
					<th><b><fmt:message key="article.dtaa.itr2" /> </b></th>
					<th><b><fmt:message key="total.tax.fsi.itr2" /> </b></th>
					<th><b><fmt:message key="relief.90.91.itr2" /> </b></th>
					<th><b><fmt:message key="relief.91.itr2" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.taxReliefDetailList}"
						var="taxrelief">
						<tr>
							<td><c:out value="${taxrelief.country_Name}" /></td>
							<td><c:out value="${taxrelief.tax_ID}" /></td>
							<td><c:out value="${taxrelief.article_dtaa}" /></td>
							<td><w4india:inr value="${taxrelief.totaltax_fsi}" /></td>
							<td><w4india:inr value="${taxrelief.relief90_91}" /></td>
							<td><w4india:inr value="${taxrelief.relief91}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trdetailsedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${taxrelief.canonicalUUID}"/>/trdetailsdelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3" align="center"><b>Total</b></td>
						<td><w4india:inr value="${parentBean.total_TaxFsi}" /></td>
						<td><w4india:inr value="${parentBean.rebate9091}" /></td>
						<td><w4india:inr value="${parentBean.rebate90}" /></td>
					</tr>
				</c:if>
			</table>

			<a href="${scriptName}/trdetailsnew" class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>

<script type="text/javascript">
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
<res:calc screenCalc="taxrelief" formId="frmtrdetails"></res:calc>
<res:client-validation formId="frmtrdetails"
	screenConfigurationDocumentName="taxrelief"
	formSubmitButtonId="myModalHrefTaxrebate" />
