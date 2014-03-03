<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.member.SalaryIncome"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.SalaryIncomeDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<c:set var="salaryincometitle">
	<fmt:message key="member.salary.title" />
</c:set>
<w4india:itrmenu />
<hippo-gogreen:title title="${salaryincometitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="row show-grid">
				<w4india:itrsidebar></w4india:itrsidebar>
	  			<div class="col-md-10">
	  				<div id="questionandanswerformdiv" style="display:none"></div>
						<c:choose>
							<c:when
								test="${not empty screenConfigDocument && not empty screenConfigDocument.screenHeading}">
								<c:out value="${screenConfigDocument.screenHeading}" />
							</c:when>
							<c:otherwise>
								<w4india:titleandnav title="Pension Income" subTitle="Enter details of your Pension Income"/>
							</c:otherwise>
						</c:choose>
					<c:if test="${not empty formMap}">
						<c:forEach items="${formMap.message}" var="item">
							<div class="alert alert-danger">
								<fmt:message key="${item.value}" />
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${finStatus != 'H'}">
						<c:choose>
							<c:when
								test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') || pageAction == 'NEW_CHILD'}">
								<%-- <h5>
							<small><fmt:message key="member.employe.message" /> </small>
						</h5> --%>
								<form id="frmdataSlryInc" action="${actionUrl}" name="salaryincome"
									method="post">
									<fieldset>
										<legend class="header-color">
											<small>Category Of Employment</small>
										</legend>
										<!-- <legend style="color: green; font-weight: bold;">Employment</legend> -->
										<div class="row show-grid">
											<div class="col-md-3">
												<div class="rowlabel">
													<label for="Employe_category"><fmt:message
															key="member.employe.category" /> </label>
												</div>
												<select id="Employe_category" name="Employe_category">
													<option value="">-SELECT-</option>
													<option value="GOV"
														<c:if test="${not empty childBean.employe_category && childBean.employe_category =='GOV'}">selected</c:if>>GOVT.</option>
													<option value="PSU"
														<c:if test="${not empty childBean.employe_category && childBean.employe_category =='PSU'}">selected</c:if>>PSU</option>
													<option value="OTH"
														<c:if test="${not empty childBean.employe_category && childBean.employe_category =='OTH'}">selected</c:if>>OTHERS.</option>
													<option value="NA"
														<c:if test="${not empty childBean.employe_category && childBean.employe_category =='NA'}">selected</c:if>>NA</option>
												</select>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend class="header-color">
											<small> Details Of Employer & Employee</small>
										</legend>
										<div class="row show-grid">
											<div class="col-md-4">
												<div class="rowlabel">
													<label for="Name_employer"><fmt:message
															key="member.employe.name" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Name_employer" type="text" name="Name_employer"
														maxlength="125" class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_employer}"/></c:if>" />
			
												</div>
											</div>
											<div class="col-md-4">
												<div class="rowlabel">
													<label for="Pan_employer"><fmt:message
															key="member.info.pan" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Pan_employer" type="text" name="Pan_employer"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employer}"/></c:if>" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="rowlabel">
													<label for="Tan_employer"><fmt:message
															key="member.info.tan" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Tan_employer" type="text" name="Tan_employer"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_employer}"/></c:if>">
												</div>
											</div>
											<%-- <div class="col-md-4">
												<div class="rowlabel">
													<label for="Name_employee"><fmt:message
															key="member.employee.name" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Name_employee" type="text" name="Name_employee"
														maxlength="25" class="uprcase"
														value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.name_employee}"/></c:when><c:otherwise><c:out value="${memberpersonalinformation.name}"/></c:otherwise></c:choose>"
														readonly="readonly" />
												</div>
											</div>
											<div class="col-md-4">
												<div class="rowlabel">
													<label for="Pan_employee"><fmt:message
															key="member.info.pan.employee" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Pan_employee" type="text" name="Pan_employee"
														class="uprcase"
														value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.pan_employee}"/></c:when><c:otherwise><c:out value="${memberpersonalinformation.PAN}"/></c:otherwise></c:choose>"
														readonly="readonly" />
												</div>
											</div> --%>
										</div>
										<div class="row show-grid">
											<%-- <div class="col-md-6">
												<div class="rowlabel">
													<label for="Pan_employer"><fmt:message
															key="member.info.pan" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Pan_employer" type="text" name="Pan_employer"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_employer}"/></c:if>" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="rowlabel">
													<label for="Tan_employer"><fmt:message
															key="member.info.tan" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Tan_employer" type="text" name="Tan_employer"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.tan_employer}"/></c:if>">
												</div>
											</div> --%>
											<div class="col-md-6">
												<div class="rowlabel">
													<label for="Name_employee"><fmt:message
															key="member.employee.name" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Name_employee" type="text" name="Name_employee"
														maxlength="25" class="uprcase"
														value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.name_employee}"/></c:when><c:otherwise><c:out value="${memberpersonalinformation.name}"/></c:otherwise></c:choose>"
														readonly="readonly" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="rowlabel">
													<label for="Pan_employee"><fmt:message
															key="member.info.pan.employee" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Pan_employee" type="text" name="Pan_employee"
														class="uprcase"
														value="<c:choose><c:when test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.pan_employee}"/></c:when><c:otherwise><c:out value="${memberpersonalinformation.PAN}"/></c:otherwise></c:choose>"
														readonly="readonly" />
												</div>
											</div>
										</div>
									</fieldset>
									<fieldset>
										<legend class="header-color">
											<small>Address Of Employer</small>
										</legend>
										<div class="row show-grid">
											<div class="col-md-3">
												<div class="rowlabel">
													<label for="Addressslry"><fmt:message
															key="member.address.info" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Addressslry" type="text" name="Addressslry"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.address}"/></c:if>" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="rowlabel">
													<label for="Cityslry"><fmt:message
															key="member.city.info" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Cityslry" type="text" name="Cityslry"
														class="uprcase"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.city}"/></c:if>" />
												</div>
											</div>
			
											<div class="col-md-3">
												<div class="rowlabel">
													<label for="Stateslry"><fmt:message
															key="member.salary.state" /> </label>
												</div>
												<div class="rowlabel">
													<c:set var="searchresultstitle">
														<fmt:message key="member.contact_info.state.select" />
													</c:set>
													<c:set var="statesType">
														<fmt:message key="dropdown.states" />
													</c:set>
													<w4india:dropdown dropDownSelectId="Stateslry"
														optionSelectString="${searchresultstitle}"
														dropDownType="${statesType}" fetchValue="${childBean.state}" />
												</div>
											</div>
											<div class="col-md-3">
												<div class="rowlabel">
													<label for="Pinslry"><fmt:message
															key="member.pin.info" /> </label>
												</div>
												<div class="rowlabel">
													<input id="Pinslry" type="text" name="Pinslry" maxlength="6"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
									<c:out value="${childBean.pin}"/></c:if>" />
												</div>
											</div>
			
										</div>
									</fieldset>
									<%-- 	<fieldset>
								<legend>
									<fmt:message key="member.period.info" />
								</legend>
								<div class="row show-grid">
									<div class="col-md-4">
										<div class="rowlabel">
											<label for="From"><fmt:message key="member.period.info1" />
											</label>
										</div>
										<div class="rowlabel">
											<input id="From" name="From"
												value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.from}"/></c:if>" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="rowlabel">
											<label for="To"><fmt:message key="member.period.infoto" />
											</label>
										</div>
										<div class="rowlabel">
											<input id="To" name="To"
												value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.to}"/></c:if>" />
										</div>
									</div>
								</div>
							</fieldset>--%>
									<fieldset>
										<legend class="header-color">
											<small>Compensation and Taxation</small>
										</legend>
										<div class="row show-grid">
											<div class="col-md-6">
												<div class="rowlabel">
													<label for="tdspension"><fmt:message
															key="itr.tds.pension" /></label>
												</div>
												<div class="rowlabel">
													<input type="text" name="tdspension" id="tdspension"
														class="decimal"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
								              <fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.tdsPension}" /></c:if>" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="rowlabel">
													<label for="Gross_salary"><fmt:message
															key="member.gross.salary" /> </label>
												</div>
												<div class="rowlabel">
													<input type="text" name="Gross_salary" maxlength="14"
														id="Gross_salary" class="decimal"
														value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}">
												<fmt:formatNumber type="number"  groupingUsed="false" value="${childBean.gross_salary}" /></c:if>" />
												</div>
											</div>
										</div>
									</fieldset>
									<div class="row show-grid">
										<div class="col-md-4 col-md-offset-8 decimal">
											<a
												href="${scriptName}?selectedItrTab=<%=ITRTab.INCOME_SALARY_PENSION%>"
												class="btn btn-default btn-danger">Cancel</a>&nbsp; <a
												id="myModalHrefSlryInc" role="button"
												class="btn btn-default btn-success">Save</a>
										</div>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<table class="table table-bordered">
									<tr align="center">
										<th><b>Name Of Employer</b></th>
										<th><b>Address Of Employer</b></th>
										<th><b>Taxable Earning</b></th>
										<th><b>Actions</b></th>
									</tr>
									<c:if test="${not empty parentBean}">
										<c:forEach items="${parentBean.salaryIncomeDetailList}"
											var="salaryItemDetail">
											<tr>
												<td><a
													href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><c:out
															value="${salaryItemDetail.name_employer}" /> </a></td>
												<td><c:out value="${salaryItemDetail.address}" /> , <c:out
														value="${salaryItemDetail.city}" /></td>
												<td align="right"><w4india:inr
														value="${salaryItemDetail.gross_salary}" /></td>
												<td><a class="btn btn-default btn-primary"
													href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomeedit"><small><i
															class="glyphicon glyphicon-pencil"></i>Edit</small> </a>&nbsp;&nbsp;<a
													class="btn btn-default btn-danger"
													href="${scriptName}/<c:out value="${salaryItemDetail.canonicalUUID}"/>/salaryincomedelete"
													data-confirm=""><small><i
															class="glyphicon glyphicon-trash"></i>Delete</small> </a></td>
			
											</tr>
										</c:forEach>
										<tr align="center">
											<td colspan="2">Total Earning</td>
											<td align="right"><w4india:inr value="${parentBean.total}" /></td>
									</c:if>
								</table>
								<a href="${scriptName}/salaryincomenew"
									class="btn btn-default btn-info"><small><i
										class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
							</c:otherwise>
						</c:choose>
					</c:if>
					<br /> <br />
					<c:if test="${finStatus eq 'H' }">
						<h4 class="alert alert-danger">
							<b>Sorry!!!</b> This service is not applicable for tax payee having
							filing status as 'HUF'.
						</h4>
					</c:if>
				</div>
			</div>
<res:client-validation formId="frmdataSlryInc"
	screenConfigurationDocumentName="salaryincome"
	formSubmitButtonId="myModalHrefSlryInc" />

