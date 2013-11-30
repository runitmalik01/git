package com.mootly.wcm.services.ditws.model;

/*
 * <entry key="PAN" value="//pan"></entry>
				<entry key="fatherFullName" value="//ffullname"></entry>
				<entry key="address" value="//address"></entry>
				<entry key="DOB" value="//dob"></entry>
				<entry key="fullName" value="//fullname"></entry>
				<entry key="error" value="//error"></entry>
 */
public class RetrieveRectificationResponse extends DITSOAPResponse {

	String panNo;
	String asseessmentYear;
	String itrName;
	String rectification;
	String cpcOrder;
	String details;
	String status;
	
	public final String getPanNo() {
		return panNo;
	}
	public final String getAsseessmentYear() {
		return asseessmentYear;
	}
	public final String getItrName() {
		return itrName;
	}
	public final String getRectification() {
		return rectification;
	}
	public final String getCpcOrder() {
		return cpcOrder;
	}
	public final String getDetails() {
		return details;
	}
	public final String getStatus() {
		return status;
	}
	
	public final void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public final void setAsseessmentYear(String asseessmentYear) {
		this.asseessmentYear = asseessmentYear;
	}
	public final void setItrName(String itrName) {
		this.itrName = itrName;
	}
	public final void setRectification(String rectification) {
		this.rectification = rectification;
	}
	public final void setCpcOrder(String cpcOrder) {
		this.cpcOrder = cpcOrder;
	}
	public final void setDetails(String details) {
		this.details = details;
	}
	public final void setStatus(String status) {
		this.status = status;
	}

}
