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
					<td colspan="1">
					<a href="houseincome.html"  style="color: blue; margin-left: 20px;">
						<fmt:message key="income.house.itr1" />
					</a>
					<a style="color: blue;"><fmt:message key="itr2.nil.income"/></a>
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
								<li>
								<c:choose>
									<c:when test="${theForm.partBTI.incomeFromHP eq'0'}">
										<a href="houseincome.html/houseincomenew"><fmt:message key="income.house.itr1" /></a>
									</c:when>
									<c:otherwise>
										<a href="houseincome.html"><fmt:message key="income.house.itr1" /></a>
									</c:otherwise>
								</c:choose>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					   <a href="othersourcesITR2.html"  style="color: blue; margin-left: 20px;">
					      <fmt:message key="income.other.sources" />
					   </a>
					   <a style="color: blue;"><fmt:message key="itr2.nil.income"/></a>
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
					<td colspan="1">
					   <a href="capitalgains.html"  style="color: blue; margin-left: 20px;">
					     <fmt:message key="itr2.capital.gain"/>
					   </a>
					   <a style="color: blue;"><fmt:message key="itr2.nil.income"/></a>
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
								<li><c:choose>
								<c:when test="${theForm.partBTI.capGain.longTerm.totalLongTerm gt '0' || theForm.partBTI.capGain.shortTerm.totalShortTerm gt '0'|| theForm.scheduleEI.LTCGWhereSTTPaid gt '0' }">
								<a href="capitalgains.html"><fmt:message key="itr2.long.term"/> |<w4india:inr value="${theForm.partBTI.capGain.longTerm.totalLongTerm}" />|</a>
									<a href="capitalgains.html"><fmt:message key="itr2.short.term"/> |<w4india:inr value="${theForm.partBTI.capGain.shortTerm.totalShortTerm}" />|</a>
									<c:choose>
									   <c:when test="${theForm.scheduleEI.LTCGWhereSTTPaid eq null}">
						         			<a href="capitalgains.html"><fmt:message key="itr2.long.term.exempt"/> |<w4india:inr value="0" />|</a>
									   </c:when>
									   <c:otherwise>
									      <a href="capitalgains.html"><fmt:message key="itr2.long.term.exempt"/> |<w4india:inr value="${theForm.scheduleEI.LTCGWhereSTTPaid}" />|</a>
									   </c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
								<a href="capitalgains.html"><fmt:message key="itr2.capital.gain"/></a>
								</c:otherwise>
								</c:choose>

								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					   <a href="incomefromfirmsItr3.html"  style="color: blue; margin-left: 20px;">
					      <fmt:message key="itr4s.bussiness.income" />
					   </a>
					   <a style="color: blue;"><fmt:message key="itr2.nil.income"/></a>
					</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.profBusGain.totProfBusGain eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<w4india:inr value="${theForm.partBTI.profBusGain.totProfBusGain}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="incomefromfirmsItr3.html">
								<fmt:message key="itr4s.bussiness.income" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				 <tr>
					<td colspan="1">
					   <a style="font-weight:bold;color: black;">
					    <fmt:message key="itr2.total.income"/>
					   </a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTI.totalTI}"/>
						</span>
					</td>
				</tr>
				 <tr>
					<td colspan="1">
					   <a style="font-weight:bold;color: black;">
					    <fmt:message key="itr2.currentyear.loss"/>
					   </a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTI.currentYearLoss}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					   <a style="font-weight:bold;color: black;">
					    <fmt:message key="itr2.brought.forward.loss"/>
					   </a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTI.broughtFwdLossesSetoff}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="chapterVIdeductions.html" style="font-weight:bold;color: black;">
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
					<td colspan="1" style="font-weight:bold; color: black;">
					<fmt:message key="itr2.aggreate.income"/>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTI.aggregateIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold; color: black;">
					     <fmt:message key="income.tax"/>
					</td>
					<td  style="text-align:left">
					<c:choose>
					<c:when test="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc eq '0'}">
					<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc}"/>
						</span>
					</c:when>
					<c:otherwise>
					<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
										<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc}" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a><fmt:message key="income.tax.normal.rates"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxAtNormalRatesOnAggrInc}" />|</a></li>
								<li><a><fmt:message key="income.tax.special.rates"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxAtSpecialRates}" />|</a></li>
								<li><a><fmt:message key="income.tax.rebate.agriculture"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.rebateOnAgriInc}" />|</a></li>
							</ul>
						</div>
					</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
				<td colspan="1" style="font-weight:bold; color: black;"><fmt:message key="education.cess"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.educationCess}"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold; color: black;"><fmt:message key="tax.education.surcharge"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.grossTaxLiability}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold; color: black;">
					<fmt:message key="itr2.tax.relief"/>
					</td>
					<td  style="text-align:left">
					   <div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTTI.computationOfTaxLiability.taxRelief.totTaxRelief eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.totTaxRelief}"/>
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="formsixteenschedule.html"><fmt:message key="itr2.relief.89"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section89}" />|</a></li>
								<li><a href="trdetails.html"><fmt:message key="itr2.relief.90/90a"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section90}" />|</a></li>
								<li><a href="trdetails.html"><fmt:message key="itr2.relief.91"/> |<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxRelief.section91}" />|</a></li>
							</ul>
						</div>
                   </td>
				</tr>
				<tr>
					<td colspan="1" style="font-weight:bold; color: black;">
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
					<td colspan="1" style="font-weight:bold; color: black;"><fmt:message key="total.tax.interest.payable"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.aggregateTaxInterestLiability}"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1" style="font-weight:bold; color: black;"><fmt:message key="less.prepaid.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.totalTaxesPaid}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="advancetax.html" style="color: blue; margin-left: 20px;">
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
					<td colspan="1">
					<a href="selfassesmenttax.html" style="color: blue; margin-left: 20px;">
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
					<td colspan="1">
					<a href="formsixteenschedule.html" style="color: blue; margin-left: 20px;"><fmt:message key="itr2.tds.salary"/></a>
					<a href="salaryincome.html" style="color: blue"><fmt:message key="itr2.tds.pension"/></a>
					<a href="tdsfromothers.html" style="color: blue"><fmt:message key="itr2.tds.others"/></a>
					</td>
					<td  style="text-align:left">
					   <div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.TDS eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
								        	<w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.TDS}"/>
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

				<c:choose>
				<c:when test="${theForm.partBTTI.taxPaid.balTaxPayable gt 0}">
				<tr class="success">
					<td colspan="1"><b><fmt:message key="itr2.tax.payable"/></b>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.partBTTI.taxPaid.balTaxPayable}"/>
								<c:if test="${theForm.partBTTI.taxPaid.balTaxPayable > 0}">
								<span style="padding-left:20px"><a href="https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp">Pay Tax Now</a></span>
							</c:if>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${theForm.partBTTI.refund.refundDue gt 0}">
				<tr class="success">
					<td colspan="1"><b><fmt:message key="itr2.tax.refundable"/></b>
					<td  style="text-align:left">
						<span class="decimal">
                              <fmt:formatNumber value="${theForm.partBTTI.refund.refundDue}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1">
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