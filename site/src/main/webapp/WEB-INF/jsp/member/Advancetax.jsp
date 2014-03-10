<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="advancetaxtitle">
	<fmt:message key="adv.tax.title" />
</c:set>
<hippo-gogreen:title title="${advancetaxtitle}" />
<w4india:itrmenu></w4india:itrmenu>
<div class="row show-grid">
		<w4india:itrsidebar></w4india:itrsidebar>
		<div class="${sideBarMainClass}">
			<hst:link var="mainSiteMapRefId" />
			<w4india:titleandnav title="Advance Tax" subTitle="Schedule IT&nbsp;- &nbsp;Advance tax is payment of tax
						liability by a person before the end of financial year and it is
						payable only when an assessee’s total tax liability is exceeding
						&#8377;10,000."></w4india:titleandnav>
			<c:if test="${not empty formMap}">
				<c:forEach items="${formMap.message}" var="item">
					<div class="alert alert-danger">
						<fmt:message key="${item.value}" />
					</div>
				</c:forEach>
			</c:if>
			<hst:actionURL var="actionUrl" />
			<div>
				<c:if test="${not empty errors}">
					<c:forEach items="${errors}" var="error">
						<c:if test="${error eq 'invalid.date.period'} ">
							<span class="form-error"><fmt:message
									key="member.personal_info.pan.error2" /> </span>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<c:choose>
				<c:when
					test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
					<form id="frmdataAdvTax" action="${actionUrl}" method="post"
						name="advancetax">
			
						<fieldset>
							<legend class="header-color">
								<small>Enter Details</small>
							</legend>
							<div class="row show-grid">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="bsr_codeadv"><abbr
											title=" Basic Statistical Return Code"><fmt:message
													key="tds.bsr.code" /> </abbr> </label>
									</div>
									<div class="rowlabel">
										<input id="bsr_codeadv" name="bsr_codeadv" type="text"
											maxlength="7"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="date_creditadv"><small><fmt:message
													key="tds.date.credit" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="date_creditadv" name="date_creditadv" type="text"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>" />
									</div>
								</div>
							</div>
							<div class="row show-grid" id="ul_revised_input">
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="Serial_challanadv"><small><fmt:message
													key="tds.serial.challan" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="Serial_challanadv" name="Serial_challanadv"
											type="text" maxlength="5"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>" />
									</div>
								</div>
								<div class="col-md-4">
									<div class="rowlabel">
										<label for="amountadv"><small><fmt:message
													key="tds.amount.selfassesment" /> </small> </label>
									</div>
									<div class="rowlabel">
										<input id="amountadv" name="amountadv" type="text" maxlength="14"
											class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.p_Amount}"/></c:if>" />
									</div>
								</div>
							</div>
						</fieldset>
						<div class="row show-grid">
							<div class="col-md-4 col-md-offset-8 decimal">
								<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_ADVANCE%>"
									class="btn btn-default btn-danger">Cancel</a>&nbsp; <a
									id="myModalHrefAdvTax" role="button"
									class="btn btn-default btn-success">Save</a>
							</div>
						</div>
			
			
					</form>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered">
						<tr align="center">
							<th><b><fmt:message key="tds.bsr.code" /> </b></th>
							<th><b><fmt:message key="tds.date.credit" /> </b></th>
							<th><b><fmt:message key="tds.serial.challan" /> </b></th>
							<th><b><fmt:message key="tds.amount.selfassesment" /> </b></th>
							<th><b>Actions</b></th>
						</tr>
						<c:if test="${not empty parentBean}">
							<c:forEach items="${parentBean.advanceTaxDetailList}"
								var="advancetaxdetail">
								<tr>
									<td><c:out value="${advancetaxdetail.p_BSR}" /></td>
									<td><c:out value="${advancetaxdetail.dateStr}" /></td>
									<td><c:out value="${advancetaxdetail.p_Serial}" /></td>
									<td><w4india:inr value="${advancetaxdetail.p_Amount}" /></td>
									<td><a class="btn btn-default btn-primary"
										href="${scriptName}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/advancetaxedit"><small><i
												class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									</a>&nbsp;&nbsp; <a class="btn btn-default btn-danger"
										href="${scriptName}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/advancetaxdelete"
										data-confirm=""><small><i
												class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
									</a></td>
								</tr>
			
							</c:forEach>
							<tr>
								<td colspan="3"><fmt:message key="tds.amount.total" /></td>
								<td><w4india:inr value="${parentBean.total_Amount}" /></td>
						</c:if>
			
					</table>
					<a href="${scriptName}/advancetaxnew" class="btn btn-default btn-info"><small><i
							class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
							
					<c:if test = "${not empty is26ASImportEnabled && is26ASImportEnabled == true}">
					<a href="servicerequest-itr-sync-tds-from-dit.html" class="btn btn-default btn-success"><small><i
							class="glyphicon glyphicon-import"></i>Import 26AS</small></a>
					</c:if>			
			
					<!--
					<table>
						<tr align="center">
							<th><b>Date of Installment</b>
							</th>
							<th><b>Upto 01/04 To 15/6</b>
							</th>
							<th><b>Upto 16/6 To 15/9</b>
							</th>
							<th><b>Upto 16/9 To 15/12</b>
							</th>
							<th><b>Upto 16/12 To 15/03</b>
							</th>
							<th><b>Upto 16/03 To 31/03</b>
							</th>
			
						</tr>
						<c:if test="${not empty parentBean}">
							<tr>
								<td>Amount</td>
								<td><c:out value="${parentBean.total_Sum1}" />
								</td>
								<td><c:out value="${parentBean.total_Sum2}" />
								</td>
								<td><c:out value="${parentBean.total_Sum3}" />
								</td>
								<td><c:out value="${parentBean.total_Sum4}" />
								</td>
								<td><c:out value="${parentBean.total_Sum5}" />
								</td>
			
							</tr>
						</c:if>
			
					</table>
					 -->
				</c:otherwise>
			</c:choose>
		</div>
	</div>

<res:client-validation formId="frmdataAdvTax"
	screenConfigurationDocumentName="advancetax"
	formSubmitButtonId="myModalHrefAdvTax" />

<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
    $(document).ready(function() {

	var fY='<c:out value="${financialYear}" />'.split("-", 4);
	itrFinYrMax="31/03/"+fY[1];
	itrFinYrMin="01/04/"+fY[0];
			$( ".indiandateAdvance" ).datepicker( "option", "minDate", itrFinYrMin );
			$( ".indiandateAdvance" ).datepicker( "option", "maxDate", itrFinYrMax );
			});


</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />


