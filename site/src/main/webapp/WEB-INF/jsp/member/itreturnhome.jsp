<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<div class="page">	
	<h4>Prepare Income Tax Return for FY:<c:out value="${financialYear}"/></h4>
	<hst:actionURL var="actionURL"/>
	<form id="frmdata" method="post" action="${actionURL}">
		<fieldset>
			<legend>Start preparing New Return - Fill up this form and <a id="myModalHref" role="button" class="btn orange" data-toggle="modal">Click Here!! </a></legend>
			<div class="row-fluid show-grid">
		          <div class="span3"><input id="pan" name="pan" placeholder="PAN" type="text" maxlength="10"/></div>
		          <!-- <div class="span2"><input id="pi_first_name" name="pi_first_name" placeholder="First Name" type="text"/></div>	      
		          <div class="span1"><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text"/></div>
		           -->
		          <div class="span3"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text"/></div>	          
			   	  <div class="span3"><input id="pi_dob" name="pi_dob" placeholder="DOB" type="text" maxlength="10"/></div>
		          <div class="span3"><select id="pi_return_type" name="pi_return_type"><option value="">Select Type</option><option value="original">Original</option><option value="revised">Revised</option></select></div>
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
			<tr>
				<td colspan="4"><b>Original Returns</b></td>
			</tr>
			<c:forEach items="${pansForMember}" var="panForMember">				
				<%
					HippoFolder hf = (HippoFolder) pageContext.getAttribute("panForMember");
					String financialYear = (String) request.getAttribute("financialYear");
					String itReturnType = "original";
					String relPath = financialYear + "/" + itReturnType + "/" + MemberPersonalInformation.class.getSimpleName().toLowerCase();
				    //out.println(relPath);
				    MemberPersonalInformation memberPersonalInfo =  hf.getBean(relPath,MemberPersonalInformation.class);
				    if (memberPersonalInfo != null) {
				    	request.setAttribute("memberPersonalInfo",memberPersonalInfo);
				    }
				    else {
				    	request.removeAttribute("memberPersonalInfo");
				    }				    
				%>
				<c:if test="${not empty  memberPersonalInfo}">
					<tr>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${financialYear}/original/${panForMember.name}/personalinformation.html"/>			
							<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${panForMember.name}"/></a></span>		
						</td>
						<td><c:out value="${memberPersonalInfo.filingStatus}"/></td>
						<td><c:out value="${memberPersonalInfo.name}"/></td>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${financialYear}/original/${panForMember.name}/personalinformation.html"/>
							<span style="font-size:10px;"><a href="${viewLink}">Continue</a></span>		
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<!--  duplicating logic will cleanup later -->
			<tr>
				<td colspan="4"><b>Revised Returns</b></td>
			</tr>
			<c:forEach items="${pansForMember}" var="panForMember">				
				<%
					HippoFolder hf = (HippoFolder) pageContext.getAttribute("panForMember");
					String assessmentYear = (String) request.getAttribute("financialYear");
					String itReturnType = "revised";
					String relPath = assessmentYear + "/" + itReturnType + "/" + MemberPersonalInformation.class.getSimpleName().toLowerCase();
				    //out.println(relPath);
				    MemberPersonalInformation memberPersonalInfo =  hf.getBean(relPath,MemberPersonalInformation.class);
				    if (memberPersonalInfo != null) {
				    	request.setAttribute("memberPersonalInfo",memberPersonalInfo);
				    }
				    else {
				    	request.removeAttribute("memberPersonalInfo");
				    }
				%>
				<c:if test="${not empty  memberPersonalInfo}">
					<tr>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${financialYear}/revised/${panForMember.name}/personalinformation.html"/>			
							<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${panForMember.name}"/></a></span>		
						</td>
						<td><c:out value="${memberPersonalInfo.filingStatus}"/></td>
						<td><c:out value="${memberPersonalInfo.name}"/></td>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${financialYear}/revised/${panForMember.name}/personalinformation.html"/>
							<span style="font-size:10px;"><a href="${viewLink}">Continue</a></span>		
						</td>
					</tr>
				</c:if>
			</c:forEach>			
		</table>		
	</c:if>
</div>
<res:client-validation screenConfigurationDocumentName="itreturnhomepage" formId="frmdata"></res:client-validation>
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
			$("#myModal").modal();
		});
		$("#packageSelector").click (function(t) {
			if (selectedPackage == null) return;
			$("#frmdata").validate();
			if (!$("#frmdata").valid()) return false;
			$("#frmdata").submit();
		 	//var hstMainURL = "<hst:link path="/"/>";
		 	
		 	//url = hstMainURL + "/member/itreturn/" + selectedPackage + "/<c:out value="${financialYear}"/>/" + $("#pi_return_type").val() + "/" + $("#pan").val().toLowerCase() + "/personalinformation.html";
		 	//window.location.href=url;
		});
	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>		

