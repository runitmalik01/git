<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.member.FormSixteen"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.FormSixteenDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<fieldset>
	<legend style="font-style: italic; color: blue;">Employer
		Address</legend>
	<div class="row-fluid show-grid">
		<div class="span3">
			<div class="rowlabel">
				<label for="addressdetail"><fmt:message
						key="member.address.info" /> </label>
			</div>
			<div class="rowlabel">
				<input id="addressdetail" type="text" name="addressdetail"
					class="uprcase"
					value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.addressdetail}"/></c:if>" />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="city"><fmt:message key="member.city.info" />
				</label>
			</div>
			<div class="rowlabel">
				<input id="city" type="text" name="city" class="uprcase"
					value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
			</div>
		</div>

		<div class="span3">
			<div class="rowlabel">
				<label for="state"><fmt:message
						key="member.salary.state" /> </label>
			</div>
			<div class="rowlabel">
				<c:set var="searchresultstitle">
					<fmt:message key="member.contact_info.state.select" />
				</c:set>
				<c:set var="statesType">
					<fmt:message key="dropdown.states" />
				</c:set>
				<w4india:dropdown dropDownSelectId="state"
					optionSelectString="${searchresultstitle}"
					dropDownType="${statesType}" fetchValue="${childBean.state}" />
			</div>
		</div>
		<div class="span3">
			<div class="rowlabel">
				<label for="pin"><fmt:message key="member.pin.info" />
				</label>
			</div>
			<div class="rowlabel">
				<input id="pin" type="text" name="pin" maxlength="6"
					value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
						<c:out value="${childBean.pin}"/></c:if>" />
			</div>
		</div>

	</div>
</fieldset>
