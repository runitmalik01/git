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
<%@page import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="java.util.Enumeration"%>
<%@include file="../includes/tags.jspf"%>
<%
String errorKey = "login.error";
try {
	if (request.getSession() != null) {
		org.springframework.security.authentication.AuthenticationServiceException authenticationException = (org.springframework.security.authentication.AuthenticationServiceException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if (authenticationException != null) {
			String msg = authenticationException.getMessage();
			if (msg != null && msg.equals("user.not.found")) {
				errorKey = "login.error.userNameNotFound";
			}
			else if (msg != null && msg.equals("password.mismatch")) {
				errorKey = "login.error.passwordMismatch";
			}
			else if (msg != null && msg.equals("user.account.inactive")) {
				errorKey = "login.error.inactiveuser";
			}	
			else {
				errorKey = "login.error";
			}
			session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			pageContext.setAttribute("login_error_key", errorKey);	
		}
	}
} catch (Exception ex) {
	
}
				
%>
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
				<h4>Login to Wealth4India</h4>				
				<c:if test="${not empty login_error_key}">
					<div class="alert alert-error"><fmt:message key="${login_error_key}"/></div>
				</c:if>
				<form action="j_spring_security_check" method="post" id="loginForm">
				   <p>
				 	  <label for="username">
				          <small>Email Address</small>
				       </label>
				       <input name="j_username" id="username" value="${fn:escapeXml(userName)}" size="22" tabindex="1" type="text">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.userNameNotFound')}"><label for="userName" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
				   </p>
				   <p>
						<label for="password">
				           <small>Password</small>
				       </label>
				       <input name="j_password" id="password" value="" size="22" tabindex="2" type="password">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.passwordMismatch')}"><label for="password" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
				   </p>
				   <p>
				   		<a href="javascript:void(0)" id="hrefLogin" class="orange button">Login</a>
				   </p>
				   <hst:link var="memberhome" path="/member"/>
				   <input type="hidden" name="destination" value="${memberhome}"/> 
				</form>
		</div>
		<res:client-validation screenConfigurationDocumentName="memberlogin" formId="loginForm" formSubmitButtonId="hrefLogin"></res:client-validation>
	</c:otherwise>
</c:choose>


