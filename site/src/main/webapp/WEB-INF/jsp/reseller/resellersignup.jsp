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
<div class="memberlogin page type-page">
		<h3 id="respond1">Signup to <w4india:resellername/></h3>
	    <div class="alert alert-info">It takes just a minute to join us. Please enter the following information to create your account.</div>
		<form action="${actionUrl}" method="post" id="signupForm">
		<fieldset>
		<legend>Enter your unique Reseller ID</legend>
		 <div class="row show-grid" >
		   <div class="col-md-4">
		      <div class="rowlabel">
		       <label for="email">
		          <small>Reseller ID (required)</small>
		       </label>
		      </div>
		      <div class="rowlabel">
		         <input name="resellerID" id="resellerID" value="${fn:escapeXml(resellerID)}" size="22" tabindex="1" type="text" maxlength="6">
		         <label for="resellerID" class="error" generated="false"><c:if test="${not empty resellerIDError}"><fmt:message key="${resellerIDError}"/></c:if></label>
		      </div>
		  </div>
		 </div>	
		</fieldset>
		
	   <fieldset>
		<legend>Access to Panel</legend>
		 <div class="row show-grid" >
		   <div class="col-md-4">
		      <div class="rowlabel">
		       <label for="email">
		          <small>Email Address (required)</small>
		       </label>
		      </div>
		      <div class="rowlabel">
		         <input class="username" name="email" id="email" value="${fn:escapeXml(email)}" size="22" tabindex="1" type="text" maxlength="50">
		         <label for="email" class="error" generated="false"><c:if test="${not empty emailError}"><fmt:message key="${emailError}"/></c:if></label>
		     </div>
		   </div>
		   <div class="col-md-4">
		      <div class="rowlabel">
		      <label for="confirmEmail">
		          <small>Confirm Email Address (required)</small>
		       </label>
		      </div>
		      <div class="rowlabel">
		         <input class="username" name="confirmEmail" id="confirmEmail" value="" size="22" tabindex="2" type="text" maxlength="50">
		         <label for="confirmEmail" class="error" generated="false"><c:if test="${not empty confirmEmailError}"><fmt:message key="${confirmEmailError}"/></c:if></label>
		     </div>
		   </div>
		   <div class="col-md-4">
		      <div class="rowlabel">
		       <label for="email">
		          <small>Contact No. (required)</small>
		       </label>
		      </div>
		      <div class="rowlabel">
		         <input name="phoneCustomerService" id="phoneCustomerService" onchange="phonenumber()" value="${fn:escapeXml(phoneCustomerService)}" size="22" tabindex="1" type="text" maxlength="50">
		         <label for="phoneCustomerService" class="error" generated="false"><c:if test="${not empty phoneCustomerServiceError}"><fmt:message key="${phoneCustomerServiceError}"/></c:if></label>
		     </div>
		   </div>
		 </div>	
		 <div class="row show-grid" >
		   <div class="col-md-4">
		      <div class="rowlabel">
		        <label for="password">
		           <small>Password (required)</small>
		        </label>
		      </div>
		      <div class="rowlabel">
		        <input name="password" id="password" value="" size="22" tabindex="3" type="password" maxlength="20">
		        <label for="password" class="error" generated="false"><c:if test="${not empty passwordError}"><fmt:message key="${passwordError}"/></c:if></label>
		      </div>
		   </div>
		   <div class="col-md-4">
		      <div class="rowlabel">
		        <label for="confirmPassword">
		           <small>Confirm Password (required)</small>
		        </label>
		      </div>
		      <div class="rowlabel">
		         <input name="confirmPassword" id="confirmPassword" value="" size="22" tabindex="4" type="password" maxlength="20">
		         <label for="confirmPassword" class="error" generated="false"><c:if test="${not empty confirmPasswordError}"><fmt:message key="${confirmPasswordError}"/></c:if></label>
		     </div>
		   </div>
		 </div>
		</fieldset>

		   <p>
				<input class="checkbox" id="signupTerms" name="signupTerms" tabindex="5" type="checkbox" value="on">
				<label for="signupTerms">Yes, I agree to the&nbsp;<a href='<hst:link path="/terms"/>' target="_blank">Terms of Use</a></label>
				<label for="signupTerms" class="error" generated="false"><c:if test="${not empty signupTermsError}"><fmt:message key="${signupTermsError}"/></c:if></label>
		   </p>
		   <p>
		   		<a href="javascript:void(0);" id="hrefSignup" class="btn btn-default btn-warning">Submit</a>
		   </p>
		   <hst:link var="memberhome" path="/member"/>
		   <%--<input type="hidden" name="destination" value="${memberhome}"/>  --%>
		</form>
</div>

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
					},
					resellerID:{
					required: true
					},
					phoneCustomerService:{
					required: true,
					mobile: true
					}
				},
				messages: {
					email: "Please enter a valid email address.",
					confirmEmail: "Please enter a valid email address.",
					password: "Password is required.",
					confirmPassword: "Confirm Password is required.",
					signupTerms: "Terms of Use must be checked.",
					resellerID: "Reseller ID is required.",
					phoneCustomerService: "Please enter a valid contact no."
				}
			});
		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
