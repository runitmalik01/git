<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<c:if test="${not empty formError}">
	<c:forEach items="${formError}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty error}"><div class="alert alert-danger">Error while creating folder.Please try Again.</div></c:if>
<c:if test="${not empty success}"><div class="alert alert-success">Folder Successfully created.</div></c:if>
<c:if test="${not empty alError}"><div class="alert alert-danger">Oops!Folder already existed.</div></c:if>
<form action="${actionURL}" method="post" name="folderForm" id="folderForm" role="form">
	<div class="row">
		<div class="col-md-3">
			<div class="form-group">
				<label for="folderName">Folder Name</label> 
				<input type="text" class="form-control" id="folderName" name="folderName" placeholder="Folder Name">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group">
				<label for="parentFolderName">Component Name</label> 
				<input type="text" class="form-control" id="parentFolderName" name="parentFolderName" placeholder="Folder Name">
			</div>
		</div>
		<div class="col-md-3">
			<div class="form-group"><br/>
				<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-folder-close"></i>&nbsp;Create Folder</button>
			</div>
		</div>
	</div>
</form>