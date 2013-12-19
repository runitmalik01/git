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
			<c:otherwise>Invoice Number</c:otherwise>
		</c:choose>
		- <c:out value="${parentBean.invoiceNumber}"/> - Payment by <fmt:message key="paymentType.${paymentType}.label" />
	</h3>
	<c:if test="${parentBean.amountDue > 0}">
		<h4>Amount Due: <w4india:inr value="${parentBean.amountDue}"/></h4>
	</c:if>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:choose>
		<c:when test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">
			<form id="frmdataInvoice" action="${actionUrl}" method="post" name="frmdataInvoice">
				<hst:link var="home" siteMapItemRefId="itreturnhome"></hst:link>
				<hst:link var="invoiceLink" siteMapItemRefId="memberinvoice"></hst:link>
				<ul class="breadcrumb">
					<li><a href="${home}" class="btn btn-default btn-info"><i class="glyphicon glyphicon-home glyphicon glyphicon-white"></i><strong>Member Home</strong></a> <span
						class="divider">/</span></li>
					<li><a href="${scriptName}" class="btn btn-default btn-info"><i class="glyphicon glyphicon-file glyphicon glyphicon-white"></i><strong>Member Invoices</strong></a><span
						class="divider">/</span></li>
					<li class="active"><c:out value="${fn:replace(paymentType,'_',' ')}" /></li>
				</ul>
				<jsp:include page="type/${paymentType}.jsp"></jsp:include>
			</form>
		</c:when>
		<c:otherwise>
			<!--  show the table -->
			<table>
				<tr align="center">
					<th><b>Services</b></th>
					<th><b>Mode</b></th>
					<th><b>Rate</b></th>
					<th><b>Quantity</b></th>
					<th><b>Amount</b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.invoiceDocumentDetailList}" var="invoicedetail">
						<tr align="center">
						<tr>
							<td><c:out value="${invoicedetail.serviceName}" /></td>
							<td><c:out value="${invoicedetail.filingMode}" /></td>
							<td><c:out value="${invoicedetail.serviceRate}" /></td>
							<td><c:out value="${invoicedetail.serviceQty}" /></td>
							<td><c:out value="${invoicedetail.serviceAmount}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${invoicedetail.canonicalUUID}"/>/memberinvoiceedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small> </a>&nbsp;&nbsp;<a
								class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${invoicedetail.canonicalUUID}"/>/memberinvoicedelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small> </a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<c:if test="${empty NEW_CHILD_DISABLED}">
				<a href="${scriptName}/payment/paymentadd" class="btn btn-default btn-info"
					style="color: black">Add New</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</div>
<hst:element var="uiCustom" name="script">
<hst:attribute name="type">text/javascript</hst:attribute>
     $('#filingMode,#services').change(function(){
		  <c:forEach items="${serviceDocumentList}" var="serviceList">
		    if('<c:out value="${serviceList.name}"/>' == $('#services').val()){
		      <c:if test="${not empty serviceList.costModel}">
		        <c:forEach items="${serviceList.costModel}" var="costModal">
		           if('<c:out value="${costModal.offeringMode}"/>' == $('#filingMode').val()){
 		               $('#amount').val('<c:out value="${costModal.cost}"/>');	         
		             }
		         </c:forEach>
		       </c:if>
		       }
		    </c:forEach> 
	  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="memberinvoice"
	formSubmitButtonId="myModalHrefinvoice" />
