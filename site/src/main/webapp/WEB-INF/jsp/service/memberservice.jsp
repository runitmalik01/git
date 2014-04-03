<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Services"></hippo-gogreen:title>
<div class="row show-grid">
	<div class="col-md-9">
	  <div class="rowlabel">
		<h1><w4india:resellername/> Services</h1>
		<h5><small>We are constantly working towards our goal of bridging the possible gap between income earning population of 
		India with the Government of India, by providing dedicated, fast and cost effective services and creating value for our customers and partners.</small></h5>
		<div id="services">
			<c:forEach items="${searchResult.items}" var="serviceitem" varStatus="status">
				<c:if test="${serviceitem.enable eq 'true'}">
					<hst:cmseditlink var="test" hippobean="${serviceitem}" />
					<hst:link var="link" hippobean="${serviceitem}" />
					<div align="center">
						<a href="${link}"><c:out value="${serviceitem.name}" /></a>
					</div>
					<div class="well text-center">
						<c:out value="${serviceitem.serviceDescription}"/><a href="${link}">Learn More..</a>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<c:choose>
			<c:when test="${searchResult.total eq 0}">
				<p id="results">
					<fmt:message key="search.results.noresults" />
					'${query}'
				</p>
			</c:when>
			<c:otherwise>
				<hippo-gogreen:pagination pageableResult="${searchResult}" queryName="query" queryValue="${query}" />
			</c:otherwise>
		</c:choose>
		</div>
	</div>
	<div class="col-md-3">
	   <div class="rowlabel">
		   <hst:include ref="facetnav"/>
		</div>
	</div>
</div>
