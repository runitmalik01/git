

<%@include file="../includes/tags.jspf"%>

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
					<th>Income Head</th>
					<th>Total Amount</th>
				</tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td colspan="1">Salary Income</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
								<c:when test="${theForm.ITR1IncomeDeductions.incomeFromSal eq'0'}">
								<c:out value="Fill Now" />
								</c:when>
									<c:when
										test="${not empty theForm.ITR1IncomeDeductions.incomeFromSal}">
										<c:out value="${ theForm.ITR1IncomeDeductions.incomeFromSal}" />
									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="<c:out value="${scriptName}"/>?tab=formsixteen"><fmt:message
											key="income.salary.penson" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">House Property</td>
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
										<c:out
											value="${ theForm.ITR1IncomeDeductions.totalIncomeOfHP}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="<c:out value="${scriptName}"/>?tab=houseincome"><fmt:message
											key="income.house.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Income From Other Sources</td>
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
										<c:out value="${ theForm.ITR1IncomeDeductions.incomeOthSrc}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="<c:out value="${scriptName}"/>?tab=incomeothersources"><fmt:message
											key="income.other.sources" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Gross Total Income</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when
										test="${theForm.ITR1IncomeDeductions.grossTotIncome eq '0'}">
										<c:out value="Not Calculated" />
									</c:when>
									<c:otherwise>
										<c:out value="${ theForm.ITR1IncomeDeductions.grossTotIncome}" />
									</c:otherwise>
								</c:choose>

							</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Less: Deduction Under Chapter 6A</td>
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
										<c:out
											value="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}" />
									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="<c:out value="${scriptName}"/>?tab=deductions"><fmt:message
											key="deductions.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Taxable Income</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when
										test="${ theForm.ITR1IncomeDeductions.totalIncome eq '0'}">
										<c:out value="Not Calculated" />
									</c:when>
									<c:otherwise>
										<c:out value="${ theForm.ITR1IncomeDeductions.totalIncome}" />
									</c:otherwise>
								</c:choose>

							</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Income Tax</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Normal Tax</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Special Tax</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Surcharge</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Education Cess</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Tax including Surcharge & Education Cess</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Less:prepaid Tax</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Advance Tax</td>
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
										<c:out value="${ theForm.taxPaid.taxesPaid.advanceTax}" />
									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="<c:out value="${scriptName}"/>?tab=advancetax"><fmt:message
											key="advance.tax.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">Self Assesment Tax</td>
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
										<c:out value="${theForm.taxPaid.taxesPaid.selfAssessmentTax}" />
									</c:when>
									<c:otherwise>
										<c:out value="Fill Now" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="<c:out value="${scriptName}"/>?tab=selfassesmenttax"><fmt:message key="advance.selfassesmenttax.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">TDS From Salary</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${bigTotalTdsSalary eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<c:out value="${bigTotalTdsSalary}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="<c:out value="${scriptName}"/>?tab=tdsfromsalary"><fmt:message
											key="advance.tdssalary.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1">TDS From Others</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">
								<c:choose>
									<c:when test="${bigTotalTdsOther eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<c:out value="${bigTotalTdsOther}" />
									</c:otherwise>
								</c:choose>
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="<c:out value="${scriptName}"/>?tab=tdsfromothers"><fmt:message
											key="advance.tdsothers.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
				<tr class="success">
					<td colspan="1"><b>Tax Payable/Refund </b>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">Not Calculated</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</c:when>
	<c:when test="${not empty show || show == 'xml'}">
		<script type="syntaxhighlighter" class="brush: xml">
<![CDATA[
  <c:out value="${xml}" escapeXml="false"/>
]]></script>
		<a role="button" class="btn orange">Download XML</a>
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
	<link rel="stylesheet" href='<hst:link path="/js/syntaxhighlighter_3.0.83/styles/shCore.css.css"/>' type="text/css" />
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
