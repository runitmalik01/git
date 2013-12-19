<%@include file="../../includes/tags.jspf"%>
<style>
ul.niceList { 
  margin-left:0em; 
  padding-left:0.2em; 
  margin-bottom:1em; 
}
ul.niceList li { 
  /*background:url(images/bullet.gif) 0em 0.5em no-repeat; *//* change background em accordingly */
  padding-left: 0.8em; 
  list-style: none; 
}
/*.niceList ul li { background-image:url(images/bullet_child.gif); }*/
 
ol.niceList li, ul.niceList li { margin-bottom:0.5em; }
 
ol.niceList { 
  margin-left:1.5em; 
  padding-left:0px; 
}
.niceList ol li { 
  list-style:decimal; 
  background-image:none; 
  padding-left:0em; 
}
</style>
	<ul class="niceList">
		<c:forEach items="${services.items}" var="serviceitem" varStatus="status">
			<c:if test="${serviceitem.enable eq 'true'}">
				<hst:cmseditlink var="test" hippobean="${serviceitem}" />
				<hst:link var="link" hippobean="${serviceitem}" />
				<li>
					<a href="${link }"><c:out value="${serviceitem.name}" /></a>
					<%--
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
					 --%>
				</li>
			</c:if>
		</c:forEach>
	</ul>
<%--
<div class="row">
	<div class="col-md-12">
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
 --%>