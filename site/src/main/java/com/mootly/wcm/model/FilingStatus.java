package com.mootly.wcm.model;

import com.mootly.wcm.member.ResidentialStatus;

public enum FilingStatus {
	COMPANY('c',"Company","C"),
	PERSON('p',"Individual","I"),
	HUF('h',"HUF(Hindu Undivided Family)","H"),
	FIRM('f',"Firm","F"),
	AOP('a',"Association of Persons (AOP)","A"),
	TRUST('t',"AOP (Trust)","T"),
	BOI('b',"Body of Individuals (BOI)","B"),
	LOCALAUTHORITY('l',"Local Authority","L"),
	AJP('j',"Artificial Juridical Person","A"),
	GOVT('g',"Government","G"),
	UNKNOWN;
	
	char fourthCharInPAN;
	String name;
	String xmlCode;
	
	FilingStatus() {
	}
	
	FilingStatus(char fourthCharInPAN,String name,String xmlCode) {
		this.fourthCharInPAN = fourthCharInPAN;
		this.name = name;
		this.xmlCode = xmlCode;
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
	
	public String getXmlCode() {
		return xmlCode;
	}

	public void setXmlCode(String xmlCode) {
		this.xmlCode = xmlCode;
	}

	public void setFourthCharInPAN(char fourthCharInPAN) {
		this.fourthCharInPAN = fourthCharInPAN;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ITRForm[] getPossibleITRForms() {
		if (this == FilingStatus.PERSON) {
			ITRForm[] arr = new ITRForm[] {ITRForm.ITR1,ITRForm.ITR2,ITRForm.ITR3,ITRForm.ITR4,ITRForm.ITR4S}; //,ITRForm.ITR7};
			return arr;
		}
		else if (this == FilingStatus.HUF) {
			ITRForm[] arr = new ITRForm[] {ITRForm.ITR2,ITRForm.ITR3,ITRForm.ITR4,ITRForm.ITR4S};
			return arr;
		}
		else if (this == FilingStatus.FIRM || this == FilingStatus.AOP || this == FilingStatus.BOI) {
			ITRForm[] arr = new ITRForm[] {ITRForm.ITR5};
			return arr;
		}
		else if (this == COMPANY) {
			ITRForm[] arr = new ITRForm[] {ITRForm.ITR6,ITRForm.ITR7};
			return arr;
		}
		else {
			return null;
		}
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
