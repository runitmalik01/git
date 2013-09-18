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
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<w4india:resellername/>_files/roe.js"></script>

<%@include file="../../includes/tags.jspf" %>
<hst:link var="login" path="/login/login"/>
<hst:link var="logout" path="/login/logout"/>
<hst:link var="signup" path="/signup"/>
<hst:link var="myaccount" path="/member"/>

<!-- Right Box -->
<c:choose>
<c:when test="${not empty email}">
<ul id="main1">
    <c:forEach var="item" items="${menu.siteMenuItems}">
        <c:set var="itemLink" value="${item.hstLink}" />
        <c:if test="${not empty itemLink}">
            <hst:link var="link" link="${itemLink}"/>
            <c:choose >
                    <c:when test="${item.expanded}">
                        <li class="active">
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
        </c:if>
    </c:forEach>
</ul>
 
<div id="logloggedin" class="xr_s7">
 <fmt:message key="standard.header.login.welcome"/>,&nbsp;&nbsp;&nbsp;<c:out value="${email}"></c:out> | <a href="${myaccount}">My Account</a> | <a href="${logout}">Logout</a> 
</div>


</c:when>
<c:otherwise>

<!-- main navigation -->

<ul id="main1">
    <c:forEach var="item" items="${menu.siteMenuItems}">
        <c:set var="itemLink" value="${item.hstLink}" />
        <c:if test="${not empty itemLink}">
            <hst:link var="link" link="${itemLink}"/>
            <c:choose >
                    <c:when test="${item.expanded}">
                        <li class="active">
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
        </c:if>
    </c:forEach>
</ul>
  
<div id="log" class="xr_s7">
 <a href="${login}">Login</a> | <a href="${signup}">Signup</a> 
</div>
</c:otherwise>
</c:choose>
 <img class="xr_ap" src="<c:url value='/images/home05.png'/>" alt="headerimage" title="" style="left:165px; top: 114px; width: 980px;height: 220px;">
 
