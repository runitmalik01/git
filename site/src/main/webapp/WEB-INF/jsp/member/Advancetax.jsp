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
 String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("advancetax","selfassesmenttax");
 pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
 pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
 <a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>
 <hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>


<h4>
	<fmt:message key="advance.tax" />
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
						<td><input id="date_credit" name="date_credit"
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
						<td class="input"><input type="text" name="amount" maxlength="14"
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
					<td><input type="text" name="total_value" value="${parentBean.total_Amount}"></td>
				</c:if>
		</table>

		<a href="${redirectURLToSamePage}/new" class="button orange">Add
			New</a>
			<a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>
		<table><tr align="center">
		<th><b>Date of Installment</b></th>
		<th><b>Upto 01/04 To 15/6</b></th>
		<th><b>Upto 16/6 To 15/9</b></th>
		<th><b>Upto 16/9 To 15/12</b></th>
		<th><b>Upto 16/12 To 15/03</b></th>
		<th><b>Upto 16/03 To 31/03</b></th>
		
			</tr>
			<c:if test="${not empty parentBean}">
				<tr>	<td> Amount </td>
						<td><c:out value="${parentBean.total_Sum1}" /></td>
						<td><c:out value="${parentBean.total_Sum2}" /></td>
						<td><c:out value="${parentBean.total_Sum3}" /></td>
						<td><c:out value="${parentBean.total_Sum4}" /></td>
						<td><c:out value="${parentBean.total_Sum5}" /></td>
						
						</tr>
						</c:if>
		
		</table>
	</c:otherwise>
</c:choose>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
		
			    if (Modernizr.touch && Modernizr.inputtypes.date) {
			    	
			        document.getElementById('date_credit').type = 'date';
			        
			    } else {
			        $('#date_credit').datepicker({
			    
                    changeMonth: true,
                    changeYear: true,
                  
                   
                    yearRange: "2011:2012"
                    
                   });
                 
			    }
			    var filing=$('#filing').val();
			    if(filing!=null){
			        $('#status').val(filing);
			    };
			    $('#frmPersonalInfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmPersonalInfo').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmPersonalInfo').submit();
				});
				
				$("#pi_first_name").popover({'trigger':'focus'});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>



