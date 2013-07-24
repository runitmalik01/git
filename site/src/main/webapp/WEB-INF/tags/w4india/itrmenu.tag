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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india" %>

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

MemberPersonalInformation memberPersonalInformation = null;
boolean noMenu = false;
request.setAttribute("nomenu", "false");

String theResolvedPathInfo = resolvedMapItem.getPathInfo();
String[] theFileNameParts = theResolvedPathInfo.split("[/]");
String theResolvedPathInfoFileName = theFileNameParts[theFileNameParts.length - 1];
//theResolvedPathInfo must be a member of the itr menu otherwise it means some one is trying to mess
//for now lets kick the user out
boolean didWeFindTheResolvedMapItemInMenu = false;
if ( resolvedMapItem.getHstComponentConfiguration().getId().equals("hst:pages/member-start-application")) {
	request.setAttribute("nomenu", "true");
	noMenu = true;
	memberPersonalInformation = (MemberPersonalInformation) request.getAttribute("parentBean");
	if (memberPersonalInformation != null) {
		if (memberPersonalInformation.getNode() != null) {
			request.setAttribute("nomenu", "false");
			noMenu = false;
		}
	}
}
String propertyToCheck = null;
ITRForm itrForm = null;
ITRServiceDelivery itrServiceDelivery = null;
String serviceItemKey= null;
String deliveryEmail = request.getUserPrincipal().getName();
if (!noMenu) {
	if (memberPersonalInformation == null) memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
	if (memberPersonalInformation != null) {
		//every menu must have a property which starts with the formname and .enabled = true
		//e.g. ITR1.enabled = true if not we won't display it and then we must have to find out if DIY or Assisted
		itrForm = memberPersonalInformation.getSelectedITRForm();
		itrServiceDelivery = memberPersonalInformation.getSelectedServiceDeliveryOption();
		request.setAttribute("itrForm",itrForm);
		propertyToCheck = itrForm + ".enabled";
		FinancialYear financialYear = (FinancialYear) request.getAttribute("financialYear");
		ITReturnType itReturnType = (ITReturnType) request.getAttribute("itReturnType");
		String strReturnSection = memberPersonalInformation.getReturnSection();
		if (strReturnSection != null) {
			FilingSection filingSection = FilingSection.getByXmlCode(strReturnSection);
			request.setAttribute("filingSection", filingSection);
		}
		
		serviceItemKey = memberPersonalInformation.getPAN() + "-" + financialYear.getDisplayAssessmentYear() + "-" + itrForm + "-" + itReturnType +	"-" + itrServiceDelivery;
		if (serviceItemKey != null) request.setAttribute("serviceItemKey", serviceItemKey);
		if (memberPersonalInformation.getEmail() != null && !"".equals(memberPersonalInformation.getEmail().trim())) deliveryEmail = memberPersonalInformation.getEmail();
	}
}
boolean hasDIY = false;
boolean isDIY = false;
if (itrForm != null) {
	hasDIY = itrForm.getHasDIY();
}	
if (itrServiceDelivery != null && itrServiceDelivery == ITRServiceDelivery.DIY) {
	isDIY = true;
}
else {
	isDIY = false;
}
request.setAttribute("hasDIY", hasDIY);
request.setAttribute("isDIY", isDIY);
if (itrForm != null) {
	request.setAttribute("hasDIY",String.valueOf(itrForm.getHasDIY()));
}
//out.println(noMenu);
//out.println(propertyToCheck);

