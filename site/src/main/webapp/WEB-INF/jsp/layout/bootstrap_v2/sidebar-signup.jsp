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
<%@page import="java.util.Enumeration"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../includes/tags.jspf" %>
<%--
	Enumeration enm = request.getAttributeNames();
	while(enm.hasMoreElements()) {
		String element = (String) enm.nextElement();
		Object elementFromCollection = request.getAttribute(element);
		out.println(element + ":" + elementFromCollection.getClass().getName()	);
	}
	System.out.println("template:"+ request.getAttribute("template"));
--%>
<div id="text-3" class="widget-wrapper widget_text"><div class="widget-title">Right Sidebar Widget</div>			<div class="textwidget">Page-specific widget which appears only to Content/Sidebar Template. How cool is that? Responsive's main sidebar applies to all pages/post while this area is 100% independed.

Just go to Appearance &gt; Widgets and drag any available widgets to your right. Save it an voila, you're done my friend.

Down below we've added few more, just for demo purposes.</div>
		</div>
<hst:include ref="box1"/>
<hst:include ref="box2"/>