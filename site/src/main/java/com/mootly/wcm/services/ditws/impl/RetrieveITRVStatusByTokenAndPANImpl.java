package com.mootly.wcm.services.ditws.impl;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import javax.xml.xpath.XPathExpressionException;

import org.hippoecm.hst.content.beans.manager.workflow.WorkflowPersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.components.ITReturnComponentHelper;
import com.mootly.wcm.services.ditws.ITRVStatus;
import com.mootly.wcm.services.ditws.RetrieveITRVStatusByTokenAndPAN;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.helper.SpringExpressionParser;
import com.mootly.wcm.services.ditws.model.RetrieveITRVStatusResponse;
import com.mootly.wcm.services.ditws.soap.SOAPCallWrapper;
import com.mootly.wcm.services.ditws.soap.SOAPService;


public class RetrieveITRVStatusByTokenAndPANImpl extends DITSOAPServiceImpl implements RetrieveITRVStatusByTokenAndPAN {
	
	public RetrieveITRVStatusByTokenAndPANImpl(String userName, String password, String certChain,
			String signature, SOAPService soapService,ITReturnComponentHelper itReturnComponentHelper,boolean saveAllSOAPReuqestToFileSystem,  String soapRequestSaveLocation,  boolean saveAllSOAPRequestToRepository) {
		super(userName, password, certChain, signature, soapService,itReturnComponentHelper,saveAllSOAPReuqestToFileSystem,soapRequestSaveLocation,saveAllSOAPRequestToRepository);
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(RetrieveITRVStatusByTokenAndPANImpl.class);
	//XPath xPath;
	
	SOAPCallWrapper soapCallWrapperRetrieveITRVByTokenNo;
	
	public SOAPCallWrapper getSoapCallWrapperRetrieveITRVByTokenNo() {
		return soapCallWrapperRetrieveITRVByTokenNo;
	}

	public void setSoapCallWrapperRetrieveITRVByTokenNo(
			SOAPCallWrapper soapCallWrapperRetrieveITRVByTokenNo) {
		this.soapCallWrapperRetrieveITRVByTokenNo = soapCallWrapperRetrieveITRVByTokenNo;
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
		
		Map<String,String> inputParamValues = new HashMap<String,String>(1);
		/*
		 *  <entry key="userID" value="#userName"></entry>
    			<entry key="password" value="#password"></entry>
    			<entry key="certChain" value="#certChain"></entry>
    			<entry key="signature" value="#signature"></entry>
    			<entry key="tokenNumber" value="#tokenNumber"></entry>
    			<entry key="panID" value="#panID"></entry>
		 */
		inputParamValues.put("tokenNumber", tokenID);	
		inputParamValues.put("panID", PAN);		
		updateInputParamValues (inputParamValues); //update username password 
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.putAll(inputParamValues);
		Map<String,String> newStaticInputValues = SpringExpressionParser.parseStaticInputMap(soapCallWrapperRetrieveITRVByTokenNo.getInputElementMap(), variables);
		if (newStaticInputValues != null && newStaticInputValues.size() > 0) {
			inputParamValues.putAll(newStaticInputValues);
		}
		
		List<Map<String,String>> inputParams = new ArrayList<Map<String,String>>(1);
		inputParams.add(inputParamValues);
		
		try {
			Map<String,Object> outputMap = soapService.executeSOAPCall(soapCallWrapperRetrieveITRVByTokenNo,inputParams);
			if (isSaveAllSOAPRequestToRepository()) {
				try {
					saveSOAPRequestToRepository(soapCallWrapperRetrieveITRVByTokenNo.getOperation(), absoluteBasePathToReturnDocuments, wpm, outputMap);
				}catch (Exception e) {
					logger.error("Saving into repository exception",e);
				}
			}
			if (outputMap != null && outputMap.containsKey(PARAM_RESULT)) {
				String theResponse = (String) outputMap.get(PARAM_RESULT);
				if (theResponse != null ) {
					//<ns2:result><![CDATA[<STATUSRESPONSE><STATUS><PAN>AWBPR0486J</PAN><ACK>860562120080114</ACK><MESSAGE>Success</MESSAGE><ERROR_CODE>null</ERROR_CODE><ERROR_MESSAGE>null</ERROR_MESSAGE></STATUS></STATUSRESPONSE>]]></ns2:result>
					if (theResponse.contains("<STATUSRESPONSE>") ){
						theResponse = theResponse.replaceAll("<STATUSRESPONSE>", "");
					}
					if (theResponse.contains("</STATUSRESPONSE>") ){
						theResponse = theResponse.replaceAll("</STATUSRESPONSE>", "");
					}
					try {
						RetrieveITRVStatusResponse retrieveITRVStatusResponse = RetrieveITRVStatusResponse.loadFromXml(theResponse,new  RetrieveITRVStatusResponse());
						return retrieveITRVStatusResponse;
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error("Malformed URL",e);
					}
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
}
