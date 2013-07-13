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
	 %>
<div class="page">
	<h4>Prepare Income Tax Return for Individuals and/or HUF</h4>
	<hst:actionURL var="actionURL"/>
	<form id="frmdata" method="post" action="${actionURL}">
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
		          <!-- 	<select id="pi_return_type" readonly="readonly" name="pi_return_type" style="text-transform: uppercase;"><option value="">Select Type</option><option value="original">Original</option><option value="revised">Revised</option></select>
		           --><input type="text" id="pi_return_type" readonly="readonly" name="pi_return_type" class="uprcase">
		           </div>
		          </div>
		          <div class="span2">
		          	<div class="rowlabel"><label for="fy"><small>Financial Year</small></label></div>
		          	<div class="rowlabel"><select id="fy" name="fy" style="text-transform: uppercase;"><option value="2012-2013">2012-2013(Current)</option>
		          		<%--<option value="2011-2012">2011-2012</option><option value="2011-2012">2010-2011</option> --%>
		          	</select></div>
		          </div>
		     </div>
		     <div align="center" ><a id="myModalHref" class="btn orange">Click Here!! </a></div>
		</fieldset>

                <!--   <fieldset id="ul_revised" style="display:none;" class="revised_v original_h">
                        <legend>Revised Return Details</legend>
                        <div class="row-fluid show-grid" id="ul_revised_input">
                            <div class="span3">
                            	<div class="rowlabel"><label for="ack_no"><small>Original Ack No</small></label></div>
                            	<div class="rowlabel"><input id="ack_no" name="ack_no" placeholder="Enter Original Ack No" type="text"/></div>
                            </div>
                            <div class="span2">
                            	<div class="rowlabel" id="ack_date_label"><label for="ack_date"><small>Original Ack Date</small></label></div>
                            	<div class="rowlabel"><input id="ack_date" name="ack_date" placeholder="Enter Ack Date" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
                            </div>
                            <div class="span2">
                            	<div class="rowlabel"><label for="defective"><small><abbr title="Defective Return (U/s-139)">Defective?</abbr></small></label></div>
                            	<div class="rowlabel"><select id="defective" name="defective"><option value="">Select</option><option value="N">No</option><option value="Y">Yes</option></select></div>
                            </div>
                            <div class="span3 defective_Y_v defective_N_h" style="display:none">
                            	<div class="rowlabel"><label for="ack_date"><small>Notice No(U/s-139)</small></label></div>
                            	<div class="rowlabel"><input id="notice_no" name="notice_no" placeholder="Enter Notice No" type="text"/></div>
                            </div>
                            <div  class="span2 defective_Y_v defective_N_h" style="display:none">
                            	<div class="rowlabel"><label for="ack_date"><small>Notice Date(U/s-139)</small></label></div>
                            	<div class="rowlabel"><input id="notice_date" name="notice_date" maxlength="10" placeholder="Enter Notice Date" type="text"/></div>
	                        </div>
                        </div>
                 </fieldset> -->
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
	    <%--<button class="btn disabled button olive">I choose Premium Package</button> --%>
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
						<hst:link var="viewLink" path="/member/itreturn/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr.html"/>
						<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${anEntry.pan}"/></a></span>
					</td>
					<td class="pan"><b><c:out value="${anEntry.lastOrOrgName}"/></b></td>
					<td class="filingStatus decimal"><span><c:out value="${anEntry.financialYear}"/></span></td>
					<td class="filingStatus decimal"><c:out value="${anEntry.filingStatus}"/></td>
					<td><fmt:message key="${anEntry.ITRForm}.packageName"/></td>
					<td class="filingStatus"  style="text-transform:capitalize;"><c:out value="${anEntry.itReturnType}"/></td>
					<td><fmt:message key="ITRServiceDelivery.${anEntry.ITRFormMode}.displayName"/></td>
					<td>
						<hst:link var="viewLink" path="/member/itreturn/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-summary.html"/>
						<%--<span style=""><a href="${viewLink}">Continue Filing</a></span>--%>
						<div class="btn-group">
			                <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li><a href="${viewLink}">Continue Filing</a></li>
			                  <li class="divider"></li>
			                  <li><a href="<hst:link path="/member/itreturn/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-download-summary.html"/>">Download Summary</a></li>
			                  <li><a href="<hst:link  path="/member/itreturn/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-download-xml.html" />">Download XML</a></li>
			                  <li><a href="<hst:link  path="/member/itreturn/${anEntry.financialYear.displayName}/${anEntry.itReturnType.displayName}/${anEntry.pan}/servicerequest-itr-email-xml-summary.html" />">Email Summary and XML</a></li>
			                </ul>
			             </div>
					</td>
				</tr></c:if>
			</c:forEach>
		</table>
	</c:if>
</div>
<res:client-validation formSubmitButtonId="myModalHref" screenConfigurationDocumentName="itreturnhomepage" formId="frmdata" fieldOneID="pan" fieldTwoID="pi_last_name" validationType="pan"></res:client-validation>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		var selectedPackage = null;
		$("#basicPackage").click(function (t) {
			if (this.checked) {
				selectedPackage=this.value;
				$("#packageSelector").button("reset");
			}
		});
		$("#premiumPackage").click(function (t) {
			if (this.checked) {
				selectedPackage=this.value;
				$("#packageSelector").button("reset");
			}
		});
		$("#helpmeChoose").click(function (t) {
			if (this.checked) {
				selectedPackage = null;
				$("#packageSelector").toggleClass("disabled",true);
			}
		});
		/*$("#myModalHref").click( function() {
			$("#frmdata").validate();
			if (!$("#frmdata").valid()) return false;
			$("#frmdata").submit();
			//$("#myModal").modal();
		});*/
		$('#pi_return_type').change(function(){
			$('.' + $(this).val() + '_v').show();
			$('.' + $(this).val() + '_h').hide();
		});
		$('#defective').change(function(){
			$('.defective_' + $(this).val() + '_v').show();
			$('.defective_' + $(this).val() + '_h').hide();
		});
		$("#packageSelector").click (function(t) {
			if (selectedPackage == null) return;
			$("#frmdata").validate();
			if (!$("#frmdata").valid()) return false;
			$("#frmdata").submit();
		});

	});
	function getSection(){
		var option=document.getElementById("ReturnSection");
		var sectionName = option.options[option.selectedIndex].value;
		if(sectionName=="17" || sectionName == "18"){
		$("#pi_return_type").val("revised");
		} else{
		$("#pi_return_type").val("original");
		}
		}
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>

