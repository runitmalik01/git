package com.mootly.wcm.services.ditws.soap;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeader;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.NotWritablePropertyException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class SOAPCallWrapperHelper {
	final static Logger logger = LoggerFactory.getLogger(SOAPCallWrapperHelper.class);
	
	public static SOAPMessage createSOAPMessage(SOAPCallWrapper soapCallWrapper,List<Map<String,String>> inputParams) throws SOAPException  {
		SOAPFactory soapFactory = soapCallWrapper.getSoapFactory();
		MessageFactory messageFactory = soapCallWrapper.getMessageFactory();
		List<MimeHeader> mimeHeaders = soapCallWrapper.getMimeHeaders();
		List<SOAPCallElement> soapHeadChildren = soapCallWrapper.getHeadChildren();
		SOAPCallElement soapBodyElement = soapCallWrapper.getSoapBodyElement();
		List<SOAPCallElement> soapBodyChildren = soapCallWrapper.getBodyChildren();
		boolean isDetachHeader = soapCallWrapper.isDetachHeader();
		Map<String,String> inputElementMap = soapCallWrapper.getInputElementMap();
		
		logger.debug("Initializing...");
		SOAPMessage soapMessage;
		soapMessage = messageFactory.createMessage();
		
		MimeHeaders hd = soapMessage.getMimeHeaders();
		if ( mimeHeaders != null) {
			for(MimeHeader mimeHeader:mimeHeaders) {
				hd.addHeader(mimeHeader.getName(), mimeHeader.getValue());
			}
		}
		hd.addHeader("SOAPAction", "");
		SOAPHeader header = soapMessage.getSOAPHeader();
		if (soapCallWrapper.getNameSpaceDeclarations() != null) {
			for (SOAPCallNameSpaceDeclaration nameSpaceDeclaration:soapCallWrapper.getNameSpaceDeclarations()) {
				header.addNamespaceDeclaration(nameSpaceDeclaration.getPrefix(), nameSpaceDeclaration.getUri());
			}
		}
		SOAPBody body = soapMessage.getSOAPBody();
		if (isDetachHeader) header.detachNode();
		//it is very much possible that we don't have a body element just the children
		SOAPBodyElement bodyElement =null;
		if (soapBodyElement != null) {
			Name bodyName = soapFactory.createName(soapBodyElement.getName(),soapBodyElement.getNsPrefix(),soapBodyElement.getNs());		
			bodyElement = body.addBodyElement(bodyName);
		}
		if (bodyElement != null) {
			addRestOfTheChildren(soapFactory, bodyElement, soapBodyChildren,inputElementMap, inputParams);
		}
		else {
			addRestOfTheChildren(soapFactory, body, soapBodyChildren,inputElementMap, inputParams);
		}
		
		if (soapHeadChildren != null && soapHeadChildren.size() > 0 ) {
			Map<String,String> tmpI = new HashMap<String, String>();
			List<Map<String,String>> tmpM = new ArrayList<Map<String,String>>(1);
			tmpM.add(tmpI);
			addRestOfTheChildren(soapFactory, header, soapHeadChildren,inputElementMap, tmpM);//we don't want it to repeat
		}				
		return soapMessage;
	}
	
	protected static void addRestOfTheChildren(SOAPFactory soapFactory,SOAPElement currentParent,List<SOAPCallElement> children,Map<String,String> inputElementMap,List<Map<String,String>> inputParams) throws SOAPException{
		Stack<SOAPElement> parentStack = new Stack<SOAPElement>();		
		for (Map<String,String> anInputParam:inputParams) {
			for (Iterator<SOAPCallElement> itSoapCallElement = children.iterator();itSoapCallElement.hasNext(); ) {
				SOAPCallElement el = itSoapCallElement.next();		
				SOAPElement soapWrapElement = null;
				
				if (el.getSoapCallElementType() == SOAPCallElementType.START_ELEMENT) {
					soapWrapElement = soapFactory.createElement(el.getName(), el.getNsPrefix(), el.getNs());
					SOAPElement newChild = currentParent.addChildElement(soapWrapElement);
					parentStack.push(currentParent);
					currentParent = newChild;
				}
				else if (el.getSoapCallElementType() == SOAPCallElementType.END_ELEMENT) {
					currentParent = parentStack.pop();
				}
				else if (el.getSoapCallElementType() == SOAPCallElementType.TEXT_ELEMENT && el.getValue() != null) {	
					if (el.getNsPrefix() != null && el.getNs() != null) {
						soapWrapElement = soapFactory.createElement(el.getName(), el.getNsPrefix(), el.getNs());
					}
					else { 
						soapWrapElement = soapFactory.createElement(el.getName());
					}
					/*
					if (inputElementMap != null && inputElementMap.containsKey(el.getName())) {
						if (anInputParam != null && anInputParam.containsKey(inputElementMap.get(el.getName()))) {
							soapWrapElement.addTextNode((String) anInputParam.get(inputElementMap.get(el.getName())));
						}else {
							soapWrapElement.addTextNode(el.getValue());
						}
					}
					else {
						soapWrapElement.addTextNode(el.getValue());
					}	
					*/
					if (anInputParam != null && anInputParam.containsKey(el.getName())) {
						soapWrapElement.addTextNode((String) anInputParam.get(el.getName()));
					}else {
						soapWrapElement.addTextNode(el.getValue());
					}
					if (el.getSoapCallElementAttributes() != null){
						for (SOAPCallElementAttribute soapCallElementAttribute:el.getSoapCallElementAttributes()) {
							soapWrapElement.addAttribute(soapCallElementAttribute.getName(), soapCallElementAttribute.getValue());
						}						
					}
					currentParent.addChildElement(soapWrapElement);
				}			
			}
		}		
	}
	
	public static Map<String,Object> parseSOAPResponse(SOAPMessage soapResponse,SOAPCallWrapper soapCallWrapper) throws XPathExpressionException,SOAPException {
		Map<String,Object> outputMap = new HashMap<String, Object>();
		//for ( Iterator it =soapResponse.getAttachments();it.hasNext();){
		//	AttachmentPart attachmentPart = (AttachmentPart) it.next();
		//	logger.debug( "ATTACHMENT:" + attachmentPart.getContent() );
		//}
		if (logger.isDebugEnabled()) {
			SOAPBody theSOAPBody = soapResponse.getSOAPBody();
			Iterator it = theSOAPBody.getChildElements();
			for (;it.hasNext();) {
				Object o = it.next();
				logger.debug(o.toString() + ":" + o.getClass().getName());
			}
		}
		if (soapCallWrapper.isHasMultipleChildRootInResponse() && soapCallWrapper.getRootChildrenInResponse() != null) {			
			for (String aChildResponseKey:soapCallWrapper.getRootChildrenInResponse()) {
				NodeList theNodeList = soapResponse.getSOAPBody().getElementsByTagNameNS(soapCallWrapper.getSoapBodyElement().getNs(), aChildResponseKey);
				Node parentNode = null;// (Node) xPathExpression.evaluate(soapResponse.getSOAPBody() ,XPathConstants.NODE);
				for (int i=0;i<theNodeList.getLength();i++) {
					if (logger.isDebugEnabled()) {
						logger.debug(theNodeList.item(i).getLocalName());
					}
					if (theNodeList.item(i).getLocalName().equalsIgnoreCase(aChildResponseKey)) {
						parentNode = theNodeList.item(i);
						break;
					}
				}
				if (parentNode != null) {
					Map<String,Object> theLocalMap = parseSOAPResponseWithOutputKeys(soapResponse,soapCallWrapper,parentNode);
					outputMap.put(aChildResponseKey,theLocalMap);
				}
			}				
		}
		else {
			outputMap = parseSOAPResponseWithOutputKeys(soapResponse,soapCallWrapper,null);
		}
		return outputMap;
	}
	
	public static Map<String,Object> parseSOAPResponseWithOutputKeys(SOAPMessage soapResponse,SOAPCallWrapper soapCallWrapper,Object xPathScope) throws XPathExpressionException,SOAPException {
		Map<String,Object> outputMap = new HashMap<String, Object>();
		if (xPathScope == null) {
			xPathScope = soapResponse.getSOAPBody();
		}
		for (String mapKey:soapCallWrapper.getOutputElementMap().keySet()) {
			//this means we need to generate hashtable with value as list not as string
			if (soapCallWrapper.isResponseRepeatingMultipleTimes()) {
				//Node parentNode = (Node) soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), soapResponse.getSOAPBody(),XPathConstants.NODE);
				NodeList nodeList = (NodeList) soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), xPathScope ,XPathConstants.NODESET);
				if (nodeList != null && nodeList.getLength() > 0) {
					List<String> linkedList = new LinkedList<String>();
					for (int i=0;i<nodeList.getLength();i++) {
						Element anElement = (Element) nodeList.item(i);
						linkedList.add(anElement.getTextContent());
					}
					outputMap.put(mapKey, linkedList);
				}
			}			
			else {
				String value = soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), xPathScope );
				outputMap.put(mapKey, value);
			}			
		}
		//final check if any value is missing just put a blank space
		if (soapCallWrapper.isCreateEmptyElementsInOutputWhenXPathNotFound()) {
			for (String mapKey:soapCallWrapper.getOutputElementMap().keySet()) {
				if (outputMap != null && !outputMap.containsKey(mapKey)) outputMap.put(mapKey, "");
			}
		}
		return outputMap;
	}
	
	public final static <T> List<T> getInstanceFromSOAPMap(Class<T> inClass,Map<String,List<String>> theMap) throws InstantiationException, IllegalAccessException {			
		if (theMap == null || theMap.size() == 0) return null;
		
		List<T> listOfReturnObjects = new ArrayList<T>();
		@SuppressWarnings("unchecked")
		String theFirstKeyToCheck = (String) theMap.keySet().toArray()[0];
		List<String> theFirstListToCheck = (List<String>) theMap.get(theFirstKeyToCheck);
				
		int total = theFirstListToCheck.size();
		
		for (int i=0;i<total;i++) {
			T theInstance = inClass.newInstance();
			for (String theProperty:theMap.keySet()) {
				if (logger.isInfoEnabled()) {
					logger.info("The KEY is:" + theProperty);				
				}
				String theMethodToFind =  "set" + StringUtils.capitalize(theProperty);
				try {
					List<String> theValues = theMap.get(theProperty);
					String theValueToSet = theValues.get(i);
					Method theSetter = theInstance.getClass().getMethod(theMethodToFind,String.class);
					if (logger.isInfoEnabled()) {
						logger.info("Found the setter :" + theSetter);
					}					
					DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(theInstance);
					directFieldAccessor.setPropertyValue(theProperty, theValueToSet);					
				}catch (NoSuchMethodException nfe) {
					logger.warn(theMethodToFind + " does not exist in the bean check it out");
					logger.error("Error in nfe",nfe);
				} catch (NotWritablePropertyException npe) {
					logger.error("Error in NPE",npe);
				}
			}
			listOfReturnObjects.add(theInstance);
		}
		return listOfReturnObjects;
	}
	
	/**
	 * When there is just one instance 
	 * @param inClass
	 * @param theMap
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public final static <T> T getInstanceFromSOAPMapSingleInstance(Class<T> inClass,Map<String,Object> theMap) throws InstantiationException, IllegalAccessException {			
		if (theMap == null || theMap.size() == 0) return null;
		
		T theInstance = inClass.newInstance();
		for (String theProperty:theMap.keySet()) {
			if (logger.isInfoEnabled()) {
				logger.info("The KEY is:" + theProperty);				
			}
			String theMethodToFind =  "set" + StringUtils.capitalize(theProperty);
			try {
				String theValueToSet = (String) theMap.get(theProperty);
				Method theSetter = theInstance.getClass().getMethod(theMethodToFind,String.class);
				if (logger.isInfoEnabled()) {
					logger.info("Found the setter :" + theSetter);
				}					
				DirectFieldAccessor directFieldAccessor = new DirectFieldAccessor(theInstance);
				directFieldAccessor.setPropertyValue(theProperty, theValueToSet);					
			}catch (NoSuchMethodException nfe) {
				logger.warn(theMethodToFind + " does not exist in the bean check it out");
				logger.error("Error in nfe",nfe);
			} catch (NotWritablePropertyException npe) {
				logger.error("Error in NPE",npe);
			}
		}
		return theInstance;
	}
}
