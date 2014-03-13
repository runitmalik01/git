<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>

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
                            <i class="glyphicon glyphicon-envelope"></i><c:out  value="${theForm.personalInfo.address.emailAddress}"></c:out>
                            <br />
                            <i class="glyphicon glyphicon-gift"></i><c:out  value="${theForm.personalInfo.DOB}"></c:out></p>
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
                          <c:when test="${BalTaxPayable gt 0}">
                             <fmt:formatNumber value="${BalTaxPayable}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
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
                          <c:when test="${BalTaxPayable lt 0}">
                             <fmt:formatNumber value="${BalTaxPayable}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
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
              <h3 class="panel-title">Tax Summary</h3>
         </div>
         <table class="table table-condensed">
		     <tr class="success">
					<td style="font-weight:bold;color: black;"><fmt:message key="income.head"/></td>
					<td style="font-weight:bold;color: black;"><fmt:message key="total.amount"/></td>
			  </tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td class ="summary-text-color">
					<a href="formsixteen.html" class ="summary-href-color">
					<fmt:message key="salary.income"/>
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
								<c:when test="${salaryincome eq'0'}">
								<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a  href="salaryincome.html" class ="summary-href-color">
					<fmt:message key="income.salary.penson"/>
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
								<c:when test="${Penson eq'0'}">
								<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a href="singlehouseincome.html" class ="summary-href-color">
						<fmt:message key="income.house.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
									<c:when
										test="${theForm.ITR1IncomeDeductions.totalIncomeOfHP eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<a href="othersources.html" class ="summary-href-color">
					<fmt:message key="income.other.sources" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when
										test="${empty theForm.ITR1IncomeDeductions.incomeOthSrc  || theForm.ITR1IncomeDeductions.incomeOthSrc eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color">
					<fmt:message key="gross.total.income"/>
					</td>
					<td>
					<div class="btn btn-group decimal">
					<button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1IncomeDeductions.grossTotIncome}"/>
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
								<c:when test="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions eq'0'}">
								<fmt:message key="summary.button.label" />
								</c:when>
									<c:when
										test="${not empty theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}">
										<w4india:inr value="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}"/>

									</c:when>
									<c:otherwise>
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color"><fmt:message key="taxable.income"/></td>
					<td>
					  <div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1IncomeDeductions.totalIncome}"/>
					     </button>
					  </div>
					</td>
				</tr>
				<tr>
				<td class ="summary-text-color"><fmt:message key="income.tax"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.totalTaxPayable }"/>
					     </button>
					  </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color"><fmt:message key="surcharge.tax"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.surchargeOnTaxPayable}"/>
					     </button>
					  </div>
					</td>
				</tr>
				<tr>
				<td class ="summary-text-color"><fmt:message key="education.cess"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.educationCess }"/>
					     </button>
					  </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color"><fmt:message key="tax.education.surcharge"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.grossTaxLiability }"/>
					     </button>
					  </div>
					</td>
				</tr>
                <tr>
					<td class ="summary-text-color"><fmt:message key="relief.section.89"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.section89}"/>
					     </button>
					  </div>
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
					<td class ="summary-text-color">

					<fmt:message key="interest.under.section.234abc"/>
					</td>
					<td>
					<c:choose>
					<c:when test="${theForm.ITR1TaxComputation.totalIntrstPay eq '0'}">
						<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.totalIntrstPay}"/>
					     </button>
					  </div>
					</c:when>
					<c:otherwise>
					<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
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
					<td class ="summary-text-color"><fmt:message key="total.tax.interest.payable"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.ITR1TaxComputation.totTaxPlusIntrstPay}"/>
					     </button>	
					     </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color"><fmt:message key="less.prepaid.tax"/></td>
					<td>
					<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
							<w4india:inr value="${theForm.taxPaid.taxesPaid.totalTaxesPaid}"/>
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
								<c:when test="${theForm.taxPaid.taxesPaid.advanceTax eq'0'}">
								<fmt:message key="summary.button.label" />
								</c:when>
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.advanceTax}">
										<w4india:inr value="${ theForm.taxPaid.taxesPaid.advanceTax}"/>
									</c:when>
									<c:otherwise>
										<fmt:message key="summary.button.label" />
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
								<c:when test="${theForm.taxPaid.taxesPaid.selfAssessmentTax eq'0'}">
								<fmt:message key="summary.button.label" />
								</c:when>
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.selfAssessmentTax}">
										<w4india:inr value="${theForm.taxPaid.taxesPaid.selfAssessmentTax}"/>

									</c:when>
									<c:otherwise>
										<fmt:message key="summary.button.label" />
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
					<td class ="summary-text-color"><fmt:message key="advance.tdssalary.itr1" /></td>
					<td>
						<div class="btn btn-group decimal">
					     <button class="btn btn-default btn-sm">
								<w4india:inr value="${bigTotalTdsSalary}"/>
					     </button>
					  </div>
					</td>
				</tr>
				<tr>
					<td class ="summary-text-color">
					<a href="tdsfromothers.html" class ="summary-href-color">
					<fmt:message key="advance.tdsothers.itr1" />
					</a>
					</td>
					<td>
						<div class="btn btn-group" class="decimal">
							<button class="btn btn-default btn-sm dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${bigTotalTdsOther eq '0'}">
										<fmt:message key="summary.button.label" />
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
					<td style="font-weight:bold;color: black;">Tax Payable
					<td>
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
								<c:if test="${BalTaxPayable > 0}">
								<span style="padding-left:20px"><a href="https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp">Pay Tax Now</a></span>
							</c:if>
						</span>
					</td>
				</tr>
				</c:when>
				<c:when test="${BalTaxPayable eq 0}">
				<tr class="success">
					<td style="font-weight:bold;color: black;">Tax
					<td>
						<span class="decimal">
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr class="success">
					<td style="font-weight:bold;color: black;">Tax Refundable
					<td>
						<span class="decimal">
							<fmt:formatNumber value="${BalTaxPayable}" type="CURRENCY" currencySymbol="${currencySymbol}" maxFractionDigits="2" minFractionDigits="2" minIntegerDigits="1"></fmt:formatNumber>
						</span>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
		</table>		
      </div>
    </div>