<%@include file="../includes/tags.jspf" %>
<c:set var="startapplication">
   <fmt:message key="member.start.application"/>
</c:set>
<hippo-gogreen:title title="${ startapplication}"/>
<res:breadcrumb/>	
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
	String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("personal","contact");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error"><fmt:message key="${item.value}" /></div>
	</c:forEach>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">	
	<h4>Personal and Contact Information</h4>
	<form id="frmPersonalInfo" action="${actionUrl}" method="post" name="pi">
		<fieldset>
			  <legend>Name & Gender</legend>
		      <div class="row-fluid show-grid">	        			 
		          <div class="span3"><input id="pi_first_name" name="pi_first_name" placeholder="First Name" type="text" value="<c:if test="${not empty parentBean.firstName}"><c:out value="${parentBean.firstName}"/></c:if>"/></div>
		          <div class="span2"><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>	         
		          <div class="span2"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:if test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:if>"/></div>
		          <!--  <div class="span1">Gender</div>  -->
		          <div class="span2"><input id="pi_dob" name="pi_dob" placeholder="DOB" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
		          <div class="span2">
					<select id="gender" name="gender"><option value="">Select Gender</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'M'}">selected</c:if> value="M">Male</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'F'}">selected</c:if> value="F">Female</option></select>
		          </div>       
			  </div>
		 </fieldset>
		 <fieldset>
			 <legend>Address & Contact Information</legend>
			 <div class="row-fluid show-grid">	   
			   	  <div class="span6"><input id="pi_flat_door_building" value="${parentBean.flatDoorBuilding}" name="pi_flat_door_building" placeholder="Flat/Door/Building" type="text"  value="<c:if test="${not empty parentBean.flatDoorBuilding}"><c:out value="${parentBean.flatDoorBuilding}"/></c:if>"/></div>
			   	  <div class="span6"><input id="pi_road_street" value="${parentBean.roadStreet}" name="pi_road_street" placeholder="Road/Street" type="text"/></div>
			  </div>
			  <div class="row-fluid show-grid">	   
		          <div class="span4"><input id="pi_area_locality" value="${parentBean.areaLocality}" name="pi_area_locality" placeholder="Area/Locality" type="text"/></div>
		          <div class="span3"><input id="pi_town_city_district" value="${parentBean.townCityDistrict }" name="pi_town_city_district" placeholder="Town/City/District" type="text"/></div>
		          <div class="span1"><input id="pi_state" value="${parentBean.state}" name="pi_state" placeholder="State" type="text"/></div>
		          <div class="span2"><input id="pi_pin_code" value="${parentBean.pinCode}" name="pi_pin_code" placeholder="PIN Code" type="text" maxlength="10"/></div>
			 </div>			
			 <div class="row-fluid show-grid">	
			 	  <div class="span2"><input id="std" value="${parentBean.stdCode}" name="pi_std_code"  placeholder="STD"  type="text" maxlength="10"/></div>
		          <div class="span3"><input id="phone" value="${parentBean.phone}" name="pi_phone"  placeholder="Phone Number"  type="text" maxlength="10"/></div>
		          <div class="span3"><input id="mobile" value="${parentBean.mobile}" name="pi_mobile"  placeholder="Mobile Phone Number"  type="text" maxlength="10"/></div>
		          <div class="span4">
			          	<div class="input-prepend">
					      <span class="add-on"><i class="icon-envelope"></i></span>
					      <input id="pi_email" value="${parentBean.email}" name="pi_email" placeholder="Email Address" type="text"/>
	    				</div>
    			  </div>
		     </div>
		</fieldset>
		<fieldset>
		<legend><fmt:message key="member.residential.status" /></legend>
		<div class="page">
				<h5>
					<small><fmt:message key="member.resi.status.sentence" /></small>
				</h5>
				<script>
					var qs = <c:out value="${jsonObject}" escapeXml="false"/>
				</script>
				<div class="row-fluid show-grid">
					<div class="span10">
						<c:out value="${map['rsstatus_q']}" />
					</div>
					<div class="span2">
						<select class="answer" id="rsstatus_q" name="rsstatus_q">
							<option>Select</option>
							<option value="yes">Yes</option>
							<option value="no">No</option>
						</select>
					</div>
				</div>
				<c:forEach items="${map}" var="item" varStatus="status">
					<c:if test="${item.key != 'rsstatus_q'}">
						<c:set var="pageItemValue" value="${item.value}"/>
						<%				
							pageContext.setAttribute("isAnswer","false");
							String pageItemValue =  (String) pageContext.getAttribute("pageItemValue");
							if (pageItemValue != null && pageItemValue.startsWith("ans_")) {
								pageContext.setAttribute("isAnswer","true");
							}
						%>				
							<div class="row-fluid show-grid" id="ul_<c:out value="${item.key}"/>" style="display:none;visiblity:hidden">
								<div class="span10">
									<c:choose>
										<c:when test="${fn:startsWith(item.value,'ans_')}">
											<br/><p id="resi<c:out value="${status.index}" />" style="color:#65B43D;" align="center">
											<b><c:out value="${fn:replace(item.value,'ans_','')}"/></b></p>
										</c:when>
										<c:otherwise>
											<c:out value="${item.value}"/>
										</c:otherwise>
									</c:choose>
								<c:if test="${fn:startsWith(item.value,'ans_')}">
								</c:if>
								</div>
								<div class="span2">
									<c:if test="${isAnswer != 'true'}">
										<select class="answer" id="<c:out value="${item.key}"/>" name="<c:out value="${item.key}"/>">
											<option>Select</option>
											<option value="yes">Yes</option>
											<option value="no">No</option>
										</select>
									</c:if>
								</div>
							</div>					
					</c:if>
				</c:forEach>	
            </div>
			<c:if test="${not empty parentBean }">
				<c:if test="${not empty fetchmap}">
					<c:forEach items="${fetchmap}" var="item" varStatus="stat">
						<c:if test="${fn:contains(item.value,'yes') || fn:contains(item.value,'no') }">
							<c:set var="myVar" value="${stat.first ? '' : myVar}${item.value}_" />
						</c:if>
					</c:forEach>
				</c:if>
			</c:if>
			<c:set var="len" value="${fn:length(myVar)}"/>
			<c:set  var="modmyVar" value="${fn:substring(myVar,0,len-1)}"/>
			<c:if test="${not empty parentBean }">
				<c:if test="${not empty fetchmap}">
					<c:forEach items="${fetchmap}" var="fitem">
						<c:set var="fmapkey" value="${fitem.key}" />
						<c:set var="fmapvalue" value="${fitem.value}" />
						<script type="text/javascript">
							var fmapkey = '<c:out value="${fmapkey}"/>';
							var fmapvalue = '<c:out value="${fmapvalue}"/>';
							var myVar = '<c:out value="${modmyVar}"/>';
							if (fmapvalue.match("yes") || fmapvalue.match("no")) {
								$('#' + fmapkey).val(fmapvalue);
								$("#ul_" + fmapkey).css("display", "block");
								$("#ul_" + fmapkey).css("visibility", "visible");
							}
							$("#ul_rsstatus_q_" + myVar).css("display", "block");
							$("#ul_rsstatus_q_" + myVar).css("visibility", "visible");
						</script>
					</c:forEach>
				</c:if>
			</c:if>
		</fieldset>
		<fieldset>
			<legend>
				<fmt:message key="member.bank.detail" />
			</legend>
			<div class="page">
				<h5>Do you want to add Bank Detail now (for Refund and/or Tax payment). You can always add this detail later.</h5>
				<a href="#myModal" role="button" class="btn" data-toggle="modal">ADD Bank Detail</a>
				<!-- Modal -->
				<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
						<h3 id="myModalLabel">Bank Detail</h3>
					</div>
					<div class="modal-body">
						<fieldset>
							 <label><fmt:message key="member.bank.detail.bank.name" /></label>
						  <input type="text" id="bd_bank_name" name="bd_bank_name" value="${parentBean.BD_BANK_NAME}" data-toggle="tooltip" title="Enter Name of Bank"maxlength="25" min="1" required="required" /><br/>
				             <label><fmt:message key="member.bank.detail.micr.code"/></label> 
				          <input type="text" name="bd_micr_code"value="${parentBean.BD_MICR_CODE}" title="Enter 9-Digit valid MICR Code" maxlength="9" class="numberinput" required="required" /><br/>
			                 <label><fmt:message key="member.bank.detail.bank.branch" /></label>
				          <input type="text" name="bd_Branch_name" value="${parentBean.BD_ADD_BANK_BRANCH}" title="Enter Name of Bank's Branch" maxlength="120" required="required" /> <br/>
				             <label><fmt:message key="member.bank.detail.acc.type"/></label> 
				          <select name="bd_account_type" title="Select Type of Account" id="bd_account_type">
					         <option value=""></option>
					         <option <c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'SAV'}">selected</c:if> value="SAV">
						         <fmt:message key="member.bank.detail.acc.type.saving"/></option>
					         <option <c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'CUR'}">selected</c:if> value="CUR" >
						         <fmt:message key="member.bank.detail.acc.type.current"/></option>
				          </select>
				              <label><fmt:message key="member.bank.detail.acc.number"/></label> 
				          <input type="text" name="bd_account_no" value="${parentBean.BD_ACC_NUMBER}" title="Enter Account Number" maxlength="17" class="numberinput" required="required" /><br/>
				              <label><fmt:message key="member.bank.detail.ecs"/></label>
				          <select name="bd_ecs" title="Select Electronic Clearing System" id="bd_ecs">
					          <option <c:if test="${not empty parentBean.BD_ECS && parentBean.BD_ECS == 'N'}">selected</c:if> value="N">
						          <fmt:message key="member.choice.no"/></option>
					          <option <c:if test="${not empty parentBean.BD_ECS && parentBean.BD_ECS == 'Y'}">selected</c:if> value="Y">
						          <fmt:message key="member.choice.yes"/></option>
				          </select>
				      </fieldset>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
						<button class="btn btn-primary">Save changes</button>
					</div>
				</div>

			</div>
		</fieldset>
		<div class="row-fluid show-grid">	
	    	<div class="span2 offset10"><a  id="hrefLogin" class="button orange">Save &amp; Next</a></div>
	    </div>	    
	</form>
