
<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page type-page">
	<form action="${actionUrl}" method="post" id="packageSelection">
	<div class="alert alert-error">
	Please Select a package according to your need.
	</div>
       <fieldset>
            <legend>Package Selection</legend>
		        <div class="row-fluid show-grid" >
		          <div class="span3">
		            <div class="rowlabel">
		   	            <label for="packageSelection">
		                <small>Select the Package (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		               <select name="packageSelection" id="packageSelection">
						         <option value="">--Select--</option>
						         <c:forEach var="PackageForReseller" items="${PackageForReseller}">
							     <option value="${PackageForReseller}"><c:out value="${PackageForReseller.displayName}" /></option>					  
						</c:forEach>
					</select>
		            </div>
		        </div>
		   </div>
   </fieldset>
	      <div class="row-fluid show-grid">
			  <div class="span4 offset8 decimal">
		   		  <a href="javascript:void(0);" id="hrefpackageSelection" class="orange button">Continue</a>
		      </div>
		  </div>
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