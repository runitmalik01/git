<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="balancesheet"></hst:link>
<hippo-gogreen:title title="Schedule-BL" />
<w4india:itrmenu />
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
<w4india:titleandnav title="${screenConfigDocument.screenHeading}" subTitle="${screenConfigDocument.screenSubHeading}"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty invalidSouceAndAppliFind}">
	<div class="alert alert-danger">
		<fmt:message key="${invalidSouceAndAppliFind}" />
	</div>
</c:if>
<form name="schedBalanceSheet" id="schedBalanceSheet"
	action="${actionUrl}" method="post">
	<c:if test="${not empty parentBean}">
		<div class="alert alert-warning">
			<strong>CareFull! Change of selection can lost data until
				you don't click on save button.Click on<a href="${scriptName}"
				class="btn btn-default btn-inverse">Get Saved Data</a>.If lost.
			</strong>
		</div>
	</c:if>
	<div class="row show-grid">
		<div class="col-md-6">
			<div class="rowlabel">
				<label for="regularAccOrNoCase"><small>Do you
						maintain regular books of accounts of Business or Profession?</small></label>
			</div>
		</div>
		<div class="col-md-4">
			<div class="rowlabel">
				<select id="regularAccOrNoCase" name="regularAccOrNoCase">
					<option value="">Select</option>
					<option value="Y"
						<c:if test="${parentBean.regularAccOrNoCase == 'Y'}">selected</c:if>>YES</option>
					<option value="N"
						<c:if test="${parentBean.regularAccOrNoCase == 'N'}">selected</c:if>>NO</option>
				</select>
			</div>
		</div>
	</div>
	<h5 align="center"
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">Sources
		of Funds</h5>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Proprietor's fund</small>
		</legend>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="reavReserve"> <small>Revaluation Reserve</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="reavReserve" name="reavReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.reavReserve }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="capReserve"> <small>Capital Reserve</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="capReserve" name="capReserve" type="text" maxlength="14"
					class="decimal" value="${parentBean.capReserve }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="statReserve"> <small>Statutory Reserve</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="statReserve" name="statReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.statReserve }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="otherReserve"> <small>Any Other Reserve</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="otherReserve" name="otherReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.otherReserve }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="propCapital"> <small>Proprietor's
						capital</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="propCapital" name="propCapital" type="text"
					maxlength="14" class="decimal" value="${parentBean.propCapital }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="grossProprietFund"> <small>Gross
						Proprietor's Fund</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="grossProprietFund" name="grossProprietFund" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.grossProprietFund }" readonly="readonly" />
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Loan funds</small>
		</legend>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="unsecLoanBank"> <small>Unsecured Loan
						from Banks</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="unsecLoanBank" name="unsecLoanBank" type="text"
					maxlength="14" class="decimal" value="${parentBean.unsecLoanBank }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="unsecLoanOther"> <small>Unsecured Loan
						from Other</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="unsecLoanOther" name="unsecLoanOther" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.unsecLoanOther }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="forgnCurrLoan"> <small>Foreign Currency
						Loans</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="forgnCurrLoan" name="forgnCurrLoan" type="text"
					maxlength="14" class="decimal" value="${parentBean.forgnCurrLoan }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rupLoanBank"><small>Rupee Loans from
						Banks</small> </label>
			</div>
			<div class="rowlabel">
				<input id="rupLoanBank" name="rupLoanBank" type="text"
					maxlength="14" class="decimal" value="${parentBean.rupLoanBank }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="rupLoanOther"> <small>Rupee Loan from
						Other</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="rupLoanOther" name="rupLoanOther" type="text"
					maxlength="14" class="decimal" value="${parentBean.rupLoanOther }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="grossLoanFund"> <small>Gross Loan Fund</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="grossLoanFund" name="grossLoanFund" type="text"
					maxlength="14" class="decimal" value="${parentBean.grossLoanFund }"
					readonly="readonly" />
			</div>
		</div>
	</fieldset>
	<div
		class="well regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="defTaxLiability"> <small>Deferred tax
							liability</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="defTaxLiability" name="defTaxLiability" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.defTaxLiability }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="sourcOfFund"> <small>Sources of Funds</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="sourcOfFund" name="sourcOfFund" type="text"
						maxlength="14" class="decimal" value="${parentBean.sourcOfFund }"
						readonly />
				</div>
			</div>
		</div>
	</div>
	<h5 align="center"
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">Application
		of Funds</h5>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Fixed assets</small>
		</legend>
		<div class="row show-grid">
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="grossBlock"> <small>Gross: Block</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossBlock" name="grossBlock" type="text" maxlength="14"
						class="decimal" value="${parentBean.grossBlock }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="depreciation"> <small>Depreciation</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="depreciation" name="depreciation" type="text"
						maxlength="" class="decimal" value="${parentBean.depreciation }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="capWorkProgrss"> <small>Capital
							work-in-progress</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="capWorkProgrss" name="capWorkProgrss" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.capWorkProgrss }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="grossFixedAsset"> <small>Gross Fixed
							Assets</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossFixedAsset" name="grossFixedAsset" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossFixedAsset }" readonly />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Investments</small>
		</legend>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="stInvestEquity"> <small>Short Term
						Investment Equity Shares</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="stInvestEquity" name="stInvestEquity" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.stInvestEquity }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="stInvestPrefShare"> <small>Short Term
						Investment Preference Shares</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="stInvestPrefShare" name="stInvestPrefShare" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.stInvestPrefShare }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="stInvestDebent"> <small>Short Term
						Investment Debenture</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="stInvestDebent" name="stInvestDebent" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.stInvestDebent }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="ltInvestQuot"> <small>Long Term
						Investment Govt and Other -Quoted</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="ltInvestQuot" name="ltInvestQuot" type="text"
					maxlength="14" class="decimal" value="${parentBean.ltInvestQuot }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="ltInvestUnquot"> <small>Long Term
						Investment Govt and Other -Unquoted</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="ltInvestUnquot" name="ltInvestUnquot" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.ltInvestUnquot }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="grossInvest"> <small>Gross Investment</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="grossInvest" name="grossInvest" type="text"
					maxlength="14" class="decimal" value="${parentBean.grossInvest }"
					readonly />
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Current assets</small>
		</legend>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="sundryDebtor"> <small>Sundry Debtors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="sundryDebtor" name="sundryDebtor" type="text"
						maxlength="14" class="decimal" value="${parentBean.sundryDebtor }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="cashInHand"> <small>Cash-in-hand</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="cashInHand" name="cashInHand" type="text" maxlength="14"
						class="decimal" value="${parentBean.cashInHand }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="balanceBank"> <small>Balance with bank</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="balanceBank" name="balanceBank" type="text"
						maxlength="14" class="decimal" value="${parentBean.balanceBank }" />
				</div>
			</div>
		</div>
		<div class="show-grid row">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="storesConsum"> <small>Stores/consumables
							including packing material</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="storesConsum" name="storesConsum" type="text"
						maxlength="14" class="decimal" value="${parentBean.storesConsum }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="rawMaterial"> <small>Raw materials</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="rawMaterial" name="rawMaterial" type="text"
						maxlength="14" class="decimal" value="${parentBean.rawMaterial }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="stockProcess"> <small>Stock-in-process</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="stockProcess" name="stockProcess" type="text"
						maxlength="14" class="decimal" value="${parentBean.stockProcess }" />
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="finishGoods"> <small>Finished
							Goods/Traded Goods</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="finishGoods" name="finishGoods" type="text"
						maxlength="14" class="decimal" value="${parentBean.finishGoods }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="otherCurrAsset"> <small>Other Current
							Assets</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="otherCurrAsset" name="otherCurrAsset" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.otherCurrAsset }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="grossCurrAssets"> <small>Gross Current
							Assets</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossCurrAssets" name="grossCurrAssets" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossCurrAssets }" readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Loans and advances</small>
		</legend>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="advancRecover"> <small>Advances
						recoverable in cash</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="advancRecover" name="advancRecover" type="text"
					maxlength="14" class="decimal" value="${parentBean.advancRecover }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="loanAdvanCorpOthr"> <small>Deposits,loans
						and advances to Corp &amp; others</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="loanAdvanCorpOthr" name="loanAdvanCorpOthr" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.loanAdvanCorpOthr }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="balWthRevenAuth"> <small>Balance with
						Revenue Authorities</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="balWthRevenAuth" name="balWthRevenAuth" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.balWthRevenAuth }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="grossCurrAssLoanAdvan"> <small>Gross
						Current Assets,Loan &amp;Advances</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="grossCurrAssLoanAdvan" name="grossCurrAssLoanAdvan"
					type="text" maxlength="14" class="decimal"
					value="${parentBean.grossCurrAssLoanAdvan }" readonly />
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Current liabilities</small>
		</legend>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="interestAcuurNtLoan"> <small>Interest
							Accrued(Not due on Loan)</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="interestAcuurNtLoan" name="interestAcuurNtLoan"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.interestAcuurNtLoan }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="interestAcuurOnabove"> <small>Interest
							Accrued on above</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="interestAcuurOnabove" name="interestAcuurOnabove"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.interestAcuurOnabove }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="sundryCreditor"> <small>Sundry
							Creditors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="sundryCreditor" name="sundryCreditor" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.sundryCreditor }" />
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="laibLeaseAsset"> <small>Liability for
							Leased Assets</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="laibLeaseAsset" name="laibLeaseAsset" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.laibLeaseAsset }" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="grossCurrLiability"> <small>Gross
							Current Liablity</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossCurrLiability" name="grossCurrLiability"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.grossCurrLiability }" readonly />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset
		class="regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>Provisions</small>
		</legend>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="incometaxProvis"> <small>Provision for
						Income Tax</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="incometaxProvis" name="incometaxProvis" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.incometaxProvis }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="wealthTaxProvis"> <small>Provision for
						Wealth Tax</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="wealthTaxProvis" name="wealthTaxProvis" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.wealthTaxProvis }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="leaveProvis"> <small>Provision for Leave</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="leaveProvis" name="leaveProvis" type="text"
					maxlength="14" class="decimal" value="${parentBean.leaveProvis }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="otherProvis"> <small>Other Provisions</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="otherProvis" name="otherProvis" type="text"
					maxlength="14" class="decimal" value="${parentBean.otherProvis }" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="grossProvision"> <small>Gross Provisions</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="grossProvision" name="grossProvision" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.grossProvision }" readonly />
			</div>
		</div>
	</fieldset>
	<div
		class="well regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="grossCurrLaibilProvison"> <small>Gross
							Current liabilities and provisions</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossCurrLaibilProvison" name="grossCurrLaibilProvison"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.grossCurrLaibilProvison }" readonly />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="netCurrAssets"> <small>Net Current
							Assets</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="netCurrAssets" name="netCurrAssets" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.netCurrAssets }" readonly />
				</div>
			</div>
		</div>
	</div>
	<div
		class="well regularAcc_Y regularAcc_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'N'}">hide</c:when></c:choose>">
		<div class="row show-grid">
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="miscellanExpend"> <small>Miscellaneous
							expenditure</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="miscellanExpend" name="miscellanExpend" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.miscellanExpend }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="deftaxAssets"> <small>Deferred tax
							asset</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="deftaxAssets" name="deftaxAssets" type="text"
						maxlength="14" class="decimal" value="${parentBean.deftaxAssets }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="profLoassAccn"> <small>Profit and loss
							account</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="profLoassAccn" name="profLoassAccn" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossAppliFund }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="grossAppliFund"> <small>Gross
							Application of Funds</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="grossAppliFund" name="grossAppliFund" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.grossAppliFund }" readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<fieldset
		class="noAccount_Y noAccount_N <c:choose><c:when test="${empty parentBean.regularAccOrNoCase || parentBean.regularAccOrNoCase == 'Y'}">hide</c:when></c:choose>">
		<legend class="header-color">
			<small>No Account Case</small>
		</legend>
		<div class="alert alert-info">In a case where regular books of
			account of business or profession are not maintained -furnish the
			following information as on 31st day of March, 2013, in respect of
			business</div>
		<div class="row show-grid">
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="totalSundryDebtor"> <small>Amount of
							total sundry debtors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalSundryDebtor" name="totalSundryDebtor" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.totalSundryDebtor }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="totalSundryCreditor"> <small>Amount of
							total sundry creditors</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalSundryCreditor" name="totalSundryCreditor"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.totalSundryCreditor }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="totalStockTrade"> <small>Amount of
							total stock-in-trade</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalStockTrade" name="totalStockTrade" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.totalStockTrade }" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="rowlabel">
					<label for="cashBalance"> <small>Amount of the cash
							balance</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="cashBalance" name="cashBalance" type="text"
						maxlength="14" class="decimal" value="${parentBean.cashBalance }" />
				</div>
			</div>
		</div>
	</fieldset>
	<div class="row show-grid">
		<div class="col-md-4 col-md-offset-8 decimal">
			<!--<a href="${scriptName}"
				class="btn btn-default btn-danger" style="color: black">Cancel</a>&nbsp;  -->
			<a id="myModalScheduleBalSheet" role="button"
				class="btn btn-default btn-success">Save</a>
		</div>
	</div>
