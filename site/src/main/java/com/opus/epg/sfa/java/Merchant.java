/*   1:    */ package com.opus.epg.sfa.java;
/*   2:    */ 
/*   3:    */ import java.net.InetAddress;
/*   4:    */ 
/*   5:    */ public class Merchant
/*   6:    */ {
/*   7:    */   private String mstrMerchantID;
/*   8:    */   private String mstrOrderReferenceNo;
/*   9:    */   private String mstrMerchantTxnID;
/*  10:    */   private String mstrVendor;
/*  11:    */   private String mstrPartner;
/*  12:    */   private String mstrRespURL;
/*  13:    */   private String mstrRespMethod;
/*  14:    */   private String mstrExt1;
/*  15:    */   private String mstrExt2;
/*  16:    */   private String mstrExt3;
/*  17:    */   private String mstrExt4;
/*  18:    */   private String mstrExt5;
/*  19:    */   private String mstrCurrCode;
/*  20:    */   private String mstrMessageType;
/*  21:    */   private String mstrGMTTimeOffset;
/*  22:    */   private String mstrInvoiceNo;
/*  23:    */   private String moInvoiceDate;
/*  24:    */   private String mstrAmount;
/*  25:    */   private String mstrCustIPAddress;
/*  26:    */   private String mstrRootTxnSysRefNum;
/*  27:    */   private String mstrRootPNRefNum;
/*  28:    */   private String mstrRootAuthCode;
/*  29:    */   private String mstrLanguageCode;
/*  30:    */   private String mstrStartDate;
/*  31:    */   private String mstrEndDate;
/*  32:    */   
/*  33:    */   public void setMerchantDetails(String mstrMerchantID, String mstrVendor, String mstrPartner, String mstrCustIPAddress, String mstrMerchantTxnID, String mstrOrderReferenceNo, 
				String mstrRespURL, String mstrRespMethod, String mstrCurrCode, String mstrInvoiceNo, String mstrMessageType, String mstrAmount, 
				String mstrGMTTimeOffset, String mstrExt1, String mstrExt2, String mstrExt3, String mstrExt4, String mstrExt5)
/*  34:    */   {
/*  35:218 */     this.mstrMerchantID = mstrMerchantID;
/*  36:219 */     this.mstrVendor = mstrVendor;
/*  37:220 */     this.mstrPartner = mstrPartner;
/*  38:221 */     this.mstrCustIPAddress = mstrCustIPAddress;
/*  39:222 */     this.mstrMerchantTxnID = mstrMerchantTxnID;
/*  40:223 */     this.mstrOrderReferenceNo = mstrOrderReferenceNo;
/*  41:224 */     this.mstrRespURL = mstrRespURL;
/*  42:225 */     this.mstrRespMethod = mstrRespMethod;
/*  43:226 */     this.mstrCurrCode = mstrCurrCode;
/*  44:227 */     this.mstrInvoiceNo = mstrInvoiceNo;
/*  45:228 */     this.mstrMessageType = mstrMessageType;
/*  46:229 */     this.mstrAmount = mstrAmount;
/*  47:230 */     this.mstrGMTTimeOffset = mstrGMTTimeOffset;
/*  48:231 */     this.mstrExt1 = mstrExt1;
/*  49:232 */     this.mstrExt2 = mstrExt2;
/*  50:233 */     this.mstrExt3 = mstrExt3;
/*  51:234 */     this.mstrExt4 = mstrExt4;
/*  52:235 */     this.mstrExt5 = mstrExt5;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setMerchantRelatedTxnDetails(String mstrMerchantID, String mstrVendor, String mstrPartner, String mstrMerchantTxnID, 
				String mstrRootTxnSysRefNum, String mstrRootPNRefNum, String mstrRootAuthCode, String mstrRespURL, String mstrRespMethod, 
				String mstrCurrCode, String mstrMessageType, String mstrAmount, String mstrGMTTimeOffset, String mstrExt1,
				String mstrExt2, String mstrExt3, String mstrExt4, String mstrExt5)
/*  56:    */   {
/*  57:247 */     this.mstrMerchantID = mstrMerchantID;
					this.mstrVendor = mstrVendor;
/*  58:248 */     this.mstrPartner = mstrPartner;
/*  59:249 */     this.mstrMerchantTxnID = mstrMerchantTxnID;
/*  60:250 */     this.mstrRootTxnSysRefNum = mstrRootTxnSysRefNum;
/*  61:251 */     this.mstrRootPNRefNum = mstrRootPNRefNum;
/*  62:252 */     this.mstrRootAuthCode = mstrRootAuthCode;
/*  63:253 */     this.mstrRespURL = mstrRespURL;
/*  64:254 */     this.mstrRespMethod =mstrRespMethod;
/*  65:255 */     this.mstrCurrCode = mstrCurrCode;
/*  66:256 */     this.mstrMessageType = mstrMessageType;
/*  67:257 */     this.mstrAmount = mstrAmount;
/*  68:258 */     this.mstrGMTTimeOffset = mstrGMTTimeOffset;
/*  69:259 */     this.mstrExt1 = mstrExt1;
/*  70:260 */     this.mstrExt2 = mstrExt2;
/*  71:261 */     this.mstrExt3 = mstrExt3;
/*  72:262 */     this.mstrExt4 = mstrExt4;
/*  73:263 */     this.mstrExt5 = mstrExt5;
/*  74:264 */     
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setMerchantOnlineInquiry(String paramString1, String paramString2)
/*  78:    */   {
/*  79:270 */     this.mstrMerchantID = paramString1;
/*  80:271 */     this.mstrMerchantTxnID = paramString2;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setMerchantTxnSearch(String paramString1, String paramString2, String paramString3)
/*  84:    */   {
/*  85:276 */     this.mstrMerchantID = paramString1;
/*  86:277 */     this.mstrStartDate = paramString2;
/*  87:278 */     this.mstrEndDate = paramString3;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getLanguageCode()
/*  91:    */   {
/*  92:282 */     return this.mstrLanguageCode;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setLanguageCode(String paramString)
/*  96:    */   {
/*  97:286 */     this.mstrLanguageCode = paramString;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getStartDate()
/* 101:    */   {
/* 102:289 */     return this.mstrStartDate;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setStartDate(String paramString)
/* 106:    */   {
/* 107:293 */     this.mstrStartDate = paramString;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getEndDate()
/* 111:    */   {
/* 112:297 */     return this.mstrEndDate;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setEndDate(String paramString)
/* 116:    */   {
/* 117:301 */     this.mstrEndDate = paramString;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getMerchantID()
/* 121:    */   {
/* 122:304 */     return this.mstrMerchantID;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getMrtIPAddress()
/* 126:    */   {
/* 127:    */     try
/* 128:    */     {
/* 129:309 */       return InetAddress.getLocalHost().getHostAddress();
/* 130:    */     }
/* 131:    */     catch (Exception localException) {}
/* 132:311 */     return null;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public String getCustIPAddress()
/* 136:    */   {
/* 137:316 */     return this.mstrCustIPAddress;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getVendor()
/* 141:    */   {
/* 142:321 */     return this.mstrVendor;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String getPartner()
/* 146:    */   {
/* 147:326 */     return this.mstrPartner;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getOrderReferenceNo()
/* 151:    */   {
/* 152:331 */     return this.mstrOrderReferenceNo;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String getRespURL()
/* 156:    */   {
/* 157:336 */     return this.mstrRespURL;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getRespMethod()
/* 161:    */   {
/* 162:341 */     return this.mstrRespMethod;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public String getCurrCode()
/* 166:    */   {
/* 167:346 */     return this.mstrCurrCode;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getInvoiceNo()
/* 171:    */   {
/* 172:351 */     return this.mstrInvoiceNo;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String getInvoiceDate()
/* 176:    */   {
/* 177:356 */     return String.valueOf(System.currentTimeMillis());
/* 178:    */   }
/* 179:    */   
/* 180:    */   public String getMerchantTxnID()
/* 181:    */   {
/* 182:361 */     return this.mstrMerchantTxnID;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public String getMessageType()
/* 186:    */   {
/* 187:366 */     return this.mstrMessageType;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public String getAmount()
/* 191:    */   {
/* 192:371 */     return this.mstrAmount;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public String getGMTTimeOffset()
/* 196:    */   {
/* 197:376 */     return this.mstrGMTTimeOffset;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public String getExt1()
/* 201:    */   {
/* 202:381 */     return this.mstrExt1;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public String getExt2()
/* 206:    */   {
/* 207:386 */     return this.mstrExt2;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String getExt3()
/* 211:    */   {
/* 212:391 */     return this.mstrExt3;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public String getExt4()
/* 216:    */   {
/* 217:396 */     return this.mstrExt4;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public String getExt5()
/* 221:    */   {
/* 222:401 */     return this.mstrExt5;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public String getRootTxnSysRefNum()
/* 226:    */   {
/* 227:406 */     return this.mstrRootTxnSysRefNum;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String getRootPNRefNum()
/* 231:    */   {
/* 232:411 */     return this.mstrRootPNRefNum;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public String getRootAuthCode()
/* 236:    */   {
/* 237:416 */     return this.mstrRootAuthCode;
/* 238:    */   }
/* 239:    */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.Merchant
 * JD-Core Version:    0.7.0.1
 */