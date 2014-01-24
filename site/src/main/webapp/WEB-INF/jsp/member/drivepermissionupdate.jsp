<%@page import="com.mootly.wcm.model.PERMISSION"%>
<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<%
	PERMISSION[] permissionList = PERMISSION.values();
	pageContext.setAttribute("permissionList", permissionList);
%>
<form action="${actionURL}" name="permissionUpdate" id="permissionUpdate" method="post">
	<div class="row">
		<div class="col-md-12">
			<label for="accesspermission">Selection Action Permission Type</label>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<select name="accesspermission" id="accesspermission" class="col-xs-2 form-control input-sm">
				<c:forEach items="${permissionList}" var="permission">
					<option <c:if test="${permission eq memberDriveDocument.accessPermission}">selected</c:if> value="${permission}">${permission}</option>
				</c:forEach>
			</select>
		</div>
	</div>
 <input type="hidden" name="memberDriveCanonicalUUID" id="memberDriveCanonicalUUID" value="${memberDriveDocument.canonicalUUID}" />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- <input type="submit" class="btn btn-warning btn-sm" id="action" name="action" value="Save Permission"/> -->
</form>
<c:if test="${not empty updatepermission}">
	<script type="text/javascript">
		var updatepermission = '<c:out value="${updatepermission}"/>';
		$('.updatepermission').text(updatepermission);
		$('.updatepermission').show();
	</script>
</c:if>