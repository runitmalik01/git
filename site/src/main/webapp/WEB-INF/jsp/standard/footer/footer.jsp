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

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="ft">

<img class="xr_ap" src="<c:url value='/images/footerbg.png'/>" alt="" title="" style="left: 165px; top: 700px; width: 965px;height:15px;">
<img class="xr_ap" src="<c:url value='/images/bg-footer.png'/>" alt="" title="" style="left: 165px; top: 702px; width: 965px;height:149px;">

 <span class="xr_s10" style="position:absolute; top:710px;left:680px; width:100px;">
      <fmt:message key="standard.footer.navigation.policy"/>
      </span>
                <span class="xr_s3" style="position: absolute; left:690px; top:730px;">
                     <span class="xr_tl" style="top: 9px;"><hst:link var="policy" siteMapItemRefId="policy"></hst:link>
                     <a href="${policy}"><fmt:message key="standard.footer.navigation.privacy"/></a></span>
                     <span class="xr_tl" style="top: 20px; left:-62px;">
                     <hst:link var="termsLink" path="${termsPath}"/>
                     <a href="${termsLink}"><fmt:message key="standard.footer.navigation.terms"/></a>        
                   </span>
               </span>
 
 <span class="xr_s10" style="position:absolute; top:710px;left:510px;width:100px;"><fmt:message key="standard.footer.navigation.help"/></span>
      <span class="xr_s3" style="position: absolute; left:525px; top:730px;">
                     <span class="xr_tl" style="top: 9px;"><hst:link var="about" siteMapItemRefId="about"></hst:link>
                     <a href="${about}">About Us</a></span>
                     <span class="xr_tl" style="top: 29px;"><hst:link var="contactus" siteMapItemRefId="contactus"></hst:link>
                    <a href="${contactus}">Contact Us</a></span>
                    <span class="xr_tl" style="top: 50px;"><hst:link var="faq" siteMapItemRefId="faq"></hst:link>
                    <a href="${faq}">FAQ</a></span>
               </span>
               
 <span class="xr_s10" style="position:absolute; top:710px;left:250px;width:200px;"><fmt:message key="standard.footer.contact"/></span>
<span class="xr_s3" style="position: absolute; left:280px; top:755px;">
  <span class="xr_tl" style="top: -11px;"><fmt:message key="standard.footer.phone"/></span>
  <span class="xr_tl" style="top: 9px;"><fmt:message key="standard.footer.mobile"/></span>
  <span class="xr_tl xr_s5" style="top: 29px;"><span class="xr_s3"><fmt:message key="standard.footer.email"/>&nbsp; </span><span class="xr_s6">&nbsp;</span><span class="xr_s7"><fmt:message key="standard.footer.emailid1"/>&nbsp;&nbsp; </span></span>
  <span class="xr_tl xr_s7" style="top: 49px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="standard.footer.emailid2"/></span>
 </span>

 <span class="xr_s10" style="position:absolute; top:710px;left:845px; width:100px;">NEWSLETTERS</span>
<span class="xr_s10" style="position:absolute; top:740px;left:830px; width:100px;height:80px;">
<input name="email_subscribe" type="text" title="Subscribe to Newsletter" value="" />
</span>
<span class="xr_s10" style="position:absolute; top:740px;left:950px; width:150px;height:80px;">
<input type="button" name="submit" value="Subscribe"/>
</span>
<span class="xr_s10" style="position:absolute; font-style:normal; top:760px;left:830px;">
<a href="#">unsubscribe</a>
</span>
 <span class="xr_s10" style="position:absolute; top:785px;left:845px; width:100px;">
 <fmt:message key="standard.footer.connect"/>
 </span>
  <img class="xr_ap" src="<c:url value='/images/33.png'/>" alt="" title="" style="left:820px; top: 805px; width: 70px; height: 33px;">
 <img class="xr_ap" src="<c:url value='/images/34.png'/>" alt="" title="" style="left: 900px; top: 805px; width: 70px; height: 33px;">
 
 <img class="xr_ap" src="<c:url value='/images/copyimg.png'/>" alt="" title="" style="left: 165px; top: 852px; width: 965px; height:40px;">
 
 <span class="xr_s16" style="position: absolute; left:300px; top:855px;width:700px;">
  Copyright 2013&nbsp;&nbsp; &nbsp;&nbsp; <w4india:resellername/>&nbsp;&nbsp; &nbsp;&nbsp; Web Design: Proweaver
 </span>
 
  <span class="xr_s16" style="position: absolute; left:300px; top:870px;width:700px;">
 <fmt:message key="standard.footer.managed"/>
 </span>
 


