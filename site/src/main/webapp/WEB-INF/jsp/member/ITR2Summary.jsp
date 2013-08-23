<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

<div class="page">

			<table class="table table-hover table-bordered">
				<tr>
					<th style="font-weight:bold; color: black;"><fmt:message key="income.head"/></th>
					<th><fmt:message key="total.amount"/></th>
				</tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td colspan="1" align="center" > &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="formsixteenschedule.html" style="color: blue">
					Salary
					</a>
					<a href="salaryincome.html" style="color: blue">
					/ Pension
					</a>
					</td>
					<td>
					<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.salaries eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.partBTI.salaries}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li>
								<c:choose>
									<c:when test="${theForm.partBTI.salaries eq'0'}">
										<a href="formsixteenschedule.html/formsixteennew"><fmt:message key="income.form.sixteen" /></a>
									</c:when>
									<c:otherwise>
										<a href="formsixteenschedule.html"><fmt:message key="income.form.sixteen" /></a>
									</c:otherwise>
								</c:choose>
								</li>
								<li>
                                <c:choose>
									<c:when test="${theForm.partBTI.salaries eq'0'}">
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
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="houseincome.html"  style="color: blue">
						<fmt:message key="income.house.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.incomeFromHP eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.partBTI.incomeFromHP}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="houseincome.html">
								<fmt:message key="income.house.itr1" /></a>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					   <a href="othersourcesITR2.html"  style="color: blue">
					      <fmt:message key="income.other.sources" />
					   </a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.incFromOS.totIncFromOS eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTI.incFromOS.totIncFromOS}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="othersourcesITR2.html">
								<fmt:message key="income.other.sources" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					   <a href="capitalgains.html"  style="color: blue">
					     Capital Gain
					   </a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.capGain.totalCapGains eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTI.capGain.totalCapGains}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="capitalgains.html">
								Capital Gain</a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="chapterVIdeductions.html" style="font-weight:bold;color: black">
					<fmt:message key="deduction.under.6a"/></a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTI.deductionsUnderScheduleVIA eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTI.deductionsUnderScheduleVIA }"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="chapterVIdeductions.html"><fmt:message key="deductions.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold; color: black">Aggregate Income</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTI.aggregateIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1" style="font-weight:bold; color: black";><fmt:message key="income.tax"/></td>
					<td  style="text-align:left;">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="surcharge.tax"/></td>
					<td  style="text-align:left; color: black">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.surchargeOnTaxPayable}"/>
						</span>
					</td>
				</tr>
					<tr>
				<td colspan="1" style="font-weight:bold;"><fmt:message key="education.cess"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.educationCess}"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="tax.education.surcharge"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.grossTaxLiability}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="relief.section.89"/></td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section89}"/>
						</span>
					</td>
				</tr>
				<c:set var="pageToInclude" value="../itreturns/${financialYear.javaPackageName}/itreturnxml-rebates.jsp"/>
				<jsp:include page="${pageToInclude}"></jsp:include>
				<tr>
					<td colspan="1" style="font-weight:bold;">
					  Deduct: Relief under Section 90/90A
					</td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section90}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;">
					  Deduct: Relief under Section 91
					</td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section91}"/>
						</span>
					</td>
				</tr>
					<tr>
					<td colspan="1" style="font-weight:bold;">
					   <fmt:message key="interest.under.section.234abc"/>
					</td>
					<td  style="text-align:left">
					<c:choose>
					<c:when test="${theForm.partBTTI.computationOfTaxLiability.intrstPay.totalIntrstPay eq '0'}">
					<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.totalIntrstPay}"/>
						</span>
					</c:when>
					<c:otherwise>
					<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
										<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.totalIntrstPay}" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a><fmt:message key="interest.under.section.234a"></fmt:message> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234A}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234b"></fmt:message> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234B}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234c"></fmt:message> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.intrstPayUs234C}" />|</a></li>
							</ul>
						</div>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="total.tax.interest.payable"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.aggregateTaxInterestLiability}"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="less.prepaid.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.totalTaxesPaid}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="advancetax.html" style="color: blue">&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="advance.tax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.advanceTax eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.advanceTax}"/>
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
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="selfassesmenttax.html" style="color: blue">
					<fmt:message key="advance.selfassesmenttax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.selfAssessmentTax eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.selfAssessmentTax}"/>
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
					<td colspan="1" style="color: blue">&nbsp;&nbsp;&nbsp;&nbsp;TDS From Salary/Pension/Others</td>
					<td  style="text-align:left">
						<span class="decimal">
							 <w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.TDS}"/>
						</span>
					</td>
				</tr>
				<c:choose>
				<c:when test="${theForm.partBTTI.taxPaid.balTaxPayable gt 0}">
				<tr class="success">
					<td colspan="1"><b>Tax Payable</b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.partBTTI.taxPaid.balTaxPayable}"/>
								<c:if test="${theForm.partBTTI.taxPaid.balTaxPayable > 0}">
								<span style="padding-left:20px"><a href="https://incometaxindiaefiling.gov.in/e-Filing/Services/KnowYourTanLink.html">Pay Tax Now</a></span>
							</c:if>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${theForm.partBTTI.refund.refundDue gt 0}">
				<tr class="success">
					<td colspan="1"><b>Tax Refundable</b>
					<td  style="text-align:left">
						<span class="decimal">
								<fmt:formatNumber value="${theForm.partBTTI.refund.refundDue}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td colspan="1"><b>Tax</b>
					<td  style="text-align:left">
						<span class="decimal">
							<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</table>
		</div>