package com.mootly.wcm.services;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ValidationResponse;

public interface XmlGeneratorService {
	String generateXml(HstRequest request,HstResponse response) throws Exception;
	Map<String,Object> generateXml(FinancialYear financialYear,Map<String,HippoBean> inputBeans) throws Exception;
	
	String getConsolidateReturnsToBulk(List<Object> listOfItrForms);
	
	//void validateXml(File file) throws Exception;
	ValidationResponse validateXml(String xml) throws Exception;
	ValidationResponse validateXml(InputStream inputStream) throws Exception;
}
