/*   1:    */ package com.opus.epg.sfa.java;
/*   2:    */ 
/*   3:    */ import java.net.URLDecoder;
/*   4:    */ import java.util.Hashtable;
/*   5:    */ import java.util.StringTokenizer;
/*   6:    */ 
/*   7:    */ public class PGResponse
/*   8:    */ {
/*   9:    */   private String strRespCode;
/*  10:    */   private String strRespMessage;
/*  11:    */   private String strTxnId;
/*  12:    */   private String strEPGTxnId;
/*  13:    */   private String strRedirectionTxnId;
/*  14:    */   private String strRedirectionUrl;
/*  15:    */   private String strAuthIdCode;
/*  16:    */   private String strRRN;
/*  17:    */   private String strTxnType;
/*  18:    */   private String strTxnDateTime;
/*  19:    */   private String strCVRespCode;
/*  20:    */   private String strCookie;
/*  21:    */   private String strFDMSResult;
/*  22:    */   private String strFDMSScore;
/*  23:    */   private String strReserveFld1;
/*  24:    */   private String strReserveFld2;
/*  25:    */   private String strReserveFld3;
/*  26:    */   private String strReserveFld4;
/*  27:    */   private String strReserveFld5;
/*  28:    */   private String strReserveFld6;
/*  29:    */   private String strReserveFld7;
/*  30:    */   private String strReserveFld8;
/*  31:    */   private String strReserveFld9;
/*  32:    */   private String strReserveFld10;
/*  33:    */   private static final String PG_RESP_RESPCODE = "RespCode";
/*  34:    */   private static final String PG_RESP_RESPMSG = "Message";
/*  35:    */   private static final String PG_RESP_EPG_TXN_ID = "ePGTxnID";
/*  36:    */   private static final String PG_RESP_MRT_TXN_ID = "TxnID";
/*  37:    */   private static final String PG_RESP_REDIRECT_TXN_ID = "RedirectionTxnID";
/*  38:    */   private static final String PG_RESP_AUTH_ID = "AuthIdCode";
/*  39:    */   private static final String PG_RESP_RRN = "RRN";
/*  40:    */   private static final String PG_RESP_TXNTYPE = "TxnType";
/*  41:    */   private static final String PG_RESP_TXN_DATE_TIME = "TxnDateTime";
/*  42:    */   private static final String PG_RESP_CVRESP_CODE = "CVRespCode";
/*  43:    */   private static final String PG_RESP_RESERVE1 = "Reserve1";
/*  44:    */   private static final String PG_RESP_RESERVE2 = "Reserve2";
/*  45:    */   private static final String PG_RESP_RESERVE3 = "Reserve3";
/*  46:    */   private static final String PG_RESP_RESERVE4 = "Reserve4";
/*  47:    */   private static final String PG_RESP_RESERVE5 = "Reserve5";
/*  48:    */   private static final String PG_RESP_RESERVE6 = "Reserve6";
/*  49:    */   private static final String PG_RESP_RESERVE7 = "Reserve7";
/*  50:    */   private static final String PG_RESP_RESERVE8 = "Reserve8";
/*  51:    */   private static final String PG_RESP_RESERVE9 = "Reserve9";
/*  52:    */   private static final String PG_RESP_RESERVE10 = "Reserve10";
/*  53:    */   private static final String PG_RESP_COOKIE = "Cookie";
/*  54:    */   private static final String PG_RESP_FDMSRESULT = "FDMSResult";
/*  55:    */   private static final String PG_RESP_FDMSSCORE = "FDMSScore";
/*  56:    */   
/*  57:    */   public String getCVRespCode()
/*  58:    */   {
/*  59: 68 */     return this.strCVRespCode;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setCVRespCode(String paramString)
/*  63:    */   {
/*  64: 72 */     this.strCVRespCode = paramString;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getCookie()
/*  68:    */   {
/*  69: 77 */     return this.strCookie;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setCookie(String paramString)
/*  73:    */   {
/*  74: 81 */     this.strCookie = paramString;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getFDMSResult()
/*  78:    */   {
/*  79: 84 */     return this.strFDMSResult;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setFDMSResult(String paramString)
/*  83:    */   {
/*  84: 87 */     this.strFDMSResult = paramString;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getFDMSScore()
/*  88:    */   {
/*  89: 90 */     return this.strFDMSScore;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setFDMSScore(String paramString)
/*  93:    */   {
/*  94: 93 */     this.strFDMSScore = paramString;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getReserveFld1()
/*  98:    */   {
/*  99: 96 */     return this.strReserveFld1;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setReserveFld1(String paramString)
/* 103:    */   {
/* 104:100 */     this.strReserveFld1 = paramString;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getReserveFld2()
/* 108:    */   {
/* 109:104 */     return this.strReserveFld2;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setReserveFld2(String paramString)
/* 113:    */   {
/* 114:108 */     this.strReserveFld2 = paramString;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getReserveFld3()
/* 118:    */   {
/* 119:112 */     return this.strReserveFld3;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setReserveFld3(String paramString)
/* 123:    */   {
/* 124:116 */     this.strReserveFld3 = paramString;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getReserveFld4()
/* 128:    */   {
/* 129:120 */     return this.strReserveFld4;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setReserveFld4(String paramString)
/* 133:    */   {
/* 134:124 */     this.strReserveFld4 = paramString;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String getReserveFld5()
/* 138:    */   {
/* 139:128 */     return this.strReserveFld5;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setReserveFld5(String paramString)
/* 143:    */   {
/* 144:132 */     this.strReserveFld5 = paramString;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getReserveFld6()
/* 148:    */   {
/* 149:136 */     return this.strReserveFld6;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setReserveFld6(String paramString)
/* 153:    */   {
/* 154:140 */     this.strReserveFld6 = paramString;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getReserveFld7()
/* 158:    */   {
/* 159:144 */     return this.strReserveFld7;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setReserveFld7(String paramString)
/* 163:    */   {
/* 164:148 */     this.strReserveFld7 = paramString;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getReserveFld8()
/* 168:    */   {
/* 169:152 */     return this.strReserveFld8;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setReserveFld8(String paramString)
/* 173:    */   {
/* 174:156 */     this.strReserveFld8 = paramString;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String getReserveFld9()
/* 178:    */   {
/* 179:160 */     return this.strReserveFld9;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setReserveFld9(String paramString)
/* 183:    */   {
/* 184:164 */     this.strReserveFld9 = paramString;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public String getReserveFld10()
/* 188:    */   {
/* 189:168 */     return this.strReserveFld10;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setReserveFld10(String paramString)
/* 193:    */   {
/* 194:172 */     this.strReserveFld10 = paramString;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public String getRespCode()
/* 198:    */   {
/* 199:180 */     return this.strRespCode;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setRespCode(String paramString)
/* 203:    */   {
/* 204:184 */     this.strRespCode = paramString;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public String getRespMessage()
/* 208:    */   {
/* 209:188 */     return this.strRespMessage;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setRespMessage(String paramString)
/* 213:    */   {
/* 214:193 */     this.strRespMessage = paramString;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public String getTxnId()
/* 218:    */   {
/* 219:197 */     return this.strTxnId;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setTxnId(String paramString)
/* 223:    */   {
/* 224:202 */     this.strTxnId = paramString;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public String getEpgTxnId()
/* 228:    */   {
/* 229:206 */     return this.strEPGTxnId;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setEpgTxnId(String paramString)
/* 233:    */   {
/* 234:211 */     this.strEPGTxnId = paramString;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String getRedirectionTxnId()
/* 238:    */   {
/* 239:216 */     return this.strRedirectionTxnId;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void setRedirectionTxnId(String paramString)
/* 243:    */   {
/* 244:220 */     this.strRedirectionTxnId = paramString;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public String getRedirectionUrl()
/* 248:    */   {
/* 249:225 */     return this.strRedirectionUrl;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void setRedirectionUrl(String paramString)
/* 253:    */   {
/* 254:230 */     this.strRedirectionUrl = paramString;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public String getAuthIdCode()
/* 258:    */   {
/* 259:235 */     return this.strAuthIdCode;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public void setAuthIdCode(String paramString)
/* 263:    */   {
/* 264:240 */     this.strAuthIdCode = paramString;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public String getRRN()
/* 268:    */   {
/* 269:244 */     return this.strRRN;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setRRN(String paramString)
/* 273:    */   {
/* 274:248 */     this.strRRN = paramString;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public String getTxnType()
/* 278:    */   {
/* 279:252 */     return this.strTxnType;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setTxnType(String paramString)
/* 283:    */   {
/* 284:256 */     this.strTxnType = paramString;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public void setTxnDateTime(String paramString)
/* 288:    */   {
/* 289:260 */     this.strTxnDateTime = paramString;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public String getTxnDateTime()
/* 293:    */   {
/* 294:264 */     return this.strTxnDateTime;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public PGResponse() {}
/* 298:    */   
/* 299:    */   public PGResponse(String paramString)
/* 300:    */   {
/* 301:272 */     Hashtable localHashtable = new Hashtable();
/* 302:    */     try
/* 303:    */     {
/* 304:    */       try
/* 305:    */       {
/* 306:275 */         StringTokenizer localStringTokenizer1 = new StringTokenizer(URLDecoder.decode(paramString), "&");
/* 307:276 */         while (localStringTokenizer1.hasMoreElements()) {
/* 308:    */           try
/* 309:    */           {
/* 310:278 */             String str1 = localStringTokenizer1.nextToken();
/* 311:279 */             StringTokenizer localStringTokenizer2 = new StringTokenizer(str1, "=");
/* 312:280 */             String str2 = localStringTokenizer2.nextToken();
/* 313:281 */             String str3 = localStringTokenizer2.nextToken();
/* 314:282 */             localHashtable.put(str2, str3);
/* 315:    */           }
/* 316:    */           catch (Exception localException3) {}
/* 317:    */         }
/* 318:    */       }
/* 319:    */       catch (Exception localException1) {}
/* 320:290 */       this.strRespCode = ((String)localHashtable.get("RespCode"));
/* 321:291 */       this.strRespMessage = ((String)localHashtable.get("Message"));
/* 322:292 */       this.strTxnId = ((String)localHashtable.get("TxnID"));
/* 323:293 */       this.strEPGTxnId = ((String)localHashtable.get("ePGTxnID"));
/* 324:294 */       this.strRedirectionTxnId = ((String)localHashtable.get("RedirectionTxnID"));
/* 325:295 */       this.strAuthIdCode = ((String)localHashtable.get("AuthIdCode"));
/* 326:296 */       this.strRRN = ((String)localHashtable.get("RRN"));
/* 327:297 */       this.strTxnType = ((String)localHashtable.get("TxnType"));
/* 328:298 */       this.strTxnDateTime = ((String)localHashtable.get("TxnDateTime"));
/* 329:299 */       this.strCVRespCode = ((String)localHashtable.get("CVRespCode"));
/* 330:300 */       this.strCookie = ((String)localHashtable.get("Cookie"));
/* 331:301 */       this.strFDMSResult = ((String)localHashtable.get("FDMSResult"));
/* 332:302 */       this.strFDMSScore = ((String)localHashtable.get("FDMSScore"));
/* 333:303 */       this.strReserveFld1 = ((String)localHashtable.get("Reserve1"));
/* 334:304 */       this.strReserveFld2 = ((String)localHashtable.get("Reserve2"));
/* 335:305 */       this.strReserveFld3 = ((String)localHashtable.get("Reserve3"));
/* 336:306 */       this.strReserveFld4 = ((String)localHashtable.get("Reserve4"));
/* 337:307 */       this.strReserveFld5 = ((String)localHashtable.get("Reserve5"));
/* 338:308 */       this.strReserveFld6 = ((String)localHashtable.get("Reserve6"));
/* 339:309 */       this.strReserveFld7 = ((String)localHashtable.get("Reserve7"));
/* 340:310 */       this.strReserveFld8 = ((String)localHashtable.get("Reserve8"));
/* 341:311 */       this.strReserveFld9 = ((String)localHashtable.get("Reserve9"));
/* 342:312 */       this.strReserveFld10 = ((String)localHashtable.get("Reserve10"));
/* 343:    */     }
/* 344:    */     catch (Exception localException2) {}
/* 345:    */   }
/* 346:    */   
/* 347:    */   public String toString()
/* 348:    */   {
/* 349:319 */     return "strRespCode: " + this.strRespCode + "\n" + "strRespMessage : " + this.strRespMessage + "\n" + "strRedirectionTxnId : " + this.strRedirectionTxnId + "\n" + "strTxnId : " + this.strTxnId + "\n" + "strEPGTxnId : " + this.strEPGTxnId + "\n" + "strAuthIdCode : " + this.strAuthIdCode + "\n" + "strRRN : " + this.strRRN + "\n" + "strTxnType : " + this.strTxnType + "\n" + "strTxnDateTime : " + this.strTxnDateTime + "\n" + "strCVRespCode : " + this.strTxnDateTime + "\n" + "strCookie : " + this.strCookie + "\n" + "strFDMSResult : " + this.strFDMSResult + "\n" + "strFDMSScore : " + this.strFDMSScore + "\n" + "strReserveFld1 : " + this.strReserveFld1 + "\n" + "strReserveFld2 : " + this.strReserveFld2 + "\n" + "strReserveFld3 : " + this.strReserveFld3 + "\n" + "strReserveFld4 : " + this.strReserveFld4 + "\n" + "strReserveFld5 : " + this.strReserveFld5 + "\n" + "strReserveFld6 : " + this.strReserveFld6 + "\n" + "strReserveFld7 : " + this.strReserveFld7 + "\n" + "strReserveFld8 : " + this.strReserveFld8 + "\n" + "strReserveFld9 : " + this.strReserveFld9 + "\n" + "strReserveFld10 : " + this.strReserveFld10 + "\n";
/* 350:    */   }
/* 351:    */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.PGResponse
 * JD-Core Version:    0.7.0.1
 */