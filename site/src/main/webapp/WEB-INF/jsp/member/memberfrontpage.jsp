
<%--

 @Author Dhananjay
    28/02/2013
    
    With the help of this jsp file we are showing users details 
    
--%>


<%@include file="../includes/tags.jspf" %>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@include file="../includes/commonincludes.jspf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="WEALTH4INDIA_files/roe.js"></script>

<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<c:set var="memberfrontpagetitle"><fmt:message key="member.overview.title"/></c:set>
<hippo-gogreen:title title="${memberfrontpagetitle}"/>

<!-- code to create tabs -->

<div class="table">
    <ul class="tabs">

       <li><a href="#tab1">April <c:out value="${filingyear+1899}"></c:out> to March <c:out value="${filingyear+1900}"></c:out></a></li>

       <li><a href="#tab2">April <c:out value="${filingyear+1898}"></c:out> to March <c:out value="${filingyear+1899}"></c:out></a></li>

       <li><a href="#tab3">April <c:out value="${filingyear+1897}"></c:out> to March <c:out value="${filingyear+1898}"></c:out></a></li>
   
   </ul>

<div class="tab_container">

<div id="tab1" class="tab_content">

  <div id="notification">

     <h2><fmt:message key="notification.overview.content.title"/></h2>
        
     <%--@elvariable id="notification" type="java.util.List<com.mootly.wcm.beans.NotificationItem>"--%>

		<c:forEach items="${notification.items}" var="notificationitems" varStatus="status">
			<ul class="notification-item <c:if test="${preview}">editable</c:if>">
				<hst:link var="link" hippobean="${notificationitems}" />
				
				<!-- code to show notification title -->
				
				<li class="title">
				    <hst:cmseditlink hippobean="${notificationitems}" /> 
				    <c:out value="${notificationitems.title}" />
				</li>
				
				<!-- code to show notification date -->
				
				<li class="date">
				    <fmt:formatDate value="${notificationitems.date.time}" type="date" pattern="MMM d, yyyy" /></li>
				
				<!-- code to show notification summary -->
				
				<li class="description">
				    <c:out value="${notificationitems.summary}" />
				</li>
				
			</ul>
			
		</c:forEach>
			
<!-- code to check is there any notification available -->
    
     <c:choose>
        <c:when test="${notification.total eq 0}">
           <p id="results"><fmt:message key="search.results.noresults"/> '${query}'</p>
        </c:when>
        <c:otherwise>
           <hippo-gogreen:pagination pageableResult="${notification}" queryName="query" queryValue="${query}"/>
        </c:otherwise>
        </c:choose>
</div>

<!-- Showing values of member personal information and member contact information -->

<div id="information">

<table border="2" style="min-width: 900px;">
		
	 <tr style="background-color: #B6BFDA; height:40px; font-size: 12px;">
		 <th><fmt:message key="member.front.page.pan"></fmt:message></th>
		 <th><fmt:message key="member.front.page.firstname"></fmt:message></th>
		 <th><fmt:message key="member.front.page.middlename"></fmt:message></th>
		 <th><fmt:message key="member.front.page.lastname"></fmt:message></th>
		 <th><fmt:message key="member.front.page.dob"></fmt:message></th>
		 <th><fmt:message key="member.front.page.sex"></fmt:message></th>
		 <th><fmt:message key="member.front.page.emailid"></fmt:message></th>
		 <th><fmt:message key="member.front.page.mobile"></fmt:message></th>
		 <th><fmt:message key="member.front.page.state"></fmt:message></th>
		 <th><fmt:message key="member.front.page.returnstatus"></fmt:message></th>
		 <th><fmt:message key="member.front.page.downloadxml"></fmt:message></th>
		 <th><fmt:message key="member.front.page.filereturn"></fmt:message></th>
		 <th><fmt:message key="member.front.page.edit"></fmt:message></th>
	  </tr>
	  
<!-- if member personal information is not empty this will show all personal information related to that member -->

