<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>
<hst:actionURL var="actionUrl"></hst:actionURL>
  <fieldset>
  	  <legend>Deduction Detail</legend>
	  <div class="row-fluid show-grid">
	       <div class="span8">
	        	<div class="rowlabel"><label for="ack_no"><small>Deduction Head</small></label></div>
	        	<div class="rowlabel selectdropdown">
	        		<c:choose>
						<c:when test="${not empty deductionSection.listOfDeductionHead}">
							<select name="head" width="100%" class="head">
								<c:if test="${pageAction == 'NEW_CHILD'}">
									<option value="">Select category/Click on Save when done</option>
								</c:if>
								<c:forEach items="${deductionSection.listOfDeductionHead}" var="deductionHead">	
									<option <c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && not empty editingSection && editingSection.head == deductionHead.name}">selected="selected"</c:if> value="<c:out value="${deductionHead.name}"/>"><c:out value="${deductionHead.label}"/></option>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
							<span>Enter investment under <c:out value="${deductionSection.label}"/></span>
							<c:choose>
								<c:when test="${pageAction == 'EDIT_CHILD'}">
									<input type="hidden" name="head" value="<c:out value="${childBean.section}"/>"/>
								</c:when>
								<c:otherwise>
									<input type="hidden" name="head" value="<c:out value="${deductionSection.name}"/>"/>
								</c:otherwise>
							</c:choose>							
						</c:otherwise>
					</c:choose>	
	        	</div>
	       </div>
	       <div class="span4">
				<div class="rowlabel"><label for="investment"><small><abbr title="Enter the gross amount. We will calculate the eligible amount">Gross Amount</abbr></small></label></div>
	       		<div class="rowlabel"><input class="theamount" name="investment" type="text" placeholder="Gross Investment" value="<c:out value="${childBean.investment}"/>"></div>
	       </div>
		</div>	     
	</fieldset>     
	
	<script>
		<c:if test="${pageAction == 'NEW_CHILD' && not empty deductionSection.listOfDeductionHead}">
			jQuery(document).ready(function($) {
				$("#addNewBtn").click( handleBlur );			
				$("#addNewBtn").show();	
			});
			
			function handleBlur() {
				arrClass = $(this).parent('.modal-footer').siblings('.modal-body');
				theForm = $(this).parent('.modal-footer').siblings('.modal-body').find('.frmDeduction');
				var theId  = theForm.attr('id');
				if (theId.indexOf("row_") != -1) {
					theindx = theId.split("_")[1];
					//check if row_1 exists
					var eDiv =  $("#row_" + theindx);
					var theNewDiv =  $("#row_" + (parseInt(theindx) + 1));
					if (theNewDiv.length == 0) {
						//insertDiv
						html = eDiv.html();
						//<div class="row-fluid show-grid" id="row_0">
						//<form id="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}">frmDeduction</c:when><c:otherwise>row_0</c:otherwise></c:choose>" method="post" name="frmDeduction" action="${submitDeduction}" class="frmDeduction">
						var newdiv1 = $('<form class="frmDeduction" name="frmDeduction"  id="row_' +  (parseInt(theindx) + 1)  + '"/>');
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
						
						
						$('.frmDeduction input').keydown(function(e) {
						    if (e.keyCode == 13) {
						   		e.preventDefault();
						        //$('#frmdata').submit();
						    }
						});
						//alert(html);
					}
				}
			}
			
			$(".head").change(headChangeHandler);
			
			function headChangeHandler() {
				var o = $(this).val();	
				if (o.trim() == '') {
					//hide and remove the corresponding amount button
					$(this).parents(".row-fluid").find(".span4").hide();
					$('label[for="investment"]').hide();
				}
				else {
					$(this).parents(".row-fluid").find(".span4").show();
					$('label[for="investment"]').show();
				}
			}
			
		</c:if>
	
	</script>       