<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="com.mootly.wcm.model.FinancialYear"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="com.mootly.wcm.model.FilingSection"%>
<c:set var="startapplication">
	<fmt:message key="member.start.application" />
</c:set>
<hippo-gogreen:title title="${startapplication}" />
<%
ValueListService objValueListService = ValueListServiceImpl
.getInstance();
TreeMap objTreeMapSection = (TreeMap) objValueListService.getReturnFile();
	request.setAttribute("objTreeMapSection", objTreeMapSection);
	pageContext.setAttribute("filingSectionValues", FilingSection.values());
	String serviceItemKey= null;
	String deliveryEmail = request.getUserPrincipal().getName();
	 %>
<div class="page">
	<h4>Vendor IT Return Home</h4>
	<form id="frmSearch" method="GET">
		<input type="hidden" name="pageNumber" value="${params.pageNumber}"/>
		<fieldset>
			<legend><fmt:message key="member.homepage.fillform"/> </legend>
			<div class="row-fluid show-grid">
				 <div class="span9">		          	
		          	<div class="rowlabel"><input id="query" name="query" placeholder="Search String" type="text" maxlength="50"  value="${params.query}"/></div>
		          </div>
		           <div class="span3">
		          	 	<a id="myModalHref" class="btn orange">Search</a>
		           </div>
		    </div>
		 </fieldset>		 
	 </form>
	 <%--
     <div id="error" class="alert alert-error" style="display:none;">PAN's fifth alphabet should be first alphabet of Last Name</div>
     <div id="strictmsg" class="alert hide">Please enter PAN number for Individual or HUF</div>
		<fieldset>
			<legend><fmt:message key="member.homepage.fillform"/> </legend>
			<div class="row-fluid show-grid">
		          <div class="span2">
		          	<div class="rowlabel"><label for="pan"><small>PAN</small></label></div>
		          	<div class="rowlabel"><input id="pan" name="pan" placeholder="PAN" type="text" maxlength="10" class="uprcase strict"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="pi_last_name"><small><fmt:message key="member.homepage.lastname"/></small></label></div>
		          	<div class="rowlabel"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" class="uprcase"/></div>
		          </div>
		           <div class="span3">
		            <div class="rowlabel"><label for="ReturnSection"><small>Return filed under section</small><c:out value="${parentBean.returnSection}"/></label></div>
		          	<div class="rowlabel">
		          	<select id="ReturnSection" name="ReturnSection" onChange="getSection()" class="uprcase">
		          	<option value="">Select </option>
			        <c:forEach items="${filingSectionValues}" var="fs">
				      <c:if test="${fs != 'UNKNOWN'}">
					 <option value='<c:out value="${fs.xmlCode}"/>'><c:out value="${fs.displayString}"/></option>
				       </c:if>
			        </c:forEach>
		          	</select></div>
		          </div>
		          <div class="span2">
		            <div class="rowlabel"><label for="pi_return_type"><small>Return Type</small></label></div>
		          	<div class="rowlabel">
		           <input type="text" id="pi_return_type" readonly="readonly" name="pi_return_type" class="uprcase">
		           </div>
		          </div>
		          <div class="span2">
		          	<div class="rowlabel"><label for="fy"><small>Financial Year</small></label></div>
		          	<div class="rowlabel"><select id="fy" name="fy" style="text-transform: uppercase;"><option value="2012-2013">2012-2013(Current)</option>
		          	</select></div>
		          </div>
		     </div>
		     <div align="center" ><a id="myModalHref" class="btn orange">Search </a></div>
		</fieldset>
				      --%>
	</form>
	
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">Choose a package which suits your need</h3>
	  </div>
	  <div class="modal-body">
			<div class="row-fluid show-grid">
				<div class="span4"><label for="basicPackage"></label><input id="basicPackage" type="radio" name="packagename" value="basic">Basic</div>
				<div class="span4"><label for="premiumPackage"></label><input id="premiumPackage" type="radio" name="packagename" value="premium">Premium</div>
				<div class="span4"><label for="helpmeChoose"></label><input id="helpmeChoose" type="radio" name="packagename" value="">Help me Choose</div>
			</div>
	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	    <button id="packageSelector" class="btn btn-primary disabled">Choose a Package</button>
	  </div>
	</div>
	<c:if test="${not empty listOfITReturnHomePageView}">
		<table class="table table-striped table-hover">
			<tr>
				<th>PAN</th>
				<th><fmt:message key="member.homepage.lastname"/></th>
				<th>FY</th>
				<th>Filing As</th>
				<th>Package</th> 
				<th>Return Type</th>
				<th>Mode</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listOfITReturnHomePageView}" var="anEntry">
                   <c:if test="${not empty anEntry.lastOrOrgName}">
				<tr>
					<td class="pan">
						<hst:link var="viewLink" path="/vendor/itreturn/${anEntry.canonicalUUID}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${fn:toLowerCase(anEntry.pan)}/servicerequest-itr.html"/>
						<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${anEntry.pan}"/></a></span>
					</td>
					<td class="pan"><b><c:out value="${anEntry.lastOrOrgName}"/></b></td>
					<td class="filingStatus decimal"><span><c:out value="${anEntry.financialYear}"/></span></td>
					<td class="filingStatus decimal"><c:out value="${anEntry.filingStatus}"/></td>
					<td><fmt:message key="${anEntry.ITRForm}.packageName"/></td>
					<td class="filingStatus"  style="text-transform:capitalize;"><c:out value="${anEntry.itReturnType}"/></td>
					<td><fmt:message key="ITRServiceDelivery.${anEntry.ITRFormMode}.displayName"/></td>
					<td>
						<hst:link var="viewLink" path="/vendor/itreturn/${anEntry.canonicalUUID}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-summary.html"/>
						<%--<span style=""><a href="${viewLink}">Continue Filing</a></span>--%>
						<div class="btn-group">
			                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="${viewLink}">Continue Filing</a></li>
			                  <c:if test="${anEntry.ITRFormMode == 'DIY'}">
				                  <li class="divider"></li>
				                  <li><a href="<hst:link path="/vendor/itreturn/${anEntry.canonicalUUID}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-download-summary.html"/>">Download Summary</a></li>
				                  <li><a href="<hst:link  path="/vendor/itreturn/${anEntry.canonicalUUID}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-download-xml.html" />">Download XML</a></li>
				                  <li><a href="<hst:link  path="/vendor/itreturn/${anEntry.canonicalUUID}/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-email-xml-summary.html"/>?email=${anEntry.email}">Email Summary and XML</a></li>
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
</div>
<%--
<res:client-validation formSubmitButtonId="myModalHref" screenConfigurationDocumentName="itreturnhomepage" formId="frmdata" fieldOneID="pan" fieldTwoID="pi_last_name" validationType="pan"></res:client-validation>
 --%>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		$("#myModalHref").click( function () {			
			$("#frmSearch").submit();
		});		
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>

