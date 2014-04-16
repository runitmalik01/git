package com.mootly.wcm.services.sms.impl.netcore;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.services.http.HTTPConnectionException;
import com.mootly.wcm.services.http.HTTPConnectionService;
import com.mootly.wcm.services.sms.SMSProvider;


public class NetCoreSMSProviderByGET implements SMSProvider,  ApplicationContextAware {
	
	String feedId;
	String userName;
	String password;
	String senderId;
	
	ApplicationContext applicationContext;
	HTTPConnectionService httpConnectionService;

	final Logger logger = LoggerFactory.getLogger(NetCoreSMSProviderByGET.class);
	
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public HttpURLConnection getHttpUrlConnection() {
		return (HttpURLConnection) applicationContext
				.getBean("SMSByGETServiceHTTPConnection");
	}
	
	public String getQueryStringParameters(String to,String time,String mtype,String text) {
		StringBuffer sbq = new StringBuffer();
		String encodedText = text;
		try {
			encodedText = URLEncoder.encode(text, "UTF-8");
		}catch (UnsupportedEncodingException e) {
		}
		sbq.append("feedid=").append(feedId);
		sbq.append("&Username=").append(userName);
		sbq.append("&Password=").append(password);
		if (mtype != null && !"".equals(mtype.trim())) sbq.append("&mtype=").append(mtype);
		sbq.append("&Text=").append(encodedText);
		sbq.append("&To=").append(to);
		
		return sbq.toString();
	}
	
	@Override
	public void sendTextMessage(String mobileNumbers, String message,
			String expiryInMinutes, boolean isAsync) {
		// TODO Auto-generated method stub
		
		try {
			String queryStringParams = getQueryStringParameters(mobileNumbers,null,"1",message);
			String returnXml = httpConnectionService.doPost(null, queryStringParams, getHttpUrlConnection());
			if (logger.isInfoEnabled()) {
				logger.info(returnXml);
			}
		} catch (HTTPConnectionException e) {
			logger.error("Error in Transaction", e.getTheCompleteMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error in doPost", e);
		}
	}
	

	public final HTTPConnectionService getHttpConnectionService() {
		return httpConnectionService;
	}

	public final void setHttpConnectionService(
			HTTPConnectionService httpConnectionService) {
		this.httpConnectionService = httpConnectionService;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
