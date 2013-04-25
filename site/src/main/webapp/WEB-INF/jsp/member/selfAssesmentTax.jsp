<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<script>

$(document).ready(function() {
	if (Modernizr.touch && Modernizr.inputtypes.date) {
    	
        document.getElementById('datecredit').type = 'date';
        
    } else {
        $('#datecredit').datepicker({
    
        changeMonth: true,
        changeYear: true,

       // minDate: "-13M +15D",
      //   maxDate: "+0M -19D",
        yearRange: "2013:2014"
        
       });
     
    }
});    

</script>
<c:set var="tds2">
	<fmt:message key="tds2" />
</c:set>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hippo-gogreen:title title="${tds2}" />


<script type="text/javascript">


function calculate(){
	var amt= document.getElementById("taxdeducted").value;
	document.getElementById("amount").value = amt;
	 
}

</script>

<hst:actionURL var="actionUrl" />


<hst:link var="mainSiteMapRefId" />

<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
 String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("selfassesmenttax","tdsfromsalary");
 pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
 pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<h4>
	<fmt:message key="member.tds.selfassesment.tax" />
</h4>

<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">


		<form id="selfassesment" action="${actionUrl}" method="post"
			name="selfassesment">

			<fieldset>
				<legend style="color: blue" align="left">Enter Details</legend>

				<table class="personal_info">

					<tr height="30px">
						<td class="label"><fmt:message key="tds.bsr.code" /></td>
						<td class="input"><input type="text" name="bsr_code"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>"
							id="cost" maxlength="7"
							title="This field accept 7 digit numeric value"
							placeholder="7 digits" />
						</td>
					</tr>



					<tr height="30px">
						<td class="label"><fmt:message key="tds.date.credit" /></td>
						<td class="input"><input id="datecredit" name="date_credit"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>"
							 />
						</td>
					</tr>

					<tr height="30px">
						<td class="label"><fmt:message key="tds.serial.challan" /></td>
						<td class="input"><input type="text" name="Serial_challan" maxlength="5"
							
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>"
							id="Serial_challan">
						</td>
					</tr>
					<tr height="30px">
						<td class="label"><fmt:message key="tds.amount.selfassesment" />
						</td>
						<td class="input"><input type="text" name="amount"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Amount}"/></c:if>"
							id="amount"
							class="validate[required,custom[integer],maxSize[14]] text-input" />
						</td>
					</tr>
		</table>
			</fieldset>
			<a href="${redirectURLToSamePage}" class="button olive">Cancel</a><input type="submit" class="button orange" value="Save">
		</form>

	</c:when>
	<c:otherwise>




		<table>
			<tr align="center">
				<th><b><fmt:message key="tds.bsr.code" /> </b></th>
				<th><b><fmt:message key="tds.date.credit" /> </b></th>
				<th><b><fmt:message key="tds.serial.challan" /> </b></th>
				<th><b><fmt:message key="tds.amount.selfassesment" /> </b></th>

				<th><b>Actions</b>
				</th>


			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.selfAssesmentDetailList}"
					var="selfassesmentdetail">
					<tr>
						<td><c:out value="${selfassesmentdetail.p_BSR}" /></td>
						<td><c:out value="${selfassesmentdetail.dateStr}" /></td>
						<td><c:out value="${selfassesmentdetail.p_Serial}" /></td>
						<td><c:out value="${selfassesmentdetail.p_Amount}" /></td>
						<td><a
							href="${redirectURLToSamePage}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/edit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/delete"><small>Delete</small>
						</a></td>

					</tr>

				</c:forEach>
				<tr>
					<td><fmt:message key="tds.amount.total" />
					</td>
					<td><input type="text" name="total_value" value="${parentBean.total_Amount}"></td></tr>
			</c:if>

		</table>

		<a href="${redirectURLToSamePage}/new" class="button orange">Add
			New</a>
			<a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>

	</c:otherwise>
</c:choose>