</div>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$("#mobile").watermark("Mobile # (Optional)");
			    if (Modernizr.touch && Modernizr.inputtypes.date) {
			        document.getElementById('pi_dob').type = 'date';
			    } else {
			        $('#pi_dob').datepicker({
                    changeMonth: true,
                    changeYear: true,
                    maxDate: "+0M +15D",
                    yearRange: "1900:2013"
                   });
			    }
			    var filing=$('#filing').val();
			    if(filing!=null){
			        $('#status').val(filing);
			    };
			    $('#frmPersonalInfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmPersonalInfo').submit();
				    }
				});
	    var parentbean='<c:out value="${parentBean}"/>';
       if(parentbean==''){
              $('#rsstatus_q').val('yes');
	      $("#ul_rsstatus_q_yes").css("display","block");
              $("#ul_rsstatus_q_yes").css("visibility","visible");
              $('#rsstatus_q_yes').val('yes');
	      $("#ul_rsstatus_q_yes_yes").css("display","block");
              $("#ul_rsstatus_q_yes_yes").css("visibility","visible");
              $('#rsstatus_q_yes_yes').val('yes');
	      $("#ul_rsstatus_q_yes_yes_yes").css("display","block");
              $("#ul_rsstatus_q_yes_yes_yes").css("visibility","visible");
              }
              $('.answer').change(function() {
			  //we should now turn off the one which were selected with previous selection
			  selectedId= $(this).attr('id');
			  idToShow= selectedId +"_"+ $(this).val();
			  for (qid in qs) {
			    qidul = "ul_" + qid ;
			  	if (qid == selectedId || qid == 'rsstatus_q') continue;
			  	if (qid == idToShow) {
			  		 $("#ul_" + idToShow).css("display","block");
			  		 $("#ul_" + idToShow).css("visibility","visible");
			  		 continue;
			  	}
			  	if (qid.indexOf(selectedId) == 0) {
			  		$("#ul_" +qid).css("display","none");
			  		$("#ul_" +qid).css("visibility","hidden");
			  		if ($("#" + qid).length > 0 ) $("#" + qid).get(0).selectedIndex= 0;		  		
			  	}
			  }			
			  var str = "";
			  $("ul option:selected").each(function () {
			            str += $(this).text() + " ";
			  });			  
			});	
			$('#bd_bank_name').tooltip(data-toggle)
				$('#hrefLogin').click(function() {
		 			$('#frmPersonalInfo').submit();
				});
				$("#pi_first_name").popover({'trigger':'focus'});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
