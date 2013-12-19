<%@include file="../../includes/tags.jspf" %>
<div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="<hst:link path="/images/slide-02.jpg"/>" alt="">
          <div class="container">
            <div class="carousel-caption captionfull">
              <h1>For Individuals and HUF</h1>
              <p class="lead">eFile or eZ File choice is yours. In any case its as easy as 1,2,3...
              <a class="btn btn-default btn-mini yellow" id="huf_invdl" data-toggle="modal" href="#modal" ><i class="glyphicon glyphicon-info-sign"></i><strong>Help</strong></a></p>
              <a class="btn btn-default btn-large btn-primary" href='<hst:link path="/signup"/>'>Sign up today</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="<hst:link path="/images/slide-02.jpg"/>" alt="">
          <div class="container">
            <div class="carousel-caption captionfull">
              <h1>eZ-File</h1>
              <p class="lead">Don't know what to do? Just choose eZ Filing option after you fill your personal information.<br/>
              <a class="btn btn-default btn-mini yellow" id="ezFile" data-toggle="modal" href="#modal" ><i class="glyphicon glyphicon-info-sign"></i><strong>Help</strong></a></p>
              <a class="btn btn-default btn-large btn-primary" href='<hst:link path="/signup"/>'>Sign up today</a>
            </div>
          </div>
        </div>
		<div class="item">
          <img src="<hst:link path="/images/slide-02.jpg"/>" alt="">
          <div class="container">
            <div class="carousel-caption captionfull">
              <h1>e-File</h1>
              <p class="lead">Do it yourself.<br/>
              <a class="btn btn-default btn-mini yellow" id="eFile" data-toggle="modal" href="#modal"><i class="glyphicon glyphicon-info-sign"></i><strong>Help</strong></a></p>
              <a class="btn btn-default btn-large btn-primary" href='<hst:link path="/signup"/>'>Sign up today</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="<hst:link path="/images/slide-03.jpg"/>" alt="">
          <div class="container">
            <div class="carousel-caption captionfull">
              <h1>For Companies and Firms.</h1>
              <p class="lead"><w4india:resellername/> offers comprehensive Tax services for Companies and Firms.</p>
              <a class="btn btn-default btn-large btn-primary" href='<hst:link path="/signup"/>'>Sign up today</a>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&#8249;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&#8250;</a>
</div>
<!--this File is reponsible to add modal with respective youtube videos  -->
<jsp:include page="../../home/responsive/modal-tutorial.jsp"/>