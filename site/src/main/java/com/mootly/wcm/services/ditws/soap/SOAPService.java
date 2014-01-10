package com.mootly.wcm.services.ditws.soap;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SOAPService {
	private static final Logger logger = LoggerFactory.getLogger(SOAPService.class);
	
	
	public static enum SOAPDebugVerbosity {DEBUG,INFO,WARN,ERROR};	
	public static enum SOAPMessageDirection {IN,OUT};	
	
	String logFileLocationBaseDir;
	
	public SOAPService() {
			
	}
	
	public String getLogFileLocationBaseDir() {
		return logFileLocationBaseDir;
	}



	public void setLogFileLocationBaseDir(String logFileLocationBaseDir) {
		this.logFileLocationBaseDir = logFileLocationBaseDir;
	}



	public  void debugMessage(long timeStamp,SOAPMessageDirection soapMessageDirection,SOAPDebugVerbosity soapDebugVerbosity,SOAPMessage soapMessage,String operation) {
		final String fileName = logFileLocationBaseDir +  File.separator + soapDebugVerbosity.toString() +  File.separator + operation + "_" + soapMessageDirection + "_"+ timeStamp +".xml";
		if (logger.isDebugEnabled()) {
			FileOutputStream fo = null;
			try {
				//fo = new FileOutputStream(operation + "_" + System.currentTimeMillis() + "_message.xml");
				fo = new FileOutputStream(fileName);
				soapMessage.writeTo(fo);
			}catch (Exception ex){
				logger.error("Error",ex);
			}
			finally {
				try {fo.close();}catch (Exception ex1) {}
			}
		}
	}
	
	/**
	 * 
	 * @param async Is the transaction synchronous
	 * @param endPoint Web Service End Point
	 * @param soapCallWrapper
	 * @return SOAPBody representation 
	 * @throws Exception
	 */
	public SOAPMessage executeSOAPCallRAW(SOAPCallWrapper soapCallWrapper,List<Map<String,String>> initialParamValues,SOAPMessage soapMessage) throws MalformedURLException,XPathExpressionException, SOAPFaultException, SOAPException{
		if (soapMessage == null) {
			soapMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapper, initialParamValues);
		}
		SOAPMessage soapResponse = callWebService(soapCallWrapper.getOperation(),soapMessage,soapCallWrapper.getSoapConnection(),soapCallWrapper.getEndPointURL());
		if (logger.isDebugEnabled()) {
			SOAPBody theSOAPBody = soapResponse.getSOAPBody();
			Iterator it = theSOAPBody.getChildElements();
			for (;it.hasNext();) {
				Object o = it.next();
				logger.debug(o.toString() + ":" + o.getClass().getName());
			}
		}
		return soapResponse;
		//Map<String, Object> outputMapLocal= SOAPCallWrapperHelper.parseSOAPResponse(soapResponse, soapCallWrapper);		
		//return outputMapLocal;
	}
	/**
	 * 
	 * @param async Is the transaction synchronous
	 * @param endPoint Web Service End Point
	 * @param soapCallWrapper
	 * @return SOAPBody representation 
	 * @throws DITSoapFaultException 
	 * @throws Exception
	 */
	public SOAPMessage executeSOAPCallRAW(SOAPCallWrapper soapCallWrapper,List<Map<String,String>> initialParamValues) throws MalformedURLException,XPathExpressionException, SOAPException, SOAPFaultException{
		SOAPMessage soapResponse = executeSOAPCallRAW(soapCallWrapper, initialParamValues,null);
		return soapResponse;
		//Map<String, Object> outputMapLocal= SOAPCallWrapperHelper.parseSOAPResponse(soapResponse, soapCallWrapper);		
		//return outputMapLocal;
	}
	
	/**
	 * 
	 * @param async Is the transaction synchronous
	 * @param endPoint Web Service End Point
	 * @param soapCallWrapper
	 * @return SOAPBody representation 
	 * @throws Exception
	 */
	public Map<String, Object> executeSOAPCall(SOAPCallWrapper soapCallWrapper,List<Map<String,String>> initialParamValues,SOAPMessage soapMessage) throws MalformedURLException,XPathExpressionException,  SOAPFaultException, SOAPException{
		String soapRequestStr = null;
		try {
			SOAPMessage theDebugMessage = null;
			if ( soapMessage == null) {
				theDebugMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapper, initialParamValues);
			}
			else {
				theDebugMessage = soapMessage;
			}
			//doTrustToCertificates();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			BufferedOutputStream bo = new BufferedOutputStream(byteArrayOutputStream);
			theDebugMessage.writeTo(bo);
			bo.flush();
			soapRequestStr = byteArrayOutputStream.toString("UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error",e);
			e.printStackTrace();
		}
		SOAPMessage soapResponse = null;
		
		//THIS CODE MUSTNOT GO PUBLIC ////
		soapResponse = executeSOAPCallRAW(soapCallWrapper, initialParamValues,soapMessage);
		/*
		if (soapCallWrapper.getOperation().equals("submitITR")) {
			try {
				soapResponse = getSoapMessageFromString("<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header/><env:Body><ns2:DITWSResponseEle xmlns:ns2=\"http://incometaxindiaefiling.gov.in/ws/ds/common/v_1_0\"><ns2:result>111148210</ns2:result></ns2:DITWSResponseEle></env:Body></env:Envelope>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			soapResponse = executeSOAPCallRAW(soapCallWrapper, initialParamValues,soapMessage);
		}
		*/
		String soapResponseStr = null;
		try {
			//doTrustToCertificates();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			BufferedOutputStream bo = new BufferedOutputStream(byteArrayOutputStream);
			soapResponse.writeTo(bo);
			bo.flush();
			soapResponseStr = byteArrayOutputStream.toString("UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SOAPMessage soapMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapper, initialParamValues);
		//SOAPMessage soapResponse = callWebService(soapCallWrapper.getOperation(),soapMessage,soapCallWrapper.getSoapConnection(),soapCallWrapper.getEndPointURL());
		Map<String, Object> outputMapLocal= SOAPCallWrapperHelper.parseSOAPResponse(soapResponse, soapCallWrapper);
		if (outputMapLocal == null && (soapRequestStr != null || soapResponseStr != null) ) {
			outputMapLocal =new HashMap<String, Object>(2);
		}
		if (soapRequestStr != null) {
			outputMapLocal.put("soapRequest", soapRequestStr);
		}
		if (soapResponseStr != null) {
			outputMapLocal.put("soapResponse", soapResponseStr);
		}
		return outputMapLocal;
	}
	
	/**
	 * 
	 * @param async Is the transaction synchronous
	 * @param endPoint Web Service End Point
	 * @param soapCallWrapper
	 * @return SOAPBody representation 
	 * @throws Exception
	 */
	public Map<String, Object> executeSOAPCall(SOAPCallWrapper soapCallWrapper,List<Map<String,String>> initialParamValues) throws MalformedURLException,XPathExpressionException, SOAPFaultException, SOAPException{
		//SOAPMessage soapResponse = executeSOAPCallRAW(soapCallWrapper, initialParamValues,null);
		//SOAPMessage soapMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapper, initialParamValues);
		//SOAPMessage soapResponse = callWebService(soapCallWrapper.getOperation(),soapMessage,soapCallWrapper.getSoapConnection(),soapCallWrapper.getEndPointURL());
		Map<String, Object> outputMapLocal= executeSOAPCall(soapCallWrapper,initialParamValues,null); //SOAPCallWrapperHelper.parseSOAPResponse(soapResponse, soapCallWrapper);		
		return outputMapLocal;
	}
	/**
	 * 
	 * @param async Is the transaction synchronous
	 * @param endPoint Web Service End Point
	 * @param soapCallWrapper
	 * @return SOAPBody representation 
	 * @throws Exception
	 */
	public SOAPMessage callWebService(String operation,SOAPMessage soapMessage,SOAPConnection soapConnection,URL endpointURL) throws MalformedURLException, SOAPFaultException, SOAPException{
		SOAPMessage response = null;
		final long startTime = System.currentTimeMillis();
		try {				
			if (logger.isDebugEnabled()) {
				logger.debug("Now Ready to Connect to " + endpointURL.toExternalForm());
				debugMessage(startTime, SOAPMessageDirection.IN  ,SOAPDebugVerbosity.DEBUG,soapMessage,operation);
			}			
			
			response = soapConnection.call(soapMessage, endpointURL);
			if (response != null  && response.getSOAPBody() != null && response.getSOAPBody().getFault() != null) {
				SOAPFault soapFault = response.getSOAPBody().getFault();
				throw new SOAPFaultException(soapFault);
			}
			//logger.debug(response.toString());
			if (logger.isDebugEnabled()) {
				debugMessage(startTime, SOAPMessageDirection.OUT  ,SOAPDebugVerbosity.DEBUG,response, operation);
			}
			return response;
		}		
		catch (SOAPException soe) {
			logger.error("Error",soe);
			try {
				if (soapMessage != null) debugMessage(startTime, SOAPMessageDirection.IN  ,SOAPDebugVerbosity.ERROR,soapMessage,operation);
				if (response != null) debugMessage(startTime, SOAPMessageDirection.OUT  ,SOAPDebugVerbosity.ERROR,response,operation);
			}catch (Exception anyException) {
				//need to WARN
				logger.warn("SOAPFault soapFault Occurred Trying to write the SOAP Message:",anyException);
			}			
			throw soe;
		}
		finally {
			
		}
	}
	
	private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
	    MessageFactory factory = MessageFactory.newInstance();
	    SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
	    return message;
	} 
}

