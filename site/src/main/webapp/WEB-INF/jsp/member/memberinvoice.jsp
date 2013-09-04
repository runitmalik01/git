
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.beans.compound.InvoiceDocumentDetail"%>
<%@page import="com.mootly.wcm.member.MemberInvoice"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="parentBeantitle">
	<fmt:message key="member.invoice.title" />
</c:set>
<hippo-gogreen:title title="${parentBeantitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<w4india:itrmenu></w4india:itrmenu>
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>Invoice Details</c:otherwise>
		</c:choose>
	</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>

	<c:choose>
		<c:when
			test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">

			<form id="frmdataInvoice" action="${actionUrl}" method="post"
				name="frmdataInvoice">
				<fieldset>
					<legend>Invoice Details</legend>
					<div class="row-fluid show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<label for="services"><small>Services</small> </label>
							</div>
						</div>
						<div class="span4 offset1">
							<div class="rowlabel">
								<select name="services" id="services">
									<c:forEach var="serviceList" items="${serviceDocumentList}">
										<option value="<c:out value="${serviceList.name}"></c:out>">
											<c:out value="${serviceList.name}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<label for="filingMode"><small>Mode</small> </label>
							</div>
						</div>
						<div class="span3 offset1">
							<div class="rowlabel">
								<select name="filingMode" id="filingMode">
									<option value="">-Select-</option>
									<option value="efile"
										<c:if test="${not empty childBean.filingMode && childBean.filingMode =='E'}">selected</c:if>>EFile</option>
									<option value="ezfile"
										<c:if test="${not empty childBean.filingMode && childBean.filingMode =='Ez'}">selected</c:if>>EzFile</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<label for="quantity"><small>Quantity</small> </label>
							</div>
						</div>
						<div class="span3 offset1">
							<div class="rowlabel">
								<input id="quantity" name="quantity" placeholder="Quantity"
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.quantity}"/></c:if>" />

							</div>
						</div>
					</div>

					<div class="row-fluid show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<label for="amount"><small>Amount</small> </label>
							</div>
						</div>
						<div class="span3 offset1">
							<div class="rowlabel">
								<input id="amount" name="amount" placeholder="Amount"
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amount}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span3 offset10">
						<a href="${redirectURLToSamePage}" class="btn btn-danger"
							style="color: black">Cancel</a> &nbsp; <a id="myModalHrefinvoice"
							role="button" class="btn btn-success" style="color: black">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<!--  show the table -->
			<table>
				<tr align="center">
					<th><b>Services</b></th>
					<th><b>Mode</b>
					</th>
					<th><b>Quantity</b></th>
					<th><b>Amount</b></th>

				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.invoiceDocumentDetailList}"
						var="invoicedocumentdetail">
						<tr>
							<td><c:out value="${invoicedocumentdetail.services}" /></td>
							<td><c:out value="${invoicedocumentdetail.mode}" /></td>
							<td><a class="btn btn-primary"
								href="${scriptName}/<c:out value="${invoicedocumentdetail.canonicalUUID}"/>/memberinvoiceedit"><i
									class="icon-pencil icon-white"></i><small>Edit</small> </a>&nbsp;&nbsp;<a
								class="btn btn-danger"
								href="${scriptName}/<c:out value="${invoicedocumentdetail.canonicalUUID}"/>/memberinvoicedelete"
								data-confirm=""><i class="icon-trash icon-white"></i><small>Delete</small>
							</a></td>
						</tr>
					</c:forEach>
					<tr>

					</tr>
				</c:if>
			</table>
			<c:if test="${empty NEW_CHILD_DISABLED}">
				<a href="${scriptName}/memberinvoicenew" class="btn btn-info"
					style="color: black">Add New</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>
<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="memberinvoice"
	formSubmitButtonId="myModalHrefinvoice" />
