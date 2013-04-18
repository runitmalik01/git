
<%--

Here we are calculating salary income
@author abhishek	
05/03/2013

 --%>

<%@page import="com.mootly.wcm.beans.compound.SalaryIncomeDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="calculationtitle">
	<fmt:message key="member.calculation.title" />
</c:set>
<hippo-gogreen:title title="${calculationtitle}" />
<div id="breadcrumbs">
	<fmt:message key="member.location.label" />
	&nbsp;

	<hst:link var="home" siteMapItemRefId="home" />
	<a href="${home}"><fmt:message key="products.detail.location.home" />
	</a>&gt;

	<hst:link var="startapplication"
		siteMapItemRefId="member-personal-information"></hst:link>
	<a href="${startapplication}"><fmt:message
			key="member.start.application" /> </a>&gt;

	<hst:link var="memberothersources"
		siteMapItemRefId="member-other-income"></hst:link>
	<a href="${memberothersources}"><fmt:message
			key="member.other.income" /> </a>
	<hst:link var="calculation" siteMapItemRefId="calculation"></hst:link>
		<a href="${calculation}"><fmt:message
				key="member.start.calculation" /> </a>
</div>
<hst:link var="mainSiteMapRefId"
	siteMapItemRefId="${mainSiteMapItemRefId}" />
<%
	String varToReplace = (String) pageContext
			.getAttribute("mainSiteMapRefId");
	if (varToReplace != null) {
		String pan = (String) request.getAttribute("pan");
		String modifiedSiteMapRefId = varToReplace.replaceAll(
				"_default_", pan).replaceAll("contactinformation",
				"residetialstatus");
		pageContext.setAttribute("modifiedSiteMapRefId",
				modifiedSiteMapRefId);
	} else {
		pageContext.setAttribute("modifiedSiteMapRefId",
				mainSiteMapRefId);
	}
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="calculationfrm" action="${actionUrl}" name="calculationfrm"
	method="post">
	<input type="hidden" name="screenMode" id="screenMode" value="CREATE" />
			<fieldset>
			<legend style="color: blue" align="left">Calculation Summary From all Head</legend>
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
					<td align="right"><%=request.getAttribute("GROSS_SALARY")%></td>
				</tr>
				<tr align="left">
					<td><b>House Property</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("HouseProperty")%></td>
				</tr>
				<tr align="left">
					<td><b>Capital Asset</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("CAPITALGAIN")%></td>
				</tr>
				<tr align="left">
					<td><b>Securities</b>
					</td>
					<td align="right"><%=request.getAttribute("Security")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Income From Other Sources</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("TAXABLE_INCOME")%></td>
				</tr>
				<tr align="left">
					<td><b>Total</b>
					</td>
					<td></td>
					<td align ="right"><%=request.getAttribute("Total")%></td>
				</tr>
				<tr align="left">
					<td><b>Less: Adjustment Of Losses</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Losses")%></td>
				</tr>
				<tr align="left">
					<td><b>Gross Total Income</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("GrossTotal")%></td>
				</tr>
				<tr align="left">
					<td><b>Less: Deduction Under Chapter 6A</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("DEDUCTION")%></td>
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
					<td><b>Tax after Rebate U/S 88E</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Incometax")%></td>
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
					<td><b>Less:Rebate</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("LesssRebate")%></td>
				</tr>
				<tr align="left">
					<td>Rebate under section 89</td>
					<td align="right"><%=request.getAttribute("Rebate89")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>Rebate under section 90</td>
					<td align="right"><%=request.getAttribute("Rebate90_91")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>Rebate under section 91</td>
					<td align="right"><%=request.getAttribute("Rebate90_91")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Tax after rebate under section 90/91</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Taxafterrebate")%></td>
				</tr>
				<tr align="left">
					<td><b>Add: Interest under section 234A/234B/234C</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("Interest")%></td>
				</tr>
				<tr align="left">
					<td>Interest under section 234A</td>
					<td align="right"><c:out value="${ objInterestDocument.section234A}"/></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>Interest under section 234B</td>
					<td align="right"><c:out value="${ objInterestDocument.section234B}"/></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>Interest under section 234C</td>
					<td align="right"><c:out value="${ objInterestDocument.section234C}"/></td>
					<td></td>
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
					<td align="right"><%=request.getAttribute("Selfasses")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>TDS Salary</td>
					<td align="right"><%=request.getAttribute("TdsSalary")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>TDS</td>
					<td align="right"><%=request.getAttribute("TdsOther")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td>TCS</td>
					<td align="right"><%=request.getAttribute("TAXCOLLECTED")%></td>
					<td></td>
				</tr>
				<tr align="left">
					<td><b>Tax Payable/Refund</b>
					</td>
					<td></td>
					<td align="right"><%=request.getAttribute("tax_payable")%></td>
				</tr>

			</table>
			<p align="center">
				<input name="button" type="button" value="Next"
					onclick="nextScreen()" />
			</p>
			</fieldset>
</form>


<script>
    
    function nextScreen()
    {
			alert("nextScreen");
			
			document.forms['calculationfrm'].elements["screenMode"].value = "NEXTSCREEN";
document.getElementById('calculationfrm').submit();	 	
   }
    
    
</script>