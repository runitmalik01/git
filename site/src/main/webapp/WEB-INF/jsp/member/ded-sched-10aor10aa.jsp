<%@include file="../includes/tags.jspf" %>
<c:set var="Schedule10A">
 ITR Schedule 10A/10AA
</c:set>
<hippo-gogreen:title title="${Schedule10A}" />
<hst:actionURL var="actionUrl"></hst:actionURL> 
<w4india:itrmenu/>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
<w4india:titleandnav title="ITR Schedule 10A/10AA"/>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:link var="siLink" siteMapItemRefId="itr-ded-schedule-10a"></hst:link>
<h4>ITR-Schedule 10A/10AA</h4>
<fieldset>
	<legend>Schedule 10A/10AA</legend>
	<strong>Click on</strong>
	<div class="btn-group">
		<button type="button" class="btn btn-default btn-warning dropdown-toggle" data-toggle="dropdown">
			Deduction Schedule-10A/10AA in special economic zone<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li> <a href="${scriptName}/itrdedschedule10anew" id="newchild"><i class="glyphicon glyphicon-plus-sign"></i><strong>Add</strong></a>
			    <%-- <a href="./itrdedschedule10a.html/itrdedschedule10anew" id="newchild"><i class="glyphicon glyphicon-plus-sign"></i><strong>Add</strong></a>--%>    
			</li>
		</ul>
	</div>&nbsp;<strong>to add new Schedule 10A/10AA(Undertaking Amount)!!</strong>
</fieldset>
<table class="table table-hover table-striped table-bordered">
</br>
	<caption>
		<strong>Detailed of Deductions Schedule 10A/10AA</strong>
	</caption>
	<thead>
		<tr>
			<th>#</th>
			<th>Schedule 10A/10AA</th>
			<th>Undertaking Gross Amount</th>
			<th align="center"><div class="col-md-1">Action</div></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty parentBean.scheduleTenADetailList}">
			<c:forEach items="${parentBean.scheduleTenADetailList}" var="schedule10ADetail" varStatus="ct">
				<tr class="warning">
					<td><c:out value="${ct.count}"/></td>
					<td><c:out value="Schedule-${fn:toUpperCase(schedule10ADetail.scheduleName)}"/></td>
					<td><w4india:inr value="${schedule10ADetail.amount}"/></td>
					<td align="center"><div class="rowlabel">
							<a href="${scriptName}/${schedule10ADetail.canonicalUUID}/itrdedschedule10aedit"
								class="btn btn-default btn-primary"><i class="glyphicon glyphicon-edit glyphicon glyphicon-white"></i><span><strong>Edit</strong></span></a>&nbsp;
							<a href="${scriptName}/${schedule10ADetail.canonicalUUID}/itrdedschedule10adelete" data-confirm=""
							class="btn btn-default btn-danger"><i class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i><span><strong>Delete</strong></span></a>
						</div></td>
				</tr>
			</c:forEach>
		</c:if>
		<tr class="success">
			<td colspan="2"><b>Total</b></td>

			<td><c:if test="${not empty parentBean.scheduleTenADetailList}">
					<c:set value="sumGross" var="0" />
					<c:forEach items="${parentBean.scheduleTenADetailList}" var="schedule10ADetail">
						<c:set value="${sumGross + schedule10ADetail.amount}" var="sumGross" />
					</c:forEach>
				</c:if><b><w4india:inr value="${sumGross}" /></b></td>
			<td></td>
		</tr>
	</tbody>
</table>
<c:set var="sectionData">
	<fieldset>
		<legend>Schedule 10A/10AA</legend>
		<div class="row show-grid">
			<div class="col-md-8">
				<div class="rowlabel">
					<label for="scheduleName"><small>Select Schedule Name</small></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleTenADetailList}" var="schedule10ADetail">
							<c:if test="${schedule10ADetail.canonicalUUID == uuid}">
								<c:set value="${schedule10ADetail.scheduleName}" var="editschedule10A" />
							</c:if>
						</c:forEach>
					</c:if>
					<select name="scheduleName" class="select-drop head" id="scheduleName">
						<option value="">-Select-</option>
							<option value="10a" <c:if test="${pageAction == 'EDIT_CHILD' && '10a' == editschedule10A}">selected</c:if>>
								Schedule10A
							</option>
							<option value="10aa" <c:if test="${pageAction == 'EDIT_CHILD' && '10aa' == editschedule10A}">selected</c:if>>
								Schedule10AA
							</option>							
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="amount"><abbr title="Gross Amount of Undertakings for selected schedule"><small>Gross Amount</small></abbr></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleTenADetailList}" var="schedule10ADetail">
							<c:if test="${schedule10ADetail.canonicalUUID == uuid}">
								<c:set value="${schedule10ADetail.amount}" var="editAmount" />
							</c:if>
						</c:forEach>
					</c:if>
					<input id="amount" name="amount" class="<c:if test="${pageAction == 'NEW_CHILD'}">hide</c:if>" placeholder="Gross Amount" value="${editAmount}" type="text" maxlength="14"/>
				</div>
			</div>
		</div>
	</fieldset>
