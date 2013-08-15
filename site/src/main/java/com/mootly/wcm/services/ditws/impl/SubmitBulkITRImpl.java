package com.mootly.wcm.services.ditws.impl;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.ditws.SubmitBulkITR;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapperHelper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class SubmitBulkITRImpl extends DITSOAPServiceImpl implements SubmitBulkITR {
	
	public SubmitBulkITRImpl(String userName, String password,
			String certChain, String signature, SOAPService soapService) {
		super(userName, password, certChain, signature, soapService);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(SubmitBulkITRImpl.class);
	//XPath xPath;
	SOAPCallWrapper soapCallWrapperSubmitBulkITR;
	
	public SOAPCallWrapper getSoapCallWrapperSubmitBulkITR() {
		return soapCallWrapperSubmitBulkITR;
	}

	public void setSoapCallWrapperSubmitBulkITR(
			SOAPCallWrapper soapCallWrapperSubmitBulkITR) {
		this.soapCallWrapperSubmitBulkITR = soapCallWrapperSubmitBulkITR;
	}

	@Override
	public Map<String,Object> submitBulkITR(File theZipFile)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		
		updateInputParamValues (inputParamValues); //update username password 
		
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperSubmitBulkITR.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			SOAPMessage soapMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapperSubmitBulkITR, inputParams);
			if (theZipFile != null) {
				DataHandler dataHandler = new DataHandler(theZipFile.toURI().toURL());
				AttachmentPart attachmentPart = soapMessage.createAttachmentPart(dataHandler);
				attachmentPart.setContentType("application/octet-stream");
				attachmentPart.setContentId("itrXMLFile");
				soapMessage.addAttachmentPart(attachmentPart);
			}
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperSubmitBulkITR,inputParams,soapMessage);
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
