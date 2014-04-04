<%@include file="../includes/tags.jspf"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.beans.Service"%>
<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set value="${document.name}" var="serviceName" scope="request"></c:set>
<hippo-gogreen:seoheader title="${document.name}" robots="NOINDEX, NOFOLLOW"/>

<hst:link var="services" siteMapItemRefId="myservices"></hst:link>
<hst:link var="home" siteMapItemRefId="home"></hst:link>

<ul class="breadcrumb">
	<li><a href="${home}" class="btn btn-default btn-info"><i
			class="glyphicon glyphicon-home glyphicon glyphicon-white"></i><strong>Home</strong></a>
		<span class="divider">/</span></li>
	<li><a href="${services}" class="btn btn-default btn-info"><i
			class="glyphicon glyphicon-cog glyphicon glyphicon-white"></i><strong>Services</strong></a>
		<span class="divider">/</span></li>
	<li class="active"><c:out value="${document.name}" /></li>
</ul>
<c:if test="${not empty Success}">
		<div class="alert alert-success">Your have Successfully applied for ${document.name}.Soon we will contact you.</div>
</c:if>
<c:set var="colSpan" value="12"/>
<c:choose>
	<c:when test="${document.canApllyForServiceOnline }">
		<c:set var="colSpan" value="8"/>
	</c:when>
</c:choose>
<div class="row">
	<div class="col-md-${colSpan}">
		<div itemscope itemtype="http://schema.org/Product">
			<h1 itemprop="name"><c:out value="${document.name}" /></h1>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${not empty document.highlights}">
						<h4>Highlights</h4>
						<ul>
						<c:forEach items="${document.highlights}" var="highlight" varStatus="status">
							<li>
							<c:choose>
								<c:when test="${status.first}">
									<b><c:out value="${highlight}"></c:out></b>
								</c:when>
								<c:otherwise>
									<c:out value="${highlight}"></c:out>
								</c:otherwise>
							</c:choose>
							</li>
						</c:forEach>
						</ul>
					</c:if>
					<span  itemprop="description"><c:out value="${document.serviceDescription}" escapeXml="false"/></span>
				</div>
			</div>
			<!-- content -->
			<div class="row show-grid">
				<div>
					<hst:cmseditlink hippobean="${document}" />
					<c:if test="${document.serviceLeadTime != 0}">
					   <div class="alert alert-info">
						   <b>Service Lead Time : <c:out value="${document.serviceLeadTime}" /> Days</b>
					   </div>
					</c:if>
					<c:forEach items="${document.alertMessageDetails}" var="alertmsgdetail">
						<c:if test="${alertmsgdetail.enable}">
							<div class="alert alert-warning">
								<c:out value="${alertmsgdetail.alertMessage}" escapeXml="false"/>
							</div>
						</c:if>
					</c:forEach>
					<c:if test="${not empty document.documentRequired && document.documentRequired eq true }">
						<div class="well">
							<p>Document Required to apply for this Service:</p>
							<c:forEach items="${document.documentNames}" var="documentName" varStatus="status">
								<c:out value="${status.count}."/><c:out value="${documentName}"></c:out>
								<br />
							</c:forEach>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${document.canApllyForServiceOnline }">
		<div class="col-md-3">
			<div class="rowlabel">
				<hst:include ref="servicerequest-itr" />
			</div>
		</div>
	</c:if>
</div>
