package com.mootly.wcm.services.ditws.model;

/*
 * <entry key="TAN" value="//tan"></entry>
   <entry key="categoryOfDeductor" value="//categoryOfDeductor"></entry>
   <entry key="fullName" value="//fullname"></entry>
   <entry key="address" value="//address"></entry>
   <entry key="PAN" value="//pan"></entry>
   <entry key="status" value="//status"></entry>
   
   <entry key="emailId1" value="//emailId1"></entry>
   <entry key="emailId2" value="//emailId2"></entry>
   <entry key="areaCode" value="//areaCode"></entry>
   <entry key="AOType" value="//AOType"></entry>
   <entry key="rangeCode" value="//rangeCode"></entry>
   <entry key="AONumber" value="//AONumber"></entry>
   <entry key="error" value="//error"></entry>
 */
public class RetrieveTANResponse extends DITSOAPResponse{
	String tan;
	String categoryOfDeductor;
	String fullname;
	String address;
	String pan;
	String status;
	
	String emailId1;
	String emailId2;
	String areaCode;
	String AOType;
	String rangeCode;
	String AONumber;
	
	
	
	public final String getCategoryOfDeductor() {
		return categoryOfDeductor;
	}
	
	public final String getFullname() {
		return fullname;
	}
	
	public final String getAddress() {
		return address;
	}
	
	
	public final String getTan() {
		return tan;
	}

	public final void setTan(String tan) {
		this.tan = tan;
	}

	public final String getPan() {
		return pan;
	}

	public final void setPan(String pan) {
		this.pan = pan;
	}

	public final String getStatus() {
		return status;
	}
	
	public final String getEmailId1() {
		return emailId1;
	}
	
	public final String getEmailId2() {
		return emailId2;
	}
	
	public final String getAreaCode() {
		return areaCode;
	}
	
	public final String getAOType() {
		return AOType;
	}
	
	public final String getRangeCode() {
		return rangeCode;
	}
	
	public final String getAONumber() {
		return AONumber;
	}
	
	
	
	public final void setCategoryOfDeductor(String categoryOfDeductor) {
		this.categoryOfDeductor = categoryOfDeductor;
	}
	
	public final void setFullname(String fullName) {
		this.fullname = fullName;
	}
	
	public final void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public final void setStatus(String status) {
		this.status = status;
	}
	
	public final void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	
	public final void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}
	
	public final void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public final void setAOType(String aOType) {
		AOType = aOType;
	}
	
	public final void setRangeCode(String rangeCode) {
		this.rangeCode = rangeCode;
	}
	
	public final void setAONumber(String aONumber) {
		AONumber = aONumber;
	}
}
