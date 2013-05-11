<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@include file="../includes/commonincludes.jspf"%>
<c:set var="otherincometitle">
	<fmt:message key="member.otherincome.title" />
</c:set>
<hippo-gogreen:title title="${otherincometitle}" />


<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="oi" id="frmIncomeinfo" action="${actionUrl}" method="post">
	<fieldset>
		<legend>
			<fmt:message key="member.interest.tax" />
		</legend>
		<div class="row-fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="Gov_income "><fmt:message
							key="member.income.gov" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Gov_income" maxlength="14"
						title="Enter income from Govt." class="numberinput decimal"
						value="${parentBean.gov_income}" id="A" onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Kissanpatra "><fmt:message
							key="member.income.kissan" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Kissan" maxlength="14"
						value="${parentBean.kissan}" class="numberinput decimal" id="B"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Bank_interest "><fmt:message
							key="member.bank.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Bank_detail_fdr" maxlength="14"
						value="${parentBean.bank_detail_fdr}" class="numberinput decimal" id="C"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Bank_interest "><fmt:message
							key="member.bank.interest1" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Bank_detail_saving" maxlength="14"
						value="${parentBean.bank_detail_saving}" class="numberinput decimal"
						id="S" onchange="cal1()" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">

			<div class="span3">
				<div class="rowlabel">
					<label for="Indira"><fmt:message
							key="member.interest.indiravikas" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Indira" maxlength="14"
						value="${parentBean.indira}" class="numberinput decimal" id="D"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="intnsc"><fmt:message key="member.interest.nsc" />
					</label>
				</div>
				<div class="rowlabel">
					<input type="text" name="intnsc" maxlength="14"
						value="${parentBean.intnsc}" class="numberinput decimal" id="E"
						onchange="cal1()" />
				</div>
			</div>

			<div class="span3">
				<div class="rowlabel">
					<label for="Otherint "><fmt:message
							key="member.other.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Otherint" maxlength="14"
						value="${parentBean.otherint}" class="numberinput decimal" id="F"
						onchange="cal1()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel">
					<label for="Totalint "><fmt:message
							key="member.total.interest" /> </label>
				</div>
				<div class="rowlabel">
					<input type="text" name="Totalint" value="${parentBean.totalint}" class="decimal"
						id="G" onchange="cal1()" readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>
			<fmt:message key="member.otherincome.message1" />
		</legend>
		<div class="row-fluid show-grid">
				<div class="span4">
				<div class="rowlabel">
				<label for="Family_pension"><fmt:message
							key="member.family.pension" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Family_pension"
					value="${parentBean.family_pension}" maxlength="14"
					class="numberinput decimal" id="a1" onchange="cal2()" />
				</div>
				</div>
				<div class="span4">
				<div class="rowlabel">
				<label for="Dividends"><fmt:message
							key="member.dividends" /> </label>
				</div>
				<div class="rowlabel">
				<input type="text" name="Dividends"
					value="${parentBean.dividends}" maxlength="14" class="numberinput decimal"
					id="a2" onchange="cal2()" /></div>
				</div>

			
				<c:if test="${empty hideHorseIncome }">
					<td><label for="Lottery_horse_income"><fmt:message
								key="member.income.lottery" /> </label>
					</td>
					<td><input type="text" name="Lottery_horse_income"
						value="${parentBean.lottery_horse_income}" maxlength="14"
						class="numberinput" id="a3" onchange="cal2()" />
					</td>
				</c:if>
				<div class="span4">
				<div class="rowlabel">
				<label for="Income_rent_machine"><fmt:message
							key="member.income.rental" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Income_rent_machine"
					value="${parentBean.income_rent_machine}" class="numberinput decimal"
					id="a4" onchange="cal2()" maxlength="14" />
				</div>
			</div>
			</div>

              <div class="row-fluid show-grid">
				<div class="span4">
				<div class="rowlabel">
				<label for="Income_rent_machine"><fmt:message
							key="member.income.maintain" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Income_maintain"
					value="${parentBean.income_maintain}" class="numberinput decimal" id="a5"
					onchange="cal2()" maxlength="14" />
				</div>
				</div>
				<div class="span3">
				<div class="rowlabel">
				<label for="Income_other "><fmt:message
							key="member.income.other" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Income_other" maxlength="14"
					value="${parentBean.income_other}" class="numberinput decimal" id="a6"
					onchange="cal2()" /></div>
				</div>

			<div class="span3">
				<div class="rowlabel">
				<label for="Deduction_57 "><fmt:message
							key="member.income.deduct" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Deduction_57"
					value="${parentBean.deduction_57}" class="numberinput decimal" id="a7"
					onchange="cal2()" maxlength="14" />
				</div>
				</div>
				<div class="span2">
				<div class="rowlabel">
				<label for="TotalOther_income "><fmt:message
							key="member.income.totalother" /> </label>
				</div>
				<div class="rowlabel">
				<input type="text" name="TotalOther_income"
					value="${parentBean.totalOther_income}" id="a8" onchange="cal2()" class="decimal"
					readonly="readonly" />
				</div>
			</div>
		</div>

	</fieldset>
	<fieldset>
		<legend>
			<fmt:message key="member.income.expenses" />
		</legend>
		 <div class="row-fluid show-grid">
		 <div class="span3">
		 <div class="rowlabel">
				<label for="Familypension_deduction "><fmt:message
							key="member.income.deductfamily" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Familypension_deduction"
					maxlength="14" class="numberinput decimal"
					value="${parentBean.familypension_deduction}" id="b1"
					onchange="cal3()" readonly="readonly" /></div>
					</div>
					<div class="span3">
					<div class="rowlabel">
					<label for="Otherdeduction "><fmt:message
							key="member.income.others" /> </label>
				</div>
				
				<div class="rowlabel">
				<input type="text" name="Otherdeduction" maxlength="14"
					value="${parentBean.otherdeduction}" class="numberinput decimal" id="b2"
					onchange="cal3()" /></div>
				</div>
				<div class="span3">
				<div class="rowlabel">
			
				<label for="depreciation"><fmt:message
							key="member.income.depreciation" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="depreciation" maxlength="14"
					value="${parentBean.depreciation}" class="numberinput decimal" id="b3"
					onchange="cal3()" />
				</div>
				</div>
				<div class="span3">
				<div class="rowlabel">
				<label for="totalexpense "><fmt:message
							key="member.total.expenses" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="totalexpense" maxlength="14"
					value="${parentBean.totalexpense}" id="b4" onchange="cal3()" class="decimal"
					readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset>
		<legend>
			<fmt:message key="member.income.taxfree" />
		</legend>
		<div class="row-fluid show-grid">
				<div class="span3">
				<div class="rowlabel">
				<label for="Dividends_uti"><fmt:message
							key="member.div.uti" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Dividends_uti"
					value="${parentBean.dividends_uti}" class="numberinput decimal"
					maxlength="14" id="c1" onchange="cal4()" />
				</div>
				</div>
				<div class="span3">
				<div class="rowlabel">
				<label for="Interest_income"><fmt:message
							key="member.income.intincome" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Interest_income"
					value="${parentBean.interest_income}" class="numberinput decimal" id="c2"
					onchange="cal4()" maxlength="14" />
				</div>
			</div>
			<div class="span3">
			<div class="rowlabel"><label for="Dividends_mutualfund"><fmt:message
							key="member.div.mutual" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Dividends_mutualfund"
					value="${parentBean.dividends_mutualfund}" class="numberinput decimal"
					id="c3" onchange="cal4()" />
				</div>
				</div>
					<div class="span3">
					<div class="rowlabel">
					<label for="Agriculture_income"><fmt:message
							key="member.income.agriculture" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Agriculture_income"
					value="${parentBean.agriculture_income}" class="numberinput decimal"
					id="c4" onchange="cal4()" maxlength="14" />
				</div>
			</div>
			</div>
				<div class="row-fluid show-grid">
				<div class="span4">
				<div class="rowlabel">
				<label for="Dividends_indian_companies"><fmt:message
							key="member.div.indian" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Dividends_indian_companies"
					value="${parentBean.dividends_indian_companies }"
					class="numberinput decimal" id="c5" onchange="cal4()" maxlength="14" />
				</div></div>
				<div class="span3">
				<div class="rowlabel">
				<label for="Other_income "><fmt:message
							key="member.other.income" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Otherincome"
					value="${parentBean.otherincome}" maxlength="14"
					class="numberinput decimal" id="c6" onchange="cal4()" />
				</div>
			</div>
			<div class="span3">
				<div class="rowlabel"><label for="Total_taxfree_income "><fmt:message
							key="member.total.otherincome" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Total_taxfree_income"
					value="${parentBean.total_taxfree_income}" class="numberinput decimal"
					id="c7" onchange="cal4()" maxlength="14" readonly="readonly" />
				</div>
			</div>
			<div class="span2">
				<div class="rowlabel"><label for="Taxable_income "><fmt:message
							key="member.taxable.income" /> </label>
				</div>
				<div class="rowlabel"><input type="text" name="Taxable_income"
					value="${parentBean.taxable_income}" id="Taxable" onblur="cal5()"
					readonly="readonly" />
				</div>
			</div>

		</div>
	</fieldset>
	<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						
								<input type="submit" id="myModalHref" class="button olive" value="Save">

					</div>
				</div>
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
</hst:element> <hst:headContribution
						element="${uiCustom}" category="jsInternal" /> <script>
							function cal1() {
								var A = document.getElementById("A").value - 0;
								var B = document.getElementById("B").value - 0;
								var C = document.getElementById("C").value - 0;
								var D = document.getElementById("D").value - 0;
								var E = document.getElementById("E").value - 0;
								var F = document.getElementById("F").value - 0;
								var S = document.getElementById("F").value - 0;
								document.getElementById("G").value = (A + B + C
										+ S + D + E + F);

							}
							function cal2() {
								var a1 = document.getElementById("a1").value - 0;
								var a2 = document.getElementById("a2").value - 0;
								//var a3 = document.getElementById("a3").value - 0;
								var a4 = document.getElementById("a4").value - 0;
								var a5 = document.getElementById("a5").value - 0;
								var a7 = document.getElementById("a7").value - 0;
								var a6 = document.getElementById("a6").value - 0;
								document.getElementById("a8").value = (a1 + a2
										+ a4 + (a5 - a7) + a6);

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
								document.getElementById("c7").value = (c1 + c2
										+ c3 + c4 + c5 + c6);

							}
							function cal5() {
								var G = document.getElementById("G").value - 0;
								var a8 = document.getElementById("a8").value - 0;
								var b4 = document.getElementById("b4").value - 0;
								document.getElementById("Taxable").value = mycal(
										G, a8, b4);

							}
							function mycal(a, b, c) {
								return (a + b - c);
							}
						</script>