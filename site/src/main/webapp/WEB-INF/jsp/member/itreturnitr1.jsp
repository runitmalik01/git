
<%--
@author Pankaj Singh
13/03/2013
 --%>

<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenusImpl"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenusManagerImpl"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenuImpl"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenu"%>
<%@page import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<%--res:breadcrumb breadcrumType="IT Return-ITR1" / --%>
<!-- used to set title  -->
<%
HstRequest hstRequest = (HstRequest) request;
ResolvedSiteMapItem resolvedMapItem = hstRequest.getRequestContext().getResolvedSiteMapItem();
String actionInSiteMap =  resolvedMapItem.getLocalParameter("action");
String tabName = (String)request.getAttribute("Tab");
if (actionInSiteMap != null && actionInSiteMap.contains("_")) {
 tabName = actionInSiteMap.substring(0,actionInSiteMap.indexOf("_"));
}

HstSiteMenusImpl itrSiteMenuImpl = new HstSiteMenusImpl(hstRequest.getRequestContext());
HstSiteMenu itrSiteMenu = itrSiteMenuImpl.getSiteMenu("itrmenu");
for (HstSiteMenuItem siteMenuItem : itrSiteMenu.getSiteMenuItems() ){
	
}
pageContext.setAttribute("itrSiteMenu", itrSiteMenu);
//How is the page designed, lets define a structure for this page using simple linkedhashmap and arraylist
%>
<c:set var="tds1">
	<fmt:message key="tds1" />
</c:set>
<hippo-gogreen:title title="${tds1}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
   <div class="navbar">
      <div class="navbar-inner">
         <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">
               <span class="pan">
                  <c:out value="${pan}"/>
               </span>
            </a>
            <div class="nav-collapse collapse navbar-responsive-collapse">
               <ul class="nav">                  
                  <c:forEach items="${itrSiteMenu.siteMenuItems}" var="itrSiteMenuItem">
                  	<c:set var="childCount" value="${fn:length(itrSiteMenuItem.childMenuItems)}"/>
                  	<c:choose>
	                  	<c:when test="${childCount gt 0}">	                  		
	                  		<li class="dropdown">
	                  			<a href="#" class="dropdown-toggle" data-toggle="dropdown">${itrSiteMenuItem.name}<b class="caret"></b></a>
	                  			<ul class="dropdown-menu">	                  				
	                  				<c:forEach items="${itrSiteMenuItem.childMenuItems}" var="childMenuItem">
	                  					<%
	                  					 HstSiteMenuItem anItem = ( HstSiteMenuItem ) pageContext.getAttribute("childMenuItem");
	                  					 if (anItem != null) {
	                  						String theURL =  anItem.getParameter("theURL");
	                  					 	//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
	                  	 				 	if (theURL != null) pageContext.setAttribute("theURL",theURL);
	                  					 }
	                  					%>
	                  					<c:choose>
	                  						<c:when test="${childMenuItem.name == 'nav-header' || childMenuItem.name == 'divider' }">
	                  							<li class="${childMenuItem.name}"></li>
	                  						</c:when>
	                  						<c:otherwise>
	                  							<li><a href="${theURL}">${childMenuItem.name}</a></li>
	                  						</c:otherwise>
	                  					</c:choose>	                  					
	                  				</c:forEach>
	                  			</ul>
                  		</c:when>
                  		<c:otherwise>
                  			<li><a href="${scriptName}">${itrSiteMenuItem.name}</a></li>
                  		</c:otherwise>
                  	</c:choose>
                  </c:forEach>  
                </ul>               
	               <!-- 
	                  <form class="navbar-search pull-left" action="">
	                    <input type="text" class="search-query span2" placeholder="Search">
	                  </form>
	                   -->
               <ul class="nav pull-right">
                  <!-- <li><a href="#">Link</a></li> -->
                  <li class="divider-vertical"></li>
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Return<b class="caret"></b></a>
                     <ul class="dropdown-menu">
                        <li><a href="#">View XML</a></li>
                        <li><a href="#">Download XML</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Download Return</a></li>
                     </ul>
                  </li>
               </ul>
            </div>
            <!-- /.nav-collapse -->
         </div>
      </div>
      <!-- /navbar-inner -->
   </div>
</div>
