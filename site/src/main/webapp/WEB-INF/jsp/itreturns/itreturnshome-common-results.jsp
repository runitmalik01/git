<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="com.mootly.wcm.model.FinancialYear"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="org.hippoecm.hst.core.component.HstRequest" %>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="com.mootly.wcm.model.FilingSection"%>
<%
HstRequest hstRequest = (HstRequest) request;
%>
    <c:if test="${strIsOnVendorPortal eq true && empty listOfITReturnHomePageView}">
        <hst:link var="back" path="/${basePath}/itreturn"></hst:link>
      <div align="center" class="row"><a class="btn btn-default green" href="${back}">Back</a></div>
    </c:if>
	<c:if test="${not empty listOfITReturnHomePageView}">
		<div class="alert alert-info">Click on Actions->Duplicate if you want to Revise an existing return or make a copy of it</div>
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<th>PAN</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>FY</th>
				<th>Filing As</th>
				<th>Package</th>
				<th>Return Type/Filing Section</th>
				<th>Mode</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listOfITReturnHomePageView}" var="anEntry">
                <c:if test="${not empty anEntry.lastOrOrgName}">
					<c:choose>
						<c:when test="${basePath == 'vendor'}">
							<c:set var="additionalParam" value="/${anEntry.canonicalUUID}"/>
							<hst:link var="baseFolderLink" path="/${basePath}/itreturn${additionalParam}/${anEntry.financialYear.displayName}/${anEntry.theParentFolder}/${fn:toLowerCase(anEntry.pan)}"/>
						</c:when>
						<c:otherwise>
							<hst:link var="baseFolderLink" path="/${basePath}/itreturn${additionalParam}/${anEntry.financialYear.displayName}/${anEntry.theParentFolder}/${fn:toLowerCase(anEntry.pan)}"/>
							<c:set var="additionalParam" value=""/>
						</c:otherwise>
					</c:choose>


				<tr>
					<td class="pan">
						<span style="text-transform:uppercase;">
						<a <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">title="${anEntry.pathToItr}"</c:if> href="${baseFolderLink}/servicerequest-itr.html">
							<c:out value="${anEntry.pan}"/>
						</a>
						</span>
					</td>
					<!-- <td class="pan"><b><c:out value="${anEntry.lastOrOrgName}"/></b></td> -->
					<td><c:out value="${anEntry.fullName}"/></td>
					<td><c:out value="${anEntry.DOB}"/></td>
					<td class="filingStatus decimal"><span><c:out value="${anEntry.financialYear}"/></span></td>
					<td class="filingStatus decimal"><c:out value="${anEntry.filingStatus}"/></td>
					<td><fmt:message key="${anEntry.ITRForm}.packageName"/></td>
					<td class="filingStatus"  style="text-transform:capitalize;"><c:out value="${anEntry.itReturnType}"/>/<c:out value="${anEntry.filingSection.desc}"/></td>
					<td><fmt:message key="ITRServiceDelivery.${anEntry.ITRFormMode}.displayName"/></td>
					<td>
						<div class="btn-group">
			                <button class="btn btn-default btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="${baseFolderLink}/servicerequest-itr-summary.html">Continue Filing</a></li>
			                  <li class="divider"></li>
			                  <li><a href="${baseFolderLink}/servicerequest-itr-copy-or-move.html">Duplicate</a></li>
			                  <c:if test="${anEntry.ITRFormMode == 'DIY'}">
				                  <li class="divider"></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-download-summary.html">Download Summary</a></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-download-xml.html">Download XML</a></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-email-xml-summary.html?email=${anEntry.email}">Email Summary and XML</a></li>
								  <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
				                  	<li><a href="${baseFolderLink}/servicerequest-itr-summary.html/addpathtobulk">Add To Bulk</a></li>
				                  </c:if>
				              </c:if>
				              <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
								<li><a href="${baseFolderLink}/servicerequest-itr-v-status.html">ITR-V Status</a></li>
				              </c:if>				              
			                </ul>
			             </div>
					</td>
				</tr></c:if>
			</c:forEach>
		</table>
		<c:choose>
		  <c:when test="${docs.total eq 0}">
		    <p id="results"><fmt:message key="search.results.noresults"/> '${query}'</p>
		  </c:when>
		  <c:otherwise>
		    <hippo-gogreen:pagination pageableResult="${docs}" queryName="query" queryValue="${query}"/>
		  </c:otherwise>
		</c:choose>
	</c:if>
<form method="POST" action="">
</form>	
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	function s(act) {
		$("#")
	}
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>