package com.mootly.wcm.services.y2012_2013;

import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.services.ITR1XmlGeneratorService;
import com.mootly.wcm.services.ITR2XmlGeneratorService;
import com.mootly.wcm.services.ITRXmlGeneratorServiceCommon;
import com.mootly.wcm.services.XmlGeneratorService;

public class ITRXmlGeneratorService extends ITRXmlGeneratorServiceCommon  implements XmlGeneratorService {
	private static Logger log = LoggerFactory.getLogger(ITRXmlGeneratorService.class);
	@Override
	public void generateXml(HstRequest request,HstResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.generateXml(request, response);
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR1")){
			ITR1XmlGeneratorService.generateITR1(request, response);
		}
		if(memberPersonalInformation.getFlexField("flex_string_ITRForm", "").equals("ITR2")){
			ITR2XmlGeneratorService.generateITR2(request, response);
		}

	}

}
