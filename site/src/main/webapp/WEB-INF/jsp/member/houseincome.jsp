
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="parentBeantitle"><fmt:message key="member.parentBean.title"/></c:set>
<hippo-gogreen:title title="${parentBeantitle}"/>
<script type="text/javascript"
	src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<hst:actionURL var="actionUrl" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.2.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.2.js"></script>

<%-- Script is written for show and hide --%>
<script type="text/javascript">
var $m=jQuery.noConflict(true);
</script>
<script type="text/javascript">
hideAllDivs = function () {
    $("#hourly").hide();
    $("#per_diem").hide();
    $("#button").show();
};

handleNewSelection = function () {

    hideAllDivs();
    
    switch ($(this).val()) {
        case '1':
            $("#hourly").show();
            $("#button").show();
        break;
        case '2':
            $("#per_diem").show();
            $("#button").show();
        break;
    }
};

$(document).ready(function() {
    
    $("#project_billing_code_id").change(handleNewSelection);
    
    // Run the event handler once now to ensure everything is as it should be
    handleNewSelection.apply($("#project_billing_code_id"));
    
	});

</script>


<%-- Code for Dropdown --%>
<h2 style="color: blue">Whether your House Property let out:</h2>

<c:set var="searchresultstitle">
	<fmt:message key="select.one.title" />
</c:set>
<c:set var="booleanType">
	<fmt:message key="dropdown.boolean" />
</c:set>
<w4india:dropdown dropDownSelectId="project_billing_code_id"
	optionSelectString="${searchresultstitle}"
	dropDownType="${booleanType}" />
<form action="${actionUrl}" method="POST">
	<%-- This div is for yes form --%>
	<div id="hourly">

		<table>
			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.income.grossannual" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Gross_Annual_Income" value=""
							id="grossannual" onchange="fill()" maxlength="14"
							class="numberinput" title="Please fill this field " />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Gross_Annual_Income"
							value="${parentBean.grossAnnualIncome}" id="grossannual"
							onchange="fill()" maxlength="14" class="numberinput"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'enter.gross.income'}">
								<span class="form-error"><fmt:message
										key="house.property.income.grossannual.error" /> </span>
							</c:if>
						</c:forEach>
					</c:if></td>
			</tr>

			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.rent.unrealised" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Unrealised_Rent" value="" id="rent"
							onchange="fill()" class="numberinput" maxlength="14"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Unrealised_Rent"
							value="${parentBean.unrealisedRent}" id="rent" onchange="fill()"
							class="numberinput" maxlength="14"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'enter.unrealised.rent'}">
								<span class="form-error"><fmt:message
										key="house.property.rent.unrealised.error" /> </span>
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>

			<tr height="30px">
				<td class="label"><fmt:message key="house.property.taxes.local" />
				</td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Local_Taxes" value="" id="taxes"
							onchange="fill()" class="numberinput" maxlength="14"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Local_Taxes"
							value="${parentBean.localTaxes}" id="taxes" onchange="fill()"
							class="numberinput" maxlength="14"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'enter.local.taxes'}">
								<span class="form-error"><fmt:message
										key="house.property.taxes.local.error" /> </span>
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>

			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.interest.borrowed" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Interest_Borrowed2" value=""
							id="interest" onchange="fill()" class="numberinput"
							maxlength="14" title="Please fill this field " />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Interest_Borrowed2"
							value="${parentBean.interestBorrowed2}" id="interest"
							onchange="fill()" class="numberinput" maxlength="14"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'enter.interest.borrowed'}">
								<span class="form-error"><fmt:message
										key="house.property.interest.borrowed.error" /> </span>
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>

			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.income.total" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Total_Income" value="" id="total"
							title="Please fill this field" readonly />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Total_Income"
							value="${parentBean.totalIncome}" id="total"
							title="Please fill this field" readonly />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">

						</c:forEach>
					</c:if>
				</td>
			</tr>
		</table>

	</div>
	<%-- This div is for NO form --%>
	<div id="per_diem">
		<table>
			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.interest.borrowed1" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Interest_Borrowed1" value=""
							id="borrowed" onchange="fill1()" class="numberinput"
							maxlength="14" title="Please fill this field " />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Interest_Borrowed1"
							value="${parentBean.interestBorrowed1}" id="borrowed"
							onchange="fill1()" class="numberinput" maxlength="10"
							title="Please fill this field " />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">
							<c:if test="${error eq 'enter.interest.borrowed'}">
								<span class="form-error"><fmt:message
										key="house.property.interest.borrowed.error" /> </span>
							</c:if>
						</c:forEach>
					</c:if>
				</td>
			</tr>
			<tr>
				<td><b style="color: blue">Income from House Property is
						Interest on Borrowed Capital OR 1,50,000 whichever is less...</b>
				</td>
			</tr>
			<tr height="30px">
				<td class="label"><fmt:message
						key="house.property.income.total" /></td>
				<td class="input"><c:if test="${empty parentBean}">
						<input type="text" name="Income_Hproperty" value="" id="income"
							title="Please fill this field " readonly />
					</c:if> <c:if test="${not empty parentBean}">
						<input type="text" name="Income_Hproperty"
							value="${parentBean.incomeHproperty}" id="income"
							title="Please fill this field " readonly />
					</c:if> <c:if test="${not empty errors}">
						<c:forEach items="${errors}" var="error">

						</c:forEach>
					</c:if>
				</td>
			</tr>

		</table>


	</div>
	<input type="submit" name="sunbmou" />

</form>
<%-- Calculation for YES form using jquery --%>
<script>

    
function fill() {

	  var A = parseFloat(document.getElementById("grossannual").value);
	  var B = parseFloat(document.getElementById("rent").value);
	  var C= parseFloat(document.getElementById("taxes").value);
	  var D= parseFloat(document.getElementById("interest").value);
	  if(B==0 && C==0 && A==0 && D==0){

			 
	 }
	  else
	  {
		 
	  var E = B + C;
	  var F = A - E

	  var  H = 0.3 * F;

	  var  J = H + D;
	  var K = F - J;

	  
	
	  document.getElementById("total").value =Math.round(K*100)/100;
	}
		 }
	 
</script>

<%-- Calculation for NO form using jquery --%>
<script>
    
    function fill1() {

        var I = document.getElementById("borrowed").value-0;
       

 if(I<="150000"){
	
	 document.getElementById("income").value= -I;
 }
 else{
	 document.getElementById("income").value = "-1,50,000";
 
 }
    }
</script>

<%-- In this script jquery is used for putting a check on fields that alphabets and special characters excluding dot do not enter --%>
<script>

var jqueryFunction;
$m(document).ready(function () {
    $m('input.numberinput').bind('keypress', function (e) {
        return (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 46) ? false : true;
    });
});

</script>


