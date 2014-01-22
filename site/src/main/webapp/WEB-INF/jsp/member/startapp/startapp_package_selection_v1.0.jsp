<%@include file="../../includes/tags.jspf"%>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="income_sources_${assessmentYear}" var="incsources"/>
<c:if test="${empty parentBean.sourceIncPackSelectKey && parentBean.sourceIncPackSelect eq false}">
<h5 align="center"><small>Showing a default choices for Income sources for <b><fmt:message key="${parentBean.selectedITRForm}.packageName"/></b> Package.You can change by checking the income source to decide your package.</small></h5>
</c:if>
<div class="row show-grid">
	<div class="col-md-5">
		<div class="rowlabel">
			<label for="flex_string_ITRForm"><small>Income Sources</small></label>
		</div>
	</div>
	<div class="col-md-4">
		<div class="rowlabel">
			<label for="whoCan"><small>Package</small></label>
		</div>
	</div>
	<div class="col-md-2 col-md-offset-1">
		<div class="rowlabel">
			<label for="filingMode"><a class="btn btn-warning btn-sm" id="hlpackageselection">High Level Selection</a></label>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-5">
		<fmt:message bundle="${incsources}" key="total.source.income" var="totalSource" />
		<fmt:parseNumber integerOnly="true" value="${totalSource}" var="end" />
		<c:forEach begin="1" end="${end}" var="indexValue">
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.name" var="name" />
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.value" var="value" />
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.label" var="label" />
			<fmt:message bundle="${incsources}"
				key="income.source.${indexValue}.help" var="help" />
			<div class="checkbox">
				<input type="checkbox" name="${name}" value="${value}" class="packageChoice" id="${name}" /> 
				<label for="${name}"><abbr title="${help}"><c:out value="${label}" escapeXml="false"/></abbr></label>
			</div>
		</c:forEach>
	</div>
	<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
	 <fmt:message key="${itrForm}.packageName" var="packageName"></fmt:message>	
	 <div class="col-md-4 <c:out value="${fn:replace(packageName,'+','plus')}"/> hide">
		<div class="well">
				<c:choose>
					<c:when test="${not empty packageName}">
						<c:if test="${packageName eq 'Deluxe'}">
							<c:set value="text-warning" var="textClass" />
						</c:if>
						<c:if test="${packageName eq 'Platinum'}">
							<c:set value="text-success" var="textClass" />
						</c:if>
						<c:if test="${packageName eq 'Platinum+'}">
							<c:set value="text-info" var="textClass" />
						</c:if>
					</c:when>
					<c:otherwise>
						<c:set value="muted" var="textClass" />
					</c:otherwise>
				</c:choose>
				<h2 class="${textClass}"><c:out value="${packageName}"/></h2>
			<p>
				<span class="label label-info">POPULAR</span>
			</p>
			<fmt:message key="${itrForm}.whoCan" var="whocan"></fmt:message>
			<p>(a)<c:out value="${fn:substringAfter(whocan,'(a)') }" escapeXml="false"/></p>
			<hr>
			<h3>&nbsp;&nbsp;&#8377;&nbsp;<fmt:message key="${itrForm}.packageName.DIY.cost"></fmt:message>/-</h3>
			<hr>
			<p>
				<a class="btn btn-large btn-success" href="#"><i class="glyphicon glyphicon-ok"></i>&nbsp;Selected plan</a>
			</p>
		</div>
	</div>
	</c:forEach>
	<%-- <c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">	
	<div class="col-xs-12 col-md-3 hide">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><fmt:message key="${itrForm}.packageName"></fmt:message></h3>
			</div>
			<div class="panel-body">
				<div class="the-price">
					<h1>
						&#8377;<fmt:message key="${itrForm}.packageName.DIY.cost"></fmt:message>
					</h1>
				</div>
				<fmt:message key="${itrForm}.whoCan" var="whocan"></fmt:message>
				<p><c:out value="${fn:substringAfter(whocan,'(a)') }" escapeXml="false"/></p>
			</div>
			<div class="panel-footer">
				<a href="#" class="btn btn-success"
					role="button">Selected Package</a>
			</div>
		</div>
	</div>
	</c:forEach> --%>
	<!-- Package Selection variables   -->
	<input type="hidden" name="sourceIncPackSelectKey" id="sourceIncPackSelectKey" value="${parentBean.sourceIncPackSelectKey}"/>
	<input type="hidden" name="sourceIncPackSelect" id="sourceIncPackSelect" value="${parentBean.sourceIncPackSelect}"/>
