package com.mootly.wcm.model.schedules.y2013_2014;

import in.gov.incometaxindiaefiling.y2013_2014.CreationInfo;
import in.gov.incometaxindiaefiling.y2013_2014.ITR;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;

public class CreationInformation {

	public CreationInfo getCreationInfo(ITR itr){

		GregorianCalendar globalIndianGregorianCalendar = ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsDate();
		CreationInfo creationInfo = new CreationInfo();
		creationInfo.setSWVersionNo("1.0");
		creationInfo.setIntermediaryCity(ITRXmlGeneratorServiceCommon.getIntermediaryCity());
		creationInfo.setSWCreatedBy(ITRXmlGeneratorServiceCommon.getSWCreatedBy());
		creationInfo.setXMLCreatedBy(ITRXmlGeneratorServiceCommon.getXMLCreatedBy());
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			XMLGregorianCalendar xmlGC =   DatatypeFactory.newInstance().newXMLGregorianCalendarDate(globalIndianGregorianCalendar.get(Calendar.YEAR),globalIndianGregorianCalendar.get(Calendar.MONTH)+1,globalIndianGregorianCalendar.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
			creationInfo.setXMLCreationDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return creationInfo;
	}

}
