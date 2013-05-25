
<%--
@author Pankaj Singh
13/03/2013
 --%>

<%@page import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<res:breadcrumb breadcrumType="IT Return-ITR1" />
<!-- used to set title  -->
<%
HstRequest hstRequest = (HstRequest) request;
ResolvedSiteMapItem resolvedMapItem = hstRequest.getRequestContext().getResolvedSiteMapItem();
String actionInSiteMap =  resolvedMapItem.getLocalParameter("action");
String tabName = (String)request.getAttribute("Tab");
if (actionInSiteMap != null && actionInSiteMap.contains("_")) {
 tabName = actionInSiteMap.substring(0,actionInSiteMap.indexOf("_"));
}

//How is the page designed, lets define a structure for this page using simple linkedhashmap and arraylist
%>
<c:set var="tds1">
	<fmt:message key="tds1" />
</c:set>
<hippo-gogreen:title title="${tds1}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page type-page">
	<h3 id="respond1"><fmt:message key="titile.itr1.page" /></h3>
	<!-- <form id="frmdata" action="${actionUrl}" name="oi" method="post"> -->

	<ul id="myTab" class="nav nav-tabs">
		<c:forEach items="${view.listOfITRTabs}" var="itrTab" >
			<c:choose>
				<c:when test="${not empty itrTab.itrTabType && itrTab.itrTabType == 'group'}">
					<li class="dropdown <c:if test='${not empty selectedItrTab && fn:contains(itrTab.tabNames,selectedItrTab)}'>active</c:if>"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="${itrTab.labelKey}"/> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:forEach items="${itrTab.tabList}" var="aTab">
								<li <c:if test='${empty selectedItrTab && selectedItrTab == aTab}'>class="active"</c:if>><a href="#<c:out value="${aTab}"/>" data-toggle="tab"><fmt:message key="${aTab.labelKey}" /></a></li>
							</c:forEach>	
						</ul>
					</li>
				</c:when>
				<c:otherwise>
					<li <c:if test='${not empty selectedItrTab && selectedItrTab == itrTab}'>class="active"</c:if>><a href="#<c:out value="${itrTab}"/>" data-toggle="tab"><fmt:message key="${itrTab.labelKey}" /></a></li>
				</c:otherwise>
			</c:choose>				
		</c:forEach>			
	</ul>
	<%-- active tab gets the class in active --%>
	<div id="myTabContent" class="tab-content">
		<c:forEach items="${view.listOfITRTabs}" var="itrTab" >
			<c:choose>
				<c:when test="${not empty itrTab.itrTabType && itrTab.itrTabType == 'group'}">
					<c:forEach items="${itrTab.tabList}" var="aTab">
						<div class="tab-pane fade <c:if test='${not empty selectedItrTab && selectedItrTab == aTab}'>in active</c:if>" id="<c:out value="${aTab}"/>">
							<hst:include ref="${aTab.componentName}" />
						</div>
					</c:forEach>	
				</c:when>
				<c:otherwise>
					<div class="tab-pane fade <c:if test='${not empty selectedItrTab && selectedItrTab == itrTab}'>in active</c:if>" id="<c:out value="${itrTab}"/>">
						<hst:include ref="${itrTab.componentName}" />
					</div>
				</c:otherwise>
			</c:choose>				
		</c:forEach>	
			<%--		
			<div
				class="tab-pane fade <%if (tabName == "summary"){%>in active <%}%>"
				id="incometaxsummary">
				<hst:include ref="calculation" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("formsixteen")){%>in active<%}%>"
				id="formsixteen">
				<hst:include ref="formsixteenITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("salaryincome")){%>in active<%}%>"
				id="incomesalaries">
				<hst:include ref="salaryincomeITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("incomeothersources")){%>in active<%}%>"
				id="incomeothersources">
				<hst:include ref="otherincome" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("houseincome")){%>in active<%}%> "
				id="incomesinglehouse">
				<hst:include ref="singlehouseincome" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("advancetax")){%>in active<%}%>  "
				id="advancetax">
				<hst:include ref="advanceataxITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("selfassesmenttax")){%>in active<%}%>  "
				id="selfassesmenttax">
				<hst:include ref="selfassesmenttaxITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("tdsfromothers")){%>in active<%}%>  "
				id="tdsfromothers">
				<hst:include ref="tdsfromothersITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("tdsfromsalary")){%>in active<%}%>  "
				id="tdsfromsalary">
				<hst:include ref="tdsfromsalaryITR1" />
			</div>
			<div
				class="tab-pane fade <%if (tabName != null && tabName.equals("deductions")){%>in active<%}%> "
				id="deductions">
				<hst:include ref="deductionITR1" />
			</div>
			 --%>
		</div>
		
		<div id="reviewModal">
			<hst:include ref="reviewsITR1" />
		</div>
	

</div>

