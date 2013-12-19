<!-- News Catalog to show News Items on Home Page -->
<%@include file="../includes/tags.jspf"%>
<hst:link var="newslink" siteMapItemRefId=""/>
<c:set value="${items}" var="newsdocuments"/>
<div class="widget-wrapper">
	<div class="row">
		<c:if test="${not empty newsdocuments}">
			<c:forEach items="${newsdocuments}" var="nwdocument" varStatus="nstat">
<%-- 				<c:if test="${nstat.index lt newsItems}"> --%>
					<div class="col-md-2">
						<hst:link path="images/catalog/news.png" var="nwimgpath"></hst:link>
						<img src="${nwimgpath}" class="img-circle">
					</div>
					<div class="">
						<hst:link var="newsdoclink" hippobean="${nwdocument}" />
						<h6>
							<small><fmt:formatDate value="${nwdocument.date.time}" pattern="MMM-DD-YYYY" /></small>
						</h6>
						<small><a href="${newsdoclink}"><c:out value="${nwdocument.title}" /></a></small>
					</div>
					<hr />
<%-- 				</c:if> --%>
			</c:forEach><small><a href="${newslink}">More...</a></small>
		</c:if>
	</div>
</div>