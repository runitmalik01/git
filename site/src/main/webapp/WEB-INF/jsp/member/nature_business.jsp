<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="nat_bus">
	<fmt:message key="nat_bus" />
</c:set>
<hippo-gogreen:title title="${nat_bus}" />
<hst:actionURL var="actionUrl" />
<%
ValueListService ObjValueListService = ValueListServiceImpl.getInstance();
TreeMap<String,String> objHashMapBusinessCode=ObjValueListService.getBusinessCode();

request.setAttribute("objHashMapBusinessCode", objHashMapBusinessCode);
%>

<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />

	<h4>
		<fmt:message key="nature.business.itr4" />
	</h4>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmNature_business" action="${actionUrl}" method="post"
				name="frmNature_business">
				<fieldset>
				<legend style="color: black">Enter Details</legend>
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="business_code"><small><fmt:message
										key="business.name.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<select id="business_code" name="business_code" class="uprcase">
						<option value="">-Select-</option>
						<c:forEach var="businessCode" items="${objHashMapBusinessCode}">
							<option
								<c:if test="${childBean.business_Code == businessCode.key}">selected</c:if>
								value="${businessCode.key}">${businessCode.value}</option>
						</c:forEach>
					</select>
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="tradeName_Proprietorship"><small><fmt:message
										key="tradeName.Proprietorship.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="tradeName_Proprietorship" class="uprcase" maxlength="125"
								name="tradeName_Proprietorship" type="text" value="${childBean.tradeName_Proprietorship}" />
						</div>
					</div>
				</div>
     </fieldset>

				<div class="row-fluid show-grid">
				   <div class="span4 offset8 decimal">
					  <a href="${scriptName}"
						 class="btn btn-danger" style="color: black">Cancel</a>&nbsp; <a id="myModalHrefBusinessNature"
						 role="button" class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>

			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b><fmt:message key="business.name.itr4" /> </b></th>

					<th><b><fmt:message key="tradeName.Proprietorship.itr4" />
					</b>
					</th>

					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.natureBusinessDetailList}"
						var="businessDetail">
						<tr>
							<td class="uprcase">
							<c:forEach items="${objHashMapBusinessCode}" var="businessmap">
							<c:if test="${businessmap.key == businessDetail.business_Code}">
							<c:out value="${businessmap.value}" />
							</c:if>
							</c:forEach>
							</td>
							<td><c:out
									value="${businessDetail.tradeName_Proprietorship}" /></td>

							<td><a class="btn btn-danger"
								href="${scriptName}/<c:out value="${businessDetail.canonicalUUID}"/>/businessnatureedit"><small><i
										class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp; </a>&nbsp;<a
								class="btn btn-primary"
								href="${scriptName}/<c:out value="${businessDetail.canonicalUUID}"/>/businessnaturedelete"
								data-confirm=""><small><i
										class="icon-trash icon-white"></i>Delete</small> </a></td>
						</tr>

					</c:forEach>

				</c:if>
			</table>
            <c:if test="${empty NEW_CHILD_DISABLED}">
			<a href="${scriptName}/businessnaturenew" class="btn btn-info" style="color: black">Add
				New</a>
            </c:if>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
	$('#business_code').ready(function(){
		if ($("#business_code").val() != null) {
			<c:forEach var="businessCode" items="${objHashMapBusinessCode}">
			if ($("#business_name").val() == '<c:out value="${businessCode.key}"/>') {
				$("#business_code").val('<c:out value="${businessCode.value}"/>');
			}
			</c:forEach>

		}
	});

	$("#business_code").change(function() {
	if ($("#business_code").val() != null) {
							<c:forEach var="businessCode" items="${objHashMapBusinessCode}">
							if ($("#business_code").val() == '<c:out value="${businessCode.key}"/>') {
								$("#business_name").val('<c:out value="${businessCode.value}"/>');
							}
							</c:forEach>

						}
					});
</script>
<res:client-validation formId="frmNature_business"
	screenConfigurationDocumentName="businessnature"
	formSubmitButtonId="myModalHrefBusinessNature" />
