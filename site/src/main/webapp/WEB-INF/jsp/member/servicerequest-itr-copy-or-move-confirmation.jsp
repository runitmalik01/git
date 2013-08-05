<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Copy complete" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="page">
	<%--<w4india:itrmenu />  --%>
	<h5></h5>
	<a href="../../${newFolderName}/${pan}/servicerequest-itr-summary.html">Your return was copied successfully. Click here to open the new return</a>
</div>
<%--<res:client-validation screenConfigurationDocumentName="payment" formId="frmPayment" formSubmitButtonId="hrefLogin"></res:client-validation> --%>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />