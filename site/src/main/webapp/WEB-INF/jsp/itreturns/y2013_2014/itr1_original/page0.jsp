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

<h2>Indian Income Tax Return</h2>
<h3>ITR-1 (SAHAJ)</h3>
<h3>For individuals having Income from Salary/Pension/Income from One House Property</h3>
<hst:actionURL var="actionUrl"/>
<form id="frmRating" action="${actionUrl}" method="post">	
	<input type="submit" value="Start Filing ITR-1" id="comment-button" />
</form>
