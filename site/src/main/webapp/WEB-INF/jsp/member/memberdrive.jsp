<%@page import="java.net.URLEncoder"%>
<%@page import="com.mootly.wcm.components.ITReturnComponentHelper"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="docattach"></hst:link>
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
	<h4>Member Drive</h4>
	<form id="memberdrive" action="${actionUrl}" method="post" name="memberdrive" enctype="multipart/form-data">
	<c:if test="${memberpersonalinformation.selectedITRForm=='ITR2'}">
		<fieldset>
			<legend>Need help on what to upload? Download these sample templates to help you report your Income Tax Data</legend>
			<div class="row show-grid">
				<div class="col-md-12">
					 <div class="rowlabel">
					    <label for="sample"><small><abbr title="Download this sample template and provide information for capital gain and other">Capital Gain Document Template</abbr></small></label>				 
					 </div>
					 <div class="rowlabel">
					    <c:forEach items="${sampleDocList}" var="sampleDoc">
					        <hst:link var="sampledoclink" hippobean="${sampleDoc.memberFileResource}"/>				    
					        <a href="${sampledoclink}" class="btn btn-default btn-inverse"><i class="glyphicon glyphicon-download-alt glyphicon glyphicon-white"></i><span>Download</span></a>
					    </c:forEach>
					 </div>
			 	 </div>
			</div>
		</fieldset>
	</c:if>
	<fieldset>
		<legend>Upload your Income Tax documents for FY:${memberpersonalinformation.financialYear}</legend>
		   <!--  <div class="row show-grid">
		       <div class="col-md-6">
					<div class="rowlabel">
                       <div id="progressbar"><div class="progress-label"></div></div>
					</div>
			   </div>
		    </div>-->
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
			                      <option value="">-Select-</option>
			                      <optgroup label="Income from Salary">
			                      <c:forEach items="${valueList.valueListDocumentDetailList}" var="listItem" varStatus="status">
			                         <c:if test="${fn:containsIgnoreCase(fn:trim(listItem.key),'Income from Salary')}">			                               
			                                 <option value="<c:out value="${listItem.label}"/>"><c:out value="${listItem.label}"/></option>
			                          </c:if>
			                      </c:forEach>
			                      </optgroup>
			                      <optgroup label="Income From House Property">
			                      <c:forEach items="${valueList.valueListDocumentDetailList}" var="listItem" varStatus="status">
			                         <c:if test="${fn:containsIgnoreCase(fn:trim(listItem.key),'Income From House Property')}">			                               
			                                 <option value="<c:out value="${listItem.label}"/>"><c:out value="${listItem.label}"/></option>
			                          </c:if>
			                      </c:forEach>
			                      </optgroup>
			                      <optgroup label="Other Sources Details">
			                      <c:forEach items="${valueList.valueListDocumentDetailList}" var="listItem" varStatus="status">
			                         <c:if test="${fn:containsIgnoreCase(fn:trim(listItem.key),'Other Sources Details')}">			                               
			                                 <option value="<c:out value="${listItem.label}"/>"><c:out value="${listItem.label}"/></option>
			                          </c:if>
			                      </c:forEach>
			                      </optgroup>
			                      <optgroup label="Investment details">
			                      <c:forEach items="${valueList.valueListDocumentDetailList}" var="listItem" varStatus="status">
			                         <c:if test="${fn:containsIgnoreCase(fn:trim(listItem.key),'Investment details')}">			                               
			                                 <option value="<c:out value="${listItem.label}"/>"><c:out value="${listItem.label}"/></option>
			                          </c:if>
			                      </c:forEach>
			                      </optgroup>
			                      <optgroup label="Others">
			                      <c:forEach items="${valueList.valueListDocumentDetailList}" var="listItem" varStatus="status">
			                         <c:if test="${fn:containsIgnoreCase(fn:trim(listItem.key),'Others')}">			                               
			                                 <option value="<c:out value="${listItem.label}"/>"><c:out value="${listItem.label}"/></option>
			                          </c:if>
			                      </c:forEach>
			                      </optgroup>
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
		<legend>Your documents for Financial Year:${memberpersonalinformation.financialYear}</legend>
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
                                  <th>#</th>
                                  <th>Document Name</th>
                                  <th>Type</th>
                                  <th align="center">Action</th>
                                  <th>Last Uploaded</th>
                               </tr>
                           </thead>
                           <tbody>
                             <c:forEach var="file" items="${memberFiles}">
                               <tr>
                                  <td><span class="add-on"><i class="glyphicon glyphicon-file"></i></span></td>
                        	     <hst:link var="assetLink" hippobean="${file.memberFileResource}"/>
                                  <td><c:out value="${file.name}"/></td> 
                                  <td>${file.description}</td>
                                  <td><c:set value="${hostname}${assetLink}" var="doc_url" scope="page"/>                                      
                                      <a href="https://www.docs.google.com/viewer?url=<%=URLEncoder.encode((String)pageContext.getAttribute("doc_url"),"UTF-8")%>" class="btn btn-default btn-info"> 
                                      <i class="glyphicon glyphicon-eye-open glyphicon glyphicon-white"></i><span>View</span></a>
                                      <a href="${assetLink}" class="btn btn-default btn-primary">
                                      <i class="glyphicon glyphicon-download-alt glyphicon glyphicon-white"></i><span>Download</span></a>
                                      <a href="${scriptName}?delete=${file.canonicalUUID}" id="deletefile" class="btn btn-default btn-danger" data-confirm="">
                                      <i class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i><span>Delete</span></a>                                   
                                  </td>
                                  <td><fmt:formatDate value="${file.memberFileResource.lastModified.time}" type="date" pattern="MMM d, yyyy"/></td>
                               </tr>
                              </c:forEach>
                            </tbody>
                           </table>
                      </div>
		      </div>
		      	
		<div id="dialog-confirm" title="Confirm To Delete" style="display: none;">
			<p>
				<span class="ui-icon ui-glyphicon glyphicon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
				Are you sure want to Delete this Document?
			</p>
		</div>
	</fieldset>
	<%--
	<c:if test="${fn:length(memberFiles) > 0}">
		<div class="row show-grid">
			<div class="col-md-3 col-md-offset-9">
				 <a href="servicerequest-itr-payment.html" id="upload" class="btn btn-default btn-inverse start"><i class="glyphicon glyphicon-arrow-right glyphicon glyphicon-white"></i><span>Proceed</span></a>
			</div>
		</div>
	</c:if>
	 --%>
