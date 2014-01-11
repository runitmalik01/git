package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.services.ditws.RetrieveRectificationStatus;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.RetrieveRectificationResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapperHelper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveRectificationStatusImpl extends DITSOAPServiceImpl implements RetrieveRectificationStatus {
	
	public RetrieveRectificationStatusImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService,ITReturnComponentHelper itReturnComponentHelper,boolean saveAllSOAPReuqestToFileSystem,  String soapRequestSaveLocation,  boolean saveAllSOAPRequestToRepository) {
		super(userName, password, certChain, signature, soapService,itReturnComponentHelper,saveAllSOAPReuqestToFileSystem,soapRequestSaveLocation,saveAllSOAPRequestToRepository);
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
	public RetrieveRectificationResponse retrieveRectificationStatus(String userName,String password,String certChain, String signature, String PAN,
			String assessmentYear,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN_NO, PAN);	
		inputParamValues.put(PARAM_ASSESSMENT_YEAR_2E, assessmentYear);	
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
			if (isSaveAllSOAPRequestToRepository()) {
				try {
					saveSOAPRequestToRepository(soapCallWrapperRetrieveRectificationStatus.getOperation(), absoluteBasePathToReturnDocuments, wpm, outputMap);
				}catch (Exception e) {
					logger.error("Saving into repository exception",e);
				}
			}
			RetrieveRectificationResponse retrieveRectificationResponse = SOAPCallWrapperHelper.getInstanceFromSOAPMapSingleInstance(RetrieveRectificationResponse.class, outputMap);
			return retrieveRectificationResponse;
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
			logger.error("SOAPException",e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			logger.error("SOAPException",e);
		}
		return null;
	}
	
}
