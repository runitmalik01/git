
<%@include file="../includes/tags.jspf"%>
<c:set var="activecodetitle"><fmt:message key="member.activecode.title"/></c:set>
<hippo-gogreen:title title="${activecodetitle}"/>
<hst:actionURL var="activationcode"></hst:actionURL>
<div class="page">
		<form action="${activationcode}" method="post" id="activationForm">
		<c:choose>
		<c:when test="${not empty success}">
		    <div class="alert alert-info" id="chkentry">
            <fmt:message key="member.message.active"/>
		    <h3><fmt:message key="member.message.info1"/></h3><br/>
		    <h4 style="color:green"><fmt:message key="member.message.info2"/>(${userName}) </h4>
		    </div>
		</c:when>
		<c:otherwise>
		 <div class="alert alert-info" id="chkentry">
			<h4><fmt:message key="signup.forgotcode.message" /></h4>
			<h5><small><fmt:message key="reseller.forgotcode.message" /></small></h5>
			</div>
			<fieldset>
	             <legend>Recover Activation Code</legend>
	       <p>
		 	  <label for="email">
		          <small>Reseller ID (required)</small>
		       </label>
		       <input name="resellerID" id="resellerID" value="${fn:escapeXml(resellerID)}" size="22" tabindex="1" type="text" maxlength="6">
		       <c:if test="${not empty reseller_error}">
				    <span class="form-error">
					      <c:out value="Reseller ID is not registered" /> 
					</span>
			   </c:if>
			    <c:if test="${not empty reseller_acvtivation}">
				    <span class="form-error">
					      <c:out value="Reseller ID is already activated" /> 
					</span>
			   </c:if>
		   </p>
		   <!-- 
		   <p>
		 	  <label for="email">
		          <small>Email Address (required)</small>
		       </label>
		       <input class="username" name="email" id="email" value="${fn:escapeXml(email)}" size="22" tabindex="1" type="text" maxlength="50">
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
		   </p>
		    -->
		    <p>
		   		<a href="javascript:void(0);" id="hrefActivation" class="orange button">Get Activation Code</a>
		   </p>
		 </fieldset>   
		</c:otherwise>
		</c:choose>
	</form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefActivation').click(function() {
 				 $('#activationForm').submit();
			});
			$('#activationForm input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#activationForm').submit();
			    }
			});
			$('#activationForm').validate({
				rules: {
					email: {
						required: true,
						minlength: 2,
						email:true
					},
					resellerID:{
					required: true
					}
				},
				messages: {
					email: "Please enter a valid email address.",
					resellerID: "Reseller ID is required."
				}
			});


		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
