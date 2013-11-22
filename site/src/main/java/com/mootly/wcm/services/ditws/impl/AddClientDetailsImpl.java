package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ditws.AddClientDetails;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.AddClientDetailsResponse;
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
			FinancialYear financialYear) throws SOAPFaultException, MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);	
		String theFormatForSOAP = IndianGregorianCalendar.formatDateAsString(DOB, "YYYY-MM-dd");
		inputParamValues.put(PARAM_DOB, theFormatForSOAP);		
		inputParamValues.put(PARAM_EMAIL, email);
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
		AddClientDetailsResponse addClientDetailsResponse = new AddClientDetailsResponse();
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperaddClientDetailsImpl,inputParams);
			return addClientDetailsResponse;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			logger.error("Malformed URL",e);
			addClientDetailsResponse.setError(e.getMessage());
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			logger.error("XPathExpressionException",e);
			addClientDetailsResponse.setError(e.getMessage());
		} catch (SOAPFaultException e) {
			logger.error("SOAPFaultException",e);
			addClientDetailsResponse.setError(e.getMessage());
			throw e; //throw this exception as DIT sends every ERROR as FAULT
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			logger.error("SOAPException",e);
			addClientDetailsResponse.setError(e.getMessage());
		}
		catch (Exception e) {
			logger.error("SOAPException",e);
			addClientDetailsResponse.setError(e.getMessage());
		}
		return addClientDetailsResponse;
	}
}
