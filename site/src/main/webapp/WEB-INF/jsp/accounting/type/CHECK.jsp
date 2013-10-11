<%@include file="../../includes/tags.jspf"%>
<c:set var="allReadOnly" value=""/>
<fieldset class="CHECK_ONLY CASH_NOT_ONLY RTGS_NOT_ONLY">
	<legend>Cheque Details</legend>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel">
				<label for="checkNo"><small>Cheque No.</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkNo" name="checkNo" value="${childBean.checkNo}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="checkDate"><small>Dated</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="checkDate" name="checkDate" value="${childBean.checkDateStr}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span2">
			<div class="rowlabel">
				<label for="paymentAmount"><small>For (Amount)</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="paymentAmount" name="paymentAmount" value="${childBean.paymentAmount}" <c:out value="${allReadOnly}"/> />
				<w4india:inr value="${totalCost}" />
			</div>
		</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel"><label for="checkBank"><small>Drawn On Bank</small> </label></div>				
			<div class="rowlabel">
				<input type="text" id="checkBank" name="checkBank"
					value="${childBean.checkBank}" <c:out value="${allReadOnly}"/> />
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
					value="${childBean.checkBranch}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>			
		<div class="span4">
			<div class="rowlabel"><label for="checkLocation"><small>Location</small> </label></div>		
			<div class="rowlabel">
				<input type="text" id="checkLocation" name="checkLocation"
					value="${childBean.checkLocation}"
					<c:out value="${allReadOnly}"/> />
			</div>					
		</div>			
	</div>
	<c:if test="${empty allReadOnly}">
		<div class="row-fluid show-grid">
			<div class="span4 offset8 decimal">
				<a id="myModalHrefinvoice" role="button" class="btn orange">Save</a>
			</div>
		</div>
	</c:if>
</fieldset>
<res:client-validation formId="frmdataInvoice"
	screenConfigurationDocumentName="invoice-payment-check"
	formSubmitButtonId="myModalHrefinvoice" />