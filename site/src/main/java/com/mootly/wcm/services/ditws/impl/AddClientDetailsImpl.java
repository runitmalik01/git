package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.AddClientDetailsResponse;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class AddClientDetailsImpl extends DITSOAPServiceImpl implements AddClientDetails {
	
	public AddClientDetailsImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService) {
		super(userName, password, certChain, signature, soapService);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(AddClientDetailsImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperaddClientDetailsImpl;
	
	public SOAPCallWrapper getSoapCallWrapperAddClientDetails() {
		return soapCallWrapperaddClientDetailsImpl;
	}

	public void setSoapCallWrapperAddClientDetails(
			SOAPCallWrapper soapCallWrapperaddClientDetailsImpl) {
		this.soapCallWrapperaddClientDetailsImpl = soapCallWrapperaddClientDetailsImpl;
	}
	
	@Override
	public AddClientDetailsResponse addClientDetails(String userName,
			String password, String certChain, String signature, String PAN,
			GregorianCalendar DOB, String email,
			AddClientOption addClientOption, String TAN,
			FinancialYear financialYear) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);	
		String theFormatForSOAP = IndianGregorianCalendar.formatDateAsString(DOB, "YYYY-MM-dd");
		inputParamValues.put(PARAM_DATE_OF_BIRTH, theFormatForSOAP);		
		//inputParamValues.put(PARAM_ASSESSMENT_YEAR, assessmentYear);		
		
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperaddClientDetailsImpl.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperaddClientDetailsImpl,inputParams);
			AddClientDetailsResponse addClientDetailsResponse = new AddClientDetailsResponse();
			return addClientDetailsResponse;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			logger.error("Malformed URL",e);
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			logger.error("XPathExpressionException",e);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			logger.error("SOAPException",e);
		}
		
		return null;
	}
}
