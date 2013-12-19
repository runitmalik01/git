<%@page import="java.util.ArrayList"%>
<%@page import="java.util.SortedSet"%>
<%@page import="com.mootly.wcm.utils.ValueListServiceImpl"%>
<%@page import="com.mootly.wcm.utils.ValueListService"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>
<%
ValueListService objValueListService = ValueListServiceImpl.getInstance();
SortedSet<Map.Entry<String,String>> objHashMapstates = objValueListService.getStates();
request.setAttribute("objHashMapstates", objHashMapstates);
%>
<fieldset>
	<legend>Donation Detail</legend>
	<div class="row show-grid">
	      <div class="col-md-8">
	      	<div class="rowlabel"><label for="flex_string_doneeName"><small>Donee Name</small></label></div>
	      	<div class="rowlabel"><input id="flex_string_doneeName" class="uprcase" name="flex_string_doneeName" placeholder="Donee Name" type="text" value="${doneeWithPAN.doneeName}"/></div>
	      </div>
	      <div class="col-md-4">
	      	<div class="rowlabel"><label for="flex_string_doneePAN"><small>Donee PAN</small></label></div>
	      	<div class="rowlabel"><input id="flex_string_doneePAN" class="uprcase" name="flex_string_doneePAN" placeholder="Donee PAN" type="text" maxlength="10" value="${doneeWithPAN.doneePAN}"/></div>
	      </div>
	</div>
	 <div class="row show-grid">
	   	  <div class="col-md-6">
	   	  	<div class="rowlabel"><label for="flex_string_doneeFlatFloorBuilding"><small>Flat/Door/Building</small></label></div>
	   	  	<div class="rowlabel"><input id="flex_string_doneeFlatFloorBuilding" class="uprcase" name="flex_string_doneeFlatFloorBuilding" placeholder="Flat/Door/Building" type="text"  value="${doneeWithPAN.doneeFlatFloorBuilding}"/></div>
	   	  </div>
	   	  <div class="col-md-6">
	   	  	<div class="rowlabel"><label for="flex_string_doneeRoadStreet"><small>Road/Street</small></label></div>
	   	  	<div class="rowlabel"><input id="flex_string_doneeRoadStreet" class="uprcase" name="flex_string_doneeRoadStreet" placeholder="Road/Street" type="text" value="${doneeWithPAN.doneeRoadStreet}" /></div>
	   	  </div>
	  </div>
	  <div class="row show-grid">
          <div class="col-md-4">
          	<div class="rowlabel"><label for="flex_string_doneeAreaLocality"><small>Area/Locality</small></label></div>
          	<input id="flex_string_doneeAreaLocality" class="uprcase" name="flex_string_doneeAreaLocality" placeholder="Area/Locality" type="text" value="${doneeWithPAN.doneeAreaLocality}"/>
          </div>
          <div class="col-md-3">
          	<div class="rowlabel"><label for="flex_string_doneeCityTownDistrict"><small>City/Town/District</small></label></div>
          	<div class="rowlabel"><input id="flex_string_doneeCityTownDistrict" class="uprcase" name="flex_string_doneeCityTownDistrict" placeholder="Town/City/District" type="text" value="${doneeWithPAN.doneeCityTownDistrict}"/></div>
          </div>
          <div class="col-md-3">
          	<div class="rowlabel"><label for="flex_string_doneeState"><small>State</small></label></div>
                  <div class="rowlabel">
                  	<select id="flex_string_doneeState" name="flex_string_doneeState" class="uprcase">
						<option value="">-Select-</option>
						<c:forEach var="booleanCombo" items="${objHashMapstates}">
							<option
								<c:if test="${pageAction == 'EDIT_CHILD' || doneeWithPAN.doneeState == booleanCombo.key}">selected</c:if>
								value="${booleanCombo.key}">${booleanCombo.value}</option>
						</c:forEach>
					</select>
                  </div>
                </div>
          <div class="col-md-2">
            <div class="rowlabel"><label for="flex_string_doneePostalCode"><small>PIN</small></label></div>
          	<div class="rowlabel"><input id="flex_string_doneePostalCode" name="flex_string_doneePostalCode" placeholder="PIN Code" type="text" maxlength="6" value="${doneeWithPAN.doneePostalCode}"/></div>
          </div>
	 </div>
</fieldset>
<script>
$('#flex_string_doneeState').change(function(){
	if($('#flex_string_doneeState').val()=='99'){
	      $('#flex_string_doneePostalCode').val('999999');
	      $('#flex_string_doneePostalCode').attr('readonly','readonly');
	   }else{
             $('#flex_string_doneePostalCode').val('');
             $('#flex_string_doneePostalCode').removeAttr('readonly');
            }
	});
</script>