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
<%--
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
 --%>
<%--
<span class="simpleCart_quantity"></span> items - <span class="simpleCart_total"></span>
<a href="javascript:;" class="simpleCart_checkout">Checkout</a>
 --%>
 <%--
 <hst:link var="securelink" siteMapItemRefId="secure-connection"></hst:link>
<ul id="menu-top" class="top-menu nav navbar-nav">
		<c:choose>
			<c:when test="${loggedin}">			
				<%--<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724" style="color: brown"><small><strong></strong></small></li> --%>
	<%--			
				<li id="menu-item-723" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724">
				<li class="dropdown">
	                <a class="dropdown-toggle btn btn-primary" data-toggle="dropdown" href="#" style="color: white"><i class="icon-user icon-white"></i><%=request.getUserPrincipal().getName()%><b></b></a>
	                <ul class="dropdown-menu">
	                	<hst:link var="changepass" siteMapItemRefId="memberchangepass"></hst:link>
	                    <li><a href="${changepass}"><i class="icon-edit"></i>ChangePassword</a></li>
	                    <li><a href="${securelink}?security=true"><i class="icon-wrench"></i>Security Setting</a></li>
	                    <%
	                    	if (request.isUserInRole("ROLE_vendor")) {	                    		
	                    %>
	                    	<li><a href="<hst:link path="/vendor/itreturn"/>"><i class="icon-home"></i>Vendor Home</a></li>
	                    <% } %>
	                </ul>
              	</li>
				<li id="menu-item-724" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724"><a href="${logout}" class="btn btn-warning" style="color: white"><i class="icon-off icon-white"></i>Logout</a></li>
			</c:when>
			<c:otherwise>				
				<li id="menu-item-724" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724"><a href="${login}" class="btn btn-info" style="color: white"><i class="icon-user icon-white "></i>Login</a></li>
				<li id="menu-item-725" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-725"><a href="${signup}" class="btn btn-success" style="color: white"><i class="icon-globe icon-white"></i>Signup</a></li>				
			</c:otherwise>
		</c:choose>		
</ul>
--%>