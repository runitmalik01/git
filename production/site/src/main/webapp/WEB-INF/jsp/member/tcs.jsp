
<%--
@author Pankaj Singh
30/03/2013
 --%>

<%@include file="../includes/tags.jspf"%>

<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	TreeMap TreeMapNaturePayment = (TreeMap) objValueListService
			.getNatureOfPayment();
	request.setAttribute("TreeMapNaturePayment", TreeMapNaturePayment);
%>

<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<script type="text/javascript">
var $m=jQuery.noConflict(true);





</script>

<c:set var="tcs">
	<fmt:message key="member.tcs.content.title" />
</c:set>
<hippo-gogreen:title title="${tcs}" />

<div class="yui3-bd" align="center">
	<hst:actionURL var="actionUrl"></hst:actionURL>
	<form id="frmRating" action="${actionUrl}" method="post">
		<input type="hidden" id="fetchpaymentId"
			value="${fetchtcs.naturepayment}" />
		<div id="demo" class="yui3-module">
			<div class="yui3-hd">
				<h2>
					<fmt:message key="member.tcs.tittle"></fmt:message>
				</h2>
			</div>


			<div class="yui3-bd" align="center">
				<table>
					<tr height="30px">
						<td id="label"><fmt:message key="member.tcs.nature.payment" />
						</td>
						<td><c:if test="${ not empty fetchtcs}">
								<select name="naturepayment" id="naturepayment">
									<option>-Select Nature of Payment-</option>
									<c:forEach var="booleanpayment" items="${TreeMapNaturePayment}">
										<option value="${booleanpayment.value}">${booleanpayment.value}</option>
									</c:forEach>
								</select>
							</c:if> <c:if test="${ empty fetchtcs}">
								<select name="naturepayment" id="name">
									<option>-Select Nature of Payment-</option>
									<c:forEach var="booleanpayment" items="${TreeMapNaturePayment}">
										<option value="${booleanpayment.value}">${booleanpayment.value}</option>
									</c:forEach>
								</select>
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.naturepayment-label'}">
										<span class="form-error"><fmt:message
												key="member.nature.payment.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
						<td id="label"><fmt:message
								key="member.tcs.collector.details"></fmt:message></td>
					</tr>
					<tr height="30px">
						<td id="label"><fmt:message key="member.tcs.tan" /></td>
						<td><c:if test="${ not empty fetchtcs}">
								<input type="text" name="tan" maxlength="10"
									value="${fn:escapeXml(fetchtcs.tan)}" id="tan" required />
							</c:if> <c:if test="${ empty fetchtcs}">
								<input type="text" name="tan" maxlength="10" value="" id="tan"
									required />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'Enter a valid Tan'}">
										<span class="form-error"><fmt:message
												key="member.tan.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
					<tr height="30px">
						<td id="label"><fmt:message key="member.tcs.name" /></td>

						<td><c:if test="${ not empty fetchtcs}">
								<input type="text" name="name" maxlength="125"
									value="${fn:escapeXml(fetchtcs.name)}" id="name" required />
							</c:if> <c:if test="${empty fetchtcs}">
								<input type="text" name="name" maxlength="125" value=""
									id="name" required />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.name-label'}">
										<span class="form-error"><fmt:message
												key="member.name.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
					<tr>
						<td align="center"><b>&nbsp;&nbsp; <fmt:message
									key="member.tcs.tax.details" />
						</b>
						</td>

					</tr>

					<tr>
						<td id="label"><fmt:message
								key="member.tcs.amount.tax.calculate"></fmt:message>
						</td>
						<td><c:if test="${ not empty fetchtcs}">
								<input type="text" name="taxcalamount" maxlength="14"
									class="numberinput"
									value="${fn:escapeXml(fetchtcs.taxCalcAmount)}"
									id="taxcalamount" required />
							</c:if> <c:if test="${empty fetchtcs}">
								<input type="text" name="taxcalamount" maxlength="14"
									class="numberinput" value="" id="taxcalamount" required />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.taxcalculateAmount-label'}">
										<span class="form-error"><fmt:message
												key="member.taxcalculate.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
					<tr height="30px">
						<td id="label"><fmt:message key="member.tcs.tax.collected" />
						</td>
						<td><c:if test="${ not empty fetchtcs}">
								<input type="text" name="taxcollected" maxlength="14"
									class="numberinput"
									value="${fn:escapeXml(fetchtcs.taxCollected)}"
									id="taxcollected" onchange="fillAmountclaimed()" required />
							</c:if> <c:if test="${empty fetchtcs}">
								<input type="text" name="taxcollected" maxlength="14"
									class="numberinput" value="" id="taxcollected"
									onchange="fillAmountclaimed()" required />
							</c:if> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'invalid.taxcollected-label'}">
										<span class="form-error"><fmt:message
												key="member.taxcollected.error" /> </span>
									</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>

					<tr height="30px">
						<td id="label"><fmt:message key="member.tcs.amount.claimed" />
						</td>
						<td><c:if test="${ not empty fetchtcs}">
								<input type="text" name="amountclaimed" maxlength="14"
									value="${fn:escapeXml(fetchtcs.amountClaimed)}"
									id="amountclaimed" readonly />
							</c:if> <c:if test="${ empty fetchtcs}">
								<input type="text" name="amountclaimed" maxlength="14" value=""
									id="amountclaimed" readonly />
							</c:if>
						</td>
					</tr>

				</table><table><tr><td>
				 <input type="submit" name="submit" value="Save" /> <br /></td>
					<td><button>
					<a href="/site/calculation">skip</a>
						</button>				 
					
					</td></tr></table>
			</div>
		</div>
	</form>

</div>

<!--when user click on change button all values will be fetched from repository and will be shown 
 in their respective-->

<script>
function fillAmountclaimed(){
	var i=document.getElementById("taxcollected").value;
	document.getElementById("amountclaimed").value= i;
}

    var fetchpayment =$m("#fetchpaymentId").val();

  if(fetchpayment!=null){
   $m("#naturepayment").val(fetchpayment);
   }
  
</script>
<script type="text/javascript">

 $m(document).ready(function () {
     $m('input.numberinput').bind('keypress', function (e) {
         return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
     });
 });
 </script>

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



