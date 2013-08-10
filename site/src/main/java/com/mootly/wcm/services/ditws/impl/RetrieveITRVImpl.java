package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveITRVImpl implements RetrieveITRV {
	Logger logger = LoggerFactory.getLogger(RetrieveITRVImpl.class);
	SOAPService soapService;
	//XPath xPath;
	
	SOAPCallWrapper soapCallWrapperRetrieveITRVGetStatus;
	
	String springExpFindMicrosite;
	

	public Logger getLogger() {
		return logger;
	}



	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	public SOAPService getSoapService() {
		return soapService;
	}



	public void setSoapService(SOAPService soapService) {
		this.soapService = soapService;
	}

	public SOAPCallWrapper getSoapCallWrapperRetrieveITRVGetStatus() {
		return soapCallWrapperRetrieveITRVGetStatus;
	}

	public void setSoapCallWrapperRetrieveITRVGetStatus(
			SOAPCallWrapper soapCallWrapperRetrieveITRVGetStatus) {
		this.soapCallWrapperRetrieveITRVGetStatus = soapCallWrapperRetrieveITRVGetStatus;
	}



	public String getSpringExpFindMicrosite() {
		return springExpFindMicrosite;
	}



	public void setSpringExpFindMicrosite(String springExpFindMicrosite) {
		this.springExpFindMicrosite = springExpFindMicrosite;
	}

	@Override
	public ITRVStatus retrieveITRVStatus(String PAN, String assessmentYear)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put("PAN", PAN);		
		inputParamValues.put("assessmentYear", assessmentYear);		
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrieveITRVGetStatus.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrieveITRVGetStatus,inputParams);
			if (outputMap != null && outputMap.containsKey("result")) {
				String theResponse = (String) outputMap.get("result");
				if (theResponse != null) {
					ITRVStatus itrStatus = ITRVStatus.getBySOAPResponse(theResponse);
					return itrStatus;
				}
			}
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



	@Override
	public Hashtable retrieveITRVByAcknowledgementNumber(String userName,
			String password, String certChain, String signature,
			String acknowledgementNumber) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Hashtable retrieveITRVByTokenAndPAN(String userName,
			String password, String certChain, String signature,
			String tokenID, String PAN) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		return null;
	}
}
