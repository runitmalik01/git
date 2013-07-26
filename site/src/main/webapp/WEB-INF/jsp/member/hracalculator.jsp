<%@include file="../includes/commonincludes.jspf"%>

<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="memberlogin page type-page"></div>
<h3 class="title text-center text-success">HRA Calculator</h3>

<form id="frmRating" action="${actionUrl}" method="post" name="hra">


	<p>
		<label for="metrocity" class="text-warning">I am staying in
			METRO</label> <select name="metrocity" id="metrocity" onChange="hracalc()" >
			<option value="Select">Select</option>
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		</select>
	</p>
	<p>
		<label for="salary">Basic Salary (p.a) </label> <input required
			name="salary" type="text" id="salary" placeholder="per Annum" onChange="hracalc()"
			title="Please fill this field" onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="da">Dearness Allowance (p.a) </label> <input required
			name="da" type="text" id="da" title="Please fill this field" onChange="hracalc()"
			placeholder="per Annum" onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="allowhra">House Rent Allowance (p.a) </label> <input
			required name="allowhra" type="text" id="allowhra" onChange="hracalc()"
			title="Please fill this field" placeholder="per Annum"
			onkeypress="return isNumberKey(event)" />
	</p>

	<p>
		<label for="rent">Rent Paid (p.a) </label> <input required name="rent"
			type="text" id="rent" placeholder="per Annum"  onChange="hracalc()"
			onkeypress="return isNumberKey(event)" />
	</p>
	<p>
		<label for="finalhra">HRA Exemption will be allowed</label> <input
		required name="finalhra" type="text" id="finalhra" readonly />
	</p>

</form>






