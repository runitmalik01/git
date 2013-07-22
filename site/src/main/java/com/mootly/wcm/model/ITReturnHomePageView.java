package com.mootly.wcm.model;

public class ITReturnHomePageView {
	
	public FinancialYear getFinancialYear() {
		return financialYear;
	}
	
	public ITRForm getITRForm() {
		return itrForm;
	}
	
	public FilingSection getFilingSection() {
		return filingSection;
	}

	public ITRForm getItrForm() {
		return itrForm;
	}

	public ITRServiceDelivery getItrFormMode() {
		return itrFormMode;
	}

	public void setITRForm(ITRForm itrForm) {
		this.itrForm = itrForm;		
	}

	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}

	public FilingStatus getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(FilingStatus filingStatus) {
		this.filingStatus = filingStatus;
	}

	public ITReturnType getItReturnType() {
		return itReturnType;
	}

	public void setItReturnType(ITReturnType itReturnType) {
		this.itReturnType = itReturnType;
	}
	
	public void setFilingSection(FilingSection filingSection) {
		this.filingSection = filingSection;
	}

	public void setItrForm(ITRForm itrForm) {
		this.itrForm = itrForm;
	}

	public void setItrFormMode(ITRServiceDelivery itrFormMode) {
		this.itrFormMode = itrFormMode;
	}

	public String getLastOrOrgName() {
		return lastOrOrgName;
	}

	public void setLastOrOrgName(String lastOrOrgName) {
		this.lastOrOrgName = lastOrOrgName;
	}
	public void setITRFormMode(ITRServiceDelivery itrFormMode){
		this.itrFormMode=itrFormMode;
	}
	public ITRServiceDelivery getITRFormMode() {
		return itrFormMode;
	}
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
		if (pan != null && pan.length() >= 4) setFilingStatus(FilingStatus.getEnumByFourthChar(pan.charAt(3)));
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCanonicalUUID() {
		return canonicalUUID;
	}

	public void setCanonicalUUID(String canonicalUUID) {
		this.canonicalUUID = canonicalUUID;
	}

	String pan;
	FinancialYear financialYear;
	FilingStatus filingStatus;
	ITReturnType itReturnType;
	FilingSection filingSection;
	ITRForm itrForm;
	ITRServiceDelivery itrFormMode;
	String canonicalUUID;
	
	String lastOrOrgName;
	String email;
	
	
}
