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
<%--
<span class="simpleCart_quantity"></span> items - <span class="simpleCart_total"></span>
<a href="javascript:;" class="simpleCart_checkout">Checkout</a>
 --%>
<hst:link var="securelink" siteMapItemRefId="secure-connection"></hst:link>
<c:choose>
	<c:when test="${loggedin}">			
		<%--<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-724" style="color: brown"><small><strong></strong></small></li> --%>
               <a class="dropdown-toggle btn btn-primary" data-toggle="dropdown" href="#" style="color: white"><i class="glyphicon glyphicon-user glyphicon glyphicon-white"></i><%=request.getUserPrincipal().getName()%><b></b></a>
               <ul class="dropdown-menu">
               	<hst:link var="changepass" siteMapItemRefId="memberchangepass"></hst:link>
                   <li><a href="${changepass}"><i class="glyphicon glyphicon-edit"></i>ChangePassword</a></li>
                   <li><a href="${securelink}?security=true"><i class="glyphicon glyphicon-wrench"></i>Security Setting</a></li>
                   <%
                   	if (request.isUserInRole("ROLE_vendor")) {	                    		
                   %>
                   	<li><a href="<hst:link path="/vendor/itreturn"/>"><i class="glyphicon glyphicon-home"></i>Vendor Home</a></li>
                   <% } %>
               </ul>
			   <button type="submit" class="btn btn-default btn-info"  onclick="javascript:$('#frmLogin').attr('action','${logout}');$('#frmLogin').submit()">Logout</button>
	</c:when>
	<c:otherwise>	<!-- Login/Signup (when user is logging first time)-->
	<c:if test="${etaxfilestation == true}">
	<button type="submit" class="btn btn-default btn-warning" onclick="javascript:$('#frmLogin').attr('action','${resellersignup}');$('#frmLogin').submit()">Apply Here !!!</button>
	</c:if>
	<c:if test="${etaxfilestation == false}">
	<button type="submit" class="btn btn-default btn-info" onclick="javascript:$('#frmLogin').attr('action','${login}');$('#frmLogin').submit()">Login</button>
	<button type="submit" class="btn btn-default btn-warning" onclick="javascript:$('#frmLogin').attr('action','${signup}');$('#frmLogin').submit()">Signup</button>					
	</c:if>
	</c:otherwise>
</c:choose>		
