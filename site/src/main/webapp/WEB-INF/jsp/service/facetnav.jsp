<%@include file="../includes/tags.jspf"%>
<div align="left" class="row show-grid">
<h4 class="text-success">Browse Service Categories</h4>
<ul class="thumbnails nav nav-list bs-docs-sidenav">
    <c:forEach var="facet" items="${facetnav.folders}">
      <c:if test="${facet.count > 0}">
        <c:choose>
          <c:when test="${facet.leaf}">
            <li class="filter-by"><c:out value="${facet.name}"/>
              <ul class="bullet-points">
                <li><a class="filter" href="#"><c:out value="${facet.name}"/></a></li>
              </ul>
            </li>
          </c:when>
          <c:when test="${facet.childCountsCombined eq 0}">
          </c:when>
          <c:otherwise>
            <label><small><c:out value="${facet.name}"/>:</small></label>
              <c:if test="${not empty facet.folders}">
                <ul class="bullet-points">
                  <c:forEach items="${facet.folders}" var="item">
                    <c:choose>
                      <c:when test="${item.leaf and item.count gt 0}">
                          <hst:facetnavigationlink remove="${item}" current="${facetnav}" var="removeLink"/>
                          <li><a class="filter" href="${removeLink}"><c:out value="${item.name}"/></a></li>
                      </c:when>
                      <c:when test="${item.leaf and item.count eq 0}">
                      </c:when>
                      <c:otherwise>
                          <hst:link var="link" hippobean="${item}" navigationStateful="true" />
                          <li>
                              <c:choose>
                                <c:when test="${query eq null}">
                                    <a href="${link}"><c:out value="${item.name}"/></a>&nbsp;(${item.count})
                                </c:when>
                                <c:otherwise>
                                    <a href="${link}"><c:out value="${item.name}"/></a>&nbsp;(${item.count})
                                </c:otherwise>
                              </c:choose>
                          </li>
                      </c:otherwise>
                    </c:choose>                
                  </c:forEach>
                </ul>
              </c:if>
          </c:otherwise>
        </c:choose>
      </c:if>
    </c:forEach>
  </ul>
</div>
