<%@include file="../../includes/tags.jspf"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%if(request.getUserPrincipal()!=null){
    pageContext.setAttribute("regemail", request.getUserPrincipal().getName()); 
    }
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
  <form class="form" name="serviceRequest" action="${actionUrl}" method="post" id="serviceRequest">
<%-- <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="myModalLabel">Service Request</h3>
  </div>--%>
  <h4><c:out value="${srdocument.name}"/> Request</h4>
  		<h5><small>Fill this service request form.Soon we will get back to you.</small></h5>
  		<c:if test="${not empty ReqSuccess}">
  		  <div class="alert alert-success">
  		     <button type="button" class="close" data-dismiss="alert">&times;</button>
  		       <strong><c:out value="Successfully Applied"/></strong>
  		  </div>
  		</c:if>
<c:choose>
	<c:when test="${success eq 'success'}">
		<fmt:message key="easyforms.formtemplate.thankyou.event" />
	</c:when>
	<c:otherwise>
		<c:forEach items="${ef_errors}" var="error">
			<div class="form-error">
				<c:out value="${error.message}" />
			</div>
		</c:forEach>
			<c:forEach var="field" items="${form.fields}">
				<c:choose>
					<c:when test="${field.simpleText}">
						<div class="ef-text">
							<h2>
								<c:out value="${field.label}" />
							</h2>
							<p>
								<c:out value="${field.hint}" />
							</p>
						</div>
					</c:when>
					<%-- simple types layout--%>
					<c:when test="${field.textField or field.password or field.textArea or field.dropdown or field.radioBox or field.checkBox}">
							<label for="<c:out value="${field.name}" />"><small><c:out value="${field.label}"/></small><span class="required"><c:out value="${field.requiredMarker}" />
							</span>
							</label>
							<c:choose>
							  <c:when test="${field.textField}"> 
							    <input type="text" name="${field.name}" id="${field.name}" maxlength="${field.length}">
							  </c:when>
							  <c:otherwise>${field.html}</c:otherwise>
							</c:choose>
							 <span class="ef-hint"><c:out value="${field.hint}" /></span>
					</c:when>
					<c:when test="${field.radioGroup}">
						<div class="ef-field clearfix">
							<label><c:out value="${field.label}" /><span
								class="ef-req"><c:out value="${field.requiredMarker}" />
							</span>
							</label>
							<c:forEach var="radio" items="${field.fields}">
								<p>
									${radio.html}<span><c:out value="${radio.label}" />
									</span>
								</p>
							</c:forEach>
							<c:if test="${field.allowOther}">
                               ${field.otherChoice} <fmt:message
									key="easyforms.formtemplate.other" />: <span>${field.other}</span>
							</c:if>
							<span class="ef-hint"><c:out value="${field.hint}" />
							</span>
						</div>
					</c:when>
					<c:when test="${field.checkBoxGroup}">
						<div class="ef-field clearfix">
							<label><c:out value="${field.label}" /><span
								class="ef-req">${field.requiredMarker}</span>
							</label>
							<c:forEach var="box" items="${field.fields}">
								<p>
									${box.html}
									<c:out value="${box.label}" />
								</p>
							</c:forEach>
							<c:if test="${field.allowOther}">
                               ${field.otherChoice} <fmt:message
									key="easyforms.formtemplate.other" />: <span>${field.other}</span>
							</c:if>
							<span class="ef-hint"><c:out value="${field.hint}" />
							</span>
						</div>
					</c:when>
					<%--  LIKERT--%>
					<c:when test="${field.likert}">
						<div class="ef-field clearfix">
							<label><c:out value="${field.label}" /><span class="ef-req"><c:out value="${field.requiredMarker}" />
							</span>
							</label>
							<table class="ef-likert-table">
								<tr>
									<td>&nbsp;</td>
									<c:forEach var="option" items="${field.options}">
										<td>${option}</td>
									</c:forEach>
								</tr>
								<c:forEach var="map" items="${field.htmlMap}">
									<tr>
										<td><c:out value="${map.key.label}" />
										</td>
										<c:forEach var="radio" items="${map.value}">
											<td>${radio.html}</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</table>
							<span class="ef-hint"><c:out value="${field.hint}" />
							</span>
						</div>
					</c:when>
				</c:choose>
			</c:forEach>
	</c:otherwise>
</c:choose>
<br/><br/>
<div class="rowlabel" align="center">
<button value="Apply" id="apply" class="btn btn-info">Apply</button>
</div>
</form>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		  $("#serviceRequest").validate({
           rules: {
               "flex_field_string_0": {
                 required: true
               },
               "flex_field_string_2": {
                 required: true
               },
               "flex_field_string_4": {
                 required: true
               },
               "flex_field_string_5": {
                 required: true
               }
            },
            messages: {
                "flex_field_string_0": {
                   required: "Please enter first name"
                },
                "flex_field_string_2": {
                   required: "Please enter last name"
                },
                "flex_field_string_4": {
                   required: "Please enter mobile no."
                },
                "flex_field_string_5": {
                   required: "Please enter email"
                }            
            },
            submitHandler: function (form) { // for demo
                $('#serviceRequest').submit();                
                return true;
             }
            });
            var regemail='<c:out value = "${regemail}" />';
	        if(regemail!='') {
	           serviceRequest.flex_field_string_5.value= regemail ;
	        }
	        serviceRequest.flex_field_string_5.setAttribute('id','flex_field_string_5');
	        serviceRequest.flex_field_string_6.value='<c:out value="${srdocument.name}"/>';
	        serviceRequest.flex_field_string_6.readOnly=true;
		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<%-- <res:client-validation formId="serviceRequest" formSubmitButtonId="apply" screenConfigurationDocumentName="servicerequest"></res:client-validation>--%>