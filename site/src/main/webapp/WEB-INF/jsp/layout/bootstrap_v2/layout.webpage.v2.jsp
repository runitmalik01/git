<!DOCTYPE html>
<!--[if !IE]>      <html class="no-js non-ie" lang="en-US"> <![endif]-->
<!--[if IE 7 ]>    <html class="no-js ie7" lang="en-US"> <![endif]-->
<!--[if IE 8 ]>    <html class="no-js ie8" lang="en-US"> <![endif]-->
<!--[if IE 9 ]>    <html class="no-js ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en-US"> <!--<![endif]-->
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
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../includes/tags.jspf" %>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<c:set var="lang" value="${pageContext.request.locale.language}"/>
<head>
	<hst:headContributions categoryExcludes="css,jsInternal,jsExternal"  />
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
	<%-- <meta name='robots' content='noindex,nofollow' /> --%>		
	<hst:link var="stylecss" path="/css/style-stripped.css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="${stylecss}"/>
    <hst:link var="w4indiacss" path="/css/w4india.css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="${w4indiacss}"/>
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootstrap.css"></hst:link>'/>
    <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootstrap-responsive.css"></hst:link>'/>
    <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootstrap.flat.min.css"></hst:link>'/>    
	
	<!-- <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootplus.css"></hst:link>'/> -->
	<!-- <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/font-awesome-min.css"></hst:link>'/> -->
	<link rel="stylesheet" media="screen" type="text/css" href="<hst:link path="/css/author.css"></hst:link>"/>
    <hst:headContributions categoryIncludes="css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="<hst:link path="/css/dropdown-submenu.css"></hst:link>"/>
    <link rel="stylesheet" media="screen" type="text/css" href="<hst:link path="/css/boostrap_login-signup.css"></hst:link>"/>
    <hst:headContributions categoryIncludes="jsHead"/>    
</head>
<body class="<c:choose><c:when test="${not empty strIsOnVendorPortal}">page-vendor</c:when><c:when test="${not empty bodyCssClass}"><c:out value="${bodyCssClass}"/></c:when><c:otherwise>page</c:otherwise></c:choose>">

	<div id="wrap"> 
	<hst:include ref="header"/>
	<c:if test="${not empty isError && error.key == 'true' && loggedin == 'true'}">
		<c:choose>
			<c:when test="${not empty error.key}">
				<span class="label label-default label-warning"><c:out value="${error.key}" escapeXml="false"/></span>
			</c:when>
			<c:otherwise>
				<span class="label label-default label-warning">There was an error processing your request</span>
			</c:otherwise>
		</c:choose>				
	</c:if>
	<hst:include ref="main"/>
	<hst:headContributions categoryIncludes="customHTML" xhtml="false"/>
	</div>
	<hst:include ref="footer"/>
	<script type="text/javascript"  src='<hst:link path="/js/w4india-validations.js"/>'></script>
	<script type="text/javascript">
	 	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-41164129-1', '<w4india:resellername/>.com');
		  ga('send', 'pageview');
	</script>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-41164129-2', '<w4india:resellername/>.com');
	  ga('send', 'pageview');	
	</script>
</body>
</html>
