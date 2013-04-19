<%@page import="com.mootly.wcm.beans.compound.SalaryIncomeDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
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
		href="">Home</a>
	</span> <span class="chevron">&#187;</span> <span typeof="v:Breadcrumb"><a
		rel="v:url" property="v:title" href="">My Income Tax Returns</a>
	</span> <span class="chevron">&#187;</span> <span
		class="breadcrumb-current pan"><c:out value="${pan}" />
	</span> <span class="chevron">&#187;</span> <span class="breadcrumb-current"><select
		style="width: 120px"><option>Salary Income</option>
			<option>a</option>
			<option>a</option>
	</select>
	</span>
</div>
<div class="page type-page">
	<h3 id="respond1">Salary Income</h3>
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
				<small><fmt:message key="member.employe.message" />
				</small>
			</h5>
			<form id="frmdata" action="${actionUrl}" name="salaryfrm"
				method="post">
				<fieldset>
					<legend>Employment</legend>
					<p>
						<label for="Name_employer"><fmt:message
								key="member.employe.category" />
						</label> <input type="radio" name="Employe_category" value="Govt."
							checked="checked" />Govt. <input type="radio"
							name="Employe_category" value="PSU" />PSU <input type="radio"
							name="Employe_category" value="Others" />Others
					</p>
				</fieldset>
				<fieldset>
					<legend>Employer</legend>
					<p>
						<label for="Name_employer"><fmt:message
								key="member.employe.name" />
						</label> <input id="Name_employer" required type="text"
							name="Name_employer" maxlength="25" class="alphaonly"
							title="Enter Employer Name"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employer}"/></c:if>" />
					</p>
					<p>
						<label for="Pan_employer"><fmt:message
								key="member.info.pan" />
						</label> <input id="Pan_employer" type="text" name="Pan_employer"
							title="This field accept first five alphabate next four numeric then single alphabate"
							placeholder="10 Characters"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employer}"/></c:if>" />
					</p>
					<p>
						<label for="Tan_employer"><fmt:message
								key="member.info.tan" />
						</label> <input id="Tan_employer" required type="text" name="Tan_employer"
							title="This field accept first four alphabate next five numeric then single alphabate"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_employer}"/></c:if>">
					</p>
				</fieldset>
				<fieldset>
					<legend>Employer Address</legend>
					<label for="Address"><fmt:message key="member.address.info" />
					</label> <input id="Address" type="text" name="Address" maxlength="35"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />
					<label for="City"><fmt:message key="member.city.info" />
					</label> <input id="City" type="text" name="City"
						value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
					<label for="State"><fmt:message key="member.salary.state" />
					</label> <select id="State" name="State">
						<option value="">Select One</option>
						<c:forEach var="booleanCombo" items="${objHashMapStates}">
							<option
								"<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') && childBean.state == booleanCombo.value}">selected</c:if>" value="${booleanCombo.value}">${booleanCombo.value}</option>
						</c:forEach>
					</select> <label></label> <label for="Pin"><fmt:message
							key="member.pin.info" />
					</label> <input id="Pin" type="text" class="numberinput" name="Pin"
						maxlength="6" title="Enter Pin code of your area"
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
							</label>
							</td>
							<td><input id="datepicker" name="From"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from}"/></c:if>" />
							</td>
							<td><label><fmt:message key="member.period.infoto" />
							</label>
							</td>
							<td><input id="datepicker1" name="To"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to}"/></c:if>" />
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset>
					<legend>Compensation and Taxation</legend>
					<p>
						<label><fmt:message key="member.gross.salary" />
						</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input title="enter gross salary" name="Gross_salary"
							maxlength="14" id="A" onchange="fill()" id=A
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.gross_salary}"/></c:if>" />
					</p>
					<p>
						<label><fmt:message key="member.allowance.salary" />
						</label> &nbsp;&nbsp;&nbsp;<input name="Allowance" id="B" maxlength="14" onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.allowance}"/></c:if>">
					</p>
					<p>
						<label>Allowance Not Exempt:
						</label> &nbsp;&nbsp;&nbsp;<input name="Allowance1"  maxlength="14" 
							value="">
					</p>
					<p>
						<label><fmt:message key="member.value.preq" />
						</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;<input maxlength="14" name="Perquisite" id="C" onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.perquisite}"/></c:if>">
					</p>
					<p>
						<label><fmt:message key="member.value.profit" />
						</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input maxlength="14" name="Profit" id="D" onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.profit}"/></c:if>">
					</p>
					<p>
						<label><fmt:message key="member.value.tax" />
						</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="Taxable_earning" readonly="readonly" id="E"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.taxable_earning}"/></c:if>" />
					</p>
				</fieldset>
			</form>
			<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>&nbsp;<a
				href="javascript:void(0)" id="hrefLogin" class="button orange">Save</a>

			<hst:element var="uiCustom" name="script">
				<hst:attribute name="type">text/javascript</hst:attribute>
				$(document).ready(function() {
					$('#frmdata input').keydown(function(e) {
					    if (e.keyCode == 13) {
					   		e.preventDefault();
					        $('#frmdata').submit();
					    }
					});
					$('#frmdata').validate({
						rules: {
							username: {
								required: true,
								minlength: 2
							},
		
							password: {
								required: true
							}
						},				
						messages: {
							username: "Please enter a valid email address.",
							password: "Please enter a valid password."
						}
					});
					
					$('#hrefLogin').click(function() {
		 				 $('#frmdata').submit();
					});
				});    
		</hst:element>
			<hst:headContribution element="${uiCustom}" category="jsInternal" />
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
								href="${redirectURLToSamePage}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/edit"><c:out
										value="${salaryItemDetail.name_employer}" />
							</a>
							</td>
							<td><c:out value="${salaryItemDetail.from}" /> - <c:out
									value="${salaryItemDetail.to}" />
							</td>
							<td><c:out value="${salaryItemDetail.taxable_earning}" />
							</td>
							<td><a
								href="${redirectURLToSamePage}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/edit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${redirectURLToSamePage}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/delete"><small>Delete</small>
							</a>
							</td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="2">Total Earning</td>
						<td><c:out value="${parentBean.total}"></c:out>
						</td>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/new" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<script>
	function fill() {
		var A = document.getElementById("A").value - 0;
		var B = document.getElementById("B").value - 0;
		var C = document.getElementById("C").value - 0;
		var D = document.getElementById("D").value - 0;
		document.getElementById("E").value = (A + B + C + D);

	}
</script>

<script>
	function editEmployer(employecategory, empName, pan, tan, address, city,
			state, pin, from, to, gross, alwnce, perquisite, profit,
			taxableIncome) {
		alert("ddd");
		document.forms['salaryfrm'].elements["Employe_category"].value = employecategory;
		document.forms['salaryfrm'].elements["Name_employer"].value = empName;
		document.forms['salaryfrm'].elements["Pan_employer"].value = pan;
		document.forms['salaryfrm'].elements["Tan_employer"].value = tan;
		document.forms['salaryfrm'].elements["Address"].value = address;
		document.forms['salaryfrm'].elements["City"].value = city;
		document.forms['salaryfrm'].elements["State"].value = state;
		document.forms['salaryfrm'].elements["Pin"].value = pin;
		document.forms['salaryfrm'].elements["From"].value = from;
		document.forms['salaryfrm'].elements["To"].value = to;
		document.forms['salaryfrm'].elements["Gross_salary"].value = gross;
		document.forms['salaryfrm'].elements["Allowance"].value = alwnce;
		document.forms['salaryfrm'].elements["Perquisite"].value = perquisite;
		document.forms['salaryfrm'].elements["Profit"].value = profit;
		document.forms['salaryfrm'].elements["Taxable_earning"].value = taxableIncome;

		document.forms['salaryfrm'].elements["screenMode"].value = "UPDATE";

	}

	function nextScreen() {
		alert("nextScreen");

		document.forms['salaryfrm'].elements["screenMode"].value = "NEXTSCREEN";
		document.getElementById('salaryfrm').submit();
	}
</script>



<hst:headContribution keyHint="buttonCss" category="css">
	<hst:link
		path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"
		var="homeSliderCss" />
	<link rel="stylesheet" media="screen" type="text/css"
		href="${homeSliderCss}" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/adornment.css"/>'
		type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="seedFile" category="jsExternal">
	<script src="http://yui.yahooapis.com/3.8.0/build/yui/yui-min.js"
		type="text/javascript"></script>
</hst:headContribution>
