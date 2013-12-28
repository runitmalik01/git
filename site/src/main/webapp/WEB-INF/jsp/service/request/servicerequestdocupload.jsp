<%@include file="../../includes/tags.jspf"%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:set var="sectionData">
	<div class="row show-grid">
		<div class="col-md-6">
			<div class="rowlabel">
				<label for="description"><small>Type (Optional)</small></label>
			</div>
			<div class="rowlabel">
				<select name="description" id="description">
					<option value="">-Select-</option>
				</select>
			</div>
		</div>
		<div class="col-md-6">
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
		<div class="col-md-6">
			<div class="rowlabel">
				<label for="protected"><small><abbr
						title="If Uploading Document is password protected then please provide password">Document
							Password</abbr></small></label>
			</div>
			<div class="rowlabel">
				<input id="protected" name="protected" type="password" />
			</div>
		</div>
		<div class="col-md-6">
			<div class="rowlabel">
				<label for="protected"><small><abbr
						title="If you want to share any additional notes">Additional
							Notes</abbr></small></label>
			</div>
			<div class="rowlabel">
				<textarea id="additionalnotes" name="additionalnotes" draggable="false" cols="2" rows="4"></textarea>
			</div>
		</div>
	</div>
	<input type="hidden" name="serviceRequestNumber" id="serviceRequestNumber" value="${serviceRequestNumber}"/>
</c:set>
<c:if test="${not empty documentUploaded && documentUploaded eq 'false'}">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h6 class="modal-title">Add Document for ${srdocument.name} Request.Your SR-Number:<b>${serviceRequestNumber}</b></h6>
			</div>
			<div class="modal-body">
				<div class="alert alert-warning">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Request is in Process.Upload your's document according type list to complete it</strong>
				</div>
				<form id="row_0" name="memberDriveForm" class="memberDriveForm" action="${actionUrl}" method="post" enctype="multipart/form-data">
					<div class="scheduleSIbody">
						<c:out value="${sectionData}" escapeXml="false"></c:out>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-default btn-default btn-sm" data-dismiss="modal" aria-hidden="true">Close</a> 
				<a href="#" class="btn btn-default btn-warning btn-sm" id="addnew"><i class="glyphicon glyphglyphicon glyphicon-plus-sign"></i>Add New</a> 
				<a href="#" id="ajaxsubmit" class="btn btn-default btn-primary btn-sm"><i class="glyphicon glyphglyphicon glyphicon-ok-circle"></i>Save changes</a>
			</div>
		</div>
	</div>
</div>
</c:if>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){		  
		  if ($("#myModal").length >0) $("#myModal").modal({backdrop: 'static'});	        
             <c:if test="${not empty srdocument}">
             $.expr[':'].nonEmptyValue = function(obj) {
                  return $(obj).val() != '';
              };
             $('#description option:nonEmptyValue').remove();
             <c:forEach items="${srdocument.documentNames}" var="documentName">
                <c:if test="${not empty documentName}">
                     $('#description').append($("<option></option>")
                         .attr("value",'<c:out value="${documentName}"/>')
                                 .text('<c:out value="${documentName}"/>'));
                </c:if>
             </c:forEach>
          </c:if>
             if ($("#myModal").length >0) $("#myModal").modal();
             $('#member_file').bind('change', function(){
		        $('#member_file_name').text(this.files[0].name);
		        //$('#file_process').show();		    
             });
      $('#ajaxsubmit').on('click',function(){
      allForms=$('.memberDriveForm');
      var formValid = true;
      allForms.each ( function(index,value) {
                formValidate(value.id);
				$(value).validate();
				formValid = $(value).valid();
			});
			if(!formValid){
			  return;
			}
	  for (var i=0;i< allForms.length; i++ ) {
            var theData = $(allForms[i]).serialize();
             var formData = new FormData(allForms[i]);
				$.ajax('<hst:actionURL></hst:actionURL>',
						{
						'data': formData,
						'method':'POST',
						'async':false,
						'mimeType':"multipart/form-data",
                        'contentType': false,
                        'cache': false,
                        'processData':false											
					  }).done (function () {
					     $('#myModal').modal('hide');
					     location.reload();					   
						//window.location.href = ;
					});
		     }      
       });      
      $('#addnew').on('click', function(){
            var rehtml=$('.modal-body').html();
            arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.memberDriveForm').last();
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
						var newdiv1 = $('<form class="memberDriveForm" name="memberDriveForm"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						newdiv1.append(html);
						$(".modal-body").append(newdiv1);																	
					}
				}     
		 });
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
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/jquery.fileupload-ui.css"/>" type="text/css" />
</hst:headContribution>