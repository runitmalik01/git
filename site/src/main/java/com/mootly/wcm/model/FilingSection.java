package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

public enum FilingSection {
	BeforeDueDate_139_1("11","Before Due Date","original",ITReturnType.ORIGINAL,false),
	AfterDueDate_139_4("12","After Due Date","139_4",ITReturnType.ORIGINAL,false),
	u_s_142_1("13","u/s 142(1)","u_s_142_1",ITReturnType.ORIGINAL,true),
	u_s_148("14","u/s 148","u_s_148",ITReturnType.ORIGINAL,true),
	u_s_153A("15","u/s 153A","u_s_153A",ITReturnType.ORIGINAL,true),
	u_s_153C_r_w_153A("16","u/s 153 r/w 153A","u_s_153C_r_w_153A",ITReturnType.ORIGINAL,true),
	Revised_139_5("17","Revised 139(5)","revised",ITReturnType.REVISED,false),
	Revised_139_9("18","u/s 139(9) (Defective)","revised_defective",ITReturnType.ORIGINAL,true),  //DEFECIVE RETURN
	UNKNOWN;

	String xmlCode;
	String desc;
	String folderName;
	ITReturnType itReturnType;
	boolean requiresNotice;

	private FilingSection() {
	}

	private FilingSection(String xmlCode) {
		this.xmlCode = xmlCode;
	}

	private FilingSection(String xmlCode,String desc,String folderName,ITReturnType itReturnType,boolean requiresNotice) {
		this.xmlCode = xmlCode;
		this.desc = desc;
		this.folderName = folderName;
		this.itReturnType = itReturnType;
		this.requiresNotice = requiresNotice;
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

	public String getDesc() {
		return desc;
	}

	public String getFolderName() {
		return folderName;
	}

	public ITReturnType getItReturnType() {
		return itReturnType;
	}

	public boolean isRequiresNotice() {
		return requiresNotice;
	}

	/**
	 * Fetch the FilingSection by Xml Code
	 * @param xmlCode
	 * @return
	 */
	public static FilingSection getByXmlCode(String xmlCode) {
		for (FilingSection aFilingSection:FilingSection.values()) {
			if (xmlCode.equals(aFilingSection.getXmlCode())) {
				return aFilingSection;
			}
		}
		return UNKNOWN;
	}

}
