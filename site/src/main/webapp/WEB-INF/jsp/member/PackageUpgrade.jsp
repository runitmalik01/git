
<%--
@author Dhananjay Panwar
05/04/2014
 --%>

<%@include file="../includes/tags.jspf"%>     
 
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
     <div class="modal-content">
        <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
           <h4 class="modal-title">Upgrade your package</h4>
        </div>
        <div class="modal-body">
        <div class="row">
          <c:choose>
             <c:when test="${not empty listOfCostModel}">
                <c:forEach items="${listOfCostModel}" var="costModel">               
                   <div class="col-md-4 ">
                      <div class="well">
                        <% Boolean hasAValidMatch = false; %>
                          <c:if test="${not empty mapForCostModelName}">
                            <c:forEach items="${mapForCostModelName}" var="resultMap">
                              <c:if test = "${costModel.offeringMode eq resultMap.key}">
                                <h4 align="center"><c:out value="${resultMap.value}"/></h4>
                                <% hasAValidMatch = true;%>
                              </c:if>
                            </c:forEach>
                         </c:if>
                       <% if(!hasAValidMatch){ %>
                        <h4 align="center"><c:out value ="${costModel.offeringMode}"/></h4>
                       <%} %>                  
                      <hr>
                      <small><i class="glyphicon glyphicon-rupee">&#8377;</i></small>&nbsp;
                      <strong><c:out value ="${costModel.cost}"/></strong>
                      <hr>             
                      <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-success" id="${costModel.offeringMode}">
                          <input type="radio" id="${costModel.offeringMode}" name="offeringMode" class="offeringMode" value="${costModel.offeringMode}"> Upgrade
                       </label>
                      </div>                     
                      </div>
                   </div>
                </c:forEach>
             </c:when>
             <c:otherwise>
                No package available
             </c:otherwise>
          </c:choose>
          </div>
       </div>
     </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal --> 
<input type="hidden" id="packageValue" name="packageValue" value=""/>

<script type="text/javascript">
	
	 $(document).ready(function(){
		 
		 $('.offeringMode').click(function() {
				 $('#reviewFrm').submit();
		});
		$('#signupForm input').keydown(function(e) {
		    if (e.keyCode == 13) {
		   		e.preventDefault();
		        $('#reviewFrm').submit();
		    }
		});
		
	 var savedServiceDelivery = '<c:out value="${selectedITRServiceDelivery}"/>';
	 if(savedServiceDelivery != ''){
	   $("#"+savedServiceDelivery).addClass("disabled");
	 }
		$('.offeringMode').click(function(){
			var offModeVal = '';
		$(".offeringMode:checked").each(function(){
			   offModeVal = $(this).val();
			});
		alert("1"+offModeVal);
		  $("#packageValue").val(offModeVal);
		});
		 
	 });
	 
</script>
