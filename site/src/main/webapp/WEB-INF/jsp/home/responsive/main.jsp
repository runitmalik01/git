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
<%@page import="org.hippoecm.hst.content.beans.standard.HippoBean" %>
<c:set var="hometitle">
   <fmt:message key="home.title"/>
</c:set>
<hippo-gogreen:title title="${hometitle}"/>
<%--
<div class="slider-wrapper grid col-940 theme-default">
   <div id="slider" class="nivoSlider">
      <img src="<hst:link path="/images/retirement.png"/>"/>
      <img src="<hst:link path="/images/businessprotection.png"/>"/>
      <img src="<hst:link path="/images/grow_income.jpg"/>"/>
      <img src="<hst:link path="/images/slide08.jpg"/>"/>
      <img src="<hst:link path="/images/taxation.jpg"/>"/>
   </div>
</div>
<div id="htmlcaption1" class="nivo-html-caption">
   Its free to join Wealth4India.<a href="#nogo" class="orange button">Get Started!</a>
</div>
<div id="htmlcaption2" class="nivo-html-caption">
   <a href="#nogo" class="orange button">Free! Get Started!</a>
</div>
 --%>
<jsp:include page="cara.jsp"/>
<%--
<div class="slider-wrapper grid col-940 theme-default">
	<div id="myCarousel" class="carousel slide">
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0"  class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	    <li data-target="#myCarousel" data-slide-to="3"></li>
	  </ol>
	  <!-- Carousel items -->
	  <div class="carousel-inner">
	    <div class="item"><img src="<hst:link path="/images/grow_income.jpg"/>"/> </div>
	    <div class="item"><img src="<hst:link path="/images/slide08.jpg"/>"/> </div>
	    <div class="item"><img src="<hst:link path="/images/taxation.jpg"/>"/> </div>
	  </div>
	  <!-- Carousel nav -->
	  <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	  <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
</div>
  --%>
<%-- comment out for now will work on it again --%>
<%--
<div class="row-fluid show-grid">	        
	<div class="span12" style="border-bottom:1px solid green;border-top:1px solid green">
		<div class="row-fluid show-grid">
		     <div class="span12">	
			   <hst:include ref="services-itr"/>
			</div>			
		</div>		
	</div>
</div>
 --%>
<%-- /end  --%>
<!-- 
<div class="row-fluid show-grid">	        
	<div class="span6" style="border-bottom:1px solid green;border-top:1px solid green">
		<h2 style="display:inline">eFile</h2>&nbsp;&nbsp;<a href="">Learn More..</a>
		<div class="row-fluid show-grid">	
			<div class="span6">
				<h3>Basic</h3>			
			</div>
			<div class="span6">
				<h3>Standard</h3>
			</div>
		</div>		
	</div>
	<div class="span6" style="border-bottom:1px solid olive;border-top:1px solid olive">
		<h2  style="display:inline">eZ-File</h2>&nbsp;&nbsp;<a href="">Learn More..</a>
		<div class="row-fluid show-grid">	
			<div class="span6">
				<h3>Premium</h3>
			</div>
			<div class="span6">
				<h3>Platinum</h3>
			</div>
		</div>			
	</div>
</div>
-->
<h3>File your Tax Return as easy as 1,2,3..</h3>
<h4>Choose the package which suits your need</h4>
<h5>Remember eZ File can make your life simple. Simply upload your documents and rest will be taken care by us.</h5>
<div class="row-fluid show-grid">	 
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3><fmt:message key="ITR1.packageName"></fmt:message>&nbsp;&nbsp;<a href="#modal" data-toggle="modal" id="itr1" class="btn yellow"><i class="icon-info-sign"></i></a></h3>
         </div>
         <div class="textwidget">
           <div><fmt:message key="ITR1.whoCan"></fmt:message></div>          
           <button type="button" class="btnfiling btn btn-success">e-File <small>(<w4india:inr minFractionDigits="0" value="199"></w4india:inr>)</small></button>
           <button type="button" class="btnfiling btn btn-info">eZ-File <small>(<w4india:inr minFractionDigits="0" value="499"></w4india:inr>)</small></button>
         </div>         
      </div>
      <!-- end of .widget-wrapper -->
   </div>
   <!-- end of .col-300 -->
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3><fmt:message key="ITR2.packageName"></fmt:message>&nbsp;&nbsp;<a href="#modal" data-toggle="modal" id="itr2" class="btn yellow"><i class="icon-info-sign"></i></a></h3>
         </div>
         <div class="textwidget">
            <div><fmt:message key="ITR2.whoCan"></fmt:message></div>	
            <%--<button type="button" class="btn btn-success">e-File (<w4india:inr minFractionDigits="0" value="299"></w4india:inr>)</button>--%>
            <button type="button" class="btnfiling btn btn-info">eZ-File (<w4india:inr minFractionDigits="0" value="799"></w4india:inr>)</button>			
         </div>         
      </div>
      <!-- end of .widget-wrapper -->
   </div>
   <!-- end of .col-300 -->
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3><fmt:message key="ITR3.packageName"></fmt:message>&nbsp;&nbsp;<a href="#modal" data-toggle="modal" id="itr3" class="btn yellow"><i class="icon-info-sign"></i></a></h3>
         </div>
         <div class="textwidget">
            <div><fmt:message key="ITR3.whoCan" var="text"/><c:out value="${fn:substringBefore(text,' Income from Multiple')}" escapeXml="false"/><a href="serviceprice"> learn more..</a></div>	
            <%--<button type="button" class="btn btn-success">e-File (<w4india:inr minFractionDigits="0" value="499"></w4india:inr>)</button>--%>
            <button type="button" class="btnfiling btn btn-info">eZ-File (<w4india:inr minFractionDigits="0" value="1099"></w4india:inr>)</button>			
         </div>         
      </div>
      <!-- end of .widget-wrapper -->
   </div>
