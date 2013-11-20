package com.mootly.wcm.services.ditws.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.services.ditws.DITSOAPService;
import com.mootly.wcm.services.ditws.soap.SOAPService;

public abstract class DITSOAPServiceImpl implements DITSOAPService{
	Logger logger = LoggerFactory.getLogger(DITSOAPService.class);
	
	public void updateInputParamValues(Map<String,String> inputParamValues) {
		if (inputParamValues == null) inputParamValues = new HashMap<String, String>();
		
		inputParamValues. put(PARAM_USER_NAME, getUserName());
		inputParamValues.put(PARAM_PASSWORD, getPassword());
		
		inputParamValues.put(PARAM_CERT_CHAIN, getCertChain());
		inputParamValues.put(PARAM_SIGNATURE, getSignature());
		
	}
	
	public DITSOAPServiceImpl(String userName,String password,String certChain,String signature,SOAPService soapService) {
		this.userName = userName;
		this.password = password;
		this.certChain = certChain;
		this.signature = signature;
		this.soapService = soapService;
	}
	
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public SOAPService getSoapService() {
		return soapService;
	}


	@Override
	public String getCertChain() {
		// TODO Auto-generated method stub
		return certChain;
	}


	@Override
	public String getSignature() {
		// TODO Auto-generated method stub
		return signature;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final void setCertChain(String certChain) {
		this.certChain = certChain;
	}

	public final void setSignature(String signature) {
		this.signature = signature;
	}



	String userName;
	String password;
	String certChain;
	String signature;
	final SOAPService soapService;
}
