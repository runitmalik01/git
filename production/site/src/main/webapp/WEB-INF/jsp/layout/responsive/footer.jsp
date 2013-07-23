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
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../includes/tags.jspf" %>

<div id="footer" class="clearfix">
   <div id="footer-wrapper">
        <div class="grid col-940">
        <div class="grid col-540">
			        <ul id="menu-foot" class="footer-menu">
			        	<hst:link var="contactUs" siteMapItemRefId="contactus"/>
			        	<hst:link var="tos" path="/terms"/>
			        	<hst:link var="pp" path="/privacy"/>
			        	<li id="menu-item-715" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-715"><a href="${pp}">Privacy Policy</a></li>
						<li id="menu-item-716" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-716"><a href="${tos}">Terms of Use</a></li>
						<li id="menu-item-717" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="about"/>">About Us</a></li>
						<li id="menu-item-718" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="${contactUs}">Contact Us</a></li>
						<li id="menu-item-719" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="${feedback}">Feedback</a></li>
						<li id="menu-item-720" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="faq"/>">FAQ</a></li>
						<li id="menu-item-721" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="serviceprice"/>">Pricing</a></li>
						<li id="menu-item-722" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="itr-validate-xml"/>">IT Return XML Validator</a></li>
					</ul>                  
		</div><!-- end of col-540 -->
        <div class="grid col-380 fit">
        </div><!-- end of col-940 -->
            </div><!-- end of #colophon-widget -->                
        <div class="grid col-300 copyright">© 2013<a href="http://www.wealth4india.com/" title="Wealth4India">Wealth4India</a>
        </div><!-- end of .copyright -->
        
        <div class="grid col-300 scroll-top"><a href="#scroll-top" title="scroll to top">↑</a></div>
        
        <div class="grid col-300 fit powered">
            <a href='<hst:link path="/"/>' title="Wealth4India">Wealth4India</a>
            developed by <a href="http://www.mootly.com/" title="Mootly:Get IT Done Get IT Right">
                    Mootly Software Pvt Ltd.</a>
        </div><!-- end .powered -->
        
    </div>
</div><!-- end #footer -->


