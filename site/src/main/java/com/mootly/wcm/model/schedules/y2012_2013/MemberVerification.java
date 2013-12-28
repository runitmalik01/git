package com.mootly.wcm.model.schedules.y2012_2013;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.Verification;
import in.gov.incometaxindiaefiling.y2012_2013.Verification.Declaration;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;

public class MemberVerification {
	MemberPersonalInformation document = null;

	public MemberVerification(MemberPersonalInformation document) {
		this.document = document;
	}

	/**
	 * 2012-2013 Financial Year
	 * @param itr
	 * @return
	 */

	public Verification getVerification(ITR itr){

		GregorianCalendar globalIndianGregorianCalendar = ITRXmlGeneratorServiceCommon.getCurrentDateInIndiaAsDate();
		Verification verification = new Verification();
		Declaration declaration = new Declaration();
		declaration.setAssesseeVerName(document.getFirstName().toUpperCase()+" "+
				document.getMiddleName().toUpperCase()+" "+document.getLastName().toUpperCase());
		declaration.setFatherName(document.getFatherName().toUpperCase());
		declaration.setAssesseeVerPAN(document.getPAN().toUpperCase());
		verification.setDeclaration(declaration);
		verification.setPlace(document.getTownCityDistrict().toUpperCase());
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			XMLGregorianCalendar xmlGC =   DatatypeFactory.newInstance().newXMLGregorianCalendarDate(globalIndianGregorianCalendar.get(Calendar.YEAR),globalIndianGregorianCalendar.get(Calendar.MONTH)+1,globalIndianGregorianCalendar.get(Calendar.DAY_OF_MONTH),DatatypeConstants.FIELD_UNDEFINED);
			verification.setDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return verification;

	}
}
