package com.opus.epg.sfa.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;


public class PostLib
{
  private URL urlDataSources;
  private String motoURL;
  private String sslURL;
  private boolean verbose = false;
  private String strKeyDir;
  private String strOsType;
  private String epgURL;
  private long TxnNo;
  private static long SerialNo = 0L;
  private static String traceLog = null;
  private String strMerchantTxnId = null;
  private static PrintWriter pw = null;
  private static FileWriter fos = null;
  private static final String MERCHANT = "MerchantID";
  private static final String VENDOR = "Vendor";
  private static final String PARTNER = "Partner";
  private static final String MER_TXN_ID = "MerchantTxnID";
  private static final String MSG_TYPE = "MessageType";
  private static final String INV_NO = "InvoiceNo";
  private static final String ORD_REFNO = "OrdRefNo";
  private static final String INV_DT = "InvoiceDate";
  private static final String GMT_OFFSET = "GMTOffset";
  private static final String TIME_STAMP = "TimeStamp";
  private static final String INV_AMT = "Amount";
  private static final String CURR_CODE = "CurrCode";
  private static final String BT_CUSTID = "CustomerId";
  private static final String BT_CUSTNM = "CustomerName";
  private static final String BT_STREET1 = "BillAddrLine1";
  private static final String BT_STREET2 = "BillAddrLine2";
  private static final String BT_STREET3 = "BillAddrLine3";
  private static final String BT_CITY = "BillCity";
  private static final String BT_STATE = "BillState";
  private static final String BT_ZIP = "BillZip";
  private static final String BT_COUNTRY = "BillCountryAlphaCode";
  private static final String BT_MAIL = "BillEmail";
  private static final String ST_STREET1 = "ShipAddrLine1";
  private static final String ST_STREET2 = "ShipAddrLine2";
  private static final String ST_STREET3 = "ShipAddrLine3";
  private static final String ST_CITY = "ShipCity";
  private static final String ST_STATE = "ShipState";
  private static final String ST_ZIP = "ShipZip";
  private static final String ST_COUNTRY = "ShipCountryAlphaCode";
  private static final String CRD_TYP = "CardType";
  private static final String CRD_NUM = "CardNum";
  private static final String EXP_DT_MON = "ExpDtMon";
  private static final String EXP_DT_YR = "ExpDtYr";
  private static final String CVVNUM = "CVVNum";
  private static final String CRD_NAME = "NameOnCard";
  private static final String RESPMETH = "RespMethod";
  private static final String RESPURL = "RespURL";
  private static final String EXT1 = "Ext1";
  private static final String EXT2 = "Ext2";
  private static final String EXT3 = "Ext3";
  private static final String EXT4 = "Ext4";
  private static final String EXT5 = "Ext5";
  private static final String MRT_IP_ADDR = "MrtIpAddr";
  private static final String ENCRYPTED_DATA = "EncryptedData";
  private static final String LANGUAGE_TYPE = "LanguageType";
  private static final String OS_TYPE = "OsType";
  private static final String REQUEST_TYPE = "RequestType";
  private static final String TRN_ORG = "RootTxnSysRefNum";
  private static final String RRN_ORG = "RootPNRefNum";
  private static final String AUTH_CD = "RootAuthCode";
  private static final String MerchantType = "MerchantType";
  private static final String REQUEST_TYPE_RELATED = "RelatedTxn";
  private static final String REQUEST_TYPE_STATUS_INQUIRY = "SFAStatusInquiry";
  private static final String REQUEST_TYPE_TXN_SEARCH = "SFATxnSearch";
  private static final String REQUEST_TYPE_ROOTSSLPOST = "SFARootSSLPost";
  private static final String REQUEST_TYPE_ROOTMOTOPOST = "SFARootMotoPost";
  public static final String REQUEST_TYPE_ROOTSSLREDIRECT = "SFARootSSLRedirect";
  private static final String LANGUAGE_TYPE_JAVA = "Java";
  private static final String SSL_PURCHASE_AMOUNT = "PurchaseAmount";
  private static final String SSL_DISPLAY_AMOUNT = "DisplayAmount";
  private static final String SSL_CURRENCY_VAL = "CurrencyVal";
  private static final String SSL_EXPONENT = "Exponent";
  private static final String SSL_ORDERDESC = "OrderDesc";
  private static final String SSL_RECURFREQ = "RecurFreq";
  private static final String SSL_RECUREND = "RecurEnd";
  private static final String SSL_INSTALLMENT = "Installment";
  private static final String SSL_DEVICECATEGORY = "DeviceCategory";
  private static final String SSL_WHATIUSE = "WhatIUse";
  private static final String SSL_ACCEPTHDR = "AcceptHdr";
  private static final String SSL_USERAGENT = "UserAgent";
  private static final String MOTO_VBV_STATUS = "status";
  private static final String MOTO_VBV_CAVV = "cavv";
  private static final String MOTO_VBV_ECI = "eci";
  private static final String MOTO_VBV_PURCHASE_AMOUNT = "purchaseAmount";
  private static final String MOTO_VBV_CURR_VAL = "currencyVal";
  private static final String MOTO_VBV_CURR_XID = "xid";
  private static final String MOTO_VBV_CURR_SHOPPING_CONTEXT = "shoppingcontext";
  private static final String INSTRUMENT_TYPE = "InstrType";
  private static final String CUST_IP_ADDR = "CustIPAddress";
  private static final String TXN_SEARCH_START_DATE = "StartDate";
  private static final String TXN_SEARCH_END_DATE = "EndDate";
  public static final String METHOD_GET = "GET";
  public static final String METHOD_POST = "POST";
  private static final String PG_RESP_RESERVE1 = "Reserve1";
  private static final String PG_RESP_RESERVE2 = "Reserve2";
  private static final String PG_RESP_RESERVE3 = "Reserve3";
  private static final String PG_RESP_RESERVE4 = "Reserve4";
  private static final String PG_RESP_RESERVE5 = "Reserve5";
  private static final String PG_RESP_RESERVE6 = "Reserve6";
  private static final String PG_RESP_RESERVE7 = "Reserve7";
  private static final String PG_RESP_RESERVE8 = "Reserve8";
  private static final String PG_RESP_RESERVE9 = "Reserve9";
  private static final String PG_RESP_RESERVE10 = "Reserve10";
  private static final String OFF_STREET1 = "OfficeAddrLine1";
  private static final String OFF_STREET2 = "OfficeAddrLine2";
  private static final String OFF_STREET3 = "OfficeAddrLine3";
  private static final String OFF_CITY = "OfficeCity";
  private static final String OFF_STATE = "OfficeState";
  private static final String OFF_ZIP = "OfficeZip";
  private static final String OFF_COUNTRY = "OfficeCountryAlphaCode";
  private static final String HOME_STREET1 = "HomeAddrLine1";
  private static final String HOME_STREET2 = "HomeAddrLine2";
  private static final String HOME_STREET3 = "HomeAddrLine3";
  private static final String HOME_CITY = "HomeCity";
  private static final String HOME_STATE = "HomeState";
  private static final String HOME_ZIP = "HomeZip";
  private static final String HOME_COUNTRY = "HomeCountryAlphaCode";
  private static final String MOBILE = "MobileNo";
  private static final String CUSTINFOPRESENT = "CustInfoPresent";
  private static final String FIRSTNAME = "FirstName";
  private static final String LASTNAME = "LastName";
  private static final String ISBillNSHIPADDRMATCH = "IsBillNShipAddrMatch";
  private static final String REGDATE = "RegistrationDate";
  private static final String SESSIONDETAILSINFOPRESENT = "SessionDetailsInfoPresent";
  private static final String TRANS_IP_ADDR = "TransIPAddress";
  private static final String COOKIE = "Cookie";
  private static final String BROW_CNT = "BrowserCountry";
  private static final String BROW_LOC_LANG = "BrowserLocalLang";
  private static final String BROW_LOC_VAR = "BrowserLocalLangVariant";
  private static final String BROW_USR_AGT = "BrowserUserAgent";
  private static final String AIRLINEINFOPRESENT = "AirLineInfoPresent";
  private static final String BOOK_DATE = "BookingDate";
  private static final String FLT_DATE = "FlightDate";
  private static final String FLT_TIME = "FlightTime";
  private static final String FLT_NO = "FlightNumber";
  private static final String PASS_NAME = "PassengerName";
  private static final String NO_OF_TICKET = "NumberOfTickets";
  private static final String CARD_NAME_N_CUST_NAME_MATCH = "CardNameNCustomerNameMatch";
  private static final String PNR = "PNR";
  private static final String SEC_FROM = "SectorFrom";
  private static final String SEC_TO = "SectorTo";
  private static final String MERCHANTDISEINFOPRESENT = "MerchantDiseInfoPresent";
  private static final String ITEM_PUR = "ItemPurchased";
  private static final String QUANT = "Quantity";
  private static final String BRAND = "Brand";
  private static final String MOD_NO = "ModelNumber";
  private static final String BUY_NAME = "BuyersName";
  private static final String CARD_NAME_N_BUY_NAME_MATCH = "CardNameNBuyerNameMatch";
  
