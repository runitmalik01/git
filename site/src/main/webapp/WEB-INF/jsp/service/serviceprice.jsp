<%--
For Mootly ITR Pricing Plans
--%>

<%@include file="../includes/tags.jspf"%>

<c:set var="servicepricetitle">
	<fmt:message key="service.price.title" />
</c:set>
<hippo-gogreen:title title="${servicepricetitle}" />


<h3 class="title">
	<fmt:message key="service.price.title" />
</h3>
<table>
	<tr>
		<th>Mootly Compare Plans</th>
		<c:forEach items="${documents}" var="document">
			<th><c:out value="${document.title}" />
			</th>
		</c:forEach>
	</tr>

	<tr>
		<th>Compare Plans</th>
		<c:forEach items="${documents}" var="document">
			<th><c:out value="${document.subTitle}" />
			</th>
		</c:forEach>
	</tr>
	<tr>

		<th>Pricing</th>
		<c:forEach items="${documents}" var="document">
			<th><c:if test="${!fn:contains(document.pricing,'FREE') }">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/rupeeGreen.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/rupeeBlue.gif"/>
						</c:otherwise>
					</c:choose>
				</c:if> <c:out value="${document.pricing}" />
			</th>
		</c:forEach>
	</tr>


	<tr>
		<th>Description</th>
		<c:forEach items="${documents}" var="document">
			<th><c:out value="${document.description}" />
			</th>
		</c:forEach>
	</tr>

	<tr>
		<th>Features</th>
		<c:forEach items="${documents}" var="document">
			<th>
				<h5>
					<small> Recommended if you:</small>
				</h5> <c:forEach items="${document.features}" var="features">
					<c:out value="${features}" />
					<br>
				</c:forEach>
			</th>
		</c:forEach>
	</tr>
</table>


<div id="income" align="center">
	<h4>Income</h4>
</div>
<table>
	<tr>
		<th>Salary/Pension</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanIncome.salary eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif"/>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Other Source (Only Interest Income or Family Pension)</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.otherSourceInterest eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Other Source Agriculture Income Exempt Income</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.otherSourceAgriculture eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>House Property</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.houseProperty eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif"/>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Capital Gain on sale of investment or property</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.capitalGain eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>

	<tr>
		<th>Partner in Partnership Firms</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.partnership eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>

	<tr>
		<th>Propriety Business/Profession Income</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanIncome.business eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif"/>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Income from Presumptive Business</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.presumtiveBusiness eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Foreign Assets</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.foreignAssests eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif"/>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Special Rate Income</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanIncome.rateIncome eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
</table>
<div id="income" align="center">
	<h4>Deductions</h4>
</div>
<table id="deduction">
	<tr>
		<th>Deductions</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanDeductions.deduction eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Relief u/s 89</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanDeductions.reliefEightyNine eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Relief u/s 90 / 91</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanDeductions.reliefNintyOne eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Losses</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanDeductions.losses eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
</table>
<div id="taxes" align="center">
	<h4>Taxes</h4>
</div>
<table>
	<tr>
		<th>TDS from Salary</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanTaxes.tdsSalary eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>TDS other than salary</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanTaxes.tdsOther eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>TCS</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanTaxes.tcs eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Advance Tax</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.pricingPlanTaxes.advanceTax eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
	<tr>
		<th>Self Assesment Tax</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if
					test="${document.pricingPlanTaxes.selfAssessmentTax eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
</table>
<table id="e-filing">
	<tr>
		<th>e-Filing of Income-tax Return (Original)</th>
		<c:forEach items="${documents}" var="document">
			<td><c:if test="${document.efiling eq true}">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<img src="images/GreenOK.gif" />
						</c:when>
						<c:otherwise>
							<img src="images/BlueOK.gif" />
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</c:forEach>
	</tr>
</table>
<div id="additionalservices" align="center">
	<h4>Additional Services (Optional):</h4>
</div>
<table>
	<tr>
		<th>Tax planning for 2012-13</th>
		<c:forEach items="${documents}" var="document">
			<td><c:choose>
					<c:when test="${document.title eq 'DELUXE'}">
						<img src="images/rupeeGreen.gif" />
					</c:when>
					<c:otherwise>
						<img src="images/rupeeBlue.gif" />
					</c:otherwise>
				</c:choose> <c:out
					value="${document.pricingPlanAdditionalServices.taxPlanning }" />
			</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Get your IT Return Reviewed by an Expert</th>
		<c:forEach items="${documents}" var="document">
			<td><c:choose>
					<c:when test="${document.title eq 'DELUXE'}">
						<img src="images/rupeeGreen.gif" />
					</c:when>
					<c:otherwise>
						<img src="images/rupeeBlue.gif" />
					</c:otherwise>
				</c:choose> <c:out
					value="${document.pricingPlanAdditionalServices.assessmentProtection }" />
			</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Get yourself 'Assessment Protection'</th>
		<c:forEach items="${documents}" var="document">
			<td><c:choose>
					<c:when test="${document.title eq 'DELUXE'}">
						<img src="images/rupeeGreen.gif" />
					</c:when>
					<c:otherwise>
						<img src="images/rupeeBlue.gif" />
					</c:otherwise>
				</c:choose> <c:out
					value="${document.pricingPlanAdditionalServices.refundStatus}" />
			</td>
		</c:forEach>
	</tr>
	<tr>
		<th>ITR-V Submission Service</th>
		<c:forEach items="${documents}" var="document">
			<td><c:choose>
					<c:when test="${document.title eq 'DELUXE'}">
						<img src="images/rupeeGreen.gif" />
					</c:when>
					<c:otherwise>
						<img src="images/rupeeBlue.gif" />
					</c:otherwise>
				</c:choose> <c:out
					value="${document.pricingPlanAdditionalServices.returnProcessingStatus }" />
			</td>
		</c:forEach>
	</tr>
	<tr>
		<th>Track your Refund Status</th>
		<c:forEach items="${documents}" var="document">
			<td><c:choose>
					<c:when test="${document.title eq 'DELUXE'}">
						<img src="images/rupeeGreen.gif" />
					</c:when>
					<c:otherwise>
						<img src="images/rupeeBlue.gif" />
					</c:otherwise>
				</c:choose> <c:out
					value="${document.pricingPlanAdditionalServices.reviewedByExpert}" />
			</td>
		</c:forEach>
	</tr>
</table>