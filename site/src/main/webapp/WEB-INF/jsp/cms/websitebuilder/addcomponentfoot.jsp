<%@include file="../../includes/tags.jspf"%>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" />
<hst:link var="vendorhomelink" siteMapItemRefId="vendoritreturnhome" />
<hst:link var="pageslink" siteMapItemRefId="pages" />
<br/>
<div class="row">
	<div class="col-md-3 col-md-offset-3">
		<div class="input-group bk">
			<input type="text" class="form-control input-sm" name="bkcomponentName" id="bkcomponentName" title="Name of Block Component"
				placeholder="Add New Block Component"><label for="email" class="error" generated="false"></label>
			<div class="input-group-btn">
				<a href="${websitebuilderlink}/blocks.html/newblock" class="btn btn-success btn-sm" id="bkaddcomponent"><i
					class="glyphicon glyphicon-plus-sign"></i><strong>ADD Block</strong></a>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="input-group pg">
			<input type="text" class="form-control input-sm" name="pgcomponentName" id="pgcomponentName"
				title="Name of Page Component" placeholder="Add New Page Component"><label for="email" class="error" generated="false"></label>
			<div class="input-group-btn">
				<a href="${websitebuilderlink}/pagess.html/newpage" class="btn btn-success btn-sm" id="pgaddcomponent"><i
					class="glyphicon glyphicon-plus-sign"></i><strong>ADD Page</strong></a>
			</div>
		</div>
	</div>
	<div class="col-md-3 col-md-offset-3"></div>
</div>
<br/>
<script type="text/javascript">
$('document').ready(function(){
    $('#bkaddcomponent').on('click',function(){
    	if($('#bkcomponentName').val() == '' ){ //&& !($('#componentName').val().match('^([A-Za-Z]/s)+$'))
    		$('div.bk').addClass('has-error');
    		$('#bkaddcomponent').attr('href','#');
    	}else{
    		$('div.bk').removeClass('has-error');
    		var hrefVal = '<c:out value="${websitebuilderlink}"/>'+'/blocks.html/newblock';
    		$('#bkaddcomponent').attr('href',hrefVal+'/'+$('#bkcomponentName').val());
    	}
    });
    $('#pgaddcomponent').on('click',function(){
    	if($('#pgcomponentName').val() == '' ){//&& !($('#componentName').val().match('^([A-Za-Z]/s)+$'))
    		$('div.pg').addClass('has-error');
    		$('#pgaddcomponent').attr('href','#');
    	}else{
    		$('div.pg').removeClass('has-error');
    		var hrefVal = '<c:out value="${websitebuilderlink}"/>'+'/pages.html/newpage';
    		$('#pgaddcomponent').attr('href',hrefVal+'/'+$('#pgcomponentName').val());
    	}
    });
});
</script>