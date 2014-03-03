

<%@include file="../../includes/tags.jspf"%>

<c:set var="newsoverviewtitle">
	<fmt:message key="news.overview.content.title" />
</c:set>
<hst:link var="newslink" siteMapItemRefId="news" />
<hippo-gogreen:title title="${newsoverviewtitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="page" id="news">
	<c:if test="${news.total gt 0}">
		<ol class="breadcrumb">
			<li><fmt:message key="news.overview.content.location.label" />
			</li>
			<li><a href="<hst:link siteMapItemRefId="home" />"><fmt:message
						key="news.overview.content.location.home" /> </a> &gt;</li>
		</ol>

		<div class="row show-grid">
			<span class="col-md-8"> <b><fmt:message
						key="news.overview.content.title" /> &nbsp;&nbsp;&nbsp; <hst:link
						var="linknew" hippobean="${newsitem}" /> </b> <c:if
					test="${isVendor eq 'true' }">
					<a class="btn btn-default navbar-btn navbar-right btn-primary"
						href="${newslink}/newNews"><small><i
							class="glyphicon glyphicon-plus"></i>Create New</small></a>
				</c:if>

			</span>
		</div>
	</c:if>

	<c:forEach items="${news.items}" var="newsitem" varStatus="status">
		<c:if test="${preview}">editable</c:if>
		<hst:link var="link" hippobean="${newsitem}" />
		<c:if test="${fn:contains(link,'/documents/')}">
          	<c:set var="linkURL" value="/${fn:substringAfter(link,'/documents/')}"/>
          	<hst:link var="link" path="${linkURL}"/>
         </c:if>
        <hst:link var="editLink" path="${fn:replace(linkURL,'.html','.edit')}"/>
        <hst:link var="deleteLink" path="${fn:replace(linkURL,'.html','.del')}"/>
		<ul class="image">
			<c:if test="${newsitem.firstImage != null}">
				<hst:link var="src"
					hippobean="${newsitem.firstImage.smallThumbnail}" />
				<a href="${link}"><img src="${src}"
					alt="${fn:escapeXml(newsitem.firstImage.alt)}" /> </a>
			</c:if>
		</ul>
		<ul class="title">
			<hst:cmseditlink hippobean="${newsitem}" var="cmsEditLink" />
			<a href="${link}"><c:out value="${newsitem.title}" /> </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${link}"><fmt:formatDate value="${newsitem.date.time}"
					type="date" pattern="MMM d, yyyy" /> </a>
		</ul>
		<ul class="text">
			<c:out value="${newsitem.summary}" />
		</ul>
		<ul class="comments">
			<c:if test="${isVendor eq 'true' }">
				<a class="btn btn-default btn-sm btn-success"
					href="${editLink}"><small><i
						class="glyphicon glyphicon-pencil"></i>Edit</small></a> &nbsp;&nbsp;&nbsp;<a
					class="btn btn-default btn-sm btn-danger"
					href="${deleteLink}"><small><i
						class="glyphicon glyphicon-trash"></i>Delete</small></a>
			</c:if>
			&nbsp;&nbsp;&nbsp;
			<a class="btn btn-default btn-sm btn-info" href="${link}"> <c:choose>
					<c:when test="${commentsCountList[status.index] > 0}">
						<c:out value="${commentsCountList[status.index]} " />
						<fmt:message key="news.overview.content.commentsfound" />
						<c:if test="${commentsCountList[status.index] gt 1}">
							<fmt:message key="news.overview.content.commentsplural" />
						</c:if>
					</c:when>
					<c:otherwise>
						<fmt:message key="news.overview.content.nocomments" />
					</c:otherwise>
				</c:choose>
			</a>
		</ul>
	</c:forEach>
	<c:choose>
		<c:when test="${news.total eq 0}">
			<p id="results">
				<fmt:message key="search.results.noresults" />
				'${query}'
			</p>
		</c:when>
		<c:otherwise>
			<hippo-gogreen:pagination pageableResult="${news}" queryName="query"
				queryValue="${query}" />
		</c:otherwise>
	</c:choose>
</div>
