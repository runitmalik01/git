<%--This file is being used to calculation in all Screens --%>
<%@tag import="com.mootly.wcm.beans.ScreenCalculation"%>
<%@tag import="com.mootly.wcm.services.ScreenConfigService"%>
<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>
<%@ attribute name="screenCalc" type="java.lang.String" rtexprvalue="true" required="true"%>
<%@ attribute name="formId" type="java.lang.String" rtexprvalue="true" required="true"%>

<%
	HippoBean siteContentBaseBean = (HippoBean) request.getAttribute("siteContentBaseBean");
	if (siteContentBaseBean != null) {
		String pathToScreenCalc = "configuration/screencalculation/" + screenCalc.toLowerCase();
		ScreenCalculation screencalc=siteContentBaseBean.getBean(pathToScreenCalc, ScreenCalculation.class);
		String jqinput="";String jqdrop="";
		for(String field:screencalc.getInputTypeFields()) jqinput=jqinput+"#"+field.trim()+",";	
		for(String field:screencalc.getRadioDropTypeFields()){
			if ("".equals(field.trim())) continue;
			jqdrop=jqdrop+"#"+field.trim()+",";
		}		
		request.setAttribute("jqinput", jqinput.substring(0,jqinput.length()-1));
		if (jqdrop != null && jqdrop.length() > 0) request.setAttribute("jqdrop", jqdrop.substring(0,jqdrop.length()-1));
	}
%>
<hst:componentRenderingURL var="ajaxLinkToComponent"></hst:componentRenderingURL>
		<hst:element var="uiCustom" name="script">
			<hst:attribute name="type">text/javascript</hst:attribute>
			recalc_Counter = 0;
				//$(document).ready(function() {
					$("<c:out value="${jqinput}"/>").blur(
						recalc
						// recalc_Counter++;
					);
					$("<c:if test="${not empty jqdrop}"><c:out value="${jqdrop}"/></c:if>").change(function(){
						if ($(this).hasClass('trecalc') && recalc_Counter >0){
						alert("Please note all calculation will reset");
						$('.rrecalcAmt').each( function(indx) {
		       				  $(this).val('0');
		      				 
	  						    });
	  				}
						recalc(false)
						
						}
					);							
				//});    
				$(document).ready(function() {
					$('#<c:out value="${formId}"/>').submit(
						function(){
							recalc(false);
							return true;
						}						
					);
				});
				function recalc(isAsync) {
				recalc_Counter++;
					if (typeof(isAsync) == 'undefined') isAsync = true;
					$.ajax({
						url:'<c:out value="${ajaxLinkToComponent}"/>?command=calc&screen=<c:out value="${screenCalc}"/>',
						data: $("#<c:out value="${formId}"/>").serialize(),
						datatype:'json',
						async:isAsync,
						success: function(data,textStatus,jqXhr) {
							for (key in data) {
								//change the response
								$("#"+key).val(data[key]);
							}
					    }
					   });
				}
		</hst:element>
		<hst:headContribution element="${uiCustom}" category="jsInternal" />