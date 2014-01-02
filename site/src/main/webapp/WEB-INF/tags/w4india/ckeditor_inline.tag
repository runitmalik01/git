<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hst" uri="http://www.hippoecm.org/jsp/hst/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%@ tag import="com.mootly.wcm.utils.*" %>
<%@ tag import="java.util.*" %>

<%@ attribute name="textAreaId" required="true" type="java.lang.String" %>


<hst:element var="uiCustom" name="style">
	<hst:attribute name="type">text/css</hst:attribute>
		/* Style the CKEditor element to look like a textfield */
		.cke_textarea_inline
		{
			padding: 10px;
			height: 200px;
			overflow: auto;

			border: 1px solid gray;
			-webkit-appearance: textfield;
		}
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />

<hst:element var="uiCustom" name="script">
	<hst:attribute name="src"><hst:link path="/ckeditor/ckeditor.js"/></hst:attribute>	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsHead" />

<hst:element var="uiCustom" name="script">
	CKEDITOR.inline( '<c:out value="${textAreaId}"/>' );	
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal" />
