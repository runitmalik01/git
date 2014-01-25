<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<c:set var="scheduledep">
	<fmt:message key="member.scheduledep.title" />
</c:set>
<w4india:itrmenu></w4india:itrmenu>
<hippo-gogreen:title title="${scheduledep}" />
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
	<div class="page-header">
		<h2 class="title page-title">Schedule DEP</h2>
		<h4>
			<small></small>
		</h4>
	</div>
	<fieldset>
		<legend class="header-color">
			<small><fmt:message key="member.scheduledep.summary" /></small>
		</legend>
		<table>
			<tr width="100%">
				<td><b>1</b></td>
				<td><b><fmt:message key="member.scheduledep.plant" /> </b></td>
			</tr>

			<tr>
				<td width="10%">a</td>
				<td width="50%"><fmt:message key="member.scheduledep.a" /></td>
				<td width="10%">1a</td>
				<td width="40%"><input id="plantMach_15Per"
					name="plantMach_15Per" readonly="readonly"
					value="${plantMach_15Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="10%">b</td>
				<td width="50%"><fmt:message key="member.scheduledep.b" /></td>
				<td width="10%">1b</td>
				<td width="40%"><input id="plantMach_30Per"
					name="plantMach_30Per" readonly="readonly"
					value="${plantMach_30Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="10%">c</td>
				<td width="50%"><fmt:message key="member.scheduledep.c" /></td>
				<td width="10%">1c</td>
				<td width="40%"><input id="plantMach_40Per"
					name="plantMach_40Per" readonly="readonly"
					value="${plantMach_40Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="10%">d</td>
				<td width="50%"><fmt:message key="member.scheduledep.d" /></td>
				<td width="10%">1d</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="${plantMach_50Per}" class="decimal"
					type="text" /></td>

			</tr>
			<tr>
				<td width="10%">e</td>
				<td width="50%"><fmt:message key="member.scheduledep.e" /></td>
				<td width="10%">1e</td>
				<td width="40%"><input id="plantMach_60Per"
					name="plantMach_60Per" readonly="readonly"
					value="${plantMach_60Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="10%">f</td>
				<td width="50%"><fmt:message key="member.scheduledep.f" /></td>
				<td width="10%">1f</td>
				<td width="40%"><input id="plantMach_80Per"
					name="plantMach_80Per" readonly="readonly"
					value="${plantMach_80Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="8%">g</td>
				<td width="52%"><fmt:message key="member.scheduledep.g" /></td>
				<td width="10%">1g</td>
				<td width="40%"><input id="plantMach_100Per"
					name="plantMach_100Per" readonly="readonly"
					value="${plantMach_100Per}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="8%">h</td>
				<td width="52%"><fmt:message key="member.scheduledep.h" /></td>
				<td width="10%">1g</td>
				<td width="40%"><input id="plantMach_Total"
					name="plantMach_Total" readonly="readonly"
					value="${plantMach_Total}" class="decimal" type="text" /></td>

			</tr>
		</table>
		<table>
			<tr width="100%">
				<td><b>2</b></td>
				<td><b><fmt:message key="member.scheduledep.building" />Building</b>
				</td>
			</tr>
			<tr>
				<td width="10%">a</td>
				<td width="50%"><fmt:message key="member.scheduledep.2a" /></td>
				<td width="10%">2a</td>
				<td width="40%"><input id="build_5Per" name="build_5Per"
					readonly="readonly" value="${build_5Per}" class="decimal"
					type="text" /></td>

			</tr>
			<tr>
				<td width="10%">b</td>
				<td width="50%"><fmt:message key="member.scheduledep.2b" /></td>
				<td width="10%">2b</td>
				<td width="40%"><input id="build_10Per" name="build_10Per"
					readonly="readonly" value="${build_10Per}" class="decimal"
					type="text" /></td>

			</tr>
			<tr>
				<td width="8%">c</td>
				<td width="52%"><fmt:message key="member.scheduledep.2c" /></td>
				<td width="10%">2c</td>
				<td width="40%"><input id="buid_100Per" name="buid_100Per"
					readonly="readonly" value="${buid_100Per}" class="decimal"
					type="text" /></td>

			</tr>
			<tr>
				<td width="10%">d</td>
				<td width="50%"><fmt:message key="member.scheduledep.2d" /></td>
				<td width="10%">2d</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="${build_TotalPer}" class="decimal"
					type="text" /></td>

			</tr>
		</table>
		<table>
			<tr>
				<td width="10%"><b>3</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.3" /></td>
				<td width="10%">3</td>
				<td width="40%"><input id="furniture_Fitting"
					name="furniture_Fitting" readonly="readonly"
					value="${furniture_Fitting}" class="decimal" type="text" /></td>

			</tr>
			<tr>
				<td width="8%"><b>4</b></td>
				<td width="52%"><fmt:message key="member.scheduledep.4" /></td>
				<td width="10%">4</td>
				<td width="40%"><input id="intangible" name="intangible"
					readonly="readonly" value="${intangible}" class="decimal"
					type="text" /></td>

			</tr>
			<tr>
				<td width="10%"><b>5</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.5" /></td>
				<td width="10%">5</td>
				<td width="40%"><input id="ships" name="ships"
					readonly="readonly" value="${ships}" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%"><b>6</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.6" /></td>
				<td width="10%">6</td>
				<td width="40%"><input id="total_CG" name="total_CG"
					readonly="readonly" value="${total_CG}" class="decimal" type="text" />
				</td>

			</tr>

		</table>
	</fieldset>