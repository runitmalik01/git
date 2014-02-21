<%@include file="../../includes/tags.jspf" %>
<c:forEach items="${parentBean.invoicePaymentDetailList}" var="paymentdetail">
						   <c:if test="${uuid == paymentdetail.canonicalUUID}"><c:set value="${paymentdetail}" var="tarPaymentDetail"></c:set></c:if>
						</c:forEach>
<fieldset class="CHECK_NOT_ONLY CASH_NOT_ONLY RTGS_ONLY">
	<legend>RTGS Details</legend>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rtgsTranNo"><small>Transaction/UTR Number</small>
				</label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsTransNumber" name="rtgsTransNumber"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.rtgsTransNumber}</c:if>"
					<c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rtgsDate"><small>Date (dd/mm/yyyy)</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsDate" name="rtgsDate"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.rtgsDate}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rtgsAmount"><small>Amount</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsAmount" name="rtgsAmount"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.rtgsAmount}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rtgsTime"><small>Time</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsTime" name="rtgsTime"
					value="<c:if test="${pageAction=='EDIT_CHILD'}">${tarPaymentDetail.rtgsTime}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
	</div>
	<c:if test="${empty allReadOnly && not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
		<jsp:include page="vendor_verification.jsp"/>
	</c:if>
	<div class="control-group" align="right">
				<div class="controls">
					<button class="btn btn-default btn-success" type="submit" id="payment_submit">Pay Now</button>
					<a class="btn btn-default btn-default"  href="${scriptName}" id="payment_submit"><strong>Cancel</strong></a>
				</div>
			</div>
</fieldset>