  public PostLib()
    throws Exception
  {
    try
    {
      InputStream localInputStream = getClass().getResourceAsStream("/sfa.properties");
      Properties localProperties = new Properties();
      localProperties.load(localInputStream);
      
      this.motoURL = localProperties.getProperty("motoURL");
      if ((this.motoURL == null) || ("".equals(this.motoURL))) {
        throw new Exception("Error in the properties file. Value for motoURL is not mentioned or is invalid");
      }
      this.sslURL = localProperties.getProperty("sslURL");
      if ((this.sslURL == null) || ("".equals(this.sslURL))) {
        throw new Exception("Error in the properties file. Value for sslURL is not mentioned or is invalid");
      }
      String str = localProperties.getProperty("verbose");
      if ((str != null) && (str.trim().equals("true"))) {
        this.verbose = true;
      }
      this.strKeyDir = localProperties.getProperty("Key.Directory");
      if ((this.strKeyDir == null) || ("".equals(this.strKeyDir))) {
        throw new Exception("Error in the properties file. Value for key Directory is not mentioned or is invalid");
      }
      this.strOsType = localProperties.getProperty("OS.Type", "NT");
      if ((this.strOsType == null) || ("".equals(this.strOsType))) {
        throw new Exception("Error in the properties file. Value for OS.Type is not mentioned or is invalid");
      }
      this.epgURL = localProperties.getProperty("epgURL");
      if ((this.epgURL == null) || ("".equals(this.epgURL))) {
        throw new Exception("Error in the properties file. Value for relatedTxnURL is not mentioned or is invalid");
      }
      traceLog = localProperties.getProperty("traceLog");
    }
    catch (Exception localException)
    {
      if (this.verbose)
      {
        trace("PostLib", "An exception occured while loading the Properties file.");
        trace("PostLib", localException.toString());
      }
      throw localException;
    }
  }
  
