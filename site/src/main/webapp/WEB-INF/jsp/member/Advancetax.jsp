<%@include file="../includes/tags.jspf"%>

<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="member.advancetax.title" />
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
$(function() {

	  $m( "#date_credit" ).datepicker({
		
	    changeMonth: true,
	    changeYear: false
	  });
	  
	});
</script>
<script type="text/javascript">
var $m=jQuery.noConflict(true);

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
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan);
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


		<form id="advancetax" action="${actionUrl}" method="post"
			name="advancetax">

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
						<td class="input"><input id="date_credit" name="date_credit"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>"
							 />
						</td>
					</tr>

					<tr height="30px">
						<td class="label"><fmt:message key="tds.serial.challan" /></td>
						<td class="input"><input type="text" name="Serial_challan"
							
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



					<tr height="40px">

						<td class="submit fright" colspan="1" align="right"><input
							type="submit" value="save" id="submit" onclick="hiddenvalue()" />
						</td>
						<td>
							<button>
								<a>Skip</a>
							</button></td>
					</tr>


				</table>
			</fieldset>
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
				<c:forEach items="${parentBean.advanceTaxDetailList}"
					var="advancetaxdetail">
					<tr>
						<td><c:out value="${advancetaxdetail.p_BSR}" /></td>
						<td><c:out value="${advancetaxdetail.dateStr}" /></td>
						<td><c:out value="${advancetaxdetail.p_Serial}" /></td>
						<td><c:out value="${advancetaxdetail.p_Amount}" /></td>
						<td><a
							href="${redirectURLToSamePage}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/edit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/delete"><small>Delete</small>
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

	</c:otherwise>
</c:choose>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$m(document).ready(function() {
		
			    if (Modernizr.touch && Modernizr.inputtypes.date) {
			        
			        document.getElementById('date_credit').type = 'date';
			        
			    } else {
			        $m('#date_credit').datepicker({
                    changeMonth: true,
                    changeYear: true,
                    maxDate: "+0M +15D",
                    yearRange: "2012:2013"
                   });
                   
			    }
	
				
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>



