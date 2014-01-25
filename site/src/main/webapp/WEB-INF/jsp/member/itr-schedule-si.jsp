<%@include file="../includes/tags.jspf"%>

<%-- String ipAddress = request.getHeader("X-FORWARDED-FOR");  
 if (ipAddress == null) {  
	   ipAddress = request.getRemoteAddr();  
} pageContext.setAttribute("ipAddress", ipAddress);--%>
<c:set var="ScheduleSI">
Schedule SI
</c:set>
<hippo-gogreen:title title="${ScheduleSI}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<w4india:itrmenu />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:link var="siLink" siteMapItemRefId="itr-schedule-si"></hst:link>

<div class="page-header">
	<h2 class="title page-title">Income Tax at Special Rates</h2>
	<h4>
		<small>Schedule SI&nbsp;-&nbsp;Income that is taxable at a
			flat rate as perscribed by the Income Tax Department and not under
			slab rate. For Eg. Income from Long and Short Etrm Capital gains,
			Winning from Lotteries, crosswords puzzles and races.</small>
	</h4>
</div>
<fieldset>
	<legend class="header-color">
		<small>Enter Details</small>
	</legend>
	<strong>Click on</strong>
	<div class="btn-group">
		<button type="button"
			class="btn btn-default btn-warning dropdown-toggle"
			data-toggle="dropdown">
			Income chargeable to Income tax at special rates IB<span
				class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="${scriptName}/itrschedulesinew" id="newchild"><i
					class="glyphicon glyphicon-plus-sign"></i><strong>Add</strong></a></li>
		</ul>
	</div>
	&nbsp;<strong>to add new Schedule SI section!!</strong>
</fieldset>
<table class="table table-hover table-striped">
	<caption>
		<strong>Detailed of Schedule SI sections</strong>
	</caption>
	<thead>
		<tr>
			<th>#</th>
			<th>Schedule SI Section Name</th>
			<th><abbr title="Rates described by Income Tax Department">Special
					Rate (%)</abbr></th>
			<th>Gross Income</th>
			<th><abbr title="Gross Amount after apply rates.">Eligible
					Amount</abbr></th>
			<th align="center"><div class="col-md-1">Action</div></th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty parentBean.scheduleSiDetailList}">
			<c:forEach items="${parentBean.scheduleSiDetailList}"
				var="scheduleSiDetail" varStatus="ct">
				<c:forEach var="si" items="${scheduleSIList}">
					<c:if test="${scheduleSiDetail.schedulesiSection ==  si.xmlCode}">
						<tr class="warning">
							<td><c:out value="${ct.count}" /></td>
							<td><c:out value="${si.displayName}" /></td>
							<td><c:out value="${scheduleSiDetail.specialRate}" /></td>
							<td><w4india:inr value="${scheduleSiDetail.amount}" /></td>
							<td><w4india:inr value="${scheduleSiDetail.calcRateIncome}" /></td>
							<td><a
								href="${scriptName}/${scheduleSiDetail.canonicalUUID}/itrschedulesiedit"
								class="btn btn-default btn-primary btn-sm"><i
									class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i><span><strong>Edit</strong></span></a>&nbsp;
								<a
								href="${scriptName}/${scheduleSiDetail.canonicalUUID}/itrschedulesidelete"
								data-confirm="" class="btn btn-default btn-danger btn-sm"> <i
									class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i><span><strong>Delete</strong></span></a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</c:if>
		<tr class="success">
			<td colspan="3"><b>Total</b></td>

			<td><c:if test="${not empty parentBean.scheduleSiDetailList}">
					<c:set value="sumGross" var="0" />
					<c:forEach items="${parentBean.scheduleSiDetailList}"
						var="scheduleSiDetail">
						<c:forEach var="si" items="${scheduleSIList}">
							<c:if test="${scheduleSiDetail.schedulesiSection ==  si.xmlCode}">
								<c:set value="${sumGross + scheduleSiDetail.amount}"
									var="sumGross" />
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:if><b><w4india:inr value="${sumGross}" /></b></td>

			<td><c:if test="${not empty parentBean.scheduleSiDetailList}">
					<c:set value="eligSum" var="0" />
					<c:forEach items="${parentBean.scheduleSiDetailList}"
						var="scheduleSiDetail">
						<c:forEach var="si" items="${scheduleSIList}">
							<c:if test="${scheduleSiDetail.schedulesiSection ==  si.xmlCode}">
								<c:set value="${eligSum + scheduleSiDetail.calcRateIncome}"
									var="eligSum" />
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:if><b><w4india:inr value="${eligSum}" /></b></td>

			<td></td>
		</tr>
	</tbody>
