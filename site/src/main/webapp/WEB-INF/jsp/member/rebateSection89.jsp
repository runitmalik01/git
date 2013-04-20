<%--Copyright (C) 2010 Hippo B.V.

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

<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf"%>
<c:set var="section89">
	<fmt:message key="rebate.section89" />
</c:set>
<hippo-gogreen:title title="${section89}" />
<div id="breadcrumbs">
	<fmt:message key="member.location.label" />
	<hst:link var="home" siteMapItemRefId="home" /> <a
		href="${home}"><fmt:message key="products.detail.location.home" /></a>&gt;
	
	<hst:link var="rebatesection89"
			siteMapItemRefId="rebatesection89"></hst:link> <a
		href="${rebatesection89}"><fmt:message key="rebate.section89" /></a>

</div>
<br />
<script type="text/javascript">

	var $m = jQuery.noConflict(true);
	$m(document).ready(function() {
		var netincome = $m('#salaryincome').val() - 0;
		var totalarrear = $m('#arrear').val() - 0;
		var total = netincome + totalarrear;
		var curryear='<c:out value="${assessmentYear}"/>';
		var computedtabletotal = ('#computedtabletotal').val() - 0;
		$m('#totalincomearrears').val(total);
		var gender = "M";
		var taxonnetincome = calculateTax(curryear, gender, netincome);
		var taxontotal = calculateTax(curryear, gender, total);
		$m('#diff').val(Math.round((taxontotal - taxonnetincome) * 100) / 100);
		var taxpaid = Math.round((diff - computedtabletotal) * 100) / 100;
		if (taxpaid < 0) {
			$m('#taxpaid').val(0);
		} else {
			$m('#taxpaid').val(taxpaid);
		}

	});
	function calculate() {
		var assyear1 = $m('#prevyear').val();
		if (!(assyear1.match("-Select-"))) {
			var income1 = $m('#income1').val() - 0;
			var arrears1 = $m('#arrears1').val() - 0;
			var total1 = parseInt(income1) + parseInt(arrears1);
			$m('#total1').val(total1);
			var gender = "M";
			var total1 = parseInt(income1) + parseInt(arrears1);
			$m('#total1').val(total1);
			var taxontotal1 = calculateTax(assyear1, gender, total1);
			var taxincome1 = calculateTax(assyear1, gender, income1);
			$m('#taxontotal1').val(taxontotal1);
			$m('#taxincome1').val(taxincome1);
			$m('#taxdiff1').val(
					Math.round((taxontotal1 - taxincome1) * 100) / 100);
			var taxdiff1 = $m('#taxdiff1').val();
		}
	}
	function calculateTax(assyear, gender, tax) {

		if (assyear == "2005-2006" || assyear == "2006-2007") {
			if (gender == "M") {
				if (tax <= 100000) {
					return 0;
				} else if (tax >= 100001 && tax <= 150000) {
					var b = (tax - 100000) * 0.1;
					var c = b * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 150001 && tax <= 250000) {
					var b = ((tax - 150000) * 0.2) + 5000;
					var c = (b) * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.2) + 25000;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.02;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "F") {
				if (tax <= 100000) {
					return 0;
				} else if (tax >= 135001 && tax <= 150000) {
					var b = (tax - 135000) * 0.1;
					var c = b * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;

				} else if (tax >= 150001 && tax <= 250000) {
					var b = ((tax - 150000) * 0.2) + 1500;
					var c = (b) * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.3) + 21500;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.02;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "Senior") {
				if (tax >= 185000) {
					return 0;
				} else if (tax >= 185001 && tax <= 250000) {
					var b = ((tax - 185000) * 0.2);
					var c = (b) * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.3) + 6500;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.02;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			}
		} else if (assyear == "2008-2009") {
			if (gender == "M") {
				if (tax <= 150000) {
					return 0;
				} else if (tax >= 150001 && tax <= 300000) {
					var b = (tax - 150000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 300000) * 0.2) + 15000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var a = 0;
					var b = ((tax - 500000) * 0.3) + 55000;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.03;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "F") {
				if (tax <= 180000) {
					return 0;
				} else if (tax >= 180001 && tax <= 300000) {
					var b = (tax - 150000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 300000) * 0.2) + 12000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var a = 0;
					var b = ((tax - 500000) * 0.3) + 52000;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.03;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "Senior") {
				if (tax <= 225000) {
					return 0;
				} else if (tax >= 225001 && tax <= 300000) {
					var b = (tax - 225000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 300000) * 0.2) + 7500;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var a = 0;
					var b = ((tax - 500000) * 0.3) + 47500;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.03;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			}
		} else if (assyear == "2007-2008") {
			if (gender == "M") {
				if (tax <= 110000) {
					return 0;
				} else if (tax >= 110001 && tax <= 150000) {
					var b = (tax - 110000) * 0.1;
					var c = b * 3;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 150001 && tax <= 250000) {
					var b = ((tax - 150000) * 0.2) + 4000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.3) + 24000;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.03;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "F") {
				if (tax <= 145000) {
					return 0;
				} else if (tax >= 145001 && tax <= 150000) {
					var b = (tax - 145000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 150001 && tax <= 250000) {
					var b = ((tax - 150000) * 0.2) + 500;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.3) + 20500;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.03;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "Senior") {
				if (tax >= 195000) {
					return 0;
				} else if (tax >= 195001 && tax <= 250000) {
					var b = ((tax - 195000) * 0.2);
					var c = (b) * 0.02;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 250000) {
					var a = 0;
					var b = ((tax - 250000) * 0.3) + 5500;
					if (tax > 1000000) {
						a = b * 0.1;
					}
					var c = (b) * 0.02;
					var d = Math.round((a + b + c) * 100) / 100;
					return d;
				}
			}
		} else if (assyear == "2009-2010") {
			if (gender == "M") {
				if (tax <= 160000) {
					return 0;
				} else if (tax >= 160001 && tax <= 300000) {
					var b = (tax - 160000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 150000) * 0.2) + 14000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var b = ((tax - 250000) * 0.3) + 34000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "F") {
				if (tax <= 190000) {
					return 0;
				} else if (tax >= 190001 && tax <= 300000) {
					var b = (tax - 190000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 150000) * 0.2) + 11000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var b = ((tax - 250000) * 0.3) + 31000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "Senior") {
				if (tax <= 240000) {
					return 0;
				} else if (tax >= 240001 && tax <= 300000) {
					var b = (tax - 240000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 300001 && tax <= 500000) {
					var b = ((tax - 150000) * 0.2) + 6000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 500000) {
					var b = ((tax - 250000) * 0.3) + 26000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			}
		} else if (assyear == 2010 - 2011) {
			if (gender == "M") {
				if (tax <= 160000) {
					return 0;
				} else if (tax >= 160001 && tax <= 500000) {
					var b = (tax - 160000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 500001 && tax <= 800000) {
					var b = ((tax - 500000) * 0.2) + 34000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 800000) {
					var b = ((tax - 800000) * 0.3) + 94000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "F") {
				if (tax <= 190000) {
					return 0;
				} else if (tax >= 190001 && tax <= 500000) {
					var b = (tax - 190000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 500001 && tax <= 800000) {
					var b = ((tax - 500000) * 0.2) + 31000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 800000) {
					var b = ((tax - 800000) * 0.3) + 91000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			} else if (gender == "Senior") {
				if (tax <= 240000) {
					return 0;
				} else if (tax >= 240001 && tax <= 500000) {
					var b = (tax - 240000) * 0.1;
					var c = b * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax >= 500001 && tax <= 800000) {
					var b = ((tax - 500000) * 0.2) + 26000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				} else if (tax > 800000) {
					var b = ((tax - 800000) * 0.3) + 86000;
					var c = (b) * 0.03;
					var d = Math.round((b + c) * 100) / 100;
					return d;
				}
			}
		} else if (assyear == "2013-2014") {
			if (gender == "M") {
				if (tax <= 200000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 200001 && tax <= 500000) {
					var A = (tax - 200000) * 0.1;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 1000000) {
					var A = ((tax - 500000) * 0.2) + 30000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 1000000) {
					var A = ((tax - 1000000) * 0.3) + 130000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			} //  Year 2013-2014..For Male and Female
			else if (gender == "Senior") {
				if (tax <= 250000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 250001 && tax <= 500000) {
					var A = ((tax - 250000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 1000000) {
					var A = ((tax - 500000) * 0.2) + 25000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 1000000) {
					var A = ((tax - 1000000) * 0.3) + 125000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			} // Year 2013-2014..Senior Citizen
			else if (gender == "SuperSenior") {
				if (tax <= 500000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 500001 && tax <= 1000000) {
					var A = ((tax - 500000) * 0.2);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 1000000) {
					var A = ((tax - 1000000) * 0.3) + 100000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			} //Year 2013-2014..Super Senior Citizen 
		}// Assesssment Year 2013-2014 Calculation
		else if (assyear == "2012-2013") {
			if (gender == "M") {
				if (tax <= 180000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 180001 && tax <= 500000) {
					var A = ((tax - 180000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 32000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 92000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			}// Year 2012-2013.. Male Calculation
			else if (gender == "F") {
				if (tax <= 190000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 190001 && tax <= 500000) {
					var A = ((tax - 190000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 31000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 91000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			}// Year 2012-2013.. Female Calculation
			else if (gender == "Senior") {
				if (tax <= 250000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 250001 && tax <= 500000) {
					var A = ((tax - 250000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 25000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 85000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			}// Year 2012-2013.. Senior Citizen Calculation
			else if (gender == "SuperSenior") {
				if (tax <= 500000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 60000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			} // Year 2012-2013.. Super Senior Citizen Calculation      
		} // Assesssment Year 2012-2013 Calculation  

		else if (assyear == "2011-2012") {
			if (gender == "M") {
				if (tax <= 160000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 160001 && tax <= 500000) {
					var A = ((tax - 160000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 34000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 94000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			}// Year 2011-2012.. Male Calculation
			else if (gender == "F") {
				if (tax <= 190000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 190001 && tax <= 500000) {
					var A = ((tax - 190000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 26000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 86000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			} // Year 2011-2012.. Female Calculation

			else if (gender == "Senior") {
				if (tax <= 240000 && tax != 0) {
					var D = 0;
					return D;
				} else if (tax > 240001 && tax <= 500000) {
					var A = ((tax - 240000) * 0.1);
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 500001 && tax <= 800000) {
					var A = ((tax - 500000) * 0.2) + 26000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				} else if (tax > 800000) {
					var A = ((tax - 800000) * 0.3) + 86000;
					var B = A * 0.02;
					var C = A * 0.01;
					var D = Math.round((A + B + C) * 100) / 100;
					return D;
				}
			}// Year 2011-2012... Senior Citizen 
			//Assessment Year 2011-2012 Calculations		       
		}
	}//End
</script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="page type-page">
<c:choose>
	<c:when test="${(pageAction == 'EDIT_CHILD' || pageAction == 'NEW_CHILD') || pageAction == 'NEW_CHILD'}">
		<h5><small><fmt:message key="member.employe.message" /></small></h5>
		<form id="frmdata" action="${actionUrl}" name="salaryfrm" method="post">
		<fieldset>
		<legend><fmt:message key="rebate.section89.prev.arrears" /></legend>
		   <p>
			   <label><fmt:message key="rebate.section89.prev.year" /></label>
			     <c:set var="scheduletitle">
							<fmt:message key="member.schedule80C.select" /></c:set> 
				 <c:set var="scheduleType">
							<fmt:message key="dropdown.assessyear" /></c:set> 
			<w4india:dropdown dropDownSelectId="prevyear" optionSelectString="${scheduletitle}" dropDownType="${scheduleType}" dropDownFuction="calculate()"/></p>
			        <p>
                        <label><fmt:message key="rebate.section89.prev.income" /></label>
					<input type='text' size='8' name='previncome' id="income1" onchange="calculate()" class="numberinput" value="${childBean.prevIncome }" /></p>
					<p>
						<label><fmt:message key="rebate.section89.prev.arrears" /></label>
					<input type='text' size='8' name='prevarrears' id="arrears1" onchange="calculate()" class="numberinput" value="${childBean.prevArrears }" /></p>
					<p>
						<label><fmt:message key="rebate.section89.prev.total" /></label>
					<input type='text' size='8' name='prevtotal' id="total1" readonly='readonly' value="${childBean.prevTotalIncome }" /></p>
					<p>
						<label><fmt:message key="rebate.section89.prev.taxontotal" /></label>
					<input type='text' size='8' name='prevtaxontotal' id="taxontotal1" readonly='readonly' value="${childBean.prevTaxTotalIncome }" /></p>
					<p>
						<label><fmt:message key="rebate.section89.prev.taxincome" /></label>
					<input type='text' size='8' name='prevtaxincome' id="taxincome1" readonly='readonly' value="${childBean.prevTaxIncome }" /></p>
					<p>
					    <label><fmt:message key="rebate.section89.prev.taxdiff" /></label>
					<input type='text' size='8' name='pervtaxdiff' id="taxdiff1" readonly='readonly' value="${childBean.prevTaxDiff }" /></p>
						</fieldset>
		<a href="${redirectURLToSamePage}" class="button olive">Cancel</a>&nbsp;<input type="submit" value="Save" id="hrefLogin" class="button orange"/>
		</form>
		<hst:element var="uiCustom" name="script">
		    <hst:attribute name="type">text/javascript</hst:attribute>
				$(document).ready(function() {
					$('#frmdata input').keydown(function(e) {
					    if (e.keyCode == 13) {
					   		e.preventDefault();
					        $('#frmdata').submit();
					    }
					});
					
					$('#hrefLogin').click(function() {
		 				 $('#frmdata').submit();
					});
				});    
		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal"/>
	</c:when>
		<c:otherwise>				
				<table>
					<tr align="center">
					<th><b><fmt:message key="rebate.section89.prev.year"/></b></th>
					<th><b><fmt:message key="rebate.section89.prev.income"/></b></th>
					<th><b><fmt:message key="rebate.section89.prev.arrears"/></b></th>
					<th><b><fmt:message key="rebate.section89.prev.taxdiff"/></b></th>
					<th><b>Actions</b></th>				
					</tr>
					<c:if test="${not empty parentBean}">
						<c:forEach items="${parentBean.prevSalaryInfoList}" var="prevsalaryinfo">
							<tr>
								<td><a href="${redirectURLToSamePage}/<c:out value="${prevsalaryinfo.canonicalUUID}"/>/edit"><c:out value="${prevsalaryinfo.prevYear}"/></a></td>
								<td><c:out value="${prevsalaryinfo.prevIncome}"/></td>
								<td><c:out value="${prevsalaryinfo.prevArrears}"/></td>
								<td><c:out value="${prevsalaryinfo.prevTaxDiff}"/></td>
								<td><a href="${redirectURLToSamePage}/<c:out value="${prevsalaryinfo.canonicalUUID}"/>/edit"><small>Edit</small></a>&nbsp;&nbsp;<a href="${redirectURLToSamePage}/<c:out value="${prevsalaryinfo.canonicalUUID}"/>/delete"><small>Delete</small></a></td>
							</tr>
						</c:forEach>					
					</c:if>			
				</table>
				<a href="${redirectURLToSamePage}/new" class="button orange">Add New</a>
				<form id="frmdata" action="${actionUrl}" name="salaryfrm" method="post">
				<fieldset>
				<p>
                <fmt:message key="rebate.section89.salaryincome" />
			    <input type="text" name="salaryincome" id="salaryincome" value="${Taxable}" title="Salary Income as Enter in Sources of Income" readonly="readonly" /></p>
			    <p>
                <fmt:message key="rebate.section89.arrears"/>                    
				<input type="text" name="arrears" value="${parentBean.arrears}" onchange="currcalArrers()" id="arrears" title="Enter Arrears" class="numberinput" readonly="readonly" /></p>
				<p>		
                <fmt:message key="rebate.section89.totalincome.arrears" />	
				<input type="text" name="totalincomearrears" value="${parentBean.totalIncomeArrears}" id="totalincomearrears" title="Total Income in current Year included Arrears"readonly="readonly" /></p>
				<p>		
                <fmt:message key="rebate.section89.tax.salaryincome" />
				<input type="text" name="taxsalaryincome" value="${parentBean.taxSalaryIncome}" id="taxsalaryincome" title="Tax on total Income excluded Arrears or Advance" readonly="readonly" /></p>
				<p>
			    <fmt:message key="rebate.section89.tax.totalincome.arrears" />
				<input type="text" name="taxarrears" value="${parentBean.taxArrears}" id="taxarrears"	title="Tax on Total Income of Current Year included Arrears" readonly="readonly" /></p>
				<p>
				<fmt:message key="rebate.section89.tax" />
				<input type="text" name="diff" value="${parentBean.diff}" id="diff" title="Difference(Tax on salary received in arrears or advance)" readonly="readonly" /></p>
				<p>
				<fmt:message key="rebate.section89.tax.computed.table" />	
				<input type="text" name="computedtabletotal" value="${parentBean.computedTableTotal}" id="computedtabletotal"	title="Difference(Tax on salary received in arrears or advance)" readonly="readonly" /></p>
				<p>
				<fmt:message key="rebate.section89.tax.paid" />
				<input type="text" name="taxpaid" value="${parentBean.taxRelief}" id="taxpaid" title="Difference(Tax on salary received in arrears or advance)" readonly="readonly" /></p>
						
				<input type="submit" name=" Next " height="38px" value="Next" width="90px" onclick="Date()" class="button orange"/>
			</fieldset>
			</form>
	</c:otherwise>
</c:choose>
</div>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="show-hide" category="jsInternal">
	<script type="text/javascript"
		src='<hst:link path="/js/show-hide.rebate.js"/>'></script>
</hst:headContribution>