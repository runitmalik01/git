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
				<th><fmt:message key="member.homepage.lastname"/></th>
				<th>FY</th>
				<th>Filing As</th>
				<th>Package</th> 
				<th>Return Type/Filing Section</th>
				<th>Mode</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listOfITReturnHomePageView}" var="anEntry">
                   <c:if test="${not empty anEntry.lastOrOrgName}">
				<tr>
					<td class="pan">
						<hst:link var="viewLink" path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr.html"/>
						<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${anEntry.pan}"/></a></span>
					</td>
					<td class="pan"><b><c:out value="${anEntry.lastOrOrgName}"/></b></td>
					<td class="filingStatus decimal"><span><c:out value="${anEntry.financialYear}"/></span></td>
					<td class="filingStatus decimal"><c:out value="${anEntry.filingStatus}"/></td>
					<td><fmt:message key="${anEntry.ITRForm}.packageName"/></td>
					<td class="filingStatus"  style="text-transform:capitalize;"><c:out value="${anEntry.itReturnType}"/>/<c:out value="${anEntry.filingSection.desc}"/></td>
					<td><fmt:message key="ITRServiceDelivery.${anEntry.ITRFormMode}.displayName"/></td>
					<td>
						<hst:link var="viewLink" path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-summary.html"/>
						<%--<span style=""><a href="${viewLink}">Continue Filing</a></span>--%>
						<div class="btn-group">
			                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="${viewLink}">Continue Filing</a></li>
			                  <c:if test="${anEntry.ITRFormMode == 'DIY'}">
				                  <li class="divider"></li>
				                  <li><a href="<hst:link path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-download-summary.html"/>">Download Summary</a></li>
				                  <li><a href="<hst:link  path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-download-xml.html" />">Download XML</a></li>
				                  <li><a href="<hst:link  path="/${basePath}/itreturn/${anEntry.financialYear.displayName}/${anEntry.filingSection.folderName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr-email-xml-summary.html"/>?email=${anEntry.email}">Email Summary and XML</a></li>
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