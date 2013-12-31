<%@tag import="com.mootly.wcm.model.VerificationStatus"%>
<%@tag import="com.mootly.wcm.channels.ChannelInfoWrapper"%>
<%@tag import="com.mootly.wcm.beans.InvoiceDocument"%>
<%@tag import="com.mootly.wcm.model.IndianGregorianCalendar"%>
<%@tag import="com.mootly.wcm.model.FilingSection"%>
<%@tag import="com.mootly.wcm.model.ITReturnType"%>
<%@tag import="com.mootly.wcm.model.FinancialYear"%>
<%@tag import="net.sf.ehcache.store.MemoryStoreEvictionPolicy.MemoryStoreEvictionPolicyEnum"%>
<%@tag import="com.mootly.wcm.model.ITRServiceDelivery"%>
<%@tag import="org.hippoecm.hst.util.HstResponseUtils"%>
<%@tag import="org.hippoecm.hst.core.component.HstResponse"%>
<%@tag import="org.hippoecm.hst.configuration.site.HstSite"%>
<%@tag import="com.mootly.wcm.model.ITRForm"%>
<%@tag import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenu"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenusImpl"%>
<%@tag import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@tag import="org.hippoecm.hst.core.component.HstRequest"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india"%>

<%@ tag trimDirectiveWhitespaces="true"%>

<%@ tag import="com.mootly.wcm.utils.*"%>
<%@ tag import="java.util.*"%>
<hst:link siteMapItemRefId="vendor" var="baseVendorURL"/>
<%
String propertyToCheck = "active";
HstRequest hstRequest = (HstRequest) request;
ResolvedSiteMapItem resolvedMapItem = hstRequest.getRequestContext().getResolvedSiteMapItem();
HstSiteMenusImpl itrSiteMenuImpl = new HstSiteMenusImpl(hstRequest.getRequestContext());
HstSiteMenu itrSiteMenu = itrSiteMenuImpl.getSiteMenu("dashboardmenu");
if (itrSiteMenu != null && itrSiteMenu.getSiteMenuItems() != null) {
	List<HstSiteMenuItem> listOfSiteItems = itrSiteMenu.getSiteMenuItems();
	List<HstSiteMenuItem> onlyActiveMenuItems = new ArrayList<HstSiteMenuItem>();

	if (listOfSiteItems != null && listOfSiteItems.size() > 0 ) {
		for (HstSiteMenuItem anItem:listOfSiteItems) {
			if (anItem.getParameter(propertyToCheck) == null || (anItem.getParameter(propertyToCheck) != null && anItem.getParameter(propertyToCheck).equals("true"))) {
				onlyActiveMenuItems.add(anItem);
			}
		}
		Collections.sort(onlyActiveMenuItems,new MenuComparator());
		request.setAttribute("listOfSiteItems", onlyActiveMenuItems);
	}
}
%>
<% final class EvaluateMenusList{
	String propertyToCheck;
	boolean hasDIY;
	String theResolvedPathInfoFileName;
	boolean didWeFindTheResolvedMapItemInMenu;
	//EvaluateMenusList(String propertyToCheck,boolean hasDIY,String theResolvedPathInfoFileName,boolean didWeFindTheResolvedMapItemInMenu){
	EvaluateMenusList(String propertyToCheck){
		this.propertyToCheck = propertyToCheck;
		//this.hasDIY = hasDIY;
		//this.theResolvedPathInfoFileName = theResolvedPathInfoFileName;
		//this.didWeFindTheResolvedMapItemInMenu = didWeFindTheResolvedMapItemInMenu;
	}
	public List<HstSiteMenuItem> getListOfSortedMenutItems(HstSiteMenuItem itrSiteMenuItem){
		if (itrSiteMenuItem != null && itrSiteMenuItem.getChildMenuItems() != null && propertyToCheck != null) {
			List<HstSiteMenuItem> listOfChildMenuItems = itrSiteMenuItem.getChildMenuItems();
			List<HstSiteMenuItem> onlyActiveMenuItems = new ArrayList<HstSiteMenuItem>();
			for (HstSiteMenuItem anItem:listOfChildMenuItems) {
				if (anItem.getParameter(propertyToCheck) == null || (anItem.getParameter(propertyToCheck) != null && anItem.getParameter(propertyToCheck).equals("true"))) {
					onlyActiveMenuItems.add(anItem);
				}
			}
			Collections.sort(onlyActiveMenuItems,new MenuComparator());
			return onlyActiveMenuItems;
		}
		return null;
	} 
	public void getMenuItemsAttributes(HttpServletRequest request,HstSiteMenuItem anItem){
		 Boolean shouldPutDivider = null;
		 Boolean isAPackage = null;
		 request.removeAttribute("shouldPutDivider");
		 request.removeAttribute("isAPackage");
		 request.removeAttribute("price");
		 request.removeAttribute("sub-menu");
		 request.removeAttribute("iconClass");
		 request.removeAttribute("isDivider");
		 if (anItem != null) {
			String theURL =  anItem.getParameter("theURL");
			String isPackage =  anItem.getParameter("isPackage");
			String weight =  anItem.getParameter("weight");
			String subMenu =  anItem.getParameter("sub-menu");
			String iconClass = anItem.getParameter("iconClass");
			String isDivider = anItem.getParameter("isDivider");
			if(subMenu!=null && subMenu.equalsIgnoreCase("true")) request.setAttribute("subMenu", true);
			else request.setAttribute("subMenu", false);
			//if (isPackage != null && isPackage.equals("true")) {
				isAPackage = Boolean.TRUE;
				if (weight != null && weight.equals("0")) {
					shouldPutDivider = null;
				}
				else {
					shouldPutDivider = Boolean.TRUE;
				}
				String price = anItem.getParameter("price");
				if (price != null) request.setAttribute("price", price);
			/* }
			else {
				isAPackage = null;
			} */
			if(isDivider!=null && isDivider.equalsIgnoreCase("true")) shouldPutDivider = Boolean.TRUE;
			else shouldPutDivider = Boolean.FALSE;
			if (shouldPutDivider != null) request.setAttribute("shouldPutDivider",shouldPutDivider);
			if (isAPackage != null) request.setAttribute("isAPackage",isAPackage);
			if (iconClass != null) request.setAttribute("iconClass",iconClass);
		 	//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
		 	if (theURL != null) {
		 		request.setAttribute("theURL",theURL);
		 		//if (theURL.contains(theResolvedPathInfoFileName)) didWeFindTheResolvedMapItemInMenu= true;
		 	}
		 	else {
		 		request.setAttribute("theURL", "#");
		 	}
		 }
	}
} %>

