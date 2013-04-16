
<%--

 @Author Dhananjay
    28/02/2013
    
    With the help of this jsp file we are showing users details 
    
--%>


<%@include file="../includes/tags.jspf" %>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="WEALTH4INDIA_files/roe.js"></script>

<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />

<link rel="stylesheet" href="http://yui.yahooapis.com/combo?3.8.1/build/cssreset/reset-min.css&amp;3.8.1/build/cssfonts/fonts-min.css&amp;3.8.1/build/cssbase/base-min.css">
<script src="http://yui.yahooapis.com/3.8.1/build/yui/yui-min.js"></script>

<!-- code to create tabs -->

<div class="table">
    <ul class="tabs">

       <li><a href="#tab1">April <c:out value="${filing_year-1}"></c:out> to March <c:out value="${filing_year}"></c:out></a></li>

       <li><a href="#tab2">April <c:out value="${filing_year-2}"></c:out> to March <c:out value="${filing_year-1}"></c:out></a></li>

       <li><a href="#tab3">April <c:out value="${filing_year-3}"></c:out> to March <c:out value="${filing_year-2}"></c:out></a></li>
   
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
		
	  <tr style="background-color: #B6BFDA; height:20px; font-size: 12px;">
		 <th>PAN</th>
		 <th>First Name</th>
		 <th>Middle Name</th>
		 <th>Last Name</th>
		 <th>DOB</th>
		 <th>Sex</th>
		 <th>Email ID</th>
		 <th>Mobile Phone</th>
		 <th>State</th>
		 <th>Return Status</th>
		 <th>Download XML</th>
		 <th>File Return</th>
		 <th>Edit</th>
	  </tr>
	  
<!-- if member personal information is not empty this will show all personal information related to that member -->

<c:if test="${not empty mpersonalinfo}">
	 <c:forEach items="${mpersonalinfo}" var="doc1">
	    <tr style="height:20px;">
	        <td id="pan"><a href="#" id="Update"><c:out value="${doc1.PAN}"></c:out></a></td>
		
	        <td><c:out value="${doc1.firstName}"></c:out></td>
		
	        <td><c:out value="${doc1.middleName}"></c:out></td>
		
	        <td><c:out value="${doc1.lastName}"></c:out></td>
		
	        <td><fmt:formatDate value="${doc1.DOB.time}" pattern="MMM dd yyyy"/></td>
		      
		    <td></td>
         
<!-- if member contact information is not empty this will show all contact information related to that member -->

<c:if test="${not empty mcontactinfo}">

     <c:forEach items="${mcontactinfo}" var="doc2">

               <c:if test="${doc2.PAN eq doc1.PAN}">

	                <td><c:out value="${doc2.email}"></c:out></td>
		
	                <td><c:out value="${doc2.mobile}"></c:out></td>
		
	                <td><c:out value="${doc2.state}"></c:out></td>
	                
	                <td><fmt:message key="member.information.returnstatus"/></td>
	                
	                <td><a href="#" onClick="showAlert()"><img src="<c:url value='/images/downloadbutton.png'/>" alt="Download" style="width: 70px; height: 35px;"/></a></td>
		
		            <td><a href="#" onClick="showAlert()"><img src="<c:url value='/images/continuebutton.png'/>" alt="Continue" style="width: 70px; height: 35px;"/></a></td>
		            
		            <td><a href="#" title="I want to edit my entry and I have not uploaded to IT Web Site">
		                <img src="<c:url value='/images/edit-pencil.gif'/>" alt="Continue" style="width:20px; height:12px;"/>
		                </a>
		            </td>
		            
               </c:if>
      </c:forEach>
</c:if>

       </tr>
                 
    </c:forEach>
</c:if>
            
</table>
	     <div class="addpan" align="center"> 
	                     <hst:link var="startapplication" siteMapItemRefId="startapplication"></hst:link>
               <a href="${startapplication}"><c:out value="Add New PAN"></c:out></a> 
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

<!-- code for popup window -->

