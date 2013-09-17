<%@page import="java.util.TreeMap"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<fieldset id="trpdetails" class="<c:if test="${parentBean.selectedITRForm != 'ITR4S'}"> hide </c:if>">
	<legend style="font-style: italic;">
		<fmt:message key="member.trp.info" />
	</legend>
	<div class="row-fluid show-grid">
	<div class="span9">
				<div class="rowlabel" >
					<label for="isTaxPreparebyTRP"><small><fmt:message
								key="isTaxPreparebyTRP.itr4s" /> </small> </label>
				</div>
			</div>
			<div class="span2">
				<div class="rowlabel">
					<select id="isTaxPreparebyTRP" name="isTaxPreparebyTRP">
					<option value="">-SELECT-</option>
					<option	value="Y"<c:if test="${not empty parentBean.isTaxPreparebyTRP && parentBean.isTaxPreparebyTRP =='Y'}">selected</c:if>>YES</option>
					<option value="N"<c:if test="${not empty parentBean.isTaxPreparebyTRP && parentBean.isTaxPreparebyTRP =='N'}">selected</c:if>>NO</option>
					</select>
				</div>
		</div></div>
	<div class="row-fluid show-grid <c:if test="${parentBean.isTaxPreparebyTRP == 'N'}"> hide </c:if>" id="yesTaxPreparebyTRP">
		<div class="span3">
			<div class="rowlabel">
				<label for="trpnumber"><small><fmt:message
						key="member.trp.ident.number" /></small> </label>
			</div>
				<div class="rowlabel">
					<input id="trpnumber" name="trpnumber" class="uprcase" maxlength="10"
						type="text"  value="${parentBean.trpnumber }"/>
				</div>
			</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="trpname"><small><fmt:message key="member.trp.name" /></small>
				</label>
			</div>
			<div class="rowlabel">
				<input id="trpname" name="trpname" class="uprcase" maxlength="125"
						type="text" value="${parentBean.trpname }" />
			</div>
		</div>
	
	
		<div class="span8">
			<div class="rowlabel">
				<label for="trpreimbursement"><small><fmt:message
						key="member.trp.reimbursement" /></small> </label>
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