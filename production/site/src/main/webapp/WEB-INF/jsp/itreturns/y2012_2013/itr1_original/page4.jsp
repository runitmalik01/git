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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../../../includes/tags.jspf" %>

<h1>This is Page 4 of ITR -1 Original Form</h1>
<hst:actionURL var="actionUrl"/>
<form id="frmRating" action="${actionUrl}" method="post">
	First Name:<input type="text" name="pi_first_name" value="<c:out value="${itr1.personalInformation.firstName}"/>"/>
	<input type="submit" value="<fmt:message key="products.detail.submit.label"/>" id="comment-button" />
</form>
