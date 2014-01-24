<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../includes/tags.jspf" %>
<%--
Privacy Policy Terms of Use About Us Contact Us	 Feedback FAQ Pricing IT Return XML Validator Knowledge Portal News Events
 --%>
 <!-- FOOTER -->
 <hst:link var="contactUs" siteMapItemRefId="contactus"/>
 <hst:link var="feedback" path="/feedback"/>
<div class="container">
 <footer>
   <p class="pull-right"><a href="#">Back to top</a></p>
   <p>
   	&copy; 2013 <w4india:resellername/>
   	<c:if test = "${resellerId != null && resellerId != 'etaxfilestation'}">
   	&middot; <a href="<hst:link path="/privacypolicy.cms"/>">Privacy</a>
   	&middot; <a href="<hst:link path="/terms.cms"/>">Terms</a>
   	&middot; <a href="<hst:link path="/aboutus.cms"/>">About Us</a>
   	&middot; <a href="<hst:link path="/contactus.cms"/>">Contact Us</a>
   	&middot; <a href="${feedback}">Feedback</a>
   	&middot; <a href="<hst:link siteMapItemRefId="serviceprice"/>">Pricing</a>
   	&middot; <a href="<hst:link siteMapItemRefId="itr-validate-xml"/>">IT Return XML Validator</a>
   	&middot; <a href="<hst:link siteMapItemRefId="knowledgeportal"/>">Knowledge Portal</a>
   	&middot; <a href="<hst:link siteMapItemRefId="news"/>">News</a>
   	&middot; <a href="<hst:link siteMapItemRefId="events"/>">Events</a>
   	</c:if>
   </p>
  
 </footer>
</div>