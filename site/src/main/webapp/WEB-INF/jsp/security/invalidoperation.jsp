<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Invalid Operation" />
<c:set value="<%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll(\"@\",\"-at-\") :\"\"%>" var="loggedin"></c:set>
<c:choose>
	<c:when test="${not empty loggedin}">
		<hst:link var="homeLink" siteMapItemRefId="itreturnhome"></hst:link>
	</c:when>
	<c:otherwise>
		<hst:link var="homeLink" siteMapItemRefId="home"></hst:link>
	</c:otherwise>
</c:choose>

<div class="hero-unit center">
	<h1>
		<small><font face="Tahoma" color="red">Invalid operation.</font></small>
	</h1>
	<br /> <a href="${homeLink}" class="btn btn-default btn-lg btn-info"><i class="glyphicon glyphicon-home glyphicon glyphicon-white"></i> Take Me Home</a>
</div>