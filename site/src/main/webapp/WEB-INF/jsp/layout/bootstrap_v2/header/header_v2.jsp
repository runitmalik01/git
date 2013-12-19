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
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics"
	prefix="ga"%>
<%@include file="../../../includes/tags.jspf"%>
<hst:link var="login" path="/memberLogin" />
<hst:link var="logout" path="/j_spring_security_logout" />
<hst:link var="signup" path="/signup" />
<hst:link var="myaccount" path="/member" />

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






