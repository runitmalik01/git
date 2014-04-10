<%@page import="javax.jcr.Node"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix='hst' uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ga" uri="http://www.onehippo.org/jsp/google-analytics" %>
<%@ taglib prefix="hippo-gogreen" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india" %>
<%@ taglib prefix="res" tagdir="/WEB-INF/tags/responsive" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:choose>
	<c:when test="${not empty format && format == 'rss'}">
		<%response.setContentType("text/xml; charset=UTF-8"); %>
		<rss xmlns:content="http://purl.org/rss/1.0/modules/content/" xmlns:wfw="http://wellformedweb.org/CommentAPI/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:atom="http://www.w3.org/2005/Atom" xmlns:sy="http://purl.org/rss/1.0/modules/syndication/" xmlns:slash="http://purl.org/rss/1.0/modules/slash/" version="2.0">
			<channel>
				<title/>
				<atom:link href="https://www.wealth4india.com/site/r/w4india/contentdelivery/all.rss" rel="self" type="application/rss+xml"/>
				<link>https://www.wealth4india.com/site/r/w4india/contentdelivery/all.rss</link>
				<description>Wealth4India - Content RSS Feed</description>
				<lastBuildDate><fmt:formatDate value="${now}" pattern="EEE, dd MMM yyyy HH:mm:ss zzz" /></lastBuildDate>
				<language>en-US</language>
				<sy:updatePeriod>hourly</sy:updatePeriod>
				<sy:updateFrequency>1</sy:updateFrequency>
				<c:forEach items="${searchResult.items}" var="hit">
					<item>
		            <hst:link var="link" hippobean="${hit}" fullyQualified="true"/>
		            <c:if test="${fn:contains(link,'/documents/')}">
		            	<c:set var="linkURL" value="/${fn:substringAfter(link,'/documents/')}"/>
		            	<hst:link var="link" path="${linkURL}"/>
		            </c:if>
		            <c:set var="theNode" value="${hit.node}"/>
		            <% 
		            	Node theNode = (Node) pageContext.getAttribute("theNode");
		            	boolean isIdentifiable =  theNode.isNodeType("mootlywcm:identifiable");
		            	pageContext.setAttribute("isIdentifiable",isIdentifiable);
		            %>
		            <c:set var="hitClassName" value="${hit['class'].simpleName}"/>
		              <c:choose>
		                <c:when test="${hitClassName eq 'HippoAsset'}">
		                	<title><c:out value="${hit.name}"/></title>
		                  	<link>${fn:escapeXml(link)}</link>
		                </c:when>
		                <c:when test="${hitClassName eq 'Faq'}">
		                	<title><c:out value="${hit.question}"/></title>
		                  	<link>${fn:escapeXml(link)}</link>
		                </c:when>
						<c:when test="${hitClassName eq 'Service'}">
							<title><c:out value="${hit.name}"/></title>
		                 	<link>${fn:escapeXml(link)}</link>
		                </c:when>	
		                <c:when test="${hitClassName eq 'KnowledgeArticle'}">		                  
			            	<title><c:out value="${hit.title}"/></title>
		                  	<link>${fn:escapeXml(link)}</link>
		                </c:when>	
		              </c:choose>
		              <%--getPublicationDate --%>
		              <pubDate><fmt:formatDate value="${hit.publicationDate.time}" pattern="EEE, dd MMM yyyy HH:mm:ss zzz" /></pubDate>
		              <description>
						<![CDATA[
							<c:out value="${hit.description.content}" escapeXml="true"/>
						]]>
						</description>
						<content:encoded><![CDATA[
							<c:out value="${hit.description.content}" escapeXml="false"/>
						]]></content:encoded>
		        	</item>
				</c:forEach>
			</channel>
		</rss>
	</c:when>
	<c:otherwise>
		<c:out value="${jsonResult}" escapeXml="false"/>
	</c:otherwise>
</c:choose>
