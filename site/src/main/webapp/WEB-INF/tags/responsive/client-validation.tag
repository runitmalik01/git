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
<%@ attribute name="validationType" type="java.lang.String" description="Enter the Name of validation for 5th char like Pan:pan & Tan:tan" required="false" %>
<%@ attribute name="fieldOneID" description="Id of Field PAN/TAN" type="java.lang.String" required="false"%>
<%@ attribute name="fieldTwoID" description="Id of Field Last Name" type="java.lang.String" required="false"%>
<%
	HippoBean siteContentBaseBean = (HippoBean) request.getAttribute("siteContentBaseBean");
	if (siteContentBaseBean != null) {
		String screenConfigDocumentJSON = ScreenConfigService.generateJSON( siteContentBaseBean, screenConfigurationDocumentName);
		request.setAttribute("screenConfigDocumentJSON",screenConfigDocumentJSON);
	}
%>	
<hst:componentRenderingURL var="ajaxLinkToComponent"></hst:componentRenderingURL>
<c:if test="${not empty siteContentBaseBean && not empty screenConfigDocumentJSON}">
	<hst:element var="uiCustom" name="script">
		<hst:attribute name="type">text/javascript</hst:attribute>
		var flagforPanAndTan=true;
		var d = new Date();
		yrRange="1900:"+d.getFullYear();		
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
									changeYear : true,
                                    showAnim: "fadeIn",
                                    minDate: "01/01/1900",
                                    yearRange: yrRange
								}).addClass("indiandate");	
							break;
					case "indiandateAdvance":
								fObj.datepicker({
									changeMonth : true,
									changeYear : true,
                                    showAnim: "fadeIn",
                                  
								}).addClass("indiandateAdvance");
						case "indiandateSelfAssesment":
								fObj.datepicker({
									changeMonth : true,
									changeYear : true,
                                    showAnim: "fadeIn",
                                  
								}).addClass("indiandateSelfAssesment");
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
								//set the label with *
								if ( $("label[for='" + fieldConfig[fn].fieldId + "']").length > 0 ){
									$("label[for='" + fieldConfig[fn].fieldId + "']").append("<span class='required'>*</span>");
								}
							}
						);
					}
					if (fieldConfig[fn].fieldTitle != '') {
						fObj.watermark(fieldConfig[fn].fieldTitle);
					}
					if (fieldConfig[fn].fieldPopoverText != '') {
						fObj.popover({"html":true,"trigger":"focus",content:fieldConfig[fn].fieldPopoverText});
					}
				}
				<c:if test="${not empty validationType}">
				
				
                    $('#<c:out value="${fieldOneID}"/>,#<c:out value="${fieldTwoID}"/>').blur(function(){
                  
                        var ConvertFormToJSON=function(){
						     var array = jQuery('form').serializeArray();
						     var json = {};
						     jQuery.each(array, function(){
						     if(this.name.match('<c:out value="${fieldOneID}"/>')||this.name.match('<c:out value="${fieldTwoID}"/>'))
						     json[this.name] = this.value || '';
							 });
						     return json;
						     };
                       var reqFromJson=JSON.stringify(ConvertFormToJSON());
                          $.ajax({
						         url:'<c:out value="${ajaxLinkToComponent}"/>?validation=<c:out value="${validationType}"/>',
						         data: 'data='+reqFromJson,
						         datatype:'text',
						         success: function(data,textStatus,jqXhr) {
						                   if(jqXhr.getResponseHeader("myHeader").match('error')){
							                   $('#error').show();
							                   flagforPanAndTan=false;
							                   }
							             		 else {
							             		 $('#error').hide();
							             		 flagforPanAndTan=true;
							             		 }
					              }
					          });	
					   });</c:if>
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
					if(flagforPanAndTan){
		 				 $('#<c:out value="${formId}"/>').submit();
		 				 }
					});
                 </c:if>	
				$('.tan').attr("style","text-transform: uppercase;");		
			});   
			 
   </hst:element>
	<hst:headContribution element="${uiCustom}" category="jsInternal"/>	
</c:if>