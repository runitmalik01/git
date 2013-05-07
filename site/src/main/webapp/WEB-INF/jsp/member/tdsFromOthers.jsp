<%@include file="../includes/tags.jspf"%>
<%@include file="../includes/commonincludes.jspf"%>

<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="tds2" />
</c:set>
<hippo-gogreen:title title="${tds2}" />
<script type="text/javascript">
 jQuery(document).ready(function(cash) {
  // binds form submission and fields to the validation engine
  jQuery("#tdsfromothers").validationEngine();
 });
</script>


<hst:actionURL var="actionUrl" />
<script type="text/javascript">


function calculate(){
	var amt= document.getElementById("taxdeducted").value;
	document.getElementById("amount").value = amt;

}
</script>
<script type="text/javascript">
function keyup(){
	var x=document.getElementById("tan_deductor");
	x.value=x.value.toUpperCase();
}
</script>
<hst:link var="mainSiteMapRefId"/>

	
<%
ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap objTreeMapDeductedYear = (TreeMap) objValueListService.getDeducterdYear();

request.setAttribute("objTreeMapDeductedYear", objTreeMapDeductedYear);
%>

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
<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error"><fmt:message key="${item.value}" /></div>
		</c:forEach>
	</c:if>
<h4>
	<fmt:message key="member.tds.from.others" />
</h4>

<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">


		<form id="tdsfromothers" action="${actionUrl}" method="post"
			name="tdsfromothers">


			<h2>Enter Details</h2>

			<table class="personal_info">

				<tr height="30px">
					<td class="label"><fmt:message key="tds.tan.deductor" />
					</td>
					<td class="input"><input type="text" name="tan_deductor" onkeyup="keyup()" id="tan_deductor"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Deductor}"/></c:if>"
						 maxlength="10" 
						/></td>
				</tr>



				<tr height="30px">
					<td class="label"><fmt:message key="tds.name.deductor" />
					</td>
					<td class="input"><input type="text" name="name_deductor"
						id="name_deductor" 
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Deductor}"/></c:if>"
						maxlength="125"  /></td>
						
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message key="tds.unique.certificate" />
					</td>
					<td class="input"><input type="text" name="tds_certificate"
						 maxlength="6" 
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tds_Certificate}"/></c:if>"
						id="tds_certificate"></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.financial.year" />
					</td>
					<td class="input"><select name="financial_year" id="consideration" title=" Enter deducted year as,for Ex. 2011 for 2011-2012 "
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.financial_Year}"/></c:if>" >
								
								<option value="">Select</option>
									<c:forEach var="yeardeducted" items="${objTreeMapDeductedYear}">
									<option value="${yeardeducted.value}">${yeardeducted.value}</option>
								</c:forEach>
							</select>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.total.tax.deducted" />
					</td>
					<td class="input"><input type="text" name="total_taxdeducted" maxlength="14"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total_TaxDeductor}"/></c:if>"
						 id="taxdeducted" onblur="calculate()" onchange="calculate"  /></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="tds.amount.claimed" />
					</td>
					<td class="input"><input type="text" name="amount" maxlength="14"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Amount}"/></c:if>"
						required="required" id="amount" readonly /></td>
				</tr>
	
			</table>
<a href="${redirectURLToSamePage}" class="button olive">Cancel</a><input type="submit" id="myModalHref" class="button orange" value="Save">
		</form>
		

	</c:when>
	<c:otherwise>
	<table>
			<tr align="center">
				<th><b><fmt:message key="tds.tan.deductor" />
				</b>
				</th>
				<th><b><fmt:message key="tds.name.deductor" />
				</b>
				</th>
				<th><b><fmt:message key="tds.unique.certificate" />
				</b>
				</th>
				<th><b><fmt:message key="tds.financial.year" />
				</b>
				</th>
				<th><b><fmt:message key="tds.total.tax.deducted" />
				</b></th>
				<th><b><fmt:message key="tds.amount.claimed" />
				</b></th>
				<th><b>Actions</b></th>
				

			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.tdsSalaryDetailList}"
					var="tdsfromothersdetail">
					<tr>
						<td><c:out value="${tdsfromothersdetail.tan_Deductor}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.name_Deductor}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.tds_Certificate}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.financial_Year}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.total_TaxDeductor}" />
						</td>
						<td><c:out value="${tdsfromothersdetail.p_Amount}" />
						</td>
						</td>
						

						<td><a
							href="${redirectURLToSamePage}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/edit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/delete"><small>Delete</small>
						</a>
						</td>

					</tr>

				</c:forEach>
				<tr><td><fmt:message key="tds.amount.total" /></td>
			<td><input type="text" name="total_value" value="${parentBean.total_Amount}"></td></tr>
			</c:if>
			
		</table>
		
		<a href="${redirectURLToSamePage}/new" class="button orange">Add
			New</a>
			<a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>

	</c:otherwise>
</c:choose>

<res:client-validation formId="tdsfromothers" screenConfigurationDocumentName="tdsfromothers" formSubmitButtonId="myModalHref"/>