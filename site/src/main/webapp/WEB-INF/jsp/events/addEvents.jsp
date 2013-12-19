<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol class="breadcrumb">
	<li><fmt:message key="events.overview.location.label" />${deletelink}</li>
	<li><hst:link var="home" siteMapItemRefId="home" /><a
		href="${home}"><fmt:message key="events.overview.location.home" />
	</a> &gt;</li>
	<li><hst:link var="events" siteMapItemRefId="events" /> <a
		href="${events}"><fmt:message key="events.overview.title" /> </a>
		&gt;</li>
</ol>
<div class="page">
	<form id="events" action="${actionUrl}" name="events" method="post">
		<fieldset>
			<legend>Edit Your own Events</legend>

			<div class="row-fluid show-grid">
				<div class="span5">
					<div class="rowlabel">
						<label for="title">Title Of Events </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="title" name="title">
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span7">
					<div class="rowlabel">
						<label for="summary">Summary </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="summary" name="summary">
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span8">
					<div class="rowlabel">
						<label for="description">Description </label>
					</div>
					<div class="rowlabel">
						<textarea class="field span12" id="description" name="description"></textarea>

					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="rowlabel">
					<input type="submit" value="Save" style="color: blue;">
				</div>

			</div>
		</fieldset>
	</form>
</div>