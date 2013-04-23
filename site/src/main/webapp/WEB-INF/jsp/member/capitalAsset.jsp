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

			<h2>Enter Details</h2>
		</div>
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
							<input type="text" pattern="^[0-9]+$" name="sale_consideration"
								id="sale" value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>" maxlength="14"
								required="required" class="numberinput"
								title="Please fill only Numeric value" onChange="fill()"
								onblur="fill()" />
						
					</td>
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message
							key="capital.gain.cost.inflation.acquisition" /></td>
					<td class="input">
							<input type="text" pattern="^[0-9]+$"
								name="inflation_acquisition" 
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costIndexAcquisition}"/></c:if>" id="inflation"
								class="numberinput" onChange="fill()" onblur="fill()" readonly>
					
					</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="capital.gain.cost.inflation.consideration" /></td>
					<td class="input">
							<input type="text" pattern="^[0-9]+$"
								name="inflation_consideration"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costIndexConsideration}"/></c:if>" required="required"
								id="consideration" class="numberinput" onChange="fill()"
								onblur="fill()" readonly />

										</td>
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message key="capital.gain" /></td>
					<td class="input">
							<input type="text" pattern="^[0-9]+$"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.capitalGain}"/></c:if>"  name="capital_gain"
								class="numberinput" id="gain" readonly />
										</td>
				</tr>
				<tr height="40px">

					<td class="submit fright" colspan="1" align="right"><input
						type="submit" value="save" onclick="hiddenvalue()" /></td>
					<td>
						<button>
							<a href="${Securities}">Next</a>
						</button></td>
				</tr>
				
				
			</table>
		
		</div>
	</div>
</form>

<script>

function hiddenvalue(){

var s=document.capitalasset.dropvalue; 
var hid=s.options[s.selectedIndex].text
document.forms['capitalasset'].elements["hidDateAcquisition"].value = hid;
var t=document.capitalasset.dropvalue1;
var hid1=t.options[t.selectedIndex].text

document.forms['capitalasset'].elements["hidDateSale"].value = hid1;
	}
var F=null;
var g=null;

function dpdown1(){
	 var n = document.getElementById("drop1");
 	g = n.options[n.selectedIndex].value;
	document.getElementById("consideration").value=g;
	 }
	function dpdown(){
  var e = document.getElementById("drop");
    var f = e.options[e.selectedIndex].value;
	document.getElementById("inflation").value=f;
    }
    
  function fill() {

        var B = document.getElementById("cost").value-0;
		var D = document.getElementById("sale").value-0;
		var E = document.getElementById("inflation").value-0;
		 F = document.getElementById("consideration").value-0;
	if (E>0 && F>0 && B>0 && D>0){
         var be = B/E;
	var bef=be*F;
	var total=D-bef;
	
	
	document.getElementById("gain").value=Math.round(total*100)/100;
	}


    }
</script>
</c:when>
<c:otherwise>				
				<table>
					<tr align="center">
					
							
						<th><b><fmt:message key="capital.gain.date.acquisition" /></b></th>
						<th><b><fmt:message key="capital.gain.cost.acquisition" /></b></th>
						<th><b><fmt:message key="capital.gain.date.sale" /></b></th>
						<th><b><fmt:message key="capital.gain.sale.consideration" /></b></th>
						<th><b><fmt:message key="capital.gain" /></b></th>
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
