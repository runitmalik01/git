<%@include file="../includes/tags.jspf" %>
<c:set value="Security Question" var="title"></c:set>
<hippo-gogreen:title title="${title}"></hippo-gogreen:title>
<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="itreturnhomepage" siteMapItemRefId="itreturnhome"/>
<c:if test="${securityQues eq true }">
	<div class="alert alert-info">
		<p>
			<strong>Wealth4India cares about your security and we take all necessary measures to make sure your information is secured and safe.</strong>
		</p>
		<p>In order to ensure your safety we will need the following.Please add questions.</p>
	</div>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<div class="well">
		<fieldset>
			<legend>
				<strong><i class="icon-lock"></i>Security Questions</strong>
			</legend>
			<strong>Click on</strong>
			<div class="btn-group">
				<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
					<i class="icon-lock icon-white"></i>Security Question Panel<span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="${scriptName}/membersecuritynew" id="newchild"><i class="icon-plus-sign"></i><strong>Add</strong></a></li>
				</ul>
			</div>
			&nbsp;<strong>to add security question!!</strong>
		</fieldset>
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr class="success">
					<th>#</th>
					<th><i class=" icon-ok-circle"></i>Security Question</th>
					<th><i class="icon-lock"></i><abbr title="Answer of selected Security Question">Answer</abbr></th>
					<th><i class="icon-adjust"></i>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty parentBean.securityQuestionAnswerValueListList}">
					<c:forEach items="${parentBean.securityQuestionAnswerValueListList}" var="secQuesAnsList" varStatus="ct">
						<tr class="warning">
							<td><c:out value="${ct.count}" /></td>
							<td><c:out value="${secQuesAnsList.question}" /></td>
							<td><c:out value="${secQuesAnsList.answer}" /></td>
							<td> <a href="${scriptName}/${secQuesAnsList.canonicalUUID}/membersecurityedit"
										class="btn btn-primary"><i class="icon-edit icon-white"></i><span><strong>Edit</strong></span></a>&nbsp;
									<a href="${scriptName}/${secQuesAnsList.canonicalUUID}/membersecuritydelete" 
									data-confirm="" class="btn btn-danger"><i class="icon-trash icon-white"></i><span><strong>Delete</strong></span></a>
								</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="rowlabel offset6"><a href="${itreturnhomepage}" id="skip" class="btn btn-primary" data-verify=""><i class="icon-play-circle icon-white"></i>Continue Filing</a></div>
	</div>
	<c:set var="modalBody">
		<fieldset>
			<legend>
				<strong><i class="icon-lock"></i>Security Questions</strong>
			</legend>
			<div class="show-grid row-fluid">
				<div class="span8">
					<div class="rowlabel">
						<label for="securityQuestion"><small>Security Question</small></label>
					</div>
					<div class="rowlabel">
						<c:if test="${pageAction == 'EDIT_CHILD'}">
							<c:forEach items="${parentBean.securityQuestionAnswerValueListList}" var="secQuesAnsList">
								<c:if test="${secQuesAnsList.canonicalUUID == uuid}">
									<c:set value="${secQuesAnsList.question}" var="ques" />
								</c:if>
							</c:forEach>
						</c:if>
						<select id="securityQuestion" name="securityQuestion" class="select-drop head">
							<option value="">-Select-</option>
							<c:forEach items="${questionsMap}" var="question" varStatus="stat">
								<c:forEach items="${question.value}" var="sques">
									<option value="${sques.value}"
										<c:if test="${pageAction == 'EDIT_CHILD' && sques.value == ques}">selected</c:if>>${sques.value}</option>
								</c:forEach>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="span4 <c:if test="${pageAction == 'NEW_CHILD'}">hide</c:if>">
					<div class="rowlabel">
						<label for="securityAnswer"><small><abbr title="Feasible answer for selected Question">Answer</abbr></small></label>
					</div>
					<div class="rowlabel">
						<c:if test="${pageAction == 'EDIT_CHILD'}">
							<c:forEach items="${parentBean.securityQuestionAnswerValueListList}" var="secQuesAnsList">
								<c:if test="${secQuesAnsList.canonicalUUID == uuid}">
									<c:set value="${secQuesAnsList.answer}" var="qanswer" />
								</c:if>
							</c:forEach>
						</c:if>
						<input id="securityAnswer" name="securityAnswer" value="${qanswer}" type="text" />
					</div>
				</div>
			</div>
		</fieldset>
	</c:set>
	<c:if test="${pageAction == 'NEW_CHILD'||pageAction == 'EDIT_CHILD'}">
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Member Security Panel</h4>
					</div>
					<div class="modal-body">
						<c:choose>
							<c:when test="${pageAction == 'NEW_CHILD'}">
								<c:set value="row_0" var="formID" />
							</c:when>
							<c:otherwise>
								<c:set value="memberSecQues" var="formID" />
							</c:otherwise>
						</c:choose>
						<form name="memberSecQues" id="${formID}" action="${actionUrl}" method="post" class="securtiyQuesForm">
							<c:out value="${modalBody}" escapeXml="false" />
						</form>
					</div>
					<div class="modal-footer">
						<c:if test="${pageAction == 'NEW_CHILD'}">
							<a href="#" class="btn btn-inverse" id="addnew">Add New</a>
						</c:if>
						<c:if test="${pageAction == 'EDIT_CHILD'}">
							<a href="${scriptName}/${uuid}/membersecuritydelete"
								class="btn btn-danger"> <i class="icon-trash icon-white"></i>Delete
							</a>
						</c:if>
						<a href="${scriptName}?security=true" class="btn" data-dismiss="">Close</a>
						<c:choose>
							<c:when test="${pageAction == 'NEW_CHILD'}">
								<c:set value="ajaxsubmit" var="saveID" />
							</c:when>
							<c:otherwise>
								<c:set value="siSave" var="saveID" />
							</c:otherwise>
						</c:choose>
						<a href="#" id="${saveID}" class="btn btn-primary">Save changes</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</c:if>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>    
    $('document').ready(function(){
    
    if ($("#myModal").length >0) $("#myModal").modal();
    
     $('#siSave').on('click',function(){
         $('#memberSecQues').submit();
      });
      
    $('.select-drop').on('change',function(){
	     if($(this).val()!=null){
		     $('.span4').show();
	     } 
      });
      $('a[data-verify]').click(function(ev) {
       var child_count = '<c:if test="${empty parentBean.securityQuestionAnswerValueListList}"><c:out value="0"/></c:if>';
       if(child_count == '0'){
        var href = $(this).attr('href');
        if (!$('#dataConfirmModal').length) {
            $('body').append('<div id="dataConfirmModal" class="modal" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="dataConfirmLabel">Please Confirm</h3></div><div class="modal-body"></div><div class="modal-footer"><button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button><a class="btn btn-primary" id="dataConfirmOK">OK</a></div></div>');
        }
        $('#dataConfirmModal').find('.modal-body').text("Are you don't want to save security question?");
        $('#dataConfirmOK').attr('href', href);
        $('#dataConfirmModal').modal({show:true});
        return false;
       }
    });
    $('#ajaxsubmit').on('click',function(){
      allForms=$('.securtiyQuesForm');
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
						window.location.href = '<c:out value="${scriptName}?security=true"/>';
					});
		}
      
      });
      
      $('#addnew').on('click', function(){
            var rehtml=$('.modal-body').html();
            arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.securtiyQuesForm').last();
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
						//insertDiv
						html = eDiv.html();						
						var newdiv1 = $('<form class="securtiyQuesForm" name="memberSecQues"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						//alert(html);
						newdiv1.append(html);
						
						$(".modal-body").append(newdiv1);
						
						newdiv1.find(".span4").hide();
						
						//$(".theamount").blur( handleBlur );	
						$(".head").change(headChangeHandler);
						
						$(".head").change( function(o) {
							changeD(this);
							}
						);											
						$('.securtiyQuesForm input').keydown(function(e) {
						    if (e.keyCode == 13) {
						   		e.preventDefault();
						        //$('#frmdata').submit();
						    }
						});
						//alert(html);
					}
				}
				
				$(".head").change(headChangeHandler);
			
			function headChangeHandler() {
				var o = $(this).val();	
				if (o.trim() == '') {
					//hide and remove the corresponding amount button
					$(this).parents(".row-fluid").find(".span4").hide();
					$('label[for="securityAnswer"]').hide();
				}
				else {
					$(this).parents(".row-fluid").find(".span4").show();
					$('label[for="securityAnswer"]').show();
				}
			}       
			function formValidate(formID){
			 $('#'+formID).validate({
				rules: {
					securityQuestion: {
						required: true,
					},
					securityAnswer: {
						required: true
					}
				},
				messages: {
					schedulesiSection: "This field is required.",
					securityAnswer: "This field is required."
				}
			  });
			}
        });
  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
