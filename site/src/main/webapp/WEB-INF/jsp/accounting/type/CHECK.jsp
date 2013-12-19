<%@include file="../../includes/tags.jspf" %>
<c:forEach items="${parentBean.invoicePaymentDetailList}" var="paymentdetail">
						   <c:if test="${uuid == paymentdetail.canonicalUUID}"><c:set value="${paymentdetail}" var="tarPaymentDetail"></c:set></c:if>
						</c:forEach>
<c:set var="allReadOnly" value=""/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<fieldset class="CHECK_ONLY CASH_NOT_ONLY RTGS_NOT_ONLY">
	<legend>Cheque Details</legend>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel">
				<label for="checkNo"><small>Cheque No.</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkNo" name="checkNo" value="${tarPaymentDetail.checkNo}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="checkDate"><small>Dated(dd/mm/yyyy)</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkDate" name="checkDate" value="${tarPaymentDetail.checkDateStr}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span2">
			<div class="rowlabel">
				<label for="checkAmount"><small>For (Amount)</small> </label>
			</div>
			<div class="rowlabel">
				<%-- <input type="text" id="paymentAmount" name="paymentAmount" value="${tarPaymentDetail.paymentAmount}" <c:out value="${allReadOnly}"/> />
				<w4india:inr value="${totalCost}" /> --%>
				<input type="text" id="checkAmount" name="checkAmount" value="${tarPaymentDetail.checkAmount}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel"><label for="checkBank"><small>Drawn On Bank</small> </label></div>				
			<div class="rowlabel">
				<input type="text" id="checkBank" name="checkBank"
					value="${tarPaymentDetail.checkBank}" <c:out value="${allReadOnly}"/> />
			</div>				
		</div>			
		<div class="span2">
			<div class="rowlabel"><label><small>Deposited At</small> </label></div>	
			<div class="rowlabel">ICICI Bank Limited</div>
		</div>
		<div class="span3">
			<div class="rowlabel"><label for="checkBranch"><small>Branch</small> </label></div>		
			<div class="rowlabel">
				<input type="text" id="checkBranch" name="checkBranch"
					value="${tarPaymentDetail.checkBranch}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>			
		<div class="span4">
			<div class="rowlabel"><label for="checkLocation"><small>Location</small> </label></div>		
			<div class="rowlabel">
				<input type="text" id="checkLocation" name="checkLocation"
					value="${tarPaymentDetail.checkLocation}"
					<c:out value="${allReadOnly}"/> />
			</div>					
		</div>			
	</div>
	<c:if test="${empty allReadOnly}">
		<div class="control-group" align="right">
				<div class="controls">
					<button class="btn btn-success" type="submit" id="payment_submit">Pay Now</button>
					<a class="btn btn-default"  href="${scriptName}" id="payment_submit"><strong>Cancel</strong></a>
				</div>
		</div>
	</c:if>
</fieldset>
<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="invoice-payment-check"
	formSubmitButtonId="myModalHrefinvoice" />