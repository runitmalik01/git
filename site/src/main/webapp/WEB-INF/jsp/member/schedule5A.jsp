<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="schedule5a">
	<fmt:message key="schedule5A" />
</c:set>
<hippo-gogreen:title title="${schedule5a}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />

	<h4>
		<fmt:message key="member.schedule5a.itr2" />
	</h4>
	<form id="frmschedule5a" action="${actionUrl}" method="post"
		name="frmschedule5a">

		<fieldset>
			<legend>Enter Details</legend>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="name_spouse"><small><fmt:message
									key="schedule5a.name.spouse.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_spouse" name="name_spouse" type="text" value="${parentBean.name_Spouse}" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="pan_spouse"><small><fmt:message
									key="schedule5a.pan.spouse.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="pan_spouse" name="pan_spouse" type="text"
							maxlength="10" class="uprcase" value="${parentBean.pan_Spouse}" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="house_property"><small><fmt:message
									key="schedule5a.house.property.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="house_property" name="house_property" type="text"
							maxlength="14" class="decimal" value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.house_Property}" />" />
					</div>
				</div>
			</div>
			<div class="row-fluid show-grid">

				<div class="span4">
					<div class="rowlabel">
						<label for="capital_gains"><small><fmt:message
									key="schedule5a.capitalgains.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="capital_gains" name="capital_gains" type="text"
							maxlength="14" class="decimal" value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.capital_Gains}" />" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="other_sources"><small><fmt:message
									key="schedule5a.othersources.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="other_sources" name="other_sources" type="text"
							maxlength="14" class="decimal" value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_Sources}" />" />
					</div>
				</div>
			</div>
		</fieldset>
		<div class="row-fluid show-grid">
			<div class="span4 offset8 decimal">
				<a href="${scriptName}" class="btn btn-danger" style="color: black">Cancel</a>&nbsp;
				<a id="myModalHrefschedule5a" role="button" class="btn btn-success"
					style="color: black">Save</a>
			</div>
		</div>

	</form>
</div>



<res:client-validation formId="frmschedule5a"
	screenConfigurationDocumentName="schedule5a"
	formSubmitButtonId="myModalHrefschedule5a" />


