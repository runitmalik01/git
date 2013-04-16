
<%--

Here we are calculating salary income
@author abhishek	
05/03/2013

 --%>


<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<%
			
ValueListService  objValueListService = ValueListServiceImpl.getInstance();
TreeMap  objHashMapStates= (TreeMap) objValueListService.getStates();
request.setAttribute("objHashMapStates", objHashMapStates);

%>
<c:set var="salaryincometitle">
	<fmt:message key="member.salary.title" />
</c:set>
<hippo-gogreen:title title="${salaryincometitle}" />

<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label" />
	</li>
	<li><hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message key="products.detail.location.home" />
	</a>&gt;</li>
	<li><hst:link var="salaryincome" siteMapItemRefId="salaryincome"></hst:link>
		<a href="${salaryincome}"><fmt:message key="member.start.salary" />
	</a></li>
</ol>
<br />
<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="salaryfrm" action="${actionUrl}" name="salaryfrm"
	method="post">
	<input type="hidden" name="screenMode" id="screenMode" value="CREATE" />
	<div id="demo" class="yui3-module">
		<div class="yui3-hd">
			<h1>Salary Income</h1>
		</div>
		<div>
			<h3 style="color: blue">
				<fmt:message key="member.employe.message" />
				<br /> <br />
			</h3>

		</div>
		<div class="yui3-bd" align="center">
			<table class="salary income">
				<tr height="30px">
					<td class="label"><fmt:message key="member.employe.category" />
					</td>
					<td class="input"><input type="radio" name="Employe_category"
						value="Govt." checked="checked" />Govt. <input type="radio"
						name="Employe_category" value="PSU" />PSU <input type="radio"
						name="Employe_category" value="Others" />Others</td>
				</tr>
				<tr height="30px">
					<td class="label"><fmt:message key="member.employe.name" /><span
						style="color: red">*</span>
					</td>
					<td class="input"><input required type="text"
						name="Name_employer" maxlength="25" class="alphaonly" title="Enter Employer Name" />
						<c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<c:if test="${error eq 'invalid.name-label'}">
									<span class="form-error"><fmt:message
											key="member.employe.name.error" /> </span>
									<br />
								</c:if>
							</c:forEach>
						</c:if>
				<tr height="30px">
					<td class="label" align="left"><fmt:message
							key="member.info.pan" /><span style="color: red">*</span>
					</td>
					<td class="input"><input type="text" name="Pan_employer" 
						title="This field accept first five alphabate next four numeric then single alphabate" placeholder="10 Characters"/>
						<c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<c:if test="${error eq 'Enter a valid PAN'}">
									<span class="form-error"><fmt:message
											key="member.info.pan.error" /> </span>
									<br />
								</c:if>
							</c:forEach>
						</c:if>
					</td>
				</tr>

				<tr height="30px">
					<td class="label"><fmt:message key="member.info.tan" /><span
						style="color: red">*</span>
					</td>
					<td class="input"><input required type="text"
						name="Tan_employer"
						title="This field accept first four alphabate next five numeric then single alphabate"
						value="" onclick="" /> <c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<c:if test="${error eq 'Enter a valid TAN'}">
									<span class="form-error"><fmt:message
											key="member.info.tan.error" /> </span>
									<br />
								</c:if>
							</c:forEach>
						</c:if>
					</td>
				</tr>
				<tr height="30px">
					<td id="label" align="left"><fmt:message
							key="member.address.info" /><span style="color: red">*</span>
					</td>
					<td><input type="text" name="Address" maxlength="35" /></td>

					<td id="labe"><fmt:message key="member.city.info" />
					</td>
					<td><input type="text" name="City" />
					</td>
				</tr>

				<tr height="30px">
					<td id="label"><fmt:message key="member.salary.state" /><span
						style="color: red">*</span></td>
					<td><select name="State">
							<option value="">Select One</option>
							<c:forEach var="booleanCombo" items="${objHashMapStates}">
								<option value="${booleanCombo.value}">${booleanCombo.value}</option>
							</c:forEach>
					</select> <c:if test="${not empty errors}">
							<c:forEach items="${errors}" var="error">
								<c:if test="${error eq 'invalid.select.state'}">
									<span class="form-error"><fmt:message
											key="member.state.error" /> </span>
									<br />
								</c:if>
							</c:forEach>
						</c:if>
					</td>
				</tr>

				<tr height="30px">
					<td id="label"><fmt:message key="member.pin.info" /><span
						style="color: red">*</span>
					</td>
					<td><input type="number" name="Pin" maxlength="6"
						title="Enter Pin code of your area" /></td>
				</tr>

				<tr height="30px">
					<td id="label" align="left" style="color: blue"><fmt:message
							key="member.period.info" /><span style="color: red">*</span>
					</td>
				</tr>

				<tr height="30px">
					<td id="label" align="left"><fmt:message
							key="member.period.info1" />
					<td><input type="date" name="From" /></td>


					<td id="label"><fmt:message key="member.period.infoto" />
					</td>
					<td><input type="date" name="To" /></td>
				</tr>


				<tr height="30px">
					<td id="label"><fmt:message key="member.gross.salary" /><span style="color: red">*</span>
					</td>
					<td><input type="number" title="enter gross salary"
						name="Gross_salary" maxlength="14" id="A" onchange="fill()" id=A />
					</td>
					<c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'invalid.gross-label'}">
								<span class="form-error"><fmt:message
										key="member.gross.salary.error" /> </span>
								<br />
							</c:if>
						</c:forEach>
					</c:if>


				</tr>

				<tr height="30px">
					<td id="label"><fmt:message key="member.allowance.salary" />
					</td>
					<td><input type="number" name="Allowance" id="B"
						maxlength="14" onchange="fill()"></td>
				</tr>
				<tr height="30px">
					<td id="label"><fmt:message key="member.value.preq" />
					</td>
					<td><input type="number" maxlength="14" name="Perquisite"
						id="C" onchange="fill()"></td>
				</tr>
				<tr height="30px">
					<td id="label"><fmt:message key="member.value.profit" />
					</td>
					<td><input type="number" maxlength="14" name="Profit" id="D"
						onchange="fill()"></td>
				</tr>
				<tr height="30px">
					<td id="label"><fmt:message key="member.value.tax" />
					</td>
					<td><input type="text" readonly="readonly"
						name="Taxable_earning" id="E" /></td>
				</tr>
				<tr height="40px">
					<td class="submit fright" colspan="3" align="center"><input
						type="submit" value="Save Details " />
					</td>
				</tr>

			</table>
			<br /> <br />

			<H1>
				<b> Employer's Details</b>
			</H1>
			<br />
			<table border="1" width="600">
				<tr align="center">
					<th><b>Employer's Name</b></th>
					<th><b>Employment Period</b></th>
					<th><b>Taxable Earning</b></th>
				</tr>
				<% if (request.getAttribute("arrLSalaryIncomeDocument") != null) { 	
				   ArrayList arrLSalaryIncomeDocument = (ArrayList)request.getAttribute("arrLSalaryIncomeDocument");
				 
				   Iterator<Object> iterSalaryIncomeDocument = arrLSalaryIncomeDocument.iterator();
				 
				   while(iterSalaryIncomeDocument.hasNext())
				   {
					   SalaryIncomeDocument objSalaryIncomeDocument = (SalaryIncomeDocument)iterSalaryIncomeDocument.next();
					   if(null != objSalaryIncomeDocument){
				       //Do something with obj
				%>
				<tr align="center">
					<td><a
						href="javascript:editEmployer('<%= objSalaryIncomeDocument.getEmploye_category()%>','<%= objSalaryIncomeDocument.getName_employer()%>','<%= objSalaryIncomeDocument.getPan_employer()%>','<%= objSalaryIncomeDocument.getTan_employer()%>',
				       	'<%= objSalaryIncomeDocument.getAddress() %>','<%=objSalaryIncomeDocument.getCity()%>','<%=objSalaryIncomeDocument.getState()%>','<%= objSalaryIncomeDocument.getPin()%>',
				       	'<%=objSalaryIncomeDocument.getFrom()%>','<%=objSalaryIncomeDocument.getTo()%>','<%=objSalaryIncomeDocument.getGross_salary()%>',
				       	'<%=objSalaryIncomeDocument.getAllowance()%>','<%=objSalaryIncomeDocument.getPerquisite()%>','<%=objSalaryIncomeDocument.getProfit()%>','<%=objSalaryIncomeDocument.getTaxable_earning()%>')">
							<%= objSalaryIncomeDocument.getName_employer() %> </a></td>
					<td><%= objSalaryIncomeDocument.getFrom() %> - <%= objSalaryIncomeDocument.getTo() %>
					<td><%= objSalaryIncomeDocument.getTaxable_earning() %>
				</tr>
				<%
					   }//end of if
				   }//end of while
			   	}//end of if
			     
			   %>

			</table>
			<p align="center">
				<input name="button" type="button" value="Next"
					onclick="nextScreen()" />
			</p>
		</div>
	</div>
</form>

<script>
	function fill() {
		var A = document.getElementById("A").value - 0;
		var B = document.getElementById("B").value - 0;
		var C = document.getElementById("C").value - 0;
		var D = document.getElementById("D").value - 0;
		document.getElementById("E").value = (A - B + C + D);

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
