
<!-- New home page design 14tn Nov'13 -->


<%@include file="../../includes/tags.jspf"%>

<%-- <%@page import="org.hippoecm.hst.content.beans.standard.HippoBean"%> --%>
<c:set var="hometitle">
	<fmt:message key="home.title" />
</c:set>
<hippo-gogreen:title title="${hometitle}" />
<head>
<link rel="stylesheet" media="screen" type="text/css"
	href='<hst:link path="/css/bootstrap_v2/bootstrap.flat.min.css"></hst:link>' />
<link rel="stylesheet" media="screen" type="text/css"
	href='<hst:link path="/css/bootstrap_v2/wealth4india.css"></hst:link>' />
</head>

<body>
	<div class="jumbotron bg-jumbotron" style="background-image: url('images/bootstrap_v2_img/bg_jumbotron_v2.png');"> 
		<div class="container">
			<h1>Pricing as low as &#8377; 199!</h1>
			<h2>The Easiest and Fastest Way to E-File or eZ File Tax
				Returns!</h2>
			<p>
				For Individuals and HUF eFile or eZ File, the choice is yours.<br />
				Straight-forward pricing with no hidden fees. Securely file in as
				little as 15 minutes! <br /> Simple. Fast. Safe.
			</p>
			<p>
				<a class="btn btn-default btn-warning btn-lg" href='/site/home_v2'>Sign Up
					Now! &raquo;</a>
			</p>
		</div>
		</div>
</body>
<div class="container">
	<!-- Example row of columns -->
	<div class="row">
		<div class="col-lg-4">
			<h1 style="text-align: center; font-size: 5em">
				<span class="glyphicon glyphglyphicon glyphicon-usd"></span>
			</h1>
			<h1>Simple.</h1>
			<p class="lead">
				Simple, straight-forward pricing with no hidden fees. Easy-to-use
				tools to help you complete your e-file or eZ File tax return.<br />
				<a href="#">Learn More...</a>
			</p>
		</div>
		<div class="col-lg-4">
			<h1 style="text-align: center; font-size: 5em">
				<span class="glyphicon glyphglyphicon glyphicon-usd"></span>
			</h1>
			<h1>Fast.</h1>
			<p class="lead">
				Fast and easy service. Finish your e-file in as little as 15
				minutes! Don't know what to do? Just choose eZ Filing option after
				you fill your personal information.<br /> <a href="#">Learn
					More...</a>
			</p>
		</div>
		<div class="col-lg-4">
			<h1 style="text-align: center; font-size: 5em">
				<span class="glyphicon glyphglyphicon glyphicon-lock"></span>
			</h1>
			<h1>Safe.</h1>
			<p class="lead">
				Our secure servers and SSL encryption will keep your personal
				information safe. We are Authorized by Government of India for
				e-Filing.<br /> <a href="#">Learn More...</a><br />
			</p>
		</div>
	</div>


	<hr>
	<div class="container well">
		<div class="row">
			<div class="col-lg-12">
				<h2>For Individuals:</h2>
			</div>
		</div>
		<div class="row well">
			<div class="col-lg-3">
				<div class="bestplan">
					<div class="bestplan-header">Best Savings!</div>
					<h2>Basic</h2>

					<p>
						If you have a simple tax return to file, choose this easy plan.<br />
						<br /> <br />
					</p>

					<p>
						<a class="btn btn-default btn-success btn-lg btn-block" href="#">Pricing
							from &#8377; 199</a>
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="plan">
					<div class="plan-header">&nbsp;</div>
					<h2>Deluxe</h2>
					<p>File your return with Salary details, Bank Interest, House
						Properties and Other Source income details.</p>
					<p>
						<a class="btn btn-default btn-info btn-lg btn-block" href="#">Pricing from
							&#8377; 299</a>
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="plan">
					<div class="plan-header">&nbsp;</div>
					<h2>Premier</h2>
					<p>People who deal with Capital Gains and Shares or have any
						other source of Income, need to file through this plan.</p>
					<p>
						<a class="btn btn-default btn-info btn-lg btn-block" href="#">Pricing from
							&#8377; 499</a>
					</p>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="betterplan">
					<div class="betterplan-header">Most Popular Plan!</div>
					<h2>Platinum</h2>
					<p>Choose this plan if you have a Professional Income or Income
						from Business along with any other Income.</p>
					<p>
						<a class="btn btn-default btn-primary btn-lg" href="#">Pricing from
							&#8377; 999</a>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h2>For Assisted Filing:</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="well gold">
					<h3>Need live, assisted help with your taxes? Work with one of
						our Tax Professionals!</h3>
					<p>Tax preparation can be confusing, complex and complicated.
						Our certified tax professionals will assist you with your return,
						no matter how complex.</p>
					<p>Benefits of working with a LIVE tax professional:
					<ul>
						<li>Work securely online to discuss and review your tax
							filings.</li>
						<li>Avoid time-consuming office appointments and trips.</li>
						<li>Enjoy peace of mind that your INDIVIDUAL and/or BUSINESS
							tax filings will be prepared and reviewed by a tax professional.</li>
						<li>Maximize your tax savings and return with our
							professional guidance</li>
						<li>Get answers to your tax questions from an experienced
							professional.</li>

					</ul>
					<p>
						<a class="btn btn-default btn-primary btn-lg" href="#">Pricing from
							&#8377; 1099</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end main container -->

<div class="container">
	<footer>
		<p>
			Call Us: <a href="callto:+91-11-45067102">+91-11-45067102</a>, <a
				href="callto:+91-11-25074341">+91-11-25074341</a>, <a
				href="callto:+91-9136265229">+91-9136265229</a> <br /> <a
				href='/site/contactus'>Our India Offices</a> are open from 9:30 am -
			9:30 pm IST

		</p>
	</footer>
</div>

<!--this File is reponsible to add modal with respective youtube videos  -->
<script src='./js/bootstrap_v2/bootstrap.min.js'></script>
<script src='./js/bootstrap_v2/bootstrap.js'></script>
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





