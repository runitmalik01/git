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
<div id="breadcrumb">
<fmt:message key="member.location.label"/>
<hst:link var="home" siteMapItemRefId="memberfrontpage" />
<a href="${home}">
   <fmt:message key="products.detail.location.home"/>
</a>
&gt;
<hst:link var="startapplication" siteMapItemRefId="member-personal-information"></hst:link>
<a href="${startapplication}">
   <fmt:message key="member.start.application"/>
</a></div>
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan).replaceAll("personal","contact");
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
<script type="text/javascript" src='js/show-hide-gender.js'> </script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="frmPersonalInfo" action="${actionUrl}" method="post" name="pi">
      <div class="row">
         <div class="span4">           
              PAN:<span class="pan"><b><c:out value="${pan}"/></b></span>      
         </div>
         <div class="span4">
            <fmt:message key="member.personal_info.status"/>
            <input type="hidden" id="filing" value="${parentBean.filingStatus}"/>
            <select name="status" id="status">
               <option id="1" value="I">
                  <fmt:message key="member.persoanl_info.individual"/>
               </option>
               <option id="2" value="H">
                  <fmt:message key="member.persoanl_info.huf"/>
               </option>
            </select>
         </div>
         <div class="span4">
            <fmt:message key="member.personal_info.firstname"/>
            <input type="text" name="pi_first_name" id="pi_first_name" data-content="First Name" value="${parentBean.firstName}" title="Enter First Name" class="alphaonly" maxlength="25" min="0"/>
            <c:if test="${not empty errors}">
               <c:forEach items="${errors}" var="error">
                  <c:if test="${error eq 'invalid.fname-label'}">
                     <span class="form-error">
                        <fmt:message key="member.personal_info.firstname.error"/>
                     </span>
                  </c:if>
               </c:forEach>
            </c:if>
            <label for="pi_middle_name"><fmt:message key="member.personal_info.middlename" /></label>
            <input type="text" name="pi_middle_name" id="pi_middle_name" value="${parentBean.middleName}" title="Enter Middle Name(if any)" class="alphaonly" maxlength="25" min="0"/>
            <label for="pi_last_name"><fmt:message key="member.personal_info.lastname"/></label>
            <input type="text" name="pi_last_name" id="pi_last_name" value="${parentBean.lastName}" required="required" title="Last Name should not blank" class="alphaonly"/>
            <label for="pi_father_name"><fmt:message key="member.personal_info.fathername"/></label>
            <input type="text" id="pi_father_name" name="pi_father_name" value="${parentBean.fatherName}" title="Enter Father Name" class="alphaonly" maxlength="75" min="1"/>
            <label for="gender"><fmt:message key="member.personal_info.gender"/></label>
            <label for="gender_m">Male</label>
            <input id="gender_m" type="radio" name="gender" value="M" <c:if test="${not empty parentBean && parentBean.sex == 'M'}"> checked="checked"</c:if>/> 
            <label for="gender_f">Female</label>
            <input type="radio" id="gender_f" name="gender" value="F" <c:if test="${not empty parentBean && parentBean.sex == 'F'}"> checked="checked"</c:if>/>
            <br/>
            <label for="pi_dob"><fmt:message key="member.personal_info.dob"/></label>
            <input  id="pi_dob" name="pi_dob" value="${parentBean.DOBStr}"/>     
            <br/>  
            <a  id="hrefLogin" class="button orange">Save & Next</a><a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>
     	 </div>
      </div>
      
</form>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
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
