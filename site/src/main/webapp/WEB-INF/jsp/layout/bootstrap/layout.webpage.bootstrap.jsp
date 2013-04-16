<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
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
<c:set var="lang" value="${pageContext.request.locale.language}"/>
	<head>
		<hst:headContributions categoryExcludes="css,jsInternal,jsExternal" />
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<title></title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<style>
			body {
			padding-top: 60px;
			padding-bottom: 40px;
			}
			.green { color: #1e6c22;}
			.orange {color: #ff6300;}
		</style>
		<link rel="stylesheet" href="<hst:link path="/css/bootstrap-responsive.min.css"/>"/>
		<link rel="stylesheet" href="<hst:link path="/css/main.css"/>"/>
		<hst:headContributions categoryIncludes="css"/>
		<hst:link var="responsive_modernizr" path="/js/responsive-modernizr.js"/>
		<script type="text/javascript" src="${responsive_modernizr}"></script>
	</head>
	<body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
		<hst:include ref="header"/>	
		<hst:include ref="main"/>
		<hst:include ref="footer"/>
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.js"><\/script>')</script>
        <hst:link var="bootstrapmin" path="/js/vendor/bootstrap.min.js"/>
        <script src="${bootstrapmin}"></script>
        <hst:link var="mainjs" path="/js/main.js"/>
        <script src="${mainjs}"></script>
		<hst:headContributions categoryIncludes="jsInternal"/>
		<hst:headContributions categoryIncludes="jsExternal"/>
		<script>
			$.datepicker.setDefaults({
			  showOn: "both",
			  buttonImageOnly: true,
	          buttonImage: "<hst:link path="/img/calendar.gif"/>",
			  buttonText: "Calendar",
		      dateFormat: "dd/mm/yy"
			});
			$.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
		</script>
	</body>
</html>
 