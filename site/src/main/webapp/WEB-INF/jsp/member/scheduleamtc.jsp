<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="itr-schedule-amtc"></hst:link>
<hippo-gogreen:title title="Schedule-AMTC" />
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
	<b>ITR- Schedule AMTC(Alternative Minimum Tax Credit)</b>
</h4>
<c:if test="${not empty exceedErrorGrossTurnOver}">
	<div class="alert alert-error">
		<strong><fmt:message key="busi.prof.exceed.grosturnover.itr4" /></strong><a
			href="./servicerequest-itr.html" class="btn btn-warning">Change
			Package</a>
	</div>
</c:if>
<form name="scheduleAMTC" id="scheduleAMTC" action="${actionUrl}"
	method="post">
	<fieldset>
		<legend style="color: green; font-weight: bold;">Computation of Tax U|S 115JC</legend>
		<div class="row-fluid show-grid">
			<div class="span8">
				<div class="rowlabel">
					<label for="taxUndSec115JC"><small>Tax U|S 115JC in
							Assessment Yr ${assessmentYear}</small> </label>
				</div></div>
				<div class="span4">
				<div class="rowlabel">
					<input id="taxUndSec115JC" name="taxUndSec115JC" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.taxUndSec115JC }" readonly="readonly" />
				</div>
			</div></div>
			<div class="row-fluid show-grid">
			<div class="span8">
				<div class="rowlabel">
					<label for="taxUnderOtherProv"><small>Tax under
							Other Provision in Assessment Yr <c:out value="${assessmentYear}" />
					</small> </label>
				</div></div>
				<div class="span4">
				<div class="rowlabel">
					<input id="taxUnderOtherProv" name="taxUnderOtherProv" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.taxUnderOtherProv}" readonly="readonly" />
				</div>
			</div>
			</div>
			<div class="row-fluid show-grid">
			<div class="span8">
				<div class="rowlabel">
					<label for="taxAgainstCredit"><small>Amount of Tax
							Against which Credit Available</small> </label>
				</div></div>
				<div class="span4">
				<div class="rowlabel">
					<input id="taxAgainstCredit" name="taxAgainstCredit" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.taxAgainstCredit}"
						readonly="readonly" />
				</div>
			</div>
		</div>
	
	<fieldset>
		<legend style="color: green; font-weight: bold;">Utilisation of AMT credit available for Assessment
			Year ${assessmentYear}</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="amtCreditGross"> <small>AMT Credit
							Gross</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="amtCreditGross" name="amtCreditGross" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.amtCreditGross}" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="amtCreditSetOff"> <small>AMT Credit Set
							Off In earlier Year</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="amtCreditSetOff" name="amtCreditSetOff" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.amtCreditSetOff}"
						readonly="readonly" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="amtCreditBrghtFwrd"> <small>AMT Credit
							Brought Forward</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="amtCreditBrghtFwrd" name="amtCreditBrghtFwrd"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.amtCreditBrghtFwrd}"
						readonly="readonly" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="amtCreditUnlisted"> <small>AMT Credit
							Unlisted in Current year</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="amtCreditUnlisted" name="amtCreditUnlisted" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.amtCreditUnlisted}"
						readonly="readonly" />
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="amtCreditCarriedFwrd"> <small>Balance
							AMT Credit Carried Forward</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="amtCreditCarriedFwrd" name="amtCreditCarriedFwrd"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.amtCreditCarriedFwrd}"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
	<div class="row-fluid show-grid">
		<div class="span4">
			<div class="rowlabel">
				<label for="unlistCreditUndSec115JD"><small>Tax
						Credit Amount U|S 115JC unlisted during year</small> </label>
			</div>
			<div class="rowlabel">
				<input id="unlistCreditUndSec115JD" name="unlistCreditUndSec115JD"
					type="text" maxlength="14" class="decimal"
					value="${parentBean.unlistCreditUndSec115JD}" readonly="readonly" />
			</div>
		</div>
		<div class="span5">
			<div class="rowlabel">
				<label for="liabAvailCredit"> <small>AMT liability
						Available for Credit in Assessment year</small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="liabAvailCredit" name="liabAvailCredit" type="text"
					maxlength="14" class="decimal"
					value="${parentBean.liabAvailCredit}" readonly="readonly" />
			</div>
		</div>
	</div>
	</fieldset>
	<div class="row-fluid show-grid">
		<div class="span4 offset8 decimal">
			<!--<a href="${scriptName}"
				class="btn btn-danger" style="color: black">Cancel</a>&nbsp;  -->
			<a id="myModalscheduleAMTC" role="button" class="btn btn-success"
				style="color: black">Save</a>
		</div>
	</div>
</form>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
        	$(document).ready( function() {
        	  $('#myModalscheduleAMTC').on('click',function(){
        	    $('#scheduleAMTC').submit();
        	  });
        	});
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />

<res:calc screenCalc="itrscheduleamtc" formId="scheduleAMTC"></res:calc>
