<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<hst:link var="mainSiteMapRefId"
	siteMapItemRefId="${mainSiteMapItemRefId}" />
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan).replaceAll("","");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}

ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap objTreeMapCountries = (TreeMap) objValueListService.getDtaaCountries();
request.setAttribute("objTreeMapCountries", objTreeMapCountries);


%>


<hst:actionURL var="actionUrl" />
<div align="center" >
	<form id="frmrebate" action="${actionUrl}" method="post">

		<b>LESS: REBATE</b>
</div>

<div class="yui3-bd" align="center">
	<table>
		<tr height="30px">
			<td class="label">select country</td>
			<td class="input"><input type="text" name="userCountry"
				value="${parentBean.userCountry}"/>
				</td>
		<tr height="30px">
			<td class="label">income earned form others
				country</td>
			<td class="input"><input type="text" name="incomeForeignCountry" 
					value="${parentBean.incomeForeignCountry }" maxlength="14" class="numberinput" /></td>
		</tr>
		<tr height="30px">
			<td class="label">Tax paid in foreign
				country</td>
			<td class="input"><input type="text"
				name="taxPaidForeignCountry"  maxlength="14"
				value="${parentBean.taxPaidForeignCountry }"
				class="numberinput" /></td>
		</tr>
		
		
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.section90.required" /></td>
			<td class="input"><input type="text" name="section_90" value="${relief}"
				maxlength="14" readonly /></td>
		</tr>
		<tr height="30px">
			<td class="label"><fmt:message key="rebate.section91.required" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td class="input"><input type="text" name="section_91" value="Not Applicable"
				maxlength="14" readonly /></td>
		</tr>
		
		
			</table>
</div>
<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
<input type="submit" class="button orange" value="Save">
</form>
		




