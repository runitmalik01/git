<%@include file="../../includes/tags.jspf" %>

<c:set var="allReadOnly" value=""/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<fieldset class="CHECK_ONLY CASH_NOT_ONLY RTGS_NOT_ONLY">
	<legend>Cheque Details</legend>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkNo"><small>Cheque No.</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkNo" name="checkNo" value="<c:if test="${not empty childBean}">${childBean.checkNo}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="checkDate"><small>Dated(dd/mm/yyyy)</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkDate" name="checkDate" value="<c:if test="${not empty childBean && not empty childBean.checkDate}">${childBean.checkDate}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="col-md-2">
			<div class="rowlabel">
				<label for="checkAmount"><small>For (Amount)</small> </label>
			</div>
			<div class="rowlabel">
				<%-- <input type="text" id="paymentAmount" name="paymentAmount" value="${tarPaymentDetail.paymentAmount}" <c:out value="${allReadOnly}"/> />
				<w4india:inr value="${totalCost}" /> --%>
				<input type="text" id="checkAmount" name="checkAmount" value="<c:if test="${not empty childBean}">${childBean.checkAmount}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
	</div>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel"><label for="checkBank"><small>Drawn On Bank</small> </label></div>				
			<div class="rowlabel">
				<input type="text" id="checkBank" name="checkBank"
					value="<c:if test="${not empty childBean}">${childBean.checkBank}</c:if>" <c:out value="${allReadOnly}"/> />
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
					value="<c:if test="${not empty childBean}">${childBean.checkBranch}</c:if>" <c:out value="${allReadOnly}"/> />
			</div>
		</div>			
		<div class="col-md-4">
			<div class="rowlabel"><label for="checkLocation"><small>Location</small> </label></div>		
			<div class="rowlabel">
				<input type="text" id="checkLocation" name="checkLocation"
					value="<c:if test="${not empty childBean}">${childBean.checkLocation}</c:if>"
					<c:out value="${allReadOnly}"/> />
			</div>					
		</div>			
	</div>
	<c:if test="${empty allReadOnly && not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
		<jsp:include page="vendor_verification.jsp"/>
	</c:if>
	<c:if test="${empty allReadOnly}">
		<div class="control-group" align="right">
				<div class="controls">
					<button class="btn btn-default btn-success" type="submit" id="payment_submit">Pay Now</button>
					<a class="btn btn-default btn-default"  href="${scriptName}" id="payment_submit"><strong>Cancel</strong></a>
				</div>
		</div>
	</c:if>
</fieldset>
<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="invoice-payment-check"
	formSubmitButtonId="myModalHrefinvoice" />