<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<c:set var="securities">
	<fmt:message key="member.securities.title" />
</c:set>
<hippo-gogreen:title title="${securities}" />
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<hst:actionURL var="actionUrl" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.2.js"></script>
<script type="text/javascript"
	src=http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
var $m=jQuery.noConflict(true);
</script>


<script type="text/javascript">


$(document).ready(function() {
    // Run the event handler once now to ensure everything is as it should be
    
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
<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	TreeMap objHashMapBoolean = (TreeMap) objValueListService
			.getBoolean();

	request.setAttribute("objHashMapBoolean", objHashMapBoolean);

	TreeMap objTreeMapYear = (TreeMap) objValueListService
			.getInflationIndex();
	request.setAttribute("objTreeMapYear", objTreeMapYear);
%>
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

<h2>Capital gain Income Screen</h2>
<b>Securities</b>

<c:choose>
	<c:when test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
<form id="frmSecurity" action="${actionUrl}" method="post"
	name="security">

	<input type="hidden" name="hidDateAcquisition" id="hidDateAcquisition"
			value=" " /> <input type="hidden" name="hidDateSale"
			id="hidDateSale" value=" " /> <input type="hidden" name="screenMode"
			id="screenMode" value="CREATE" />
		
				<h2>Enter Details</h2>
			
			<div class="yui3-bd" align="center">
				<table class="personal_info">
					<tr height="30px">
						<td class="label label-default"><fmt:message
								key="capital.gain.date.acquisition" />
						</td>
						<td class="input"><select onChange="dpdown()" id="drop"
							name="dropvalue" onblur="fill()">
								<option value="">Select</option>

								<c:forEach var="numberyear" items="${objTreeMapYear}">
									<option value="${numberyear.key}">${numberyear.value}</option>
								</c:forEach>


								<c:if test="${not empty errors}">
									<c:forEach items="${errors}" var="error">
										<c:if test="${error eq 'invalid.date-acquisition-label'}">
											<span class="form-error"><fmt:message
													key="capital.gain.date.acquisition.error" /> </span>
										</c:if>
									</c:forEach>
								</c:if>
								<c:if test="${not empty errors}">
									<c:forEach items="${errors}" var="error">
										<c:if test="${error eq 'invalid.date-sale-label'}">
											<span class="form-error"><fmt:message
													key="capital.gain.date.sale.error" /> </span>
										</c:if>
									</c:forEach>
								</c:if>
						</td>
					</tr>


					<tr height="30px">
						<td class="label label-default"><fmt:message
								key="capital.gain.cost.acquisition" />
						</td>
						<td class="input"><c:if test="${not empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="cost_acquisition"
									value="${parentBean.costAcquisition}" id="cost" maxlength="14"
									required="required" class="numberinput"
									title="Please fill Numeric value" onChange="fill()"
									onblur="fill()" />
							</c:if> <c:if test="${empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="cost_acquisition"
									value="${fn:escapeXml(cost_acquisition)}" id="cost" maxlength="14"
									required="required" class="numberinput"
									title="Please fill Numeric value" onChange="fill()"
									onblur="fill()" />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.cost-acquisition-label'}">
										<span class="form-error"><fmt:message
												key="capital.gain.cost.acquisition.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
						<td class="label label-default"><fmt:message key="capital.gain.date.sale" />
						</td>
						<td class="input"><select onChange="dpdown1()" id="drop1"
							name="dropvalue1" onblur="fill()">
								<option value="">Select</option>

								<c:forEach var="numberyear" items="${objTreeMapYear}">
									<option Id="10" value="${numberyear.key}">${numberyear.value}</option>
								</c:forEach>
						</select> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.datesale.dateaquisition'}">
										<span class="form-error"><fmt:message
												key="capital.gain.date.acquisition.date.sale.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>

					<tr height="30px">
						<td class="label label-default"><fmt:message
								key="capital.gain.sale.consideration" />
						</td>
						<td class="input"><c:if test="${not empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="sale_consideration"
									maxlength="14" id="sale" required="required"
									value="${security.saleConsideration}" class="numberinput"
									title="Please fill Numeric value" onChange="fill()"
									onblur="fill()" />
							</c:if> <c:if test="${empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="sale_consideration"
									id="sale" required="required" maxlength="14"
									value="${fn:escapeXml(sale_consideration)}" class="numberinput"
									title="Please fill Numeric value" onChange="fill()"
									onblur="fill()" />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.sale-consideration-label'}">
										<span class="form-error"><fmt:message
												key="capital.gain.sale.consideration.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>

					<tr height="30px">
						<td class="label label-default"><fmt:message
								key="capital.gain.cost.inflation.acquisition" />
						</td>
						<td class="input"><c:if test="${not empty parentBean}">
								<input type="text" pattern="^[0-9]+$"
									name="inflation_acquisition" required="required"
									value="${security.costIndexAcquisition}" id="inflation"
									class="numberinput" onChange="fill()" onblur="fill()" readonly>
							</c:if> <c:if test="${empty parentBean}">
								<input type="text" pattern="^[0-9]+$"
									name="inflation_acquisition" required="required"
									value="${fn:escapeXml(inflation_acquisition)}" id="inflation"
									class="numberinput" onChange="fill()" onblur="fill()" readonly>
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if
										test="${error eq 'invalid.cost-inflation-acquision-label'}">
										<span class="form-error"><fmt:message
												key="capital.gain.cost.inflation.acquisition.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
						<td class="label label-default"><fmt:message
								key="capital.gain.cost.inflation.consideration" />
						</td>
						<td class="input"><c:if test="${not empty parentBean}">
								<input type="text" pattern="^[0-9]+$"
									name="inflation_consideration"
									value="${security.costIndexConsideration}" required="required"
									id="consideration" class="numberinput" onChange="fill()"
									onblur="fill()" readonly />
							</c:if> <c:if test="${empty parentBean}">
								<input type="text" pattern="^[0-9]+$"
									name="inflation_consideration"
									value="${fn:escapeXml(inflation_consideration)}"
									required="required" id="consideration" class="numberinput"
									onChange="fill()" onblur="fill()" readonly />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if
										test="${error eq 'invalid.cost-inflation-consideration-label'}">
										<span class="form-error"><fmt:message
												key="capital.gain.cost.inflation.consideration.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>

					<tr height="30px">
						<td class="label label-default"><fmt:message key="capital.gain" />
						</td>
						<td class="input"><c:if test="${not empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="capital_gain"
									value="${security.costIndexConsideration}" class="numberinput"
									id="gain" readonly />
							</c:if> <c:if test="${empty parentBean}">
								<input type="text" pattern="^[0-9]+$" name="capital_gain"
									value="${fn:escapeXml(capital_gain)}" class="numberinput"
									id="gain" readonly />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">

								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="40px">
						<td>&nbsp;</td>
						<td class="submit fright" colspan="2" align="center"><input
							type="submit" value="save" onclick="hiddenvalue()" />
						</td>
					</tr>
				</table>
			</div>

</form>



<script>
   
   function nextScreen()
   {
  
  
  document.forms['frmSecurity'].elements["screenMode"].value = "NEXTSCREEN";
document.getElementById('frmSecurity').submit();   
  }
function hiddenvalue(){

var s=document.security.dropvalue; 
var hid=s.options[s.selectedIndex].text



document.forms['frmSecurity'].elements["hidDateAcquisition"].value = hid;


var t=document.security.dropvalue1;
var hid1=t.options[t.selectedIndex].text

document.forms['frmSecurity'].elements["hidDateSale"].value = hid1;

}
var F=null;
var g=null;
    function dpdown(){
   
    var e = document.getElementById("drop");
    
 var f = e.options[e.selectedIndex].value;

	

document.getElementById("inflation").value=f;
    }
    
 function dpdown1(){
    
    var n = document.getElementById("drop1");
    
  g = n.options[n.selectedIndex].value;


document.getElementById("consideration").value=g;
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
						<th><b>Year Of Acquisition</b></th>
						<th><b>Year Of Sale</b></th>
						<th><b>Capital Gain</b></th>
						<th><b>Actions</b></th>
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.securitiesDetailList}" var="securitydetail">
							<tr>
								<td><a href="${modifiedSiteMapRefId}/<c:out value="${securitydetail.canonicalUUID}"/>/edit"><c:out value="${securitydetail.dateAcquisition}"/></a></td>
								
								<td><c:out value="${securitydetail.dateSale}"/></td>
								<td><c:out value="${securitydetail.capitalGain}"/></td>
								<td><a href="${redirectURLToSamePage}/<c:out value="${securitydetail.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${securitydetail.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
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



<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
