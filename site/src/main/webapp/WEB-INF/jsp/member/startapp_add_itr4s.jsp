<%@page import="java.util.TreeMap"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<fieldset id="trpdetails" class="<c:if test="${parentBean.selectedITRForm != 'ITR4S'}">hide</c:if>">
	<legend style="font-style: italic;">
		<fmt:message key="member.trp.info" />
	</legend>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel">
				<label for="trpnumber"><fmt:message
						key="member.trp.ident.number" /> </label>
			</div>
				<div class="rowlabel">
					<input id="trpnumber" name="trpnumber" class="uprcase"
						type="text"  value="${parentBean.trpnumber }"/>
				</div>
			</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="trpname"><fmt:message key="member.trp.name" />
				</label>
			</div>
			<div class="rowlabel">
				<input id="trpname" name="trpname" class="uprcase"
						type="text" value="${parentBean.trpname }" />
			</div>
		</div>
	</div>
	<div class="row-fluid show-grid">
		<div class="span8">
			<div class="rowlabel">
				<label for="trpreimbursement"><fmt:message
						key="member.trp.reimbursement" /> </label>
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<input id="trpreimbursement" name="trpreimbursement" class="uprcase decimal"
						type="text"  value="${parentBean.trpreimbursement }" maxlength="14"/>
			</div>
		</div>
	</div>
</fieldset>