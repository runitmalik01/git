<!-- News Catalog to show News Items on Home Page -->
<%@include file="../includes/tags.jspf"%>
<hst:link var="servicelink" siteMapItemRefId="myservices"/>
<c:set value="${items}" var="servicesDocuments"/>
<div class="widget-wrapper">
	<div class="row-fluid">
		<c:if test="${not empty servicesDocuments}">
			<c:forEach items="${servicesDocuments}" var="srdocument" varStatus="nstat">
<%-- 				<c:if test="${nstat.index lt servicesItems }"> --%>
					<div class="span2">
						<hst:link path="images/catalog/service.png" var="srimgpath"></hst:link>
						<img src="${srimgpath}" class="img-circle">
					</div>
					<div class="">
						<hst:link var="srvicesdoclink" hippobean="${srdocument}" />
						<small><a href="${srvicesdoclink}"><c:out
									value="${srdocument.name}" /></a></small>
						<h6>
							<small>Price:<c:forEach items="${srdocument.costModel}" var="ctModel">
									<c:if test="${fn:toLowerCase(ctModel.offeringMode) eq 'efile'}">
										<c:out value="${ctModel.cost}" />
									</c:if>
								</c:forEach></small>
						</h6>
					</div>
					<hr/>
<%-- 				</c:if> --%>
			</c:forEach><small><a href="${servicelink}">More..</a></small>
		</c:if>
	</div>
</div>