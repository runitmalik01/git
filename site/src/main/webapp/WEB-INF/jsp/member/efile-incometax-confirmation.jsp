<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<c:set var="ditsynctitle">
	<fmt:message key="member.ditsyn.title" />
</c:set>
<w4india:itrmenu />

<c:choose>
	<c:when test="${empty freezeIncomeTaxAction}">
		<div class="alert alert-danger">Error in locating your record.</div>
	</c:when>
</c:choose>
