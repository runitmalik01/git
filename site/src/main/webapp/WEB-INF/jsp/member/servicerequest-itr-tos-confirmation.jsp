<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Please confirm and agree to Wealth4India's Terms and Conditions" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="page">
	<w4india:itrmenu />
	<h4>Please review your return</h4>
	<form id="frmPayment" action="${actionUrl}" method="post" name="frmConfirmation">
		<fieldset>
			<legend>Your Income Tax Return Summary</legend>
			<div class="row-fluid show-grid">
				<div class="span12">
					<c:out value="${generatedHtmlSummary}" escapeXml="false"/>
				</div>
			</div>
		</fieldset>	
		<div class="row-fluid show-grid">
			<div class="span12">
				By clicking <b><i><fmt:message key="${originalPageAction}.label"/></i></b>,<br/>
				<p>I son/daughter of <b><c:out value="${memberpersonalinformation.fatherName}"/></b> solemnly declare that to the best of my knowledge and belief, the information 
				given in the return thereto is correct and complete and that the amount of total income and other particulars shown therein are truly stated and are in accordance with provisions of Income-tax Act, 1961, 
				in respect of income chargeable to Income-tax for the previous year relevant to the <b>Assessment Year ${assessmentYear}</b>
				</p>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span4 offset8 decimal">				  
				<a href="${redirectToOriginalPage}?uuid=${publicParameterUUID}" role="button" class="btn btn-primary">					
					<fmt:message key="${originalPageAction}.label"/>
				</a>
			</div>
		</div>
	</form>
</div>
<%--<res:client-validation screenConfigurationDocumentName="payment" formId="frmPayment" formSubmitButtonId="hrefLogin"></res:client-validation> --%>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	
	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />