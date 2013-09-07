%@page import="com.mootly.wcm.model.ITRTab"%>
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
	<hst:link var="mainSiteMapRefId" />

	<h4>
		<fmt:message key="asset.liability.itr4" />
	</h4>
	<form id="frmAsset_Liability" action="${actionUrl}" method="post"
		name="frmAsset_Liability">
		<fieldset>
			<legend style="color: blue">Particulars of Asset </legend>
			<fieldset>
				<legend style="color: black">Immovable Asset</legend>
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="land"><small>Land</small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="land" name="land" type="text" maxlength="14" value="" />

						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="building"><small>Building</small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="building" name="building" type="text" maxlength="14"
								value="" />

						</div>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend style="color: black">Movable Asset</legend>
				<h2>Financial Asset</h2>

				<div class="row-fluid show-grid">
					<div class="span1 decimal">
						<div class="rowlabel">
							<small>i</small>
						</div>
					</div>
					<div class="span7 decimal">
						<div class="rowlabel">
							<label for="deposit_Bank"><small><fmt:message
										key="al.bankdeposit.itr4" /> </small> </label>
						</div>
					</div>
					<div class="span2 offset1">
						<div class="rowlabel">
							<input id="deposit_Bank" name="deposit_Bank" type="text"
								maxlength="14" value="" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span1 decimal">
						<div class="rowlabel">
							<small>ii</small>
						</div>
					</div>
					<div class="span7 decimal">
						<div class="rowlabel">
							<label for="shares"><small>Shares and securities
							</small> </label>
						</div>
					</div>
					<div class="span2 offset1">
						<div class="rowlabel">
							<input id="shares" name="shares" type="text" maxlength="14"
								value="" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span1 decimal">
						<div class="rowlabel">
							<small>iii</small>
						</div>
					</div>
					<div class="span7 decimal">
						<div class="rowlabel">
							<label for="insurance"><small>Insurance policies
							</small> </label>
						</div>
					</div>
					<div class="span2 offset1">
						<div class="rowlabel">
							<input id="insurance" name="insurance" type="text" maxlength="14"
								value="" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span1 decimal">
						<div class="rowlabel">
							<small>iv</small>
						</div>
					</div>
					<div class="span7 decimal">
						<div class="rowlabel">
							<label for="loans_Adv"><small>Loans and Advances
									given </small> </label>
						</div>
					</div>
					<div class="span2 offset1">
						<div class="rowlabel">
							<input id="loans_Adv" name="loans_Adv" type="text" maxlength="14"
								value="" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span1 decimal">
						<div class="rowlabel">
							<small>v</small>
						</div>
					</div>
					<div class="span7 decimal">
						<div class="rowlabel">
							<label for="cash"><small>Cash in hand</small> </label>
						</div>
					</div>
					<div class="span2 offset1">
						<div class="rowlabel">
							<input id="cash" name="cash" type="text" maxlength="14" value="" />
						</div>
					</div>
				</div>

				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="jewellery"><small>Jewellery, bullion
									etc.</small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="jewellery" name="jewellery" type="text" maxlength="14"
								value="" />

						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="drawing"><small><fmt:message
										key="al.drawing.itr4" /> </small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="drawing" name="drawing" type="text" maxlength="14"
								value="" />

						</div>
					</div>
				</div>
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="vehicles"><small><fmt:message
										key="al.vehicles.itr4" />
							</small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="vehicles" name="vehicles" type="text" maxlength="14"
								value="" />
						</div>
					</div>
				</div>

				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="total"><small>Total</small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="total" name="total" type="text" maxlength="14"
								readonly="readonly" />
						</div>
					</div>
				</div>
			</fieldset>


			<div id="liability_A">
				<div class="row-fluid show-grid">
					<div class="span8">
						<div class="rowlabel">
							<label for="liability"><small><fmt:message
										key="al.liability.itr4" /> </small> </label>
						</div>
					</div>
					<div class="span3">
						<div class="rowlabel">
							<input id="liability" name="liability" type="text" maxlength="14"
								value="" />
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
					<a id="myModalAssetAndLiability" role="button"
						class="btn btn-success" style="color: black">Save</a>
				</div>
			</div>
	</form>
</div>


<res:client-validation formId="frmAsset_Liability"
	screenConfigurationDocumentName="assetandliability"
	formSubmitButtonId="myModalAssetAndLiability" />

