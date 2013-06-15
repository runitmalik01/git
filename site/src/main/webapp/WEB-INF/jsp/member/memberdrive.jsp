<%@include file="../includes/tags.jspf"%>
 <style>
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
   height :64px;
   width :64px;
   background: url(http://icons.iconarchive.com/icons/vargas21/aquave-metal/48/Document-icon.png) no-repeat;
}
#upload-file-container input {
   filter: alpha(opacity=0);
   opacity: 0;
}
</style>
<c:set var="startapplication">
	<fmt:message key="member.start.application" />
</c:set>
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
	<form id="memberdrive" action="${actionUrl}" method="post" name="memberdrive">
	<fieldset>
		<legend>Upload Your Document to File Income Tax Return
			${memberpersonalinformnation.financialYear}</legend>
		   <!-- <div class="row-fluid show-grid">
		       <div class="span6">
					<div class="rowlabel">
                       <div id="progressbar"><div class="progress-label"></div></div>
					</div>
			   </div>
		    </div>-->
		    <div class="row-fluid show-grid">
			   <div class="span6">
					<div class="rowlabel">			            
			             <!--   <div class="input-prepend">
			                  <span class="add-on"><i class="icon-file"></i></span>-->
			             <div id="upload-file-container">
			                 <input type="file" id="member_file" name="member_file" title="Select a File to Upload in Member Drive" size="10"/>			              
			             </div>
			             <div id="member_file_name"></div>
				   </div>
			</div>
			</div>
		    <div class="row-fluid show-grid">
			   <div class="span6">
					<div class="rowlabel">
                        <span class="add-on"><i class="icon-folder-open"></i></span><div class="file_name">
                        <c:forEach items="${fileNames}" var="filename">
                           <c:out value="${filename}"/>
                        </c:forEach></div>
				   </div>
			   </div>
		    </div>
		    <div class="row-fluid show-grid">
				 <div class="span2 offset10">
					<!--  <a href="#" id="upload" class="orange button">Upload File</a>-->
					<input type="Submit" name="Submit" value="Upload File"/>
				 </div>
		    </div>
	</fieldset>
</form>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){
		$('#member_file').bind('change', function(){
		    $('#member_file_name').text(this.files[0].name);
          });
		 /* $('#upload').click(function(){
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
		      $.ajax({
						url:'<c:out value="${ajaxLinkToComponent}"/>?command=upload',
						data: 'data='+reqFromJson,
						//data :$('#memberdrive').serialize(),
						datatype:'text',
						success: function(data,textStatus,jqXhr) {							
								//change the response
								$('.file_name').text(jqXhr.getResponseHeader("myfileheader"));
					      }
			       });
           var progressbar = $( "#progressbar" ),
           progressLabel = $( ".progress-label" );
           progressbar.progressbar({
              value: false,
              change: function(){
              progressLabel.text( progressbar.progressbar("value" ) + "%" );
               },
           complete: function(){
                         progressLabel.text( "Complete!" );                   
                   }
           });
          function progress(){
              var val = progressbar.progressbar( "value" ) || 0;
              progressbar.progressbar( "value", val + 1 );
              if( val < 99 ){
                setTimeout(progress, 100 );
               }
            }
            setTimeout(progress, 3000 );
              });*/
		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />

