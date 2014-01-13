package com.opus.epg.sfa.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import xjava.security.Cipher;
import cryptix.provider.Cryptix;
import cryptix.provider.rsa.BaseRSAKeyPairGenerator;
import cryptix.provider.rsa.RawRSAPrivateKey;
import cryptix.provider.rsa.RawRSAPublicKey;
import cryptix.util.core.Hex;

public class EPGMerchantEncryptionLib
{
  byte[] bytarrMsg = null;
  static SecureRandom random = new SecureRandom();
  
  public byte[] encryptDataWithPubLicKey(String paramString, RawRSAPublicKey paramRawRSAPublicKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initEncrypt(paramRawRSAPublicKey);
      int i = localCipher.getInputBlockSize();
      byte[] arrayOfByte1 = paramString.getBytes();
      byte[] arrayOfByte2 = new byte[i];
      for (int j = 0; j < arrayOfByte1.length; j++) {
        arrayOfByte2[j] = arrayOfByte1[j];
      }
      byte[] arrayOfByte3 = localCipher.crypt(arrayOfByte2);
      return arrayOfByte3;
    }
    finally {}
  }
  
  public String getEncryptedStringWithPubLicKey(String paramString, RawRSAPublicKey paramRawRSAPublicKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initEncrypt(paramRawRSAPublicKey);
      int i = localCipher.getInputBlockSize();
      byte[] arrayOfByte1 = paramString.getBytes();
      byte[] arrayOfByte2 = new byte[i];
      for (int j = 0; j < arrayOfByte1.length; j++) {
        arrayOfByte2[j] = arrayOfByte1[j];
      }
      byte[] arrayOfByte3 = localCipher.crypt(arrayOfByte2);
      return Hex.toString(arrayOfByte3);
    }
    finally {}
  }
  
  public byte[] encryptDataWithPublicKeyContents(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPublicKey localRawRSAPublicKey = new RawRSAPublicKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return encryptDataWithPubLicKey(paramString1, localRawRSAPublicKey);
    }
    finally {}
  }
  
  public String getEncryptedStringWithPubLicKey(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPublicKey localRawRSAPublicKey = new RawRSAPublicKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return getEncryptedStringWithPubLicKey(paramString1, localRawRSAPublicKey);
    }
    finally {}
  }
  
  public String decryptDataWithPublicKey(byte[] paramArrayOfByte, RawRSAPublicKey paramRawRSAPublicKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initDecrypt(paramRawRSAPublicKey);
      byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte);
      String str1 = new String(arrayOfByte);
      return str1;
    }
    finally {}
  }
  
  public String decryptDataWithPublicKey(String paramString, RawRSAPublicKey paramRawRSAPublicKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initDecrypt(paramRawRSAPublicKey);
      byte[] arrayOfByte = localCipher.doFinal(Hex.fromString(paramString));
      String str1 = new String(arrayOfByte);
      return str1;
    }
    finally {}
  }
  
  public String decryptDataWithPublicKeyContents(byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws Exception
  {
    try
    {
      RawRSAPublicKey localRawRSAPublicKey = new RawRSAPublicKey(new BigInteger(paramString1), new BigInteger(paramString2));
      return decryptDataWithPublicKey(paramArrayOfByte, localRawRSAPublicKey);
    }
    finally {}
  }
  
  public String decryptDataWithPublicKeyContents(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPublicKey localRawRSAPublicKey = new RawRSAPublicKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return decryptDataWithPublicKey(paramString1, localRawRSAPublicKey);
    }
    finally {}
  }
  
  public byte[] encryptDataWithPrivateKey(String paramString, RawRSAPrivateKey paramRawRSAPrivateKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initEncrypt(paramRawRSAPrivateKey);
      int i = localCipher.getInputBlockSize();
      byte[] arrayOfByte1 = paramString.getBytes();
      byte[] arrayOfByte2 = new byte[i];
      for (int j = 0; j < arrayOfByte1.length; j++) {
        arrayOfByte2[j] = arrayOfByte1[j];
      }
      byte[] arrayOfByte3 = localCipher.crypt(arrayOfByte2);
      return arrayOfByte3;
    }
    finally {}
  }
  
  public String getEncryptedStringWithPrivateKey(String paramString, RawRSAPrivateKey paramRawRSAPrivateKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initEncrypt(paramRawRSAPrivateKey);
      int i = localCipher.getInputBlockSize();
      byte[] arrayOfByte1 = paramString.getBytes();
      byte[] arrayOfByte2 = new byte[i];
      for (int j = 0; j < arrayOfByte1.length; j++) {
        arrayOfByte2[j] = arrayOfByte1[j];
      }
      byte[] arrayOfByte3 = localCipher.crypt(arrayOfByte2);
      return Hex.toString(arrayOfByte3);
    }
    finally {}
  }
  
  public byte[] encryptDataWithPrivateKeyContents(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPrivateKey localRawRSAPrivateKey = new RawRSAPrivateKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return encryptDataWithPrivateKey(paramString1, localRawRSAPrivateKey);
    }
    finally {}
  }
  
  public String getEncryptedKeyWithPrivateKeyContents(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPrivateKey localRawRSAPrivateKey = new RawRSAPrivateKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return getEncryptedStringWithPrivateKey(paramString1, localRawRSAPrivateKey);
    }
    finally {}
  }
  
  public String decryptDataWithPrivateKey(byte[] paramArrayOfByte, RawRSAPrivateKey paramRawRSAPrivateKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initDecrypt(paramRawRSAPrivateKey);
      byte[] arrayOfByte = localCipher.doFinal(paramArrayOfByte);
      String str1 = new String(arrayOfByte);
      return str1;
    }
    finally {}
  }
  
  public String decryptDataWithPrivateKey(String paramString, RawRSAPrivateKey paramRawRSAPrivateKey)
    throws Exception
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS7", "Cryptix");
      localCipher.initDecrypt(paramRawRSAPrivateKey);
      byte[] arrayOfByte = localCipher.doFinal(Hex.fromString(paramString));
      String str1 = new String(arrayOfByte);
      return str1;
    }
    finally {}
  }
  
  public String decryptDataWithPrivateKeyContents(byte[] paramArrayOfByte, String paramString1, String paramString2)
    throws Exception
  {
    try
    {
      RawRSAPrivateKey localRawRSAPrivateKey = new RawRSAPrivateKey(new BigInteger(paramString1), new BigInteger(paramString2));
      return decryptDataWithPrivateKey(paramArrayOfByte, localRawRSAPrivateKey);
    }
    finally {}
  }
  
  public String decryptDataWithPrivateKeyContents(String paramString1, String paramString2, String paramString3)
    throws Exception
  {
    try
    {
      RawRSAPrivateKey localRawRSAPrivateKey = new RawRSAPrivateKey(new BigInteger(paramString2), new BigInteger(paramString3));
      return decryptDataWithPrivateKey(paramString1, localRawRSAPrivateKey);
    }
    finally {}
  }
  
  public KeyPair generateKeyPair()
    throws Exception
  {
    try
    {
      Cryptix localCryptix = new Cryptix();
      Security.addProvider(localCryptix);
      BaseRSAKeyPairGenerator localBaseRSAKeyPairGenerator = (BaseRSAKeyPairGenerator)KeyPairGenerator.getInstance("RSA", "Cryptix");
      localBaseRSAKeyPairGenerator.initialize(1024, random);
      KeyPair localKeyPair1 = localBaseRSAKeyPairGenerator.generateKeyPair();
      return localKeyPair1;
    }
    finally {}
  }
  
  public RawRSAPublicKey getPublicKey(KeyPair paramKeyPair)
    throws Exception
  {
    try
    {
      RawRSAPublicKey localRawRSAPublicKey1 = (RawRSAPublicKey)paramKeyPair.getPublic();
      return localRawRSAPublicKey1;
    }
    finally {}
  }
  
  public RawRSAPrivateKey getPrivateKey(KeyPair paramKeyPair)
    throws Exception
  {
    try
    {
      RawRSAPrivateKey localRawRSAPrivateKey1 = (RawRSAPrivateKey)paramKeyPair.getPrivate();
      return localRawRSAPrivateKey1;
    }
    finally {}
  }
  
  public void print(byte[] paramArrayOfByte)
  {
    try
    {
      for (int i = 0; i < paramArrayOfByte.length; i++) {
        System.out.println("Index : " + i + " Value : 0x" + this.hex[(paramArrayOfByte[i] >> 4 & 0xF)] + this.hex[(paramArrayOfByte[i] & 0xF)]);
      }
    }
    catch (Exception localException) {}
  }
  
  public void print(byte paramByte)
  {
    try
    {
      System.out.println(" Value : 0x" + this.hex[(paramByte >> 4 & 0xF)] + this.hex[(paramByte & 0xF)]);
    }
    catch (Exception localException) {}
  }
  
  char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
      KeyPair localKeyPair = localEPGMerchantEncryptionLib.generateKeyPair();
      RawRSAPublicKey localRawRSAPublicKey = (RawRSAPublicKey)localKeyPair.getPublic();
      RawRSAPrivateKey localRawRSAPrivateKey = (RawRSAPrivateKey)localKeyPair.getPrivate();
      byte[] arrayOfByte = localEPGMerchantEncryptionLib.encryptDataWithPubLicKey("This is a test string", localRawRSAPublicKey);
      String str = localEPGMerchantEncryptionLib.decryptDataWithPrivateKey(arrayOfByte, localRawRSAPrivateKey);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    finally {}
  }
  
  public String encryptData(String paramString1, String paramString2)
    throws Exception
  {
    if ((paramString1 == null) || (paramString1 == "")) {
      return null;
    }
    if ((paramString2 == null) || (paramString2 == "")) {
      return null;
    }
    EPGCryptLib localEPGCryptLib = new EPGCryptLib();
    String str = localEPGCryptLib.Encrypt(paramString2, paramString1);
    return str;
  }
  
  public String decryptData(String paramString1, String paramString2)
    throws Exception
  {
    if ((paramString1 == null) || (paramString1 == "")) {
      return null;
    }
    if ((paramString2 == null) || (paramString2 == "")) {
      return null;
    }
    EPGCryptLib localEPGCryptLib = new EPGCryptLib();
    String str = localEPGCryptLib.Decrypt(paramString2, paramString1);
    return str;
  }
  
  public String encryptMerchantKey(String paramString1, String paramString2)
    throws Exception
  {
    return encryptData(paramString1, (paramString2 + paramString2).substring(0, 16));
  }
  
  public String decryptMerchantKey(String paramString1, String paramString2)
    throws Exception
  {
    return decryptData(paramString1, (paramString2 + paramString2).substring(0, 16));
  }
  
  public String encryptMerchantData(String paramString1, String paramString2, String paramString3, String paramString4)
    throws Exception
  {
    try
    {
      String str1 = paramString1 + "," + System.currentTimeMillis() + "," + paramString3 + "," + paramString4;
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString2 + paramString1 + ".key"));
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
      String str2 = localBufferedReader.readLine();
      if (str2 == null) {
        throw new SFAApplicationException("Invalid credentials. Transaction cannot be processed");
      }
      str2 = decryptMerchantKey(str2, paramString1);
      if (str2 == null) {
        throw new SFAApplicationException("Invalid credentials. Transaction cannot be processed");
      }
      String str3 = localBufferedReader.readLine();
      if (str3 == null) {
        throw new SFAApplicationException("Invalid credentials. Transaction cannot be processed");
      }
      str3 = decryptMerchantKey(str3, paramString1);
      if (str3 == null) {
        throw new SFAApplicationException("Invalid credentials. Transaction cannot be processed");
      }
      return getEncryptedStringWithPubLicKey(str1, str2, str3);
    }
    finally {}
  }
}
