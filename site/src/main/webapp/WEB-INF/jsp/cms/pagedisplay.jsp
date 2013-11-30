<%@include file="../includes/tags.jspf" %>
<c:set var="divOpenContainer">
	<div class="container">
</c:set>
<c:set var="openDiv1">
<div class="row-fluid show-grid">
</c:set>
<c:set var="closeDiv">
	</div>
</c:set>

<c:if test="${not empty pageDisplayView}">
	<c:if test="${not empty pageDisplayView.title && pageDisplayView.title != ''}">
		<div class="container">
	        <div class="page-header">
	          <h1><c:out value="${pageDisplayView.title}"/></h1>
	        </div>
	    </div>
    </c:if>
	<c:forEach items="${pageDisplayView.displayRows}" var="row">
		<c:set var="openDiv2">
			<div class="col-lg-<c:out value="${row.singleColumnSpan}"/>">
		</c:set>
		<c:if test="${empty row.notContainer || row.notContainer == 'false' }"><c:out value="${divOpenContainer}" escapeXml="false"/></c:if>
				<c:if test="${empty row.notRow || row.notRow == 'false' }"><c:out value="${openDiv1}"  escapeXml="false"/></c:if>
					<c:forEach items="${row.columns}" var="column">
						<c:if test="${empty row.notColumn || row.notColumn == 'false' }"><c:out value="${openDiv2}"  escapeXml="false"/></c:if>
							<c:out value="${column.parsedHTML}" escapeXml="false"/>
						<c:if test="${empty row.notColumn || row.notColumn == 'false' }"><c:out value="${closeDiv}"  escapeXml="false"/></c:if>
					</c:forEach>
				<c:if test="${empty row.notRow || row.notRow == 'false' }"><c:out value="${closeDiv}"  escapeXml="false"/></c:if>
		<c:if test="${empty row.notContainer || row.notContainer == 'false' }"><c:out value="${closeDiv}"  escapeXml="false"/></c:if>			
	</c:forEach>
</c:if>
