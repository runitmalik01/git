
<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page">
		<form action="${actionUrl}" method="post" id="signupForm">
		     <c:choose>
		        <c:when test="${not empty isError}">
		            <h3><fmt:message key="${errorCode}"/></h3><br/>
	            </c:when>
		        <c:otherwise>
		          Thanks for the verification of requested user !!!!!!
		     </c:otherwise>
		 </c:choose>
		</form>
</div>