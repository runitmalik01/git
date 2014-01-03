<%@include file="../includes/tags.jspf"%>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:actionURL var="actionURL" />
<hippo-gogreen:title title="Dashboard"></hippo-gogreen:title>
<w4india:dashboard-menu></w4india:dashboard-menu>
<div class="row">
	<div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Dashboard Shortcuts</div>
			<div class="panel-body">
				<hst:include ref="dashboard-shortcut" />
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Dashboard History</div>
			<div class="panel-body">
				<hst:include ref="dashboard-event-log" />
			</div>
		</div>
	</div>
	<!-- <div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">DashBoard History</div>
			<div class="panel-body">
				Name of new Component
			</div>
		</div>
	</div> -->
</div>
