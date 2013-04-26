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
	var fieldConfig = <c:out value="${screenConfigDocumentJSON}" escapeXml="false"/>
	for (var fn in fieldConfig) {
		var fObj = $("input[name='" + fn + "']");
		if (fObj.length ==0) {
			fObj =$("select[name='" + fn + "']");
			if (fObj.length ==0) continue;
		}
		if (fObj.length ==0) continue;
		
		fObj.each( function(indx) {									
				validationRules.rules[fieldConfig[fn].fieldId] = new Object();
			}
		)
		
		switch (fieldConfig[fn].fieldFormat) {
			case "indiandate":
			case "date":
				fObj.datepicker({
						changeMonth : true,
						changeYear : true
					}).addClass("indiandate");	
				break;
			default:				
				if (fieldConfig[fn].fieldFormat != null && fieldConfig[fn].fieldFormat != '') {
					fObj.addClass(fieldConfig[fn].fieldFormat);
					validationRules.rules[fieldConfig[fn].fieldId][fieldConfig[fn].fieldFormat]=true;
				}
				break;
		}
		if (fieldConfig[fn].isRequired) {
			fObj.each( function(indx) {
					//alert(validationRules.rules);
					validationRules.rules[fieldConfig[fn].fieldId].required=true;
				}
			);
		}
		if (fieldConfig[fn].fieldTitle != '') {
			fObj.watermark(fieldConfig[fn].fieldTitle);
		}
	}
	$('#frmdata input').keydown(function(e) {
	    if (e.keyCode == 13) {
	   		e.preventDefault();
	        $('#frmdata').submit();
	    }
	});
	$('#frmdata').validate({
		rules: validationRules.rules					
	});

});    



