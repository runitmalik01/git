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
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="java.util.Enumeration"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="forgotpass" siteMapItemRefId="forgotpass"></hst:link>
<hst:link var="loginProxy" path="/login/proxy"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:choose>
	<c:when test="${loggedin}">
		<hst:link var="redirectUrl" path="/member">
		</hst:link>
		<html>
		  <head>
		    <meta http-equiv="refresh" content="0;URL=${redirectUrl}" />
		  </head>
		<body>
		</body>
		</html>
	</c:when>
	<c:otherwise>
		<div class="memberlogin page type-page">
				<h3 id="respond1">Login to <w4india:resellername/></h3>
				<form action="${loginProxy}" method="post" id="loginForm">
				   <p>
				 	  <label for="username">
				          <small>Email Address (required)</small>
				       </label>
				       <input name="username" id="username" value="${fn:escapeXml(userName)}" size="22" tabindex="1" type="text">
				       <c:if test="${not empty loginError}"><label for="userName" generated="true" class="error" style="">Either your username or password were incorrect.</label></c:if>
				   </p>
				   <p>
						<label for="password">
				           <small>Password (required)</small>
				       </label>
				       <input name="password" id="password" value="" size="22" tabindex="2" type="password">
				   </p>
				   <p>
				   		<a href="javascript:void(0)" id="hrefLogin" class="orange button">Login</a>
				   </p>
				   <hst:link var="memberhome" path="/member"/>
				   <input type="hidden" name="destination" value="${memberhome}"/> 
				</form>
		</div>
		
		<hst:element var="uiCustom" name="script">
		    <hst:attribute name="type">text/javascript</hst:attribute>
				$(document).ready(function() {
					$('#loginForm input').keydown(function(e) {
					    if (e.keyCode == 13) {
					   		e.preventDefault();
					        $('#loginForm').submit();
					    }
					});
					$('#loginForm').validate({
						rules: {
							username: {
								required: true,
								minlength: 2
							},
		
							password: {
								required: true
							}
						},				
						messages: {
							username: "Please enter a valid email address.",
							password: "Please enter a valid password."
						}
					});
					
					$('#hrefLogin').click(function() {
		 				 $('#loginForm').submit();
					});
				});    
		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal"/>
	</c:otherwise>
</c:choose>