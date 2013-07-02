
<%--
@author Dhananjay Panwar
13/03/2013
 --%>

<%@include file="../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<%

ValueListService  objValueListService = ValueListServiceImpl.getInstance();
TreeMap  objHashMapAssessmentYear= (TreeMap) objValueListService.getAssessmentYear();
request.setAttribute("objHashMapAssessmentYear", objHashMapAssessmentYear);

TreeMap  objHashMapNameOfHead= (TreeMap) objValueListService.getNameOfHead();
request.setAttribute("objHashMapNameOfHead", objHashMapNameOfHead);

TreeMap  objHashMapBoolean= (TreeMap) objValueListService.getBoolean();
request.setAttribute("objHashMapBoolean", objHashMapBoolean);
%>

<!-- used to set title  -->

<c:set var="adjustmentoflossestitle">
      <fmt:message key="member.adjustment.content.title" />
</c:set>

<hippo-gogreen:title title="${adjustmentoflossestitle}" />

<hst:actionURL var="actionUrl"></hst:actionURL>
<hst:link var="mainSiteMapRefId" />

<h4>
	Losses
</h4>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error">
			<c:choose>
			<c:when test="${item.key == 'checkentry'}">
			<c:out value="${item.value}"/>
			</c:when>
			<c:otherwise>
			<c:out value="${item.key}"/> - <c:out value="${item.value}"/>
			</c:otherwise>
			</c:choose>
			</div>
		</c:forEach>
	</c:if>
<!--
<div class="alert alert-error hide" id="chkentry">
</div>
 -->
	<c:choose>
	<c:when test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdataLosses" action="${actionUrl}" name="adjustmentoflosses" method="post">
			<fieldset>
				<legend>Detail Of Losses</legend>
				<div class="row-fluid show-grid" >
                    <div class="span6">
					<div class="rowlabel"><label for="NameOfHead"><small><fmt:message key="member.adjustment.losses.name"></fmt:message></small></label></div>
					<div class="rowlabel"><select name="NameOfHead" id="NameOfHead">
					             <option value="">-Select Head-</option>
					             <c:forEach var="booleanCombo" items="${objHashMapNameOfHead}">

					             <option <c:if test="${pageAction == 'EDIT_CHILD' && childBean.nameOfHead == booleanCombo.value}">selected</c:if>
					                                value="${booleanCombo.value}">${booleanCombo.value}</option>

						         </c:forEach>
					      </select>
					      </div>
					      </div>
					 <div class="span6">
					 <div class="rowlabel"><label for="AssessmentYear"><small><fmt:message key="member.adjustment.losses.year"></fmt:message></small></label></div>
					 <div class="rowlabel"><select name="AssessmentYear" id="AssessmentYear" onblur="setYear()" onchange="checkentry()">
						  <option value="">-Select Year-</option>
						  <c:forEach var="booleanCombo" items="${objHashMapAssessmentYear}">
						  <option <c:if test="${pageAction == 'EDIT_CHILD' && childBean.assessmentYear == booleanCombo.value}">selected</c:if> value="${booleanCombo.value}">${booleanCombo.value}</option>
						  </c:forEach>
					</select>
					</div>
					</div>
					</div>
				<div class="row-fluid show-grid" >
				 <div class="span6">
					<div class="rowlabel"><label for="DueDate"><small><fmt:message key="member.adjustment.losses.duedate"></fmt:message></small></label></div>
					<div class="rowlabel"><select name="DueDate" id="DueDate">
					            <option value="">-Select-</option>
					            <option
								<c:if test="${not empty childBean.dueDate && childBean.dueDate == 'Y'}">selected</c:if>
								value="Y">
								<fmt:message key="member.choice.yes" />
							</option>
							<option
								<c:if test="${not empty childBean.dueDate && childBean.dueDate == 'N'}">selected</c:if>
								value="N">
								<fmt:message key="member.choice.no" />
							</option>
					      </select>
					</div>
				</div>
				<div class="span3">
					 <div class="rowlabel"><label for="DateOfFilingYear"><small><fmt:message key="member.adjustment.losses.date"></fmt:message></small></label></div>
					 <div class="rowlabel"><input type="text" id="DateOfFilingYear" name="DateOfFilingYear" value="${childBean.dateStr}" /></div>
				</div>
				<div class="span3">
					 <div class="rowlabel"><label for="Amount"><small><fmt:message key="member.adjustment.losses.amount" /></small></label></div>
					 <div class="rowlabel"><input type="text" name="Amount" id="Amount" class="decimal" value="<c:if test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.amount}"/></c:if>"/></div>
				</div>
			</div>
			</fieldset>
			          <div class="row-fluid show-grid">
					      <div class="span4 offset8 decimal">
						      <a href="${scriptName}" class="button olive">Cancel</a>&nbsp;
					          <a id="myModalHref" role="button" class="btn orange">Save</a>
					     </div>
					 </div>
		</form>

	</c:when>
	<c:otherwise>
				<table>
					<tr align="center">
						<th width="180px"><b>Name Of Head</b></th>
						<th><b>Assessment Year</b></th>
						<th><b>Date Of Filing year</b></th>
						<th><b>Amount</b></th>
						<th><b>Actions</b></th>
					</tr>
					<c:if test="${not empty parentBean}">

					<c:forEach items="${parentBean.adjustmentOfLossesList}" var="adjustmentOfLosses">
							<tr>
								<td><c:out value="${adjustmentOfLosses.nameOfHead}"/></td>
								<td><c:out value="${adjustmentOfLosses.assessmentYear}"/></td>
								<td><c:out value="${adjustmentOfLosses.dateStr}"/></td>
								<td><w4india:inr value="${adjustmentOfLosses.amount}" /></td>
								<td><a href="${scriptName}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/edit"><small><i class="icon-pencil"></i>Edit</small>
								</a>&nbsp;&nbsp;
								<a href="${scriptName}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/delete" data-confirm="">
								<small><i class="icon-trash"></i>Delete</small></a></td>
					        </tr>

						</c:forEach>
						<tr>
					       <td colspan="3"><fmt:message key="tds.amount.total" /></td>
					       <td><w4india:inr value="${parentBean.totalAmount}" /></td>
					    </tr>
					</c:if>

				</table>
				<a href="${scriptName}/new" class="button orange">Add New</a>
	</c:otherwise>
	</c:choose>
