<%@include file="../includes/tags.jspf" %>

<label class="radio inline">
  <input type="radio" name="optionsRadios" id="showSummary" value="summary" <c:if test="${empty show || show == 'summary'}">checked</c:if>>
  Show Summary
</label>
<label class="radio inline">
  <input type="radio" name="optionsRadios" id="showXml" value="xml" <c:if test="${show == 'xml'}">checked</c:if>>
  Show XML
</label>
<c:choose>
	<c:when test="${empty show || show == 'summary'}">
		<pre>
			<c:out value="${theForm.personalInfo.assesseeName.firstName}"/>
			<c:out value="${theForm.personalInfo.assesseeName.surNameOrOrgName}"/>
			<fieldset>
			<table class="calculation of income" border="1" width="500">
				<tr align="left">
					<th><b>Income Head</b>
					</th>
					<th><b>Amount</b>
					</th>
					<th><b>Total Amount</b>
					</th>
				</tr>
				<tr align="left">
					<td><b>Gross Salary</b>
					</td>
					<td></td>
					<td align="right"><c:out value="${theForm.ITR1IncomeDeductions.incomeFromSal}"/></td>
				</tr>
				<tr align="left">
					<td><b>House Property</b>
					</td>
					<td></td>
					<td align="right"><c:out value="${theForm.ITR1IncomeDeductions.totalIncomeOfHP}"/></td>
				</tr>
				
				<tr align="left">
					<td><b>Income From Other Sources</b>
					</td>
					<td></td>
					<td align="right"><c:out value="${theForm.ITR1IncomeDeductions.incomeOthSrc}"/></td>
				</tr>
				
				<tr align="left">
					<td><b>Gross Total Income</b>
					</td>
					<td></td>
					<td align="right"><c:out value="${theForm.ITR1IncomeDeductions.grossTotIncome}"/></td>
				</tr>
					<tr align="left">
					<td><b>Total Income</b>
					</td>
					<td></td>
					<td align ="right"><c:out value="${theForm.ITR1IncomeDeductions.totalIncome}"/></td>
				</tr>
				<tr align="left">
					<td><b>Less: Deduction Under Chapter 6A</b>
					</td>
					<td></td>
					<td align="right"><c:out value="${theForm.ITR1IncomeDeductions.deductUndChapVIA.totalChapVIADeductions}"/></td>
				</tr>
				<tr align="left">
					<td><b>Taxable Income</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Taxable")%></td>
				</tr>
				<tr align="left">
					<td><b>Income Tax</b>
					</td>
					<td align="right"><%=request.getAttribute("Incometax")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Normal Tax</b>
					</td>
					<td align="right"><%=request.getAttribute("Normaltax")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Special Tax</b>
					</td>
					<td align="right"><%=request.getAttribute("Specialtax")%></td>
					<td></td>
				</tr>
			
				<tr align="left">
					<td><b>Surcharge</b>
					</td>
					<td align="right"><%=request.getAttribute("Surcharge")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Education Cess </b>
					</td>
					<td align="right"><%=request.getAttribute("EduCess")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Tax including Surcharge & Education Cess </b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("IncomeTaxEduCess")%></td>
				</tr>
			
				<tr align="left">
					<td><b>Less:prepaid Tax</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Lessprepaidtax")%></td>
				</tr>
				<tr align="left">
					<td>Advance/ Self assesment tax
					</td>
					<td align="right"><c:out value="${theForm.taxPaid.taxesPaid.advanceTax}"/></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>TDS</td>
					<td align="right"><c:out value="${theForm.taxPaid.taxesPaid.TDS}"/></td>
					<td></td>
				</tr>
				
				<tr align="left">
					<td><b>Tax Payable/Refund</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("tax_payable")%></td>
				</tr>

			</table>
		</fieldset>			
	</pre>
	
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

<link href="http://alexgorbatchev.com/pub/sh/current/styles/shThemeDefault.css" rel="stylesheet" type="text/css" />
<script src="http://alexgorbatchev.com/pub/sh/current/scripts/shCore.js" type="text/javascript"></script>
<script src="http://alexgorbatchev.com/pub/sh/current/scripts/shAutoloader.js" type="text/javascript"></script>

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

<hst:headContribution element="${shCore}" category="css"/>
<hst:headContribution element="${shThemeDefault}" category="css"/>
<hst:headContribution element="${shCore}" category="jsInternal"/>
<hst:headContribution element="${shAutoLoader}" category="jsInternal"/>
<hst:headContribution element="${shBrushXml}" category="jsInternal"/>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			SyntaxHighlighter.all();
			$("#showSummary,#showXml").click(function(){
				window.location.href="${scriptName}?show=" + $(this).val() ;
			});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>