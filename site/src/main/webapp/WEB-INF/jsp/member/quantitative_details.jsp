<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="qDetails">
	<fmt:message key="qDetails" />
</c:set>
<hippo-gogreen:title title="${qDetails}" />
<hst:actionURL var="actionUrl" />
<%
	ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap<String,String> objHashMapQuantUnitCode = objValueListService.getQuantitativeCode();
request.setAttribute("objHashMapQuantUnitCode", objHashMapQuantUnitCode);
%>

<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<fmt:message key="quantitative.details.itr4" var="subTitle"/>
	<w4india:titleandnav title="Quantitative Details -Trade" subTitle="${subTitle}"/>
	<hst:link var="mainSiteMapRefId" />
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmQuantitativeDetails" action="${actionUrl}" method="post"
				name="frmQuantitativeDetails">
				<legend class="header-color">
					<small><fmt:message key="quantitative.details.itr4.A" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="item_Name"><small><fmt:message
										key="item.Name.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="item_Name" name="item_Name" type="text" maxlength="25"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.item_Name}"/></c:if>" />
						</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="itemUnit_Code"><small><fmt:message
										key="item.unit.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<select id="itemUnit_Code" name="itemUnit_Code">
								<option value="">-Select-</option>
								<c:forEach var="quantUnits" items="${objHashMapQuantUnitCode}">
									<option
										<c:if test="${childBean.itemUnit_Code == quantUnits.key}">selected</c:if>
										value="${quantUnits.key}">${quantUnits.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="col-md-4">
						<div class="rowlabel">
							<label for="opening_Stock"><small><fmt:message
										key="opening.Stock.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="opening_Stock" name="opening_Stock" type="text"
								maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.opening_Stock}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="purchage"><small><fmt:message
										key="purchage.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="purchage" name="purchage" maxlength="14" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.purchage}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="sales_Qty"><small><fmt:message
										key="sales.Qty.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="sales_Qty" name="sales_Qty" type="text" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.sales_Qty}"/></c:if>" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="closing_Stock"><small><fmt:message
										key="closing.Stock.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="closing_Stock" name="closing_Stock" type="text"
								maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.closing_Stock}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="shortage_IfAny"><small><fmt:message
										key="shortage.IfAny.quant.itr4" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="shortage_IfAny" name="shortage_IfAny" type="text"
								maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.shortage_IfAny}"/></c:if>" />
						</div>
					</div>
				</div>


				<input type="hidden" id="itemUnit_Name" name="itemUnit_Name">

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalQuantitativeDetails" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="item.Name.quant.itr4" /> </b></th>
					<th><b><fmt:message key="item.Name.quant.itr4" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.quantitativeUnitDetailList}"
						var="QuantitativeDetails">
						<tr>
							<td><c:out value="${QuantitativeDetails.item_Name}" /></td>
							<td><c:out value="${QuantitativeDetails.itemUnit_Name}" />
							</td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${QuantitativeDetails.canonicalUUID}"/>/quantitativedetailsedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${QuantitativeDetails.canonicalUUID}"/>/quantitativedetailsdelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
					</c:forEach>

				</c:if>
			</table>
			<a href="${scriptName}/quantitativedetailsnew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<script type="text/javascript">
	$("#itemUnit_Code")
			.ready(
					function() {
						if ($("#itemUnit_Code").val() != null) {
							<c:forEach var="QuantitativeCode" items="${objHashMapQuantUnitCode}">
							if ($("#itemUnit_Code").val() == '<c:out value="${QuantitativeCode.key}"/>') {
								$("#itemUnit_Name")
										.val(
												'<c:out value="${QuantitativeCode.value}"/>');
							}
							</c:forEach>

						}
					});

	$("#itemUnit_Code")
			.change(
					function() {
						if ($("#itemUnit_Code").val() != null) {
							<c:forEach var="QuantitativeCode" items="${objHashMapQuantUnitCode}">
							if ($("#itemUnit_Code").val() == '<c:out value="${QuantitativeCode.key}"/>') {
								$("#itemUnit_Name")
										.val(
												'<c:out value="${QuantitativeCode.value}"/>');
							}
							</c:forEach>

						}
					});
</script>
<res:client-validation formId="frmQuantitativeDetails"
	screenConfigurationDocumentName="quantitativedetails"
	formSubmitButtonId="myModalQuantitativeDetails" />
