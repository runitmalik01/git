package com.mootly.wcm.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "VerificationStatus")
@XmlEnum
public enum VerificationStatus {
	@XmlEnumValue(value = "VERIFIED") VERIFIED,
	@XmlEnumValue(value = "UNVERIFIED") UNVERIFIED,
	@XmlEnumValue(value = "FAILED") FAILED;
}
