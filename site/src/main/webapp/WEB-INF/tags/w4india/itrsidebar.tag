  <%--
Page Title and Navigation Links
 --%>
<%@tag import="com.mootly.wcm.beans.DITResponseDocument"%>
<%@tag import="com.mootly.wcm.beans.compound.DITResponseDocumentDetail"%>
<%@tag import="com.mootly.wcm.beans.HelpDeskTicketDocument"%>
<%@tag import="java.util.LinkedList"%>
<%@tag import="java.util.List"%>
<%@tag import="java.util.Map"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%
int totalUnReadAnswers = 0;
HelpDeskTicketDocument helpDeskTicketDocument = (HelpDeskTicketDocument) request.getAttribute(HelpDeskTicketDocument.class.getSimpleName().toLowerCase());
if ( helpDeskTicketDocument != null ) {
	totalUnReadAnswers = helpDeskTicketDocument.getTotalUnReadAnswers();
}

%>

 <c:if test="${nomenu != 'true'}">
	 <div class="col-md-2" style="border-right:1px solid black;"> 
	 		<a id="lnkAskQuestion" href="javascript:void();" class="btn btn-success btn-block"><i class="glyphicon glyphicon-question-sign"></i>Help</a>
			<a href="${scriptName}/../efile-incometax.html" class="btn btn-warning btn-block"><i class="glyphicon glyphicon-paperclip"></i>eFile</a>
			<a href="${scriptName}/../servicerequest-itr-summary.html" class="btn btn-default btn-block"><small>View Tax Summary</small></a>
			<h5><b>Your Tax Return</b></h5>
			<ul class="nav nav-pills nav-stacked">	
			     <li>
					<a href="${scriptName}/../questionandanswers.html"><i class="glyphicon glyphicon-question-sign"></i><small> Answers</small><span class="label label-warning badge pull-right"><small><%=totalUnReadAnswers%></small></span></a>
			     </li>	  
			     <li>
					<a href="#"><i class="glyphicon glyphicon-question-sign"></i><small> Suggestions</small><span class="label label-warning badge pull-right"><small>0</small></span></a>
			     </li>		
			     <%--
			     <li>
					<a href="#"><i class="glyphicon glyphicon-warning-sign"></i><small> Warnings</small>
						<span class="label label-warning badge pull-right">
							<small>								
								<c:choose>
									<c:when test="${not empty hippoBeanValidationResponse_totalWarnings}">
										<c:out value="${hippoBeanValidationResponse_totalWarnings}"/>
									</c:when>
									<c:otherwise>
										0
									</c:otherwise>
								</c:choose>
							</small>
						</span>
					</a>
			     </li>		
			     --%>		     		
			     <li>
					<a href="${scriptName}/../errors-warnings.html"><i class="glyphicon glyphicon-ban-circle"></i><small> <span color="red">Errors</span></small>
						<span class="badge pull-right">
							<small>
								<c:choose>
									<c:when test="${not empty hippoBeanValidationResponse_totalErrors}">
										<c:out value="${hippoBeanValidationResponse_totalErrors}"/>
									</c:when>
									<c:otherwise>
										0
									</c:otherwise>
								</c:choose>
							</small>
						</span>
					</a>
			     </li>	  	
			</ul>
			<h5><b>Services</b></h5>
			<ul class="nav nav-pills nav-stacked">	
					<%--
				     <li>
						<a href="${scriptName}/../digitalsignature.html"><i class="glyphicon glyphicon-check"></i><small> Digital Signature</small></a>
				     </li>	
				     --%>
				     <li>
						<a href="${scriptName}/../attachdoc.html"><i class="glyphicon glyphicon-upload"></i><small> My Documents</small></a>
				     </li>	
				     <%--
				     <li>
						<a href="#"><i class="glyphicon glyphicon-certificate"></i><small> Peace of Mind</small></a>
				     </li>		  
				      --%>		    
				</ul>
		        <h5><b>Contact Us</b></h5>
				<ul class="nav nav-pills nav-stacked">		  	    
				     <li>
				     	<a href="#"><small><i class="glyphicon glyphicon-phone-alt"></i> 91-11-45067102</small></a>
				     </li>
	 				 <li>
				     	<a href="mailto:info@wealth4india.com"><small><i class="glyphicon glyphicon-envelope"></i> Email</small></a>
				     </li>			     
				</ul>
		  	</div>
		  	
		  	<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>
		    $(document).ready ( function() {
		   		$("#lnkAskQuestion").click ( function () {
	        	  		$.ajax({
						  url: "${scriptName}/../questionandanswers.html/new-ajax",
						  data: 'fileName=${fileName}'
						}).done(function( html ) {
						  $( "#questionandanswerformdiv" ).show();
						  $( "#questionandanswerformdiv" ).html( html );
						  if ($("#hrefCancelQuestion").length > 0 ) { 
						  	$("#hrefCancelQuestion").click (function () {
						  		$("#containerQA").hide();
						  		$("#qaProgressBar").hide();
						  		$( "#questionandanswerformdiv" ).hide();
						  		$("#note").focus();
						  	});
						  }
						  if ($("#hrefSaveQuestion").length > 0 ) { 
					        	  $("#hrefSaveQuestion").click( function ()  {
					        	    $("#containerQA").hide();
					        	    $("#qaProgressBar").show();
					        	    $("#scriptName").val('<c:out value="${scriptName}"/>');
					        	    $("#fileName").val('<c:out value="${fileName}"/>');
					        	    progress=45;
					        	    var myVar= setInterval(function(){    
					        	    	progress+=10;
					        	    	if (progress > 95) {
					        	    		progress = 95;
					        	    		clearInterval(myVar);
					        	    	}
					        	    	$("#qaProgressBarReal").attr("aria-valuenow",progress);
					        	    	//style="width: 45%"
					        	    	$("#qaProgressBarReal").attr("style","width: "+ progress + "%");
					        	    	$("#qaProgressBarRealSROnly").html((45+10)+ "% Complete");
					        	    },1000);
					        	  	var frmData = $("#frmQuestionAndAnswers").serialize();
					        	  	$.ajax({
					        	  		  type:"POST",
										  url: $("#frmQuestionAndAnswers").attr("action"),
										  data: frmData
										}).done(function( html ) {
										  	$("#qaProgressBar").hide();
										  	$( "#questionandanswerformdiv" ).html('<div class="alert alert-info alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>We have received your question.Our experts will review the question and get back to you soon. You will be notified via an email when an answer is posted.</div>');
										});
					        	  } );
					       }
						});
	        	  });
	        	  
	        	  $( "#frmQuestionAndAnswers" ).submit(function( event ) {
	        	  	event.preventDefault();
	        	  });
		   		
		   });
		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal" />
	</c:if>