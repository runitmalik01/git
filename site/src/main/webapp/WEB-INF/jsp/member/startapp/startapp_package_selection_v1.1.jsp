<%@include file="../../includes/tags.jspf"%>
<%@page import="com.mootly.wcm.model.ITRServiceDelivery"%>

<fmt:setLocale value="en"/>
<fmt:setBundle basename="income_heads_${financialYear.displayName}" var="incsources"/>

<div class="row show-grid">
   <div class="col-md-5">
      <div class="rowlabel">
          <label for="flex_string_ITRForm"><small>Income Sources</small></label>
      </div>
   </div>
   <div class="col-md-5">
	   <div class="rowlabel"><label for="whoCan"><small>Who can select this package</small></label></div>
   </div>
</div>
   
<div class="row">
    <div class="rowlabel">
      <div class="col-md-5">
        <fmt:message bundle="${incsources}" key="total.source.income" var="totalSource" />
		<fmt:parseNumber integerOnly="true" value="${totalSource}" var="end" />
		<c:forEach begin="1" end="${end}" var="indexValue">
		   <fmt:message bundle="${incsources}" key="income.source.${indexValue}.name" var="name" />
		   <fmt:message bundle="${incsources}" key="income.source.${indexValue}.value" var="value" />
	       <fmt:message bundle="${incsources}" key="income.source.${indexValue}.label" var="label" />
		   <fmt:message bundle="${incsources}" key="income.source.${indexValue}.help" var="help" />
		   <div class="checkbox">
				<input type="checkbox" name="${name}" value="${value}" class="packageChoice" id="${name}" /> 
				<label for="${name}"><abbr title="${help}"><c:out value="${label}" escapeXml="false"/></abbr></label>
		   </div>
		</c:forEach>
	</div>
   </div>
<c:forEach items="${filingStatus.possibleITRForms}" var="itrForm">
    <div class="rowlabel">
        <div class="col-md-6 <c:out value="${itrForm}"/> hide">
              <!-- <h1 class="${textClass}"><c:out value="${itrForm}"/></h1> -->
              Form - ${itrForm}<small><fmt:message key="${itrForm}.whoCan" var="whocan"></fmt:message></small>
              <p><small>(a)<c:out value="${fn:substringAfter(whocan,'(a)') }" escapeXml="false"/></small></p>
          </div>
   </div>
</c:forEach>
</div>
    
<div class="row col-md-12">
   <c:if test="${not empty servicesMap}">
     <c:forEach items="${servicesMap}" var="serviceMapKey">
     <c:set value="${serviceMapKey.key}" var="ITRForm"/>
       <div class="<c:out value="${ITRForm}"/> hide">
         <c:forEach items="${serviceMapKey.value}" var="keyValue">
           <c:choose>
	          <c:when test="${not empty keyValue}">
			    <c:if test="${keyValue.offeringMode eq 'DIY'}">
				  <c:set value="#5bc0de" var="panelClass" />
			    </c:if>
			    <c:if test="${keyValue.offeringMode eq 'SemiAssisted'}">
				  <c:set value="#f0ad4e" var="panelClass" />
			    </c:if>
			    <c:if test="${keyValue.offeringMode eq 'Assisted'}">
				  <c:set value="#d9534f" var="panelClass" />
			    </c:if>
		     </c:when>
		     <c:otherwise>
			   <c:set value="#5cb85c" var="panelClass" />
		     </c:otherwise>
	      </c:choose>
          <div class="col-md-4 col-md-offset-1 productbox">
            <div class="productheader" style="background-color: ${panelClass};">
               <% Boolean hasAValidMatch = false; %>
               <c:if test="${not empty mapForCostModelName}">
                 <c:forEach items="${mapForCostModelName}" var="resultMap">
                   <c:if test = "${keyValue.offeringMode eq resultMap.key}">
                     <h4 style="text-align: center;color: white; font-weight: bold; "><c:out value="${resultMap.value}"/>&nbsp;<a href="" data-toggle="modal" data-target="#${keyValue.offeringMode}"><span style="color: black;" class="glyphicon glyphicon-question-sign"></span></a></h4>
                     <% hasAValidMatch = true;%>
                   </c:if>
                 </c:forEach>
               </c:if>
               <% if(!hasAValidMatch){ %>
                   <h4 style="text-align: center;color: white; font-weight: bold; "><c:out value="${keyValue.offeringMode}"/>&nbsp;<span style="color: black;" class="glyphicon glyphicon-question-sign"></span></h4>
               <%} %>
               <c:if test="${not empty keyValue.costDetail}">
               <div class="modal fade" id="${keyValue.offeringMode}">
                 <div class="modal-dialog">
                   <div class="modal-content">
                     <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                       <h4 class="modal-title">Getting help is easy</h4>
                     </div>
                     <div class="modal-body">
                       <c:out value="${keyValue.costDetail}"/>
                     </div>
                  </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
              </div><!-- /.modal --> 
              </c:if>
             </div>
             <div class="producttitle">         
                  <i class="glyphicon glyphicon-ok"></i>&nbsp;<c:out value="${keyValue.costHighlight}"/>            
             </div>
             <div class="productprice">
               <div class="pull-right">
                 <input type="radio" value="${keyValue.offeringMode}" id="${ITRForm}${keyValue.offeringMode}" name="offeringMode" class="offeringMode">
                 <span class="label label-danger">Select</span>
               </div>
               <div class="pricetext">
                  <small><i class="glyphicon glyphicon-rupee">&#8377;</i></small>&nbsp;<strong><c:out value="${keyValue.cost}"/></strong>
               </div>
             </div>
         </div>
      </c:forEach>
     </div>
    </c:forEach>
  </c:if>
