<%@include file="../includes/tags.jspf"%>
 <style type="text/css">
.ui-progressbar {
	position: relative;
}
.progress-label {
	position: absolute;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow: 1px 1px 0 #fff;
}
#upload-file-container {
	height: 64px;
	width: 64px;
	background:
		url(http://icons.iconarchive.com/icons/vargas21/aquave-metal/48/Document-icon.png)
		no-repeat;
}
#upload-file-container input {
	filter: alpha(opacity = 0);
	opacity: 0;
}
</style>
<c:set var="startapplication">
	<fmt:message key="member.start.application" />
</c:set>
<hst:link var="memberDriveComp" siteMapItemRefId="docattach"></hst:link>
<hippo-gogreen:title title="${ startapplication}" />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:componentRenderingURL var="ajaxLinkToComponent"></hst:componentRenderingURL>
<w4india:itrmenu/>
	<h4>Member Drive</h4>
	<form id="memberdrive" action="${actionUrl}" method="post" name="memberdrive" enctype="multipart/form-data">
	<fieldset>
		<legend>Upload Your Document to File Income Tax Return
			${memberpersonalinformation.financialYear}</legend>
		   <!--  <div class="row-fluid show-grid">
		       <div class="span6">
					<div class="rowlabel">
                       <div id="progressbar"><div class="progress-label"></div></div>
					</div>
			   </div>
		    </div>
		    <div class="progress progress-striped active">
               <div class="bar" style="width: 50%;"></div>
             </div>-->
		<c:if test="${not empty msg}">
			<div class="row-fluid show-grid">
				<div class="alert alert-success">Your have Successfully
					Uploaded File in Member Drive.</div>
			</div>
		</c:if>
		<div class="row-fluid show-grid">
			   <div class="span6">
					<div class="rowlabel">			            
			             <!--   <div class="input-prepend">
			                  <span class="add-on"><i class="icon-file"></i></span>-->
			                  <label for="member_file"><small>Select Document To Upload</small></label>
			             <div id="upload-file-container" class="rowlabel">
			                   <input type="file" id="member_file" name="member_file"/>			              
			             </div>
			             <div id="member_file_name"></div>
			          </div>
			    </div>
			    <div class="span6">			                     
			         <div class="rowlabel">
			               <label for="description"><small>Description</small></label>
			         </div>
			         <div class="rowlabel">
			                 <select name="description" id="description" class="span8 hide_Others_sel">
			                       <option value="Income">Income Document</option>
			                       <option value="Insurance">Insurance Document</option>
			                       <option value="Others">Write Your Own</option>
			                 </select>
			                 <input type="text" name="description" id="description" class="hide_Others_inp span7 btn" style="display: none;" data-provide="typeahead"/>
			          </div>				    				   		
			    </div>
			</div>
			<div class="row-fluid show-grid">
				 <div class="span2 offset10">
					 <a href="#" id="upload" class="btn orange">Upload File</a>
					<!-- <input type="Submit" name="Submit" value="Upload File"/>-->
				 </div>
		    </div>
		    <div class="row-fluid show-grid">
                   <div class="file_name">
                        <table class="table table-hover table-bordered">
                           <thead>
                               <tr>
                                  <th>#</th>
                                  <th>Document Name</th>
                                  <th>Description</th>
                                  <th align="center">Action</th>
                                  <th>Last Uploaded</th>
                               </tr>
                           </thead>
                           <tbody>
                             <c:forEach var="file" items="${memberFiles}">
                               <tr>
                                  <td><span class="add-on"><i class="icon-file"></i></span></td>
                        	     <hst:link var="assetLink" hippobean="${file.memberFileResource}"/>
                                  <td><c:out value="${file.name}"/></td> 
                                  <td></td>
                                  <td>
                                      <a href="#" class="btn btn-info">View</a>
                                      <a href="${assetLink}" class="btn btn-primary">Download</a>
                                      <a href="${scriptName}?delete=${file.canonicalUUID}" id="deletefile"  class="btn btn-danger">Delete</a>                                  
                                  </td>
                                   <!--  <a href="https://www.docs.google.com/viewer?url=www.wealth4india.com${assetLink}">View</a> :--> 
                                   <td><fmt:formatDate value="${file.memberFileResource.lastModified.time}" type="date" pattern="MMM d, yyyy"/></td>
                               </tr>
                              </c:forEach>
                            </tbody>
                           </table>
                      </div>
		      </div>
		      	
		<div id="dialog-confirm" title="Confirm To Delete" style="display: none;">
			<p>
				<span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
				Are you sure want to Delete this Document?
			</p>
		</div>
	</fieldset>
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
          $('#upload').click(function(){
            $('#memberdrive').submit();
          });
          $('#deletefile').click(function(){
            var resp=confirm("Do you want to delete it ?");
	          if(resp) return true;
	          else return false;
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
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />


