<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../../includes/tags.jspf" %>

<div id="header" role="banner">
	<div id="default-nav" class="navbar navbar-static-top scrollsections">
	    <div class="container">
	        <hst:include ref="logo" />
	        <nav class="navigation" id="navigation">
	        	<hst:include ref="menu-top" />
				<ul class="nav navbar-nav">
					<hst:include ref="menu-main" />
				</ul>
	        </nav><!-- /.flyout-navigation -->
	    </div><!-- /.container -->
	</div><!-- /.navbar -->
</div>
