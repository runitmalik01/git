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
<%@ attribute name="pageableResult" required="true" type="com.mootly.wcm.utils.PageableCollection" rtexprvalue="true" %>
<%@ attribute name="queryName" required="false" type="java.lang.String" rtexprvalue="true" %>
<%@ attribute name="queryValue" required="false" type="java.lang.String" rtexprvalue="true" %>

<c:if test="${not empty pageableResult.currentRange}">
<ul class="pager">
  <c:choose>
    <c:when test="${pageableResult.previous}">
      <li class="previous">
        <c:url var="prevLink" value="">
          <c:param name="${queryName}" value="${fn:escapeXml(queryValue)}"/>
          <c:param name="pageNumber" value="${pageableResult.previousPage}"/>
        </c:url>
        <a href="${fn:escapeXml(prevLink)}">Prev</a>
      </li>
    </c:when>
    <c:otherwise>
      <li class="previous"><a href="#" class="success">Prev</a></li>
    </c:otherwise>
  </c:choose>
  <c:choose>
    <c:when test="${pageableResult.next}">
      <li class="next">
        <c:url var="nextLink" value="">
          <c:param name="${queryName}" value="${fn:escapeXml(queryValue)}"/>
          <c:param name="pageNumber" value="${pageableResult.nextPage}"/>
        </c:url>
        <a href="${fn:escapeXml(nextLink)}"><fmt:message key="pagination.next" /></a>
      </li>
    </c:when>
    <c:otherwise>
      <li class="next"><a href="#" class="success"><fmt:message key="pagination.next"/></a></li>
    </c:otherwise>
  </c:choose>
</ul>
</c:if>
