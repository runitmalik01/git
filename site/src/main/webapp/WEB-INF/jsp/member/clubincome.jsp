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
	<w4india:itrmenu/>
<hst:link var="mainSiteMapRefId" />
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<% 
ValueListService objValueListservice=ValueListServiceImpl.getInstance();
TreeMap objTreeMapRelation=objValueListservice.getRelationship();
request.setAttribute("objTreeMapRelation", objTreeMapRelation);
%>
<h4>
	<fmt:message key="member.clubincome.itr2" />
</h4>
<c:choose>
	<c:when
		test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmClubIncome" action="${actionUrl}" method="post"
			name="frmClubIncome">
			
			<h2>Enter Details</h2>
			<div class="row-fluid show-grid">
				<div class="span4">
					<div class="rowlabel">
						<label for="name_person"><small><fmt:message
									key="name.person.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="name_person" name="name_person" 
							type="text" maxlength="125"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.name_Person}"/></c:if> " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="pan_person"><small><fmt:message
									key="pan.person.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="pan_person" name="pan_person"
							type="text" maxlength="10" 
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.pan_person}"/></c:if>" />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="relationship"><small><fmt:message
									key="relationship.clubincome" /> </small> </label>
					</div>
					<div class="rowlabel">
							<select name="relationship" id="relationship"
									style="text-transform: uppercase;">
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
			<div class="row-fluid show-grid">
				
				
				<div class="span4">
					<div class="rowlabel">
						<label for="nature_income"><small><fmt:message
									key="nature.income.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="nature_income" name="nature_income"
							type="text" value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><c:out value="${childBean.nature_income}"/></c:if> " />
					</div>
				</div>
				<div class="span4">
					<div class="rowlabel">
						<label for="amountclub"><small><fmt:message
									key="amount.clubincome.itr2" /> </small> </label>
					</div>
					<div class="rowlabel">
						<input id="amountclub" name="amountclub" type="text"
							maxlength="14"   class="decimal"
							value="<c:if test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD')}"><fmt:formatNumber type="number"  maxIntegerDigits="14" groupingUsed="false" value="${childBean.amountclub}"/></c:if>" />
					</div>
				</div>
				</div>
			</div>
		 	<div class="row-fluid show-grid">
				<div class="span4 offset8 decimal">
					<a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					<a id="myModalHrefClubIncome" role="button" class="btn orange">Save</a>
				</div>
			</div> 
			
		</form>
	</c:when>
	<c:otherwise>
		<table>
			<tr align="center">
				<th><b><fmt:message key="name.person.itr2" /> </b>
				</th>
				<th><b><fmt:message key="pan.person.itr2" /> </b>
				</th>
				<th><b><fmt:message key="relationship.clubincome" /> </b></th>
				<th><b><fmt:message key="nature.income.itr2" /> </b>
				</th>
				<th><b><fmt:message key="amount.clubincome.itr2" /> </b></th>
				<th><b>Actions</b></th>
			</tr>
			<c:if test="${not empty parentBean}">
				<c:forEach items="${parentBean.clubIncomeDetailList}"
					var="clubincomedetail">
					<tr>
						<td><c:out value="${clubincomedetail.name_Person}" />
						</td>
						<td><c:out value="${clubincomedetail.pan_person}" />
						</td>
						<td><c:out value="${clubincomedetail.relationship}" />
						</td>
						<td><c:out value="${clubincomedetail.nature_income}" />
						</td>
						<td><w4india:inr value="${clubincomedetail.amountclub}" />
						</td>
						<td><a
							href="${scriptName}/<c:out value="${clubincomedetail.canonicalUUID}"/>/clubincomeedit"><small>Edit</small> &nbsp;&nbsp;
						</a>&nbsp;<a href="${scriptName}/<c:out value="${clubincomedetail.canonicalUUID}"/>/clubincomedelete" id="delete" onclick="return checkdelete()"><small>Delete</small> </a>
							</td>
						</tr>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3"><fmt:message key="tds.amount.total" /></td>
					<td><w4india:inr value="${parentBean.total_Amount}" /></td>
				</tr>
			</c:if>
		</table>
		<a href="${scriptName}/clubincomenew"
			class="button orange">Add New</a>
	</c:otherwise>
</c:choose>
</div>


<res:client-validation formId="frmClubIncome"
	screenConfigurationDocumentName="clubincome"
	formSubmitButtonId="myModalHrefClubIncome" />

