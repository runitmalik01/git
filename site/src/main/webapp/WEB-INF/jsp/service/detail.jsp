<%@include file="../includes/tags.jspf"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.beans.Service"%>
<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
<c:set value="${document.name}" var="serviceName" scope="request"></c:set>
<hippo-gogreen:title title="${document.name}" />
<hst:link var="services" siteMapItemRefId="myservices"></hst:link>
<hst:link var="home" siteMapItemRefId="home"></hst:link>
<div class="row show-grid">
	<div class="col-md-9">
		<div class="rowlabel">
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
				<div class="row show-grid">
					<div class="alert alert-success">Your have Successfully applied for ${document.name}.Soon we will contact you.</div>
				</div>
			</c:if>
			<!-- content -->
			<div class="row show-grid">
				<div id="content">
					<h3 align="center">
						<c:out value="${document.name}" />
					</h3>
					<div>
					    <c:if test="${document.serviceLeadTime not eq 0}">
						   <div class="alert alert-info">
							   <b>Service Lead Time : <c:out value="${document.serviceLeadTime}" /> Days</b>
						   </div>
						</c:if>
						<hst:cmseditlink hippobean="${document}" />
						<div class="well text-cleft">
							<c:out value="${document.serviceDescription}" />
						</div>
						<c:if test="${not empty document.highlights}">
							<div class="well">
								<c:forEach items="${document.highlights}" var="highlight" varStatus="status">
									<c:choose>
										<c:when test="${status.first}">
											<b><c:out value="${highlight}"></c:out></b>
										</c:when>
										<c:otherwise>
											<c:out value="${highlight}"></c:out>
										</c:otherwise>
									</c:choose>
									<br />
								</c:forEach>
							</div>
						</c:if>
						<c:if test="${not empty document.documentRequired && document.documentRequired eq true }">
							<div class="well">
								<p>Document Required to apply for this Service:</p>
								<c:forEach items="${document.documentNames}" var="documentName" varStatus="status">
									<c:out value="${documentName}"></c:out>
									<br />
								</c:forEach>
							</div>
						</c:if>
						<%--
            <div>
            <c:forEach items="${document.costModel}" var="costmodel">
                     <div class="alert alert-info"><c:out value="${costmodel.costDetail }"/>|<w4india:inr value="${costmodel.cost}"></w4india:inr>|
                       <div class="btn-group">
                          <a class="btn btn-default dropdown-toggle btn-primary" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-briefcase glyphicon glyphicon-white"></i>&nbsp;<c:out value="${costmodel.offeringMode}"/>
                             <span class="caret"></span>
                          </a>
                         <ul class="dropdown-menu">
                           <li><a href="#myModal" id="<c:out value="${costmodel.offeringMode}"/>" data-toggle="modal">Apply</a></li>
                         </ul>
                       </div>
                    </div>
            </c:forEach>
            </div>
             --%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="rowlabel">
			<hst:include ref="servicerequest-itr" />
		</div>
	</div>
</div>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){

		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />