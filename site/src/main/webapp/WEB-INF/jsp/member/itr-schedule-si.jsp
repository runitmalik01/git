<%@include file="../includes/tags.jspf" %>

<%-- String ipAddress = request.getHeader("X-FORWARDED-FOR");  
 if (ipAddress == null) {  
	   ipAddress = request.getRemoteAddr();  
} pageContext.setAttribute("ipAddress", ipAddress);--%>
<c:set var="ScheduleSI">
 ITR Schedule SI
</c:set>
<hippo-gogreen:title title="${ScheduleSI}" />
<hst:actionURL var="actionUrl"></hst:actionURL> 
<w4india:itrmenu/>
<c:out value="${ipAddress}"/>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:link var="siLink" siteMapItemRefId="itr-schedule-si"></hst:link>
<h4>ITR-Schedule SI</h4>
<fieldset>
	<legend>Schedule SI</legend>
	<strong>Click on</strong>
	<div class="btn-group">
		<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
			Income chargeable to Income tax at special rates IB<span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="${scriptName}/itrschedulesinew" id="newchild"><i class="icon-plus-sign"></i><strong>Add</strong></a></li>
		</ul>
	</div>&nbsp;<strong>to add new Schedule SI section!!</strong>
</fieldset>
<table class="table table-hover table-striped table-bordered">
	  <caption><strong>Detailed of Schedule SI sections</strong></caption>
		<thead>
			<tr>
				<th>#</th>
				<th>Schedule SI Section Name</th>
				<th><abbr title="Rates described by Income Tax Department">Special Rate (%)</abbr></th>
				<th>Gross Income</th>
				<th><abbr title="Gross Amount after apply rates.">Eligible Amount</abbr></th>
				<th align="center"><div class="span1">Action</div></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty parentBean.scheduleSiDetailList}">
				<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail" varStatus="ct">
					<tr class="warning">
						<td><c:out value="${ct.count}"/></td>
						<td><c:forEach var="si" items="${scheduleSIList}">
								<c:if test="${scheduleSiDetail.schedulesiSection == si.xmlCode}">
									<c:out value="${si.displayName}" />
								</c:if>
							</c:forEach>
						</td>
						<td><c:out value="${scheduleSiDetail.specialRate}" /></td>
						<td><w4india:inr value="${scheduleSiDetail.amount}"/></td>
						<td><w4india:inr value="${scheduleSiDetail.calcRateIncome}" /></td>
						<td align="center"><div class="span1"><a href="${scriptName}/${scheduleSiDetail.canonicalUUID}/itrschedulesiedit"
							class="btn btn-primary"><i class="icon-edit icon-white"></i><span><strong>Edit</strong></span></a>&nbsp;
							<%-- <a href="${scriptName}/${scheduleSiDetail.canonicalUUID}/itrschedulesidelete" data-confirm=""
							class="btn btn-danger"><i class="icon-trash icon-white"></i><span><strong>Delete</strong></span></a>--%>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr class="success">
			   <td colspan="3"><b>Total</b></td>
			   
			   <td align="right" style="text-align:right"><c:if test="${not empty parentBean.scheduleSiDetailList}">
			   <c:set value="sumGross" var="0"/>
				<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail">
				  <c:set value="${sumGross + scheduleSiDetail.amount}" var="sumGross"/>
				</c:forEach></c:if><b><w4india:inr value="${sumGross}"/></b></td>
				
			   <td align="right" style="text-align:right"><c:if test="${not empty parentBean.scheduleSiDetailList}">
			   <c:set value="eligSum" var="0"/>
				<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail">
				  <c:set value="${eligSum + scheduleSiDetail.calcRateIncome}" var="eligSum"/>
				</c:forEach></c:if><b><w4india:inr value="${eligSum}"/></b></td>
				
				<td></td>
			</tr>
		</tbody>
	</table>