</div>
<div class="row-fluid show-grid">	 
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3><fmt:message key="ITR4.packageName"></fmt:message>&nbsp;&nbsp;<a href="#modal" data-toggle="modal" id="itr4" class="btn yellow"><i class="icon-info-sign"></i></a></h3>
         </div>
         <div class="textwidget">
            <div><fmt:message key="ITR4.whoCan"></fmt:message></div>	
            <%--<button type="button" class="btn btn-success">e-File (<w4india:inr minFractionDigits="0" value="999"></w4india:inr>)</button> --%>
            <button type="button" class="btnfiling btn btn-info">eZ-File (<w4india:inr minFractionDigits="0" value="1499"></w4india:inr>)</button>		
         </div>         
      </div>
      <!-- end of .widget-wrapper -->
   </div>
   <!-- end of .col-300 -->
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3><fmt:message key="ITR4S.packageName"></fmt:message>&nbsp;&nbsp;<a href="#modal" data-toggle="modal" id="itr5" class="btn yellow"><i class="icon-info-sign"></i></a></h3>
         </div>
         <div class="textwidget">
            <div><fmt:message key="ITR5.whoCan"></fmt:message></div>	
            <%--<button type="button" class="btn btn-success">e-File (<w4india:inr minFractionDigits="0" value="1499"></w4india:inr>)</button> --%>
            <button type="button" class="btnfiling btn btn-info">eZ-File (<w4india:inr minFractionDigits="0" value="1499"></w4india:inr>)</button>				
         </div><br/>         
      </div>
      <!-- end of .widget-wrapper -->
   </div>
   <!-- end of .col-300 -->
   <div class="grid span4">
      <div class="widget-wrapper">
         <div class="widget-title-home">
            <h3>Other Services</h3>
         </div>
         <div class="textwidget">
            <hst:include ref="services-itr"/>
         </div>
      </div>
      <!-- end of .widget-wrapper -->
   </div>
</div>	
<!--this File is reponsible to add modal with respective youtube videos  -->
<jsp:include page="../../home/responsive/modal-tutorial.jsp"/>
<hst:headContribution keyHint="detectMobile" category="jsInternal">
   <script type="text/javascript">
      $(document).ready(function(){
        if ("${path}" == "/") {
          var isMobile = false;
          (function(a){isMobile=/android|avantgo|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|e\-|e\/|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(di|rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|xda(\-|2|g)|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))})(navigator.userAgent||navigator.vendor||window.opera);
          if (isMobile) {
            var answer = confirm("<fmt:message key="mobile.dialog" />");
            if (answer) {
              window.location = "<hst:link path="/mobile"/>";
            } else {}
          }
        }
      });
   </script>
</hst:headContribution>
<%--
   <hst:link var="nivoSliderCss" path="/css/nivo-slider.css"/>
   <hst:headContribution  category="css">
   	<link rel="stylesheet" type="text/css" href="${nivoSliderCss}" />
   </hst:headContribution>
    --%>
