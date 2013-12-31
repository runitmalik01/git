<%@include file="../includes/tags.jspf"%>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:actionURL var="actionURL"/>
<hippo-gogreen:title title="Dashboard Shortcut"></hippo-gogreen:title>
<div class="row">
	<div class="col-md-3">
		<c:if test="${not empty documents}">
			<c:forEach items="${documents}" var="document">
				<c:forEach items="${document.dashboardShortcutDetail}"
					var="dbshortcut">
					<%-- <c:if test="${dbshortcut.enable}"> --%>
					<a href="#" class="btn btn-warning" id="${dbshortcut.canonicalUUID}" data-prompt=""><c:out value="${dbshortcut.shortcutLabel}" /></a>
					<%-- </c:if> --%>
					<br /> <hr />
				</c:forEach>
			</c:forEach>
		</c:if>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel"></h4>
			</div>
			<div class="modal-body">
				<form action="${actionURL}" method="post" name="dashboardshortForm" id="dashboardshortForm">
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<label for="documentName">Document Name</label> 
								<input type="hidden" name="contentFolder" id="contentFolder"/>
								<input type="hidden" name="documentType" id="documentType"/> 
								<input type="text" class="form-control" name="documentName"
									id="documentName" placeholder="Name of Document" title="Name of Document" />
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal"><i class="glyphicon glyphicon-remove-sign"></i>&nbsp;Cancel</button>
				<a href="#" class="btn btn-success btn-sm" id="dataConfirmOK"><i class="glyphicon glyphicon-floppy-disk"></i>&nbsp;Create</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('a[data-prompt]').click(function(ev) {
		var href = $(this).attr('href');
		var contentFolder = null;var documentType = null;
		if($('#myModal').length > 0){
			$('#myModal').modal({
				show: true,
				backdrop: 'static'
			});	
		}
		var id = $(this).attr('id');
		<c:forEach items="${documents}" var="document">
		    <c:forEach items="${document.dashboardShortcutDetail}" var="dbshortcut">
			   if('<c:out value="${dbshortcut.canonicalUUID}"/>' == id){
				   contentFolder = '<c:out value="${dbshortcut.contentFolder}"/>';
				   documentType = '<c:out value="${dbshortcut.documentType}"/>';
			   }
		    </c:forEach>
	    </c:forEach>
		$('#myModalLabel').text($(this).text()+'Panel');
		$('#contentFolder').val(contentFolder);
		$('#documentType').val(documentType);
		return false;
	});
	$('#dataConfirmOK').on('click',function(){
    	if($('#documentName').val() == '' ){ //&& !($('#componentName').val().match('^([A-Za-Z]/s)+$'))
    		$('div.form-group').addClass('has-error');
    		$('#dataConfirmOK').attr('href','#');
    	}else{
    		$('div.form-group').removeClass('has-error');
    		$('#dashboardshortForm').submit();
    	}
    });
</script>