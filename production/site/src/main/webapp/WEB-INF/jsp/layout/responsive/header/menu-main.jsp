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
<%@page import="java.util.List"%>
<%@page import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../../includes/tags.jspf" %>

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
<%@include file="../../../includes/tags.jspf" %>
<ul id="menu-main" class="menu">
    <c:forEach var="item" items="${menu.siteMenuItems}">
        <c:set var="itemLink" value="${item.hstLink}" />
        <c:if test="${not empty itemLink}">
            <hst:link var="link" link="${itemLink}"/>
             <%
              		HstSiteMenuItem item = (HstSiteMenuItem) pageContext.getAttribute("item");
              		List<HstSiteMenuItem>	childMenuItems = item.getChildMenuItems();
              		if (childMenuItems != null && childMenuItems.size() > 0) {
              			pageContext.setAttribute("hasChildren","1");
              		}
              		else {
              			pageContext.setAttribute("hasChildren","0");
              		}
			%>
            <c:choose >
                    <c:when test="${item.expanded}">
                        <li class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-761">
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                           <c:if test="${hasChildren == '1'}">
	                           <ul class="sub-menu">
	                           		<c:forEach items="${item.childMenuItems}"  var="childItem">
	                           			<c:set var="childItemLink" value="${childItem.hstLink}" />
	                           			<hst:link var="childLink" link="${childItemLink}"/>
										<li  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-776"><a href="${fn:escapeXml(childLink)}"><c:out value="${childItem.name}"/></a></li>
									</c:forEach>
								</ul>
							</c:if>                           
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="menu-item menu-item-type-custom menu-item-object-custom  menu-item-home menu-item-761">
                           <c:set var="totalChildren" value="${item.childMenuItems}"/>                          
                           <a href="${fn:escapeXml(link)}"><c:out value="${item.name}"/></a>
                           <c:if test="${hasChildren == '1'}">
	                           <ul class="sub-menu">
	                           		<c:forEach items="${item.childMenuItems}"  var="childItem">
	                           			<c:set var="childItemLink" value="${childItem.hstLink}" />
	                           			<hst:link var="childLink" link="${childItemLink}"/>
										<li  class="menu-item menu-item-type-post_type menu-item-object-page menu-item-776"><a href="${fn:escapeXml(childLink)}"><c:out value="${childItem.name}"/></a></li>
									</c:forEach>
								</ul>
							</c:if>
                        </li>
                    </c:otherwise>
                </c:choose>
        </c:if>
    </c:forEach>
</ul>


