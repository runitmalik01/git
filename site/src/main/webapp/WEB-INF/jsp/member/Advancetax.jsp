<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>


<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>


<hst:actionURL var="actionUrl" />
<hst:link var="mainSiteMapRefId" />

	
<h4>
	<fmt:message key="advance.tax" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdataAdvTax" action="${actionUrl}" method="post"
			name="advancetax">
		
		<fieldset>
				<legend style="color: black">Enter Details</legend>
				<div class="row-fluid show-grid" >
					<div class="span4">
			            <div class="rowlabel"><label for="bsr_codeadv"><abbr title=" Basic Statistical Return Code"><fmt:message key="tds.bsr.code" /></abbr></label></div>
			          	<div class="rowlabel"><input id="bsr_codeadv" name="bsr_codeadv"  type="text" maxlength="7"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>"/></div>
			          </div>
			        <div class="span4">
			            <div class="rowlabel"><label for="date_creditadv"><small><fmt:message key="tds.date.credit" /></small></label></div>
			          	<div class="rowlabel"><input id="date_creditadv" name="date_creditadv"  type="text" 
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>"/></div>
			          </div>
			          </div>
			          <div class="row-fluid show-grid" id="ul_revised_input">
			              <div class="span4">
			            <div class="rowlabel"><label for="Serial_challanadv"><small><fmt:message key="tds.serial.challan" /></small></label></div>
			          	<div class="rowlabel"><input id="Serial_challanadv" name="Serial_challanadv"  type="text" maxlength="5" 
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>"/></div>
			          </div>
			               <div class="span4">
			            <div class="rowlabel"><label for="amountadv"><small><fmt:message key="tds.amount.selfassesment" /></small></label></div>
			          	<div class="rowlabel"><input id="amountadv" name="amountadv"  type="text" maxlength="14" class="decimal"
			          	value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>"/></div>
			          </div>
			          </div>
			</fieldset>
				<div class="row-fluid show-grid">
					<div class="span4 offset8 decimal">
						<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_ADVANCE%>" class="button olive">Cancel</a>&nbsp;
								<a id="myModalHrefAdvTax" role="button" class="btn orange">Save</a>
					</div>
					</div>
					
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="tds.bsr.code" /> </b>
				</th>
				<th><b><fmt:message key="tds.date.credit" /> </b>
				</th>
				<th><b><fmt:message key="tds.serial.challan" /> </b>
				</th>
				<th><b><fmt:message key="tds.amount.selfassesment" /> </b>
				</th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.advanceTaxDetailList}"
					var="advancetaxdetail">
					<tr>
						<td><c:out value="${advancetaxdetail.p_BSR}" />
						</td>
						<td><c:out value="${advancetaxdetail.dateStr}" />
						</td>
						<td><c:out value="${advancetaxdetail.p_Serial}" />
						</td>
						<td><c:out value="${advancetaxdetail.p_Amount}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/advancetaxedit"><small>Edit</small></a>
						<a href="${scriptName}/<c:out value="${advancetaxdetail.canonicalUUID}"/>/advancetaxdelete" onclick="return checkdelete()"><small>Delete</small></a>
							</td>
					</tr>
			</c:forEach>
				<tr>
					<td><fmt:message key="tds.amount.total" /></td>
					<td><input type="text" name="total_value" maxlength="14"
						readonly value="${parentBean.total_Amount}">
					</td>
			</c:if>
		</table>
		<a href="${scriptName}/advancetaxnew" class="button orange">Add
			New</a>
			
		<!-- 
		<table>
			<tr align="center">
				<th><b>Date of Installment</b>
				</th>
				<th><b>Upto 01/04 To 15/6</b>
				</th>
				<th><b>Upto 16/6 To 15/9</b>
				</th>
				<th><b>Upto 16/9 To 15/12</b>
				</th>
				<th><b>Upto 16/12 To 15/03</b>
				</th>
				<th><b>Upto 16/03 To 31/03</b>
				</th>

			</tr>
			<c:if test="${not empty parentBean}">
				<tr>
					<td>Amount</td>
					<td><c:out value="${parentBean.total_Sum1}" />
					</td>
					<td><c:out value="${parentBean.total_Sum2}" />
					</td>
					<td><c:out value="${parentBean.total_Sum3}" />
					</td>
					<td><c:out value="${parentBean.total_Sum4}" />
					</td>
					<td><c:out value="${parentBean.total_Sum5}" />
					</td>

				</tr>
			</c:if>

		</table>
		 -->
	</c:otherwise>
</c:choose>

<res:client-validation formId="frmdataAdvTax" screenConfigurationDocumentName="advancetax" formSubmitButtonId="myModalHrefAdvTax" />

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    $(document).ready(function() {
    
	var fY='<c:out value="${assessmentYear}"/>'.split("-", 4);
	itrFinYrMax="01/04/"+fY[1];
	itrFinYrMin="01/04/"+fY[0];
			$( ".indiandateAdvance" ).datepicker( "option", "minDate", itrFinYrMin );
			$( ".indiandateAdvance" ).datepicker( "option", "maxDate", itrFinYrMax );
			});
  
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
