

<%@include file="../includes/tags.jspf"%>

<c:if test="${not empty comments}">
	<div id="comments">
		<c:forEach items="${comments}" var="comment">
			<ul class="comment-item">
				<li class="name"><c:choose>
						<c:when test="${not empty comment.email}">
							<a href="mailto:${fn:escapeXml(comment.email)}"><c:out
									value="${comment.name}" /></a>
						</c:when>
						<c:otherwise>
							<c:out value="${comment.name}" />
						</c:otherwise>
					</c:choose></li>
				<li class="date"><span class="seperator">|</span> <fmt:formatDate
						value="${comment.creationDate.time}" type="date"
						pattern="MMM d, yyyy" /></li>
				<li class="text"><c:out value="${comment.body}" /></li>
				<li class="bg-bottom"></li>
			</ul>
		</c:forEach>
	</div>
</c:if>


<hst:actionURL var="actionUrl" />

<!-- <a name="comment"></a> -->
<!-- <div id="article-footer"> -->
<legend style="color: green; font-weight: bold">
	<%-- <fmt:message key="common.comments.label" /> --%>
	<small>Post Your Comment</small>
</legend>
<form id="frmRating" action="${actionUrl}" method="post">
	<c:if test="${not empty success}">
		<%-- <fmt:message key="common.comments.thankyou" /> --%>
		<p class="alert alert-danger">Thank you for submitting your
			comment. After approval of an editor through a verification process
			for security reasons, this comment will be shown on the site.</p>
	</c:if>
	<fieldset>
		<div class="row show-grid">
			<div class="col-md-6">
				<div class="rowlabel">
					<label for="Name_user"><fmt:message
							key="common.comments.name" /></label>
				</div>
				<div class="rowlabel">
					<input type="text" value="${name}" name="name"
						placeholder="User Name" />
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'invalid.name-label'}">
								<span class="form-error"><fmt:message
										key="common.comments.name.error" /></span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>
				</div>
			</div>
			<div class="col-md-6">
				<div class="rowlabel">
					<label for="Name_user"><fmt:message
							key="common.comments.email" /></label>
				</div>
				<div class="rowlabel">
					<!-- <span class="input-group-addon">@</span>	 -->
					<input type="text" value="${email}" placeholder="Email Address"
						name="email" />
					<ul class="text">
						<c:out value="${document.name}" />
					</ul>
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'invalid.email-label'}">
								<span class="form-error"><fmt:message
										key="common.comments.email.error" /></span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-12">
				<div class="rowlabel">
					<label for="Comment_user"><fmt:message
							key="common.comments.comment" /></label>
				</div>
				<div class="rowlabel">
					<textarea name="comment" id="comment" rows="4" cols="10">
								<c:if test="${not empty comment}">
									<c:out value="${comment}" />
								</c:if>
							</textarea>
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'invalid.comment-label'}">
								<span class="form-error"><fmt:message
										key="common.comments.comment.error" /></span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>

				</div>
			</div>
		</div>
		<input type="submit" class="btn btn-default btn-success btn-sm"
			value="Save">
	</fieldset>
</form>