<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../../../includes/tags.jspf"%>

<div class="container">
<br>
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="well well-sm">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
                                     alt="User Pic">
                    </div>
                    <div class="col-sm-6 col-md-8">
                        <h4><c:out  value="${theForm.verification.declaration.assesseeVerName}"></c:out></h4>
                        <small><i class="glyphicon glyphicon-map-marker"></i><c:out  value="${theForm.verification.place}"></c:out></small>
                        <p>
                            <i class="glyphicon glyphicon-envelope"></i><c:out  value="${theForm.partAGEN1.personalInfo.address.emailAddress}"></c:out>
                            <br />
                            <i class="glyphicon glyphicon-gift"></i><c:out  value="${theForm.partAGEN1.personalInfo.DOB}"></c:out></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="hero-widget well well-sm">
                <div class="icon">
                     <small><i class="glyphicon glyphicon-rupee">&#8377;</i></small>
                </div>
                <div class="text">
                    <span class="decimal">
                       <c:choose>
                          <c:when test="${theForm.partBTTI.taxPaid.balTaxPayable gt 0}">
                             <fmt:formatNumber value="${theForm.partBTTI.taxPaid.balTaxPayable}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
                          </c:when>
                          <c:otherwise>
                             <fmt:formatNumber value="0" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
                          </c:otherwise>
					  </c:choose>
				  </span>
                </div>
                <div class="options">
                    <h4><span class="label label-primary">Tax Payable</span></h4>
                </div>
            </div>
		</div>
       <div class="col-sm-3">
            <div class="hero-widget well well-sm">
                <div class="icon">
                    <small><i class="glyphicon glyphicon-rupee">&#8377;</i></small> 
                </div>
                <div class="text">
                    <span class="decimal">
                       <c:choose>
                          <c:when test="${theForm.partBTTI.refund.refundDue gt 0}">
                             <fmt:formatNumber value="${theForm.partBTTI.refund.refundDue}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
                          </c:when>
                          <c:otherwise>
                             <fmt:formatNumber value="0" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
                          </c:otherwise>
					  </c:choose>
				  </span>
                </div>
                <div class="options">
                 <h4><span class="label label-primary">Tax Refundable</span></h4>
                </div>
            </div>
		</div>
    </div>
</div>

<div class="container">       
     <div class="panel panel-primary">
         <div class="panel-heading">
              <h3 class="panel-title"><i class="glyphicon glyphicon-tags"></i> Your Income Tax Return Summary</h3>
         </div>
			<table class="table table-condensed">
		     <tr class="success">
					<td style="font-weight:bold;color: black;"><fmt:message key="income.head"/></td>
					<td style="font-weight:bold;color: black;"><fmt:message key="total.amount"/></td>
			  </tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td class ="summary-text-color">
					   <a href="formsixteenschedule.html" class ="summary-href-color">
					     <fmt:message key="itr2.salary"/>
					  </a>
					  <a href="salaryincome.html" class ="summary-href-color">
					    <fmt:message key="itr2.pension"/>
					  </a>
				  </td>
				  <td>
					 <div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.salaries eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a href="houseincome.html"  class ="summary-href-color">
						<fmt:message key="income.house.itr1" />
					</a>
					<fmt:message key="itr2.nil.income"/>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.incomeFromHP eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					   <a href="othersourcesITR2.html"  class ="summary-href-color">
					      <fmt:message key="income.other.sources" />
					   </a>
					   <fmt:message key="itr2.nil.income"/>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.incFromOS.totIncFromOS eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					   <a href="capitalgains.html"  class ="summary-href-color">
					     <fmt:message key="itr2.capital.gain"/>
					   </a>
					   <fmt:message key="itr2.nil.income"/>
					</td>

					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTI.capGain.totalCapGains eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					    <fmt:message key="itr2.total.income"/>
					</td>
					<td>
					   <div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTI.totalTI}"/>
					      </button>
					   </div>
					</td>
				</tr>
				 <tr>
					<td class ="summary-text-color">
					    <fmt:message key="itr2.currentyear.loss"/>
					</td>
					<td>
					   <div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTI.currentYearLoss}"/>
					      </button>
					   </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					    <fmt:message key="itr2.brought.forward.loss"/>
					</td>
					<td>
					   <div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTI.broughtFwdLossesSetoff}"/>
					      </button>
					   </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					<a href="chapterVIdeductions.html" class ="summary-href-color">
					<fmt:message key="deduction.under.6a"/></a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTI.deductionsUnderScheduleVIA eq'0'}">
								<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<fmt:message key="itr2.aggreate.income"/>
					</td>
					<td>
					   <div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTI.aggregateIncome}"/>
					      </button>
					   </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					     <fmt:message key="income.tax"/>
					</td>
					<td>
					<c:choose>
					<c:when test="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc eq '0'}">
					   <div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.taxPayableOnTI.taxPayableOnTotInc}"/>
					      </button>
					   </div>
					</c:when>
					<c:otherwise>
					<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
				<td class ="summary-text-color"><fmt:message key="education.cess"/></td>
					<td>
						<div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.educationCess}"/>
					      </button>
					   </div>
					</td>
				</tr>
                <tr>
					<td class ="summary-text-color"><fmt:message key="tax.education.surcharge"/></td>
					<td>
						<div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.grossTaxLiability}"/>
					      </button>
					   </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					<fmt:message key="itr2.tax.relief"/>
					</td>
					<td>
					   <div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTTI.computationOfTaxLiability.taxRelief.totTaxRelief eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					   <fmt:message key="interest.under.section.234abc"/>
					</td>
					<td>
					<c:choose>
					<c:when test="${theForm.partBTTI.computationOfTaxLiability.intrstPay.totalIntrstPay eq '0'}">
						<div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.intrstPay.totalIntrstPay}"/>
					      </button>
					   </div>
					</c:when>
					<c:otherwise>
					<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
					<td class ="summary-text-color"><fmt:message key="total.tax.interest.payable"/></td>
					<td>
						<div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.computationOfTaxLiability.aggregateTaxInterestLiability}"/>
					      </button>
					   </div>
					</td>
				</tr>
                <tr>
					<td class ="summary-text-color"><fmt:message key="less.prepaid.tax"/></td>
					<td>
						<div class="btn btn-group decimal">
					      <button class="btn btn-default btn-sm">
							  <w4india:inr value="${theForm.partBTTI.taxPaid.taxesPaid.totalTaxesPaid}"/>
					      </button>
					   </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					<a href="advancetax.html" class ="summary-href-color">
					<fmt:message key="advance.tax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.advanceTax eq'0'}">
								<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a href="selfassesmenttax.html" class ="summary-href-color">
					<fmt:message key="advance.selfassesmenttax.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.selfAssessmentTax eq'0'}">
								<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a href="formsixteenschedule.html" class ="summary-href-color"><fmt:message key="itr2.tds.salary"/></a>
					<a href="salaryincome.html" class ="summary-href-color"><fmt:message key="itr2.tds.pension"/></a>
					<a href="tdsfromothers.html" class ="summary-href-color"><fmt:message key="itr2.tds.others"/></a>
					</td>
					<td>
					   <div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
								<c:choose>
									<c:when test="${theForm.partBTTI.taxPaid.taxesPaid.TDS eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td ><b><fmt:message key="itr2.tax.payable"/></b>
					<td>
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
					<td><b><fmt:message key="itr2.tax.refundable"/></b>
					<td>
						<span class="decimal">
                              <fmt:formatNumber value="${theForm.partBTTI.refund.refundDue}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1">
                              </fmt:formatNumber>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td><b><fmt:message key="itr2.tax"/></b>
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
	</div>