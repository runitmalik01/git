package com.mootly.wcm.services.ditws.model;

/*
 * <entry key="PAN" value="//pan"></entry>
				<entry key="fatherFullName" value="//ffullname"></entry>
				<entry key="address" value="//address"></entry>
				<entry key="DOB" value="//dob"></entry>
				<entry key="fullName" value="//fullname"></entry>
				<entry key="error" value="//error"></entry>
 */
public class RetrieveRefundResponse extends DITSOAPResponse {
	String result;

	public final String getResult() {
		return result;
	}

	public final void setResult(String result) {
		this.result = result;
	}

}
