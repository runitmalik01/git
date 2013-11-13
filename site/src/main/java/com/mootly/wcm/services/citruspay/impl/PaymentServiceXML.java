package com.mootly.wcm.services.citruspay.impl;

import java.io.IOException;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.citruspay.PaymentService;
import com.mootly.wcm.services.citruspay.Transaction;

/**
 * The purpose of this to support all XML based transactions
 * @author admin
 *
 */
public abstract class PaymentServiceXML extends PaymentServiceGeneric implements PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceXML.class);

	@Override
	public final CITRUS_CONTENT_TYPE getContentType() {
		return CITRUS_CONTENT_TYPE.XML;
	}

	@Override
	public final CITRUS_CONTENT_TYPE getAccept() {
		return CITRUS_CONTENT_TYPE.XML;
	}
	
	public final String getGatewayReturnURL(String xmlResponse) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document =  builder.build(new StringReader(xmlResponse));
			Element elementReturnUrl = document.getRootElement().getChild("redirectUrl");
			String theReturnURL = elementReturnUrl.getText();
			return theReturnURL;
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			logger.error("Error parsing return XML",e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error parsing return XML",e);
		}
		catch (Exception e) {
			logger.error("Error parsing return XML",e);
		}
		return null;
	}
	
}
