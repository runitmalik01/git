<%@include file="../includes/tags.jspf" %>
<%-- <div class="row-fluid">
<c:if test="${fn:length(items) gt 0}">
	<ul class="box-general box-event <c:if test="${preview}">editable</c:if>">
	    <c:forEach items="${items}" var="item">
	        <li class="title">
            <hst:cmseditlink hippobean="${item}"/>
            <a href="<hst:link hippobean="${item}"/>"><c:out value="${item.title}"/></a>
          </li>
	        <li class="month"><fmt:formatDate value="${item.date.time}" pattern="MMM"/></li>
	        <li class="day"><fmt:formatDate value="${item.date.time}" pattern="dd"/></li>
	        <li class="content"><c:out value="${item.summary}"/></li>
	    </c:forEach>
	    <li class="more">
	        <hst:link var="overview" siteMapItemRefId="events" />
	        <a href="${overview}"><fmt:message key="events.overview.title"/></a>
	    </li>
	</ul>
</c:if>
</div> --%>
<hst:link var="eventslink" siteMapItemRefId=""/>
<div class="widget-wrapper">
	<div class="row-fluid">
		<c:if test="${not empty items}">
			<c:forEach items="${items}" var="evdocument" varStatus="nstat">
					<div class="span2">
						<hst:link path="images/catalog/icon-latest-events.png" var="evimgpath"></hst:link>
						<img src="${evimgpath}" class="img-circle">
					</div>
					<div class="">
						<hst:link var="eventdoclink" hippobean="${evdocument}" />
						<h6>
							<small><fmt:formatDate value="${evdocument.date.time}" pattern="MMM-DD-YYYY"/></small>
						</h6>
						<small><a href="${eventdoclink}"><c:out value="${evdocument.title}" /></a></small>
					</div>
					<hr />
			</c:forEach>
			<small><a href="${eventslink}">More...</a></small>
		</c:if>
	</div>
</div>