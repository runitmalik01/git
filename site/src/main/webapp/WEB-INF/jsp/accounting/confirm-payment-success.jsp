<%@include file="../includes/tags.jspf"%>
<c:set var="parentBeantitle">
	<fmt:message key="member.invoice.title" />(${paymentType})
</c:set>
<hippo-gogreen:title title="${parentBeantitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<w4india:itrmenu></w4india:itrmenu>
	<h3 id="respond1">
		<c:choose>
			<c:when test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>Invoice Number</c:otherwise>
		</c:choose>
		- <c:out value="${invoiceDocument.invoiceNumber}" /> - Payment by <fmt:message key="paymentType.${paymentType}.label" />
	</h3>
	<c:if test="${invoiceDocument.amountDue > 0}">
		<h4> Amount Paid: <w4india:inr value="${invoiceDocument.amountDue}"/></h4>
	</c:if>
	<div class="hero-unit">
	   <div class="alert alert-success">
	    You have successfully paid for Member Invoices.
	    </div>
	   <br/>Wealth4India have received your payment.Wealth4India is very thankful to you. 
	   <div class="" align="center"><a class="btn btn-default btn-info"><i class="glyphicon glyphicon-home glyphicon glyphicon-white"></i>&nbsp;Go Home</a></div>
	</div>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
     $('#filingMode,#services').change(function(){
		  <c:forEach items="${serviceDocumentList}" var="serviceList">
		    if('<c:out value="${serviceList.name}" />' == $('#services').val()){
		      <c:if test="${not empty serviceList.costModel}">
			<c:forEach items="${serviceList.costModel}" var="costModal">
		           if('<c:out value="${costModal.offeringMode}" />' == $('#filingMode').val()){
 		               $('#amount').val('<c:out value="${costModal.cost}" />');	         
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
