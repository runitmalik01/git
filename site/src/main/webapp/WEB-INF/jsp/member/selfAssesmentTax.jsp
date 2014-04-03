<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="tds2">
	Self Assessment Tax
</c:set>
<hippo-gogreen:title title="${tds2}" />
<hst:actionURL var="actionUrl" />
<w4india:itrmenu></w4india:itrmenu>
<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
		<c:if test="${not empty formMap}">
			<c:forEach items="${formMap.message}" var="item">
				<div class="alert alert-danger">
					<fmt:message key="${item.value}" />
				</div>
			</c:forEach>
		</c:if>
		<w4india:titleandnav title="Self Assessment Tax"
			subTitle="Self Assessment tax means any balance tax paid by the
			assessee on the assessed income after deducting TDS and Advance tax
			before filing the Return of income."></w4india:titleandnav>
		<c:choose>
			<c:when
				test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
				<form id="frmdataSelfTax" action="${actionUrl}" method="post"
					name="selfassementtax">

					<fieldset>
						<legend class="header-color">
							<fmt:message key="member.tds.selfassesment.tax" />
						</legend>
						<div class="row show-grid">
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="bsr_codeself"><abbr
										title=" Basic Statistical Return Code"><small><fmt:message
													key="tds.bsr.code" /> </small> </abbr> </label>
								</div>
								<div class="rowlabel">
									<input id="bsr_codeself" name="bsr_codeself" type="text"
										maxlength="7"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="date_creditself"><small><fmt:message
												key="tds.date.credit" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="date_creditself" name="date_creditself" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>" />
								</div>
							</div>
						</div>
						<div class="row show-grid" id="ul_revised_input">
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="Serial_challanself"><small><fmt:message
												key="tds.serial.challan" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="Serial_challanself" name="Serial_challanself"
										type="text" maxlength="5"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="amountself"><small><fmt:message
												key="tds.amount.selfassesment" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="amountself" name="amountself" type="text"
										maxlength="14" class="decimal"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.p_Amount}"/></c:if>" />
								</div>
							</div>
						</div>
					</fieldset>
					<div class="row show-grid">
						<div class="col-md-4 col-md-offset-8 decimal">
							<a
								href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_SELF_ASSESSMENT%>"
								class="btn btn-default btn-danger">Cancel</a>&nbsp; <a
								id="myModalHrefSelfTax" role="button"
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
						<c:forEach items="${parentBean.selfAssesmentDetailList}"
							var="selfassesmentdetail">
							<tr>
								<td><c:out value="${selfassesmentdetail.p_BSR}" /></td>
								<td><c:out value="${selfassesmentdetail.dateStr}" /></td>
								<td><c:out value="${selfassesmentdetail.p_Serial}" /></td>
								<td><w4india:inr value="${selfassesmentdetail.p_Amount}" />
								</td>
								<td><a class="btn btn-default btn-primary"
									href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxedit"><small><i
											class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
										&nbsp;&nbsp; </a>&nbsp;&nbsp;<a class="btn btn-default btn-danger"
									href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxdelete"
									id="delete" data-confirm=""><small><i
											class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
								</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="3"><fmt:message key="tds.amount.total" /></td>
							<td><w4india:inr value="${parentBean.total_Amount}" /></td>
					</c:if>
				</table>
				<a href="${scriptName}/selfassesmenttaxnew"
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

<res:client-validation formId="frmdataSelfTax"
	screenConfigurationDocumentName="selfassementtax"
	formSubmitButtonId="myModalHrefSelfTax" />
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
    $(document).ready(function() {

    var AY='<c:out value="${assessmentYear}" />'.split("-", 4);
    var currDate = '<c:out value="${currDate}"></c:out>';
	itrFinYrMax=currDate;
	itrFinYrMin="01/04/"+'<c:out value="${endYear}"></c:out>';
	$( ".indiandateSelfAssesment" ).datepicker( "option", "minDate", itrFinYrMin );
			$( ".indiandateSelfAssesment" ).datepicker( "option", "maxDate", itrFinYrMax );
			});

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
