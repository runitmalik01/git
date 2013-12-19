<%@include file="../includes/tags.jspf"%>
<div class="page">
	<table class="table table-striped table table-condensed"
		style="border-color: gray;">
		<tr>
			<td>Deduction Under section vi A</td>
			<td><c:choose>
					<c:when test="${theForm.partBTI.deductionsUnderScheduleVIA eq'0'}">
						<c:out value="0.0" />
					</c:when>
					<c:otherwise>
						<w4india:inr
							value="${theForm.partBTI.deductionsUnderScheduleVIA }" />
					</c:otherwise>
				</c:choose>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Taxable Income</b></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><b>Income Tax</b></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><b>Special Tax</b></td>
			<td></td>
			<td><c:out value="0.0" /></td>
		</tr>
		<tr>
			<td><b>Normal Tax</b></td>
			<td></td>
			<td><c:out value="0.0" /></td>
		</tr>
		<tr>
			<td><b>Surcharges</b></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><b>Education Cess</b></td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.educationCess}" />
			</td>

		</tr>
		<tr>
			<td><b>Tax Including surcharges </b></td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.grossTaxLiability}" />
			</td>
		</tr>
		<tr>
			<td>Rebate Section 89</td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.totTaxRelief}" />
			</td>
		</tr>
		<tr>
			<td><b>Add: Interest under </b></td>
		</tr>
		<tr>
			<td>section 234A</td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234A}" />
			</td>
			<td></td>
		</tr>
		<tr>
			<td>section 234B</td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234B}" />
			</td>
			<td></td>
		</tr>
		<tr>
			<td>section 234C</td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234C}" />
			</td>
			<td></td>
		</tr>
		<tr>
			<td>Total Tax and Interest</td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.computationOfTaxLiability.aggregateTaxInterestLiability}" />
			</td>
		</tr>
		<tr>
			<td><b>Less: Prepaid Tax</b>
			</td>
		</tr>
		<tr>
			<td>Advance Tax</td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.taxPaid.taxesPaid.advanceTax}" /></td>
		</tr>
		<tr>
			<td>SelfAssessment Tax</td>
			<td></td>
			<td><w4india:inr
					value="${theForm.partBTTI.taxPaid.taxesPaid.selfAssessmentTax}" />
			</td>
		</tr>
		<tr>
			<td><b>Total TDS</b>
			</td>
			<td></td>
			<td><b><w4india:inr
						value="${theForm.partBTTI.taxPaid.taxesPaid.TDS}" /> </b></td>
		</tr>
		<tr>
			<td><b>Tax Payable</b>
			</td>
			<td></td>
			<td><b><w4india:inr
						value="${theForm.partBTTI.taxPaid.balTaxPayable}" /> </b></td>
		</tr>
	</table>
</div>
