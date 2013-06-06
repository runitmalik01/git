<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
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
	<c:if test="${empty ischildofform16 || ischildofform16 !='true'}"><w4india:itrmenu/></c:if>
	<h4>Deductions</h4>
	<h5><small>List of deductions</small></h5>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Deduction Section</th>
				<th><abbr title="How much money you have invested">Gross Investment (&#8377;)</abbr></th>
				<th><abbr title="Maximum Allowed Deduction">Total Deduction (&#8377;)</abbr></th>
			</tr>
			<c:forEach items="${deductionSectionMap}" var="deductionSectionMapEntry">
				<c:set var="skipIt" value="false"/>
				<c:set var="totalEligibleDeduction" value="0"/>
				<c:set var="deductionSectionName" value="${deductionSectionMapEntry.key}"/>
				<c:set var="deductionSectionLabel" value="${deductionSectionMapEntry.value.additionalProperties['label']}"/>
				<c:set var="deductionAdditionalScreen" value="${deductionSectionMapEntry.value.additionalProperties['additionalScreen']}"/>
				<c:choose>
					<c:when test="${empty ischildofform16 || ischildofform16 !='true'}">
						<c:set var="addURL" value="${scriptName}/newc6deduction/${deductionSectionName}"/>
					</c:when>
					<c:otherwise>
						<c:set var="successURL" value="./formsixteenedit"/>
						<c:set var="addURL" value="./formsixteenedit/newc6deduction/${deductionSectionName}"/>
						<c:set var="showOnForm16" value="${deductionSectionMapEntry.value.additionalProperties['showOnForm16']}"/>
						<c:if test="${empty showOnForm16}">
							<c:set var="skipIt" value="true"/>
						</c:if>
					</c:otherwise>
				</c:choose>
				<!--  lets create a bookmark for each section -->
				<c:if test="${skipIt == 'false'}">
					<tr>    
						<td colspan="1">     	
							<div class="btn-group">	
								<button class="btn btn-small dropdown-toggle" data-toggle="dropdown"><c:out value="${deductionSectionLabel}"/><span class="caret"></span></button>
								<ul class="dropdown-menu">
					            	<li><a href="${addURL}">Add</a></li>
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
													<c:choose>
														<c:when test="${empty ischildofform16 || ischildofform16 !='true'}">
															<c:set var="editURL" value="${scriptName}/${aSectionHead.canonicalUUID}/editc6deduction"/>
														</c:when>
														<c:otherwise>
															<c:set var="editURL" value="./formsixteenedit/${aSectionHead.canonicalUUID}/editc6deduction"/>
															<c:set var="successURL" value="./formsixteenedit"/>
														</c:otherwise>
													</c:choose>
													<li><a href="${editURL}"><fmt:message var="label" bundle="${dSectionHeads}" key="sectionhead.${aSectionHead.head}.label"></fmt:message><res:displaylabel label="${label}"></res:displaylabel> |<c:out value="${aSectionHead.investment}"/>|</a></li>
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
									</c:when>	
									<c:otherwise>
										<w4india:inr value="0"/>
									</c:otherwise>
								</c:choose>
							</span>
						</td>
					</tr>	
				</c:if>
			</c:forEach>	
				<c:set var="finaltotalEligibleDeduction" value="${totalMapForJS['total_eligiblededuction']}"/>
			<tr class="success">
				<td colspan="1" style="text-align:right"><b>Total</b></td>				
				<td align="right" style="text-align:right"><b><w4india:inr value="${grandTotal}"/></b></td>
				<td align="right" style="text-align:right"><b><w4india:inr value="${finaltotalEligibleDeduction}"/></b>
				</td>
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
<c:set var="formHTMLComplete">
	<c:if test="${not empty formHTML and ( (empty ischildofform16 )  || ( not empty ischildofform16 &&  not empty uuidform_16) ) }">
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
		    <form id="frmDeduction" method="post" name="frmDeduction" action="${submitDeduction}">
		    	<c:out value="${formHTML}" escapeXml="false"/>
		    	<c:if test="${not empty successURL && not empty uuidform_16}"><input type="hidden" name="successURL" value="${scriptName}/${uuidform_16}/formsixteenedit"/></c:if>
		    	<c:if test="${(pageAction == 'EDIT_CHILD' && not empty editingSection)}"><input type="hidden" name="decuuidform16" value="${editingSection.form16uuid}"/></c:if>
		    	<c:if test="${not empty additionalScreenHTML}"><c:out value="${additionalScreenHTML}" escapeXml="false"/></c:if>
		    	
		    </form>
		  </div>
		  <div class="modal-footer">
		    <a href="<c:choose><c:when test="${not empty modUrlToredirect}"><c:out value="${modUrlToredirect}"/></c:when><c:otherwise><c:out value="${scriptName}?selectedItrTab="/><%=ITRTab.DEDUCTIONS%></c:otherwise></c:choose>" class="btn" data-dismiss="">Close</a>
		    <c:if test="${pageAction =='EDIT_CHILD'}"><button class="btn btn-danger" onclick="$('#frmDeduction').attr('action','<c:out value="${scriptName}"/><c:out value="/${editingSection.canonicalUUID}"/>/deletec6deduction');$('#frmDeduction').attr('method','get');$('#frmDeduction').submit()">Delete</button></c:if>
		    <a href="#" id="deductionSave" class="btn btn-primary">Save changes</a>
		  </div>
		</div>
	</c:if>
</c:set>
<c:choose>
	<c:when test="${empty ischildofform16 || ischildofform16 !='true'}">
		<c:out value="${formHTMLComplete}" escapeXml="false"/>
	</c:when>
	<c:otherwise>
		<% 
			HstRequest hstRequest = (HstRequest) request;
		    String formHTMLComplete = (String) pageContext.getAttribute("formHTMLComplete");
			hstRequest.getRequestContext().setAttribute("formHTMLComplete",formHTMLComplete);
		//request.setAttribute("formHTMLComplete, arg1)
		%>
	</c:otherwise>
</c:choose>
<%-- <a href="${scriptName}?selectedItrTab=<%=ITRTab.FORM16_SINGLE%>" id="test" role="button" class="btn" data-toggle="" ><fmt:message key="back.to.formsixteen" /></a>--%>


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
			
			$('#deductionSave').click(function() {
 				 $('#frmDeduction').submit();
			});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>