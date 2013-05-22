<%@include file="../includes/tags.jspf" %>
<%@page import="com.mootly.wcm.model.FilingStatus"%>
<c:set var="startapplication">
   <fmt:message key="member.start.application"/>
</c:set>
<hippo-gogreen:title title="${ startapplication}"/>
<res:breadcrumb/>	
<%-- <hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
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
%>--%>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error"><fmt:message key="${item.value}" /></div>
	</c:forEach>
</c:if>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">	
	<h4><c:out value="${filingStatus}"/> Information</h4>
	<form id="frmPersonalInfo" action="${actionUrl}" method="post" name="pi">
		<c:if test="${itReturnType.displayName == 'revised'}">
			<fieldset id="ul_revised" class="revised_v original_h">
	             <legend>Revised Return Details</legend>
	             <div class="row-fluid show-grid" id="ul_revised_input">
	                 <div class="span3">
	                 	<div class="rowlabel"><label for="ack_no"><small>Original Ack No</small></label></div>
	                 	<div class="rowlabel"><input id="ack_no" name="ack_no" value="${parentBean.originalAckNo}" placeholder="Enter Original Ack No" type="text"/></div>
	                 </div>
	                 <div class="span2">
	                 	<div class="rowlabel" id="ack_date_label"><label for="ack_date"><small>Original Ack Date</small></label></div>
	                 	<div class="rowlabel"><input id="ack_date" name="ack_date" placeholder="Enter Ack Date" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
	                 </div>
	                 <div class="span2">
	                 	<div class="rowlabel"><label for="defective"><small><abbr title="Defective Return (U/s-139)">Defective?</abbr></small></label></div>
	                 	<div class="rowlabel"><select id="defective" name="defective"><option value="">Select</option>
	                 	<option value="N" <c:if test="${not empty parentBean.defective && parentBean.defective =='N'}">selected</c:if>>No</option>
	                 	<option value="Y" <c:if test="${not empty parentBean.defective && parentBean.defective =='Y'}">selected</c:if>>Yes</option></select></div>
	                 </div> 
	                 <div class="span3 defective_Y_v defective_N_h" style="display:none">                            
	                 	<div class="rowlabel"><label for="notice_no"><small>Notice No(U/s-139)</small></label></div>
	                 	<div class="rowlabel"><input id="notice_no" name="notice_no" value="${parentBean.noticeNo}" placeholder="Enter Notice No" type="text"/></div>
	                 </div>
	                 <div  class="span2 defective_Y_v defective_N_h" style="display:none">   
	                 	<div class="rowlabel"><label for="notice_date"><small>Notice Date(U/s-139)</small></label></div>
	                 	<div class="rowlabel"><input id="notice_date" name="notice_date" maxlength="10" placeholder="Enter Notice Date" type="text"/></div>
	              </div>
	             </div>
	        </fieldset> 
        </c:if>
		<fieldset>
			  <legend><c:out value="${filingStatus}"/> Details</legend>			  
		      <div class="row-fluid show-grid">	        
		      	  <c:choose>
		      	  	<c:when test="${filingStatus eq 'PERSON'}">
			          <div class="span3">
			            <div class="rowlabel"><label for="pi_first_name"><small>First Name</small></label></div>
			          	<div class="rowlabel"><input id="pi_first_name" name="pi_first_name" placeholder="First Name" type="text" value="<c:if test="${not empty parentBean.firstName}"><c:out value="${parentBean.firstName}"/></c:if>"/></div>
			          </div>
			          <div class="span2">
			          	<div class="rowlabel"><label for="pi_middle_name"><small>Middle Name</small></label></div>
			          	<div class="rowlabel"><input id="pi_middle_name" name="pi_middle_name"  placeholder="Middle Name" type="text" value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>"/></div>
			          </div>	         
			          <div class="span3">
			          	<div class="rowlabel"><label for="pi_last_name"><small>Last Name</small></label></div>
			          	<div class="rowlabel"><input id="pi_last_name" name="pi_last_name" placeholder="Last Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>" readonly="readonly"/></div>
			          </div>		      	  	
		      	  	</c:when>
		      	  	<c:otherwise>		      	  		
						<div class="span12">
				          	<div class="rowlabel"><label for="pi_last_name"><small><abbr title="Name of your organization name"><c:out value="${filingStatus}"/> Name</abbr> </small></label></div>
				          	<div class="rowlabel"><input id="pi_last_name" name="pi_last_name" placeholder="Organization Name" type="text" value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"/></div>
				          	<input type="hidden" id="pi_first_name" name="pi_first_name" value="-"/>
			      	  		<input type="hidden" id="pi_last_name" name="pi_last_name" value="-"/>
			      	  		<input type="hidden" id="pi_dob" name="pi_dob" value="01/01/1970"/>
			      	  		<input type="hidden" id="gender" name="gender" value="X"/>
			          	</div>
		      	  	</c:otherwise>
		      	  </c:choose>			 
		          <c:if test="${filingStatus eq 'PERSON'}">
			          <div class="span2">
			          	<div class="rowlabel"><label for="pi_dob"><small>Date Of Birth</small></label></div>
			          	<div class="rowlabel"><input id="pi_dob" name="pi_dob" placeholder="DOB" type="text" maxlength="10" value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>"/></div>
			          </div>
			          <div class="span2">
						<div class="rowlabel"><label for="pi_dob"><small>Gender</small></label></div>
						<div class="rowlabel"><select id="gender" name="gender"><option value="">Select Gender</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'M'}">selected</c:if> value="M">Male</option><option <c:if test="${not empty parentBean.sex && parentBean.sex == 'F'}">selected</c:if> value="F">Female</option></select></div>
			          </div>  
			      </c:if>     
			  </div>
		 </fieldset>
		 <fieldset>
			 <legend>Address &amp; Contact Information</legend>
			 <div class="row-fluid show-grid">	   
			   	  <div class="span6">
			   	  	<div class="rowlabel"><label for="pi_flat_door_building"><small>Flat/Door/Building</small></label></div>
			   	  	<div class="rowlabel"><input id="pi_flat_door_building" value="${parentBean.flatDoorBuilding}" name="pi_flat_door_building" placeholder="Flat/Door/Building" type="text"  value="<c:if test="${not empty parentBean.flatDoorBuilding}"><c:out value="${parentBean.flatDoorBuilding}"/></c:if>"/></div>
			   	  </div>
			   	  <div class="span6">
			   	  	<div class="rowlabel"><label for="pi_road_street"><small>Road/Street</small></label></div>
			   	  	<div class="rowlabel"><input id="pi_road_street" value="${parentBean.roadStreet}" name="pi_road_street" placeholder="Road/Street" type="text"/></div>
			   	  </div>
			  </div>
			  <div class="row-fluid show-grid">	   
		          <div class="span4">
		          	<div class="rowlabel"><label for="pi_area_locality"><small>Area/Locality</small></label></div>
		          	<input id="pi_area_locality" value="${parentBean.areaLocality}" name="pi_area_locality" placeholder="Area/Locality" type="text"/>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="pi_town_city_district"><small>City/Town/District</small></label></div>
		          	<div class="rowlabel"><input id="pi_town_city_district" value="${parentBean.townCityDistrict }" name="pi_town_city_district" placeholder="Town/City/District" type="text"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="pi_state"><small>State</small></label></div>
		          	<c:set var="searchresultstitle"><fmt:message key="member.contact_info.state.select"/></c:set>
                    <c:set var="statesType"><fmt:message key="dropdown.states"/></c:set>
                    <div class="rowlabel"><w4india:dropdown dropDownSelectId="pi_state" optionSelectString="${searchresultstitle}" dropDownType="${statesType}" fetchValue="${parentBean.state}"/></div>
                  </div>
		          <div class="span2">
		            <div class="rowlabel"><label for="pi_pin_code"><small>PIN</small></label></div>
		          	<div class="rowlabel"><input id="pi_pin_code" value="${parentBean.pinCode}" name="pi_pin_code" placeholder="PIN Code" type="text" maxlength="6"/></div>
		          </div>
			 </div>			
			 <div class="row-fluid show-grid">	
			 	  <div class="span2">
			 	  	<div class="rowlabel"><label for="std"><small>STD Code</small></label></div>
			 	  	<div class="rowlabel"><input id="pi_std_code" value="${parentBean.stdCode}" name="pi_std_code"  placeholder="STD"  type="text" maxlength="5"/></div>
			 	  </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="phone"><small>Phone</small></label></div>
		          	<div class="rowlabel"><input id="pi_phone" value="${parentBean.phone}" name="pi_phone"  placeholder="Phone Number"  type="text" maxlength="10"/></div>
		          </div>
		          <div class="span3">
		          	<div class="rowlabel"><label for="mobile"><small>Mobile</small></label></div>
		          	<div class="rowlabel"><input id="mobile" value="${parentBean.mobile}" name="pi_mobile"  placeholder="Mobile Phone Number"  type="text" maxlength="10"/></div>
		          </div>
		          <div class="span4">
		          		<div class="rowlabel"><label for="pi_email"><small>Email</small></label></div>
			          	<div class="input-prepend">
					      <span class="add-on"><i class="icon-envelope"></i></span>
					      <input id="pi_email" value="<c:choose><c:when test="${empty parentBean || empty parentBean.email}"><%=request.getUserPrincipal().getName()%><c:out value="${request.userPrincipal.name}"/></c:when><c:otherwise>${parentBean.email}</c:otherwise></c:choose>" name="pi_email" placeholder="Email Address" type="text"/>
	    				</div>
    			  </div>
		     </div>
		</fieldset>
		<fieldset>
		<legend><fmt:message key="member.residential.status" /></legend>
			 <c:choose>
		      	  	<c:when test="${filingStatus eq 'PERSON'}">
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
					</c:when>
					<c:otherwise>
						<div class="row-fluid show-grid">
							<div class="span5">Control &amp; management of affairs of the taxpayer is</div>
							<div class="span4">
								<select id="rsstatus_q" name="rsstatus_q">
									<option value="">Select</option>
									<option <c:if test="${not empty parentBean.rsstatusQ=='RES'}">selected</c:if> value="RES">Wholly in India</option>
									<option <c:if test="${not empty parentBean.rsstatusQ=='NRI'}">selected</c:if> value="NRI">Wholly outside India</option>
									<option <c:if test="${not empty parentBean.rsstatusQ=='NRO'}">selected</c:if> value="NRO">Partly in India partly outside India</option>
								</select>			
							</div>
						</div>
					</c:otherwise>
				</c:choose>
		</fieldset>
		<fieldset>
			<legend>
				<fmt:message key="member.bank.detail" />
			</legend>
			<div class="page">
				<h5>Do you want to add Bank Detail now (for Refund and/or Tax payment). You can always add this detail later.</h5>
				<a href="#myModal" role="button" class="btn" id="bank" data-toggle="modal" onclick="bankDetail()">
				<c:choose>
				<c:when test="${parentBean.BD_BANK_NAME eq null || parentBean.BD_BANK_NAME eq ''  }">ADD Bank Detail</c:when>
				<c:otherwise>Change Bank Detail</c:otherwise></c:choose></a>
				<!-- Modal -->
				<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
						<h3 id="myModalLabel">Bank Detail</h3>
					</div>
					<div class="modal-body">
						<fieldset>
							 <label><fmt:message key="member.bank.detail.bank.name" /></label>
						  <input type="text" id="bd_bank_name" name="bd_bank_name" value="${parentBean.BD_BANK_NAME}" data-toggle="tooltip" title="Enter Name of Bank" maxlength="25"/><br/>
				             <label><fmt:message key="member.bank.detail.micr.code"/></label> 
				          <input type="text" id="bd_micr_code" name="bd_micr_code"value="${parentBean.BD_MICR_CODE}" title="Enter 9-Digit valid MICR Code" maxlength="9" class="numberinput"/><br/>
			                 <label><fmt:message key="member.bank.detail.bank.branch" /></label>
				          <input type="text" id="bd_Branch_name" name="bd_Branch_name" value="${parentBean.BD_ADD_BANK_BRANCH}" title="Enter Name of Bank's Branch" maxlength="120"/> <br/>
				             <label><fmt:message key="member.bank.detail.acc.type"/></label> 
				          <select name="bd_account_type" title="Select Type of Account" id="bd_account_type">
					         <option value="">Select</option>
					         <option <c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'SAV'}">selected</c:if> value="SAV">
						         <fmt:message key="member.bank.detail.acc.type.saving"/></option>
					         <option <c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'CUR'}">selected</c:if> value="CUR" >
						         <fmt:message key="member.bank.detail.acc.type.current"/></option>
				          </select>
				              <label><fmt:message key="member.bank.detail.acc.number"/></label> 
				          <input type="text" id="bd_account_no" name="bd_account_no" value="${parentBean.BD_ACC_NUMBER}" title="Enter Account Number" maxlength="17"/><br/>
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
				<div id="itreturnHomepage" style="display:none;visiblity:hidden">
					<input id="pan" name="pan" value="<c:choose><c:when test="${not empty parentBean&&parentBean.PAN}"><c:out value="${parentBean.PAN}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pan']}"><c:out value="${savedValuesFormMap.value['pan'].value}"/></c:when></c:choose>" type="hidden"/>
				    <input id="pi_return_type" name="pi_return_type" value="<c:choose><c:when test="${not empty parentBean&&parentBean.returnType}"><c:out value="${parentBean.returnType}"/></c:when><c:otherwise><c:out value="${itReturnType.xmlStatus}"/></c:otherwise></c:choose>" type="hidden"/>
				    <input id="fy" name="fy" value="<c:choose><c:when test="${not empty parentBean&&parentBean.financialYear}"><c:out value="${parentBean.financialYear}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['fy']}"><c:out value="${savedValuesFormMap.value['fy'].value}"/></c:when></c:choose>" type="hidden"/>
				   <!-- <input id="ack_no" name="ack_no" value="<c:choose><c:when test="${not empty parentBean&&parentBean.originalAckNo}"><c:out value="${parentBean.originalAckNo}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ack_no']}"><c:out value="${savedValuesFormMap.value['ack_no'].value}"/></c:when></c:choose>" type="hidden"/>
		            <input id="defective" name="defective" value="<c:choose><c:when test="${not empty parentBean&&parentBean.defective}"><c:out value="${parentBean.defective}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['defective']}"><c:out value="${savedValuesFormMap.value['defective'].value}"/></c:when></c:choose>" type="hidden"/> 
		            <input id="ack_date" name="ack_date" value="<c:choose><c:when test="${not empty parentBean&&parentBean.originalAckDate}"><c:out value="${parentBean.originalAckDate}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ack_date']}"><c:out value="${savedValuesFormMap.value['ack_date'].value}"/></c:when></c:choose>" type="hidden"/>
		            <input id="notice_no" name="notice_no" value="<c:choose><c:when test="${not empty parentBean&&parentBean.noticeNo}"><c:out value="${parentBean.noticeNo}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['notice_no']}"><c:out value="${savedValuesFormMap.value['notice_no'].value}"/></c:when></c:choose>" type="hidden"/>
		            <input id="notice_date" name="notice_date" value="<c:choose><c:when test="${not empty parentBean&&parentBean.noticeDate}"><c:out value="${parentBean.noticeDate}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['notice_date']}"><c:out value="${savedValuesFormMap.value['notice_date'].value}"/></c:when></c:choose>" type="hidden"/>-->
		            <input id="pi_filing_status" name="pi_filing_status" value="${filingStatus.xmlCode}" type="hidden"/>
			    </div>
			</div>
		</fieldset>
		<div class="row-fluid show-grid">	
	    	<div class="span2 offset10"><a  id="hrefLogin" class="button orange">Save &amp; Continue</a></div>
	    </div>	    
	</form>
</div>
<res:client-validation screenConfigurationDocumentName="startapplication" formId="frmPersonalInfo" formSubmitButtonId="hrefLogin"></res:client-validation>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#defective').change(function(){
				$('.defective_' + $(this).val() + '_v').show();
				$('.defective_' + $(this).val() + '_h').hide();
			});
			$("#mobile").watermark("Mobile # (Optional)");
			var d = new Date();
			itrDob="01/04/"+d.getFullYear();
			$( ".indiandate" ).datepicker( "option", "defaultDate", "01/01/1980" );
			$( ".indiandate" ).datepicker( "option", "maxDate", itrDob );
				$('#hrefLogin').click(function() {
		 			$('#frmPersonalInfo').submit();
				});
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
			$('#pi_state').change(function(){
			if($('#pi_state').val()=='99'){
			      $('#pi_pin_code').val('999999');
			      $('#pi_pin_code').attr('readonly','readonly');
			   }else{
                     $('#pi_pin_code').val('');
                     $('#pi_pin_code').removeAttr('readonly');
                    }
			});
			$('#bd_bank_name').tooltip('data-toggle');
				$("#pi_first_name").popover({'trigger':'focus'});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
