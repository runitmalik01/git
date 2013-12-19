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
	<h4>Prepare Income Tax Return for Individuals and/or HUF</h4>
	<hst:actionURL var="actionURL"/>
	<form id="frmdata" method="post" action="${actionURL}">
     <div id="error" class="alert alert-danger" style="display:none;"><fmt:message key="err.valid.lastName.with.pan"/></div>
     <div id="strictmsg" class="alert hide">Please enter PAN number for Individual or HUF</div>
	 <div id="ditPanInvalid" class="alert alert-danger <c:if test="${empty noPanMatchFound}">hide</c:if>"><strong><fmt:message key="err.match.pan.dit"/></strong></div>
	 <div id="lastNameInvalid" class="alert alert-danger hide"><strong><fmt:message key="err.match.last.name.dit"/></strong></div>
		<fieldset>
			<legend><fmt:message key="member.homepage.fillform"/> </legend>
			<div class="row show-grid">
		          <div class="col-md-2">
		          	<div class="rowlabel"><label for="pan"><small>PAN</small></label></div>
		          	<div class="rowlabel"><input id="pan" name="pan" placeholder="PAN" type="text" maxlength="10" class="uprcase strict"/></div>
		          </div>
		          <div class="col-md-3">
		          	<div class="rowlabel"><label for="pi_last_name"><small><fmt:message key="member.homepage.lastname"/></small></label></div>
		          	<div class="rowlabel"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" class="uprcase"/></div>
		          </div>
		          <div class="col-md-3">
		          <div class="rowlabel"><label for="pi_mobile"><small><fmt:message key="member.homepage.mobileNo"/></small></label></div>
		          <div class="rowlabel"><input id="pi_mobile" name="pi_mobile" placeholder="Mobile Number" type="text" class="uprcase"/></div>
		          </div>
		          <%--
		          <div class="col-md-3">
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
		          --%>
		          <%-- 
		          <div class="col-md-2">
		            <div class="rowlabel"><label for="pi_return_type"><small>Return Type</small></label></div>
		          	<div class="rowlabel">
		            <select id="pi_return_type" name="pi_return_type" style="text-transform: uppercase;"><option value="">Select Type</option><option value="original">Original</option><option value="revised">Revised</option></select>
		           </div>
		          </div>
		          --%>
		          <div class="col-md-2">
		          	<div class="rowlabel"><label for="fy"><small>Financial Year</small></label></div>
		          	<div class="rowlabel">
			          	<select id="fy" name="fy" style="text-transform: uppercase;">
			          		<% 
			          			for (FinancialYear fy: FinancialYear.values()) {
			          				if (fy.isActive() && fy != FinancialYear.UNKNOWN) {
			          		%>
			          			<option value="<%=fy.getDisplayName()%>"><%=fy.getDisplayName()%></option>
			          			<%--<option value="2013-2014">2013-2014</option> --%>
			          		<% }
			          				} %>
			          		<%--<option value="2011-2012">2011-2012</option><option value="2011-2012">2010-2011</option> --%>
			          	</select>
		          	</div>
		          </div>
		     </div>
		     <div align="center" ><a id="myModalHref" class="btn btn-default <c:choose><c:when test="${empty noPanMatchFound}">orange</c:when><c:otherwise>btn-danger</c:otherwise></c:choose> ">Click Here!! </a></div>
		</fieldset>

                <!--   <fieldset id="ul_revised" style="display:none;" class="revised_v original_h">
                        <legend>Revised Return Details</legend>
                        <div class="row show-grid" id="ul_revised_input">
                            <div class="col-md-3">
                            	<div class="rowlabel"><label for="ack_no"><small>Original Ack No</small></label></div>
                            	<div class="rowlabel"><input id="ack_no" name="ack_no" placeholder="Enter Original Ack No" type="text"/></div>
                            </div>
                            <div class="col-md-2">
                            	<div class="rowlabel" id="ack_date_label"><label for="ack_date"><small>Original Ack Date</small></label></div>
                            	<div class="rowlabel"><input id="ack_date" name="ack_date" placeholder="Enter Ack Date" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
                            </div>
                            <div class="col-md-2">
                            	<div class="rowlabel"><label for="defective"><small><abbr title="Defective Return (U/s-139)">Defective?</abbr></small></label></div>
                            	<div class="rowlabel"><select id="defective" name="defective"><option value="">Select</option><option value="N">No</option><option value="Y">Yes</option></select></div>
                            </div>
                            <div class="col-md-3 defective_Y_v defective_N_h" style="display:none">
                            	<div class="rowlabel"><label for="ack_date"><small>Notice No(U/s-139)</small></label></div>
                            	<div class="rowlabel"><input id="notice_no" name="notice_no" placeholder="Enter Notice No" type="text"/></div>
                            </div>
                            <div  class="col-md-2 defective_Y_v defective_N_h" style="display:none">
                            	<div class="rowlabel"><label for="ack_date"><small>Notice Date(U/s-139)</small></label></div>
                            	<div class="rowlabel"><input id="notice_date" name="notice_date" maxlength="10" placeholder="Enter Notice Date" type="text"/></div>
	                        </div>
                        </div>
                 </fieldset> -->
	</form>
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">Choose a package which suits your need</h3>
			  </div>
			  <div class="modal-body">
					<div class="row show-grid">
						<div class="col-md-4"><label for="basicPackage"></label><input id="basicPackage" type="radio" name="packagename" value="basic">Basic</div>
						<div class="col-md-4"><label for="premiumPackage"></label><input id="premiumPackage" type="radio" name="packagename" value="premium">Premium</div>
						<div class="col-md-4"><label for="helpmeChoose"></label><input id="helpmeChoose" type="radio" name="packagename" value="">Help me Choose</div>
					</div>
			  </div>
			  <div class="modal-footer">
			    <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Close</button>
			    <%--<button class="btn btn-default disabled button olive">I choose Premium Package</button> --%>
			    <button id="packageSelector" class="btn btn-default btn-primary disabled">Choose a Package</button>
			  </div>
			</div>
		</div>
	</div>
	<c:set var="basePath" scope="request" value="member"/>
	<jsp:include page="../itreturns/itreturnshome-common-results.jsp"/>
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
	<c:if test="${not empty valiPanWithLastNameError && valiPanWithLastNameError == 'true'}">
	  $('#error').show();
	</c:if>
	<%--
	function getSection(){
		var option=document.getElementById("ReturnSection");
		var sectionName = option.options[option.selectedIndex].value;
		if(sectionName=="17" || sectionName == "18"){
		$("#pi_return_type").val("revised");
		} else{
		$("#pi_return_type").val("original");
		}
		}
	 --%>
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>

