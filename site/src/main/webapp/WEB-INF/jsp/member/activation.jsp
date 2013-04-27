<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<c:choose>
	<c:when test="${not empty isError}">
		<h3><fmt:message key="${errorCode}"/></h3><br/>
	</c:when>
	<c:otherwise>
		<legend style="color: blue"><fmt:message key="member.message.active"/></legend>
		<h3><fmt:message key="member.message.info1"/></h3><br/>
		<h4 style="color:green"><fmt:message key="member.message.info2"/>(${userName}) </h4>
	</c:otherwise>
</c:choose>

