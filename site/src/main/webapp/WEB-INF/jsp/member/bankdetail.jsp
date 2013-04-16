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
<%-- 
  - Author:Priyank 
  - Date:16-Apr-2013
  -Description: It contains the code for the Bank detail of Member to transfer the Refund by Income Tax Department. 
  --%>
<%@include file="../includes/commonincludes.jspf"%>
<c:set var="bankdetail">
	<fmt:message key="member.bank.detail" />
</c:set>
<hippo-gogreen:title title="${ bankdetail}" />
<div id="breadcrumb">
	<fmt:message key="member.location.label" />
	&nbsp;
	<hst:link var="home" siteMapItemRefId="home" />
	<a href="${home}"><fmt:message key="products.detail.location.home" /></a>&gt;
	<hst:link var="startapplication" siteMapItemRefId="member-personal-information"></hst:link>
	<a href="${startapplication}"><fmt:message
			key="member.start.application" /></a>&gt;
	<hst:link var="contactinformation"
		siteMapItemRefId="member-contact-information"></hst:link>
	<a href="${contactinformation}"><fmt:message
			key="member.contact.information" /></a>&gt;
	<hst:link var="residentialstatus" siteMapItemRefId="member-residential-status"></hst:link>
	<a href="${residentialstatus}"><fmt:message
			key="member.residential.status" /></a>&gt;
	<hst:link var="bankdetail" siteMapItemRefId="member-bank-detail"></hst:link>
	<a href="${bankdetail}"><fmt:message key="member.bank.detail" /></a>
</div>
<br />
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan).replaceAll("bankdetail.html","");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="bankDetail" action="${actionUrl}" method="post" id="frmBankDetail">
	<div id="row">
		<div id="span4">
			 <label><fmt:message key="member.bank.detail.bank.name" /></label> 
			 <input type="text" name="bd_bank_name" value="${parentBean.BD_BANK_NAME}" title="Enter Name of Bank"maxlength="25" min="1" required="required" />
			 <label><fmt:message key="member.bank.detail.micr.code" /></label> 
			 <input type="text" name="bd_micr_code"value="${parentBean.BD_MICR_CODE}" title="Enter 9-Digit valid MICR Code" maxlength="9" class="numberinput" required="required" />
		     <label><fmt:message key="member.bank.detail.branch.name" /></label>
			 <input type="text" name="bd_Branch_name" value="${parentBean.BD_ADD_BANK_BRANCH}" title="Enter Name of Bank's Branch" maxlength="120" required="required" /> 
			 <label><fmt:message key="member.bank.detail.acc.type" /> </label> 
			 <select name="bd_account_type" title="Select Type of Account" id="bd_account_type">
				<option value=""></option>
				<option value="SAV">
					<fmt:message key="member.bank.detail.acc.type.saving" />
				</option>
				<option value="CUR">
					<fmt:message key="member.bank.detail.acc.type.current" />
				</option>
			</select>
			<input type="hidden" name="acc_type" value="${parentBean.BD_TYPE_ACC}" id="acc_type"> 
			<label><fmt:message key="member.bank.detail.acc.number" /></label> 
			<input type="text" name="bd_account_no" value="${parentBean.BD_ACC_NUMBER}" title="Enter Account Number" maxlength="17" class="numberinput" required="required" />
			<label><fmt:message key="member.bank.detail.ecs"/></label>
			<select name="bd_ecs" title="Select Electronic Clearing System" id="bd_ecs">
				<option value="N">
					<fmt:message key="member.choice.no" />
				</option>
				<option value="Y">
					<fmt:message key="member.choice.yes" />
				</option>
			</select>
			<input type="hidden" name="ecs" value="${parentBean.BD_ECS}" id="ecs">
			<br /> 
			<a id="hrefLogin" class="button orange">Save & Next</a><a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left: 100px;">Next</a>
		</div>
	</div>
</form>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			    $('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
         });
			    $('#frmBankDetail input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmBankDetail').submit();
				    }
				});
				var ecs=$('#ecs').val();
				if(ecs!=null){
				      $('#bd_ecs').val(ecs);
				};
				var acc_type=$('#acc_type').val();
				if(acc_type!=null){
				      $('#bd_account_type').val(acc_type);
				}
				
				$('#hrefLogin').click(function() {
		 			$('#frmBankDetail').submit();
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>