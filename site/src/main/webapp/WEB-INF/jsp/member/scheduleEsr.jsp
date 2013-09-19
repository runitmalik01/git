<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="scheduleesr">
	<fmt:message key="member.scheduleesr.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${scheduleesr}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
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
	<h4>Schedule ESR</h4>

	<form id="scheduleESR" action="${actionUrl}" method="post"
		name="scheduleESR">
		<fieldset>
			<legend style="color: green; font-weight: bold;">Deduction
				Under Section 35</legend>
			<br />
			<table>
				<tr>
					<th width="20%"><b>Expenditure of the nature referred to
							in section (1) </b>
					</th>
					<th width="25%"><b>Amount, if any, debited to profit and
							loss account (2) </b></th>
					<th width="25%"><b>Amount of deduction allowable (3) </b>
					</th>
					<th width="25%"><b>Amount of deduction in excess of the
							amount debited to profit and loss account (4) = (3) - (2) </b>
					</th>
				</tr>
				<tr>
					<td>35(1)(i)</td>

					<td><input id="amtDebit1" name="amtDebit1"
						value="${parentBean.amtDebit1}" class="decimal" type="text" />
					</td>
					<td><input id="amtDeduct1" name="amtDeduct1" class="decimal"
						value="${parentBean.amtDeduct1}" type="text">
					</td>
					<td><input id="amtExcess1" name="amtExcess1"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" value="${parentBean.amtExcess1}" type="text">
					</td>
				</tr>
				<tr>
					<td>35(1)(ii)</td>

					<td><input id="amtDebit2" name="amtDebit2" class="decimal"
						value="${parentBean.amtDebit2}" type="text">
					</td>
					<td><input id="amtDeduct2" name="amtDeduct2" class="decimal"
						value="${parentBean.amtDeduct2}" type="text">
					</td>
					<td><input id="amtExcess2" name="amtExcess2"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" value="${parentBean.amtExcess2}" type="text">
					</td>
				</tr>
				<tr>
					<td>35(1)(iii)</td>

					<td><input id="amtDebit3" name="amtDebit3" class="decimal"
						value="${parentBean.amtDebit3}" type="text">
					</td>
					<td><input id="amtDeduct3" name="amtDeduct3" class="decimal"
						value="${parentBean.amtDeduct3}" type="text">
					</td>
					<td><input id="amtExcess3" name="amtExcess3" class="decimal"
						readonly="readonly" style="background-color: #DFDFDF"
						value="${parentBean.amtExcess3}" type="text">
					</td>
				</tr>
				<tr>
					<td>35(1)(iv)</td>

					<td><input id="amtDebit4" name="amtDebit4" class="decimal"
						value="${parentBean.amtDebit4}" type="text">
					</td>
					<td><input id="amtDeduct4" name="amtDeduct4" class="decimal"
						value="${parentBean.amtDeduct4}" type="text">
					</td>
					<td><input id="amtExcess4" name="amtExcess4" class="decimal"
						readonly="readonly" style="background-color: #DFDFDF"
						value="${parentBean.amtExcess4}" type="text">
					</td>
				</tr>
				<tr>
					<td>35(2AA)</td>

					<td><input id="amtDebit2AA" name="amtDebit2AA" class="decimal"
						value="${parentBean.amtDebit2AA}" type="text">
					</td>
					<td><input id="amtDeduct2AA" name="amtDeduct2AA"
						class="decimal" value="${parentBean.amtDeduct2AA}" type="text">
					</td>
					<td><input id="amtExcess2AA" name="amtExcess2AA"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" value="${parentBean.amtExcess2AA}" type="text">
					</td>
				</tr>
				<tr>
					<td>35(2AB)</td>

					<td><input id="amtDebit2AB" name="amtDebit2AB" class="decimal"
						value="${parentBean.amtDebit2AB}" type="text">
					</td>
					<td><input id="amtDeduct2AB" name="amtDeduct2AB"
						class="decimal" value="${parentBean.amtDeduct2AB}" type="text">
					</td>
					<td><input id="amtExcess2AB" name="amtExcess2AB"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" value="${parentBean.amtExcess2AB}" type="text">
					</td>
				</tr>
				<tr>
					<td><b>Total</b></td>

					<td><input id="totalDebit" name="totalDebit" class="decimal"
						readonly="readonly" value="${parentBean.totalDebit}" type="text">
					</td>
					<td><input id="totalDeduct" name="totalDeduct"
						readonly="readonly" class="decimal"
						value="${parentBean.totalDeduct}" type="text">
					</td>
					<td><input id="totalExcess" name="totalExcess"
						readonly="readonly" style="background-color: #DFDFDF"
						class="decimal" value="${parentBean.totalExcess}" type="text">
					</td>
				</tr>

			</table>

		</fieldset>
		<div class="row-fluid show-grid">
			<div class="span3 offset10">
				<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>
				&nbsp; <a id="myModalHrefscheduleESR" role="button"
					class="btn orange">Save</a>
			</div>
		</div>
	</form>
</div>
<res:calc screenCalc="scheduleesr" formId="scheduleESR"></res:calc>
<res:client-validation formId="scheduleESR"
	screenConfigurationDocumentName="scheduleesr"
	formSubmitButtonId="myModalHrefscheduleESR" />