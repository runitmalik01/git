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
	<c:if test="${not empty listOfITReturnHomePageView}">
		<table class="table table-striped table-hover">
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
							<hst:link var="baseFolderLink" path="/${basePath}/itreturn${additionalParam}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}${anEntry.itrFolderSuffix}/${fn:toLowerCase(anEntry.pan)}"/>
						</c:when>
						<c:otherwise>
							<hst:link var="baseFolderLink" path="/${basePath}/itreturn${additionalParam}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}${anEntry.itrFolderSuffix}/${fn:toLowerCase(anEntry.pan)}"/>
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
			                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="${baseFolderLink}/servicerequest-itr-summary.html">Continue Filing</a></li>
			                  <c:if test="${anEntry.ITRFormMode == 'DIY'}">
				                  <li class="divider"></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-download-summary.html">Download Summary</a></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-download-xml.html">Download XML</a></li>
				                  <li><a href="${baseFolderLink}/servicerequest-itr-email-xml-summary.html?email=${anEntry.email}">Email Summary and XML</a></li>
								  <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
				                  	<li><a href="${baseFolderLink}/servicerequest-itr-summary.html/addpathtobulk">Add To Bulk</a></li>
				                  	<li class="divider"></li>			                  	
				                  </c:if>
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