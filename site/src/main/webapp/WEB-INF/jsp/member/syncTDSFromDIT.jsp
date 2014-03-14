<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${ditsynctitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
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
    <div class="alert alert-success">
		<c:out value="Your details has been successfully imported into your return"></c:out>
	</div>
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
		    <c:choose>
			  <c:when test="${not empty isInfoAvail && isInfoAvail == true}">
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
		<form id="tdsfromdit" action="${actionUrl}" method="post" name="tdsfromdit">
		<c:if test="${totalToBeImported > 0}">
			<div class="row show-grid">
				<div class="col-md-3 col-md-offset-10">
					<a href="${redirectURLToSamePage}" class="btn btn-info">Cancel</a>
					<button type="submit" class="btn btn-primary">Import</button>
					<%--<input type="submit" value="Import" class="button default"> --%>
				</div>
			</div>
			</c:if>
			<c:if test="${not empty totalToBeImported && totalToBeImported == 0}">
			<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<a href="servicerequest-itr-summary.html" class="btn btn-default btn-success">Proceed</a>
			</div>
			</div>
			</c:if>
		</form>
  </c:when>
  <c:otherwise>
  <div class="alert alert-info">
  <span style="color:#AC1700;">We are unable to find any information related to your 26AS from the Department of Income Tax.
    You can always update your Tax Deduction information using one of the following</span><br><br>
     <a href="formsixteen.html"><button type="button" class="btn btn-primary"> Form 16 (Salaried)</button></a>
      <a href="salaryincome.html"><button type="button" class="btn btn-primary"> Pension</button></a>
       <a href="advancetax.html"> <button type="button" class="btn btn-primary"> Advanced Tax</button></a>
        <a href="selfassesmenttax.html"> <button type="button" class="btn btn-primary"> Self Assessment</button></a>
        <a href="tdsfromothers.html"> <button type="button" class="btn btn-primary"> TDS Others</button></a>
        <c:if test="${not empty itrSelection && (itrSelection == 'ITR4' || itrSelection == 'ITR4S')}">
        <a href="tcsdetail.html"> <button type="button" class="btn btn-primary"> Tax Collected at Source</button></a>
        </c:if>
        <br><br>
       <span style="color:#AC1700;"> If you have questions feel free to contact us <strong><a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.
       </strong></span>	
  </div>	
  </c:otherwise>
</c:choose>		
</c:if>
</div>
</div>
<res:client-validation formId="tdsfromdit"
	screenConfigurationDocumentName="syncTDSFromDIT"
	formSubmitButtonId="myModalHreftdsfromdit" />
