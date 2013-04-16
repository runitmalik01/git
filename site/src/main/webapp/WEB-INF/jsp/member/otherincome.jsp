<%@include file="../includes/tags.jspf"%>
<c:set var="otherincometitle">
	<fmt:message key="member.otherincome.title" />
</c:set>
<hippo-gogreen:title title="${otherincometitle}" />

<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<ol id="breadcrumbs">
	<li><fmt:message key="member.location.label" /></li>
	<li><hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message key="products.detail.location.home" />
	</a>&gt;</li>
	<li><hst:link var="otherincome" siteMapItemRefId="otherincome"></hst:link>
		<a href="${otherincome}"><fmt:message
				key="member.start.otherincome" /> </a>
	</li>
</ol>
<!-- Load jQuery, SimpleModal and Basic JS files -->
<script type='text/javascript' src='js/jquery.js'></script>
<script type='text/javascript' src='js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='js/basic.js'></script>
<link type='text/css' href='css/demo.css' rel='stylesheet'
	media='screen' />
<!-- Contact Form CSS files -->
<link type='text/css' href='css/basic.css' rel='stylesheet'
	media='screen' />
<link type='text/css' href='css/basic_ie.css' rel='stylesheet'
	media='screen' />
<!-- IE6 "fix" for the close png image -->
<!--[if lt IE 7]>
<!-- included for yui popup windows -->
<br />
<hst:actionURL var="actionUrl"></hst:actionURL>
<form id="frmincome" action="${actionUrl}" method="post"name="f1">
	<!-- code for personal information popup window -->
	<div id='container'>
		<div id='content'>
			<div id='basic-modal'>
				<h2>
					<fmt:message key="member.otherin.message" />
				</h2>
				<h3 style="color: blue" align="left">
					<fmt:message key="member.interest.tax" />
				</h3>

				<br />
				<table>
					<tr>
						<td width="340"><fmt:message key="member.income.gov" />
							&nbsp; &nbsp; &nbsp; <input type="text" name="Gov_income"
							size="15" maxlength="14" onchange="cal1()" id="A" />
						</td>
						<td width="350"><fmt:message key="member.income.kissan" /> <input
							name="Kissan_patra" type="text" size="15" maxlength="14"
							onchange="cal1()" id="B" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.bank.interest" />&nbsp; &nbsp;
							&nbsp; <input name="Bank_detail" type="text" size="15"
							maxlength="14" onchange="cal1()" id="C" />&nbsp; 
						</td>
						<td><fmt:message key="member.interest.indiravikas" />&nbsp;
							&nbsp; <input name="Indira_patra" type="text" size="15"
							maxlength="14" onchange="cal1()" id="D" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.interest.nsc" /> &nbsp; &nbsp;
							&nbsp;&nbsp;<input name="Int_nsc" type="text" size="15"
							onchange="cal1()" id="E" />
						</td>
						<td><fmt:message key="member.other.interest" />&nbsp;&nbsp;
							&nbsp;&nbsp; <input name="Other_interest" type="text" size="15"
							onchange="cal1()" id="F" id="otherint" />&nbsp; </td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><fmt:message key="member.total.interest" />&nbsp; &nbsp;
							&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Total_interest" type="text" size="15" onchange="cal1()"
							id="G" readonly /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
				</table>


				<h3 style="color: blue" align="left">

					<fmt:message key="member.otherincome.message1" />
				</h3>
				<br />
				<table>
					<tr>
						<td width="340"><fmt:message key="member.family.pension" />
							&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Family_pension" type="text" onchange="cal2()" size="15"
							id="a1" />
						</td>
						<td width="350"><fmt:message key="member.dividends" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Dividends" type="text" size="15" onchange="cal2()" id="a2" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.income.lottery" /><br /> <fmt:message
								key="member.income.horse" />&nbsp; <input
							name="Lottery_horse_income" type="text" onchange="cal2()" id="a3"
							size="15" /></td>
						<td><fmt:message key="member.income.rental" /> <br /> <fmt:message
								key="member.income.machine" />&nbsp; &nbsp; &nbsp; &nbsp; <input
							name="Income_rent_machine" type="text" size="15"
							onchange="cal2()" id="a4" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.income.maintain" /><br /> <fmt:message
								key="member.income.racing" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Income_maintain" type="text" size="15" onchange="cal2()"
							id="a5" />
						</td>
						<td><fmt:message key="member.income.other" />&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="Income_other"
							type="text" size="15" onchange="cal2()" id="a6" /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.income.deduct" /> &nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="Deduction_57"
							type="text" size="15" onchange="cal2()" id="a7" />
						</td>
						<td><fmt:message key="member.income.totalother" />&nbsp;
							&nbsp; &nbsp; &nbsp;&nbsp; <input name="TotalOther_income"
							type="text" size="15" onchange="cal2()" id="a8" readonly /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
				</table>


				<h3 style="color: blue" align="left">

					<fmt:message key="member.income.expenses" />
				</h3>
				<br />
				<table>
					<tr>
						<td width="340"><fmt:message key="member.income.deductfamily" />
							<br /> <fmt:message key="member.income.pension" /> &nbsp;
							&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Familypension_deduction" type="text" size="15"
							onblur="cal3()" id="b1" readonly />
						</td>
						<td width="350"><fmt:message key="member.income.others" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Other_deduction" type="text" size="15" onchange="cal3()"
							id="b2" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.income.depreciation" />&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="Depreciation"
							type="text" size="15" onchange="cal3()" id="b3" /></td>
						<td><fmt:message key="member.total.expenses" />&nbsp; &nbsp;
							&nbsp;<input name="Total_expenses" type="text" size="15"
							onchange="cal3()" id="b4" readonly />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>

				</table>


				<h3 style="color: blue" align="left">
					<fmt:message key="member.income.taxfree" />
				</h3>
				<br />
				<table>
					<tr>
						<td width="340"><fmt:message key="member.div.uti" /> &nbsp;
							&nbsp; &nbsp;&nbsp; <input name="Dividends_uti" type="text"
							size="15" onchange="cal4()" id="c1" />
						</td>
						<td width="350"><fmt:message key="member.income.intincome" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="Interest_income" type="text" size="15"
							onchange="cal4()" id="c2" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.div.mutual" /> <br /> <fmt:message
								key="member.income.funds" />&nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="Dividends_mutualfund" type="text" size="20"
							onchange="cal4()" id="c3" /></td>
						<td><fmt:message key="member.income.agriculture" />&nbsp;
							&nbsp; &nbsp; <input name="Agriculture_income" type="text"
							size="20" onchange="cal4()" id="c4" />
						</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><fmt:message key="member.div.indian" /> <br /> <fmt:message
								key="member.income.companies" />&nbsp; &nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <input
							name="Dividends_indian_companies" type="text" size="15"
							onchange="cal4()" id="c5" />
						</td>
						<td><fmt:message key="member.other.income" />&nbsp;&nbsp;
							&nbsp; &nbsp;&nbsp; <input name="Total_income" type="text"
							size="15" onchange="cal4()" id="c6" /></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><fmt:message key="member.total.otherincome" />&nbsp;
							&nbsp; &nbsp; <input name="Total_taxfree_income" type="text"
							size="15" onchange="cal4()" id="c7" readonly /></td>
					</tr>
					<tr>
						<td width="320"><fmt:message key="member.taxable.income" />
							&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <input
							name="Taxable_income" type="text" size="15" onblur="cal5()"
							id="Taxable" readonly /><br /> <br /> <br />
						</td>
						<td width="370"><input type="submit" value="Save" />&nbsp;
							&nbsp; &nbsp; <input type="button" onclick="nextScreen()"
							value="Skip" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</form>
