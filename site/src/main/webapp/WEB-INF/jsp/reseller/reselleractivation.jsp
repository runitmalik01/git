
<%@include file="../includes/tags.jspf" %>
<c:set var="activationtitle"><fmt:message key="member.activation.title"/></c:set>
<hippo-gogreen:title title="${activationtitle}"/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page">
		<form action="${actionUrl}" method="post" id="signupForm">
		     <c:choose>
		        <c:when test="${not empty isError}">
		            <h3><fmt:message key="${errorCode}"/></h3><br/>
	            </c:when>
		        <c:when test="${not empty success}">
		           <div class="alert alert-info">Congratulations !!!!! You have Successfully Signup
		           <h2 style="color:green">We would like to thank you for choosing our service.</h2>
		      </div>
		     </c:when>
		     <c:otherwise>
		     <div class="alert alert-info">
		      Your account is just one step away from being fully activated. The last little step to finishing the registration. Please fill in your details to activate your account.
		     </div>
	  <fieldset class="well">
		     <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">
		 	            <label for="emailCustomerService">
		                <small>Email Customer Service (required)</small>
		                </label>
		           </div>
		           <div class="rowlabel">
		              <input name="emailCustomerService" id="emailCustomerService" value="${fn:escapeXml(emailCustomerService)}" size="22" tabindex="1" type="text" maxlength="50">
		           </div>
		        </div>   
		    <div class="span4">
		        <div class="rowlabel">
		 	        <label for="emailFrom">
		            <small>Email From (required)</small>
		            </label>
		        </div>
		        <div class="rowlabel">
		            <input name="emailFrom" id="emailFrom" value="${fn:escapeXml(emailFrom)}" size="22" tabindex="1" type="text" maxlength="50">
		        </div>
		   </div>    
		   <div class="span4">
		        <div class="rowlabel">
		 	       <label for="emailFromName">
		           <small>Email From Name (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">
		           <input name="emailFromName" id="emailFromName" value="" size="22" tabindex="2" type="text" maxlength="50">
		        </div>
		  </div>
		  </div> 
		  <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">
				     <label for="emailSignature">
		             <small>Email Signature (required)</small>
		             </label>
		             </div>
		          <div class="rowlabel">
		            <input name="emailSignature" id="emailSignature" value="" size="22" tabindex="3" type="text" maxlength="50">
		          </div>
		      </div>
		   </div>
	</fieldset>
	 <fieldset class="well">
		     <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">	   
				       <label for="eriEnable26ASImport ">
		               <small>Eri Enable 26AS Import  (required)</small>
		               </label>
		            </div> 
		           <div class="rowlabel">   
		               <select id= "eriEnable26ASImport" name="eriEnable26ASImport">
							<option value="">-Select-</option>
							<option value="true">Yes</option>
							<option value="false">No</option>
			          </select>   
		          </div>
		    </div>
		    <div class="span4">
		        <div class="rowlabel">	
		 	       <label for="eriEnabled">
		           <small>Eri Enabled (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">
		            <select id= "eriEnabled" name="eriEnabled">
						<option value="">-Select-</option>
						<option value="true">Yes</option>
						<option value="false">No</option>
				    </select>
				</div>
		   </div>
		    <div class="span4">
		        <div class="rowlabel">	
			       <label for="eriPassword">
		           <small>Eri Password (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">	
		           <input name="eriPassword" id="eriPassword" value="" size="22" tabindex="3" type="password" maxlength="20">
		       </div>
		   </div>
	   </div>
	   <div class="row-fluid show-grid" >
	       <div class="span4">
		       <div class="rowlabel">	 
		   	      <label for="eriUserId">
		          <small>Eri UserId (required)</small>
		          </label>
		       </div>
		       <div class="rowlabel">	
		           <input name="eriUserId" id="eriUserId" value="${fn:escapeXml(eriUserId)}" size="22" tabindex="1" type="text" maxlength="20">
		       </div>
		    </div>
		 </div>
 </fieldset>
 <fieldset class="well">
		   <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">	
		 	            <label for="isReseller">
		                <small>Is Reseller (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		               <select id= "isReseller" name="isReseller">
						    <option value="">-Select-</option>
						    <option value="true">Yes</option>
						    <option value="false">No</option>
				      </select>
				    </div>
				</div>
		        <div class="span4">
		            <div class="rowlabel">	
		   	            <label for="pageTitlePrefix">
		                <small>Page Title Prefix (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		               <input name="pageTitlePrefix" id="pageTitlePrefix" value="${fn:escapeXml(pageTitlePrefix)}" size="22" tabindex="1" type="text" maxlength="50">
		            </div>
		        </div>
		        <div class="span4">
		            <div class="rowlabel">	
		   	           <label for="paymentAvailableTypes">
		               <small>Payment Available Types (required)</small>
		               </label>
		            </div>
		            <div class="rowlabel">	
		               <select id= "paymentAvailableTypes" name="paymentAvailableTypes" multiple="multiple">
						     <option value="CASH">Cash</option>
						     <option value="RTGS">RTGS</option>
						     <option value="CREDIT">Credit</option>
			       	   </select>
		          </div>
		       </div>
		   </div>
		  <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">
		 	           <label for="paymentEnabled">
		               <small>Payment Enabled (required)</small>
		               </label>
		             </div>
		             <div class="rowlabel">
		                <select id= "paymentEnabled" name="paymentEnabled">
						     <option value="">-Select-</option>
						     <option value="true">Yes</option>
						     <option value="false">No</option>
				       </select>
				    </div>
		       </div>
		   </div>
   </fieldset>
   <fieldset class="well">
		     <div class="row-fluid show-grid" >
		        <div class="span4">
		            <div class="rowlabel">
		   	            <label for="resellerName">
		                <small>Reseller Name (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		                <input name="resellerName" id="resellerName" value="${fn:escapeXml(resellerName)}" size="22" tabindex="1" type="text" maxlength="20">
		            </div>
		        </div>
		    </div>
    </fieldset>
  
	      <div class="row-fluid show-grid">
			  <div class="span4 offset8 decimal">
		   		  <a href="javascript:void(0);" id="hrefSignup" class="orange button">Activate your account</a>
		      </div>
		  </div>
		 
		 </c:otherwise>
		 </c:choose>
		</form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefSignup').click(function() {
 				 $('#signupForm').submit();
			});
			$('#signupForm input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#signupForm').submit();
			    }
			});
			$('#signupForm').validate({
				rules: {
					emailCustomerService: {
						required: true,
						minlength: 2,
						email:true
					},
					emailFrom: {
						required: true,
						minlength: 2,
						email:true
					},
					emailFromName: {
						required: true,
						minlength: 2
					},
					emailSignature: {
						required: true,
						minlength: 2
					},
					eriEnable26ASImport: {
						required: true
					},
					eriEnabled:{
					required: true
					},
					eriPassword:{
					required: true,
					minlength: 2
					},
					eriUserId:{
					required: true,
					minlength: 2
					},
					isReseller:{
					required: true
					},
					pageTitlePrefix:{
					required: true,
					minlength: 2
					},
					paymentAvailableTypes:{
					required: true
					},
					paymentEnabled:{
					required: true
					},
					resellerName:{
					required: true,
					minlength: 2
					}
				},
				messages: {
					emailCustomerService: "Please enter a valid email address.",
					emailFrom: "Please enter a valid email address.",
					emailFromName: "This field is required.",
					emailSignature: "This field is required.",
					eriEnable26ASImport: "This field is required.",
					eriEnabled: "This field is required.",
					eriPassword: "This field is required.",
					eriUserId: "This field is required.",
					isReseller: "This field is required.",
					pageTitlePrefix: "This field is required.",
					paymentAvailableTypes: "This field is required.",
					paymentEnabled: "This field is required.",
					resellerName: "This field is required."
				}
			});
		});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>