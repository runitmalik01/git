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
    <hr/>
    <h3>My Income Tax Returns</h3>
    <c:choose>
		<c:when test="${not empty listOfITReturnHomePageView}">
			<%-- <div class="alert alert-info">Click on Actions->Duplicate if you want to Revise an existing return or make a copy of it</div> --%>
			<table class="table">
				<thead>
				<tr>
					<th>PAN</th>
					<th>Name</th>
					<th>FY</th>
					<th>Return Type</th>
					<th>Form</th>
					<th>Amount Due</th>
					<th>Return Status</th>
					<th>ITR V</th>
					<th>Acknowledgment Number</th>
					<th>Actions</th>
				</tr>
				</thead>
				<tbody>
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
							<c:choose>
								<c:when test="${anEntry.frozen}">
									<a <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">title="${anEntry.pathToItr}"</c:if> href="${baseFolderLink}/servicerequest-itr.html">
										<c:out value="${anEntry.pan}"/>
									</a>
								</c:when>
								<c:otherwise>
									<a <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">title="${anEntry.pathToItr}"</c:if> href="${baseFolderLink}/servicerequest-itr.html">
										<c:out value="${anEntry.pan}"/>
									</a>
								</c:otherwise>
							</c:choose>
							</span>
							<c:choose>
								<c:when test="${anEntry.verificationStatus == 'FAILED'}">
									<c:set var="cssClass" value="glyphicon-ban-circle"/>
									<c:set var="msg" value="NOT VERIFIED"/>
								</c:when>
								<c:otherwise>
									<c:set var="cssClass" value="glyphicon-ok-circle"/>
									<c:set var="msg" value="VERIFIED"/>
								</c:otherwise>
							</c:choose>
							<i class="glyphicon ${cssClass}" data-toggle="tooltip" data-placement="bottom" title="${msg}"></i>
						</td>
						<td><c:out value="${anEntry.fullName}"/></td>
						<%--<td><c:out value="${anEntry.DOB}"/></td> --%>
						<td class="filingStatus"><span><c:out value="${anEntry.financialYear}"/></span></td>
						<td class="filingStatus"  style="text-transform:capitalize;"><c:out value="${anEntry.itReturnType}"/>/<c:out value="${anEntry.filingSection.desc}"/></td>
						<td class="filingStatus"><c:out value="${anEntry.itrForm}"/></td>
						<td class="decimal"><c:out value="${anEntry.amountDue}"/></td>
						<td class="filingStatus">
							<c:choose>
								<c:when test="${anEntry.eFiledFailed}">
									<a href="${baseFolderLink}/servicerequest-itr.html"><i class="glyphicon glyphicon-pencil"></i> Prepare</a><br/>
									<i class="glyphicon glyphicon-ban-circle"></i>eFiled failed <c:out value="${anEntry.eFileDateTime}"/>
								</c:when>
								<c:when test="${anEntry.frozen}">
									<i class="glyphicon glyphicon-ok"></i>eFiled on <c:out value="${anEntry.eFileDateTime}"/>
								</c:when>
								<c:otherwise>
									<a href="${baseFolderLink}/servicerequest-itr.html"><i class="glyphicon glyphicon-pencil"></i> Prepare</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="filingStatus">
						
						</td>
						<td class="filingStatus">
							<c:if test="${anEntry.frozen}">
								<c:out value="${anEntry.ackResponse}"/>
							</c:if>
						</td>
						<td>
							<div class="btn-group">
				                <button class="btn btn-default btn-primary dropdown-toggle" data-toggle="dropdown">More <span class="caret"></span></button>
				                <ul class="dropdown-menu">
				                  <c:if test="${not anEntry.frozen}">
				                  	<li><a href="${baseFolderLink}/servicerequest-itr.html">Continue Filing</a></li>
				                  	<li class="divider"></li>
				                  </c:if>
				                  <c:if test="${not anEntry.frozen}">
				                  	<li><a href="${baseFolderLink}/efile-incometax.html">eFile</a></li>
				                  	<li class="divider"></li>
				                  </c:if>
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
				</tbody>
			</table>
			<c:choose>
			  <c:when test="${docs.total eq 0}">
			    <p id="results"><fmt:message key="search.results.noresults"/> '${query}'</p>
			  </c:when>
			  <c:otherwise>
			    <hippo-gogreen:pagination pageableResult="${docs}" queryName="query" queryValue="${query}"/>
			  </c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<h3>We were not able to find any Income Tax Returns in your system. Please start a new one by filling the form.</h3>
		</c:otherwise>
	</c:choose>
<form method="POST" action="">
</form>	
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	function s(act) {
		$("#")
	}
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>