
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<form action="${actionUrl}">
<table>
<tr>
	<td><fmt:message key="foreign.income.dtaa.applicable" /></td>
	<td align="right">
		<div class="input-group">
			<input class="col-md-2" id="appendedInputButton"
					name="IncomeApplDtaa" type="text" value="${parentBean.incomeApplDtaa}"> <input class="btn btn-default green"
					id="test" value="Save" type="submit" /></td>
			</div>
		</form>
</tr>

<tr>
	<td><fmt:message key="foreign.income.dtaa.not.applicable" />
	</td>
	<td align="right"><w4india:inr
			value="${parentBean.incomeNotApplDtaa}" />
	</td>
</tr>
</table>