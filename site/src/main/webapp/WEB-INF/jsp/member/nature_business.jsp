<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="nat_bus">
	Nature of Business
</c:set>
<hippo-gogreen:title title="${nat_bus}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<w4india:titleandnav title="Nature Of Business"/>
	<hst:link var="mainSiteMapRefId" />
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmNature_business" action="${actionUrl}" method="post"
				name="frmNature_business">
				<fieldset>
					<legend class="header-color">
						<small><fmt:message key="nature.business.itr4" /></small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="business_code"><small><fmt:message
											key="business.name.itr4" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="business_code" name="business_code" class="uprcase">
									<option value="">-Select-</option>
									<c:forEach var="catBusinessCode" items="${catBusinessCode}">
									 <optgroup label="${catBusinessCode.key}">
									 <c:forEach var="subCatBussCode" items="${catBusinessCode.value}">
									 	<option
											<c:if test="${childBean.business_Code == subCatBussCode.key}">selected</c:if>
											value="${subCatBussCode.key}">${subCatBussCode.value}</option>
									 </c:forEach>
									 </optgroup>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="tradeName_Proprietorship"><small><fmt:message
											key="tradeName.Proprietorship.itr4" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="tradeName_Proprietorship" class="uprcase"
									maxlength="125" name="tradeName_Proprietorship" type="text"
									value="${childBean.tradeName_Proprietorship}" />
							</div>
						</div>
					</div>
					<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="tradeName_ProprietorshipSec"><small><fmt:message
										key="tradeName.Proprietorship.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="tradeName_ProprietorshipSec" class="uprcase" maxlength="125"
								name="tradeName_ProprietorshipSec" type="text" value="${childBean.tradeName_ProprietorshipSec}" />
						</div>
					</div>
				
				
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="tradeName_ProprietorshipLast"><small><fmt:message
										key="tradeName.Proprietorship.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="tradeName_ProprietorshipLast" class="uprcase" maxlength="125"
								name="tradeName_ProprietorshipLast" type="text" value="${childBean.tradeName_ProprietorshipLast}" />
						</div>
					</div>
				</div>
				</fieldset>

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
					<a	href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefBusinessNature" role="button"
							class="btn btn-default btn-success">Save</a> 
					</div>
				</div>

			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="business.name.itr4" /> </b></th>

					<th><b><fmt:message key="tradeName.Proprietorship.itr4" />
					</b></th>

					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.natureBusinessDetailList}"
						var="businessDetail">
						<tr>
							<td class="uprcase">
								<c:forEach var="catBusinessCode" items="${catBusinessCode}">
									 <c:forEach var="subCatBussCode" items="${catBusinessCode.value}">
										<c:if test="${businessDetail.business_Code == subCatBussCode.key}"><c:out value="${subCatBussCode.value}"></c:out></c:if>
									 </c:forEach>
								</c:forEach>				
							</td>
							<td>
							<c:out value="${businessDetail.tradeName_Proprietorship}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${businessDetail.canonicalUUID}"/>/businessnatureedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${businessDetail.canonicalUUID}"/>/businessnaturedelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>

					</c:forEach>

				</c:if>
			</table>
			<c:if test="${empty NEW_CHILD_DISABLED}">
				<a href="${scriptName}/businessnaturenew"
					class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>

<res:client-validation formId="frmNature_business"
	screenConfigurationDocumentName="businessnature"
	formSubmitButtonId="myModalHrefBusinessNature" />