<c:set var="sectionData">
	<fieldset>
		<legend>Schedule SI</legend>
		<div class="row-fluid show-grid">
			<div class="span8">
				<div class="rowlabel">
					<label for="schedulesiSection"><small>Schedule SI Section</small></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail">
							<c:if test="${scheduleSiDetail.canonicalUUID == uuid}">
								<c:set value="${scheduleSiDetail.schedulesiSection}" var="editscheduleSI" />
							</c:if>
						</c:forEach>
					</c:if>
					<select name="schedulesiSection" class="select-drop head" id="schedulesiSection">
						<option value="">-Select-</option>
						<c:forEach var="si" items="${scheduleSIList}">
							<option value="${si.xmlCode}" <c:if test="${pageAction == 'EDIT_CHILD' && si.xmlCode == editscheduleSI}">selected</c:if>>
								<c:out value="${si.displayName}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="amount"><small>Gross Amount</small></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail">
							<c:if test="${scheduleSiDetail.canonicalUUID == uuid}">
								<c:set value="${scheduleSiDetail.amount}" var="editAmount" />
							</c:if>
						</c:forEach>
					</c:if>
					<input id="amount" name="amount" class="<c:if test="${pageAction == 'NEW_CHILD'}">hide</c:if>" placeholder="Gross Amount" value="${editAmount}" type="text" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid hide" id="spRates">
			<div class="span6">
				<div class="rowlabel">
					<label for="specialRate"><abbr
						title="Rates described by Income Tax Department"><small>Special
								Rate (%)</small></abbr></label>
				</div>
				<div class="rowlabel">
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<c:forEach items="${parentBean.scheduleSiDetailList}" var="scheduleSiDetail">
							<c:if test="${scheduleSiDetail.canonicalUUID == uuid && scheduleSiDetail.schedulesiSection == '1'}">
								<c:set value="${scheduleSiDetail.specialRate}" var="spRate" />
							</c:if>
						</c:forEach>
					</c:if>
					<select name="specialRate" id="specialRate">
						<c:forEach var="si" items="${scheduleSIList}">
							<c:if test="${si.xmlCode eq '1'}">
								<c:forEach var="rt" items="${si.percentRate}">
									<option value="${rt}" <c:if test="${pageAction == 'EDIT_CHILD' && spRate eq rt}">selected</c:if>>
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
<c:set var="modalBody"><form id="scheduleSI" name="scheduleSI" action="${actionUrl}" method="post"><c:out value="${sectionData}" escapeXml="false"/></form></c:set>
<c:if test="${pageAction == 'NEW_CHILD'||pageAction == 'EDIT_CHILD'}">
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
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
					<form id="${formID}" name="scheduleSI" class="scheduleSIForm" action="${actionUrl}" method="post">
						<div class="scheduleSIbody">
							<c:out value="${sectionData}" escapeXml="false"></c:out>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<c:if test="${pageAction == 'NEW_CHILD'}"><a href="#" class="btn btn-inverse" id="addnew">Add New</a></c:if>
					<c:if test="${pageAction == 'EDIT_CHILD'}">
						<a href="${scriptName}/${uuid}/itrschedulesidelete" class="btn btn-danger">
                              <i class="icon-trash icon-white"></i>Delete</a>
					</c:if>
					<a href="${scriptName}" class="btn" data-dismiss="">Close</a>
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

<c:set var="progress"><div class="progress progress-striped active"><div class="bar" style="width: 0%;"></div></div></c:set>
<c:set var="addNewAlert"><div class="alert alert-success">Schedule SI section has been saved.Now Add New.</div></c:set>
<res:client-validation screenConfigurationDocumentName="itrschedulesi" formId="scheduleSI" formSubmitButtonId="siSave"></res:client-validation>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    $('document').ready(function(){
      if ($("#myModal").length >0) $("#myModal").modal();
      
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
						window.location.href = '<c:out value="${scriptName}"/>';
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
						
						var newdiv1 = $('<form class="scheduleSIForm" name="scheduleSI"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
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
					$(this).parents(".row-fluid").find(".span4").hide();
					$('label[for="amount"]').hide();
				}
				else {
					$(this).parents(".row-fluid").find(".span4").show();
					$('label[for="amount"]').show();
				}
			}       
			function formValidate(formID){
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
				}
			  });
			}
        });
   
  });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
<!-- <fieldset> <legend>test</legend> <div class="row-fluid show-grid"> <div class="rowlabel span6"><select name="test-select" class="select-drop" id="test-select"> <option value="">Select</option> <option value="section-89">Section-89</option> </select> </div> <div class="rowlabel span4"> <input id="amount" name="amount" class="hide" placeholder="Gross Amount" type="text"> </div> </div> </fieldset> 
-->