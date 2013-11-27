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

<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics"
	prefix="ga"%>
<%@include file="../../includes/tags.jspf"%>

<div id="footer" class="row">
<div id="menu-foot">
<hst:link var="contactUs" siteMapItemRefId="contactus"/>
			        	<hst:link var="tos" path="/terms"/>
			        	<hst:link var="pp" path="/privacy"/>
			        	<hst:link var="feedback" path="/feedback"/>
	<div id="menu-item-715" class="col-md-1">
		<a href="${pp}">Privacy Policy</a>
	</div>
	<div id="menu-item-716" class="col-md-1">
		<a href="${tos}">Terms of Use</a>
	</div>
	<div id="menu-item-717" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="about"/>">About Us</a>
	</div>
	<div id="menu-item-718" class="col-md-1">
		<a href="${contactUs}">Contact Us</a>
	</div>
	<div id="menu-item-719" class="col-md-1">
		<a href="${feedback}">Feedback</a>
	</div>
	<div id="menu-item-720" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="faq"/>">FAQ</a>
	</div>
	<div id="menu-item-721" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="serviceprice"/>">Pricing</a>
	</div>
	<div id="menu-item-722" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="itr-validate-xml"/>">IT
			Return XML Validator</a>
	</div>
	<div id="menu-item-723" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="knowledgeportal"/>">Knowledge
			Portal</a>
	</div>
	<div id="menu-item-723" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="news"/>">News</a>
	</div>
	<div id="menu-item-723" class="col-md-1">
		<a href="<hst:link siteMapItemRefId="events"/>">Events</a>
	</div>
	</div>
</div>


<div class="row">
<p>
	<div class="col-md-4">
		<p class="text-muted credit">
			&copy; 2013 Wealth4India <a
				href="http://www.<w4india:resellername/>.com/"
				title="<w4india:resellername/>"><w4india:resellername />
			</a>
		</p>
			</div>


	<div class="col-md-4 scroll-top">
		<a href="#scroll-top" title="scroll to top">↑</a>
	</div>
	<div class="col-md-4">
		<a href='<hst:link path="/"/>' title="<w4india:resellername/>"><w4india:resellername />
		</a> developed by <a href="http://www.mootly.com/"
			title="Mootly. Get IT Done Get IT Right"> Mootly Software Pvt
			Ltd.</a>
	</div>
	</footer>
</div>


