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
	    <hst:link var="schedule80IC" siteMapItemRefId="schedule80IC" />
	    <a href="${schedule80IC}"><fmt:message key="80IC.schedule"/></a>
<br/>
<form id="frmRating" action="${actionUrl}" method="post" name="80IA">
<div><h2><fmt:message key="80IC.schedule"/></h2></div>
     <table> 
		<tr>
		<td align="left">Particulars</td>
		<td align="right">Amount</td>
		</tr>
           <tr>
	       <td class="label label-default"><fmt:message key="80IC.id1"/></td>
	       <td class="input"><input  type="text" name="id1ic"   class="numberinput" value="${documentic.locSikkim }" id="AIC" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
			
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id2"/></td>
	       <td class="input"><input  type="text" name="id2ic"   class="numberinput" id="BIC" value="${documentic.locHimachalPradesh }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id3"/></td>
	       <td class="input"><input type="text" name="id3ic" class="numberinput" id="CIC" value="${documentic.locUttaranchal }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	   
	       
	       <tr><td class="label label-default" colspan="2"><fmt:message key="80IC.id4"/></td></tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IC.id5"/></td>
	       <td class="input"><input type="text" name="id5ic" class="numberinput" id="DIC" value="${documentic.norestAssam }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80IC.id6"/></td>
	       <td class="input"><input  type="text" name="id6ic" class="numberinput" id="EIC" value="${documentic.norestArunachal }"  onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id7"/></td>
	       <td class="input"><input type="text" name="id7ic" class="numberinput" id="FIC" value="${documentic.norestManipur }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id8"/></td>
	       <td class="input"><input  type="text" name="id8ic" class="numberinput" id="GIC" value="${documentic.norestMizoram }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>       
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id9"/></td>
	       <td class="input"><input  type="text" name="id9ic" class="numberinput" id="HIC" value="${documentic.norestMeghalaya }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id10"/></td>
	       <td class="input"><input  type="text" name="id10ic" class="numberinput" id="IIC" value="${documentic.norestTripura }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id11"/></td>
	       <td class="input"><input  type="text" name="id11ic" class="numberinput" id="JIC" value="${documentic.norestNagaland }" onblur="fillIC()" title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id12"/></td>
	       <td class="input"><input  type="text" name="id12ic" class="numberinput" id="KIC" value="${documentic.totalnorest }" readonly title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80IC.id13"/></td>
	       <td class="input"><input  type="text" name="id13ic" class="numberinput" id="LIC" value="${documentic.total }" readonly title="Please fill this field" maxlength="14" min="0" /></td>
	       </tr>        
          <tr><td colspan="2" align="center"><input type="submit" value="Save" height="100px" width="90px" /></td></tr>
           </table>
 </form>
