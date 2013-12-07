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

<%--@elvariable id="form" type="org.onehippo.forge.easyforms.model.Form"--%>
<%--@elvariable id="likert" type="org.onehippo.forge.easyforms.model.Likert"--%>
<%--@elvariable id="ef_errors" type="java.util.List"--%>
<%--@elvariable id="error" type="org.onehippo.forge.easyforms.model.ErrorMessage"--%>

<%
	if (request.getUserPrincipal() != null) {
		pageContext.setAttribute("regemail", request.getUserPrincipal()
				.getName());
	}
%>


<c:choose>
	<c:when test="${success eq 'eventsuccess'}">
		<fmt:message key="easyforms.formtemplate.thankyou.event" />
	</c:when>
	<c:when test="${success eq 'dummysuccess'}">

		<div id="content">
			<fmt:message key="easyforms.formtemplate1.thankyou.form" />
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${ef_errors}" var="error">
			<div class="form-error">
				<c:out value="${error.message}" />
			</div>
		</c:forEach>
		<form class="form" name="contactus" action="<hst:actionURL />"
			method="post" id="${form.id}">
			
			<div class="row-fluid show-grid">
				<div class="span3">Your Name<span style="color: red">*</span></div>
				<div class="span8">
					<input id="name" type="text" name="name" required="required"><br><br>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span3">E-mail ID<span style="color: red">*</span></div>
				<div class="span8">
					<input type="text" id="email" name="email" required="required"><br><br>
				</div>

			</div>
			<div class="row-fluid show-grid">
				<div class="span4">Category<span style="color: red">*</span></div>
				<div class="span7">
					<select name="category" id="category" required="required">
						<option value="">-Select-</option>
						<option value="am">Accounting Management</option>
						<option value="nd">Newsletter Delivery</option>
						<option value="up">Username and Password</option>
						<option value="ep">Email Preferences</option>
						<option value="ma">Mailing Address Change</option>
						<option value="oth">Other</option>
					</select> <br>
				</div>
			</div>
		<div class="row-fluid show-grid">
				<div class="span3">Comments/Questions</div>
				<div class="span8">	<textarea cols="40" rows="20" name="comments"></textarea><br>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span3">Resolution</div>
				<div class="span8">	<textarea cols="40" rows="20" name="resolution"></textarea><br>
				</div>
			</div>
			<div class="ef-buttons">
				<c:forEach var="button" items="${form.buttons}">
                ${button.html}
            </c:forEach>
			</div>

		</form>
	</c:otherwise>
</c:choose>
<%--
    HERE WE PRINT JAVASCRIPT CALL WHICH WILL VALIDATE OUR FORM
--%>

${form.jsCall}
<%--
    //########################################################################
    //  HEADER CONTRIBUTIONS
    //########################################################################
--%>

<hst:headContribution keyHint="formValidationCss" category="css">
	<link rel="stylesheet"
		href="<hst:link path="/js/formcheck/theme/blue/formcheck.css"/>"
		type="text/css" />
</hst:headContribution>

<hst:headContribution keyHint="formJsValidation" category="jsInternal">
	<script type="text/javascript"
		src="<hst:link path="/js/jquery.validate.min.js"/>"></script>
</hst:headContribution>
<%--
    easy forms css
--%>
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/easyforms.css"/>"
		type="text/css" />
</hst:headContribution>
<script type="text/javascript">
	$(document).ready(function() {
		var regemail = '<c:out value = "${regemail}" />';
		if (regemail != '') {
			contactus.email.value = regemail;
		}
	});
</script>

