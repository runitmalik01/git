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
					<p>
						<span style="color: red">*</span> Indicates mandatory fields
					</p>
					<table>
						<tr>
							<th width="20%"><b>Assessment Year</b><span
								style="color: red">*</span>
							</th>
							<th width="25%"><b>Amount of brought forward unabsorbed
									depreciation</b><span style="color: red">*</span></th>
							<th width="25%"><b>Amount of depreciation set-off
									against the current year income</b><span style="color: red">*</span>
							</th>
							<th width="25%"><b>Balance Carried forward to the next
									year </b><span style="color: red">*</span>
							</th>
						</tr>
						<tr>
							<td><input id="assessYear" name="assessYear"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.assessYear}"/></c:if>"
								type="text">
							</td>

							<td><input id="amtUaDep" name="amtUaDep"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtUADepreciation}"/></c:if>"
								type="text">
							</td>
							<td><input id="amtDepCurrYear" name="amtDepCurrYear"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtDepCurrYear}"/></c:if>"
								type="text">
							</td>
							<td><input id="balanceCarry" name="balanceCarry"
								style="background-color: #DFDFDF"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.balanceCarry}"/></c:if>"
								type="text">
							</td>
						</tr>
					</table>

				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span3 offset10">
						<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
						&nbsp; <a id="myModalHrefUADepreciate" role="button"
							class="btn orange">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th width="20%"><b style="color: black;">Assessment Year</b></th>
					<th width="20%"><b style="color: black;">Amount of brought
							forward unabsorbed depreciation </b></th>
					<th width="20%"><b style="color: black;">Amount of
							depreciation set-off against the current year income </b></th>
					<th width="20%"><b style="color: black;">Balance Carried
							forward to the next year </b></th>
					<th width="20%"><b style="color: black;">Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.unabsorbedDepreciationDetailList}"
						var="capitalassetdetail">
						<tr>
							<td align="right"><c:out
									value="${capitalassetdetail.assessYear}" /></td>

							<td align="right"><c:out
									value="${capitalassetdetail.amtUADepreciation}" /></td>
							<td align="right"><c:out
									value="${capitalassetdetail.amtDepCurrYear}" /></td>
							<td align="right"><c:out
									value="${capitalassetdetail.balanceCarry}" /></td>
							<td><a class="btn btn-primary"
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/scheduleUDedit"><small><i
										class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp; </a>&nbsp;&nbsp;<a
								class="btn btn-danger"
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/scheduleUDdelete"
								id="delete" data-confirm=""><small><i
										class="icon-trash icon-white"></i>Delete</small> </a></td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td><b style="color: black;">Total Amounts</b>
						</td>
						<td align="right"><w4india:inr
								value="${parentBean.total_Amount}" /></td>
						<td align="right"><w4india:inr value="${parentBean.total2}" />
						</td>
						<td align="right"><w4india:inr value="${parentBean.total3}" />
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