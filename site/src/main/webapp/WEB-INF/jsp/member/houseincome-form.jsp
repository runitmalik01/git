<%@include file="../includes/tags.jspf" %>

<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">	
	<h4>Property Income</h4>
	<form id="frmPersonalInfo" action="${actionUrl}" method="post" name="pi">
		<fieldset>
			  <legend>Property Details</legend>
		      <div class="row-fluid show-grid">	        			 
		          <div class="span3">
		          	<div class="rowlabel"><label for=""><small>Street</small></label></div>
		          	<div><input id="pi_first_name" name="pi_first_name" placeholder="First Name" type="text" value="<c:if test="${not empty parentBean.firstName}"><c:out value="${parentBean.firstName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for=""><small>Town/City</small></label></div>
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		            <div class="rowlabel"><label for=""><small>State</small></label></div>
		          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>
		           <div class="span3">
		            <div class="rowlabel"><label for=""><small>PIN Code</small></label></div>
		          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>
		          <div class="row-fluid show-grid">	        			 
			          <div class="span4">
			          	<div class="rowlabel"><label for=""><small>Is the property let out?</small></label></div>
			          	<div><select><option value="">Select a value</option><option value="Y">Yes</option><option value="N">No</option></select></div>
			          </div>
			          <div class="span4">
			          	<div class="rowlabel"><label for=""><small>Tenant Name</small></label></div>
			          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
			          </div>
			          <div class="span4">
			            <div class="rowlabel"><label for=""><small>Tenant PAN</small></label></div>
			          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
			          </div>
			  	  </div>
			      <div class="row-fluid show-grid">	        			 
			          <div class="span6">
			          	<div class="rowlabel"><label for=""><small>Is the property co-owned?</small></label></div>
			          	<div><select><option value="">Select a value</option><option value="Y">Yes</option><option value="N">No</option></select></div>
			          </div>
			          <div class="span6">
			          	<div class="rowlabel"><label for=""><small>Your percentage share in Property</small></label></div>
			          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
			          </div>
				  </div>			  	  
			  </div>
		 </fieldset>		 
		 <fieldset>
			  <legend><abbr title="Is this property being owned by some one else">Ownership Details</abbr></legend>
			   <div class="row-fluid show-grid">	        			 
		          <div class="span1">
		          	<div class="rowlabel decimal"><label for=""><small>S.No</small></label></div>
		          	<div class="decimal">1.</div>
		          </div>
		          <div class="span4">
		          	<div class="rowlabel"><label for=""><small>Name of Co-owner</small></label></div>
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Name of Co-owner" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span4">
		          	<div class="rowlabel"><label for=""><small>PAN of the Co-owner</small></label></div>
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for=""><small><abbr title="Percentage Share In Property">Share (%)</abbr></small></label></div>
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>		          
			  </div>
			  <div class="row-fluid show-grid">	        			 
		          <div class="span1">
		          	<div class="decimal">2.</div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Name of Co-owner" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div class="decimal"><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>		          
			  </div>
			  <div class="row-fluid show-grid">	        			 
		          <div class="span1">
		          	<div class="decimal">3.</div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Name of Co-owner" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>		          
			  </div>
			  <div class="row-fluid show-grid">	        			 
		          <div class="span1">
		          	<div class="decimal">4.</div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Name of Co-owner" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>		          
			  </div>		
			 <div class="row-fluid show-grid">	        			 
		          <div class="span1">
		          	<div class="decimal">5.</div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Name of Co-owner" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span4">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>
		          <div class="span3">
		          	<div><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
		          </div>		          
			  </div>	
		 </fieldset>
		 <fieldset>
			  <legend>Property Income Details</legend>
		      <div class="row-fluid show-grid">	        			 
		          <div class="span1 decimal">
		          	<div class="rowlabel"><small>a.</small></div>
		          </div>
		          <div class="span7 decimal">
		          	<div class="rowlabel"><label for=""><small>Annuable letable value/rent received or receivable</small></label></div>
		          </div>
		          <div class="span2 offset1">
		          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>	  	 
			  </div>
		      <div class="row-fluid show-grid">	        			 
		          <div class="span1 decimal">
		          	<div class="rowlabel"><small>b.</small></div>
		          </div>
		          <div class="span7 decimal">
		          	<div class="rowlabel"><label for=""><small>The amount of rent which cannot be realized</small></label></div>
		          </div>
		          <div class="span2 offset1">
		          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>	  	 
			  </div>		
		      <div class="row-fluid show-grid">	        			 
		          <div class="span1 decimal">
		          	<div class="rowlabel"><small>c.</small></div>
		          </div>
		          <div class="span7 decimal">
		          	<div class="rowlabel"><label for=""><small>Tax paid to local authorities</small></label></div>
		          </div>
		          <div class="span2 offset1">
		          	<div><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>	  	 
			  </div>				
		      <div class="row-fluid show-grid">	        			 
		          <div class="span1 decimal">
		          	<div class="rowlabel"><small>d</small></div>
		          </div>
		          <div class="span7 decimal">
		          	<div class="rowlabel"><label for=""><small>Total (b+c)</small></label></div>
		          </div>
		          <div class="span2 offset1">
		          	<div><input readonly id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>	  	 
			  </div>	
		      <div class="row-fluid show-grid">	        			 
		          <div class="span1 decimal">
		          	<div class="rowlabel"><small>f</small></div>
		          </div>
		          <div class="span7 decimal">
		          	<div class="rowlabel"><label for=""><small>30% of e</small></label></div>
		          </div>
		          <div class="span2 offset1">
		          	<div><input readonly id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
		          </div>	  	 
			  </div>				  			  			    	  
		 </fieldset>	
		 <div class="row-fluid show-grid">	        			 		         
	          <div class="span4 offset8 decimal">
	          	<a href="${SCRIPTNAME}" class="button olive">Cancel</a>&nbsp;
	          	<a href="hrefSubmit" class="button orange">Save</a>
	          </div>		          
	     </div>	
	</form>
</div>