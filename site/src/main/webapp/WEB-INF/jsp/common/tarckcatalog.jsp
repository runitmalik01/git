<%@include file="../includes/tags.jspf"%>
<div class="well">Tests</div>
<c:if test="${not empty listfetchDocuments}">
	<c:forEach items="${listfetchDocuments}" var="mapOfdocumentList">
		<div class="panel panel-info">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<strong><c:out value="${mapOfdocumentList.key}" /></strong>
			</div>
			<c:forEach items="${mapOfdocumentList.value}" var="document">
				<c:out value="${fn:toUpperCase(document.parentBean.parentBean.parentBean.name)}" />-
				<c:out value="${document.name}" />
				<c:if test="${document.name eq 'invoicedocument'}">
					<c:forEach items="${document.invoicePaymentDetailList}" var="child">
						<c:out value="${child.paymentVerificationStatusStr}" />
					</c:forEach>|<fmt:formatDate value="${document.lastModificationDate.time}"
						pattern="dd-MMM-YYYY" />
				</c:if>
				<a href="#" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-edit"></i>&nbsp;Follow</a>
				<hr />
			</c:forEach>
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty mapForCounterCompo}">
	<c:forEach items="${mapForCounterCompo}" var="mapOfdocumentList">
		<div class="well"><c:out value="${mapOfdocumentList.value}"/></div>
	</c:forEach>
</c:if>