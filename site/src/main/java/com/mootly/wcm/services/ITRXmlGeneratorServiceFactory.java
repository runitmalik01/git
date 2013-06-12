package com.mootly.wcm.services;

import java.util.Map;

import com.mootly.wcm.model.FinancialYear;

public class ITRXmlGeneratorServiceFactory {
	
	Map<String, XmlGeneratorService> xmlGeneratorServicesMap = null;
	
	public ITRXmlGeneratorServiceFactory(Map<String, XmlGeneratorService> xmlGeneratorServicesMap) {
		this.xmlGeneratorServicesMap = xmlGeneratorServicesMap;
	}
	
	public XmlGeneratorService getInstance(FinancialYear financialYear) {
		if (xmlGeneratorServicesMap.containsKey(financialYear.toString())) {
				return xmlGeneratorServicesMap.get(financialYear.toString());
		}
		return null;
	}
}
