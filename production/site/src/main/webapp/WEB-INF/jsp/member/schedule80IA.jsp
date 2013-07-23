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
<%@include file="../includes/commonincludes.jspf" %>
<script type="text/javascript" title="DeductionCalJs" src="js/deduction.schedules.common.js"></script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label"/></li>
	<li>
	    <hst:link var="schedule80IA" siteMapItemRefId="schedule80IA" />
	    <a href="${schedule80IA}"><fmt:message key="80IA.schedule"/></a>
	</li>
</ol>
<form id="frmRating" action="${actionUrl}" method="post" name="80IA">
<div><h2><fmt:message key="80IA.schedule"/></h2></div>
   <table>
		<tr>
	         <td class="label"><fmt:message key="80IA.id1"/></td>
	         <td class="input">
	         <input  type="text" name="id1ia" class="numberinput" value="${documentia.infraFac}" id="AIA" onblur="fillIA()" title="Please fill this field" maxlength="14" min="0"/>	        
	         </td>
		</tr>
           		
	       <tr>
	       <td class="label"><fmt:message key="80IA.id2"></fmt:message></td>
	       <td class="input">
	       <input  type="text" name="id2ia"   class="numberinput" value="${documentia.teleFac}" id="BIA"  onblur="fillIA()" title="Please fill this field" maxlength="14" min="0"/>	      
	       </td>
	       </tr>
	       
	       <tr>
	       <td class="label"><fmt:message key="80IA.id3"/></td>
	       <td class="input">       
	       <input type="text" name="id3ia" class="numberinput" id="CIA" value="${documentia.indsPark}"  onblur="fillIA()" title="Please fill this field" maxlength="14" min="0"/>	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label"><fmt:message key="80IA.id4"/></td>
	       <td class="input">	     
	       <input  type="text" name="id4ia" class="numberinput" id="DIA" value="${documentia.powerGen}" onblur="fillIA()" title="Please fill this field" maxlength="14" min="0"/>	      
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label"><fmt:message key="80IA.id5"/></td>
	       <td class="input">	       
	       <input  type="text" name="id5ia" class="numberinput"  id="EIA" value="${documentia.engPower}" onblur="fillIA()" title="Please fill this field" maxlength="14" min="0"/>	      
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label"><fmt:message key="80IA.id6"/></td>
	       <td class="input">	       
	       <input  type="text" name="id6ia" class="numberinput" id="FIA" value="${documentia.total}" onblur="fillIA()" readonly  title="Please fill this field" maxlength="14" min="0"/>	      
	       </td>
	       </tr>
          
    	 <tr><td colspan="2" align="center"><input type="submit" value="Save" height="38px" width="90px" /></td></tr>
     
 </table>
 </form>
