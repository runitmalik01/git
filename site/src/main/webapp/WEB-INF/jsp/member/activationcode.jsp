<%--

 This for forgot activation code
 @author abhishek
 12/03/2013
 --%>
<%@include file="../includes/tags.jspf"%>
<c:set var="activecodetitle"><fmt:message key="member.activecode.title"/></c:set>
<hippo-gogreen:title title="${activecodetitle}"/>
<hst:actionURL var="activationcode"></hst:actionURL>
<div class="page">
		<form action="${activationcode}" method="post">
			<h4><fmt:message key="signup.forgotcode.message" /></h4>
			<h5><small><fmt:message key="member.forgotcode.message" /></small></h5>
			<fieldset id="ul_revised" class="revised_v original_h">
	             <legend>Recover Activation Code</legend>
	             <div class="row show-grid" id="ul_revised_input">
				 	  <div class="col-md-2">
					 	  <label for="username">
					          <small><fmt:message key="signup.email.required" /></small>
					       </label>
				       </div>
				       <div class="col-md-8">
				       <input type="text" name="email" value="${fn:escapeXml(email)}" class="input_data" />
						 <c:if test="${not empty errors}">
								<c:forEach items="${errors}" var="error">
									<c:choose>
										<c:when test="${error eq 'signup.email.error.required'}">
											<span class="form-error"><fmt:message
													key="signup.email.error.required" /> </span>
											<br />
										</c:when>
										<c:otherwise>
											<span class="form-error"><c:out value="${error}"/></span>
											<br />
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
							<c:if test="${not empty email_error}">
								<span class="form-error">
								<c:out value="Your Email is not registered" /> </span>
							</c:if>
				   	</div>
				   	<div class="col-md-2">
						<input type="submit"
						value="<fmt:message key="member.start.submit.label"/>"
						class="yui3-button" />
					</div>
			</div>
		 </fieldset>
		</form>
</div>