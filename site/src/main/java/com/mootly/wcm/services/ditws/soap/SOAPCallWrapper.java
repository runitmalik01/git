package com.mootly.wcm.services.ditws.soap;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPFactory;
import javax.xml.xpath.XPath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SOAPCallWrapper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6742422391552522772L;
	private String operation; 
	SOAPCallElement soapBodyElement;
	List<MimeHeader> mimeHeaders;
	boolean detachHeader;
	
	SOAPConnectionFactory soapConnectionFactory;
	SOAPFactory soapFactory;
	MessageFactory messageFactory;
	SOAPConnection soapConnection;
	
	URL endPointURL;
	
	List<SOAPCallElement> bodyChildren = new LinkedList<SOAPCallElement>();
	List<SOAPCallElement> headChildren = new LinkedList<SOAPCallElement>();
	
	Map<String,String> inputElementMap;
	String outputParentElement; //this will be used for Generating List
	Map<String,String> outputElementMap;
	boolean isResponseRepeatingMultipleTimes;
	
	boolean hasMultipleChildRootInResponse;
	List<String> rootChildrenInResponse;
	
	boolean createEmptyElementsInOutputWhenXPathNotFound = true;
	
	XPath xPath;
	
	Logger logger = LoggerFactory.getLogger(SOAPCallWrapper.class);
	
	List<SOAPCallNameSpaceDeclaration> nameSpaceDeclarations;
	
	public List<SOAPCallNameSpaceDeclaration> getNameSpaceDeclarations() {
		return nameSpaceDeclarations;
	}

	public void setNameSpaceDeclarations(
			List<SOAPCallNameSpaceDeclaration> nameSpaceDeclarations) {
		this.nameSpaceDeclarations = nameSpaceDeclarations;
	}

	public SOAPCallWrapper(String operation) {
		this.operation = operation;
	}
	
	public List<SOAPCallElement> getBodyChildren() {
		return bodyChildren;
	}
	
	public void AddBodyChildren(SOAPCallElement bodyChild) {
		bodyChildren.add(bodyChild);
	}
	
	public List<SOAPCallElement> getHeadChildren() {
		return headChildren;
	}
		
	public void setHeadChildren(List<SOAPCallElement> headChildren) {
		this.headChildren = headChildren;
	}

	public void AddHeadChildren(SOAPCallElement headChild) {
		headChildren.add(headChild);
	}
	
	public SOAPCallElement getSoapBodyElement() {
		return soapBodyElement;
	}
	
	public void setSoapBodyElement(SOAPCallElement soapBodyElement) {
		this.soapBodyElement = soapBodyElement;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public boolean isResponseRepeatingMultipleTimes() {
		return isResponseRepeatingMultipleTimes;
	}

	public void setResponseRepeatingMultipleTimes(
			boolean isResponseRepeatingMultipleTimes) {
		this.isResponseRepeatingMultipleTimes = isResponseRepeatingMultipleTimes;
	}

	public List<MimeHeader> getMimeHeaders() {
		return mimeHeaders;
	}

	public void addMimeHeader(String name,String value) {
		if (mimeHeaders == null) mimeHeaders = new ArrayList<MimeHeader>(1);
		mimeHeaders.add(new MimeHeader(name, value));
	}
	
	public void setMimeHeaders(List<MimeHeader> mimeMeaders) {
		this.mimeHeaders = mimeMeaders;
	}

	public boolean isDetachHeader() {
		return detachHeader;
	}

	public void setDetachHeader(boolean detachHeader) {
		this.detachHeader = detachHeader;
	}

	public void setBodyChildren(List<SOAPCallElement> bodyChildren) {
		this.bodyChildren = bodyChildren;
	}
			
	public Map<String, String> getInputElementMap() {
		return inputElementMap;
	}

	public void setInputElementMap(Map<String, String> inputElementMap) {
		this.inputElementMap = inputElementMap;
	}
	
	public String getOutputParentElement() {
		return outputParentElement;
	}

	public void setOutputParentElement(String outputParentElement) {
		this.outputParentElement = outputParentElement;
	}

	public Map<String, String> getOutputElementMap() {
		return outputElementMap;
	}

	public void setOutputElementMap(Map<String, String> outputElementMap) {
		this.outputElementMap = outputElementMap;
	}

	public SOAPConnectionFactory getSoapConnectionFactory() {
		return soapConnectionFactory;
	}

	public void setSoapConnectionFactory(SOAPConnectionFactory soapConnectionFactory) {
		this.soapConnectionFactory = soapConnectionFactory;
	}

	public SOAPFactory getSoapFactory() {
		return soapFactory;
	}

	public void setSoapFactory(SOAPFactory soapFactory) {
		this.soapFactory = soapFactory;
	}

	public MessageFactory getMessageFactory() {
		return messageFactory;
	}

	public void setMessageFactory(MessageFactory messageFactory) {
		this.messageFactory = messageFactory;
	}
	
	public URL getEndPointURL() {
		return endPointURL;
	}

	public void setEndPointURL(URL endPointURL) {
		this.endPointURL = endPointURL;
	}
	
	public SOAPConnection getSoapConnection() {
		return soapConnection;
	}

	public void setSoapConnection(SOAPConnection soapConnection) {
		this.soapConnection = soapConnection;
	}

	public XPath getxPath() {
		return xPath;
	}

	public void setxPath(XPath xPath) {
		this.xPath = xPath;
	}

	public boolean isHasMultipleChildRootInResponse() {
		return hasMultipleChildRootInResponse;
	}

	public void setHasMultipleChildRootInResponse(
			boolean hasMultipleChildRootInResponse) {
		this.hasMultipleChildRootInResponse = hasMultipleChildRootInResponse;
	}

	public List<String> getRootChildrenInResponse() {
		return rootChildrenInResponse;
	}

	public void setRootChildrenInResponse(List<String> rootChildrenInResponse) {
		this.rootChildrenInResponse = rootChildrenInResponse;
	}

	public boolean isCreateEmptyElementsInOutputWhenXPathNotFound() {
		return createEmptyElementsInOutputWhenXPathNotFound;
	}

	public void setCreateEmptyElementsInOutputWhenXPathNotFound(
			boolean createEmptyElementsInOutputWhenXPathNotFound) {
		this.createEmptyElementsInOutputWhenXPathNotFound = createEmptyElementsInOutputWhenXPathNotFound;
	}

}
