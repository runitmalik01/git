

<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<w4india:itrmenu></w4india:itrmenu>
<label class="radio inline"> <input type="radio"
	name="optionsRadios" id="showSummary" value="summary"
	<c:if test="${empty show || show == 'summary'}">checked</c:if>>
	Show Summary </label>
<label class="radio inline"> <input type="radio"
	name="optionsRadios" id="showXml" value="xml"
	<c:if test="${show == 'xml'}">checked</c:if>> Show XML </label>
<c:choose>
	<c:when test="${empty show || show == 'summary'}">
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
								<a href="formsixteen.html">
								<fmt:message key="income.form.sixteen" /></a>
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
								<li><a href="salaryincome.html">
								<fmt:message key="income.salary.penson" /></a>
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
									<w4india:inr value="${ theForm.ITR1IncomeDeductions.totalIncomeOfHP}"/>

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
										test="${theForm.ITR1IncomeDeductions.incomeOthSrc eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
									<w4india:inr value="${ theForm.ITR1IncomeDeductions.incomeOthSrc}"/>
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
					<a href="#">
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
					<a href="chapterVIdeductions.html">
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
					<td colspan="1"><a href="#"><fmt:message key="taxable.income"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${ theForm.ITR1IncomeDeductions.totalIncome}"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a href="#"><fmt:message key="income.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totalTaxPayable }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#"><fmt:message key="surcharge.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.surchargeOnTaxPayable}"/>
						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><a href="#"><fmt:message key="education.cess"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.educationCess }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#"><fmt:message key="tax.education.surcharge"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.grossTaxLiability }"/>
						</span>
					</td>
				</tr>
                <tr>
					<td colspan="1"><a href="#"><fmt:message key="relief.section.89"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
								<w4india:inr value="${theForm.ITR1TaxComputation.section89}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="rebates.html">
					<fmt:message key="relief.section.90/91"/></a>
					</td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1">
					<a href="interest.html">
					<fmt:message key="interest.under.section.234abc"/></a>
					</td>
					<td  style="text-align:left">
					<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
								<c:when test="${theForm.ITR1TaxComputation.totalIntrstPay eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:otherwise>
										<c:out value="${theForm.ITR1TaxComputation.totalIntrstPay}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="interest.html">
								<fmt:message key="interest.under.section.234abc"/></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><a href="#"><fmt:message key="total.tax.interest.payable"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totTaxPlusIntrstPay}"/>
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
					<td colspan="1"><a href="#"><fmt:message key="advance.tdssalary.itr1" /></a></td>
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
				<tr>
					<td colspan="1"><a href="#"><fmt:message key="less.prepaid.tax"/></a></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.taxPaid.taxesPaid.totalTaxesPaid}"/>
						</span>
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
								<w4india:inr value="${BalTaxPayable}"/>
						</span>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</table>
		</div>
	</c:when>
	<c:when test="${not empty show || show == 'xml'}">
		<script type="syntaxhighlighter" class="brush: xml">
<![CDATA[
  <c:out value="${xml}" escapeXml="false"/>
]]></script>
		<!-- <a role="button" class="btn orange">Download XML</a> -->
	</c:when>
	<c:otherwise>

	</c:otherwise>
</c:choose>

<%--
<pre class="brush: xml">
 	<c:out value="${xml}" escapeXml="true"/>
</pre>
--%>

<hst:headContribution category="jsExternal">
	<script type="text/javascript" src="<hst:link path="/js/syntaxhighlighter_3.0.83/scripts/shCore.js"/>"></script>
</hst:headContribution>

<hst:headContribution category="jsExternal">
	<script type="text/javascript" src="<hst:link path="/js/syntaxhighlighter_3.0.83/scripts/shBrushXml.js"/>"></script>
</hst:headContribution>

<hst:headContribution category="css">
	<link rel="stylesheet" href='<hst:link path="/js/syntaxhighlighter_3.0.83/styles/shCore.css"/>' type="text/css" />
</hst:headContribution>

<hst:headContribution category="css">
	<link rel="stylesheet" href='<hst:link path="/js/syntaxhighlighter_3.0.83/styles/shThemeDefault.css"/>' type="text/css" />
</hst:headContribution>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			SyntaxHighlighter.all();
			$("#showSummary,#showXml").click(function(){
				window.location.href="${scriptName}?show=" + $(this).val() ;
			});
		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />