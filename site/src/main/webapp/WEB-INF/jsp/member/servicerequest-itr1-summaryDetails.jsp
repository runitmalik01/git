<%@include file="../includes/tags.jspf"%>

<div class="page">
	<table class="table table-striped table table-condensed"
		style="border-color: gray;">
		<tr>
			<td>Deduction Under section vi A</td>
			<td><c:choose>
					<c:when
						test="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions eq'0'}">
						<div class="decimal">
							<c:out value="0.0" />
						</div>
					</c:when>
					<c:when
						test="${not empty theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}">
						<div class="decimal">
							<c:out
								value="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}" />
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
					<c:out value="${theForm.ITR1IncomeDeductions.totalIncome}" />
				</div></td>
		</tr>
		<tr>
			<td><b>Income Tax</b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.totalTaxPayable }" />
				</div></td>
		</tr>
		<tr>
			<td><b>Surcharges</b></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.surchargeOnTaxPayable}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Education Cess</b></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.educationCess }" />
				</div>
			</td>
			<td></td>

		</tr>
		<tr>
			<td><b>Tax Including surcharges </b></td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.grossTaxLiability }" />
				</div></td>
		</tr>
		<tr>
			<td>Rebate Section 89</td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.section89}" />
				</div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Add: Interest under </b></td>
		</tr>
		<tr>
			<td>section 234A</td>
			<td><div class="decimal">
					<c:out value="${Interest234A }" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>section 234B</td>
			<td><div class="decimal">
					<c:out value="${Interest234B}" />
					<c:set var="salary" scope="session" value="${Interest234B}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>section 234C</td>
			<td><div class="decimal">
					<c:out value="${Interest234C}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>Total from under section 234</td>
			<td></td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.totTaxPlusIntrstPay}" />
				</div></td>
		</tr>
		<tr>
			<td><b>Less: Prepaid Tax</b>
			</td>
		</tr>
		<tr>
			<td>Advance Tax</td>
			<td><div class="decimal">
					<c:out value="${totaladvtax}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td>SelfAssessment Tax</td>
			<td><div class="decimal">
					<c:out value="${theForm.ITR1TaxComputation.totTaxPlusIntrstPay}" />
				</div></td>
			<td></td>
		</tr>
		<tr>
			<td><b>Tax Payable</b>
			</td>
			<td></td>
			<td><b><div class="decimal">
						<c:out value="${BalTaxPayable}" />
					</div> </b></td>
		</tr>
	</table>
</div>