
<%@include file="../includes/commonincludes.jspf"%>

<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page"></div>
<h3>
	<fmt:message key="emi.calculator" />
</h3>
Equated monthly installment (EMI) is commonly the scheme for personal and home loans. Any borrowed amount from a bank or financial institution is called principal (P), yearly interest rate which the bank charges for lending us the money is called annual interest rate (I) and 
number of months within which one has agreed to repay the borrowed amount along with interest is called the term (N) months.
<form id="frmRating" action="${actionUrl}" method="post" name="emi">

	<p>
		<label for="A"><fmt:message key="emi_loan_amount" />
		</label> <input required name="loan_amount" type="text" id="A"
			onChange="fill()" title="Please fill this field" onkeypress="return isNumberKey(event)"  />
	</p>

	<p>
		<label for="B"><fmt:message key="emi_interest_rate" />
		</label> <input required name="interest_rate" type="text" id="B"
			onChange="fill()" title="Please fill this field"
			placeholder="% Per Annum" onkeypress="return isNumberKey(event)"  />
	</p>

	<p>
		<label for="C"><fmt:message key="emi_loan_tenure" />
		</label> <input required name="loan_tenure" type="text" id="C"
			onChange="fill()" title="Please fill this field"
			placeholder="In Months" onkeypress="return isNumberKey(event)"  />
	</p>

	<p>
		<label for="D"><fmt:message key="emi_calculation" />
		</label> <input required name="loan_tenure" type="text" id="D"
			onChange="fill()" readonly="readonly" />
	</p>


<%-- 	<a id="hrefTaxCalc" href="#" class="button orange"><fmt:message
			key="tax_button" /> </a>   --%>

<%-- 	<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#hrefTaxCalc').click(function() {
 				 $('#frmTaxCalc').submit();
			});
			$('#frmTaxCalc input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
			        $('#frmTaxCalc').submit();
			    }
			});
		});    
</hst:element>
	<hst:headContribution element="${uiCustom}" category="jsInternal" /> --%>
</form>


