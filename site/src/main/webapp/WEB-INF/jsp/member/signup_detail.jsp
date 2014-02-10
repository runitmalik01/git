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
<%@include file="../includes/tags.jspf"%>
<c:set var="signuptitle"><fmt:message key="member.signup.title"/></c:set>
<hippo-gogreen:title title="${signuptitle}"/>
<hst:link var="forgotpass" siteMapItemRefId="forgotpass"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>

<c:choose>
<c:when  test = "${allowSignup==false}">
    <fmt:message key="signup.not.allowed"></fmt:message>
</c:when>
<c:otherwise>
<div class="row">
<div class="memberlogin page type-page">
		<h3 id="respond1">Signup to <w4india:resellername/></h3>
		<h4><small>
It takes just a minute to join.
Please enter the following information to create your account.</small></h4>
		
		<form action="${actionUrl}" method="post" id="signupForm" role="form">
		   <%-- <p>
		 	  <label for="email">
		          <small>Email Address (required)</small>
		       </label>
		       <input class="username" name="email" id="email" value="${fn:escapeXml(email)}" size="22" tabindex="1" type="text" maxlength="50">
		       <label for="email" class="error" generated="false"><c:if test="${not empty emailError}"><fmt:message key="${emailError}"/></c:if></label>
		   </p>
		   <p>
		 	  <label for="confirmEmail">
		          <small>Confirm Email Address (required)</small>
		       </label>
		       <input class="username" name="confirmEmail" id="confirmEmail" value="" size="22" tabindex="2" type="text" maxlength="50">	
		       <label for="confirmEmail" class="error" generated="false"><c:if test="${not empty confirmEmailError}"><fmt:message key="${confirmEmailError}"/></c:if></label>	       
		   </p>
		   <p>
				<label for="password">
		           <small>Password (required)</small>
		       </label>
		       <input name="password" id="password" value="" size="22" tabindex="3" type="password" maxlength="20">
		       <label for="password" class="error" generated="false"><c:if test="${not empty passwordError}"><fmt:message key="${passwordError}"/></c:if></label>
		   </p>
		   <p>
				<label for="confirmPassword">
		           <small>Confirm Password (required)</small>
		       </label>
		       <input name="confirmPassword" id="confirmPassword" value="" size="22" tabindex="4" type="password" maxlength="20">
		       <label for="confirmPassword" class="error" generated="false"><c:if test="${not empty confirmPasswordError}"><fmt:message key="${confirmPasswordError}"/></c:if></label>
		   </p>
		   <p>
				<input class="checkbox" id="signupTerms" name="signupTerms" tabindex="5" type="checkbox" value="on">
				<label for="signupTerms">Yes, I agree to the&nbsp;<a href='<hst:link path="/terms"/>' target="_blank">Terms of Use</a></label>
				<label for="signupTerms" class="error" generated="false"><c:if test="${not empty signupTermsError}"><fmt:message key="${signupTermsError}"/></c:if></label>
		   </p>
		   <p>
		   		<a href="javascript:void(0);" id="hrefSignup" class="orange button">Signup</a>
		   </p>
		   <hst:link var="memberhome" path="/member"/>--%>
		   <%--<input type="hidden" name="destination" value="${memberhome}"/>  --%>
		   <h2>Please Sign Up</h2>
			<hr class="colorgraph">
			<div>
			  <label for="email">
		          <small>Email Address (required)</small>
		       </label>
			</div>
			<div class="form-group">
				<!-- input type="text" name="display_name" id="display_name" class="form-control input-lg" placeholder="Display Name" tabindex="3"-->
				<input class="username form-control" name="email" id="email" value="${fn:escapeXml(email)}" size="22" tabindex="1" type="text" maxlength="50">
		       <label for="email" class="error" generated="false"><c:if test="${not empty emailError}"><fmt:message key="${emailError}"/></c:if></label>
			</div>
			<div>
			  <label for="confirmEmail">
		          <small>Confirm Email Address (required)</small>
		       </label>
			</div>
			<div class="form-group">
				<!-- input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4"-->
				<input class="username form-control" name="confirmEmail" id="confirmEmail" value="" size="22" tabindex="2" type="text" maxlength="50">	
		       <label for="confirmEmail" class="error" generated="false"><c:if test="${not empty confirmEmailError}"><fmt:message key="${confirmEmailError}"/></c:if></label>
			</div>
			<div>
			  <label for="password">
		           <small>Password (required)</small>
		       </label>
			</div>
					<div class="form-group">
						<!-- input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5"-->
						 <input name="password" id="password" value="" size="22" tabindex="3" type="password" maxlength="20" class="form-control">
		                 <label for="password" class="error" generated="false"><c:if test="${not empty passwordError}"><fmt:message key="${passwordError}"/></c:if></label>
					</div>	
			<div>
			  <label for="confirmPassword">
		           <small>Confirm Password (required)</small>
		       </label>
			</div>
					<div class="form-group">
						<!-- input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6"-->
						<input name="confirmPassword" id="confirmPassword" value="" size="22" tabindex="4" type="password" maxlength="20" class="form-control">
		                <label for="confirmPassword" class="error" generated="false"><c:if test="${not empty confirmPasswordError}"><fmt:message key="${confirmPasswordError}"/></c:if></label>
					</div>
			<div class="row">
				<div class="col-xs-3 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="success" tabindex="5">I Agree</button>
						<input class="checkbox hidden" id="signupTerms" name="signupTerms" tabindex="5" type="checkbox" value="on">
						<label for="signupTerms" class="error" generated="false"><c:if test="${not empty signupTermsError}"><fmt:message key="${signupTermsError}"/></c:if></label>
                        <!-- input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1"-->
					</span>
				</div>
				<div class="col-xs-9 col-sm-9 col-md-9">
					 By clicking <strong class="label label-primary">Sign Up</strong>, you agree to the <a href="<hst:link path="/terms"/>" target="_blank">Terms and Conditions</a> set out by <w4india:resellername/>, including our Cookie Use.
				</div>
			</div>
			
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-6 col-md-6"><a href="javascript:void(0);" id="hrefSignup" class="btn btn-warning btn-block btn-lg" tabindex="6">Sign Up</a></div>
				<div class="col-xs-6 col-md-6"><a href="<hst:link siteMapItemRefId="memberlogin"/>" class="btn btn-info btn-block btn-lg">Log In</a></div>
			</div>
		</form>
</div>
</div>
</c:otherwise>
</c:choose>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefSignup').click(function() {
 				 $('#signupForm').submit();
			});
			$('#signupForm input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#signupForm').submit();
			    }
			});
			$('#signupForm').validate({
				rules: {
					email: {
						required: true,
						minlength: 2,
						email:true
					},
					confirmEmail: {
						required: true,
						minlength: 2,
						email:true
					},
					password: {
						required: true,
						minlength: 2
					},
					confirmPassword: {
						required: true,
						minlength: 2
					},
					signupTerms: {
						required: true
					}
				},				
				messages: {
					email: "Please enter a valid email address.",
					confirmEmail: "Please enter a valid email address.",
					password: "Password is required.",
					confirmPassword: "Confirm Password is required.",
					signupTerms: "Terms of Use must be checked."
				}
			});
			
			
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>


