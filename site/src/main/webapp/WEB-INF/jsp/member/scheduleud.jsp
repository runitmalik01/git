<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="capitalasset">
	<fmt:message key="member.capital.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${capitalasset}" />
<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
${aggIncome }

<div class="page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</h3>
	<h4>Schedule UD</h4>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="UAdepriciation" action="${actionUrl}" method="post"
				name="UAdepriciation">
				<fieldset>
					<legend style="color: green; font-weight: bold;">UnAbsorbed
						Depreciation Details</legend>
					<br />
					<div class="span4">
						<div class="rowlabel">
							<label for="assessYear"> <small>Assessment Year</small> </label>
						</div>
						<div class="rowlabel">
							<input id="assessYear" name="assessYear" maxLength="7"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.assessYear}"/></c:if>"
								type="text">
						</div>
					</div>

					<div class="span4">
						<div class="rowlabel">
							<label for="amtUaDep"> <small>Amount of brought
									forward unabsorbed depreciation</small> </label>
						</div>
						<div class="rowlabel">
							<input id="amtUaDep" name="amtUaDep" maxLength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtUADepreciation}"/></c:if>"
								type="text">
						</div>
					</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span3 offset10">
						<a href="${redirectURLToSamePage}" class="btn btn-danger">Cancel</a>
						&nbsp; <a id="myModalHrefUADepreciate" role="button"
							class="btn btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class=" table table-bordered">
				<tr align="center">
					<th><b style="color: black;">Assessment Year</b></th>
					<th width="20%"><b style="color: black;">Amount of brought
							forward unabsorbed depreciation </b></th>
					<th width="20%"><b style="color: black;">Amount of
							depreciation set-off against the current year income </b></th>
					<th width="20%"><b style="color: black;">Balance Carried
							forward to the next year </b></th>
					<th width="20%"><b style="color: black;">Actions</b></th>
				</tr>

				<c:if test="${not empty listofValuesDep && not empty parentBean}">
					<c:forEach items="${listofValuesDep}" var="UD">
						<c:forEach items="${parentBean.unabsorbedDepreciationDetailList}"
							var="depreciation">
							<c:if test="${UD.assYr eq depreciation.assessYear }">
								<c:forEach var="UUID" items="${depreciation.canonicalUUID}">
									<tr>
										<td align="right"><c:out value="${UD.assYr}" />
										</td>
										<td align="right"><c:out value="${UD.amtBFUD}" /></td>
										<td align="right"><c:out value="${UD.amtDeprSOCY}" />
										</td>
										<td align="right"><c:out value="${UD.balCFNY}" />
										</td>

										<td><a class="btn btn-primary"
											href="${scriptName}/<c:out value="${UUID}"/>/scheduleUDedit"><small><i
													class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp; </a>&nbsp;&nbsp;<a
											class="btn btn-danger"
											href="${scriptName}/<c:out value="${UUID}"/>/scheduleUDdelete"
											id="delete" data-confirm=""><small><i
													class="icon-trash icon-white"></i>Delete</small> </a>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:forEach>
					<tr align="center">
						<td colspan="3"><b style="color: black;">Total Amounts</b></td>
						<td align="right"><w4india:inr value="${totalCarryFwdAmt}" />
						</td>
				</c:if>

			</table>
			<a href="${redirectURLToSamePage}/scheduleUDnew"
				class="button orange">Add New</a>
		</c:otherwise>
	</c:choose>
</div>
<res:calc screenCalc="scheduleud" formId="UAdepriciation"></res:calc>
<res:client-validation formId="UAdepriciation"
	screenConfigurationDocumentName="scheduleud"
	formSubmitButtonId="myModalHrefUADepreciate" />