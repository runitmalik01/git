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
	<div class="row show-grid">
		<w4india:itrsidebar></w4india:itrsidebar>
		<div class="${sideBarMainClass}">
			<w4india:titleandnav title="Schedule 5A"
				subTitle="Schedule 5A&nbsp;- &nbsp;This Schedule is to be filled
				in case of assessee governed by Portuguese Civil Code. The share of
				income of the spouse,should be filled in this schedule and the same
				should form part of the return of income of the spouse." />
			<hst:link var="mainSiteMapRefId" />
			<hst:link var="gotoPersonalInfo"
				siteMapItemRefId="servicerequest-itr">
			</hst:link>
			<fmt:message key="schedule5a.isportugese.civil.itr2" />
			&nbsp;&nbsp; <a
				href="${fn:replace(scriptName,'schedule5a.html','servicerequest-itr.html')}">${isPortugese}</a>



			<c:if test="${isPortugese eq 'Yes'}">
				<form id="frmschedule5a" action="${actionUrl}" method="post"
					name="frmschedule5a">

					<fieldset>
						<legend class="header-color">
							<small>Enter Details</small>
						</legend>
						<div class="row show-grid">
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="name_spouse"><small><fmt:message
												key="schedule5a.name.spouse.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="name_spouse" name="name_spouse" type="text"
										value="${parentBean.name_Spouse}" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="pan_spouse"><small><fmt:message
												key="schedule5a.pan.spouse.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="pan_spouse" name="pan_spouse" type="text"
										maxlength="10" class="uprcase"
										value="${parentBean.pan_Spouse}" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="house_property"><small><fmt:message
												key="schedule5a.house.property.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="house_property" name="house_property" type="text"
										maxlength="14" class="decimal"
										value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.house_Property}" />" />
								</div>
							</div>
						</div>
						<div class="row show-grid">

							<div class="col-md-4">
								<div class="rowlabel">
									<label for="capital_gains"><small><fmt:message
												key="schedule5a.capitalgains.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="capital_gains" name="capital_gains" type="text"
										maxlength="14" class="decimal"
										value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.capital_Gains}" />" />
								</div>
							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="other_sources"><small><fmt:message
												key="schedule5a.othersources.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="other_sources" name="other_sources" type="text"
										maxlength="14" class="decimal"
										value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.other_Sources}" />" />
								</div>

							</div>
							<div class="col-md-4">
								<div class="rowlabel">
									<label for="total"><small><fmt:message
												key="schedule5a.total.itr2" /> </small> </label>
								</div>
								<div class="rowlabel">
									<input id="total" name="total" type="text" maxlength="14"
										class="decimal"
										value="<fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${parentBean.total}" />" />
								</div>

							</div>
						</div>
					</fieldset>

					<div class="row show-grid">
						<div class="col-md-4 col-md-offset-8 decimal">
							<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
							<a id="myModalHrefschedule5a" role="button"
								class="btn btn-default btn-success">Save</a>
						</div>
					</div>

				</form>
		</div>
		</c:if>

		</br> </br> </br> </br>
		<c:if test="${isPortugese eq 'No'}">

			<fmt:message key="schedule5a.noteligible.itr2" />
		</c:if>
	</div>
</div>

<res:calc screenCalc="schedulefivea" formId="frmschedule5a"></res:calc>
<res:client-validation formId="frmschedule5a"
	screenConfigurationDocumentName="schedule5a"
	formSubmitButtonId="myModalHrefschedule5a" />


