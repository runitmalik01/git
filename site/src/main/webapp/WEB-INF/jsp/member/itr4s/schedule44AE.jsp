<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>

<c:set var="businessincome">
<fmt:message key="name.schedule44AE.title" />
</c:set>
<hippo-gogreen:title title="${businessincome}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid"> 
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<hst:link var="mainSiteMapRefId" />		
		<w4india:titleandnav title="Presumptive Income" subTitle="Business Income sources includes any trade, commerce,
				manufacture or any adventure or concern in the nature of trade,
				commerce or manufacture.It includes any activity carried out by
				person with a motive to earn profit out of it."/>	
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmSch44AE" action="${actionUrl}" method="post"
				name="frmSch44AE">

				<fieldset>
					<legend class="header-color">
						<small><fmt:message key="name.schedule44AE.itr4s" /></small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="type_Vehicle"><small><fmt:message
											key="sch441e.type.Vehicle.itr4s" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="type_Vehicle" name="type_Vehicle">
									<option value="">-Select-</option>
									<option value="Light"
										<c:if test="${not empty childBean.type_Vehicle && childBean.type_Vehicle =='Light'}">selected</c:if>>Light</option>
									<option value="Heavy"
										<c:if test="${not empty childBean.type_Vehicle && childBean.type_Vehicle =='Heavy'}">selected</c:if>>Heavy</option>
								</select>
							</div>
						</div>

						<div class="col-md-4">
							<div class="rowlabel">
								<label for="hold_Period"><small><fmt:message
											key="sch441e.hold.Period.itr4" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="hold_Period" name="hold_Period" type="text"
									maxlength="2"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.hold_Period}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-4">
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
					<div class="row show-grid">

						<div class="col-md-4">
							<div class="rowlabel">
								<label for="deemedIncome_Heavy"><small><fmt:message
											key="sch44ae.deemed.Income.heavy.itr4s" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="deemedIncome_Heavy" name="deemedIncome_Heavy"
									readonly="readonly" type="text" maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deemedIncome_Heavy}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="deemedIncome_Light"><small><fmt:message
											key="sch44ae.deemed.Income.light.itr4s" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="deemedIncome_Light" name="deemedIncome_Light"
									readonly="readonly" type="text" maxlength="14" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.deemedIncome_Light}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalSchdule44AE" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="sch441e.type.Vehicle.itr4s" /> </b>
					</th>
					<th><b><fmt:message
								key="sch44ae.deemed.Income.heavy.itr4s" /> </b></th>
					<th><b><fmt:message
								key="sch44ae.deemed.Income.light.itr4s" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.schFourtyFourDetailList}"
						var="scheduleFourtyFour">
						<tr>
							<td><c:out value="${scheduleFourtyFour.type_Vehicle}" /></td>
							<td><c:out value="${scheduleFourtyFour.deemedIncome_Heavy}" />
							</td>
							<td><w4india:inr
									value="${scheduleFourtyFour.deemedIncome_Light}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${scheduleFourtyFour.canonicalUUID}"/>/schedulefourtyfourAEedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>&nbsp;&nbsp;
							</a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${scheduleFourtyFour.canonicalUUID}"/>/schedulefourtyfourAEdelete"
								id="delete" data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="1">Total</td>
						<td><w4india:inr
								value="${parentBean.total_deemedIncome_Heavy}" /></td>

						<td><w4india:inr
								value="${parentBean.total_deemedIncome_Light}" /></td>
					</tr>
				</c:if>
			</table>
			<a href="${scriptName}/schedulefourtyfourAEnew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<script type="text/javascript">
	$('#hold_Period').change(function() {
		var no_Months = $('#hold_Period').val();
		if (no_Months > 12) {
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
	function getCheck_IncomeVehicle() {
		var type_Vehicle = $('#type_Vehicle').val();
		var income_Vehicle = $('#income_PerVehicle').val();
		if (type_Vehicle == "Light") {
			if ((income_Vehicle < 4500) && (income_Vehicle != "")) {
				alert("For Light vehicle Please enter amount more than 4500");
				$('#income_PerVehicle').val("");
			}
		} else {
			if (type_Vehicle == "Heavy") {
				if ((income_Vehicle < 5000) && (income_Vehicle != "")) {
					alert("For Heavy vehicle Please enter amount more than 5000");
					$('#income_PerVehicle').val("");
				}

			}
		}
	}
</script>


<res:calc screenCalc="schedulefourtyfourae" formId="frmSch44AE"></res:calc>
<res:client-validation formId="frmSch44AE"
	screenConfigurationDocumentName="schfourtyfourae"
	formSubmitButtonId="myModalSchdule44AE" />
