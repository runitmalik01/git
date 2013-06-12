package com.mootly.wcm.services;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;

public interface XmlGeneratorService {
	void generateXml(HstRequest request,HstResponse response) throws Exception;
}
