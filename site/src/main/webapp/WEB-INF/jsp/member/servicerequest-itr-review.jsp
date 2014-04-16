
<%--
@author Dhananjay Panwar
05/04/2014
 --%>

<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<fmt:message key="service.request.itr.review.title" var="pagetitle" />
<!-- used to set title  -->
<hippo-gogreen:title title="${pagetitle}" />

<w4india:itrmenu></w4india:itrmenu>

<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="mainSiteMapRefId" />

<div class="row show-grid">
   <w4india:itrsidebar></w4india:itrsidebar>
	   <div class="${sideBarMainClass}">   
		 <w4india:titleandnav title="${pagetitle}"
			subTitle="" />
		<form id="reviewFrm" action="${actionUrl}" name="reviewFrm" method="post">
         <c:choose>
           <c:when test = "${expertReviewAvail}">
              Thanks for using our service. We will get back to you soon.                            
           </c:when>
           <c:otherwise>
             As per selected package, you are not allowed to use this service. If you want to get reviewed your Income Tax Return by our experts <a href="" data-toggle="modal" data-target="#myModal">please upgrade package.</a>
             <jsp:include page="../member/PackageUpgrade.jsp"/>
           </c:otherwise>
         </c:choose>	
       </form>
	</div>
</div>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
