<%@include file="../includes/tags.jspf" %>

<!-- NOTE: Switch on the following variable if you want to eanble Inline Editing feature in this page. -->
 
<hst:link var="services" siteMapItemRefId="myservices" />
<hippo-gogreen:title title="${document.name}"/>
<div class="span9">
<ul class="breadcrumb">
  <li><a href="#"><i class="icon-home"></i>Home</a> <span class="divider">/</span></li>
  <li><a href="${services}">Services</a> <span class="divider">/</span></li>
  <li class="active"><c:out value="${document.name}"/></li>
</ul>
</div>
<!-- content -->
<div class="span9">
    <div id="content">
        <h3 align="center"><c:out value="${document.name}"/></h3>
        <div>
            <hst:cmseditlink hippobean="${document}"/>
            <div class="well text-center"><c:out value="${document.serviceDescription}"/></div>
            <c:if test="${not empty document.highlights }">
            <div class="well"><c:out value="${document.highlights }"></c:out></div>
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
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="myModalLabel">Service Request</h3>
  </div>
  <div class="modal-body">
    <p>One fine body…</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    <button class="btn btn-primary">Apply</button>
  </div>
</div>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function(){

		 });
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
