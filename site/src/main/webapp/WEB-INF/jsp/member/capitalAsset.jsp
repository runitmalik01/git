<%@include file="../includes/tags.jspf"%>
<%@include file="../includes/commonincludes.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.CapitalAssetDetail"%>
<%@page import="com.mootly.wcm.beans.CapitalAssetDocument"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="capitalasset">
	<fmt:message key="member.capital.title" />
</c:set>
<hippo-gogreen:title title="${capitalasset}" />
<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>

<script type="text/javascript">
var $m=jQuery.noConflict(true);
</script>

<script type="text/javascript">
$m(document).ready(function() {
var checkF=$m("#consideration").val();
if(checkF != null){
$m("#drop1").val(checkF);
var checkE=$m("#inflation").val();
$m("#drop").val(checkE);
}
    
	});

</script>

<script type="text/javascript">
var $m=jQuery.noConflict(true);

$m(document).ready(function () {
    $('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
    });
});
</script>


<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan);
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>


<h3>
	<fmt:message key="Capital.gain.Income.Screen" />
</h3>

<c:choose>
	<c:when test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

<form id="capitalasset" action="${actionUrl}" method="post"
	name="capitalasset">
	<input type="hidden" name="hidDateAcquisition" id="hidDateAcquisition"
		value=" " /> <input type="hidden" name="hidDateSale" id="hidDateSale"
		value=" " />

			<h4>Enter Details</h4>
		
		<div class="yui3-bd" align="center">
			<table class="personal_info">
				<tr height="30px">
					<td class="label"><fmt:message
							key="capital.gain.date.acquisition" /></td>
					<td class="input"><input type="text"   name="date_acquisition" 
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateAcquisition}"/></c:if>" id="cost" maxlength="14"
								 class="numberinput"
								title="Please fill only Numeric value" onChange="fill()" />
						
						

						
				<tr height="30px">
					<td class="label"><fmt:message
							key="capital.gain.cost.acquisition" /></td>
					<td class="input">
							<input type="text"  name="cost_acquisition"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>" id="cost" maxlength="14"
								 class="numberinput"
								title="Please fill only Numeric value" onChange="fill()" />
					
				<tr height="30px">
					<td class="label"><fmt:message key="capital.gain.date.sale" />
					</td><td class="input">
						<input type="text" name="date_sale"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateSale}"/></c:if>" id="cost" maxlength="14"
								 class="numberinput"
								title="Please fill only Numeric value"  />
				</td>
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message
							key="capital.gain.sale.consideration" /></td>
					<td class="input">
							<input type="text"  name="sale_consideration"
								id="sale" value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>" maxlength="14"
								required="required" class="numberinput"
								title="Please fill only Numeric value" onChange="fill()"
								onblur="fill()" />
						
					</td>
				</tr>
	</table>
		
		</div>
	<a href="${redirectURLToSamePage}" class="button olive">Cancel</a><input type="submit" class="button orange" value="Save">
</form>

</c:when>
<c:otherwise>				
				<table>
					<tr align="center">
					
							
						<th><b><fmt:message key="capital.gain.date.acquisition" /></b></th>
						<th><b><fmt:message key="capital.gain.cost.acquisition" /></b></th>
						<th><b><fmt:message key="capital.gain.date.sale" /></b></th>
						<th><b><fmt:message key="capital.gain.sale.consideration" /></b></th>
						<th><b><fmt:message key="capital.gain" /></b></th>
						<th><b><fmt:message key="capital.gain.long" /></b></th>
						<th><b>Actions</b></th>
				
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.capitalAssetDetailList}" var="capitalassetdetail">
							<tr>
								<td><c:out value="${capitalassetdetail.dateAcquisition}"/></td>
								<td><c:out value="${capitalassetdetail.costAcquisition}"/></td>
								<td><c:out value="${capitalassetdetail.dateSale}"/></td>
								<td><c:out value="${capitalassetdetail.saleConsideration}"/></td>
								<td><c:out value="${capitalassetdetail.capitalGain}"/></td>
								<td><c:out value="${capitalassetdetail.capitalGainTaxLT}"/></td>
								
								<td><a href="${redirectURLToSamePage}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
							</tr>
						</c:forEach>					
					</c:if>			
				</table>
				<a href="${redirectURLToSamePage}/new" class="button orange">Add New</a>
	</c:otherwise>
	</c:choose>

<hst:headContribution keyHint="buttonCss" category="css">
	<hst:link
		path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"
		var="homeSliderCss" />
	<link rel="stylesheet" media="screen" type="text/css"
		href="${homeSliderCss}" />
</hst:headContribution>


<hst:headContribution keyHint="seedFile" category="jsExternal">
	<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js"
		type="text/javascript"></script>
</hst:headContribution>
