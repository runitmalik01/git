<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 

implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://www.hippoecm.org/jsp/hst/core" prefix='hst'%>

<script type="text/javascript" src="../../build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../../build/container/container_core.js"></script>
<script type="text/javascript" src="../../build/menu/menu.js"></script>

<!-- 
<ul id="left-nav">
	<c:forEach var="item" items="${submenu}">
		<li>
           <hst:link var="link" link="${item.hstLink}" /> 
	   	   <a href="${link}"><c:out value="${item.name}"/></a>
		</li>
	</c:forEach>
</ul>
-->

<div id="memberleftmenu" class="yuimenu">
    <div class="bd">
        <ul class="first-of-type" id="left-nav">
            <li class="yuimenuitem">
                <a class="yuimenuitemlabel" href="#memberinformation">Member Information</a>
            </li>
            <li class="yuimenuitem">
                <a class="yuimenuitemlabel" href="#calculators">Calculators</a>
            </li>
            <li class="yuimenuitem">
                <a class="yuimenuitemlabel" href="#downloads">Downloads</a>
            </li>
            <li class="yuimenuitem">
                <a class="yuimenuitemlabel" href="#viewform">View Form 26AS</a>
            </li>
            <li class="yuimenuitem">
                <a class="yuimenuitemlabel" href="#upload form">Upload form 16</a>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript">

            /*
                 Initialize and render the Menu when its elements are ready 
                 to be scripted.
            */

            YAHOO.util.Event.onContentReady("memberleftmenu", function () {

                /*
					Instantiate a Menu:  The first argument passed to the constructor
					is the id for the Menu element to be created, the second is an 
					object literal of configuration properties.
                */

                var oMenu = new YAHOO.widget.Menu("memberleftmenu", { 
                                                        position: "static", 
                                                        hidedelay:  750, 
                                                        lazyload: true });


                /*
                     Define an array of object literals, each containing 
                     the data necessary to create a submenu.
                */


                var aSubmenuData = [

                {
                   id: "memberinformation", 
                   itemdata: [ 
                       { text: "Personal Information", url: "http://360.yahoo.com" },
                       { text: "Contact Information", url: "http://alerts.yahoo.com" },
                       { text: "Residential Status", url: "http://avatars.yahoo.com" },
                       { text: "Bank Details", url: "http://groups.yahoo.com " },
                   ]
                },

                {
                   id: "calculators", 
                   itemdata: [
                       { text: "Tax Calculator", url: "http://auctions.shopping.yahoo.com" },
                       { text: "NPV Calculator", url: "http://autos.yahoo.com" },
                       { text: "EMI Calculator", url: "http://classifieds.yahoo.com" },
                                      
                   ]    
                },

                {
                   id: "downloads", 
                   itemdata: [
                       { text: "ITR 1", url: "http://fantasysports.yahoo.com" },
                       { text: "ITR 2", url: "http://games.yahoo.com" },
                       { text: "ITR 3", url: "http://www.yahooligans.com" },
                       { text: "ITR V", url: "http://music.yahoo.com" },
                                    
                   ] 
                },

                {
                   id: "viewform",
                   itemdata: [
                       { text: "View Form 26AS", url: "http://downloads.yahoo.com" },
                      
                   ]
                } ,

                {
                	   id: "uploadform",
                	   itemdata: [
                	       { text: "Upload Form 16", url: "http://downloads.yahoo.com" },
                	      
                	   ]
                	} 
                ];

                // Subscribe to the Menu instance's "beforeRender" event

                oMenu.subscribe("beforeRender", function () {

					var nSubmenus = aSubmenuData.length,
						i;


                    if (this.getRoot() == this) {

						for (i = 0; i < nSubmenus; i++) {
                        	this.getItem(i).cfg.setProperty("submenu", aSubmenuData[i]);
						}

                    }

                });
                

                /*
                     Call the "render" method with no arguments since the 
                     markup for this Menu instance is already exists in the page.
                */

                oMenu.render();
            
            });

        </script>   


<style>
#memberleftmenu {
    
    position: static;
    
}
</style>