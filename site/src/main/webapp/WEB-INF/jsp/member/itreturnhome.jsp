<%@page import="java.util.List"%>
<%@page import="com.mootly.wcm.model.FinancialYear"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<div class="page">	
	<h4>Prepare Income Tax Return</h4>
	<hst:actionURL var="actionURL"/>
	<form id="frmdata" method="post" action="${actionURL}">
		<fieldset>
			<legend>Start preparing New Return - Fill up this form and <a id="myModalHref" class="btn orange">Click Here!! </a></legend>
			<div class="row-fluid show-grid">
		          <div class="span3">
		          	<div class="rowlabel"><label for="pan"><small>PAN</small></label></div>
		          	<div class="rowlabel"><input id="pan" name="pan" placeholder="PAN" type="text" maxlength="10"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="pi_last_name"><small>Last Name/Org Name</small></label></div>
		          	<div class="rowlabel"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text"/></div>
		          </div>	      
		          <div class="span3">    
		            <div class="rowlabel"><label for="pi_return_type"><small>Return Type</small></label></div>
		          	<div class="rowlabel"><select id="pi_return_type" name="pi_return_type" ><option value="">Select Type</option><option value="original">Original</option><option value="revised">Revised</option></select></div>
		          </div>
		          <div class="span3"> 
		          	<div class="rowlabel"><label for="fy"><small>Financial Year</small></label></div>
		          	<div class="rowlabel"><select id="fy" name="fy"><option value="2012-2013">2012-2013(Current)</option><option value="2011-2012">2011-2012</option><option value="2011-2012">2010-2011</option></select></div>
		          </div>
			 </div>
		 </fieldset>	
                 <fieldset id="ul_revised" style="display:none;" class="revised_v original_h">
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
                 </fieldset> 
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
	<c:if test="${not empty pansForMember}">	
		<table>
			<tr>
				<th>PAN</th>
				<th>Filing As</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${pansForMember}" var="panForMember">			
				<tr>
					<td colspan="4" class="pan"><b><c:out value="${panForMember.name}"/></b></td>
				</tr>	
				<%
					HippoFolder hf = (HippoFolder) pageContext.getAttribute("panForMember");
					//children of hf will be financialyear
					List<HippoFolder> financialYearList = hf.getChildBeans(HippoFolder.class);
					pageContext.setAttribute("financialYearList",financialYearList);
				%>
					<c:forEach items="${financialYearList}" var="financialYear">
						<%
							HippoFolder financialYearFolder = (HippoFolder) pageContext.getAttribute("financialYear");
							List<HippoFolder> itReturnTypeList = financialYearFolder.getChildBeans(HippoFolder.class);
							pageContext.setAttribute("itReturnTypeList",itReturnTypeList);
						%>
						<tr>
							<td colspan="4" class="pan"><b><c:out value="${financialYear.name}"/></b></td>
						</tr>	
						<c:forEach items="${itReturnTypeList}" var="itReturnType">
							<%
								HippoFolder itReturnTypeFolder = (HippoFolder) pageContext.getAttribute("itReturnType");
								MemberPersonalInformation memberPersonalInformation = itReturnTypeFolder.getBean("memberpersonalinformation");
								pageContext.setAttribute("memberPersonalInformation",memberPersonalInformation);
							%>
							<tr>
								<td colspan="4" class="pan"><b><c:out value="${itReturnType.name}"/></b></td>
							</tr>	
							<c:if test="${not empty  memberPersonalInformation}">
								<tr>
									<td>
										<hst:link var="viewLink" path="/member/itreturn/${financialYear.name}/${itReturnType.name}/${panForMember.name}/personalinformation.html"/>			
										<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${panForMember.name}"/></a></span>		
									</td>
									<td><c:out value="${memberPersonalInformation.filingStatus}"/></td>
									<td><c:out value="${memberPersonalInformation.name}"/></td>
									<td>
										<hst:link var="viewLink" path="/member/itreturn/${financialYear.name}/${itReturnType.name}/${panForMember.name}/personalinformation.html"/>
										<span style="font-size:10px;"><a href="${viewLink}">Continue</a></span>		
									</td>
								</tr>
							</c:if>
						</c:forEach>						
					</c:forEach>														
			</c:forEach>	
		</table>		
	</c:if>
</div>
<res:client-validation  screenConfigurationDocumentName="itreturnhomepage" formId="frmdata"></res:client-validation>
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
		$("#myModalHref").click( function() {
			$("#frmdata").validate();
			if (!$("#frmdata").valid()) return false;
			$("#frmdata").submit();
			//$("#myModal").modal();
		});
		$('#pi_return_type').change(function(){			
			$('.' + $(this).val() + '_v').show();
			$('.' + $(this).val() + '_h').hide();
		});
		$('#defective').change(function(){
			$('.defective_' + $(this).val() + '_v').show();
			$('.defective_' + $(this).val() + '_h').hide();
		});

        if (Modernizr.touch && Modernizr.inputtypes.date) {
	        document.getElementById('ack_date').type = 'date';
                              document.getElementById('notice_date').type = 'date';
	    } else {
	        $('#ack_date').datepicker({
                  changeMonth: true,
                  changeYear: true,
                  maxDate: "+0M +15D",
                  yearRange: "1900:2013"
                 });  
               $('#notice_date').datepicker({
                  changeMonth: true,
                  changeYear: true,
                  maxDate: "+0M +15D",
                  yearRange: "1900:2013"
                 });
	    }
		$("#packageSelector").click (function(t) {
			if (selectedPackage == null) return;
			$("#frmdata").validate();
			if (!$("#frmdata").valid()) return false;
			$("#frmdata").submit();
		});
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>		

