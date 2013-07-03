<%@include file="../../includes/tags.jspf"%>

	<c:forEach items="${services.items}" var="serviceitem" varStatus="status">
		<c:if test="${serviceitem.enable eq 'true'}">
			<hst:cmseditlink var="test" hippobean="${serviceitem}" />
			<hst:link var="link" hippobean="${serviceitem}" />
			<div class="span4 widget-wrapper" align="left">
				<a href="${link}"><c:out value="${serviceitem.name}" /></a>
			</div>
		</c:if>
	</c:forEach>

<div class="row-fluid">
  <div class="span12">
<c:choose>
	<c:when test="${services.total eq 0}">
		<p id="results">
			<fmt:message key="search.results.noresults" />
			'${query}'
		</p>
	</c:when>
	<c:otherwise>
		<hippo-gogreen:home-service-pagination pageableResult="${services}" queryName="query" queryValue="${query}" />
	</c:otherwise>
</c:choose>
   </div>
</div>