</form>
<script type="text/javascript">
  $('#delete').click(function(){
	   $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        width:300,
        modal: true,
        draggable: false,
        buttons: {
            "Delete": function confirm() {
            	return true;
                $( this ).dialog( "close" );              
               },
        Cancel: function() {
                 $( this ).dialog( "close" );
          }
        }
     });     
  });
</script>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		$('#member_file').bind('change', function(){
		    $('#member_file_name').text(this.files[0].name);
		    $('#file_process').show();		    
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
          /*$('#upload').click(function(){
		  var ConvertFormToJSON=function(){
						     var array = jQuery('form').serializeArray();
						     var json = {};
						     jQuery.each(array, function(){
						         json[this.name] = this.value || '';
							 });
						     return json;
						     };
						     var form=$('#memberdrive').serialize();
						     alert("this "+form);
                       var reqFromJson=JSON.stringify(ConvertFormToJSON());
                       alert("request"+JSON.stringify(ConvertFormToJSON()));
		      $.ajax({url:'<c:out value="${ajaxLinkToComponent}"/>?command=upload',
						data: 'data='+reqFromJson,
						//data :$('#memberdrive').serialize(),
						datatype:'text',
						success: function(data,textStatus,jqXhr) {							
								//change the response
								$('.file_name').text(jqXhr.getResponseHeader("myfileheader"));
					      }
			       });
			 });*/
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
<res:client-validation formId="memberdrive" formSubmitButtonId="upload" screenConfigurationDocumentName="memberdrive"></res:client-validation>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/jquery.fileupload-ui.css"/>" type="text/css" />
</hst:headContribution>