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
<%@include file="../../../includes/tags.jspf" %>
<hst:link var="myitreturns" path="/member/itreturn"/>
<hst:link var="contactus" path="/contactus"/>
<div id="top-widget" class="top-widget">
  <div id="text-8" class="widget_text">
    <div class="textwidget" align="center">      
      <!--  <a href="${myitreturns}" class="button orange">
      		My Income Tax Returns
      </a>-->
          <a href="${contactus}" class="button blue" style="text-decoration: none;"><strong>Contact Us</strong></a><br>
          <abbr title="Phone">P:</abbr> <strong>+91-(11)-45067102, +91-(11)-25074341, +91-9136265229</strong><br/> 
          <strong>+91-8459024905</strong> &nbsp;&nbsp;&nbsp;<abbr title="Timing">T:</abbr> <strong>9.30 AM To 9.30 PM</strong>
    </div>
  </div>
</div><!-- end of #top-widget -->
