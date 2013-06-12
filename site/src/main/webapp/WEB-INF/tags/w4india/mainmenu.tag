<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
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
request.setAttribute("nomenu", "false");
//out.println( resolvedMapItem.getHstComponentConfiguration().getId() );
if ( resolvedMapItem.getHstComponentConfiguration().getId().equals("hst:pages/member-start-application")) {
	request.setAttribute("nomenu", "true");
	HippoBean memberPersonalInformation = (HippoBean) request.getAttribute("parentBean");
	if (memberPersonalInformation != null) {
		if (memberPersonalInformation.getNode() != null) request.setAttribute("nomenu", "false");
	}
}
request.setAttribute("itrSiteMenu", itrSiteMenu);
//How is the page designed, lets define a structure for this page using simple linkedhashmap and arraylist
%>
<hst:link var="logopath" path="/binaries/content/gallery/logos/w4ilogo.png"/>
<hst:link var="logopathtext" path="/images/w4indiatxt.png"/>
<hst:link var="home" path="/"/>
<div class="navbar top-menu">
   <div class="navbar-inner">
      <div class="container">
         <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
	         <span class="icon-bar"></span>
         </a>
         <a class="brand" href="./personalinformation.html">
            <span class="pan">
               <a href=""><img class="logo" width="290" height="40" src="${logopath}">&nbsp;</a>
            </span>
         </a>
         <c:if test="${nomenu != 'true'}">
	         <div class="nav-collapse collapse navbar-responsive-collapse">
	            <ul class="nav">
				    <c:forEach var="item" items="${menu.siteMenuItems}">
				        <c:set var="itemLink" value="${item.hstLink}" scope="request"/>
				        <c:if test="${not empty itemLink}">
				            <hst:link var="link" link="${itemLink}"/>
				             <%
				              		HstSiteMenuItem item = (HstSiteMenuItem) request.getAttribute("item");
				              		List<HstSiteMenuItem>	childMenuItems = item.getChildMenuItems();
				              		if (childMenuItems != null && childMenuItems.size() > 0) {
				              			request.setAttribute("hasChildren","1");
				              		}
				              		else {
				              			request.setAttribute("hasChildren","0");
				              		}
							%>
				            <c:choose >
				                    <c:when test="${item.expanded}">
				                        <li class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-761">
				                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
				                           <c:if test="${hasChildren == '1'}">
					                           <ul class="sub-menu">
					                           		<c:forEach items="${item.childMenuItems}"  var="childItem">
					                           			<c:set var="childItemLink" value="${childItem.hstLink}" scope="request"/>
					                           			<hst:link var="childLink" link="${childItemLink}"/>
														<li  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-776"><a href="${fn:escapeXml(childLink)}"><c:out value="${childItem.name}"/></a></li>
													</c:forEach>
												</ul>
											</c:if>                           
				                        </li>
				                    </c:when>
				                    <c:otherwise>
				                        <li class="menu-item menu-item-type-custom menu-item-object-custom  menu-item-home menu-item-761">
				                           <c:set var="totalChildren" value="${item.childMenuItems}" scope="request"/>                          
				                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
				                           <c:if test="${hasChildren == '1'}">
					                           <ul class="sub-menu">
					                           		<c:forEach items="${item.childMenuItems}"  var="childItem">
					                           			<c:set var="childItemLink" value="${childItem.hstLink}" scope="request"/>
					                           			<hst:link var="childLink" link="${childItemLink}"/>
														<li  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-776"><a href="${fn:escapeXml(childLink)}"><c:out value="${childItem.name}"/></a></li>
													</c:forEach>
												</ul>
											</c:if>
				                        </li>
				                    </c:otherwise>
				                </c:choose>
				        </c:if>
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
         </c:if>
         <!-- /.nav-collapse -->
      </div>
   </div>
   <!-- /navbar-inner -->
</div>