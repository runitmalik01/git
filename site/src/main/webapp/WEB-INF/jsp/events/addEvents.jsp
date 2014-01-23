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
			<legend>Edit your Events</legend>

			<div class="row show-grid">
				<div class="col-md-5">
					<div class="rowlabel">
						<label for="title">Title Of Event </label>
					</div>
					<div class="rowlabel">
						<input type="text" id="title" name="title">
					</div>
				</div>
			</div>
			<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="newstartdate"> Start Date </label>
						</div>
						<div class="rowlabel">
							<input type="text" id="newstartdate" name="newstartdate"/>
						</div>
					</div>
				</div>
			<div class="row show-grid">
					<div class="col-md-6">
						<div class="rowlabel">
							<label for="newenddate"> End Date</label>
						</div>
						<div class="rowlabel">
							<input type="text" id="newenddate" name="newenddate"/>
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
						<label for="description">Description </label>
					</div>
					<div class="rowlabel">
						<textarea class="field col-md-12" id="description" name="description"></textarea>
						<w4india:ckeditor_inline textAreaId="description"/>

					</div>
				</div>
			</div>
			<input type="submit" class="btn btn-default btn-success" value="Save">
		</fieldset>
	</form>
</div>
<res:client-validation formId="events"
	screenConfigurationDocumentName="newevents"/>