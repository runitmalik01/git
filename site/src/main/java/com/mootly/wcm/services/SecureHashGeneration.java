package com.mootly.wcm.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecureHashGeneration {

	private static final Logger log = LoggerFactory.getLogger(SecureHashGeneration.class);
	private static final String PASS_PREFIX="$SHA-256$";
	private static final String REGEX_HEX="^[0-9A-Fa-f]+$";
	private static final String UNICODE_FORMAT="UTF8";
	private static boolean SHAtrue = true;
	/**
	 * This method is used to create the password according to SHA-256 format with prefix "$SHA-256$".
	 * 
	 * @param password {@link String}
	 * 
	 * @return {@link String} Hex value of SHA-256 in String with prefix "$SHA-256$"
	 * */
	public static String passSHAdigest(String password){
		if(SHAtrue && StringUtils.isNotEmpty(password)){
			try {
				MessageDigest md=MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				StringBuffer result = new StringBuffer();
				for (byte byt : md.digest()) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
				return PASS_PREFIX.concat(result.toString());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				log.info("Exception while not able to find Algorithm from Name provided",e);
			}		 	
		}
		return password;
	} 

	/**
	 * This method is used to check that password is Hex or not
	 * 
	 * @param value {@link String} password 
	 * 
	 * @return result {@link Boolean} check that passed string Hex
	 * 
	 * */
	public static boolean isHexFormat(String BaseValue) {
		boolean result=false;
		String value = BaseValue.replace(PASS_PREFIX, "").trim();
		if(!value.contains(PASS_PREFIX)){
			if(value.matches(REGEX_HEX) && (value.length()%4)==0 ){
				result=true;
			}
		}
		return result;
	}
	
	public static String simpleBase64Encrption(String Data){
		byte[] dataByte=null;
		String encryptData=null;
		try {
			dataByte = Data.getBytes(UNICODE_FORMAT);
			byte[] encryptedValue = Base64.encodeBase64(dataByte);
			encryptData=new String(encryptedValue);
			return encryptData;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			log.error("Error in case of Encoding the transfer data string",e);
			return encryptData;
		}
	}
	
	public static String simpleBase64Decrytion(String encryptedData){
		byte[] dataByte=null;
		String decryptedData=null;
		dataByte = Base64.decodeBase64(encryptedData);
		decryptedData = new String(dataByte);
		return decryptedData;
	}
}
