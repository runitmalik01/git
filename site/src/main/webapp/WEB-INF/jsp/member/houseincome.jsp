<%--
@author Megha Agarwal
06/05/2013
 --%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
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
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
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
	<w4india:itrmenu></w4india:itrmenu>
	<h3 id="respond1">
		<c:choose>
			<c:when
				test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
				<c:out value="${screenConfigDocument.screenHeading}" />
			</c:when>
			<c:otherwise>
				<h2 class="page-title">House Income</h2>
			</c:otherwise>
		</c:choose>
	</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>

	<c:choose>
		<c:when
			test="${pageAction == 'NEW_CHILD' || pageAction == 'EDIT_CHILD'}">

			<form id="frmdataHouseIncome" action="${actionUrl}" method="post"
				name="housefrm">
				<fieldset>
					<legend class="header-color">
						<small>Property Details</small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="Address"><small>Address</small> </label>
							</div>
							<div>
								<input id="Address" name="Address" placeholder="Address"
									class="uprcase" type="text" maxLength="200"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />

							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="City"><small>Town/City/District</small> </label>
							</div>
							<div>
								<input id="City" name="City" placeholder="Town/City/District"
									type="text" maxlength="50" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="states"><small><fmt:message
											key="member.salary.state" /></small></label>
							</div>
							<div class="rowlabel">
								<select id="states" name="states" class="uprcase">
									<option value="">-Select-</option>
									<c:forEach var="booleanCombo" items="${objHashMapstates}">
										<option
											<c:if test="${childBean.states == booleanCombo.key}">selected</c:if>
											value="${booleanCombo.key}">${booleanCombo.value}</option>
									</c:forEach>
									<option
										<c:if test="${childBean.states == '99'}">selected</c:if>
										value="99">FOREIGN</option>
								</select>
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for="Pin"><small>PIN Code</small> </label>
							</div>
							<div>
								<input id="Pin" type="text" name="Pin" maxlength="6"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.pin}"/></c:if>" />

							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel" id="idletout">
								<label for="letout"><small>Type of House
										Property</small> </label>
							</div>
							<div>
								<select name="letout" id="letout" onChange="hideTanPan()"
									class="uprcase">
									<option value="">-Select-</option>
									<option value="S"
										<c:if test="${not empty childBean.letOut && childBean.letOut =='S'}">selected</c:if>>Self
										Occupied</option>
									<option value="L"
										<c:if test="${not empty childBean.letOut && childBean.letOut =='L'}">selected</c:if>>Letout</option>
								</select>
								<!--
									<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.letOut == booleanCombo.value}">selected</c:if>
											value="${booleanCombo.value}">${booleanCombo.value}</option>
									</c:forEach>
								</select>
