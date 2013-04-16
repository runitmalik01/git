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
<hst:link var="login" path="/login/login"/>
<hst:link var="logout" path="/login/logout"/>
<hst:link var="signup" path="/signup"/>
<hst:link var="myaccount" path="/member"/>
<ul id="menu-top" class="top-menu">
		<c:choose>
			<c:when test="${loggedin}">
				<li id="menu-item-723" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724"><a href="${myaccount}">My Account</a></li>
				<li id="menu-item-724" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724"><a href="${logout}">Logout</a></li>
			</c:when>
			<c:otherwise>				
				<li id="menu-item-724" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724"><a href="${login}">Login</a></li>
				<li id="menu-item-725" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-725"><a href="${signup}">Signup</a></li>				
			</c:otherwise>
		</c:choose>		
</ul>