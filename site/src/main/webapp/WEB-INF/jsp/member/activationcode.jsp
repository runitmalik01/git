<%--

 This for forgot activation code
 @author abhishek
 12/03/2013


 --%>

<%@include file="../includes/tags.jspf"%>
<c:set var="activecodetitle"><fmt:message key="member.activecode.title"/></c:set>
<hippo-gogreen:title title="${activecodetitle}"/>
<hst:actionURL var="activationcode"></hst:actionURL>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />


<div align="center" class="forgotpass">
	<div id="demo" class="yui3-module" align="center">
		
		<form action="${activationcode}" method="post">

			<div class="yui3-hd">
			<h1><fmt:message key="signup.forgotcode.message" /></h1>
			</div>
			<br /> <br />
			<div class="yui3-bd" align="center">
			<h2><fmt:message key="member.forgotcode.message" /></h2>
				<table>
					<tr>
						<td><br /></td>
					</tr>
					<tr height="30px">
						<td class="label"><fmt:message key="signup.email.required" />
						</td>
						<td class="input"><input type="text" name="email" value="${fn:escapeXml(email)}" class="input_data" />
						 <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'signup.email.error.required'}">
										<span class="form-error"><fmt:message
												key="signup.email.error.required" /> </span>
										<br />
									</c:if>
								</c:forEach>
							</c:if>
						</td>
					</tr>
					<c:if test="${not empty email_error}">
						<span class="form-error">
						<c:out value="Your Email is not registered" /> </span>
					</c:if>
					<tr height="40px">
						<td colspan="3" align="center"><input type="submit"
							value="<fmt:message key="member.start.submit.label"/>"
							class="yui3-button" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</div>
<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/Newstyle.css"/>' />
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