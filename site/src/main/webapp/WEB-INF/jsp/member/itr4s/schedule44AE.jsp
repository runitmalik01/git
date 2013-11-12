<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="44AE">
	<fmt:message key="44AE" />
</c:set>

<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />

<h4>
	<fmt:message key="name.schedule44AE.itr4s" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmSch44AE" action="${actionUrl}" method="post"
			name="frmSch44AE">
			
		<fieldset>
			<legend style="color: green; font-weight: bold;">Enter Details</legend>
			<div class="row-fluid show-grid">
			<div class="span4">
					<div class="rowlabel">
						<label for="type_Vehicle"><small><fmt:message
									key="sch441e.type.Vehicle.itr4s" /> </small> </label>
					</div>
					<div class="rowlabel">
					<select id="type_Vehicle" name="type_Vehicle">
								<option value="">-Select-</option>
								<option value="Light"<c:if test="${not empty childBean.type_Vehicle && childBean.type_Vehicle =='Light'}">selected</c:if>>Light</option>
								<option value="Heavy"<c:if test="${not empty childBean.type_Vehicle && childBean.type_Vehicle =='Heavy'}">selected</c:if>>Heavy</option>
								</select>
						</div>
				</div>
			
				<div class="span4">
					<div class="rowlabel">
						<label for="hold_Period"><small><fmt:message
									key="sch441e.hold.Period.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="hold_Period" name="hold_Period"
							type="text"  maxlength="2"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.hold_Period}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="income_PerVehicle"><small><fmt:message
									key="sch44ae.income.PerVehicle.itr4s" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="income_PerVehicle" name="income_PerVehicle"
							type="text" maxlength="125" class="uprcase"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_PerVehicle}"/></c:if>" />
					</div>
				</div>
				
			</div>
			<div class="row-fluid show-grid">
			
				<div class="span4">
					<div class="rowlabel">
						<label for="deemedIncome_Heavy"><small><fmt:message
									key="sch44ae.deemed.Income.heavy.itr4s" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="deemedIncome_Heavy" name="deemedIncome_Heavy" readonly="readonly"
							type="text" maxlength="14"
							 class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deemedIncome_Heavy}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="deemedIncome_Light"><small><fmt:message
									key="sch44ae.deemed.Income.light.itr4s" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="deemedIncome_Light" name="deemedIncome_Light" readonly="readonly"
							type="text" maxlength="14"
							 class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deemedIncome_Light}"/></c:if>" />
					</div>
				</div>
			</div></fieldset>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
					<a id="myModalSchdule44AE" role="button" class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>
		</form>
	</c:when>
	<c:otherwise>
		<table class="table table-bordered">
			<tr align="center">
				<th><b><fmt:message key="sch441e.type.Vehicle.itr4s" /> </b>
				</th>
				<th><b><fmt:message key="sch44ae.deemed.Income.heavy.itr4s" /> </b>
				</th>
				<th><b><fmt:message key="sch44ae.deemed.Income.light.itr4s" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.schFourtyFourDetailList}"
					var="scheduleFourtyFour">
					<tr>
						<td><c:out value="${scheduleFourtyFour.type_Vehicle}" />
						</td>
						<td><c:out value="${scheduleFourtyFour.deemedIncome_Heavy}" />
						</td>
						<td><w4india:inr value="${scheduleFourtyFour.deemedIncome_Light}" />
						</td>
						<td><a class="btn btn-primary" href="${scriptName}/<c:out value="${scheduleFourtyFour.canonicalUUID}"/>/schedulefourtyfourAEedit"><small><i class="icon-pencil icon-white"></i>Edit</small>&nbsp;&nbsp;
						</a>&nbsp;<a class="btn btn-danger" href="${scriptName}/<c:out value="${scheduleFourtyFour.canonicalUUID}"/>/schedulefourtyfourAEdelete" id="delete" data-confirm=""><small><i class="icon-trash icon-white"></i>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="1">Total</td>
					<td><w4india:inr value="${parentBean.total_deemedIncome_Heavy}" /></td>
					
					<td><w4india:inr value="${parentBean.total_deemedIncome_Light}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/schedulefourtyfourAEnew"
			class="btn btn-info" style="color: black">Add New</a>
	</c:otherwise>
</c:choose>
</div>
<script type="text/javascript">
$('#hold_Period').change(function(){
	var no_Months = $('#hold_Period').val();
	if(no_Months > 12){
		alert("Holding period can not be greater than 12 months");
		$('#hold_Period').val("");
	}
});
// The following code is for check in case of heavy and light vehicles.
		 $('#income_PerVehicle').change(function() {
			 getCheck_IncomeVehicle();
		 });
		 $('#type_Vehicle').change(function() {
			 getCheck_IncomeVehicle();
		 });
	function getCheck_IncomeVehicle(){
		 var type_Vehicle = $('#type_Vehicle').val();
			var income_Vehicle = $('#income_PerVehicle').val();
			if(type_Vehicle == "Light"){
			if((income_Vehicle < 4500) && (income_Vehicle != "")){
				alert("For Light vehicle Please enter amount more than 4500");
				$('#income_PerVehicle').val("");
			} 
			}else {
				if(type_Vehicle == "Heavy"){
					if((income_Vehicle < 5000) && (income_Vehicle != "")){
						alert("For Heavy vehicle Please enter amount more than 5000");
						$('#income_PerVehicle').val("");
				}
			
			}}
	}
	
	




</script>


<res:calc screenCalc="schedulefourtyfourae" formId="frmSch44AE"></res:calc>
<res:client-validation formId="frmSch44AE"
	screenConfigurationDocumentName="schfourtyfourae"
	formSubmitButtonId="myModalSchdule44AE" />
