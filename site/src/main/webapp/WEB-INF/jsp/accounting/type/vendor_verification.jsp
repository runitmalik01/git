<%@page import="com.mootly.wcm.model.PaymentVerificationStatus"%>
<%@page import="com.mootly.wcm.model.ITRServiceDelivery"%>
<%@page import="com.mootly.wcm.model.ITRForm"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="com.mootly.wcm.model.PaymentType"%>
<%@include file="../../includes/tags.jspf" %>
<c:if test="${not empty parentBean}">
	<c:if test="${empty allReadOnly && not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
		<div class="row show-grid">
			<div class="col-md-4">
					<fieldset>
						<legend>Vendor - Payment Verification</legend>
				   		<select name="paymentVerificationStatusStr">
				   			<option value="">Select Payment Verification</option>
				   			<%for (PaymentVerificationStatus aPaymentStatus : PaymentVerificationStatus.values()) {%>
				   				<%
				   					pageContext.setAttribute("aPaymentStatus",aPaymentStatus);
				   				%>
				   				<option <c:if test="${aPaymentStatus == 'VERIFIED' && not empty childBean.paymentVerificationStatus && childBean.paymentVerificationStatus == 'VERIFIED'}">selected</c:if> value="<%=aPaymentStatus.name()%>"><%=aPaymentStatus.name()%></option>
				   			<%} %>
				   		</select>
				   	</fieldset>
			   	</div>		
				<div class="col-md-4 col-md-offset-4">
					<fieldset>
						<legend>Vendor - Transaction Amount</legend>
				   		<input id="txnAmount" name="vendor_txnAmount" value="${childBean.txnAmount}"/>				   			
				   	</fieldset>
			   	</div>
		</div>
	</c:if>
</c:if>