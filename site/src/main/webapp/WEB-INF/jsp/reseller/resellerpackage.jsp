
<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page type-page">
	<form action="${actionUrl}" method="post" id="packageSelection">
	    
	    <fieldset>
	    <legend>Select a package according to your need.</legend> 
		  	<table class="table table-bordered table-striped">
				<tr align="center" class="success">
					<th><b>Service Name</b></th>
					<th><b>No. of Users</b></th>
					<th><b>Validity</b></th>
					<th><b>Amount</b></th>			
				</tr>			
				<c:if test="${not empty PackageForReseller}">
				<c:forEach items="${PackageForReseller}" var="PackageForReseller">
				<tr>
				<td><input id="packageSelection" name="packageSelection" type ="radio" value="${PackageForReseller}"> <c:out value="${PackageForReseller.displayName}"></c:out></td>
				<td><c:out value="${PackageForReseller.numberOfLicensedUsers}"></c:out></td>
				<td><c:out value="${PackageForReseller.vadilityOfLicense}"></c:out></td>
				<td><c:out value="${PackageForReseller.amount}"></c:out></td>
				</tr>
				</c:forEach>
				</c:if>			
			</table>
		    <div class="row show-grid">
			     <div class="col-md-4 col-md-offset-8 decimal">
		   		      <a href="javascript:void(0);" id="hrefpackageSelection" class="orange button">Continue</a>
		         </div>
		    </div>
		   </fieldset>
		</form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefpackageSelection').click(function() {
 				 $('#packageSelection').submit();
			});
			$('#packageSelection input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#packageSelection').submit();
			    }
			});
			$('#packageSelection').validate({
				rules: {
					packageSelection:{
					required: true,
					}
				},
				messages: {
					packageSelection: "This field is required."
				}
			});
		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>