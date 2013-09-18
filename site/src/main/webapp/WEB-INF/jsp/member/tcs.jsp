<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="tcstitle">
	<fmt:message key="member.tcs.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${tcstitle}" />
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
	<h4>Schedule TCS</h4>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="frmdatatcs" action="${actionUrl}" method="post"
				name="frmdatatcs">
				<fieldset>
					<legend style="color: green; font-weight: bold;">Tax
						Collected from Sources Details</legend>
					<table>
						<tr>
							<th width="20%"><b>TAN of Collector</b></th>
							<th width="36%"><b>Name of Collector</b></th>
							<th width="22%"><b>Total Tax Deducted</b></th>
							<th width="22%"><b>Amount to be allowed as credit during
									the year</b></th>
						</tr>
						<tr>
							<td><input id="tan" name="tan" class="uprcase"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan}"/></c:if>"
								type="text"></td>
							<td><input id="name" name="name"
								placeholder="Collector Name" maxlength="125"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name}"/></c:if>"
								type="text"></td>
							<td><input id="totaltax" name="totaltax"
								placeholder="Amount" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.totaltax}"/></c:if>"
								type="text"></td>
							<td><input id="taxCredited" name="taxCredited"
								placeholder="Amount" maxlength="14"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.taxCredited}"/></c:if>"
								type="text"></td>
						</tr>
					</table>

				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span3 offset10">
						<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
						&nbsp; <a id="myModalHreftcs" role="button" class="btn orange">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b style="color: olive;">Tan Collector</b>
					</th>
					<th><b style="color: olive;">Name of Collector </b>
					</th>
					<th><b style="color: olive;">Total Tax </b>
					</th>
					<th><b style="color: olive;">Tax Credited </b>
					</th>
					<th><b style="color: olive;">Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.tcsDetailList}" var="tdsdetail">
						<tr>
							<td align="right"><c:out value="${tdsdetail.tan}" />
							</td>
							<td align="right"><c:out value="${tdsdetail.name}" />
							</td>
							<td align="right"><fmt:formatNumber type="number"
									groupingUsed="false" value="${tdsdetail.totaltax}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									groupingUsed="false" value="${tdsdetail.taxCredited}" />
							</td>
							<td><a class="btn btn-primary"
								href="${scriptName}/<c:out value="${tdsdetail.canonicalUUID}"/>/tcsedit"><small><i
										class="icon-pencil icon-white"></i>Edit</small> &nbsp;&nbsp; </a>&nbsp;&nbsp;<a
								class="btn btn-danger"
								href="${scriptName}/<c:out value="${tdsdetail.canonicalUUID}"/>/tcsdelete"
								id="delete" data-confirm=""><small><i
										class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
						</tr>

					</c:forEach>
					<tr align="center">
						<td colspan="2">Total Amount Claimed</td>
						<td align="right"><w4india:inr value="${parentBean.total}" />
						</td>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/tcsnew" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<res:client-validation formId="frmdatatcs"
	screenConfigurationDocumentName="tcs"
	formSubmitButtonId="myModalHreftcs" />