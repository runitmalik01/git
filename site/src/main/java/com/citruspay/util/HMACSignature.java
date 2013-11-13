package com.citruspay.util;

import java.io.PrintStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class HMACSignature
{
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	public static String generateHMAC(String data, String hexEncodedKey)
	{
		String result = "";
		try {
			byte[] keyBytes = hexEncodedKey.getBytes();
			SecretKeySpec signingKey = new SecretKeySpec(keyBytes, 
					"HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);
			byte[] rawHmac = mac.doFinal(data.getBytes());

			byte[] hexBytes = new Hex().encode(rawHmac);
			result = new String(hexBytes, "UTF-8");
		} catch (Exception e) {
			System.out.println("error getting signature " + e.getMessage());
		}
		return result;
	}
}