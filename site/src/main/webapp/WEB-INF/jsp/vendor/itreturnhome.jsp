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
ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap objTreeMapSection = (TreeMap) objValueListService.getReturnFile();
	request.setAttribute("objTreeMapSection", objTreeMapSection);
	pageContext.setAttribute("filingSectionValues", FilingSection.values());
	String serviceItemKey= null;
	String deliveryEmail = request.getUserPrincipal().getName();
	 %>
	 
<div class="page">
	<h4>Vendor IT Return Home</h4>
	<%-- <c:if test="${strIsOnVendorPortal eq true}"><w4india:reseller-menu></w4india:reseller-menu></c:if> --%>
	 <c:if test="${not empty strIsOnVendorPortal && strIsOnVendorPortal =='true' && isVendor =='true'}">
	 	<c:if test="${not empty  bulk_download_xml_paths}">
	 		<h5>Selected for Bulk XML download</h5>
	 		<ul>
	    	<c:forEach items="${bulk_download_xml_paths}" var="aPath">
	    		<li><c:out value="${aPath}"/></li>
	    	</c:forEach>
	    	</ul>
	    	<a href="itreturn/servicerequest-itr-bulk-xml-download.html">Download Bulk XML Returns</a>
    	</c:if>
    </c:if>
	<form id="frmSearch" method="GET" class="">
		<input type="hidden" name="pageNumber" value="${params.pageNumber}"/>
		<fieldset>
			<legend><fmt:message key="member.homepage.fillform"/> </legend>
			<div class="row-fluid show-grid">
			  <div class="rowlabel">
		           <div class="input-append span10">
                     <input id="query" class="span10" name="query" placeholder="Search String" type="text" maxlength="50" value="${params.query}"/>
                     <button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i>Search</button>
                     <!--<div class="btn-group">
                      <button class="btn btn-primary" id="filter-name" type="button" data-toggle="dropdown">Filter<span class="caret"></span></button>
                        <ul class="dropdown-menu">
                          <li><a href="#" id="SalaryIncome" class="search-doc-filter">SalaryIncome</a></li>
                          <li><a href="#" id="Deduction" class="search-doc-filter">Deduction</a></li>
                          <li><a href="#" id="FormSixteen" class="search-doc-filter">FormSixteen</a></li>
                          <li><a href="#" id="None" class="search-doc-filter">None</a></li>
                        </ul>
                      </div>
                       <input name="search-filter" id="search-filter" value="${search-filter}" class="span2 hide" type="hidden"/>  -->
                   </div>
               </div>
		    </div>
		   <c:if test="${not empty valueListDocument}">
		    <div class="row-fluid show-grid">
		      <div class="rowlabel">
		       <div class="btn-group" data-toggle="buttons-checkbox">
		        <c:forEach items="${valueListDocument.valueListDocumentDetailList}" var="valueListDetail">
		         <button class="btn btn-warning" id="${valueListDetail.key}">${valueListDetail.label}</button>
		        </c:forEach>
		         <button class="btn btn-warning" id="all">All</button>
		         </div>
		      </div>
		    </div></c:if>
		 </fieldset>
		<c:choose>
			<c:when test="${not empty docs && not empty listOfITReturnHomePageView}">
				<c:if test="${not empty query}">
					<div class="alert alert-success" align="center">
						<strong>Showing Search Results for all members having <c:out value="${fn:toUpperCase(query)}" />.</strong>
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<div class="alert alert-error" align="center"><strong>No search Result has been found.</strong></div>
			</c:otherwise>
		</c:choose>
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
	<c:set var="basePath" scope="request" value="vendor"/>
	<jsp:include page="../itreturns/itreturnshome-common-results.jsp"/>
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
		url_query = '<c:out value="${query}"/>';
		if(url_query != ''){
		  $('#'+url_query).removeClass('btn-warning');
		  $('#'+url_query).addClass('btn-success');
		}else{
		  if($('#'+url_query).find('.btn-success')){
		    $('#'+url_query).removeClass('btn-success');
		    $('#'+url_query).addClass('btn-warning');
		  }
		}
		<c:forEach items="${valueListDocument.valueListDocumentDetailList}" var="valueListDetail">
		   var freeText = '<c:out value="${valueListDetail.key}"/>'
		   $('#'+freeText).on('click',function(){
		      $('#query').val($(this).attr('id'));
		      $("#frmSearch").submit();
		   });
		</c:forEach>
		/*$('#due,#verified,#unverified,#diy,#assisted,#itr1,#itr2,#itr3,#itr4').on('click',function(){
		   $('#query').val($(this).attr('id'));
		   $("#frmSearch").submit();
		});*/
		$('#all').on('click',function(){
		   $('#query').val('');
		   $("#frmSearch").submit();
		});
		$('.search-doc-filter').on('click',function(){
		  $('#search-filter').val($(this).attr('id'));
		  $('#filter-name').html($(this).attr('id')+"<span class=\"caret\"></span>");
		});
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
<hst:headContribution keyHint="formCss" category="css">
	<link rel="stylesheet" href="<hst:link path="/css/switch-On-Off.css"/>" type="text/css" />
</hst:headContribution>
