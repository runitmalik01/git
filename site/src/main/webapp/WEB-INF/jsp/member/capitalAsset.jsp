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
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${capitalasset}" />
<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
<%
	pageContext.setAttribute("inflationindexValues",
			InflationIndex.values());
%>
<div class="page">
	<fmt:message key="Capital.gain.Income.Screen" var="title"/>
	<w4india:titleandnav title="${title}" subTitle="Schedule CG&nbsp;-&nbsp;A capital gain is a profit that results from a
				disposition of a capital asset, such as stock, bond or real estate,
				where the amount realized on the disposition exceeds the purchase
				price. The gain is the difference between a higher selling price and
				a lower purchase price.Conversely, a capital loss arises if the
				proceeds from the sale of a capital asset are less than the purchase
				price."></w4india:titleandnav>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="capitalassetfrm" action="${actionUrl}" method="post"
				name="capitalasset">
				<fieldset>
					<legend class="header-color">
						<small>Asset Information</small>
					</legend>
					<div align="center" style="color: red">Please enter your
						details</div>
					<br />


					<div class="row show-grid">

						<div class="col-md-3">
							<div class="rowlabel">
								<label for="asset_type"><small><fmt:message
											key="capital.gain.type.asset" /> </small> </label>
							</div>

							<div class="rowlabel">
								<select id="asset_type" name="asset_type" onChange="hidesst()"
									class="uprcase">
									<option value="">-Select-</option>
									<option value="SHARES"
										<c:if test="${not empty childBean.assetType && childBean.assetType =='SHARES'}">selected</c:if>>Listed
										Shares/Debentures/Bond/ Unit of Mutual Fund etc</option>
									<option value="OTH"
										<c:if test="${not empty childBean.assetType && childBean.assetType =='OTH'}">selected</c:if>>Other
										Asset</option>
									<c:if test="${itrform=='ITR4' }">
										<option value="SLUMP"
											<c:if test="${not empty childBean.assetType && childBean.assetType =='SLUMP'}">selected</c:if>>Slump
											Sale</option>
									</c:if>
								</select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="nameasset"><small><fmt:message
											key="capital.gain.name.asset" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="nameasset" name="nameasset" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nameAsset}"/></c:if>"
									type="text">
							</div>
						</div>
						<div class="col-md-3">
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
						<div class="col-md-3">
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
					</div>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="months"><small><fmt:message
											key="capital.gain.days" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" name="months" id="months" class="decimal"
									readonly="readonly" onblur="daycalculate()"
									value="<c:if test="${not empty childBean.months}">
								<c:out value="${childBean.months}"/></c:if>">
							</div>
						</div>
						<div class="col-md-4 st">
							<div class="rowlabel" id="sst">
								<label for="sst_charge"><small><fmt:message
											key="capital.gain.sst.charge" /> </small> </label>
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
					<legend class="hide st" id="sg" style="color: maroon">
						<small>Computation (Short Term Gain)</small>
					</legend>
					<legend class="hide lt" style="color: maroon;" id="lg">
						<small>Computation (Long Term Gain)</small>
					</legend>
					<c:if test="${status != 'RES'}">
						<div class="st" id="snri">
							<h2>
								<fmt:message key="capital.gain.nri.info" />
							</h2>
							<div class="row show-grid">
								<div class="col-md-9">
									<div class="rowlabel">
										<label for="asset111"><small><fmt:message
													key="capital.gain.nri.infoa" /> </small> </label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="rowlabel">
										<input id="asset111" name="asset111" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.asset_111}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
							<div class="row show-grid">
								<div class="col-md-9">
									<div class="rowlabel">
										<label for="assetnt111"><small><fmt:message
													key="capital.gain.nri.infob" /> </small> </label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="rowlabel">
										<input id="assetnt111" name="assetnt111" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.assetnt111}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${status != 'RES'}">
						<div class="lt" id="lnri">
							<div class="row show-grid">
								<div class="col-md-9">
									<div class="rowlabel">
										<label for="section48"><small><fmt:message
													key="capital.gain.nri.infosection" /> </small> </label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="rowlabel">
										<input id="section48" name="section48" class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.section48}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
							<div class="row show-grid">
								<div class="col-md-9">
									<div class="rowlabel">
										<label for="unlstdsecurity"><small><fmt:message
													key="capital.gain.nri.security" /> </small> </label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="rowlabel">
										<input id="unlstdsecurity" name="unlstdsecurity"
											class="decimal"
											value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.unlstdSecurity}"/></c:if>"
											type="text">
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<div class="row show-grid" id="lindex">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="index"><small><fmt:message
											key="capital.gain.index" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<select id="index" name="index">
									<option value="">-Select-</option>
									<option value="Y" style="border-right: olive;"
										<c:if test="${not empty childBean.index && childBean.index =='Y'}">selected</c:if>>YES</option>
									<option value="N"
										<c:if test="${not empty childBean.index && childBean.index =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="saleconsideration"><fmt:message
										key="capital.gain.sale.consider" /> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="saleconsideration"
									id="saleconsideration" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.saleConsideration}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row show-grid dateimp" id="imp">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="date_improve"><small><fmt:message
											key="capital.gain.date.imprv" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input id="date_improve" name="date_improve" type="text"
									value="<c:if test="${not empty childBean.dateimpStr}">
								<c:out value="${childBean.dateimpStr}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-9">
							<div class="rowlabel acq">
								<label for="costacquisition"><fmt:message
										key="capital.gain.cost.acquisition" /> </label>
							</div>
							<div class="rowlabel hide slmacq ">
								<label for="costacquisition"><small><fmt:message
											key="capital.gain.sale.slump" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3 ">
							<div class="rowlabel">
								<input id="costacquisition" name="costacquisition" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</diV>
					<div class="row show-grid hide slump">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="cgSlump"> <fmt:message
										key="capital.gain.slump" />
								</label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="cgSlump" id="cgSlump"
									readonly="readonly"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.cgSlump}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row show-grid cstimp">
						<div class="col-md-9">
							<div class="rowlabel without_Y_index without_N_index">
								<label for="costimprovement"><small><fmt:message
											key="capital.gain.cost.improvement" /> </small> </label>
							</div>
							<div class="rowlabel hide with_Y_index with_N_index ">
								<label for="costimprovement"><small><fmt:message
											key="capital.gain.imprv.index" /> </small> </label>

							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input id="costimprovement" name="costimprovement" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costImprovement}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>

					<div class="row show-grid csttrsfr">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="costtrnsfr"><small><fmt:message
											key="capital.gain.cost.trnsfr" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input id="costtrnsfr" name="costtrnsfr" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costTransfer}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<div class="row show-grid bal">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="balanc"><fmt:message
										key="capital.gain.balance" /> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="balanc" id="balanc"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number"  maxIntegerDigits="14" value="${childBean.balance}"/></c:if>"
									class="decimal" readonly="readonly" />

							</div>
						</div>
					</div>
					<div class="row show-grid st" id="loss">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="losssec94"><small><fmt:message
											key="capital.gain.loss" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="losssec94" id="losssec94"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.loss_sec94}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row show-grid" id="ded">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="dedsec54"><fmt:message
										key="capital.gain.deduction" /> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="dedsec54" id="dedsec54" maxlength="14" 
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number"  maxIntegerDigits="14" value="${childBean.ded_sec54}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row show-grid hide slump">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="netCGSlump"> <fmt:message
										key="capital.gain.slump.net" />
								</label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="netCGSlump" id="netCGSlump"
									readonly="readonly"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.netCGSlump}"/></c:if>"
									class="decimal" title="Please fill only Numeric value" />
							</div>
						</div>
					</div>
					<c:if test="${itrform=='ITR4' }">
						<div class="row show-grid amtdmdsc">
							<div class="col-md-9">
								<div class="rowlabel">
									<label for="amtdeemedsc"><small> <fmt:message
												key="capital.amt.deemed.schedule6" />
									</small> </label>
								</div>
							</div>
							<div class="col-md-3">
								<div class="rowlabel">
									<input id="amtdeemedsc" name="amtdeemedsc" readonly="readonly"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtdeemedsc}"/></c:if>"
										type="text" class="decimal" />
								</div>
							</div>
						</div>
					</c:if>
					<div class="row show-grid amtdmd">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="amtdeemed"><small><fmt:message
											key="capital.gain.amt.deemed" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input id="amtdeemed" name="amtdeemed"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.amtdeemed}"/></c:if>"
									type="text" class="decimal" />
							</div>
						</div>
					</div>
					<div class="row show-grid" id="pan">
						<div class="col-md-9 lt">
							<div class="rowlabel">
								<label for="panifded"><small><fmt:message
											key="capital.gain.pan" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3 lt">
							<div class="rowlabel">
								<input type="text" name="panifded" id="panifded"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.pan}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row show-grid cpgain">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="capitalgain"><fmt:message
										key="capital.gain.cpgain" /> </label>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<input type="text" name="capitalgain" id="capitalgain"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number"  maxIntegerDigits="14" value="${childBean.capitalGain}"/></c:if>"
									class="decimal" readonly="readonly" />
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend class="header-color">
						<small><fmt:message key="capital.gain.acc.message" /></small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-9">
							<div class="rowlabel">
								<label for="accural_info"><small><fmt:message
											key="capital.gain.acc.option" /> </small> </label>
							</div>
						</div>
						<div class="col-md-3">
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
								<th style="color: black;" width="50%">(In case of short
									term gain only) Dates:</th>
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
									class="decimal" maxlength="15"></td>
							<tr>

								<td>iii- 16/12 to 15/3(iii)</td>
								<td><input type="text" name="upto16decst" id="upto16decst"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16decSt}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto16decoth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16DecOth}"/></c:if>"
									class="decimal" id="upto16decoth" maxlength="15"></td>
							<tr>
								<td>iv- 16/3 to 31/3(iv)</td>
								<td><input type="text" name="upto31st" id="upto31st"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto31St}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto31oth" id="upto31oth"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto31Oth}"/></c:if>"
									class="decimal" maxlength="15"></td>
							</tr>
							<tr>
								<th width="50%" style="color: black;">(In case of long term
									gain only)Dates:</th>
								<th style="color: black;">LTCG proviso</th>
								<th style="color: black;">LTCG NO proviso</th>
							</tr>
							<tr>
								<td>i- Upto 15/9(i)</td>
								<td><input type="text" name="upto15Lt" id="upto15Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15Lt}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto15np" id="upto15np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto15Np}"/></c:if>"
									class="decimal" maxlength="15"></td>
							<tr>
								<td>ii- 16/9 to 15/12(ii)</td>
								<td><input type="text" name="upto16Lt" id="upto16Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16Lt}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto16np" id="upto16np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.upto16Np}"/></c:if>"
									class="decimal" maxlength="15"></td>
							<tr>
								<td>iii- 16/12 to 15/3(iii)</td>
								<td><input type="text" name="upto16decLt" id="upto16decLt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto16DecLt}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="uptodecnp" id="uptodecnp"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.uptodecNp}"/></c:if>"
									class="decimal" maxlength="15"></td>
							<tr>
								<td>iv- 16/3 to 31/3(iv)</td>
								<td><input type="text" name="upto31Lt" id="upto31Lt"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto31Lt}"/></c:if>"
									class="decimal" maxlength="15"></td>
								<td><input type="text" name="upto31np" id="upto31np"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								<c:out value="${childBean.upto31Np}"/></c:if>"
									class="decimal" maxlength="15"></td>
							</tr>
						</table>
					</div>
				</fieldset>
				<div class="row show-grid">
					<div class="col-md-3 col-md-offset-10">
						<a href="${redirectURLToSamePage}"
							class="btn btn-default btn-danger">Cancel</a> &nbsp; <a
							id="myModalHrefcapitalast" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th width="10%"><b>Type of Asset </b></th>
					<th width="15%"><b>Name of Asset </b></th>
					<th width="15%"><b><fmt:message
								key="capital.gain.cost.acquisition" /> </b></th>
					<th width="15%"><b><fmt:message
								key="capital.gain.sale.consideration" /> </b></th>
					<th width="12%"><b>Long Term Gain </b></th>
					<th width="12%"><b>Short Term Gain </b></th>
					<th width="20%"><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.capitalAssetDetailList}"
						var="capitalassetdetail">
						<tr><td align="right"><c:out
									value="${capitalassetdetail.assetType}" /></td>
							<td align="right"><c:out
									value="${capitalassetdetail.nameAsset}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail. costAcquisition}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail.saleConsideration}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail.capitalGainTaxLT}" /></td>
							<td align="right"><fmt:formatNumber type="number"
									maxIntegerDigits="14"
									value="${capitalassetdetail.capitalGainTaxST}" /></td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/edit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/delete"
								id="delete" data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/new"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
