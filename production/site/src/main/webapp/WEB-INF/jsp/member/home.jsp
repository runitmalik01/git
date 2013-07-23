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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>

<%@include file="../includes/tags.jspf" %>
<ol id="breadcrumbs">
      <li><fmt:message key="member.location.label"/></li>
      <li>
          <hst:link var="memberhome" siteMapItemRefId="memberhome" />
          <a href="${memberhome}"><fmt:message key="member.location.home"/></a> &gt;
      </li>
  </ol>
 <div id="login">
      <span class="username"><fmt:message key="standard.header.login.welcome"/>, ${user.firstname}&nbsp;${user.lastname}</span>
      <hst:link var="logoutLink" path="/login/logout" />
      <span class="first"><a class="black" href="${logoutLink}"><fmt:message key="standard.header.login.logoutlink"/></a></span>
    </div>
<h2>List of current applications</h2>
<ul>
	<li><a href="2012-2013/itr1_original_420420420PP.html"> ITR1 (Original) - 420420420PP</a></li>
	<li><a href="2012-2013/itr1_original_650420420PP.html"> ITR2 (Original) - 650420420PP</a></li>
	
</ul>
<script type="text/javascript">
function ass_year(){
	 var year=prompt("Enter the Assessment Year\nlike <year>-<year>(2012-2013)","2012-2013");
	 if(year!=null && year.match("^\\d{4}-\\d{4}$"))
	     {
	 var mod_start="startapplication?assess_year="+year;
	 var element = document.getElementById("start_link"); 
	  element.setAttribute("href", mod_start); 
	     }
	 else{
		 var mod_start="memberhome?error=assessyear";
		 var element =document .getElementById("start_link");
		 element.setAttribute("href",mod_start);
	     }
}
</script>
<h2>Start an application for Year 2012-2013</h2>
 <c:if test="${not empty assess_year_error}">
<span class="form-error"><%=request.getAttribute("assess_year_error")%></span>
</c:if>
<c:if test="${not empty status}">
<span class="form-error"><%=request.getAttribute("status")%></span>
</c:if>
<table id="profiles">
<tr>
<td><a href="startapplication/" onclick="ass_year()" id="start_link">START APPLICATION</a></td>
</tr></table>
<h2>List of Existing Profiles</h2>
<table id="application">
<tr>
<td> <c:if test="${not empty oldpan}">
              <c:forEach items="${oldpan}" var="error">
                  <c:if test="${not empty error}">
                   <a href="#"><c:out value="${error}"></c:out></a><br/>
                  </c:if>
              </c:forEach>
            </c:if></td>
</tr>
</table>
<h2>Estimation of Your Income Tax </h2>
<hst:link var="taxestimation" siteMapItemRefId="taxestimation"/>
<a href="${taxestimation}"><fmt:message key="member.tax.estimation"/></a>

<h2>profile edit</h2>
<a href="changepass">Profile Change</a>
<h2>Member Personal Information</h2>
 <c:if test="${not empty mperinfo}">
              <c:forEach items="${mperinfo}" var="personal">
                  <c:if test="${not empty personal}">
                   <a href="#"><c:out value="${personal.firstName}"></c:out></a><br/>
                  </c:if>
              </c:forEach>
            </c:if>