<div id="xr_xo0" class="xr_ap" style="left:0; top:0; width:1300px; height:100px; visibility:hidden;">
</div>
<div id="xr_xd0"></div>
 
 <!-- bottom navigation -->
 
 <!-- 
 <img class="xr_ap" src="<c:url value='/images/45.png'/>" alt="" title="" style="left: 153px; top: 1031px; width: 994px; height: 70px;">
 <img class="xr_ap" src="<c:url value='/images/46.png'/>" alt="" title="" style="left: 206px; top: 1059px; width: 78px; height: 24px;">
 <img class="xr_ap" src="<c:url value='/images/47.png'/>" alt="" title="" style="left: 366px; top: 1059px; width: 210px; height: 23px;">
 <img class="xr_ap" src="<c:url value='/images/22.png'/>" alt="" title="" style="left: 348px; top: 1030px; width: 1px; height: 72px;">
 <img class="xr_ap" src="<c:url value='/images/48.png'/>" alt="" title="" style="left: 658px; top: 1059px; width: 135px; height: 23px;">
 <img class="xr_ap" src="<c:url value='/images/24.png'/>" alt="" title="" style="left: 639px; top: 1030px; width: 2px; height: 72px;">
 <img class="xr_ap" src="<c:url value='/images/49.png'/>" alt="" title="" style="left: 874px; top: 1059px; width: 185px; height: 24px;">
 <img class="xr_ap" src="<c:url value='/images/22.png'/>" alt="" title="" style="left: 855px; top: 1030px; width: 1px; height: 72px;">
 <img class="xr_ap" src="<c:url value='/images/26.png'/>" alt="" title="" style="left: 296px; top: 1049px; width: 40px; height: 40px;">
 <img class="xr_ap" src="<c:url value='/images/26.png'/>" alt="" title="" style="left: 591px; top: 1049px; width: 40px; height: 40px;">
 <img class="xr_ap" src="<c:url value='/images/26.png'/>" alt="" title="" style="left: 802px; top: 1049px; width: 40px; height: 40px;">
 <img class="xr_ap" src="<c:url value='/images/26.png'/>" alt="" title="" style="left: 1075px; top: 1049px; width: 40px; height: 40px;">
-->
 
 
</div>

<!--[if lt IE 7]><script type="text/javascript" src="index_htm_files/png.js"></script><![endif]-->
<script type="text/javascript">xr_aeh();</script>



<%--  
<div id="ft">
    <div class="logo">
        <a href="http://www.onehippo.com">
          <img src="<hst:link path="/images/logo-hippo.png"/>" alt="<fmt:message key="standard.footer.onehippo"/>"/>
        </a>

        <p><fmt:message key="standard.footer.copyright"/></p>

        <p>
          <hst:link var="termsLink" path="${termsPath}"/>
          <a href="${termsLink}"><fmt:message key="standard.footer.termsandconditions"/></a>
        </p>
    </div>
    <div class="yui-gb" id="ft-nav">
        <div class="yui-u first">
            <h3><fmt:message key="standard.footer.servicelabel"/></h3>
            <hst:include ref="service"/>
        </div>
        <div class="yui-u">
            <h3><fmt:message key="standard.footer.sectionslabel"/></h3>
            <hst:include ref="sections"/>
        </div>
    </div>
    
    
    <img id="ft-image" src="<hst:link path="/images/ft-leaf.png"/>" alt="" />
</div>

 --%>
 
