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
<div class="page type-page">
	<w4india:itrmenu/>
<form id="frmrebate" action="${actionUrl}" method="post">
	<fieldset>
				<legend style="color: black">Section 89</legend>
				<div class="row-fluid show-grid" >
	         <div class="span6">
	          <div class="rowlabel">
			<label for="section89"><small><fmt:message key="rebate.section89.required" /></small></label></div>
			<div class="rowlabel"><input type="text" id="section89" name="section89"   maxlength="14"  value="${parentBean.section89}" /></div>
		</div>
		</div>
</fieldset>

<fieldset>
				<legend style="color: black">Section 90</legend>
<div class="row-fluid show-grid" >

		<div class="span4">
		<div class="rowlabel">
			<label for="userCountry"><small><fmt:message key="rebate.contry.user.earning" /></small></label></div>
				<div class="rowlabel"><select name="userCountry" id="userCountry">
				<option value="" selected>Select</option>
			<c:forEach var="countries" items="${objTreeMapCountries}">
			<option value="${countries.value}">${countries.value}</option>
			</c:forEach>

			</select></div></div>
		<div class="span4">
		<div class="rowlabel">
		<label for="incomeForeignCountry"><small><fmt:message key="rebate.contry.total.earning" /></small></label></div>
			<div class="rowlabel"><input type="text" id="incomeForeignCountry" name="incomeForeignCountry" maxlength="14" class="numberinput" value="${parentBean.incomeForeignCountry}"/></div>
		</div>
		<div class="span4">
		 <div class="rowlabel">
			<label for="taxPaidForeignCountry"><small><fmt:message key="rebate.total.tax.paid" /></small></label></div>
			<div class="rowlabel"><input type="text" id="taxPaidForeignCountry" name="taxPaidForeignCountry"  maxlength="14" value="${parentBean.taxPaidForeignCountry}"/></div>
		</div></div>
		<div class="row-fluid show-grid" >
		   <div class="span6">
		   <div class="rowlabel">
			<label for="txttotaltax"><small><fmt:message key="rebate.section90.required" /></small></label></div>
			<div class="rowlabel"><input type="text" id="txttotaltax" name="txttotaltax"  maxlength="14" value="${parentBean.section90}"/></div>
			</div>
			</div>
			</fieldset>
			<fieldset>
				<legend style="color: black">Section 91</legend>
				<div class="row-fluid show-grid" >
	         <div class="span6">
	          <div class="rowlabel">
			<label for="section91"><small><fmt:message key="rebate.section91.required" /></small></label></div>
			<div class="rowlabel"><input type="text" id="section91" name="section91" readonly="readonly"  maxlength="14"  value="${parentBean.section91}" /></div>
		</div>
		</div>
</fieldset>
<div class="row-fluid show-grid">
<div class="span4 offset8 decimal">
<input type="submit" class="button orange" value="Save">
</div>
</div>
</form>
</div>
<res:calc screenCalc="rebatesCalculation" formId="frmrebate"></res:calc>
<script type="text/javascript">
function sortDropDownListByText() {
    // Loop for each select element on the page.
    $("select").each(function() {
         
        // Keep track of the selected option.
        var selectedValue = $(this).val();
 
        // Sort all the options by text. I could easily sort these by val.
        $(this).html($("option", $(this)).sort(function(a, b) {
            return a.text == b.text ? 0 : a.text < b.text ? -1 : 1
        }));
 
        // Select one option.
        $(this).val(selectedValue);
    });
}
$(document).ready(sortDropDownListByText);
</script>



