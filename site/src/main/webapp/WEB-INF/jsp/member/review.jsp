
<%--
@author Dhananjay Panwar
18/05/2013
 --%>
 
<%@include file="../includes/tags.jspf"%>

<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="frmReview" action="${actionUrl}" name="rating" method="post">

<div align="center">
	<a href="#myModal" id="click" role="button" class="btn" data-toggle="modal" >Review This Page</a>
</div>
	<!-- Modal -->
	<div id="" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Review This Page</h3>
		</div>
		<div class="modal-body">
			<fieldset>
				<label for="review_name">Name</label> 
				<input type="text" id="review_name" name="review_name" value=" " data-toggle="tooltip"  maxlength="25" /> 
				<label for="review_email">Email</label>
				<input type="text" id="review_email" name="review_email" value=""/>
				<label for="review_score">Score</label>
				 <ol class="rate">
                                  <li><span title="Rate: 1">1</span></li>
                                  <li><span title="Rate: 2">2</span></li>
                                  <li><span title="Rate: 3">3</span></li>
                                  <li><span title="Rate: 4">4</span></li>
                                  <li><span title="Rate: 5">5</span></li>
                              </ol>
                <input type="hidden" value="0" name="rating" id="ratingField" /></br>
				<label for="review">Review</label>
				<textarea  name="review" id="review" rows="5" cols="50"></textarea>
				
			</fieldset>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button id="myModalHrefReview" class="btn btn-primary">Submit</button>
		</div>
	</div>

</form>


<res:client-validation formId="frmReview" screenConfigurationDocumentName="review" formSubmitButtonId="myModalHrefReview" />


<script type="text/javascript">
		$('#click').click(function(){
			$('.modal').attr('id','myModal');
		});
		</script>

<hst:headContribution keyHint="rate" category="jsInternal">
     <hst:link path="/js/rate.js" var="rateJs"/>
    <script type="text/javascript" src="${rateJs}"></script>
</hst:headContribution>


<style>

.rate li { display: inline-block; width: 16px; height: 18px;  background: url("/site/images/rating.png") no-repeat 0 0; float: left; padding: 0 1px; }
.rate li:hover { cursor: pointer; background-position: 0 -200px; }
.rate li.on, .rate li.hover { background-position: 0 -200px; }
.rate li.hover-off { background-position: 0 0; }
.rate li.hover-on { background-position: 0 -200px; opacity: 0.75; filter: alpha(opacity=75); }
.rate li span { position: absolute; left: -9999px; }

</style>
