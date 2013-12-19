<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="forgotpassaction"></hst:actionURL>
<c:set var="forgotpass">
	<fmt:message key="member.forgot.title" />
</c:set>
<hippo-gogreen:title title="${forgotpass}" />
<form action="${forgotpassaction}" method="post" id="forgotpassForm">
	<c:if test="${empty memberSignup}">
		<fieldset>
			<legend>Enter your email address</legend>
			<h5>
				<fmt:message key="signup.forgotpass.message" />
			</h5>
			<table class="table table-hover table-bordered">
				<tr>
					<td><label for="recoverType"><small>Recovery Type</small><span class="required">*</span></label></td>
					<td><select id="recoverType" name="recoverType">
							<option value="">-Select-</option>
							<option value="via-Email">Email</option>
							<c:if test="${enableSecurityQuestion eq true}">
								<option value="via-question">Answer Security Question</option>
							</c:if>
					</select> 
					<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'recovery.option.required'}">
								<br/><span class="label label-default label-danger">This is required.</span>
							</c:if>
				     </c:forEach></td>
				</tr>
				<tr>
					<td><label for="email"><small><fmt:message key="signup.email.required" /></small><span class="required">*</span></label></td>
					<td class="input"><input type="text" name="email" value="${fn:escapeXml(email)}" class="input_data" />
						<c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<c:if test="${error eq 'signup.email.error.required'}">
									<br/><span class="label label-default label-important">This is required.</span>
								</c:if>
							</c:forEach>
						</c:if></td>
				</tr>
				<c:if test="${not empty email_error}">
					<span class="label label-default label-warning"> <c:out value="Your Email is not registered"/>
					</span>
				</c:if>
				<tr>
				    <td></td>
					<td  align="justify"><div class="rowlabel col-md-offset-3"><button type="submit" class="btn btn-default btn-primary"><fmt:message key="member.start.submit.label"/></button></div></td>
				</tr>
			</table>
			<input name="pageAction" id="pageAction" value="forgotPassHandle" type="hidden"/>
		</fieldset>
	</c:if>
	<c:if test="${not empty memberSignup}">
		<c:forEach items="${chError}" var="error">
			<c:if test="${error eq 'answer.wrong'}">
				<div class="alert alert-danger">Please give correct answer of selected question.Try again.</div>
			</c:if>
		</c:forEach>
	<div class="well">
	<div class=""><strong>Please answer one of following questions and you will be able to access your account.</strong></div>
		<div class="show-grid row">
			<div class="col-md-8">
				<div class="rowlabel">
					<label for="slquestion"><small>Select a question to answer</small><span class="required">*</span></label>
				</div>
				<div class="rowlabel">
					<select id="slquestion" name="slquestion">
						<option value="">-Select-</option>
						<c:forEach items="${memberSignup.securityQuestionAnswerValueListList}" var="sqQuesList">
							<option value="${sqQuesList.question}">${sqQuesList.question}</option>
						</c:forEach>
					</select>
				</div>
				<div class="rowlabel">
					<c:forEach items="${chError}" var="error">
						<c:if test="${error eq 'question.required'}">
							<span class="label label-default label-danger">This is required.</span>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="slquestion"><small><abbr title="Answer of selected Question">Answer</abbr></small><span class="required">*</span></label>
				</div>
				<div class="rowlabel">
					<input id="slanswer" name="slanswer" type="text">
				</div>
				<div class="rowlabel">
					<c:forEach items="${chError}" var="error">
						<c:if test="${error eq 'answer.required'}">
							<span class="label label-default label-important">This is required.</span>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
		<input name="userName" id="userName" value="${memberSignup.userName}" type="hidden"/>
		<input name="pageAction" id="pageAction" value="changePassHandle" type="hidden"/>
		<br/>
		<div class="row">
		  <div class="col-md-6 col-md-offset-4">
			<button type="submit" class="btn btn-default btn-success">
				<i class="glyphicon glyphicon-lock glyphicon glyphicon-white"></i>Answered
			</button>
			</div>
	   </div>
		</div>
	</c:if>
</form>