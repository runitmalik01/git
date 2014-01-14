<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol class="breadcrumb">
	<li><fmt:message key="events.overview.location.label" />${deletelink}</li>
	<li><hst:link var="home" siteMapItemRefId="home" /><a
	href="${home}"><fmt:message key="news.detail.content.location.home" />
	</a> &gt;</li>
	<li><hst:link var="newslink" siteMapItemRefId="news" /> <a
		href="${newslink}"><fmt:message key="news.detail.content.title" /> </a>
		&gt;</li>
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
						<textarea class="field col-md-12" id="description" name="description"></textarea>

					</div>
				</div>
			</div>
			<div class="row show-grid">
				<div class="rowlabel">
					<input type="submit" class="btn btn-default btn-success" value="Save">
				</div>

			</div>
		</fieldset>
	</form>
</div>