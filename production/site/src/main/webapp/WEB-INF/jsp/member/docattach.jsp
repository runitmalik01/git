<%@page import="com.mootly.wcm.model.ITRTab"%>
<%@page import="com.mootly.wcm.member.Attachments"%>
<%@page import="com.mootly.wcm.services.ScreenConfigService"%>
<%@page import="com.mootly.wcm.beans.compound.MemberDetail"%>
<%@include file="../includes/tags.jspf"%>
<%@ page import="com.mootly.wcm.utils.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mootly.wcm.beans.*"%>
<c:set var="termstitle"><fmt:message key="member.terms.title"/></c:set>

<hippo-gogreen:title title="${termstitle}"/>
<hst:actionURL var="actionUrl"></hst:actionURL>

<form method="POST" enctype="multipart/form-data" action="${actionUrl}">
<fieldset>
<legend>Please Upload Your Documents Here!!</legend>
<br />
 <label> File to upload:</label> <input type="file" name="attachment"><br/><br />
 <label> Notes about the file:</label> <input type="text" name="notes"><br/>
  <br/>
  <input type="submit" value="Press Me"> &nbsp;&nbsp;<label style="color: blue">to upload the file!</label> 
  </fieldset>
</form>
