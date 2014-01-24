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

<%@include file="../../includes/tags.jspf" %>
<c:set value="<%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName().replaceAll(\"@\",\"-at-\") :\"\"%>" var="loggedin"></c:set>
<c:choose>
	<c:when test="${not empty loggedin}">
		<hst:link var="homeLink" siteMapItemRefId="itreturnhome"></hst:link>
	</c:when>
	<c:otherwise>
		<hst:link var="homeLink" siteMapItemRefId="home"></hst:link>
	</c:otherwise>
</c:choose>
<c:set var="searchresultstitle"><fmt:message key="search.results.title"/></c:set>
<hippo-gogreen:title title="${searchresultstitle}"/>
<hst:link var="newticket" siteMapItemRefId="newticket"></hst:link>
 <div><a href="${newticket}" class="btn btn-default btn-success"> <small><i class="glyphicon  glyphicon glyphicon-white"></i>Create New</small></a> </div>

<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr class="success">
					<th>#</th>
					<th>Ticket Number</th>
					<th>Summary</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			  <c:if test="${not empty documents}">
					<c:forEach items="${documents.items}" var="helpdesklist" varStatus="ct">
					<hst:link var="helpdeskDocPath" path="member/helpdesk/${helpdesklist.name}.html"/>
						<tr class="warning">
							<td><c:out value="${ct.count}" /></td>
							<td><c:out value="${helpdesklist.identifier}" /></td>
							<td><c:out value="${helpdesklist.title}" /></td>
							<td>							
							<a class="btn btn-default btn-sm btn-success" href="${helpdeskDocPath}"><small><i
								class="glyphicon glyphicon-pencil"></i>Edit</small></a>
								</td>
						</tr>
		</c:forEach></c:if>		
			</tbody>
		</table> 
		<c:choose>
		  <c:when test="${documents.total eq 0}">
		    <p id="results"><fmt:message key="search.results.noresults"/> '${query}'</p>
		  </c:when>
		  <c:otherwise>
		    <hippo-gogreen:pagination pageableResult="${documents}" queryName="query" queryValue="${query}" />
		  </c:otherwise>
		</c:choose> 
		
		<form method="POST" action="">
</form>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
	function s(act) {
		$("#")
	}
