<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

<div class="page">
			<table class="table table-hover table-bordered">
				<tr>
					<th><fmt:message key="income.head"/></th>
					<th><fmt:message key="total.amount"/></th>
				</tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td colspan="1" >
					<a href="formsixteen.html">
					<fmt:message key="salary.income"/>
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
								<c:when test="${salaryincome eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${salaryincome}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li>
								<c:choose>
									<c:when test="${salaryincome eq'0'}">
										<a href="formsixteen.html/formsixteennew"><fmt:message key="income.form.sixteen" /></a>
									</c:when>
									<c:otherwise>
										<a href="formsixteen.html"><fmt:message key="income.form.sixteen" /></a>
									</c:otherwise>
								</c:choose>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="salaryincome.html">
					<fmt:message key="income.salary.penson"/>
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
								<c:when test="${Penson eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${Penson}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li>
								<c:choose>
									<c:when test="${Penson eq'0'}">
										<a href="salaryincome.html/salaryincomenew"><fmt:message key="income.salary.penson" /></a>
									</c:when>
									<c:otherwise>
										<a href="salaryincome.html"><fmt:message key="income.salary.penson" /></a>
									</c:otherwise>
								</c:choose>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="houseincome.html">
						<fmt:message key="income.house.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
									<c:when
										test="${theForm.ITR1IncomeDeductions.totalIncomeOfHP eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
									<w4india:inr value="${theForm.ITR1IncomeDeductions.totalIncomeOfHP}"/>

									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="singlehouseincome.html">
								<fmt:message key="income.house.itr1" /></a>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="othersources.html">
					<fmt:message key="income.other.sources" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when
										test="${empty theForm.ITR1IncomeDeductions.incomeOthSrc  || theForm.ITR1IncomeDeductions.incomeOthSrc eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.ITR1IncomeDeductions.incomeOthSrc}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="othersources.html">
								<fmt:message key="income.other.sources" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a style="font-weight:bold;">
					<fmt:message key="gross.total.income"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1IncomeDeductions.grossTotIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="chapterVIdeductions.html" style="font-weight:bold;">
					<fmt:message key="deduction.under.6a"/></a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}">
										<w4india:inr value="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}"/>

									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="chapterVIdeductions.html"><fmt:message
											key="deductions.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a style="font-weight:bold;"><fmt:message key="taxable.income"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1IncomeDeductions.totalIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a><fmt:message key="income.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totalTaxPayable }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a><fmt:message key="surcharge.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.surchargeOnTaxPayable}"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a><fmt:message key="education.cess"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.educationCess }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a style="font-weight:bold;"><fmt:message key="tax.education.surcharge"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.grossTaxLiability }"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1"><a><fmt:message key="relief.section.89"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.ITR1TaxComputation.section89}"/>
						</span>
					</td>
				</tr>
				<c:set var="pageToInclude" value="../itreturns/${financialYear.javaPackageName}/itreturnxml-rebates.jsp"/>
				<jsp:include page="${pageToInclude}"></jsp:include>
				<%--
				<tr>
					<td colspan="1"><a href="rebates.html">
					<fmt:message key="relief.section.90/91"/></a>
					</td>
					<td  style="text-align:left">
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.ITR1TaxComputation.section90And91 eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.ITR1TaxComputation.section90And91}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="rebates.html">
								<fmt:message key="relief.section.90/91"/></a></li>
							</ul>
						</div>
					</td>
				</tr>
				 --%>
				<tr>
					<td colspan="1">
					<a>
					<fmt:message key="interest.under.section.234abc"/></a>
					</td>
					<td  style="text-align:left">
					<c:choose>
					<c:when test="${theForm.ITR1TaxComputation.totalIntrstPay eq '0'}">
					<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totalIntrstPay}"/>
						</span>
					</c:when>
					<c:otherwise>
					<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
										<w4india:inr value="${theForm.ITR1TaxComputation.totalIntrstPay}" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a><fmt:message key="interest.under.section.234a"></fmt:message> |<w4india:inr value="${Interest234A}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234b"></fmt:message> |<w4india:inr value="${Interest234B}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234c"></fmt:message> |<w4india:inr value="${Interest234C}" />|</a></li>
							</ul>
						</div>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a style="font-weight:bold;"><fmt:message key="total.tax.interest.payable"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totTaxPlusIntrstPay}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a style="font-weight:bold;"><fmt:message key="less.prepaid.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.taxPaid.taxesPaid.totalTaxesPaid}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="advancetax.html">
					<fmt:message key="advance.tax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.taxPaid.taxesPaid.advanceTax eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.advanceTax}">
										<w4india:inr value="${ theForm.taxPaid.taxesPaid.advanceTax}"/>
									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="advancetax.html">
								<fmt:message key="advance.tax.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="selfassesmenttax.html">
					<fmt:message key="advance.selfassesmenttax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.taxPaid.taxesPaid.selfAssessmentTax eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.selfAssessmentTax}">
										<w4india:inr value="${theForm.taxPaid.taxesPaid.selfAssessmentTax}"/>

									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="selfassesmenttax.html">
								<fmt:message key="advance.selfassesmenttax.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
			    <tr>
					<td colspan="1"><a><fmt:message key="advance.tdssalary.itr1" /></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${bigTotalTdsSalary}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="tdsfromothers.html">
					<fmt:message key="advance.tdsothers.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${bigTotalTdsOther eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
									<w4india:inr value="${bigTotalTdsOther}"/>

									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="tdsfromothers.html">
									<fmt:message key="advance.tdsothers.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<c:choose>
				<c:when test="${BalTaxPayable gt 0}">
				<tr class="success">
					<td colspan="1"><b>Tax Payable</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${BalTaxPayable eq 0}">
				<tr class="success">
					<td colspan="1"><b>Tax</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td colspan="1"><b>Tax Refundable</b>
					<td  style="text-align:left">
						<span class="decimal">
						<fmt:formatNumber value="${BalTaxPayable}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
						</span>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</table>
		</div>