<nav class="navbar navbar-inverse" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#"><i class="glyphicon glyphicon-plus"></i>Admin Control</a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
		   <c:forEach items="${listOfSiteItems}" var="itrSiteMenuItem">
						<c:set var="childCount" value="${fn:length(itrSiteMenuItem.childMenuItems)}" />
						<c:set var="itrSiteMenuItem" value="${itrSiteMenuItem}" scope="request" />
						<c:choose>
							<c:when test="${childCount gt 0}">
								<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon ${iconClass}"></i>
								       &nbsp;${itrSiteMenuItem.name}<b class="caret"></b>
								</a>
									<ul class="dropdown-menu">
										<%-- bad luck the child menus r not SORTED it sucks so lets sort it for now based on weight  --%>
										<%
											HstSiteMenuItem itrSiteMenuItem = (HstSiteMenuItem) request.getAttribute("itrSiteMenuItem");
											EvaluateMenusList evaluateMenusList = new EvaluateMenusList( propertyToCheck );
											request.setAttribute( "listOfChildMenuItems", evaluateMenusList.getListOfSortedMenutItems(itrSiteMenuItem));
										%>
										<c:forEach items="${listOfChildMenuItems}" var="childMenuItem">
											<c:set var="childMenuItemReq" scope="request" value="${childMenuItem}" />
											<% HstSiteMenuItem anItem = (HstSiteMenuItem) request.getAttribute("childMenuItemReq");
												evaluateMenusList.getMenuItemsAttributes(request, anItem);
											%>
											<c:if test="${not empty shouldPutDivider && shouldPutDivider eq true}">
												<li class="divider"></li>
											</c:if>
											<c:set var="subMenuChildCount" value="${fn:length(childMenuItem.childMenuItems)}" />
											<c:choose>
