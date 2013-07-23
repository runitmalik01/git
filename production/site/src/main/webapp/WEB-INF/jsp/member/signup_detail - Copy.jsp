<%--

here we are getting basic details from users for creating his/her account
@ author abhishek
20/02/2013


--%>

<%@include file="../includes/tags.jspf" %>
<c:set var="signuptitle"><fmt:message key="member.signup.title"/></c:set>
<hippo-gogreen:title title="${signuptitle}"/>
<%--
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label"/></li>
	<li>
	    <hst:link var="home" siteMapItemRefId="home" />
	    <a href="${home}"><fmt:message key="products.detail.location.home"/></a>&gt;
	</li>
	<li>
	   <hst:link var="signup" siteMapItemRefId="signup"></hst:link>
	   <a href="${signup}"><fmt:message key="member.start.signup"/></a>
	</li>
</ol>
 --%>
<hst:actionURL var="actionUrl"/>
<h3 id="respond1">Signup</h3>
<form method="post" action="${actionUrl}">
   <p>
 	  <label for="userName">
          <small>Email Address (required)</small>
       </label>
       <input name="userName" id="userName" value="${fn:escapeXml(userName)}" size="22" tabindex="1" type="text">
   </p>
   <p>
		<label for="password">
           <small>Password (required)</small>
       </label>
       <input name="password" id="password" value="" size="22" tabindex="2" type="password">
   </p>
   <p>
	   <label for="confirm_password">
           <small>Confirm Password (required)</small>
       </label>
       <input name="confirm_password" id="confirm_password" value="" size="22" tabindex="2" type="password">
   </p>
   <p>
       <input name="submit" id="submit" tabindex="5" value="Signup" type="submit">
       <input name="comment_post_ID" value="1" type="hidden">
   </p>
</form>
