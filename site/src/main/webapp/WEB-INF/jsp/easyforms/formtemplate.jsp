
<%@include file="../includes/tags.jspf"%>
<c:set var="feedbacktitle">
	Feedback
</c:set>

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
<hippo-gogreen:seoheader title="Problem with eFiling? - Provide your Feedback" robots="NOINDEX, FOLLOW"/>
<!-- <div class="page type-page"> -->
<div class="page">
	<w4india:titleandnav title="Problem with eFiling? - Provide your Feedback"
		subTitle="We welcome problem reports, feature ideas and
						general comments." />
	<!-- <h2 class="page-title">Feedback</h2> -->
	<c:forEach items="${ef_errors}" var="error">
		<div class="form-error">
			<c:out value="${error.message}" />
		</div>
	</c:forEach>
	<form class="form" name="contactus" action="<hst:actionURL />"
		method="post" id="${form.id}">
		<fieldset>
			<c:if test="${success eq 'eventsuccess'}">
				<fmt:message key="easyforms.formtemplate.thankyou.event" />
			</c:if>

			<c:if test="${success eq 'dummysuccess'}">
				<div id="content" class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					<strong>Thank You!!</strong> &nbsp; We appreciate your time and
					valuable feedback in helping to make us better.
				</div>

			</c:if>
			<div class="row show-grid">
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Name"><small>Your Name<span
								style="color: red">*</span></small></label>
					</div>
					<div class="rowlabel">
						<input id="name" type="text" name="name" required="required" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="email"><small>E-mail ID<span
								style="color: red">*</span></small></label>
					</div>
					<div class="rowlabel">
						<input type="text" id="email" name="email" required="required" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="rowlabel">
						<label for="Category"><small>Category<span
								style="color: red">*</span></small></label>
					</div>
					<div class="rowlabel">
						<select name="subject" id="subject" required="required">
							<option value="">-Select-</option>
							<option value="ep">Email Preferences</option>
							<option value="ma">Mailing Address Change</option>
							<option value="am">Accounting Management</option>
							<option value="tp">Tax Planning</option>
							<option value="pay">Payment Issues</option>
							<option value="taxcomp">Question on Tax Computation</option>
							<option value="nd">Newsletter Delivery</option>
							<option value="up">Username and Password</option>
							<option value="oth">Other</option>
						</select>
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<div class="row show-grid">
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="comments"><small>Comments/Questions</small></label>
					</div>
					<div class="rowlabel">
						<textarea cols="8" rows="5" name="comments" id="comments"></textarea>
					</div>
				</div>
				<div class="col-md-6">
					<div class="rowlabel">
						<label for="resolution"><small>Resolution</small></label>
					</div>
					<div class="rowlabel">
						<textarea cols="9" rows="5" name="resolution" id="resolution"></textarea>
					</div>
				</div>
			</div>
		</fieldset>
		<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<input type="submit" class="btn btn-default btn-success"
					value="Submit">
			</div>
		</div>
		<%-- <div class="ef-buttons">
						<c:forEach var="button" items="${form.buttons}">
                ${button.html}
            </c:forEach>
					</div> --%>
	</form>
</div>


<%--
    HERE WE PRINT JAVASCRIPT CALL WHICH WILL VALIDATE OUR FORM
--%>

${form.jsCall}
<%--
     HEADER CONTRIBUTIONS
    --%>

<hst:headContribution keyHint="formJsValidation" category="jsInternal">
	<script type="text/javascript"
		src="<hst:link path="/js/jquery.validate.min.js"/>"></script>
</hst:headContribution>

<!-- To get email of active user -->
<script type="text/javascript">
	$(document).ready(function() {
		var regemail = '<c:out value = "${regemail}" />';
		if (regemail != '') {
			contactus.email.value = regemail;
		}
	});
</script>

