<%--
For Mootly ITR Pricing Plans
--%>

<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<c:set var="servicepricetitle">
	<fmt:message key="service.price" />
</c:set>
<hippo-gogreen:seoheader title="${servicepricetitle}" description="Wealth4India offers competitive pricing in eFiling your Income Tax Return anywhere from the world. Calculations are accurate and our experienced staff is always there to help."/>
<c:set var="flatPrice" value="299"/>
<div class="page-header">
	<h1><fmt:message key="service.price.title" /></h1>
</div>





<form>
	<table class="table table-bordered table-hover table-striped">
		<thead class='header'>
			<tr>
				<th width="15%" class=success><fmt:message
						key="service.price.title1" /></th>
				<c:forEach items="${documents}" var="document">
					<c:choose>
						<c:when test="${document.title eq 'DELUXE'}">
							<td class=success />
						</c:when>
						<c:otherwise>
							<td class=success />
						</c:otherwise>
					</c:choose>
					<c:out value="${document.title}" />
				</c:forEach>
			</tr>
		</thead>
			<tr>
				<th width="15%"><fmt:message key="service.price.efilepricing" />
				</th>
				<c:forEach items="${documents}" var="document">
					<td width="15%">
						&#8377; <del><c:out value="${document.efilePricing}" /></del><c:out value="${flatPrice}"/>
					</td>
				</c:forEach>
			</tr>
			<%--
			<tr>
				<th width="15%"><fmt:message key="service.price.ezfilepricing" />
				</th>
				<c:forEach items="${documents}" var="document">
					<td width="15%">&#8377;<c:out value="${document.ezfilePricing}" /></td>
				</c:forEach>
			</tr>
			 --%>
			<tr>
				<th width="15%"><fmt:message key="service.price.description" />
				</th>
				<c:forEach items="${documents}" var="document">
					<td width="5%"><c:out value="${document.description}" /></td>
				</c:forEach>
			</tr>
			<tr>
				<th width="15%"><fmt:message key="service.price.can" /></th>
				<c:forEach items="${documents}" var="document">
					<td width="5%">
						<h5>
							<small> Recommended if you:</small>
						</h5> <fmt:message key="${whoCan[document.title]}" />
					</td>
				</c:forEach>
			</tr>
			<tr>
				<th width="15%"><fmt:message key="service.price.cannot" /></th>
				<c:forEach items="${documents}" var="document">
					<td width="5%"><fmt:message key="${whoCannot[document.title]}" />
					</td>
				</c:forEach>
			</tr>
	</table>
	<div id="income" align="center">
		<h4>
			<fmt:message key="service.price.income" />
		</h4>
	</div>
	<table class="table table-bordered table-hover table-striped"
		width="100%">
		<tr>
			<th width="15%"><fmt:message key="service.price.salary" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.salary eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.othersource" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.otherSourceInterest eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.agriculture" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.otherSourceAgriculture eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.house" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.houseProperty eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.capitalgain" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.capitalGain eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>

		<tr>
			<th width="15%"><fmt:message key="service.price.partnership" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.partnership eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>

		<tr>
			<th width="15%"><fmt:message key="service.price.business1" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.business eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.business2" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.presumtiveBusiness eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.foreign" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.foreignAssests eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.specialrate" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanIncome.rateIncome eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
	</table>
	<div id="income" align="center">
		<h4>
			<fmt:message key="service.price.deductions" />
		</h4>
	</div>
	<table id="deduction " width="100%"
		class="table table-bordered table-hover table-striped">
		<tr>
			<th width="15%"><fmt:message key="service.price.deductions" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanDeductions.deduction eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.relief89" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanDeductions.reliefEightyNine eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.relief9091" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanDeductions.reliefNintyOne eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.losses" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanDeductions.losses eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
	</table>
	<div id="taxes" align="center">
		<h4>
			<fmt:message key="service.price.taxes" />
		</h4>
	</div>
	<table width="100%"
		class="table table-bordered table-hover table-striped">
		<tr>
			<th width="15%"><fmt:message key="service.price.tdssalary" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanTaxes.tdsSalary eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.tdsother" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanTaxes.tdsOther eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.tcs" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanTaxes.tcs eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.advancetax" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanTaxes.advanceTax eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.selftax" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if
						test="${document.pricingPlanTaxes.selfAssessmentTax eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
	</table>
	<table id="e-filing" width="100%"
		class="table table-bordered table-hover table-striped">
		<tr>
			<th width="15%"><fmt:message key="service.price.efiling" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%"><c:if test="${document.efiling eq true}">
						<span class="glyphicon glyphicon-ok"></span>
					</c:if>
				</td>
			</c:forEach>
		</tr>
	</table>
	<div id="additionalservices" align="center">
		<h4>
			<fmt:message key="service.price.additional" />
		</h4>
	</div>
	<table width="100%"
		class="table table-bordered table-hover table-striped">
		<%--
		<tr>
			<th width="15%"><fmt:message key="service.price.taxplanning" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377; <c:out
						value="${document.pricingPlanAdditionalServices.taxPlanning }" />
				</td>
			</c:forEach>
		</tr>
		 --%>
		 <%--
		<tr>
			<th width="15%"><fmt:message key="service.price.expert" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377;<c:out
						value="${document.pricingPlanAdditionalServices.reviewedByExpert}" />
				</td>
			</c:forEach>
		</tr>
		 --%>
		<tr>
			<th width="15%"><fmt:message key="service.price.protection" />
			</th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377;<c:out
						value="${document.pricingPlanAdditionalServices.assessmentProtection}" />
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.itr" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377; <del><c:out
						value="${document.pricingPlanAdditionalServices.itrSubmission }" /></del> FREE
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.refund" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377; <del><c:out
						value="${document.pricingPlanAdditionalServices.refundStatus}" /></del> FREE
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.status" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377; <del><c:out
						value="${document.pricingPlanAdditionalServices.itrRecieptStatus}" /></del> FREE
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.return" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377; <del><c:out
						value="${document.pricingPlanAdditionalServices.returnProcessingStatus}" /></del> FREE
				</td>
			</c:forEach>
		</tr>
		<tr>
			<th width="15%"><fmt:message key="service.price.manager" /></th>
			<c:forEach items="${documents}" var="document">
				<td width="5%">&#8377;<del><c:out
						value="${document.pricingPlanAdditionalServices.documentManager}" /></del> FREE
				</td>
			</c:forEach>
		</tr>
	</table>
</form>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	$(document).ready(function() {
		$('#hrefSubmitbasic').click(function() {			 
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_basic");
		$('#package').val('basic');
			 $('#frmdata').submit();
		});
		$('#hrefSubmitpremier').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_premier");
		$('#package').val('premier');
			 $('#frmdata').submit();
		});
		$('#hrefSubmitassisted').click(function() {
			 $("#partNumber").val("<c:out value="${financialYear.displayName}" />_<c:out
		value="${filingStatus.fourthCharInPAN}" />_assisted");
		$('#package').val('assisted');
			 $('#frmdata').submit();			 
		});
			
	});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
