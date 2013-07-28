package com.mootly.wcm.services;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.ValidationResponse;

public class ITRXmlGeneratorServiceCommon implements XmlGeneratorService {

	@Override
	public String generateXml(HstRequest request, HstResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ValidationResponse validateXml(String xml) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidationResponse validateXml(InputStream inputStream)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> generateXml(FinancialYear financialYear,
			Map<String, HippoBean> inputBeans) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConsolidateReturnsToBulk(List<Object> listOfItrForms) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
