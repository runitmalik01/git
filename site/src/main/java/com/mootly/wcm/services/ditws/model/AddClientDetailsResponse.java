package com.mootly.wcm.services.ditws.model;

/*
 * <entry key="PAN" value="//pan"></entry>
				<entry key="fatherFullName" value="//ffullname"></entry>
				<entry key="address" value="//address"></entry>
				<entry key="DOB" value="//dob"></entry>
				<entry key="fullName" value="//fullname"></entry>
				<entry key="error" value="//error"></entry>
 */
public class AddClientDetailsResponse {
	String error;
	public final String getError() {
		return error;
	}
	public final void setError(String error) {
		this.error = error;
	}
		
}
