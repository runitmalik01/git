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
<%@include file="../includes/tags.jspf"%>
<c:set var="section89">
	<fmt:message key="rebate.section89" />
</c:set>
<hippo-gogreen:title title="${ section89}" />
<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label" /></li>
	<li><hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message key="products.detail.location.home" /></a>&gt;
	</li>
	<li><hst:link var="rebatesection89"
			siteMapItemRefId="rebatesection89"></hst:link> <a
		href="${rebatesection89}"><fmt:message key="rebate.section89" /></a>
	</li>
</ol>
<br />
<script type="text/javascript" src='js/rebate-calculation.js'></script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="frmRating" action="${actionUrl}" method="post" name="pi">
	<div id="demo" class="yui3-module">
		<div class="yui3-hd">
			<h2>
				<fmt:message key="rebate.section89" />
			</h2>
		</div>
		<div class="yui3-bd" align="center">
			<table id="prevtable">
				<tr height="30px">
					<td class="label" colspan="7" align="left"><h2>
							<b><fmt:message key="rebate.section89.prev.arrears" /></b>
						</h2></td>
				</tr>
				<tr>
					<td><fmt:message key="rebate.section89.prev.year" /></td>
					<td><fmt:message key="rebate.section89.prev.income" /></td>
					<td><fmt:message key="rebate.section89.prev.arrears" /></td>
					<td><fmt:message key="rebate.section89.prev.total" /></td>
					<td><fmt:message key="rebate.section89.prev.taxontotal" /></td>
					<td><fmt:message key="rebate.section89.prev.taxincome" /></td>
					<td><fmt:message key="rebate.section89.prev.taxdiff" /></td>
				</tr>
				<tr>
					<td><c:set var="scheduletitle">
							<fmt:message key="member.schedule80C.select" />
						</c:set> <c:set var="scheduleType">
							<fmt:message key="dropdown.assessyear" />
						</c:set> <w4india:dropdown dropDownSelectId="prevyear1"
							optionSelectString="${scheduletitle}"
							dropDownType="${scheduleType}" dropDownSize="8" /></td>

					<td><input type='text' size='8' name='income1' id="income1"
						onchange="calculate()" class="numberinput"
						value="${prev0.prevIncome }" /></td>
					<td><input type='text' size='8' name='arrears1' id="arrears1"
						onchange="calculate()" class="numberinput"
						value="${prev0.prevArrears }" /></td>
					<td><input type='text' size='8' name='total1' id="total1"
						readonly='readonly' value="${prev0.prevTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxontotal1'
						id="taxontotal1" readonly='readonly'
						value="${prev0.prevTaxTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxincome1'
						id="taxincome1" readonly='readonly'
						value="${prev0.prevTaxIncome }" /></td>
					<td><input type='text' size='8' name='taxdiff1' id="taxdiff1"
						readonly='readonly' value="${prev0.prevTaxDiff }" /></td>
				</tr>
				<tr>
					<td><c:set var="scheduletitle">
							<fmt:message key="member.schedule80C.select" />
						</c:set> <c:set var="scheduleType">
							<fmt:message key="dropdown.assessyear" />
						</c:set> <w4india:dropdown dropDownSelectId="prevyear2"
							optionSelectString="${scheduletitle}"
							dropDownType="${scheduleType}" dropDownSize="8" /></td>
					<td><input type='text' size='8' name='income2' id="income2"
						onchange="calculate()" class="numberinput"
						value="${prev1.prevYear }" /></td>
					<td><input type='text' size='8' name='arrears2' id="arrears2"
						onchange="calculate()" class="numberinput"
						value="${prev1.prevArrears }" /></td>
					<td><input type='text' size='8' name='total2' id="total2"
						readonly='readonly' value="${prev1.prevTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxontotal2'
						id="taxontotal2" readonly='readonly'
						value="${prev1.prevTaxTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxincome2'
						id="taxincome2" readonly='readonly'
						value="${prev1.prevTaxIncome }" /></td>
					<td><input type='text' size='8' name='taxdiff2' id="taxdiff2"
						readonly='readonly' value="${prev1.prevTaxDiff }" /></td>
				</tr>
				<tr>
					<td><c:set var="scheduletitle">
							<fmt:message key="member.schedule80C.select" />
						</c:set> <c:set var="scheduleType">
							<fmt:message key="dropdown.assessyear" />
						</c:set> <w4india:dropdown dropDownSelectId="prevyear3"
							optionSelectString="${scheduletitle}"
							dropDownType="${scheduleType}" dropDownSize="8" /></td>
					<td><input type='text' size='8' name='income3' id="income3"
						onchange="calculate()" class="numberinput"
						value="${prev2.prevIncome }" /></td>
					<td><input type='text' size='8' name='arrears3' id="arrears3"
						onchange="calculate()" class="numberinput"
						value="${prev2.prevArrears }" /></td>
					<td><input type='text' size='8' name='total3' id="total3"
						readonly='readonly' value="${prev2.prevTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxontotal3'
						id="taxontotal3" readonly='readonly'
						value="${prev2.prevTaxTotalIncome }" /></td>
					<td><input type='text' size='8' name='taxincome3'
						id="taxincome3" readonly='readonly'
						value="${prev2.prevTaxIncome }" /></td>
					<td><input type='text' size='8' name='taxdiff3' id="taxdiff3"
						readonly='readonly' value="${prev2.prevTaxDiff }" /></td>
				</tr>
			</table>
			<table class="rebate_section89">
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.salaryincome" /></td>
					<td class="input"><input type="text" name="salaryincome"
						id="salaryincome" value="${salaryincome}"
						title="Salary Income as Enter in Sources of Income"
						readonly="readonly" /></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.otherincome" /></td>
					<td class="input"><input type="text" name="otherincome"
						value="${otherincome}" id="otherincome"
						title="Others Income as Enter in Sources of Income"
						readonly="readonly" /></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="rebate.section89.arrears" />
					</td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="arrears" value="${document.arrears}"
								onchange="currcalArrers()" id="arrears" title="Enter Arrears"
								class="numberinput" readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="arrears"
								value="${fn:escapeXml(arrears)}" onchange="currcalArrers()"
								id="arrears" title="Enter Arrears" class="numberinput"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.totalincome.arrears" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="totalincomearrears"
								value="${document.totalIncomeArrears}" id="totalincomearrears"
								title="Total Income in current Year included Arrears"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="totalincomearrears"
								value="${fn:escapeXml(totalincomearrears)}"
								id="totalincomearrears"
								title="Total Income in current Year included Arrears"
								readonly="readonly">
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.tax.salaryincome" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="taxsalaryincome"
								value="${document.taxSalaryIncome}" id="taxsalaryincome"
								title="Tax on total Income excluded Arrears or Advance"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="taxsalaryincome"
								value="${fn:escapeXml(taxsalaryincome)}" id="taxsalaryincome"
								title="Tax on total Income excluded Arrears or Advance"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.tax.totalincome.arrears" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="taxarrears"
								value="${document.taxArrears}" id="taxarrears"
								title="Tax on Total Income of Current Year included Arrears"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="taxarrears"
								value="${fn:escapeXml(taxarrears)}" id="taxarrears"
								title="Tax on Total Income of Current Year included Arrears"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="rebate.section89.tax" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="diff" value="${document.diff}" id="diff"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="diff" value="${fn:escapeXml(diff)}"
								id="diff"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message
							key="rebate.section89.tax.computed.table" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="computedtabletotal"
								value="${document.computedTableTotal}" id="computedtabletotal"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="computedtabletotal"
								value="${fn:escapeXml(computedtabletotal)}"
								id="computedtabletotal"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="rebate.section89.tax.paid" /></td>
					<td class="input"><c:if test="${ not empty document}">
							<input type="text" name="taxpaid" value="${document.taxRelief}"
								id="taxpaid"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if> <c:if test="${empty document}">
							<input type="text" name="taxpaid"
								value="${fn:escapeXml(taxpaid)}" id="taxpaid"
								title="Difference(Tax on salary received in arrears or advance)"
								readonly="readonly" />
						</c:if></td>
				</tr>
				<tr height="40px">
					<td>&nbsp;</td>
					<td class="submit fright" colspan="2" align="center"><input
						type="submit" name=" Next " height="38px" value="Next"
						width="90px" onclick="Date()" /></td>
				</tr>

			</table>
			<br />
		</div>
	</div>
<div id="fetch">
<input type="hidden" name="cbassyear" id="cbassyear" value="${cbassyear}"/>
<input type="hidden" name="cbasstype" id="cbasstype" value="${payer}"/>
<input type="hidden" name="cbresistatus" id="cbresistatus" value="${resistatus}"/>
<input type="hidden" name="cbasscategory" id="cbasscategory" value="${gender}"/>
<input type="hidden" name="txtNetIncome" id="txtNetIncome" value="${nettaxIncome}"/>
</div>
	<br />

</form>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="show-hide" category="jsInternal">
	<script type="text/javascript"
		src='<hst:link path="/js/show-hide.rebate.js"/>'></script>
</hst:headContribution>