</div>
<script type="text/javascript">
 $(document).ready(function(){
	 var incomeMap = <c:out value="${jsonObjectIncomeSource}" escapeXml="false"/>; 
	 <c:if test="${not empty parentBean}">
	   <c:if test="${not empty parentBean.sourceIncPackSelectKey && parentBean.sourceIncPackSelect}">
	     var savedPackageKey = '<c:out value="${parentBean.sourceIncPackSelectKey}"/>';
	     if(savedPackageKey != '') {
	    	 var incomeSourcesArray = [];
	    	 incomeSourcesArray = savedPackageKey.split('.');
	    	 for(var i=0; i<incomeSourcesArray.length;i++) {
	    		 $('.packageChoice').each( function(index,value) {
		   	          if(value.name == incomeSourcesArray[i]){
		   	        	  $('#'+value.name).attr('checked','checked');
		   	          }
		        });
	    	 }
	    	 packageDecideRules(savedPackageKey);
	     }
	   </c:if>
	 </c:if>
	 //Use this if we want to show default selection to assess if he decide package without selection of sources of income.
	 <c:if test="${not empty parentBean}">
	   <c:if test="${empty parentBean.sourceIncPackSelectKey && parentBean.sourceIncPackSelect eq false}">
	     <fmt:message key="${parentBean.selectedITRForm}.packageName" var="savepackage"/>
	     var genPackageKey = '<fmt:message bundle="${incsources}" key="${savepackage}"/>';
	     if(typeof genPackageKey == "undefined") {
	    	 genPackageKey = '';
		 }
	     if(genPackageKey != ''){
	    	 var incomeSourcesArray = [];
	    	 incomeSourcesArray = genPackageKey.split('.');
	    	 for(var i=0; i<incomeSourcesArray.length;i++) {
	    		 $('.packageChoice').each( function(index,value) {
		   	          if(value.name == incomeSourcesArray[i]){
		   	        	  $('#'+value.name).attr('checked','checked');
		   	          }
		        });
	    	 }
	    	 packageDecideRules(genPackageKey);
	     }
	   </c:if>
	 </c:if>
	 $('.packageChoice').change(function() {
		 var packageName = '';var packageKey = ''; 
		 $('.packageChoice').each( function(index,value) {
	          if(value.checked){
	        	  packageKey = packageKey + value.name + '.'; 	        	  
	          }
         });
		 packageName = incomeMap[packageKey.substring(0,packageKey.length-1)] ;
		 if(typeof packageName == "undefined") {
			 packageName = '';
		 }		
		 packageDecideRules(packageKey);
		 /* if(packageName != '') {
			 $('.'+packageName.replace('+','plus')).show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == packageName); });			 
		 }/* else {
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
		 } */		 
	 });
	 function packageDecideRules(packageKey){
		 $('.Basic').hide();
		 $('.Platinumplus').hide();
		 $('.Deluxe').hide();
		 $('.Premier').hide();
		 $('.Platinum').hide();
		//Simple Rule If packageKey contain "propBusinessIncome" then definetly It will be Platinum i.e. ITR4
		 if(packageKey.indexOf('propBusinessIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Platinumplus').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Platinum'); }); 
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('partnerFirmIncome') != -1 || packageKey.indexOf('moreExemptIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Premier').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Premier'); });
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('moreHouseProperty') != -1 || packageKey.indexOf('capitalGain') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Deluxe').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Deluxe'); });
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('presumBusinessIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Platinum').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Platinum+'); });
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('salaryIncome') != -1 || packageKey.indexOf('otherSourceExLottHorse') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.length == 0) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.Basic').show();
			 $("select#flex_string_ITRForm option")
			   .each(function() { this.selected = (this.text == 'Basic'); });
			 handleChangeOfItrPackageSelection();
		 } 
	 }
	 function handleChangeOfItrPackageSelection(){
		 var packageName = $('#flex_string_ITRForm').val();
		    if((packageName == 'ITR2' || (packageName == 'ITR4') || (packageName == 'ITR3'))) {
		         $('#represenative_detail').show();
		    } else{
		         $('#represenative_detail').hide();
		    }
			if(packageName == 'ITR4') {
			     $('#fieldsfor_ITR4').show();
			} else{
			    $('#fieldsfor_ITR4').hide();
			}
			// This code is for ITR4S
			if(packageName == 'ITR4S') {
			    $('#trpdetails').show();
			} else {
				$('#trpdetails').hide();
			}
	 }
 });
</script>
<hst:link var="packageprice" path="/css/package_price.css"/>
<link rel="stylesheet" media="screen" type="text/css" href="${packageprice}"/>