-->
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel" id="idtenantname">
								<label for=""><small>Tenant Name</small> </label>
							</div>
							<div>
								<input id="Tenant_name" name="Tenant_name" maxlength="75"
									placeholder="Tenant Name" type="text" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tenant_name}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel" id="idtenantpan">
								<label for=""><small>Tenant PAN</small> </label>
							</div>
							<div>
								<input id="Tenant_pan" name="Tenant_pan"
									placeholder="10 Characters" type="text" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tenant_pan}"/></c:if>" />
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-6">
							<div class="rowlabel">
								<label for="coowned"><small>Is the property
										co-owned?</small> </label>
							</div>
							<div>
								<select name="coowned" id="coowned" onChange="hidecoOwner()"
									style="text-transform: uppercase;">
									<option value="">-Select-</option>
									<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.coowned == booleanCombo.value}">selected</c:if>
											value="${booleanCombo.value}">${booleanCombo.value}</option>

									</c:forEach>
								</select>
							</div>
						</div>

						<div class="col-md-6">
							<div class="rowlabel" id="percentageshare_label">
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
				<fieldset id="coOwner">
					<legend class="header-color">
						<small> <abbr
							title="Is this property being owned by someone else">Ownership
								Details</abbr></small>
					</legend>

					<div class="row show-grid">
						<div class="col-md-1">
							<div class="rowlabel decimal">
								<label for=""><small>S.No</small> </label>
							</div>
							<div class="decimal">1.</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for=""><small>Name of Co-owner</small> </label>
							</div>
							<div>
								<input id="coownername1" name="coownername1" class="uprcase"
									placeholder="Name of Co-owner" type="text" maxLength="125"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername1}"/></c:if>" />
							</div>
						</div>

						<div class="col-md-4">
							<div class="rowlabel">
								<label for=""><small>PAN of the Co-owner</small> </label>
							</div>
							<div>
								<input id="coownerpan1" name="coownerpan1" class="uprcase"
									placeholder="10 Characters" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan1}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-3">
							<div class="rowlabel">
								<label for=""><small><abbr
										title="Percentage Share In Property">Share (%)</abbr> </small> </label>
							</div>
							<div>
								<input id="share1" name="share1" type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share1}"/></c:if>" />
							</div>
						</div>

						<div class="row show-grid">
							<div class="col-md-1">
								<div class="decimal">2.</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownername2" name="coownername2" class="uprcase"
										placeholder="Name of Co-owner" type="text" maxLength="125"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername2}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownerpan2" name="coownerpan2" class="uprcase"
										placeholder="10 Characters" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan2}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-3">
								<div class="decimal">
									<input id="share2" name="share2" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share2}"/></c:if>" />
								</div>
							</div>
						</div>
						<div class="row show-grid">
							<div class="col-md-1">
								<div class="decimal">3.</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownername3" name="coownername3" class="uprcase"
										placeholder="Name of Co-owner" type="text" maxLength="125"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername3}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownerpan3" name="coownerpan3" class="uprcase"
										placeholder="10 Characters" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan3}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-3">
								<div>
									<input id="share3" name="share3" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share3}"/></c:if>" />
								</div>
							</div>
						</div>
						<div class="row show-grid">
							<div class="col-md-1">
								<div class="decimal">4.</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownername4" name="coownername4" class="uprcase"
										placeholder="Name of Co-owner" type="text" maxLength="125"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername4}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownerpan4" name="coownerpan4"
										placeholder="10 Characters" type="text" class="uprcase"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan4}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-3">
								<div>
									<input id="share4" name="share4" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share4}"/></c:if>" />
								</div>
							</div>
						</div>
						<div class="row show-grid">
							<div class="col-md-1">
								<div class="decimal">5.</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownername5" name="coownername5" class="uprcase"
										placeholder="Name of Co-owner" type="text" maxLength="125"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownername5}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-4">
								<div>
									<input id="coownerpan5" name="coownerpan5" class="uprcase"
										placeholder="10 Characters" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.coownerpan5}"/></c:if>" />
								</div>
							</div>
							<div class="col-md-3">
								<div>
									<input id="share5" name="share5" type="text"
										value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.share5}"/></c:if>" />
								</div>
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend class="header-color">
						<small>Property Income Details</small>
					</legend>
					<div class="row show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>a.</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Lettable value</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Letable_value" name="Letable_value" placeholder="Rs."
									class="letout_L_inv letout_S_inh" type="text" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.letable_value}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>b.</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Unrealised Rent</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Unrealised_rent" name="Unrealised_rent"
									class="letout_L_inv letout_S_inh" placeholder="Rs." type="text"
									maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.unrealised_rent}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>c.</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Local Taxes</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Local_tax" name="Local_tax" placeholder="Rs."
									class="letout_L_inv letout_S_inh" type="text" maxlength="14"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.local_tax}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>d</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Balance</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Total" name="Total" placeholder="Rs." type="text"
									class="letout_L_inv letout_S_inh"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.total}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>
					<div class="row show-grid letout_L_v letout_S_h"
						style="dispaly: none;">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>e</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>30% of d</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Balance" name="Balance" placeholder="Rs." type="text"
									class="letout_L_inv letout_S_inh"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.balance}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>f</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Interest Payable</small> </label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Interest_borrowed" name="Interest_borrowed"
									class="letout_L_inv letout_S_inh" placeholder="Rs." type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.interest_borrowed}"/></c:if>">
							</div>
						</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-1 decimal">
							<div class="rowlabel">
								<small>g</small>
							</div>
						</div>
						<div class="col-md-7 decimal">
							<div class="rowlabel">
								<label for=""><small>Income from House Property</small>
								</label>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div>
								<input id="Income_hproperty" name="Income_hproperty"
									class="letout_L_inv letout_S_inh" placeholder="Rs." type="text"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.income_hproperty}"/></c:if>"
									readonly="readonly" />
							</div>
						</div>
					</div>
				</fieldset>
				<c:if test="${ not empty ITR2}">
					<jsp:include page="houseIncome_add.jsp" />
				</c:if>
				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a
							href="${scriptName}?selectedItrTab=<%=ITRTab.INCOME_HOUSE_PROPERTY_SINGLE%>"
							class="btn btn-default btn-danger">Cancel</a>&nbsp; <a
							id="myModalHrefHouseIncome" role="button"
							class="btn btn-default btn-success"">Save</a>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<!--  show the table -->
			<table class="table table-bordered">
				<tr align="center">
					<th><b>Property Let Out</b></th>
					<th><b>Address</b></th>
					<th><b>Ownership %</b></th>
					<th><b>Income from House Property</b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.houseIncomeDetailList}"
						var="houseincomedetail">
						<tr>
							<td><a
								href="${scriptName}/<c:out value="${houseincomedetail.canonicalUUID}"/>/houseincomeedit">
									<c:choose>
										<c:when test="${houseincomedetail.letOut=='S'}">
											<c:out value="Self Occupied" />
										</c:when>
										<c:otherwise>
											<c:out value="Letout" />
										</c:otherwise>
									</c:choose>
							</a></td>
							<td><c:out value="${houseincomedetail.address}" /></td>
							<td><c:out value="${houseincomedetail.property_share}" /></td>
							<c:choose>
								<c:when test="${ not empty ITR2}">
									<td><w4india:inr
											value="${houseincomedetail.total_houseIncome}" /></td>
								</c:when>
								<c:otherwise>
									<td><w4india:inr
											value="${houseincomedetail.income_hproperty}" /></td>
								</c:otherwise>
							</c:choose>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${houseincomedetail.canonicalUUID}"/>/houseincomeedit"><i
									class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i><small>Edit</small>
							</a>&nbsp;&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${houseincomedetail.canonicalUUID}"/>/houseincomedelete"
								data-confirm=""><i
									class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i><small>Delete</small>
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<c:if test="${empty NEW_CHILD_DISABLED}">
				<a href="${scriptName}/houseincomenew"
					class="btn btn-default btn-info"><small><i
						class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
			</c:if>



		</c:otherwise>
	</c:choose>

