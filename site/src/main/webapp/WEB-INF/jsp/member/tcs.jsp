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
	<w4india:titleandnav title="Tax Collected at Source" subTitle="Schedule TCS&nbsp;-&nbsp;It is income tax collected by
			seller in India from payer on sale of certain items in section
			206C.The seller has to collect tax at specified rates from the payer
			who has purchased these items as Alcoholic liquor for human
			consumption,Tendu leaves,Timber obtained under a forest lease,Scrap
			Minerals being coal or lignite or iron ore Scrap Batteries."></w4india:titleandnav>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="frmdatatcs" action="${actionUrl}" method="post"
				name="frmdatatcs">
				<fieldset>
					<legend class="header-color"><small>Tax Collected from Sources
						Details</small></legend>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">

								<label for="tan">TAN of Collector </label>
							</div>
							<div class="rowlabel">
								<input id="tan" name="tan" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan}"/></c:if>"
									type="text">
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="name">Name of Collector </label>
							</div>
							<div class="rowlabel">
								<input id="name" name="name" placeholder="Collector Name"
									maxlength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name}"/></c:if>"
									type="text">

							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="totaltax">Total Tax Deducted </label>
							</div>
							<div class="rowlabel">
								<input id="totaltax" name="totaltax" placeholder="Amount"
									maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.totaltax}"/></c:if>"
									type="text">

							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="taxCredited">Amount to be allowed as credit
									during the year </label>
							</div>
							<div class="rowlabel">
								<input id="taxCredited" name="taxCredited" placeholder="Amount"
									maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.taxCredited}"/></c:if>"
									type="text">

							</div>
						</div>
					</div>
				</fieldset>
				<div class="row show-grid">
					<div class="col-md-3 col-md-offset-10">
						<a href="${redirectURLToSamePage}"
							class="btn btn-default btn-danger" >Cancel</a>
						&nbsp; <a id="myModalHreftcs" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b>Tan Collector</b></th>
					<th><b>Name of Collector </b></th>
					<th><b>Total Tax </b></th>
					<th><b>Tax Credited </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.tcsDetailList}" var="tdsdetail">
						<tr>
							<td align="right"><c:out value="${tdsdetail.tan}" /></td>
							<td align="right"><c:out value="${tdsdetail.name}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									groupingUsed="false" value="${tdsdetail.totaltax}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									groupingUsed="false" value="${tdsdetail.taxCredited}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${tdsdetail.canonicalUUID}"/>/tcsedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${tdsdetail.canonicalUUID}"/>/tcsdelete"
								id="delete" data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>

					</c:forEach>
					<tr align="center">
						<td colspan="2">Total Amount Claimed</td>
						<td align="right"><w4india:inr value="${parentBean.total}" />
						</td>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/tcsnew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
					
			<c:if test = "${not empty is26ASImportEnabled && is26ASImportEnabled == true}">
					<a href="servicerequest-itr-sync-tds-from-dit.html" class="btn btn-default btn-success"><small><i
							class="glyphicon glyphicon-import"></i>Import 26AS</small></a>
					</c:if>			
		</c:otherwise>
	</c:choose>
</div>
<res:client-validation formId="frmdatatcs"
	screenConfigurationDocumentName="tcs"
	formSubmitButtonId="myModalHreftcs" />