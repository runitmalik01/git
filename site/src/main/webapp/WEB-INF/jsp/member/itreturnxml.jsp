

<%@page import="com.mootly.wcm.model.ITRTab"%>
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
					<th><fmt:message key="income.head"/></th>
					<th><fmt:message key="total.amount"/></th>
				</tr>
				<!--  lets create a bookmark for each section -->
				<tr>
					<td colspan="1"><fmt:message key="salary.income"/></td>
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
								<li><a
									href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.FORM16_SINGLE%>"><fmt:message
											key="income.form.sixteen" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="income.salary.penson"/></td>
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
								<li><a
									href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.INCOME_SALARY_PENSION%>"><fmt:message
											key="income.salary.penson" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="income.house.itr1" /></td>
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
								<li><a
									href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.INCOME_HOUSE_PROPERTY_SINGLE%>"><fmt:message key="income.house.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="income.other.sources" /></td>
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
								<li><a
									href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.INCOME_OTHER_SOURCE%>"><fmt:message key="income.other.sources" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="gross.total.income"/></td>
					<td  style="text-align:left">
						<span class="decimal">

									<w4india:inr value="${theForm.ITR1IncomeDeductions.grossTotIncome}"/>

						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="deduction.under.6a"/></td>
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
								<li><a href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.DEDUCTIONS%>"><fmt:message
											key="deductions.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="taxable.income"/></td>
					<td  style="text-align:left">
						<span class="decimal">

									<w4india:inr value="${ theForm.ITR1IncomeDeductions.totalIncome}"/>

						</span>
					</td>
				</tr>
				<tr>
				<td colspan="1"><fmt:message key="income.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totalTaxPayable }"/>
						</span>
					</td>
				</tr>
				<!--
				<tr>
					<td colspan="1"><fmt:message key="income.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.totalTaxPayable}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="normal.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="special.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="surcharge.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.surchargeOnTaxPayable}"/>
						</span>
					</td>
				</tr>
				-->
				<tr>
				<td colspan="1"><fmt:message key="education.cess"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.educationCess }"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="tax.education.surcharge"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.grossTaxLiability }"/>
						</span>
					</td>
				</tr>

				<tr>
					<td colspan="1"><fmt:message key="advance.tax.itr1" /></td>
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
								<li><a href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.TAX_ADVANCE%>"><fmt:message key="advance.tax.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="advance.selfassesmenttax.itr1" /></td>
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
								<li><a href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.TAX_SELF_ASSESSMENT%>">
								<fmt:message key="advance.selfassesmenttax.itr1" /></a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="advance.tdssalary.itr1" /></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${bigTotalTdsSalary}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="advance.tdsothers.itr1" /></td>
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
								<li><a
									href="<c:out value="${scriptName}"/>?selectedItrTab=<%=ITRTab.TAX_TDS_OTHERS%>">
									<fmt:message key="advance.tdsothers.itr1" /> </a></li>
							</ul>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="less.prepaid.tax"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.taxPaid.balTaxPayable}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="net.tax.liability"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="${theForm.ITR1TaxComputation.netTaxLiability}"/>
						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="relief.section.89"/></td>
					<td  style="text-align:left">
						<span class="decimal">

								<w4india:inr value="${theForm.ITR1TaxComputation.section89}"/>

						</span>
					</td>
				</tr>
				<tr>
					<td colspan="1"><fmt:message key="relief.section.90/91"/></td>
					<td  style="text-align:left">
						<span class="decimal">
									<w4india:inr value="0"/>
						</span>
					</td>
				</tr>

				<tr>
					<td colspan="1"><fmt:message key="interest.under.section.234abc"/></td>
					<td  style="text-align:left">
						<span class="decimal">
						<w4india:inr value="${theForm.ITR1TaxComputation.totalIntrstPay}"/>
						<!--
						<c:choose>
							<c:when test="${theForm.ITR1TaxComputation.totalIntrstPay eq '0'}">
								<a href="#myModalInterest" id="clickInterest" role="button" class="btn" data-toggle="modal" >
								<c:out value="Calculate Interest" /></a>
							</c:when>
							<c:otherwise>
								<w4india:inr value="${theForm.ITR1TaxComputation.totalIntrstPay}"/>
							</c:otherwise>
						</c:choose>
						 -->
						</span>
					</td>
				</tr>

				<tr class="success">
					<td colspan="1"><b><fmt:message key="tax.payble.refund"/></b>
					<td  style="text-align:left">
						<span class="decimal">

								<w4india:inr value="${theForm.taxPaid.balTaxPayable}"/>

						</span>
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
