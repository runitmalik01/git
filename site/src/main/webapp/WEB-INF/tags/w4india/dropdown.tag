<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>

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

TreeMap  objTreeMapResidentialStatus =  (TreeMap) objValueListService.getResidentialStatus();
TreeMap  objTreeMapBoolean = (TreeMap) objValueListService.getBoolean();
TreeMap  objTreeMapStates = (TreeMap) objValueListService.getStates();
TreeMap  objTreeMapSchedule80CDropdown = (TreeMap) objValueListService.getSchedule80CDropdown();
TreeMap  objTreeMapAssessmentYear = (TreeMap) objValueListService.getAssessmentYear();
TreeMap  objTreeMapNameOfHead = (TreeMap) objValueListService.getNameOfHead();
TreeMap  objTreeMapNumbersDropdown = (TreeMap) objValueListService.getNumbersDropdown();

request.setAttribute("objTreeMapResidentialStatus", objTreeMapResidentialStatus);
request.setAttribute("objTreeMapBoolean", objTreeMapBoolean);
request.setAttribute("objTreeMapStates", objTreeMapStates);
request.setAttribute("objTreeMapSchedule80CDropdown", objTreeMapSchedule80CDropdown);
request.setAttribute("objTreeMapAssessmentYear", objTreeMapAssessmentYear);
request.setAttribute("objTreeMapNameOfHead", objTreeMapNameOfHead);
request.setAttribute("objTreeMapNumbersDropdown", objTreeMapNumbersDropdown);
%>

<%@ attribute name="dropDownSelectId" required="true" type="java.lang.String"  %>
<%@ attribute name="optionSelectString" required="true" type="java.lang.String" %>
<%@ attribute name="dropDownType" required="true" type="java.lang.String" %>
<%@ attribute name="dropDownFuction" required="false" type="java.lang.String" %>


<select name="${dropDownSelectId}" id="${dropDownSelectId}" onchange="${dropDownFuction}">
	<option value="">${optionSelectString}</option>
	<c:choose>
		<c:when test="${dropDownType == 'boolean'}">
			<c:forEach var="objDropDown" items="${objTreeMapBoolean}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
		</c:when>
		<c:when test="${dropDownType == 'states'}">
			<c:forEach var="objDropDown" items="${objTreeMapStates}">
				<option value="${objDropDown.key}">${objDropDown.value}</option>
			</c:forEach>
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


