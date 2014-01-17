
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
		          Congratulations !!!!! Your account has been created successfully.
		        <h2 style="color:green">We would like to thank you for choosing our service.</h2>
		        <p><strong><span style="color:#AC1700;">IMPORTANT: </span>Please check your email</strong></p>
	            <ol style="margin-bottom:30px; margin-top:20px; width:90%;">
	            <li style="font-size:14px; line-height:16px; margin-bottom:10px;"> An Activation Email will be there shortly. If you do not receive it, please contact  
	            <a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.</li>
	            <li style="font-size:14px; line-height:16px; margin-bottom:10px;"><strong>Click the given Link.</strong></li>
	            <li style="font-size:14px; line-height:16px; margin-bottom:10px;"><strong>Start Enjoying you signed up for.</strong></li>
	            <li style="font-size:14px; line-height:16px; margin-bottom:10px;"><strong>If you do not receive an Email within 24 hrs, please check your bulk folder,</strong> or contact <a href="mailto:<w4india:emailcustomerservice/>"><w4india:emailcustomerservice/></a>.</li>
	            </ol>
	             <h3>Thank You</h3>
		     </c:when>
		   <c:otherwise>
		     <div class="alert alert-info">
		      Your account is just one step away from being fully activated. The last little step to finishing the registration. Please fill in your details to activate your account.
		     </div>
	  <fieldset class="well">
		     <div class="row show-grid" >
		        <div class="col-md-4">
		            <div class="rowlabel">
		 	            <label for="emailCustomerService">
		                <small>Email Customer Service (required)</small>
		                </label>
		           </div>
		           <div class="rowlabel">
		              <input name="emailCustomerService" id="emailCustomerService" value="${fn:escapeXml(emailCustomerService)}" size="22" tabindex="1" type="text" maxlength="50">
		           </div>
		        </div>   
		    <div class="col-md-4">
		        <div class="rowlabel">
		 	        <label for="emailFrom">
		            <small>Email From (required)</small>
		            </label>
		        </div>
		        <div class="rowlabel">
		            <input name="emailFrom" id="emailFrom" value="${fn:escapeXml(emailFrom)}" size="22" tabindex="2" type="text" maxlength="50">
		        </div>
		   </div>    
		   <div class="col-md-4">
		        <div class="rowlabel">
		 	       <label for="emailFromName">
		           <small>Email From Name (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">
		           <input name="emailFromName" id="emailFromName" value="" size="22" tabindex="3" type="text" maxlength="50">
		        </div>
		  </div>
		  </div> 
		  <div class="row show-grid" >
		        <div class="col-md-4">
		            <div class="rowlabel">
				     <label for="emailSignature">
		             <small>Email Signature (required)</small>
		             </label>
		             </div>
		          <div class="rowlabel">
		            <input name="emailSignature" id="emailSignature" value="" size="22" tabindex="4" type="text" maxlength="50">
		          </div>
		      </div>
		      <div class="col-md-4">
		            <div class="rowlabel">	   
				       <label for="eriEnable26ASImport ">
		               <small>Eri Enable 26AS Import  (required)</small>
		               </label>
		            </div> 
		            <div class="rowlabel">   
		               <select id= "eriEnable26ASImport" name="eriEnable26ASImport" tabindex="5">
							<option value="">-Select-</option>
							<option value="true">Yes</option>
							<option value="false">No</option>
			          </select>   
		          </div>
		    </div>
		    <div class="col-md-4">
		        <div class="rowlabel">	
		 	       <label for="eriEnabled">
		           <small>Eri Enabled (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">
		            <select id= "eriEnabled" name="eriEnabled" tabindex="6">
						<option value="">-Select-</option>
						<option value="true">Yes</option>
						<option value="false">No</option>
				    </select>
				</div>
		   </div>
		   </div>
	</fieldset>
	<fieldset class="well">
		   <div class="row show-grid" >
		     <div class="col-md-4">
		        <div class="rowlabel">	
			       <label for="eriPassword">
		           <small>Eri Password (required)</small>
		           </label>
		        </div>
		        <div class="rowlabel">	
		           <input name="eriPassword" id="eriPassword" value="" size="22" tabindex="7" type="password" maxlength="20">
		       </div>
		   </div>
		   	<div class="col-md-4">
		       <div class="rowlabel">	 
		   	      <label for="eriUserId">
		          <small>Eri UserId (required)</small>
		          </label>
		       </div>
		       <div class="rowlabel">	
		           <input name="eriUserId" id="eriUserId" value="${fn:escapeXml(eriUserId)}" size="22" tabindex="8" type="text" maxlength="20">
		       </div>
		    </div>
		     <div class="col-md-4">
		            <div class="rowlabel">
		   	            <label for="resellerName">
		                <small>Reseller Name (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		                <input name="resellerName" id="resellerName" value="${fn:escapeXml(resellerName)}" size="22" tabindex="9" type="text" maxlength="20">
		            </div>
		        </div>
		    <!-- 
		    <div class="col-md-4">
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
				 -->
	   </div>
	   <div class="row show-grid" >
		        <div class="col-md-4">
		            <div class="rowlabel">	
		   	            <label for="pageTitlePrefix">
		                <small>Page Title Prefix (required)</small>
		                </label>
		            </div>
		            <div class="rowlabel">
		               <input name="pageTitlePrefix" id="pageTitlePrefix" value="${fn:escapeXml(pageTitlePrefix)}" size="22" tabindex="10" type="text" maxlength="50">
		            </div>
		        </div>
		        <div class="col-md-4">
		            <div class="rowlabel">	
		   	           <label for="paymentAvailableTypes">
		               <small>Payment Available Types (required)</small>
		               </label>
		            </div>
		            <div class="rowlabel">	
		               <select id= "paymentAvailableTypes" name="paymentAvailableTypes" multiple="multiple" tabindex="11">
						     <option value="CASH">Cash</option>
						     <option value="RTGS">RTGS</option>
						     <option value="CREDIT">Credit</option>
			       	   </select>
		          </div>
		       </div>
		       <div class="col-md-4">
		            <div class="rowlabel">
		 	           <label for="paymentEnabled">
		               <small>Payment Enabled (required)</small>
		               </label>
		             </div>
		             <div class="rowlabel">
		                <select id= "paymentEnabled" name="paymentEnabled" tabindex="12">
						     <option value="">-Select-</option>
						     <option value="true">Yes</option>
						     <option value="false">No</option>
				       </select>
				    </div>
		       </div>
		 </div>
 </fieldset>
	      <div class="row show-grid">
			  <div class="col-md-4 col-md-offset-8 decimal">
		   		  <a href="javascript:void(0);" id="hrefSignup" class="btn btn-default btn-warning" tabindex="13">Submit</a>
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