<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<hippo-gogreen:title title="ITReturn-Analysis"></hippo-gogreen:title>
<w4india:dashboard-menu></w4india:dashboard-menu>
<div class="row">
	<div class="col-md-6">
		<div id="container1"
			style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	</div>
	<div class="col-md-6">
		<div id="container"
			style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	</div>
</div>
<script type="text/javascript">
var yearList = []; var noOfITReturn = [];
<c:forEach items="${fyList}" var="fy">
yearList.push('<c:out value="${fy}"/>');
</c:forEach>
<c:forEach items="${fyBasedNoOfReturns}" var="nr"> 
noOfITReturn.push(<c:out value="${nr}"/>);
</c:forEach>
$( document ).ready(
		function () {
		    $('#container1').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'Filed IT-Return on <w4india:resellername/>'
		        },
		        xAxis: {
		            categories: yearList,
		            title: {
		                text: 'Financial Year'
		            }
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'Total Number of IT-Returns'
		            },
		            stackLabels: {
		                enabled: true,
		                style: {
		                    fontWeight: 'bold',
		                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
		                }
		            }
		        },
		        legend: {
		            align: 'right',
		            x: -70,
		            verticalAlign: 'top',
		            y: 20,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
		            borderColor: '#CCC',
		            borderWidth: 1,
		            shadow: false
		        },
		        tooltip: {
		            formatter: function() {
		                return '<b>'+ this.x +'</b><br/>'+
		                    this.series.name +': '+ this.y +'<br/>'+
		                    'Total: '+ this.point.stackTotal;
		            }
		        },
		        plotOptions: {
		            column: {
		                stacking: 'normal',
		                dataLabels: {
		                    enabled: true,
		                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
		                }
		            }
		        },
		        series: [{
		        	name: 'IT-Returns',
		            data: noOfITReturn//'<c:out value="${fyBasedNoOfReturns}"/>'
		        }]
		    });
		}
	);
var itrFormsArray = [];
<c:forEach items="${itrFormsList}" var="itrForm">
 var itrForm = [];
   <c:forEach items="${itrForm}" var="itr">
      if($.isNumeric('<c:out value="${itr}"/>')) {
    	  itrForm.push(<c:out value="${itr}"/>);
      } else {
    	  itrForm.push('<c:out value="${itr}"/>');
      }        
   </c:forEach> 
   itrFormsArray.push(itrForm);
</c:forEach>
$( document ).ready(
	function() {
		$('#container').highcharts(
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false
							},
							title : {
								text : 'Analyse Filed IT-Return on <w4india:resellername/> with ITR-Forms'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										color : '#000000',
										connectorColor : '#000000',
										format : '<b>{point.name}</b>: {point.percentage:.1f} %'
									}
								}
							},
							series : [ {
								type : 'pie',
								name : "No of IT-Returns",
								data :   itrFormsArray
							} ]
						});
	}
);
</script>
<script type="text/javascript" src="<hst:link path="js/highchart/themes/gray.js"/>"></script>
<script src="//code.highcharts.com/highcharts.js"></script>