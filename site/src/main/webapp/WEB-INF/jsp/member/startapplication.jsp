<%--
   Copyright (C) 2010 Hippo B.V.
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   
           http://www.apache.org/licenses/LICENSE-2.0
   
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   --%>
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf" %>
<c:set var="startapplication">
   <fmt:message key="member.start.application"/>
</c:set>
<hippo-gogreen:title title="${ startapplication}"/>
<res:breadcrumb/>	
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
	String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("personal","contact");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error"><fmt:message key="${item.value}" /></div>
	</c:forEach>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">	
	<h4>Personal and Contact Information</h4>
	<form id="frmPersonalInfo" action="${actionUrl}" method="post" name="pi">
		<fieldset>
			  <legend>Name & Gender</legend>
		      <div class="row-fluid show-grid">	        			 
		          <div class="span3"><input id="pi_first_name" name="pi_first_name" placeholder="First Name" type="text" value="<c:if test="${not empty parentBean.firstName}"><c:out value="${parentBean.firstName}"/></c:if>"/></div>
		          <div class="span2"><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>	         
		          <div class="span2"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:if test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:if>"/></div>
		          <!--  <div class="span1">Gender</div>  -->
		          <div class="span2"><input id="pi_dob" name="pi_dob" placeholder="DOB" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
		          <div class="span2">
					<select id="gender" name="gender"><option value="">Select Gender</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'M'}">selected</c:if> value="M">Male</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'F'}">selected</c:if> value="F">Female</option></select>
		          </div>       
			  </div>
		 </fieldset>
		 <fieldset>
			 <legend>Address & Contact Information</legend>
			 <div class="row-fluid show-grid">	   
			   	  <div class="span6"><input id="pi_flat_door_building" name="pi_flat_door_building" placeholder="Flat/Door/Building" type="text"  value="<c:if test="${not empty parentBean.flatDoorBuilding}"><c:out value="${parentBean.flatDoorBuilding}"/></c:if>"/></div>
			   	  <div class="span6"><input id="pi_road_street" name="pi_road_street" placeholder="Road/Street" type="text"/></div>
			  </div>
			  <div class="row-fluid show-grid">	   
		          <div class="span4"><input id="pi_area_locality" name="pi_area_locality" placeholder="Area/Locality" type="text"/></div>
		          <div class="span3"><input id="pi_town_city_district" name="pi_town_city_district" placeholder="Town/City/District" type="text"/></div>
		          <div class="span1"><input id="pi_state" name="pi_state" placeholder="State" type="text"/></div>
		          <div class="span2"><input id="pi_pin_code" name="pi_pin_code" placeholder="PIN Code" type="text" maxlength="10"/></div>
			 </div>			
			 <div class="row-fluid show-grid">	
			 	  <div class="span2"><input id="std"  placeholder="STD"  type="text" maxlength="10"/></div>
		          <div class="span3"><input id="phone"  placeholder="Phone Number"  type="text" maxlength="10"/></div>
		          <div class="span3"><input id="mobile"  placeholder="Mobile Phone Number"  type="text" maxlength="10"/></div>
		          <div class="span4">
			          	<div class="input-prepend">
					      <span class="add-on"><i class="icon-envelope"></i></span>
					      <input id="pi_email" name="pi_email" placeholder="Email Address" type="text"/>
	    				</div>
    			  </div>
		     </div>
		</fieldset>
		<div class="row-fluid show-grid">	
	    	<div class="span2 offset10"><a  id="hrefLogin" class="button orange">Save &amp; Next</a></div>
	    </div>	    
	</form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$("#mobile").watermark("Mobile # (Optional)");
			    if (Modernizr.touch && Modernizr.inputtypes.date) {
			        document.getElementById('pi_dob').type = 'date';
			    } else {
			        $('#pi_dob').datepicker({
                    changeMonth: true,
                    changeYear: true,
                    maxDate: "+0M +15D",
                    yearRange: "1900:2013"
                   });
			    }
			    var filing=$('#filing').val();
			    if(filing!=null){
			        $('#status').val(filing);
			    };
			    $('#frmPersonalInfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmPersonalInfo').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmPersonalInfo').submit();
				});
				
				$("#pi_first_name").popover({'trigger':'focus'});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
