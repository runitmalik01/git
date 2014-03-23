package com.mootly.wcm.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "DITSubmissionStatus")
@XmlEnum
public enum DITSubmissionStatus {
	@XmlEnumValue(value = "NOT_ATTEMPTED_YET") NOT_ATTEMPTED_YET,
	@XmlEnumValue(value = "SUCCESS") SUCCESS,
	@XmlEnumValue(value = "FAILED") FAILED;
}
