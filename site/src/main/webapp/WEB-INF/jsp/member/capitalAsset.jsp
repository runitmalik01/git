<%@page import="com.mootly.wcm.model.InflationIndex"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.CapitalAssetDetail"%>
<%@page import="com.mootly.wcm.beans.CapitalAssetDocument"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.model.FilingSection"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<c:set var="capitalasset">
	<fmt:message key="member.capital.title" />
</c:set>
<hippo-gogreen:title title="${capitalasset}" />
<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
<%
	pageContext.setAttribute("inflationindexValues",
			InflationIndex.values());
%>
<%-- 
<script type="text/javascript">
	//var $m = jQuery.noConflict(true);
	function getautoindex() {
		var option = document.getElementById("year_purchase");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$("#inflation_acquisition").val(a);
		}
	}
	function getautoindex1() {
		var option = document.getElementById("year_sale");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$("#inflation_consideration").val(a);
		}
	}
</script>--%>
<div class="page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</h3>
	<h4>
		<fmt:message key="Capital.gain.Income.Screen" />
	</h4>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="capitalassetfrm" action="${actionUrl}" method="post"
				name="capitalasset">
				<%-- <input type="hidden" name="hidDateAcquisition"
					id="hidDateAcquisition" value=" " /> <input type="hidden"
					name="hidDateSale" id="hidDateSale" value=" " />--%>

				<fieldset>
					<legend style="font-style: italic; color: blue;">Asset
						Information</legend>
					<div align="center" style="color: red">Please enter your
						details in shaded portion of the form</div>
					<br />
					<div class="row-fluid show-grid">
						<div class="span3">
							<div class="rowlabel">
								<label for="asset_type"><small>Asset Type</small> </label>
							</div>
							<div class="rowlabel">
								<select id="asset_type" name="asset_type" onChange="hidesst()">
									<option value="">-Select-</option>
									<option value="SHARES"
										<c:if test="${not empty childBean.assetType && childBean.assetType =='SHARES'}">selected</c:if>>Listed
										Shares/Debentures/Bond/ Unit of Mutual Fund etc</option>
									<option value="OTH"
										<c:if test="${not empty childBean.assetType && childBean.assetType =='OTH'}">selected</c:if>>Other
									</option>
								</select>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="nameasset"><small><fmt:message
											key="capital.gain.name.asset" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="nameasset" name="nameasset"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nameAsset}"/></c:if>"
									type="text">
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="date_acquisition"><small><fmt:message
											key="capital.gain.date.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="date_acquisition" name="date_acquisition"
									placeholder="dd/mm/yyyy" type="text"
									value="<c:if test="${not empty childBean.dateAcquisitionStr}">
								<c:out value="${childBean.dateAcquisitionStr}"/></c:if>">
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for="date_sale"><small><fmt:message
											key="capital.gain.date.sale" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="date_sale" name="date_sale" placeholder="dd/mm/yyyy"
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.datesaleStr}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="months"><small>No. of Days</small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" name="months" id="months" class="decimal"
									readonly="readonly" onblur="daycalculate()"
									value="<c:if test="${not empty childBean.months}">
								<c:out value="${childBean.months}"/></c:if>">
							</div>
						</div>
						<div class="span4 st">
							<div class="rowlabel" id="sst">
								<label for="sst_charge"><small>Whether STT
										Charged </small> </label>
							</div>
							<div class="rowlabel">
								<select id="sst_charge" name="sst_charge"
									onchange="hidesstoptions()">
									<option value="">-Select-</option>
									<option value="Y" style="border-right: olive;"
										<c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='Y'}">selected</c:if>>YES</option>
									<option value="N"
										<c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset id="fd_set_gain"
					class="<c:if test="${pageAction == 'NEW_CHILD' }">hide</c:if>">
					<legend class="hide st" style="font-style: italic; color: blue;">Computation
						(Short Term Gain)</legend>
					<legend class="hide lt" style="font-style: italic; color: blue;">Computation
						(Long Term Gain)</legend>
					<c:if test="${status == 'RES'}">
						<div class="st">
							<h2>In case of NON-RESIDENT to which first provisio to
								section 48 is applicable</h2>
							<div class="row-fluid show-grid">
								<div class="span9">
									<div class="rowlabel">
										<label for="asset111"><small>a-From assets
												where section 111A is applicable </small> </label>
									</div>
								</div>
								<div class="span3">
									<div class="rowlabel">
										<input id="asset111" name="asset111"
											style="background-color: #DFDFDF" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.asset_111}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
							<div class="row-fluid show-grid">
								<div class="span9">
									<div class="rowlabel">
										<label for="assetnt111"><small>b-From
												assets(Shares/Unit) in the case of others where section 111A
												is applicable </small> </label>
									</div>
								</div>
								<div class="span3">
									<div class="rowlabel">
										<input id="assetnt111" name="assetnt111" class="decimal"
											style="background-color: #DFDFDF"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.assetnt111}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${status == 'RES'}">
						<div class="lt">
							<div class="row-fluid show-grid">
								<div class="span9">
									<div class="rowlabel">
										<label for="section48"><small>In case of
												NON-RESIDENT to which first proviso to section 48 is
												applicable </small> </label>
									</div>
								</div>
								<div class="span3">
									<div class="rowlabel">
										<input id="section48" name="section48"
											style="background-color: #DFDFDF" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.section48}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
							<div class="row-fluid show-grid">
								<div class="span9">
									<div class="rowlabel">
										<label for="unlstdsecurity"><small>From
												unlisted securities in case of non-resident as per section
												112(1)(c)(iii) </small> </label>
									</div>
								</div>
								<div class="span3">
									<div class="rowlabel">
										<input id="unlstdsecurity" name="unlstdsecurity"
											style="background-color: #DFDFDF" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.unlstdSecurity}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<div class="row-fluid show-grid lt">
						<div class="span9">
							<div class="rowlabel">
								<label for="index"><small>Do you want indexation
								</small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<select id="index" name="index" onchange="hidesstoptions()">
									<option value="">-Select-</option>
									<option value="Y" style="border-right: olive;"
										<c:if test="${not empty childBean.index && childBean.index =='Y'}">selected</c:if>>YES</option>
									<option value="N"
										<c:if test="${not empty childBean.index && childBean.index =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="saleconsideration"><fmt:message
										key="capital.gain.sale.consider" /> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="saleconsideration"
									id="saleconsideration" style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel without_Y_index without_N_index ">
								<label for="costacquisition"><small><fmt:message
											key="capital.gain.cost.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel hide with_Y_index with_N_index ">
								<label for="costacquisition"><small>Cost of
										Acquisition with Indexation </small> </label>
							</div>
						</div>
						<div class="span3 ">
							<div class="rowlabel">
								<input id="costacquisition" name="costacquisition" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</diV>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel without_Y_index without_N_index">
								<label for="costimprovement"><small><fmt:message
											key="capital.gain.cost.improvement" /> </small> </label>
							</div>
							<div class="rowlabel hide with_Y_index with_N_index ">
								<label for="costimprovement"><small>Cost of
										Improvement with Indexation</small> </label>

							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input id="costimprovement" name="costimprovement" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costImprovement}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="costtrnsfr"><small>Expenditure on
										Transfer </small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input id="costtrnsfr" name="costtrnsfr" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costTransfer}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="balanc">Balance </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="balanc" id="balanc"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.balance}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid st">
						<div class="span9">
							<div class="rowlabel">
								<label for="losssec94">Loss, if any, to be ignored under
									section 94(7) or 94(8) (Enter positive values only) </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="losssec94" id="losssec94"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.loss_sec94}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid" id="ded">
						<div class="span9">
							<div class="rowlabel">
								<label for="dedsec54">Deduction under section 54B/54D </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="dedsec54" id="dedsec54"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.ded_sec54}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="amtdeemed"><small>Amount deemed to
										be short term capital gains under sections 54B/54D/54G/ 54GA </small>
								</label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input id="amtdeemed" name="amtdeemed"
									style="background-color: #DFDFDF" class="decimal"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtdeemed}"/></c:if>"
									type="text">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9 lt" >
							<div class="rowlabel">
								<label for="panifded"><small>In case of
										deduction u/s 54GB, furnish PAN of the company </small> </label>
							</div>
						</div>
						<div class="span3 lt">
							<div class="rowlabel">
								<input type="text" name="panifded" id="panifded"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.pan}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="capitalgain"><small>Capital Gain </small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="capitalgain" id="capitalgain"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:if test= "${childBean.index == 'Y' || 'N' }">
									<fmt:formatNumber type="number"  maxIntegerDigits="14" value="${childBean.capitalGainTaxLT}"/></c:if>
									<fmt:formatNumber type="number"  maxIntegerDigits="14" value="${childBean.capitalGain}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
				</fieldset>

				<%--here we are coding for long terms capital gain 
				<fieldset id="longterms">
					<legend style="font-style: italic; color: blue;">Computation
						(Long Term Gain)</legend>

					<c:if test="${status == 'RES'}">
						<div class="row-fluid show-grid">
							<div class="span9">
								<div class="rowlabel">
									<label for="section48"><small>In case of
											NON-RESIDENT to which first proviso to section 48 is
											applicable </small> </label>
								</div>
							</div>
							<div class="span3">
								<div class="rowlabel">
									<input id="section48" name="section48"
										style="background-color: #DFDFDF" class="decimal"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nameAsset}"/></c:if>"
										type="text">
								</div>
							</div>
						</div>
						<div class="row-fluid show-grid">
							<div class="span9">
								<div class="rowlabel">
									<label for="unlstdsecurity"><small>From
											unlisted securities in case of non-resident as per section
											112(1)(c)(iii) </small> </label>
								</div>
							</div>
							<div class="span3">
								<div class="rowlabel">
									<input id="unlstdsecurity" name="unlstdsecurity"
										style="background-color: #DFDFDF" class="decimal"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nameAsset}"/></c:if>"
										type="text">
								</div>
							</div>
						</div>
					</c:if>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="index"><small>Do you want indexation
								</small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<select id="index" name="index" onchange="hidesstoptions()">
									<option value="">-Select-</option>
									<option value="Y" style="border-right: olive;"
										<c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='Y'}">selected</c:if>>YES</option>
									<option value="N"
										<c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel ">
								<label for="sale_consideration"><fmt:message
										key="capital.gain.sale.consider" /> </label>

							</div>

						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="sale_consideration"
									id="sale_consideration" style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel without_Y_index without_N_index ">
								<label for="cost_acquisition"><small><fmt:message
											key="capital.gain.cost.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel hide with_Y_index with_N_index ">
								<label for="cost_acquisition"><small>cost of
										acquisition with indexation </small> </label>
							</div>
						</div>
						<div class="span3 ">
							<div class="rowlabel">
								<input id="cost_acquisition" name="cost_acquisition" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</diV>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel without_Y_index without_N_index">
								<label for="cost_improvement"><small><fmt:message
											key="capital.gain.cost.improvement" /> </small> </label>
							</div>
							<div class="rowlabel hide with_Y_index with_N_index ">
								<label for="sale_consideration">Cost of improvement with
									indexation</label>

							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input id="cost_improvement" name="cost_improvement" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costImprovement}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="cost_trnsfr"><small>Expenditure on
										Transfer </small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input id="cost_trnsfr" name="cost_trnsfr" type="text"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costTransfer}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="balance">Balance </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="balance" id="balance"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value=""/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel" id="ded">
								<label for="ded_sec54">Deduction under section 54B/54D </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="ded_sec54" id="ded_sec54"
									style="background-color: #DFDFDF"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value=""/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>

					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">

								<label for="capital_gain"><small>Capital Gain </small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<input type="text" name="capital_gain" id="capital_gain"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number" 
            maxIntegerDigits="14" value="${childBean.capitalGain}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
				</fieldset>--%>
				<fieldset>
					<legend style="font-style: italic; color: blue;">Information
						about accrual/Receipt of Capital Gain</legend>
					<div class="row-fluid show-grid">
						<div class="span9">
							<div class="rowlabel">
								<label for="accural_info"><small>Do you have
										accural/Receipt of Capital Gain</small> </label>
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<select name="accural_info" id="accural_info">
									<option value="">-Select-</option>
									<option value="Y" style="border-right: olive;"
										<c:if test="${not empty childBean.accural && childBean.accural =='Y'}">selected</c:if>>YES</option>
									<option value="N"
										<c:if test="${not empty childBean.accural && childBean.accural =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div id="accural_gain" class="accural_Y_gain accural_N_gain hide">
						<table>
							<tr>
								<th style="color: black;" width="50%">Dates:</th>
								<th style="color: black;">STCG 111A</th>
								<th style="color: black;">STCG OTH</th>
							</tr>
							<tr>
								<td>i- Upto 15/9(i)</td>
								<td><input type="text" name="upto15st" id="upto15st"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15St}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto15oth" id="upto15oth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15Oth}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<tr>
								<td>ii- 16/9 to 15/12(ii)</td>
								<td><input type="text" name="upto16st" id="upto16st"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16St}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto16oth" id="upto16oth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16Oth}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							
							<tr>

								<td>iii- 16/12 to 15/3(iii)</td>
								<td><input type="text" name="upto16decst" id="upto16decst"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16decSt}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="upto16decoth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16DecOth}"/></c:if>"
									class="decimal" id="upto16decoth" maxlength="15">
								</td>
							
							<tr>
								<td>iv- 16/3 to 31/3(iv)</td>
								<td><input type="text" name="upto31st" id="upto31st"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto31St}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="upto31oth" id="upto31oth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto31Oth}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							</tr>
							<tr>
								<th width="50%" style="color: black;">Dates:</th>
								<th style="color: black;">LTCG proviso</th>
								<th style="color: black;">LTCG NO proviso</th>
							</tr>
							<tr>
								<td>i- Upto 15/9(i)</td>
								<td><input type="text" name="upto15Lt" id="upto15Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15Lt}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="upto15np" id="upto15np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15Np}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							
							<tr>
								<td>ii- 16/9 to 15/12(ii)</td>
								<td><input type="text" name="upto16Lt" id="upto16Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16Lt}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="upto16np" id="upto16np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16Np}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							
							<tr>
								<td>iii- 16/12 to 15/3(iii)</td>
								<td><input type="text" name="upto16decLt" id="upto16decLt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto16DecLt}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="uptodecnp" id="uptodecnp"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.uptodecNp}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							
							<tr>
								<td>iv- 16/3 to 31/3(iv)</td>
								<td><input type="text" name="upto31Lt" id="upto31Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto31Lt}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
								<td><input type="text" name="upto31np" id="upto31np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto31Np}"/></c:if>"
									class="decimal" maxlength="15">
								</td>
							</tr>
						</table>
					</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span3 offset10">
						<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
						&nbsp; <a id="myModalHrefcapitalast" role="button"
							class="btn orange">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">
					<th><b style="color: olive;">Type of Asset </b>
					</th>
					<th><b style="color: olive;"><fmt:message
								key="capital.gain.cost.acquisition" /> </b>
					</th>
					<th><b style="color: olive;"><fmt:message
								key="capital.gain.sale.consideration" /> </b>
					</th>
					<th><b style="color: olive;">Long Term Gain </b>
					</th>
					<th><b style="color: olive;">Short Term Gain </b>
					</th>
					<th><b style="color: olive;">Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.capitalAssetDetailList}"
						var="capitalassetdetail">
						<tr>
							<td align="right"><c:out
									value="${capitalassetdetail.assetType}" />
							</td>
							<td align="right"><c:out
									value="${capitalassetdetail.costAcquisition}" />
							</td>
							<td align="right"><c:out
									value="${capitalassetdetail.saleConsideration}" />
							</td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail.capitalGainTaxLT}" />
							</td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail.capitalGainTaxST}" />
							</td>
							<td><a
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/edit"><small><i
										class="icon-pencil"></i>Edit</small> </a>&nbsp;&nbsp;<a
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/delete"
								onclick="return checkdelete()"> <small><i
										class="icon-trash"></i>Delete</small> </a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/new" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<res:calc screenCalc="capitalasset" formId="capitalassetfrm"></res:calc>
