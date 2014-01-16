<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:set var="inlineEditingEnabled" value="false" />
<c:if test="${preview}">
	<c:if test="${inlineEditingEnabled}">
		<jsp:include page="../inc/inline-editing-head-contributions.jsp" />
	</c:if>
</c:if>


<ol class="breadcrumb">
	<li><fmt:message key="events.overview.location.label" />${deletelink}</li>
	<li><hst:link var="home" siteMapItemRefId="home" /><a
		href="${home}"><fmt:message
				key="news.detail.content.location.home" /> </a> &gt;</li>
	<li><hst:link var="newslink" siteMapItemRefId="news" /> <a
		href="${newslink}"><fmt:message key="news.detail.content.title" />
	</a> &gt;</li>
</ol>
<div class="page">
	<form id="news" action="${actionUrl}" name="news" method="post">
		<fieldset>
			<legend>Add your News</legend>
			<div class="row show-grid">
				<div class="col-md-5">
					<div class="rowlabel">
						<label for="title">Title Of News </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="title" name="title">
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-7">
					<div class="rowlabel">
						<label for="summary">Summary </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="summary" name="summary">
					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">

						<label for="description">Description</label>
					</div>
					<div class="rowlabel">

						<textarea class="field col-md-12" id="description"
							name="description"></textarea>
							<w4india:ckeditor_inline textAreaId="description"/>

					</div>
				</div>
			</div>
			<input type="submit" class="btn btn-default btn-success" value="Save">
		</fieldset>
	</form>
</div>
<c:if test="${preview && inlineEditingEnabled}">
	<jsp:include page="../inc/inline-editing-editor-form.jsp" />
</c:if>