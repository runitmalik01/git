
<%--
@author Dhananjay Panwar
13/03/2013
 --%>

<%@include file="../includes/commonincludes.jspf"%>
<%@page import="com.mootly.wcm.beans.compound.AdjustmentOfLossesCom"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>

<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
 String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("adjustmentoflosses.html","deductions.html");
 pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
 pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>

  <script>
  $(function() {
	  
	  jQuery("#frmdata").validationEngine();
	  
	  if (Modernizr.touch && Modernizr.inputtypes.date) {
          
          document.getElementById('date_credit').type = 'date';
          
      } else {
          $('#DateOfFilingYear').datepicker({
                   changeMonth: true,
                   changeYear: true,
                 
                  });            
      }	  	
  });
  </script>
 
<%

ValueListService  objValueListService = ValueListServiceImpl.getInstance();
TreeMap  objHashMapAssessmentYear= (TreeMap) objValueListService.getAssessmentYear();
request.setAttribute("objHashMapAssessmentYear", objHashMapAssessmentYear);

TreeMap  objHashMapNameOfHead= (TreeMap) objValueListService.getNameOfHead();
request.setAttribute("objHashMapNameOfHead", objHashMapNameOfHead);

TreeMap  objHashMapBoolean= (TreeMap) objValueListService.getBoolean();
request.setAttribute("objHashMapBoolean", objHashMapBoolean);
%>

<!-- used to set calendar  according to assessment year -->
<script>
function setYear(){
	
var assessmentyear=document.getElementById("year").value;

var minyear=assessmentyear.slice(0,4);
var maxyear=assessmentyear.slice(5,9);

jQuery('#DateOfFilingYear').datepicker('destroy');
    $('#DateOfFilingYear').datepicker({
             changeMonth: true,
             changeYear: true,
             yearRange: minyear+":"+maxyear
             
            });     
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
		<form id="frmdata" action="${actionUrl}" name="frmdata" method="post">
			<fieldset>
				<legend>Detail Of Losses</legend>
				<p>
					<label for="AssessmentYear"> <fmt:message key="member.adjustment.losses.year"></fmt:message></label>
					<select name="AssessmentYear" id="year" onChange="setYear()">
						  <option value="">-Select Year-</option>
						  <c:forEach var="booleanCombo" items="${objHashMapAssessmentYear}">
						  <option <c:if test="${pageAction == 'EDIT_CHILD' && childBean.assessmentYear == booleanCombo.value}">selected</c:if> value="${booleanCombo.value}">${booleanCombo.value}</option>
						  </c:forEach>
					</select>
				</p>
				<p>
					<label for="NameOfHead"><fmt:message key="member.adjustment.losses.name"></fmt:message></label>
					      <select name="NameOfHead" id="name">
					             <option value="">-Select Head-</option>	            
					             <c:forEach var="booleanCombo" items="${objHashMapNameOfHead}">

					             <option <c:if test="${pageAction == 'EDIT_CHILD' && childBean.nameOfHead == booleanCombo.value}">selected</c:if>
					                                value="${booleanCombo.value}">${booleanCombo.value}</option>
						             
						         </c:forEach>
					      </select>
				</p>
				<p>
					<label for="Amount"><fmt:message key="member.adjustment.losses.amount" /></label>
					<input id="Amount" maxlength="14" type="text" name="Amount" id="amount" value="<c:if test="${pageAction == 'EDIT_CHILD'}"><c:out value="${childBean.amount}"/></c:if>"/>
				</p>
				<p>
					<label for="DateOfFilingYear"><fmt:message key="member.adjustment.losses.date"></fmt:message></label>
					 <input  id="DateOfFilingYear" name="DateOfFilingYear" value="${childBean.DOBStr}" onClick="setYear()"/> 
				</p>
					<p>
					<label for="DueDate"><fmt:message key="member.adjustment.losses.duedate"></fmt:message></label>
					     <select name="DueDate" id="due">
					            <option value="">-Select-</option>
								<c:forEach var="booleanCombo" items="${objHashMapBoolean}">
					             <option <c:if test="${pageAction == 'EDIT_CHILD' && childBean.dueDate == booleanCombo.value}">selected</c:if> value="${booleanCombo.value}">${booleanCombo.value}</option>
						         </c:forEach>
					      </select>
				</p>
			</fieldset>
			
		</form>
		<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>&nbsp;
		<input type="submit" id="submit" class="button olive" onclick="save()" value="Save"/>
	</c:when>
	<c:otherwise>				
				<table>
					<tr align="center">
						<th><b>Name Of Head</b></th>
						<th><b>Assessment Year</b></th>
						<th><b>Amount</b></th>
						<th><b>Date Of Filing year</b></th>
						<th><b>Actions</b></th>
					</tr>
					<c:if test="${not empty parentBean}">
					
					<c:forEach items="${parentBean.adjustmentOfLossesList}" var="adjustmentOfLosses">
							<tr>
								<td><a href="${redirectURLToSamePage}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/edit"><c:out value="${adjustmentOfLosses.nameOfHead}"/></a></td>
								<td><c:out value="${adjustmentOfLosses.assessmentYear}"/></td>
								<td><c:out value="${adjustmentOfLosses.amount}"/></td>
								<td><c:out value="${adjustmentOfLosses.DOBStr}"/></td>
								<td><a href="${redirectURLToSamePage}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${adjustmentOfLosses.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
					        </tr>
					       
						</c:forEach>	
						 <tr align="center"><td colspan="2">Total Amount</td><td><c:out value="${parentBean.totalAmount}"></c:out></td>					
					</c:if>		
					
				</table>
				<a href="${redirectURLToSamePage}/new" class="button orange">Add New</a>
				<a href="${modifiedSiteMapRefId}" class="button orange">Next</a>
	</c:otherwise>
	</c:choose>
</div>

<script>
function save(){
			$("#frmdata").submit();
}
</script>