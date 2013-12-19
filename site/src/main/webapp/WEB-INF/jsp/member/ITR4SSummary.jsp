<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

<div class="page">
			<table class="table table-hover table-bordered table-striped">
				<tr class="warning">
					<td style="font-weight:bold;color: black;"><fmt:message key="income.head"/></td>
					<td style="font-weight:bold;color: black;"><fmt:message key="total.amount"/></td>
				</tr>
				<!--  lets create a bookmark for each section -->
					<tr>
					<td colspan="1" align="center" >
					   <a href="formsixteenschedule.html" style="color: blue; margin-left: 20px;">
					     <fmt:message key="itr2.salary"/>
					  </a>
					  <a href="salaryincome.html" style="color: blue">
					    <fmt:message key="itr2.pension"/>
					  </a>
				  </td>
				  <td>
					 <div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.ITR4SIncomeDeductions.incomeFromSal eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.ITR4SIncomeDeductions.incomeFromSal}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li>
								<c:choose>
									<c:when test="${theForm.ITR4SIncomeDeductions.incomeFromSal eq'0'}">
										<a href="formsixteenschedule.html/formsixteennew"><fmt:message key="income.form.sixteen" /></a>
									</c:when>
									<c:otherwise>
										<a href="formsixteenschedule.html"><fmt:message key="income.form.sixteen" /></a>
									</c:otherwise>
								</c:choose>
								</li>
								<li>
                                <c:choose>
									<c:when test="${theForm.ITR4SIncomeDeductions.incomeFromSal eq'0'}">
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
					<a href="singlehouseincome.html"  style="color: blue">
						<fmt:message key="income.house.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
									<c:when
										test="${theForm.ITR4SIncomeDeductions.totalIncomeOfHP eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
									<w4india:inr value="${theForm.ITR4SIncomeDeductions.totalIncomeOfHP}"/>

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
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="othersources.html"  style="color: blue">
					<fmt:message key="income.other.sources" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when
										test="${empty theForm.ITR4SIncomeDeductions.incomeOthSrc  || theForm.ITR4SIncomeDeductions.incomeOthSrc eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.ITR4SIncomeDeductions.incomeOthSrc}"/>
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
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="businessprofess.html"  style="color: blue">
						<fmt:message key="itr4s.bussiness.income" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
									<c:when
										test="${theForm.ITR4SIncomeDeductions.incomeFromBusinessProf eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
									<w4india:inr value="${theForm.ITR4SIncomeDeductions.incomeFromBusinessProf}"/>

									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="businessprofess.html">
								<fmt:message key="itr4s.bussiness.income" /></a>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;">
					<fmt:message key="gross.total.income"/>
					</td>
					<td  style="text-align:left; color: black" >
						<span class="decimal">
									<w4india:inr value="${theForm.ITR4SIncomeDeductions.grossTotIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="chapterVIdeductions.html" style="font-weight:bold;color: black">
					<fmt:message key="deduction.under.6a"/></a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions}">
										<w4india:inr value="${theForm.ITR4SIncomeDeductions.deductUndChapVIA.totalChapVIADeductions}"/>
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
					<td colspan="1" style="font-weight:bold; color: black"><fmt:message key="taxable.income"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR4SIncomeDeductions.totalIncome}"/>
						</span>
					</td>
				</tr>
	<tr>
				<td colspan="1" style="font-weight:bold; color: black";><fmt:message key="income.tax"/></td>
					<td  style="text-align:left;">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR4STaxComputation.totalTaxPayable }"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1" style="font-weight:bold;"><fmt:message key="education.cess"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR4STaxComputation.educationCess }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="tax.education.surcharge"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR4STaxComputation.grossTaxLiability }"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="relief.section.89"/></td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.ITR4STaxComputation.section89}"/>
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
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
					<td colspan="1" style="font-weight:bold;">

					<fmt:message key="interest.under.section.234abc"/>
					</td>
					<td  style="text-align:left">
					<c:choose>
					<c:when test="${theForm.ITR4STaxComputation.totalIntrstPay eq '0'}">
					<span class="decimal">
									<w4india:inr value="${theForm.ITR4STaxComputation.totalIntrstPay}"/>
						</span>
					</c:when>
					<c:otherwise>
					<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
										<w4india:inr value="${theForm.ITR4STaxComputation.totalIntrstPay}" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a><fmt:message key="interest.under.section.234a"></fmt:message> |<w4india:inr value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234A}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234b"></fmt:message> |<w4india:inr value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234B}" />|</a></li>
								<li><a><fmt:message key="interest.under.section.234c"></fmt:message> |<w4india:inr value="${theForm.ITR4STaxComputation.intrstPay.intrstPayUs234C}" />|</a></li>
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
									<w4india:inr value="${theForm.ITR4STaxComputation.totTaxPlusIntrstPay}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold;"><fmt:message key="less.prepaid.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.taxPaid.taxesPaid.totalTaxesPaid}"/>
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
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="selfassesmenttax.html" style="color: blue">
					<fmt:message key="advance.selfassesmenttax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
					<td colspan="1">
					<a href="formsixteenschedule.html" style="color: blue; margin-left: 20px;"><fmt:message key="itr2.tds.salary"/></a>
					<a href="salaryincome.html" style="color: blue"><fmt:message key="itr2.tds.pension"/></a>
					<a href="tdsfromothers.html" style="color: blue"><fmt:message key="itr2.tds.others"/></a>
					</td>
					<td  style="text-align:left">
					   <div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.taxPaid.taxesPaid.TDS eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.taxPaid.taxesPaid.TDS}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="formsixteenschedule.html"><fmt:message key="itr2.tds.salary"/></a></li>
								<li><a href="salaryincome.html"><fmt:message key="itr2.tds.from.pension"/></a></li>
								<li><a href="tdsfromothers.html"><fmt:message key="itr2.tds.from.others"/></a></li>
							</ul>
						</div>
                   </td>
				</tr>
				<tr>
					<td colspan="1">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="tcsdetail.html" style="color: blue">
					<fmt:message key="itr4s.tcs" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.taxPaid.taxesPaid.TCS eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.TCS}">
										<w4india:inr value="${theForm.taxPaid.taxesPaid.TCS}"/>

									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="tcsdetail.html">
								<fmt:message key="itr4s.tcs" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<c:choose>
				<c:when test="${theForm.taxPaid.balTaxPayable gt 0}">
				<tr class="success">
					<td colspan="1"><b><fmt:message key="itr2.tax.payable"/></b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.taxPaid.balTaxPayable}"/>
								<c:if test="${theForm.taxPaid.balTaxPayable > 0}">
								<span style="padding-left:20px"><a href="https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp">Pay Tax Now</a></span>
							</c:if>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${theForm.refund.refundDue gt 0}">
				<tr class="success">
					<td colspan="1"><b><fmt:message key="itr2.tax.refundable"/></b>
					<td  style="text-align:left">
						<span class="decimal">
                              <fmt:formatNumber value="${theForm.refund.refundDue}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1">
                              </fmt:formatNumber>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td colspan="1"><b><fmt:message key="itr2.tax"/></b>
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