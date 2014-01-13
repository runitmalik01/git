package com.opus.epg.sfa.java;

import java.security.Security;

import javax.crypto.Cipher;

import cryptix.provider.Cryptix;
import cryptix.provider.key.RawSecretKey;
import cryptix.util.core.Hex;

public class EPGCryptLib
{
  Cipher alg;
  
  public EPGCryptLib()
    throws Exception
  {
    Security.addProvider(new Cryptix());
    this.alg = Cipher.getInstance("DES/ECB/PKCS7", "Cryptix");
  }
  
  public String Encrypt(String paramString1, String paramString2)
    throws Exception
  {
    byte[] arrayOfByte1 = Hex.fromString(paramString1);
    byte[] arrayOfByte2 = Hex.fromString(paramString2);
    

    RawSecretKey localRawSecretKey = new RawSecretKey("DES/ECB/PKCS7", arrayOfByte1);
    this.alg.init(Cipher.ENCRYPT_MODE, localRawSecretKey); //(localRawSecretKey);
    byte[] arrayOfByte3 = this.alg.doFinal(arrayOfByte2);
    String str = Hex.toString(arrayOfByte3);
    return str;
  }
  
  public String Decrypt(String paramString1, String paramString2)
    throws Exception
  {
    byte[] arrayOfByte1 = Hex.fromString(paramString1);
    byte[] arrayOfByte2 = Hex.fromString(paramString2);
    
    RawSecretKey localRawSecretKey = new RawSecretKey("DES/ECB/PKCS7", arrayOfByte1);
    this.alg.init(Cipher.DECRYPT_MODE,localRawSecretKey);
    byte[] arrayOfByte3 = this.alg.doFinal(arrayOfByte2);
    String str = Hex.toString(arrayOfByte3);
    return str;
  }
}
