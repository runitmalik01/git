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
	<h4>Schedule DEP</h4>
	<fieldset>
		<legend style="font-style: italic; color: blue;">
			<fmt:message key="member.scheduledep.summary" />

		</legend>
		<table>
			<tr width="100%">
				<td><b>1</b></td>
				<td><b><fmt:message key="member.scheduledep.plant" /> </b>
				</td>
			</tr>

			<tr>
				<td width="10%">a</td>
				<td width="50%"><fmt:message key="member.scheduledep.a" />
				</td>
				<td width="10%">1a</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">b</td>
				<td width="50%"><fmt:message key="member.scheduledep.b" />
				</td>
				<td width="10%">1b</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">c</td>
				<td width="50%"><fmt:message key="member.scheduledep.c" />
				</td>
				<td width="10%">1c</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">d</td>
				<td width="50%"><fmt:message key="member.scheduledep.d" />
				</td>
				<td width="10%">1d</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">e</td>
				<td width="50%"><fmt:message key="member.scheduledep.e" />
				</td>
				<td width="10%">1e</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">f</td>
				<td width="50%"><fmt:message key="member.scheduledep.f" />
				</td>
				<td width="10%">1f</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="8%">g</td>
				<td width="52%"><fmt:message key="member.scheduledep.g" />
				</td>
				<td width="10%">1g</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="8%">h</td>
				<td width="52%"><fmt:message key="member.scheduledep.h" />
				</td>
				<td width="10%">1g</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

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
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">b</td>
				<td width="50%"><fmt:message key="member.scheduledep.2b" /></td>
				<td width="10%">2b</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="8%">c</td>
				<td width="52%"><fmt:message key="member.scheduledep.2c" /></td>
				<td width="10%">2c</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%">d</td>
				<td width="50%"><fmt:message key="member.scheduledep.2d" /></td>
				<td width="10%">2d</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
		</table>
		<table>
			<tr>
				<td width="10%"><b>3</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.3" />
				</td>
				<td width="10%">3</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="8%"><b>4</b></td>
				<td width="52%"><fmt:message key="member.scheduledep.4" />
				</td>
				<td width="10%">4</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%"><b>5</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.5" />
				</td>
				<td width="10%">5</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>
			<tr>
				<td width="10%"><b>6</b></td>
				<td width="50%"><fmt:message key="member.scheduledep.6" />
				</td>
				<td width="10%">6</td>
				<td width="40%"><input id="amtDebit1" name="amtDebit1"
					readonly="readonly" value="" class="decimal" type="text" />
				</td>

			</tr>

		</table>
	</fieldset>