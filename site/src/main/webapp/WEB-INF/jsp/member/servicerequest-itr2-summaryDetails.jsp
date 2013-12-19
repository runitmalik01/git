<%@include file="../includes/tags.jspf"%>
<div class="page">
	<table class="table table-striped table table-condensed"
		style="border-color: gray;">
		<tr>
			<td>Deduction Under section vi A</td>
			<td><c:choose>
					<c:when test="${theForm.partBTI.deductionsUnderScheduleVIA eq'0'}">
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="decimal">
							<c:out value="${theForm.partBTI.deductionsUnderScheduleVIA }" />
						</div>
					</c:otherwise>
				</c:choose></td>
			<td></td>
		</tr>
		<tr>
			<td><b>Taxable Income</b>
			</td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.partBTI.aggregateIncome}" />
				</div>
			</td>
		</tr>
		<tr>
			<td><b>Income Tax</b>
			</td>
			<td></td>
			<td><c:choose>
					<c:when
						test="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc eq '0'}">
						<div class="decimal">
							<c:out
								value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc}" />
						</div>
					</c:when>
					<c:otherwise>

						<div class="decimal">
							<c:out
								value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc}" />
						</div>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td><b>Special Tax</b>
			</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxAtSpecialRates}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Normal Tax</b>
			</td>
			<td><div class="decimal">
					<c:out value="0.0" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Education Cess</b>
			</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.educationCess}" />
				</div>
			</td>
			<td></td>

		</tr>
		<tr>
			<td><b>Tax Including surcharges </b>
			</td>
			<td></td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.grossTaxLiability}" />
				</div></td>
		</tr>
		<tr>
			<td>Rebate Section 89</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.totTaxRelief}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Add: Interest under </b>
			</td>
		</tr>
		<tr>
			<td>section 234A</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234A}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>section 234B</td>

			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234B}" />
					<c:set var="salary" scope="session"
						value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234B}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>section 234C</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234C}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>Total Tax and Interest</td>
			<td></td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.computationOfTaxLiability.aggregateTaxInterestLiability}" />
				</div></td>
		</tr>
		<tr>
			<td><b>Less: Prepaid Tax</b></td>
		</tr>
		<tr>
			<td>Advance Tax</td>
			<td><div class="decimal">
					<c:out value="${theForm.partBTTI.taxPaid.taxesPaid.advanceTax}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>SelfAssessment Tax</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.partBTTI.taxPaid.taxesPaid.selfAssessmentTax}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Total TDS</b></td>
			<td></td>
			<td><b><div class="decimal">
						<c:out value="${theForm.partBTTI.taxPaid.taxesPaid.TDS}" />
					</div> </b>
			</td>
		</tr>
		<c:choose>
			<c:when test="${theForm.partBTTI.taxPaid.balTaxPayable gt 0}">
				<tr>
					<td><b>Tax Payable</b></td>
					<td></td>
					<td><b><div class="decimal">
								<c:out value="${theForm.partBTTI.taxPaid.balTaxPayable}" />
							</div> </b>
					</td>
				</tr>

			</c:when>
			<c:when test="${theForm.partBTTI.refund.refundDue gt 0}">
				<tr>
					<td><b>Tax Refundable</b></td>
					<td></td>
					<td><b><div class="decimal">
								<c:out value="${theForm.partBTTI.refund.refundDue}" />
							</div> </b></td>

				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td><b><fmt:message key="itr2.tax" /> </b></td>
					<td></td>
					<td>
						<div class="decimal">
							<c:out value="0.0" />
						</div></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</div>
