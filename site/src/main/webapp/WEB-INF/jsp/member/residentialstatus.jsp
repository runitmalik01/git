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
<%--@elvariable id="document" type="com.mootly.wcm.beans.Product"--%>
<%@include file="../includes/tags.jspf"%>
<c:set var="residentialstatus">
	<fmt:message key="member.residential.status" />
</c:set>
<hippo-gogreen:title title="${residentialstatus}"></hippo-gogreen:title>
<%
	
%>
<script>
	var qs = <c:out value="${jsonObject}" escapeXml="false"/>
</script>
<hst:actionURL var="actionUrl"></hst:actionURL>
<form name="frmResidential" method="post" action="${actionUrl }">
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
		<c:forEach items="${map}" var="item">
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
						<li style="display:inline"><c:out value="${item.value}"/><c:if test="${isAnswer eq true}"><input type="hidden" name="${item.key}" value="${item.value}"/></c:if></li>
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
<c:if test="${isAnswer eq true}"><a  id="hrefLogin" class="button orange">Save &amp; Next</a><a href="${modifiedSiteMapRefId}" class="button orange" style="margin-left:100px;">Next</a></c:if>
</form>
<script type="text/javascript"> 
$('#submit').click(function(){
	var vselect=document.getElementsByTagName('select');
	for(var i=0; i < vselect.length ;i++){
		var check=vselect.item(i).attr('style');
	}
});
</script>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
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
			$('#frmResidential input').keydown(function(e) {
				    if (e.keyCode == 13) {
				   		e.preventDefault();
				        $('#frmResidential').submit();
				    }
				});
				
				$('#hrefLogin').click(function() {
		 			$('#frmResidential').submit();
				});
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>