<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@include file="../includes/tags.jspf" %>

<fieldset>
	<legend>Donation Detail</legend>
	<div class="row-fluid show-grid">
	      <div class="span8">
	      	<div class="rowlabel"><label for="flex_string_doneeName"><small>Donee Name</small></label></div>
	      	<div class="rowlabel"><input id="flex_string_doneeName" name="flex_string_doneeName" placeholder="Donee Name" type="text" value="${doneeWithPAN.doneeName}"/></div>
	      </div>
	      <div class="span4">
	      	<div class="rowlabel"><label for="flex_string_doneePAN"><small>Donee PAN</small></label></div>
	      	<div class="rowlabel"><input id="flex_string_doneePAN" name="flex_string_doneePAN" placeholder="Donee PAN" type="text" maxlength="10" value="${doneeWithPAN.doneePAN}"/></div>
	      </div>
	</div>
	 <div class="row-fluid show-grid">
	   	  <div class="span6">
	   	  	<div class="rowlabel"><label for="flex_string_doneeFlatFloorBuilding"><small>Flat/Door/Building</small></label></div>
	   	  	<div class="rowlabel"><input id="flex_string_doneeFlatFloorBuilding" name="flex_string_doneeFlatFloorBuilding" placeholder="Flat/Door/Building" type="text"  value="${doneeWithPAN.doneeFlatFloorBuilding}"/></div>
	   	  </div>
	   	  <div class="span6">
	   	  	<div class="rowlabel"><label for="flex_string_doneeRoadStreet"><small>Road/Street</small></label></div>
	   	  	<div class="rowlabel"><input id="flex_string_doneeRoadStreet" name="flex_string_doneeRoadStreet" placeholder="Road/Street" type="text" value="${doneeWithPAN.doneeRoadStreet}" /></div>
	   	  </div>
	  </div>
	  <div class="row-fluid show-grid">
          <div class="span4">
          	<div class="rowlabel"><label for="flex_string_doneeAreaLocality"><small>Area/Locality</small></label></div>
          	<input id="flex_string_doneeAreaLocality" name="flex_string_doneeAreaLocality" placeholder="Area/Locality" type="text" value="${doneeWithPAN.doneeAreaLocality}"/>
          </div>
          <div class="span3">
          	<div class="rowlabel"><label for="flex_string_doneeCityTownDistrict"><small>City/Town/District</small></label></div>
          	<div class="rowlabel"><input id="flex_string_doneeCityTownDistrict" name="flex_string_doneeCityTownDistrict" placeholder="Town/City/District" type="text" value="${doneeWithPAN.doneeCityTownDistrict}"/></div>
          </div>
          <div class="span3">
          	<div class="rowlabel"><label for="flex_string_doneeState"><small>State</small></label></div>
          	<c:set var="searchresultstitle"><fmt:message key="member.contact_info.state.select"/></c:set>
                  <c:set var="statesType"><fmt:message key="dropdown.states"/></c:set>
                  <div class="rowlabel"><w4india:dropdown dropDownSelectName="flex_string_doneeState" dropDownSelectId="flex_string_doneeState" optionSelectString="${searchresultstitle}" dropDownType="${statesType}" fetchValue="${doneeWithPAN.doneeState}"/></div>
                </div>
          <div class="span2">
            <div class="rowlabel"><label for="flex_string_doneePostalCode"><small>PIN</small></label></div>
          	<div class="rowlabel"><input id="flex_string_doneePostalCode" name="flex_string_doneePostalCode" placeholder="PIN Code" type="text" maxlength="6" value="${doneeWithPAN.doneePostalCode}"/></div>
          </div>
	 </div>
</fieldset>