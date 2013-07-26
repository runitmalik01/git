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
	
	public static String getByFolderSuffix(String folderName) {
		String strToRet = "";
		if (folderName.contains("_f_")) {
			int indx = folderName.indexOf("_f_");
			strToRet = folderName.substring(indx);
		}
		return strToRet;
	}
	
	public static ITReturnType getByFolderName(String folderName) {
		String toCompare = folderName;
		if (folderName.contains("_f_")) {
			int indx = folderName.indexOf("_f_");
			toCompare = folderName.substring(0,indx);
		}
		for (ITReturnType itReturnType:ITReturnType.values()) {
			if (toCompare.equalsIgnoreCase(itReturnType.getDisplayName())) {
				return itReturnType;
			}
		}
		return UNKNOWN;
	}
}
