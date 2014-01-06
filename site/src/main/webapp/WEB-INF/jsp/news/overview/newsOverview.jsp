

<%@include file="../../includes/tags.jspf"%>

<c:set var="newsoverviewtitle">
	<fmt:message key="news.overview.content.title" />
</c:set>
<hippo-gogreen:title title="${newsoverviewtitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
 <hst:link var="newslink" siteMapItemRefId="news" /> 


<div class="page" id="news">
	<c:if test="${news.total gt 0}">
		<ol class="breadcrumb">
			<li><fmt:message key="news.overview.content.location.label" />
			</li>
			<li><a href="<hst:link siteMapItemRefId="home" />"><fmt:message
						key="news.overview.content.location.home" /> </a> &gt;</li>
		</ol>

		<div class="row show-grid">
			<span class="col-md-8">
				<h2>	<fmt:message key="news.overview.content.title" />
					&nbsp;&nbsp;&nbsp;
					<hst:link var="linknew" hippobean="${newsitem}" />
					<c:if test="${isVendor eq 'true' }">
							<a href="${newslink}/newNews">Create New News</a>
						</c:if> 
						</h2>
			</span>
		</div>
	</c:if>

	<c:forEach items="${news.items}" var="newsitem" varStatus="status">
		<ul class="news-item <c:if test="${preview}">editable</c:if>">
			<hst:link var="link" hippobean="${newsitem}" />
			<li class="image"><c:if test="${newsitem.firstImage != null}">
					<hst:link var="src"
						hippobean="${newsitem.firstImage.smallThumbnail}" />
					<a href="${link}"><img src="${src}"
						alt="${fn:escapeXml(newsitem.firstImage.alt)}" />
					</a>
				</c:if></li>
			<li class="title"><hst:cmseditlink hippobean="${newsitem}"
					var="cmsEditLink" /> <a href="${link}"><c:out
						value="${newsitem.title}" /> </a>
			</li>

			<li class="date"><a href="${link}"><fmt:formatDate
						value="${newsitem.date.time}" type="date" pattern="MMM d, yyyy" />
			</a> |</li>
			<li class="comments"><a href="${link}"> <c:choose>
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
					</c:choose> </a></li>
			<li class="text"><c:out value="${newsitem.summary}" /></li>
			<c:if test="${isVendor eq 'true' }">
				<a href="${link}?newsEdit=newsEditlink">Edit</a> &nbsp;&nbsp;&nbsp;<a
					href="${link}?newsDelete=newsDeletelink">Delete</a>
			</c:if>
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
