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
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label"/></li>
	<li>
	    <hst:link var="schedule80IB" siteMapItemRefId="schedule80IB" />
	    <a href="${schedule80IB}"><fmt:message key="80IB.schedule"/></a>
	</li>
</ol>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="resi" id="formrating" action="${actionUrl}" method="post">
<div><h2><fmt:message key="80IB.schedule"/></h2></div>
<table class="personal_info">
           <tr>
	         <td class="label label-default"><fmt:message key="80IB.id1"/></td>
		    <td class="input">		    
		    <input  type="text" name="id1ib" class="numberinput" value="${documentib.indUndtk }" id="AIB" onblur="fillIB()"  maxlength="14" min="0"/>		    
		    </td>
			</tr>
			
	       <tr>
	       <td class="label label-default"><fmt:message key="80IB.id2"></fmt:message></td>
	       <td class="input">	       
	       <input  type="text" name="id2ib"   class="numberinput" value="${documentib.locJammu }" id="BIB" onblur="fillIB()"  maxlength="14" min="0"/>	       
	       </td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IB.id3"/></td>
	       <td class="input">	       
	       <input type="text" name="id3ib" class="numberinput" value="${documentib.locIndBackState }" id="CIB" onblur="fillIB()"  maxlength="14" min="0"/> 
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id4"/></td>
	       <td class="input">	       
	       <input  type="text" name="id4ib" class="numberinput" value="${documentib.locIndBackDisct }" id="DIB" onblur="fillIB()" maxlength="14" min="0"/> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id5"/></td>
	       <td class="input">	       
	       <input type="text" name="id5ib" class="numberinput" value="${documentib.mulTheater }" id="EIB" onblur="fillIB()" maxlength="14" min="0"/>	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id6"/></td>
	       <td class="input">	       
	       <input  type="text" name="id6ib" class="numberinput" value="${documentib.convCenter }" id="FIB" onblur="fillIB()" maxlength="14" min="0" /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id7"/></td>
	       <td class="input">	       
	       <input  type="text" name="id7ib" class="numberinput" id="GIB" value="${documentib.scientRes }"  onblur="fillIB()" maxlength="14" min="0"  />        
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id8"/></td>
	       <td class="input">	       
	       <input  type="text" name="id8ib" class="numberinput" value="${documentib.engProdOil }"  id="HIB" onblur="fillIB()" maxlength="14" min="0" /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id9"/></td>
	       <td class="input">	       
	       <input  type="text" name="id9ib" class="numberinput" value="${documentib.devHouseProject }" id="IIB" onblur="fillIB()" maxlength="14" min="0"  /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id10"/></td>
	       <td class="input">	       
	       <input type="text" name="id10ib" class="numberinput" value="${documentib.opColdChain }" id="JIB" onblur="fillIB()" maxlength="14" min="0"  /> 	       
	       </td>
	       
	       </tr>	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id11"/></td>
	       <td class="input">	       
	       <input type="text" name="id11ib" class="numberinput" value="${documentib.fruit }" id="KIB" onblur="fillIB()" maxlength="14" min="0" /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id12"/></td>
	       <td class="input">	       
	       <input  type="text" name="id12ib" class="numberinput" value="${documentib.foodGrains }" id="LIB" onblur="fillIB()" maxlength="14" min="0"  /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id13"/></td>
	       <td class="input">	       
	       <input  type="text" name="id13ib" class="numberinput" id="MIB" value="${documentib.ruralHos }" onblur="fillIB()" maxlength="14" min="0"  /> 	       
	       </td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IB.id14"/></td>
	       <td class="input">	       
	       <input  type="text" name="id14ib" class="numberinput" value="${documentib.total }" id="NIB"  readonly  /> 	       
	       </td>
	       </tr>
	              
	        <tr><td colspan="2" align="center"><input type="submit" value="Save" height="100px" width="90px" /></td></tr>
     
 </table>
 </form>
