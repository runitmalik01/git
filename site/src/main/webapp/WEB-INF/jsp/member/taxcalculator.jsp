
<%@include file="../includes/commonincludes.jspf" %>


<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page"></div>
<h3>
	<fmt:message key="tax_calculator" />
</h3>
<form id="frmTaxCalc" action="${actionUrl}" method="post" name="tax">

	<p>
		<label for="cbassyear"><fmt:message key="tax_assessment_year" />
		</label> <select name="cbassyear" id="cbassyear" onchange="calculateTax()" />
		<option value="Select One">Select One</option>
		<option value="2013-14">2013-14</option>
		<option value="2012-13">2012-13</option>
		<option value="2011-12">2011-12</option>
		</select>
	</p>
	<p>
		<label for="cbasstype"><fmt:message key="tax_tax_payer" /> </label> <select
			name="cbasstype" id="cbasstype" onchange="calculateTax();display()" />
		<option value="Select One">Select One</option>
		<option value="Individual">Individual</option>
		<option value="HUF">HUF</option>
		<option value="Firms">Firms</option>
		<option value="Local Authority">Local Authority</option>
		<option value="Domestic Company">Domestic Company</option>
		<option value="Co-operative Society">Co-operative Society</option>
		</select>
	</p>
	<p>
		<label for="cbasscategory"><span id="gender"><fmt:message
					key="tax_gender" />
		</span> </label> <select name="cbasscategory" id="cbasscategory"
			onchange="calculateTax();age()" />
		<option value="Select One">Select One</option>
		<option value="Male">Male</option>
		<option value="Female">Female</option>
		<option value="Senior Citizen">Senior Citizen</option>
		<option value="Super Senior Citizen">Super Senior Citizen</option>
		</select>
	</p>
	<p>
		<label for="cbresistatus"><span id="resistatus"><fmt:message
					key="tax_residential_status" />
		</span> </label> <select name="cbresistatus" id="cbresistatus"
			onchange="calculateTax()" />
		<option value="Select One">Select One</option>
		<option value="Resident">Resident</option>
		<option value="Non-Resident">Non-Resident</option>
		<option value="Not Ordinary Resident">Not Ordinary Resident</option>
		</select>
	</p>
	<p>
		<label for="txtNetIncome"><fmt:message
				key="tax_net_taxable_income" /> </label> <input name="txtNetIncome"
			type="text" id="txtNetIncome" onchange="calculateTax()" />
	</p>
	<p>
		<label for="txtTax"><fmt:message key="tax_income_tax" /> </label> <input
			name="txtTax" type="text" id="txtTax" readonly />
	</p>

	<p>
		<label for="txtEduCess"><fmt:message key="tax_education" /> </label>
		<input name="txtEduCess" type="text" id="txtEduCess" readonly />
	</p>
	<p>
		<label for="txtHEduCess"><fmt:message
				key="tax_sec_high_education" /> </label><input name="txtHEduCess"
			type="text" id="txtHEduCess" readonly />
	<p>
		<label for="txtsurcharge"><fmt:message key="tax_surcharge" />
		</label> <input name="txtsurcharge" type="text" id="txtsurcharge" readonly />
	</p>
	<p>
		<label for="txttotaltax"><fmt:message key="tax_tax_liability" />
		</label> <input name="txttotaltax" type="text" id="txttotaltax" readonly />
	</p>

	<p>
		<a id="hrefTaxCalc" href="#" class="button orange"><fmt:message
				key="tax_button" /> </a>



		<hst:element var="uiCustom" name="script">
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
			$('#frmTaxCalc').validate({
				rules: {
					cbassyear: {
						required: true,
						minlength: 1
					},
					cbasstype: {
						required: true,
						maxlength: 3,
						number:true,
					},
					cbasscategory: {
						required: true,
						minlength: 2
					},
					cbresistatus: {
						required: true,
						minlength: 2,
					}
					txtNetIncome: {
						required: true,
						minlength: 2,
					}
				},				
				messages: {
						cbassyear: "Please enter a valid <fmt:message
				key="tax_assessment_year" />.",
					cbasstype: "Please enter a valid <fmt:message key="tax_tax_payer" />.",
					cbasscategory: "Please enter a valid <fmt:message key="tax_gender" />.",
					cbresistatus: "Please enter a valid <fmt:message
				key="tax_residential_status" />.",
					txtNetIncome: "Please enter a valid <fmt:message key="txtNetIncome" />.",
				}
			});
			
			
		});    
</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal" />
</form>