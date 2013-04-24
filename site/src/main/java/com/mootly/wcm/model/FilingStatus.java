package com.mootly.wcm.model;

public enum FilingStatus {
	INDIVIDUAL('i'),
	HUF('h'),
	FIRM('f'),
	COMPANY('c'),
	UNKNOWN;
	
	char fourthCharInPAN;
	
	FilingStatus() {
	}
	
	FilingStatus(char fourthCharInPAN) {
		this.fourthCharInPAN = fourthCharInPAN;
	}
	
	public static FilingStatus getEnumByString(char fourthCharInPAN) {
		String a ="a";
		switch (fourthCharInPAN) {
			case 'i':
				return INDIVIDUAL;
			case 'h':
				return HUF;
			case 'f':
				return FIRM;
			case 'c':
				return COMPANY;
			default:
				return UNKNOWN;
		}
	}
	
}
