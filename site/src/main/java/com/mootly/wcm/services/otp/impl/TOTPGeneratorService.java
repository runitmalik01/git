package com.mootly.wcm.services.otp.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mootly.wcm.model.OTP;
import com.mootly.wcm.services.otp.OTPService;

public class TOTPGeneratorService implements OTPService{
	static final private Logger logger = LoggerFactory.getLogger(TOTPGeneratorService.class);
	@Override
	public OTP generate() {
		// TODO Auto-generated method stub
		Random random1 = new Random();
		StringBuffer stringBuffer = new StringBuffer(4);
		stringBuffer.append(random1.nextInt(10));
		stringBuffer.append(random1.nextInt(10));
		stringBuffer.append(random1.nextInt(10));
		stringBuffer.append(random1.nextInt(10));
		if (logger.isInfoEnabled()) {
			logger.info("The random 4 digit OTP is" + stringBuffer.toString());
		}
		Calendar creationTime = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
		Calendar expirationTime = GregorianCalendar.getInstance();
		expirationTime.setTime(creationTime.getTime());
		expirationTime.add(Calendar.MINUTE, 20); //20 minute expiration
		
		OTP otp = new OTP(stringBuffer.toString(),creationTime,expirationTime);
		
		return otp;
	}
}
