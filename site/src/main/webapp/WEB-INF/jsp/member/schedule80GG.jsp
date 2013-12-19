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
	   <hst:link var="sechulde80GG" siteMapItemRefId="schedule80GG"></hst:link>
	   <a href="${sechulde80GG}"><fmt:message key="80GG.schedule"/></a>
	</li>
	</ol>

<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="GG" id="formrating" action="${actionUrl}" method="post">
<div><h2><fmt:message key="80GG.schedule"/></h2></div>
<div align="center">
<table>

			<tr>
				<td class="label label-default"><fmt:message key="80GG.month" /></td>
				<td class="input"><c:set var="scheduletitle">
						<fmt:message key="member.schedule80C.select" />
					</c:set> <c:set var="scheduleType">
						<fmt:message key="dropdown.numbers" />
					</c:set> <w4india:dropdown dropDownSelectId="AGG" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}" dropDownFuction="fillGG()"/> 
					<input type="hidden" id="fetchggdp" onload="onLoad()" value="${documentgg.drop}" />
					</td>
			</tr>

			<%--  Gross total is dependent of Salary Income,House Property, Capital Gains, Other Sources and Less:Adjustment Of Losses--%>
 			<tr>
	       <td class="label label-default"><fmt:message key="80GG.gross.income"/></td>
	       <td class="input"><input type="text" name="80GG_grossincome" class="numberinput" value="${documentgg.grossIncome }" id="BGG" onChange="fillGG()" title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>

			<tr>
	       <td class="label label-default"><fmt:message key="80GG.rent.paid"/></td>
	       <td class="input"><input type="text" name="80GG_rent_paid" class="numberinput" value="${documentgg.rentPaid }" id="CGG" onChange="fillGG()" title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	              
	       <tr>
	       <td class="label label-default"><fmt:message key="80GG.min.exemption"/></td>
	       <td class="input"><input type="text" name="80GG_min_exemption" class="numberinput" value="${documentgg.minExemption }" id="DGG" onChange="fillGG()" readonly title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80GG.gross.total"/></td>
	       <td class="input"><input type="text" name="80GG_gross_total" class="numberinput" value="${documentgg.grossTotal }" id="EGG" onChange="fillGG()"  readonly title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	       
	        <tr>
	       <td class="label label-default"><fmt:message key="80GG.rent.paid.gross.income"/></td>
	       <td class="input"><input type="text" name="80GG_rent_paid_gross_income" class="numberinput" value="${documentgg.rentPaidGross }" id="FGG" readonly  title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	       
	       <tr>
	       <td class="label label-default"><fmt:message key="80GG.deduction.allow"/></td>
	       <td class="input"><input type="text" name="deduction_allow" class="numberinput" id="GGG" value="${documentgg.deductionAllow }" readonly title="Please fill this field" maxlength="14" min="0"/></td>
	       </tr>
	       
	       <tr><td colspan="2" align="center"><input type="submit" value="Save" height="100px" width="90px" /></td></tr>
	       
</table>
</div>
</form>
