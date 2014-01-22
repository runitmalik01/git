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
<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set var="inlineEditingEnabled" value="false" /> 

<c:if test="${preview}">
    <c:if test="${inlineEditingEnabled}">
        <jsp:include page="../../inc/inline-editing-head-contributions.jsp"/>
    </c:if>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>

<form id="frmHelpDesk" name="frmHelpDesk" method="POST" action="${actionUrl}" enctype="multipart/form-data">
	<%-- Help Desk Ticket Id --%>
	<div class="row show-grid">
		<div class="col-md-2">Ticket #</div>
		<div class="col-md-10">
			<c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">			
				</c:when>
				<c:otherwise>				
					${document.identifier}
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="row show-grid">
		<div class="col-md-2"><label for="title">Summary</label></div>
		<div class="col-md-10">
			<c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">		
					<input id="title" type="text" name="title" value="${document.title}"/>	
				</c:when>
				<c:otherwise>				
					${document.title}
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="row show-grid">
		<div class="col-md-2"><label for="problemCategory">Problem Category</label></div>
		<div class="col-md-10">
			<c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">
					<select id="problemCategory" name="problemCategory" value="${document.problemCategory}">
						<option value="itreturn">Income Tax Return (New)</option>
						<option value="itreturn">Income Tax Return (Existing)</option>
					</select>
				</c:when>
				<c:otherwise>
					${document.problemCategory}"
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="row show-grid">
		<div class="col-md-2"><label for="assessmentYear">Assessment Year</label></div>
		<div class="col-md-10">
			<c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">
					<select id="assessmentYear" name="assessmentYear" >
						<% 
							for (FinancialYear financialYear:FinancialYear.values()) {
								if (financialYear.isActive() && financialYear != FinancialYear.UNKNOWN) {
									out.println("<option value='" + financialYear.name() + "'>" + financialYear.getDisplayAssessmentYear() + "</option>");
								}
							}
						%>
					</select>
				</c:when>
				<c:otherwise>
					<c:out value="${document.assessmentYear}"/>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<!--  Problem Description -->
	<div class="row show-grid">
		<div class="col-md-2">Description</div>
		<div class="col-md-10">
			<c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">		
					<textarea id="description" name="description" rows="5" >${document.description}</textarea>
				</c:when>
				<c:otherwise>				
					<c:out value="${document.description}"/>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="row show-grid">
	 <div class="col-md-3">Attachments</div>
	 <div class="col-md-10">
	 <c:choose>
				<c:when test="${not empty pageAction && pageAction == 'NEW_CHILD' || pageAction == 'NEW' }">
			        <div class="rowlabel">
			                  <span class="btn btn-default btn-success fileinput-button" id="remove">
                                <input type="file" id="member_file" name="member_file" multiple="multiple"/>
                             </span>
			             <div id="member_file_name"></div>
			        </div></c:when>
				<c:otherwise>				
					${document.member_file}
				</c:otherwise>
			</c:choose>
			</div>   
	</div>
	<c:if test="${not empty pageAction && pageAction == 'NEW_CHILD'}">
		<div class="row show-grid">
			<div class="col-md-2">Add a Note</div>
			<div class="col-md-10">
				<textarea id="note" name="note" rows="5"></textarea>
			</div>
		</div>		
	</c:if>
	
	<c:forEach items="${document.notes}" var="aNote">
		<c:out value="${aNote.updaterType}"/>
		<hr/>
		<c:out value="${aNote.note}"/>
		<hr/>
	</c:forEach>
	 <div class="rowlabel">
						<input type="submit" class="btn btn-default btn-success" value="Save">
					</div>
	
</form>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		$('#member_file').bind('change', function(){
		    $('#member_file_name').text(this.files[0].name);
		    //$('#file_process').show();		    
          });
		$('#member_file').popover({"html":true,
		                 "trigger":"hover",
		                 delay: { show: 500, hide: 100 },
		                 content:"Select a File to Upload in Ticket or Drag Here"
		  });
		 function uploadDoc(){
		    $('#memberdrive').submit();
		    }
		    </hst:element>
		    <c:if test="${preview && inlineEditingEnabled}">
	<jsp:include page="../../inc/inline-editing-editor-form.jsp" />
</c:if>
<res:client-validation
	screenConfigurationDocumentName="helpdeskticket"
	formId="frmHelpDesk" formSubmitButtonId="hrefSave"/>

