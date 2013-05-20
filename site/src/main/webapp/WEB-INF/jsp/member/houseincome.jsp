<%--
@author Megha Agarwal
06/05/2013
 --%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="java.util.*"%>
<%@page import="com.mootly.wcm.beans.compound.HouseIncomeDetail"%>
<%@page import="com.mootly.wcm.member.HouseIncome"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	TreeMap objHashMapStates = (TreeMap) objValueListService
			.getStates();
	request.setAttribute("objHashMapStates", objHashMapStates);

	TreeMap objHashMapBoolean = (TreeMap) objValueListService
			.getBoolean();
	request.setAttribute("objHashMapBoolean", objHashMapBoolean);
%>
<c:set var="parentBeantitle">
	<fmt:message key="member.houseincome.title" />
</c:set>

<hippo-gogreen:title title="${parentBeantitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>House Income</c:otherwise>
		</c:choose>
	</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>

	<c:choose>
		<c:when
			test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">

			<h4>Property Income</h4>
			<form id="frmdataHouseIncome" action="${actionUrl}" method="post"
				name="housefrm">
				<fieldset>
					<legend>Property Details</legend>
					<div class="row-fluid show-grid">
						<div class="span3">
							<div class="rowlabel">
								<label for=""><small>Address</small> </label>
							</div>
							<div>
								<input id="Address" name="Address" placeholder="Address"
									type="text" maxLength="200"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />

							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for=""><small>Town/City/District</small> </label>
							</div>
							<div>
								<input id="City" name="City" placeholder="Town/City/District"
									type="text" maxlength="50"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
							</div>
						</div>


						<div class="span3">
							<div class="rowlabel">
								<label for=""><small>State</small> </label>
							</div>
							<div>
								<c:set var="searchresultstitle">
									<fmt:message key="member.contact_info.state.select" />
								</c:set>
								<c:set var="statesType">
									<fmt:message key="dropdown.states" />
								</c:set>
								<w4india:dropdown dropDownSelectId="State"
									optionSelectString="${searchresultstitle}"
									dropDownType="${statesType}" fetchValue="${childBean.states}" />
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for=""><small>PIN Code</small> </label>
							</div>
							<div>
								<input id="Pin" type="text" class="numberinput" name="Pin"
									maxlength="6"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.pin}"/></c:if>" />

							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span4">
							<div class="rowlabel">
								<label for=""><small>Is the property let out?</small> </label>
							</div>
							<div>
								<select name="letout" id="letout">
									<option value="">-Select-</option>
									<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.letOut == booleanCombo.value}">selected</c:if>
											value="${booleanCombo.value}">${booleanCombo.value}</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for=""><small>Tenant Name</small> </label>
							</div>
							<div>
								<input id="Tenant_name" name="Tenant_name" maxlength="75"
									placeholder="Tenant Name" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tenant_name}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for=""><small>Tenant PAN</small> </label>
							</div>
							<div>
								<input id="Tenant_pan" name="Tenant_pan"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tenant_pan}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span6">
							<div class="rowlabel">
								<label for=""><small>Is the property co-owned?</small> </label>
							</div>
							<div>
								<select name="Coowned" id="coowned">
									<option value="">-Select-</option>
									<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.coowned == booleanCombo.value}">selected</c:if>
											value="${booleanCombo.value}">${booleanCombo.value}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="span6">
							<div class="rowlabel">
								<label for=""><small>Your percentage share in
										Property</small> </label>
							</div>
							<div>
								<input id="Property_share" name="Property_share" type="text"
									placeholder="Enter the % share by you in property"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.property_share}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>
						<abbr title="Is this property being owned by someone else">Ownership
							Details</abbr>
					</legend>
					<div class="row-fluid show-grid">
						<div class="span1">
							<div class="rowlabel decimal">
								<label for=""><small>S.No</small> </label>
							</div>
							<div class="decimal">1.</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for=""><small>Name of Co-owner</small> </label>
							</div>
							<div>
								<input id="coownername1" name="coownername1"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername1}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div class="rowlabel">
								<label for=""><small>PAN of the Co-owner</small> </label>
							</div>
							<div>
								<input id="coownerpan1" name="coownerpan1"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan1}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div class="rowlabel">
								<label for=""><small><abbr
										title="Percentage Share In Property">Share (%)</abbr> </small> </label>
							</div>
							<div>
								<input id="share1" name="share1" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share1}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span1">
							<div class="decimal">2.</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownername2" name="coownername2"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername2}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownerpan2" name="coownerpan2"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan2}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div class="decimal">
								<input id="share2" name="share2" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share2}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span1">
							<div class="decimal">3.</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownername3" name="coownername3"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername3}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownerpan3" name="coownerpan3"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan3}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div>
								<input id="share3" name="share3" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share3}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span1">
							<div class="decimal">4.</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownername4" name="coownername4"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername4}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownerpan4" name="coownerpan4"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan4}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div>
								<input id="share4" name="share4" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share4}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span1">
							<div class="decimal">5.</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownername5" name="coownername5"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername5}"/></c:if>" />
							</div>
						</div>
						<div class="span4">
							<div>
								<input id="coownerpan5" name="coownerpan5"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan5}"/></c:if>" />
							</div>
						</div>
						<div class="span3">
							<div>
								<input id="share5" name="share5" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share5}"/></c:if>" />
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Property Income Details</legend>
					<div class="row-fluid show-grid letout_Yes_v letout_No_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>a.</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>Annuable letable value/rent
										received or receivable</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Letable_value" name="Letable_value" placeholder="Rs."
									class="letout_Yes_inv letout_No_inh" type="text" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.letable_value}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_Yes_v letout_No_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>b.</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>The amount of rent which
										cannot be realized</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Unrealised_rent" name="Unrealised_rent"
									class="letout_Yes_inv letout_No_inh" placeholder="Rs."
									type="text" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.unrealised_rent}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_Yes_v letout_No_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>c.</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>Tax paid to local
										authorities</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Local_tax" name="Local_tax" placeholder="Rs."
									class="letout_Yes_inv letout_No_inh" type="text" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.local_tax}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>d</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>Interest on Borrowed
										Capital</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Interest_borrowed" name="Interest_borrowed"
									class="letout_Yes_inv letout_No_inh" placeholder="Rs."
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.interest_borrowed}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_Yes_v letout_No_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>e</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>Balance</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Total" name="Total" placeholder="Rs." type="text"
									class="letout_Yes_inv letout_No_inh"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.total}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>
					<div class="row-fluid show-grid letout_Yes_v letout_No_h"
						style="dispaly: none;">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>f</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>30% of e</small> </label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Balance" name="Balance" placeholder="Rs." type="text"
									class="letout_Yes_inv letout_No_inh"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.balance}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>

					<div class="row-fluid show-grid">
						<div class="span1 decimal">
							<div class="rowlabel">
								<small>g</small>
							</div>
						</div>
						<div class="span7 decimal">
							<div class="rowlabel">
								<label for=""><small>Income from House Property</small>
								</label>
							</div>
						</div>
						<div class="span2 offset1">
							<div>
								<input id="Income_hproperty" name="Income_hproperty"
									class="letout_Yes_inv letout_No_inh" placeholder="Rs."
									type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.income_hproperty}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>
				</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}?tab=houseincome" class="button olive">Cancel</a>&nbsp;
						<a id="myModalHrefHouseIncome" role="button" class="btn orange">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<!--  show the table -->
			<table>
				<tr align="center">
					<th><b>Property Let Out</b>
					</th>
					<th><b>Address</b>
					</th>
					<th><b>Ownership %</b>
					</th>
					<th><b>Income from House Property</b>
					</th>
					<th><b>Actions</b>
					</th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.houseIncomeDetailList}"
						var="houseincomedetail">
						<tr>
							<td><a
								href="${scriptName}/<c:out value="${houseincomedetail.canonicalUUID}"/>/houseincomeedit"><c:out
										value="${houseincomedetail.letOut}" /> </a>
							</td>
							<td><c:out value="${houseincomedetail.address}" />
							</td>

							<td><c:out value="${houseincomedetail.property_share}" />
							</td>
							<td><c:out value="${houseincomedetail.income_hproperty}" />
							</td>
							<td><a
								href="${scriptName}/<c:out value="${houseincomedetail.canonicalUUID}"/>/houseincomeedit"><small>Edit</small>
									<c:set var="canonicalUUID"
										value="${houseincomedetail.canonicalUUID}" /> <c:set
										var="scriptName" value="${scriptName}" /> </a>&nbsp;&nbsp;<a
								id="delete"><small>Delete</small> </a>
							</td>
						</tr>

					</c:forEach>

				</c:if>
			</table>
			<a href="${scriptName}/houseincomenew" class="button orange">Add
				New</a>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
	$('#letout').change(function() {
		$('.letout_' + $(this).val() + '_v').show();
		$('.letout_' + $(this).val() + '_h').hide();
		$('.letout_' + $(this).val() + '_inv').val('');
		$('.letout_' + $(this).val() + '_inh').val('');
	});
	$('#delete')
			.click(
					function() {
						var result = confirm("Do you want to delete permanently");
						if (result) {
							$('#delete')
									.attr(
											'href',
											'<c:out value="${scriptName}"/>/<c:out value="${canonicalUUID}"/>/houseincomedelete');
						}
					});
</script>
<res:client-validation formId="frmdataHouseIncome"
	screenConfigurationDocumentName="houseincome"
	formSubmitButtonId="myModalHrefHouseIncome" />
<res:calc screenCalc="houseincome" formId="frmdataHouseIncome"></res:calc>