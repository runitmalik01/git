<%@page import="com.mootly.wcm.model.InflationIndex"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.CapitalAssetDetail"%>
<%@page import="com.mootly.wcm.beans.CapitalAssetDocument"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.model.FilingSection"%>
<c:set var="capitalasset">
	<fmt:message key="member.capital.title" />
</c:set>
<hippo-gogreen:title title="${capitalasset}" />
<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
<hst:actionURL var="actionUrl"></hst:actionURL>
<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
TreeMap<String,String> objHashMapindex  = objValueListService.getInflationIndex();
request.setAttribute("objHashMapindex", objHashMapindex);
pageContext.setAttribute("inflationindexValues", InflationIndex.values());
%>

<script type="text/javascript">
	//var $m = jQuery.noConflict(true);
	function getautoindex() {
		var option = document.getElementById("date_acquisition");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$("#inflation_acquisition").val(a);
		}
	}
	function getautoindex1() {
		var option = document.getElementById("date_sale");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$("#inflation_consideration").val(a);
		}
	}
</script>
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
					<legend>Enter Details</legend>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="asset_type"><small>Asset Type </small> </label>
							</div>
							<div class="rowlabel">
								<select id="asset_type" name="asset_type">
									<option value="">-Select-</option>
									<option value="SHARES" <c:if test="${not empty childBean.assetType && childBean.assetType =='SHARES'}">selected</c:if>>Listed Shares/Debentures/Bond/
										Unit of Mutual Fund etc</option>
									<option value="OTH"<c:if test="${not empty childBean.assetType && childBean.assetType =='OTH'}">selected</c:if>>Other than above</option>
								</select>
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="name_asset"><small><fmt:message
											key="capital.gain.name.asset" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="name_asset" name="name_asset"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nameAsset}"/></c:if>"
									type="text">

							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="date_acquisition"><small><fmt:message
											key="capital.gain.date.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="date_acquisition" name="date_acquisition"
									onchange="getautoindex()" >
									<option value="">-Select-</option>
									<c:forEach items="${inflationindexValues}" var="fs">
										<c:if test="${fs != 'UNKNOWN'}">
											<option value='<c:out value="${fs.xmlCode}"/>'>
												<c:out value="${fs.displayString}"  />
											</option>
										</c:if>
										<c:out value="${childBean.dateAcquisition}" />
									</c:forEach>
									<%-- <c:forEach var="index" items="${objHashMapindex}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' || childBean.dateAcquisition == booleanCombo.value}">selected</c:if>
											value="${index.key}">${index.value}</option>--%>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="inflation_acquisition"><small><fmt:message
											key="capital.gain.cost.inflationp" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="inflation_acquisition" name="inflation_acquisition"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costIndexAcquisition}"/></c:if>"
									type="text">

							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="cost_acquisition"><small><fmt:message
											key="capital.gain.cost.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="cost_acquisition" name="cost_acquisition" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value"
									placeholder=" Cost Price" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="cost_improvement"><small><fmt:message
											key="capital.gain.cost.improvement" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="cost_improvement" name="cost_improvement" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costImprovement}"/></c:if>"
									maxlength="14" class="decimal"
									title="Please fill only Numeric value"
									placeholder=" Cost Price" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="date_sale"><small><fmt:message
											key="capital.gain.date.sale" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="date_sale" name="date_sale"
									onchange="getautoindex1()">
									<option value="">-Select-</option>
									<c:forEach items="${inflationindexValues}" var="fs">
										<c:if test="${fs != 'UNKNOWN'}">
											<option value='<c:out value="${fs.xmlCode}"/>'>
												<c:out value="${fs.displayString}" />
											</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>


						<div class="span4">
							<div class="rowlabel">
								<label for="inflation_consideration"><small> <fmt:message
											key="capital.gain.cost.inflations" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="inflation_consideration"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costIndexConsideration}"/></c:if>"
									name="inflation_consideration" type="text">

							</div>
						</div>


						<div class="span4">
							<div class="rowlabel">
								<label for="sale_consideration"><small><fmt:message
											key="capital.gain.sale.consideration" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" name="sale_consideration"
									id="sale_consideration"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>"
									class="decimal" placeholder="Cost at the time of Sale"
									title="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="indexed_price"><small>Indexed
										Purchase Price </small> </label>
							</div>
							<div class="rowlabel">
								<input id="indexed_price" name="indexed_price" class="decimal"
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number" 
            maxIntegerDigits="14" value="${childBean.indexedprice}"/></c:if>"
									placeholder="Indexed Purchase Price">

							</div>
						</div>


						<div class="span4">
							<div class="rowlabel">
								<label for="capital_gain"><small>Capital Gain </small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" name="capital_gain" id="capital_gain"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<fmt:formatNumber type="number" 
            maxIntegerDigits="14" value="${childBean.capitalGain}"/></c:if>"
									class="decimal" title="Please fill only Numeric value"
									placeholder="Please fill only Numeric value" />

							</div>
						</div>


						<div class="span4">
							<div class="rowlabel">
								<label for="sst_charge"><small>Whether SST
										Charged </small> </label>
							</div>
							<div class="rowlabel">
								<select id="sst_charge" name="sst_charge">
									<option value="">-Select-</option>
									<option value="Y" <c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='Y'}">selected</c:if>>YES</option>
									<option value="N" <c:if test="${not empty childBean.sstCharge && childBean.sstCharge =='N'}">selected</c:if>>NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span2 offset10">
							<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
							<input type="submit" value="Save" style="color: orange"
								id="myModalHrefcapitalast">
						</div>
					</div>
				</fieldset>
			</form>
		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">


					<th><b>Type of Asset
					</b>
					</th>
					<th><b><fmt:message key="capital.gain.cost.acquisition" />
					</b>
					</th>
					<th><b><fmt:message key="capital.gain.sale.consideration" />
					</b>
					</th>
					<th><b><fmt:message key="capital.gain" /> </b>
					</th>
					<th><b>Actions</b>
					</th>

				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.capitalAssetDetailList}"
						var="capitalassetdetail">
						<tr>
							<td align="right"><c:out value="${capitalassetdetail.assetType}" />
							</td>
							<td align="right"><c:out value="${capitalassetdetail.costAcquisition}" />
							</td>
							<td align="right"><c:out value="${capitalassetdetail.saleConsideration}" />
							</td>
							<td align="right"><fmt:formatNumber type="number" maxIntegerDigits="14"
									value="${capitalassetdetail.capitalGain}" />
							</td>

							<td><a
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/edit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${scriptName}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/delete"
								onclick="return checkdelete()"> <small>Delete</small> </a>
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
