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

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>
var validationRules = new Object();
validationRules.rules = new Object();
$(document).ready(function() {
	var fieldConfig = <c:out value="${clientSideValidationJSON}" escapeXml="false"/>
	for (var fn in fieldConfig) {
		$("input[name='" + fn + "']").each( function(indx) {									
				validationRules.rules[$(this).attr('id')] = new Object();
			}
		)
		
		switch (fieldConfig[fn].dataType) {
			case "INDIANDATE":
			case "DATE":
				$("input[name='" + fn + "']").datepicker({
						changeMonth : true,
						changeYear : true
					}).addClass("indiandate");	
				break;
			case "DECIMAL":
				$("input[name='" + fn + "']").addClass("decimal");
				break;
		}
		if (fieldConfig[fn].isRequired) {
			$("input[name='" + fn + "']").each( function(indx) {
					//alert(validationRules.rules);
					validationRules.rules[$(this).attr('id')].required=true;
				}
			)
		}
	}
	$('#frmdata input').keydown(function(e) {
	    if (e.keyCode == 13) {
	   		e.preventDefault();
	        $('#frmdata').submit();
	    }
	});
	$('#frmdata').validate({
		rules: validationRules.rules,				
		messages: {
			username: "Please enter a valid email address.",
			password: "Please enter a valid password."
		}
	});
	
	$('#hrefLogin').click(function() {
			 $('#frmdata').submit();
	});
});    



