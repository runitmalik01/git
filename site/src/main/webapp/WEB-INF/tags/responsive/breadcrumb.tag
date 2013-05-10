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
<%@ attribute name="breadcrumType" required="false" type="java.lang.String" %>
<ul class="breadcrumb">
   <li><a href="#">Home</a> <span class="divider">/</span></li>
   <li><a href="#">IT Return</a> <span class="divider">/</span></li>
   <li>
      <a href="#">
         FY(
         <c:out value="${financialYear}"/>
         )
      </a>
      <span class="divider">/</span>
   </li>
   <li class="active">
      <div class="btn-group">
         <button class="btn btn-info dropdown-toggle pan" data-toggle="dropdown">
            <c:out value="${pan}"/>
            <span class="caret"></span>
         </button>
         <ul class="dropdown-menu">
         	<%--
            <li><a href="#">Amit Patkar</a></li>
            <li><a href="#"><b>DOB:</b>12/12/2012</a></li>
            <li><a href="#"><b>Age:</b>23 Years</a></li>
             --%>
            <li><a href="#"><b>Type:</b><c:out value="${itReturnType}"/></a></li>
            <li><a href="#"><b>Status:</b><c:out value="${filingStatus}"/></a></li>
            <li>
               <a href="#">
                  FY:
                  <c:out value="${financialYear}"/>
               </a>
            </li>
            <!-- <li class="divider"></li>
               <li><a href="#">Go back to PAN Home</a></li>
                -->
         </ul>
      </div>
      <span class="divider">/</span>
   </li>
   <li>
   <c:choose>
   <c:when test="${not empty breadcrumType }">
   <c:out value="${breadcrumType}"/>
   </c:when>
   <c:otherwise>
   <c:out value="${filingStatus}"/> Information
   </c:otherwise>
      
      </c:choose>
   </li>
   
</ul>

