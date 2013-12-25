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
  		<c:if test="${canServiceRequestFullfill eq false}">
  		   <div class="alert alert-warning">
  		     <button type="button" class="close" id='dismissImport' data-dismiss="alert">&times;</button>
  		   Service Lead Time will Pass the due Date of Income Tax Return Filing.Are you OK?</div>
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
<button value="Apply" id="apply" class="btn btn-default btn-info">Apply</button>
</div>
</form>
<c:set var="sectionData">
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="description"><small>Type (Optional)</small></label>
			</div>
			<div class="rowlabel">
				<select name="description" id="description" class="col-md-8">
					<option value="">-Select-</option>
				</select>
			</div>
		</div>
		<div class="col-md-2">
			<div class="rowlabel">
				<label for="member_file"><small>File (required)</small></label>
			</div>
			<div class="rowlabel">
				<span class="btn btn-default btn-success fileinput-button"
					id="remove"> <i
					class="glyphicon glyphicon-plus glyphicon glyphicon-white"></i> <span>Attach</span>
					<input type="file" id="member_file" name="member_file" />
				</span>
				<div id="member_file_name"></div>
			</div>
		</div>
	</div>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="protected"><small><abbr
						title="If Uploading Document is password protected then please provide password">Document
							Password</abbr></small></label>
			</div>
			<div class="rowlabel">
				<input id="protected" name="protected" type="password" />
			</div>
		</div>
		<div class="col-md-2">
			<div class="rowlabel">
				<label for="protected"><small><abbr
						title="If you want to share any additional notes">Additional
							Notes</abbr></small></label>
			</div>
			<div class="rowlabel">
				<textarea id="additionalnotes" name="additionalnotes"></textarea>
			</div>
		</div>
	</div>
</c:set>
<c:if test="${not empty documentRequired and documentRequired eq 'true'}">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Add New Row Component Panel</h4>
				</div>
				<div class="modal-body">
					<c:choose>
						<c:when test="${pageAction eq 'NEW_CHILD'}">
							<c:set value="row_0" var="formID" />
						</c:when>
						<c:otherwise>
							<c:set value="pageRowDetailsForm" var="formID" />
						</c:otherwise>
					</c:choose>
					<form id="${formID}" name="pageRowDetailsForm" class="pageRowDetailsForm" action="${actionUrl}" method="post" enctype="multipart/form-data">
						<div class="scheduleSIbody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
				    <c:if test="${pageAction eq 'NEW_CHILD'}"><a href="#" class="btn btn-default btn-warning btn-sm" id="addnew"><i class="glyphicon glyphglyphicon glyphicon-plus-sign"></i>Add New</a></c:if>
					<%-- <c:if test="${pageAction eq 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/deleterows"
							class="btn btn-default btn-danger btn-sm"> <i class="glyphglyphicon glyphicon-trash glyphicon"></i>Delete
						</a>
					</c:if> --%>
					<a href="<c:choose><c:when test="${not empty componentUUID}">${scriptName}/${componentUUID}/editpage</c:when>
					            <c:otherwise>${websitebuilderlink}/pages.html/newpage/${absoluteComponentName}</c:otherwise></c:choose>"
						class="btn btn-default btn-default btn-sm" data-dismiss="">Close</a> 
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="ajaxsubmit" var="saveID" />
						</c:when>
						<c:otherwise>
							<c:set value="siSave" var="saveID" />
						</c:otherwise>
					</c:choose>
					<a href="#" id="${saveID}" class="btn btn-default btn-primary btn-sm"><i class="glyphicon glyphglyphicon glyphicon-ok-circle"></i>Save changes</a>
				</div>
			</div>
		</div>
	</div>
</c:if>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		  if ($("#myModal").length >0) $("#myModal").modal({backdrop: 'static'});
		  $("#serviceRequest").validate({
           rules: {
               "firstName": {
                 required: true
               },
               "lastName": {
                 required: true
               },
               "mobile": {
                 required: true
               },
               "email": {
                 required: true
               }
            },
            messages: {
                "firstName": {
                   required: "Please enter first name"
                },
                "lastName": {
                   required: "Please enter last name"
                },
                "mobile": {
                   required: "Please enter mobile no."
                },
                "email": {
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
	           serviceRequest.email.value= regemail ;
	        }
	        serviceRequest.email.setAttribute('id','email');
	        serviceRequest.serviceName.value='<c:out value="${srdocument.name}"/>';
	        serviceRequest.serviceCanonicalHandleUUID.value='<c:out value="${srdocument.canonicalHandleUUID}"/>';
	        serviceRequest.serviceCode.value='<c:out value="${srdocument.serviceCode}"/>';
	        serviceRequest.serviceName.readOnly=true;
	        
	        var fieldsToHide = ['serviceCode','serviceCanonicalHandleUUID'];
	        $.each(fieldsToHide , function( index, value ) {
                $('#'+ value).hide();
                $('label[for="'+ value +'"]').hide();
             });
             if ($("#myModal").length >0) $("#myModal").modal();
      
      $('#siSave').on('click',function(){
         $('#pageRowDetailsForm').submit();
      });
      $('#ajaxsubmit').on('click',function(){
      allForms=$('.pageRowDetailsForm');
      allForms.each ( function(index,value) {
				$(value).validate();
				if (!$(value).valid()) {
					return false;
				}
			});
	  for (var i=0;i< allForms.length; i++ ) {
            var theData = $(allForms[i]).serialize();
				$.ajax('<hst:actionURL></hst:actionURL>',
						{
						'data': theData,
						'method':'POST',
						'async':false											
					  }).done (function () {
					   
						window.location.href = <c:choose><c:when test="${pageAction == 'NEW_CHILD'}"> '<c:out value="${scriptName}"/>'</c:when><c:otherwise>'../../servicerequest-itr-summary.html'</c:otherwise></c:choose>;
					});
		}
      
      });
      
      $('#addnew').on('click', function(){
            var rehtml=$('.modal-body').html();
            arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.pageRowDetailsForm').last();
			 var theId  = theForm.attr('id');
			 formValidate(theId);
			 var eDiv = $('#'+theId);
			 eDiv.validate();
			 if (!eDiv.valid()) return;
			 newID = theId+1; 
			 if (theId.indexOf("row_") != -1) {
					theindx = theId.split("_")[1];
					var eDiv =  $("#row_" + theindx);
					eDiv.validate();
					if (!eDiv.valid()) return;					
					var theNewDiv =  $("#row_" + (parseInt(theindx) + 1));
					if (theNewDiv.length == 0) {
						html = eDiv.html();						
						var newdiv1 = $('<form class="pageRowDetailsForm" name="pageRowDetailsForm"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						newdiv1.append(html);
						$(".modal-body").append(newdiv1);						
						newdiv1.find(".col-md-4").hide();	
						$(".head").change(headChangeHandler);
						$(".head").change( function(o) {
							changeD(this);
							}
						);											
					}
				}     
			function formValidate(formID){
			 $('#'+formID).validate({
				rules: {
					member_file: {
						required: true,
					},
					description: {
						required: true
					}
				},
				messages: {
					member_file: "This field is required.",
					description: "This field is required."
				}
			  });
			}
		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<%-- <res:client-validation formId="serviceRequest" formSubmitButtonId="apply" screenConfigurationDocumentName="servicerequest"></res:client-validation>--%>