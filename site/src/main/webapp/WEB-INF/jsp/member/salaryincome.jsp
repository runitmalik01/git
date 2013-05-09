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
<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title"
		href="">Home</a> </span> <span class="chevron">&#187;</span> <span
		typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My
			Income Tax Returns</a> </span> <span class="chevron">&#187;</span> <span
		class="breadcrumb-current pan"><c:out value="${pan}" /> </span> <span
		class="chevron">&#187;</span> <span class="breadcrumb-current"><select
		style="width: 120px"><option>Salary Income</option>
			<option>a</option>
			<option>a</option>
	</select> </span>
</div>
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
					<p>
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
					</p>
				</fieldset>
				<fieldset>
					<legend>Employer</legend>
					<p>
						<label for="Name_employer"><fmt:message
								key="member.employe.name" /> </label> <input id="Name_employer"
							required type="text" name="Name_employer" maxlength="25"
							class="alphaonly" placeholder="name of employer"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employer}"/></c:if>" />
					</p>
					<p>
						<label for="Name_employee"><fmt:message
								key="member.employee.name" /> </label> <input id="Name_employee"
							required type="text" name="Name_employee" maxlength="25"
							class="alphaonly" placeholder="name of employee"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employee}"/></c:if>" />
					</p>
					
					<p>
						<label for="Pan_employer"><fmt:message
								key="member.info.pan" /> </label> <input id="Pan_employer" type="text"
							name="Pan_employer"
							title="This field accept first five alphabate next four numeric then single alphabate"
							placeholder="10 Characters"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employer}"/></c:if>" />
					</p>
					<p>
						<label for="Tan_employer"><fmt:message
								key="member.info.tan" /> </label> <input id="Tan_employer" type="text"
							name="Tan_employer" placeholder=" 10 Characters"
							title="This field accept first four alphabate next five numeric then single alphabate"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_employer}"/></c:if>">
					</p>
					<p>
						<label for="Pan_employee"><fmt:message
								key="member.info.pan.employee" /> </label> <input id="Pan_employee" type="text"
							name="Pan_employee"
							title="This field accept first five alphabate next four numeric then single alphabate"
							placeholder="10 Characters"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employee}"/></c:if>" />
					</p>
				</fieldset>
				<fieldset>
					<legend>Employer Address</legend>
					<label for="Address"><fmt:message key="member.address.info" />
					</label> <input id="Address" type="text" name="Address" maxlength="35"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />
					<label for="City"><fmt:message key="member.city.info" /> </label>
					<input id="City" type="text" name="City"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
					<label for="State"><fmt:message key="member.salary.state" />
					</label> <select id="State" name="State">
						<option value="">Select One</option>
						<c:forEach var="booleanCombo" items="${objHashMapStates}">
							<option
								"<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && childBean.state == booleanCombo.value}">selected</c:if>" value="${booleanCombo.key}">${booleanCombo.value}</option>
						</c:forEach>
					</select> <label></label> <label for="Pin"><fmt:message
							key="member.pin.info" /> </label> <input id="Pin" type="text"
						class="numberinput" name="Pin" maxlength="6"
						title="Enter Pin code of your area"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.pin}"/></c:if>" />
				</fieldset>
				<fieldset>
					<legend>
						<fmt:message key="member.period.info" />
					</legend>
					<table>
						<tr>
							<td><label><fmt:message key="member.period.info1" />
							</label></td>
							<td><input id="datepicker" name="From"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from}"/></c:if>" />
							</td>
							<td><label><fmt:message key="member.period.infoto" />
							</label></td>
							<td><input id="datepicker1" name="To"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to}"/></c:if>" />
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>Compensation and Taxation</legend>
					<table>
						<tr>
							<td><label><fmt:message key="member.gross.salary" />
							</label>
							</td>
							<td><input title="enter gross salary" name="Gross_salary"
								maxlength="14" id="Gross_salary" onchange="fill()" id=A class="numberinput"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.gross_salary}"/></c:if>" />
							</td>
						</tr>
						<tr>
							<td><label>Allowance Not Exempt: </label>
							</td>
							<td><input name="Allowance" id="Allowance" maxlength="14"
								onchange="fill()" class="numberinput"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.allowance}"/></c:if>">
							</td>
						</tr>

						<tr>
							<td><label><fmt:message
										key="member.allowance.salary" /> </label></td>
							<td><input name="Allowance1" maxlength="14" value="" class="numberinput">
							</td>
						</tr>
						<tr>
							<td><label><fmt:message key="member.value.preq" />
							</label></td>
							<td><input maxlength="14" name="Perquisite" id="Perquisite" class="numberinput"
								onchange="fill()"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.perquisite}"/></c:if>">
							</td>
						</tr>

						<tr>
							<td><label><fmt:message key="member.value.profit" />
							</label>
							</td>
							<td><input maxlength="14" name="profit" id="profit" class="numberinput"
								onchange="fill()"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.profit}"/></c:if>">
							</td>
						</tr>
						<tr>
							<td><label><fmt:message key="member.value.tax" /> </label>
							</td>

							<td><input name="Taxable_earning" id="Taxable_earning" 
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.taxable_earning}"/></c:if>" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>

			<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;<a
				href="javascript:void(0)" id="myModalHref" class="button orange">Save</a>

			<res:client-validation formId="frmdata"
				screenConfigurationDocumentName="salaryincome"
				formSubmitButtonId="myModalHref" />

		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b>Employer's Name</b></th>
					<th><b>Employment Period</b></th>
					<th><b>Taxable Earning</b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.salaryIncomeDetailList}"
						var="salaryItemDetail">
						<tr>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><c:out
										value="${salaryItemDetail.name_employer}" /> </a></td>
							<td><c:out value="${salaryItemDetail.from}" /> - <c:out
									value="${salaryItemDetail.to}" /></td>
							<td align="right"><c:out value="${salaryItemDetail.taxable_earning}" /></td>
							<td><a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomedelete"><small>Delete</small>
							</a></td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="2">Total Earning</td>
						<td align="right"><c:out value="${parentBean.total}"></c:out></td>
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
