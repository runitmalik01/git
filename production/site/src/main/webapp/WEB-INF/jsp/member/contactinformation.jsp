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
<%--@elvariable id="parentBean" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/commonincludes.jspf" %>
<c:set var="contactinformation"><fmt:message key="member.contact.information"/></c:set>
<hippo-gogreen:title title="${contactinformation}"/>
<h3 id="respond1"><fmt:message key="member.contact.information"/></h3>
<div>
	<fmt:message key="member.location.label"/>&nbsp;	
	    <hst:link var="home" siteMapItemRefId="home" />
	    <a href="${home}"><fmt:message key="products.detail.location.home"/></a>&gt;
	
	   <hst:link var="startapplication" siteMapItemRefId="member-personal-information"></hst:link>
	   <a href="${startapplication}"><fmt:message key="member.start.application"/></a>&gt;

	   <hst:link var="contactinformation" siteMapItemRefId="member-contact-information"></hst:link>
	   <a href="${contactinformation}"><fmt:message key="member.contact.information"/></a>
</div>
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
	String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("contactinformation","residentialstatus");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="ci" id="frmContactinfo" action="${actionUrl}" method="post" >
<div class="row">
<div class="span4">

	<label for="pi_email "><fmt:message key="member.contact_info.email"/></label>

	               <input type="email" name="pi_email" required="required" value="${parentBean.email}" title="Enter a valid E-mail ID" maxlength="125"/>	    
<fieldset>
<label for="pi_std_code "><fmt:message key="member.contact_info.STD"/></label>

	               <input type="text" name="pi_std_code" maxlength="5" title="Enter STD code" class="numberinput" value="${parentBean.stdCode}" placeholder="Digits Only"/>
		
    <label for="pi_phone "><fmt:message key="member.contact_info.landline"/> </label>

	 <input type="text" name="pi_phone" maxlength="10" title="Enter Land Line Number" value="${parentBean.phone}" class="numberinput" placeholder="Digits Only"/>
	
	 
	 
	<label for="pi_mobile "><fmt:message key="member.contact_info.mobile"/></label>
	
	                <input type="text" name="pi_mobile" maxlength="10" title="Must be 10 digit" value="${parentBean.mobile}" class="numberinput" placeholder="Digits Only"/> 
 </fieldset>
	              
<fieldset>
<label for="pi_flat_door_building"><fmt:message key="member.contact_info.flat"/></label>

	           <input type="text" name="pi_flat_door_building" value="${parentBean.flatDoorBuilding}" title="Enter Flat/Door/Block No" maxlength="50" min="1" required="required"/>
          
         <label for="pi_premises_building"><fmt:message key="member.contact_info.building"/></label>
          
	       <input type="text" name="pi_premises_building" value="${parentBean.premisesBuilding}" title="Enter Name of House/Society/Complex" maxlength="50" min="1"/>
	       
	<label for="pi_road_street"><fmt:message key="member.contact_info.street"/></label>

	                <input type="text" name="pi_road_street" value="${parentBean.roadStreet}"/>
	      
	<label for="pi_area_locality"><fmt:message key="member.contact_info.area"/></label>

                <input type="text" name="pi_area_locality" required="required" value="${parentBean.areaLocality}" title="Enter Locality" class="" maxlength="50" min="1"/>

	<label for="pi_town_city_district"><fmt:message key="member.contact_info.town"/></label>

	                <input type="text" name="pi_town_city_district" value="${parentBean.townCityDistrict }" required="required" title="Enter District(aphabets only)" class="" maxlength="50" min="1"/>    
	              
	<label for="pi_pin_code "><fmt:message key="member.contact_info.pin"/></label>
	
	                <input type="text" name="pi_pin_code" value="${parentBean.pinCode}" maxlength="6"  required="required" title="Enter Six digit PIN Code" class="numberinput"/>
	             
	  
	       <label for="pi_state "><fmt:message key="member.contact_info.State"/></label>
	     
	        <c:set var="searchresultstitle"><fmt:message key="member.contact_info.state.select"/></c:set>
<c:set var="statesType"><fmt:message key="dropdown.states"/></c:set>
  <w4india:dropdown dropDownSelectId="pi_state" optionSelectString="${searchresultstitle}" dropDownType="${statesType}"/>

   <input type="hidden" value="${parentBean.state}" id="statekey"/>

  
   
   </fieldset>

   <a  id="hrefLogin" class="button orange">Save & Next</a><a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>
        </div>              
</div>
</form>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
		$('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
         });
                 var statekey=$("#statekey").val();
                if(statekey!=null){
                 $("#pi_state").val(statekey);
                  };
                  
			    $('#frmContactinfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmContactinfo').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmContactinfo').submit();
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>