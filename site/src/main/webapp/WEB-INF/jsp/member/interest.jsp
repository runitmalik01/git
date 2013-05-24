
 
<%@include file="../includes/tags.jspf" %>
<%@ page import="com.mootly.wcm.beans.*"%>

<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>

<!-- used to set title  -->

<c:set var="interesttitle">
      <fmt:message key="member.interest.title" />
</c:set>
<hippo-gogreen:title title="${interesttitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>

	<h4>Interest under Section 234 A B C</h4>
		<form id="frmdata" action="${actionUrl}" name="frmdata" method="post">
			
		<fieldset>	
				<div class="row-fluid show-grid" >
					<div class="span4">
			            <div class="rowlabel"><label for="section234A"><small> Interest Payable under Section 234 A</small></label></div>
			          	<div class="rowlabel"><input readonly="readonly" id="intA" name="section234A" value=""/></div>
			          </div>
			        <div class="span4">
			            <div class="rowlabel"><label for="section234B"><small>Interest Payable under Section 234 B</small></label></div>
			          	<div class="rowlabel"><input readonly="readonly" id="intB" name="section234B" value=""/></div>
			          </div>
			          </div>
			          <div class="row-fluid show-grid">
			              <div class="span4">
			            <div class="rowlabel"><label for="section234C"><small>Interest Payable under Section 234 C</small></label></div>
			          	<div class="rowlabel"><input  readonly="readonly" id="ic" name="section234C" value=""/></div>
			          </div>
			               <div class="span4">
			            <div class="rowlabel"><label for="section234ABC"><small>Total Interest payable under Sections 234 A, 234 B and 234 C</small></label></div>
			          	<div class="rowlabel"><input readonly="readonly" id="intt" name="section234ABC" value=""/></div>
			          </div>
			          </div>
			</fieldset>
				
		<fieldset>	       		
				<table><tr>
					<td><label>A.1 Due Date for filing of Income Tax Return</label></td>
					<td><select id="ddate" onchange="int234();">
					    <option value="19" selected="selected">31st July 2014</option>
					    </select>
					</td>
				</tr>
				<tr>
					<td><label>A.2 Enter Total Tax Liability for the Assessment Year</label></td>
					<td><input id="aytaxd" onchange="int234();" value=""/></td>
				</tr>
				<tr>
					<td><label>A.3 Enter Income Tax paid upto 31st March 2014</label></td>
					<td><input readonly="readonly" id="aytaxp" onchange="int234();" value="${totaltax}"/></td>
				</tr>
				<tr>
					<td><label>A.4 Amount of shortfall in tax payment upto 31st March 2014</label></td>
					<td><input readonly="readonly" id="aysfall" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>A.5 Month of Payment of Shortfall</label></td>
					<td>
					<select id="aytaxmp" onchange="int234();">
					    <option value="${intmonth}" selected="selected">${strmonth}</option>
					</select>   
					</td>
				</tr>
				</table>				
			</fieldset>	
			<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 A</legend>		
		        <table>		
				<tr>
					<td><label>B.1 Number of months for which interest is payable on shortfall amount @ 1% per month</label></td>
					<td><input readonly="readonly" id="dateA" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>B.2 Interest Payable under Section 234 A</label></td>
					<td><input readonly="readonly" id="intA" name="section234A" value=""/></td>
				</tr>
				</table>
				</fieldset>
				<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 B</legend>	
		        <table>			
				<tr>
					<td><label>C.1 Number of months for which interest is payable on shortfall amount @ 1% per month</label></td>
					<td><input readonly="readonly" id="dateB" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>C.2 Interest Payable under Section 234 B</label></td>
					<td><input readonly="readonly" id="intB" name="section234B" value=""/></td>
				</tr>
				</table>
				</fieldset>
				<fieldset>
		        <legend>Calculation of Interest Payable Under Section 234 C</legend>
		        <table>				
				<tr>
					<td><label>D.1 Advance Tax Payable upto 15th September 2013 (At least 30% of Total Tax Liability)</label></td>
					<td><input readonly="readonly" id="atdq2"/></td>
				</tr>
				<tr>
					<td><label>D.2 Income Tax deductible / collectible at source on income included in D.1 above</label></td>
					<td><input id="atlq2" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>D.3 Income Tax paid upto 15th September 2013</label></td>
					<td><input readonly="readonly" id="atpq2" onchange="int234();" value="${dsum12}"/></td>
				</tr>
				<tr>
					<td><label>D.4 Shortfall in Advance Tax payment</label></td>
					<td><input readonly="readonly" id="atsfq2"/></td>
				</tr>
				<tr>
					<td><label>D.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input readonly="readonly" id="atiq2"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>E.1 Advance Tax Payable upto 15th December 2013 (At least 60% of Total Tax Liability)</label></td>
					<td><input readonly="readonly" id="atdq3"/></td>
				</tr>
				<tr>
					<td><label>E.2 Income Tax deductible / collectible at source on income included in E.1 above</label></td>
					<td><input id="atlq3" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>E.3 Income Tax paid upto 15th December 2013</label></td>
					<td><input readonly="readonly" id="atpq3" onchange="int234();" value="${dsum3}"/></td>
				</tr>
				<tr>
					<td><label>E.4 Shortfall in Advance Tax payment</label></td>
					<td><input readonly="readonly" id="atsfq3"/></td>
				</tr>
				<tr>
					<td><label>E.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input readonly="readonly" id="atiq3"/></td>
				</tr>
					<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>F.1 Advance Tax Payable upto 15th March 2014 (100% of Total Tax Liability)</label></td>
					<td><input readonly="readonly" id="atdq4"/></td>
				</tr>
				<tr>
					<td><label>F.2 Income Tax deductible / collectible at source on income included in F.1 above</label></td>
					<td><input id="atlq4" onchange="int234();"/></td>
				</tr>
				<tr>
					<td><label>F.3 Income Tax paid upto 15th March 2014</label></td>
					<td><input readonly="readonly" id="atpq4" onchange="int234();" value="${dsum4}"/></td>
				</tr>
				<tr>
					<td><label>F.4 Shortfall in Advance Tax payment</label></td>
					<td><input readonly="readonly" id="atsfq4"/></td>
				</tr>
				<tr>
					<td><label>F.5 Interest Payable under Section 234 C <br/>(1% per month for 3 months on shortfall, if Total Tax Liability is more than Rs. 10,000/-)</label></td>
					<td><input readonly="readonly" id="atiq4"/></td>
				</tr>
					<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>Total Interest payable under Section 234 C</label></td>
					<td><input readonly="readonly" id="ic" name="section234C" value=""/></td>
				</tr>
				<tr>
					<td><label>Total Interest payable under Sections 234 A, 234 B and 234 C</label></td>
					<td><input readonly="readonly" id="intt" name="section234ABC" value=""/></td>
				</tr>
				<tr><td></td><td align="right"><input type="submit" id="submit" class="button olive" onclick="save()" value="Save"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${modifiedSiteMapRefId}" onClick="save()" class="button orange">Next</a></td>
				</table>
				
				</fieldset>
		</form>

<!-- used for interest calculation -->
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

<hst:headContribution category="jsExternal">
	<script type="text/javascript" src="<hst:link path="/js/interestcalculation/intt234.js"/>"></script>
</hst:headContribution>

<!-- used to submit the form -->				
<script>
function save(){
			$("#frmdata").submit();
}
</script>
				