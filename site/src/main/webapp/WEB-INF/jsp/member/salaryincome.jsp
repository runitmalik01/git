<%@page import="com.mootly.wcm.member.SalaryIncome"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.SalaryIncomeDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	TreeMap objHashMapStates = (TreeMap) objValueListService
			.getStates();
	request.setAttribute("objHashMapStates", objHashMapStates);
%>
<c:set var="salaryincometitle">
	<fmt:message key="member.salary.title" />
</c:set>
<hippo-gogreen:title title="${salaryincometitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>

<div class="page type-page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>Salary Income</c:otherwise>
		</c:choose>
	</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:choose>
		<c:when
			test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') || pageAction == 'NEW_CHILD'}">
			<h5>
				<small><fmt:message key="member.employe.message" /> </small>
			</h5>
			<form id="frmdata" action="${actionUrl}" name="salaryfrm"
				method="post">
				<fieldset>
					<legend>Employment</legend>
					<div class="row-fluid show-grid">

						<label for="Name_employer"><fmt:message
								key="member.employe.category" /> </label>
						<c:if
							test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
							<c:choose>
								<c:when test="${childBean.employe_category == 'GOV'}">
									<c:set var="gov" value="checked=checked" />
								</c:when>
								<c:when test="${childBean.employe_category == 'PSU'}">
									<c:set var="psu" value="checked=checked" />
								</c:when>
								<c:when test="${childBean.employe_category == 'OTH'}">
									<c:set var="oth" value="checked=checked" />
								</c:when>
							</c:choose>
						</c:if>
						<input type="radio" <c:out value="${gov}"/>
							name="Employe_category" value="GOV" />Government <input
							type="radio" <c:out value="${psu}"/> name="Employe_category"
							value="PSU" />PSU <input type="radio" <c:out value="${oth}"/>
							name="Employe_category" value="OTH" />Others

					</div>
				</fieldset>
				<fieldset>
					<legend>Employer</legend>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="Name_employer"><fmt:message
										key="member.employe.name" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Name_employer" required type="text"
									name="Name_employer" maxlength="25" class="alphaonly"
									placeholder="Name of employer"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employer}"/></c:if>" />

							</div>
						</div>

						<div class="span4">
							<div class="rowlabel">
								<label for="Name_employee"><fmt:message
										key="member.employee.name" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Name_employee" required type="text"
									name="Name_employee" maxlength="25" class="alphaonly"
									placeholder="Name of employee"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employee}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="Pan_employee"><fmt:message
										key="member.info.pan.employee" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Pan_employee" type="text" name="Pan_employee"
									title="This field accept first five alphabate next four numeric then single alphabate"
									placeholder="10 Characters"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employee}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span6">
							<div class="rowlabel">
								<label for="Pan_employer"><fmt:message
										key="member.info.pan" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Pan_employer" type="text" name="Pan_employer"
									title="This field accept first five alphabate next four numeric then single alphabate"
									placeholder=" 10 Characters"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employer}"/></c:if>" />
							</div>
						</div>
						<div class="span6">
							<div class="rowlabel">
								<label for="Tan_employer"><fmt:message
										key="member.info.tan" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Tan_employer" type="text" name="Tan_employer"
									placeholder=" 10 Characters"
									title="This field accept first four alphabate next five numeric then single alphabate"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_employer}"/></c:if>">
							</div>
						</div>

					</div>
				</fieldset>
				<fieldset>
					<legend>Employer Address</legend>
					<div class="row-fluid show-grid">
						<div class="span3">
							<div class="rowlabel">
								<label for="Address"><fmt:message
										key="member.address.info" /> </label>
							</div>
							<div class="rowlabel">
								<input id="Address" type="text" name="Address"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="City"><fmt:message key="member.city.info" />
								</label>
							</div>
							<div class="rowlabel">
								<input id="City" type="text" name="City" placeholder="City"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="Pin"><fmt:message key="member.pin.info" />
								</label>
							</div>
							<div class="rowlabel">
								<input id="Pin" type="text" class="numberinput" name="Pin"
									maxlength="6" title="Enter Pin code of your area" placeholder="Pin"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.pin}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="State"><fmt:message
										key="member.salary.state" /> </label>
							</div>
							<div class="rowlabel">
								<select id="State" name="State">
									<option value="">Select One</option>
									<c:forEach var="booleanCombo" items="${objHashMapStates}">
										<option
											"<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && childBean.state == booleanCombo.value}">selected</c:if>" value="${booleanCombo.key}">${booleanCombo.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>
				</fieldset>
				<fieldset>
					<legend>
						<fmt:message key="member.period.info" />
					</legend>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.period.info1" /> </label>
							</div>
							<div class="rowlabel">
								<input id="datepicker" name="From"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.period.infoto" /> </label>
							</div>
							<div class="rowlabel">
								<input id="datepicker1" name="To"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Compensation and Taxation</legend>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.gross.salary" /> </label>
							</div>
							<div class="rowlabel">
								<input title="enter gross salary" name="Gross_salary"
									maxlength="14" id="Gross_salary" onchange="fill()" id=A
									class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.gross_salary}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label>Allowance Not Exempt: </label>
							</div>
							<div class="rowlabel">
								<input name="Allowance" id="Allowance" maxlength="14"
									onchange="fill()" class="numberinput decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.allowance}"/></c:if>">
							</div>
						</div>

						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.allowance.salary" /> </label>
							</div>
							<div class="rowlabel">
								<input name="Allowance1" maxlength="14" value=""
									class="numberinput decimal">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.value.preq" /> </label>
							</div>
							<div class="rowlabel">
								<input maxlength="14" name="Perquisite" id="Perquisite"
									class="numberinput decimal" onchange="fill()"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.perquisite}"/></c:if>">
							</div>
						</div>

						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.value.profit" /> </label>
							</div>
							<div class="rowlabel">
								<input maxlength="14" name="profit" id="profit"
									class="numberinput decimal" onchange="fill()"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.profit}"/></c:if>">
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label><fmt:message key="member.value.tax" /> </label>
							</div>

							<div class="rowlabel">
								<input name="Taxable_earning" id="Taxable_earning" class="decimal" readonly="readonly"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.taxable_earning}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
								<a id="myModalHref" role="button" class="btn orange">Save</a>

					</div>
					</div>
			</form>

			<res:client-validation formId="frmdata"
				screenConfigurationDocumentName="salaryincome"
				formSubmitButtonId="myModalHref" />

		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b>Employer's Name</b>
					</th>
					<th><b>Employment Period</b>
					</th>
					<th><b>Taxable Earning</b>
					</th>
					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.salaryIncomeDetailList}"
						var="salaryItemDetail">
						<tr>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><c:out
										value="${salaryItemDetail.name_employer}" /> </a>
							</td>
							<td><c:out value="${salaryItemDetail.from}" /> - <c:out
									value="${salaryItemDetail.to}" />
							</td>
							<td align="right"><c:out
									value="${salaryItemDetail.taxable_earning}" />
							</td>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomedelete"><small>Delete</small>
							</a>
							</td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="2">Total Earning</td>
						<td align="right"><c:out value="${parentBean.total}"></c:out>
						</td>
				</c:if>
			</table>
			<a href="${scriptName}/salaryincomenew" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<script>
	function fill() {
		var A = document.getElementById("Gross_salary").value - 0;
		var B = document.getElementById("Allowance").value - 0;
		var C = document.getElementById("Perquisite").value - 0;
		var D = document.getElementById("profit").value - 0;
		document.getElementById("Taxable_earning").value = (A + B + C + D);
	}
</script>

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
		$('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
         });
                 var statekey=$("#statekey").val();
                if(statekey!=null){
                 $("#pi_state").val(statekey);
                  };
                  
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:client-validation formId="frmdata" screenConfigurationDocumentName="salaryincome" formSubmitButtonId="myModalHref"/>