<hst:link var="nivoSliderCss" path="/css/nivo-slider.css"/>
<hst:headContribution  category="css">
   <style>
      .nivoSlider {
      position:relative;
      background:url(images/loading.gif) no-repeat 50% 50%;
      }
      .nivoSlider img {
      position:absolute;
      top:0px;
      left:0px;
      display:none;
      }
      .nivoSlider a {
      border:0;
      display:block;
      }
      .testimonial {
      margin: 0;
      background: #B7EDFF;
      padding: 10px 50px;
      position: relative;
      font-family: Georgia, serif;
      color: #666;
      border-radius: 5px;
      font-style: italic;
      text-shadow: 0 1px 0 #ECFBFF;
      background-image: linear-gradient(#CEF3FF, #B7EDFF);
      }
      .testimonial:before, .testimonial:after {
      content: "\201C";
      position: absolute;
      font-size: 80px;
      line-height: 1;
      color: #999;
      font-style: normal;
      }
      .testimonial:before {
      top: 0;
      left: 10px;
      }
      .testimonial:after {
      content: "\201D";
      right: 10px;
      bottom: -0.5em;
      }
      .arrow-down {
      width: 0;
      height: 0;
      border-left: 15px solid transparent;
      border-right: 15px solid transparent;
      border-top: 15px solid #B7EDFF;
      margin: 0 0 0 25px;
      }
      .testimonial-author {
      margin: 0 0 0 25px;
      font-family: Arial, Helvetica, sans-serif;
      color: #999;
      text-align:left;
      }
      .testimonial-author span {
      font-size: 12px;
      color: #666;
      }
      
       /* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */

    /* Carousel base class */
    .carousel {
      margin-bottom: 10px;
    }

    .carousel .container {
      position: relative;
      z-index: 9;
    }

    .carousel-control {
      height: 80px;
      margin-top: 0;
      font-size: 120px;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
      background-color: transparent;
      border: 0;
      z-index: 10;
    }

    .carousel .item {
      height: 350px;
    }
    .carousel img {
      position: absolute;
      top: 0;
      left: 0;
      min-width: 100%;
      height: 350px;
    }

    .carousel-caption {
      background-color: transparent;
      position: static;
      max-width: 550px;
      padding: 0 20px;
      margin-top: 200px;
    }
    .carousel-caption h1,
    .carousel-caption .lead {
      margin: 0;
      line-height: 1.25;
      color: #fff;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }
    .carousel-caption .btn {
      margin-top: 10px;
    }
    
   .captionfull {max-width: 650px;margin-top:50px;margin-left:80px;}
   </style>
</hst:headContribution>
<%--
<hst:headContribution  category="css">
   <link rel="stylesheet" type="text/css" href="http://demo.dev7studios.com/nivo-slider/wp-content/plugins/nivo-slider/scripts/nivo-slider/nivo-slider.css?ver=3.5.1"/>
</hst:headContribution>
<hst:headContribution  category="jsInternal">
   <link rel='stylesheet' id='nivoslider-theme-bar-css'  href='http://demo.dev7studios.com/nivo-slider/wp-content/plugins/nivo-slider/scripts/nivo-slider/themes/bar/bar.css?ver=3.5.1' type='text/css' media='all' />
</hst:headContribution>
<hst:headContribution  category="jsInternal">
   <link rel='stylesheet' id='nivoslider-theme-dark-css'  href='http://demo.dev7studios.com/nivo-slider/wp-content/plugins/nivo-slider/scripts/nivo-slider/themes/dark/dark.css?ver=3.5.1' type='text/css' media='all' />
</hst:headContribution>
<hst:headContribution category="jsExternal">
   <script type='text/javascript' src='http://twitter.github.io/bootstrap/assets/js/bootstrap-carousel.js'></script>
</hst:headContribution>
<hst:headContribution  category="jsInternal">
   <link rel='stylesheet' id='nivoslider-theme-default-css'  href='http://demo.dev7studios.com/nivo-slider/wp-content/plugins/nivo-slider/scripts/nivo-slider/themes/default/default.css?ver=3.5.1' type='text/css' media='all' />
</hst:headContribution>
<hst:headContribution  category="jsInternal">
   <link rel='stylesheet' id='nivoslider-theme-light-css'  href='http://demo.dev7studios.com/nivo-slider/wp-content/plugins/nivo-slider/scripts/nivo-slider/themes/light/light.css?ver=3.5.1' type='text/css' media='all' />
</hst:headContribution>
<hst:link var="nivoSlider" path="/js/jquery.nivo.slider.pack.js"/>
<hst:headContribution  category="jsExternal">
   <script type='text/javascript' src='${nivoSlider}'></script>
</hst:headContribution>

<hst:headContribution  category="jsInternal">
   <script type="text/javascript">
      jQuery(function($){
      	$(window).load(function() {
      	$('#slider').nivoSlider({
      		   effect:"random",
      	        slices:15,
      	        boxCols:8,
      	        boxRows:4,
      	        animSpeed:500,
      	        pauseTime:3000,
      	        startSlide:0,
      	        directionNav:true,
      	        controlNav:false,
      	        controlNavThumbs:false,
      	        pauseOnHover:true,
      	        manualAdvance:false
      	});
      	});
      });
   </script>
</hst:headContribution>
 --%>
 
 <hst:headContribution  category="jsInternal">
   <script type="text/javascript">
      jQuery(function($){
      	$(window).load(function() {
      		$(".btnfiling").click(function() {
      			window.location.href="<hst:link siteMapItemRefId="itreturnhome"/>";
      		});
      })
      });
   </script>
</hst:headContribution>