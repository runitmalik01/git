
<!-- New home page design 14tn Nov'13 -->



<%@page import="java.util.List"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga"%>
<%@include file="../../../includes/tags.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="#">
<title>Wealth4India - Home</title>
<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.flat.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/wealth4india.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="./js/html5shiv.js"></script>
      <script src="./js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="w4i-logo" href="#"><img alt="Wealth4India"
					src="./bootstrap_v2_img/w4ilogo_v2.png"> </a>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href='/site/home_v2'>Home</a>
					</li>
					<li><a href='/site/serviceprice'>Pricing</a>
					</li>
					<li class="dropdown"><a id="dLabel" role="button"
						class="dropdown-toggle" data-toggle="dropdown" data-target="#"
						href='/site/taxcalculator'>Tax Filing <b class="caret"></b> </a>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							<li class="dropdown-header">Calculators</li>
							<li><a href='/site/taxcalculator'>Tax Calculator</a>
							</li>
							<li><a href='/site/npvcalculator'>NPV Calculator</a>
							</li>
							<li><a href='/site/emicalculator'>EMI Calculator</a>
							</li>
							<li><a href='/site/hracalculator'>HRA Calculator</a>
							</li>
							<li class="divider"></li>
							<li><a href='/site/memberLogin'>Income Tax Return</a>
							</li>
							<li><a href='/site/knowledgeportal'>Knowledge Portal</a>
							</li>
						</ul></li>
					<li class="dropdown"><a href="#about" class="dropdown-toggle"
						data-toggle="dropdown">About Us <b class="caret"></b> </a>
						<ul class="dropdown-menu">
							<li><a href='/site/about'>About</a>
							</li>
							<li><a href='/site/faq'>FAQ</a>
							</li>
							<li><a href='/site/news'>News</a>
							</li>
						</ul></li>
				</ul>

				<form class="navbar-form navbar-right">
					<a href='/site/memberLogin' class="btn btn-info">Login</a> <a
						href='/site/signup' class="btn btn-warning">Sign Up </a>
				</form>

			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
</body>
</html>
