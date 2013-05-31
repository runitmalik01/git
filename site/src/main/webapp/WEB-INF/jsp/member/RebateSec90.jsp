<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>



<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<hst:link var="mainSiteMapRefId"
	siteMapItemRefId="${mainSiteMapItemRefId}" />
<% 

ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap objTreeMapCountries = (TreeMap) objValueListService.getDtaaCountries();
request.setAttribute("objTreeMapCountries", objTreeMapCountries);


%>


<hst:actionURL var="actionUrl" />
<div align="center" >


		<b>LESS: REBATE</b>
</div>
<form id="frmrebate" action="${actionUrl}" method="post">
<div class="yui3-bd" align="center">
	<table>
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.contry.user.earning" /></td>
			<td class="input">
			<select name="userCountry" id="userCountry">
			<c:forEach var="countries" items="${objTreeMapCountries}">
			<option value="${countries.value}">${countries.value}</option>
			</c:forEach>
			
			</select>
				
				</td>
				
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.contry.total.earning" /></td>
			<td class="input"><input id="incomeForeignCountry" name="incomeForeignCountry" 
					 maxlength="14" class="numberinput" /></td>
		</tr>
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.total.tax.paid" /></td>
			<td class="input"><input id="taxPaidForeignCountry"
				name="taxPaidForeignCountry"  maxlength="14"
				 /></td>
		</tr>
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.section90.required" /></td>
			<td class="input"><input id="txttotaltax" name="txttotaltax " value="" readonly="readonly"
				maxlength="14"  /></td>
		</tr>
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.section91.required" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="input"><input id="section91" name="section91" 
				maxlength="14"  /></td>
		</tr>
		
		
			</table>
</div>
<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
<input type="submit" class="button orange" value="Save">
</form>
		
<res:calc screenCalc="rebatesCalculation" formId="frmrebate"></res:calc>



