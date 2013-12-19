<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Summary Details" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<div class="page">
	<%-- <w4india:itrmenu /> --%>
	<fieldset>
		<table class="table table-striped table table-condensed"
			style="border-color: gray;">
			<caption>
				<b>Personal Information</b>
			</caption>
			<tbody>
				<tr>
					<td>Name of the Assessee</td>
					<td><c:out
							value="${parentBean.firstName} ${parentBean.lastName}" /></td>
					<td>Mobile</td>
					<td><c:out value="${parentBean.mobile}" /></td>
				</tr>
				<tr>
					<td>Father's Name</td>
					<td><c:out value="${parentBean.fatherName} " />
					</td>
					<td>STD Code</td>
					<td><c:out value="${parentBean.stdCode}" /></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><c:out value="${parentBean.employe_category} " /></td>
					<td>Phone<span class="add-on"><i class="glyphicon glyphicon-home"></i>
					</span>
					</td>
					<td><c:out value="${parentBean.phone}" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><c:out value="${parentBean.DOBStr} " />
					</td>
					<td>Mobile(Other)</td>
					<td><c:out value="${parentBean.mobile1}" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><c:out
							value="${parentBean.flatDoorBuilding} ${parentBean.roadStreet} ${parentBean.areaLocality} ${parentBean.townCityDistrict} ${parentBean.pinCode}" />
					</td>
					<td>Email Address<span class="add-on"><i
							class="glyphicon glyphicon-envelope"></i> </span></td>
					<td><c:out value="${parentBean.email}" /></td>
				</tr>
				<tr>
					<td>Previous Year</td>
					<td><c:out value="${parentBean.financialYear} " /></td>
					<td>ITR Form</td>
					<td><c:out value="${parentBean.selectedITRForm}" /></td>
				</tr>
				<tr>
					<td>Assessment Year</td>
					<td><c:out value="${assYear} " /></td>
					<td>Bank Name</td>
					<td><c:out value="${parentBean.BD_BANK_NAME}" /></td>
				</tr>
				<tr>
					<td>PAN</td>
					<td><c:out value="${parentBean.PAN} " />
					</td>
					<td>Bank Branch</td>
					<td><c:out value="${parentBean.BD_ADD_BANK_BRANCH}" /></td>
				</tr>
				<tr>
					<td>Ward/Circle</td>
					<td><c:out value="${parentBean.ward_circle} " /></td>
					<td>Account Number</td>
					<td><c:out value="${parentBean.BD_ACC_NUMBER}" /></td>
				</tr>
				<tr>
					<td>MICR Code</td>
					<td><c:out value="${parentBean.BD_MICR_CODE} " /></td>
					<td>Account Type</td>
					<td><c:out value="${parentBean.BD_TYPE_ACC}" /></td>
				</tr>
				<tr>
					<td>Return Type</td>
					<td><c:out value="${parentBean.returnType} " /></td>
					<td>Portugese civil Status</td>
					<td><c:out value="${parentBean.portugesecivil}" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><c:out value="${parentBean.sex} " /></td>
					<td>Residential Status</td>
					<td><c:out value="${parentBean.residentCategory}" /></td>
				</tr>
				<tr>
					<td>Filling Status</td>
					<td><c:out value="${parentBean.filingStatus} " /></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>

		<c:if test="${not empty formSixteenDocument}">
			<b>Salary Details</b>

			<table class="table table-striped table table-condensed"
				style="border-color: gray;">
				<c:choose>
					<c:when
						test="${not empty  formSixteenDocument.formSixteenDetailList && fn:length(formSixteenDocument.formSixteenDetailList) > 0}">
						<c:forEach var="anItem"
							items="${formSixteenDocument.formSixteenDetailList}">
							<tr>
								<td><b><c:out value="${anItem.employer} " /> </b>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Annual Salary</td>
								<td><div class="decimal">
										<c:out value="${anItem.gross_a} " />
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>Value of perquisites</td>
								<td><div class="decimal">
										<c:out value="${anItem.gross_b} " />
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>Profits in lieu of salary</td>
								<td><div class="decimal">
										<c:out value="${anItem.gross_c} " />
									</div></td>
								<td></td>
							</tr>
							<tr>
								<td>Allowance Exempt</td>
								<td><div class="decimal">
										<c:out value="${anItem.less_total_2} " />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Allowance not Exempt</td>
								<td><div class="decimal">
										<c:out value="${anItem.allowNotExempt} " />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Total</td>
								<td></td>
								<td><div class="decimal">
										<c:out
											value="${anItem.gross_a + anItem.gross_b + anItem.gross_c - anItem.allowNotExempt}" />
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>You havn't entered form sixteen details</c:otherwise>
				</c:choose>

			</table>
		</c:if>
		<c:if test="${not empty cpDoc}">
			<b>Capital Asset Details</b>
			<table class="table table-striped table table-condensed"
				style="border-color: gray;">
				<c:choose>

					<c:when
						test="${not empty  cpDoc.capitalAssetDetailList && fn:length(cpDoc.capitalAssetDetailList) > 0}">
						<c:forEach var="anItem" items="${cpDoc.capitalAssetDetailList}">
							<tr>
								<td>Asset Type</td>
								<td><c:out value="${anItem.assetType} " />
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Gain from Asset</td>
								<td></td>
								<td><div class="decimal">
										<c:out value=" ${anItem.capitalGain}" />
									</div></td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>You havn't entered form sixteen details</c:otherwise>
				</c:choose>

			</table>
		</c:if>
		<%--house property --%>
		<c:if test="${not empty hpDoc}">
			<b>Income from house property</b>

			<table class="table table-striped table table-condensed"
				style="border-color: gray;">
				<c:choose>
					<c:when
						test="${not empty  hpDoc.houseIncomeDetailList && fn:length(hpDoc.houseIncomeDetailList) > 0}">
						<c:forEach var="anItem" items="${hpDoc.houseIncomeDetailList}">

							<tr>
								<td>Lettable Amount</td>
								<td></td>
								<td><div class="decimal">
										<c:out value="${anItem.letable_value} " />
									</div></td>
							</tr>
							<tr>
								<td>Unrealised Rent</td>
								<td><div class="decimal">
										<c:out value=" ${anItem.unrealised_rent}" />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Tax Paid</td>
								<td><div class="decimal">
										<c:out value="${anItem.local_tax} " />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Balance</td>
								<td></td>
								<td><div class="decimal">
										<c:out value=" ${anItem.balance}" />
									</div></td>
							</tr>
							<tr>
								<td>Standard Deduction U/S 24a 30%</td>
								<td><div class="decimal">
										<c:out value="${anItem.rentSec25A} " />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Interest Payable U/S 24b</td>
								<td><div class="decimal">
										<c:out value=" ${anItem.arrearRentSec25B}" />
									</div>
								</td>
								<td></td>
							</tr>
							<tr>
								<td>Total of sections</td>
								<td></td>
								<td><div class="decimal">
										<c:out
											value="${anItem.arrearRentSec25B + anItem.rentSec25A } " />
									</div></td>
							</tr>
							<tr>
								<td><b>Total from House Property</b>
								</td>
								<td></td>
								<td><b><div class="decimal">
											<c:out
												value=" ${anItem.balance - (anItem.arrearRentSec25B + anItem.rentSec25A) }" />
										</div> </b></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>You havn't entered form house property details</c:otherwise>
				</c:choose>
			</table>
		</c:if>
		<c:if test="${not empty osDoc }">


			<b>Income from Other Sources</b>
			<table class="table table-striped table table-condensed"
				style="border-color: gray;">
				<tr>
					<td>Total Interest</td>
					<td><div class="decimal">
							<c:out value="${osDoc.totalint} " />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Income from Family Pension</td>
					<td><div class="decimal">
							<c:out value="${osDoc.family_pension} " />
						</div></td>
					<td></td>
				</tr>
				<tr>
					<td>Dividends</td>
					<td><div class="decimal">
							<c:out value="${osDoc.dividends} " />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Income from Rent of Machine</td>
					<td><div class="decimal">
							<c:out value="${osDoc.income_rent_machine} " />
						</div></td>
					<td></td>
				</tr>

				<tr>
					<td>Total Income from others</td>
					<td><div class="decimal">
							<c:out value="${osDoc.totalOther_income} " />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Family Pension Deduction</td>
					<td><div class="decimal">
							<c:out value="${osDoc.familypension_deduction} " />
						</div></td>

					<td></td>
				</tr>
				<tr>
					<td>Depreciation</td>
					<td><div class="decimal">
							<c:out value="${osDoc.depreciation} " />
						</div></td>
					<td></td>
				</tr>
				<tr>
					<td>Total Expenses</td>
					<td><div class="decimal">
							<c:out value="${osDoc.totalexpense} " />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Dividends from UTI</td>
					<td><div class="decimal">
							<c:out value="${osDoc.dividends_uti} " />
						</div></td>
					<td></td>
				</tr>
				<tr>

					<td>Agriculture Income</td>
					<td><div class="decimal">
							<c:out value="${osDoc.agriculture_income} " />
						</div>
					</td>
					<td></td>
				</tr>

				<tr>
					<td>Total TaxFree Income</td>
					<td><div class="decimal">
							<c:out value="${osDoc.total_taxfree_income} " />
						</div></td>
					<td></td>
				</tr>
				<tr>
					<td><b>Total Income from Other Sources</b></td>
					<td></td>
					<td><b><div class="decimal">
								<c:out value="${osDoc.taxable_income} " />
							</div> </b></td>
				</tr>


			</table>
		</c:if>
		<c:choose>
			<c:when test="${empty show || show == 'summary'}">
				<c:if test="${ITR eq 'ITR1'}">
					<c:out value="abhishek" />
					<jsp:include page="servicerequest-itr1-summaryDetails.jsp" />
				</c:if>
				<c:if test="${ITR eq 'ITR2'}">
					<jsp:include page="servicerequest-itr2-summaryDetails.jsp" />
				</c:if>
				<c:if test="${ITR eq 'ITR4S'}">
					<jsp:include page="servicerequest-itr4s-summaryDetails.jsp" />
				</c:if>
				<c:if test="${ITR eq 'ITR4'}">
					<jsp:include page="servicerequest-itr4-summaryDetails.jsp" />
				</c:if>
				<c:if test="${ITR eq 'ITR3'}">
					<jsp:include page="servicerequest-itr3-summaryDetails.jsp" />
				</c:if>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
		<!-- table for 234b -->
		<table class="table table-striped table table-condensed"
			style="border-color: gray;">
			<thead>
				<ul style="text-align: center;">Interest Under section 234B
				</ul>
			</thead>
			<tbody>
				<tr>
					<td width="40%">Total TDS Non salary</td>
					<td width="30%"><div class="decimal">
							<c:out value="${totalTDS}" />
						</div>
					</td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td>Total TDS salary</td>
					<td><div class="decimal">
							<c:out value="${totaltdssal}" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Total TCS</td>
					<td><div class="decimal">
							<c:out value="0.0" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Advance TAX Paid</td>
					<td><div class="decimal">
							<c:out value="${totaladvtax}" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Total Prepaid Taxes</td>
					<td><div class="decimal">
							<c:out value="${totalTDS + totaltdssal+totaladvtax}" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Percent of TAX Paid</td>
					<td><div class="decimal">
							<c:out value="0.0" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Number Of Months</td>
					<td><div class="decimal">
							<c:out value="${diffInMonths}" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Rate of Tax</td>
					<td><div class="decimal">
							<c:out value="${rate}" />
						</div>
					</td>
					<td></td>
				</tr>
				<%-- <tr>
					<td>Amount on which Tax Calculated</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Tax</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr> --%>
				<tr>
					<td>Self Assessment Tax Paid</td>
					<td><div class="decimal">
							<c:out value="${totalself}" />
						</div>
					</td>
					<td></td>
				</tr>

				<tr>
					<td>Date of Deposit</td>
					<td><div class="decimal">
							<c:out value="${selfDate}" />
						</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Number of Months</td>
					<td><div class="decimal">
							<c:out value="${selfassDiff}" />
						</div>
					</td>
					<td></td>
				</tr>
				<%-- <tr>
					<td>Amount on which Tax Calculated</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Tax</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr> --%>
				<tr>
					<td>234B</td>
					<td></td>

					<td><div class="decimal">
							<c:out value="${salary }" />
						</div>
					</td>
				</tr>

			</tbody>
		</table>
		<!-- table for 234C -->
		<%-- <table class="table table-striped table table-condensed"
			style="border-color: gray;">
			<thead>
				<ul style="text-align: center;">Interest Under section 234C
				</ul>
			</thead>
			<tbody>
				<tr>
					<td width="40%">Total TDS Non salary</td>
					<td width="30%"><c:out value="${BalTaxPayable}" /></td>
					<td width="30%"></td>
				</tr>
				<tr>
					<td>Total TDS salary</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Total TCS</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Advance TAX Paid</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Total Prepaid Taxes</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Advance TAX Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Less: Deduction of CG</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Balance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>30% ofBalance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>First Instalment Paid till 15/09</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>% Of (Total Adv. Tax) Paid</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>

				<tr>
					<td>Amount On which Interest Calculated</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Interest on 1st Instalment</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Advance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Less: Deduction of CG</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Balance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>60% of Balance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Second Instalment Paid till 15/12</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>% Of (Total Adv. Tax) Paid</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Amount On which Interest Calculated</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Interest on 2st Instalment</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Advance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Less: Deduction of CG</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Balance Tax Due</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Third Instalment Paid till 15/03</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>% Of (Total Adv. Tax) Paid</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Amount On which Interest Calculated</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Interest on 3rd Instalment</td>
					<td><c:out value="${BalTaxPayable}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Total Tax</td>
					<td></td>
					<td><c:out value="${BalTaxPayable}" />
					</td>
				</tr>

			</tbody>
		</table> --%>
		<table class="table table-striped table table-condensed">
			<caption>
				<b>Schedule IT </b>
				<p>Schedule IT : Details of Advance Tax and Self Assessment Tax
					Payments of Income-tax</p>
			</caption>

			<tr>

				<th><b>BSR Code</b></th>
				<th><b>Date of Deposite(dd/mm/yyyy)</b></th>
				<th><b>Serial Number of Challan</b></th>
				<th><b>Amount(Rs.)</b></th>
			</thead>
			</tr>

			<c:choose>
				<c:when
					test="${not empty  selfassess.selfAssesmentDetailList && fn:length(selfassess.selfAssesmentDetailList) > 0}">
					<c:forEach var="Item" items="${selfassess.selfAssesmentDetailList}">
						<tr>
							<td><c:out value="${Item.p_BSR}" /></td>
							<td><c:out value="${Item.dateStr}" /></td>
							<td><c:out value="${Item.p_Serial}" /></td>
							<td><c:out value="${Item.p_Amount}" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h5 style="font-style: italic; color: blue;">You haven't
						entered your selfassessment details</h5>
				</c:otherwise>
			</c:choose>
		</table>
		<table class="table table-striped table table-condensed">
			<caption>
				<b>Schedule TDS2 </b>
				<p>ScheduleTDS2: Details of Tax Deducted at Source on Income [As
					per Form 16 A issued by Deductor(s)]</p>
			</caption>

			<tr>
				<th><b> Tax Deduction Account Number (TAN) of the</b></th>
				<th><b>Name of the Deductor</b></th>
				<th><b>Unique TDS Certificate Number</b></th>
				<th><b>Financial Year in which TDS is Deducted</b></th>
				<th><b>Total Tax Deducted</b></th>
				<th><b>Amount out of (6) claimed this Year</b></th>
			</thead>
			</tr>

			<c:choose>
				<c:when
					test="${not empty  formSixteenDocument.formSixteenDetailList && fn:length(formSixteenDocument.formSixteenDetailList) > 0}">
					<c:forEach var="Item"
						items="${formSixteenDocument.formSixteenDetailList}">
						<tr>
							<td><c:out value="${Item.tan_deductor}" /></td>
							<td><c:out value="${Item.employer}" /></td>
							<td></td>
							<td><c:out value="${parentBean.financialYear} " /></td>
							<td><c:out value="${Item.ded_ent_1}" /></td>
							<td><c:out value="${Item.ded_ent_1}" /></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h5>You haven't entered your selfassessment details</h5>
				</c:otherwise>
			</c:choose>
		</table>


	</fieldset>

</div>