</table>
<c:set var="sectionData">
	<fieldset>
		<legend>Schedule SI</legend>
		<div class="row show-grid">
			<div class="col-md-8">
				<div class="rowlabel">
					<label for="schedulesiSection"><small>Schedule SI
							Section*</small></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}"
							var="scheduleSiDetail">
							<c:if test="${scheduleSiDetail.canonicalUUID == uuid}">
								<c:set value="${scheduleSiDetail.schedulesiSection}"
									var="editscheduleSI" />
							</c:if>
						</c:forEach>
					</c:if>
					<select name="schedulesiSection" class="select-drop head"
						id="schedulesiSection">
						<option value="">-Select-</option>
						<c:forEach var="si" items="${scheduleSIList}">
							<option value="${si.xmlCode}"
								<c:if test="${pageAction == 'EDIT_CHILD' && si.xmlCode == editscheduleSI}">selected</c:if>>
								<c:out value="${si.displayName}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="amount"><small>Gross Amount*</small></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}"
							var="scheduleSiDetail">
							<c:if test="${scheduleSiDetail.canonicalUUID == uuid}">
								<c:set value="${scheduleSiDetail.amount}" var="editAmount" />
							</c:if>
						</c:forEach>
					</c:if>
					<input id="amount" name="amount"
						class="<c:if test="${pageAction == 'NEW_CHILD'}">hide</c:if>"
						placeholder="Gross Amount" value="${editAmount}" type="text"
						maxlength="14" />
				</div>
			</div>
		</div>
		<div class="row show-grid hide" id="spRates">
			<div class="col-md-6">
				<div class="rowlabel">
					<label for="specialRate"><abbr
						title="Rates described by Income Tax Department"><small>Special
								Rate (%)</small></abbr></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}"
							var="scheduleSiDetail">
							<c:if
								test="${scheduleSiDetail.canonicalUUID == uuid && scheduleSiDetail.schedulesiSection == '1'}">
								<c:set value="${scheduleSiDetail.specialRate}" var="spRate" />
							</c:if>
						</c:forEach>
					</c:if>
					<select name="specialRate" id="specialRate">
						<c:forEach var="si" items="${scheduleSIList}">
							<c:if test="${si.xmlCode eq '1'}">
								<c:forEach var="rt" items="${si.percentRate}">
									<option value="${rt}"
										<c:if test="${pageAction == 'EDIT_CHILD' && spRate eq rt}">selected</c:if>>
										<c:out value="${rt}" />
									</option>
								</c:forEach>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</fieldset>
</c:set>
<c:set var="modalBody">
	<form id="scheduleSI" name="scheduleSI" action="${actionUrl}"
		method="post">
		<c:out value="${sectionData}" escapeXml="false" />
	</form>
