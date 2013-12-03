package com.mootly.wcm.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ITRServiceDelivery")
@XmlEnum
public enum ITRServiceDelivery {
	@XmlEnumValue(value = "DIY") 
	DIY,
	@XmlEnumValue(value = "Assisted")
	Assisted;	
}
