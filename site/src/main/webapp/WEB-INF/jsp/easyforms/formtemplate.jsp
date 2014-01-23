
<%@include file="../includes/tags.jspf"%>
<c:set var="feedbacktitle">
	<fmt:message key="easyforms.formtemplate" />
</c:set>
<hippo-gogreen:title title="${feedbacktitle}" />

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
<div class="memberfeedback page type-page">
	<h2 class="title">Feedback</h2>
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
				<p>
					<label for="username"> <small>Your Name</small>
					</label> <input id="name" type="text" name="name" required="required"><br>
					<br>
				</p>
				<p>
					<label for="emailid"><small>E-mail ID</small>
					</label> <input type="text" id="email" name="email" required="required"><br>
					<br>
				</p>
				<p>
					<label> <small>Category</small><span style="color: red">*</span></label>
						<label for="category"><select name="category" id="category" required="required">
						<option value="">-Select-</option>
						<option value="am">Accounting Management</option>
						<option value="nd">Newsletter Delivery</option>
						<option value="up">Username and Password</option>
						<option value="ep">Email Preferences</option>
						<option value="ma">Mailing Address Change</option>
						<option value="oth">Other</option>
					</select>
											
					</label>			
				</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>
					<label> <small>Comments/Questions</small></label>
					<textarea cols="40" rows="20" name="comments"></textarea>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>
					<label><small>Resolution</small></label>
					<textarea cols="40" rows="20" name="resolution"></textarea>
					<br>
				</p>


				<!-- <div class="row show-grid">
				<div class="col-md-3">Your Name<span style="color: red">*</span></div>
				<div class="col-md-14">
					<input id="name" type="text" name="name" required="required"><br><br>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-3">E-mail ID<span style="color: red">*</span></div>
				<div class="col-md-8">
					<input type="text" id="email" name="email" required="required"><br><br>
				</div> 

			</div>
			<div class="row show-grid">
				<div class="col-md-4">Category<span style="color: red">*</span></div>
				<div class="col-md-7">
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
			
		<div class="row show-grid">
				<div class="col-md-3">Comments/Questions</div>
				<div class="col-md-8">	<textarea cols="40" rows="20" name="comments"></textarea><br>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-3">Resolution</div>
				<div class="col-md-8">	<textarea cols="40" rows="20" name="resolution"></textarea><br>
				</div>
			</div>-->
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>	
					
				<div class="ef-buttons">		
					<c:forEach var="button" items="${form.buttons}">
                ${button.html}
            </c:forEach>
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</div>

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

