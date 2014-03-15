package com.mootly.wcm.admin.maintenance.jobs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jdo.identity.IntIdentity;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoDocumentBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.beans.MemberSignupDocument;
import com.mootly.wcm.components.BaseComponent;
import com.mootly.wcm.utils.GoGreenUtil;

@SuppressWarnings("all")
public class SendEmailToInactiveUsers extends BaseComponent {
	Logger log = LoggerFactory.getLogger(SendEmailToInactiveUsers.class);
	public static final String REMINDERSENT = "reminder_Sent";

	@Override
	public void doBeforeRender(HstRequest request, HstResponse response) {
		// TODO Auto-generated method stub

		super.doBeforeRender(request, response);
		
		if (log.isInfoEnabled()) {
			log.info("Do Before render of the SendEmailToInactiveUsers classs");
		}

		request.setAttribute(REMINDERSENT, request.getParameter(REMINDERSENT));

	}

	@Override
	public void doAction(HstRequest request, HstResponse response)
			throws HstComponentException {
		// TODO Auto-generated method stub
		super.doAction(request, response);
		if (log.isInfoEnabled()) {
			log.info("Do Action of the SendEmailToInactiveUsers classs");
		}
		// The given parameter are derived from console
		String maxDaysReminder = request.getRequestContext().getResolvedSiteMapItem().getParameter("maxDaysReminder");
		String minDaysReminder = request.getRequestContext().getResolvedSiteMapItem().getParameter("minDaysReminder");
		
		
		// taking input paramter value
		String sendReminder = GoGreenUtil.getEscapedParameter(request,"send_Reminder");
		
		if (sendReminder != null) {
			response.setRenderParameter(REMINDERSENT, "reminder_Sent");
		}

		HippoBean siteContentBasePath = getITRInitData(request)
				.getSiteContentBaseBeanForReseller(request).getBean("members");
		HstQuery hstQuery = null;
		try {
			hstQuery = this.getQueryManager(request).createQuery(
					siteContentBasePath);
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HstQueryResult hstQueryResult = null;
		try {
			hstQueryResult = hstQuery.execute();
		} catch (QueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<HippoBean> itResults = hstQueryResult.getHippoBeans();

		for (; itResults.hasNext();) {
			HippoBean hippoBean = itResults.next();
			if (hippoBean instanceof HippoDocumentBean) {
				if (hippoBean instanceof MemberSignupDocument) {
					if (hippoBean != null) {
						String userName = ((MemberSignupDocument) hippoBean)
								.getUserName();
						// Here we  will check the time for which the user exist 
						Calendar lstModDateOfDoc =hippoBean.getProperty("hippostdpubwf:lastModificationDate");
						Calendar currentDate = Calendar.getInstance();
						getAgeOfUserAccount(lstModDateOfDoc, currentDate);
						if(getAgeOfUserAccount(lstModDateOfDoc, currentDate) <= Integer.parseInt(maxDaysReminder) && getAgeOfUserAccount(lstModDateOfDoc, currentDate) >= Integer.parseInt(minDaysReminder) ){
							Boolean isActive = ((MemberSignupDocument) hippoBean).getIsActive();
							if (!isActive) {
								Map<String, Object> velocityContext = new HashMap<String, Object>();
								velocityContext.put("membershipSignupDocument",(MemberSignupDocument) hippoBean);
								sendEmail(request,new String[] { ((MemberSignupDocument) hippoBean).getEmail() }, null, null,"reminder_activation", velocityContext);

							}
						}

					}
				}
			}
		}

	}
	// This method will calculate the difference in days when the user has created account and current date
	
	private long getAgeOfUserAccount(Calendar userReg,Calendar currentDate) {
		
		Date userRegDate = userReg.getTime();
		Date currDate = currentDate.getTime();
		return (int)( (currDate.getTime() - userRegDate.getTime()) / (1000 * 60 * 60 * 24));	
	}
}
