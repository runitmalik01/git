
<%--
@author Dhananjay Panwar
13/03/2013
 --%>

 
<%@include file="../includes/commonincludes.jspf"%>

<hst:link var ="mainSiteMapRefId" siteMapItemRefId="${mainSiteMapItemRefId}"/>
<!-- used to set title  -->

<c:set var="interesttitle">
      <fmt:message key="member.interest.title" />
</c:set>
<hippo-gogreen:title title="${interesttitle}" />
<hst:actionURL var="actionUrl"></hst:actionURL>
<div class="breadcrumb-list" xmlns:v="http://rdf.data-vocabulary.org/#">
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">Home</a></span> 
	<span class="chevron">&#187;</span> 
	<span typeof="v:Breadcrumb"><a rel="v:url" property="v:title" href="">My Income Tax Returns</a></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><c:out value="${pan}"/></span>
	<span class="chevron">&#187;</span> 
	<span class="breadcrumb-current"><select style="width:120px"><option>Interest</option><option>a</option><option>a</option></select></span>
</div>

<div class="page type-page">
	<h3 id="respond1">ADD:INTEREST</h3>
		<form id="frmdata" action="${actionUrl}" name="frmdata" method="post">
			<fieldset>
				<legend>Interest</legend>
				<p>
					<label for="Section234a"><fmt:message key="interest.section234A.required" /></label>
					<input readonly="readonly" type="text" name="section234A" value="${section234a}" maxlength="14" class="input_data" />
				</p>
				<p>
					<label for="Section234b"><fmt:message key="interest.section234B.required" /></label>
					<input readonly="readonly" type="text" name="section234B" value="${section234b}" maxlength="14" class="input_data" />
				</p>
				<p>
					<label for="Section234c"><fmt:message key="interest.section234C.required" /></label>
					<input readonly="readonly" type="text" name="section234C" value="${section234c}" maxlength="14" class="input_data" />
				</p>					
			</fieldset>		
		</form>
		<input type="submit" id="submit" class="button olive" onclick="save()" value="Next"/>
</div>
<script>
function save(){
	$("#frmdata").submit();
}
</script>