</form>
</div>
</div>

<res:client-validation screenConfigurationDocumentName="balancesheet"
	formId="schedBalanceSheet" formSubmitButtonId="myModalScheduleBalSheet"></res:client-validation>
<res:calc screenCalc="balancesheet" formId="schedBalanceSheet"></res:calc>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
       $(document).ready(function() {
          $('#regularAccOrNoCase').change(function(){
            if($(this).val()== 'Y'){
              $('.noAccount_'+$(this).val()).hide();
              $('.decimal').val('');
              $('.regularAcc_'+$(this).val()).show();
            }else{
              $('.noAccount_'+$(this).val()).show();
              $('.regularAcc_'+$(this).val()).hide();
              $('.decimal').val('');
             }
          });
          <c:if test="${not empty invalidSouceAndAppliFind}">
            $('.regularAcc_Y').show();
            $('.noAccount_Y').hide();
          </c:if>
	<c:if test="${not empty parentBean}">
           /* var selectChoice = '<c:out
			value="${parentBean.regularAccOrNoCase}" />'; 
           $('#regularAccOrNoCase').change(function(){
            if($(this).val() != selectChoice && $(this).val() != ''){
              $()
              $('.decimal').val("");
            }
          });*/
          </c:if> 
	   });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<!-- Display all fields with out any presentation -->
