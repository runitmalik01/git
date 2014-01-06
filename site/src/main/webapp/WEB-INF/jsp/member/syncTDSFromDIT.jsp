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
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty totalToBeImported && totalToBeImported == 0}">
	<div class="alert alert-info">
		Our records indicates that your income tax has all the latest 26AS information.
	</div>
</c:if>
<c:if test="${pageAction == 'SYNC_TDS_FROM_DIT'}">					
			<h4>26AS Information from Department of Income Tax</h4>
			<c:set var="totalTDS" value="0"/>
			<table class="table table-striped">
				<tr>
					<th>Category</th>
					<th>TAN of Deductor/BSR Code</th>
					<th>Deductor Name/Sr No of Challan</th>
					<th>Date of Deposit</th>	
					<th>Income Chargable on Salary</th>
					<th>Total TDS/TCS</th>					
					<th>Already Imported?</th>
				</tr>
				<c:if test="${not empty  twenty26asResponse.twenty26astdsOnSalaries && fn:length(twenty26asResponse.twenty26astdsOnSalaries) > 0}">
					<c:forEach var="anItem"
						items="${twenty26asResponse.twenty26astdsOnSalaries}">
						<tr>
							<td>Salaries</td>
							<td><c:out value="${anItem.TAN}" /></td>
							<td><c:out value="${anItem.employerOrDeductorOrCollecterName}" /></td>
							<td></td>
							<td align="right"><c:out value="${anItem.incChrgSal}" /></td>
							<td align="right"><c:out value="${anItem.totalTDSSal}" /></td>
							<td>
								<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
									<span class="glyphicon glyphicon-ok"></span>
									<a href="${scriptName}../../formsixteen.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
								</c:if>
							
							</td>
						</tr>
						<c:set var="totalTDS" value="${totalTDS + anItem.totalTDSSal}"/>
					</c:forEach>
				</c:if>
			<%-- TDS Other Than Salaries --%>
			<%--
	String DeductedYr;
	String UniqueTDSCerNo;
	String EmployerOrDeductorOrCollecterName;
	String TotTDSOnAmtPaid;
	String TAN;
	String ClaimOutOfTotTDSOnAmtPaid;
	 --%>
		<c:if test="${not empty  twenty26asResponse.twenty26astdsOtherThanSalaries && fn:length(twenty26asResponse.twenty26astdsOtherThanSalaries) > 0}">
			<c:forEach var="anItem"
				items="${twenty26asResponse.twenty26astdsOtherThanSalaries}">
				<tr>
					<td>Other than Salaries</td>
					<td><c:out value="${anItem.TAN}" /></td>
					<td><c:out value="${anItem.employerOrDeductorOrCollecterName}" /></td>		
					<td></td>
					<td align="right">N/A</td>			
					<%-- 
					<td><c:out value="${anItem.deductedYr}" /></td>
					<td><c:out value="${anItem.uniqueTDSCerNo}" /></td>
					 --%>
					<td align="right"><c:out value="${anItem.totTDSOnAmtPaid}" /></td>
					<%--<td align="right"><c:out value="${anItem.claimOutOfTotTDSOnAmtPaid}" /></td> --%>
					<td><c:if test="${anItem.hasAlreadyBeenImported == 'true'}"><span class="glyphicon glyphicon-ok"></span>
					<a href="${scriptName}../../tdsfromothers.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
					</c:if></td>
				</tr>
				<c:set var="totalTDS" value="${totalTDS + anItem.totTDSOnAmtPaid}"/>
			</c:forEach>
		</c:if>
			<!-- TCS -->
			<%--
	
	String AmtTCSClaimedThisYear;
	String EmployerOrDeductorOrCollecterName;
	String TAN;
	String TotalTCS;
	 --%>
		<c:if test="${not empty  twenty26asResponse.twenty26astcs && fn:length(twenty26asResponse.twenty26astcs) > 0}">
			<c:forEach var="anItem"
				items="${twenty26asResponse.twenty26astcs}">
				<tr>
					<td>TCS</td>
					<td><c:out value="${anItem.TAN}" /></td>
					<td><c:out value="${anItem.employerOrDeductorOrCollecterName}" /></td>
					<td></td>
					<td align="right">N/A</td>
					<td align="right"><c:out value="${anItem.totalTCS}" /></td>
					<%--<td align="right"><c:out value="${anItem.amtTCSClaimedThisYear}" /></td> --%>
					<td><c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
						<span class="glyphicon glyphicon-ok"></span>
						<a href="${scriptName}../../tcs.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
					</c:if></td>
				</tr>
				<c:set var="totalTDS" value="${totalTDS + anItem.totalTCS}"/>
			</c:forEach>
		</c:if>
			<!--  Tax Payments -->
			<%--
		String Amt;
	String SrlNoOfChaln;
	String BSRCode;
	String DateDep;
	 --%>
	 		<%-- Advance Tax --%>
			<c:if test="${not empty  selfAssessmentList && fn:length(selfAssessmentList) > 0}">
				<c:forEach var="anItem"
					items="${selfAssessmentList}">
					<tr>
						<td>Self Assessment Tax</td>
						<td><c:out value="${anItem.BSRCode}" /></td>
						<td><c:out value="${anItem.srlNoOfChaln}" /></td>
						<td><c:out value="${anItem.dateDep}" /></td>
						<td>N/A</td>
						<td align="right"><c:out value="${anItem.amt}" /></td>
						<%--<td align="right">N/A</td> --%>
						<td>
							<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
								<span class="glyphicon glyphicon-ok"></span>
								<a href="${scriptName}../../selfassesmenttax.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
							</c:if>
						</td>
					</tr>
					<c:set var="totalTDS" value="${totalTDS + anItem.amt}"/>
				</c:forEach>
			</c:if>
			<%-- Self Assessment Tax --%>
			<c:if test="${not empty  advTaxList && fn:length(advTaxList) > 0}">
				<c:forEach var="anItem"
					items="${advTaxList}">
					<tr>
						<td>Advance Tax</td>
						<td><c:out value="${anItem.BSRCode}" /></td>
						<td><c:out value="${anItem.srlNoOfChaln}" /></td>
						<td><c:out value="${anItem.dateDep}" /></td>
						<td>N/A</td>
						<td align="right"><c:out value="${anItem.amt}" /></td>
						<%--<td align="right">N/A</td>--%>
						<td>
							<c:if test="${anItem.hasAlreadyBeenImported == 'true'}">
							<span class="glyphicon glyphicon-ok"></span>
							<a href="${scriptName}../../advancetax.html" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</a>
							</c:if>
						</td>
					</tr>
					<c:set var="totalTDS" value="${totalTDS + anItem.amt}"/>
				</c:forEach>
			</c:if>
			<%-- final total --%>
			<c:if test="${totalTDS > 0}">
				<tr>
					<td align="right" colspan="5"><b>Total Tax Deducted</b></td>
					<td align="right"><c:out value="${totalTDS}"/></td>
					<td align="right"></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:if test="${totalToBeImported > 0}">
		<form id="tdsfromdit" action="${actionUrl}" method="post" name="tdsfromdit">
			<div class="row show-grid">
				<div class="col-md-3 col-md-offset-10">
					<a href="${redirectURLToSamePage}" class="btn btn-info">Cancel</a>
					<button type="submit" class="btn btn-primary">Import</button>
					<%--<input type="submit" value="Import" class="button default"> --%>
				</div>
			</div>
		</form>
	</c:if>
</c:if>
<res:client-validation formId="tdsfromdit"
	screenConfigurationDocumentName="syncTDSFromDIT"
	formSubmitButtonId="myModalHreftdsfromdit" />
