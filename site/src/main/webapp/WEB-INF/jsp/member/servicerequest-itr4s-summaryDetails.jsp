<%@include file="../includes/tags.jspf"%>
<div class="page">
	<table class="table table-striped table table-condensed"
		style="border-color: gray;">
		<tr>
			<td>Deduction Under section vi A</td>
			<td><c:choose>
					<c:when
						test="${theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions eq'0'}">
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:when>
					<c:when
						test="${not empty theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions}">
						<div class="decimal">
							<c:out
								value="${theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions}" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:otherwise>
				</c:choose>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Taxable Income</b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4SIncomeDeductions.totalIncome}" />
				</div></td>
		</tr>
		<tr>
			<td><b>Income Tax</b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4STaxComputation.totalTaxPayable }" />
				</div></td>
		</tr>
		<tr>
			<td><b>Education Cess</b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4STaxComputation.educationCess }" />
				</div>
			</td>

		</tr>
		<tr>
			<td><b>Tax Including surcharges </b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4STaxComputation.grossTaxLiability }" />
				</div>
			</td>
		</tr>
		<tr>
			<td>Rebate Section 89</td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4STaxComputation.section89}" />
				</div>
			</td>
		</tr>
		<tr>
			<td><b>Add: Interest under </b></td>
		</tr>
		<tr>
			<td>section 234A</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234A}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>section 234B</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234B}" />
					<c:set var="salary" scope="session"
						value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234B}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>section 234C</td>
			<td><div class="decimal">
					<c:out
						value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234C}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td>Total Tax and Interest</td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR4STaxComputation.totTaxPlusIntrstPay}" />
				</div>
			</td>
		</tr>
		<tr>
			<td><b>Less: Prepaid Tax</b>
			</td>
		</tr>
		<tr>
			<td>Advance Tax</td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${ theForm.taxPaid.taxesPaid.advanceTax}" />
				</div>
		</tr>
		<tr>
			<td>SelfAssessment Tax</td>
			<td></td>
			<td><c:choose>
					<c:when test="${theForm.taxPaid.taxesPaid.selfAssessmentTax eq'0'}">
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:when>
					<c:when
						test="${not empty theForm.taxPaid.taxesPaid.selfAssessmentTax}">
						<div class="decimal">
							<c:out value="${theForm.taxPaid.taxesPaid.selfAssessmentTax}" />
						</div>

					</c:when>
					<c:otherwise>
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<td><b>Total TDS</b>
			</td>
			<td></td>
			<td><b><c:choose>
						<c:when test="${theForm.taxPaid.taxesPaid.TDS eq '0'}">
							<div class="decimal">
								<c:out value="0.0" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="decimal">
								<c:out value="${theForm.taxPaid.taxesPaid.TDS}" />
							</div>
						</c:otherwise>
					</c:choose> </b></td>
		</tr>
		<tr>
			<td><b>Total TCS</b>
			</td>
			<td></td>
			<td><b><c:choose>
						<c:when test="${theForm.taxPaid.taxesPaid.TCS eq'0'}">
							<div class="decimal">
								<c:out value="0.0" />
							</div>
						</c:when>
						<c:when test="${not empty theForm.taxPaid.taxesPaid.TCS}">
							<div class="decimal">
								<c:out value="${theForm.taxPaid.taxesPaid.TCS}" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="decimal">
								<c:out value="0.0" />
							</div>
						</c:otherwise>
					</c:choose> </b></td>
		</tr>
		<tr>

			<c:choose>
				<c:when test="${theForm.taxPaid.balTaxPayable gt 0}">
					<td><b>Tax Payable</b>
					</td>
					<td></td>
					<td><div class="decimal">
							<b> <c:out value="${theForm.taxPaid.balTaxPayable}" /> </b>
						</div>
					</td>

				</c:when>
				<c:when test="${theForm.refund.refundDue gt 0}">
					<td><b>Tax Payable</b>
					</td>
					<td></td>
					<td><div class="decimal">
							<b> <c:out value="${theForm.refund.refundDue}" /> </b>
						</div></td>

				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</tr>

	</table>
</div>
