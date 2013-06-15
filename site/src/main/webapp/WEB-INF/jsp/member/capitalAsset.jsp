<%@include file="../includes/tags.jspf"%>
<%@include file="../includes/commonincludes.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.CapitalAssetDetail"%>
<%@page import="com.mootly.wcm.beans.CapitalAssetDocument"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
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
	TreeMap objHashMapBoolean = (TreeMap) objValueListService
			.getBoolean();
	request.setAttribute("objHashMapBoolean", objHashMapBoolean);
%>

<script type="text/javascript">
var $m = jQuery.noConflict(true);
	/*$m(document).ready(function() {
		var checkF = $m("#consideration").val();
		if (checkF != null) {
			$m("#drop1").val(checkF);
			var checkE = $m("#inflation").val();
			$m("#drop").val(checkE);
		}

	});*/
	function getautoindex() {
		var option = document.getElementById("date_acquisition");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$m("#inflation_acquisition").val(a);
		}
	}
	function getautoindex1() {
		var option = document.getElementById("date_sale");
		var stateName = option.options[option.selectedIndex].value;
		if (stateName != null) {
			var a = stateName;
			$m("#inflation_consideration").val(a);
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
			<c:otherwise>Capital Gains</c:otherwise>
		</c:choose>
	</h3>
	<h4>
		<fmt:message key="Capital.gain.Income.Screen" />
	</h4>

	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">

			<form id="capitalasset" action="${actionUrl}" method="post"
				name="capitalasset">
				<%-- <input type="hidden" name="hidDateAcquisition"
					id="hidDateAcquisition" value=" " /> <input type="hidden"
					name="hidDateSale" id="hidDateSale" value=" " />--%>

				<fieldset>
					<legend>Enter Details</legend>


					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for="date_acquisition"><small><fmt:message
											key="capital.gain.date.acquisition" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select id="date_acquisition" name="date_acquisition"
									onchange="getautoindex()">
									<option value="">-Select-</option>
									<c:forEach var="index" items="${objHashMapindex}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' || childBean.state == booleanCombo.key}">selected</c:if>
											value="${index.key}">${index.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="inflation_acquisition"><small>Cost
										Inflation Index (Purchase)</small> </label>
							</div>
							<div class="rowlabel">
								<input id="inflation_acquisition" name="inflation_acquisition"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									type="text" readonly="readonly">

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
									id="cost" maxlength="14" class="decimal"
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
									<c:forEach var="index" items="${objHashMapindex}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' || childBean.state == booleanCombo.key}">selected</c:if>
											value="${index.key}">${index.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="inflation_consideration"><small>Cost
										Inflation Index(Sell) </small> </label>
							</div>
							<div class="rowlabel">
								<input id="inflation_consideration"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.costAcquisition}"/></c:if>"
									name="inflation_consideration"  type="text">

							</div>
						</div>
						<%--<div class="span4">
						<div class="rowlabel">
							<label for="sale_consideration"><small><fmt:message
										key="capital.gain.sale.consideration" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input type="text" name="sale_consideration" id="sale"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.saleConsideration}"/></c:if>"
								class="decimal" title="Please fill only Numeric value"
								placeholder="" />

						</div>
					</div> --%>
						<div class="span4">
							<div class="rowlabel">
								<label for="sale_consideration"><small>Cost of
										Sale </small> </label>
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
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.capital_gain}"/></c:if>"
									placeholder="Indexed Purchase Price">

							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for="capital_gain"><small>Capital Gain </small> </label>
							</div>
							<div class="rowlabel">
								<input type="text" name="capital_gain" id="capital_gain"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.capital_gain}"/></c:if>"
									class="decimal" title="Please fill only Numeric value"
									placeholder="Please fill only Numeric value" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span2 offset10">
							<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
							<input type="submit" value="Save" style="color: orange">
						</div>
					</div>
				</fieldset>
			</form>

		</c:when>
		<c:otherwise>
			<table>
				<tr align="center">


					<th><b><fmt:message key="capital.gain.date.acquisition" />
					</b></th>
					<th><b><fmt:message key="capital.gain.cost.acquisition" />
					</b></th>
					<th><b><fmt:message key="capital.gain.date.sale" /> </b></th>
					<th><b><fmt:message key="capital.gain.sale.consideration" />
					</b></th>
					<th><b><fmt:message key="capital.gain" /> </b></th>
					<th><b><fmt:message key="capital.gain.long" /> </b></th>
					<th><b>Actions</b></th>

				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.capitalAssetDetailList}"
						var="capitalassetdetail">
						<tr>
							<td><c:out value="${capitalassetdetail.dateAcquisition}" />
							</td>
							<td><c:out value="${capitalassetdetail.costAcquisition}" />
							</td>
							<td><c:out value="${capitalassetdetail.dateSale}" /></td>
							<td><c:out value="${capitalassetdetail.saleConsideration}" />
							</td>
							<td><c:out value="${capitalassetdetail.capitalGain}" /></td>
							<td><c:out value="${capitalassetdetail.capitalGainTaxLT}" />
							</td>

							<td><a
								href="${redirectURLToSamePage}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/edit"><small>Edit</small>
							</a>&nbsp;&nbsp;<a
								href="${redirectURLToSamePage}/<c:out value="${capitalassetdetail.canonicalUUID}"/>/delete"><small>Delete</small>
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<a href="${redirectURLToSamePage}/new" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<res:calc screenCalc="capitalgains" formId="capitalasset"></res:calc>