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

<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/fonts/fonts-min.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/calendar/assets/skins/sam/calendar.css" />
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/calendar/calendar-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/element/element-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datasource/datasource-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/event-delegate/event-delegate-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<style type="text/css">
/* custom styles for this example */
.yui-skin-sam .yui-dt-col-address pre { font-family:arial;font-size:100%; } /* Use PRE in first col to preserve linebreaks*/
</style>


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

This form will include the real form based on two variables
filing_year and formName passed as request variables
<%
String filingYear = (String)request.getAttribute("filing_year");
String formName = (String) request.getAttribute("formName");
String pageParam = (String) request.getAttribute(com.mootly.wcm.utils.Constants.PAGE);

String pageName = filingYear + "/" + formName;

if (pageParam == null) {
	pageName += "/page1.jsp";
}
else {
	pageName += "/page" + pageParam + ".jsp";
}

%>
<%=pageName%>
<jsp:include page="<%=pageName%>"/>


<c:if test="${preview && inlineEditingEnabled}">
    <jsp:include page="../inc/inline-editing-editor-form.jsp"/>
</c:if>