  public PGResponse postSSL(BillToAddress paramBillToAddress, ShipToAddress paramShipToAddress, Merchant paramMerchant, MPIData paramMPIData, HttpServletResponse paramHttpServletResponse, PGReserveData paramPGReserveData, CustomerDetails paramCustomerDetails, SessionDetail paramSessionDetail, AirLineTransaction paramAirLineTransaction, MerchanDise paramMerchanDise)
  {
    String str1 = "postSSL";
    EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = null;
    String str2 = null;
    try
    {
      this.TxnNo = GetTxnSerialNo();
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><Entered>");
      }
      if (paramMerchant == null)
      {
        if (this.verbose) {
          trace(str1, "<Error. Merchant Object passed is null><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid Merchant Object passed to postSSL method. Object is null. Transaction cannot proceed.");
      }
      this.strMerchantTxnId = paramMerchant.getMerchantTxnID();
      if ((paramMerchant.getMerchantID() == null) || ("".equals(paramMerchant.getMerchantID())))
      {
        if (this.verbose) {
          trace(str1, "<Error. Merchant Id passed is nul><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Merchant Id is Invalid or null");
      }
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><MrtID-->" + paramMerchant.getMerchantID() + "><Entered>");
      }
      if (paramMerchant.getMessageType() == null)
      {
        if (this.verbose) {
          trace(str1, "<Message Type passed is null><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Invalid Message Type. Transaction cannot be processed");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(buildMerchantBillShip(paramMerchant, paramBillToAddress, paramShipToAddress));
      try
      {
        localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
        str2 = localEPGMerchantEncryptionLib.encryptMerchantData(paramMerchant.getMerchantID(), this.strKeyDir, paramMerchant.getMerchantTxnID(), paramMerchant.getAmount());
      }
      catch (SFAApplicationException localSFAApplicationException2)
      {
        if (this.verbose) {
          trace(str1, "<SFAApplicationException in encrypting data. " + localSFAApplicationException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw localSFAApplicationException2;
      }
      catch (Exception localException2)
      {
        if (this.verbose) {
          trace(str1, "<Exception in encrypting data. " + localException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while encrypting data. Transaction cannot be processed.");
      }
      localStringBuffer.append("&EncryptedData=" + str2);
      localStringBuffer.append("&OsType=" + this.strOsType);
      localStringBuffer.append("&LanguageType=Java");
      
      localStringBuffer.append("&PurchaseAmount=" + getValue(paramMPIData == null ? null : paramMPIData.getPurchaseAmount()));
      localStringBuffer.append("&DisplayAmount=" + getValue(paramMPIData == null ? null : paramMPIData.getDisplayAmount()));
      localStringBuffer.append("&CurrencyVal=" + getValue(paramMPIData == null ? null : paramMPIData.getCurrencyVal()));
      localStringBuffer.append("&Exponent=" + getValue(paramMPIData == null ? null : paramMPIData.getExponent()));
      localStringBuffer.append("&OrderDesc=" + getValue(paramMPIData == null ? null : paramMPIData.getOrderDesc()));
      localStringBuffer.append("&RecurFreq=" + getValue(paramMPIData == null ? null : paramMPIData.getRecurFreq()));
      localStringBuffer.append("&RecurEnd=" + getValue(paramMPIData == null ? null : paramMPIData.getRecurEnd()));
      localStringBuffer.append("&Installment=" + getValue(paramMPIData == null ? null : paramMPIData.getInstallment()));
      localStringBuffer.append("&DeviceCategory=" + getValue(paramMPIData == null ? null : paramMPIData.getDeviceCategory()));
      localStringBuffer.append("&WhatIUse=" + getValue(paramMPIData == null ? null : paramMPIData.getWhatIUse()));
      localStringBuffer.append("&AcceptHdr=" + getValue(paramMPIData == null ? null : paramMPIData.getAcceptHdr()));
      localStringBuffer.append("&UserAgent=" + getValue(paramMPIData == null ? null : paramMPIData.getAgentHdr()));
      
      localStringBuffer.append("&Reserve1=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField1()));
      localStringBuffer.append("&Reserve2=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField2()));
      localStringBuffer.append("&Reserve3=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField3()));
      localStringBuffer.append("&Reserve4=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField4()));
      localStringBuffer.append("&Reserve5=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField5()));
      localStringBuffer.append("&Reserve6=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField6()));
      localStringBuffer.append("&Reserve7=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField7()));
      localStringBuffer.append("&Reserve8=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField8()));
      localStringBuffer.append("&Reserve9=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField9()));
      localStringBuffer.append("&Reserve10=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField10()));
      

      localStringBuffer.append(buildCustomerDetail(paramCustomerDetails));
      localStringBuffer.append("&SessionDetailsInfoPresent=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getSessionDetailFlag()));
      localStringBuffer.append("&TransIPAddress=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getTransactionIPAddr()));
      localStringBuffer.append("&Cookie=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getSecureCookie()));
      localStringBuffer.append("&BrowserCountry=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserCountry()));
      localStringBuffer.append("&BrowserLocalLang=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserLocalLang()));
      localStringBuffer.append("&BrowserLocalLangVariant=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserLocalLangVariant()));
      localStringBuffer.append("&BrowserUserAgent=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserUserAgent()));
      
      localStringBuffer.append(buildAirlLineAndMerchanDise(paramAirLineTransaction, paramMerchanDise));
      String localObject1 = postData(this.sslURL, localStringBuffer.toString());
      
      PGResponse localObject2 = new PGResponse((String)localObject1);
      ((PGResponse)localObject2).toString();
      if (((PGResponse)localObject2).getRedirectionTxnId() != null) {
        ((PGResponse)localObject2).setRedirectionUrl(this.sslURL + "?txnId=" + ((PGResponse)localObject2).getRedirectionTxnId());
      }
      return localObject2;
    }
    catch (SFAApplicationException localSFAApplicationException1)
    {
      if (this.verbose) {
        trace(str1, "<SFAApplicationException. " + localSFAApplicationException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject1 = new PGResponse();
      ((PGResponse)localObject1).setRespCode("2");
      ((PGResponse)localObject1).setRespMessage(localSFAApplicationException1.getMessage());
      ((PGResponse)localObject1).setTxnId(this.strMerchantTxnId);
      return localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject3;
      if (this.verbose) {
        trace(str1, "<Exception. " + localException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject2 = new PGResponse();
      ((PGResponse)localObject2).setRespCode("2");
      ((PGResponse)localObject2).setRespMessage("Internal Processing Error");
      ((PGResponse)localObject2).setTxnId(this.strMerchantTxnId);
      return localObject2;
    }
    finally
    {
      localEPGMerchantEncryptionLib = null;
      str2 = null;
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Exiting>");
      }
    }
  }
  
  public static synchronized long GetTxnSerialNo()
  {
    SerialNo += 1L;
    long l = SerialNo;
    if (SerialNo == 9999999L) {
      SerialNo = 0L;
    }
    return l;
  }
  
  public PGResponse postMOTO(BillToAddress paramBillToAddress, ShipToAddress paramShipToAddress, Merchant paramMerchant, MPIData paramMPIData, CardInfo paramCardInfo, PGReserveData paramPGReserveData, CustomerDetails paramCustomerDetails, SessionDetail paramSessionDetail, AirLineTransaction paramAirLineTransaction, MerchanDise paramMerchanDise)
  {
    String str1 = "postMOTO";
    EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = null;
    String str2 = null;
    try
    {
      this.TxnNo = GetTxnSerialNo();
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><Entered>");
      }
      if (paramMerchant == null)
      {
        if (this.verbose) {
          trace(str1, "<Error. Merchant object passed is null><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid merchant object passed. Transaction cannot proceed.");
      }
      if (paramCardInfo == null)
      {
        if (this.verbose) {
          trace(str1, "<Error. Card Info object passed is null><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid card object passed. Transaction cannot proceed.");
      }
      this.strMerchantTxnId = paramMerchant.getMerchantTxnID();
      if ((paramMerchant.getMerchantID() == null) || ("".equals(paramMerchant.getMerchantID())))
      {
        if (this.verbose) {
          trace(str1, "<Error. Merchant id is Invalid><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid merchant id. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><MrtID-->" + paramMerchant.getMerchantID() + "><Entered>");
      }
      if (paramMerchant.getMessageType() == null)
      {
        if (this.verbose) {
          trace(str1, "<Message Type passed is null><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Invalid message type. Transaction cannot be processed");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(buildMerchantBillShip(paramMerchant, paramBillToAddress, paramShipToAddress));
      try
      {
        localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
        str2 = localEPGMerchantEncryptionLib.encryptMerchantData(paramMerchant.getMerchantID(), this.strKeyDir, paramMerchant.getMerchantTxnID(), paramMerchant.getAmount());
      }
      catch (SFAApplicationException localSFAApplicationException2)
      {
        if (this.verbose) {
          trace(str1, "<SFAApplicationException in encrypting data. " + localSFAApplicationException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw localSFAApplicationException2;
      }
      catch (Exception localException2)
      {
        if (this.verbose) {
          trace(str1, "<Exception in encrypting data. " + localException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while encrypting data. Transaction cannot be processed.");
      }
      localStringBuffer.append("&EncryptedData=" + str2);
      localStringBuffer.append("&OsType=" + this.strOsType);
      localStringBuffer.append("&LanguageType=Java");
      
      localStringBuffer.append("&CustIPAddress=" + getValue(paramMerchant.getCustIPAddress()));
      localStringBuffer.append("&status=" + getValue(paramMPIData == null ? null : paramMPIData.getVBVStatus()));
      localStringBuffer.append("&cavv=" + getValue(paramMPIData == null ? null : paramMPIData.getCAVV()));
      localStringBuffer.append("&eci=" + getValue(paramMPIData == null ? null : paramMPIData.getECI()));
      localStringBuffer.append("&purchaseAmount=" + getValue(paramMPIData == null ? null : paramMPIData.getPurchaseAmount()));
      localStringBuffer.append("&currencyVal=" + getValue(paramMPIData == null ? null : paramMPIData.getCurrencyVal()));
      localStringBuffer.append("&xid=" + getValue(paramMPIData == null ? null : paramMPIData.getXID()));
      localStringBuffer.append("&shoppingcontext=" + getValue(paramMPIData == null ? null : paramMPIData.getShoppingContext()));
      
      localStringBuffer.append("&InstrType=" + getValue(paramCardInfo == null ? null : paramCardInfo.getInstrType()));
      localStringBuffer.append("&CardType=" + getValue(paramCardInfo == null ? null : paramCardInfo.getCardType()));
      localStringBuffer.append("&CardNum=" + getValue(paramCardInfo == null ? null : paramCardInfo.getCardNum()));
      localStringBuffer.append("&ExpDtYr=" + getValue(paramCardInfo == null ? null : paramCardInfo.getExpDtYr()));
      localStringBuffer.append("&ExpDtMon=" + getValue(paramCardInfo == null ? null : paramCardInfo.getExpDtMon()));
      localStringBuffer.append("&CVVNum=" + getValue(paramCardInfo == null ? null : paramCardInfo.getCVVNum()));
      localStringBuffer.append("&NameOnCard=" + getValue(paramCardInfo == null ? null : paramCardInfo.getNameOnCard()));
      
      localStringBuffer.append("&Reserve1=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField1()));
      localStringBuffer.append("&Reserve2=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField2()));
      localStringBuffer.append("&Reserve3=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField3()));
      localStringBuffer.append("&Reserve4=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField4()));
      localStringBuffer.append("&Reserve5=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField5()));
      localStringBuffer.append("&Reserve6=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField6()));
      localStringBuffer.append("&Reserve7=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField7()));
      localStringBuffer.append("&Reserve8=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField8()));
      localStringBuffer.append("&Reserve9=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField9()));
      localStringBuffer.append("&Reserve10=" + getValue(paramPGReserveData == null ? null : paramPGReserveData.getReserveField10()));
      

      localStringBuffer.append(buildCustomerDetail(paramCustomerDetails));
      localStringBuffer.append("&SessionDetailsInfoPresent=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getSessionDetailFlag()));
      localStringBuffer.append("&TransIPAddress=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getTransactionIPAddr()));
      localStringBuffer.append("&Cookie=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getSecureCookie()));
      localStringBuffer.append("&BrowserCountry=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserCountry()));
      localStringBuffer.append("&BrowserLocalLang=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserLocalLang()));
      localStringBuffer.append("&BrowserLocalLangVariant=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserLocalLangVariant()));
      localStringBuffer.append("&BrowserUserAgent=" + getValue(paramSessionDetail == null ? null : paramSessionDetail.getBrowserUserAgent()));
      
      localStringBuffer.append(buildAirlLineAndMerchanDise(paramAirLineTransaction, paramMerchanDise));
      

      String localObject1 = postData(this.motoURL, localStringBuffer.toString());
      
      return new PGResponse((String)localObject1);
    }
    catch (SFAApplicationException localSFAApplicationException1)
    {
      if (this.verbose) {
        trace(str1, "<SFAApplicationException. " + localSFAApplicationException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject1 = new PGResponse();
      ((PGResponse)localObject1).setRespCode("2");
      ((PGResponse)localObject1).setRespMessage(localSFAApplicationException1.getMessage());
      ((PGResponse)localObject1).setTxnId(this.strMerchantTxnId);
      return localObject1;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception. " + localException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject2 = new PGResponse();
      ((PGResponse)localObject2).setRespCode("2");
      ((PGResponse)localObject2).setRespMessage("Internal Processing Error");
      ((PGResponse)localObject2).setTxnId(this.strMerchantTxnId);
      return localObject2;
    }
    finally
    {
      localEPGMerchantEncryptionLib = null;
      str2 = null;
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Exiting>");
      }
    }
  }
  
  private String getValue(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return URLEncoder.encode(paramString);
  }
  
  private String buildMerchantBillShip(Merchant paramMerchant, BillToAddress paramBillToAddress, ShipToAddress paramShipToAddress)
  {
    if (this.verbose) {
      trace("buildMerchantBillShip", "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Entered>");
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("MerchantID=" + getValue(paramMerchant.getMerchantID()));
    localStringBuffer.append("&Vendor=" + getValue(paramMerchant.getVendor()));
    localStringBuffer.append("&Partner=" + getValue(paramMerchant.getPartner()));
    localStringBuffer.append("&MessageType=" + getValue(paramMerchant.getMessageType()));
    localStringBuffer.append("&MerchantTxnID=" + getValue(paramMerchant.getMerchantTxnID()));
    localStringBuffer.append("&RespURL=" + getValue(paramMerchant.getRespURL()));
    localStringBuffer.append("&RespMethod=" + getValue(paramMerchant.getRespMethod()));
    localStringBuffer.append("&OrdRefNo=" + getValue(paramMerchant.getOrderReferenceNo()));
    localStringBuffer.append("&InvoiceDate=" + getValue(paramMerchant.getInvoiceDate()));
    localStringBuffer.append("&InvoiceNo=" + getValue(paramMerchant.getInvoiceNo()));
    localStringBuffer.append("&Amount=" + getValue(paramMerchant.getAmount()));
    localStringBuffer.append("&CurrCode=" + getValue(paramMerchant.getCurrCode()));
    localStringBuffer.append("&Ext1=" + getValue(paramMerchant.getExt1()));
    localStringBuffer.append("&Ext2=" + getValue(paramMerchant.getExt2()));
    localStringBuffer.append("&Ext3=" + getValue(paramMerchant.getExt3()));
    localStringBuffer.append("&Ext4=" + getValue(paramMerchant.getExt4()));
    localStringBuffer.append("&Ext5=" + getValue(paramMerchant.getExt5()));
    localStringBuffer.append("&MrtIpAddr=" + getValue(paramMerchant.getMrtIPAddress()));
    localStringBuffer.append("&GMTOffset=" + getValue(paramMerchant.getGMTTimeOffset()));
    
    localStringBuffer.append("&CustomerId=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getCustomerId()));
    localStringBuffer.append("&CustomerName=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getName()));
    localStringBuffer.append("&BillAddrLine1=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getAddrLine1()));
    localStringBuffer.append("&BillAddrLine2=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getAddrLine2()));
    localStringBuffer.append("&BillAddrLine3=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getAddrLine3()));
    localStringBuffer.append("&BillCity=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getCity()));
    localStringBuffer.append("&BillState=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getState()));
    localStringBuffer.append("&BillZip=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getZip()));
    localStringBuffer.append("&BillCountryAlphaCode=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getCountryAlphaCode()));
    localStringBuffer.append("&BillEmail=" + getValue(paramBillToAddress == null ? null : paramBillToAddress.getEmail()));
    
    localStringBuffer.append("&ShipAddrLine1=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getAddrLine1()));
    localStringBuffer.append("&ShipAddrLine2=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getAddrLine2()));
    localStringBuffer.append("&ShipAddrLine3=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getAddrLine3()));
    localStringBuffer.append("&ShipCity=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getCity()));
    localStringBuffer.append("&ShipState=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getState()));
    localStringBuffer.append("&ShipZip=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getZip()));
    localStringBuffer.append("&ShipCountryAlphaCode=" + getValue(paramShipToAddress == null ? null : paramShipToAddress.getCountryAlphaCode()));
    if (this.verbose) {
      trace("buildMerchantBillShip", "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Exiting>");
    }
    return localStringBuffer.toString();
  }
  
  private String postSearchData(String paramString1, String paramString2)
    throws SFAApplicationException
  {
    URL localURL1 = null;
    URL localURL2 = null;
    HttpURLConnection localHttpURLConnection = null;
    InputStream localInputStream = null;
    DataOutputStream localDataOutputStream = null;
    BufferedReader localBufferedReader = null;
    StringBuffer localStringBuffer = null;
    String str1 = null;
    String str2 = "postSearchData";
    try
    {
      if (this.verbose) {
        trace(str2, " <Entered>");
      }
      try
      {
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        localURL1 = new URL(paramString1);
        localURL2 = new URL("https", localURL1.getHost(), localURL1.getPort(), localURL1.getFile());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (this.verbose) {
          trace(str2, "<Malformed url Error : " + localMalformedURLException.toString() + ">");
        }
        throw new SFAApplicationException("Invalid URL passed. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Created URL object>");
      }
      try
      {
        localHttpURLConnection = (HttpURLConnection)localURL2.openConnection();
      }
      catch (IOException localIOException1)
      {
        if (this.verbose) {
          trace(str2, "<IOException while opening connection : " + localIOException1.toString() + ">");
        }
        throw new SFAApplicationException("Error while opening connection. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Opened URL Connection>");
      }
      try
      {
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        localHttpURLConnection.setRequestProperty("Accept", "image/gif, image/x-xbitmap, image/jpeg,image/pjpeg, image/png, */*");
        localHttpURLConnection.setRequestProperty("Accept-Language", "en");
        localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
        localDataOutputStream.writeBytes(paramString2);
        localDataOutputStream.flush();
        localDataOutputStream.close();
        localDataOutputStream = null;
      }
      catch (IOException localIOException2)
      {
        if (this.verbose) {
          trace(str2, "<IOException while writing data : " + localIOException2.toString() + ">");
        }
        throw new SFAApplicationException("Error while writing data. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Written data on the output stream>");
      }
      try
      {
        localInputStream = localHttpURLConnection.getInputStream();
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
        localStringBuffer = new StringBuffer();
        while ((str1 = localBufferedReader.readLine()) != null) {
          if (str1.length() != 0) {
            localStringBuffer.append(str1.trim() + "\n");
          }
        }
        localBufferedReader.close();
        localBufferedReader = null;
      }
      catch (IOException localIOException3)
      {
        if (this.verbose) {
          trace(str2, "<IOException while reading response : " + localIOException3.toString() + ">");
        }
        throw new SFAApplicationException("Error while reading data. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Read response on the stream>");
      }
      return localStringBuffer.toString();
    }
    catch (SFAApplicationException localSFAApplicationException)
    {
      throw localSFAApplicationException;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace(str2, "<Error while posting data : " + localException1.toString() + ">");
      }
      throw new SFAApplicationException("Error while posting data. Transaction cannot be processed");
    }
    finally
    {
      try
      {
        if (localHttpURLConnection != null) {
          localHttpURLConnection.disconnect();
        }
      }
      catch (Exception localException2) {}
      localURL1 = null;
      localURL2 = null;
      localHttpURLConnection = null;
      localInputStream = null;
      localDataOutputStream = null;
      localBufferedReader = null;
      localStringBuffer = null;
      str1 = null;
    }
  }
  
  private String postData(String paramString1, String paramString2)
    throws SFAApplicationException
  {
    URL localURL1 = null;
    URL localURL2 = null;
    HttpURLConnection localHttpURLConnection = null;
    InputStream localInputStream = null;
    DataOutputStream localDataOutputStream = null;
    BufferedReader localBufferedReader = null;
    StringBuffer localStringBuffer = null;
    String str1 = null;
    String str2 = "postData";
    try
    {
      if (this.verbose) {
        trace(str2, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Entered>");
      }
      try
      {
        System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
        localURL1 = new URL(paramString1);
        localURL2 = new URL("https", localURL1.getHost(), localURL1.getPort(), localURL1.getFile());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (this.verbose) {
          trace(str2, "<Malformed url Error : " + localMalformedURLException.toString() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Invalid URL passed. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Created URL object><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      try
      {
        localHttpURLConnection = (HttpURLConnection)localURL2.openConnection();
      }
      catch (IOException localIOException1)
      {
        if (this.verbose) {
          trace(str2, "<IOException while opening connection : " + localIOException1.toString() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while opening connection. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Opened URL Connection><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      try
      {
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        localHttpURLConnection.setRequestProperty("Accept", "image/gif, image/x-xbitmap, image/jpeg,image/pjpeg, image/png, */*");
        localHttpURLConnection.setRequestProperty("Accept-Language", "en");
        localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
        localDataOutputStream.writeBytes(paramString2);
        localDataOutputStream.flush();
        localDataOutputStream.close();
        localDataOutputStream = null;
      }
      catch (IOException localIOException2)
      {
        if (this.verbose) {
          trace(str2, "<IOException while writing data : " + localIOException2.toString() + "><TxnNo-->" + this.TxnNo + ">" + "<MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while writing data. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Written data on the output stream><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      try
      {
        localInputStream = localHttpURLConnection.getInputStream();
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
        localStringBuffer = new StringBuffer();
        while ((str1 = localBufferedReader.readLine()) != null) {
          if (str1.length() != 0) {
            localStringBuffer.append(str1.trim());
          }
        }
        localBufferedReader.close();
        localBufferedReader = null;
        trace(str2, "<Total transaction Response string value><" + localStringBuffer.toString() + ">");
      }
      catch (IOException localIOException3)
      {
        if (this.verbose) {
          trace(str2, "<IOException while reading response : " + localIOException3.toString() + "><TxnNo-->" + this.TxnNo + ">" + "<MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while reading data. Transaction cannot be processed");
      }
      if (this.verbose) {
        trace(str2, "<Read response on the stream><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      return localStringBuffer.toString();
    }
    catch (SFAApplicationException localSFAApplicationException)
    {
      throw localSFAApplicationException;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace(str2, "<Error while posting data : " + localException1.toString() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      throw new SFAApplicationException("Error while posting data. Transaction cannot be processed");
    }
    finally
    {
      try
      {
        if (localHttpURLConnection != null)
        {
          localHttpURLConnection.disconnect();
          trace(str2, "Close the URL connection><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
      }
      catch (Exception localException2) {}
      localURL1 = null;
      localURL2 = null;
      localHttpURLConnection = null;
      localInputStream = null;
      localDataOutputStream = null;
      localBufferedReader = null;
      localStringBuffer = null;
      str1 = null;
    }
  }
  
  public PGResponse postRelated(Merchant paramMerchant)
  {
    String str1 = "postRelated";
    EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = null;
    String str2 = null;
    try
    {
      this.TxnNo = GetTxnSerialNo();
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><Entered>");
      }
      if (paramMerchant == null)
      {
        if (this.verbose) {
          trace(str1, " <Merchant Object passed is null><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid merchant object passed. Transaction cannot proceed.");
      }
      this.strMerchantTxnId = paramMerchant.getMerchantTxnID();
      if ((paramMerchant.getMerchantID() == null) || ("".equals(paramMerchant.getMerchantID())))
      {
        if (this.verbose) {
          trace(str1, "<Merchant Id passed is null><TxnNo-->" + this.TxnNo + ">");
        }
        throw new SFAApplicationException("Invalid merchant id passed. Transaction cannot proceed.");
      }
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Entered>");
      }
      if (paramMerchant.getRootTxnSysRefNum() == null)
      {
        if (this.verbose) {
          trace(str1, "<Previous txn refrence no is null><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Invalid root txn ref number passed. Transaction cannot proceed.");
      }
      if (paramMerchant.getMessageType() == null)
      {
        if (this.verbose) {
          trace(str1, "<Message Type passed is null><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Invalid message type passed. Transaction cannot proceed.");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      
      localStringBuffer.append(buildMerchantRelatedTxn(paramMerchant));
      try
      {
        localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
        str2 = localEPGMerchantEncryptionLib.encryptMerchantData(paramMerchant.getMerchantID(), this.strKeyDir, paramMerchant.getMerchantTxnID(), paramMerchant.getAmount());
      }
      catch (SFAApplicationException localSFAApplicationException2)
      {
        if (this.verbose) {
          trace(str1, "<SFAApplicationException in encrypting data" + localSFAApplicationException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw localSFAApplicationException2;
      }
      catch (Exception localException2)
      {
        if (this.verbose) {
          trace(str1, "<Exception in encrypting data. " + localException2.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
        }
        throw new SFAApplicationException("Error while encrypting data. Transaction cannot be processed.");
      }
      localStringBuffer.append("&EncryptedData=" + str2);
      localStringBuffer.append("&OsType=" + this.strOsType);
      localStringBuffer.append("&LanguageType=" + paramMerchant.getLanguageCode());
      localStringBuffer.append("&RequestType=RelatedTxn");
      
      String localObject1 = postData(this.epgURL, localStringBuffer.toString());
      
      return new PGResponse((String)localObject1);
    }
    catch (SFAApplicationException localSFAApplicationException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception :" + localSFAApplicationException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject1 = new PGResponse();
      ((PGResponse)localObject1).setRespCode("2");
      ((PGResponse)localObject1).setRespMessage(localSFAApplicationException1.getMessage());
      ((PGResponse)localObject1).setTxnId(this.strMerchantTxnId);
      return localObject1;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace("postRelatedTxn", "<Exception :" + localException1.getMessage() + "><TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + ">");
      }
      PGResponse localObject2 = new PGResponse();
      ((PGResponse)localObject2).setRespCode("2");
      ((PGResponse)localObject2).setRespMessage("Internal Processing Error");
      ((PGResponse)localObject2).setTxnId(this.strMerchantTxnId);
      return localObject2;
    }
    finally
    {
      localEPGMerchantEncryptionLib = null;
      str2 = null;
      if (this.verbose) {
        trace(str1, "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Exiting>");
      }
    }
  }
  
  public PGResponse postRelatedTxn(Merchant paramMerchant)
  {
    if (paramMerchant != null) {
      paramMerchant.setLanguageCode("Java");
    }
    return postRelated(paramMerchant);
  }
  
  public PGSearchResponse postStatusInq(Merchant paramMerchant)
  {
    if (paramMerchant != null) {
      paramMerchant.setLanguageCode("Java");
    }
    return postStatusInquiry(paramMerchant);
  }
  
  public PGSearchResponse postSearchTransaction(Merchant paramMerchant)
  {
    if (paramMerchant != null) {
      paramMerchant.setLanguageCode("Java");
    }
    return postTxnSearch(paramMerchant);
  }
  
  public PGSearchResponse postStatusInquiry(Merchant paramMerchant)
  {
    String str1 = "postStatusInquiry";
    EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = null;
    String str2 = null;
    try
    {
      if (this.verbose) {
        trace(str1, "<Entered>");
      }
      if (paramMerchant == null)
      {
        if (this.verbose) {
          trace(str1, "<Merchant object passed is null>");
        }
        throw new SFAApplicationException("Merchant object is null");
      }
      if ((paramMerchant.getMerchantID() == null) || ("".equals(paramMerchant.getMerchantID())))
      {
        if (this.verbose) {
          trace(str1, "<Merchant Id passed is null>");
        }
        throw new SFAApplicationException("Merchant Id is null or Invalid");
      }
      if (paramMerchant.getMerchantTxnID() == null)
      {
        if (this.verbose) {
          trace(str1, " <Merchant Transaction Id passed is null>");
        }
        throw new SFAApplicationException("Merchant Transaction Id is null");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      
      localStringBuffer.append("MerchantID=" + getValue(paramMerchant.getMerchantID()));
      appendData("MerchantTxnID", paramMerchant.getMerchantTxnID(), localStringBuffer);
      try
      {
        localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
        str2 = localEPGMerchantEncryptionLib.encryptMerchantData(paramMerchant.getMerchantID(), this.strKeyDir, paramMerchant.getMerchantTxnID(), paramMerchant.getAmount());
      }
      catch (SFAApplicationException localSFAApplicationException2)
      {
        if (this.verbose) {
          trace(str1, "<SFAApplicationException in encrypting data. " + localSFAApplicationException2.getMessage() + ">");
        }
        throw localSFAApplicationException2;
      }
      catch (Exception localException2)
      {
        if (this.verbose) {
          trace(str1, "<Exception in encrypting data. " + localException2.getMessage() + ">");
        }
        throw new SFAApplicationException("Error while encrypting data. Transaction cannot be processed.");
      }
      appendData("EncryptedData", str2, localStringBuffer);
      appendData("OsType", this.strOsType, localStringBuffer);
      appendData("LanguageType", paramMerchant.getLanguageCode(), localStringBuffer);
      appendData("RequestType", "SFAStatusInquiry", localStringBuffer);
      
      String localObject1 = postSearchData(this.epgURL, localStringBuffer.toString());
      return new PGSearchResponse((String)localObject1);
    }
    catch (SFAApplicationException localSFAApplicationException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception :" + localSFAApplicationException1.getMessage() + ">");
      }
      PGSearchResponse localObject1 = new PGSearchResponse();
      ((PGSearchResponse)localObject1).setRespCode("2");
      ((PGSearchResponse)localObject1).setRespMessage(localSFAApplicationException1.getMessage());
      return localObject1;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception :" + localException1.getMessage() + ">");
      }
      PGSearchResponse localObject2 = new PGSearchResponse();
      ((PGSearchResponse)localObject2).setRespCode("2");
      ((PGSearchResponse)localObject2).setRespMessage("Internal Processing Error");
      return localObject2;
    }
    finally
    {
      localEPGMerchantEncryptionLib = null;
      str2 = null;
      if (this.verbose) {
        trace(str1, " <Exiting>");
      }
    }
  }
  
  public PGSearchResponse postTxnSearch(Merchant paramMerchant)
  {
    String str1 = "postTxnSearch";
    EPGMerchantEncryptionLib localEPGMerchantEncryptionLib = null;
    String str2 = null;
    try
    {
      if (this.verbose) {
        trace(str1, "<Entered>");
      }
      if (paramMerchant == null)
      {
        if (this.verbose) {
          trace(str1, "<Merchant object passed is null>");
        }
        throw new SFAApplicationException("Merchant object is null");
      }
      if ((paramMerchant.getMerchantID() == null) || ("".equals(paramMerchant.getMerchantID())))
      {
        if (this.verbose) {
          trace(str1, "<Merchant Id passed is null>");
        }
        throw new SFAApplicationException("Merchant Id is null or Invalid");
      }
      if (paramMerchant.getStartDate() == null)
      {
        if (this.verbose) {
          trace(str1, "<Merchant txn Start Date is null>");
        }
        throw new SFAApplicationException("Merchant txn Start Date is null");
      }
      if (paramMerchant.getEndDate() == null)
      {
        if (this.verbose) {
          trace(str1, "<Merchant txn End Date is null>");
        }
        throw new SFAApplicationException("Merchant txn End Date is null");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      
      localStringBuffer.append("MerchantID=" + getValue(paramMerchant.getMerchantID()));
      appendData("StartDate", paramMerchant.getStartDate(), localStringBuffer);
      appendData("EndDate", paramMerchant.getEndDate(), localStringBuffer);
      try
      {
        localEPGMerchantEncryptionLib = new EPGMerchantEncryptionLib();
        str2 = localEPGMerchantEncryptionLib.encryptMerchantData(paramMerchant.getMerchantID(), this.strKeyDir, paramMerchant.getMerchantTxnID(), paramMerchant.getAmount());
      }
      catch (SFAApplicationException localSFAApplicationException2)
      {
        if (this.verbose) {
          trace(str1, "<SFAApplicationException in encrypting data. " + localSFAApplicationException2.getMessage() + ">");
        }
        throw localSFAApplicationException2;
      }
      catch (Exception localException2)
      {
        if (this.verbose) {
          trace(str1, "<Exception in encrypting data. " + localException2.getMessage() + ">");
        }
        throw new SFAApplicationException("Error while encrypting data. Transaction cannot be processed.");
      }
      appendData("EncryptedData", str2, localStringBuffer);
      appendData("OsType", this.strOsType, localStringBuffer);
      appendData("LanguageType", paramMerchant.getLanguageCode(), localStringBuffer);
      appendData("RequestType", "SFATxnSearch", localStringBuffer);
      

      String localObject1 = postSearchData(this.epgURL, localStringBuffer.toString());
      return new PGSearchResponse((String)localObject1);
    }
    catch (SFAApplicationException localSFAApplicationException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception :" + localSFAApplicationException1.getMessage() + ">");
      }
      PGSearchResponse localObject1 = new PGSearchResponse();
      ((PGSearchResponse)localObject1).setRespCode("2");
      ((PGSearchResponse)localObject1).setRespMessage(localSFAApplicationException1.getMessage());
      return localObject1;
    }
    catch (Exception localException1)
    {
      if (this.verbose) {
        trace(str1, "<Exception :" + localException1.getMessage() + ">");
      }
      PGSearchResponse localObject2 = new PGSearchResponse();
      ((PGSearchResponse)localObject2).setRespCode("2");
      ((PGSearchResponse)localObject2).setRespMessage("Internal Processing Error");
      return localObject2;
    }
    finally
    {
      localEPGMerchantEncryptionLib = null;
      str2 = null;
      if (this.verbose) {
        trace(str1, " <Exiting>");
      }
    }
  }
  
  private String buildMerchantRelatedTxn(Merchant paramMerchant)
  {
    try
    {
      if (this.verbose) {
        trace("buildMerchantRelatedTxn", "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Entered>");
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("MerchantID=" + getValue(paramMerchant.getMerchantID()));
      appendData("Vendor", paramMerchant.getVendor(), localStringBuffer);
      appendData("Partner", paramMerchant.getPartner(), localStringBuffer);
      appendData("CurrCode", paramMerchant.getCurrCode(), localStringBuffer);
      appendData("RootTxnSysRefNum", paramMerchant.getRootTxnSysRefNum(), localStringBuffer);
      appendData("RootPNRefNum", paramMerchant.getRootPNRefNum(), localStringBuffer);
      appendData("RootAuthCode", paramMerchant.getRootAuthCode(), localStringBuffer);
      appendData("MessageType", paramMerchant.getMessageType(), localStringBuffer);
      appendData("Amount", paramMerchant.getAmount(), localStringBuffer);
      appendData("Ext1", paramMerchant.getExt1(), localStringBuffer);
      appendData("Ext2", paramMerchant.getExt2(), localStringBuffer);
      appendData("Ext3", paramMerchant.getExt3(), localStringBuffer);
      appendData("Ext4", paramMerchant.getExt4(), localStringBuffer);
      appendData("Ext5", paramMerchant.getExt5(), localStringBuffer);
      appendData("MrtIpAddr", paramMerchant.getMrtIPAddress(), localStringBuffer);
      appendData("MerchantTxnID", paramMerchant.getMerchantTxnID(), localStringBuffer);
      appendData("GMTOffset", paramMerchant.getGMTTimeOffset(), localStringBuffer);
      
      return localStringBuffer.toString();
    }
    finally
    {
      if (this.verbose) {
        trace("buildMerchantRelatedTxn", "<TxnNo-->" + this.TxnNo + "><MrtTxnID-->" + this.strMerchantTxnId + "><Exiting>");
      }
    }
  }
  
  private void appendData(String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    if (paramString2 != null) {
      paramStringBuffer.append("&" + paramString1 + "=" + getValue(paramString2));
    }
  }
  
  private void trace(String paramString1, String paramString2)
  {
    try
    {
      System.out.println("[" + new Timestamp(System.currentTimeMillis()).toString() + "]" + " <PostLib><" + paramString1 + ">" + paramString2);
      if (fos == null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        fos = new FileWriter("" + traceLog + "traceLog_" + localSimpleDateFormat.format(new Date()) + ".txt", true);
      }
      if (pw == null) {
        pw = new PrintWriter(fos, true);
      }
      pw.println("[" + new Timestamp(System.currentTimeMillis()).toString() + "]" + " <PostLib><" + paramString1 + ">" + paramString2);
    }
    catch (IOException localIOException)
    {
      System.out.println("Append IO error:" + localIOException);
      pw = null;
      fos = null;
    }
  }
  
  private String buildCustomerDetail(CustomerDetails paramCustomerDetails)
  {
    if (this.verbose) {
      System.out.println("<PostLib> <buildCustomerDetail> Entered ");
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Address localAddress1 = null;
    Address localAddress2 = null;
    if (paramCustomerDetails != null)
    {
      localAddress1 = paramCustomerDetails.getOfficeAddress();
      localAddress2 = paramCustomerDetails.getHomeAddress();
    }
    localStringBuffer.append("&CustInfoPresent=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getCustAvailFlag()));
    localStringBuffer.append("&FirstName=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getFirstName()));
    localStringBuffer.append("&LastName=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getLastName()));
    localStringBuffer.append("&MobileNo=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getMobileNo()));
    localStringBuffer.append("&RegistrationDate=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getRegDate()));
    localStringBuffer.append("&IsBillNShipAddrMatch=" + getValue(paramCustomerDetails == null ? null : paramCustomerDetails.getBillNShipAddrMatch()));
    
    localStringBuffer.append("&OfficeAddrLine1=" + getValue(localAddress1 == null ? null : localAddress1.getAddrLine1()));
    localStringBuffer.append("&OfficeAddrLine2=" + getValue(localAddress1 == null ? null : localAddress1.getAddrLine2()));
    localStringBuffer.append("&OfficeAddrLine3=" + getValue(localAddress1 == null ? null : localAddress1.getAddrLine3()));
    localStringBuffer.append("&OfficeCity=" + getValue(localAddress1 == null ? null : localAddress1.getCity()));
    localStringBuffer.append("&OfficeState=" + getValue(localAddress1 == null ? null : localAddress1.getState()));
    localStringBuffer.append("&OfficeZip=" + getValue(localAddress1 == null ? null : localAddress1.getZip()));
    localStringBuffer.append("&OfficeCountryAlphaCode=" + getValue(localAddress1 == null ? null : localAddress1.getCountryAlphaCode()));
    
    localStringBuffer.append("&HomeAddrLine1=" + getValue(localAddress2 == null ? null : localAddress2.getAddrLine1()));
    localStringBuffer.append("&HomeAddrLine2=" + getValue(localAddress2 == null ? null : localAddress2.getAddrLine2()));
    localStringBuffer.append("&HomeAddrLine3=" + getValue(localAddress2 == null ? null : localAddress2.getAddrLine3()));
    localStringBuffer.append("&HomeCity=" + getValue(localAddress2 == null ? null : localAddress2.getCity()));
    localStringBuffer.append("&HomeState=" + getValue(localAddress2 == null ? null : localAddress2.getState()));
    localStringBuffer.append("&HomeZip=" + getValue(localAddress2 == null ? null : localAddress2.getZip()));
    localStringBuffer.append("&HomeCountryAlphaCode=" + getValue(localAddress2 == null ? null : localAddress2.getCountryAlphaCode()));
    if (this.verbose) {
      System.out.println("<PostLib> <buildCustomerDetail> Exiting");
    }
    return localStringBuffer.toString();
  }
  
  private String buildAirlLineAndMerchanDise(AirLineTransaction paramAirLineTransaction, MerchanDise paramMerchanDise)
  {
    if (this.verbose) {
      System.out.println("<PostLib> <buildAirlLineAndMerchanDise> Entered ");
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("&AirLineInfoPresent=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getAirLineFlag()));
    localStringBuffer.append("&BookingDate=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getBookingDate()));
    localStringBuffer.append("&FlightDate=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getFlightDate()));
    localStringBuffer.append("&FlightTime=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getFlighttime()));
    localStringBuffer.append("&FlightNumber=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getFlightNumber()));
    localStringBuffer.append("&PassengerName=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getPassengerName()));
    localStringBuffer.append("&NumberOfTickets=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getNumberOfTickets()));
    localStringBuffer.append("&CardNameNCustomerNameMatch=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getIsCardNameNCustomerNameMatch()));
    localStringBuffer.append("&PNR=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getPNR()));
    localStringBuffer.append("&SectorFrom=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getSectorFrom()));
    localStringBuffer.append("&SectorTo=" + getValue(paramAirLineTransaction == null ? null : paramAirLineTransaction.getSecotrTo()));
    
    localStringBuffer.append("&MerchantDiseInfoPresent=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getMerchantFlag()));
    localStringBuffer.append("&ItemPurchased=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getItemPurchased()));
    localStringBuffer.append("&Quantity=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getQuantity()));
    localStringBuffer.append("&Brand=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getBrand()));
    localStringBuffer.append("&ModelNumber=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getModelNumber()));
    localStringBuffer.append("&BuyersName=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getBuyersName()));
    localStringBuffer.append("&CardNameNBuyerNameMatch=" + getValue(paramMerchanDise == null ? null : paramMerchanDise.getIsCardNameNBuyerNameMatch()));
    if (this.verbose) {
      System.out.println("<PostLib> <buildAirlLineAndMerchanDise> Exiting");
    }
    return localStringBuffer.toString();
  }
}