</div>

    <input type="hidden" name="sourceIncPackSelectKey" id="sourceIncPackSelectKey" value="${parentBean.sourceIncPackSelectKey}"/>
	<input type="hidden" name="sourceIncPackSelect" id="sourceIncPackSelect" value="${parentBean.sourceIncPackSelect}"/>
	<input type="hidden" name="flex_string_ITRForm" id="flex_string_ITRForm" value="${parentBean.selectedITRForm}"/>
	<input type="hidden" name="flex_string_ITRServiceDelivery" id="flex_string_ITRServiceDelivery" value="${parentBean.selectedServiceDeliveryOption}"/>
	
   
<script type="text/javascript">
   
 $(document).ready(function(){
	 	
	 //Use this to set the value of Offering Mode (DIY, Assisted, SemiAssisted) in flex_string_ITRServiceDelivery.
	  	$('.offeringMode').change(function(){
   	  	 var offeringModeValue = $('.offeringMode').val();
   	  	 $('.offeringMode').each( function(index,value) {
			          if(value.checked){
			        	  offeringModeValue = value.value;
			          } 	
		     });
   	  	 $("#flex_string_ITRServiceDelivery").val(offeringModeValue);
	  	});
	 
	 // Check if Parent bean is null then put a default condition.
	 <c:if test="${empty parentBean}">
	     defaultCondition();
	 </c:if>
	 
	 // If parent bean is not null fetch all values.
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
	 
	 // Used to get selected package (Quick File, Super, Super-Duper)
	 var savedServiceDelivery = '';
	 <c:if test="${not empty parentBean}">
	   <c:if test="${not empty parentBean.selectedServiceDeliveryOption && not empty parentBean.selectedITRForm}">
	     savedServiceDelivery = '<c:out value="${parentBean.selectedServiceDeliveryOption}"/>';
	     var savedITRForm = '<c:out value="${parentBean.selectedITRForm}"/>';
	     var combinedKey = savedITRForm+savedServiceDelivery;
	     if(combinedKey != '') {
	    	 $("#"+combinedKey).prop('checked',true);
	     }
	   </c:if>
	 </c:if>
	 
	 $('.packageChoice').change(function() {
		 var packageKey = ''; 
		 $('.packageChoice').each( function(index,value) {
	          if(value.checked){
	        	  packageKey = packageKey + value.name + '.'; 	        	  
	          }
         });
		 if(typeof packageName == "undefined") {
			 packageName = '';
		 }		
		 packageDecideRules(packageKey);	 
	 });
	 
	 // Ruels to decide ITR Form.
	 function packageDecideRules(packageKey){
		 $('.ITR1').hide();
		 $('.ITR4S').hide();
		 $('.ITR2').hide();
		 $('.ITR3').hide();
		 $('.ITR4').hide();
		//Simple Rule If packageKey contain "propBusinessIncome" then definetly It will be Platinum i.e. ITR4
		 if(packageKey.indexOf('propBusinessIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.ITR4').show();
			 $("#flex_string_ITRForm").val('ITR4');
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('partnerFirmIncome') != -1 || packageKey.indexOf('moreExemptIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.ITR3').show();
			 $("#flex_string_ITRForm").val('ITR3');
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('moreHouseProperty') != -1 || packageKey.indexOf('capitalGain') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.ITR2').show();
			 $("#flex_string_ITRForm").val('ITR2');
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('presumBusinessIncome') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.ITR4S').show();
			 $("#flex_string_ITRForm").val('ITR4S');
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.indexOf('salaryIncome') != -1 || packageKey.indexOf('otherSourceExLottHorse') != -1) {
			 $('#sourceIncPackSelectKey').val(packageKey);
			 $('#sourceIncPackSelect').val('true');
			 $('.ITR1').show();
			 $("#flex_string_ITRForm").val('ITR1');
			 handleChangeOfItrPackageSelection();
		 } else if(packageKey.length == 0) {
			 alert("You must have atleast one source of income");
			 defaultCondition();
		 } 
	 }
	 
	 function defaultCondition(){
		 $('#salaryIncome').prop('checked',true);
		 $('#sourceIncPackSelectKey').val('salaryIncome');
		 $('#sourceIncPackSelect').val('true');
		 $("#ITR1DIY").prop('checked',true);
		 $('.ITR1').show();
		 $("#flex_string_ITRForm").val('ITR1');
		 $("#flex_string_ITRServiceDelivery").val('DIY');
		 handleChangeOfItrPackageSelection();
	 }
       
	 function handleChangeOfItrPackageSelection(){
		 var packageName = $('#flex_string_ITRForm').val();
		 
		 if(savedServiceDelivery != ''){
			 var radioID = packageName+savedServiceDelivery;
			 $("#"+radioID).prop('checked',true);
		 }else{
			 $("#"+packageName+"DIY").prop('checked',true);
		 }
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
