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
<%@include file="../includes/tags.jspf" %>
<ol id="breadcrumbs">
	<li><fmt:message key="products.detail.location.label"/></li>
	<li>
	    <hst:link var="home" siteMapItemRefId="home" />
	    <a href="${home}"><fmt:message key="products.detail.location.home"/></a> &gt;
	</li>
	<li>
	    <hst:link var="incometaxreturns" siteMapItemRefId="incometaxreturns" />
	    <a href="${incometaxreturns}">Income Tax Returns</a>
	</li>
</ol>
Command Type from Request Attribute: <c:out value="${cmd}"/>
OVERVIEW
<h2>Income Tax Filing</h2>
<h3>2012-2013</h3>
<div id="products">
	<ul>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/itr1/itr1/itr1_original.html">ITR-1 - Original</a></li>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/itr1/itr1/itr1_original.html?page=2">ITR-1 - Original - Page 2</a></li>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/itr1/itr1/itr1_original.html?page=3">ITR-1 - Original - Page 3</a></li>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/itr1/itr1/itr1_original.html?page=4">ITR-1 - Original - Page 4</a></li>
		
		
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/itr1/itr1/itr1_revised.html">ITR-1 - Revised</a></li>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/ITR_3.html">ITR-3</a></li>
		<li><a href="<c:out value="${incometaxreturns}"/>/20122013/ITR_4.html">ITR-4</a></li>
	</ul>
</div>
