<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<c:set var="tds2">
	<fmt:message key="member.advancetax.title" />
</c:set>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<hippo-gogreen:title title="${tds2}" />

<hst:actionURL var="actionUrl" />

<h4>
	<fmt:message key="member.tds.selfassesment.tax" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdataSelfTax" action="${actionUrl}" method="post"
			name="selfassementtax">

			<fieldset>
				<legend style="color: black">Enter Details</legend>
				<div class="row-fluid show-grid">
					<div class="span4">
						<div class="rowlabel">
							<label for="bsr_codeself"><abbr
								title=" Basic Statistical Return Code"><small><fmt:message
											key="tds.bsr.code" /> </small> </abbr> </label>
						</div>
						<div class="rowlabel">
							<input id="bsr_codeself" name="bsr_codeself" type="text"
								maxlength="7"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_BSR}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="date_creditself"><small><fmt:message
										key="tds.date.credit" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="date_creditself" name="date_creditself" type="text"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.dateStr}"/></c:if>" />
						</div>
					</div>
				</div>
				<div class="row-fluid show-grid" id="ul_revised_input">
					<div class="span4">
						<div class="rowlabel">
							<label for="Serial_challanself"><small><fmt:message
										key="tds.serial.challan" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="Serial_challanself" name="Serial_challanself"
								type="text" maxlength="5"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>" />
						</div>
					</div>
					<div class="span4">
						<div class="rowlabel">
							<label for="amountself"><small><fmt:message
										key="tds.amount.selfassesment" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="amountself" name="amountself" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.p_Serial}"/></c:if>" />
						</div>
					</div>
				</div>
			</fieldset>
			<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}?selectedItrTab=<%=ITRTab.TAX_SELF_ASSESSMENT%>" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefSelfTax" role="button" class="btn orange">Save</a>
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
				<c:forEach items="${parentBean.selfAssesmentDetailList}"
					var="selfassesmentdetail">
					<tr>
						<td><c:out value="${selfassesmentdetail.p_BSR}" />
						</td>
						<td><c:out value="${selfassesmentdetail.dateStr}" />
						</td>
						<td><c:out value="${selfassesmentdetail.p_Serial}" />
						</td>
						<td><c:out value="${selfassesmentdetail.p_Amount}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxedit"><small>Edit</small>
						</a>&nbsp;&nbsp;<a href="${scriptName}/<c:out value="${selfassesmentdetail.canonicalUUID}"/>/selfassesmenttaxdelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
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
		<a href="${scriptName}/selfassesmenttaxnew" class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
<res:client-validation formId="frmdataSelfTax"
	screenConfigurationDocumentName="selfassementtax"
	formSubmitButtonId="myModalHrefSelfTax" />
<script type="text/javascript">
function checkdelete(){
    var re=confirm("Do You want to Delete it");
      if (re) return true;
      else return false;
            }
</script>