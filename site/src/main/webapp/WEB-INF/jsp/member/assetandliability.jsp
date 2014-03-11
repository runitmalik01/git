<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="a_l">
	<fmt:message key="a_l" />
</c:set>
<hippo-gogreen:title title="${a_l}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<fmt:message key="asset.liability.itr4" var="subTitle" />
	<w4india:titleandnav title="Schedule AL" subTitle="${subTitle}"/>
	<hst:link var="mainSiteMapRefId" />
	<form id="frmAsset_Liability" action="${actionUrl}" method="post"
		name="frmAsset_Liability">
		<fieldset>
			<legend class="header-color">
				<small>Particulars of Asset</small>
			</legend>
			<fieldset>
				<legend class="header-color">
					<small>Immovable Asset</small>
				</legend>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="land"><small>Land</small> </label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="rowlabel">
							<input id="land" name="land" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.land}" />" />

						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="building"><small>Building</small> </label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="rowlabel">
							<input id="building" name="building" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.building}" />" />

						</div>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend class="header-color">
					<small>Movable Asset</small>
				</legend>
				<h4>Financial Asset</h4>

				<div class="row show-grid">
					<div class="col-md-1 decimal">
						<div class="rowlabel">
							<small>i</small>
						</div>
					</div>
					<div class="col-md-7 decimal">
						<div class="rowlabel">
							<label for="deposit_Bank"><small><fmt:message
										key="al.bankdeposit.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<div class="rowlabel">
							<input id="deposit_Bank" name="deposit_Bank" type="text"
								maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.deposit_Bank}" />" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-1 decimal">
						<div class="rowlabel">
							<small>ii</small>
						</div>
					</div>
					<div class="col-md-7 decimal">
						<div class="rowlabel">
							<label for="shares"><small>Shares and securities
							</small> </label>
						</div>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<div class="rowlabel">
							<input id="shares" name="shares" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.shares}" />" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-1 decimal">
						<div class="rowlabel">
							<small>iii</small>
						</div>
					</div>
					<div class="col-md-7 decimal">
						<div class="rowlabel">
							<label for="insurance"><small>Insurance policies
							</small> </label>
						</div>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<div class="rowlabel">
							<input id="insurance" name="insurance" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.insurance}" />" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-1 decimal">
						<div class="rowlabel">
							<small>iv</small>
						</div>
					</div>
					<div class="col-md-7 decimal">
						<div class="rowlabel">
							<label for="loans_Adv"><small>Loans and Advances
									given </small> </label>
						</div>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<div class="rowlabel">
							<input id="loans_Adv" name="loans_Adv" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.loans_Adv}" />" />
						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-1 decimal">
						<div class="rowlabel">
							<small>v</small>
						</div>
					</div>
					<div class="col-md-7 decimal">
						<div class="rowlabel">
							<label for="cash"><small>Cash in hand</small> </label>
						</div>
					</div>
					<div class="col-md-2 col-md-offset-1">
						<div class="rowlabel">
							<input id="cash" name="cash" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.cash}" />" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="jewellery"><small>Jewellery, bullion
									etc.</small> </label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="rowlabel">
							<input id="jewellery" name="jewellery" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.jewellery}" />" />

						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="drawing"><small><fmt:message
										key="al.drawing.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="rowlabel">
							<input id="drawing" name="drawing" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.drawing}" />" />

						</div>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-md-8">
						<div class="rowlabel">
							<label for="vehicles"><small><fmt:message
										key="al.vehicles.itr4" /> </small> </label>
						</div>
					</div>
					<div class="col-md-3">
						<div class="rowlabel">
							<input id="vehicles" name="vehicles" type="text" maxlength="14"
								value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.vehicles}" />" />
						</div>
					</div>
				</div>
			</fieldset>
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="total"><small>Total</small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="total" name="total" type="text" maxlength="14"
							readonly="readonly"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total}" />" />
					</div>
				</div>
			</div>
		</fieldset>


		<div id="liability_A">
			<div class="row show-grid">
				<div class="col-md-8">
					<div class="rowlabel">
						<label for="liability"><small><fmt:message
									key="al.liability.itr4" /> </small> </label>
					</div>
				</div>
				<div class="col-md-3">
					<div class="rowlabel">
						<input id="liability" name="liability" type="text" maxlength="14"
							value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.liability}" />" />
					</div>
				</div>
			</div>
		</div>
		<div class="row show-grid">
			<div class="col-md-4 col-md-offset-8 decimal">
				<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
				<a id="myModalAssetAndLiability" role="button"
					class="btn btn-default btn-success">Save</a>
			</div>
		</div>
	</form>
</div>
</div>
</div>

<res:calc screenCalc="assetandliability" formId="frmAsset_Liability"></res:calc>
<res:client-validation formId="frmAsset_Liability"
	screenConfigurationDocumentName="assetandliability"
	formSubmitButtonId="myModalAssetAndLiability" />

