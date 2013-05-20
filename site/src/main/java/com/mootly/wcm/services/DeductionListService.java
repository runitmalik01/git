package com.mootly.wcm.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.deduction.DeductionHead;
import com.mootly.wcm.model.deduction.DeductionSection;

public class DeductionListService {
	private final static Logger log = LoggerFactory.getLogger(DeductionListService.class);
	Map<FinancialYear, Map<String,DeductionSection>> deductionSectionMap;
	


	public DeductionListService () {
		deductionSectionMap = new LinkedHashMap<FinancialYear, Map<String,DeductionSection>>();
		
		//now for each active financial year
		for (FinancialYear financialYear:FinancialYear.values()) {
			if (!financialYear.isActive()) continue;
			Properties deductionSections = getDeductionProperties(financialYear, "sections");
			Properties deductionSectionHeads = getDeductionProperties(financialYear, "section-heads");
			if (deductionSections != null && deductionSectionHeads != null) {
				Map<String,DeductionSection> mapOfSectionNameToDeductionSection = parseDeductionSectionPropertyFile(deductionSections,deductionSectionHeads);
				//List<DeductionSection> listOfDeductions = (List<DeductionSection>) mapOfSectionNameToDeductionSection.entrySet().
				if (mapOfSectionNameToDeductionSection != null && mapOfSectionNameToDeductionSection.size() >0) {
					//sort list of deductions based on the 
					//Collections.sort(listOfDeductions,new DeductionSectionComparator());
					deductionSectionMap.put(financialYear, mapOfSectionNameToDeductionSection);
				}
			}
			//now sort the list of 
		}
		System.out.println("END");
	}

	public Map<FinancialYear, Map<String, DeductionSection>> getDeductionSectionMap() {
		return deductionSectionMap;
	}


	public void setDeductionSectionMap(
			Map<FinancialYear, Map<String, DeductionSection>> deductionSectionMap) {
		this.deductionSectionMap = deductionSectionMap;
	}


	protected Map<String,DeductionSection> parseDeductionSectionPropertyFile(Properties deductionSections,Properties deductionSectionHeads) {
		DeductionSection ds = null;
		DeductionHead dh = null;
		
		//lets get the active sections first
		String strSectionActiveList = deductionSections.getProperty("section.active.list");
		if (StringUtils.isEmpty(strSectionActiveList)) return null;
		String[] listOfActiveSections = strSectionActiveList.split("[,]");
		Map<String,DeductionSection> mapOfSectionNameToSectionList = new LinkedHashMap<String, DeductionSection>(listOfActiveSections.length);
		for (String anActiveSection:listOfActiveSections) {
			if (log.isInfoEnabled()) {
				log.info("Parsing Section:" + anActiveSection);
			}
			DeductionSection d  = new DeductionSection();
			d.setName(anActiveSection);
			mapOfSectionNameToSectionList.put(anActiveSection,d);
		}
		
		for (Object aKey:deductionSections.keySet()) {
			String strKey = (String)aKey;		
			if (strKey.equals("section.active.list")) continue;
			//the key is always the second part in the array
			String[] parts = strKey.split("[\\.]");
			if (parts.length < 3) continue;
			String theSectionName = parts[1];
			if (!mapOfSectionNameToSectionList.containsKey(theSectionName)) continue;
			DeductionSection d = mapOfSectionNameToSectionList.get(theSectionName);
			d.getAdditionalProperties().put(parts[2], deductionSections.getProperty(strKey));
			if (parts[2].equals("sectionheadlist")) {
				String[] validSectionHeads = deductionSections.getProperty(strKey).split("[,]");
				for (String aSectionHead:validSectionHeads) {
					String sectionHeadName = deductionSectionHeads.getProperty("sectionhead." + aSectionHead + ".name");
					String sectionHeadLabel = deductionSectionHeads.getProperty("sectionhead." + aSectionHead + ".label");
					if (sectionHeadName != null && sectionHeadLabel != null) d.getListOfDeductionHead().add(new DeductionHead(sectionHeadName,sectionHeadLabel));
				}
			}
		}
		return mapOfSectionNameToSectionList;
	}
	
	protected Properties getDeductionProperties(FinancialYear financialYear,String typeOf) {
		String fileName = "deduction-" + typeOf + "-" + financialYear.getDisplayName() + ".properties";
		Properties properties = null;
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/mootly/wcm/components/" + fileName);
		if (is == null) {
			is = this.getClass().getResourceAsStream(fileName);
		}
		if (is != null) {
			try {
				properties = new Properties();
				properties.load(is);
			}catch (Exception ex) {
				properties = null;
				log.warn("Error loading properties file from resource. Will attempt to load from CMS value list",ex);
			}
		}
		return properties;
	}
	
	public static void main(String[] args) {
		DeductionListService dl = new DeductionListService();
		
	}
	
	class DeductionSectionComparator implements Comparator<DeductionSection> {
		@Override
		public int compare(DeductionSection d1, DeductionSection d2) {
			// TODO Auto-generated method stub
			return d1.getDisplayOrder().compareTo(d2.getDisplayOrder());			
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
	}
}	
