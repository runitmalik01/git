package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.ditws.RetrieveRectificationStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveRectificationStatusImpl extends DITSOAPServiceImpl implements RetrieveRectificationStatus {
	
	public RetrieveRectificationStatusImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService) {
		super(userName, password, certChain, signature, soapService);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(RetrieveRectificationStatusImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperRetrieveRectificationStatus;
	
	public SOAPCallWrapper getSoapCallWrapperRetrieveRectificationStatus() {
		return soapCallWrapperRetrieveRectificationStatus;
	}

	public void setSoapCallWrapperRetrieveRectificationStatus(
			SOAPCallWrapper soapCallWrapperRetrieveRectificationStatus) {
		this.soapCallWrapperRetrieveRectificationStatus = soapCallWrapperRetrieveRectificationStatus;
	}

	@Override
	public Map<String, Object> retrieveRectificationStatus(String PAN,
			String assessmentYear) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);	
		inputParamValues.put(PARAM_ASSESSMENT_YEAR, assessmentYear);	
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrieveRectificationStatus.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrieveRectificationStatus,inputParams);
			return outputMap;
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
