<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.SortedSet" %>
<%@page import="org.hippoecm.hst.core.component.HstRequest"%>
<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.member.FormSixteen"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.FormSixteenDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%
ValueListService objValueListService=ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
%>
<fieldset>
	<legend style="font-style: italic; color: blue;">Employer
		Address</legend>
	<div class="row show-grid">
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="addressdetail"><fmt:message
						key="member.address.info" /> </label>
			</div>
			<div class="rowlabel">
				<input id="addressdetail" type="text" name="addressdetail"
					class="uprcase" maxlength="200"
					value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.addressdetail}"/></c:if>" />
			</div>
		</div>
		<div class="col-md-3">
			<div class="rowlabel">
				<label for="city"><fmt:message key="member.city.info" />
				</label>
			</div>
			<div class="rowlabel">
				<input id="city" type="text" name="city" class="uprcase" maxlength="50"
					value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
			</div>
		</div>

		<div class="col-md-3">
			<div class="rowlabel">
				<label for="state"><fmt:message
						key="member.salary.state" /> </label>
			</div>
			<select id="state" name="state" onchange="getautoState()" class="uprcase">
						<option value="">-Select-</option>
						<c:forEach var="listStates" items="${objHashMapstates}">
							<option
								<c:if test="${childBean.state == listStates.key}">selected</c:if>
								value="${listStates.key}">${listStates.value}</option>
						</c:forEach>
						<option <c:if test="${chilldBean.state == '99'}">selected</c:if> value="99">FOREIGN</option>
					</select>
		</div>
		<div class="col-md-3">
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
<script type="text/javascript">
$('#state').change(function(){
	if($('#state').val()=='99'){
	      $('#pin').val('999999');
	      $('#pin').attr('readonly','readonly');
	   }else{
             $('#pin').val('');
             $('#pin').removeAttr('readonly');
            }
	});

</script>