</c:set>
<c:if test="${pageAction == 'NEW_CHILD'||pageAction == 'EDIT_CHILD'}">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Schedule SI</h4>
				</div>
				<div class="modal-body">
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="row_0" var="formID" />
						</c:when>
						<c:otherwise>
							<c:set value="scheduleSI" var="formID" />
						</c:otherwise>
					</c:choose>
					<form id="${formID}" name="scheduleSI" class="scheduleSIForm"
						action="${actionUrl}" method="post">
						<div class="scheduleSIbody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<c:if test="${pageAction == 'NEW_CHILD'}">
						<a href="#" class="btn btn-default btn-inverse btn-sm btn-info"
							id="addnew">Add New</a>
					</c:if>
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/itrschedulesidelete"
							class="btn btn-default btn-danger btn-sm"> <i
							class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete
						</a>
					</c:if>
					<a href="${scriptName}" class="btn btn-default btn-sm btn-danger"
						data-dismiss="">Close</a>
					<c:choose>
						<c:when test="${pageAction == 'NEW_CHILD'}">
							<c:set value="ajaxsubmit" var="saveID" />
						</c:when>
						<c:otherwise>
							<c:set value="siSave" var="saveID" />
						</c:otherwise>
					</c:choose>
					<a href="#" id="${saveID}"
						class="btn btn-default btn-success btn-sm">Save</a>
				</div>
			</div>
		</div>
	</div>
</c:if>

<c:set var="progress">
	<div class="progress progress-striped active">
		<div class="bar" style="width: 0%;"></div>
	</div>
</c:set>
<c:set var="addNewAlert">
	<div class="alert alert-success">Schedule SI section has been
		saved.Now Add New.</div>
</c:set>
<res:client-validation screenConfigurationDocumentName="itrschedulesi"
	formId="scheduleSI" formSubmitButtonId="siSave"></res:client-validation>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
    $('document').ready(function(){
      if ($("#myModal").length >0) $("#myModal").modal();
      
      $('#siSave').on('click',function(){
         $('#scheduleSI').submit();
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
      allForms=$('.scheduleSIForm');
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
				$.ajax('<hst:actionURL></hst:actionURL>',
						{
						'data': theData,
						'method':'POST',
						'async':false											
					  }).done (function () {
					   
						window.location.href = <c:choose>
		<c:when test="${pageAction == 'NEW_CHILD'}"> '<c:out
				value="${scriptName}" />'</c:when>
		<c:otherwise>'../../servicerequest-itr-summary.html'</c:otherwise>
	</c:choose>;
					});
		}
      
      });
      
      $('#addnew').on('click', function(){
            var rehtml=$('.modal-body').html();
            arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
			theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.scheduleSIForm').last();
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
						
						var newdiv1 = $('<form class="scheduleSIForm" name="scheduleSI"
		id="row_' +  (parseInt(theindx) + 1)  + '" />');
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
						
						$('.scheduleSIForm input').keydown(function(e) {
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
        });
        function formValidate(formID){
          var inValid = true;
			 $('#'+formID).validate({
				rules: {
					schedulesiSection: {
						required: true,
					},
					amount: {
						required: true
					}
				},
				messages: {
					schedulesiSection: "This field is required.",
					amount: "This field is required."
				},
				success:  inValid = false
				
			  });
			  return inValid;
			}
    $('a[data-confirm]').click(function(ev) {
        var href = $(this).attr('href');

        if (!$('#dataConfirmModal').length) {
            $('body').append('<div id="dataConfirmModal" class="modal"
		role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="dataConfirmLabel">Please Confirm</h3>
		</div>
		<div class="modal-body"></div>
		<div class="modal-footer">
			<button class="btn btn-default" data-dismiss="modal"
				aria-hidden="true">Cancel</button>
			<a class="btn btn-default btn-primary" id="dataConfirmOK">OK</a>
		</div>
	</div>');
        }
        $('#dataConfirmModal').find('.modal-body').text("Are you sure you want to delete?");
        $('#dataConfirmOK').attr('href', href);
        $('#dataConfirmModal').modal({show:true});
        return false;
    });
  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<!-- <fieldset> <legend>test</legend> <div class="row show-grid"> <div class="rowlabel col-md-6"><select name="test-select" class="select-drop" id="test-select"> <option value="">Select</option> <option value="section-89">Section-89</option> </select> </div> <div class="rowlabel col-md-4"> <input id="amount" name="amount" class="hide" placeholder="Gross Amount" type="text"> </div> </div> </fieldset> 
-->