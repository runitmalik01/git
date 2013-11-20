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

import com.mootly.wcm.services.ditws.RetrievePANInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.RetrievePANResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapperHelper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrievePANInformationImpl extends DITSOAPServiceImpl implements RetrievePANInformation {
	
	public RetrievePANInformationImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService) {
		super(userName, password, certChain, signature, soapService);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(RetrievePANInformationImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperRetrievePANInfo;
	
	public SOAPCallWrapper getSoapCallWrapperRetrievePANInfo() {
		return soapCallWrapperRetrievePANInfo;
	}

	public void setSoapCallWrapperRetrievePANInfo(
			SOAPCallWrapper soapCallWrapperRetrievePANInfo) {
		this.soapCallWrapperRetrievePANInfo = soapCallWrapperRetrievePANInfo;
	}
	
	@Override
	public RetrievePANResponse retrievePANInformation(String userName,
			String password,String certChain, String signature, String PAN) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);		
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrievePANInfo.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrievePANInfo,inputParams);
			RetrievePANResponse retrievePANResponse = SOAPCallWrapperHelper.getInstanceFromSOAPMapSingleInstance(RetrievePANResponse.class, outputMap);
			return retrievePANResponse;
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public RetrievePANResponse retrievePANInformation(String PAN)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		return retrievePANInformation(getUserName(),getPassword(),getCertChain(),getSignature(),PAN);
	}
	
}
