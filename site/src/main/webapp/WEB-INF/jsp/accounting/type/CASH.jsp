<fieldset class="CASH_ONLY CHECK_NOT_ONLY RTGS_NOT_ONLY">
	<legend>Cash (Delhi/NCR only)</legend>
	<div class="row-fluid show-grid">
		<div class="span4">
			<div class="rowlabel">
				<label for="checkNo"><small>Address</small> </label>
			</div>
			<div class="rowlabel">
				<textarea name="cashAddress" id="cashAddress"
					<c:out value="${allReadOnly}"/>>${parentBean.cashAddress}</textarea>
			</div>
		</div>
		<div class="span4">
			<div class="rowlabel">
				<label for="checkDate"><small>Contact Number</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="cashContactNumber" name="cashContactNumber"
					value="${parentBean.cashContactNumber}"
					<c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span4">
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