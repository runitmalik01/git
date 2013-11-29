<%@include file="../includes/tags.jspf" %>

<c:if test="${not empty pageDisplayView}">
	<c:forEach items="${pageDisplayView.displayRows}" var="row">
		<c:choose>
			<c:when test="${fn:length(row.columns) > 1 }">
				<div class="container">
					<div class="row-fluid show-grid">
						<c:forEach items="${row.columns}" var="column">
							<div class="col-lg-<c:out value="${row.singleColumnSpan}"/>">
								<c:out value="${column.parsedHTML}" escapeXml="false"/>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${row.columns}" var="column">
					<c:out value="${column.parsedHTML}" escapeXml="false"/>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:if>
