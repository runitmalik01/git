<%@include file="../includes/tags.jspf" %>
<hst:link var="websitebuilderlink" siteMapItemRefId="websitebuilder"/>
<c:set var="divOpenContainer">
	<div class="container">
</c:set>
<c:set var="openDiv1">
<div class="row show-grid">
</c:set>
<c:set var="closeDiv">
	</div>
</c:set>
<%--
<c:if test="${not empty isVendor && isVendor eq 'true'}">
	<c:choose>
		<c:when test="${not empty isCommonPage && isCommonPage eq 'false'}">
			<a class="btn btn-default btn-info" href="${websitebuilderlink}/pages.html/${pageDocument.canonicalUUID}/editpage"
				style="position: absolute; top: 10em; left: 70em;"><i
				class="glyphicon glyphicon-edit"></i>&nbsp;Edit Page</a>
		</c:when>
		<c:otherwise>
			<a class="btn btn-default btn-warning" href="${websitebuilderlink}/pages.html"
				style="position: absolute; top: 10em; left: 70em;"><i
				class="glyphicon glyphicon-plus"></i>&nbsp;Create Own Page</a>
		</c:otherwise>
	</c:choose>
</c:if>
 --%>
<c:if test="${not empty pageDisplayView}">
	<hippo-gogreen:seoheader title="${pageDisplayView.title}" keywords="${pageDisplayView.keywords}" description="${pageDisplayView.description}" />
	<c:if test="${not empty pageDisplayView.title && pageDisplayView.title != '' && not pageDisplayView.hideTitle}">
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

		
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	$( document ).ready(function() {
		// <c:out value="${pageDocument}"/> <c:out value="${isCommonPage}"/>
		<c:if  test="${not empty pageDocument && (empty isCommonPage || isCommonPage == 'false') }">
				$('<li><a href="<hst:link path="/vendor/websitebuilder/pages.html"/>/${pageDocument.canonicalUUID}/editpage">Edit Page</a> </li>').appendTo( "#submenucms" );
		</c:if>
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
