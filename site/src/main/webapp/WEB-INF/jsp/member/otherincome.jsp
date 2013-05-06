
<%@include file="../includes/commonincludes.jspf"%>
<c:set var="otherincometitle">
	<fmt:message key="member.otherincome.title" />
</c:set>
<hippo-gogreen:title title="${otherincometitle}" />
<div id="breadcrumbs">
	<fmt:message key="member.location.label" />
	&nbsp;

	<hst:link var="home" siteMapItemRefId="home" />
	<a href="${home}"><fmt:message key="products.detail.location.home" />
	</a>&gt;

	<hst:link var="startapplication"
		siteMapItemRefId="member-personal-information"></hst:link>
	<a href="${startapplication}"><fmt:message
			key="member.start.application" /> </a>&gt;

	<hst:link var="memberothersources"
		siteMapItemRefId="member-other-income"></hst:link>
	<a href="${memberothersources}"><fmt:message
			key="member.other.income" /> </a>

</div>


<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="oi" id="frmIncomeinfo" action="${actionUrl}" method="post">
	<fieldset>
		<legend style="color: blue" align="left">
			<fmt:message key="member.interest.tax" />
		</legend>
		<table>
			<tr>
				<td><label for="Gov_income "><fmt:message
							key="member.income.gov" /> </label></td>
				<td align="right"><input type="text" name="Gov_income"
					maxlength="14" title="Enter income from Govt." class="numberinput"
					value="${parentBean.gov_income}" id="A" onchange="cal1()" />
				<td><label for="Kissanpatra "><fmt:message
							key="member.income.kissan" /> </label>
				</td>
				<td><input type="text" name="Kissan" maxlength="14"
					value="${parentBean.kissan}" class="numberinput" id="B"
					onchange="cal1()" />
				</td>
			<tr>
				<td><label for="Bank_interest "><fmt:message
							key="member.bank.interest" /> </label>
				</td>
				<td><input type="text" name="Bank_detail_fdr" maxlength="14"
					value="${parentBean.bank_detail_fdr}" class="numberinput" id="C"
					onchange="cal1()" />
				</td>
				<td><label for="Bank_interest "><fmt:message
							key="member.bank.interest1" /> </label>
				</td>

				<td><input type="text" name="Bank_detail_saving" maxlength="14"
					value="${parentBean.bank_detail_saving}" class="numberinput" id="S"
					onchange="cal1()" />
				</td>
			</tr>
			<tr>
				<td><label for="Indira"><fmt:message
							key="member.interest.indiravikas" /> </label>
				</td>
				<td><input type="text" name="Indira" maxlength="14"
					value="${parentBean.indira}" class="numberinput" id="D"
					onchange="cal1()" />
				</td>
				<td><label for="intnsc"><fmt:message
							key="member.interest.nsc" /> </label>
				</td>
				<td><input type="text" name="intnsc" maxlength="14"
					value="${parentBean.intnsc}" class="numberinput" id="E"
					onchange="cal1()" />
				</td>
			</tr>
			<tr>
				<td><label for="Otherint "><fmt:message
							key="member.other.interest" /> </label>
				</td>
				<td><input type="text" name="Otherint" maxlength="14"
					value="${parentBean.otherint}" class="numberinput" id="F"
					onchange="cal1()" />
				<td><label for="Totalint "><fmt:message
							key="member.total.interest" /> </label>
				</td>
				<td><input type="text" name="Totalint"
					value="${parentBean.totalint}" id="G" onchange="cal1()"
					readonly="readonly" />
				</td>
			</tr>
		</table>
	</fieldset>

	<fieldset>
		<legend style="color: blue" align="left">

			<fmt:message key="member.otherincome.message1" />
		</legend>
		<table>
			<tr>
				<td><label for="Family_pension"><fmt:message
							key="member.family.pension" /> </label>
				</td>
				<td><input type="text" name="Family_pension"
					value="${parentBean.family_pension}" maxlength="14"
					class="numberinput" id="a1" onchange="cal2()" />
				</td>
				<td><label for="Dividends"><fmt:message
							key="member.dividends" /> </label>
				</td>
				<td><input type="text" name="Dividends"
					value="${parentBean.dividends}" maxlength="14" class="numberinput"
					id="a2" onchange="cal2()" />
				</td>
			</tr>
			<tr>
				<td><label for="Lottery_horse_income"><fmt:message
							key="member.income.lottery" /> </label>
				</td>
				<td><input type="text" name="Lottery_horse_income"
					value="${parentBean.lottery_horse_income}" maxlength="14"
					class="numberinput" id="a3" onchange="cal2()" />
				</td>
				<td><label for="Income_rent_machine"><fmt:message
							key="member.income.rental" /> </label>
				</td>
				<td><input type="text" name="Income_rent_machine"
					value="${parentBean.income_rent_machine}" class="numberinput"
					id="a4" onchange="cal2()" maxlength="14" />
				</td>
			</tr>
			<tr>
				<td><label for="Income_rent_machine"><fmt:message
							key="member.income.maintain" /> </label>
				</td>
				<td><input type="text" name="Income_maintain"
					value="${parentBean.income_maintain}" class="numberinput" id="a5"
					onchange="cal2()" maxlength="14" />
				</td>
				<td><label for="Income_other "><fmt:message
							key="member.income.other" /> </label>
				</td>
				<td><input type="text" name="Income_other" maxlength="14"
					value="${parentBean.income_other}" class="numberinput" id="a6"
					onchange="cal2()" />
				</td>

			</tr>
			<tr>
				<td><label for="Deduction_57 "><fmt:message
							key="member.income.deduct" /> </label>
				</td>
				<td><input type="text" name="Deduction_57"
					value="${parentBean.deduction_57}" class="numberinput" id="a7"
					onchange="cal2()" maxlength="14" />
				</td>
				<td><label for="TotalOther_income "><fmt:message
							key="member.income.totalother" /> </label>
				</td>
				<td><input type="text" name="TotalOther_income"
					value="${parentBean.totalOther_income}" id="a8" onchange="cal2()"
					readonly="readonly" />
				</td>
			</tr>
		</table>

	</fieldset>
	<fieldset>
		<legend style="color: blue" align="left">
			<fmt:message key="member.income.expenses" />
		</legend>
		<table>
			<tr>
				<td><label for="Familypension_deduction "><fmt:message
							key="member.income.deductfamily" /> </label>
				</td>
				<td><input type="text" name="Familypension_deduction"
					maxlength="14" class="numberinput"
					value="${parentBean.familypension_deduction}" id="b1"
					onchange="cal3()" readonly="readonly" />
				<td><label for="Otherdeduction "><fmt:message
							key="member.income.others" /> </label>
				</td>
				<td><input type="text" name="Otherdeduction" maxlength="14"
					value="${parentBean.otherdeduction}" class="numberinput" id="b2"
					onchange="cal3()" />
				</td>
			<tr>
				<td><label for="depreciation"><fmt:message
							key="member.income.depreciation" /> </label>
				</td>
				<td><input type="text" name="depreciation" maxlength="14"
					value="${parentBean.depreciation}" class="numberinput" id="b3"
					onchange="cal3()" />
				</td>
				<td><label for="totalexpense "><fmt:message
							key="member.total.expenses" /> </label>
				</td>
				<td><input type="text" name="totalexpense" maxlength="14"
					value="${parentBean.totalexpense}" id="b4" onchange="cal3()"
					readonly="readonly" />
				</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend style="color: blue" align="left">
			<fmt:message key="member.income.taxfree" />
		</legend>
		<table>
			<tr>
				<td><label for="Dividends_uti"><fmt:message
							key="member.div.uti" /> </label>
				</td>
				<td><input type="text" name="Dividends_uti"
					value="${parentBean.dividends_uti}" class="numberinput"
					maxlength="14" id="c1" onchange="cal4()" />
				</td>
				<td><label for="Interest_income"><fmt:message
							key="member.income.intincome" /> </label>
				</td>
				<td><input type="text" name="Interest_income"
					value="${parentBean.interest_income}" class="numberinput" id="c2"
					onchange="cal4()" maxlength="14" />
				</td>
			</tr>
			<tr>
				<td><label for="Dividends_mutualfund"><fmt:message
							key="member.div.mutual" /> </label>
				</td>
				<td><input type="text" name="Dividends_mutualfund"
					value="${parentBean.dividends_mutualfund}" class="numberinput"
					id="c3" onchange="cal4()" />
				</td>
				<td><label for="Agriculture_income"><fmt:message
							key="member.income.agriculture" /> </label>
				</td>
				<td><input type="text" name="Agriculture_income"
					value="${parentBean.agriculture_income}" class="numberinput"
					id="c4" onchange="cal4()" maxlength="14" />
				</td>
			</tr>
			<tr>
				<td><label for="Dividends_indian_companies"><fmt:message
							key="member.div.indian" /> </label>
				</td>
				<td><input type="text" name="Dividends_indian_companies"
					value="${parentBean.dividends_indian_companies }"
					class="numberinput" id="c5" onchange="cal4()" maxlength="14" />
				</td>
				<td><label for="Other_income "><fmt:message
							key="member.other.income" /> </label>
				</td>
				<td><input type="text" name="Otherincome"
					value="${parentBean.otherincome}" maxlength="14"
					class="numberinput" id="c6" onchange="cal4()" />
				</td>
			</tr>
			<tr>
				<td><label for="Total_taxfree_income "><fmt:message
							key="member.total.otherincome" /> </label>
				</td>
				<td><input type="text" name="Total_taxfree_income"
					value="${parentBean.total_taxfree_income}" class="numberinput"
					id="c7" onchange="cal4()" maxlength="14" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td><label for="Taxable_income "><fmt:message
							key="member.taxable.income" /> </label>
				</td>
				<td><input type="text" name="Taxable_income"
					value="${parentBean.taxable_income}" id="Taxable" onblur="cal5()"
					readonly="readonly" />
				</td>
			</tr>
		</table>
	</fieldset>
	<input type="submit" value="Save & Next"><a
		href="${modifiedSiteMapRefId}" class="button orange"
		style="margin-left: 100px;">Next</a>

</form>
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
                  
			    $('#frmIncomeinfo input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmIncomeinfo').submit();
				    }
				});
				$('#hrefLogin').click(function() {
		 			$('#frmIncomeinfo').submit();
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<script>
	function cal1() {
		var A = document.getElementById("A").value - 0;
		var B = document.getElementById("B").value - 0;
		var C = document.getElementById("C").value - 0;
		var D = document.getElementById("D").value - 0;
		var E = document.getElementById("E").value - 0;
		var F = document.getElementById("F").value - 0;
		var S = document.getElementById("F").value - 0;
		document.getElementById("G").value = (A + B + C + S + D + E + F);

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
		document.getElementById("b1").value = myfamily(a1);
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
		var G = document.getElementById("G").value - 0;
		var a8 = document.getElementById("a8").value - 0;
		var b4 = document.getElementById("b4").value - 0;
		document.getElementById("Taxable").value = mycal(G, a8, b4);

	}
	function mycal(a, b, c) {
		return (a + b - c);
	}
</script>