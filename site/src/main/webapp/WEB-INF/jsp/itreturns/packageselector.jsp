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

<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionURL"></hst:actionURL>
<div class="page">
	<h4>Welcome to Income Tax Return Preparation for Financial Year:<c:out value="${financialYear.displayName}"/></h4>
	<p>List of available packages for Filing Status <b><c:out value="${filingStatus.name}"/></b></p>
	<small>Select the package which suits your need and then click on Start Filing the Taxes</small>
	<form id="frmdata" method="post" action="${actionURL}">
		<input type="hidden" name="selectionUUID" value="${selectionUUID}"/>
		<input type="hidden" id="partNumber" name="partNumber" value=""/>	
		<div class="row-fluid show-grid rowlabel">
			<div class="span6">
				<div>Basic ()</div>
				<div><a id="hrefSubmitBasic" name="hrefSubmit" role="button" class="btn orange" data-toggle="modal">Start</a></div>
		    </div>
			<div class="span6">
				<div>Premium ()</div>
				<div><a id="hrefSubmitPremium" name="hrefSubmit" role="button" class="btn orange" data-toggle="modal">Start</a></div>
		    </div>				    
		 </div> 
	</form>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		$('#hrefSubmitBasic').click(function() {			 
			 $("#partNumber").val("<c:out value="${financialYear.displayName}"/>_<c:out value="${filingStatus.fourthCharInPAN}"/>_basic");
			 $('#frmdata').submit();
		});
		$('#hrefSubmitPremium').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}"/>_<c:out value="${filingStatus.fourthCharInPAN}"/>_premium");
			 $('#frmdata').submit();
		});
		/*
		$('#hrefSubmitAssisted').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}"/>_<c:out value="${filingStatus.fourthCharInPAN}"/>_assisted");
			 $('#frmdata').submit();			 
		});	
		*/	
	});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
