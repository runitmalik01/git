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
<form id="frmrebate" action="${actionUrl}" method="post">

<fieldset>
				<legend style="color: black">LESS: REBATE</legend>
<div class="row-fluid show-grid" >
	
		<div class="span4"> <div class="rowlabel">
			<label for="userCountry"><small><fmt:message key="rebate.contry.user.earning" /></small></label></div>
				<div class="rowlabel"><select name="userCountry" id="userCountry">
			<c:forEach var="countries" items="${objTreeMapCountries}">
			<option value="${countries.value}">${countries.value}</option>
			</c:forEach>
			
			</select></div></div>
		<div class="span4"> <div class="rowlabel">
		<label for="incomeForeignCountry"><small><fmt:message key="rebate.contry.total.earning" /></small></label></div>
			<div class="rowlabel"><input id="incomeForeignCountry" name="incomeForeignCountry" maxlength="14" class="numberinput" value="${parentBean.incomeForeignCountry}"/></div>
		</div>
		<div class="span4"> <div class="rowlabel">
			<label for="taxPaidForeignCountry"><small><fmt:message key="rebate.total.tax.paid" /></small></label></div>
			<div class="rowlabel"><input id="taxPaidForeignCountry" name="taxPaidForeignCountry"  maxlength="14" value="${parentBean.taxPaidForeignCountry}"/></div>
		</div></div>
		<div class="row-fluid show-grid" ><div class="span4"> <div class="rowlabel">
			<label for="txttotaltax"><small><fmt:message key="rebate.section90.required" /></small></label></div>
			<div class="rowlabel"><input id="txttotaltax" name="txttotaltax " value="" readonly="readonly" maxlength="14" value="${parentBean.txttotaltax}"/></div>
			</div>
	<div class="span4"> <div class="rowlabel">
			<label for="section91"><small><fmt:message key="rebate.section91.required" /></small></label></div>
			<div class="rowlabel"><input id="section91" name="section91" maxlength="14" value="${parentBean.section91}" /></div>
		</div>
		</div>
</fieldset>
<div class="row-fluid show-grid">
<div class="span4 offset8 decimal">
<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
<input type="submit" class="button orange" value="Save">
</div>
</div>
</form>
		
<res:calc screenCalc="rebatesCalculation" formId="frmrebate"></res:calc>



