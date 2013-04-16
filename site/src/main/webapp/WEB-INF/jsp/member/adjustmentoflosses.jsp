
<%--
@author Dhananjay Panwar
13/03/2013
 --%>

<%@include file="../includes/commonincludes.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.AdjustmentOfLossesCom"%>
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

<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
	String modifiedSiteMapRefId = varToReplace.replaceAll("_default_",pan);
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		// binds form submission and fields to the validation engine
		jQuery("#frmdata").validationEngine();
	});
</script>

<!-- used to set date according to assessment year -->
<script>
function setYear(){

var assessmentyear1=document.getElementById("year").value;

var assessmentyear2=assessmentyear1.slice(0,4);
var assessmentyear2d=assessmentyear2+"-01-01";

var assessmentyear3=assessmentyear1.slice(5,9);
var assessmentyear3d=assessmentyear3+"-12-31";

document.getElementById("filingyear").setAttribute("min",assessmentyear2d);
document.getElementById("filingyear").setAttribute("max",assessmentyear3d);
}
</script>

<!-- used to set title  -->

<c:set var="adjustmentoflossestitle">
      <fmt:message key="member.adjustment.content.title" />
</c:set>
<hippo-gogreen:title title="${adjustmentoflossestitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">Home</a></span> 
	<span class="chevron">&#187;</span> 
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My Income Tax Returns</a></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><c:out value="${pan}"/></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><select style="width:120px"><option>Losses</option><option>a</option><option>a</option></select></span>
</div>

<div class="page type-page">
	<h3 id="respond1">Losses</h3>
	<c:if test="${not empty formMap}">
		<c:forEach items="${formMap.message}" var="item">
			<div class="alert alert-error"><c:out value="${item.key}"/> - <c:out value="${item.value}"/> </div>
		</c:forEach>
	</c:if>
	<c:choose>
	<c:when test="${pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD'}">
		<form id="frmdata" action="${actionUrl}" name="frmdata" method="post" class="formular">
			<fieldset>
				<legend>Detail Of Losses</legend>
				<p>
					<label for="AssessmentYear"> <fmt:message key="member.adjustment.losses.year"></fmt:message></label>
					<select name="AssessmentYear" class="validate[required] text-input" id="year" onChange="setYear()">
						  <option value="">Select Year</option>
						  <c:forEach var="booleanCombo" items="${objHashMapAssessmentYear}">
						  <option "<c:if test="${pageAction == 'EDIT_CHILD' && childBean.AssessmentYear == booleanCombo.value}">selected</c:if>" value="${booleanCombo.value}">${booleanCombo.value}</option>
						  </c:forEach>
					</select>
				</p>
				<p>
					<label for="NameOfHead"><fmt:message key="member.adjustment.losses.name"></fmt:message></label>
					      <select name="NameOfHead" id="name" class="validate[required] text-input">
					             <option value="">-Select Head-</option>
					             <c:forEach var="booleanCombo" items="${objHashMapNameOfHead}">
					             <option "<c:if test="${pageAction == 'EDIT_CHILD' && childBean.NameOfHead == booleanCombo.value}">selected</c:if>" value="${booleanCombo.value}">${booleanCombo.value}</option>
						         </c:forEach>
					      </select>
				</p>
				<p>
					<label for="Amount"><fmt:message key="member.adjustment.losses.amount" /></label>
					<input id="Amount" class="validate[required] text-input" type="text" name="Amount" maxlength="14" id="amount" value="<c:if test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.Amount}"/></c:if>">
				</p>
				<p>
					<label for="DateOfFilingYear"><fmt:message key="member.adjustment.losses.date"></fmt:message></label>
					<input type="date" name="DateOfFilingYear" id="filingyear" class="validate[required] text-input"  value="<c:if test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.DateOfFilingYear}"/></c:if>">
				</p>
					<p>
					<label for="DueDate"><fmt:message key="member.adjustment.losses.duedate"></fmt:message></label>
					     <select name="DueDate" id="due" class="validate[required] text-input">
					            <option value="">-Select Date-</option>
								<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
					             <option "<c:if test="${pageAction == 'EDIT_CHILD' && childBean.DueDate == booleanCombo.value}">selected</c:if>" value="${booleanCombo.value}">${booleanCombo.value}</option>
						         </c:forEach>
					      </select>
				</p>
			</fieldset>
			
		</form>
		<a href="${modifiedSiteMapRefId}" class="button olive">Cancel</a>&nbsp;
		<input type="submit" id="submit" class="button olive" onclick="save()" value="Save"/>
	</c:when>
	<c:otherwise>				
				<table>
					<tr align="center">
						<th><b>Name Of Head</b></th>
						<th><b>Assessment Year</b></th>
						<th><b>Amount</b></th>
						<th><b>Date Of Filing Year</b></th>
						<th><b>Actions</b></th>
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.AdjustmentOfLossesDoc}" var="adjustmentOfLosses">
							<tr>
								<td><a href="${modifiedSiteMapRefId}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/edit"><c:out value="${adjustmentOfLosses.NameOfHead}"/></a></td>
								<td><c:out value="${adjustmentOfLosses.AssessmentYear}"/></td>
								<td><c:out value="${adjustmentOfLosses.Amount}"/></td>
								<td><c:out value="${adjustmentOfLosses.DateOfFilingYear}"/></td>
								<td><a href="${modifiedSiteMapRefId}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${modifiedSiteMapRefId}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
							</tr>
						</c:forEach>					
					</c:if>			
				</table>
				<a href="${modifiedSiteMapRefId}/new" class="button orange">Add New</a>
	</c:otherwise>
	</c:choose>
</div>
<script>
function save(){
	$("#frmdata").submit();
}
</script>