<%@include file="../includes/commonincludes.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<hst:link var="mainSiteMapRefId"
	siteMapItemRefId="${mainSiteMapItemRefId}" />
<%
	String varToReplace = (String) pageContext
			.getAttribute("mainSiteMapRefId");
	if (varToReplace != null) {
		String pan = (String) request.getAttribute("pan");
		String modifiedSiteMapRefId = varToReplace.replaceAll(
				"_default_", pan);
		pageContext.setAttribute("modifiedSiteMapRefId",
				modifiedSiteMapRefId);
	} else {
		pageContext.setAttribute("modifiedSiteMapRefId",
				mainSiteMapRefId);
	}
%>

<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	TreeMap objHashMapBoolean = (TreeMap) objValueListService
			.getBoolean();
	request.setAttribute("objHashMapBoolean", objHashMapBoolean);
%>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		// binds form submission and fields to the validation engine
		jQuery("#frmhp").validationEngine();
	});
</script>
<c:set var="parentBeantitle">
	<fmt:message key="member.houseincome.title" />
</c:set>
<hippo-gogreen:title title="${parentBeantitle}" />


<hst:actionURL var="actionUrl" />
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">



		<%-- Script is written for show and hide --%>
		<script type="text/javascript">
var $m=jQuery.noConflict(true);
</script>

		<script type="text/javascript">
hideAllDivs = function () {
    $m("#hourly").hide();
    $m("#per_diem").hide();
    $m("#button").show();
};

handleNewSelection = function () {

    hideAllDivs();
    
    switch ($m(this).val()) {
        case '1':
            $m("#hourly").show();
            $m("#button").show();
        break;
        case '2':
            $m("#per_diem").show();
            $m("#button").show();
        break;
    }
};

$m(document).ready(function() {
    
    $m("#project_billing_code_id").change(handleNewSelection);
    
    // Run the event handler once now to ensure everything is as it should be
    handleNewSelection.apply($m("#project_billing_code_id"));
    var fdp=$m("#fdp").val();
    var pageaction= '<%=request.getAttribute("pageAction")%>';
    if(pageaction.match("EDIT_CHILD")){
    if(fdp!=null){
    $m("#project_billing_code_id").val(fdp);
         if(fdp=='1'){
    	       $m('#hourly').show();
    	       document.getElementById('project_billing_code_id').setAttribute("disabled", "disabled");
          }else{
              $m('#per_diem').show();
              document.getElementById('project_billing_code_id').setAttribute("disabled", "disabled");
               }
    }
    }
	});
	

</script>


		<%-- Code for Dropdown --%>
		<form id="frmhp" name="frmhp" action="${actionUrl}" method="POST"
			class="formular">

			<h2 style="color: blue">Whether your House Property let out:</h2>
			<select id="project_billing_code_id" name="Let_Out">
				<option value="">Select One</option>
				<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
					<option value="${booleanCombo.key}">${booleanCombo.value}</option>
				</c:forEach>
			</select> <input type="hidden" name="fdp"
				value="<c:if test="${pageAction == 'EDIT_CHILD'}">${childBean.letOut}</c:if>"
				id="fdp" />

			<%-- This div is for yes form --%>
			<div id="hourly">

				<table>
					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.income.grossannual" />
						</td>
						<td class="input"><input type="text"
							name="Gross_Annual_Income" name="Gross_salary" 
							title="Please fill numeric value " id="grossannual" class="validate[required,custom[integer],maxSize[14]] text-input"
							onchange="fill()" id=A
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.grossAnnualIncome}"/></c:if>" />
						</td>
					</tr>

					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.rent.unrealised" />
						</td>
						<td class="input"><input type="text" name="Unrealised_Rent" 
							 title="Please fill numeric value " id="rent" class="validate[required,custom[integer],maxSize[14]] text-input"
							onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.unrealisedRent}"/></c:if>" />
						</td>
					</tr>


					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.taxes.local" /></td>
						<td class="input"><input type="text" name="Local_Taxes" class="validate[required,custom[integer],maxSize[14]] text-input"
							 title="Please fill numeric value " id="taxes" 
							onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.localTaxes}"/></c:if>" />
						</td>
					</tr>

					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.interest.borrowed" />
						</td>
						<td class="input"><input type="text"
							name="Interest_Borrowed2" 
							title="Please fill numeric value " id="interest" class="validate[required,custom[integer],maxSize[14]] text-input"
							onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.interestBorrowed2}"/></c:if>" />
						</td>
					</tr>


					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.income.total" />
						</td>
						<td class="input"><input type="text" name="Total_Income"
							readonly="readonly" id="total" onchange="fill()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.totalIncome}"/></c:if>" />

						</td>
					</tr>
				</table>

			</div>
			<%-- This div is for NO form --%>
			<div id="per_diem">
				<table>
					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.interest.borrowed1" />
						</td>
						<td class="input"><input type="text"
							name="Interest_Borrowed1" 
							title="Please fill numeric value " id="borrowed" class="validate[required,custom[integer],maxSize[14]] text-input"
							onchange="fill1()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.interestBorrowed1}"/></c:if>" />
						</td>
					</tr>

					<tr>
						<td><b style="color: blue">Income from House Property is
								Interest on Borrowed Capital OR 1,50,000 whichever is less...</b></td>
					</tr>
					<tr height="30px">
						<td class="label"><fmt:message
								key="house.property.income.total" />
						</td>
						<td class="input"><input type="text" name="Income_Hproperty"
							readonly="readonly" id="income" onchange="fill1()"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.incomeHproperty}"/></c:if>" />
						</td>
					</tr>


				</table>



			</div>
			<a href="${modifiedSiteMapRefId}" class="button olive">Cancel</a>&nbsp;
			<input type="submit" id="submit" class="button olive"
				onclick="save()" value="Save" />

		</form>

	</c:when>
	<c:otherwise>


		<table>
			<tr align="center">
				<th><b>Whether your House Property let out</b>
				</th>
				<th><b>Income from House Property</b>
				</th>
				<th><b>Actions</b>
				</th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.houseIncomeDetailList}"
					var="houseincomedetail">
					<tr>
						<td><a
							href="${redirectURLToSamePage}/<c:out value="${houseincomedetail.canonicalUUID}"/>/edit"><c:choose>
									<c:when test="${houseincomedetail.letOut == '1'}">
										<c:out value="Yes" />
									</c:when>
									<c:otherwise>
										<c:out value="No" />
									</c:otherwise>
								</c:choose>
						</a>
						</td>
						<td><c:choose>
								<c:when test="${not empty houseincomedetail.incomeHproperty}">
									<c:out value="${houseincomedetail.incomeHproperty}" />
								</c:when>
								<c:otherwise>
									<c:out value="${houseincomedetail.totalIncome}" />
								</c:otherwise>
							</c:choose>
						</td>
						<td><a
							href="${redirectURLToSamePage}/<c:out value="${houseincomedetail.canonicalUUID}"/>/edit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a
							href="${redirectURLToSamePage}/<c:out value="${houseincomedetail.canonicalUUID}"/>/delete"><small>Delete</small>
						</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>

		<a href="${redirectURLToSamePage}/new" class="button orange">Add
			New</a>
	</c:otherwise>
</c:choose>

<%-- Calculation for YES form using jquery --%>
<script type="text/javascript">

    
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


