<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.mootly.wcm.model.FilingSection"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.SortedSet"%>
<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="java.util.TreeMap"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.model.FilingStatus"%>
<c:set var="startapplication">
	<fmt:message key="member.start.application" />
</c:set>
<hippo-gogreen:title title="${startapplication}" />
<%--res:breadcrumb / --%>
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
<%
pageContext.setAttribute("filingSections", FilingSection.values());
ValueListService objValueListService = ValueListServiceImpl.getInstance();
TreeMap objHashMapBoolean = (TreeMap) objValueListService.getBoolean();
request.setAttribute("objHashMapBoolean", objHashMapBoolean);
SortedSet<Map.Entry<String,String>> objHashMapcountry = objValueListService.getCountry();
request.setAttribute("objHashMapcountry", objHashMapcountry);
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
%>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<w4india:itrmenu />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">			
			<div class="alert alert-danger">
				<c:choose>
					<c:when test="${fn:startsWith(item.key,'RAW_MESSAGE')}">
						<c:out value="${item.value}" />
					</c:when>
					<c:otherwise>
						<fmt:message key="${item.value}" />
					</c:otherwise>					
				</c:choose>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty ITR1_FORM_SELECTION}">
		<div class="alert alert-danger">
			<fmt:message key="${ITR1_FORM_SELECTION}" />
		</div>
	</c:if>
	<div id="ditPanInvalid" class="alert alert-danger <c:if test="${empty noPanMatchFound}">hide</c:if>"><strong><fmt:message key="err.match.pan.dit"/></strong></div>
	<div id="lastNameInvalid" class="alert alert-danger hide"><strong><fmt:message key="err.match.last.name.dit"/></strong></div>
	<div id="error" class="alert alert-danger" style="display:none;"><fmt:message key="err.valid.lastName.with.pan"/></div>
	<%--
	<h4>
		<c:out value="${filingStatus}" /> Information
	</h4>
	 --%>
	<div class="row show-grid">
		<w4india:itrsidebar></w4india:itrsidebar>
	  	<div class="${sideBarMainClass}">
			<w4india:titleandnav title="Personal Information"/>
			<form id="frmPersonalInfo" action="${actionUrl}" method="post"
				name="pi">
				<fieldset>
					<legend class="header-color"><small>Filing Status</small></legend>
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<td colspan="2" align="left"><input type="radio" <c:if test="${not empty memberpersonalinformation && memberpersonalinformation.filingSection.xmlCode == '17'}">checked</c:if> value="revisingNoNotice" id="revisingNoNotice" name="returnTypeChoice" class="returnTypeChoice">I am revising my return for AY ${financialYear.displayAssessmentYear} and I have already submitted my original return.</td>
							</tr>
							<tr>
								<td align="left">
									<input type="radio" <c:if test="${not empty memberpersonalinformation && memberpersonalinformation.returnType == 'O' && not empty memberpersonalinformation.filingSection.requiresNotice}">checked</c:if> value="revisingWithNotice" id="revisingWithNotice" name="returnTypeChoice" class="returnTypeChoice">I am filing my return in response to a notice received from the Income Tax Department and Section is							
								</td>
								<td align="left">
									<select name="revisingWithNoticeSection" id="revisingWithNoticeSection">
										<c:forEach items="${filingSections}" var="filingSection">
											<c:if test="${filingSection.requiresNotice}">
												<option <c:if test="${not empty memberpersonalinformation && memberpersonalinformation.returnType == 'O' && not empty memberpersonalinformation.filingSection && memberpersonalinformation.filingSection.xmlCode == filingSection.xmlCode}">selected</c:if> value="${filingSection.xmlCode}">${fn:toUpperCase(filingSection.desc)}</option>
											</c:if>
										</c:forEach>
									</select>						
								</td>
							</tr>			
							<tr>
								<td colspan="2" align="left"><input  <c:if test="${empty memberpersonalinformation || memberpersonalinformation.returnType == 'O' && not empty memberpersonalinformation.filingSection && memberpersonalinformation.filingSection.xmlCode == '11' ||  memberpersonalinformation.filingSection.xmlCode == '12'}">checked</c:if> type="radio" value="originalReturn" id="originalReturn" name="returnTypeChoice" class="returnTypeChoice">None of the above (This is my first return for assessment year ${financialYear.displayAssessmentYear} )</td>
							</tr>
						</table>
					</div>
				</fieldset>
				<fieldset>
					<legend class="header-color"><small>Employment Category</small></legend>
					<div class="row show-grid">
						<%--
						<div class="col-md-3">
							<div class="rowlabel">
								<label><small>Filing Section<span style="color: red">*</span>
								</small>
								</label>
							</div>
							<div>
								<c:choose>
									<c:when test="${not empty parentBean && not empty parentBean.returnSection}">
										<c:set var="returnSection" value="${parentBean.returnSection}"/>
									</c:when>
									<c:otherwise>
										<c:if test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ReturnSection']}">
											<c:set var="returnSection" value="${savedValuesFormMap.value['ReturnSection'].value}"/>
										</c:if>
									</c:otherwise>
								</c:choose>
								<select id="ReturnSection" name="ReturnSection">
									<c:forEach items="${filingSections}" var="filingSection">
										<c:if test="${filingSection.itReturnType.xmlStatus == itReturnType.xmlStatus}">
											<option  <c:if test="${not empty returnSection && filingSection.xmlCode == returnSection}">selected</c:if> value="${filingSection.xmlCode}">${fn:toUpperCase(filingSection.displayString)}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						 --%>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="Employe_category"><small><fmt:message
											key="member.employe.category" />
								</small>
								</label>
							</div>
							<select id= "Employe_category" name="Employe_category">
									<option value="">-Select-</option>
											<option value="GOV" <c:if test="${not empty parentBean.employe_category && parentBean.employe_category =='GOV'}">selected</c:if>>GOVT.</option>
											<option value="PSU"<c:if test="${not empty parentBean.employe_category && parentBean.employe_category =='PSU'}">selected</c:if>>PSU</option>
											<option value="OTH" <c:if test="${not empty parentBean.employe_category && parentBean.employe_category =='OTH'}">selected</c:if>>OTHERS.</option>
											<option value="NA" <c:if test="${not empty parentBean.employe_category && parentBean.employe_category =='NA'}">selected</c:if>>NA</option>
										</select>
						</div>
						<div class="col-md-5">
							<div class="rowlabel">
								<label for="portugesecivil"><small><fmt:message
											key="member.portugese.civil" />
								</small> </label>
							</div>
							<div>
							<select id="portugesecivil" name="portugesecivil" class="uprcase">
									<option value="">Select</option>
									<option
										<c:if test="${not empty parentBean.portugesecivil && parentBean.portugesecivil == 'Y'}">selected</c:if>
										value="Y">
										<fmt:message key="member.choice.yes" />
									</option>
									<option
										<c:if test="${not empty parentBean.portugesecivil && parentBean.portugesecivil == 'N'}">selected</c:if>
										value="N">
										<fmt:message key="member.choice.no" />
									</option>
		
								</select>
							</div>
		
						</div>
					</div>
				</fieldset>		
				
				<fieldset id="ul_revised" class="revised_v original_h" style="<c:if test="${empty memberpersonalinformation || (memberpersonalinformation.returnType == 'O' && (memberpersonalinformation.filingSection.xmlCode == '12'))}">display: none;</c:if>">
					<legend class="header-color"
					><small>Revised Return Details</small></legend>
					<div class="row show-grid" id="ul_revised_input">
						<div class="col-md-3" id="ackNo">
							<div class="rowlabel">
								<label for="ack_no"><small>Original Ack No</small> </label>
							</div>
							<div class="rowlabel">
								<input id="ack_no" name="ack_no"
									value="${parentBean.originalAckNo}"
									placeholder="Enter Original Ack No" type="text" maxlength="15"/>
							</div>
						</div>
						<div class="col-md-2 revs_" id="ackdate">
							<div class="rowlabel" id="ack_date_label">
								<label for="ack_date"><small>Original Ack Date</small> </label>
							</div>
							<div class="rowlabel">
								<input id="ack_date" name="ack_date" placeholder="Enter Ack Date"
									type="text" maxlength="10"
									value="<c:if test="${not empty parentBean.ackDateStr}"><c:out value="${parentBean.ackDateStr}"/></c:if>" />
							</div>
						</div>
						<%--
						<div class="col-md-2">
							<div class="rowlabel">
								<label for="defective"><small><abbr
										title="Defective Return (U/s-139)">Defective?</abbr> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="defective" name="defective" class="uprcase"><option value="">Select</option>
									<option value="N"
										<c:if test="${not empty parentBean.defective && parentBean.defective =='N'}">selected</c:if>>No</option>
									<option value="Y"
										<c:if test="${not empty parentBean.defective && parentBean.defective =='Y'}">selected</c:if>>Yes</option>
								</select>
							</div>
						</div>
						 --%>
						<div class="col-md-3 defective_Y_v defective_N_h" id="noticeNo"
							style="display: none">
							<div class="rowlabel">
								<label for="notice_no"><small>Notice No(U/s-139)</small>
								</label>
							</div>
							<div class="rowlabel">
								<input id="notice_no" name="notice_no"
									value="${parentBean.noticeNo}" placeholder="Enter Notice No"
									type="text" maxlength="30"/>
							</div>
						</div>
						<div class="col-md-2 defective_Y_v defective_N_h" id="noticeDate"
							style="display: none">
							<div class="rowlabel">
								<label for="notice_date"><small>Notice
										Date(U/s-139)</small> </label>
							</div>
							<div class="rowlabel">
								<input id="notice_date" name="notice_date"
									value="${parentBean.noticeDateStr}" maxlength="10"
									placeholder="Enter Notice Date" type="text" />
							</div>
						</div>
					</div>
				</fieldset>	
				<fieldset>
					<legend class="header-color"><small>
						<c:out value="${filingStatus}" />
						Details</small>
					</legend>
					<div class="row show-grid">
						<c:choose>
							<c:when test="${filingStatus eq 'PERSON'}">
		
		
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_first_name"><small>First Name</small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_first_name" name="pi_first_name" class="uprcase"
											placeholder="First Name" type="text"
											value="<c:if test="${not empty parentBean.firstName}"><c:out value="${parentBean.firstName}"/></c:if>" maxlength="25"/>
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_middle_name"><small>Middle Name</small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_middle_name" name="pi_middle_name" class="uprcase"
											placeholder="Middle Name" type="text"
											value="<c:if test="${not empty parentBean.middleName}"><c:out value="${parentBean.middleName}"/></c:if>" maxlength="25"/>
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_last_name"><small>Last Name</small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_last_name" name="pi_last_name" class="uprcase"
											placeholder="Last Name" type="text"
											value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>"
										     maxlength="75"/>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-md-12">
									<div class="rowlabel">
										<label for="pi_last_name"><small><abbr
												title="Name of your organization name"><c:out
														value="${filingStatus}" /> Name</abbr> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_last_name" name="pi_last_name"
											placeholder="Organization Name" type="text" class="uprcase"
											value="<c:choose><c:when test="${not empty parentBean.lastName}"><c:out value="${parentBean.lastName}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_last_name']}"><c:out value="${savedValuesFormMap.value['pi_last_name'].value}"/></c:when></c:choose>" maxlength="75"/>
									</div>
									<input type="hidden" id="pi_first_name" name="pi_first_name" class="uprcase"
										value="" /> <input type="hidden" id="pi_middle_name" class="uprcase"
										name="pi_middle_name" value="" /><input
										type="hidden" id="gender" name="gender" value="X" />
								</div>
							</c:otherwise>
						</c:choose>
					</div>
		
						<c:if test="${filingStatus eq 'PERSON' || filingStatus eq 'HUF'}">
							<div class="row show-grid">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_dob"><small>Date Of Birth</small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_dob" name="pi_dob" placeholder="DOB" type="text"
											maxlength="10"
											value="<c:if test="${not empty parentBean.DOBStr}"><c:out value="${parentBean.DOBStr}"/></c:if>" />
									</div>
								</div>
								<c:if test="${filingStatus eq 'PERSON' }">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_dob"><small>Gender</small> </label>
									</div>
									<div class="rowlabel">
										<select id="gender" name="gender" class="uprcase"><option value="">Select
												Gender</option>
											<option
												<c:if test="${not empty parentBean.sex && parentBean.sex == 'M'}">selected</c:if>
												value="M">MALE</option>
											<option
												<c:if test="${not empty parentBean.sex && parentBean.sex == 'F'}">selected</c:if>
												value="F">FEMALE</option>
										</select>
									</div>
								</div>
								</c:if>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="pi_father_name"><small>Father Name</small> </label>
									</div>
									<div class="rowlabel">
										<input id="pi_father_name" name="pi_father_name"
											placeholder="Father Name" type="text" class="uprcase"
											value="<c:if test="${not empty parentBean.fatherName}"><c:out value="${parentBean.fatherName}"/></c:if>" maxlength="125"/>
									</div>
								</div>
							</div>
						</c:if>
				</fieldset>
				<fieldset>
					<legend class="header-color"><small>Address &amp; Contact Information</small></legend>
					<div class="row show-grid">
		
						<div class="col-md-6">
							<div class="rowlabel">
								<label for="pi_flat_door_building"><small>Flat/Door/Building</small>
								</label>
							</div>
							<div class="rowlabel">
								<input id="pi_flat_door_building" class="uprcase"
									value="${parentBean.flatDoorBuilding}"
									name="pi_flat_door_building" placeholder="Flat/Door/Building"
									type="text"
									value="<c:if test="${not empty parentBean.flatDoorBuilding}"><c:out value="${parentBean.flatDoorBuilding}"/></c:if>" maxlength="50"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="rowlabel">
								<label for="pi_road_street"><small>Road/Street</small> </label>
							</div>
							<div class="rowlabel">
								<input id="pi_road_street" value="${parentBean.roadStreet}" class="uprcase"
									name="pi_road_street" placeholder="Road/Street" type="text" maxlength="50"/>
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="pi_area_locality"><small>Area/Locality</small>
								</label>
							</div>
							<input id="pi_area_locality" value="${parentBean.areaLocality}" class="uprcase"
								name="pi_area_locality" placeholder="Area/Locality" type="text" maxlength="50"/>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="pi_town_city_district"><small>City/Town/District</small>
								</label>
							</div>
							<div class="rowlabel">
								<input id="pi_town_city_district" class="uprcase"
									value="${parentBean.townCityDistrict }"
									name="pi_town_city_district" placeholder="Town/City/District"
									type="text" maxlength="50"/>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="pi_state"><small>State</small> </label>
							</div>
							<select id="pi_state" name="pi_state" onchange="getautoState()" class="uprcase">
								<option value="">-Select-</option>
								<c:forEach var="booleanCombo" items="${objHashMapstates}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' || parentBean.state == booleanCombo.key}">selected</c:if>
										value="${booleanCombo.key}">${booleanCombo.value}</option>
								</c:forEach>
								<option <c:if test="${pageAction == 'EDIT_CHILD' || parentBean.state == '99'}">selected</c:if> value="99">FOREIGN</option>
							</select>
						</div>
		
						<div class="col-md-2 <c:if test="${parentBean.country == '99'}"></c:if>hide" id="countrylist" >
							<div class="rowlabel">
								<label for="pi_country"><small>Country</small> </label>
							</div>
							<select id="pi_country" name="pi_country" class="uprcase">
								<option value="">-Select-</option>
								<c:forEach var="booleanCombo" items="${objHashMapcountry}">
									<option
										<c:if test="${pageAction == 'EDIT_CHILD' || parentBean.country == booleanCombo.key}">selected</c:if>
										value="${booleanCombo.key}">${booleanCombo.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="pi_pin_code"><small>PIN</small> </label>
							</div>
							<div class="rowlabel">
								<input id="pi_pin_code" value="${parentBean.pinCode}"
									name="pi_pin_code" placeholder="PIN Code" type="text"
									maxlength="6" />
							</div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel">
								<label for="pi_std_code"><small>STD Code</small> </label>
							</div>
							<div class="rowlabel">
								<input id="pi_std_code" value="${parentBean.stdCode}"
									name="pi_std_code" placeholder="STD" type="text" maxlength="5" />
							</div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel">
								<label for="phone"><small>Phone</small> </label>
							</div>
							<div class="rowlabel">
								<input id="pi_phone" value="${parentBean.phone}" name="pi_phone"
									placeholder="Phone Number" type="text" maxlength="10" />
							</div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel">
								<label for="pi_mobile"><small>Mobile</small> </label>
							</div>
							<div class="rowlabel">
								<input id="pi_mobile"
									value="<c:choose><c:when test="${not empty parentBean.mobile}"><c:out value="${parentBean.mobile}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pi_mobile']}"><c:out value="${savedValuesFormMap.value['pi_mobile'].value}"/></c:when></c:choose>"
									name="pi_mobile" placeholder="Mobile Number" type="text"
									maxlength="10" />
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="mobile1"><small>Mobile(If any other)</small> </label>
							</div>
							<div class="rowlabel">
								<input id="mobile1" value="${parentBean.mobile1}"
									name="pi_mobile1" placeholder="Mobile Phone Number" type="text"
									maxlength="10" />
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="ward_circle"><small>IncomeTax
										Ward/Circle</small> </label>
							</div>
							<div class="rowlabel">
								<input id="ward_circle" value="${parentBean.ward_circle}" class="uprcase"
									name="ward_circle" placeholder=" Ward/Circle" type="text" maxlength="50"/>
							</div>
						</div>
						<div class="col-md-7">
							<div class="rowlabel">
								<label for="pi_email"><small>Email</small> </label>
							</div>
							<div class="input-group">
								<span class="add-on"><i class="glyphicon glyphicon-envelope"></i> </span> <input
									id="pi_email" style="width: 200px"
									value="<c:choose><c:when test="${empty parentBean || empty parentBean.email}"><%=request.getUserPrincipal().getName()%><c:out value="${request.userPrincipal.name}"/></c:when><c:otherwise>${parentBean.email}</c:otherwise></c:choose>"
									name="pi_email" placeholder="Email Address" type="text" maxlength="125"/>
							</div>
		
						</div>
		
					</div>
				</fieldset>
				<fieldset>
					<legend class="header-color">
					<small><fmt:message key="member.residential.status" /></small>	
					</legend>
					<c:choose>
						<c:when test="${filingStatus eq 'PERSON'}">
							<h5>
								<small><fmt:message key="member.resi.status.sentence" />
								</small>
							</h5>
							<script>
								var qs = <c:out value="${jsonObject}" escapeXml="false"/>
							</script>
							<div class="row show-grid">
								<div class="col-md-10">
									<c:out value="${map['rsstatus_q']}" />
								</div>
								<div class="col-md-2">
									<select class="answer" id="rsstatus_q" name="rsstatus_q">
										<option>Select</option>
										<option value="yes">Yes</option>
										<option value="no">No</option>
									</select>
								</div>
							</div>
							<c:forEach items="${map}" var="item" varStatus="status">
								<c:if test="${item.key != 'rsstatus_q'}">
									<c:set var="pageItemValue" value="${item.value}" />
									<%
										pageContext.setAttribute("isAnswer", "false");
														String pageItemValue = (String) pageContext
																.getAttribute("pageItemValue");
														if (pageItemValue != null
																&& pageItemValue.startsWith("ans_")) {
															pageContext.setAttribute("isAnswer", "true");
														}
									%>
									<div class="row show-grid"
										id="ul_<c:out value="${item.key}"/>"
										style="display: none; visiblity: hidden">
										<div class="col-md-10">
											<c:choose>
												<c:when test="${fn:startsWith(item.value,'ans_')}">
													<br />
													<p id="resi<c:out value="${status.index}" />"
														style="color: #65B43D;" align="center">
														<b><c:out value="${fn:replace(item.value,'ans_','')}" />
														</b>
													</p>
												</c:when>
												<c:otherwise>
													<c:out value="${item.value}" />
												</c:otherwise>
											</c:choose>
											<c:if test="${fn:startsWith(item.value,'ans_')}">
											</c:if>
										</div>
										<div class="col-md-2">
											<c:if test="${isAnswer != 'true'}">
												<select class="answer" id="<c:out value="${item.key}"/>"
													name="<c:out value="${item.key}"/>">
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
										<c:if
											test="${fn:contains(item.value,'yes') || fn:contains(item.value,'no') }">
											<c:set var="myVar"
												value="${stat.first ? '' : myVar}${item.value}_" />
										</c:if>
									</c:forEach>
								</c:if>
							</c:if>
							<c:set var="len" value="${fn:length(myVar)}" />
							<c:set var="modmyVar" value="${fn:substring(myVar,0,len-1)}" />
							<c:if test="${not empty parentBean }">
								<c:if test="${not empty fetchmap}">
									<c:forEach items="${fetchmap}" var="fitem">
										<c:set var="fmapkey" value="${fitem.key}" />
										<c:set var="fmapvalue" value="${fitem.value}" />
										<script type="text/javascript">
											var fmapkey = '<c:out value="${fmapkey}"/>';
											var fmapvalue = '<c:out value="${fmapvalue}"/>';
											var myVar = '<c:out value="${modmyVar}"/>';
											if (fmapvalue.match("yes")
													|| fmapvalue.match("no")) {
												$('#' + fmapkey).val(fmapvalue);
												$("#ul_" + fmapkey).css("display",
														"block");
												$("#ul_" + fmapkey).css("visibility",
														"visible");
											}
											$("#ul_rsstatus_q_" + myVar).css("display",
													"block");
											$("#ul_rsstatus_q_" + myVar).css(
													"visibility", "visible");
										</script>
									</c:forEach>
								</c:if>
							</c:if>
						</c:when>
						<c:otherwise>
							<script>
								var qs = <c:out value="${jsonObjecthuf}" escapeXml="false"/>
							</script>
							<div class="row show-grid">
								<div class="col-md-10">
									<c:out value="${maphuf['rsstatus_q']}" />
								</div>
								<div class="col-md-2">
									<select class="answer" id="rsstatus_q" name="rsstatus_q">
										<option>Select</option>
										<option value="yes">Yes</option>
										<option value="no">No</option>
									</select>
								</div>
							</div>
							<c:forEach items="${maphuf}" var="item" varStatus="status">
								<c:if test="${item.key != 'rsstatus_q'}">
									<c:set var="pageItemValue" value="${item.value}" />
									<%
										pageContext.setAttribute("isAnswer", "false");
														String pageItemValue = (String) pageContext
																.getAttribute("pageItemValue");
														if (pageItemValue != null
																&& pageItemValue.startsWith("ans_")) {
															pageContext.setAttribute("isAnswer", "true");
														}
									%>
									<div class="row show-grid"
										id="ul_<c:out value="${item.key}"/>"
										style="display: none; visiblity: hidden">
										<div class="col-md-10">
											<c:choose>
												<c:when test="${fn:startsWith(item.value,'ans_')}">
													<br />
													<p id="resi<c:out value="${status.index}" />"
														style="color: #65B43D;" align="center">
														<b><c:out value="${fn:replace(item.value,'ans_','')}" />
														</b>
													</p>
												</c:when>
												<c:otherwise>
													<c:out value="${item.value}" />
												</c:otherwise>
											</c:choose>
											<c:if test="${fn:startsWith(item.value,'ans_')}">
											</c:if>
										</div>
										<div class="col-md-2">
											<c:if test="${isAnswer != 'true'}">
												<select class="answer" id="<c:out value="${item.key}"/>"
													name="<c:out value="${item.key}"/>">
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
										<c:if
											test="${fn:contains(item.value,'yes') || fn:contains(item.value,'no') }">
											<c:set var="myVar"
												value="${stat.first ? '' : myVar}${item.value}_" />
										</c:if>
									</c:forEach>
								</c:if>
							</c:if>
							<c:set var="len" value="${fn:length(myVar)}" />
							<c:set var="modmyVar" value="${fn:substring(myVar,0,len-1)}" />
							<c:if test="${not empty parentBean }">
								<c:if test="${not empty fetchmap}">
									<c:forEach items="${fetchmap}" var="fitem">
										<c:set var="fmapkey" value="${fitem.key}" />
										<c:set var="fmapvalue" value="${fitem.value}" />
										<script type="text/javascript">
											var fmapkey = '<c:out value="${fmapkey}"/>';
											var fmapvalue = '<c:out value="${fmapvalue}"/>';
											var myVar = '<c:out value="${modmyVar}"/>';
											if (fmapvalue.match("yes")
													|| fmapvalue.match("no")) {
												$('#' + fmapkey).val(fmapvalue);
												$("#ul_" + fmapkey).css("display",
														"block");
												$("#ul_" + fmapkey).css("visibility",
														"visible");
											}
											$("#ul_rsstatus_q_" + myVar).css("display",
													"block");
											$("#ul_rsstatus_q_" + myVar).css(
													"visibility", "visible");
										</script>
									</c:forEach>
								</c:if>
							</c:if>
						</c:otherwise>
					</c:choose>
				</fieldset>
				<fieldset>
					<legend class="header-color"><small>ITR Package Selection</small></legend>
					<div class="row show-grid">
					    <div class="col-md-2">
					    	<div class="rowlabel"><label for="flex_string_ITRForm"><small>Select the ITR Package</small></label></div>
					    </div>
						<div class="col-md-5">
							<div class="rowlabel"><label for="whoCan"><small>Who can select this package</small></label></div>
						</div>
						<div class="col-md-5">
							<div class="rowlabel"><label for="whoCannot"><small>Who should not select this package</small></label></div>
						</div>
						<%--
						<div class="col-md-2">
							<div class="rowlabel"><label for="filingMode"><small><abbr title="Choose eFile if you want to do it yourself. eZFile lets you upload documents to <w4india:resellername/> and then let <w4india:resellername/> prepare the tax return for you.">Mode</abbr>&nbsp;<a href='<hst:link siteMapItemRefId="serviceprice"/>'>Help</a></small></label></div>
						</div>
						 --%>
					</div>
					<div class="row show-grid">
						<div class="col-md-2">
							<select id="flex_string_ITRForm" name="flex_string_ITRForm">
								<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
									<option <c:if test="${parentBean.selectedITRForm == itrForm}">selected</c:if> value="${itrForm}"><fmt:message key="${itrForm}.packageName"></fmt:message></option>
								</c:forEach>
							</select>
							<input type="hidden" name="flex_string_ITRServiceDelivery" value="DIY"/>					
						</div>
						<div class="col-md-5">
							<div style="font-size:small" id="whoCan"></div>
						</div>
						<div class="col-md-5">
							<div style="font-size:small" id="whoCannot"></div>
						</div>
						<%--
						<div class="col-md-2">
							<div style="font-size:small" id="filingMode">
								<input type="hidden" id="hidden_flex_string_ITRServiceDelivery" name="hidden_flex_string_ITRServiceDelivery" value="${parentBean.selectedServiceDeliveryOption}">
								<select name="flex_string_ITRServiceDelivery" id="flex_string_ITRServiceDelivery">
		
								</select>
							</div>
						</div>
						 --%>
					</div>
				</fieldset>
				<c:choose>
					<c:when
						test="${not empty parentBean && not empty parentBean.financialYear}">
						<c:set value="${fn:substringBefore(parentBean.financialYear,'-')}"
							var="fy" />
					</c:when>
					<c:otherwise>
						<c:if
							test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['fy']}">
							<c:set
								value="${fn:substringBefore(savedValuesFormMap.value['fy'].value,'-')}"
								var="fy" />
						</c:if>
					</c:otherwise>
				</c:choose>
				<fmt:parseNumber var="fyInt" type="number" integerOnly="true" value="${fy}"></fmt:parseNumber>
				<c:choose>
					<c:when test="${fyInt >= 2012}">
						<c:set var="bnkcode" value="flex_string_IFSCCode" />
						<c:set var="maxlen" value="11" />
						<c:set var="label" value="IFSC Code" />
					</c:when>
					<c:when test="${fyInt <= 2011}">
						<c:set var="bnkcode" value="bd_micr_code" />
						<c:set var="maxlen" value="9" />
						<c:set var="label" value="MICR Code" />
					</c:when>
				</c:choose>
				<fieldset>
					<legend class="header-color"><small>
						<fmt:message key="member.bank.detail" /></small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-6">
							<div class="rowlabel">
								<small><label for="bd_bank_name"> <fmt:message
											key="member.bank.detail.bank.name" />
								</label>
								</small>
							</div>
							<div class="rowlabel">
								<input type="text" id="bd_bank_name" name="bd_bank_name" class="uprcase"
									value="${parentBean.BD_BANK_NAME}" maxlength="25" />
							</div>
						</div>
		
						<div class="col-md-6">
							<div class="rowlabel">
								<small><label for="bd_Branch_name"> <fmt:message
											key="member.bank.detail.bank.branch" />
								</label>
								</small>
							</div>
							<div class="rowlabel">
								<input type="text" id="bd_Branch_name" name="bd_Branch_name" class="uprcase"
									value="${parentBean.BD_ADD_BANK_BRANCH}" maxlength="120" />
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="bd_account_no"><small><fmt:message
											key="member.bank.detail.acc.number" />
								</small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" id="bd_account_no" name="bd_account_no" class="uprcase"
									value="${parentBean.BD_ACC_NUMBER}" title="Account Number"
									maxlength="17" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<small><label for="<c:out value="${bnkcode}"/>"> <c:out
											value="${label}" /> 
								</label><label><small><w4india:ifsc-code
													ifscCodeId="ifscCode" /></small></label>
								</small>
							</div>
							<div class="rowlabel">
								<input type="text" class="uprcase" id="<c:out value="${bnkcode}"/>"
									name="<c:out value="${bnkcode}"/>"
									value="<c:choose><c:when test="${parentBean.BD_MICR_CODE}"><c:out value="${parentBean.BD_MICR_CODE}"/></c:when><c:otherwise><c:out value="${ifsccode}"/></c:otherwise></c:choose>"
									maxlength="<c:out value="${maxlen}"/>" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="bd_account_type"><small><fmt:message
											key="member.bank.detail.acc.type" />
								</small> </label>
							</div>
							<div class="rowlabel">
								<select name="bd_account_type" id="bd_account_type" class="uprcase">
									<option value="">Select</option>
									<option
										<c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'SAV'}">selected</c:if>
										value="SAV">
										<fmt:message key="member.bank.detail.acc.type.saving" />
									</option>
									<option
										<c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'CUR'}">selected</c:if>
										value="CUR">
										<fmt:message key="member.bank.detail.acc.type.current" />
									</option>
									<option
										<c:if test="${not empty parentBean.BD_TYPE_ACC && parentBean.BD_TYPE_ACC == 'CCT'}">selected</c:if>
										value="CCT">
										<fmt:message key="member.bank.detail.acc.type.cash" />
									</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-9">
							<div class="rowlabel">
								<small><label for="bd_ecs"><fmt:message
											key="member.bank.detail.ecs" /> </label>
								</small>
		
							</div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel">
								<select name="bd_ecs" title="Select Electronic Clearing System" class="uprcase"
									id="bd_ecs">
									<option value="">Select</option>
									<option
										<c:if test="${not empty parentBean.BD_ECS && parentBean.BD_ECS == 'Y'}">selected</c:if>
										value="Y">
										<fmt:message key="member.choice.yes" />
									</option>
									<option
										<c:if test="${not empty parentBean.BD_ECS && parentBean.BD_ECS == 'N'}">selected</c:if>
										value="N">
										<fmt:message key="member.choice.no" />
									</option>
		
								</select>
							</div>
						</div>
					</div>
					<input type="hidden" name="bnk_name_solr" id="bnk_name_solr"/>
				</fieldset>
					<jsp:include page="personalinfo_add_itr2.jsp"></jsp:include>
					<jsp:include page="personalinfo_add_itr4.jsp"></jsp:include>
					<jsp:include page="startapp_add_itr4s.jsp"></jsp:include>
				<div id="itreturnHomepage" style="display: none; visiblity: hidden">
					<input id="pan" name="pan"
						value="<c:choose><c:when test="${not empty parentBean && not empty parentBean.PAN}"><c:out value="${parentBean.PAN}"/></c:when><c:otherwise><c:if test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['pan']}"><c:out value="${savedValuesFormMap.value['pan'].value}"/></c:if></c:otherwise></c:choose>"
						type="hidden" />
						<%-- comment out and let user change it --%>
						<%--
						<input id="ReturnSection" name="ReturnSection"
						value="<c:choose><c:when test="${not empty parentBean && not empty parentBean.returnSection}"><c:out value="${parentBean.returnSection}"/></c:when><c:otherwise><c:if test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ReturnSection']}"><c:out value="${savedValuesFormMap.value['ReturnSection'].value}"/></c:if></c:otherwise></c:choose>"
						type="hidden" />
						--%>
						<%-- comment out --%>
						<%--
						<input id="pi_return_type" name="pi_return_type"
						value="<c:choose><c:when test="${not empty parentBean && not empty parentBean.returnType}"><c:out value="${parentBean.returnType}"/></c:when><c:otherwise><c:out value="${itReturnType.xmlStatus}"/></c:otherwise></c:choose>"
						type="hidden" />
						 --%>
						<input id="fy" name="fy"
						value="<c:choose><c:when test="${not empty parentBean && not empty parentBean.financialYear}"><c:out value="${parentBean.financialYear}"/></c:when><c:otherwise><c:if test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['fy']}"><c:out value="${savedValuesFormMap.value['fy'].value}"/></c:if></c:otherwise></c:choose>"
						type="hidden" />
					<%-- <input id="ack_no" name="ack_no" value="<c:choose><c:when test="${not empty parentBean&&parentBean.originalAckNo}"><c:out value="${parentBean.originalAckNo}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ack_no']}"><c:out value="${savedValuesFormMap.value['ack_no'].value}"/></c:when></c:choose>" type="hidden"/>
				            <input id="defective" name="defective" value="<c:choose><c:when test="${not empty parentBean&&parentBean.defective}"><c:out value="${parentBean.defective}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['defective']}"><c:out value="${savedValuesFormMap.value['defective'].value}"/></c:when></c:choose>" type="hidden"/>
				            <input id="ack_date" name="ack_date" value="<c:choose><c:when test="${not empty parentBean&&parentBean.originalAckDate}"><c:out value="${parentBean.originalAckDate}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['ack_date']}"><c:out value="${savedValuesFormMap.value['ack_date'].value}"/></c:when></c:choose>" type="hidden"/>
				            <input id="notice_no" name="notice_no" value="<c:choose><c:when test="${not empty parentBean&&parentBean.noticeNo}"><c:out value="${parentBean.noticeNo}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['notice_no']}"><c:out value="${savedValuesFormMap.value['notice_no'].value}"/></c:when></c:choose>" type="hidden"/>
				            <input id="notice_date" name="notice_date" value="<c:choose><c:when test="${not empty parentBean&&parentBean.noticeDate}"><c:out value="${parentBean.noticeDate}"/></c:when><c:when test="${not empty savedValuesFormMap && not empty savedValuesFormMap.value['notice_date']}"><c:out value="${savedValuesFormMap.value['notice_date'].value}"/></c:when></c:choose>" type="hidden"/>--%>
					<input id="pi_filing_status" name="pi_filing_status"
						value="<c:choose><c:when test="${not empty parentBean.filingStatus}"><c:out value="${parentBean.filingStatus}"/></c:when><c:otherwise><c:out value="${filingStatus.xmlCode}"/></c:otherwise></c:choose>"
						type="hidden" />
				</div>
				<!--  Service Selection -->
				<%--
				<fieldset>
					<legend>Choose the service you want</legend>
					<div class="row show-grid">
					    <div class="col-md-2">
					    	<div class="rowlabel"><label for="flex_string_ITRForm" style="text-decoration: underline;" ><small>Service Type</small></label></div>
					    </div>
						<div class="col-md-5">
							<div class="rowlabel"><label for="whoCan" style="text-decoration: underline;" ><small>What do you get?</small></label></div>
						</div>
						<div class="col-md-2">
							<div class="rowlabel"><label for="whoCannot" style="text-decoration: underline;" ><small>How much does it cost?</small></label></div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel"><label for="whoCannot1" style="text-decoration: underline;" ><small><abbr title="You can name your own price for this service">Name your price</abbr></small></label></div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-2">
							<select id="flex_string_ITRForm" name="flex_string_ITRForm">
								<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
									<option <c:if test="${parentBean.selectedITRForm == itrForm}">selected</c:if> value="${itrForm}">${itrForm.displayName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-5">
							<div style="font-size:small" id="whoCan"></div>
						</div>
						<div class="col-md-2">
							<div style="font-size:small" id="whoCannot"></div>
						</div>
						<div class="col-md-2">
							<input type="text" value=""/>
						</div>
					</div>
				</fieldset>
				  --%>
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a id="hrefLogin" role="button" class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
			<c:if test="${not empty isDuplicate && isDuplicate == 'true' && empty formMap}">
				<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				    <h3 id="myModalLabel">Application in Progress</h3>
				  </div>
				  <div class="modal-body">
				    <p>An application is already in progress.</p>
				    <p>Do you want to Duplicate PAN<a class="btn btn-default"><c:out value="${fn:toUpperCase(pan)}"/></a>Infomation?</p>
				  </div>
				  <div class="modal-footer">
				    <a href="${fn:substringBefore(scriptName,pan)}${duplicatePANFolder}/${pan}/servicerequest-itr-copy-or-move.html" class="btn btn-default btn-primary">Continue</a>
				    <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Close</button>
				  </div>
				</div>
			</c:if>
		</div>
	</div>
</div>
<res:client-validation
	screenConfigurationDocumentName="startapplication"
	formId="frmPersonalInfo" formSubmitButtonId="hrefLogin" fieldOneID="pan" fieldTwoID="pi_last_name" validationType="pan"></res:client-validation>
	<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
        	$(document).ready( function() {
        	  if($('#myModal').length > 0) $('#myModal').modal();
        	  // to display revised fields
        	  var pageAction = '<c:out value="${pageAction}"></c:out>';
        	  var returnType = '<c:out value="${memberpersonalinformation.returnType}"></c:out>';
        	  <c:if test="${pageAction eq 'EDIT' and not empty memberpersonalinformation}">
        	  if((pageAction == "EDIT") && (returnType == "O") && ($("#revisingWithNoticeSection").val() == "18")){
        	  			$("#ackNo").show();
        	  			$("#ackdate").hide();
        	  			$("#noticeNo").show();
        	 			$("#noticeDate").show();
        	  }
        	  if((pageAction == "EDIT") && (returnType == "R") ){
        	  
        	 			 $("#ackNo").show();
        	 			 $("#ackdate").show();
        	 			 $("#noticeNo").hide();
        	  			$("#noticeDate").hide();
        	  	}
        	  	$('.returnTypeChoice').change(function(){
        	  	 var returnTypeValue = $('.returnTypeChoice').val();
        	  	 $('.returnTypeChoice').each( function(index,value) {
				          if(value.checked){
				             returnTypeValue = value.value;
				             
				          } 	
			     });
        	  	 var returnSection = $("#revisingWithNoticeSection").val();
        	  	  if(returnTypeValue == 'revisingWithNotice' && returnSection == '18'){       	  	   
        	  	        $("#ackNo").show();
        	  			$("#ackdate").hide();
        	  			$("#noticeNo").show();
        	 			$("#noticeDate").show();
        	  	   };
        	  	   if(returnTypeValue == 'revisingNoNotice'){
        	  	    $("#ackNo").show();
        	  			$("#ackdate").show();
        	  			$("#noticeNo").hide();
        	 			$("#noticeDate").hide();
        	  	   };
        	  	});
        	  
        	  		
        	  	</c:if>
        	  	
        	  		$("#revisingWithNoticeSection").change(function(){
        	  	var returnTypeValue = $('.returnTypeChoice').val();
        	  	 $('.returnTypeChoice').each( function(index,value) {
				          if(value.checked){
				             returnType = value.value;
				          } 	
			     });
        	  	var val= $(this).val();
        	  	if(returnType == "revisingWithNotice"){
        	   if(val == '18'){
        	  	  $("#ul_revised").show();
        					       $('.defective_Y_v').show();
						           $('.defective_Y_h').hide();
							       $("#ackdate").hide();
        	  	    } 
                  if(val != '18'){
                   $("#ul_revised").hide();
        	  	      }
        	  	   } 
        	  	  
        	  	});
        	  	
        		$("#revisingNoNotice,#revisingWithNotice,#originalReturn").click ( function() {
        			var v= ($(this).val());
        			$("#ul_revised").hide();
        			if(v == 'revisingNoNotice') {
        			 $("#ul_revised").show();
							$('.defective_N_h').hide();
							$('.defective_N_v').show();
							$("#ackdate").show();
        			}else if(v == 'revisingWithNotice'){
        			          if($("#revisingWithNoticeSection").val() == '18'){
        			          		 $("#ul_revised").show();
        					       $('.defective_Y_v').show();
						           $('.defective_Y_h').hide();
							       $("#ackdate").hide();
        			          }else{
        			          $("#ul_revised").hide();
        			            }
        			         
        			          if($("#revisingWithNoticeSection").val() == '18'){
        			               $("#ul_revised").show();
        					       $('.defective_Y_v').show();
						           $('.defective_Y_h').hide();
							       $("#ackdate").hide();
        			          }else{
        			          
        			              $("#ul_revised").hide();
        			              
        			            }
        			}else {
        			
        				$("#ul_revised").hide();
        			
        			}
        		});
        	});


		var mapOfItrFormWhoCanAndWhoCan = {};
		var mapOfItrFormWhoCanAndWhoCannot = {};
		var mapOfFilingMode = {};
		<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
			mapOfItrFormWhoCanAndWhoCan['${itrForm}']=  "<fmt:message key="${itrForm}.whoCan"></fmt:message>";
			mapOfItrFormWhoCanAndWhoCannot['${itrForm}']=  "<fmt:message key="${itrForm}.whoCannot"></fmt:message>";
			mapOfFilingMode['${itrForm}']=[<c:forEach varStatus="varStatus" var="filingOption" items="${itrForm.serviceDeliveryOptions}">{'key':'<c:out value="${filingOption}"/>', 'label':'<fmt:message key="ITRServiceDelivery.${filingOption}.displayName"/>'}<c:if test="${not varStatus.last}">,</c:if></c:forEach>]
		</c:forEach>

		var solrField = 'text';
		var solrExtra = '';
		ifsc = {};
		function callSolr_bd_bank_name(q,process) {
			solrField = 'BANK';
			solrFieldFacet = solrField + '_sbd_bank_name';
			solrExtra = '';
			doneFunc = function(data)  {
				var aLength = data.facet_counts.facet_fields[solrFieldFacet].length;
			    retArr = new Array();
			    for ( var i=0;i < aLength ;i++) {
				if ( (i % 2) == 0 ) retArr[retArr.length] = data.facet_counts.facet_fields[solrFieldFacet][i];
			    }
			    process(retArr);
			}
			callSolr(q,process,doneFunc);
		}

		function callSolr_bd_Branch_name(q,process) {
			solrField = 'BRANCH_NAME';
			solrFieldFacet = solrField + '_s';
			solrExtra = "%20%2BBANK:" + $("#bnk_name_solr").val();
			doneFunc = function(data)  {
			    retArr = new Array();
			    aLength = data.response.docs.length;
			    for ( var i=0;i < aLength ;i++) {
				//if ( (i % 2) == 0 ) retArr[retArr.length] = data.facet_counts.facet_fields[solrFieldFacet][i];
				if ( (i % 2) == 0 ) {
					retArr[retArr.length] = data.response.docs[i][solrFieldFacet];
					ifsc[data.response.docs[i][solrFieldFacet]] = data.response.docs[i]['ID']
				}
			    }
			    process(retArr);
			}
			callSolr(q,process,doneFunc);
		}
		//nice example http://fusiongrokker.com/post/heavily-customizing-a-bootstrap-typeahead

		function callSolr(q,process,doneFunc) {
			$.ajax({
				'url':'/site/solr/bankdata/select?q='+ solrField + ':' + q + '*'+ solrExtra +'&wt=json&indent=true&facet=on&facet.field=' + solrField + '_s',
				dataType:'json'
			}).done(doneFunc);
		}
		function bankSelected(item){
			$("#bd_Branch_name").val("");
			$("#flex_string_IFSCCode").val("");
			$("#bnk_name_solr").val(item);
			if (item.length > 25) {
				return item.substring(0,25);
			}
			else {
				return item;
			}
		}
		function branchSelected(item) {
			if (ifsc != null && typeof(ifsc[item]) != 'undefined') {
				$("#flex_string_IFSCCode").val(ifsc[item]);
			}
			return item;
		}

		$(document).ready(function() {
	// This is the check for audit filds 
	var AY='<c:out value="${assessmentYear}"/>'.split("-", 4);
	itrFinYrMin="01/04/"+AY[0];
	itrPrYr = parseInt(AY[0])-1;
	itrPrvFinYrMin = "01/04/"+itrPrYr;
	$( ".dateAuditReport" ).datepicker( "option", "minDate", itrPrvFinYrMin );
	$( ".auditdateCal" ).datepicker( "option", "minDate", itrFinYrMin );
	
	
	// this code is for itr2 when pan is HUF
 	 /*var packageName = $('#flex_string_ITRForm').val();
 	 if(packageName == 'ITR2') {
  	  $('#represenative_detail').show();
  	  }
  	  else{
  	  $('#represenative_detail').hide();
  	  }*/
			$("#flex_string_ITRForm").change(function (aval) {
					var sele = this.options[this.selectedIndex].value;
					$("#whoCan").html(mapOfItrFormWhoCanAndWhoCan[sele]);
					$("#whoCannot").html(mapOfItrFormWhoCanAndWhoCannot[sele]);

					//flex_string_ITRServiceDelivery
					str = "";
					for (var i=0;i < mapOfFilingMode[sele].length ; i++){
						str += "<option value='" + mapOfFilingMode[sele][i].key + "'>" + mapOfFilingMode[sele][i].label + "</option>";
					}
					$("#flex_string_ITRServiceDelivery").html(str);

			});

			str = "";
			v = $("#hidden_flex_string_ITRServiceDelivery").val();
			
			f = $("#flex_string_ITRForm").val();
			
			if (f != '' && typeof(mapOfFilingMode[f].length) != 'undefined') {
				for (var i=0;i < mapOfFilingMode[f].length ; i++){
					sel = '';
					if (v != '' && v == mapOfFilingMode[f][i].key) sel ='selected';
					str += "<option " + sel + " value='" + mapOfFilingMode[f][i].key + "'>" + mapOfFilingMode[f][i].label + "</option>";
				}
				$("#flex_string_ITRServiceDelivery").html(str);
			}


			$("#whoCan").html(mapOfItrFormWhoCanAndWhoCan[$("#flex_string_ITRForm").val()]);
			$("#whoCannot").html(mapOfItrFormWhoCanAndWhoCannot[$("#flex_string_ITRForm").val()]);


			var options={source:callSolr_bd_bank_name,updater:bankSelected}
			//$("#bd_bank_name").attr('autocomplete','off');  //07/20 Amit
			//$("#bd_bank_name").typeahead(options); //07/20 Amit

			options={source:callSolr_bd_Branch_name,updater:branchSelected}
			//$("#bd_Branch_name").attr('autocomplete','off');  //07/20 Amit
			//$("#bd_Branch_name").typeahead(options);  //07/20 Amit
			$('#defective').change(function(){
				$('.defective_' + $(this).val() + '_v').show();
				$('.defective_' + $(this).val() + '_h').hide();
			});
			var defective='<c:out value="${parentBean.defective}" />' ;
			if(defective!=''){
				$('.defective_' + defective + '_v').show();
				$('.defective_' + defective + '_h').hide();
			};
			//$("#mobile").watermark("Mobile # (Optional)");
			var d=new Date();
			itrDob="01/04/"+d.getFullYear();
			$( ".indiandate" ).datepicker( "option", "defaultDate", "01/01/1980" );
			$( ".indiandate" ).datepicker( "option", "maxDate", itrDob );
	       var parentbean='<c:out value="${parentBean}" />';
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
			  //weshould now turn off the one which were selected with previousselection
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
			      $("#pi_country option[value=" + 91 + "]").hide();

			   }else{
                     $('#pi_pin_code').val('');
                     $('#pi_pin_code').removeAttr('readonly');
					$("#pi_country option[value=" + 91 + "]").show();
                    }
			});
			$('#bd_bank_name').tooltip('data-toggle');
			$("#pi_first_name").popover({'trigger':'focus'});

		});
	    function getautoState(){
	        var option=document.getElementById("pi_state");
	        var stateName = option.options[option.selectedIndex].value;
	        if(stateName!="99"){
	        $("#pi_country").val("91");
	         $('#countrylist').hide();
	         }else{
              	$("#pi_country").val("");
              	 $('#countrylist').show();
              	 }
        }

        // The following logic is for itr2 and itr4 both
    $('#flex_string_ITRForm').change(function(){
    var packageName = $('#flex_string_ITRForm').val();
    if((packageName == 'ITR2' || (packageName == 'ITR4') || (packageName == 'ITR3'))) {
    $('#represenative_detail').show();
    }
    else{
    $('#represenative_detail').hide();
    }
    })
    $('#isRepresentative').change(function(){
    var yesRepresenative = $('#isRepresentative').val();
    if((yesRepresenative == 'N') || (yesRepresenative == '')){
    $('#showRepresentDetail').hide();
    } else{
     $('#showRepresentDetail').show();
    }
    })
 // And This logic is for itr4
	$('#flex_string_ITRForm').change(function(){
	var packageName = $('#flex_string_ITRForm').val();
	if(packageName == 'ITR4') {
	$('#fieldsfor_ITR4').show();
	} else{
	$('#fieldsfor_ITR4').hide();
	}
	// This code is for ITR4S
	if(packageName == 'ITR4S'){
	$('#trpdetails').show();
	} else  $('#trpdetails').hide();
	});
	$('#isTaxPreparebyTRP').change(function(){
	 var val_TaxPreparebyTRP = $('#isTaxPreparebyTRP').val();
	 if((val_TaxPreparebyTRP == 'N') || (val_TaxPreparebyTRP == ''))
	 $('#yesTaxPreparebyTRP').hide();
	 else $('#yesTaxPreparebyTRP').show();
	})
	// end code for itr4s
	$('#isLiable_ForAudit').change(function(){
	var yesLiable_ForAudit = $('#isLiable_ForAudit').val();
	if((yesLiable_ForAudit == 'N' || (yesLiable_ForAudit == '')) ){
	$('#date_name_membership').hide();
	$('#name_pan_dateofAudit').hide();
	$('#sec92E').hide();
	} else{
	$('#date_name_membership').show();
	$('#name_pan_dateofAudit').show();
	$('#sec92E').show();
	}
	});

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<w4india:dit-mock-service formId="frmPersonalInfo"></w4india:dit-mock-service>