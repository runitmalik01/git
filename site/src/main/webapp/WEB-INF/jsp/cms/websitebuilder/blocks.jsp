<%@page import="com.mootly.wcm.beans.cms.BlockDocument"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mootly.wcm.beans.cms.PageDocument"%>
<%@page import="java.util.List"%>
<%@include file="../../includes/tags.jspf"%>
<c:set value="Block Component" var="blocktitle" />
<hippo-gogreen:title title="${blocktitle}"></hippo-gogreen:title>

<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:link var="pageslink" siteMapItemRefId="pages"/>
<hst:link var="blockslink" siteMapItemRefId="blocks"/>
<div class="alert alert-info">
	<h4>Welcome To WebsiteBuilder Panel</h4>
</div>
<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="${websitebuilderlink}">WebSite Builder</a></li>
  <li><a href="${pageslink}">Pages Component</a></li>
  <li class="active"><a href="${blockslink}">Block Components</a></li>
</ol>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:forEach items="${listOfAllBlocksComponet}" var="mxblockDocument" varStatus="pgstatus">
	<c:set var="lstModDocName" value="${mxblockDocument}" />
	<c:forEach items="${listOfAllBlocksComponet}" var="mnblockDocument" varStatus="pgstatus">
		<fmt:formatDate type="both" value="${lstModDocName.lastModificationDate.time}" var="mxtime" />
		<fmt:formatDate type="both" value="${mnblockDocument.lastModificationDate.time}" var="mntime" />
		<c:if test="${mxtime != mntime}">
			<c:if test="${mntime lt mxtime}">
				<c:set var="lstModDocName" value="${mnblockDocument}" />
			</c:if>
		</c:if>
	</c:forEach>
</c:forEach>
<c:if test="${pageAction eq 'DEFAULT'}">
	<c:choose>
		<c:when test="${not empty listOfAllBlocksComponet}">
			<div class="panel panel-info">
				<!-- Default panel contents -->
				<div class="panel-heading">WebSite-Block Components</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Block Component Name</th>
							<th>Title</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfAllBlocksComponet}" var="blockDocument" varStatus="pgstatus">
							<tr><td><c:out value="${pgstatus.count}" /></td>
								<td><c:out value="${fn:toUpperCase(blockDocument.name)}" />
								    <c:if test="${lstModDocName.name eq blockDocument.name}">
								    <sup><span class="text-danger"><i class="glyphicon glyphicon-asterisk"></i>
								    <strong>Last Updated</strong></span></sup></c:if></td>
								<td><c:out value="${blockDocument.title}" /></td>
								<td><a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/editblock"
									class="btn btn-primary btn-sm"><i
										class="glyphicon glyphicon-edit"></i>&nbsp;<span><strong>Edit</strong></span></a>&nbsp;&nbsp;&nbsp;
									<a href="${websitebuilderlink}/blocks.html/${blockDocument.canonicalUUID}/deleteblock" data-confirm=""
									class="btn btn-danger btn-sm"><i
										class="glyphicon glyphicon-trash"></i>&nbsp;<span><strong>Delete</strong></span></a></td>
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
<c:choose>
	<c:when test="${pageAction eq 'EDIT' or pageAction eq 'NEW'}">
		<form class="form" method="post" action="${actionUrl}" id="blockCompoForm" name="blockCompoForm">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseOne"><span class="glyphicon glyphicon-file"> </span>${pageAction}-${parentBean.name} BLOCK Component</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<input type="text" class="form-control" placeholder="Title"
														required="required" name="title" id="title" value="<c:if test="${pageAction eq 'EDIT'}">${parentBean.title}</c:if>"/>
												</div>
												<div class="form-group">
													<textarea class="form-control" placeholder="Content"
														rows="7" required="required" name="script" id="script"><c:if test="${pageAction eq 'EDIT'}">${parentBean.script}</c:if></textarea>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="well well-sm">
													<div class="input-group">
														<select name="showAsIs" id="showAsIs" class="form-control">
															<option value="">Select</option>
															<option value="true" <c:if test="${pageAction eq 'EDIT' and parentBean.showAsIs eq 'true'}">selected</c:if>>YES</option>
															<option value="false" <c:if test="${pageAction eq 'EDIT' and parentBean.showAsIs eq 'false'}">selected</c:if>>NO</option>
														</select>
															<span class="input-group-addon">Show Content As It is.</span>
													</div>
												</div>
											</div>
											<div class="col-md-8">
												<div class="well well-sm well-primary" align="right">
													<div class="form-group">
														<button type="submit" class="btn btn-success btn-sm">
															<span class="glyphicon glyphicon-floppy-disk"></span>Save
														</button>
														<button type="button" class="btn btn-default btn-sm" id="preview" data-toggle="modal" data-target="#myModal">
															<span class="glyphicon glyphicon-eye-open"></span>Preview
														</button>
														<a class="btn btn-primary btn-sm" href="${scriptName}"><i class="glyphicon glyphicon-circle-arrow-left"></i>Back To Blocks</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</c:when>
</c:choose>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Content Preview Panel</h4>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<c:if test="${pageAction eq 'DEFAULT' || pageAction eq 'EDIT' }"><jsp:include page="addcomponentfoot.jsp"/></c:if>
<script type="text/javascript">
$('document').ready(function(){
    $('#preview').on('click',function(){
       var script = $('#script').val();
       if(script == ''){
            $('div.modal-body').html('<strong>Oops! No content to Preview.</strong>');
        } else{
            $('div.modal-body').html('<div class="row"><div class="col-md-12">'+script+'</div></div>');
         } 
     });
  });
</script>
<script src="<hst:link path="/js/action-confirm.js"></hst:link>"></script>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
   
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>