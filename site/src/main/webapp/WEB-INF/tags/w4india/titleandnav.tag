<%--
Page Title and Navigation Links
 --%>
<%@tag import="java.util.LinkedList"%>
<%@tag import="java.util.List"%>
<%@tag import="java.util.Map"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ attribute name="subTitle" required="false" type="java.lang.String" %>
<div class="row show-grid">
		<div class="col-md-8">
			<h1><c:out value="${title}"/></h1>
		</div>
		<div class="col-md-4">
			<!-- &#x2190; -->
			<%
				String scriptURL = (String) request.getAttribute("scriptName");
				Map<String,String> nextPrevLinks = (Map<String,String>) request.getAttribute("nextPrevLinks");
				if (nextPrevLinks != null && nextPrevLinks.size() >  0) {
					List<String> listOfKeys = new LinkedList<String>(); 
					for (String theKey:nextPrevLinks.keySet()) {
						listOfKeys.add(theKey);
						//out.println(theKey);
					}
					//nextPrevLinks.keySet().toArray(new String[nextPrevLinks.keySet().size()]);
					//out.println(listOfKeys.get(0));
					if (nextPrevLinks != null && scriptURL != null && nextPrevLinks.size() >  0) {
						String[] scriptURLParts = scriptURL.split("[//]");
						String keyToFind = scriptURLParts[scriptURLParts.length - 1];
						if (nextPrevLinks.containsKey(keyToFind)) {
							int indxOfKey = -1;
							for (int i=0;i<listOfKeys.size();i++) {
								if (listOfKeys.get(i).equals(keyToFind)) {
									indxOfKey = i;
									break;
								}
							}
							if (indxOfKey < listOfKeys.size() - 1) {
								request.setAttribute("nxtLinkMap_HREF",listOfKeys.get( indxOfKey + 1));
								request.setAttribute("nxtLinkMap_TITLE",nextPrevLinks.get(listOfKeys.get(indxOfKey + 1)));
							}
							else if (indxOfKey == listOfKeys.size() - 1) {
								request.setAttribute("nxtLinkMap_HREF","efile-incometax.html");
								request.setAttribute("nxtLinkMap_TITLE","eFile");
								request.setAttribute("nxtLinkMap_ISLAST","true");
							}
							
							if ( indxOfKey > 0 ) {
								request.setAttribute("prevLinkMap_HREF",listOfKeys.get(indxOfKey - 1));
								request.setAttribute("prevLinkMap_TITLE",nextPrevLinks.get(listOfKeys.get( indxOfKey - 1)));
							}
							else if ( indxOfKey == 0 && !keyToFind.equals( "servicerequest-itr.html")) {
								request.setAttribute("prevLinkMap_HREF","servicerequest-itr.html");
								request.setAttribute("prevLinkMap_TITLE","Start");
							}
						} 
						else {
							//Map<String,String> nxtLinkMap = new HashMap<String,String>(1);
							//nxtLinkMap.put(keyToFind,nextPrevLinks.get(keyToFind));
							//out.println(scriptURL);
							request.setAttribute("nxtLinkMap_HREF",listOfKeys.get(0));
							request.setAttribute("nxtLinkMap_TITLE",nextPrevLinks.get(listOfKeys.get(0)));
						}
					}
				}
			%>
			<c:if test="${not empty prevLinkMap_HREF && not empty prevLinkMap_TITLE}">
				<span class="nav-previous pull-left"><a href="${scriptName}/../${prevLinkMap_HREF}" rel="prev"><span class="meta-nav">&#x2190;</span> ${prevLinkMap_TITLE}</a></span>
			</c:if>
			<c:if test="${not empty nxtLinkMap_HREF && not empty nxtLinkMap_TITLE}">
				<span class="nav-next pull-right"><a href="${scriptName}/../${nxtLinkMap_HREF}" rel="next">${nxtLinkMap_TITLE}<c:if test="${empty nxtLinkMap_ISLAST}"><span class="meta-nav">&#x2192;</span></c:if></a></span>
				
			</c:if>
		</div>
</div>
<c:if test="${not empty subTitle}">
	<div class="row show-grid"><div class="col-md-12"><h4><small><c:out value="${subTitle}" escapeXml="false"/></small></h4></div></div>
</c:if>