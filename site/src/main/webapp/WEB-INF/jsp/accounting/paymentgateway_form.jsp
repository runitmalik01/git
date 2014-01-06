<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.beans.compound.InvoiceDocumentDetail"%>
<%@page import="com.mootly.wcm.member.MemberInvoice"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<%--
	String currency;
	String orderAmount;
	String secSignature;
	String merchantAccessKey;
	String key;
 --%>
<c:choose>
	<c:when test="${not empty invoicePaymentDetail &&  empty invoicePaymentDetail.respCode }">	
		<c:set var="actionURL" value="${checkoutURL}"/>
		<form name="frmGateway" id="frmGateway" action="${actionURL}" method="post">
			<input type="text" id="merchantTxnId" value="<c:out value="${invoicePaymentDetail.paymentTransactionId}"/>" name="merchantTxnId"/>
			<input type="text" id="orderAmount" value="<c:out value="${invoicePaymentDetail.paymentAmount}"/>" name="orderAmount"/>
			<input type="text" id="paymentType" value="<c:out value="${invoicePaymentDetail.paymentType}"/>" name="paymentType"/>
			<input type="text" id="currency" value="INR" name="currency"/>
			<input type="text" id="secSignature" value="${secSignature}" name="secSignature"/>
			<input type="text" id="merchantAccessKey" value="${merchantAccessKey}" name="merchantAccessKey"/>
			<input type="text" id="returnUrl" value="${returnUrl}" name="returnUrl"/>
			
			<input type="text" id="email" value="${email}" name="email"/>
			<input type="text" id="firstName" value="${firstName}" name="firstName"/>
			<input type="text" id="lastName" value="${lastName}" name="lastName"/>
			<input type="text" id="phoneNumber" value="${phoneNumber}" name="phoneNumber"/>
			<input type="text" id="addressStreet1" value="${addressStreet1}" name="addressStreet1"/>
			<input type="text" id="addressCity" value="${addressCity}" name="addressCity"/>
			
			<input type="text" id="addressZip" value="${addressZip}" name="addressZip"/>
			<input type="text" id="addressState" value="${addressState}" name="addressState"/>
			
			<input type="submit" value="Submit"/>
		</form>		
		<div class="modal fade" id="modalConfirmation">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		         <h4 class="modal-title">Redirecting to Payment Gateway</h4>
		      </div>
		      <div class="modal-body">
		        <p>You will now be redirected to our Payment Partner (Citrus). Once a successful payment is made, you will be redirected back to <w4india:resellername/>.</p>
		      </div>
		      <div class="modal-footer">
		        <button id="submitForm" type="button" class="btn btn-primary">OK</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->		
		<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>
		  	 $(document).ready ( function() {
		  			$("#modalConfirmation").modal();
		  			$("#submitForm").click( function() {
		  				$("#frmGateway").submit();
		  			}); 		
		   	});
		</hst:element>		
		<hst:headContribution element="${uiCustom}" category="jsInternal" />		
	</c:when>
	<c:otherwise>
		<hst:actionURL var="actionURL"></hst:actionURL>
		<form name="frmGateway" id="frmGateway" action="${actionURL}" method="post">
			<input type="hidden" id="paymentType" value="<c:out value="${paymentType}"/>" name="paymentType"/>
			<c:forEach items="${formFields}" var="formField">
				<input type="hidden" value="${formField.value}" name="${formField.key}"/>
			</c:forEach>
		</form>
		<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>
		  	 $(document).ready ( function() {
		  			$(".classRequiresGateway").click( function() {
		  				pType = $(this).attr("id").substring(5);
		  				$("#paymentType").val(pType);
		  				$("#frmGateway").submit();
		  			}); 		
		   	});
		</hst:element>		
		<hst:headContribution element="${uiCustom}" category="jsInternal" />
	</c:otherwise>
</c:choose>


