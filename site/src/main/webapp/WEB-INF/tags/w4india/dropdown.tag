<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>

<%

//create TreeMap object of boolean values  
ValueListService  objValueListService = ValueListServiceImpl.getInstance();

TreeMap<String ,String>  objTreeMapResidentialStatus =  (TreeMap<String ,String>) objValueListService.getResidentialStatus();
TreeMap<String ,String>  objTreeMapBoolean = (TreeMap<String ,String>) objValueListService.getBoolean();
TreeMap<String ,String>  objTreeMapStates = (TreeMap<String ,String>) objValueListService.getStates();
TreeMap<String ,String>  objTreeMapForeignStates = (TreeMap<String ,String>) objValueListService.getForeignState();
TreeMap<String ,String>  objTreeMapUnionTerritory = (TreeMap<String ,String>) objValueListService.getUnionTerritory();
TreeMap<String ,String>  objTreeMapSchedule80CDropdown = (TreeMap<String ,String>) objValueListService.getSchedule80CDropdown();
TreeMap<String ,String>  objTreeMapAssessmentYear = (TreeMap<String ,String>) objValueListService.getAssessmentYear();
TreeMap<String ,String>  objTreeMapNameOfHead = (TreeMap<String ,String>) objValueListService.getNameOfHead();
TreeMap<String ,String>  objTreeMapNumbersDropdown = (TreeMap<String ,String>) objValueListService.getNumbersDropdown();
request.setAttribute("objTreeMapResidentialStatus", objTreeMapResidentialStatus);
request.setAttribute("objTreeMapBoolean", objTreeMapBoolean);
request.setAttribute("objTreeMapStates", objTreeMapStates);
request.setAttribute("objTreeMapForeignStates", objTreeMapForeignStates);
request.setAttribute("objTreeMapUnionTerritory", objTreeMapUnionTerritory);
request.setAttribute("objTreeMapSchedule80CDropdown", objTreeMapSchedule80CDropdown);
request.setAttribute("objTreeMapAssessmentYear", objTreeMapAssessmentYear);
request.setAttribute("objTreeMapNameOfHead", objTreeMapNameOfHead);
request.setAttribute("objTreeMapNumbersDropdown", objTreeMapNumbersDropdown);

%>

<%@ attribute name="dropDownSelectId" required="true" type="java.lang.String"  %>
<%@ attribute name="optionSelectString" required="true" type="java.lang.String" %>
<%@ attribute name="dropDownType" required="true" type="java.lang.String" %>
<%@ attribute name="dropDownFuction" required="false" type="java.lang.String" %>
<%@ attribute name="dropDownSize" required="false" type="java.lang.String" %>
<%@ attribute name="fetchValue" required="false" type="java.lang.String" %>

<%@ attribute name="dropDownSelectName" required="false" type="java.lang.String" %>


<select name="${dropDownSelectName == null? dropDownSelectId : dropDownSelectName}" id="${dropDownSelectId}" onchange="${dropDownFuction}" size="${dropDownSize}">
	<option value="">${optionSelectString}</option>
	<c:choose>
		<c:when test="${dropDownType == 'boolean'}">
			<c:forEach var="objDropDown" items="${objTreeMapBoolean}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'states'}">
			<c:forEach var="objDropDown" items="${objTreeMapStates}">
				<option value="${objDropDown.key}" <c:if test="${fetchValue eq objDropDown.key}">Selected</c:if>>${objDropDown.value}</option>
			</c:forEach>
			<optgroup label="Union Territories">
			    <c:forEach var="objDropDown" items="${objTreeMapUnionTerritory}">
				   <option value="${objDropDown.key}" <c:if test="${fetchValue eq objDropDown.key}">Selected</c:if>>${objDropDown.value}</option>
			    </c:forEach>
			</optgroup>
			<optgroup label="Others">
			    <c:forEach var="objDropDown" items="${objTreeMapForeignStates}">
				   <option value="${objDropDown.key}" <c:if test="${fetchValue eq objDropDown.key}">Selected</c:if>>${objDropDown.value}</option>
			    </c:forEach>
			</optgroup>
		</c:when>
		<c:when test="${dropDownType == 'assessmentyear'}">
			<c:forEach var="objDropDown" items="${objTreeMapAssessmentYear}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'nameofhead'}">
			<c:forEach var="objDropDown" items="${objTreeMapNameOfHead}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'residentialStatus'}">
			<c:forEach var="objDropDown" items="${objTreeMapResidentialStatus}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'schedule80CDropdown'}">
			<c:forEach var="objDropDown" items="${objTreeMapSchedule80CDropdown}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'numbersDropdown'}">
			<c:forEach var="objDropDown" items="${objTreeMapNumbersDropdown}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</select>


