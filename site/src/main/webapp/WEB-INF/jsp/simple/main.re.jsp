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
<%--@elvariable id="document" type="com.Wealth4India.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf" %>
<c:set var="termstitle"><fmt:message key="member.terms.title"/></c:set>
<hippo-gogreen:title title="${termstitle}"/>

<div class="page">
	<h4><c:out value="${document.title}"/></h4>
	<div class="desc">
		<c:out value="${document.description.content}" escapeXml="false"/>
	</div>
</div>