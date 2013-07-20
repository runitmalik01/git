<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="changepass">
 <fmt:message key="member.change.title" />
</c:set>
<hippo-gogreen:title title="${changepass}" />
<hst:actionURL var="actionUrl" />

<form id="frmchangepass" action="${actionUrl}" method="post">
	<fieldset>
		<legend style="color: blue">CHANGE PASSWORD!!</legend>

		<p>
			<label for="Old_Password"><fmt:message
					key="signup.opassword.required" /><span class="star">*</span> </label> <input
				required type="password" id="Old_Password" name="Old_Password"
				value="${fn:escapeXml(Old_Password)}" class="input_data" />
			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					<c:if test="${error eq 'signup.password.error.required'}">
						<span class="badge badge-important"><fmt:message
								key="signup.password.error.required" /> </span>
						<br />
					</c:if>
					<c:if test="${error eq 'signup.password.error.mismatch'}">
						<span class="badge badge-important"><fmt:message
								key="signup.password.error.mismatch" /> </span>
						<br />
					</c:if>
				</c:forEach>
			</c:if>
		</p>
		<p>
			<label for="New_Password"> <fmt:message
					key="signup.npassword.required" /><span class="star">*</span> </label> <input
				required type="password" id="New_Password" name="New_Password"
				value="${fn:escapeXml(New_Password)}" class="input_data" />
			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					<c:if test="${error eq 'signup.password.error.required'}">
						<span class="badge badge-important"><fmt:message
								key="signup.password.error.required" /> </span>
						<br />
					</c:if>
				</c:forEach>
			</c:if>
		</p>

		<p>
			<label for="confirm_password"><fmt:message
					key="signup.cpassword.required" /><span class="star">*</span> </label> <input
				required type="password" id="confirm_password"
				name="confirm_password" value="${fn:escapeXml(confirm_password)}"
				class="input_data" />
			<c:if test="${not empty errors}">
				<c:forEach items="${errors}" var="error">
					<c:if test="${error eq 'signup.confirm_password.error.mismatch'}">
						<span class="badge badge-important"><fmt:message
								key="signup.confirm_password.error.mismatch" /> </span>
						<br />
					</c:if>
					<c:if test="${error eq 'signup.confirm_password.error.required'}">
						<span class="badge badge-important"><fmt:message
								key="signup.confirm_password.error.required" /> </span>

					</c:if>
				</c:forEach>
			</c:if>
		</p>


		<p  align="center">
			<a id="hrefLogin" class="btn btn-success" style="color: black"> <fmt:message
					key="member.start.cpsubmit.label" />
			</a>
		</p>

	</fieldset>
</form>
<res:client-validation screenConfigurationDocumentName="changepass"
	formId="frmchangepass" formSubmitButtonId="hrefLogin"></res:client-validation>
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
<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/Newstyle.css"/>' />
</hst:headContribution>

<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/adornment.css"/>' />
</hst:headContribution>