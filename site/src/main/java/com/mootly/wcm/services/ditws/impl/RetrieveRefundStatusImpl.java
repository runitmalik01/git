package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.ditws.RetrieveRefundStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.RetrieveRefundResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapperHelper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveRefundStatusImpl extends DITSOAPServiceImpl implements RetrieveRefundStatus {
	
	public RetrieveRefundStatusImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService) {
		super(userName, password, certChain, signature, soapService);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(RetrieveRefundStatusImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperRetrieveRefundStatus;
	
	public SOAPCallWrapper getSoapCallWrapperRetrieveRefundStatus() {
		return soapCallWrapperRetrieveRefundStatus;
	}

	public void setSoapCallWrapperRetrieveRefundStatus(
			SOAPCallWrapper soapCallWrapperRetrieveRefundStatus) {
		this.soapCallWrapperRetrieveRefundStatus = soapCallWrapperRetrieveRefundStatus;
	}

	@Override
	public RetrieveRefundResponse retrieveRefundStatus(String userName,String password,String certChain, String signature, String PAN, String assessmentYear)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN_NO, PAN);		
		inputParamValues.put(PARAM_ASSESSMENT_YEAR.toLowerCase(), assessmentYear);		
		
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrieveRefundStatus.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrieveRefundStatus,inputParams);
			RetrieveRefundResponse retrieveRefundResponse = SOAPCallWrapperHelper.getInstanceFromSOAPMapSingleInstance(RetrieveRefundResponse.class, outputMap);
			return retrieveRefundResponse;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			logger.error("Error refund status",e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error refund status",e);
		} catch (SOAPFaultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error refund status",e);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error refund status",e);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error refund status",e);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error refund status",e);
		}
			
		
		return null;
	}
}
