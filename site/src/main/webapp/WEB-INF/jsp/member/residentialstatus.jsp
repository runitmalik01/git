
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf"%>
<c:set var="residentialstatus">
	<fmt:message key="member.residential.status" />
</c:set>
<hippo-gogreen:title title="${residentialstatus}"></hippo-gogreen:title>
<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<%
String varToReplace = (String) pageContext.getAttribute("mainSiteMapRefId");
if (varToReplace != null) {
    String pan = (String) request.getAttribute("pan");
    String itReturnType = (String) request.getAttribute("itReturnType");
	String modifiedSiteMapRefId = varToReplace.replaceFirst("_default_",itReturnType).replace("_default_", pan).replaceAll("residentialstatus","bankdetail");
	pageContext.setAttribute("modifiedSiteMapRefId",modifiedSiteMapRefId);
}
else {
	pageContext.setAttribute("modifiedSiteMapRefId",mainSiteMapRefId);
}
%>
<script>
	var qs = <c:out value="${jsonObject}" escapeXml="false"/>
</script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="frmResidential" id="frmResidential" method="post" action="${actionUrl }">
<ul>
	<li>
		<ul>
			<li style="display:inline"><c:out value="${map['rsstatus_q']}"/></li>
			<li style="display:inline">
				<select class="answer" id="rsstatus_q" name="rsstatus_q">
					<option>Select</option>
					<option value="yes">Yes</option>
					<option value="no">No</option>
				</select>
			</li>
		</ul>	
		<c:forEach items="${map}" var="item" varStatus="status">
			<c:if test="${item.key != 'rsstatus_q'}">
				<c:set var="pageItemValue" value="${item.value}"/>
				<%				
					pageContext.setAttribute("isAnswer","false");
					String pageItemValue =  (String) pageContext.getAttribute("pageItemValue");
					if (pageItemValue != null && pageItemValue.startsWith("ans_")) {
						pageContext.setAttribute("isAnswer","true");
					}
				%>				
					<ul id="ul_<c:out value="${item.key}"/>" style="display:none;visiblity:hidden">
						<li style="display:inline"><c:choose>
								<c:when test="${fn:startsWith(item.value,'ans_')}">
									<br/><p id="resi<c:out value="${status.index}" />" style="color:#65B43D;">
									<b><c:out value="${fn:replace(item.value,'ans_','')}"/></b></p>
								</c:when>
								<c:otherwise>
									<c:out value="${item.value}"/>
								</c:otherwise>
							</c:choose><br/>
						<c:if test="${fn:startsWith(item.value,'ans_')}">
						<a  id="hrefLogin" class="button orange" onclick="check()">Save &amp; Next</a>
						<a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a>
						<input type="hidden" name="${item.key}" value="${item.value}"/></c:if></li>
						<li style="display:inline">
							<c:if test="${isAnswer != 'true'}">
								<select class="answer" id="<c:out value="${item.key}"/>" name="<c:out value="${item.key}"/>">
									<option>Select</option>
									<option value="yes">Yes</option>
									<option value="no">No</option>
								</select>
							</c:if>
						</li>
					</ul>					
			</c:if>
		</c:forEach>		
	</li>
</ul>
</form>
<c:if test="${not empty parentBean }">
	<c:if test="${not empty fetchmap}">
<c:forEach items="${fetchmap}" var="item" varStatus="stat">
<c:if test="${fn:contains(item.value,'yes') || fn:contains(item.value,'no') }">
  <c:set var="myVar" value="${stat.first ? '' : myVar}${item.value}_" />
  </c:if>
	</c:forEach>
	</c:if>
</c:if>
<c:set var="len" value="${fn:length(myVar)}"/>
<c:set  var="modmyVar" value="${fn:substring(myVar,0,len-1)}"/>
<c:if test="${not empty parentBean }">
	<c:if test="${not empty fetchmap}">
		<c:forEach items="${fetchmap}" var="fitem">
			<c:set var="fmapkey" value="${fitem.key}" />
			<c:set var="fmapvalue" value="${fitem.value}" />
			<script type="text/javascript">
				var fmapkey = '<c:out value="${fmapkey}"/>';
				var fmapvalue = '<c:out value="${fmapvalue}"/>';
				var myVar = '<c:out value="${modmyVar}"/>';
				if (fmapvalue.match("yes") || fmapvalue.match("no")) {
					$('#' + fmapkey).val(fmapvalue);
					$("#ul_" + fmapkey).css("display", "block");
					$("#ul_" + fmapkey).css("visibility", "visible");
				}
				$("#ul_rsstatus_q_" + myVar).css("display", "block");
				$("#ul_rsstatus_q_" + myVar).css("visibility", "visible");
			</script>
		</c:forEach>
	</c:if>
</c:if>

<script type="text/javascript">
var check=function(){
var choice=$('#rsstatus_q').val();
}
</script>
<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
   
                var parentbean='<%=request.getAttribute("parentBean")%>';
       if(parentbean==null){
              $('#rsstatus_q').val('yes');
	      $("#ul_rsstatus_q_yes").css("display","block");
              $("#ul_rsstatus_q_yes").css("visibility","visible");
              $('#rsstatus_q_yes').val('yes');
	      $("#ul_rsstatus_q_yes_yes").css("display","block");
              $("#ul_rsstatus_q_yes_yes").css("visibility","visible");
              $('#rsstatus_q_yes_yes').val('yes');
	      $("#ul_rsstatus_q_yes_yes_yes").css("display","block");
              $("#ul_rsstatus_q_yes_yes_yes").css("visibility","visible");
              }

		$('#frmResidential input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmResidential').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmResidential').submit();
				});
			$('.answer').change(function() {
			  //we should now turn off the one which were selected with previous selection
			  selectedId= $(this).attr('id');
			  idToShow= selectedId +"_"+ $(this).val();
			  for (qid in qs) {
			    qidul = "ul_" + qid ;
			  	if (qid == selectedId || qid == 'rsstatus_q') continue;
			  	if (qid == idToShow) {
			  		 $("#ul_" + idToShow).css("display","block");
			  		 $("#ul_" + idToShow).css("visibility","visible");
			  		 continue;
			  	}
			  	if (qid.indexOf(selectedId) == 0) {
			  		$("#ul_" +qid).css("display","none");
			  		$("#ul_" +qid).css("visibility","hidden");
			  		if ($("#" + qid).length > 0 ) $("#" + qid).get(0).selectedIndex= 0;		  		
			  	}
			  }			
			  var str = "";
			  $("ul option:selected").each(function () {
			            str += $(this).text() + " ";
			  });			  
			});		

		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>