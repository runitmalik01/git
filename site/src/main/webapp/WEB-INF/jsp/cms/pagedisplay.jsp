<%@include file="../includes/tags.jspf" %>

<c:if test="${not empty pageDisplayView}">
	<c:forEach items="${pageDisplayView.displayRows}" var="row">
		<div class="row-fluid show-grid">
			<c:forEach items="${row.columns}" var="column">
				<div class="col-lg-<c:out value="${row.singleColumnSpan}"/>">
					<c:out value="${column.parsedHTML}" escapeXml="false"/>
				</div>
			</c:forEach>
		</div>
	</c:forEach>
</c:if>
