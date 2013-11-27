package com.mootly.wcm.services.ditws.model;

/*
 * <entry key="PAN" value="//pan"></entry>
				<entry key="fatherFullName" value="//ffullname"></entry>
				<entry key="address" value="//address"></entry>
				<entry key="DOB" value="//dob"></entry>
				<entry key="fullName" value="//fullname"></entry>
				<entry key="error" value="//error"></entry>
 */
public class RetrievePANResponse extends DITSOAPResponse {
	String PAN;
	String fatherFullName;
	String address;
	String fullName;
	String DOB;
	String error;
	public final String getPAN() {
		return PAN;
	}
	public final void setPAN(String pAN) {
		PAN = pAN;
	}
	public final String getFatherFullName() {
		return fatherFullName;
	}
	public final void setFatherFullName(String fatherFullName) {
		this.fatherFullName = fatherFullName;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final String getFullName() {
		return fullName;
	}
	public final void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public final String getDOB() {
		return DOB;
	}
	public final void setDOB(String dOB) {
		DOB = dOB;
	}
	public final String getError() {
		return error;
	}
	public final void setError(String error) {
		this.error = error;
	}
	
	
}
