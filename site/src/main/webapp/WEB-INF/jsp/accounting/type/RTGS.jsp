<fieldset class="CHECK_NOT_ONLY CASH_NOT_ONLY RTGS_ONLY"
	style="display: none">
	<legend>RTGS Details</legend>
	<div class="row-fluid show-grid">
		<div class="span3">
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
		<div class="span3">
			<div class="rowlabel">
				<label for="checkNo"><small>Date (dd/mm/yyyy)</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsDate" name="rtgsDate"
					value="${parentBean.rtgsDateStr}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="checkDate"><small>Amount</small> </label>
			</div>
			<div class="rowlabel">
				<input type="text" id="rtgsAmount" name="rtgsAmount"
					value="${parentBean.rtgsAmount}" <c:out value="${allReadOnly}"/> />
			</div>
		</div>
		<div class="span3">
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