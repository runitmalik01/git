package com.mootly.wcm.validation.impl.itr.audit;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.xml.ws.soap.SOAPFaultException;

import org.hippoecm.hst.component.support.forms.FormField;
import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.DITResponseDocument;
import com.mootly.wcm.beans.MemberPersonalInformation;
import com.mootly.wcm.beans.compound.DITResponseDocumentDetail;
import com.mootly.wcm.channels.WebsiteInfo;
import com.mootly.wcm.components.ITReturnScreen;
import com.mootly.wcm.components.ITReturnScreen.PAGE_ACTION;
import com.mootly.wcm.model.DITSubmissionStatus;
import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.model.VerificationStatus;
import com.mootly.wcm.services.ditws.RetrieveITRVStatusByTokenAndPAN;
import com.mootly.wcm.services.ditws.model.RetrieveITRVStatusResponse;
import com.mootly.wcm.validation.HippoBeanValidationGeneric;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.ACTION;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.ACTION_REASON;
import com.mootly.wcm.validation.HippoBeanValidationGeneric.TYPE;
import com.mootly.wcm.validation.HippoBeanValidationResponse;
import com.mootly.wcm.validation.HippoBeanValidator;
import com.mootly.wcm.validation.RepositoryUpdateRequest;

/**
 * <ns2:result><![CDATA[<STATUSRESPONSE><STATUS><PAN>AWBPR0486J</PAN><ACK>860562120080114</ACK><MESSAGE>Success</MESSAGE><ERROR_CODE>null</ERROR_CODE><ERROR_MESSAGE>null</ERROR_MESSAGE></STATUS></STATUSRESPONSE>]]></ns2:result>

 * @author Amit
 *
 */
public class ValidateEfileStatus implements HippoBeanValidator {
	Logger logger = LoggerFactory.getLogger(ValidateEfileStatus.class);
	
	RetrieveITRVStatusByTokenAndPAN retrieveITRVStatusByTokenAndPAN;
	
	public RetrieveITRVStatusByTokenAndPAN getRetrieveITRVStatusByTokenAndPAN() {
		return retrieveITRVStatusByTokenAndPAN;
	}

	public void setRetrieveITRVStatusByTokenAndPAN(
			RetrieveITRVStatusByTokenAndPAN retrieveITRVStatusByTokenAndPAN) {
		this.retrieveITRVStatusByTokenAndPAN = retrieveITRVStatusByTokenAndPAN;
	}

