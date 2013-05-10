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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>

<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="forgotpass"></hst:actionURL>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

		<form action="${forgotpass}" method="post">
		<fieldset>
		<legend style="color: blue">GET YOUR FORGOTTEN PASSWORD !!</legend>
				<h5>
					<fmt:message key="signup.forgotpass.message" />
				</h5>
				<table>	
					<tr>
						<td><label for="email"><fmt:message key="signup.email.required" /></label>
						</td>
						<td class="input"><input type="text" name="email"
							value="${fn:escapeXml(email)}" class="input_data" /> <c:if
								test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:if test="${error eq 'signup.email.error.required'}">
										<span class="form-error"><fmt:message
												key="signup.email.error.required" /> </span>
										<br />
									</c:if>
								</c:forEach>
							</c:if></td>
					</tr>
					<c:if test="${not empty email_error}">
						<span class="form-error"> <c:out
								value="Your Email is not registered" /> </span>
					</c:if>
					<tr height="40px">
						<td colspan="3" align="center"><input type="submit"
							value="<fmt:message key="member.start.submit.label"/>"
							class="yui3-button" />
						</td>
					</tr>
				</table>
				</fieldset>
		</form>
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