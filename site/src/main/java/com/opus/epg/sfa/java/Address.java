package com.opus.epg.sfa.java;

public class Address
{
  protected String mstrCountryAlphaCode = null;
  protected String mstrAddLine1 = null;
  protected String mstrAddLine2 = null;
  protected String mstrAddLine3 = null;
  protected String mstrCity = null;
  protected String mstrState = null;
  protected String mstrZip = null;
  protected String mstrEmail = null;
  
  public void setAddressDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.mstrAddLine1 = paramString1;
    this.mstrAddLine2 = paramString2;
    this.mstrAddLine3 = paramString3;
    this.mstrCity = paramString4;
    this.mstrState = paramString5;
    this.mstrZip = paramString6;
    this.mstrCountryAlphaCode = paramString7;
    this.mstrEmail = paramString8;
  }
  
  public String getAddrLine1()
  {
    return this.mstrAddLine1;
  }
  
  public String getAddrLine2()
  {
    return this.mstrAddLine2;
  }
  
  public String getAddrLine3()
  {
    return this.mstrAddLine3;
  }
  
  public String getCity()
  {
    return this.mstrCity;
  }
  
  public String getState()
  {
    return this.mstrState;
  }
  
  public String getZip()
  {
    return this.mstrZip;
  }
  
  public String getCountryAlphaCode()
  {
    return this.mstrCountryAlphaCode;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(80);
    localStringBuffer.append(" \nCountry Alpha Code : " + this.mstrCountryAlphaCode + " \nAddress Line 1 : " + this.mstrAddLine1 + " \nAddress Line 2 : " + this.mstrAddLine2 + " \nAddress Line 3 : " + this.mstrAddLine3 + " \nCity : " + this.mstrCity + " \nState : " + this.mstrState + " \nZip : " + this.mstrZip);
    






    return localStringBuffer.toString();
  }
}
