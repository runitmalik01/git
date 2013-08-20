<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf" %>

<h3>Please review the data and click on Import if you want this data to be imported in your tax return</h3>
<c:if test="${not empty twenty26asResponse}">
	<h4>TDS Salaries</h4>
	<table>
		<tr>
			<th>employerOrDeductorOrCollecterName</th>
			<th>TAN</th>
			<th>incChrgSal</th>
			<th>totalTDSSal</th>
		</tr>
		<c:choose>		
			<c:when test="${not empty  twenty26asResponse.twenty26astdsOnSalaries && fn:length(twenty26asResponse.twenty26astdsOnSalaries) > 0}">
				<c:forEach var="anItem" items="${twenty26asResponse.twenty26astdsOnSalaries}">
					<tr>
						<td><c:out value="${anItem.employerOrDeductorOrCollecterName}"/></td>
						<td><c:out value="${anItem.TAN}"/></td>
						<td><c:out value="${anItem.incChrgSal}"/></td>
						<td><c:out value="${anItem.totalTDSSal}"/></td>		
					</tr>	
				</c:forEach>		
			</c:when>
			<c:otherwise>
				<h5>No data for TDS Salaries</h5>
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
	<table  class="table table-striped">
		<thead>
		<tr>
			<th>EmployerOrDeductorOrCollecterName</th>
			<th>TAN</th>
			<th>DeductedYr</th>
			<th>UniqueTDSCerNo</th>
			<th>TotTDSOnAmtPaid</th>
			<th>ClaimOutOfTotTDSOnAmtPaid</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>				
				<c:when test="${not empty  twenty26asResponse.twenty26astdsOtherThanSalaries && fn:length(twenty26asResponse.twenty26astdsOtherThanSalaries) > 0}">
					<c:forEach var="anItem" items="${twenty26asResponse.twenty26astdsOtherThanSalaries}">
						<tr>
							<td><c:out value="${anItem.employerOrDeductorOrCollecterName}"/></td>
							<td><c:out value="${anItem.TAN}"/></td>
							<td><c:out value="${anItem.deductedYr}"/></td>
							<td><c:out value="${anItem.uniqueTDSCerNo}"/></td>		
							<td><c:out value="${anItem.totTDSOnAmtPaid}"/></td>
							<td><c:out value="${anItem.claimOutOfTotTDSOnAmtPaid}"/></td>		
						</tr>	
					</c:forEach>		
				</c:when>
				<c:otherwise>
					<h5>No data for TDS Other Than Salaries</h5>
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
	<h4>TCS</h4>
	<table  class="table table-striped">
		<thead>
		<tr>
			<th>EmployerOrDeductorOrCollecterName</th>
			<th>TAN</th>
			<th>TotalTCS</th>
			<th>AmtTCSClaimedThisYear</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>				
				<c:when test="${not empty  twenty26asResponse.twenty26astcs && fn:length(twenty26asResponse.twenty26astcs) > 0}">
					<c:forEach var="anItem" items="${twenty26asResponse.twenty26astcs}">
						<tr>
							<td><c:out value="${anItem.employerOrDeductorOrCollecterName}"/></td>
							<td><c:out value="${anItem.TAN}"/></td>
							<td><c:out value="${anItem.totalTCS}"/></td>
							<td><c:out value="${anItem.amtTCSClaimedThisYear}"/></td>		
						</tr>	
					</c:forEach>		
				</c:when>
				<c:otherwise>
					<h5>No data for TCS</h5>
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
	<table  class="table table-striped">
		<thead>
		<tr>
			<th>BSRCode</th>
			<th>SrlNoOfChaln</th>
			<th>DateDep</th>
			<th>Amt</th>
		</tr>
		</thead>
		<tbody>
			<c:choose>				
				<c:when test="${not empty  twenty26asResponse.twenty26asTaxPayments && fn:length(twenty26asResponse.twenty26asTaxPayments) > 0}">
					<c:forEach var="anItem" items="${twenty26asResponse.twenty26asTaxPayments}">
						<tr>
							<td><c:out value="${anItem.BSRCode}"/></td>
							<td><c:out value="${anItem.srlNoOfChaln}"/></td>
							<td><c:out value="${anItem.dateDep}"/></td>
							<td><c:out value="${anItem.amt}"/></td>		
						</tr>	
					</c:forEach>		
				</c:when>
				<c:otherwise>
					<h5>No data for Tax Payments</h5>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</c:if>

<input type="submit" class="button" value="Import">