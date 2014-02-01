
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<fieldset id="represenative_detail" class="<c:choose> <c:when test="${(parentBean.selectedITRForm == 'ITR4') || (parentBean.selectedITRForm == 'ITR2') || (parentBean.selectedITRForm == 'ITR3')}"> </c:when> <c:otherwise> hide</c:otherwise></c:choose>">
<legend class="header-color"><small>Representative Assessee Details</small></legend>
<div class="row show-grid">
	<div class="col-md-9">
				<div class="rowlabel" >
					<label for="isRepresentative"><small><fmt:message
								key="wheather.using.representative.itr2" /> </small> </label>
				</div>
			</div>
			<div class="col-md-2">
				<div class="rowlabel">
					<select id="isRepresentative" name="isRepresentative">
					<option value="">-SELECT-</option>
					<option	value="Y"<c:if test="${not empty parentBean.isRepresentative && parentBean.isRepresentative =='Y'}">selected</c:if>>YES</option></option>
					<option value="N"<c:if test="${not empty parentBean.isRepresentative && parentBean.isRepresentative =='N'}">selected</c:if>>NO</option></option>
					</select>
				</div>
		</div></div>
		<div class="row show-grid <c:if test="${(parentBean.isRepresentative == 'N') || ( empty parentBean.isRepresentative)}">hide</c:if>" id="showRepresentDetail" >
			<div class="col-md-4" id="name_represent">
				<div class="rowlabel">
					<label for="name_Representative"><small><fmt:message
								key="name.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="name_Representative" name="name_Representative" class="uprcase" maxlength="125"
						type="text" value="${parentBean.name_Representative}" />
				</div>
			</div>

			<div class="col-md-4" id="add_represent">
				<div class="rowlabel">
					<label for="address_Representative"><small><fmt:message
								key="address.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="address_Representative" name="address_Representative"  class="uprcase" maxlength="200"
						type="text" value="${parentBean.address_Representative}" />
				</div>
			</div>

			<div class="col-md-4" id="pan_represent">
				<div class="rowlabel">
					<label for="address_Representative"><small><fmt:message
								key="pan.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="pan_Representative" name="pan_Representative" class="uprcase strict"
						type="text" value="${parentBean.pan_Representative}" />
				</div>
			</div>
		</div>
</fieldset>
