<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Copy complete" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<%--<res:client-validation screenConfigurationDocumentName="payment" formId="frmPayment" formSubmitButtonId="hrefLogin"></res:client-validation> --%>
<div class="alert alert-success">
    <span class="glyphicon glyphicon-ok"></span><strong> Copied successfully !!!</strong>
    <hr class="message-inner-separator">
    <p>
       Your return has copied successfully. <a href="../../${newFolderName}/${pan}/servicerequest-itr.html">Click here to open the new return.</a>
    </p>
</div>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>