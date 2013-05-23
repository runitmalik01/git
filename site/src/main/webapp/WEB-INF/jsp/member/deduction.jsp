<%@include file="../includes/tags.jspf" %>

<%
	pageContext.removeAttribute("redirectURLToSamePage");
%>
<c:if test="${empty redirectURLToSamePage}">
	<%
		pageContext.setAttribute("redirectURLToSamePage",request.getRequestURL());
	%>
</c:if>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="com.mootly.wcm.components.deduction-section-heads-${financialYear.displayName}" var="dSectionHeads"/>
<fmt:setBundle basename="com.mootly.wcm.components.deduction-sections-${financialYear.displayName}" var="dSections"/>
<div class="page">
	<h4>Deductions</h4>
	<h5><small>List of deductions</small></h5>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Deduction Section</th>
				<th><abbr title="How much money you have invested">Gross Investment (&#8377;)</abbr></th>
				<th><abbr title="Maximum Allowed Deduction">Total Deduction (&#8377;)</abbr></th>
			</tr>
			<c:forEach items="${deductionSectionMap}" var="deductionSectionMapEntry">
				<c:set var="totalEligibleDeduction" value="0"/>
				<c:set var="deductionSectionName" value="${deductionSectionMapEntry.key}"/>
				<c:set var="deductionSectionLabel" value="${deductionSectionMapEntry.value.additionalProperties['label']}"/>
				<c:set var="deductionAdditionalScreen" value="${deductionSectionMapEntry.value.additionalProperties['additionalScreen']}"/>
				<!--  lets create a bookmark for each section -->
				<tr>    
					<td colspan="1">     	
						<div class="btn-group">	
							<button class="btn btn-small dropdown-toggle" data-toggle="dropdown"><c:out value="${deductionSectionLabel}"/><span class="caret"></span></button>
							<ul class="dropdown-menu">
				            	<li><a href="<c:out value="${scriptName}"/>/newc6deduction/<c:out value="${deductionSectionName}"/>">Add</a></li>
								<%-- commented out --%>
								<%--
								<c:if test="${not empty savedData && not empty savedData[deductionSectionName]}">
								<li class="divider"></li>
									<c:forEach items="${savedData[deductionSectionName]}" var="aSectionHead">
										<li><a href="<c:out value="${scriptName}/${aSectionHead.canonicalUUID}"/>/editc6deduction"><fmt:message var="label" bundle="${dSectionHeads}" key="sectionhead.${aSectionHead.head}.label"></fmt:message><res:displaylabel label="${label}"/>(<c:out value="${aSectionHead.investment}"/>)</a></li>
									</c:forEach>								 	
								</c:if>	
								 --%>
							</ul>								
						</div>	
					</td>		
					<td  style="text-align:right">
						<!--  we will show total for all deductions -->
						<c:choose>
							<c:when test="${not empty totalOfSavedData && not empty totalOfSavedData[deductionSectionName]}">								
								<div class="btn-group">	
									<button class="btn btn-small dropdown-toggle" data-toggle="dropdown"><w4india:inr value="${totalOfSavedData[deductionSectionName]}"></w4india:inr><span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li class="divider"></li>
						            	<%-- commented out --%>
						            	<%-- 
						            	<li><a href="<c:out value="${scriptName}"/>/newc6deduction/<c:out value="${deductionSectionName}"/>">Add</a></li>
						            	 --%>
										<c:if test="${not empty savedData && not empty savedData[deductionSectionName]}">											
											<c:forEach items="${savedData[deductionSectionName]}" var="aSectionHead">
												<li><a href="<c:out value="${scriptName}/${aSectionHead.canonicalUUID}"/>/editc6deduction"><fmt:message var="label" bundle="${dSectionHeads}" key="sectionhead.${aSectionHead.head}.label"></fmt:message><res:displaylabel label="${label}"></res:displaylabel> |<c:out value="${aSectionHead.investment}"/>|</a></li>
											</c:forEach>								 	
										</c:if>	
									</ul>								
								</div>
							</c:when>
							<c:otherwise>
								<w4india:inr value="0"></w4india:inr>
							</c:otherwise>
						</c:choose>
					</td>
					<td  style="text-align:right">
						<span class="decimal">
							<c:set var="theKey" value="total_${fn:replace(deductionSectionName,'-','_')}"/>
							<c:choose>
								<c:when test="${not empty totalMapForJS && not empty totalMapForJS[theKey]}">
									<w4india:inr value="${totalMapForJS[theKey]}"/>
									<c:set var="totalEligibleDeduction" value="${totalEligibleDeduction + totalMapForJS[theKey]}"/>
								</c:when>	
								<c:otherwise>
									<w4india:inr value="0"/>
								</c:otherwise>
							</c:choose>
							
						</span>
					</td>
				</tr>	
			</c:forEach>		
			<tr class="success">
				<td colspan="1" style="text-align:right"><b>Total</b></td>				
				<td align="right" style="text-align:right"><b><w4india:inr value="${grandTotal}"/></b></td>
				<td align="right" style="text-align:right"><b><w4india:inr value="${totalEligibleDeduction}"/></b></td>
			</tr>	
		</table>
</div>
<c:set var="deductionAdditionalScreen" value="${deductionSection.additionalProperties['additionalScreen']}"/>
<c:choose>
	<c:when test="${not empty deductionAdditionalScreen && deductionAdditionalScreen != ''}">
		<c:set var="jspFilePath" value="${deductionAdditionalScreen}.jsp"/>
		<c:set var="additionalScreenHTML">
			<jsp:include page="${jspFilePath}"/>
		</c:set>
	</c:when>
	<c:otherwise>
		<%pageContext.removeAttribute("additionalScreenHTML");%>
	</c:otherwise>
</c:choose>	
<c:if test="${pageAction =='NEW_CHILD'}">
	<c:set var="formHTML">
		<c:set var="modalHeading" value="${deductionSection.label}"></c:set>
		<jsp:include page="deduction_addrow.jsp"/>
	</c:set>
</c:if>
<c:if test="${(pageAction == 'EDIT_CHILD' && not empty editingSection)}">
		<%out.flush();%>
		<c:set var="formHTML">
			<c:set var="modalHeading" value="${editingSection.section}"></c:set>
			<jsp:include page="deduction_addrow.jsp"/>
		</c:set>
		<%out.flush();%>
</c:if>
<c:if test="${not empty formHTML}">
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><c:out value="${modalHeading}"/></h3>
	  </div>
	  <div class="modal-body">
	  	<c:if test="${not empty formMap}">
			<c:forEach items="${formMap.message}" var="item">
				<div class="alert alert-error"><fmt:message key="${item.value}" /></div>
			</c:forEach>
		</c:if>
	  	<hst:actionURL var="submitDeduction"></hst:actionURL>
	    <form class="frmDeduction" action="${submitDeduction}">
	    	<c:out value="${formHTML}" escapeXml="false"/>
	    	<c:if test="${not empty additionalScreenHTML}"><c:out value="${additionalScreenHTML}" escapeXml="false"/></c:if>
	    	
	    </form>
	  </div>
	  <div class="modal-footer">
	    <a href="${scriptName}?tab=deductions" class="btn" data-dismiss="">Close</a>
	    <c:if test="${pageAction =='EDIT_CHILD'}"><button class="btn btn-danger" onclick="$('.frmDeduction').attr('action','<c:out value="${scriptName}/${editingSection.canonicalUUID}"/>/deletec6deduction');$('.frmDeduction').attr('method','get');$('.frmDeduction').submit()">Delete</button></c:if>
	    <a href="javascript:$('.frmDeduction').submit()" class="btn btn-primary">Save changes</a>
	  </div>
	</div>
</c:if>
<a  id="click" role="button" class="btn" data-toggle="" onclick="lastURL()"><fmt:message key="back.to.formsixteen" /></a>
<script>
function lastURL() {
	var oldURL = document.referrer;
	window.location.href=oldURL  ;
}
</script>

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