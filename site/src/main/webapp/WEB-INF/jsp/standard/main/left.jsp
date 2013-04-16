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

<%@include file="../../includes/tags.jspf" %>

<div id="left" class="yui-b">
  
<script type="text/javascript" src="../../build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="../../build/container/container_core.js"></script>
<script type="text/javascript" src="../../build/menu/menu.js"></script>
<table id="maintable" border="0" width="100%" cellspacing="0" cellpadding="0">
  <tr>
    <td id="leftbar" valign="top">
			<div class="headers">Calculators</div>
			<ul class="categorylinks">
			     <hst:link var="taxcalculator" siteMapItemRefId="taxcalculator"></hst:link>
				<li><a href="${taxcalculator}" >Tax Calculator</a></li>
				<hst:link var="npvcalculator" siteMapItemRefId="npvcalculator"></hst:link>
				<li><a href="${npvcalculator}">NPV Calculator</a></li>
				<hst:link var="emicalculator" siteMapItemRefId="emicalculator"></hst:link>
				<li><a href="${emicalculator}">EMI Calculator</a></li>
			</ul>
            <div class="headers">Downloads</div>
			<ul class="categorylinks">
				<li><a href="#" >ITR 1</a></li>
				<li><a href="#">ITR 2</a></li>
				<li><a href="#">ITR 3</a></li>
				<li><a href="#">ITR V</a></li>
			</ul>
            <div class="headers">View Form 26AS(Tax Credit)</div>
			<ul class="categorylinks">
				<li><a href="#" >View Form 26AS</a></li>
			</ul>
			 <div class="headers">Upload Form 16</div>
			<ul class="categorylinks">
				<li><a href="#" >Upload Form 16</a></li>
			</ul>
			<div class="headers">IT Returns</div>
			<ul class="categorylinks">
			
			    <hst:link var="startapplication" siteMapItemRefId="startapplication"></hst:link>
				<li><a href="${startapplication }" >Personal Information</a></li>
				<hst:link var="contactinformation" siteMapItemRefId="contactinformation"></hst:link>
				<li><a href="${contactinformation }">Contact Info</a></li>
				<hst:link var="residentialstatus" siteMapItemRefId="residentialstatus"></hst:link>
				<li><a href="${residentialstatus}">Residential Status</a></li>
				<hst:link var="bankdetail" siteMapItemRefId="bankdetail"></hst:link>
				<li><a href="${bankdetail}">Bank Details</a></li>
				<hst:link var="sourceofincome" siteMapItemRefId="sourceofincome"></hst:link>
				<li><a href="${sourceofincome}">Sources Of Income</a></li>
			    <hst:link var="salaryincome" siteMapItemRefId="salaryincome"></hst:link>
				<li><a href="${salaryincome }">Salary Income</a></li>
				<hst:link var="houseincome" siteMapItemRefId="houseincome"></hst:link>
				<li><a href="${houseincome}">House Property</a></li>
				<hst:link var="capitalasset" siteMapItemRefId="capitalasset"></hst:link>
				<li><a href="${capitalasset }">Capital Gains</a></li>
				<hst:link var="Securities" siteMapItemRefId="Securities"></hst:link>
				<li><a href="${Securities}">Securities</a></li>
				<hst:link var="otherincome" siteMapItemRefId="otherincome"></hst:link>
				<li><a href="${otherincome}">Other Sources</a></li>
				<hst:link var="adjustmentoflosses" siteMapItemRefId="adjustmentoflosses"></hst:link>
				<li><a href="${adjustmentoflosses}">Adjustment Of Losses</a></li>
				<hst:link var="deduction" siteMapItemRefId="deduction"></hst:link>
				<li><a href="${deduction}">Deduction</a></li>
				<hst:link var="rebatesection89" siteMapItemRefId="rebatesection89"></hst:link>
				<li><a href="${rebatesection89}">Rebate Section 89</a></li>
				<hst:link var="rebatesection90" siteMapItemRefId="rebatesection90"></hst:link>
				<li><a href="${rebatesection90}">Rebate Section 90/91</a></li>
				<hst:link var="advancetaxgrid" siteMapItemRefId="advancetaxgrid"></hst:link>
				<li><a href="${advancetaxgrid}">Advance Tax Grid</a></li>
				<hst:link var="tdsfromsalary" siteMapItemRefId="tdsfromsalary"></hst:link>
				<li><a href="${tdsfromsalary}">TDS From Salary</a></li>
				<hst:link var="tdsfromothers" siteMapItemRefId="tdsfromothers"></hst:link>
				<li><a href="${tdsfromothers}">TDS From Others</a></li>
				<hst:link var="interest" siteMapItemRefId="interest"></hst:link>
				<li><a href="${interest}">Interest</a></li>
				<hst:link var="tcs" siteMapItemRefId="tcs"></hst:link>
				<li><a href="${tcs}">TCS</a></li>
				<hst:link var="calculation" siteMapItemRefId="calculation"></hst:link>
				<li><a href="${calculation}">Summary</a></li>
				
			</ul>
</td>
</tr>
</table>

</div>


<style>
#leftbar{
width: 165px;
/*background-color: white;*/
}

#leftbar a:hover{
/*color: #FF8000;*/
}

.categorylinks{
list-style: none;
margin: 0;
margin-bottom:1em;
margin-left: 4px;
padding: 0;

}

.categorylinks li{
padding-bottom: 1px;
background: url(graygradient.png) top left repeat-x;
}

.categorylinks li a{
margin-left: -3px;
padding: 6px 1px;
padding-left: 4px;
font-size: 12px;
display: block;
color: #449805;
text-decoration: none;
font-weight: bold;
border-bottom: 1px solid #ececec;
}

.categorylinks a:visited{color: #449805; }
.categorylinks a:hover {	color: #fff;	background: #51B906; text-decoration: none; }

.diffpointer{
list-style-image: url(arrow.png);
}

#leftbar .headers, #leftcolumn .headers{
color: white;
font: bold 110% Arial;
background: #008000 url(greenblock.png) top left no-repeat;
padding: 3px 2px;
margin-bottom:3px;
text-align: center;
-webkit-border-radius: 0 10px 10px 0;
-moz-border-radius: 0 10px 10px 0;
border-radius: 0 10px 10px 0;
-webit-box-shadow: 5px 2px 3px rgba(160,160,160,.98), -9px 0 10px rgba(200,228,178,.5) inset;
-moz-box-shadow: 5px 2px 3px rgba(160,160,160,.98), -9px 0 10px rgba(200,228,178,.5) inset;
box-shadow: 5px 2px 3px rgba(160,160,160,.98), -9px 0 10px rgba(200,228,178,.5) inset;
}

#leftbar .menuitems{
list-style-type: disk;
list-style-image: url(arrow.gif); /*CUSTOM CHANGE*/
margin: 5px auto 10px 17px;
padding: 0;
line-height: 1.2em;
}

#leftbar .menuitems li{
padding-bottom: 8px;
background-image: url(menuline.gif);
background-repeat: no-repeat;
background-position: left bottom;
}

#leftbar .menuitems li a{
text-decoration: none;
font-weight: bold;
}

</style>
