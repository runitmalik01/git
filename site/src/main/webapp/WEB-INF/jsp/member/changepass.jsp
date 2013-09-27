<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="changepass">
	<fmt:message key="member.change.title" />
</c:set>
<hippo-gogreen:title title="${changepass}" />
<hst:actionURL var="actionUrl" />
<hst:link var="contactlink" siteMapItemRefId="contactus"></hst:link>
<hst:link var="forgotpasslink" siteMapItemRefId="forgotpass"></hst:link>
<c:if test="${not empty notify && empty changePass}">
	<div class="alert alert-error">
		<strong>Oops! Look like you have request for an expired link.If you want to change your password <a href="${forgotpasslink}">click
				here</a> or <a href="${contactlink}">Contact US</a>.
		</strong>
	</div>
</c:if>
<form id="frmchangepass" action="${actionUrl}" method="post">
	<c:set value="<%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll(\"@\",\"-at-\") :\"\"%>" var="loggedin"></c:set>
	<c:if test="${(not empty loggedin && empty notify) || (empty loggedin && changePass== true && empty notify)}">
		<fieldset>
			<legend>
				<small><strong>CHANGE PASSWORD!!</strong></small>
			</legend>
			<c:if test="${not empty loggedin}">
			<p>
				<label for="Old_Password"><fmt:message key="signup.opassword.required"/><span class="required">*</span>
				</label> <input required type="password" id="Old_Password"
					name="Old_Password" value="${fn:escapeXml(Old_Password)}" class="input_data"/>
				<c:if test="${not empty errors}">
					<c:forEach items="${errors}" var="error">
						<c:if test="${error eq 'signup.password.error.required'}">
							<span class="badge badge-important"><fmt:message key="signup.password.error.required"/></span>
							<br />
						</c:if>
						<c:if test="${error eq 'signup.password.error.mismatch'}">
							<span class="badge badge-important"><fmt:message key="signup.password.error.mismatch"/></span>
							<br />
						</c:if>
					</c:forEach>
				</c:if>
			</p>
			</c:if>
			<p>
				<label for="New_Password"><fmt:message key="signup.npassword.required"/><span class="required">*</span>
				</label> <input required type="password" id="New_Password"
					name="New_Password" value="${fn:escapeXml(New_Password)}" class="input_data"/>
				<c:if test="${not empty errors}">
					<c:forEach items="${errors}" var="error">
						<c:if test="${error eq 'signup.new_password.error.required'}">
							<span class="badge badge-important"><fmt:message key="signup.new_password.error.required"/></span>
							<br />
						</c:if>
					</c:forEach>
				</c:if>
			</p>
			<p>
				<label for="confirm_password"><fmt:message key="signup.cpassword.required"/><span class="required">*</span>
				</label> <input required type="password" id="confirm_password"
					name="confirm_password" value="${fn:escapeXml(confirm_password)}" class="input_data"/>
				<c:if test="${not empty errors}">
					<c:forEach items="${errors}" var="error">
						<c:if test="${error eq 'signup.confirm_password.error.mismatch'}">
							<span class="badge badge-important"><fmt:message key="signup.confirm_password.error.mismatch"/></span>
							<br/>
						</c:if>
						<c:if test="${error eq 'signup.confirm_password.error.required'}">
							<span class="badge badge-important"><fmt:message key="signup.confirm_password.error.required"/></span>
						</c:if>
					</c:forEach>
				</c:if>
			</p>
			<c:if test="${empty loggedin && changePass== true}">
		      <input name="userName" id="userName" value="${userName}" type="hidden"/>
			</c:if>
			<p align="center">
				<a id="hrefLogin" class="btn orange"><fmt:message key="member.start.cpsubmit.label" /> </a>
			</p>
		</fieldset>
	</c:if>
	<c:if test="${empty loggedin && empty changePass && empty notify}">
		<hst:link var="loggedinlink" siteMapItemRefId="member"></hst:link>
		<div class="alert alert-info">
			<strong>Oops!Look like you are not logged In.<a href="${loggedinlink}">Click here</a> to logged in.</strong>
		</div>
	</c:if>
</form>
<res:client-validation screenConfigurationDocumentName="changepass" formId="frmchangepass" formSubmitButtonId="hrefLogin"></res:client-validation>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
				$('#hrefLogin').click(function() {
		 			$('#frmchangepass').submit();
				});
			    $('#frmPersonalInfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmchangepass').submit();
				    }
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />