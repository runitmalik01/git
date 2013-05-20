<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>

<fieldset>
	<legend>Donation Detail</legend>
	<div class="row-fluid show-grid">
	      <div class="span8">
	      	<div class="rowlabel"><label for="doneeName"><small>Donee Name</small></label></div>
	      	<div class="rowlabel"><input id="doneeName" name="flex_field_string_0" placeholder="Donee Name" type="text" value="${doneeWithPAN.doneeName}"/></div>
	      </div>
	      <div class="span4">
	      	<div class="rowlabel"><label for="doneePAN"><small>Donee PAN</small></label></div>
	      	<div class="rowlabel"><input id="doneePAN" name="flex_field_string_1" placeholder="Donee PAN" type="text" maxlength="10" value="${doneeWithPAN.doneePAN}"/></div>
	      </div>
	</div>
	 <div class="row-fluid show-grid">	   
	   	  <div class="span6">
	   	  	<div class="rowlabel"><label for="pi_flat_door_building"><small>Flat/Door/Building</small></label></div>
	   	  	<div class="rowlabel"><input id="pi_flat_door_building" name="flex_field_string_2" placeholder="Flat/Door/Building" type="text"  value="${doneeWithPAN.doneeFlatFloorBuilding}"/></div>
	   	  </div>
	   	  <div class="span6">
	   	  	<div class="rowlabel"><label for="pi_road_street"><small>Road/Street</small></label></div>
	   	  	<div class="rowlabel"><input id="pi_road_street" name="flex_field_string_3" placeholder="Road/Street" type="text" value="${doneeWithPAN.doneeRoadStreet}" /></div>
	   	  </div>
	  </div>
	  <div class="row-fluid show-grid">	   
          <div class="span4">
          	<div class="rowlabel"><label for="pi_area_locality"><small>Area/Locality</small></label></div>
          	<input id="pi_area_locality" name="flex_field_string_4" placeholder="Area/Locality" type="text" value="${doneeWithPAN.doneeAreaLocality}"/>
          </div>
          <div class="span3">
          	<div class="rowlabel"><label for="pi_town_city_district"><small>City/Town/District</small></label></div>
          	<div class="rowlabel"><input id="flex_field_string_5" name="flex_field_string_5" placeholder="Town/City/District" type="text" value="${doneeWithPAN.doneeCityTownDistrict}"/></div>
          </div>
          <div class="span3">
          	<div class="rowlabel"><label for="pi_state"><small>State</small></label></div>
          	<c:set var="searchresultstitle"><fmt:message key="member.contact_info.state.select"/></c:set>
                  <c:set var="statesType"><fmt:message key="dropdown.states"/></c:set>
                  <div class="rowlabel"><w4india:dropdown dropDownSelectName="flex_field_string_6" dropDownSelectId="pi_state" optionSelectString="${searchresultstitle}" dropDownType="${statesType}" fetchValue="${doneeWithPAN.doneeState}"/></div>
                </div>
          <div class="span2">
            <div class="rowlabel"><label for="pi_pin_code"><small>PIN</small></label></div>
          	<div class="rowlabel"><input id="pi_pin_code" name="flex_field_string_7" placeholder="PIN Code" type="text" maxlength="6" value="${doneeWithPAN.doneePostalCode}"/></div>
          </div>
	 </div>			
</fieldset>