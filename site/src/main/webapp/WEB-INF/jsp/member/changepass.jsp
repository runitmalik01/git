<%@include file="../includes/tags.jspf"%>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label" />
	</li>
	<li><hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message key="products.detail.location.home" />
	</a>&gt;</li>
	<li><hst:link var="changeprofile" siteMapItemRefId="changeprofile"></hst:link>
		<a href="${changeprofile}"><fmt:message
				key="member.start.changeprofile" /> </a>&gt;</li>
	<li><hst:link var="changepass" siteMapItemRefId="changepass"></hst:link>
		<a href="${changepass}"><fmt:message key="member.start.change" />
	</a></li>
</ol>
<hst:actionURL var="actionUrl" />
<div align="center" class="signupform">
	<form id="frmchangepass" action="${actionUrl}" method="post">
		<div id="demo" class="yui3-module" align="center">
			<div class="yui3-hd">
				<b>CHANGE PASSWORD!!</b>
			</div>
			<br />
			<br />
			<div class="yui3-bd" align="center">
				<table>
					<tr height="30px">
						<td class="label"><fmt:message
								key="signup.opassword.required" /><span class="star">*</span>
						</td>
						<td class="input"><input required type="password"
							name="Old_Password" value="${fn:escapeXml(Old_Password)}"
							class="input_data" /> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'signup.password.error.required'}">
										<span class="form-error"><fmt:message
												key="signup.password.error.required" />
										</span>
										<br />
									</c:if>
									<c:if test="${error eq 'signup.password.error.mismatch'}">
										<span class="form-error"><fmt:message
												key="signup.password.error.mismatch" />
										</span>
										<br />
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
						<td class="label"><fmt:message
								key="signup.npassword.required" /><span class="star">*</span>
						</td>
						<td class="input"><input required type="password"
							name="New_Password" value="${fn:escapeXml(New_Password)}"
							class="input_data" /> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'signup.password.error.required'}">
										<span class="form-error"><fmt:message
												key="signup.password.error.required" />
										</span>
										<br />
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
						<td class="label"><fmt:message
								key="signup.cpassword.required" /><span class="star">*</span>
						</td>
						<td class="input"><input required type="password"
							name="confirm_password" value="${fn:escapeXml(confirm_password)}"
							class="input_data" /> <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if
										test="${error eq 'signup.confirm_password.error.mismatch'}">
										<span class="form-error"><fmt:message
												key="signup.confirm_password.error.mismatch" />
										</span>
										<br />
									</c:if>
									<c:if
										test="${error eq 'signup.confirm_password.error.required'}">
										<span class="form-error"><fmt:message
												key="signup.confirm_password.error.required" />
										</span>
										<br />
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr height="30px">
					<tr height="40px">
						<td colspan="3" align="center"><input type="submit"
							value="<fmt:message key="member.start.cpsubmit.label"/>"
							class="yui3-button" /></td>
					</tr>
				</table>
				<br />
			</div>
		</div>
	</form>
</div>
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