<%--
<res:client-validation screenConfigurationDocumentName="membersecurity" formId="memberSecQues" formSubmitButtonId="siSave"></res:client-validation>
<c:forEach items="${questionsMap}" var="question" varStatus="stat">
					<div class="show-grid row-fluid">
						<div class="span6">
							<div class="rowlabel">
								<label for="securityQues${stat.count}"><small>Security Question${stat.count}</small></label>
							</div>
							<div class="rowlabel">
								<c:forEach items="${parentBean.securityQuestionAnswerValueListList}" var="sQuesList" varStatus="sQCount">
									<c:if test="${sQCount.count == stat.count}">
										<c:set value="${sQuesList.question}" var="que"></c:set>
									</c:if>
								</c:forEach>
								<select id="securityQues${stat.count}" name="securityQues${stat.count}">
									<option value="">-Select-</option>
									<c:forEach items="${question.value}" var="sques">
										<option value="${sques.value}"
											<c:if test="${sques.value==que}">selected</c:if>>${sques.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="answer${stat.count}"><small>Answer${stat.count}</small></label>
							</div>
							<div class="rowlabel">
								<c:forEach items="${parentBean.securityQuestionAnswerValueListList}" var="sQuesList" varStatus="sQCount">
									<c:if test="${sQCount.count == stat.count}">
										<c:set value="${sQuesList.answer}" var="qanswer"></c:set>
									</c:if>
								</c:forEach>
								<input id="answer${stat.count}" name="answer${stat.count}" value="${qanswer}" type="text" />
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="pull-right rowlabel span2 offset3">
					<button type="submit" class="btn btn-primary" value="Save">
						&nbsp;&nbsp;<i class="icon-lock icon-white"></i>Save&nbsp;&nbsp;
					</button>
				</div>--%>