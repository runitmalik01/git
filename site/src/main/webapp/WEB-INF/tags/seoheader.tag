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

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="title" type="java.lang.String" required="true" rtexprvalue="true" %>
<%@ attribute name="description" type="java.lang.String" required="false" rtexprvalue="true" %>
<%@ attribute name="keywords" type="java.lang.String" required="false" rtexprvalue="true" %>
<%@ attribute name="robots" type="java.lang.String" required="false" rtexprvalue="true" %>

<link rel="schema.DC" href="http://purl.org/dc/elements/1.1/" />
<link rel="schema.DCTERMS" href="http://purl.org/dc/terms/" />
    
<hst:defineObjects/>
<c:set var="theTitle">
 <c:set var="channelInfo" value="${hstRequest.requestContext.resolvedMount.mount.channelInfo}"/>
  <c:set var="separator" value=""/>
  <c:if test="${not empty title}"><c:out value="${title}"/></c:if>
  <c:if test="${not empty channelInfo and not empty channelInfo.resellerName}">
     <c:set var="separator" value=" - "/>
     <c:out value="${channelInfo.resellerName}"/>
  </c:if>
 </c:set>
<hst:element var="head" name="title">
  <c:out value="${theTitle}"/>
</hst:element>

<hst:element var="dcTitle" name="meta">
  <hst:attribute name="name">DC.title</hst:attribute>
  <hst:attribute name="content" value="${theTitle}"/>
</hst:element>

<hst:headContribution keyHint="title" element="${head}" category="seoheader" />
<hst:headContribution keyHint="dcTitle" element="${dcTitle}" category="seoheader" />


<c:if test="${not empty  description && fn:trim(description) != '' }">
	<hst:element var="metaDescription" name="meta">
  		<hst:attribute name="name">description</hst:attribute>
  		<hst:attribute name="content" value="${description}"/>
	</hst:element>
	<hst:headContribution element="${metaDescription}" category="seoheader" />
</c:if>

<c:choose>
	<c:when test="${not empty robots && fn:trim(robots) != '' }">
		<hst:element var="metaRobots" name="meta">
	  		<hst:attribute name="name">robots</hst:attribute>
	  		<hst:attribute name="content" value="${robots}"/>
		</hst:element>
		<hst:headContribution element="${metaRobots}" category="seoheader" />	
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${empty keywords || fn:trim(keywords) == '' }">
		<hst:element var="metaKeywords" name="meta">
	  		<hst:attribute name="name">robots</hst:attribute>
	  		<hst:attribute name="content" value="${keywords}"/>
		</hst:element>
		<hst:headContribution element="${metaKeywords}" category="seoheader" />	
	</c:when>
</c:choose>

<%--
	
    <meta name="DC.keywords" content="<fmt:message key="layout.webpage.metadckeywords"/>" />
    <meta name="description" content="<fmt:message key="layout.webpage.metadescription"/>" />
    <meta name="DC.type" content="webpagina" scheme="THC.type" />
    <meta name="DCTERMS.issued" content="2009-07-09T10:31" scheme="DCTERMS.W3CDTF" />
    <meta name="DCTERMS.available" content="2009-07-09T10:31" scheme="DCTERMS.W3CDTF" />
    <meta name="DC.title" content="<fmt:message key="layout.webpage.metadctitle"/>" />
    <meta name="DC.language" content="en" scheme="DCTERMS.RFC3066" />
 --%>
