<%@include file="../includes/tags.jspf"%>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hippo-gogreen:title title=""></hippo-gogreen:title>
<hst:actionURL var="actionURL" /><hr/>
<div class="alert alert-info" align="center">
	<h5>${fn:toUpperCase(hippoBeanDocument.node.name)}</h5>
</div>
<form action="${actionURL}" method="post" name="documenteditorForm" id="documenteditorForm">
	<div class="container">
		<div id="collapseOne" class="panel-collapse collapse in">
			<c:forEach items="${mapOfAbstractFormFields}" var="abstractField">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<c:out value="${abstractField.value.html}" escapeXml="false" />
						</div>
					</div>
				</div>
			</c:forEach>
			<button type="submit" class="btn btn-success btn-sm">
				<i class="glyphicon-upload glyphicon"></i>&nbsp;Update Document
			</button>
		</div>
	</div>
</form>