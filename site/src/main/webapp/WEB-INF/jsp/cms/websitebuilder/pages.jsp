<%@page import="com.mootly.wcm.beans.cms.PageDocument"%>
<%@page import="java.util.List"%>
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
<c:forEach items="${listOfAllPagesComponet}" var="mxpageDocument" varStatus="pgstatus">
	<c:set var="lstModDocName" value="${mxpageDocument}" />
	<c:forEach items="${listOfAllPagesComponet}" var="mnpageDocument" varStatus="pgstatus">
		<fmt:formatDate type="both" value="${lstModDocName.lastModificationDate.time}" var="mxtime" />
		<fmt:formatDate type="both" value="${mnpageDocument.lastModificationDate.time}" var="mntime" />
		<c:if test="${mxtime != mntime}">
			<c:if test="${mntime gt mxtime}">
				<c:set var="lstModDocName" value="${mnpageDocument}" />
			</c:if>
		</c:if>
	</c:forEach>
</c:forEach>
<c:if test="${pageAction eq 'DEFAULT'}">
	<c:choose>
		<c:when test="${not empty listOfAllPagesComponet}">
			<div class="panel panel-info">
				<!-- Default panel contents -->
				<div class="panel-heading">WebSite-Page Components</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Page Component Name</th>
							<th>No of Grid Rows</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfAllPagesComponet}" var="pageDocument" varStatus="pgstatus">
							<tr>
								<td><c:out value="${pgstatus.count}" /></td>
								<td><c:out value="${fn:toUpperCase(pageDocument.name)}" />
								    <c:if test="${lstModDocName.name eq pageDocument.name}">
								     <sup><span class="text-danger"><i class="glyphicon glyphicon-asterisk"></i>
								     <strong>Last Updated</strong></span></sup></c:if></td>
								<td><c:out value="${fn:length(pageDocument.pageRowDetails)}" /></td>
								<td><a href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/editpage"
									class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-edit"></i>&nbsp;<span><strong>Edit</strong></span></a>
									<a href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/deletepage" data-confirm=""
									class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i>&nbsp;<span><strong>Delete</strong></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning">Opps! You have not create any
				Pages.Default Components are being used.</div>
		</c:otherwise>
	</c:choose>
</c:if>
<c:if test="${pageAction eq 'EDIT' or pageAction eq 'NEW' }">
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
			<c:otherwise>${websitebuilderlink}/pages.html/newpage/${absoluteComponentName}/rows/newrow</c:otherwise></c:choose>"
				id="newchild"><i class="glyphicon glyphicon-plus-sign"></i><strong>Add</strong></a></li>
		</ul>
	</div>
</div><hr/>
</c:if>
<c:if test="${pageAction eq 'EDIT'}">
	<div>
		<c:if test="${not empty parentBean}">
			<c:forEach items="${parentBean.pageRowDetails}" var="pageRowDetail">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-6"><strong>Grid Row of ${parentBean.name} Page</strong></div>
							<div class="col-md-2 col-md-offset-4">
								<a href="${scriptName}/${componentUUID}/editpage/rows/${pageRowDetail.canonicalUUID}/editrow"
									class="btn btn-info btn-xs"><i class="glyphicon glyphicon-edit"></i>Edit Row</a> 
								<a href="${scriptName}/${componentUUID}/editpage/rows/${pageRowDetail.canonicalUUID}/deleterow"
									class="btn btn-danger btn-xs" data-confirm=""><i class="glyphicon glyphicon-remove-sign"></i>Remove Row</a>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<c:forEach items="${pageRowDetail.blockDocuments}" var="blockDocument">
							   <c:set value="${12 div fn:length(pageRowDetail.blockDocuments)}" var="spanSize"/>
								<div class="col-md-<fmt:parseNumber integerOnly="true" type="number" value="${spanSize}"/>">
									<div class="thumbnail well">
										<!-- <img data-src="http://placehold.it/380x500" alt="fu"> -->
										<div class="caption">
											<h4> <c:out value="${blockDocument.name}" /> </h4>
											<p></p>
											<p><a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/editblock"
													class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-edit"></i><span><strong>Edit
															Block</strong></span></a>
											    <a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/deleteblock" data-confirm=""
													class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i><span><strong>Delete
															Block</strong></span></a>
											</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
