<%@include file="../../includes/tags.jspf"%>
<link rel="stylesheet" href="css/metro-bootstrap.css">
<hippo-gogreen:title title="Website Builder"></hippo-gogreen:title>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder" /><br/>
<div class="alert alert-info">
	<h4>Welcome To WebsiteBuilder Panel</h4>
</div>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="well well-sm">
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<img src="http://placehold.it/380x500" alt=""
							class="img-rounded img-responsive" />
					</div>
					<div class="col-sm-6 col-md-8">
						<h4>${resellerInfo.resellerName}</h4>
						<small><cite title="San Francisco, USA">San
								Francisco, USA <i class="glyphicon glyphicon-map-marker"> </i>
						</cite></small>
						<p>
							<i class="glyphicon glyphicon-envelope"></i>&nbsp;${resellerInfo.emailCustomerService } <br />
							<i class="glyphicon glyphicon-globe"></i><a
								href="http://www.jquery2dotnet.com">www.jquery2dotnet.com</a> <br />
							<i class="glyphicon glyphicon-gift"></i>${resellerInfo.startDate}
						</p>
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-primary">Social</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">
								<span class="caret"></span><span class="sr-only">Social</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Twitter</a></li>
								<li><a href="https://plus.google.com/+Jquery2dotnet/posts">Google
										+</a></li>
								<li><a href="https://www.facebook.com/jquery2dotnet">Facebook</a></li>
								<li class="divider"></li>
								<li><a href="#">Github</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <!-- <img data-src="http://placehold.it/380x500" alt="fu"> -->
      <div class="caption">
        <h4><strong>Page Components</strong></h4>
        <p>Capability to create WebPages for your WebSite.</p>
        <p><a href="${websitebuilderlink}/pages.html" class="btn btn-info" role="button"><span class="btn-label"><i
			class="glyphicon glyphicon-eye-open"></i></span>View Pages</a> 
		    <a href="${websitebuilderlink}/pages.html/newpage" class="btn btn-success" role="button" data-prompt=""><span class="btn-label"><i
			class="glyphicon glyphicon-plus"></i></span>Add Page</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
<!--       <img data-src="http://placehold.it/380x500" alt="..."> -->
      <div class="caption">
        <h4><strong>Blocks Components</strong></h4>
        <p>Capability to create Block component for WebPages.</p>
        <p><a href="${websitebuilderlink}/blocks.html" class="btn btn-info" role="button"><span class="btn-label"><i
			class="glyphicon glyphicon-eye-open"></i></span>View Blocks</a>
	      <a href="${websitebuilderlink}/blocks.html/newblock" class="btn btn-success" role="button" data-prompt=""><span class="btn-label"><i
			class="glyphicon glyphicon-plus"></i></span>Add Block</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
<!--      <img src="http://placehold.it/300x200" alt=""/> -->
      <div class="caption">
        <h4><strong>Assets Components</strong></h4>
        <p>Capability to add Assets for Block components.</p>
        <p><a href="${websitebuilderlink}/assests.html" class="btn btn-info" role="button"><span class="btn-label"><i
			class="glyphicon glyphicon-eye-open"></i></span>View Assets</a>
	       <a href="${websitebuilderlink}/assests.html" class="btn btn-success" role="button"><span class="btn-label"><i
			class="glyphicon glyphicon-plus"></i></span>Add Asset</a></p>
      </div>
    </div>
  </div>
</div>
<hr />
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel"></h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
							<label for="componentName">Component Name</label> 
							<input type="hidden" name="compName" id="compName">
							<input type="text" class="form-control" name="componentDocName" id="componentDocName" 
							placeholder="Name of Component Document" title="Name of Component" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"><i class="glyphicon glyphicon-remove-sign"></i>Cancle</button>
				<a href="#" class="btn btn-primary" id="dataConfirmOK"><i class="glyphicon glyphicon-ok-sign"></i>Go</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$('a[data-prompt]').click(function(ev) {
		var href = $(this).attr('href');
		if($('#myModal').length > 0){
			$('#myModal').modal({
				show: true,
				backdrop: 'static'
			});	
		}
		$('#myModalLabel').text('Data Prompt for '+$(this).text());
		$('#compName').val(href);
		return false;
	});
	$('#dataConfirmOK').on('click',function(){
    	if($('#componentDocName').val() == '' ){ //&& !($('#componentName').val().match('^([A-Za-Z]/s)+$'))
    		$('div.form-group').addClass('has-error');
    		$('#dataConfirmOK').attr('href','#');
    	}else{
    		$('div.form-group').removeClass('has-error');
    		var hrefVal = $('#compName').val();
    		$('#dataConfirmOK').attr('href',hrefVal+'/'+$('#componentDocName').val());
    	}
    });
</script>