<%@include file="../includes/tags.jspf"%>
<hippo-gogreen:title title="Please confirm and agree to Wealth4India's Terms and Conditions" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="page">
	<w4india:itrmenu />
	<!--  lets check for warnings and errors and let the user know -->
	<c:if test="${not empty hippoBeanValidationResponse && ( fn:length(hippoBeanValidationResponse.errors) > 0 || fn:length(hippoBeanValidationResponse.warnings) > 0) }">
		<div id="myModalErrors" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			    <h3>We have found the following errors/warnings in your return.</h3>
			    <h5>Please understand, if you upload your return without fixing these, your income tax may get rejected.</h5>
			  </div>
			  <div class="modal-body">
					<div style="font-size:10px; border: 1px dashed #FF0000;padding:5px;text-align:left">
						<ul>
							<c:forEach items="${hippoBeanValidationResponse.errors}" var="error">
								<li style="list-style:circle;">
									<fmt:message key="${error.message}">
										<c:forEach items="${error.messageArgs}" var="aParam">
											<fmt:param value="${aParam}"/>
										</c:forEach>										
									</fmt:message> 
								</li>
							</c:forEach>
							<c:forEach items="${hippoBeanValidationResponse.warnings}" var="warning">
								<li style="list-style:circle;">
									<fmt:message key="${warning.message}">
										<c:forEach items="${warning.messageArgs}" var="aParam">
											<fmt:param value="${aParam}"/>
										</c:forEach>										
									</fmt:message> 
								</li>
							</c:forEach>				
						</ul>
					</div>
			  </div>
			  <div class="modal-footer">
			    <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">Cancel</button>
			    <a href="${redirectToOriginalPage}?uuid=${publicParameterUUID}" class="btn btn-warning">Continue with <fmt:message key="${originalPageAction}.label"/></a>
			  </div>
		</div>
	</c:if>
	<!--  /lets check for warnings and errors and let the user know -->
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
	jQuery(document).ready(function($) {		
		if ( $("#myModalErrors").length > 0 ) {
			$('#myModalErrors').modal({'backdrop':true,'show':true});
		}
	});
	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />