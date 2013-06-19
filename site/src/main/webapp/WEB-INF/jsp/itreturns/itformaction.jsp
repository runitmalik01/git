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
<%@include file="../includes/tags.jspf"%>
<c:set var="signuptitle"><fmt:message key="member.signup.title"/></c:set>
<hippo-gogreen:title title="${signuptitle}"/>
<hst:link var="forgotpass" siteMapItemRefId="forgotpass"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>

<div id="text-4" class="widget-wrapper widget_text">
<div><span style="font-weight:bold"><small>PAN</small></span>:<span class="pan"><c:out value="${pan}"/></span></div>
<div><span  style="font-weight:bold"><small>Return Type:</small></span><span style="text-transform:capitalize;"><c:out value="${itReturnType}"/></span></div>
<div><span  style="font-weight:bold"><small>Assessment Year:</small></span><span style="text-transform:capitalize;"><c:out value="${assessmentYear}"/></span></div>
<div class="accordion" id="accordion2">
  <!-- 
  <div class="accordion-group">
    <div class="accordion-heading">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="${mi}/#collapseOne">
        Summary
      </a>
    </div>
    <div id="collapseOne" class="accordion-body collapse in">
      <div class="accordion-inner">
            <div style="font-size:11px">Amit Patkar</div>
		    <div style="font-size:11px">Senior Citizen: Unknown</div>
		    <div style="font-size:11px">Residential Status: Unknown</div>
		    <div style="font-size:11px">Application Status: In Progress</div>
		    <div style="font-size:11px">Total Income: 30</div>
		    <div style="font-size:11px">Total Deductions: 30</div>
		    <div style="font-size:11px">Total Tax Due/Owed: 30</div>
      </div>
    </div>
  </div>
  -->
  <hst:link var="mi" path="/member/itreturn/${financialYear}/${itReturnType}/${pan}"/>
  <div class="accordion-group">
    <div class="accordion-heading">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="${mi}/#collapseTwo">
        Go To
      </a>
    </div>
    <div id="collapseTwo" class="accordion-body collapse in">
      <div class="accordion-inner">
      		<div style="font-size:11px"><a href="${mi}/servicerequest-itr.html">Personal Information</a></div>
      		<div style="font-size:11px"><a href="${mi}/contactinformation.html">Contact Information</a></div>
	        <div style="font-size:11px"><a href="${mi}/residentialstatus.html">Residential Status</a></div>
	        <div style="font-size:11px"><a href="${mi}/bankdetail.html">Bank Detail</a></div>
	        <div style="font-size:11px"><a href="${mi}/sourcesofincome.html">Sources Of Income</a></div>
	        <div style="font-size:11px"><a href="${mi}/salaryincome.html">Salary Income</a></div>
	        <div style="font-size:11px"><a href="${mi}/houseincome.html">House Income</a></div>
	        <div style="font-size:11px"><a href="${mi}/capitalgains.html">Capital Gains</a></div>
	        <div style="font-size:11px"><a href="${mi}/securities.html">Securities</a></div>
	        <div style="font-size:11px"><a href="${mi}/othersources.html">Other Source of Income</a></div>
	        <div style="font-size:11px"><a href="${mi}/adjustmentoflosses.html">Adjustment of Losses</a></div>
	        <div style="font-size:11px"><a href="${mi}/deductions.html">Deductions</a></div>
	        <div style="font-size:11px"><a href="${mi}/rebatesection89.html">Rebate Section 89</a></div>
	        <div style="font-size:11px"><a href="${mi}/rebatesection9091.html">Rebate Section 90/91</a></div>
	        <div style="font-size:11px"><a href="${mi}/advacetaxgrid.html">Advance Tax</a></div>
	        <div style="font-size:11px"><a href="${mi}/tdsfromsalary.html">TDS (from Salary)</a></div>
	        <div style="font-size:11px"><a href="${mi}/tdsfromothers.html">TDS (from Others)</a></div>
	        <div style="font-size:11px"><a href="${mi}/interest.html">Interests</a></div>
	        <div style="font-size:11px"><a href="${mi}/tcs.html">TCS</a></div>
	        <div style="font-size:11px"><a href="${mi}/taxsummary.html">Tax Summary</a></div>
      </div>
    </div>
  </div>
 </div>
 </div>
 