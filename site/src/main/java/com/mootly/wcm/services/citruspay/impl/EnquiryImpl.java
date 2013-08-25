package com.mootly.wcm.services.citruspay.impl;

import java.net.HttpURLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.model.FinancialYear;
import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.Transaction;
import com.mootly.wcm.services.citruspay.model.TransactionInput;
import com.mootly.wcm.services.http.HTTPConnectionException;
import com.mootly.wcm.services.http.HTTPConnectionService;

/**
 * Final Implementation of Transaction Service
 * @author admin
 *
 */
public class EnquiryImpl extends PaymentServiceXML implements Enquiry, ApplicationContextAware {
	
	final Logger logger = LoggerFactory.getLogger(EnquiryImpl.class);
	//XPath xPath;
	ApplicationContext applicationContext;
	HTTPConnectionService httpConnectionService;
	
	String endPointURL_Enquiry;
	
	public final HTTPConnectionService getHttpConnectionService() {
		return httpConnectionService;
	}

	public final void setHttpConnectionService(
			HTTPConnectionService httpConnectionService) {
		this.httpConnectionService = httpConnectionService;
	}

	public HttpURLConnection getHttpUrlConnection(String transactionId) {
		String theFinalURL = endPointURL_Enquiry + "/" + transactionId;		
		HttpURLConnection theReturnValue = (HttpURLConnection) applicationContext.getBean("enquiryServiceHTTPConnection", theFinalURL);
		return theReturnValue;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

	@Override
	public Map<String, Object> doEnquiry(String transactionId) {
		// TODO Auto-generated method stub
		HttpURLConnection theURLConnection = getHttpUrlConnection(transactionId);
		try {
			httpConnectionService.doGet(getHeaders(), transactionId, theURLConnection);
		} catch (HTTPConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public final String getEndPointURL_Enquiry() {
		return endPointURL_Enquiry;
	}

	public final void setEndPointURL_Enquiry(String endPointURL_Enquiry) {
		this.endPointURL_Enquiry = endPointURL_Enquiry;
	}
	
}
