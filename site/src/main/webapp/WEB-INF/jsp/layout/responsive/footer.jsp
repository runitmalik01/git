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
			        	<hst:link var="tos" path="/about/terms--conditions/terms--conditions"/>
			        	<hst:link var="pp" path="/about/terms--conditions/privacy-policy"/>
			        	<li id="menu-item-715" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-715"><a href="${pp}">Privacy Policy</a></li>
						<li id="menu-item-716" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-716"><a href="${tos}">Terms of Use</a></li>
						<li id="menu-item-717" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="about"/>">About Us</a></li>
						<li id="menu-item-718" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="${contactUs}">Contact Us</a></li>
						<li id="menu-item-717" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-717"><a href="<hst:link siteMapItemRefId="faq"/>">FAQ</a></li>
					</ul>                  
		</div><!-- end of col-540 -->
        <div class="grid col-380 fit">
        	<!-- <ul class="social-icons"><li class="twitter-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/twitter-icon.png" width="24" height="24" alt="Twitter"></a></li><li class="facebook-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/facebook-icon.png" width="24" height="24" alt="Facebook"></a></li><li class="linkedin-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/linkedin-icon.png" width="24" height="24" alt="LinkedIn"></a></li><li class="youtube-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/youtube-icon.png" width="24" height="24" alt="YouTube"></a></li><li class="stumble-upon-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/stumble-upon-icon.png" width="24" height="24" alt="StumbleUpon"></a></li><li class="rss-feed-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/rss-feed-icon.png" width="24" height="24" alt="RSS Feed"></a></li><li class="google-plus-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/googleplus-icon.png" width="24" height="24" alt="Google Plus"></a></li><li class="instagram-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/instagram-icon.png" width="24" height="24" alt="Instagram"></a></li><li class="pinterest-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/pinterest-icon.png" width="24" height="24" alt="Pinterest"></a></li><li class="yelp-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/yelp-icon.png" width="24" height="24" alt="Yelp!"></a></li><li class="vimeo-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/vimeo-icon.png" width="24" height="24" alt="Vimeo"></a></li><li class="foursquare-icon"><a href="#"><img src="http://themeid.com/demo/responsive/wp-content/themes/responsive/icons/foursquare-icon.png" width="24" height="24" alt="foursquare"></a></li></ul> --><!-- end of .social-icons -->         </div><!-- end of col-380 fit -->
         
         </div><!-- end of col-940 -->
         <%--
                 <div id="colophon-widget" class="grid col-940">
            		<div id="text-7" class="colophon-widget widget-wrapper widget_text">			
            		<div class="textwidget">Hey There, I am new here and you can see me only when you need me :)</div>
				 </div>
         --%>    
            </div><!-- end of #colophon-widget -->                
        <div class="grid col-300 copyright">© 2013<a href="http://www.wealth4india.com/" title="Responsive Demo">Wealth4India</a>
        </div><!-- end of .copyright -->
        
        <div class="grid col-300 scroll-top"><a href="#scroll-top" title="scroll to top">↑</a></div>
        
        <div class="grid col-300 fit powered">
            <a href="http://themeid.com/responsive-theme/" title="Responsive Theme">Wealth4India</a>
            developed by <a href="http://www.mootly.com/" title="Mootly. Get IT Done Get IT Right">
                    Mootly Pvt Ltd.</a>
        </div><!-- end .powered -->
        
    </div>
</div><!-- end #footer -->


