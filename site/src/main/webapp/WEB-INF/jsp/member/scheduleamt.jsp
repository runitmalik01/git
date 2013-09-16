<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="itr-schedule-amt"></hst:link>
<hippo-gogreen:title title="Schedule-AMT" />
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
	<b>ITR- Schedule AMT(Alternative Minimum Tax)</b>
</h4>
<c:if test="${not empty exceedErrorGrossTurnOver}">
	<div class="alert alert-error">
		<strong><fmt:message key="busi.prof.exceed.grosturnover.itr4" /></strong><a
			href="./servicerequest-itr.html" class="btn btn-warning">Change Package</a>
	</div>
</c:if>
<form name="scheduleAMT" id="scheduleAMT" action="${actionUrl}" method="post">
	<fieldset>
		<legend>Computation of AMT U|S 115JC</legend>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="totalIncomeItem13"><small>Total income as Per item13</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalIncomeItem13" name="totalIncomeItem13" type="text"
						maxlength="14" class="decimal" value="${parentBean.totalIncomeItem13 }" readonly="readonly"/>
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="dedClaimChapSix"> <small>Deduction claim Under Chapter IV-A</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="dedClaimChapSix" name="dedClaimChapSix"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.dedClaimChapSix}" readonly="readonly"/>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="dedClaimTenAA"> <small>Deduction claimed U|S 10AA</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="dedClaimTenAA" name="dedClaimTenAA" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.dedClaimTenAA}" readonly="readonly"/>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="totalAdjustment"> <small>Total Adjustment</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalAdjustment" name="totalAdjustment" type="text"
						maxlength="14" class="decimal"
						value="${parentBean.dedClaimTenAA + parentBean.dedClaimChapSix}" readonly="readonly" />
				</div>
			</div>
		</div>
		<div class="row-fluid show-grid">
			<div class="span4">
				<div class="rowlabel">
					<label for="incUndSec115JC"> <small>Total Income Adjusted U|S 115JC</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="incUndSec115JC" name="incUndSec115JC"
						type="text" maxlength="14" class="decimal"
						value="${parentBean.incUndSec115JC}" readonly="readonly"/>
				</div>
			</div>
			<div class="span4">
				<div class="rowlabel">
					<label for="taxPayUndSec115JC"><small>Tax Payable U|S 115JC</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="taxPayUndSec115JC" name="taxPayUndSec115JC" type="text"
						maxlength="14" class="decimal" value="${parentBean.taxPayUndSec115JC}"
						readonly="readonly"/>
				</div>
			</div>
		</div>
	</fieldset>
</form>


