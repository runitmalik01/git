<%@include file="../includes/tags.jspf" %>
<%
	pageContext.removeAttribute("redirectURLToSamePage");
%>
<c:if test="${empty redirectURLToSamePage}">
	<%
		pageContext.setAttribute("redirectURLToSamePage",request.getRequestURL());
	%>
</c:if>
<div class="page">
	<h4>Deductions</h4>
	<h5><small>List of deductions</small></h5>
		<c:set var="grandTotal" value="0"/>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Deduction Section</th>
				<th><abbr title="How much money you have invested">Gross Investment (&#8377;)</abbr></th>
				<th><abbr title="Maximum Allowed Deduction">Total Deduction (&#8377;)</abbr></th>
			</tr>
			<c:forEach items="${deduction_sections}" var="deduction_section_item">
				<!--  lets create a bookmark for each section -->
				<tr>    
					<td colspan="1">     	
						<%-- - Max Deduction <c:out value="${deduction_section_maxallowed[deduction_section_item.key]}"/> --%>			
						<c:out value="${deduction_sections[deduction_section_item.key]}"/>&nbsp;						
					</td>		
					<td>
						<div class="btn-group" class="decimal">
			                <button class="btn btn-small dropdown-toggle" data-toggle="dropdown">0<span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="<c:out value="${scriptName}"/>/new/<c:out value="${deduction_section_item.key}"/>">Add</a></li>
			                </ul>
			              </div>
					</td>
					<td align="right"><span class="decimal">0</span></td>
				</tr>	
				<c:if test="${pageAction =='NEW_CHILD' && deduction_section_item.key == deduction_section}">
					<c:set var="formHTML">
						<c:set var="modalHeading" value="${deduction_sections[deduction_section_item.key]}"></c:set>
						<jsp:include page="deduction_addrow.jsp"/>
					</c:set>
				</c:if>
				<c:if test="${not empty parentBean}">
					<c:set var="totalForSection" value="0"/>
					<c:forEach items="${parentBean.deductionDocumentDetailList}" var="deductionDocumentDetail">				
							<c:if test="${deductionDocumentDetail.section == deduction_section_item.key}">
								<c:set var="totalForSection" value="${totalForSection + deductionDocumentDetail.investment}"/>
								<tr>
									<%--<td><c:out value="${deductionDocumentDetail.section}"/></td> --%>
									<td colspan="1" align="right"><c:out value="${deduction_section_heads[deductionDocumentDetail.head]}"/></td>
									<td>
										<div class="btn-group" align="right">
							                <button class="btn btn-small dropdown-toggle" data-toggle="dropdown"><c:out value="${deductionDocumentDetail.investment}"/><span class="caret"></span></button>
							                <ul class="dropdown-menu">
							                  <li><a href="<c:out value="${scriptName}/${deductionDocumentDetail.canonicalUUID}"/>/edit">Edit</a></li>
							                  <li><a href="${scriptName}/<c:out value="${deductionDocumentDetail.canonicalUUID}"/>/delete">Delete</a></li>
							                </ul>
							              </div>
									</td>
									<td><span class="decimal">0</span></td>
								</tr>
								<c:if test="${(pageAction == 'EDIT_CHILD' && uuid == deductionDocumentDetail.canonicalUUID)}">
									<%out.flush();%>
									<c:set var="formHTML">
										<c:set var="modalHeading" value="${deduction_sections[deduction_section_item.key]}"></c:set>
										<jsp:include page="deduction_addrow.jsp"/>
									</c:set>
									<%out.flush();%>
								</c:if>
							</c:if>
					</c:forEach>				
				</c:if>	
			</c:forEach>		
			<tr class="success">
				<td colspan="2"><b>Total <c:out value="${deduction_sections[deduction_section_item.key]}"/></b></td>
				<td align="right"><b><c:out value="${totalForSection}"/></b></td>
				<c:set var="grandTotal" value="${grandTotal + totalForSection}"/>
			</tr>	
		</table>
</div>

<c:if test="${not empty formHTML}">
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><c:out value="${modalHeading}"/></h3>
	  </div>
	  <div class="modal-body">
	    <form>
	    	<c:out value="${formHTML}" escapeXml="false"/>
	    </form>
	  </div>
	  <div class="modal-footer">
	    <a href="#" class="btn">Close</a>
	    <a href="#" class="btn btn-primary">Save changes</a>
	  </div>
	</div>
</c:if>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			if ($("#myModal").length >0) $("#myModal").modal();
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