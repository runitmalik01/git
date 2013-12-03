package com.mootly.wcm.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "FilingSection")
@XmlEnum
public enum FilingSection {
	@XmlEnumValue(value = "BeforeDueDate_139_1") BeforeDueDate_139_1("11","Before Due Date","original",ITReturnType.ORIGINAL,false),
	@XmlEnumValue(value = "AfterDueDate_139_4") AfterDueDate_139_4("12","After Due Date","139_4",ITReturnType.ORIGINAL,false),
	@XmlEnumValue(value = "u_s_142_1") u_s_142_1("13","u/s 142(1)","u_s_142_1",ITReturnType.ORIGINAL,true),
	@XmlEnumValue(value = "u_s_148") u_s_148("14","u/s 148","u_s_148",ITReturnType.ORIGINAL,true),
	@XmlEnumValue(value = "u_s_153A") u_s_153A("15","u/s 153A","u_s_153A",ITReturnType.ORIGINAL,true),
	@XmlEnumValue(value = "u_s_153C_r_w_153A") u_s_153C_r_w_153A("16","u/s 153 r/w 153A","u_s_153C_r_w_153A",ITReturnType.ORIGINAL,true),
	@XmlEnumValue(value = "Revised_139_5") Revised_139_5("17","Revised 139(5)","revised",ITReturnType.REVISED,false),
	@XmlEnumValue(value = "Revised_139_9") Revised_139_9("18","u/s 139(9) (Defective)","revised_defective",ITReturnType.ORIGINAL,true),  //DEFECIVE RETURN
	@XmlEnumValue(value = "UNKNOWN") UNKNOWN;

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