</div>
<res:client-validation formId="frmdataHouseIncome"
	screenConfigurationDocumentName="houseincome"
	formSubmitButtonId="myModalHrefHouseIncome" />
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
    $('#states').change(function(){
			if($('#states').val()=='99'){
			      $('#Pin').val('999999');
			      $('#Pin').attr('readonly','readonly');
			   }else{
                            $('#Pin').val('');
                            $('#Pin').removeAttr('readonly');
                            }
			});
	$('#letout').change(function(){
	$('.letout_' + $(this).val() + '_v').show();
		$('.letout_' + $(this).val() + '_h').hide();
	});

<c:if test="${not empty childBean.letOut}">
	var letout='<c:out value="${childBean.letOut}" />';
	if(letout!=''){
	
		$('.letout_' + letout + '_v').show();
		$('.letout_' + letout + '_h').hide();
	}</c:if>

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
<res:calc screenCalc="houseincome" formId="frmdataHouseIncome"></res:calc>
<script type="text/javascript">
	$(document).ready(function() {
		var OnLoadCoowned = $("#coowned").val();
		if (OnLoadCoowned == "Yes") {
			$("#coOwner").show();
			$("#Property_share").show();
			$("#percentageshare_label").show();
		} else {
			$("#coOwner").hide();
			$("#Property_share").hide();
			$("#percentageshare_label").hide();

		}

		var OnLoadLetOut = $("#letout").val();
		if (OnLoadLetOut == "S") {
			$("#Tenant_pan").hide();
			$("#Tenant_name").hide();
			$("#idtenantname").hide();
			$("#idtenantpan").hide();
		} else {
			$("#Tenant_pan").show();
			$("#Tenant_name").show();
			$("#idtenantname").show();
			$("#idtenantpan").show();
		}
	});
	function hideTanPan() {
		var e = document.getElementById("letout");
		var valueLetout = e.options[e.selectedIndex].value;
		if (valueLetout == "S") {
			$("#Tenant_pan").hide();
			$("#Tenant_name").hide();
			$("#idtenantname").hide();
			$("#idtenantpan").hide();
		} else {
			$("#Tenant_pan").show();
			$("#Tenant_name").show();
			$("#idtenantname").show();
			$("#idtenantpan").show();
		}
	}
	function hidecoOwner() {
		var d = document.getElementById("coowned");
		var valuePropCoOwned = d.options[d.selectedIndex].value;
		if (valuePropCoOwned == "Yes") {
			$("#coOwner").show();
			$("#Property_share").show();
			$("#percentageshare_label").show();
		} else {
			$("#coOwner").hide();
			$("#Property_share").hide();
			$("#percentageshare_label").hide();
		}
	}
</script>