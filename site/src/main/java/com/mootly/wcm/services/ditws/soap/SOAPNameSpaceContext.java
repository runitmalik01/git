package com.mootly.wcm.services.ditws.soap;

import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;


public class SOAPNameSpaceContext implements NamespaceContext {
	final Map<String,String> nameSpaceURIMap;
	final Map<String, String> prefixMap;
	
	public SOAPNameSpaceContext(Map<String,String> nameSpaceURIMap,Map<String, String> prefixMap) {
		this.nameSpaceURIMap = nameSpaceURIMap;
		this.prefixMap = prefixMap;
	}
	
	@Override
	public String getNamespaceURI(String prefix) {
        if (nameSpaceURIMap ==null || !nameSpaceURIMap.containsKey(prefix)) {
            return XMLConstants.NULL_NS_URI;
        }
        else {
        	return nameSpaceURIMap.get(prefix);
        }
    }

	@Override
	public String getPrefix(String namespace) {
		if (prefixMap ==null || !prefixMap.containsKey(namespace)) {
			return null;
        }
        else {
        	return prefixMap.get(namespace);
        }
    }

	@Override
	public Iterator getPrefixes(String namespace){
        return null;
    }

}