<c:if test="${not empty mpersonalinfo}">
	 <c:forEach items="${mpersonalinfo}" var="doc1">
	    <tr style="height:20px;">
	        <td><a href="startapplication?pan=<c:out value="${doc1.PAN}"/>" ><c:out value="${doc1.PAN}"></c:out></a></td>
	        
	        <td><c:out value="${doc1.firstName}"></c:out></td>
		
	        <td><c:out value="${doc1.middleName}"></c:out></td>
		
	        <td><c:out value="${doc1.lastName}"></c:out></td>
		
	        <td><fmt:formatDate value="${doc1.DOB.time}" pattern="MMM dd yyyy"/></td>
		      
		    <td><c:if test="${doc1.sex eq 'M'}"><c:out value="Male"></c:out></c:if><c:if test="${doc1.sex eq 'F'}"><c:out value="Female"></c:out></c:if></td>
         
<!-- if member contact information is not empty this will show all contact information related to that member -->

<c:if test="${not empty mcontactinfo}">

     <c:forEach items="${mcontactinfo}" var="doc2">

               <c:if test="${doc2.PAN eq doc1.PAN}">

	                <td><c:out value="${doc2.email}"></c:out></td>
		
	                <td><c:out value="${doc2.mobile}"></c:out></td>
		
	                <td><c:out value="${doc2.state}"></c:out></td>
	                
	                <td><fmt:message key="member.information.returnstatus"/></td>
	                
	                <td><img src="<c:url value='/images/downloadbutton.png'/>" alt="Download" style="width: 70px; height: 35px;"/></td>
		
		            <td id="continue"><a href="sourceofincome?pan=<c:out value="${doc1.PAN}"/>"><img src="<c:url value='/images/continuebutton.png'/>" alt="Continue" style="width: 70px; height: 35px;"/></a></td>
		            
		            <td>
		                <img src="<c:url value='/images/edit-pencil.gif'/>" alt="Continue"  style="width:20px; height:12px;"/>		               
		            </td>
		            
               </c:if>
      </c:forEach>
</c:if>

       </tr>
                 
    </c:forEach>
</c:if>
            
</table>
	     <div class="addpan" align="center"> 
	           <hst:link var="startapplication" path="/member/itreturn/2012-2013/original/"></hst:link>
               <a href="javascript:getPANAndContinue()"><c:out value="Add New PAN"></c:out></a> 
          </div>
</div>

</div>

 <div id="tab2" class="tab_content">
         <span id="label"><fmt:message key="member.itr.status"/></span>
         <img class="image" src="<c:url value='/images/continue-button.png'/>" alt="continue"/> 
         <span class="continue"><fmt:message key="member.itr.continue"/></span>
 
 <table>
        
       <tr height="40px"><td width="150px" align="left" id="label1">Period :</td><td align="left" id="label2">1st April 2011 to 31st March 2012</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Financial Year :</td><td align="left" id="label2">2011-12</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Assessment Year :</td><td align="left" id="label2">2012-13</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Due Date :</td><td align="left" style="color:red;" id="label2">31st August 2012</td></tr>
 </table>
 
 </div>
 

<div id="tab3" class="tab_content">
       <span id="label"><fmt:message key="member.itr.status"/></span>
       <img class="image" src="<c:url value='/images/continue-button.png'/>" alt="continue"/>
       <span class="continue"><fmt:message key="member.itr.continue"/></span>

<table>
       
       <tr height="40px"><td width="150px" align="left" id="label1">Period :</td><td align="left" id="label2">1st April 2010 to 31st March 2011</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Financial Year :</td><td align="left" id="label2">2010-11</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Assessment Year :</td><td align="left" id="label2">2011-12</td></tr>
       <tr height="40px"><td width="150px" align="left" id="label1">Due Date :</td><td align="left" style="color:red;" id="label2">31st July 2011</td></tr>
</table>

</div>

</div>

</div>

<!-- code for personal information popup window -->


<script>

function getPANAndContinue() {
	pan = null;
	while (true) {
		pan = prompt("Please enter the PAN Number");
		var n = pan.match(/^[\w]{3}(p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G)[\w][\d]{4}[\w]$/g);
		if (n == null) {
			alert("Invalid PIN Please reenter");
		}
		else {
			break;
		}
	}
	window.location.href="<hst:link path='/member/itreturn/2012-2013/original/'/>/" + pan.toLowerCase() + "/servicerequest-itr.html";
}

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

<hst:headContribution keyHint="listcss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/tabnav.css"/>'/>
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
<link rel="stylesheet" href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>' type="text/css"/>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
<link rel="stylesheet" href='<hst:link path="/css/show-hide-panel.css"/>' type="text/css"/>
</hst:headContribution>