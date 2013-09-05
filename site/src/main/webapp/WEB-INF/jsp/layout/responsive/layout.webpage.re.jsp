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
    <hst:headContributions categoryExcludes="css,jsInternal,jsExternal"  />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<link rel="schema.DC" href="http://purl.org/dc/elements/1.1/" />
    <link rel="schema.DCTERMS" href="http://purl.org/dc/terms/" />
    <meta name="DC.keywords" content="<fmt:message key="layout.webpage.metadckeywords"/>" />
    <meta name="description" content="<fmt:message key="layout.webpage.metadescription"/>" />
    <meta name="DC.type" content="webpagina" scheme="THC.type" />
    <meta name="DCTERMS.issued" content="2009-07-09T10:31" scheme="DCTERMS.W3CDTF" />
    <meta name="DCTERMS.available" content="2009-07-09T10:31" scheme="DCTERMS.W3CDTF" />
    <meta name="DC.title" content="<fmt:message key="layout.webpage.metadctitle"/>" />
    <meta name="DC.language" content="en" scheme="DCTERMS.RFC3066" />
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
	<%-- <meta name='robots' content='noindex,nofollow' /> --%>	
	<hst:link var="stylecss" path="/css/style.css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="${stylecss}"/>
    <hst:link var="w4indiacss" path="/css/w4india.css"/>
    <link rel="stylesheet" media="screen" type="text/css" href="${w4indiacss}"/>
    <link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootstrap.css"></hst:link>'/>
	<link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootstrap-responsive.css"></hst:link>'/>
	<!-- <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/bootplus.css"></hst:link>'/> -->
	<!-- <link rel="stylesheet" media="screen" type="text/css" href='<hst:link path="/css/font-awesome-min.css"></hst:link>'/> -->
	<link rel="stylesheet" media="screen" type="text/css" href="<hst:link path="/css/author.css"></hst:link>"/>
    <hst:headContributions categoryIncludes="css"/>
</head>
<body class="<c:choose><c:when test="${not empty strIsOnVendorPortal}">page-vendor</c:when><c:when test="${not empty bodyCssClass}"><c:out value="${bodyCssClass}"/></c:when><c:otherwise>page</c:otherwise></c:choose>">
    <hst:link var="modernizr" path="/js/modernizr.custom.39581.js"/>
	<script type='text/javascript' src='${modernizr}'></script>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.js"></script>

    <hst:link var="jqueryWaterMark" path="/js/jquery.watermark.min.js"/>
    <script src="${jqueryWaterMark}"></script>



	<hst:link var="responsive_modernizr" path="/js/responsive-modernizr.js"/>
	<script type='text/javascript' src='${responsive_modernizr}'></script>

	<script type='text/javascript' src='<hst:link path="/js/bootstrap.min.js"></hst:link>'></script>
	<script src="<hst:link path="/js/bootstrap-typeahead.js"></hst:link>"></script>
	
	<script src="<hst:link path="/js/simpleCart.min.js"></hst:link>"></script>
	<script>
			simpleCart.currency({
			    code: "INR" ,
			    name: "Indian Rupees" ,
			    symbol: "&#8377;" ,
			    accuracy: 2
			});
		  simpleCart({
		    checkout: {
		      type: "PayPal",
		      email: "you@yours.com"
		    },
		    currency: "INR"
		  });
	</script>
	<div id="container" class="hfeed">
		<hst:include ref="header"/>
		<div id="wrapper" class="clearfix">
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
	<script>
		$.datepicker.setDefaults({
		  /*showOn: "both",*/
		  /*buttonImageOnly: true,
          buttonImage: "<hst:link path="/img/calendar.gif"/>",*/
		  /*buttonText: "Calendar",*/
	      dateFormat: "dd/mm/yy"
		});
		$.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
		$.validator.addMethod("pan", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z]{3}[p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G][a-zA-Z]\d{4}[a-zA-Z]{1}?$/i.test(value);
		}, "PAN is invalid.");
		$.validator.addMethod("amount", function(value, element) {
		   	 return this.optional(element) || /^[0-9]+\.?[0-9]{0,2}?$/i.test(value);
		}, "AMOUNT is invalid.");
		$.validator.addMethod("percentage", function(value, element) {
		   	 return this.optional(element) || /^(100(\.00?)?|[1-9]?\d(\.\d\d?)?)?$/i.test(value);
		}, "Percentage is invalid.");
		$.validator.addMethod("max", function(value, element) {
		   	 return this.optional(element) || /^([0-9]+\.?[0-9]{0,2}){0,14}?$/i.test(value);
		}, "Max length allowed is 14.");
		$.validator.addMethod("pin", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{6}?$/i.test(value);
		}, "PIN Code is invalid");
		$.validator.addMethod("std", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{1,5}?$/i.test(value);
		}, "STD Code is invalid");
		$.validator.addMethod("mobile", function(value, element) {
		   	 return this.optional(element) || /^[1-9]{1}[0-9]{9}?$/i.test(value);
		}, "Mobile No is invalid");
		$.validator.addMethod("email", function(value, element) {
		   	 return this.optional(element) || /^([\.a-zA-Z0-9_\-])+@([a-zA-Z0-9_\-])+(([a-zA-Z0-9_\-])*\.([a-zA-Z0-9_\-])+)+?$/i.test(value);
		}, "Email-ID is invalid");
		$.validator.addMethod("accountno", function(value, element) {
		   	 return this.optional(element) || /^[0-9A-Za-z]{10,}$/i.test(value);
		}, "Account No is invalid");
		$.validator.addMethod("micr", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{9}?$/i.test(value);
		}, "MICR Code is invalid");
		$.validator.addMethod("ifsc", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{4}[0]{1}[a-zA-Z0-9]{6}?$/i.test(value);
		}, "IFSC Code is invalid");
		$.validator.addMethod("tan", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z]{4}[0-9]{5}[a-zA-Z]{1}?$/i.test(value);
		}, "TAN is invalid");
		$.validator.addMethod("bsr", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{7}?$/i.test(value);
		}, "BSR Code is invalid");
		$.validator.addMethod("serial", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{0,5}?$/i.test(value);
		}, "Challan Serial No is invalid");
		$.validator.addMethod("tdscertificate", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{0,8}?$/i.test(value);
		}, "TDS Certificate No is invalid");
		$.validator.addMethod("ackno", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{15}?$/i.test(value);
		}, "Ack No is invalid");
		$.validator.addMethod("indiandate", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateAdvance", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateSelfAssesment", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateLosses", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("chequeNo", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{6}?$/i.test(value);
		}, "Cheque Number is invalid");
		$.validator.addMethod("TrabsitionNo", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{0,20}?$/i.test(value);
		}, "Transition/UTR Number is invalid");
		$.validator.addMethod("TaxIdNo", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{0,16}?$/i.test(value);
		}, "Tax Identification Number is invalid");
		$.validator.addMethod("MembershipNo", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{6}?$/i.test(value);
		}, "Membership No. of Auditor is not valid");
		$(".uprcase").each(function(){
	          this.style.textTransform = 'uppercase';
	       })
	       .change(function(){
	          this.value = this.value.toUpperCase();
	       });		
		
		

	</script>	
	<script type="text/javascript">
	 	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-41164129-1', 'wealth4india.com');
		  ga('send', 'pageview');
	</script>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-41164129-2', 'wealth4india.com');
	  ga('send', 'pageview');	
	</script>
</body>
</html>
