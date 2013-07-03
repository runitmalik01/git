<%@include file="../includes/tags.jspf" %>

<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
 
<hippo-gogreen:title title="${document.name}"/>
<hst:link var="services" siteMapItemRefId="myservices"></hst:link>
<hst:link var="home" siteMapItemRefId="home"></hst:link>
<ul class="breadcrumb">
  <li><a href="${home}"><i class="icon-home"></i>Home</a> <span class="divider">/</span></li>
  <li><a href="${services}">Services</a> <span class="divider">/</span></li>
  <li class="active"><c:out value="${document.name}"/></li>
</ul>
<c:if test="${not empty Success}">
			<div class="row-fluid show-grid">
				<div class="alert alert-success">Your have Successfully
					applied for ${document.name}.Soon we will contact you.</div>
			</div>
</c:if>
<!-- content -->
<div class="row-fluid show-grid">
    <div id="content">
        <h3 align="center"><c:out value="${document.name}"/></h3>
        <div>
            <hst:cmseditlink hippobean="${document}"/>
           <div class="well text-center"><c:out value="${document.serviceDescription}"/></div>
            <c:if test="${not empty document.highlights }">
            <div class="well"><c:out value="${document.highlights}"></c:out></div>
            </c:if>
            <div>
            <c:forEach items="${document.costModel}" var="costmodel">
                     <div class="alert alert-info"><c:out value="${costmodel.costDetail }"/>|<w4india:inr value="${costmodel.cost}"></w4india:inr>|
                     <a href="#myModal" id="<c:out value="${costmodel.offeringMode}"/>" class="btn btn-primary" data-toggle="modal"><i class="icon-briefcase icon-white"></i>&nbsp;<c:out value="${costmodel.offeringMode}"/></a></div>
            </c:forEach>
            </div>
        </div>
    </div>
</div>

    <hst:include ref="servicerequest-itr"/>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){

		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
