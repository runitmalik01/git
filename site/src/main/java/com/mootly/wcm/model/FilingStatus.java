package com.mootly.wcm.model;

public enum FilingStatus {
	COMPANY('c',"Company"),
	PERSON('p',"Individual"),
	HUF('h',"HUF(Hindu Undivided Family)"),
	FIRM('f',"Firm"),
	AOP('a',"Association of Persons (AOP)"),
	TRUST('t',"AOP (Trust)"),
	BOI('b',"Body of Individuals (BOI)"),
	LOCALAUTHORITY('l',"Local Authority"),
	AJP('j',"Artificial Juridical Person"),
	GOVT('g',"Government"),
	UNKNOWN;
	
	char fourthCharInPAN;
	String name;
	
	
	FilingStatus() {
	}
	
	FilingStatus(char fourthCharInPAN,String name) {
		this.fourthCharInPAN = fourthCharInPAN;
		this.name = name;
	}
	
	public char getFourthCharInPAN() {
		return fourthCharInPAN;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public static FilingStatus getEnumByFourthChar(char fourthCharInPAN) {
		for (FilingStatus aStatus:FilingStatus.values()) {
			if (fourthCharInPAN == aStatus.getFourthCharInPAN()) {
				return aStatus;
			}
		}
		return UNKNOWN;
	}
	
	public static FilingStatus getEnumByName(String name) {
		for (FilingStatus aStatus:FilingStatus.values()) {
			if (name.equals(aStatus.getName())) {
				return aStatus;
			}
		}
		return UNKNOWN;
	}
	
}
