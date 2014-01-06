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
<%@include file="../includes/tags.jspf" %>

<c:set var="datePattern" value="dd-MM-yyyy"/>
<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set var="inlineEditingEnabled" value="false" /> 

<c:if test="${preview}">
    <c:if test="${inlineEditingEnabled}">
        <jsp:include page="../inc/inline-editing-head-contributions.jsp"/>
    </c:if>
</c:if>
<c:if test="${isVendor == 'true'}">
	<c:if test="${not empty nodeName}">
		<a class="btn btn-default btn-primary" href='<hst:link path="/knowledgeportal/knowledgearticle/edit/${nodeName}.html"/>'><small><i class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small></a>
		<a class="btn btn-default btn-danger" href='<hst:link path="/knowledgeportal/knowledgearticle/delete/${nodeName}.html"/>'><i class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small></a>
		
	</c:if>
</c:if>
<div class="page">
	<form name="frmKB" id="frmKB" action="<hst:actionURL/>" method="post">
	
		<c:choose>
			<c:when test="${not empty pageAction && pageAction == 'EDIT' || pageAction == 'NEW'}">
				 <h3>Title</h3>
				 <input type="text" name="title" value="${document.title}"/>
			</c:when>
			<c:otherwise>
				<h4><c:out value="${document.title}"/></h4>	
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${not empty pageAction && pageAction == 'EDIT' || pageAction == 'NEW'} ">
				 <h3>Summary</h3>
				 <input type="text" name="summary" value="${document.summary}"/>
			</c:when>
			<c:otherwise>
				<h4><c:out value="${document.summary}"/></h4>	
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${not empty pageAction && pageAction == 'EDIT' || pageAction == 'NEW' }">
				<h3>Description</h3>
				<textarea name="description" id="description" rows="20">
					<c:out value="${document.description.content}" escapeXml="false"/>
				</textarea>
				<w4india:ckeditor_inline textAreaId="description"/>
				<%-- <w4india:richtexteditor/>   --%>
			</c:when>
			<c:otherwise>
				<p>
					<c:out value="${document.description.content}" escapeXml="false"/>
				</p>
			</c:otherwise>
		</c:choose>	
		
		<c:choose>
			<c:when test="${not empty pageAction && pageAction == 'EDIT' || pageAction == 'NEW'}">
				<a href="javascript:$('#frmKB').submit();" id="hrefSave" class="btn btn-default btn-success">Save</a>
			</c:when>
		</c:choose>	
	</form>
</div>


<hst:headContribution keyHint="formCss">
    <link rel="stylesheet" href="<hst:link path="/css/easyforms.css"/>" type="text/css"/>
</hst:headContribution>

<%--<ga:trackDocument hippoDocumentBean="${document}"/> --%>

<c:if test="${preview && inlineEditingEnabled}">
    <jsp:include page="../inc/inline-editing-editor-form.jsp"/>
</c:if>
