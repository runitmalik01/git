/*
 * In this class we are creating a document for storing value of Contact Information details of user
 * according to form 16.
 * @author abhishek
 * 04/03/2013
 * 
 * 
 */
package com.mootly.wcm.member;


import java.io.StringWriter;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import in.gov.incometaxindiaefiling.y2012_2013.itr1.ITR1;
import in.gov.incometaxindiaefiling.y2012_2013.itr1.ObjectFactory;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address.Phone;
import in.gov.incometaxindiaefiling.y2012_2013.master.AssesseeName;
import in.gov.incometaxindiaefiling.y2012_2013.master.CreationInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.PersonalInfo;
import in.gov.incometaxindiaefiling.y2012_2013.master.Address;
import in.gov.incometaxindiaefiling.y2012_2013.master.FilingStatus;

import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.AdditionalBeans;
import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberContactInformation;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.SalaryIncomeDocument;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.model.ITRForm;

@AdditionalBeans(additionalBeansToLoad={MemberPersonalInformation.class,MemberContactInformation.class,SalaryIncomeDocument.class})
@RequiredBeans(requiredBeans={MemberPersonalInformation.class})
public class XmlGenerator extends ITReturnComponent {
	private static final Logger log = LoggerFactory.getLogger(XmlGenerator.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);	

		if (getPublicRequestParameter(request, "show") != null) request.setAttribute("show",getPublicRequestParameter(request, "show"));

		//simple test
		ITRForm whichITRForm = ITRForm.getEnumByDisplayName(getLocalParameter("formName", request));
		if (whichITRForm.equals(ITRForm.UNKNOWN)) {
			whichITRForm = ITRForm.ITR1;
		}

		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());


		ITR1 itr1 = new ObjectFactory().createITR1();
		CreationInfo creationInfo = new CreationInfo();
		creationInfo.setIntermediaryCity("Delhi");
		creationInfo.setSWCreatedBy("Wealth4India");
		creationInfo.setXMLCreatedBy("Wealth4India");
		try {
			DatatypeFactory df = DatatypeFactory.newInstance();
			GregorianCalendar gc = new GregorianCalendar();
			XMLGregorianCalendar xmlGC =  df.newXMLGregorianCalendar(gc);
			creationInfo.setXMLCreationDate(xmlGC);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		itr1.setCreationInfo(creationInfo);

		PersonalInfo personalInfo = new PersonalInfo();
		AssesseeName assesseeName = new AssesseeName();
		Address address= new Address(); 
		FilingStatus filingstatus = new FilingStatus();

		assesseeName.setFirstName(memberPersonalInformation.getFirstName());
		assesseeName.setSurNameOrOrgName(memberPersonalInformation.getLastName());
		assesseeName.setMiddleName(memberPersonalInformation.getMiddleName());
		personalInfo.setAssesseeName(assesseeName);

		personalInfo.setPAN(memberPersonalInformation.getPAN());

		address.setResidenceNo(memberPersonalInformation.getFlatDoorBuilding());
		address.setRoadOrStreet(memberPersonalInformation.getRoadStreet());
		address.setLocalityOrArea(memberPersonalInformation.getAreaLocality());
		address.setCityOrTownOrDistrict(memberPersonalInformation.getTownCityDistrict());
		address.setStateCode(memberPersonalInformation.getState());
		address.setPinCode(memberPersonalInformation.getBigPinCode());
		Phone phone = new Phone();
		phone.setSTDcode(memberPersonalInformation.getBigStdCode());
		phone.setPhoneNo(memberPersonalInformation.getBigPhone());
		address.setMobileNo(memberPersonalInformation.getBigMobile());
		address.setEmailAddress(memberPersonalInformation.getEmail());
		personalInfo.setAddress(address);

		personalInfo.setDOB(memberPersonalInformation.getGregorianDOB());
		personalInfo.setEmployerCategory(memberPersonalInformation.getEmployerCategory());
		personalInfo.setGender(memberPersonalInformation.getSex());
		personalInfo.setStatus(memberPersonalInformation.getFilingStatus());

		itr1.setPersonalInfo(personalInfo);
	    
		//filingstatus.setDesigOfficerWardorCircle(memberPersonalInformation.getIncomeTaxWard());
		//filingstatus.setReturnFileSec(memberPersonalInformation.getReturnFileSection());
		filingstatus.setReturnType(memberPersonalInformation.getReturnType());
		filingstatus.setResidentialStatus(memberPersonalInformation.getResidentCategory());
		//filingstatus.setTaxStatus(memberPersonalInformation.getTaxStatus());
		filingstatus.setAckNoOriginalReturn(memberPersonalInformation.getOriginalAckNo());
		//filingstatus.setOrigRetFiledDate(memberPersonalInformation.getGregorianOriginalAckDate());
		filingstatus.setNoticeNo(memberPersonalInformation.getNoticeNo());
		//filingstatus.setNoticeDate(memberPersonalInformation.getGregorianNoticeDate());
		//filingstatus.setReceiptNo(memberPersonalInformation.getReceiptNo());
		
		itr1.setFilingStatus(filingstatus);

		request.setAttribute("theForm", itr1);
		/* This is where we generate XML */
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ITR1.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(itr1, sw);
			request.setAttribute("xml",sw.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doAction(HstRequest request, HstResponse response) throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
}
