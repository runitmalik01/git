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
<hst:link var="login" path="/memberLogin"/>
<hst:link var="logout" path="/j_spring_security_logout"/>
<hst:link var="signup" path="/signup"/>
<hst:link var="myaccount" path="/member"/>
<hst:link var="resellersignup" path="/resellersignup"/>

<hst:link var="securelink" siteMapItemRefId="secure-connection"></hst:link>
<div class="pull-right">
	<c:choose>
		<c:when test="${loggedin}">			
			<a class="btn btn-orange pull-left btn-signin btn-beacon" href="<hst:link path="/member/itreturn"/>">Sign In</a>
		</c:when>
		<c:otherwise>
			<%--
			<a href="<hst:link path="/memberLogin"/>" class="btn btn-lg btn-info btn-block" style="display:inline" tabindex="4">Log In</a>
			<a href="<hst:link path="/signup"/>" class="btn btn-lg btn-warning btn-block" tabindex="4" style="display:inline">Signup</a>
			 --%>
			<a class="btn btn-orange pull-left btn-signin btn-beacon" href="<hst:link path="/memberLogin"/>">Sign In</a>
		</c:otherwise>
	</c:choose>		
</div>
