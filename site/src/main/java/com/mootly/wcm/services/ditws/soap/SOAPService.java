package com.mootly.wcm.services.ditws.soap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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
		SOAPMessage soapResponse = executeSOAPCallRAW(soapCallWrapper, initialParamValues,soapMessage);
		//SOAPMessage soapMessage = SOAPCallWrapperHelper.createSOAPMessage(soapCallWrapper, initialParamValues);
		//SOAPMessage soapResponse = callWebService(soapCallWrapper.getOperation(),soapMessage,soapCallWrapper.getSoapConnection(),soapCallWrapper.getEndPointURL());
		Map<String, Object> outputMapLocal= SOAPCallWrapperHelper.parseSOAPResponse(soapResponse, soapCallWrapper);		
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
			try {
				//doTrustToCertificates();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}

