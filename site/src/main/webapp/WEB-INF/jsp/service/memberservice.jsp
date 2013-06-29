<%@include file="../includes/tags.jspf"%>
<div class="row-fluid show-grid">
	<div class="span8">
	  <div class="rowlabel">
		<h2 align="center">Weath4India Services</h2>
		<div id="services">
			<%--@elvariable id="services" type="java.util.List<com.mootly.wcm.beans.NewsItem>"--%>
			<c:forEach items="${services.items}" var="serviceitem"
				varStatus="status">
				<c:if test="${serviceitem.enable eq 'true'}">
					<hst:cmseditlink var="test" hippobean="${serviceitem}" />
					<hst:link var="link" hippobean="${serviceitem}" />
					<div align="center">
						<a href="${link}"><c:out value="${serviceitem.name}" /></a>
					</div>
					<div class="well text-center">
						<c:out value="${serviceitem.serviceDescription}" />
					</div>
				</c:if>
			</c:forEach>
		</div>
		<c:choose>
			<c:when test="${services.total eq 0}">
				<p id="results">
					<fmt:message key="search.results.noresults" />
					'${query}'
				</p>
			</c:when>
			<c:otherwise>
				<hippo-gogreen:pagination pageableResult="${services}"
					queryName="query" queryValue="${query}" />
			</c:otherwise>
		</c:choose>
		</div>
	</div>
	<div class="span4">
	   <div class="rowlabel">
		   <hst:include ref="facetnav" />
		</div>
	</div>
</div>