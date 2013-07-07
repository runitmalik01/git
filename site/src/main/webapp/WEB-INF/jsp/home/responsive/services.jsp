<%@include file="../../includes/tags.jspf"%>
<div class="row-fluid">
	<ul class="thumbnails">
		<c:forEach items="${services.items}" var="serviceitem" varStatus="status">
			<c:if test="${serviceitem.enable eq 'true'}">
				<hst:cmseditlink var="test" hippobean="${serviceitem}" />
				<hst:link var="link" hippobean="${serviceitem}" />
				<li class="span4">
					<div class="thumbnail">
						<div class="caption">
							<h4>
								<a href="${link }" style="text-decoration: none; color: green;"><c:out value="${serviceitem.name}" /></a>
							</h4>
							<c:forEach var="category" items="${serviceitem.categories}">
								<c:forEach items="${services.items}" var="subserviceitem">
									<c:forEach var="campcategory"
										items="${subserviceitem.categories}">
										<c:choose>
											<c:when
												test="${category eq campcategory && not empty subserviceitem.subCategories && serviceitem.name != subserviceitem.name}">
												<hst:link var="sublink" hippobean="${subserviceitem}"></hst:link>
												<div><a href="${sublink}"><c:out value="${subserviceitem.name}" /></a></div>
											</c:when>
										</c:choose>
									</c:forEach>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</div>
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