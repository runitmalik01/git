package com.mootly.wcm.utils;

import java.security.SecureRandom;
import java.util.Random;

public final class MootlyITReturnUtil {
	
	/**
	 * I plan to use this to ensure some uniqueness to my transaction ids instead of sequences, which may result in disaster
	 * @param length
	 * @return
	 */
	public final static String getUniqueRandomString(int length) {
		Random r = new SecureRandom();
		byte[] b = new byte[length];
		r.nextBytes(b);
		String s = org.apache.commons.codec.binary.Base64.encodeBase64String(b);
		return s.substring(0, length); 
	}
}
