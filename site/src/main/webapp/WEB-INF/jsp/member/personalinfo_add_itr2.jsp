
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>


<hst:actionURL var="actionUrl" />
<fieldset id="represenative_detail">
<div class="row-fluid show-grid">
	<div class="span9">
				<div class="rowlabel" >
					<label for="isRepresentative"><small><fmt:message
								key="wheather.using.representative.itr2" /> </small> </label>
				</div>
			</div>
			<div class="span2">
				<div class="rowlabel">
					<select id="isRepresentative" name="isRepresentative">
					<option value="">-Select-</option>
					<option	value="Yes"<c:if test="${not empty parentBean.isRepresentative && parentBean.isRepresentative =='Yes'}">selected</c:if>>Yes</option></option>
					<option value="No"<c:if test="${not empty parentBean.isRepresentative && parentBean.isRepresentative =='No'}">selected</c:if>>No</option></option>
						
					</select>
				</div>
		</div></div>
		<div class="row-fluid show-grid">
			<div class="span4" id="name_represent">
				<div class="rowlabel">
					<label for="name_Representative"><small><fmt:message
								key="name.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="name_Representative" name="name_Representative"
						type="text" class="decimal" value="${parentBean.name_Representative}" />
				</div>
			</div>

			<div class="span4" id="add_represent">
				<div class="rowlabel">
					<label for="address_Representative"><small><fmt:message
								key="address.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="address_Representative" name="address_Representative"
						type="text" value="${parentBean.address_Representative}" />
				</div>
			</div>

			<div class="span4" id="pan_represent">
				<div class="rowlabel">
					<label for="address_Representative"><small><fmt:message
								key="pan.representative.itr2" /> </small> </label>
				</div>
				<div class="rowlabel">
					<input id="pan_Representative" name="pan_Representative"
						type="text" value="${parentBean.pan_Representative}" />
				</div>
			</div>

		</div>
	</table>
</fieldset>
