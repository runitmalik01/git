<%@page import="java.net.URLEncoder"%>
<%@page import="com.mootly.wcm.components.ITReturnComponentHelper"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="digital-signature"></hst:link>
<hippo-gogreen:title title="Member Drive" />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<%StringBuilder builder=new StringBuilder();
builder.append(request.getScheme() + "://" +  request.getServerName()).append(":").append(request.getServerPort());
HstRequest hstRequest = (HstRequest) request;
ITReturnComponentHelper componentHelper = new ITReturnComponentHelper();
if(componentHelper.isReSeller(hstRequest)){
	if(componentHelper.getResellerId(hstRequest) != null){
		builder.append("/r/").append(componentHelper.getResellerId(hstRequest));
	}
}
pageContext.setAttribute("hostname", builder.toString());
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:componentRenderingURL var="ajaxLinkToComponent"></hst:componentRenderingURL>
<w4india:itrmenu/>
<div class="row">
		<w4india:itrsidebar/>
		<div class="${sideBarMainClass}">
			<w4india:titleandnav title="Digital Signature"/>
			<h4>Please note that your Digital Signature must be in compliance with the Department of Income Tax. For more details read the <a href="https://incometaxindiaefiling.gov.in/#DCQ10" target="_new">FAQs</a></h4>
			<form id="memberdrive" action="${actionUrl}" method="post" name="memberdrive" enctype="multipart/form-data">
			<fieldset>
				<legend>Upload your Digital Signature for FY:${memberpersonalinformation.financialYear}</legend>
				   <!--  <div class="row show-grid">
				       <div class="col-md-6">
							<div class="rowlabel">
		                       <div id="progressbar"><div class="progress-label"></div></div>
							</div>
					   </div>
				    </div>-->
				<c:if test="${not empty srDocument}">
				   <div class="alert alert-info">
				      Upload your documents to fulfill service request for service <b><c:out value="${fn:toUpperCase(srDocument.name)}"/></b>.
				      <p>All Documents are required* shown in description list of Document.Please select the appropriate document description while upload.</p>  
				   </div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="row show-grid">
						<div class="alert alert-success">Your have successfully
							uploaded file in Member Drive.</div>
					</div>
				</c:if>
				<c:if test="${not empty delete}">
					<div class="row show-grid">
						<div class="alert alert-info">File has been deleted from Member Drive</div>
					</div>
				</c:if>
				<div class="row show-grid">
					    <div class="col-md-3">			                     
					         <div class="rowlabel">
					               <label for="description"><small>Type (Optional)</small></label>
					         </div>
					         <div class="rowlabel">
					                 <select name="description" id="description" class="col-md-8">
					                      <option value="Digital Signature">Digital Signature</option>
					                 </select>
					          </div>				    				   		
					   </div>		
					   <div class="col-md-2">
							<div class="rowlabel">			            
					                  <label for="member_file"><small>File (required)</small></label>
					        </div>
					        <div class="rowlabel">
					                  <span class="btn btn-default btn-success fileinput-button" id="remove">
		                                <i class="glyphicon glyphicon-plus glyphicon glyphicon-white"></i>
		                                <span>Attach</span>
		                                <input type="file" id="member_file" name="member_file"/>
		                             </span>
					             <div id="member_file_name"></div>
					        </div>
					    </div>
						<div class="col-md-3">
							<div class="rowlabel">
							 <label for="protected"><small><abbr title="If Uploading Document is password protected then please provide password">Document Password</abbr></small></label>				 
							</div>
							<div class="rowlabel">
							  <input id="protected" name="protected" type="password"/>
							</div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel">
							 <label for="protected"><small><abbr title="If you want to share any additional notes">Additional Notes</abbr></small></label>				 
							</div>
							<div class="rowlabel">
							  <textarea id="additionalnotes" name="additionalnotes"></textarea>
							</div>
						</div>
						<div class="col-md-2">
					         <div class="rowlabel">
					              <label for="startupload"><small>Click</small></label>
					         </div>
						    <div class="rowlabel">
							 <a href="#" id="upload" class="btn btn-default btn-primary start">
							    <i class="glyphicon glyphicon-upload glyphicon glyphicon-white"></i>
		                        <span>Upload</span></a>
							 </div>
						 </div>
				</div>
			</fieldset>
			<fieldset>
				<legend>Your digital signature</legend>
				<div class="row show-grid hide" id="file_process">
				      <div class="well">
				         <div class="col-md-8">
						     <div class="rowlabel">
				   		        <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
		                           <div class="bar" style="width: 0%;"></div>
		                        </div>
		                     </div>
		                </div>
						 <div class="col-md-4">
						     <div class="rowlabel">
		                        <a id="cancel" class="btn btn-default btn-warning cancel">
		                          <i class="glyphicon glyphicon-ban-circle glyphicon glyphicon-white"></i>
		                          <span>Cancel upload</span>
		                        </a>
		                     </div>
						 </div>
					  </div>
					</div>
				    <div class="row show-grid">
		                   <div class="file_name">
		                        <table class="table table-hover table-bordered">
		                           <thead>
		                               <tr>
		                                  <th>File Name</th>
		                                  <th>Subject DN</th>
		                                  <th>Issuer DN</th>
		                                  <th>Valid From</th>
		                                  <th>Valid To</th>
		                                  <th align="center">Action</th>
		                               </tr>
		                           </thead>
		                           <tbody>
		                           	  <c:if test="${not empty memberdrivedocument}">
		                           	  		<tr>
		                           	  			<td><c:out value="${memberdrivedocument.memberFileName}"></c:out></td>
		                           	  			<td><c:out value="${memberdrivedocument.certificateSubjectDN}"></c:out></td>
		                           	  			<td><c:out value="${memberdrivedocument.certificateIssuerDN}"></c:out></td>
		                           	  			<td>
			                           	  			<jsp:useBean id="certificateGetNotBefore" class="java.util.Date" />
													<jsp:setProperty name="certificateGetNotBefore" property="time" value="${memberdrivedocument.certificateGetNotBefore}" />
													<fmt:formatDate value="${certificateGetNotBefore}" />
												</td>
												<td>
			                           	  			<jsp:useBean id="certificateGetNotAfter" class="java.util.Date" />
													<jsp:setProperty name="certificateGetNotAfter" property="time" value="${memberdrivedocument.certificateGetNotAfter}" />
													<fmt:formatDate value="${certificateGetNotAfter}" />
												</td>
												<td>
													<hst:link var="assetLink" hippobean="${memberdrivedocument}"/>
													<c:set value="${hostname}${assetLink}" var="doc_url" scope="page"/>
				                                      <a href="${scriptName}?delete=${memberdrivedocument.canonicalUUID}" id="deletefile" class="btn btn-default btn-danger" data-confirm="">
				                                      <i class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i><span>Delete</span></a>
												</td>
												<td></td>
		                           	  		</tr>	
		                           	  </c:if>
		                            </tbody>
		                           </table>
		                      </div>
				      </div>
			</fieldset>
		</form>
	</div>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		$('#member_file').bind('change', function(){
		    $('#member_file_name').text(this.files[0].name);
		    //$('#file_process').show();		    
          });
		$('#member_file').popover({"html":true,
		                 "trigger":"hover",
		                 delay: { show: 500, hide: 100 },
		                 content:"Select a File to Upload in Member Drive or Drag Here"
		  });
		  $('#descrption').popover({"html":true,
		                 "trigger":"hover",
		                 delay: { show: 500, hide: 100 },
		                 content:"Select a description of File or write Your own"
		  });
		  var myVar=null;var i=10;
		  
          $('#upload').click(uploadDoc);
          var control = $('#member_file');
          $('#cancel').click(function(){
            clearInterval(myVar);
            $('.bar').css({"width" :'0%'});
            i=10;
            $('#file_process').hide();
            $('#memberdrive').reset();
            $('#remove').html($('#remove').html());
          });
          $('#description').change(function(){
              if($(this).val()=='Others'){
                $('.hide_'+$(this).val()+'_inp').show();
                $('.hide_'+$(this).val()+'_sel').hide();
                }
              else {
                   $('.hide_'+$(this).val()+'_inp').hide();
                   $('.hide_'+$(this).val()+'_sel').show();
                   } 
          });
		 });
		 
		 function uploadDoc(){
		    $('#memberdrive').submit();
		    /*
             myVar=setInterval(function(){
               if(i<=100){
                $('.bar').css({"width" :i+'%'});
                 i=i+10;
               }else{
                  clearInterval(myVar);
                  $('#memberdrive').submit();
                 } 
             },200);
             */
          }
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/jquery.fileupload-ui.css"/>" type="text/css" />
</hst:headContribution>
<res:client-validation formId="memberdrive" formSubmitButtonId="upload" screenConfigurationDocumentName="digitalsignature"></res:client-validation>