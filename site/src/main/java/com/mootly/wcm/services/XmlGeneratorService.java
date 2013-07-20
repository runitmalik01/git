package com.mootly.wcm.services;

import java.io.File;
import java.io.InputStream;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

import com.mootly.wcm.model.ValidationResponse;

public interface XmlGeneratorService {
	String generateXml(HstRequest request,HstResponse response) throws Exception;
	
	//void validateXml(File file) throws Exception;
	ValidationResponse validateXml(String xml) throws Exception;
	ValidationResponse validateXml(InputStream inputStream) throws Exception;
}
