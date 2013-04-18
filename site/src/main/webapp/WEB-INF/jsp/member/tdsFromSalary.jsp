<%@include file="../includes/tags.jspf"%>
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
<c:choose>
	<c:when test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">





<form id="tdsfromsalary" action="${actionUrl}" method="post"
	name="tdsfromsalary">

	
			<h2>Enter Details</h2>
	
			<table class="personal_info">

				<tr height="30px">
					<td class="label"><fmt:message
							key="tds.tan.emoloyer" /></td>
					<td class="input">
							<input type="text" name="tan_employer"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Employer}"/></c:if>" id="cost" maxlength="10"
								required="required" 
								title="This field accept first four alphabate next five numeric then single alphabate" placeholder="10 Characters" />
						</td></tr>
						


				<tr height="30px">
					<td class="label"><fmt:message
							key="tds.name.employer" /></td>
					<td class="input">
							<input type="text" name="name_employer"
								id="sale" value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Employer}"/></c:if>" maxlength="14"
								required="required" 
								title="Please fill alphabets only"/>
					</td>
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message
							key="tds.income.chargeable" /></td>
					<td class="input">
							<input type="text" 
								name="income_chargeable" required="required"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_Chargeable}"/></c:if>" id="income_chargeable"
								class="numberinput" >
						
					</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="tds.total.tax.deducted" /></td>
					<td class="input">
							<input type="text"
								name="total_taxdeducted"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_TaxDeducted}"/></c:if>" required="required"
								id="consideration" class="numberinput"  />


					</td>
				</tr>


				<tr height="40px">

					<td class="submit fright" colspan="1" align="right"><input
						type="submit" value="save" /></td>
					<td>
						<button>
							<a href="${Securities}">Next</a>
						</button></td>
				</tr>
	
				
			</table>
		
</form>

		</c:when>
<c:otherwise>		
	<table>
					<tr align="center">
						<th><b>TAN of Employer</b></th>
						<th><b>Name of Employer</b></th>
						<th><b>Income Chargeable under head salaries</b></th>
						<th><b>Total tax Deducted</b></th>
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.tdsSalaryDetailList}" var="tdsfromsalarydetail">
							<tr>
								<td><c:out value="${tdsfromsalarydetail.tan_Employer}"/></td>
								
								<td><c:out value="${tdsfromsalarydetail.name_Employer}"/></td>
								<td><c:out value="${tdsfromsalarydetail.income_Chargeable}"/></td>
								<td><c:out value="${tdsfromsalarydetail.total_TaxDeducted}"/></td>
							
								<td><a href="${redirectURLToSamePage}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${tdsfromsalarydetail.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
							
							</tr>
						</c:forEach>	
							<tr><td><fmt:message key="tds.amount.total.deducted" /></td>
			<td><input type="text" name="total_value" value="${parentBean.total_Amount}"></td></tr>				
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
