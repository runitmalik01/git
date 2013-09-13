<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="dcg">
	<fmt:message key="dcg" />
</c:set>
<hippo-gogreen:title title="${dcg}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />

	<h4>
		<fmt:message key="deemed.capitalgain.itr4" />
	</h4>
	<form id="frmDeemed_Capital" action="${actionUrl}" method="post"
		name="frmDeemed_Capital">
		<fieldset>
			<legend style="color: black">Plant and Machinery </legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="ratefifteen"><small><fmt:message
									key="dcg.15.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratefifteen" name="ratefifteen" readonly="readonly"
							type="text" maxlength="14" value="" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="ratethirty"><small><fmt:message
									key="dcg.30.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratethirty" name="ratethirty" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="rateforty"><small><fmt:message
									key="dcg.40.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="rateforty" name="rateforty" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="ratefifty"><small><fmt:message
									key="dcg.50.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratefifty" name="ratefifty" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="ratesixty"><small><fmt:message
									key="dcg.60.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratesixty" name="ratesixty" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="rateeighty"><small><fmt:message
									key="dcg.80.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="rateeighty" name="rateeighty" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="ratehundred"><small><fmt:message
									key="dcg.100.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratehundred" name="ratehundred" readonly="readonly"
							type="text" maxlength="14" value="" />

					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="total"><small>Total</small> </label>
					</div>
					<div class="rowlabel">
						<input id="total" name="total" type="text" maxlength="14"
							readonly="readonly" />
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset>
			<legend style="color: black">Building</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="ratefive"><small><fmt:message
									key="dcg.5.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="ratefive" name="ratefive" type="text" maxlength="14"
							value="" readonly="readonly" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="rateten"><small><fmt:message
									key="dcg.10.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="rateten" name="rateten" type="text" maxlength="14"
							readonly="readonly" value="" />

					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="hundred"><small><fmt:message
									key="dcg.hundred.itr4" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="hundred" name="hundred" type="text" maxlength="14"
							readonly="readonly" value="" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">

				<div class="span4">
					<div class="rowlabel">
						<label for="total1"><small>Total</small> </label>
					</div>
					<div class="rowlabel">
						<input id="total1" name="total1" type="text" maxlength="14"
							readonly="readonly" />
					</div>
				</div>
			</div>
		</fieldset>
		<div id="depreciable_asset">
			<div class="row-fluid show-grid">
				<div class="span3">
					<div class="rowlabel">
						<label for="furniture"><small>Furniture and
								fittings </small> </label>
					</div>
					<div class="rowlabel">
						<input id="furniture" name="furniture" type="text" maxlength="14"
							readonly="readonly" value="" />
					</div>
				</div>
			<div class="span3">
					<div class="rowlabel">
						<label for="intangible"><small>Intangible Assets</small> </label>
					</div>
					<div class="rowlabel">
						<input id="intangible" name="intangible" type="text"
							maxlength="14" readonly="readonly" value="" />
					</div>
				</div>
			<div class="span3">
					<div class="rowlabel">
						<label for="ships"><small>Ships</small> </label>
					</div>
					<div class="rowlabel">
						<input id="ships" name="ships" type="text" maxlength="14"
							readonly="readonly" value="" />
					</div>
				</div>
				<div class="span3">
					<div class="rowlabel">
						<label for="total2"><small>Total</small> </label>
					</div>
					<div class="rowlabel">
						<input id="total2" name="total2" type="text" maxlength="14"
							readonly="readonly" />
					</div>
				</div>
		</div>
		</div>

		<div class="row-fluid show-grid">
			<div class="span4 offset8 decimal">
				<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
				<a id="myModalDeemedCapitalGain" role="button"
					class="btn btn-success" style="color: black">Save</a>
			</div>
		</div>
	</form>
</div>
<res:client-validation formId="frmDeemed_Capital"
	screenConfigurationDocumentName="deemedcapitalgain"
	formSubmitButtonId="myModalDeemedCapitalGain" />
