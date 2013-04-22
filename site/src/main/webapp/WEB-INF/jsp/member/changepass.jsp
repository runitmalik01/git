<%@include file="../includes/tags.jspf"%>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<hst:actionURL var="actionUrl" />


<form id="frmchangepass" action="${actionUrl}" method="post">
	
		<label style="color: blue">CHANGE PASSWORD!!</label>
		<table>
			<tr>
				<td><label for="Old_Password"><fmt:message
							key="signup.opassword.required" /><span class="star">*</span>
				</label></td>
				<td class="input"><input required type="password"
					name="Old_Password" value="${fn:escapeXml(Old_Password)}"
					class="input_data" /> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'signup.password.error.required'}">
								<span class="form-error"><fmt:message
										key="signup.password.error.required" /> </span>
								<br />
							</c:if>
							<c:if test="${error eq 'signup.password.error.mismatch'}">
								<span class="form-error"><fmt:message
										key="signup.password.error.mismatch" /> </span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><label for="New_Password"> <fmt:message
							key="signup.npassword.required" /><span class="star">*</span>
				</label></td>
				<td class="input"><input required type="password"
					name="New_Password" value="${fn:escapeXml(New_Password)}"
					class="input_data" /> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'signup.password.error.required'}">
								<span class="form-error"><fmt:message
										key="signup.password.error.required" /> </span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><label for="confirm_password"><fmt:message
							key="signup.cpassword.required" /><span class="star">*</span>
				</label></td>
				<td class="input"><input required type="password"
					name="confirm_password" value="${fn:escapeXml(confirm_password)}"
					class="input_data" /> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'signup.confirm_password.error.mismatch'}">
								<span class="form-error"><fmt:message
										key="signup.confirm_password.error.mismatch" /> </span>
								<br />
							</c:if>
							<c:if test="${error eq 'signup.confirm_password.error.required'}">
								<span class="form-error"><fmt:message
										key="signup.confirm_password.error.required" /> </span>

							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>
			
			<tr>
						<td colspan="3" align="center"><input type="submit"
							value="<fmt:message key="member.start.cpsubmit.label"/>"
							class="yui3-button" /></td>
					</tr> 
		</table>
	

</form>

<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/Newstyle.css"/>' />
</hst:headContribution>

<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/adornment.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
	<link rel="stylesheet"
		href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>'
		type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/adornment.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
	<link rel="stylesheet"
		href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>'
		type="text/css" />
</hst:headContribution>