	@Override
	public boolean validate(FinancialYear financialYear, ITReturnScreen.PAGE_ACTION pageAction, Map<String,HippoBean> mapOfBeans,Map<String,Object> additionalData,Annotation[] annotations, HippoBeanValidationResponse response) {
		if ( response == null ) response = new HippoBeanValidationResponse();
		
		MemberPersonalInformation memberPersonalInformation = (MemberPersonalInformation) mapOfBeans.get(MemberPersonalInformation.class.getSimpleName().toLowerCase());
		DITResponseDocument ditResponseDocument = (DITResponseDocument) mapOfBeans.get(DITResponseDocument.class.getSimpleName().toLowerCase());
		
		if (memberPersonalInformation == null || ditResponseDocument == null) {
			return true; //no point even moving forward if any of the document is null
		}
		
		//if not then check if there is any document with submitITReturn 
		Integer totalAttemptsToEfile = ditResponseDocument.getTotalCountOfOperation("submitITR");
		if (totalAttemptsToEfile != null && totalAttemptsToEfile > 0 ) {
			//now the fun begins if there is an efile attempt make sure to get the noticeNumber and then check if verificationStatus is either null or UNVERIFIED
			//call DIT and get ITRV status by notice number if success or failure (if we receive a response from DIT then the next step is to make sure the record is modified with proper update
			//and also we need to update MEMBER PERSONAL INFORMATION, the alreadyEfile
			
			//loop and see which one r not verified
			for (DITResponseDocumentDetail ditResponseDocumentDetail:ditResponseDocument.getDitResponseDocumentDetails()) {
				try {
					if (ditResponseDocumentDetail.getSoapOperation() == null || !"submitITR".equalsIgnoreCase(ditResponseDocumentDetail.getSoapOperation())) {
						continue;
					}
					String childUuid = ditResponseDocumentDetail.getCanonicalUUID();
					Node theNode = ditResponseDocumentDetail.getNode();
					String certChain = null;
					String signature = null;
					String PAN = null;
					String tokenID = null;
					String ackResponse = null;
					String eFileDateTime   = null;
					if ( theNode != null) {
						if (theNode.hasProperty("mootlywcm:certChain")) {
							certChain = theNode.getProperty("mootlywcm:certChain").getString();
						}
						if (theNode.hasProperty("mootlywcm:signature")) {
							signature = theNode.getProperty("mootlywcm:signature").getString();
						}
						if (theNode.hasProperty("mootlywcm:PAN")) {
							PAN = theNode.getProperty("mootlywcm:PAN").getString();
						}
						if (theNode.hasProperty("mootlywcm:result")) {
							tokenID = theNode.getProperty("mootlywcm:result").getString();
						}
						if (theNode.hasProperty("mootlywcm:ackResponse")) {
							ackResponse = theNode.getProperty("mootlywcm:ackResponse").getString();
						}
						if (theNode.hasProperty("mootlywcm:eFileDateTime")) {
							eFileDateTime = theNode.getProperty("mootlywcm:eFileDateTime").getString();
						}
						String verificationStatus = null;
						if (theNode.hasProperty("mootlywcm:verificationStatus")) verificationStatus = theNode.getProperty("mootlywcm:verificationStatus").getString();
						if (verificationStatus != null && !"".equals(verificationStatus.trim()) && VerificationStatus.VERIFIED.name().equals(verificationStatus)) {
							//lets check what else is for us, now check eFileSubmissionStatus if its success then we are good
							if (theNode.hasProperty("mootlywcm:ditSubmissionStatus")) {
								String ditSubmissionStatus = theNode.getProperty("mootlywcm:ditSubmissionStatus").getString();
								if (ditSubmissionStatus != null && ditSubmissionStatus.equals(DITSubmissionStatus.SUCCESS.name())) {
									//this means the user cannot modify the record any more and we should redirect the user to efile-confirmation page with proper details
									response.addMessage(new HippoBeanValidationGeneric("ditSubmissionStatus",DITSubmissionStatus.SUCCESS.name(),TYPE.INFORMATION));
									if (ackResponse != null) response.addMessage(new HippoBeanValidationGeneric("ackResponse",ackResponse,TYPE.INFORMATION));
									if (tokenID != null) response.addMessage(new HippoBeanValidationGeneric("tokenNumber",tokenID,TYPE.INFORMATION));
									if (eFileDateTime != null) response.addMessage(new HippoBeanValidationGeneric("eFileDateTime",eFileDateTime,TYPE.INFORMATION));
									response.addAction(ACTION.FREEZE_INCOMETAX_RETURN,ACTION_REASON.SUCCESSFUL_SUBMISSION);
								}
							}
						} else {
							//we must CALL DIT and query the status of eFile using the notice number
							WebsiteInfo websiteInfo = null;
							if (additionalData != null && additionalData.containsKey("webSiteInfo")) {
								websiteInfo = (WebsiteInfo) additionalData.get("webSiteInfo");
							}
							if (getRetrieveITRVStatusByTokenAndPAN()!= null && websiteInfo != null) {
								FormMap childFormMap = new FormMap();
								try {
									RetrieveITRVStatusResponse retrieveITRVStatusResponse = getRetrieveITRVStatusByTokenAndPAN().retrieveITRVByTokenAndPAN(websiteInfo.getEriUserId(), websiteInfo.getEriPassword(), certChain, signature, tokenID, PAN, null, null);
									if ( retrieveITRVStatusResponse != null ) {
										ackResponse = retrieveITRVStatusResponse.getAck();
										String messageResponse = retrieveITRVStatusResponse.getMessage();
										String panResponse = retrieveITRVStatusResponse.getPAN();
										if (messageResponse != null && messageResponse.equalsIgnoreCase("SUCCESS") && panResponse != null && panResponse.equalsIgnoreCase(PAN)) {
											//we need to make sure we update this row and and ensure the VERIFIED is set for next check
											
											FormField frmField = new FormField("ackResponse");
											frmField.addValue(ackResponse);
											childFormMap.addFormField(frmField);
											
											FormField frmField2 = new FormField("verificationStatus");
											frmField2.addValue(VerificationStatus.VERIFIED.name());
											childFormMap.addFormField(frmField2);
											
											FormField frmField3 = new FormField("ditSubmissionStatus");
											frmField3.addValue(DITSubmissionStatus.SUCCESS.name());
											childFormMap.addFormField(frmField3);
											
											
											if (ackResponse != null) response.addMessage(new HippoBeanValidationGeneric("ackResponse",ackResponse,TYPE.INFORMATION));
											if (tokenID != null) response.addMessage(new HippoBeanValidationGeneric("tokenNumber",tokenID,TYPE.INFORMATION));
											if (eFileDateTime != null) response.addMessage(new HippoBeanValidationGeneric("eFileDateTime",eFileDateTime,TYPE.INFORMATION));
											
											response.addAction(ACTION.FREEZE_INCOMETAX_RETURN,ACTION_REASON.SUCCESSFUL_SUBMISSION);
										}
										else {
											//we now should set to be VERIFIED and let the USER make more changes as it was not a successful transmission
											FormField frmField2 = new FormField("verificationStatus");
											frmField2.addValue(VerificationStatus.VERIFIED.name());
											childFormMap.addFormField(frmField2);
										}
									}
								}catch (SOAPFaultException e) {
									logger.error("Error",e);
									 //we still want to save and set VERIFIED
									//FormField frmField2 = new FormField("verificationStatus");
									//frmField2.addValue(VerificationStatus.VERIFIED.name());
									//childFormMap.addFormField(frmField2);
									response.addAction(ACTION.FREEZE_INCOMETAX_RETURN,ACTION_REASON.VERIFICATION_PENDING);
								}catch (Exception e) {
									logger.error("Error",e);
									 //we still want to save and set VERIFIED
									//FormField frmField2 = new FormField("verificationStatus");
									//frmField2.addValue(VerificationStatus.VERIFIED.name());
									//childFormMap.addFormField(frmField2);
									response.addAction(ACTION.FREEZE_INCOMETAX_RETURN,ACTION_REASON.VERIFICATION_PENDING);
								}
								//we will save this info 
								//,final String parentBeanAbsolutePath,final String parentBeanNameSpace,final String parentBeanNodeName
								if (childFormMap != null && childFormMap.getFormMap().size() > 0 ) {
									RepositoryUpdateRequest repositoryUpdateRequest = new RepositoryUpdateRequest(PAGE_ACTION.EDIT_CHILD, null, childFormMap, DITResponseDocument.class, DITResponseDocumentDetail.class, childUuid, ditResponseDocument.getPath(),"mootlywcm:ditResponseDocument",ditResponseDocument.getName());
									response.addRepositoryUpdateRequest(repositoryUpdateRequest);
								}
							}
						}
					}
				} catch (RepositoryException e) {
					// TODO Auto-generated catch block
					logger.error("Error",e);
				}
			}
		}
		return true;
	}

}
