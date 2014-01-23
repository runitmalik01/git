<%@include file="../includes/commonincludes.jspf"%>

<hst:actionURL var="actionUrl"></hst:actionURL>
<c:set var="hratitle">
	<fmt:message key="calculator.hra.title" />
</c:set>
<hippo-gogreen:title title="${hratitle}" />
<div class="memberlogin page type-page"></div>
<h3 class="title text-center">House Rent Allowance Calculator</h3>
<div class="text-info">House Rent Allowance (HRA) is given by the
	employer to the employee to meet the expenses in connection with rent
	of the accommodation which the employee might have to make for his
	residential purpose. This House Rent Allowance so paid by the employer
	to his employee is taxable under head "Income from salaries" to extent
	it is not exempt u/s 10(13A).</div>


<form id="frmRating" action="${actionUrl}" method="post" name="hra">
	<p>
		<label for="metrocity" class="text-danger">Are you staying in
			metro city?</label> <select name="metrocity" id="metrocity"
			onChange="hracalc()">
			<option value="Select">-Select-</option>
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		</select>
	</p>
	<p>
		<label for="salary">Basic Salary (&#8377;) </label> <input required
			name="salary" type="text" id="salary" placeholder="per Annum"
			onChange="hracalc()" title="Please fill this field"
			onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="da">Dearness Allowance (&#8377;) </label> <input required
			name="da" type="text" id="da" title="Please fill this field"
			onChange="hracalc()" placeholder="per Annum"
			onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="allowhra">House Rent Allowance (&#8377;)</label> <input
			required name="allowhra" type="text" id="allowhra"
			onChange="hracalc()" title="Please fill this field"
			placeholder="per Annum" onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="rent">Rent Paid (&#8377;) </label> <input required
			name="rent" type="text" id="rent" placeholder="per Annum"
			onChange="hracalc()" onkeypress="return isNumberKey(event)" />
	</p>
	<p>
		<label for="finalhra">HRA Exemption will be allowed to you is
			(&#8377;)</label> <input required name="finalhra" type="text" id="finalhra"
			readonly />
	</p>
</form>

