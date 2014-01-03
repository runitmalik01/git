<%@include file="../includes/tags.jspf"%>
<hst:actionURL var="actionURL" />
<hippo-gogreen:title title="ITReturn-Analysis"></hippo-gogreen:title>
<w4india:dashboard-menu></w4india:dashboard-menu>
<div class="row">
	<div class="col-md-6">
		<div id="container1"
			style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
	<div class="col-md-6">
		<div id="container"
			style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>
</div>
${itrFormsList}${fyBasedNoOfReturns}
<!-- <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div> -->
<script type="text/javascript">
var startYear = 2012;
var endYear = new Date().getFullYear();
var yearList = [];
for(var i = startYear;i <= endYear; i++ ){
	yearList.push(i);
}
$(function () {
    $('#container1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Filed IT-Return on <w4india:resellername/>'
        },
        xAxis: {
            categories: yearList
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
            data: [2,3,4]//'<c:out value="${fyBasedNoOfReturns}"/>'
        }]
    });
});
var itr = ['ITR-1',  10];
$(function () {
    $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Analyse Filed IT-Return on <w4india:resellername/> with ITR-Forms'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: "No of ITR's",
            data: [
                itr,
                ['ITR-2',  11],
                ['ITR-3',  12],
                ['ITR-4',   4],
                ['ITR-5',   1],
                ['ITR-6',   0]
            ] 
        }]
    });
});
</script>