</c:if>
<c:set var="sectionData">
	<div class="row">
		<div class="col-md-12">
			<div class="well well-sm well-primary">
				<div class="input-group">
					<!--  <input type="hidden" name="blockDocCanonicalUUIDs" id="blockDocCanonicalUUIDs" value=""/> -->
					<label for="blocDocCanonicalUuid"><small>Select Block Component</small></label> 
					<select name="blockDocCanonicalUUIDs" class="select-drop head form-control" id="blockDocCanonicalUUIDs" multiple="multiple">
						<option value="">-Select-</option>
						<c:forEach var="blockDoc" items="${listOfAllBlocksComponet}">
							<option value="${blockDoc.canonicalHandleUUID}"
								<c:if test="${pageAction eq 'EDIT_CHILD'}">
							<c:forEach items="${childBean.blockDocuments}" var="svblockDocument">
								<c:choose>
									<c:when test="${svblockDocument.canonicalHandleUUID eq blockDoc.canonicalHandleUUID}">
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
<c:if test="${pageAction eq 'NEW_CHILD' or pageAction eq 'EDIT_CHILD'}">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Add New Row Component Panel</h4>
				</div>
				<div class="modal-body">
					<c:choose>
						<c:when test="${pageAction eq 'NEW_CHILD'}">
							<c:set value="row_0" var="formID" />
						</c:when>
						<c:otherwise>
							<c:set value="pageRowDetailsForm" var="formID" />
						</c:otherwise>
					</c:choose>
					<hst:actionURL var="actionUrl"></hst:actionURL>
					<form id="${formID}" name="pageRowDetailsForm" class="pageRowDetailsForm" action="${actionUrl}" method="post">
						<div class="scheduleSIbody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
				    <c:if test="${pageAction eq 'NEW_CHILD'}"><a href="#" class="btn btn-warning btn-sm" id="addnew"><i class="glyphicon glyphicon-plus-sign"></i>Add New</a></c:if>
					<%-- <c:if test="${pageAction eq 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/deleterows"
							class="btn btn-danger btn-sm"> <i class="glyphicon-trash glyphicon"></i>Delete
						</a>
					</c:if> --%>
					<a href="<c:choose><c:when test="${not empty componentUUID}">${scriptName}/${componentUUID}/editpage</c:when>
					            <c:otherwise>${websitebuilderlink}/pages.html/newpage/${absoluteComponentName}</c:otherwise></c:choose>"
						class="btn btn-default btn-sm" data-dismiss="">Close</a> 
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="ajaxsubmit" var="saveID" />
						</c:when>
						<c:otherwise>
							<c:set value="siSave" var="saveID" />
						</c:otherwise>
					</c:choose>
					<a href="#" id="${saveID}" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-ok-circle"></i>Save changes</a>
				</div>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${pageAction eq 'DEFAULT' or pageAction eq 'EDIT' }"><jsp:include page="addcomponentfoot.jsp"/></c:if>
<script type="text/javascript">
$('document').ready(function(){
	if ($("#myModal").length >0) $("#myModal").modal();
	$('#siSave').on('click',function(){
        $('#pageRowDetailsForm').submit();
     });   
     $('#ajaxsubmit').on('click',function(){
     allForms=$('.pageRowDetailsForm');
     allForms.each ( function(index,value) {
				$(value).validate();
				if (!$(value).valid()) {
					return false;
				}
			});
	  for (var i=0;i< allForms.length; i++ ) {
           var theData = $(allForms[i]).serialize();
				$.ajax('<hst:actionURL></hst:actionURL>',
						{
						'data': theData,
						'method':'POST',
						'async':false											
					  }).done (function () {
						window.location.href = '<c:out value="${scriptName}"/>';
					});
		   }
       });   
     $('#addnew').on('click', function(){
           var rehtml=$('.modal-body').html();
           arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.pageRowDetailsForm').last();
			 var theId  = theForm.attr('id');
			 formValidate(theId);
			 var eDiv = $('#'+theId);
			 eDiv.validate();
			 if (!eDiv.valid()) return;
			 newID = theId+1; 
			 if (theId.indexOf("row_") != -1) {
					theindx = theId.split("_")[1];
					var eDiv =  $("#row_" + theindx);
					eDiv.validate();
					if (!eDiv.valid()) return;
					var theNewDiv =  $("#row_" + (parseInt(theindx) + 1));
					if (theNewDiv.length == 0) {
						//insertDiv
						html = eDiv.html();
						var newdiv1 = $('<form class="pageRowDetailsForm" name="pageRowDetailsForm"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						//alert(html);
						newdiv1.append(html);
						$(".modal-body").append(newdiv1);				
						$('.pageRowDetailsForm input').keydown(function(e) {
						    if (e.keyCode == 13) {
						   		e.preventDefault();
						        //$('#frmdata').submit();
						    }
						});
						//alert(html);
					}
				}
			function formValidate(formID){
			 $('#'+formID).validate({
				rules: {
					blockDocCanonicalUUIDs: {
						required: true,
					}
				},
				messages: {
					blockDocCanonicalUUIDs: "This field is required.",
				}
			  });
			}
       });
});
</script>
<script src="<hst:link path="/js/action-confirm.js"></hst:link>"></script>
