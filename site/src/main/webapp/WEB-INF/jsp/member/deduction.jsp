<%@include file="../includes/commonincludes.jspf" %>
<%
	pageContext.removeAttribute("redirectURLToSamePage");
%>
<c:if test="${empty redirectURLToSamePage}">
	<%
		pageContext.setAttribute("redirectURLToSamePage",request.getRequestURL());
	%>
</c:if>
<c:set var="grandTotal" value="0"/>
<table border="1">
	<tr>
		<th>Investment Section</th>
		<th>Investment Head</th>
		<th>Investment Amount</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${deduction_sections}" var="deduction_section_item">
		<!--  lets create a bookmark for each section -->
		<a name="${deduction_section_item.key}"></a>
		<tr>
			<td colspan="3">				
				<h2><b><c:out value="${deduction_sections[deduction_section_item.key]}"/> - Max Deduction <c:out value="${deduction_section_maxallowed[deduction_section_item.key]}"/></b></h2>
			</td>
			<td width="10%">
				<a href="<c:out value="${redirectURLToSamePage}"/>/new/<c:out value="${deduction_section_item.key}"/>#<c:out value="${deduction_section_item.key}"/>">Add</a>
			</td>
		</tr>
		<tr>
			<c:if test="${pageAction =='NEW_CHILD' && deduction_section_item.key == deduction_section}">
				<jsp:include page="deduction_addrow.jsp"/>
			</c:if>			
		</tr>
		<c:if test="${not empty parentBean}">
				<c:set var="totalForSection" value="0"/>
				<c:forEach items="${parentBean.deductionDocumentDetailList}" var="deductionDocumentDetail">				
						<c:if test="${deductionDocumentDetail.section == deduction_section_item.key}">
							<c:set var="totalForSection" value="${totalForSection + deductionDocumentDetail.investment}"/>
							<c:choose>
								<c:when test="${(pageAction =='EDIT_CHILD' && uuid == deductionDocumentDetail.canonicalUUID)}">
									<tr>
										<jsp:include page="deduction_addrow.jsp"/>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<%--<td><c:out value="${deductionDocumentDetail.section}"/></td> --%>
										<td colspan="2" align="right"><c:out value="${deduction_section_heads[deductionDocumentDetail.head]}"/></td>
										<td align="right"><c:out value="${deductionDocumentDetail.investment}"/></td>
										<td><a href="<c:out value="${redirectURLToSamePage}/${deductionDocumentDetail.canonicalUUID}"/>/edit#<c:out value="${deduction_section_item.key}"/>">Edit</a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${deductionDocumentDetail.canonicalUUID}"/>/delete">Delete</a></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</c:if>
				</c:forEach>			
				<tr>
					<td colspan="2"><b>Total <c:out value="${deduction_sections[deduction_section_item.key]}"/></b></td>
					<td align="right"><b><c:out value="${totalForSection}"/></b></td>
					<td>&nbsp;</td>
					<c:set var="grandTotal" value="${grandTotal + totalForSection}"/>
				</tr>			
		</c:if>
	</c:forEach>
	<tr>
		<td colspan="2" align="right"><b>Grand Total</b></td>
		<td align="right"><b><c:out value="${grandTotal}"/></b></td>
		<td>&nbsp;</td>		
	</tr>
</table>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#frmdata input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#frmdata').submit();
			    }
			});
			$('#frmdata').validate({
				rules: {
					username: {
						required: true,
						minlength: 2
					},

					password: {
						required: true
					}
				},				
				messages: {
					username: "Please enter a valid email address.",
					password: "Please enter a valid password."
				}
			});
			
			$('#hrefLogin').click(function() {
 				 $('#frmdata').submit();
			});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>