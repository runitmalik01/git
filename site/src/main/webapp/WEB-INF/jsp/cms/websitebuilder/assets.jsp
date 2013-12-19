<%@page import="com.mootly.wcm.components.ITReturnComponentHelper"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="java.net.URLEncoder"%>
<%@include file="../../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="docattach"></hst:link>
<hippo-gogreen:title title="Asset Drive" />
<c:set value="Pages Component" var="pagestitle" />
<hippo-gogreen:title title="${pagestitle}"></hippo-gogreen:title>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:link var="assetslink" siteMapItemRefId="assets" />
<div class="alert alert-info">
	<h4>Welcome To WebsiteBuilder Panel</h4>
</div>
<ol class="breadcrumb">
	<li><a href="${vendorhomelink}">Home</a></li>
	<li><a href="${websitebuilderlink}">WebSite Builder</a></li>
	<li class="active">Asset Components</li>
</ol>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<%StringBuilder builder=new StringBuilder();
builder.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort());
HstRequest hstRequest = (HstRequest) request;
ITReturnComponentHelper componentHelper = new ITReturnComponentHelper();
if(componentHelper.isReSeller(hstRequest)){
	if(componentHelper.getResellerId(hstRequest) != null){
		builder.append("/r/").append(componentHelper.getResellerId(hstRequest));
	}
}
pageContext.setAttribute("hostname", builder.toString());
%>
<hst:include ref="folder-component"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
	<h4 align="center"><b>Assets Drive</b></h4>
	<form id="memberdrive" action="${actionUrl}" method="post" name="memberdrive" enctype="multipart/form-data">
     <small><strong>Upload your Asset for Building Web Pages</strong></small>
		<c:if test="${not empty msg}">
			<div class="row show-grid">
				<div class="alert alert-success">Your have successfully
					uploaded file in Asset Drive.</div>
			</div>
		</c:if>
		<c:if test="${not empty delete}">
			<div class="row show-grid">
				<div class="alert alert-info">File has been deleted from
					Asset Drive</div>
			</div>
		</c:if>
		
		<div class="row">
			<div class="col-md-4">
			     <div class="well well-sm well-primary">
					<div class="form-group">
						<input id="description" name="description" class="form-control" type="text"/>
						<span class="input-group-addon">File Description</span>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="well well-lg well-primary">
					<div class="input-group">
						<input type="file" id="member_file" name="member_file" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="well well-sm">
					<div class="input-group" align="center">
						<a href="#" id="upload" class="btn btn-default btn-info start"> <i
							class="glyphglyphicon glyphicon-upload glyphicon"></i>&nbsp;<span>Upload</span></a>
					</div>
				</div>
			</div>
		</div>
	<small><strong>All Uploaded Assets for Creation of Web Pages</strong></small>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>File Name</th>
				<th>Type</th>
				<th align="center">Action</th>
				<th>Last Uploaded</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="file" items="${memberFiles}">
				<tr>
					<td><span class="add-on"><i class="glyphglyphicon glyphicon-file glyphicon"></i></span></td>
					<hst:link var="assetLink" hippobean="${file.memberFileResource}" />
					<td><c:out value="${file.name}" /></td>
					<td>${file.description}</td>
					<td><c:set value="${hostname}${assetLink}" var="doc_url" scope="page" /> 
					<a href="https://www.docs.google.com/viewer?url=<%=URLEncoder.encode((String)pageContext.getAttribute("doc_url"),"UTF-8")%>"
						class="btn btn-default btn-info btn-sm"> <i class="glyphglyphicon glyphicon-eye-open glyphicon"></i><span>View</span></a> 
						<a href="${assetLink}" class="btn btn-default btn-success btn-sm"> <i
							class="glyphglyphicon glyphicon-download-alt glyphicon"></i><span>Download</span></a>
						<a href="${assetslink}?delete=${file.canonicalUUID}" id="deletefile" class="btn btn-default btn-danger btn-sm" data-confirm="">
							<i class="glyphglyphicon glyphicon-trash glyphicon"></i><span>Delete</span>
					</a></td>
					<td><fmt:formatDate value="${file.memberFileResource.lastModified.time}" type="date" pattern="MMM d, yyyy" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</form>
<script type="text/javascript">
$(document).ready(function(){
	$('#member_file').bind('change', function(){
	    $('#member_file_name').text(this.files[0].name);
	    $('#file_process').show();		    
      });
	$('#member_file').popover({"html":true,
	                 "trigger":"hover",
	                 delay: { show: 500, hide: 100 },
	                 content:"Select a File to Upload in Member Drive or Drag Here"
	  });
	  $('#descrption').popover({"html":true,
	                 "trigger":"hover",
	                 delay: { show: 500, hide: 100 },
	                 content:"Select a description of File or write Your own"
	  });
      $('#upload').click(uploadDoc);
      function uploadDoc(){
		    $('#memberdrive').submit();
        }
	 });
</script>
<script src="<hst:link path="/js/action-confirm.js"></hst:link>"></script>