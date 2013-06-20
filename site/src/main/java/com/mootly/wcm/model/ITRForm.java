package com.mootly.wcm.model;

public enum ITRForm {
	ITR1("ITR-1",true),
	ITR2("ITR-2"),
	ITR3("ITR-3"),
	ITR4("ITR-4"),
	ITR4S("ITR-4S"),
	ITR5("ITR-5"),
	ITR6("ITR-6"),
	ITR7("ITR-7"),
	ITR8("ITR-8"),
	UNKNOWN;
	
	String whoCanAndWhoCannot;
	String displayName;
	Boolean hasDIY = Boolean.FALSE;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	ITRForm() {
	}
	
	ITRForm(String displayName) {
		this.displayName = displayName;
		this.hasDIY = false;
	}
	
	ITRForm(String displayName,Boolean hasDIY) {
		this.displayName = displayName;
		this.hasDIY = true;
	}
	
	public Boolean getHasDIY() {
		return hasDIY;
	}
	
	public static ITRForm getEnumByDisplayName(String displayName) {
		if (displayName == null) return UNKNOWN;
		for (ITRForm aStatus:ITRForm.values()) {
			if (displayName.equals(aStatus.getDisplayName())) {
				return aStatus;
			}
		}
		return UNKNOWN;
	}
	
}
