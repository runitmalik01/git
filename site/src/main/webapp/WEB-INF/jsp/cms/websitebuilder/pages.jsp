<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../../includes/tags.jspf"%>
<c:set value="Pages Component" var="pagestitle" />
<hippo-gogreen:title title="${pagestitle}"></hippo-gogreen:title>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:link var="vendorhomelink" siteMapItemRefId="vendoritreturnhome" />
<hst:link var="pageslink" siteMapItemRefId="pages" />
<div class="alert alert-info">
	<h4>Welcome To WebsiteBuilder Panel</h4>
</div>
<ol class="breadcrumb">
	<li><a href="${vendorhomelink}">Home</a></li>
	<li><a href="${websitebuilderlink}">WebSite Builder</a></li>
	<li class="active"><a href="${pageslink}">Page Components</a></li>
</ol>
<c:if test="${pageAction == 'DEFAULT'}">
	<c:choose>
		<c:when test="${not empty listOfAllPagesComponet}">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Page Component Name</th>
						<th>No of Grid Rows</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listOfAllPagesComponet}" var="pageDocument"
						varStatus="pgstatus">
						<tr>
							<td><c:out value="${pgstatus.count}" /></td>
							<td><c:out value="${fn:toUpperCase(pageDocument.name)}" /></td>
							<td><c:out value="${fn:length(pageDocument.pageRowDetails)}" /></td>
							<td><a href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/editpage"
								class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>&nbsp;<span><strong>Edit</strong></span></a>
								<a href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/deletepage"
								class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span><strong>Delete</strong></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning">Opps! You have not create any
				Pages.Default Components are being used.</div>
		</c:otherwise>
	</c:choose>
</c:if>
<c:if test="${pageAction eq 'EDIT' || pageAction eq 'NEW' }">
<div class="alert alert-info">
	All Components of Page has been shown in rows.Each row can contain 'n'
	no of Block components.You can add Other Block Component to it.<br />
	Also you can add New rows that you want to Add in your Page Component
</div>
<hr />
<div align="center">
	<div class="btn-group" align="center">
		<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
			Add New Row to <c:if test="${pageAction eq 'EDIT'}"> <c:out value="${fn:toUpperCase(parentBean.name)}"/></c:if> Page Component <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="<c:choose><c:when test="${pageAction eq 'EDIT'}">${websitebuilderlink}/pages.html/${componentUUID}/editpage/rows/newrow</c:when>
			<c:otherwise>${websitebuilderlink}/pages.html/newpage/rows/newrow</c:otherwise></c:choose>"
				id="newchild"><i class="glyphicon glyphicon-plus-sign"></i><strong>Add</strong></a></li>
		</ul>
	</div>
</div><hr/>
</c:if>
<c:if test="${pageAction == 'EDIT'}">
	<div class="alert alert-warning" align="center">
		Details of <strong><c:out value="${fn:toUpperCase(parentBean.name)}" /></strong> Page Component
	</div>
	<hr/>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<tbody>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.pageRowDetails}" var="pageRowDetail">
						<tr>
							<c:forEach items="${pageRowDetail.blockDocuments}" var="blockDocument">
								<td><c:out value="${blockDocument.name}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/editblock"
									class="btn btn-primary btn-xs"><i class="glyphicon glyphicon-edit"></i><span><strong>Edit
												Block</strong></span></a>
									<a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/deleteblock"
									class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-remove-sign"></i><span><strong>Delete
												Block</strong></span></a>		
												</td>
							</c:forEach>
							<td> <a href="${scriptName}/${componentUUID}/editpage/rows/${pageRowDetail.canonicalUUID}/editrow" class="btn btn-info btn-sm"><i class="glyphicon glyphicon-edit"></i>Edit Row</a>
							<a href="${scriptName}/${componentUUID}/editpage/rows/${pageRowDetail.canonicalUUID}/deleterow" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i>Remove Row</a>    
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</c:if>
<c:set var="sectionData">
	<div class="row">
		<div class="col-md-12">
			<div class="well well-sm well-primary">
				<div class="input-group">
					<!--  <input type="hidden" name="blockDocCanonicalUUIDs" id="blockDocCanonicalUUIDs" value=""/> -->
					<label for="blocDocCanonicalUuid"><small>Select Block Component</small></label> 
					<select name="blockDocCanonicalUUIDs" class="select-drop head form-control" id="blockDocCanonicalUUIDs"
						multiple="multiple">
						<option value="">-Select-</option>
						<c:forEach var="blockDoc" items="${listOfAllBlocksComponet}">
							<option value="${blockDoc.canonicalUUID}"
								<c:if test="${pageAction eq 'EDIT_CHILD'}">
							<c:forEach items="${childBean.blockDocuments}" var="svblockDocument">
								<c:choose>
									<c:when test="${svblockDocument.canonicalUUID eq blockDoc.canonicalUUID}">
										selected="selected"
									</c:when>
								</c:choose>
							</c:forEach>
						</c:if>>
								<c:out value="${blockDoc.name}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
