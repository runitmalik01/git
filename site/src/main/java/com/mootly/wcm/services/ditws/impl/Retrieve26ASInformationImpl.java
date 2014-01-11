package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.model.IndianGregorianCalendar;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class Retrieve26ASInformationImpl extends DITSOAPServiceImpl implements Retrieve26ASInformation {
	
	public Retrieve26ASInformationImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService,ITReturnComponentHelper itReturnComponentHelper,boolean saveAllSOAPReuqestToFileSystem,  String soapRequestSaveLocation,  boolean saveAllSOAPRequestToRepository) {
		super(userName, password, certChain, signature, soapService,itReturnComponentHelper,saveAllSOAPReuqestToFileSystem,soapRequestSaveLocation,saveAllSOAPRequestToRepository);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(Retrieve26ASInformationImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperRetrieve26ASInformation;
	
	public SOAPCallWrapper getSoapCallWrapperRetrieve26ASInformation() {
		return soapCallWrapperRetrieve26ASInformation;
	}

	public void setSoapCallWrapperRetrieve26ASInformation(
			SOAPCallWrapper soapCallWrapperRetrieve26ASInformation) {
		this.soapCallWrapperRetrieve26ASInformation = soapCallWrapperRetrieve26ASInformation;
	}
	
	@Override
	public Twenty26ASResponse retrieve26ASInformation(String userName,String password,String certChain, String signature, String PAN,
			GregorianCalendar DOB, String assessmentYear,String absoluteBasePathToReturnDocuments , WorkflowPersistenceManager wpm)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		inputParamValues.put(PARAM_PAN, PAN);	
		String theFormatForSOAP = IndianGregorianCalendar.formatDateAsString(DOB, "YYYY-MM-dd");
		inputParamValues.put(PARAM_DOB, theFormatForSOAP);		
		inputParamValues.put(PARAM_ASSESSMENT_YEAR, assessmentYear);		
		
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrieve26ASInformation.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrieve26ASInformation,inputParams);
			Twenty26ASResponse twentyASResponse = Twenty26ASResponse.createFromSOAPResponse(outputMap);
			if (isSaveAllSOAPRequestToRepository()) {
				try {
					saveSOAPRequestToRepository(soapCallWrapperRetrieve26ASInformation.getOperation(), absoluteBasePathToReturnDocuments, wpm, outputMap);
				}catch (Exception e) {
					logger.error("Saving into repository exception",e);
				}
			}
			return twentyASResponse;
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