</c:set>
<c:set var="modalBody"><form id="schedule10A" name="schedule10A" action="${actionUrl}" method="post"><c:out value="${sectionData}" escapeXml="false"/></form></c:set>
<c:if test="${pageAction == 'NEW_CHILD'||pageAction == 'EDIT_CHILD'}">
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Deduction Schedule 10A Panel</h4>
				</div>
				<div class="modal-body">
				    <div class="alert alert-info"><strong>Deductions in respect of units located in Special Economic Zone.</strong></div>
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="row_0" var="formID" />
						</c:when>
						<c:otherwise>
							<c:set value="schedule10A" var="formID" />
						</c:otherwise>
					</c:choose>
					<form id="${formID}" name="schedule10A" class="schedule10AForm" action="${actionUrl}" method="post">
						<div class="schedule10Abody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<c:if test="${pageAction == 'NEW_CHILD'}"><a href="#" class="btn btn-default btn-inverse" id="addnew">Add New</a></c:if>
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/itrdedschedule10adelete" class="btn btn-default btn-danger">
                              <i class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</a>
					</c:if>
					<a href="${scriptName}" class="btn btn-default" data-dismiss="">Close</a>
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="ajaxsubmit" var="saveID" />
						</c:when>
						<c:otherwise>
							<c:set value="siSave" var="saveID" />
						</c:otherwise>
					</c:choose>
					<a href="#" id="${saveID}" class="btn btn-default btn-primary">Save changes</a>
				</div>
			</div>
		</div>
	</div>
</c:if>
</div>
</div>

<c:set var="progress"><div class="progress progress-striped active"><div class="bar" style="width: 0%;"></div></div></c:set>
<c:set var="addNewAlert"><div class="alert alert-success">Schedule SI section has been saved.Now Add New.</div></c:set>
<res:client-validation screenConfigurationDocumentName="itrschedulesi" formId="schedule10A" formSubmitButtonId="siSave"></res:client-validation>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    $('document').ready(function(){
      if ($("#myModal").length >0) $("#myModal").modal();
      
      $('#siSave').on('click',function(){
         $('#schedule10A').submit();
      });
      
      $('.select-drop').on('change',function(){
	     if($(this).val()!=null){
		     $('#amount').show();
	     } 
      });
      $('#schedulesiSection').on('change', function(){
        if($('#schedulesiSection').val()== '1'){
            $('#spRates').show();
            $('#addnew').hide();
         }else{
            $('#spRates').hide();
            $('#addnew').show();      
         }
      });
      $('#ajaxsubmit').on('click',function(){
      allForms=$('.schedule10AForm');
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
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.schedule10AForm').last();
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
						
						var newdiv1 = $('<form class="schedule10AForm" name="schedule10A"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
						//alert(html);
						newdiv1.append(html);
						
						$(".modal-body").append(newdiv1);
						
						newdiv1.find(".col-md-4").hide();
						
						//$(".theamount").blur( handleBlur );	
						$(".head").change(headChangeHandler);
						
						$(".head").change( function(o) {
							changeD(this);
							}
						);					
						
						$('.schedule10AForm input').keydown(function(e) {
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
					$(this).parents(".row").find(".col-md-4").hide();
					$('label[for="amount"]').hide();
				}
				else {
					$(this).parents(".row").find(".col-md-4").show();
					$('label[for="amount"]').show();
				}
			}       
			function formValidate(formID){
			 $('#'+formID).validate({
				rules: {
					scheduleName: {
						required: true,
					},
					amount: {
						required: true
					}
				},
				messages: {
					scheduleName: "This field is required.",
					amount: "This field is required."
				}
			  });
			}
        });
   
  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
<!-- <fieldset> <legend>test</legend> <div class="row show-grid"> <div class="rowlabel col-md-6"><select name="test-select" class="select-drop" id="test-select"> <option value="">Select</option> <option value="section-89">Section-89</option> </select> </div> <div class="rowlabel col-md-4"> <input id="amount" name="amount" class="hide" placeholder="Gross Amount" type="text"> </div> </div> </fieldset> 
-->