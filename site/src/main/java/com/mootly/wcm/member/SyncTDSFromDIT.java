package com.mootly.wcm.member;


import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.annotations.RequiredBeans;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.components.ITReturnComponent;
import com.mootly.wcm.services.ditws.Retrieve26ASInformation;
import com.mootly.wcm.services.ditws.exception.DataMismatchException;
import com.mootly.wcm.services.ditws.exception.InvalidFormatException;
import com.mootly.wcm.services.ditws.exception.MissingInformationException;
import com.mootly.wcm.services.ditws.model.Twenty26ASResponse;

@RequiredBeans (requiredBeans={MemberPersonalInformation.class})  //this bean must be present before we do any thing
public class SyncTDSFromDIT extends ITReturnComponent {
	private static final Logger logger = LoggerFactory.getLogger(SyncTDSFromDIT.class);
	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub
		super.doBeforeRender(request, response);
		Retrieve26ASInformation retrieve26asInformation = getRetrieve26ASService();
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) request.getAttribute(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		if (memberPersonalInformation == null) {
			logger.warn("Personal Information is NULL for the following path " + request.getPathInfo());
			return;
		}
		try {
			Twenty26ASResponse twenty26asResponse = retrieve26asInformation.retrieve26ASInformation(memberPersonalInformation.getPAN(), memberPersonalInformation.getDOB() , getFinancialYear().getAssessmentYearForDITSOAPCall());
			request.setAttribute("twenty26asResponse", twenty26asResponse);
		} catch (MissingInformationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("Missing Information",e);
		} catch (DataMismatchException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DataMismatchException",e);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			logger.error("InvalidFormatException",e);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
	}
	

}
