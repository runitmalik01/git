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
import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.RetrieveITRV;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.RetrieveITRVStatusResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveITRVImpl extends DITSOAPServiceImpl implements RetrieveITRV {
	
	public RetrieveITRVImpl(String userName, String password, String certChain,
			String signature, SOAPService soapService,ITReturnComponentHelper itReturnComponentHelper,boolean saveAllSOAPReuqestToFileSystem,  String soapRequestSaveLocation,  boolean saveAllSOAPRequestToRepository) {
		super(userName, password, certChain, signature, soapService,itReturnComponentHelper,saveAllSOAPReuqestToFileSystem,soapRequestSaveLocation,saveAllSOAPRequestToRepository);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(RetrieveITRVImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperRetrieveITRVGetStatus;
	
	SOAPCallWrapper soapCallWrapperRetrieveITRVByTokenNo;
	
	public SOAPCallWrapper getSoapCallWrapperRetrieveITRVGetStatus() {
		return soapCallWrapperRetrieveITRVGetStatus;
	}

	public void setSoapCallWrapperRetrieveITRVGetStatus(
			SOAPCallWrapper soapCallWrapperRetrieveITRVGetStatus) {
		this.soapCallWrapperRetrieveITRVGetStatus = soapCallWrapperRetrieveITRVGetStatus;
	}
	
	public SOAPCallWrapper getSoapCallWrapperRetrieveITRVByTokenNo() {
		return soapCallWrapperRetrieveITRVByTokenNo;
	}

	public void setSoapCallWrapperRetrieveITRVByTokenNo(
			SOAPCallWrapper soapCallWrapperRetrieveITRVByTokenNo) {
		this.soapCallWrapperRetrieveITRVByTokenNo = soapCallWrapperRetrieveITRVByTokenNo;
	}

	@Override
	public ITRVStatus retrieveITRVStatus(String PAN, String assessmentYear,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
//		if (userName  != null)  setUserName(userName);
//		if (password  != null)  setPassword(password);
//		if (certChain != null)  setCertChain(certChain);
//		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);		
		inputParamValues.put(PARAM_ASSESSMENT_YEAR, assessmentYear);		
		
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
			if (isSaveAllSOAPRequestToRepository()) {
				try {
					saveSOAPRequestToRepository(soapCallWrapperRetrieveITRVGetStatus.getOperation(), absoluteBasePathToReturnDocuments, wpm, outputMap);
				}catch (Exception e) {
					logger.error("Saving into repository exception",e);
				}
			}
			if (outputMap != null && outputMap.containsKey(PARAM_RESULT)) {
				String theResponse = (String) outputMap.get(PARAM_RESULT);
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
	public RetrieveITRVStatusResponse retrieveITRVByAcknowledgementNumber(
			String userName, String password, String certChain,
			String signature, String acknowledgementNumber,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm) throws MissingInformationException,
			DataMismatchException, InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		return null;
	}
	
	@Override
	public RetrieveITRVStatusResponse retrieveITRVByTokenAndPAN(String userName, String password, String certChain,
			String signature, String tokenID, String PAN,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		return null;
	}
}
