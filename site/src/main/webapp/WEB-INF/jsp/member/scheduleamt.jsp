<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="itr-schedule-amt"></hst:link>
<hippo-gogreen:title title="Schedule AMT" />
<w4india:itrmenu />
<hst:actionURL var="actionUrl"></hst:actionURL>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-danger">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<w4india:titleandnav title="Schedule AMT" subTitle="Schedule AMT(Alternative Minimum Tax)"/>
<c:if test="${not empty exceedErrorGrossTurnOver}">
	<div class="alert alert-danger">
		<strong><fmt:message key="busi.prof.exceed.grosturnover.itr4" /></strong><a
			href="./servicerequest-itr.html" class="btn btn-default btn-warning">Change
			Package</a>
	</div>
</c:if>
<form name="scheduleAMT" id="scheduleAMT" action="${actionUrl}"
	method="post">
	<fieldset>
		<legend class="header-color"><small>Computation
			of AMT U/S 115JC</small></legend>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="totalIncomeItem13"><small>Total income
							as Per item13</small> </label>
				</div>
				<div class="rowlabel">
					<input id="totalIncomeItem13" name="totalIncomeItem13" type="text"
						maxlength="14" class="decimal" value="${partBTIitem13}"
						readonly="readonly" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="dedClaimChapSix"> <small>Deduction
							claim Under Chapter IV-A</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="dedClaimChapSix" name="dedClaimChapSix" type="text"
						maxlength="14" class="decimal" value="${dedUnderChapSix}"
						readonly="readonly" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="dedClaimTenAA"> <small>Deduction
							claimed U/S 10AA</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="dedClaimTenAA" name="dedClaimTenAA" type="text"
						maxlength="14" class="decimal" value="${dedSecTanAA}"
						readonly="readonly" />
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="totalAdjustment"> <small>Total
							Adjustment</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="totalAdjustment" name="totalAdjustment" type="text"
						maxlength="14" class="decimal"
						value="${dedSecTanAA + dedUnderChapSix}" readonly="readonly" />
				</div>
			</div>

			<div class="col-md-4">
				<div class="rowlabel">
					<label for="incUndSec115JC"> <small>Total Income
							Adjusted U/S 115JC</small>
					</label>
				</div>
				<div class="rowlabel">
					<input id="incUndSec115JC" name="incUndSec115JC" type="text"
						maxlength="14" class="decimal"
						value="${dedSecTanAA + dedUnderChapSix + partBTIitem13}"
						readonly="readonly" />
				</div>
			</div>
			<div class="col-md-4">
				<div class="rowlabel">
					<label for="taxPayUndSec115JC"><small>Tax Payable
							U/S 115JC</small> </label>
				</div>
				<div class="rowlabel">
					<c:if
						test="${(dedSecTanAA + dedUnderChapSix + partBTIitem13) > 2000000}">
						<c:set
							value="${(dedSecTanAA + dedUnderChapSix + partBTIitem13)*0.185}"
							var="taxPayUndSec115JC" />
					</c:if>
					<input id="taxPayUndSec115JC" name="taxPayUndSec115JC" type="text"
						maxlength="14" class="decimal"
						value="<fmt:formatNumber value="${taxPayUndSec115JC}" maxFractionDigits="2" type="CURRENCY"></fmt:formatNumber>"
						readonly="readonly" />
				</div>
			</div>
		</div>
	</fieldset>
</form>


