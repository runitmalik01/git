<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>
<c:out value="${itReturnType}"/>
<div class="page">
	<h3>Income Tax Returns (<c:out value="${assessmentYear}"/>)</h3>

	<c:if test="${not empty pansForMember}">	
		<table>
			<tr>
				<th>PAN</th>
				<th>Filing As</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<tr>
				<td colspan="4"><b>Original Returns</b></td>
			</tr>
			<c:forEach items="${pansForMember}" var="panForMember">				
				<%
					HippoFolder hf = (HippoFolder) pageContext.getAttribute("panForMember");
					String assessmentYear = (String) request.getAttribute("assessmentYear");
					String itReturnType = "original";
					String relPath = assessmentYear + "/" + itReturnType + "/" + MemberPersonalInformation.class.getSimpleName().toLowerCase();
				    //out.println(relPath);
				    MemberPersonalInformation memberPersonalInfo =  hf.getBean(relPath,MemberPersonalInformation.class);
				    if (memberPersonalInfo != null) {
				    	request.setAttribute("memberPersonalInfo",memberPersonalInfo);
				    }
				    else {
				    	request.removeAttribute("memberPersonalInfo");
				    }				    
				%>
				<c:if test="${not empty  memberPersonalInfo}">
					<tr>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${assessmentYear}/original/${panForMember.name}/personalinformation.html"/>			
							<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${panForMember.name}"/></a></span>		
						</td>
						<td><c:out value="${memberPersonalInfo.filingStatus}"/></td>
						<td><c:out value="${memberPersonalInfo.name}"/></td>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${assessmentYear}/original/${panForMember.name}/personalinformation.html"/>
							<span style="font-size:10px;"><a href="${viewLink}">Continue</a></span>		
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<!--  duplicating logic will cleanup later -->
			<tr>
				<td colspan="4"><b>Revised Returns</b></td>
			</tr>
			<c:forEach items="${pansForMember}" var="panForMember">				
				<%
					HippoFolder hf = (HippoFolder) pageContext.getAttribute("panForMember");
					String assessmentYear = (String) request.getAttribute("assessmentYear");
					String itReturnType = "revised";
					String relPath = assessmentYear + "/" + itReturnType + "/" + MemberPersonalInformation.class.getSimpleName().toLowerCase();
				    //out.println(relPath);
				    MemberPersonalInformation memberPersonalInfo =  hf.getBean(relPath,MemberPersonalInformation.class);
				    if (memberPersonalInfo != null) {
				    	request.setAttribute("memberPersonalInfo",memberPersonalInfo);
				    }
				    else {
				    	request.removeAttribute("memberPersonalInfo");
				    }
				%>
				<c:if test="${not empty  memberPersonalInfo}">
					<tr>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${assessmentYear}/revised/${panForMember.name}/personalinformation.html"/>			
							<span style="text-transform:uppercase;"><a href="${viewLink}"><c:out value="${panForMember.name}"/></a></span>		
						</td>
						<td><c:out value="${memberPersonalInfo.filingStatus}"/></td>
						<td><c:out value="${memberPersonalInfo.name}"/></td>
						<td>
							<hst:link var="viewLink" path="/member/itreturn/${assessmentYear}/revised/${panForMember.name}/personalinformation.html"/>
							<span style="font-size:10px;"><a href="${viewLink}">Continue</a></span>		
						</td>
					</tr>
				</c:if>
			</c:forEach>			
		</table>
		<hst:element var="uiCustom" name="script">
			    <hst:attribute name="type">text/javascript</hst:attribute>
			    	<c:if test="${not empty jsonForValidators}"><c:out value="${jsonForValidators}"/></c:if>		    	
					$(document).ready(function() {
						
					});    
			</hst:element>
			<hst:headContribution element="${uiCustom}" category="jsInternal"/>
		
	</c:if>
</div>