<res:client-validation formId="frmdataLosses" screenConfigurationDocumentName="adjustmentoflosses" formSubmitButtonId="myModalHref"/>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
function setYear(){

var assessmentyear=document.getElementById("AssessmentYear").value;
var minyear=assessmentyear.slice(0,4);
var maxyear=assessmentyear.slice(5,9);

itrFinYrMax="31/03/"+maxyear;
	itrFinYrMin="01/04/"+minyear;
			$( ".indiandateLosses" ).datepicker( "option", "minDate", itrFinYrMin );
			$( ".indiandateLosses" ).datepicker( "option", "maxDate", itrFinYrMax );
}
<!--
function checkentry(){
    var checkout=false;
	var currhead = document.getElementById("NameOfHead").value;
	var curryear = document.getElementById("AssessmentYear").value;
<c:if test="${not empty parentBean}">
<c:forEach items="${parentBean.adjustmentOfLossesList}" var="adjustmentOfLosses">
<c:set value="${adjustmentOfLosses.nameOfHead}" var="head"/>
<c:set value="${adjustmentOfLosses.assessmentYear}" var="assessmentyear"/>
if(currhead == '<c:out value="${head}"/>' && curryear == '<c:out value="${assessmentyear}"/>'){
checkout=true;
$("#chkentry").text("Warning! You have already selected "+currhead+" for "+curryear);;
}
</c:forEach>
</c:if>
if(checkout){
$("#chkentry").show();
$("#myModalHref").attr('id','abc');
}else{
$("#chkentry").hide();
}
}
 -->

</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>
