<%@include file="../includes/tags.jspf"%>
<c:set var="resellerName"><w4india:resellername/></c:set>
<div id="myCarousel" class="carousel slide">
	<div class="carousel-inner">
		<c:if test="${not empty banners}">
			<c:forEach items="${banners}" var="document" varStatus="carastat">
				<div class="item <c:if test="${carastat.index eq '0'}">active</c:if>">
					<img src="<hst:link hippobean="${document.image.original}"/>" alt=""/>
					<div class="container">
					  <c:if test="${buttonTextOn eq 'true'}">
						<div class="carousel-caption captionfull">
							<h1>
								<c:out value="${fn:toUpperCase(document.name)}" />
							</h1>
							<p class="lead">
								<c:out value="${fn:replace(document.title,'${resellerName}',resellerName)}"/>
								<a class="btn btn-mini yellow" id="huf_invdl" data-toggle="modal" href="#modal"><i class="icon-info-sign"></i><strong>Help</strong></a>
							</p>
							<a class="btn btn-large btn-primary" href='<hst:link path="/signup"/>'>Sign up today</a>
						</div>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">&#8249;</a>
	<a class="right carousel-control" href="#myCarousel" data-slide="next">&#8250;</a>
</div>

<!--this File is reponsible to add modal with respective youtube videos  -->
<jsp:include page="../home/responsive/modal-tutorial.jsp" />

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

<%-- <%@include file="../includes/tags.jspf" %>
<div id="featured" class="grid col-940">
        <div class="grid col-460">
          <!-- <h1 class="featured-title">Stressed about Income Tax Return?</h1> -->
          <h2 class="featured-subtitle">Stressed about Income Tax Return?</h2>
          <p><w4india:resellername/> Tax Return can take care of your income tax returns. Its as easy as 1,2,3..</p>
          <div class="call-to-action"><a href="#nogo" class="orange button">Free! Get Started!</a></div><!-- end of .call-to-action -->
        </div><!-- end of .col-460 -->
        <div id="featured-image" class="grid col-460 fit"><img class="aligncenter" src="images/Drawing2.png" width="440" height="300" alt="" /></div><!-- end of #featured-image -->
</div><!-- end of #featured --> --%>