package com.mootly.wcm.model;

public enum FilingSection {
	BeforeDueDate_139_1("11","Before Due Date"),
	AfterDueDate_139_4("12","After Due Date"),
	u_s_142_1("13"),
	u_s_148("14"),
	u_s_153A("15"),
	u_s_153C_r_w_153A("16"),
	Revised_139_5("17"),
	Revised_139_9("18"),
	UNKNOWN;
	
	String xmlCode;
	String desc;
	
	private FilingSection() {
	}
	
	private FilingSection(String xmlCode) {
		this.xmlCode = xmlCode;
	}
	
	private FilingSection(String xmlCode,String desc) {
		this.xmlCode = xmlCode;
		this.desc = desc;
	}
	
	public String displayString() {
		if (desc == null) {
			return toString();
		}
		else {
			return this.desc;
		}
	}
}
