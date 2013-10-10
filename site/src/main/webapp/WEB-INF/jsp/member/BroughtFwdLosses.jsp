<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="bfla">
	<fmt:message key="member.bfla.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${bfla}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page">
	<h4>Schedule BFLA (Brought Forward Losses)</h4>

	<form id="scheduleBFLA" action="${actionUrl}" method="post" name="scheduleBFLA">

		<fieldset>
			<legend style="color: green; font-weight: bold;">Details of Income after Set off of Brought Forward Losses of earlier years</legend>
			<br/>
		<div class="table-responsive">
			<table class="table table-condensed table-hover table-bordered">
				<tr class="success">
					<th><b>Head/ Source of Income</b></th>
					<th><b>Income after set off, if any, of current year's losses</b></th>
					<th width="17%"><b>Brought forward loss set off</b></th>
					<th><b>Brought forward depreciation set off</b></th>
					<th><b>Brought forward allowance under section 35(4) set off</b></th>
					<th><b>Current year's income remaining after set off</b></th>
				</tr>
				<tr>
					<td>Salaries</td>
					<td><input readonly="readonly" id="salariesincomesetoff" name="salariesincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td> </td>
                    <td> </td>
					<td> </td>
					<td><input id="salariescurrentsetoff" name="salariescurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>House property</td>
					<td><input readonly="readonly" id="hpincomesetoff" name="hpincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="hpbflasetoff" name="hpbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="hpbfdsetoff" name="hpbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="hpbflus35setoff" name="hpbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="hpcurrentsetoff" name="hpcurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>Business Income (excluding speculation profit and income from specified business)</td>
					<td><input readonly="readonly" id="businessincomesetoff" name="businessincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="businessbflasetoff" name="businessbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="businessbfdsetoff" name="businessbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="businessbflus35setoff" name="businessbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="businesscurrentsetoff" name="businesscurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>Speculative Income</td>
					<td><input readonly="readonly" id="speculativeincomesetoff" name="speculativeincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="speculativebflasetoff" name="speculativebflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="speculativebfdsetoff" name="speculativebfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="speculativebflus35setoff" name="speculativebflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="speculativecurrentsetoff" name="speculativecurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>Specified Business Income</td>
					<td><input readonly="readonly" id="specifiedincomesetoff" name="specifiedincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="specifiedbflasetoff" name="specifiedbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="specifiedbfdsetoff" name="specifiedbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="specifiedbflus35setoff" name="specifiedbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="specifiedcurrentsetoff" name="specifiedcurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>Short-term capital gain</td>
					<td><input readonly="readonly" id="stgcincomesetoff" name="stgcincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="stgcbflasetoff" name="stgcbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="stgcbfdsetoff" name="stgcbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="stgcbflus35setoff" name="stgcbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="stgccurrentsetoff" name="stgccurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
			    <tr>
					<td>Long-term capital gain</td>
					<td><input readonly="readonly" id="ltgcincomesetoff" name="ltgcincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="ltgcbflasetoff" name="ltgcbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="ltgcbfdsetoff" name="ltgcbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="ltgcbflus35setoff" name="ltgcbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="ltgccurrentsetoff" name="ltgccurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
			    <tr>
					<td>Other sources (excluding profit from owning race horses and winnings from lottery)</td>
					<td><input readonly="readonly" id="otherincomesetoff" name="otherincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="otherbflasetoff" name="otherbflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="otherbfdsetoff" name="otherbfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="otherbflus35setoff" name="otherbflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="othercurrentsetoff" name="othercurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
				<tr>
					<td>Profit from owning and maintaining race horses</td>
					<td><input readonly="readonly" id="horseincomesetoff" name="horseincomesetoff" maxlength="14" type="text" class="decimal"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="horsebflasetoff" name="horsebflasetoff" class="decimal" maxlength="14" type="text"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="horsebfdsetoff" name="horsebfdsetoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="horsebflus35setoff" name="horsebflus35setoff" class="decimal" type="text"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="horsecurrentsetoff" name="horsecurrentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>

				<tr class="well">
					<td colspan="2"><label>Total of brought forward loss set off</label></td>
					<td><input id="totalbflasetoff" name="totalbflasetoff" class="decimal" maxlength="14" type="text" readonly="readonly"
						value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="" />" />
					</td>
					<td><input id="totalbfdsetoff" name="totalbfdsetoff" class="decimal" type="text" readonly="readonly"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td><input id="totalbflus35setoff" name="totalbflus35setoff" class="decimal" type="text" readonly="readonly"
						value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
					<td>
					</td>
				</tr>
				<tr class="well">
					<td colspan="5"><label>Current year's income remaining after set off Total</label></td>
					<td><input id="currentsetoff" name="currentsetoff" class="decimal" type="text"
						readonly="readonly" value="<fmt:formatNumber type="number"  groupingUsed="false" value="" />" />
					</td>
				</tr>
			</table>
      </div>
      <div class="row-fluid show-grid">
			<div class="span3 offset10">
			    <a id="myModalHrefscheduleBFLA" role="button" class="btn btn-success">Save</a>
			</div>
		</div>
</fieldset>
</form>
</div>
<res:client-validation formId="scheduleBFLA" screenConfigurationDocumentName="broughtfwdlosses" formSubmitButtonId="myModalHrefscheduleBFLA" />