<div class="yui3-u-1">

    <div id="dt"></div>

         <div id="panelContent">
         
             <form id="frmRating" action="${actionUrl}" method="post" name="pi">
                  <div id="demo" class="yui3-module">
                      <div class="yui3-hd">
                          <h2>Personal Information</h2>
                      </div>
                  <div class="yui3-bd" align="center">
                      <table class="personal_info">
                            <tr height="30px">
	                            <td class="label"><fmt:message key="member.personal_info.pan"/></td>
	                            <td class="input">
                                   <input type="text" name="pi_pan" value="<c:out value="${document.PAN}"/>" onclick="" required="required"
                                           maxlength="10" style="text-transform: uppercase;" pattern="^[A-Z]{5}\d{4}[A-Z]$" 
                                           title="Fist Five alphabets,next four digits then alphabet(exactly 10 char)"/>
	                                <c:if test="${not empty errors}">
                                          <c:forEach items="${errors}" var="error">
                                                    <c:if test="${error eq 'Enter a valid PAN'}">
                                                         <span class="form-error"><fmt:message key="member.personal_info.pan.error"/></span>
                                                    </c:if>
                                          </c:forEach>
                                   </c:if>
                                 <c:if test="${not empty errors}">
                                       <c:forEach items="${errors}" var="error">
                                                 <c:if  test="${error eq 'invalid.pan-label'} ">
                                                      <span class="form-error"><fmt:message key="member.personal_info.pan.error2"/></span>
                                                 </c:if>
                                       </c:forEach>
                                 </c:if>
	                          </td>
	                     </tr>
	                 <tr height="30px">
	                    <td class="label" colspan="2" align="center"><fmt:message key="member.personal_info.status"/></td>
	                </tr>
	               <tr height="30px">
	                  <td class="select" colspan="2" align="center">
	                      <select name="status">
	                             <option id="1">Yes, as an individual </option></select>
	                  </td>
	              </tr>
               <tr height="30px">
                   <td class="label"><fmt:message key="member.personal_info.firstname"/> </td>
	                   <td class="input"> <input type="text" name="pi_first_name" value="<c:out value="${document.firstName}"/>" title="Enter First Name" onkeyup="AllowAlphabets()"/>
	                      <c:if test="${not empty errors}">
                               <c:forEach items="${errors}" var="error">
                                          <c:if test="${error eq 'invalid.fname-label'}">
                                               <span class="form-error"><fmt:message key="member.personal_info.firstname.error"/></span>
                                          </c:if>
                               </c:forEach>
                         </c:if>
	                </td>
	            </tr>
	        <tr height="30px">
	           <td class="label"><fmt:message key="member.personal_info.middlename" /></td>
	               <td class="input"><input type="text" name="pi_middle_name" value="${fn:escapeXml(pi_middle_name)}" title="Enter Middle Name(if any)" onkeyup="AllowAlphabets()"/></td></tr>      
	       <tr height="30px">
	          <td class="label"><fmt:message key="member.personal_info.lastname"/></td>
	              <td class="input"><input type="text" name="pi_last_name" value="${fn:escapeXml(pi_last_name)}" required="required" title="Last Name should not blank" onkeyup="AllowAlphabets()"/>
	                  <c:if test="${not empty errors}">
                            <c:forEach items="${errors}" var="error">
                                      <c:if test="${error eq 'invalid.lname-label'}">
                                           <span class="form-error"><fmt:message key="member.personal_info.lastname.error"/></span>
                                      </c:if>
                            </c:forEach>
                     </c:if>
	             </td>
	        </tr>
	     <tr height="30px">
	         <td class="label"><fmt:message key="member.personal_info.fathername"/></td>
	             <td class="input"><input type="text" name="pi_father_name" value="${fn:escapeXml(pi_father_name)}" title="Enter Father Name" onkeyup="AllowAlphabets()"/>
	                <c:if test="${not empty errors}">
                         <c:forEach items="${errors}" var="error">
                             <c:if test="${error eq 'invalid.father-label'}">
                                <span class="form-error"><fmt:message key="member.personal_info.fathername.error"/></span>
                             </c:if>
                        </c:forEach>
                   </c:if>
	          </td>
	     </tr>   
	  <tr height="30px">
	     <td class="label"><fmt:message key="member.personal_info.gender"/></td>
	         <td class="input"><input type="radio" name="gender" value="true" checked="checked"/>Male <input type="radio" name="gender" value="false"/>Female</td></tr> 
	  <tr height="30px">
	      <td class="label" width="150px"><fmt:message key="member.personal_info.dob"/></td>
	           <td class="input"><input type="date" name="pi_dob" required="required"/>
	               <c:if test="${not empty errors}">
                        <c:forEach items="${errors}" var="error">
                           <c:if test="${error eq 'invalid.dob-label'}">
                                <span class="form-error"><fmt:message key="member.personal_info.dob.error"/></span>
                           </c:if>
                       </c:forEach>
                  </c:if>
	          </td>
	     </tr>    
	  <tr height="40px">
         <td>&nbsp;</td>
             <td class="submit fright" colspan="2" align="center"><input type="image" src="images/next-button-png-hi.png" height="38px" width="90px" /></td>
     </tr>           
</table>
      <br/>
    </div>
</div>
     <br/>
</form>
    </div>
</div>

<div id="nestedPanel" style=" background-color: gray;"></div>

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

<hst:headContribution keyHint="listcss">
<link type="text/css" rel="stylesheet" href='<hst:link path="/css/tabnav.css"/>'/>
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
<link rel="stylesheet" href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>' type="text/css"/>
</hst:headContribution>
<hst:headContribution keyHint="formcss">
<link rel="stylesheet" href='<hst:link path="/css/animation/animation.css"/>' type="text/css"/>
</hst:headContribution>
<hst:headContribution keyHint="form-animation" category="jsInternal"> 
<script type="text/javascript" src='<hst:link path="/js/details.js"/>'></script>
</hst:headContribution>