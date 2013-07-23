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

<hst:headContribution keyHint="rate" category="jsInternal">
     <hst:link path="/js/rate.js" var="rateJs"/>
    <script type="text/javascript" src="${rateJs}"></script>
</hst:headContribution>
<hst:headContribution keyHint="formCss">
    <link rel="stylesheet" href="<hst:link path="/css/easyforms.css"/>" type="text/css"/>
</hst:headContribution>

<ol id="breadcrumbs">
	<li><fmt:message key="products.detail.location.label"/></li>
	<li>
	    <hst:link var="home" siteMapItemRefId="home" />
	    <a href="${home}"><fmt:message key="products.detail.location.home"/></a> &gt;
	</li>
	<li>
	    <hst:link var="incometaxreturns" siteMapItemRefId="incometaxreturns" />
	    <a href="${incometaxreturns}">Income Tax Returns</a>
	</li>
</ol>
<c:out value="${cmd}"/>
DETAIL PAGE
<c:if test="${preview && inlineEditingEnabled}">
    <jsp:include page="../inc/inline-editing-editor-form.jsp"/>
</c:if>
