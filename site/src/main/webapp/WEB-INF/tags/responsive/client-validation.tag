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

<%@tag import="com.mootly.wcm.services.ScreenConfigService"%>
<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>
<%@ attribute name="screenConfigurationDocumentName" type="java.lang.String" rtexprvalue="true" required="true"%>
<%@ attribute name="formId" type="java.lang.String" rtexprvalue="true" required="true"%>
<%@ attribute name="formSubmitButtonId" type="java.lang.String" rtexprvalue="true" required="false"%>

<%
	HippoBean siteContentBaseBean = (HippoBean) request.getAttribute("siteContentBaseBean");
	if (siteContentBaseBean != null) {
		String screenConfigDocumentJSON = ScreenConfigService.generateJSON( siteContentBaseBean, screenConfigurationDocumentName);
		request.setAttribute("screenConfigDocumentJSON",screenConfigDocumentJSON);
	}
%>	
<c:if test="${not empty siteContentBaseBean && not empty screenConfigDocumentJSON}">
	<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>	
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
				$('#<c:out value="${formId}"/> input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#<c:out value="${formId}"/>').submit();
				    }
				});
				$('#<c:out value="${formId}"/>').validate({
					rules: validationRules.rules					
				});
				
				<c:if test="${not empty formSubmitButtonId}">
					$('#<c:out value="${formSubmitButtonId}"/>').click(function() {
		 				 $('#<c:out value="${formId}"/>').submit();
					});
				</c:if>			
			});    
	</hst:element>
	<hst:headContribution element="${uiCustom}" category="jsInternal"/>	
</c:if>