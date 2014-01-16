package com.mootly.wcm.services.citruspay.impl;

import java.net.HttpURLConnection;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.mootly.wcm.services.citruspay.Enquiry;
import com.mootly.wcm.services.citruspay.model.enquiry.EnquiryResponse;
import com.mootly.wcm.services.citruspay.model.enquiry.TxnEnquiryResponse;
import com.mootly.wcm.services.http.HTTPConnectionException;
import com.mootly.wcm.services.http.HTTPConnectionService;
import com.opus.epg.sfa.java.PGResponse;
import com.opus.epg.sfa.java.PGSearchResponse;
import com.opus.epg.sfa.java.PostLib;

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
	
	String paysealMerchantId;
	String paysealNoResultMessage;
	String paysealNoResultCode;
	
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
	
	public final String getPaysealMerchantId() {
		return paysealMerchantId;
	}

	public final void setPaysealMerchantId(String paysealMerchantId) {
		this.paysealMerchantId = paysealMerchantId;
	}
	
	public final String getPaysealNoResultMessage() {
		return paysealNoResultMessage;
	}

	public final void setPaysealNoResultMessage(String paysealNoResultMessage) {
		this.paysealNoResultMessage = paysealNoResultMessage;
	}

	public final String getPaysealNoResultCode() {
		return paysealNoResultCode;
	}

	public final void setPaysealNoResultCode(String paysealNoResultCode) {
		this.paysealNoResultCode = paysealNoResultCode;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

	@Override
	public TxnEnquiryResponse doEnquiry(String transactionId) {
		// TODO Auto-generated method stub
		HttpURLConnection theURLConnection = getHttpUrlConnection(transactionId);
		try {
			String returnXml = httpConnectionService.doGet(getHeaders(), transactionId, theURLConnection);
			if (returnXml != null && !returnXml.trim().equals("")) {
				TxnEnquiryResponse enquiryOutput = TxnEnquiryResponse.loadFromXml(returnXml,new TxnEnquiryResponse());			
				if (logger.isInfoEnabled()) {
					logger.info("returnXml :" + returnXml);
					logger.info("returnXml :" + enquiryOutput.toString());
				}
				return enquiryOutput;
			}
		} catch (HTTPConnectionException e) {
			// TODO Auto-generated catch block
			logger.error("Error in HTTP Connection",e);
			//e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			logger.error("Error in JAXBException",e);
			//e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method is going to work with ICICI interface, we could have created separate methods but what the hack lets just do it here.
	 */
	
	@Override
	public TxnEnquiryResponse doEnquiryForCreditAndDebitCard(String transactionId) throws Exception {
		// TODO Auto-generated method stub
		com.opus.epg.sfa.java.Merchant oMerchant 	= new com.opus.epg.sfa.java.Merchant();
		PostLib oPostLib	= new PostLib();
		
		oMerchant.setMerchantOnlineInquiry(getPaysealMerchantId(), transactionId);
		PGSearchResponse pgSearchResponse = oPostLib.postStatusInquiry(oMerchant);
		
		if (pgSearchResponse != null && pgSearchResponse.getPGResponseObjects() != null && pgSearchResponse.getPGResponseObjects().size() > 0) {
			//convert these into the XML format this way the OLD way can work or just simply comvert them into response objects
			TxnEnquiryResponse txnEnquiryResponse = new TxnEnquiryResponse();
			for (Object pgResponseObj:pgSearchResponse.getPGResponseObjects()) {
				PGResponse pgResponse = (PGResponse) pgResponseObj;
				EnquiryResponse enquiryResponse = new EnquiryResponse();
				
				enquiryResponse.setRespCode(pgResponse.getRespCode());
				enquiryResponse.setRespMsg(pgResponse.getRespMessage());
				enquiryResponse.setTxnId(pgResponse.getTxnId());
				enquiryResponse.setTxnGateway(pgResponse.getEpgTxnId());
				
				enquiryResponse.setAuthIdCode(pgResponse.getAuthIdCode());
				enquiryResponse.setRRN(pgResponse.getRRN());
				enquiryResponse.setCvRespCode(pgResponse.getCVRespCode());
				
				enquiryResponse.setTxnType("SALE");
				
				txnEnquiryResponse.addEnquiryResponse(enquiryResponse);
			}
			return txnEnquiryResponse;
		}
		else if (pgSearchResponse != null && pgSearchResponse.getRespCode() != null && pgSearchResponse.getRespCode().equals(getPaysealNoResultCode())  && pgSearchResponse.getRespMessage().equals(getPaysealNoResultMessage())) {
			
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
