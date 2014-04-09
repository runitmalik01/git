<!doctype html>
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
	<link rel="shortcut icon" href="/favicon.ico?12345" type="image/x-icon">
	<link rel="icon" href="/favicon.ico?1234" type="image/x-icon">
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
    <hst:link var="modernizr" path="/js/modernizr.custom.39581.js"/>
	<script type='text/javascript' src='${modernizr}'></script>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.js"></script>

    <hst:link var="jqueryWaterMark" path="/js/jquery.watermark.min.js"/>
    <script src="${jqueryWaterMark}"></script>
    
    <hst:link var="boostcheckboxjs" path="/js/boostrap_checkbox.js"/>
    <script src="${boostcheckboxjs}"></script>

	<hst:link var="responsive_modernizr" path="/js/responsive-modernizr.js"/>
	<script type='text/javascript' src='${responsive_modernizr}'></script>

	<script type='text/javascript' src='<hst:link path="/js/bootstrap.min.js"></hst:link>'></script>
	<script src="<hst:link path="/js/bootstrap-typeahead.js"></hst:link>"></script>
	
	<div id="wrap" class="hfeed">
		<hst:include ref="header"/>
		<div id="wrapper" class="container clearfix">
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
	    </div><!-- end of #wrapper -->
	</div><!-- end of #container -->
	<hst:include ref="footer"/>
	<hst:headContributions categoryIncludes="jsInternal"/>
	<hst:link var="responsive_scripts" path="/js/responsive-scripts.js"/>
	<script type='text/javascript' src='${responsive_scripts}'></script>
	<hst:link var="responsive_plugin" path="/js/responsive-plugins.js"/>
	<script type='text/javascript' src='${responsive_plugin}'></script>

	<hst:link var="jquery_validate_min" path="/js/jquery.validate.min.js"/>
	<script type='text/javascript' src='${jquery_validate_min}'></script>
	<hst:componentRenderingURL var="ajaxLinkToComponent"></hst:componentRenderingURL>
	<hst:headContributions categoryIncludes="jsExternal"/>
	<script type="text/javascript"  src='<hst:link path="/js/w4india-validations.js"/>'></script>	
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