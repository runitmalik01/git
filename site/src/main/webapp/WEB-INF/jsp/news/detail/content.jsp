

<%@include file="../../includes/tags.jspf"%>

<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set var="inlineEditingEnabled" value="false" />

<hippo-gogreen:title title="${document.title}" />
<c:if test="${preview}">
	<c:if test="${inlineEditingEnabled}">
		<jsp:include page="../../inc/inline-editing-head-contributions.jsp" />
	</c:if>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol class="breadcrumb">
	<li><fmt:message key="news.detail.content.location.label" /></li>
	<li><hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message
				key="news.detail.content.location.home" /> </a> &gt;</li>
	<li><hst:link var="news" siteMapItemRefId="news" /> <a
		href="${news}"><fmt:message key="news.detail.content.title" /> </a>
		&gt;</li>
</ol>

<c:choose>
	<c:when test="${not empty pageAction && pageAction == 'EDIT' }">
		<form id="news" action="${actionUrl}" name="news" method="post">
			<fieldset>
				<legend>Edit your News</legend>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="title">Title Of News </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="title" name="title"
								value="${document.title}" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="summary">Summary</label>
						</div>

						<div class="rowlabel">
							<input type="text" id="summary" name="summary"
								value="${document.summary}" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="description">Description </label>
						</div>
						<div class="rowlabel">
							<textarea name="description" id="description" rows="30"
								value="<c:if test="${preview}">editable</c:if> inline"
								id="mootlywcm:description">
							<c:out value="${document.description.content}" escapeXml="false" />
								<%-- <hst:html
								hippohtml="${document.description}"/> --%>
							</textarea>
							<w4india:ckeditor_inline textAreaId="description" />
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-default btn-success"
					value="Save">
			</fieldset>
		</form>
	</c:when>
	<c:when test="${not empty newsDeletelink}">
		<form id="newsDelete" action="${actionUrl}" name="newsDelete"
			method="post">
			<fieldset>
				<legend>Delete your News</legend>
				<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="title">Title Of News </label>
						</div>
						<div class="rowlabel">
							<c:out value="${document.title}" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="deletenews">Are you sure want to delete ?</label>
						</div>
						<div class="rowlabel">
							<select id="deletenews" name="deletenews">
								<option value="select">-Select-</option>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-default btn-success"
					value="Save">
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
		<div id="content"
			class="yui-b left-and-right <c:if test="${preview}"> editable</c:if>">
			<h2 class="title">
				<c:out value="${document.title}" />
			</h2>
			<div id="article" class="news">
				<hst:cmseditlink hippobean="${document}" var="editLink" />
				<c:set var="image" value="${document.firstImage}" />
				<c:if test="${image != null}">
					<hst:link var="src" hippobean="${image.largeThumbnail}" />
					<img class="image" src="${fn:escapeXml(src)}"
						alt="${fn:escapeXml(image.alt)}" />
					<hippo-gogreen:imagecopyright image="${image}" />
				</c:if>
				<span class="date"><fmt:formatDate
						value="${document.date.time}" type="date" pattern="MMM d, yyyy" />
				</span> <span class="seperator"> | </span> <span class="comments"><a
					href="#"> <c:choose>
							<c:when test="${commentCount gt 0}">
								<c:out value="${commentCount}" />
								<fmt:message key="news.detail.content.commentsfound" />
								<c:if test="${commentCount gt 1}">
									<fmt:message key="news.detail.content.commentsplural" />
								</c:if>
							</c:when>
							<c:otherwise>
								<fmt:message key="news.detail.content.nocomments" />
							</c:otherwise>
						</c:choose>
				</a> </span>


				<div id="editable_cont" class="inline-editor-editable-container">
					<span class="<c:if test="${preview}">editable</c:if>"
						id="mootlywcm:summary"><c:out value="${document.summary}" />
					</span>
					<div class="yui-cssbase body">
						<span class="<c:if test="${preview}">editable</c:if> inline"
							id="mootlywcm:description"><hst:html
								hippohtml="${document.description}" /> </span>
						<hippo-gogreen:copyright document="${document}" />
					</div>
				</div>

				<c:if
					test="${not empty document.attachments && fn:length(document.attachments) > 0 }">
					<h5>Attachments</h5>
					<ul>
						<c:forEach items="${document.attachments}" var="asset">
							<li><a href="<hst:link hippobean="${asset}"/>"><c:out
										value="${asset.name}" /> </a></li>
						</c:forEach>
					</ul>
				</c:if>
				<%-- <ul id="document-actions">
					<li><a class="comment" href="#comment"><fmt:message
								key="news.detail.content.comment" /> </a></li>
				</ul> --%>
			</div>
			<div class="postedComments">
				<c:if test="${commentBeans != null}">
				<legend style="color:green; font-weight:bold">
					<small>Shared Comments</small>
				</legend>
					<c:forEach var="commentChild" items="${commentBeans}">
						<div class="alert alert-info">
						<ul>
							<li class="glyphicon glyphicon-user"><strong>&nbsp;<c:out
										value="${commentChild.name}"></c:out></strong></li><br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <li
								class="glyphicon glyphicon-comment">&nbsp;<c:out
									value="${commentChild.body}"></c:out></li>
									</ul>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<hst:include ref="comments" />
			
		</div>
	</c:otherwise>
</c:choose>
<c:if test="${preview && inlineEditingEnabled}">
	<jsp:include page="../../inc/inline-editing-editor-form.jsp" />
</c:if>
