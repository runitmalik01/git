<%@page import="java.util.Iterator"%>
<%@page import="com.mootly.wcm.beans.MemberPersonalInformation"%>
<%@page import="org.hippoecm.hst.content.beans.standard.HippoFolder"%>
<%@include file="../includes/tags.jspf"%>

	<hst:link var="originalViewLink" path="/member/itreturn/financialYear/original/pan/itrformselection.html"/>
	<hst:link var="viewLink" path="/member/itreturn/financialYear/original/pan/itrformselection.html"/>	
<form id="addPanForm" action="">	
	<span class="label1 label-info1">Start a new Return for <c:out value="${financialYear}"/></span>	
	<p>
		<label for="newpan">PAN</label>
		<input id="newpan" style="text-transform:uppercase;" name="newpan" data-content="PAN (10 characters)" maxlength="10">
	</p>
	<p>
		<label for="returnType">Original</label>
		<input value="original" type="radio" checked="checked" id="returnTypeOriginal" name="returnType">
		<label for="returnType">Revised</label>
		<input value="revised"  type="radio" id="returnTypeRevised" name="returnType">				
	</p>
	<a id="hrefAddPan" class="button orange">Start</a>
</form>

<hst:element var="uiCustom" name="script">
    <hst:attribute name="type">text/javascript</hst:attribute>
		$(document).ready(function() {
			$('#newpan').popover({'trigger':'focus'})
			
		    var ay = "<c:out value="${financialYear}"/>";
			$('#addPanForm input').keydown(function(e) {
			    if (e.keyCode == 13) {
			   		e.preventDefault();
					changeAction();
	 				$('#addPanForm').submit();
			    }
			});
			$('#addPanForm').validate({
				rules: {
					newpan: {
					    required: true,
						minlength: 10,
						PAN: true						
					}					
				},				
				messages: {
					pan: "Please enter a valid PAN."
				}
			});
			
			$('#hrefAddPan').click(function() {	
				changeAction();
 				$('#addPanForm').submit();
			});
			
			function changeAction() {
				var lnk = "<c:out value="${originalViewLink}"/>";	
				var pan = $("#newpan").val().toLowerCase();
				var ty = $("#addPanForm input[name='returnType']:checked").val();
				var newLnk = lnk.replace(/pan/g,pan);
				newLnk = newLnk.replace(/financialYear/g,ay);
				newLnk = newLnk.replace(/original/g,ty);
				$('#addPanForm').attr("action",newLnk);
			}
		});    
</hst:element>
<hst:headContribution element="${uiCustom}" category="jsInternal"/>