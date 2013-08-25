package com.mootly.wcm.services.citruspay.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.citruspay.PaymentService;

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
	
}
