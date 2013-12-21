package com.mootly.wcm.services.ditws.impl;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
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
import com.mootly.wcm.services.efile.EFileResponse;


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
	public EFileResponse submitBulkITR(String userName,String password,String certChain, String signature, byte[] bytes)
			throws MissingInformationException, DataMismatchException,
			InvalidFormatException {
		// TODO Auto-generated method stub
		if (userName  != null)  setUserName(userName);
		if (password  != null)  setPassword(password);
		if (certChain != null)  setCertChain(certChain);
		if (signature != null)  setSignature(signature);
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
			if (bytes != null) {
				ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(bytes, "application/octet-stream");
				DataHandler dataHandler = new DataHandler(byteArrayDataSource);
				AttachmentPart attachmentPart = soapMessage.createAttachmentPart(dataHandler);
				attachmentPart.setMimeHeader("Content-Type", "application/xml");
				attachmentPart.setContent(new ByteArrayInputStream(bytes),"application/zip");
				//attachmentPart.setContentType("application/xml");
				//attachmentPart.setRawContent(new ByteArrayInputStream(bytes));//, "MIME");
				attachmentPart.setContentId("itrXMLFile");
				
				soapMessage.addAttachmentPart(attachmentPart);
			}
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperSubmitBulkITR,inputParams,soapMessage);
			EFileResponse eFileResponse = new EFileResponse ();
			if (outputMap != null && outputMap.containsKey("result")) {
				String tokenNumber = (String) outputMap.get("result");
				eFileResponse.setTokenNumber(tokenNumber);
			}
			return eFileResponse;
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
