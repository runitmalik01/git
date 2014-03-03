<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="scheduleesr">
	<fmt:message key="member.scheduleesr.title" />
</c:set>
<hippo-gogreen:title title="${scheduleesr}" />
<w4india:itrmenu></w4india:itrmenu>
<w4india:titleandnav title="Schedule ESR" subTitle="Schedule ESR (Expenditure on Scientific
				Research)&nbsp;-&nbsp; Details of deduction on amounts of expenses
				of the nature by section 35 which are, if, debited to profit and loss account.
				Please note that no deduction for depreciation is available in
				respect of capital asset for which deduction under section 35(1)(iv)
				has been claimed."/>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<form id="scheduleESR" action="${actionUrl}" method="post"
		name="scheduleESR">
		<fieldset>
			<legend class="header-color"><small>Deduction
				Under Section 35</small></legend>
			<br />
			<table>
				<tr>
					<th width="20%"><b>Expenditure of the nature referred to
							in section (1) </b></th>
					<th width="25%"><b>Amount, if any, debited to profit and
							loss account (2) </b></th>
					<th width="25%"><b>Amount of deduction allowable (3) </b></th>
					<th width="25%"><b>Amount of deduction in excess of the
							amount debited to profit and loss account (4) = (3) - (2) </b></th>
				</tr>
				<tr>
					<td>35(1)(i)</td>

					<td><input id="amtDebit1" name="amtDebit1" maxlength="14"
						type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit1}" />" />
					</td>
					<td><input id="amtDeduct1" name="amtDeduct1" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct1}" />" />
					</td>
					<td><input id="amtExcess1" name="amtExcess1"
						style="background-color: #DFDFDF" class="decimal" type="text"
						readonly="readonly"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="${parentBean.amtExcess1}" />" />
					</td>
				</tr>
				<tr>
					<td>35(1)(ii)</td>

					<td><input id="amtDebit2" name="amtDebit2" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit2}" />" />
					</td>
					<td><input id="amtDeduct2" name="amtDeduct2" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct2}" />" />
					</td>
					<td><input id="amtExcess2" name="amtExcess2"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="${parentBean.amtExcess2}" />" />
					</td>
				</tr>
				<tr>
					<td>35(1)(iii)</td>

					<td><input id="amtDebit3" name="amtDebit3" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit3}" />" />
					</td>
					<td><input id="amtDeduct3" name="amtDeduct3" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct3}" />" />
					</td>
					<td><input id="amtExcess3" name="amtExcess3" class="decimal"
						readonly="readonly" style="background-color: #DFDFDF" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.amtExcess3}" />" />
					</td>
				</tr>
				<tr>
					<td>35(1)(iv)</td>

					<td><input id="amtDebit4" name="amtDebit4" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit4}" />" />
					</td>
					<td><input id="amtDeduct4" name="amtDeduct4" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct4}" />" />
					</td>
					<td><input id="amtExcess4" name="amtExcess4" class="decimal"
						readonly="readonly" style="background-color: #DFDFDF" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.amtExcess4}" />" />
					</td>
				</tr>
				<tr>
					<td>35(2AA)</td>

					<td><input id="amtDebit2AA" name="amtDebit2AA" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit2AA}" />" />
					</td>
					<td><input id="amtDeduct2AA" name="amtDeduct2AA"
						class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct2AA}" />" />
					</td>
					<td><input id="amtExcess2AA" name="amtExcess2AA"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.amtExcess2AA}" />" />
					</td>
				</tr>
				<tr>
					<td>35(2AB)</td>

					<td><input id="amtDebit2AB" name="amtDebit2AB" class="decimal"
						maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDebit2AB}" />" />
					</td>
					<td><input id="amtDeduct2AB" name="amtDeduct2AB"
						maxlength="14" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.amtDeduct2AB}" />" />
					</td>
					<td><input id="amtExcess2AB" name="amtExcess2AB"
						style="background-color: #DFDFDF" class="decimal"
						readonly="readonly" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.amtExcess2AB}" />" />
					</td>
				</tr>
				<tr>
					<td><b>Total</b></td>

					<td><input id="totalDebit" name="totalDebit" class="decimal"
						readonly="readonly" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.totalDebit}" />" />
					</td>
					<td><input id="totalDeduct" name="totalDeduct"
						readonly="readonly" class="decimal" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.totalDeduct}" />" />
					</td>
					<td><input id="totalExcess" name="totalExcess"
						readonly="readonly" style="background-color: #DFDFDF"
						class="decimal" type="text"
						value="<fmt:formatNumber type="number" groupingUsed="false" value="${parentBean.totalExcess}" />" />
					</td>
				</tr>

			</table>

		</fieldset>
		<div class="row show-grid">
			<div class="col-md-3 col-md-offset-10">
				<a href="${redirectURLToSamePage}"
					class="btn btn-default btn-danger">Cancel</a> &nbsp; <a
					id="myModalHrefscheduleESR" role="button"
					class="btn btn-default btn-success">Save</a>
			</div>
		</div>
	</form>
</div>
<res:calc screenCalc="scheduleesr" formId="scheduleESR"></res:calc>
<res:client-validation formId="scheduleESR"
	screenConfigurationDocumentName="scheduleesr"
	formSubmitButtonId="myModalHrefscheduleESR" />