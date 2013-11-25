<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${ditsynctitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<h3 id="respond1">
	<c:choose>
		<c:when
			test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
			<c:out value="${screenConfigDocument.screenHeading}" />
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</h3>
<c:if test="${not empty message}">
	<h4 style="font-style: italic; color: maroon;">
		<c:out
			value="Your details has been successfully imported into your return"></c:out>
	</h4>
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<h3>Please review the data
	and click on Import if you want this data to be imported in your tax
	return</h3>
<c:if test="${not empty totalGetTDSDetail && totalGetTDSDetail > 0}">
	<div>
		<span class="label label-warning">Our record indicates that you have already imported your 26AS information.Re-importing the information may result in duplicates</span>
	</div>
</c:if>
<c:choose>
	<c:when test="${pageAction == 'SYNC_TDS_FROM_DIT'}">
		<form id="tdsfromdit" action="${actionUrl}" method="post"
			name="tdsfromdit">
			<h4>TDS Salaries</h4>
			<table class="table table-striped">
				<tr>
					<th>Deductor Name</th>
					<th>TAN of Deductor</th>
					<th>Income Chargable on Salary</th>
					<th>Total TDS on Salary</th>
				</tr>
				<c:choose>
					<c:when
						test="${not empty  twenty26asResponse.twenty26astdsOnSalaries && fn:length(twenty26asResponse.twenty26astdsOnSalaries) > 0}">
						<c:forEach var="anItem"
							items="${twenty26asResponse.twenty26astdsOnSalaries}">
							<tr>
								<td><c:out
										value="${anItem.employerOrDeductorOrCollecterName}" /></td>
								<td><c:out value="${anItem.TAN}" /></td>
								<td align="right"><c:out value="${anItem.incChrgSal}" /></td>
								<td align="right"><c:out value="${anItem.totalTDSSal}" />
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h5 style="font-style: italic; color: blue;">No data for TDS
							Salaries</h5>
					</c:otherwise>
				</c:choose>
			</table>
			<%-- TDS Other Than Salaries --%>
			<%--
	String DeductedYr;
	String UniqueTDSCerNo;
	String EmployerOrDeductorOrCollecterName;
	String TotTDSOnAmtPaid;
	String TAN;
	String ClaimOutOfTotTDSOnAmtPaid;
	 --%>
			<h4>TDS Other than Salaries</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Deductor Name</th>
						<th>TAN of Deductor</th>
						<th>Deducted Year</th>
						<th>TDS Certificate No.</th>
						<th>Total TDS On Amount Paid</th>
						<th>Claim Out Of Total TDS On Amount Paid</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when
							test="${not empty  twenty26asResponse.twenty26astdsOtherThanSalaries && fn:length(twenty26asResponse.twenty26astdsOtherThanSalaries) > 0}">
							<c:forEach var="anItem"
								items="${twenty26asResponse.twenty26astdsOtherThanSalaries}">
								<tr>
									<td><c:out
											value="${anItem.employerOrDeductorOrCollecterName}" /></td>
									<td><c:out value="${anItem.TAN}" /></td>
									<td><c:out value="${anItem.deductedYr}" /></td>
									<td><c:out value="${anItem.uniqueTDSCerNo}" /></td>
									<td align="right"><c:out value="${anItem.totTDSOnAmtPaid}" />
									</td>
									<td align="right"><c:out
											value="${anItem.claimOutOfTotTDSOnAmtPaid}" />
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h5 style="font-style: italic; color: blue;">No data for TDS
								Other Than Salaries</h5>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<!-- TCS -->
			<%--
	
	String AmtTCSClaimedThisYear;
	String EmployerOrDeductorOrCollecterName;
	String TAN;
	String TotalTCS;
	 --%>
			<h4>Tax Collected from Source</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Collector Name</th>
						<th>TAN of Collector</th>
						<th>Total TCS</th>
						<th>Amount TCS Claimed This Year</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when
							test="${not empty  twenty26asResponse.twenty26astcs && fn:length(twenty26asResponse.twenty26astcs) > 0}">
							<c:forEach var="anItem"
								items="${twenty26asResponse.twenty26astcs}">
								<tr>
									<td><c:out
											value="${anItem.employerOrDeductorOrCollecterName}" /></td>
									<td><c:out value="${anItem.TAN}" /></td>
									<td align="right"><c:out value="${anItem.totalTCS}" /></td>
									<td align="right"><c:out
											value="${anItem.amtTCSClaimedThisYear}" /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h5 style="font-style: italic; color: blue;">No data for TCS</h5>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>

			<!--  Tax Payments -->
			<%--
		String Amt;
	String SrlNoOfChaln;
	String BSRCode;
	String DateDep;
	 --%>
			<h4>Tax Payments</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>BSR Code</th>
						<th>Sr No Of Challan</th>
						<th>Date Deposit</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when
							test="${not empty  twenty26asResponse.twenty26asTaxPayments && fn:length(twenty26asResponse.twenty26asTaxPayments) > 0}">
							<c:forEach var="anItem"
								items="${twenty26asResponse.twenty26asTaxPayments}">
								<tr>
									<td><c:out value="${anItem.BSRCode}" /></td>
									<td><c:out value="${anItem.srlNoOfChaln}" /></td>
									<td><c:out value="${anItem.dateDep}" /></td>
									<td align="right"><c:out value="${anItem.amt}" /></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h5 style="font-style: italic; color: blue;">No data for Tax
								Payments</h5>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>

			<div class="row-fluid show-grid">
				<div class="span3 offset10">
					<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
					<input type="submit" value="Import" class="button default">
				</div>
			</div>
		</form>
	</c:when>
</c:choose>
<res:client-validation formId="tdsfromdit"
	screenConfigurationDocumentName="syncTDSFromDIT"
	formSubmitButtonId="myModalHreftdsfromdit" />
