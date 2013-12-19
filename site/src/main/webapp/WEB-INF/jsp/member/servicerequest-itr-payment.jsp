<%@page import="com.mootly.wcm.model.PaymentVerificationStatus"%>
<%@page import="com.mootly.wcm.model.ITRServiceDelivery"%>
<%@page import="com.mootly.wcm.model.ITRForm"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="com.mootly.wcm.model.PaymentType"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="itrpayment_title">
	<fmt:message key="member.itrpayment.title" />
</c:set>
<hippo-gogreen:title title="${itrpayment_title}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<%
	ITRForm itrForm;
	ITRServiceDelivery itrServiceDelivery;
	MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request
			.getAttribute(MemberPersonalInformation.class
					.getSimpleName().toLowerCase());
	if (memberPersonalInformation != null) {
		itrForm = memberPersonalInformation.getSelectedITRForm();
		itrServiceDelivery = memberPersonalInformation
				.getSelectedServiceDeliveryOption();
		pageContext.setAttribute("itrServiceDelivery",
				itrServiceDelivery);
	}
%>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${itrForm}" />
		</div>
	</c:forEach>
</c:if>
<div class="page">
	<w4india:itrmenu />
	<h4>
		Payment for Package
		<fmt:message key="${itrForm}.packageName.${itrServiceDelivery}.cost"
			var="totalCost" />
		<w4india:inr value="${totalCost}"></w4india:inr>
	</h4>
	<c:if test="${not empty success}">
		<div class="alert alert-success">
 			<fmt:message key="itrpayment.success"/>
		</div>
	</c:if>
	<h5 style="color: maroon;">Your Income Tax return will be
		available for email/download, once <w4india:resellername/> receives and
		successfully verifies your payment.</h5>
	<c:if test="${not empty parentBean}">
		<c:choose>
			<c:when
				test="${not empty parentBean.paymentVerificationStatus && parentBean.paymentVerificationStatus == 'VERIFIED'}">
				<span class="label label-default label-success">Your payment has been
					verified by <w4india:resellername/>. You can continue to download XML.</span>
				<c:set var="allReadOnly" value="readonly" />
			</c:when>
			<c:otherwise>
				<span class="label label-default label-danger">Your payment information
					is still being reviewed.
			   </span>
			</c:otherwise>
		</c:choose>
	</c:if>
	<form id="frmPayment" action="${actionUrl}" method="post"
		name="frmPayment">
		<fieldset>
			<legend>Payment Options. You can choose one of the following
				methods of payment</legend>
			<div class="row show-grid">
				<div class="col-md-12 info">
					<b style="color: teal;">Please mention the PAN Number in the
						Memo Section of the payment</b>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="ack_no"><small>By Cheque</small> </label>
					</div>
					<div class="rowlabel">
						Bank Name: <b>ICICI Bank Ltd.,</b> <br /> Payee Name: <b>Wealth 4 India Private Limited</b><br /> Account Number: <b>114305000075 </b><br />
						Branch: <b>Office Number 11, Times Tower, M.G Road, Gurgaon -
							122001, Haryana.</b><br /> RTGS/NEFT/IFSC CODE: ICIC0001143
					</div>
				</div>
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="ack_no"><small>NEFT/RTGS</small> </label>
					</div>
					<div class="rowlabel">
						RTGS/NEFT/IFSC CODE: <b style="color: teal;"> ICIC0001143</b>
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend>Please enter your payment details</legend>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="ack_no"><small>Payment Type</small> </label>
					</div>
					<div class="rowlabel">
						<c:choose>
							<c:when test="${empty allReadOnly}">
								<select name="paymentType" id="paymentType">
									<option value="">Select</option>
									<%
										for (PaymentType paymentType : PaymentType.values()) {
													pageContext.setAttribute("paymentType", paymentType);
									%>
									<option value="<%=paymentType%>"
										<c:if test="${paymentType == parentBean.paymentType}">selected</c:if>>
										<fmt:message key="paymentType.${paymentType}.label" />
									</option>
									<%
										}
									%>
								</select>
							</c:when>
							<c:otherwise>
								<c:out value="${parentBean.paymentType}" />
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>
		</fieldset>
		<fieldset class="CHECK_ONLY CASH_NOT_ONLY RTGS_NOT_ONLY"
			style="display: none">
			<legend>Cheque Details</legend>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkNo"><small>Cheque No.</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="checkNo" name="checkNo"
							value="${parentBean.checkNo}" <c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkDate"><small>Dated</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="checkDate" name="checkDate"
							value="${parentBean.checkDateStr}"
							<c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-2">
					<div class="rowlabel">
						<label for="checkDate"><small>For (Amount)</small> </label>
					</div>
					<div class="rowlabel">
						<w4india:inr value="${totalCost}" />
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel"><label for="checkBank"><small>Drawn On Bank</small> </label></div>				
					<div class="rowlabel">
						<input type="text" id="checkBank" name="checkBank"
							value="${parentBean.checkBank}" <c:out value="${allReadOnly}"/> />
					</div>				
				</div>			
				<div class="col-md-2">
					<div class="rowlabel"><label><small>Deposited At</small> </label></div>	
					<div class="rowlabel">ICICI Bank Limited</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel"><label for="checkBranch"><small>Branch</small> </label></div>		
					<div class="rowlabel">
						<input type="text" id="checkBranch" name="checkBranch"
							value="${parentBean.checkBranch}" <c:out value="${allReadOnly}"/> />
					</div>
				</div>			
				<div class="col-md-4">
					<div class="rowlabel"><label for="checkLocation"><small>Location</small> </label></div>		
					<div class="rowlabel">
						<input type="text" id="checkLocation" name="checkLocation"
							value="${parentBean.checkLocation}"
							<c:out value="${allReadOnly}"/> />
					</div>					
				</div>			
			</div>
		</fieldset>
		<fieldset class="CASH_ONLY CHECK_NOT_ONLY RTGS_NOT_ONLY"
			style="display: none">
			<legend>Cash (Delhi/NCR only)</legend>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="checkNo"><small>Address</small> </label>
					</div>
					<div class="rowlabel">
						<textarea name="cashAddress" id="cashAddress"
							<c:out value="${allReadOnly}"/>>${parentBean.cashAddress}</textarea>
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="checkDate"><small>Contact Number</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="cashContactNumber" name="cashContactNumber"
							value="${parentBean.cashContactNumber}"
							<c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="checkDate"><small>Best Time</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" name="cashBestTime" id="cashBestTime"
							value="${parentBean.cashBestTime}"
							<c:out value="${allReadOnly}"/> />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset class="CHECK_NOT_ONLY CASH_NOT_ONLY RTGS_ONLY"
			style="display: none">
			<legend>RTGS Details</legend>
			<div class="row show-grid">
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkNo"><small>Transation/UTR Number</small>
						</label>
					</div>
					<div class="rowlabel">
						<input type="text" id="rtgsTransNumber" name="rtgsTransNumber"
							value="${parentBean.rtgsTransNumber}"
							<c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkNo"><small>Date (dd/mm/yyyy)</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="rtgsDate" name="rtgsDate"
							value="${parentBean.rtgsDateStr}" <c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkDate"><small>Amount</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="rtgsAmount" name="rtgsAmount"
							value="${parentBean.rtgsAmount}" <c:out value="${allReadOnly}"/> />
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<label for="checkDate"><small>Time</small> </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="rtgsTime" name="rtgsTime"
							value="${parentBean.rtgsTime}" <c:out value="${allReadOnly}"/> />
					</div>
				</div>
			</div>
		</fieldset>
		<c:if test="${not empty parentBean}">
			<c:if test="${empty allReadOnly && not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
				<div class="row show-grid">
						<div class="col-md-4 col-md-offset-8">
							<fieldset>
								<legend>Vendor - Payment Verification</legend>
						   		<select name="paymentVerificationStatus">
						   			<option value="">Select Payment Verification</option>
						   			<%for (PaymentVerificationStatus aPaymentStatus : PaymentVerificationStatus.values()) {%>
						   				<%
						   					pageContext.setAttribute("aPaymentStatus",aPaymentStatus);
						   				%>
						   				<option <c:if test="${aPaymentStatus == 'VERIFIED' && not empty parentBean.paymentVerificationStatus && parentBean.paymentVerificationStatus == 'VERIFIED'}">selected</c:if> value="<%=aPaymentStatus.name()%>"><%=aPaymentStatus.name()%></option>
						   			<%} %>
						   		</select>
						   	</fieldset>
					   	</div>
				</div>
			</c:if>
		</c:if>
		<c:if test="${empty allReadOnly}">
			<div class="row show-grid">
				<div class="col-md-4 col-md-offset-8 decimal">
					<a id="hrefLogin" role="button" class="btn btn-default orange">Save</a>
				</div>
			</div>
		</c:if>
	</form>
</div>
<res:client-validation screenConfigurationDocumentName="payment"
	formId="frmPayment" formSubmitButtonId="hrefLogin"></res:client-validation>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	jQuery(document).ready ( function($) {
		$("#paymentType").change( function () {
			d($(this).val());
		});
		<c:choose>
		<c:when test="${empty allReadOnly}">
				 d('<c:out value="${parentBean.paymentType}" />');
			</c:when>
		<c:otherwise>
				if ( $("#paymentType").val().trim() != '') { d($("#paymentType")) }
			</c:otherwise>
	</c:choose>
		
		
		
		function d(v) {
			$("." + v + "_ONLY").show();
			$("." + v + "_NOT_ONLY").hide();
		}
	
	}); 
		
	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />