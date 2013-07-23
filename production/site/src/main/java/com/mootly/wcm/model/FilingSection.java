package com.mootly.wcm.model;

public enum FilingSection {
	BeforeDueDate_139_1("11","Before Due Date"),
	AfterDueDate_139_4("12","After Due Date"),
	u_s_142_1("13","u/s 142(1)"),
	u_s_148("14","u/s 148"),
	u_s_153A("15","u/s 153A"),
	u_s_153C_r_w_153A("16","u/s 153 r/w 153A"),
	Revised_139_5("17","Revised 139(5)"),
	Revised_139_9("18","u/s 139(9)"),
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
	
	public String getdisplayString() {
		if (desc == null) {
			return toString();
		}
		else {
			return this.desc;
		}
	}
	public String getXmlCode(){
		return xmlCode;
	}
}
