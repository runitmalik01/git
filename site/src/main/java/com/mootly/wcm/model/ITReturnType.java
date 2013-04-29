package com.mootly.wcm.model;

public enum ITReturnType {
	ORIGINAL("O","original"),
	REVISED ("R","revised"),
	UNKNOWN("","unknown");
	
	String displayName;
	String xmlStatus;
	
	ITReturnType() {
	}
	
	ITReturnType(String xmlStatus,String displayName) {
		this.xmlStatus = xmlStatus;
		this.displayName = displayName;
	}
	
	
	public String getDisplayName() {
		return displayName;
	}

	public String getXmlStatus() {
		return xmlStatus;
	}
	
	public String toString() {
		return this.displayName;
	}

	public static ITReturnType getByDisplayName(String displayName) {
		if (displayName == null) return null;
		for (ITReturnType aReturnType:ITReturnType.values()) {
			if (displayName.equals(aReturnType.getDisplayName())) {
				return aReturnType;
			}
		}
		return UNKNOWN;
	}
	
	public static ITReturnType getByXmlStatus(String xmlStatus) {
		for (ITReturnType aReturnType:ITReturnType.values()) {
			if (xmlStatus.equals(aReturnType.getXmlStatus())) {
				return aReturnType;
			}
		}
		return UNKNOWN;
	}
	
}
