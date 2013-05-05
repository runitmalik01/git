package com.mootly.wcm.model;

public enum ITRForm {
	ITR1("ITR-1"),
	ITR2("ITR-2"),
	UNKNOWN;
	
	String displayName;
	
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
