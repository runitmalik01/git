

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
					<td colspan="1">Gross Salary</td>
					<td>
						<div class="btn-group" class="decimal">
							<button class="btn btn-small dropdown-toggle"
								data-toggle="dropdown">

								<c:choose>
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
									href="<c:out value="${scriptName}"/>?tab=salaryincome"><fmt:message
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
									<c:when
										test="${not empty theForm.taxPaid.taxesPaid.selfAssessmentTax}">
										<c:out value="${theForm.taxPaid.taxesPaid.selfAssessmentTax}" />
									</c:when>
									<c:otherwise>
										<c:out value="Not Filled" />
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
									<c:when test="${ theForm.taxPaid.taxesPaid.TDS eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<c:out value="${ theForm.taxPaid.taxesPaid.TDS}" />
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
									<c:when test="${ theForm.taxPaid.taxesPaid.TDS eq '0'}">
										<c:out value="Fill Now" />
									</c:when>
									<c:otherwise>
										<c:out value="${ theForm.taxPaid.taxesPaid.TDS}" />
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

<link
	href="http://alexgorbatchev.com/pub/sh/current/styles/shThemeDefault.css"
	rel="stylesheet" type="text/css" />
<script src="http://alexgorbatchev.com/pub/sh/current/scripts/shCore.js"
	type="text/javascript"></script>
<script
	src="http://alexgorbatchev.com/pub/sh/current/scripts/shAutoloader.js"
	type="text/javascript"></script>

<hst:element var="shThemeCore" name="link">
	<hst:attribute name="rel">stylesheet</hst:attribute>
	<hst:attribute name="type">text/css</hst:attribute>
	<hst:attribute name="href">http://alexgorbatchev.com/pub/sh/current/styles/shCore.css.css</hst:attribute>
</hst:element>

<hst:element var="shThemeDefault" name="link">
	<hst:attribute name="rel">stylesheet</hst:attribute>
	<hst:attribute name="type">text/css</hst:attribute>
	<hst:attribute name="href">http://alexgorbatchev.com/pub/sh/current/styles/shThemeDefault.css</hst:attribute>
</hst:element>

<hst:element var="shCore" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shCore.js</hst:attribute>
</hst:element>

<hst:element var="shAutoLoader" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shAutoloader.js</hst:attribute>
</hst:element>
<hst:element var="shBrushXml" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<hst:attribute name="src">http://alexgorbatchev.com/pub/sh/current/scripts/shBrushXml.js</hst:attribute>
</hst:element>

<hst:headContribution element="${shCore}" category="css" />
<hst:headContribution element="${shThemeDefault}" category="css" />
<hst:headContribution element="${shCore}" category="jsInternal" />
<hst:headContribution element="${shAutoLoader}" category="jsInternal" />
<hst:headContribution element="${shBrushXml}" category="jsInternal" />

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
