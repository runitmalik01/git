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

<%--@elvariable id="form" type="org.onehippo.forge.easyforms.model.Form"--%>
<%--@elvariable id="likert" type="org.onehippo.forge.easyforms.model.Likert"--%>
<%--@elvariable id="ef_errors" type="java.util.List"--%>
<%--@elvariable id="error" type="org.onehippo.forge.easyforms.model.ErrorMessage"--%>

<%
	if (request.getUserPrincipal() != null) {
		pageContext.setAttribute("regemail", request.getUserPrincipal()
				.getName());
	}
%>


<c:choose>
	<c:when test="${success eq 'eventsuccess'}">
		<fmt:message key="easyforms.formtemplate.thankyou.event" />
	</c:when>
	<c:when test="${success eq 'dummysuccess'}">

		<div id="content">
			<fmt:message key="easyforms.formtemplate1.thankyou.form" />
		</div>
	</c:when>
	<c:otherwise>
		<c:forEach items="${ef_errors}" var="error">
			<div class="form-error">
				<c:out value="${error.message}" />
			</div>
		</c:forEach>
		<form class="form" name="memberticket" action="<hst:actionURL />"
			method="post" id="${form.id}">
			
			<div class="row-fluid show-grid">
				<div class="span3">Name<span style="color: red">*</span></div>
				<div class="span8">
					<input id="name" type="text" name="name" ><br><br>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span3">E-mail ID<span style="color: red">*</span></div>
				<div class="span8">
					<input type="text" id="email" name="email" ><br><br>
				</div>

			</div>
			<div class="row-fluid show-grid">
				<div class="span4">Category<span style="color: red">*</span></div>
				<div class="span7">
					<select name="category" id="category" >
						<option value="">-Select-</option>
						<option value="am">Accounting Management</option>
						<option value="cd">Contact Details</option>
						<option value="sq">Secret Question/Answer</option>
						<option value="ep">Email Preferences</option>
						<option value="itv">Unable to open ITRV</option>
						<option value="py">Payment</option>
						<option value="ws">Web Services related</option>
						<option value="rr">Procedure to file a Revised return</option>
						<option value="itf">Filing of It return forms</option>
						<option value="xml">XMl upload</option>
						<option value="oth">Other</option>
					</select> <br>
				</div>
			</div>
		<div class="row-fluid show-grid">
				<div class="span3">Comments/Questions</div>
				<div class="span8">	<textarea cols="40" rows="20" name="comments" id="comments"></textarea><br>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span3">Resolution</div>
				<div class="span8">	<textarea cols="40" rows="20" name="resolution" id="resolution"></textarea><br>
				</div>
			</div>
			<div class="ef-buttons">
				<c:forEach var="button" items="${form.buttons}">
                ${button.html}
            </c:forEach>
			</div>

		</form>
	</c:otherwise>
</c:choose>
<%--
    HERE WE PRINT JAVASCRIPT CALL WHICH WILL VALIDATE OUR FORM
--%>

${form.jsCall}
<%--
    //########################################################################
    //  HEADER CONTRIBUTIONS
    //########################################################################
--%>

<hst:headContribution keyHint="formValidationCss" category="css">
	<link rel="stylesheet"
		href="<hst:link path="/js/formcheck/theme/blue/formcheck.css"/>"
		type="text/css" />
</hst:headContribution>

<hst:headContribution keyHint="formJsValidation" category="jsInternal">
	<script type="text/javascript"
		src="<hst:link path="/js/jquery.validate.min.js"/>"></script>
</hst:headContribution>
<%--
    easy forms css
--%>
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/easyforms.css"/>"
		type="text/css" />
</hst:headContribution>
<script type="text/javascript">
	$(document).ready(function() {
		var regemail = '<c:out value = "${regemail}" />';
		if (regemail != '') {
			contactus.email.value = regemail;
		}
	});
</script>


<%--
For <w4india:resellername/> Contact Us
--%>

<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<c:set var="contactus">Contact Us</c:set>
<!--  
<div itemscope itemtype="http://schema.org/Organization">
  <span itemprop="name">Mootly Software</span>-->
<hippo-gogreen:title title="${contactus}" />
<h3 class="title text-center text-success">Contact Us</h3>

<table class="table table-bordered table-hover table-

striped">
	<thead>
		<tr>
			<th class="success" itemscope itemtype="http://schema.org/AccountingService" itemprop="name">
				New Delhi Office
			</th>
			<th class="success" itemscope itemtype="http://schema.org/AccountingService" itemprop="name">Gurgaon Office</th>
			<th class=success itemscope itemtype="http://schema.org/AccountingService" itemprop="name">USA Office</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td width="35%">
				<div itemscope itemtype="http://schema.org/AccountingService">
						  <div itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
						    <span itemprop="streetAddress" style="font-size:smaller">T-4, 3rd Floor, Manish Twin Plaza Plot No.3, Sector-4</span>
						    <span itemprop="addressLocality" style="font-size:smaller">Dwarka</span>,
						    <span itemprop="addressRegion" style="font-size:smaller">New Delhi</span> 
						    <span itemprop="postalCode"  style="font-size:smaller">110075</span>
						  </div>
						  <span itemprop="telephone"  style="font-size:smaller">91-11-45067102</span>
						  <div><small><a href="https://www.<w4india:resellername/>.com"  itemprop="url">https://www.<w4india:resellername/>.com</a></small></div>
				</div>
			</td>
			<td width="35%">
				<div itemscope itemtype="http://schema.org/AccountingService">
					<div itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
						<div itemprop="streetAddress" style="font-size:smaller">338, Vipul Trade Center</div>
					    <div itemprop="addressLocality" style="font-size:smaller">Sohna Road</div>
					    <span itemprop="addressRegion" style="font-size:smaller">Gurgaon,Haryana</span> 
					    <span itemprop="postalCode"  style="font-size:smaller">122103</span>
					</div>
					<div><small><a href="https://www.<w4india:resellername/>.com"  itemprop="url">https://www.<w4india:resellername/>.com</a></small></div>
				</div>
		       </td>
			<td width="30%">
				<div itemscope itemtype="http://schema.org/AccountingService">
					<div itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
						<div itemprop="streetAddress" style="font-size:smaller">830, Stewart Drive Suite 109</div>
					    <span itemprop="addressLocality" style="font-size:smaller">Sunnyvale</span>,
					    <span itemprop="addressRegion" style="font-size:smaller">CA</span> 
					    <span itemprop="postalCode"  style="font-size:smaller">94085</span>
					</div>
					<span itemprop="telephone"  style="font-size:smaller">+1-408-475-2035</span>
					<div><small><a href="https://www.<w4india:resellername/>.com"  itemprop="url">https://www.<w4india:resellername/>.com</a></small></div>
				</div>
			</td>
		</tr>
	</tbody>
</table>

<div>
	<strong>E-mail:</strong>&nbsp;<span itemprop="email"><a href="mailto:info@<w4india:resellername/>.com">info@<w4india:resellername/>.com</a>
	</span>
</div>
<div>
	<strong>Website:</strong>&nbsp;<span><a href="http://www.<w4india:resellername/>.com">www.<w4india:resellername/>.com</a>
	</span>
</div>
<div>
	<strong>Telephone No:</strong><span itemprop="telephone">+91-(11)-45067102, +91-(11)-25074341, +91-9136265229, +1-408-475-2035</span>
</div>