<res:calc screenCalc="capitalasset" formId="capitalassetfrm"></res:calc>
<res:client-validation formId="capitalassetfrm"
	screenConfigurationDocumentName="capitalasset"
	formSubmitButtonId="myModalHrefcapitalast" />
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



<script type="text/javascript">
	$(document).ready(function() {
		var type = $('#asset_type').val();
		var day = $('#months').val();

		if (type == 'SLUMP') {
			if (day <= 1096) {
				$('#fd_set_gain').show();
				$(".slump").show();
				$(".amtdmdsc").hide();
				$(".cstacq").hide();
				$("#imp").hide();
				$("#sst").hide();
				$("#sst_charge").hide();
				$(".amtdmd").hide();
				$(".csttrsfr").hide();
				$(".bal").hide();
				$(".cpgain").hide();
				$("#pan").hide();
				$(".cstimp").hide();
				$("#sg").show();
				$("#lg").hide();
				$("#loss").hide();
				$("#lindex").hide();
			} else {
				$('#fd_set_gain').show();
				$(".slump").show();
				$("#sst_charge").hide();
				$("#sst").hide();
				$(".cstacq").hide();
				$(".amtdmdsc").hide();
				$("#imp").hide();
				$(".amtdmd").hide();
				$(".csttrsfr").hide();
				$(".bal").hide();
				$(".cpgain").hide();
				$("#pan").hide();
				$(".cstimp").hide();
				$("#sg").hide();
				$("#lg").show();
				$("#loss").hide();
				$("#lindex").hide();
			}
		}

		if (type == 'SHARES') {
			day = $('#months').val();
			var stt = $('#sst_charge').val();
			if (stt == 'N') {
				$("#ded").show();
			} else {
				$("#ded").hide();
			}
			if (day < 366) {
				$("#lnri").hide();
				$("#index").hide();
				$("#sg").show();
				$("#lindex").hide();
				$("#pan").hide();
				$("#imp").hide();
				$(".amtdmdsc").hide();
			} else {
				if (stt == 'Y') {
					$("#pan").hide();
					$("#imp").hide();
					$("#ded").hide();
					$("#lindex").hide();
				} else {
					$("#lindex").show();
					$("#imp").show();
				}
				$("#loss").hide();
				$("#lg").show();
				$("#lnri").show();
				$("#snri").hide();
				$("#sg").hide();
				$(".amtdmdsc").hide();
			}
			$("#sst").show();
			$("#sst_charge").show();
		}
		if (type == 'OTH') {
			if (day <= 1096) {

				$(".st").show();
				$("#imp").hide();
				$("#lg").hide();
				$("#sg").show();
				$(".with_Y_index").hide();
				$(".without_N_index").show();
				$(".lt").hide();
				$("#sst").hide();
				$(".amtdmdsc").show();

			} else {
				$("#loss").hide();
				$("#lg").show();
				$("#sg").hide();
				$("#imp").show();
				$(".with_Y_index").hide();
				$(".lt").show();
				$("#sst").hide();
				$(".amtdmdsc").hide();
			}

			$("#lindex").hide();
			$("#sst_charge").hide();
		}
		var acc = $('#accural_info').val();
		if (acc == 'Y') {
			$('#accural_gain').show();
		} else {
			$('#accural_gain').hide();
		}

	});

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
	$('#date_improve')
			.change(
					function() {
						var imp = $('#date_improve').val();
						var acq = $('#date_acquisition').val();
						if (new Date(imp).getTime() > new Date(acq).getTime()) {
						} else {
							alert("Date of improvement can't be before then date of acquisition, Please choose right date of improvement");
							document.getElementById("date_improve").value = $(
									'#date_sale').val();
							;
						}

					});
	$('#date_sale,#date_acquisition,#sst_charge').change(function() {
		var a;
		var b;
		a = document.getElementById("date_acquisition").value;
		b = document.getElementById("date_sale").value;
		document.getElementById("months").value = datediff(a, b);
		document.getElementById("shortterms").value = decidegaintype();
		function decidegaintype() {
			var c = document.getElementById("months").value;
			var m = document.getElementById("asset_type").value;
			if (m == 'SLUMP') {
				if (c <= 1096) {
					$('#fd_set_gain').show();
					$("#lindex").hide();
					$(".slump").show();
					$(".acq").hide();
					$(".slmacq").show();
					$("#imp").hide();
					$(".amtdmd").hide();
					$(".csttrsfr").hide();
					$(".bal").hide();
					$(".cpgain").hide();
					$("#pan").hide();
					$(".cstimp").hide();
					$("#sg").show();
					$("#lg").hide();
					$("#loss").hide();
					$(".amtdmdsc").hide();
				} else {
					$('#fd_set_gain').show();
					$(".slump").show();
					$("#lindex").hide();
					$(".acq").hide();
					$(".slmacq").show();
					$("#imp").hide();
					$(".amtdmd").hide();
					$(".csttrsfr").hide();
					$(".bal").hide();
					$(".cpgain").hide();
					$("#pan").hide();
					$(".cstimp").hide();
					$("#sg").hide();
					$("#lg").show();
					$("#loss").hide();
					$(".amtdmdsc").hide();
				}
			}

			if (m == "SHARES") {
				if (c <= 365) {
					$('#fd_set_gain').show();
					$(".st").show();
					$("#lg").hide();
					$("#sg").show();
					$(".with_Y_index").hide();
					$(".without_N_index").show();
					$(".lt").hide();
					$("#imp").hide();
					$(".amtdmdsc").hide();
				} else {
					var sst = $("#sst_charge").val();
					if (sst == 'N') {
						$("#lindex").show();
						$("#imp").show();
						$("#pan").show();
					} else {
						$("#pan").hide();
						$("#imp").show();
						$("#ded").hide();
						$("#lindex").hide();
					}
					$("#lg").show();
					$("#sg").hide();
					$("#loss").hide();
					$(".with_Y_index").hide();
					$('#fd_set_gain').show();
					$(".lt").show();
					$("#sst").show();
					$(".amtdmdsc").hide();
				}
			}
			if (m == 'OTH') {
				if (c <= 1096) {
					$('#fd_set_gain').show();
					$(".st").show();
					$("#imp").hide();
					$("#lg").hide();
					$("#sg").show();
					$(".with_Y_index").hide();
					$(".without_N_index").show();
					$(".lt").hide();
					$("#sst").hide();
					$(".amtdmdsc").show();
				} else {

					$("#loss").hide();
					$("#lg").show();
					$("#sg").hide();
					$('#fd_set_gain').show();
					$("#imp").show();
					$(".with_Y_index").hide();
					$(".lt").show();
					$("#sst").hide();
					$("#lindex").hide();
					$(".amtdmdsc").hide();

				}
			}
		}
		function dstrToUTC(ds) {
			var dsarr = ds.split("/");
			var dd = parseInt(dsarr[0], 10);
			var mm = parseInt(dsarr[1], 10);
			var yy = parseInt(dsarr[2], 10);
			return Date.UTC(yy, mm - 1, dd, 0, 0, 0);
		}

		$(document).ready(function() {
			<c:if test="${pageAction == 'EDIT_CHILD'}">
			$('#fd_set_gain').show();
			</c:if>
		});
		function datediff(ds1, ds2) {
			var d1 = dstrToUTC(ds1);
			var d2 = dstrToUTC(ds2);
			var oneday = 86400000;
			var e = (d2 - d1) / oneday;
			if (e < 0) {
				alert("days can't be negative change your date");
				return 0;
			}
			return e;

		}

	});
	$("#accural_info").on('change', function() {
		if ($(this).val() == 'Y') {
			$('#accural_gain').show();
		} else {
			$('#accural_gain').hide();
		}
	});
	/*
	$("#costacquisition").on(
			'change',
			function() {
				var imp = $('#date_improve').val();
				if (imp == '') {
					document.getElementById("date_improve").value = $(
							'#date_sale').val();
				}
			});
	*/
</script>