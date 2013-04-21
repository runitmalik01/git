
 
<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<script type="text/javascript">

function $(){
	
	var elements=new Array();
	for (var i=0;i<arguments.length;i++){
		var element=arguments[i];
		if(typeof element== 'string')
			element=document.getElementById(element);
		if(arguments.length==1) 
			return element;
		}
	return elements;
	}

</script>

<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
 String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("interest.html","taxsummary.html");
 pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
 pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>

<!-- used to set title  -->

<c:set var="interesttitle">
      <fmt:message key="member.interest.title" />
</c:set>
<hippo-gogreen:title title="${interesttitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">Home</a></span> 
	<span class="chevron">&#187;</span> 
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My Income Tax Returns</a></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><c:out value="${pan}"/></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><select style="width:120px"><option>Interest</option><option>a</option><option>a</option></select></span>
</div>


<div class="page type-page">
	<h3 id="respond1">Calculator - Interest u/s 234 A B C - Individuals</h3>
		<form id="frmdata" action="${actionUrl}" name="frmdata" method="post">
		
		<fieldset>
		        <legend>Enter data in shaded boxes</legend>				
				<table><tr>
					<td><label>A.1 Select Due Date for filing of Income Tax Return</label></td>
					<td><select id="ddate" onchange="int234();"><option value="7" selected="selected">31st July 2013<option value="9">30th Sept. 2013</select></td>
				</tr>
				<tr>
					<td><label>A.2 Enter Total Tax Liability for the Assessment Year</label></td>
					<td><input id="aytaxd" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>A.3 Enter Income Tax paid upto 31st March 2013</label></td>
					<td><input id="aytaxp" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>A.4 Amount of shortfall in tax payment upto 31st March 2013</label></td>
					<td><input id="aysfall" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>A.5 Month of Payment of Shortfall</label></td>
					<td><select id="aytaxmp" class="ip" onchange="int234();">
					    <option value="3" selected="selected">Before March 2013<option value="4">April 2013<option value="5">May 2013<option value="6">June 2013<option value="7">July 2013<option value="8">August 2013<option value="9">September 2013<option value="10"> October 2013<option value="11">November 2013<option value="12">December 2013<option value="13">January 2013<option value="14">February 2013<option value="15">March 2013</select></td>
				</tr>
				</table>				
			</fieldset>	
			<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 A</legend>		
		        <table>		
				<tr>
					<td><label>B.1 Number of months for which interest is payable on shortfall amount @ 1% per month</label></td>
					<td><input id="dateA" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>B.2 Interest Payable under Section 234 A</label></td>
					<td><input id="intA" name="section234A" value="${parentBean.section234A}"/></td>
				</tr>
				</table>
				</fieldset>
				<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 B</legend>	
		        <table>			
				<tr>
					<td><label>C.1 Number of months for which interest is payable on shortfall amount @ 1% per month</label></td>
					<td><input id="dateB" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>C.2 Interest Payable under Section 234 B</label></td>
					<td><input id="intB" name="section234B" value="${parentBean.section234B}"/></td>
				</tr>
				</table>
				</fieldset>
				<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 C</legend>
		        <table>				
				<tr>
					<td><label>D.1 Advance Tax Payable upto 15th September 2012 (At least 30% of Total Tax Liability)</label></td>
					<td><input id="atdq2"/></td>
				</tr>
				<tr>
					<td><label>D.2 Income Tax deductible / collectible at source on income included in D.1 above</label></td>
					<td><input id="atlq2" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>D.3 Income Tax paid upto 15th September 2012</label></td>
					<td><input id="atpq2" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>D.4 Shortfall in Advance Tax payment</label></td>
					<td><input id="atsfq2"/></td>
				</tr>
				<tr>
					<td><label>D.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input id="atiq2"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>E.1 Advance Tax Payable upto 15th December 2012 (At least 60% of Total Tax Liability)</label></td>
					<td><input id="atdq3"/></td>
				</tr>
				<tr>
					<td><label>E.2 Income Tax deductible / collectible at source on income included in E.1 above</label></td>
					<td><input id="atlq3" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>E.3 Income Tax paid upto 15th December 2012</label></td>
					<td><input id="atpq3" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>E.4 Shortfall in Advance Tax payment</label></td>
					<td><input id="atsfq3"/></td>
				</tr>
				<tr>
					<td><label>E.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input id="atiq3"/></td>
				</tr>
					<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>F.1 Advance Tax Payable upto 15th March 2013 (100% of Total Tax Liability)</label></td>
					<td><input id="atdq4"/></td>
				</tr>
				<tr>
					<td><label>F.2 Income Tax deductible / collectible at source on income included in F.1 above</label></td>
					<td><input id="atlq4" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>F.3 Income Tax paid upto 15th March 2013</label></td>
					<td><input id="atpq4" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>F.4 Shortfall in Advance Tax payment</label></td>
					<td><input id="atsfq4"/></td>
				</tr>
				<tr>
					<td><label>F.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input id="atiq4"/></td>
				</tr>
					<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>Total Interest payable under Section 234 C</label></td>
					<td><input id="ic" name="section234C" value="${parentBean.section234C}"/></td>
				</tr>
				<tr>
					<td><label>Total Interest payable under Sections 234 A, 234 B and 234 C</label></td>
					<td><input id="intt"/></td>
				</tr>
				<tr><td align="right"><input type="submit" id="submit" class="button olive" onclick="save()" value="Save"/></td><td align="right"><button type="reset">Reset</button></td>
				</table>
				</fieldset>
		</form>
</div>
				
<script>
function save(){
			$("#frmdata").submit();
}
</script>				