HstSiteMenusImpl itrSiteMenuImpl = new HstSiteMenusImpl(hstRequest.getRequestContext());
HstSiteMenu itrSiteMenu = itrSiteMenuImpl.getSiteMenu("itrmenu");
if (itrSiteMenu != null && itrSiteMenu.getSiteMenuItems() != null && propertyToCheck != null) {
	List<HstSiteMenuItem> listOfSiteItems = itrSiteMenu.getSiteMenuItems();
	List<HstSiteMenuItem> onlyEnabledForThisITRForm = new ArrayList<HstSiteMenuItem>();
	
	if (listOfSiteItems != null && listOfSiteItems.size() > 0 ) {
		for (HstSiteMenuItem anItem:listOfSiteItems) {
			if (anItem.getParameter(propertyToCheck) == null || (anItem.getParameter(propertyToCheck) != null && anItem.getParameter(propertyToCheck).equals("true"))) {
				if (hasDIY || ( !hasDIY && anItem.getParameter("nonDIY") != null )) {					
					onlyEnabledForThisITRForm.add(anItem);
				}
			}
		}		
		Collections.sort(onlyEnabledForThisITRForm,new MenuComparator());
		request.setAttribute("listOfSiteItems", onlyEnabledForThisITRForm);
	}
}
for (HstSiteMenuItem siteMenuItem : itrSiteMenu.getSiteMenuItems() ){

}
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
         <a class="brand" href="${fn:substringBefore(scriptName,pan)}${pan}/servicerequest-itr.html">
            <span class="pan">
               <c:out value="${pan}"/>
            </span>
         </a>
         <c:if test="${nomenu != 'true'}">
	         <div class="nav-collapse collapse navbar-responsive-collapse">
	            <ul class="nav">
	               <c:forEach items="${listOfSiteItems}" var="itrSiteMenuItem">
	               	<c:set var="childCount" value="${fn:length(itrSiteMenuItem.childMenuItems)}"/>
	               	<c:set var="itrSiteMenuItem" value="${itrSiteMenuItem}" scope="request"/>
	               	<c:choose>
	                	<c:when test="${childCount gt 0}">
	                		<li class="dropdown">
	                			<a href="#" class="dropdown-toggle" data-toggle="dropdown">${itrSiteMenuItem.name}<b class="caret"></b></a>
	                			<ul class="dropdown-menu">
	                				<%-- bad luck the child menus r not SORTED it sucks so lets sort it for now based on weight  --%>
	                				<%
	                					HstSiteMenuItem itrSiteMenuItem = (HstSiteMenuItem) request.getAttribute("itrSiteMenuItem");
	                					if (itrSiteMenuItem != null && itrSiteMenuItem.getChildMenuItems() != null && propertyToCheck != null) {
		                					List<HstSiteMenuItem> listOfChildMenuItems = itrSiteMenuItem.getChildMenuItems();
		                					List<HstSiteMenuItem> onlyEnabledForThisITRForm = new ArrayList<HstSiteMenuItem>();
		                					for (HstSiteMenuItem anItem:listOfChildMenuItems) {
		                						if (anItem.getParameter(propertyToCheck) == null || (anItem.getParameter(propertyToCheck) != null && anItem.getParameter(propertyToCheck).equals("true"))) {
		                							if (hasDIY || ( !hasDIY && anItem.getParameter("nonDIY") != null )) {	
		                								onlyEnabledForThisITRForm.add(anItem);
		                							}
		                						}
		                					}	
		                					Collections.sort(onlyEnabledForThisITRForm,new MenuComparator());
		                					request.setAttribute("listOfChildMenuItems", onlyEnabledForThisITRForm);	
	                					}
	                				%>
	                				<c:forEach items="${listOfChildMenuItems}" var="childMenuItem">
	                					<c:set var="childMenuItemReq" scope="request" value="${childMenuItem}"/>
	                					<%
	                					 HstSiteMenuItem anItem = ( HstSiteMenuItem ) request.getAttribute("childMenuItemReq");
	                					 Boolean shouldPutDivider = null;
	                					 Boolean isAPackage = null;
	                					 request.removeAttribute("shouldPutDivider");
	                					 request.removeAttribute("isAPackage");
	                					 request.removeAttribute("price");
	                					 if (anItem != null) {
	                						String theURL =  anItem.getParameter("theURL");
	                						String isPackage =  anItem.getParameter("isPackage");
	                						String weight =  anItem.getParameter("weight");
	                						if (isPackage != null && isPackage.equals("true")) {
	                							isAPackage = Boolean.TRUE;
	                							if (weight != null && weight.equals("0")) {
	                								shouldPutDivider = null;
	                							}
	                							else {
	                								shouldPutDivider = Boolean.TRUE;
	                							}
	                							String price = anItem.getParameter("price");
	                							if (price != null) request.setAttribute("price", price);
	                						}
	                						else {
	                							isAPackage = null;
	                						}
	                						if (shouldPutDivider != null) request.setAttribute("shouldPutDivider",shouldPutDivider);
	                						if (isAPackage != null) request.setAttribute("isAPackage",isAPackage);
	                					 	//String theURL = anItem.getHstLink().toUrlForm(hstRequest.getRequestContext(), true);
	                	 				 	if (theURL != null) {
	                	 				 		request.setAttribute("theURL",theURL);
	                	 				 		if (theURL.contains(theResolvedPathInfoFileName)) didWeFindTheResolvedMapItemInMenu= true;
	                	 				 	}
	                	 				 	else {
	                	 				 		request.setAttribute("theURL", "#");
	                	 				 	}
	                					 }
	                					%>
	                					<c:if test="${not empty shouldPutDivider}">
	                						<li class="divider"></li>
	                					</c:if>
	                					<c:choose>
	                						<c:when test="${childMenuItem.name == 'nav-header' || childMenuItem.name == 'divider' || not empty isAPackage}">
	                							<li class="nav-header">${childMenuItem.name}</li>
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
										if (theURL.contains(theResolvedPathInfoFileName)) didWeFindTheResolvedMapItemInMenu= true;
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
			        		<c:if test="${itrSiteMenuItem.name != 'PAN'}">
	               				<li <c:if test='${not empty isActive && isActive == "true"}'>class="active"</c:if>><a href="${scriptName}${theURLParent}">${itrSiteMenuItem.name}</a></li>
	               			</c:if>
	               		</c:otherwise>
	               	</c:choose>
	               </c:forEach>
	             </ul>
	             <!--
	                <form class="navbar-search pull-left" action="">
	                  <input type="text" class="search-query span2" placeholder="Search">
	                </form>
	                 -->	    
	             <%--  
	            <div id="addToCart" style="display:none" class="pull-right simpleCart_shelfItem">
	            	<h2 class="item_name" style="display:none;"><c:out value="${serviceItemKey}"/></h2>
	            	<span class="item_price" style="display:none;"><w4india:inr value="199"></w4india:inr></span>  
	            	<input type="hidden" value="1" class="item_Quantity">	            	
	            	<a class="item_add dropdown-toggle btn btn-primary" data-toggle="dropdown" href="javascript:;" style="color: white"><i class="icon-shopping-cart icon-white"></i>Add to cart</a>
	            </div>	
	             <div id="removeFromCart" style="display:none" class="pull-right">
	            	<a id="removeCartLink" class="dropdown-toggle btn btn-primary" data-toggle="dropdown" href="javascript:;" style="color: white"><i class="icon-shopping-cart icon-white"></i>Remove from cart</a>
	            </div>	      
	             --%>           
	            <c:if test="${hasDIY =='true'}">
		            <ul class="nav pull-right">
		               <li class="divider-vertical"></li>
		               <li class="dropdown">
		                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Actions<b class="caret"></b></a>
		                  <ul class="dropdown-menu">
		                  	 	 <%-- hide Show XML only for developers --%>
		                  	 	 <%--
			                  	 <li><a href="servicerequest-itr-summary.html">View Summary</a></li>
			                     <li><a href="servicerequest-itr-summary.html?show=xml">View XML</a></li>		                     	
			                     <li class="divider"></li>
			                      --%>
			                     <li><a href="servicerequest-itr-download-xml.html">Download XML</a></li>
		                     	<li><a href="servicerequest-itr-download-summary.html">Download Summary</a></li>
		                     	<li><a href="servicerequest-itr-email-xml-summary.html?email=<%=deliveryEmail%>">Email to <small>(<%=deliveryEmail%>)</small></a></li>
		                  </ul>
		               </li>
		            </ul>
	            </c:if>
	         </div>
         </c:if>
         <!-- /.nav-collapse -->
      </div>
   </div>
   <!-- /navbar-inner -->
</div>
<%-- you kidding me?? can't escape  --%>
<%-- this is not working as the response has already been sent to the browser --%>
<%-- //todo we need to more this entire damn logic into a java component --%>
<% 
if (!didWeFindTheResolvedMapItemInMenu && !hasDIY) { %>
<% 	
	
//HstResponse hstResponse = (HstResponse) response;
	//HstResponseUtils.sendRedirect(hstRequest,hstResponse,"root");
	//return;
}  
%>
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
<%-- no need for a shopping cart for now --%>
<%--
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    var theO = {'name':'<c:out value="${serviceItemKey}"/>','price':199};
    var myItem = new simpleCart.Item(theO);
	var itemInCart=null;
    simpleCart.ready( function(){
  		console.log( "simpleCart total: " + simpleCart.toCurrency( simpleCart.total() ) ); 
  		var h = simpleCart.has(myItem);
  		if (h) {
  			res = simpleCart.find(theO);
  			itemInCart= res[0];
  			$("#removeFromCart").show();
  			$("#addToCart").hide();
  		}
  		else {
  			//alert('not');
  			$("#removeFromCart").hide();
  			$("#addToCart").show();
  		}
	});
	
	simpleCart.bind( 'afterAdd' , function(item){
		itemInCart = item;
    	togg();	
	});
	
	// simple callback example
	simpleCart.bind( 'beforeCheckout' , function( data ){
	  	//data.invoiceNumber = "ABC-123456789";
	  	alert('WE NEED TO CALL ITR COMPONENT HERE TO GENERATE THE INVOICE');
	});
	
	$("#removeCartLink").click( function () {
			if (simpleCart.has(myItem)) {
				itemInCart.remove();
				togg();
			}
		}
	);
	
	function togg() {
		$("#addToCart").toggle();
		$("#removeFromCart").toggle();
	}
    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
 --%>