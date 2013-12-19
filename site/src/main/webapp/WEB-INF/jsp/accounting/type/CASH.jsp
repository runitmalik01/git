<%@include file="../../includes/tags.jspf" %>
<c:forEach items="${parentBean.invoicePaymentDetailList}" var="paymentdetail">
						   <c:if test="${uuid == paymentdetail.canonicalUUID}"><c:set value="${paymentdetail}" var="tarPaymentDetail"></c:set></c:if>
						</c:forEach>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>						
<fieldset class="CASH_ONLY CHECK_NOT_ONLY RTGS_NOT_ONLY">
	<legend>Cash (Delhi/NCR only)</legend>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkNo"><small>Address</small> </label>
			</div>
			<div class="rowlabel">
				<textarea name="cashAddress" id="cashAddress"
					<c:out value="${allReadOnly}"/> > <c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.cashAddress}</c:if></textarea>
			</div>
		</div>
		
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkDate"><small>Contact Number</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="cashContactNumber" name="cashContactNumber"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.cashContactNumber}</c:if>"
					<c:out value="${allReadOnly}"/> />
			</div>
		</div>
		
		
		
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkAmount"><small>Amount</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="cashAmount" name="cashAmount"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.cashAmount}</c:if>"
					<c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkDate"><small>Best Time</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" name="cashBestTime" id="cashBestTime"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.cashBestTime}</c:if>"
					<c:out value="${allReadOnly}"/> />
			</div>
		</div>
	</div>
	<div class="control-group" align="right">
				<div class="controls">
					<button class="btn btn-default btn-success" type="submit" id="payment_submit">Pay Now</button>
					<a class="btn btn-default btn-default"  href="${scriptName}" id="payment_submit"><strong>Cancel</strong></a>
				</div>
			</div>
</fieldset>