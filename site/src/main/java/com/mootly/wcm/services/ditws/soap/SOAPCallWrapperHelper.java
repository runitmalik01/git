package com.mootly.wcm.services.ditws.soap;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		for (String mapKey:soapCallWrapper.getOutputElementMap().keySet()) {
			//this means we need to generate hashtable with value as list not as string
			if (soapCallWrapper.isResponseRepeatingMultipleTimes() && soapCallWrapper.getOutputParentElement() != null) {
				Node parentNode = (Node) soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), soapResponse.getSOAPBody(),XPathConstants.NODE);
				NodeList nodeList = (NodeList) soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), soapResponse.getSOAPBody(),XPathConstants.NODESET);
				if (nodeList != null) {
					List<String> linkedList = new LinkedList<String>();
					for (int i=0;i<nodeList.getLength();i++) {
						Element anElement = (Element) nodeList.item(i);
						linkedList.add(anElement.getTextContent());
					}
					outputMap.put(mapKey, linkedList);
				}
			}
			else {
				String value = soapCallWrapper.getxPath().evaluate(soapCallWrapper.getOutputElementMap().get(mapKey), soapResponse.getSOAPBody());
				outputMap.put(mapKey, value);
			}			
		}
		//final check if any value is missing just put a blank space
		for (String mapKey:soapCallWrapper.getOutputElementMap().keySet()) {
			if (outputMap != null && !outputMap.containsKey(mapKey)) outputMap.put(mapKey, "");
		}
		return outputMap;
	}
}
