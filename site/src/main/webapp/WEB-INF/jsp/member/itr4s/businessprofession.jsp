<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="balancesheet"></hst:link>
<hippo-gogreen:title title="Schedule-BP" />
<w4india:itrmenu />
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<h4>
	<b>ITR- Schedule Business Profession</b>
</h4>
<c:if test="${not empty exceedErrorGrossTurnOver}">
	<div class="alert alert-error">
		<strong><fmt:message key="busi.prof.exceed.grosturnover.itr4" /></strong><a
			href="./servicerequest-itr.html" class="btn btn-warning">Change Package</a>
	</div>
</c:if>
<c:if test="${not empty exceedErrorGrossPremptInc}">
	<div class="alert alert-error">
		<strong><fmt:message key="busi.prof.exceed.grossPresumptIncome.itr4" /></strong>
	</div>
</c:if>
<form name="schedBusinessProfess" id="schedBusinessProfess" action="${actionUrl}" method="post">
	<h5 align="center">Presumptive Income</h5>
	<fieldset>
		<legend style="color: green; font-weight: bold;">Presumptive Income under 44AD</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="grossTurnOver"> <small>GrossIncome or GrossTurnOver Receipts</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossTurnOver" name="grossTurnOver" type="text"
						maxlength="14" class="decimal" value="${parentBean.grossTurnOver }" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="grossPresumptIncome"> <small>Total Presumptive Income u|s 44AD</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossPresumptIncome" name="grossPresumptIncome"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.grossPresumptIncome}" />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend style="color: green; font-weight: bold;">Presumptive Income under 44AE</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="presumHeavyVehi"> <small>Presumptive Income from Heavy Vehicles</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="presumHeavyVehi" name="presumHeavyVehi" type="text"
						maxlength="14" class="decimal"
						value="${schFourtyFourAEDocument.total_deemedIncome_Heavy}" readonly="readonly" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="presumOtherVehi"> <small>Presumptive Income from Other Vehicles</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="presumOtherVehi" name="presumOtherVehi" type="text"
						maxlength="14" class="decimal"
						value="${schFourtyFourAEDocument.total_deemedIncome_Light}" readonly="readonly" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="grossPresumInc44AE"> <small>Gross Presumptive Income u|s 44AE</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossPresumInc44AE" name="grossPresumInc44AE"
						type="text" maxlength="14" class="decimal"
						value="${schFourtyFourAEDocument.total_deemedIncome_Light + schFourtyFourAEDocument.total_deemedIncome_Heavy}"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<div class="well">
		<div class="row -fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="statReserve"><small>Gross Business or Profession Income</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="incChargBusiness" name="incChargBusiness" type="text"
						maxlength="14" class="decimal" value="${schFourtyFourAEDocument.total_deemedIncome_Light + schFourtyFourAEDocument.total_deemedIncome_Heavy + parentBean.grossPresumptIncome}"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<fieldset>
		<legend style="color: green; font-weight: bold;">Financial Particulars of Business</legend>
		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="grossSundryDebt"> <small>Total Sundry Debtors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossSundryDebt" name="grossSundryDebt" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossSundryDebt}"/>
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="grossSundryCredit"> <small>Total Sundry Creditors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossSundryCredit" name="grossSundryCredit" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossSundryCredit}"/>
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="grossStockTrade"> <small>Total Stock In Trade</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossStockTrade" name="grossStockTrade" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossStockTrade}"/>
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="grossCashBalance"> <small>Total cash in Balance</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossCashBalance" name="grossCashBalance" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossCashBalance}"/>
				</div>
			</div>
		</div>
	</fieldset>
	<div class="row-fluid show-grid">
		<div class="span4 offset8 decimal">
			<!--<a href="${scriptName}"
				class="btn btn-danger" style="color: black">Cancel</a>&nbsp;  --> <a
				id="myModalScheduleBusiProf" role="button" class="btn btn-success"
				style="color: black">Save</a>
		</div>
	</div>
</form>


<res:client-validation screenConfigurationDocumentName="businessprofession" formId="schedBusinessProfess" formSubmitButtonId="myModalScheduleBusiProf"></res:client-validation>

<res:calc screenCalc="businessprofession" formId="schedBusinessProfess"></res:calc>
