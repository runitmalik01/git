package com.mootly.wcm.components;

import java.text.DateFormat;

import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstRequest;

import com.mootly.wcm.member.Member;

public interface ITReturnScreen {

	 public enum PAGE_ACTION {DEFAULT,NEW,EDIT,DELETE,SAVE,NEW_CHILD,EDIT_CHILD,SAVE_CHILD,DELETE_CHILD,SHOW_ITR_SUMMARY,DOWNLOAD_ITR_XML,DOWNLOAD_ITR_SUMMARY,EMAIL_ITR_XML_AND_SUMMARY};

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