<script>
	function cal1() {
		var A = document.getElementById("A").value - 0;
		var B = document.getElementById("B").value - 0;
		var C = document.getElementById("C").value - 0;
		var D = document.getElementById("D").value - 0;
		var E = document.getElementById("E").value - 0;
		var F = document.getElementById("F").value - 0;
		document.getElementById("G").value = (A + B + C + D + E + F);

	}
	function cal2() {
		var a1 = document.getElementById("a1").value - 0;
		var a2 = document.getElementById("a2").value - 0;
		var a3 = document.getElementById("a3").value - 0;
		var a4 = document.getElementById("a4").value - 0;
		var a5 = document.getElementById("a5").value - 0;
		var a7 = document.getElementById("a7").value - 0;
		var a6 = document.getElementById("a6").value - 0;
		document.getElementById("a8").value = (a1 + a2 + a3 + a4 + (a5 - a7) + a6);

	}
	function cal3() {
		var a1 = document.getElementById("a1").value - 0;
		document.getElementById("b1").value = myfamily(a1)
		function myfamily(a) {
			return (a * 333 / 1000);
		}
		var b1 = document.getElementById("b1").value - 0;
		var b2 = document.getElementById("b2").value - 0;
		var b3 = document.getElementById("b3").value - 0;
		document.getElementById("b4").value = (b1 + b2 + b3);
	}
	function cal4() {
		var c1 = document.getElementById("c1").value - 0;
		var c2 = document.getElementById("c2").value - 0;
		var c3 = document.getElementById("c3").value - 0;
		var c4 = document.getElementById("c4").value - 0;
		var c5 = document.getElementById("c5").value - 0;
		var c6 = document.getElementById("c6").value - 0;
		document.getElementById("c7").value = (c1 + c2 + c3 + c4 + c5 + c6);

	}
	function cal5() {
		alert("i am in cal 5");
		var G = document.getElementById("G").value - 0;
		var a8 = document.getElementById("a8").value - 0;
		var b4 = document.getElementById("b4").value - 0;
		document.getElementById("Taxable").value = mycal(G, a8, b4);

	}
	function mycal(a, b, c) {
		return (a + b - c);
	}

	function nextScreen() {
		alert("nextScreen");

		document.forms['frmincome'].elements["screenMode"].value = "NEXTSCREEN";
		document.getElementById('frmincome').submit();
	}
</script>

<!-- code for personal information popup window -->
<!-- modal content -->
<div id="basic-modal-contentbankint">
	<jsp:include page="../member/bankinterest.jsp" flush="false" />
</div>
<div id="basic-modal-contentotherint">
	<jsp:include page="../member/otherinterest.jsp" flush="false" />
</div>
<!-- preload the images -->

<div style='display: none'>
	<img src='images/basic/x.png' alt='' />
</div>

<hst:headContribution keyHint="formcss">
	<link rel="stylesheet" href='<hst:link path="/css/adornment.css"/>'
		type="text/css" />
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
<hst:headContribution keyHint="form-validation" category="jsInternal">
	<script type="text/javascript"
		src='<hst:link path="/js/reverse_animation.js"/>'></script>
</hst:headContribution>