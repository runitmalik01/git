<%-- This Tag File is used to invoke Dit Service which can be Specified in tag file by using Script.
    Need to include this tag if want to invoke the response of Dit Service
  --%>
<%@tag import="com.mootly.wcm.services.ScreenConfigService"%>
<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ tag trimDirectiveWhitespaces="true"%>

<%@ tag import="com.mootly.wcm.utils.*"%>
<%@ tag import="java.util.*"%>

<%-- request attribute "shouldRetrievePANInformation" should be true if want to invoke values for DIT Service.
 
     request attribute "shouldValidatePANWithDIT" should be true if you want to validate the pan of Member with DIT service of GOV.
--%>
<%
	ValueListService objValueListService = ValueListServiceImpl
			.getInstance();
	SortedSet<Map.Entry<String, String>> objMapcountry = objValueListService
			.getCountry();
	request.setAttribute("objMapcountry", objMapcountry);
	SortedSet<Map.Entry<String, String>> objMapstates = objValueListService
			.getStates();
	request.setAttribute("objMapstates", objMapstates);
%>
<hst:element var="uiCustom" name="script">
	<hst:attribute name="type">text/javascript</hst:attribute>
	<c:if test="${shouldRetrievePANInformation && not empty retrievePANResponse}">
		<%--invoke response of RetrievePANResponse to Fields of StartApplication Screen --%>
        //alert('Putting Response of DIT Service');
		<%-- Invoke DOB in Start Application Screen --%>
	  $('#pi_dob').val('<c:out value="${retrievePANResponse.DOB}" />');
	  <%-- Invoke Father Name in Start Application Screen --%>
	  $('#pi_father_name').val('<c:out value="${retrievePANResponse.fatherFullName }" />');
	  <%-- Invoke First Name in Start Application Screen 
	       As First Name will be at Start of Full Name so we Split Name and then invoke this value to Screen
	  --%>
		<c:set value="${fn:split(retrievePANResponse.fullName,' ')}" var="splittedFullName" />
	  $('#pi_first_name').val('<c:out value="${splittedFullName[0]}" />');
	  <%-- Invoke Middle Name in Start Application Screen 
	       As Middle Name will be at mid of Full Name so we Split Name and then invoke this value to Screen
	  --%>
		<c:if test="${fn:length(splittedFullName) > 2}">
			<c:forEach items="${splittedFullName}" var="namePart" varStatus="cnt">
				<c:if test="${cnt.count > 1 && cnt.count <= (fn:length(splittedFullName) -1)}">
					<c:set value="${namePart + ' ' + midName}" var="midName" />
				</c:if>
			</c:forEach>
	    $('#pi_middle_name').val('<c:out value="${fn:trim(midName)}" />');
	  </c:if>
		<%-- Invoke flat/Door/Building in Start Application Screen 
	       As flat/door/Building will be at Start of Address so we Split Address and then invoke this value to Screen
	  --%>
	  $('#pi_flat_door_building').val('<c:out value="${fn:split(retrievePANResponse.address,' ')[0]}" />');
	  <%-- Invoke Town/City/District in Start Application Screen 
	       As Town/City/District will be at someWhere in Address so we Split Address and then invoke this value to Screen
	  --%>
		<c:forEach var="booleanCombo" items="${objMapstates}">
			<c:if test="${fn:contains(retrievePANResponse.address,booleanCombo.value)}">
				<c:set value="${fn:substringBefore(retrievePANResponse.address, booleanCombo.value)}" var="strBefstate" />
				<c:set value="${booleanCombo.key}" var="resStateKey" />
			</c:if>
		</c:forEach>
		<c:set value="${fn:split(strBefstate,' ')}" var="cityTownDistct" />
	   $('#pi_town_city_district').val('<c:out value="${cityTownDistct[fn:length(cityTownDistct)-1]}" />');
	   <%-- Invoke Area/Locality in Start Application Screen 
	       As Area/Locality will be at someWhere in Address so we Split Address and then invoke this value to Screen.
	       Use "strBefstate" value remove flat/door/building with string after space("/000u") and then select string before cityTownDrict 
	  --%>
		<c:set value="${fn:substringBefore(fn:substringAfter(strBefstate,' '),cityTownDistct[fn:length(cityTownDistct)-1]) }" var="areaLocal" />
		<%-- <c:if test="${fn:length(cityTownDistct) >= 2}">
	    <c:forEach items="${cityTownDistct}" var="addrsItem" varStatus="addsct">
	      
	    </c:forEach>
	  </c:if>--%>
	  $('#pi_area_locality').val('<c:out value="${areaLocal}" />');
	  <%-- Invoke state in Start Application Screen 
	       As state will be at someWhere of Address so we Split Address and then invoke this value to Screen
	  --%>
	  $('#pi_state').val('<c:out value="${resStateKey}" />');
	  
	  </c:if>
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />