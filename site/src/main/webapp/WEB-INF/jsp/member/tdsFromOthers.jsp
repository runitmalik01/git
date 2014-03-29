<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="tds2">
	<fmt:message key="tds2" />
</c:set>
<hippo-gogreen:title title="${tds2}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<fmt:message key="member.tds.from.others" var="subTitle" />
	<div class="row show-grid">
		<w4india:itrsidebar></w4india:itrsidebar>
		<div class="${sideBarMainClass}">
			<w4india:titleandnav title="Tax Deducted at Other Source"
				subTitle="Tax deducted at source (TDS) on others, as the very names imply aim at collection of revenue at the very source of income other than Salary. It is essentially an indirect method of collecting tax which combines the concepts of 'pay as you earn, and 'collect as it is being earned'." />
			<c:if test="${not empty formMap}">
				<c:forEach items="${formMap.message}" var="item">
					<div class="alert alert-danger">
						<fmt:message key="${item.value}" />
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${not empty putSameChar}">
				<div class="alert alert-danger">
					<fmt:message key="eneter.validPan.ORvalidName"></fmt:message>
				</div>
			</c:if>
			<c:choose>
				<c:when
					test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
					<form id="frmdataTdsOther" action="${actionUrl}" method="post"
						name="tdsfromothers">
						<div id="error" class="alert alert-danger" style="display: none;">TAN's
							fourth alphabet should be first alphabet of Name of Deductor</div>
						<fieldset>
							<legend class="header-color">
								<small>Enter Details</small>
							</legend>
							<div class="row show-grid">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="tan_deductortdsoth"><small><fmt:message
													key="tds.tan.deductor" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="tan_deductortdsoth" name="tan_deductortdsoth"
											class="uprcase" type="text" onchange="keyup()"
											onblur=" keyup()" maxlength="10"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_Deductor}"/></c:if>" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="name_deductortdsoth"><small><fmt:message
													key="tds.name.deductor" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="name_deductortdsoth" name="name_deductortdsoth"
											type="text" maxlength="125" class="uprcase"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Deductor}"/></c:if>" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="tds_certificatetdsoth"><small><fmt:message
													key="tds.unique.certificate" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="tds_certificatetdsoth" name="tds_certificatetdsoth"
											type="text" maxlength="8" class="uprcase"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tds_Certificate}"/></c:if>" />
									</div>
								</div>
							</div>
							<div class="row show-grid">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="financial_yeartdsoth"><small><fmt:message
													key="tds.financial.year" /> </small> </label>
									</div>
									<div class="rowlabel">
										<select id="financial_yeartdsoth" name="financial_yeartdsoth"
											class="uprcase">
											<option value="">Select</option>
											<option value="${eight}"
												<c:if test="${childBean.financial_Year ==eight}">selected</c:if>>${eight}</option>
											<option value="${nine}"
												<c:if test="${childBean.financial_Year ==nine}">selected</c:if>>${nine}</option>
											<option value="${ten}"
												<c:if test="${childBean.financial_Year ==ten}">selected</c:if>>${ten}</option>
											<option value="${eleven}"
												<c:if test="${childBean.financial_Year ==eleven}">selected</c:if>>${eleven}</option>
											<option value="${twelve}"
												<c:if test="${childBean.financial_Year ==twelve}">selected</c:if>>${twelve}</option>
											<option value="${thirteen}"
												<c:if test="${childBean.financial_Year ==thirteen}">selected</c:if>>${thirteen}</option>
											<option value="${forteen}"
												<c:if test="${childBean.financial_Year ==forteen}">selected</c:if>>${forteen}</option>
											<option value="${fifteen}"
												<c:if test="${childBean.financial_Year ==fifteen}">selected</c:if>>${fifteen}</option>

										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="total_taxdeductedtdsoth"><small><fmt:message
													key="tds.total.tax.deducted" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="total_taxdeductedtdsoth"
											name="total_taxdeductedtdsoth" type="text" maxlength="14"
											onblur="calculate()" onchange="calculate" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.total_TaxDeductor}"/></c:if>" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="amounttdsoth"><small><fmt:message
													key="tds.amount.claimed" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="amounttdsoth" name="amounttdsoth" type="text"
											maxlength="14" readonly class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.p_Amount}"/></c:if>" />
									</div>
								</div>
							</div>
						</fieldset>
						<div class="row show-grid">
							<div class="col-md-4 col-md-offset-8 decimal">
								<a
									href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_TDS_OTHERS%>"
									class="btn btn-default btn-danger">Cancel</a>&nbsp; <a
									id="myModalHrefTdsOther" role="button"
									class="btn btn-default btn-success">Save</a>
							</div>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered">
						<tr align="center">
							<th><b><fmt:message key="tds.tan.deductor" /> </b></th>
							<th><b><fmt:message key="tds.name.deductor" /> </b></th>
							<th><b><fmt:message key="tds.total.tax.deducted" /> </b></th>
							<th><b><fmt:message key="tds.amount.claimed" /> </b></th>
							<th><b>Actions</b></th>
						</tr>
						<c:if test="${not empty parentBean}">
							<c:forEach items="${parentBean.tdsSalaryDetailList}"
								var="tdsfromothersdetail">
								<tr>
									<td><c:out value="${tdsfromothersdetail.tan_Deductor}" /></td>
									<td><c:out value="${tdsfromothersdetail.name_Deductor}" />
									</td>
									<td><w4india:inr
											value="${tdsfromothersdetail.total_TaxDeductor}" /></td>
									<td><w4india:inr value="${tdsfromothersdetail.p_Amount}" />
									</td>
									<td><a class="btn btn-default btn-primary"
										href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersedit"><small><i
												class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>&nbsp;&nbsp;
									</a>&nbsp;<a class="btn btn-default btn-danger"
										href="${scriptName}/<c:out value="${tdsfromothersdetail.canonicalUUID}"/>/tdsfromothersdelete"
										id="delete" data-confirm=""><small><i
												class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
									</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="3"><fmt:message key="tds.amount.total" /></td>
								<td><w4india:inr value="${parentBean.total_Amount}" /></td>
							</tr>
						</c:if>
					</table>
					<a href="${scriptName}/tdsfromothersnew"
						class="btn btn-default btn-info"><small><i
							class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>

					<c:if
						test="${not empty is26ASImportEnabled && is26ASImportEnabled == true}">
						<a href="servicerequest-itr-sync-tds-from-dit.html"
							class="btn btn-default btn-success"><small><i
								class="glyphicon glyphicon-import"></i>Import 26AS</small></a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<script type="text/javascript">
	function calculate() {
		var amt = document.getElementById("total_taxdeductedtdsoth").value;
		document.getElementById("amounttdsoth").value = amt;
	}
</script>


<res:client-validation formId="frmdataTdsOther"
	screenConfigurationDocumentName="tdsfromothers"
	formSubmitButtonId="myModalHrefTdsOther"
	fieldOneID="tan_deductortdsoth" fieldTwoID="name_deductortdsoth"
	validationType="tan" />
