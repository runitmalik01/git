<%--

 This for forgot activation code
 @author abhishek
 12/03/2013
 --%>
<%@include file="../includes/tags.jspf"%>
<c:set var="activecodetitle"><fmt:message key="member.activecode.title"/></c:set>
<hippo-gogreen:title title="${activecodetitle}"/>
<hst:actionURL var="activationcode"></hst:actionURL>

<div class="page">
		<form action="${activationcode}" method="post" id="formActivation">
			<fieldset>
	             <legend>
	                <h4>Recover your activation code here</h4>
			        <h5><small>Oops! Lost your activation mail. Enter your registered email address for getting your activation code.</small></h5>
			     </legend>
			     
			     <c:if test="${not empty success}">
	                 <div class="alert alert-info">
			         An email has been sent to your email address. Please check your email to activate your account.
	                 </div>
	            </c:if>
	
	           <c:if test="${not empty emailError}">
	               <div class="alert alert-danger">
			       <fmt:message key="${emailError}" />
	               </div>
	          </c:if>
	
	          <c:if test="${not empty emailRegistered}">
	             <div class="alert alert-danger">
			     <fmt:message key="${emailRegistered}" />
	             </div>
	         </c:if>
	         
	             <div class="row show-grid">
				 	  <div class="col-md-2">
					 	  <label for="email">
					         Enter your Email Address
					       </label>
				       </div>
				       <div class="col-md-6">
				           <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${fn:escapeXml(email)}"/>
						   </div>
				      </div>
				   	  <div class="col-md-4">
				     	<a href="javascript:void(0);" id="hrefActivation" class="btn btn-default btn-success">Get Activation Code</a>
					  </div>
			    </div>
		  </fieldset>
	  </form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefActivation').click(function() {
 				 $('#formActivation').submit();
			});
			$('#formActivation input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#formActivation').submit();
			    }
			});
			$('#formActivation').validate({
				rules: {
					email: {
						required: true,
						minlength: 2,
						email:true
					}
				},				
				messages: {
					email: "Please enter a valid email address."
				}
			});
			
			
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
