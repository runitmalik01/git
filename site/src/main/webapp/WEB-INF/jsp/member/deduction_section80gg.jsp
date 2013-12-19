<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>

<fieldset>
	<legend>Rent Paid Detail</legend>
	<div class="row show-grid">
	      <div class="col-md-8">
	      	<div class="rowlabel"><label for="rent_month"><small>No. of months for which rent paid</small></label></div>
	      	<div class="rowlabel"><w4india:dropdown dropDownSelectId="rent_month" dropDownType="numbersDropdown" optionSelectString="Select"/></div>
	      </div>
	      <div class="col-md-4">
	      	<div class="rowlabel"><label for="rent_amoutnt"><small>Total amount of rent paid</small></label></div>
	      	<div class="rowlabel"><input id="rent_amount" name="rent_amount" placeholder="Rs." type="text" maxlength="10" value=""/></div>
	      </div>
	</div>		
</fieldset>