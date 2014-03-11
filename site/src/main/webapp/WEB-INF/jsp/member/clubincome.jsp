<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<c:set var="clubincome">
	<fmt:message key="clubincome" />
</c:set>
<hippo-gogreen:title title="${clubincome}" />
<hst:actionURL var="actionUrl" />
<div class="page type-page">
	<w4india:itrmenu />
	<hst:link var="mainSiteMapRefId" />
	<div class="row show-grid">
	<w4india:itrsidebar></w4india:itrsidebar>
	<div class="${sideBarMainClass}">
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-danger">
				<fmt:message key="${item.value}" />
			</div>
		</c:forEach>
	</c:if>
	<%
		ValueListService objValueListservice = ValueListServiceImpl
				.getInstance();
		TreeMap objTreeMapRelation = objValueListservice.getRelationship();
		request.setAttribute("objTreeMapRelation", objTreeMapRelation);
	%>
	<fmt:message key="member.clubincome.itr2" var="title" />
	<w4india:titleandnav title="${title}" subTitle="Schedule SPI&nbsp;-&nbsp;All income which arises to
				spouse,minor child directly or indirectly by way of salary,
				commission etc. by virtue of any employment or otherwise from a
				concern in which assessee has substantial interest shall be included
				in assesses total income."/>
	<c:choose>
		<c:when
			test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
			<form id="frmClubIncome" action="${actionUrl}" method="post"
				name="frmClubIncome">
				<fieldset>
					<legend class="header-color">
						<small>Enter Details</small>
					</legend>
					<div class="row show-grid">
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="name_person"><small><fmt:message
											key="name.person.itr2" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="name_person" name="name_person" class="uprcase"
									type="text" maxlength="75"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Person}"/></c:if> " />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="pan_person"><small><fmt:message
											key="pan.person.itr2" /> </small> </label>
							</div>
							<div class="rowlabel">
								<input id="pan_person" name="pan_person" type="text"
									maxlength="10" class="uprcase"
									value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_person}"/></c:if>" />
							</div>
						</div>
						<div class="col-md-4">
							<div class="rowlabel">
								<label for="relationship"><small><fmt:message
											key="relationship.clubincome" /> </small> </label>
							</div>
							<div class="rowlabel">
								<select name="relationship" id="relationship">
									<option value="">-Select-</option>
									<c:forEach var="relation" items="${objTreeMapRelation}">
										<option
											<c:if test="${pageAction == 'EDIT_CHILD' && childBean.relationship== relation.value}">selected</c:if>
											value="${relation.value}">${relation.value}</option>

									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</fieldset>
				<div class="row show-grid">


					<div class="col-md-4">
						<div class="rowlabel">
							<label for="nature_income"><small><fmt:message
										key="nature.income.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<select id="nature_income" name="nature_income">
								<option value="">-Select-</option>
								<option value="House Property"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='House Property'}">selected</c:if>>House
									Property</option>
								<option value="Long Term Capital Gain 10%"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Long Term Capital Gain 10%'}">selected</c:if>>Long
									Term Capital Gain 10%</option>
								<option value="Long Term Capital Gain 20%"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Long Term Capital Gain 20%'}">selected</c:if>>Long
									Term Capital Gain 20%</option>
								<option value="Short Term Capital Gain 15%"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Short Term Capital Gain 15%'}">selected</c:if>>Short
									Term Capital Gain 15%</option>
								<option value="Short Term Capital Gain Normal"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Short Term Capital Gain Normal'}">selected</c:if>>Short
									Term Capital Gain Normal</option>
								<option value="Income from Other Sources"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Income from Other Sources'}">selected</c:if>>Income
									from Other Sources</option>
								<option value="Speculative Business"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Speculative Business'}">selected</c:if>>Speculative
									Business</option>
								<option value="Profit from Firm"
									<c:if test="${not empty childBean.nature_income && childBean.nature_income =='Profit from Firm'}">selected</c:if>>Profit
									from Firm</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="rowlabel">
							<label for="amountclub"><small><fmt:message
										key="amount.clubincome.itr2" /> </small> </label>
						</div>
						<div class="rowlabel">
							<input id="amountclub" name="amountclub" type="text"
								maxlength="14" class="decimal"
								value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.amountclub}"/></c:if>" />
						</div>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-md-4 col-md-offset-8 decimal">
						<a href="${scriptName}" class="btn btn-default btn-danger">Cancel</a>&nbsp;
						<a id="myModalHrefClubIncome" role="button"
							class="btn btn-default btn-success">Save</a>
					</div>
				</div>

			</form>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<tr align="center">
					<th><b><fmt:message key="name.person.itr2" /> </b></th>
					<th><b><fmt:message key="pan.person.itr2" /> </b></th>
					<th><b><fmt:message key="relationship.clubincome" /> </b></th>
					<th><b><fmt:message key="nature.income.itr2" /> </b></th>
					<th><b><fmt:message key="amount.clubincome.itr2" /> </b></th>
					<th><b>Actions</b></th>
				</tr>
				<c:if test="${not empty parentBean}">
					<c:forEach items="${parentBean.clubIncomeDetailList}"
						var="clubincomedetail">
						<tr>
							<td><c:out value="${clubincomedetail.name_Person}" /></td>
							<td><c:out value="${clubincomedetail.pan_person}" /></td>
							<td><c:out value="${clubincomedetail.relationship}" /></td>
							<td><c:out value="${clubincomedetail.nature_income}" /></td>
							<td><w4india:inr value="${clubincomedetail.amountclub}" />
							</td>
							<td><a class="btn btn-default btn-primary"
								href="${scriptName}/<c:out value="${clubincomedetail.canonicalUUID}"/>/clubincomeedit"><small><i
										class="glyphicon glyphicon-pencil glyphicon glyphicon-white"></i>Edit</small>
									&nbsp;&nbsp; </a>&nbsp;<a class="btn btn-default btn-danger"
								href="${scriptName}/<c:out value="${clubincomedetail.canonicalUUID}"/>/clubincomedelete"
								data-confirm=""><small><i
										class="glyphicon glyphicon-trash glyphicon glyphicon-white"></i>Delete</small>
							</a></td>
						</tr>

					</c:forEach>
					<tr>
						<td colspan="4"><fmt:message key="tds.amount.total" /></td>
						<td><w4india:inr value="${parentBean.total_Amount}" /></td>
					</tr>
				</c:if>
			</table>
			<a href="${scriptName}/clubincomenew"
				class="btn btn-default btn-info"><small><i
					class="glyphicon glyphicon-plus-sign"></i>Add New</small></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>


<res:client-validation formId="frmClubIncome"
	screenConfigurationDocumentName="clubincome"
	formSubmitButtonId="myModalHrefClubIncome" />

