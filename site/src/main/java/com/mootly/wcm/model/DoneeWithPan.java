package com.mootly.wcm.model;

import org.hippoecm.hst.component.support.forms.FormMap;

import com.mootly.wcm.beans.compound.DeductionDocumentDetail;

/**
 * Structure for Donee , lets add another structure for ScheduleG
 * @author admin
 *
 */
public class DoneeWithPan {
	String doneeName;
	String doneePAN;
	String doneeFlatFloorBuilding;
	String doneeRoadStreet;
	String doneeAreaLocality;
	String doneeCityTownDistrict;
	String doneeState;
	String doneePostalCode;
	public String getDoneeName() {
		return doneeName;
	}
	public void setDoneeName(String doneeName) {
		this.doneeName = doneeName;
	}
	public String getDoneePAN() {
		return doneePAN;
	}
	public void setDoneePAN(String doneePAN) {
		this.doneePAN = doneePAN;
	}
	public String getDoneeFlatFloorBuilding() {
		return doneeFlatFloorBuilding;
	}
	public void setDoneeFlatFloorBuilding(String doneeFlatFloorBuilding) {
		this.doneeFlatFloorBuilding = doneeFlatFloorBuilding;
	}
	public String getDoneeRoadStreet() {
		return doneeRoadStreet;
	}
	public void setDoneeRoadStreet(String doneeRoadStreet) {
		this.doneeRoadStreet = doneeRoadStreet;
	}
	public String getDoneeAreaLocality() {
		return doneeAreaLocality;
	}
	public void setDoneeAreaLocality(String doneeAreaLocality) {
		this.doneeAreaLocality = doneeAreaLocality;
	}
	public String getDoneeCityTownDistrict() {
		return doneeCityTownDistrict;
	}
	public void setDoneeCityTownDistrict(String doneeCityTownDistrict) {
		this.doneeCityTownDistrict = doneeCityTownDistrict;
	}
	public String getDoneeState() {
		return doneeState;
	}
	public void setDoneeState(String doneeState) {
		this.doneeState = doneeState;
	}
	public String getDoneePostalCode() {
		return doneePostalCode;
	}
	public void setDoneePostalCode(String doneePostalCode) {
		this.doneePostalCode = doneePostalCode;
	}
	/**
	 * Use this method to create an instance from the bean
	 * @param deductionDocumentDetail
	 * @return
	 */
	public static DoneeWithPan getInstanceFromChildBean(DeductionDocumentDetail deductionDocumentDetail) {
		if (deductionDocumentDetail == null) return null;
		
		DoneeWithPan dp = new DoneeWithPan();
		String doneeName = deductionDocumentDetail.getFlexField(0, new String[]{""});
		String doneePAN = deductionDocumentDetail.getFlexField(1, new String[]{""});
		String doneeFlatFloorBuilding = deductionDocumentDetail.getFlexField(2, new String[]{""});
		String doneeRoadStreet = deductionDocumentDetail.getFlexField(3, new String[]{""});
		String doneeAreaLocality = deductionDocumentDetail.getFlexField(4, new String[]{""});
		String doneeCityTownDistrict = deductionDocumentDetail.getFlexField(5, new String[]{""});
		String doneeState = deductionDocumentDetail.getFlexField(6, new String[]{""});
		String doneePostalCode = deductionDocumentDetail.getFlexField(7, new String[]{""});
		
		dp.setDoneeName(doneeName);
		dp.setDoneePAN(doneePAN);
		dp.setDoneeFlatFloorBuilding(doneeFlatFloorBuilding);
		dp.setDoneeRoadStreet(doneeRoadStreet);
		dp.setDoneeAreaLocality(doneeAreaLocality);
		dp.setDoneeCityTownDistrict(doneeCityTownDistrict);
		dp.setDoneeState(doneeState);
		dp.setDoneePostalCode(doneePostalCode);
		
		return dp;
	}
	/**
	 * Use this to create an instance from the form map
	 * @param deductionDocumentDetail
	 * @return
	 */
	public static DoneeWithPan getInstanceFromFormMap(FormMap formMap) {
		if (formMap == null) return null;
		
		DoneeWithPan dp = new DoneeWithPan();
		if (formMap.getField("flex_field_string_0") != null) dp.setDoneeName(formMap.getField("flex_field_string_0").getValue());
		if (formMap.getField("flex_field_string_1") != null) dp.setDoneePAN(formMap.getField("flex_field_string_1").getValue());
		if (formMap.getField("flex_field_string_2") != null) dp.setDoneeFlatFloorBuilding(formMap.getField("flex_field_string_2").getValue());
		if (formMap.getField("flex_field_string_3") != null) dp.setDoneeAreaLocality(formMap.getField("flex_field_string_3").getValue());
		if (formMap.getField("flex_field_string_4") != null) dp.setDoneeRoadStreet(formMap.getField("flex_field_string_4").getValue());
		if (formMap.getField("flex_field_string_5") != null) dp.setDoneeCityTownDistrict(formMap.getField("flex_field_string_5").getValue());
		if (formMap.getField("flex_field_string_6") != null) dp.setDoneeState(formMap.getField("flex_field_string_6").getValue());
		if (formMap.getField("flex_field_string_7") != null) dp.setDoneePostalCode(formMap.getField("flex_field_string_7").getValue());
		
		return dp;
	}
	
}