</hst:element>
<div class="page">
    <c:set var="isFound" value="${tags != null or searchResult.total > 0}"/>
    <c:set var="searched" value="'${fn:escapeXml(tag != null ? tag.label : query)}'"/>
	<c:choose>
		<c:when test="${empty firstBean || isFound}">
			<hst:element var="robotsContent"  name="meta">
				<hst:defineObjects/>
				<hst:attribute name="name">robots</hst:attribute>
				<hst:attribute name="content">noindex, follow</hst:attribute>
			</hst:element>
			<hst:headContribution category="meta" element="${robotsContent}"></hst:headContribution>
		    <%-- Do titles --%>
		    <c:choose>
		      <%-- When page is not found --%>
				<c:when test="${pagenotfound}">
					<div class="hero-unit center">
						<h1>
							<fmt:message key="search.results.pagenotfound" />
							<small><font face="Tahoma" color="red">Error 404</font></small>
						</h1>
						<br/>
						<!--  <h2><fmt:message key="search.results.pagenotfound"/></h2> -->
						<div id="not-found">
							<p>
								<fmt:message key="search.results.notfounddescr" />
								<c:if test="${not isFound}"><br /><br />
									<fmt:message key="search.results.norelatedpages" />
								</c:if>
							</p>
							<c:if test="${isFound}">
								<p class="b">
									<fmt:message key="search.results.suggestion" /></p>
							</c:if>
						</div>
						<a href="${homeLink}" class="btn btn-default btn-lg btn-info"><i class="glyphicon glyphicon-home glyphicon glyphicon-white"></i> Take Me Home</a>
					</div>
				</c:when>
				<%-- When a search is done, but no results where found --%>
		      <c:when test="${not isFound}">
		        <h2><fmt:message key="search.results.title"/></h2>
		        <p id="results"><fmt:message key="search.results.noresults"/> '${searched}'</p>
		      </c:when>
		      <%-- When a search is done and there is a result --%>
		      <c:otherwise>
		        <h2><fmt:message key="search.results.title"/></h2>
		        <p id="results">
		          <c:choose>
		            <c:when test="${empty query}">
		              <fmt:message key="search.results.found">
		                <fmt:param value="${searchResult.startOffset + 1}"/>
		                <fmt:param value="${searchResult.endOffset}"/>
		                <fmt:param value="${searchResult.total}"/>
		              </fmt:message>
		            </c:when>
		            <c:otherwise>
		              <fmt:message key="search.results.resultsfound">
		                <fmt:param value="${searchResult.startOffset + 1}"/>
		                <fmt:param value="${searchResult.endOffset}"/>
		                <fmt:param value="${searchResult.total}"/>
		                <fmt:param value="${searched}"/>
		               </fmt:message>
		            </c:otherwise>
		          </c:choose>
		        </p>
		      </c:otherwise>
		    </c:choose>
		
		    <%-- if there is a result, show it --%>
		   
		    <c:choose>
		      <c:when test="${isFound}">
		      	<hst:element var="robots_Content"  name="meta">
					<hst:defineObjects/>
					<hst:attribute name="name">robots</hst:attribute>
					<hst:attribute name="content">noindex, follow</hst:attribute>
				</hst:element>
				<hst:headContribution category="meta" element="${robots_Content}"></hst:headContribution>
		        <div id="search-results">
		          <c:forEach items="${searchResult.items}" var="hit">
		            <hst:link var="link" hippobean="${hit}"/>
		            <c:set var="hitClassName" value="${hit['class'].simpleName}"/>
		            <c:out value="${hitClassName}"/>
		            <ul class="search-result">
		              <c:choose>
		                <c:when test="${hitClassName eq 'HippoAsset'}">
		                  <li class="title"><a href="${fn:escapeXml(link)}"><c:out value="${hit.name}"/></a></li>
		                </c:when>
		                <c:when test="${hitClassName eq 'Faq'}">
		                  <li class="title"><a href="${fn:escapeXml(link)}"><c:out value="${hit.question}"/></a></li>
		                </c:when>
 						<c:when test="${hitClassName eq 'Service'}">
		                  <li class="title"><a href="${fn:escapeXml(link)}"><c:out value="${hit.name}"/></a></li>
		                </c:when>	
		                <c:when test="${hitClassName eq 'KnowledgeArticle'}">
		                  <li class="title"><a href="knowledgearticles/${hit.name}.html"><c:out value="${hit.name}"/></a></li>
		                </c:when>	
		                <c:when test="${hitClassName eq 'HelpDeskTicketDocument'}">
		                  <li class="title"><a href="helpdesk/view/${hit.name}.html"><c:out value="${hit.title}"/></a></li>
		                </c:when>	
		                <c:when test="${hitClassName eq 'SimpleDocument'}">
		                  <li class="title"><a href="${fn:escapeXml(link)}"><c:out value="${hit.title}"/></a></li>
		                </c:when>		                
		                <c:otherwise>
		                 <%-- <hst:link var="Link" hippobean="${hit}"/>
		                  <li class="title"><a href="${fn:escapeXml(Link)}"><c:out value="${hit.title}"/></a></li>
		                  <c:if test="${not empty hit.summary && hit.summary != ''}">
		                 	 <li class="text"><c:out value="${hit.summary}"/></li>
		                  </c:if> --%>
		                </c:otherwise>
		              </c:choose>
		            </ul>
		          </c:forEach>
		        </div>
		      </c:when>
		      <c:otherwise>
		      </c:otherwise>
		    </c:choose>		
		    <%-- Show bottom pagination if it is a proper search, if it comes from pagenotfound, dont show it --%>
		    <c:choose>
		      <c:when test="${not pagenotfound}">
		        <hippo-gogreen:pagination pageableResult="${searchResult}" queryName="query" queryValue="${fn:escapeXml(query)}"/>
		      </c:when>
		      <c:otherwise>
		      </c:otherwise>
		    </c:choose>
		</c:when>
		<c:otherwise>
			 <c:set var="hitClassName" value="${firstBean.getClass().simpleName}"/>
			 <hst:element var="robotsContent"  name="meta">
				<hst:defineObjects/>
				<hst:attribute name="name">robots</hst:attribute>
				<hst:attribute name="content">noindex, follow</hst:attribute>
			</hst:element>
			<hst:headContribution category="meta" element="${robotsContent}"></hst:headContribution>
			 <c:choose>
               <c:when test="${hitClassName eq 'HippoAsset'}">
                 	<h4><c:out value="${firstBean.name}"/></h4>
                 	<hippo-gogreen:title title="${firstBean.name}"></hippo-gogreen:title>
               </c:when>
               <c:when test="${hitClassName eq 'Faq'}">
                	<h4><c:out value="${firstBean.question}"/></h4>
                	<div><c:out value="${firstBean.answer.content}" escapeXml="false"/></div>
                	<hippo-gogreen:title title="${firstBean.question}"></hippo-gogreen:title>
               </c:when>
				<c:when test="${hitClassName eq 'Service'}">
                 	<h4><c:out value="${firstBean.name}"/></h4>
                 	<div><c:out value="${firstBean.serviceDescription.content}" escapeXml="false"/></div>
                 	<hippo-gogreen:title title="${firstBean.name}"></hippo-gogreen:title>
               </c:when>	
               <c:when test="${hitClassName eq 'SimpleDocument'}">
                	<h4><c:out value="${firstBean.title}"/></h4>
                	<div>
                		<c:out value="${firstBean.description.content}" escapeXml="false"/>
                		<hippo-gogreen:title title="${firstBean.title}"></hippo-gogreen:title>
                	</div>
               </c:when>		                
             </c:choose>
		</c:otherwise>
	</c:choose>
</div>
<hst:element var="cssCustom" name="style">
    <hst:attribute name="type">text/css</hst:attribute>
    .page #results { margin: 15px 0; }
	.page #search-results .search-result { border-top: 1px solid #cccccc; padding: 0 5px; }
	.page #search-results .search-result .title { display: block; font-size: 108%; margin-top: 7px; }
	.page #search-results .search-result .text { display: block; margin-top: 5px; }
	.page #search-results .search-result .path { display: block; color: #009900; font-size: 85%; margin: 3px 0 10px; }
	.center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}
</hst:element>
<hst:headContribution element="${cssCustom}" category="css"/>
