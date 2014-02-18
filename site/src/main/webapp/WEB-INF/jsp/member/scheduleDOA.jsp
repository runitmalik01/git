<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="DOA">
	<fmt:message key="DOA" />
</c:set>
<hippo-gogreen:title title="${DOA}" />
<hst:actionURL var="actionUrl" />

<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty stopPuttingSameRate}">
		<div class="alert alert-danger">
			<fmt:message key="${stopPuttingSameRate}" />
		</div>
	</c:if>
	<div class="page-header">
		<h2 class="title page-title">Schedule DOA</h2>
		<h4>
			<small></small>
		</h4>
	</div>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmScheduleDOA" action="${actionUrl}" method="post"
				name="frmScheduleDOA">
				<legend class="header-color">
					<small><fmt:message key="schedule.DOA.itr4" /></small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="rates"><small><fmt:message
										key="type.asset.depreciation.doa.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<select id="type_Asset" name="type_Asset">
								<option value="">-Select-</option>
								<option value="Building"
									<c:if test="${not empty childBean.type_Asset && childBean.type_Asset =='Building'}">selected</c:if>>Building</option>
								<option value="Furniture"
									<c:if test="${not empty childBean.type_Asset && childBean.type_Asset =='Furniture'}">selected</c:if>>Furniture
									and Fittings</option>
								<option value="Intangible"
									<c:if test="${not empty childBean.type_Asset && childBean.type_Asset =='Intangible'}">selected</c:if>>Intangible</option>
								<option value="Ships"
									<c:if test="${not empty childBean.type_Asset && childBean.type_Asset =='Ships'}">selected</c:if>>Ships</option>

							</select>
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="rates"><small><fmt:message
										key="rates.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<select id="rates" name="rates">
								<option value="">-Select-</option>
								<option id="Rate5" value="5"
									<c:if test="${not empty childBean.rates && childBean.rates =='5'}">selected</c:if>>5</option>
								<option id="Rate10" value="10"
									<c:if test="${not empty childBean.rates && childBean.rates =='10'}">selected</c:if>>10</option>
								<option id="Rate100" value="100"
									<c:if test="${not empty childBean.rates && childBean.rates =='100'}">selected</c:if>>100</option>
								<option id="Rate_10" value="10"
									<c:if test="${not empty childBean.rates && childBean.rates =='10'}">selected</c:if>>10</option>
								<option id="Rate25" value="25"
									<c:if test="${not empty childBean.rates && childBean.rates =='25'}">selected</c:if>>25</option>
								<option id="Rate20" value="20"
									<c:if test="${not empty childBean.rates && childBean.rates =='20'}">selected</c:if>>20</option>

							</select>
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="valFirstDayPrevYr"><small><fmt:message
										key="valFirstDayPrevYr.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="valFirstDayPrevYr" name="valFirstDayPrevYr"
								class="uprcase decimal" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.valFirstDayPrevYr}"/></c:if>">

						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="periodMore180Day"><small><fmt:message
										key="periodMore180Day.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="periodMore180Day" name="periodMore180Day"
								maxlength="14" type="text" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.periodMore180Day}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="prevYrConsider"><small><fmt:message
										key="prevYrConsider.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="prevYrConsider" name="prevYrConsider" maxlength="14"
								type="text" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.periodMore180Day}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="amtDepreciationFullRate"><small><fmt:message
										key="amtDepreciationFullRate.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="amtDepreciationFullRate"
								name="amtDepreciationFullRate" maxlength="14" type="text"
								class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.amtDepreciationFullRate}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="periodLess180Day"><small><fmt:message
										key="periodLess180Day.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="periodLess180Day" name="periodLess180Day" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.periodLess180Day}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="considerOrRealDuringYr"><small><fmt:message
										key="considerOrRealDuringYr.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="considerOrRealDuringYr" name="considerOrRealDuringYr"
								type="text" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.considerOrRealDuringYr}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="amtDepreciationHalfRate"><small><fmt:message
										key="amtDepreciationHalfRate.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="amtDepreciationHalfRate"
								name="amtDepreciationHalfRate" type="text" maxlength="14"
								class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.amtDepreciationHalfRate}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="depreciationFullRate"><small><fmt:message
										key="DepreciationFullRate.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="depreciationFullRate" name="depreciationFullRate"
								type="text" maxlength="14" class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.depreciationFullRate}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="depreciationHalfRate"><small><fmt:message
										key="depreciationHalfRate.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="depreciationHalfRate" name="depreciationHalfRate"
								type="text" maxlength="14" class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.depreciationHalfRate}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="addDepreciatMore180Day"><small><fmt:message
										key="addDepreciatMore180Day.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="addDepreciatMore180Day" name="addDepreciatMore180Day"
								type="text" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.addDepreciatMore180Day}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="addDepreciatLess180Day"><small><fmt:message
										key="addDepreciatLess180Day.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="addDepreciatLess180Day" name="addDepreciatLess180Day"
								type="text" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.addDepreciatLess180Day}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="totalDepreciation"><small><fmt:message
										key="totalDepreciation.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="totalDepreciation" name="totalDepreciation"
								type="text" maxlength="14" class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.totalDepreciation}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="expense_TransferAsset"><small><fmt:message
										key="expense_TransferAsset.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="expense_TransferAsset" name="expense_TransferAsset"
								type="text" maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.expense_TransferAsset}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="capitalGain_LossSec50"><small><fmt:message
										key="capitalGain_LossSec50.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="capitalGain_LossSec50" name="capitalGain_LossSec50"
								type="text" maxlength="14" class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.capitalGain_LossSec50}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="valLastDayPrevYr"><small><fmt:message
										key="valLastDayPrevYr.dpm.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<input id="valLastDayPrevYr" name="valLastDayPrevYr" type="text"
								maxlength="14" class="decimal" readonly="readonly"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.valLastDayPrevYr}"/></c:if>" />
						</div>
					</div>
				</div>
					<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="isBlockExhist"><small>Is property exhist </small> </label>
					</div></div>
					<div class="col-md-4">
					<div class="rowlabel">
						<select id="isBlockExhist" name="isBlockExhist">
						<option value="">-Select-</option>
								<option value="Yes"
									<c:if test="${not empty childBean.isBlockExhist && childBean.isBlockExhist =='Yes'}">selected</c:if>>Yes</option>
								<option value="No"
									<c:if test="${not empty childBean.isBlockExhist && childBean.isBlockExhist =='No'}">selected</c:if>>No</option>
						</select>
					</div>
				</div>
		</div>
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalScheduleDOA" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>

				</div>

			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="rates.dpm.itr4" /> </b></th>
					<th><b><fmt:message key="valLastDayPrevYr.dpm.itr4" /> </b></th>

					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.scheduleDOADetailList}"
						var="scheduleDOA">
						<tr>
							<td><c:out value="${scheduleDOA.rates}" /></td>
							<td><c:out value="${scheduleDOA.valLastDayPrevYr}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${scheduleDOA.canonicalUUID}"/>/scheduleDOAedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger "
								href="${scriptName}/<c:out value="${scheduleDOA.canonicalUUID}"/>/scheduleDOAdelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
						</tr>
					</c:forEach>


				</c:if>
			</table>
			<a href="${scriptName}/scheduleDOAnew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
	$("#type_Asset").change(function() {
		if ($("#type_Asset").val() == "Building") {
			$('#rates').val('');
			$('#Rate5').show();
			$('#Rate10').show();
			$('#Rate100').show();
			$('#Rate_10').hide();
			$('#Rate25').hide();
			$('#Rate20').hide();
		}
		if ($("#type_Asset").val() == "Furniture") {
			$('#rates').val('');
			$('#Rate5').hide();
			$('#Rate10').show();
			$('#Rate100').hide();
			$('#Rate_10').hide();
			$('#Rate25').hide();
			$('#Rate20').hide();
		}
		if ($("#type_Asset").val() == "Intangible") {
			$('#rates').val('');
			$('#Rate5').hide();
			$('#Rate10').hide();
			$('#Rate100').hide();
			$('#Rate_10').hide();
			$('#Rate25').show();
			$('#Rate20').hide();
		}
		if ($("#type_Asset").val() == "Ships") {
			$('#rates').val('');
			$('#Rate5').hide();
			$('#Rate10').hide();
			$('#Rate100').hide();
			$('#Rate_10').hide();
			$('#Rate25').hide();
			$('#Rate20').show();
		}
	});
</script>
<res:calc screenCalc="scheduledoa" formId="frmScheduleDOA"></res:calc>
<res:client-validation formId="frmScheduleDOA"
	screenConfigurationDocumentName="scheduledoa"
	formSubmitButtonId="myModalScheduleDOA" />