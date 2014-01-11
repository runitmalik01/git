<%@tag import="com.mootly.wcm.beans.DITResponseDocument"%>
<%@tag import="com.mootly.wcm.model.VerificationStatus"%>
<%@tag import="com.mootly.wcm.channels.ChannelInfoWrapper"%>
<%@tag import="com.mootly.wcm.beans.InvoiceDocument"%>
<%@tag import="com.mootly.wcm.model.IndianGregorianCalendar"%>
<%@tag import="com.mootly.wcm.model.FilingSection"%>
<%@tag import="com.mootly.wcm.model.ITReturnType"%>
<%@tag import="com.mootly.wcm.model.FinancialYear"%>
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
<%
HstRequest hstRequest = (HstRequest) request;
Boolean isFrozen = (Boolean) request.getAttribute("isFrozen");
if (isFrozen == null ) {
	isFrozen = false;
}

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

request.setAttribute("invoicePresent", "false");
if (request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase()) != null) {
	InvoiceDocument invoiceDocument = (InvoiceDocument) request.getAttribute(InvoiceDocument.class.getSimpleName().toLowerCase());
	request.setAttribute("totalInvoiceAmount", invoiceDocument.getTotalInvoiceAmount());
	request.setAttribute("amountDue", invoiceDocument.getAmountDue());
	request.setAttribute("invoicePresent", "true");
}

ChannelInfoWrapper channelInfoWrapper = (ChannelInfoWrapper) request.getAttribute("channelInfoWrapper");
boolean isEriEnabled = false;
boolean showImportTDSButton = false;

//if DIT is enabled and user has not chosen for 26AS import show the button
if (!isFrozen && channelInfoWrapper != null) {
	isEriEnabled = channelInfoWrapper.getIsEriEnabled();
	if (isEriEnabled && memberPersonalInformation != null) {
		DITResponseDocument ditResponseDocument = (DITResponseDocument) request.getAttribute(DITResponseDocument.class.getSimpleName().toLowerCase());
		if ( ditResponseDocument != null ){
			Integer totalGetTDSDetail = ditResponseDocument.getTotalCountOfOperation("getTDSDetails");
			if (totalGetTDSDetail == null || totalGetTDSDetail == 0) {
				showImportTDSButton = true;
			}
		}
		else {
			showImportTDSButton = true;
		}
	}
}
request.setAttribute("showImportTDSButton",showImportTDSButton);

boolean isDITVerified = false;
if (memberPersonalInformation != null && memberPersonalInformation.getDitVerificationStatus() != null && memberPersonalInformation.getDitVerificationStatus() == VerificationStatus.VERIFIED) {
	isDITVerified = true;
}
request.setAttribute("isDITVerified",isDITVerified);

