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
	MemberPersonalInformation  memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
	if (memberPersonalInformation != null) {
		itrForm = memberPersonalInformation.getSelectedITRForm();
		itrServiceDelivery = memberPersonalInformation.getSelectedServiceDeliveryOption();
		pageContext.setAttribute("itrServiceDelivery", itrServiceDelivery);
	}
 %>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${itrForm}" />
		</div>
	</c:forEach>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<w4india:itrmenu />
	<h4>Payment for Package <fmt:message key="${itrForm}.packageName.${itrServiceDelivery}.cost" var="totalCost"/> <w4india:inr value="${totalCost}"></w4india:inr> </h4>
	<h5>Your Income Tax return will be available for email/download, once Wealth4India receives and successfully verifies your payment.</h5>	
	<c:if test="${not empty parentBean}">
		<c:choose>
			<c:when test="${not empty parentBean.paymentVerificationStatus && parentBean.paymentVerificationStatus == 'VERIFIED'}">
				<span class="label label-success">Your payment has been verified by Wealth4India. You can continue to download XML.</span>
				<c:set var="allReadOnly" value="readonly"/>
			</c:when>
			<c:otherwise>
				<span class="label label-important">Your payment information is still being reviewed.</span>
			</c:otherwise>
		</c:choose>
	</c:if>
	<form id="frmPayment" action="${actionUrl}" method="post" name="frmPayment">
		<fieldset>
			<legend>Payment Options. You can choose one of the following methods of payment</legend>
			<div class="row-fluid show-grid">
				<div class="span12 info"><b>Please mention the PAN Number in the Memo Section of the payment</b></div>
			</div>			
			<div class="row-fluid show-grid">
				<div class="span6">
					<div class="rowlabel">
						<label for="ack_no"><small>By Cheque</small> </label>
					</div>
					<div class="rowlabel">
						 Bank Name: <br/>
						 Payee Name: <br/>
						 Account Number: <br/>
						 Branch: <br/>
						 RTGS/NEFT/IFSC CODE: 
				 	</div>
				 </div>
				 <div class="span6">
					<div class="rowlabel">
						<label for="ack_no"><small>NEFT/RTGS</small> </label>
					</div>
					<div class="rowlabel">						
						 RTGS/NEFT/IFSC CODE: 
				 	</div>
				 </div>
			</div>			
		</fieldset>	
		<fieldset>
			<legend>Please enter your payment details</legend>
			<div class="row-fluid show-grid">
				<div class="span3">
					<div class="rowlabel">
						<label for="ack_no"><small>Payment Type</small> </label>
					</div>
					<div class="rowlabel">
						<c:choose>
							<c:when test="${empty allReadOnly}">
								<select name="paymentType" id="paymentType">
									<option value="">Select</option>
									<%
										for (PaymentType paymentType: PaymentType.values() ) {
											pageContext.setAttribute("paymentType", paymentType);
											
									%>
										<option value="<%=paymentType%>" <c:if test="${paymentType == parentBean.paymentType}">selected</c:if>><fmt:message key="paymentType.${paymentType}.label"/></option>
									<%  
										}
									%>
								</select>							
							</c:when>
							<c:otherwise>
								<c:out value="${parentBean.paymentType}"/>
							</c:otherwise>
						</c:choose>
	
					</div>
				</div>
			</div>
		</fieldset>	
		<fieldset class="CHECK_ONLY CASH_NOT_ONLY RTGS_NOT_ONLY" style="display:none">
			<legend>Check Details</legend>
			<div class="row-fluid show-grid">
				<div class="span3">
						<div class="rowlabel">
							<label for="checkNo"><small>Check No.</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="checkNo" name="checkNo" value="${parentBean.checkNo}" <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
				<div class="span3">
						<div class="rowlabel">
							<label for="checkDate"><small>Dated</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="checkDate" name="checkDate" value="${parentBean.checkDateStr}" <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
				<div class="span2">
						<div class="rowlabel">
							<label for="checkDate"><small>For (Amount)</small> </label>
						</div>
						<div class="rowlabel">
							 <w4india:inr value="${totalCost}"/>
					 	</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span6">
						<div class="rowlabel">
							<label for="checkNo"><small>Drawn on Bank Name</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="checkBank" name="checkBank" value="${parentBean.checkBank}" <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
				<div class="span6">
						<div class="rowlabel">
							<label for="checkDate"><small>Drawn on Branch</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="checkBranch" name="checkBranch" value="${parentBean.checkBranch}" <c:out value="${allReadOnly}"/> />
					 	</div>
				</div>				
			</div>			
		</fieldset>		
		<fieldset class="CASH_ONLY CHECK_NOT_ONLY RTGS_NOT_ONLY"  style="display:none">
			<legend>Cash (Delhi/NCR only)</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
						<div class="rowlabel">
							<label for="checkNo"><small>Address</small> </label>
						</div>
						<div class="rowlabel">
							<textarea name="cashAddress" id="cashAddress" <c:out value="${allReadOnly}"/>>${parentBean.cashAddress}</textarea>
					 	</div>
				</div>
				<div class="span4">
						<div class="rowlabel">
							<label for="checkDate"><small>Contact Number</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="cashContactNumber" name="cashContactNumber" value="${parentBean.cashContactNumber}"  <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>		
				<div class="span4">
						<div class="rowlabel">
							<label for="checkDate"><small>Best Time</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" name="cashBestTime" id="cashBestTime"  value="${parentBean.cashBestTime}"  <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>							
			</div>
		</fieldset>		
		<fieldset class="CHECK_NOT_ONLY CASH_NOT_ONLY RTGS_ONLY" style="display:none">
			<legend>RTGS Details</legend>
			<div class="row-fluid show-grid">
			  <div class="span3">
						<div class="rowlabel">
							<label for="checkNo"><small>Transation/UTR Number</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="rtgsTransNumber" name="rtgsTransNumber" value="${parentBean.rtgsTransNumber}"  <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
				<div class="span3">
						<div class="rowlabel">
							<label for="checkNo"><small>Date</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="rtgsDate" name="rtgsDate" value="${parentBean.rtgsDateStr}"  <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
				<div class="span3">
						<div class="rowlabel">
							<label for="checkDate"><small>Amount</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="rtgsAmount" name="rtgsAmount" value="${parentBean.rtgsAmount}"  <c:out value="${allReadOnly}"/>/>							
					 	</div>
				</div>
				<div class="span3">
						<div class="rowlabel">
							<label for="checkDate"><small>Time</small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="rtgsTime" name="rtgsTime" value="${parentBean.rtgsTime}" <c:out value="${allReadOnly}"/>/>
					 	</div>
				</div>
			</div>
		</fieldset>	
		<div class="row-fluid show-grid">
			<div class="span4 offset8 decimal">
				<a id="hrefLogin" role="button" class="btn orange">Save</a>
			</div>
		</div>
	</form>
</div>
<res:client-validation screenConfigurationDocumentName="payment" formId="frmPayment" formSubmitButtonId="hrefLogin"></res:client-validation>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	jQuery(document).ready ( function($) {
		$("#paymentType").change( function () {
			d($(this).val());
		});
		<c:choose>
			<c:when test="${empty allReadOnly}">
				if ( $("#paymentType").val().trim() != '') { d($("#paymentType")) }
			</c:when>
			<c:otherwise>
				 d('<c:out value="${parentBean.paymentType}"/>');
			</c:otherwise>		
		</c:choose>
		
		
		
		function d(v) {
			$("." + v + "_ONLY").show();
			$("." + v + "_NOT_ONLY").hide();
		}
	
	}); 
		
	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />