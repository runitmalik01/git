
<%--

 @Author Dhananjay
    28/02/2013
    
    With the help of this jsp file we are showing users details 
    
--%>


<%@include file="../includes/tags.jspf"%>

<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="memberfrontpagetitle">
	<fmt:message key="member.overview.title" />
</c:set>
<hippo-gogreen:title title="${memberfrontpagetitle}" />
<hst:link var="startapp" path="/startapplication" />
		<table class="footable" data-filter="#filter">
			<thead>
				<tr>
					<th data-class="expand"><fmt:message key="member.front.page.pan"></fmt:message></th>
					<th>Name</th>
					<th id='pi' data-hide="phone,tablet">Personal Information</th>
					<th data-hide="phone,tablet">Contact Details</th>
					<th data-hide="phone,tablet">Residential Status</th>
					<th data-hide="phone,tablet">Source of Income</th>
					<th data-hide="phone,tablet">Deductions</th>
					<th data-hide="phone,tablet">Rebates</th>
					<th data-hide="phone,tablet">Interests</th>
					<th><fmt:message key="member.front.page.returnstatus"></fmt:message></th>
					<th data-hide="phone,tablet"><fmt:message key="member.front.page.downloadxml"></fmt:message></th>
					<th data-hide="phone,tablet"><fmt:message key="member.front.page.filereturn"></fmt:message></th>
					<th data-hide="phone,tablet"><fmt:message key="member.front.page.edit"></fmt:message></th>
				</tr>
			</thead>
			<!-- if member personal information is not empty this will show all personal information related to that member -->
			<c:forEach items="${mpersonalinfo}" var="doc1">
				<tr>
					<td><c:out value="${doc1.PAN}"/></td>
					<td><c:out value="${doc1.firstName}"/></td>
					<td><c:out value="${member.information.returnstatus}"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>


<!-- code for personal information popup window -->


<script>

function showAlert(){
	alert("Fill your complete details");
}

$(document).ready(function() {

 //When page loads...

 $(".tab_content").hide(); //Hide all content

 $("ul.tabs li:first").addClass("active").show(); //Activate first tab

 $(".tab_content:first").show(); //Show first tab content
 

 //On Click Event

 $("ul.tabs li").click(function() {

  $("ul.tabs li").removeClass("active"); //Remove any "active" class

  $(this).addClass("active"); //Add "active" class to selected tab

  $(".tab_content").hide(); //Hide all tab content

  var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
    
  $(activeTab).fadeIn(); //Fade in the active ID content

  return false;

 });

});

</script>
<hst:link var="footablecss" path="/css/footable-0.1.css" />
<hst:headContribution category="jsExternal">
	<link href="${footablecss}" rel="stylesheet" type="text/css" />
</hst:headContribution>
<hst:link var="footablejs" path="/js/footable-0.1.js" />
<hst:headContribution category="jsExternal">
	<script src="${footablejs}" type="text/javascript"></script>
</hst:headContribution>

<hst:headContribution category="jsInternal">
	<script type="text/javascript">
		  $(function() {
		    $('.footable').footable();
		  });
	</script>
</hst:headContribution>

<hst:headContribution keyHint="listcss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/tabnav.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
	<link rel="stylesheet"
		href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>'
		type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/show-hide-panel.css"/>' type="text/css" />
</hst:headContribution>

