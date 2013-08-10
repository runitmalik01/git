package com.mootly.wcm.services.ditws.soap;


import javax.xml.soap.SOAPBody;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public final class SOAPServiceHelper {
	
	
	
	public static final String getInnerText(SOAPBody soapBody,String nameSpaceURI,String elementName) {
		NodeList nodeList = soapBody.getElementsByTagNameNS( nameSpaceURI,elementName);
		if (nodeList == null || nodeList.getLength() == 0) return null;
		Node node = nodeList.item(0);
		if (node.getNodeType() != Node.ELEMENT_NODE) return null;
		return node.getTextContent();
	}
	
}
