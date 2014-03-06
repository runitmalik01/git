<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@page import="com.mootly.wcm.model.FinancialYear"%>
<%@include file="../../includes/tags.jspf" %>
<c:set var="datePattern" value="dd-MM-yyyy"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:choose>
		<c:when test="${not empty pageAction && (pageAction == 'NEW_CHILD') }">	
			<div class="progress progress-striped active" id="qaProgressBar" style="display:none">
			 <div class="progress-bar" id="qaProgressBarReal" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="100" style="width: 1%">
			    <span class="sr-only" id="qaProgressBarRealSROnly">1% Complete</span>
			  </div>
			</div>
			<c:set var="leftColClass" value="col-md-6"/>
			<c:set var="rightColClass" value="col-md-6"/>
			<c:if test="${empty searchResult || empty searchResult.items || fn:length(searchResult.items) == 0 }">
				<c:set var="leftColClass" value="col-md-6"/>
				<c:set var="rightColClass" value="col-md-12"/>
			</c:if>
			<div id="containerQA">
				<div class="row">
					<c:if test="${not empty searchResult && not empty searchResult.items && fn:length(searchResult.items) > 0 }">
						<div class="col-md-6"> 
							<h4><small>Knowledge Articles</small></h4>
							<ul>
								<c:forEach items="${searchResult.items}" var="item">
									<c:set var="hitClassName" value="${hit['class'].simpleName}"/>
									<hst:link var="link" hippobean="${item}"/>
									<li><a href="${link}" target="_new"><c:out value="${item.title}"/></a></li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
					<div class="${rightColClass}"> 
						<h4><small>Submit Question</small></h4>
						<h5><small>Getting help is easy. Type your question and click on Submit. We will be get back to you as soon as possible.</small></h5>
						<form id="frmQuestionAndAnswers" name="frmQuestionAndAnswers" method="POST" action="${actionUrl}">
							<input type="hidden" name="scriptName" id="scriptName" value=""/>
							<input type="hidden" name="fileName" id="fileName" value=""/>
							<%-- Help Desk Ticket Id --%>
							<c:if test="${empty pageAction || pageAction != 'NEW_CHILD' }">		
								<div class="row show-grid">
									<div class="col-md-2">Ticket #</div>
									<div class="col-md-10">
										<c:choose>
											<c:when test="${not empty pageAction && (pageAction == 'NEW_CHILD') }">			
											</c:when>
											<c:otherwise>				
												${document.identifier}
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</c:if>
							
							<div class="row show-grid">
								<div class="col-md-12">
									<c:choose>
										<c:when test="${not empty pageAction && (pageAction == 'NEW_CHILD') }">		
											<textarea id="question" type="text" name="question"></textarea>
										</c:when>
										<c:otherwise>				
											${document.title}
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<button id="hrefCancelQuestion" type="reset" class="btn btn-info">Cancel</button>
							<a id="hrefSaveQuestion" role="button" class="btn btn-default orange">Submit Question</a>
						</form>
					</div>
				</div>
				<hr/>
				</div>
		</c:when>
		<c:when test="${not empty pageAction && (pageAction == 'EDIT_CHILD') }">	
			<%response.setContentType("application/json");%>
			{"hstActionURL":"<c:out value="${hstURL}"/>"}
		</c:when>
		<c:otherwise>
			<w4india:itrmenu />
			<div class="row show-grid">
				<w4india:itrsidebar></w4india:itrsidebar>
				<div class="${sideBarMainClass}">
	  				<w4india:titleandnav title="Questions & Answers" subTitle="Connect with our experts to get Answers to your questions."></w4india:titleandnav>
					<c:if test="${not empty parentBean && not empty parentBean.notes && fn:length(parentBean.notes) > 0 }">
						<table>
							<tr>
								<th>Question</th>
								<th>Answer</th>
								<th>Screen</th>
							</tr>
							<c:forEach items="${parentBean.notes}" var="item" varStatus="varStatus">
								<tr>
									<td><c:out value="${item.question}"/></td>
									<td>
										<small>
											<c:choose>
												<c:when test="${isVendor && strIsOnVendorPortal == 'true'}">
													<textarea readonly="readonly" rows="4" cols="60" name="answer" id="answer_${item.canonicalUUID}"><c:out value="${item.answer}"/></textarea>
													<input type="hidden" name="frmActionURL" id="frmActionURL_${item.canonicalUUID}" value=""/>
													<input type="hidden" name="answered" id="answered_${item.canonicalUUID}" value="true"/>
													<a class="editAnswer" id="href2_${item.canonicalUUID}" href="javascript:void()"><i class="glyphicon glyphicon-pencil"></i> Edit</a>
													<a class="saveAnswer hidden" id="href_${item.canonicalUUID}" href="javascript:void()"><i class="glyphicon glyphicon-save">Save</i></a>
												</c:when>
												<c:otherwise>
													<c:out value="${item.answer}"/>				
												</c:otherwise>
											</c:choose>
										</small>
									</td>
									<td><a href="${scriptName}/../${item.fileName}"><c:out value="${item.fileName}"/></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>
				<hst:element var="jsCustom" name="script">
					<hst:attribute name="type">text/javascript</hst:attribute>
					$(".editAnswer").click(function () { 
				    	uuid = $(this).attr("id").substring(6); //href2_
				    		$.ajax({
		        	  		  type:"GET",
							  url: '${scriptName}/edit-child'
							}).done(function( html ) {
								//alert(html.hstActionURL);
								$("#frmActionURL_"+uuid).val(html.hstActionURL);
								$("#answer_"+uuid).removeAttr('readonly'); //var ans = $("#answer_"+uuid).attr('readonly','readonly');
								$("#href_"+uuid).removeClass("hidden");
								$(this).hide();
							  	//$("#qaProgressBar").hide();
							  	//$( "#questionandanswerformdiv" ).html('<div class="alert alert-info alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>We have received your question.Our experts will review the question and get back to you soon. You will be notified via an email when an answer is posted.</div>');
							});
				    });
				    $(".saveAnswer").click(function () { 
				    	$("#answer_"+uuid).attr('readonly','readonly');
				    	var uuid = $(this).attr("id").substring(5);
				    	var ans = $("#answer_"+uuid).val();
				    		$.ajax({
		        	  		  type:"POST",
							  url: $("#frmActionURL_"+uuid).val(),
							  data: {"answer":ans,"uuid":uuid}
							}).done(function( html ) {
								$("#href_"+uuid).addClass("hidden");
								$("#href2_"+uuid).removeClass("hidden");
							});
				    });
					
				</hst:element>
				<hst:headContribution element="${jsCustom}" category="jsInternal" />
			</div>
		</c:otherwise>
	</c:choose>
	
	


