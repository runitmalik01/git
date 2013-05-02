<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<c:choose>
	<c:when test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">
		<jsp:include page="houseincome-form.jsp"/>
	</c:when>
	<c:otherwise>
		<!--  show the table -->
		<a href="${scriptName}/new" class="button orange">Add New</a>
	</c:otherwise>
</c:choose>