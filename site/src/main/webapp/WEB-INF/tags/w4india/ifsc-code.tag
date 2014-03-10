<%@tag import="com.mootly.wcm.model.ITReturnType"%>
<%@tag import="com.mootly.wcm.model.FinancialYear"%>
<%@tag import="net.sf.ehcache.store.MemoryStoreEvictionPolicy.MemoryStoreEvictionPolicyEnum"%>
<%@tag import="com.mootly.wcm.model.ITRServiceDelivery"%>
<%@tag import="org.hippoecm.hst.util.HstResponseUtils"%>
<%@tag import="org.hippoecm.hst.core.component.HstResponse"%>
<%@tag import="org.hippoecm.hst.configuration.site.HstSite"%>
<%@tag import="com.mootly.wcm.model.ITRForm"%>
<%@tag import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@tag import="org.hippoecm.hst.content.beans.standard.HippoBean"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenuItem"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenu"%>
<%@tag import="org.hippoecm.hst.core.sitemenu.HstSiteMenusImpl"%>
<%@tag import="org.hippoecm.hst.core.request.ResolvedSiteMapItem"%>
<%@tag import="org.hippoecm.hst.core.component.HstRequest"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="w4india" tagdir="/WEB-INF/tags/w4india" %>

<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>

<%@ attribute name="ifscCodeId" required="false" type="java.lang.String" %>
<span><a target="_new" id="findIfscLink" href="http://www.rbi.org.in/Scripts/bs_viewcontent.aspx?Id=2009">Find IFSC</a></span>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
    jQuery(document).ready(function($) {
    	$("#findTanLink").click (function(){
    		url = "http://www.rbi.org.in/Scripts/bs_viewcontent.aspx?Id=2009";
    		<c:if test="${not empty ifscCodeId}">url += "&ifscCode=" + $("#ifscCodeId").val();</c:if>
    		window.open(url);
    	})
    });
    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>