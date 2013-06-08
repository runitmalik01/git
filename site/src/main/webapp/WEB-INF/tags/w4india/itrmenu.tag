<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenu"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenusImpl"%>
<%@tag import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@tag import="org.hippoecm.hst.core.component.HstRequest"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>

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
request.setAttribute("itrSiteMenu", itrSiteMenu);
//How is the page designed, lets define a structure for this page using simple linkedhashmap and arraylist
%>
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
                					<c:set var="childMenuItemReq" scope="request" value="${childMenuItem}"/>
                					<%
                					 HstSiteMenuItem anItem = ( HstSiteMenuItem ) request.getAttribute("childMenuItemReq");
                					 if (anItem != null) {
                						String theURL =  anItem.getParameter("theURL");
                					 	//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
                	 				 	if (theURL != null) {
                	 				 		request.setAttribute("theURL",theURL);
                	 				 	}
                	 				 	else {
                	 				 		request.setAttribute("theURL", "#");
                	 				 	}
                					 }
                					%>
                					<c:choose>
                						<c:when test="${childMenuItem.name == 'nav-header' || childMenuItem.name == 'divider' }">
                							<li class="${childMenuItem.name}"></li>
                						</c:when>
                						<c:otherwise>
                							<li><a href="${scriptName}${theURL}">${childMenuItem.name}</a></li>
                						</c:otherwise>
                					</c:choose>
                				</c:forEach>
                			</ul>
               		</c:when>
               		<c:otherwise>
						<c:set var="parentMenuItemReq" scope="request" value="${itrSiteMenuItem}"/>
		    			<%
		    				HstSiteMenuItem parentItem = ( HstSiteMenuItem ) request.getAttribute("parentMenuItemReq");
		    				if (parentItem != null) {
		    					String theURL =  parentItem.getParameter("theURL");
		    					String currentScriptHTMLName = null;
		    					//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
		    	 				if (theURL != null) {
									request.setAttribute("theURLParent",theURL);
									String[] parts = theURL.split("[/]");
									if (parts != null && parts.length > 0) currentScriptHTMLName = parts[parts.length-1];
								}
								else {
									request.setAttribute("theURLParent", "#");
								}
		    	 				String theScript = (String) request.getAttribute("scriptName");
			    				if (theScript != null && currentScriptHTMLName != null && theScript.contains(currentScriptHTMLName) ) {
			    					request.setAttribute("isActive", "true");
			    				}
			    				else {
			    					request.removeAttribute("isActive");
			    				}
		    				}

		        		%>
               			<li <c:if test='${not empty isActive && isActive == "true"}'>class="active"</c:if>><a href="${scriptName}${theURLParent}">${itrSiteMenuItem.name}</a></li>
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
                  <li><a href="xmlgenerator.html?show=summary">View Summary</a></li>
                     <li><a href="xmlgenerator.html?show=xml">View XML</a></li>
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