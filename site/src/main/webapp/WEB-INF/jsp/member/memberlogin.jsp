<%@page import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="java.util.Enumeration"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="memberlogintitle">
	<fmt:message key="member.login.title" />
</c:set>
<hippo-gogreen:title title="${memberlogintitle}" />
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
<hst:link var="j_spring_security_check" path="/j_spring_security_check"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${ not empty errormsg}">
		<div class="alert alert-success"><c:out value="${errormsg}"/></div>
		</c:if>	
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
		<div class="row">
				<h4>Login to <w4india:resellername/></h4>				
				<c:if test="${not empty login_error_key}">
					<div class="alert alert-danger"><fmt:message key="${login_error_key}"/></div>
				</c:if>
				<form action="/site/j_spring_security_check" method="post" id="loginForm" role="form">
				  <%--  <p>
				 	  <label for="username">
				          <small>Email Address</small>
				       </label>
				       <input class="username" name="j_username" id="username" value="${fn:escapeXml(userName)}" size="22" tabindex="1" type="text" maxlength="50">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.userNameNotFound')}"><label for="userName" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
				   </p>
				   <p>
						<label for="password">
				           <small>Password</small>
				       </label>
				       <input name="j_password" id="password" value="" maxlength="20" size="22" tabindex="2" type="password">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.passwordMismatch')}"><label for="password" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
				   </p>
				   <p>
				   		<a href="javascript:void(0)" id="hrefLogin" class="btn btn-default btn-success" style="color: black"">Login</a>
				   </p>
				   <hst:link var="memberhome" path="/member"/>
				   <input type="hidden" name="destination" value="${memberhome}"/> 
				   <%--  multi tenancy the channel UUID --%>
				   <%-- <c:if test="${not empty mountIdentifier}">
				   	<input type="hidden" name="c" value="${mountIdentifier}"/>
				   </c:if> --%>
				<fieldset>
					<h2>Please Log In</h2>
					<hr class="colorgraph">
					<div>
					 <label for="username">
				          <small>Email Address</small>
				       </label>
					</div>
					<div class="form-group">
						<!-- input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address"> -->
						<input class="username form-control" name="j_username" id="username" value="${fn:escapeXml(userName)}" size="22" tabindex="1" type="text" maxlength="50" placeholder="Email Address">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.userNameNotFound')}"><label for="userName" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
					</div>
					<div>
					 <label for="password">
				           <small>Password</small>
				       </label>
					</div>
					<div class="form-group">
						<!-- input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password"> -->
						<input name="j_password" id="password" value="" maxlength="20" size="22" tabindex="2" class="form-control" type="password" placeholder="Password">
				       <c:if test="${not empty login_error_key &&  (login_error_key == 'login.error' || login_error_key == 'login.error.passwordMismatch')}"><label for="password" generated="true" class="error" style=""><fmt:message key="${login_error_key}"/></label></c:if>
					</div>
					<!-- <span class="button-checkbox">
						<button type="button" class="btn" data-color="info">Remember
							Me</button> <input type="checkbox" name="remember_me" id="remember_me"
						checked="checked" class="hidden"> 
					</span> -->
					<div class="row">
					   <div class="col-md-4 col-md-offset-8">
					       <a href="<hst:link siteMapItemRefId="forgotpass"/>" class="btn btn-link pull-right" tabindex="3">Forgot Password?</a>
					   </div>
					</div>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<a href="javascript:void(0)" id="hrefLogin" class="btn btn-lg btn-info btn-block" tabindex="4">Log In</a>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<a href="<hst:link siteMapItemRefId="signup"/>" class="btn btn-lg btn-warning btn-block">Sign Up</a>
						</div>
					</div>
					<hst:link var="memberhome" path="/member"/>
				   <input type="hidden" name="destination" value="${memberhome}"/> 
				   <%--  multi tenancy the channel UUID --%>
				   <c:if test="${not empty mountIdentifier}">
				   	<input type="hidden" name="c" value="${mountIdentifier}"/>
				   </c:if>
				</fieldset>
			</form>
		</div>
	</c:otherwise>
</c:choose>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		$("#loginForm").submit (function() {
			$("#username").val($("#username").val().toLowerCase());
			return true;
		});
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:client-validation screenConfigurationDocumentName="memberlogin" formId="loginForm" formSubmitButtonId="hrefLogin"></res:client-validation>