<res:client-validation formId="capitalassetfrm"
	screenConfigurationDocumentName="capitalasset"
	formSubmitButtonId="myModalHrefcapitalast" />
<script type="text/javascript">
	$('#asset_type').change(function() {
		var d = $('#asset_type').val();
		if (d == 'SHARES') {
			$("#sst_charge").show();
			$("#sst").show();
		} else {
			$("#sst_charge").hide();
			$("#sst").hide();
		}
	});

	$('#index').change(function() {
		if ($(this).val() == 'Y') {
			$('.with_' + $(this).val() + '_index').show();
			$('.without_' + $(this).val() + '_index').hide();
		} else {
			$('.with_' + $(this).val() + '_index').hide();
			$('.without_' + $(this).val() + '_index').show();
		}
	});

	$('#date_acquisition').change(function() {
		var data = $('#date_acquisition').val();
		var arr = data.split('/');
	});

	$('#sst_charge').change(function() {
		var d = document.getElementById("sst_charge");
		var valuePropCoOwned = d.options[d.selectedIndex].value;
		if (valuePropCoOwned == "N") {
			$("#dedsec54").show();
			$("#ded").show();

		} else {
			$("#dedsec54").hide();
			$("#ded").hide();
		}
	});
	$('#date_sale,#date_acquisition').change(function() {
		var a;
		var b;
		a = document.getElementById("date_acquisition").value;
		//alert("" + a);
		b = document.getElementById("date_sale").value;
		document.getElementById("months").value = datediff(a, b);
		document.getElementById("shortterms").value = decidegaintype();
		function decidegaintype() {
			var c = document.getElementById("months").value;
			//alert("" + c);
			if (c <= 365) {
				//$("#shortterms").show();
				//$("#longterms").hide();
				$('#fd_set_gain').show();
				$(".st").show();
				$(".with_Y_index").hide();
				$(".without_N_index").show();
				$(".lt").hide();
			} else {
				//$("#shortterms").show();
				//$("#longterms").show();
				$(".with_Y_index").hide();
				$('#fd_set_gain').show();
				$(".st").hide();
				$(".lt").show();

			}
		}
		function dstrToUTC(ds) {
			var dsarr = ds.split("/");
			var dd = parseInt(dsarr[0], 10);
			var mm = parseInt(dsarr[1], 10);
			var yy = parseInt(dsarr[2], 10);
			return Date.UTC(yy, mm - 1, dd, 0, 0, 0);
		}
		$(document).ready(function(){
			<c:if test="${pageAction == 'EDIT_CHILD'}">
			  $('#fd_set_gain').show();
			</c:if>
		});
		function datediff(ds1, ds2) {
			var d1 = dstrToUTC(ds1);
			var d2 = dstrToUTC(ds2);
			var oneday = 86400000;
			return (d2 - d1) / oneday;
		}
	});
	$("#accural_info").on('change',function(){
		if($(this).val()=='Y'){
			$('#accural_gain').show();
		}else{
			$('#accural_gain').hide();
		}		
	});
</script>