</c:set>
<c:if test="${pageAction == 'NEW_CHILD'||pageAction == 'EDIT_CHILD'}">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Add New Row Component Panel</h4>
				</div>
				<div class="modal-body">
				     <hst:actionURL var="actionUrl"></hst:actionURL>
					<form id="pageRowDetailsForm" name="pageRowDetailsForm" class="pageRowDetailsForm" action="${actionUrl}" method="post">
						<div class="scheduleSIbody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<%-- <c:if test="${pageAction eq 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/deleterows"
							class="btn btn-danger btn-sm"> <i class="glyphicon-trash glyphicon"></i>Delete
						</a>
					</c:if> --%>
					<a href="<c:choose><c:when test="${pageAction eq 'EDIT_CHILD'}">${scriptName}/${componentUUID}/editpage</c:when>
					            <c:otherwise>${websitebuilderlink}/pages.html/newpage</c:otherwise></c:choose>"
						class="btn btn-default btn-sm" data-dismiss="">Close</a> 
					<a href="#" id="siSave" class="btn btn-primary btn-sm">Save changes</a>
				</div>
			</div>
		</div>
	</div>
</c:if>

<div align="center">
	<a href="${websitebuilderlink}/blocks.html/newblock"
		class="btn btn-success btn-labeled"><span class="btn-label"><i
			class="glyphicon glyphicon-plus"></i></span>Click Here to add New
		BlockComponent</a>
	<%-- <div class="row">
		<div class="col-md-12">
			<div class="col-lg-4">
				<div class="input-group">
					<input type="text" class="form-control input-sm" name="componentName" id="componentName" title="Name of Block Component"
						placeholder="Add New Block Component">
					<div class="input-group-btn">
					   <a href="${websitebuilderlink}/blocks.html/newblock" class="btn btn-success btn-sm"
								id="addcomponent"><i class="glyphicon glyphicon-plus-sign"></i><strong>ADD</strong></a>
						<!-- <button type="button" class="btn btn-success dropdown-toggle btn-sm"
							data-toggle="dropdown"> Action <span class="caret"></span>
						</button>
						<ul class="dropdown-menu pull-right">
							<li></li>
						</ul> -->
					</div>
				</div>
			</div>
		</div>
	</div> --%>
</div>



<script type="text/javascript">
$('document').ready(function(){
	if ($("#myModal").length >0) $("#myModal").modal();
	$('#siSave').on('click',function(){
        $('#pageRowDetailsForm').submit();
     });
    $('#addcomponent').on('click',function(){
    	if($('#componentName').val() == '' ){//&& !($('#componentName').val().match('^([A-Za-Z]/s)+$'))
    		$('div.input-group').addClass('has-error');
    		$('#addcomponent').attr('href','#');
    	}else{
    		$('div.input-group').removeClass('has-error');
    		var hrefVal = '<c:out value="${websitebuilderlink}"/>'+'/blocks.html/newblock';
    		$('#addcomponent').attr('href',hrefVal+'/'+$('#componentName').val());
    	}
    });
    
//    $('a[data-confirm]').click(function(ev) {
//        var href = $(this).attr('href');

//        if (!$('#dataConfirmModal').length) {
//            $('body').append('<div id="dataConfirmModal" class="modal" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"> <div class="modal-header">
// 			<button type="button" class="close" data-dismiss="modal"
// 				aria-hidden="true">×</button>
// 			<h3 id="dataConfirmLabel">Please Confirm</h3>
// 		</div>
// 		<div class="modal-body"></div>
// 		<div class="modal-footer">
// 			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
// 			<a class="btn btn-primary" id="dataConfirmOK">OK</a>
// 		</div>
// 	</div>');
//        }
//        $('#dataConfirmModal').find('.modal-body').text("Are you sure you want to delete?");
//        $('#dataConfirmOK').attr('href', href);
//        $('#dataConfirmModal').modal({show:true});
//        return false;
//    });
});
</script>