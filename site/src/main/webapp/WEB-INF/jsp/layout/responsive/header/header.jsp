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
<%@include file="../../../includes/tags.jspf" %>
<style>
bestplan {
	background-color:#acecac;
	padding: 5px 10px 10px 10px;
}

.bestplan-header {
	background-color: #5cb85c;
	color: #fff;
	font-weight: bold;
	font-size: 1.3em;
	padding: 4px;
	text-align: center;
  border-radius: 4px;

}

.betterplan {
	background-color:#9bc6ec;
	padding: 5px 10px 10px 10px;
}

.betterplan-header {
	background-color:#f0ad4e;
	color: #fff;
	font-weight: bold;
	font-size: 1.3em;
	padding: 4px;
	text-align: center;
  border-radius: 4px;
}


.plan {
	background-color:#ededed;
	padding: 5px 10px 10px 10px;
}

.plan-header {
	background-color:#ededed;
	color: #fff;
	font-weight: bold;
	font-size: 1.3em;
	padding: 4px;
	text-align: center;
  border-radius: 4px;
}

/* Pricing CSS Rules   */


.w4i-logo {
		float: left;
		padding-right: 10px;
		padding-top: 10px;
}

.gold {
	background-color: #fc3;
	padding: 5px 10px 10px 10px;
}

/* JumboTron */

.bg-jumbotron {
	background-image: url('../img/bg_jumbotron_v2.png');
}

.bg-jumbotron h1 {
	color: #fff;
	text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135;
}

.bg-jumbotron h2 {
	color: #fff;
	text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135;
}


/* Sticky Footer */

/* Wrapper for page content to push down footer */
#wrap {
  min-height: 100%;
  height: auto !important;
  height: 100%;
  /* Negative indent footer by its height */
  margin: 0 auto -60px;
  /* Pad bottom by footer height */
  padding: 40px 0 60px;
}

/* Set the fixed height of the footer here */
#footer {
  height: 60px;
  background-color: #f5f5f5;
}

.footer-copy {
	margin: 8px 10px 5px 30px;
}

.footer-content {
	margin: 2px 30px 2px 10px;
}
</style>
<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="glyphicon glyphicon-bar"></span> <span class="glyphicon glyphicon-bar"></span> <span
					class="glyphicon glyphicon-bar"></span>
			</button>
			<!-- logo -->
			<hst:include ref="logo" />
		</div>
		<!-- menu top-->
		<!-- main-menu -->
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<hst:include ref="menu-main" />
			</ul>
			<form id="frmLogin" method="GET" class="navbar-form navbar-right">
				<div class="form-group">
					<hst:include ref="menu-top" />
				</div>
			</form>			
		</div>
	</div>
</div>