<%-- 												<c:when test="${childMenuItem.name == 'nav-header' || childMenuItem.name == 'divider' || not empty isAPackage}">
													<li class="nav-header"><i class="glyphicon ${iconClass}"></i>&nbsp;3434${childMenuItem.name}</li>
												</c:when> --%>
												<c:when test="${subMenu && subMenuChildCount gt 0}">
													<li class="dropdown-submenu"><a tabindex="-1" href="#"><i class="glyphicon ${iconClass}"></i>&nbsp;${childMenuItem.name}</a>
														<c:set var="childMenuItem" value="${childMenuItem}" scope="request" /> 
													<c:if test="${subMenuChildCount gt 0}">
															<ul class="dropdown-menu">
																<% HstSiteMenuItem childMenuItem = (HstSiteMenuItem) request.getAttribute("childMenuItem");
																	request.setAttribute("listOfSubChildMenuItems", evaluateMenusList.getListOfSortedMenutItems(childMenuItem));
																%>
																<c:forEach items="${listOfSubChildMenuItems}" var="subChildMenuItem">
																	<c:set var="subChildMenuItemReq" scope="request" value="${subChildMenuItem}" />
																	<%HstSiteMenuItem anChildItem = (HstSiteMenuItem) request .getAttribute("subChildMenuItemReq");
																		evaluateMenusList.getMenuItemsAttributes(request, anChildItem);
																	%>
																	<li><a tabindex="-1" href="${baseVendorURL}${theURL}"><i class="glyphicon ${iconClass}"></i>&nbsp;${subChildMenuItem.name}</a>
																	</li>
																</c:forEach>
															</ul>
														</c:if></li>
												</c:when>
												<c:otherwise>
													<li><a href="${baseVendorURL}${theURL}"><i class="glyphicon ${iconClass}"></i>&nbsp;${childMenuItem.name}</a>
													</li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ul>
							</c:when>
							<c:otherwise>
								<c:set var="parentMenuItemReq" scope="request" value="${itrSiteMenuItem}" />
								<% HstSiteMenuItem parentItem = (HstSiteMenuItem) request .getAttribute("parentMenuItemReq");
												if (parentItem != null) {
													String theURL = parentItem.getParameter("theURL");
													String iconClass = parentItem.getParameter("iconClass");
													String currentScriptHTMLName = null;
													//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
													if (theURL != null) {
														request.setAttribute("theURLParent", theURL);
														//if (theURL .contains(theResolvedPathInfoFileName)) didWeFindTheResolvedMapItemInMenu = true;
													    String[] parts = theURL.split("[/]");
														if (parts != null && parts.length > 0)
															currentScriptHTMLName = parts[parts.length - 1];
													} else {
														request.setAttribute("theURLParent", "#");
													}
													String theScript = (String) request.getAttribute("baseVendorURL");
													if (theScript != null && currentScriptHTMLName != null && theScript.contains(currentScriptHTMLName)) {
														request.setAttribute("isActive", "true");
													} else {
														request.removeAttribute("isActive");
													}
													if (iconClass != null) request.setAttribute("iconClass",iconClass);
												}
								%>
								<li <c:if test='${not empty isActive && isActive == "true"}'>class="active"</c:if>><a
										href="${baseVendorURL}${theURLParent}"><i class="glyphicon ${iconClass}"></i>&nbsp;${itrSiteMenuItem.name}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			<!-- <li class="active"><a href="#"><i class="glyphicon glyphicon-home"></i>&nbsp;Dashboard</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-dashboard"></i>&nbsp;WebSite Builder</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-leaf"></i>&nbsp;IT-Returns</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-stats"></i>&nbsp;Analysis</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i>&nbsp;Manage<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="glyphicon glyphicon-globe"></i>&nbsp;Services</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-list-alt"></i>&nbsp;Knowledge Articles</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-question-sign"></i>&nbsp;FAQ</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="glyphicon glyphicon-tasks"></i>&nbsp;Tickets</a></li>
					<li class="divider"></li>
					<li><a href="#">Others</a></li>
				</ul></li>
			<li><a href="#"><i class="glyphicon glyphicon-hdd"></i>&nbsp;Assets</a></li>
			<li><a href="#"><i class="glyphicon glyphicon-bullhorn"></i>&nbsp;Active Requests</a></li> -->
		</ul>
		<!-- <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form> -->
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><i class="glyphicon glyphicon-info-sign"></i>&nbsp;Account Info</a></li>
			<li class="dropdown active"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Action<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Download Bulk Xml</a></li>
					<li><a href="#">Send Bulk Xml</a></li>
					<li><a href="#">Something else here</a></li>
					<li class="divider"></li>
					<li><a href="#">Separated link</a></li>
				</ul></li>
		</ul>
	</div>
</nav>
<%!
class MenuComparator implements Comparator<HstSiteMenuItem> {
    public int compare(HstSiteMenuItem o1, HstSiteMenuItem o2)
    {
    	Integer o1Weight = null;
    	Integer o2Weight = null;
    	String o1WeightStr = o1.getParameter("weight");
        String o2WeightStr = o2.getParameter("weight");
        if (o1WeightStr != null) {
         	o1Weight = Integer.valueOf(o1WeightStr);
    	}
        if (o2WeightStr != null) {
         	o2Weight = Integer.valueOf(o2WeightStr);
    	}
       	if ( o1Weight != null && o2Weight != null) {
       		return o1Weight.compareTo(o2Weight);
       	}
       	else {
    		return o1.getName().compareTo(o2.getName()); // Compare by name, for example
       	}
    }
}

%>