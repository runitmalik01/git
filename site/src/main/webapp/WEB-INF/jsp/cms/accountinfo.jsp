<%@page import="com.mootly.wcm.channels.WebsiteInfo"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="imgLogo" hippobean="${logo.original}"/>
<hst:actionURL var="actionURL" />
<hippo-gogreen:title title="Account Info"></hippo-gogreen:title>
<w4india:dashboard-menu></w4india:dashboard-menu>
<% HstRequest hstRequest = (HstRequest) request;
  WebsiteInfo websiteInfo = hstRequest.getRequestContext().getResolvedMount().getMount().getChannelInfo();
  request.setAttribute("resellerInfo", websiteInfo);
 %>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-6 col-md-6 col-md-offset-3">
			<div class="well well-sm">
				<div class="row">
					<div class="col-sm-6 col-md-4">					    
						<a class="w4i-logo" href="${home}"><img src="${imgLogo}" class="img-rounded img-responsive" ></a>
					</div>
					<div class="col-sm-6 col-md-8">
						<h4><b>${resellerInfo.resellerName}</b></h4>
						<small><cite title="San Francisco, USA"><i class="glyphicon glyphglyphicon glyphicon-map-marker"> </i>
						</cite></small>
						<p>
							<i class="glyphicon glyphicon-envelope"></i>&nbsp;${resellerInfo.emailCustomerService } <br />
							<i class="glyphicon glyphicon-globe"></i><a href="http://www.jquery2dotnet.com">www.<w4india:resellername/>.com</a> <br />
							<i class="glyphicon glyphicon-gift"></i>${resellerInfo.startDate}-${resellerInfo.endDate }<br/>
							&#8377;${resellerInfo.paymentAvailableTypes}<br/>
							<i class="glyphicon glyphicon-phone"></i>${resellerInfo.phoneCustomerService}<br/>
						</p>
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-default btn-primary"><i class="glyphicon glyphicon-share"></i>&nbsp;Social</button>
							<button type="button" class="btn btn-default btn-primary dropdown-toggle"data-toggle="dropdown">
								<span class="caret"></span><span class="sr-only">Social</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="https://www.twitter.com/<w4india:resellername/>">Twitter</a></li>
								<li><a href="https://plus.google.com/+Jquery2dotnet/posts">Google+</a></li>
								<li><a href="https://www.facebook.com/<w4india:resellername/>">Facebook</a></li>
								<li><a href="https://in.linkedin.com/in/<w4india:resellername/>">LinkedIn</a></li>
								<li class="divider"></li>
								<li><a href="#">Github</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%-- <div class="row">
	<div class="alert alert-info">It takes just a minute to join.
		Please enter the following information to create your account.</div>
	<form action="${actionUrl}" method="post" id="signupForm">
		<div>
			<label for="email"> <small>Reseller ID (required)</small>
			</label> <input name="resellerID" id="resellerID"
				value="${fn:escapeXml(resellerID)}" size="22" tabindex="1"
				type="text" maxlength="6"> <label for="resellerID"
				class="error" generated="false"><c:if
					test="${not empty resellerIDError}">
					<fmt:message key="${resellerIDError}" />
				</c:if></label>
		</div>
		<div>
			<label for="email"> <small>Email Address (required)</small>
			</label> <input class="username" name="email" id="email"
				value="${fn:escapeXml(email)}" size="22" tabindex="1" type="text"
				maxlength="50"> <label for="email" class="error"
				generated="false"><c:if test="${not empty emailError}">
					<fmt:message key="${emailError}" />
				</c:if></label>
		</div>
		<div>
			<label for="confirmEmail"> <small>Confirm Email
					Address (required)</small>
			</label> <input class="username" name="confirmEmail" id="confirmEmail"
				value="" size="22" tabindex="2" type="text" maxlength="50">
			<label for="confirmEmail" class="error" generated="false"><c:if
					test="${not empty confirmEmailError}">
					<fmt:message key="${confirmEmailError}" />
				</c:if></label>
		</div>
		<div>
			<label for="password"> <small>Password (required)</small>
			</label> <input name="password" id="password" value="" size="22" tabindex="3"
				type="password" maxlength="20"> <label for="password"
				class="error" generated="false"><c:if
					test="${not empty passwordError}">
					<fmt:message key="${passwordError}" />
				</c:if></label>
		</div>
		<div>
			<label for="confirmPassword"> <small>Confirm Password
					(required)</small>
			</label> <input name="confirmPassword" id="confirmPassword" value=""
				size="22" tabindex="4" type="password" maxlength="20"> <label
				for="confirmPassword" class="error" generated="false"><c:if
					test="${not empty confirmPasswordError}">
					<fmt:message key="${confirmPasswordError}" />
				</c:if></label>
		</div>
		<div>
			<label for="email"> <small>Contact No. (required)</small>
			</label> <input name="phoneCustomerService" id="phoneCustomerService"
				onchange="phonenumber()"
				value="${fn:escapeXml(phoneCustomerService)}" size="22" tabindex="1"
				type="text" maxlength="50"> <label
				for="phoneCustomerService" class="error" generated="false"><c:if
					test="${not empty phoneCustomerServiceError}">
					<fmt:message key="${phoneCustomerServiceError}" />
				</c:if></label>
		</div>
		<div>
			<input class="checkbox" id="signupTerms" name="signupTerms"
				tabindex="5" type="checkbox" value="on"> <label
				for="signupTerms">Yes, I agree to the&nbsp;<a
				href='<hst:link path="/terms"/>' target="_blank">Terms of Use</a></label> <label
				for="signupTerms" class="error" generated="false"><c:if
					test="${not empty signupTermsError}">
					<fmt:message key="${signupTermsError}" />
				</c:if></label>
		</div>
		<hst:link var="memberhome" path="/member" />
		<input type="hidden" name="destination" value="${memberhome}"/> 
	</form>
</div> --%>
