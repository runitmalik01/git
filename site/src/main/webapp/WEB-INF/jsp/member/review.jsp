
<%--
@author Dhananjay Panwar
18/05/2013
 --%>

<%@include file="../includes/tags.jspf"%>

<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="frmReview" action="${actionUrl}" name="rating" method="post">
<!--
<div id="comments">



			<c:if test="${not empty success}">
				<fmt:message key="products.detail.thanksforreview" />
				<br />
				<br />
			</c:if>



      <%--@elvariable id="reviews" type="java.util.List<com.mootly.wcm.beans.Review>"--%>
      <c:forEach items="${reviews}" var="review">
          <ul class="comment-item">
              <li class="name"><a href="#">Name:<c:out value="${review.name}"/></a></li>
              <li class="date"><span class="seperator">|</span> <fmt:formatDate value="${review.date.time}"
                                                                                pattern="MMM dd, yyyy"/></li>
              <li class="text">
                  <ul>
                      <li class="score"><fmt:message key="products.detail.score"/>:</li>
                      <fmt:formatNumber value="${review.rating * 10}" var="reviewRatingStyle" pattern="#0"/>
                      <li class="rating stars-${reviewRatingStyle}"></li>
                      <li class="review"><c:out value="${review.comment}"/></li>
                  </ul>
              </li>
              <li class="bg-bottom"></li>
          </ul>
      </c:forEach>
  </div>
 -->
<div align="center">
	<a href="#myModalReview" id="clickReview" role="button" class="btn btn-default" data-toggle="modal" >Review This Page</a>
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
				<label for="name">Name</label>
				<input type="text" required="required" id="name" name="name" value="" data-toggle="tooltip"  maxlength="25" /></br>
				<label for="email">Email</label></br>
				<input type="email" required="required" id="email" name="email" value=""/></br>
				<label for="review_score">Score</label>
				 <ol class="rate">
                                  <li><span title="Rate: 1">1</span></li>
                                  <li><span title="Rate: 2">2</span></li>
                                  <li><span title="Rate: 3">3</span></li>
                                  <li><span title="Rate: 4">4</span></li>
                                  <li><span title="Rate: 5">5</span></li>
                              </ol>
                <input type="hidden" value="0" name="rating" id="ratingField" /></br>
				<label for="comment">Review</label>
				<textarea name="comment" id="comment" rows="5" cols="50" required><c:if test="${not empty comment}"><c:out value="${comment}"/></c:if></textarea>

			</fieldset>
		</div>
		<div class="modal-footer">
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Close</button>
			<input type="submit" value="Submit" class="btn btn-default btn-primary"/>
		</div>
	</div>

</form>

<script type="text/javascript">
		$('#clickReview').click(function(){
			$('.modal').attr('id','myModalReview');
		});
		</script>

<hst:headContribution keyHint="rate" category="jsInternal">
     <hst:link path="/js/rate.js" var="rateJs"/>
    <script type="text/javascript" src="${rateJs}"></script>
</hst:headContribution>

<c:if test="${preview && inlineEditingEnabled}">
    <jsp:include page="../inc/inline-editing-editor-form.jsp"/>
</c:if>

<style>

.rate li { display: inline-block; width: 16px; height: 18px;  background: url("/site/images/rating.png") no-repeat 0 0; float: left; padding: 0 1px; }
.rate li:hover { cursor: pointer; background-position: 0 -200px; }
.rate li.on, .rate li.hover { background-position: 0 -200px; }
.rate li.hover-off { background-position: 0 0; }
.rate li.hover-on { background-position: 0 -200px; opacity: 0.75; filter: alpha(opacity=75); }
.rate li span { position: absolute; left: -9999px; }

</style>
