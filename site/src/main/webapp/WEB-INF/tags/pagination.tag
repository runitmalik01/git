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
<div style="text-align:center">
<ul class="pagination">
  <c:choose>
    <c:when test="${pageableResult.previous}">
      <li>
        <c:url var="prevLink" value="">
          <c:param name="${queryName}" value="${fn:escapeXml(queryValue)}"/>
          <c:param name="pageNumber" value="${pageableResult.previousPage}"/>
        </c:url>
        <a href="${fn:escapeXml(prevLink)}">&laquo;</a>
      </li>
    </c:when>
    <c:otherwise>
      <li><a href="#" class="success">&laquo;</a></li>
    </c:otherwise>
  </c:choose>
  <c:forEach var="page" begin="${pageableResult.startPage}" end="${pageableResult.endPage}">
    <c:choose>
      <c:when test="${page == pageableResult.currentPage}">
        <li><a href="#" class="success"><c:out value="${page}"/></a></li>
      </c:when>
      <c:otherwise>
        <li>
          <c:url var="pageLink" value="">
            <c:param name="${queryName}" value="${fn:escapeXml(queryValue)}"/>
            <c:param name="pageNumber" value="${page}"/>
          </c:url>
          <a href="${fn:escapeXml(pageLink)}"><c:out value="${page}"/></a>
        </li>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  <c:choose>
    <c:when test="${pageableResult.next}">
      <li>
        <c:url var="nextLink" value="">
          <c:param name="${queryName}" value="${fn:escapeXml(queryValue)}"/>
          <c:param name="pageNumber" value="${pageableResult.nextPage}"/>
        </c:url>
        <a href="${fn:escapeXml(nextLink)}">&raquo;</a>
      </li>
    </c:when>
    <c:otherwise>
      <li><a href="#" class="success">&raquo;</a></li>
    </c:otherwise>
  </c:choose>
</ul>
</div>
</c:if>

