<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="balancesheet"></hst:link>
<hippo-gogreen:title title="Schedule-BP" />
<w4india:itrmenu />
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<h4>
	<b><c:out value="${screenConfigDocument.screenHeading}"/></b>
</h4>
<c:if test="${not empty screenConfigDocument.screenSubHeading}">
	<div class="alert alert-info">
		<c:out value="${screenConfigDocument.screenSubHeading}"/>
	</div>
</c:if>
<form name="schedBusinessProfess" id="schedBusinessProfess" action="${actionUrl}" method="post">
	<h5 align="center">Presumptive Income</h5>
	<fieldset>
		<legend>Presumptive Income under 44AD</legend>
		<div class="span3">
			<div class="rowlabel">
				<label for="reavReserve"> <small>GrossIncome or GrossTurnOver Receipts</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="reavReserve" name="reavReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.reavReserve }" />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="capReserve"> <small>Total Presumptive Income u|s 44AD</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="capReserve" name="capReserve" type="text" maxlength="14"
					class="decimal" value="${parentBean.capReserve }" />
			</div>
		</div>	
	</fieldset>	
		<fieldset>
		<legend>Presumptive Income under 44AE</legend>
		<div class="span3">
			<div class="rowlabel">
				<label for="reavReserve"> <small>Presumptive Income from Heavy Vehicles</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="reavReserve" name="reavReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.reavReserve }" />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="capReserve"> <small>Presumptive Income from Other Vehicles</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="capReserve" name="capReserve" type="text" maxlength="14"
					class="decimal" value="${parentBean.capReserve }" />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="statReserve"> <small>Gross Presumptive Income u|s 44AE </small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="statReserve" name="statReserve" type="text"
					maxlength="14" class="decimal" value="${parentBean.statReserve }" readonly="readonly" />
			</div>
		</div>		
	</fieldset>
	<div class="well">
		<div class="row -fluid show-grid">
			<div class="span3">
				<div class="rowlabel">
					<label for="statReserve"> <small>Gross Business Profession Income</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="statReserve" name="statReserve" type="text"
						maxlength="14" class="decimal" value="${parentBean.statReserve }"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span4 offset8 decimal">
			<!--<a href="${scriptName}"
				class="btn btn-danger" style="color: black">Cancel</a>&nbsp;  --> <a
				id="myModalScheduleBalSheet" role="button" class="btn btn-success"
				style="color: black">Save</a>
		</div>
	</div>
</form>


<res:client-validation screenConfigurationDocumentName="balancesheet" formId="schedBalanceSheet" formSubmitButtonId="myModalScheduleBalSheet"></res:client-validation>


