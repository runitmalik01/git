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
	<w4india:itrmenu />
	<div class="row show-grid">
		<w4india:itrsidebar></w4india:itrsidebar>
		<div class="${sideBarMainClass}">
			<w4india:titleandnav title="Chapter VI A Deductions"/>
			<%--
			<div class="alert alert-info" id="chkentry">As some of the deductions are based on your income. Please ensure to fill all your total income before filling up deductions for an accurate summary of your return.</div>
			 --%>
				<table class="table table-hover table-bordered">
					<tr>
						<th>Deduction Section</th>
						<th><abbr title="How much money you have invested?">Gross Investment (&#8377;)</abbr></th>
						<th><abbr title="Maximum Allowed Deduction">Total Deduction (&#8377;)</abbr></th>
					</tr>
					<c:forEach items="${deductionSectionMap}" var="deductionSectionMapEntry">
						<c:set var="skipIt" value="false"/>
						<c:set var="totalEligibleDeduction" value="0"/>
						<c:set var="deductionSectionName" value="${deductionSectionMapEntry.key}"/>
						<c:set var="deductionSectionLabel" value="${deductionSectionMapEntry.value.additionalProperties['label']}"/>
						<c:set var="deductionAdditionalScreen" value="${deductionSectionMapEntry.value.additionalProperties['additionalScreen']}"/>
						<c:set var="appliesToFilingStatus" value="${deductionSectionMapEntry.value.additionalProperties['filingStatus']}"/>
						<c:set var="appliesToResidentStatus" value="${deductionSectionMapEntry.value.additionalProperties['residentStatus']}"/>
						<c:set var="isDerived" value="${deductionSectionMapEntry.value.additionalProperties['isDerived']}"/>
						<c:set var="appliesToItrForm" value="${deductionSectionMapEntry.value.additionalProperties['itrform']}"/>
						<c:choose>
							<c:when test="${empty ischildofform16 || ischildofform16 !='true'}">
								<c:set var="addURL" value="${scriptName}/newc6deduction/${deductionSectionName}"/>
								<%-- <c:if test="${not empty appliesToFilingStatus && ( (filingStatus.name == appliesToFilingStatus) || fn:contains(filingStatus,appliesToFilingStatus))}">--%>
								<c:if test="${not empty appliesToFilingStatus && !fn:contains(fn:toUpperCase(fn:trim(appliesToFilingStatus)),fn:toUpperCase(fn:trim(memberpersonalinformation.filingStatus)))}">
									<c:set var="skipIt" value="true"/>
								</c:if>
								<c:if test="${skipIt != 'true' && not empty appliesToResidentStatus && memberpersonalinformation.residentCategory != appliesToResidentStatus}">
									<c:set var="skipIt" value="true"/>
								</c:if>
								<!--Show Deduction section According to Package i.e ITR_FORM  -->
								<c:if test="${skipIt != 'true' && not empty appliesToItrForm && !fn:contains(appliesToItrForm,fn:toLowerCase(memberpersonalinformation.selectedITRForm))}">
									<c:set var="skipIt" value="true"/>
								</c:if>						
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
										<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><c:out value="${deductionSectionLabel}"/><span class="caret"></span></button>
										<ul class="dropdown-menu">
							            	<li>
												<c:choose>
													<c:when test="${deductionSectionName == '80tta'}">
														<li><a href="./othersources.html">Add</a></li>
													</c:when>
													<c:otherwise>
														<a href="${addURL}">Add</a>
													</c:otherwise>
							            		</c:choose>
							            	</li>
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
												<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><w4india:inr value="${totalOfSavedData[deductionSectionName]}"></w4india:inr><span class="caret"></span></button>
												<ul class="dropdown-menu">
													<!-- <li class="divider"></li> -->
													<c:choose>
														<c:when test="${deductionSectionName == '80tta'}">
															<li><a href="./othersources.html">Edit</a></li>
														</c:when>
														<c:when test="${not empty savedData && not empty savedData[deductionSectionName] && (empty isDerived || isDerived == 'false')}">
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
														</c:when>
													</c:choose>
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
		<%-- 
		<c:if test="${fn:toLowerCase(memberpersonalinformation.selectedITRForm) == 'itr4' }">
		<hst:include ref="ded-sched-10a"/>
		</c:if>--%>
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
				<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					    <h3><c:out value="${modalHeading}"/></h3>
					  </div>
					  <div class="modal-body">
						<c:if test="${not empty formMap}">
							<c:forEach items="${formMap.message}" var="item">
								<div class="alert alert-danger"><fmt:message key="${item.value}" /></div>
							</c:forEach>
						</c:if>
						<hst:actionURL var="submitDeduction"></hst:actionURL>
					    <form id="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}">frmDeduction</c:when><c:otherwise>row_0</c:otherwise></c:choose>" method="post" name="frmDeduction" action="${submitDeduction}" class="frmDeduction">
							<c:out value="${formHTML}" escapeXml="false"/>
							<c:if test="${not empty successURL && not empty uuidform_16}"><input type="hidden" name="successURL" value="${scriptName}/${uuidform_16}/formsixteenedit"/></c:if>
							<c:if test="${(pageAction == 'EDIT_CHILD' && not empty editingSection)}"><input type="hidden" name="decuuidform16" value="${childBean.form16Uuid}"/></c:if>
							<c:if test="${not empty additionalScreenHTML}"><c:out value="${additionalScreenHTML}" escapeXml="false"/></c:if>
					    </form>
					  </div>
					  
					  <div class="modal-footer">
					  					    
					    <div class="progress progress-striped active" id="chapterProgressBar" style="display:none">
							<div class="progress-bar" id="chapterProgressBarReal" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
						    	<span class="sr-only" id="chapterProgressBarSROnly">30% Complete</span>
						 	</div>
						</div>
					    <a href="#" class="btn btn-default btn-inverse" id="addNewBtn" style="display:none">Add New</a>
		
					    <a href="<c:choose><c:when test="${not empty modUrlToredirect}"><c:out value="${modUrlToredirect}"/></c:when><c:otherwise><c:out value="${scriptName}?selectedItrTab="/><%=ITRTab.DEDUCTIONS%></c:otherwise></c:choose>" class="btn btn-default" data-dismiss="">Close</a>
					    <c:if test="${pageAction =='EDIT_CHILD'}"><button class="btn btn-default btn-danger" onclick="$('#frmDeduction').attr('action','<c:out value="${scriptName}"/><c:out value="/${editingSection.canonicalUUID}"/>/deletec6deduction');$('#frmDeduction').attr('method','get');$('#frmDeduction').submit()">Delete</button></c:if>
					    <a href="#" id="<c:choose><c:when test="${pageAction =='NEW_CHILD'}">deductionSaveAJAX</c:when><c:otherwise>deductionSave</c:otherwise></c:choose>" class="btn btn-default btn-primary">Save changes</a>
					  </div>
					</div>
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
	</div>
</div>
<%-- <a href="${scriptName}?selectedItrTab=<%=ITRTab.FORM16_SINGLE%>" id="test" role="button" class="btn btn-default" data-toggle="" ><fmt:message key="back.to.formsixteen" /></a>--%>
<res:client-validation formId="frmDeduction" formName="frmDeduction" screenConfigurationDocumentName="doneedetails" formSubmitButtonId="deductionSave" />


<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			if ($("#myModal").length >0) $("#myModal").modal();
			$('#frmdata input,.frmDeduction input').keydown(function(e) {
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

			$(".head").change( function(o) {
					changeD(this);
				}
			);
			changeD($(".head"));
			
			$("#deductionSaveAJAX").click (ajaxSubmit);
			
		});

		function changeD(o) {
			if ($(o).val() == 'others') {
				$(o).parents('.frmDeduction').find(".80cadditional").show();
			}
			else {
				$(o).parents('.frmDeduction').find(".80cadditional").hide();
			}
		}
		
		function ajaxSubmit() {
				allForms = $(".frmDeduction");
				//allForms.validate();
				allForms.each ( function(index,value) {
					$(value).validate();
						if (!$(value).valid()) {
							return false;
						}
					}
			    );
				$("#chapterProgressBar").show();
				
				progress=30;
				increment = parseInt (70 / allForms.length);
				//alert(allForms.length + ":" + increment);
	       	    $("#chapterProgressBarReal").attr("aria-valuenow",progress);
	       	    $("#chapterProgressBarReal").attr("style","width: "+ progress + "%");
	       	    $("#chapterProgressBarReal").html( progress + "% Complete");
	       	    //$("#chapterProgressBarSROnly").html( progress + "% Complete");
				 //$("#deductionSaveAJAX").attr("disabled",true);
	        	 allForms.each ( function(index,value) {
	        	 	progress+=increment;
	        	 	$("#chapterProgressBarReal").attr("aria-valuenow",progress);
	       	    	$("#chapterProgressBarReal").attr("style","width: "+ progress + "%");
	       	    	$("#chapterProgressBarReal").html( progress + "% Complete");
	       	    	//$("#chapterProgressBarSROnly").html( progress + "% Complete");
					theData = $(value).serialize();
					$.ajax('<hst:actionURL></hst:actionURL>',
						{
							'data': theData,
							'method':'POST',
							'async':false											
						}).done (function () {
							//$("#chapterProgressBarSROnly").html((100)+ "% Complete");
							//$("#chapterProgressBar").hide();
							//$(".bar").css('width' , (stepsIncrement * (i +1)) + '%');
						}) ;					
					//$(".progress").removeClass('active');
					window.location.href = '../../chapterVIdeductions.html';
				});// it is right place to end method
		}
		
<c:if test="${pageAction == 'NEW_CHILD' && not empty deductionSection.listOfDeductionHead && deductionSection.name != '80g'}">
			
			jQuery(document).ready(function($) {
				$("#addNewBtn").click( handleBlur );			
				$("#addNewBtn").show();	
				$(".head").rules('add',{'required':true});
			});
			
			function handleBlur() {
				
				arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
				theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.frmDeduction').last();
				var theId  = theForm.attr('id');
				if (theId.indexOf("row_") != -1) {
					theindx = theId.split("_")[1];
					//check if row_1 exists
					var eDiv =  $("#row_" + theindx);
					eDiv.validate();
					if (!eDiv.valid()) return;
					
					var theNewDiv =  $("#row_" + (parseInt(theindx) + 1));
					if (theNewDiv.length == 0) {
						//insertDiv
						html = eDiv.html();
						//<div class="row show-grid" id="row_0">
						//<form id="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}">frmDeduction</c:when><c:otherwise>row_0</c:otherwise></c:choose>" method="post" name="frmDeduction" action="${submitDeduction}" class="frmDeduction">
						var newdiv1 = $('<form class="frmDeduction" name="frmDeduction"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						//alert(html);
						newdiv1.append(html);
						
						$(".modal-body").append(newdiv1);
						
						newdiv1.find(".col-md-4").hide();
						
						//$(".theamount").blur( handleBlur );	
						$(".head").change(headChangeHandler);
						
						$(".head").change( function(o) {
							changeD(this);
							}
						);
						
						
						$('.frmDeduction input').keydown(function(e) {
						    if (e.keyCode == 13) {
						   		e.preventDefault();
						        //$('#frmdata').submit();
						    }
						});
						//alert(html);
					}
				}
			}
			
			$(".head").change(headChangeHandler);
			
			function headChangeHandler() {
				var o = $(this).val();	
				if (o.trim() == '') {
					//hide and remove the corresponding amount button
					$(this).parents(".row").find(".col-md-4").hide();
					$('label[for="investment"]').hide();
				}
				else {
					$(this).parents(".row").find(".col-md-4").show();
					$('label[for="investment"]').show();
				}
			}
			
		</c:if>		
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>    