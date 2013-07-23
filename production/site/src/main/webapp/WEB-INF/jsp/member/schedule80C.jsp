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
<ol  id="breadcrumb">
	<li>
	   <hst:link var="sechulde80C" siteMapItemRefId="schedule80C"></hst:link>
	   <a href="${sechulde80C}"><fmt:message key="80C.schedule"/></a>
	</li>
	</ol>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="80C" id="formrating" action="${actionUrl}" method="post">
<div><h2><fmt:message key="80C.schedule"/></h2></div>
<div align="center">
<table>	
	       <tr>
	      <td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C1" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input  type="text" name="dp1"   class="numberinput" id="A" value="${documentc.dpone }" onblur="fillC()" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp1" onload="onLoad()" value="${documentc.scheduleCone }"/>
			</td>
	       </tr>

 			<tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C2" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
		<td><input type="text" name="dp2" class="numberinput" id="B" onblur="fillC()" value="${documentc.dptwo }" title="Please fill this field" maxlength="14" min="0"/>
		<input  type="hidden" id="fetchdp2" onload="onLoad()" value="${documentc.scheduleCtwo }"/>
		</td>
	       </tr>

			<tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C3" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp3" class="numberinput" id="C" onblur="fillC()" value="${documentc.dpthree }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp3" onload="onLoad()" value="${documentc.scheduleCthree }"/>
			</td>
	       </tr>
	              
	       <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C4" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp4" class="numberinput" id="D" onblur="fillC()" value="${documentc.dpfour }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp4" onload="onLoad()" value="${documentc.scheduleCfour }"/>
			</td>
	       </tr>
	       
	       <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C5" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp5" class="numberinput" id="E" onblur="fillC()" value="${documentc.dpfive }"  title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp5" onload="onLoad()" value="${documentc.scheduleCfive }"/>
			</td>	
	       </tr>
	       
	        <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C6" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp6" class="numberinput" id="F" onblur="fillC()" value="${documentc.dpsix }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp6" onload="onLoad()" value="${documentc.scheduleCsix }"/>
			</td>		
	       </tr>
	       
	       <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C7" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp7" class="numberinput" id="G" onblur="fillC()" value="${documentc.dpseven }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp7" onload="onLoad()" value="${documentc.scheduleCseven }"/>
			</td>
	       </tr>
	       
	       <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C8" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp8" class="numberinput" id="H" onblur="fillC()" value="${documentc.dpeight }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp8" onload="onLoad()" value="${documentc.scheduleCeight }"/>
			</td>
	       </tr>
	       
	       <tr>
			<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C9" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp9" class="numberinput" id="I" onblur="fillC()" value="${documentc.dpnine }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp9" onload="onLoad()" value="${documentc.scheduleCnine }"/>
			</td>
	       </tr>
	              		
	       <tr>
		<td><c:set var="scheduletitle"><fmt:message key="member.schedule80C.select"/></c:set>
<c:set var="scheduleType"><fmt:message key="dropdown.schedule80C"/></c:set>
  <w4india:dropdown dropDownSelectId="schedule80C10" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}"/></td>
			<td><input type="text" name="dp10" class="numberinput" id="J" onblur="fillC()" value="${documentc.dpten }" title="Please fill this field" maxlength="14" min="0"/>
			<input  type="hidden" id="fetchdp10" onshow="onLoad()" onload="onLoad()" value="${documentc.scheduleCten }"/>
			</td>
	       </tr>
		
	       <tr>
	       <td class="label"><fmt:message key="80C.id11"/></td>
	       <td class="input"><input type="text" name="Total" class="numberinput" id="K" value="${documentc.total }" onblur="fillC()"  readonly title="Please fill this field"/></td>
	       </tr>
	                    
    	 <tr><td colspan="2" align="center"><input type="submit" value="Save" height="100px" width="90px" /></td></tr>
 </table>
 </div>
</form>