//How is the page designed, lets define a structure for this page using simple linkedhashmap and arraylist
%>
<% final class EvaluateMenusList{
	String propertyToCheck;
	boolean hasDIY;
	String theResolvedPathInfoFileName;
	boolean didWeFindTheResolvedMapItemInMenu;
	EvaluateMenusList(String propertyToCheck,boolean hasDIY,String theResolvedPathInfoFileName,boolean didWeFindTheResolvedMapItemInMenu){
		this.propertyToCheck = propertyToCheck;
		this.hasDIY = hasDIY;
		this.theResolvedPathInfoFileName = theResolvedPathInfoFileName;
		this.didWeFindTheResolvedMapItemInMenu = didWeFindTheResolvedMapItemInMenu;
	}
	public List<HstSiteMenuItem> getListOfSortedMenutItems(HstSiteMenuItem itrSiteMenuItem){
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
			return onlyEnabledForThisITRForm;
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
		 if (anItem != null) {
			String theURL =  anItem.getParameter("theURL");
			String isPackage =  anItem.getParameter("isPackage");
			String weight =  anItem.getParameter("weight");
			String subMenu =  anItem.getParameter("sub-menu");
			if(subMenu!=null && subMenu.equalsIgnoreCase("true")) request.setAttribute("subMenu", true);
			else request.setAttribute("subMenu", false);
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
	}
} %>
  	<c:if test="${isTrialPeriodActive==true}">
		<div class="alert alert-danger" style="font-size: small;">
			<c:if test="${daysLeft == 1}">
			Only ${daysLeft} day is left of your trial period. <a href="${urlToResellerPackage}">  Click Here !!! To upgrade your account.</a> .
			</c:if>
			<c:if test ="${daysLeft gt 1}">
			Only ${daysLeft} days are left of your trial period. <a href="${urlToResellerPackage}"> Click Here !!! To upgrade your account.</a> .
			</c:if>
		</div>
	</c:if>
	<div class="navbar navbar-inverse">
		<div class="navbar-header main-nav-header">
			<a
				href="${fn:substringBefore(scriptName,pan)}${pan}${itrFolderSuffix}/${pan}/servicerequest-itr.html"
				class="navbar-brand"> <span class="pan"
				style="font-size: small;"> <c:out value="${pan}" /> </span> </a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".main-nav">
				<span class="glyphicon glyphicon-bar"></span> <span class="glyphicon glyphicon-bar"></span> <span
					class="glyphicon glyphicon-bar"></span>
			</button>
		</div>
		<c:if test="${nomenu != 'true'}">
			<div class="navbar-collapse collapse main-nav">
				<ul class="nav navbar-nav">
					<c:forEach items="${listOfSiteItems}" var="itrSiteMenuItem">
						<c:set var="childCount"
							value="${fn:length(itrSiteMenuItem.childMenuItems)}" />
						<c:set var="itrSiteMenuItem" value="${itrSiteMenuItem}"
							scope="request" />
						<c:choose>
							<c:when test="${childCount gt 0}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">${itrSiteMenuItem.name}<b
										class="caret"></b>
								</a>
									<ul class="dropdown-menu">
										<%-- bad luck the child menus r not SORTED it sucks so lets sort it for now based on weight  --%>
										<%
              					HstSiteMenuItem itrSiteMenuItem = (HstSiteMenuItem) request.getAttribute("itrSiteMenuItem");
              					EvaluateMenusList evaluateMenusList = new EvaluateMenusList(propertyToCheck,hasDIY,theResolvedPathInfoFileName,didWeFindTheResolvedMapItemInMenu);	                						
              					request.setAttribute("listOfChildMenuItems", evaluateMenusList.getListOfSortedMenutItems(itrSiteMenuItem));	                					
              				%>
										<c:forEach items="${listOfChildMenuItems}" var="childMenuItem">
											<c:set var="childMenuItemReq" scope="request"
												value="${childMenuItem}" />
											<%
              					HstSiteMenuItem anItem = ( HstSiteMenuItem ) request.getAttribute("childMenuItemReq");
              					 evaluateMenusList.getMenuItemsAttributes(request,anItem);
              					%>
											<c:if test="${not empty shouldPutDivider}">
												<li class="divider"></li>
											</c:if>
											<c:set var="subMenuChildCount"
												value="${fn:length(childMenuItem.childMenuItems)}" />
											<c:choose>
												<c:when
													test="${childMenuItem.name == 'nav-header' || childMenuItem.name == 'divider' || not empty isAPackage}">
													<li class="nav-header">${childMenuItem.name}</li>
												</c:when>
												<c:when test="${subMenu && subMenuChildCount gt 0}">
													<li class="dropdown-submenu"><a tabindex="-1" href="#">${childMenuItem.name}</a>
														<c:set var="childMenuItem" value="${childMenuItem}"
															scope="request" /> <c:if test="${subMenuChildCount gt 0}">
															<ul class="dropdown-menu">
																<%	                  						
              							     HstSiteMenuItem childMenuItem = (HstSiteMenuItem) request.getAttribute("childMenuItem");
              					             request.setAttribute("listOfSubChildMenuItems", evaluateMenusList.getListOfSortedMenutItems(childMenuItem));	                					
              				                 %>
																<c:forEach items="${listOfSubChildMenuItems}"
																	var="subChildMenuItem">
																	<c:set var="subChildMenuItemReq" scope="request"
																		value="${subChildMenuItem}" />
																	<%
              					              HstSiteMenuItem anChildItem = ( HstSiteMenuItem ) request.getAttribute("subChildMenuItemReq");
              					              evaluateMenusList.getMenuItemsAttributes(request,anChildItem);
              					             %>
																	<li><a tabindex="-1" href="${scriptName}${theURL}">${subChildMenuItem.name}</a>
																	</li>
																</c:forEach>
															</ul>
														</c:if></li>
												</c:when>
												<c:otherwise>
													<li><a href="${scriptName}${theURL}">${childMenuItem.name}</a>
													</li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ul>
							</c:when>
							<c:otherwise>
								<c:set var="parentMenuItemReq" scope="request"
									value="${itrSiteMenuItem}" />
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
									<li
										<c:if test='${not empty isActive && isActive == "true"}'>class="active"</c:if>><a
										href="${scriptName}${theURLParent}">${itrSiteMenuItem.name}</a>
									</li>
								</c:if>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				<!--
              <form class="navbar-search pull-left" action="">
                <input type="text" class="search-query col-md-2" placeholder="Search">
              </form>
               -->
				<%--
          <div id="addToCart" style="display:none" class="pull-right simpleCart_shelfItem">
          	<h2 class="item_name" style="display:none;"><c:out value="${serviceItemKey}"/></h2>
          	<span class="item_price" style="display:none;"><w4india:inr value="199"></w4india:inr></span>
          	<input type="hidden" value="1" class="item_Quantity">
          	<a class="item_add dropdown-toggle btn btn-primary" data-toggle="dropdown" href="javascript:;" style="color: white"><i class="glyphicon glyphicon-shopping-cart glyphicon glyphicon-white"></i>Add to cart</a>
          </div>
           <div id="removeFromCart" style="display:none" class="pull-right">
          	<a id="removeCartLink" class="dropdown-toggle btn btn-primary" data-toggle="dropdown" href="javascript:;" style="color: white"><i class="glyphicon glyphicon-shopping-cart glyphicon glyphicon-white"></i>Remove from cart</a>
          </div>
           --%>
				<c:if test="${hasDIY =='true'}">
					<ul class="nav navbar-nav pull-right">
						<li><c:if
								test="${not empty hippoBeanValidationResponse_totalErrors}">
								<span title="Errors" class="badge badge-important"><c:out
										value="${hippoBeanValidationResponse_totalErrors}" />
								</span>
							</c:if> <c:if
								test="${not empty hippoBeanValidationResponse_totalWarnings}">
								<span title="Errors" class="badge badge-warning"><c:out
										value="${hippoBeanValidationResponse_totalWarnings}" />
								</span>
							</c:if></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Actions<b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="${scriptName}/../servicerequest-itr-sync-tds-from-dit.html">Import 26AS</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-refund-status.html">Refund Status</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-rectification-status.html">Rectification Status</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-itr-v-status.html">ITR-V Status</a>
								</li>
								<li class="divider"></li>
								<%-- hide Show XML only for developers --%>
								<%--
                  	 <li><a href="servicerequest-itr-summary.html">View Summary</a></li>
                     <li><a href="servicerequest-itr-summary.html?show=xml">View XML</a></li>
                     <li class="divider"></li>
                      --%>
								<li><a
									href="${scriptName}/../servicerequest-itr-summary-detailed.html">Detailed
										View of Summary</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-itr-download-xml.html">Download
										XML</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-itr-download-summary.html">Download
										Summary</a>
								</li>
								<li><a
									href="${scriptName}/../servicerequest-itr-email-xml-summary.html?email=<%=deliveryEmail%>">Email
										to <small>(<%=deliveryEmail%>)</small>
								</a>
								</li>
							</ul></li>
					</ul>
				</c:if>
			</div>
		</c:if>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.navbar  -->
	<c:if test="${not empty isFrozen && isFrozen == 'true'}">
		<div class="alert alert-info">
			Our record indicates that this income tax return was submitted to the Income Tax Department on <strong><i><c:if test="${not empty eFileDateTime}"><c:out value="${eFileDateTime.message}"/></c:if></i></strong> with <strong>Acknowledgement Number <i><c:if test="${not empty ackResponse}"><c:out value="${ackResponse.message}"/></c:if> </i></strong>.
			We do not allow any more modifications to the current income tax. <small> If you want to revise your income tax. Please start a new return </small>
		</div>
	</c:if>
<c:if
	test="${isDITVerified == 'false' && not empty memberpersonalinformation}">
	<c:choose>
		<c:when test="${fn:endsWith(scriptName,'servicerequest-itr.html')}">
			<div class="alert alert-danger">
				Unverified Information. You will not be able to file
					your income tax until the information is verified. Review your
					information (Name,DOB and PAN) and Click on the Save button. <c:if
						test="${isVendor == 'true' && not empty memberpersonalinformation}">
						<c:out value="${memberpersonalinformation.ditVerificationMessage}" />
					</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger">
				Unverified Information. You will not be able to file
					your income tax until the information is verified <a class="alert-link"
					href="${scriptName}../../servicerequest-itr.html">Click here to
						review your information (Name,DOB and PAN)</a> <c:if
						test="${isVendor == 'true' && not empty memberpersonalinformation}">
						<c:out value="${memberpersonalinformation.ditVerificationMessage}" />
					</c:if>
			</div>
	</c:otherwise>
	</c:choose>
</c:if>
<c:if
	test="${showImportTDSButton == 'true' && isDITVerified == 'true' && not fn:endsWith(scriptName,'servicerequest-itr-sync-tds-from-dit.html') }">
	<div class="alert alert-success">
		<button type="button" class="close" id='dismissImport'
			data-dismiss="alert">&times;</button>
		<strong>Save Time !!!</strong> Automatically import your TDS details
		from Department Of Income Tax <small><a class="alert-link"
			href="${scriptName}/../servicerequest-itr-sync-tds-from-dit.html">Learn More..</a>
		</small>
	</div>
</c:if>
<%--ITR1.packageName.DIY.package --%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="indianLocalDateFormStr"
	value="<%=IndianGregorianCalendar.indianDateTimeFormStr%>" />
<c:if test="${not empty memberpersonalinformation}">
	<c:if
		test="${not empty hippoBeanValidationResponse && ( fn:length(hippoBeanValidationResponse.errors) > 0 || fn:length(hippoBeanValidationResponse.warnings) > 0) }">
		<%--
		<div style="font-weight:bold;font-size:10px; border: 1px dashed #FF0000;padding:5px;text-align:center">
			<ul>
				<c:forEach items="${hippoBeanValidationResponse.errors}" var="error">
					<li style="list-style:none">
						<fmt:message key="${error.message}">
							<c:forEach items="${error.messageArgs}" var="aParam">
								<fmt:param value="${aParam}"/>
							</c:forEach>
						</fmt:message>
					</li>
				</c:forEach>
				<c:forEach items="${hippoBeanValidationResponse.warnings}" var="warning">
					<li style="list-style:none">
						<fmt:message key="${warning.message}">
							<c:forEach items="${warning.messageArgs}" var="aParam">
								<fmt:param value="${aParam}"/>
							</c:forEach>
						</fmt:message>
					</li>
				</c:forEach>
			</ul>
		</div>
		 --%>
	</c:if>
	<div
		style="font-size: 9px; font-family: arial; border: 1px dashed #ccc; padding: 5px;">
		<span>Local Time: <b><u><fmt:formatDate type="both"
						pattern="${indianLocalDateFormStr}" timeZone="GMT+5:30"
						dateStyle="short" timeStyle="short" value="${now}" />
			</u>
		</b>
		</span> | <span>For: <b><u><c:out
						value="${memberpersonalinformation.name}" />
			</u>
		</b>
		</span> | <span>DOB: <b><u><c:out
						value="${memberpersonalinformation.DOBStr}" />
			</u>
		</b>
		</span> | <span>AY: <b><u><c:out
						value="${financialYear.displayAssessmentYear}" />
			</u>
		</b>
		</span> | <span>FY: <b><u><c:out
						value="${financialYear.displayName}" />
			</u>
		</b>
		</span> | <span>Section : <b><u><c:out
						value="${memberpersonalinformation.filingSection.desc}" />
			</u>
		</b>
		</span> | <span>Due Date : <b><u><c:out
						value="${thePastDueDateStr}" />
			</u>
		</b>
		</span> | <span>Package : <b><u><fmt:message
						key="${itrForm}.packageName.${memberpersonalinformation.selectedServiceDeliveryOption}.package" />
			</u>
		</b>
		</span> | <span>Payment : <b> <c:choose>
					<c:when test="${invoicePresent == 'false'}">
						<a href="${scriptName}/../memberinvoice.html">Create
							Invoice</a>
					</c:when>
					<c:when test="${invoicePresent == 'true' }">
						<c:choose>
							<c:when test="${amountDue == 0}">
								<a href="${scriptName}/../memberinvoice.html">PAID</a>
							</c:when>
							<c:otherwise>
								<a href="${scriptName}/../memberinvoice.html">Due (<w4india:inr
										value="${amountDue}" />)</a>
							</c:otherwise>
						</c:choose>
					</c:when>
				</c:choose> </b>
		</span>
	</div>
</c:if>
<%-- you kidding me?? can't escape  --%>
<%-- this is not working as the response has already been sent to the browser --%>
<%-- //todo we need to more this entire damn logic into a java component --%>
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

<hst:element var="uiCustom" name="style">
	<hst:attribute name="type">text/css</hst:attribute>
    .navbar {
		margin-bottom: 5px;
	}
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<c:if test="${showImportTDSButton == 'true' && isDITVerified == 'true'}">
	<div id="modalForImport" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>Save time - Import your TDS details from DIT</h3>
		</div>
		<div class="modal-body">
			<p>
				<span class="label label-default label-danger">To get back to Import
					TDS, go to Actions -> Import TDS</span>
			</p>
		</div>
		<div class="modal-footer">
			<a href="${scriptName}" class="btn btn-default btn-inverse" id="importTDSNow">OK</a>
		</div>
	</div>

	<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>
	   $(document).ready ( function() {
	   		$("#dismissImport").click ( function() {
	   			 //$("#modalForImport").modal();
	   		}); 		
	   });
	</hst:element>
	<hst:headContribution element="${uiCustom}" category="jsInternal" />
</c:if>
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