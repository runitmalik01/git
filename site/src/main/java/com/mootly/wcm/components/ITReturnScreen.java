package com.mootly.wcm.components;

import java.text.DateFormat;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;

import com.mootly.wcm.member.Member;

public interface ITReturnScreen {

	 public enum PAGE_ACTION {
		 DEFAULT,
		 NEW,EDIT,DELETE,SAVE,NEW_CHILD,EDIT_CHILD,SAVE_CHILD,DELETE_CHILD,
		 SHOW_ITR_ERRORS_WARNINGS,SHOW_ITR_EFILE_HISTORY,SHOW_ITR_SUMMARY,DOWNLOAD_ITR_XML,DOWNLOAD_ITR_SUMMARY,DOWNLOAD_ITR_PDF,DOWNLOAD_ITR_JSON,EMAIL_ITR_XML_AND_SUMMARY,
		 DOWNLOAD_ITR_XML_BULK_ADD_TO_SESSION,DOWNLOAD_ITR_XML_BULK,
		 COPY_ORIGINAL_TO_REVISED,
		 RETRIEVE_ITRV_STATUS,RETRIEVE_ITRV_BY_ACKNO,RETRIEVE_ITRV_BY_TOKENNO,SYNC_TDS_FROM_DIT, RETRIEVE_REFUND_STATUS, RETRIEVE_RECTIFICATION_STATUS,
		 EFILE,EFILE_CONFIRMATION};
	 public enum PAGE_OUTPUT_FORMAT {HTML,XML,JSON};

	 String getAssessmentYear() throws InvalidNavigationException; ;
	 String getMemberUserName() throws InvalidNavigationException; ; //this should simply return the username which is the email address
	 String getNormalizedMemberEmail() throws InvalidNavigationException; ; //this will convert @ to -at-
	 String getPAN() throws InvalidNavigationException; //PAN number either extract from REQUEST URL or from session
	 Member getMember() throws InvalidNavigationException;

	 String getRelBasePathToReturnDocuments() throws InvalidNavigationException;
	 String getAbsoluteBasePathToReturnDocuments() throws InvalidNavigationException;

	 HippoBean getParentBean();

	 Class<? extends HippoBean>  getParentBeanClass();
	 String getParentBeanNodeName(); //what is the node name of the parent bean if exists or if saved what it should be
	 String getParentBeanPath(); // where is the parent bean stored and
	 String getParentBeanNameSpace(); //whats is the namespace of the parent bean

	 String getNextScreenSiteMapItemRefId();
	 String getPrevScreenSiteMapItemRefId();

	 PAGE_ACTION getPageAction();
	 PAGE_OUTPUT_FORMAT getPageOutputFormat();
	 boolean hasNextScreen();
	 boolean hasPrevScreen();
	 boolean isLastScreen();

	 //boolean beforeSave(HstRequest request);
	 //void afterSave(HstRequest request);

	 ScreenAction getScreenAction();
	 //dateFormatter
	 DateFormat getDateFormatter();

	 void setPAN(HstRequest request, String pan);
}
