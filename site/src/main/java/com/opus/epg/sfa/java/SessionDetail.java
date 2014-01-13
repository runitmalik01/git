/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class SessionDetail
/*  4:   */ {
/*  5: 4 */   private String mstrTransactionIPAddr = null;
/*  6: 6 */   private String mstrBrowserCountry = null;
/*  7: 7 */   private String mstrBrowserLocalLang = null;
/*  8: 8 */   private String mstrBrowserLocalLangVariant = null;
/*  9: 9 */   private String mstrBrowserUserAgent = null;
/* 10:10 */   private String mstrSecureCookie = null;
/* 11:11 */   private String sessionDetailIsAvailable = null;
/* 12:   */   
/* 13:   */   public void setSessionDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
/* 14:   */   {
/* 15:17 */     this.mstrBrowserCountry = paramString3;
/* 16:18 */     this.mstrBrowserLocalLang = paramString4;
/* 17:19 */     this.mstrBrowserLocalLangVariant = paramString5;
/* 18:20 */     this.mstrBrowserUserAgent = paramString6;
/* 19:21 */     this.mstrSecureCookie = paramString2;
/* 20:22 */     this.mstrTransactionIPAddr = paramString1;
/* 21:23 */     this.sessionDetailIsAvailable = "YES";
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getSessionDetailFlag()
/* 25:   */   {
/* 26:28 */     return this.sessionDetailIsAvailable;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getTransactionIPAddr()
/* 30:   */   {
/* 31:32 */     return this.mstrTransactionIPAddr;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getBrowserCountry()
/* 35:   */   {
/* 36:37 */     return this.mstrBrowserCountry;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getBrowserLocalLang()
/* 40:   */   {
/* 41:41 */     return this.mstrBrowserLocalLang;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getBrowserLocalLangVariant()
/* 45:   */   {
/* 46:45 */     return this.mstrBrowserLocalLangVariant;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getBrowserUserAgent()
/* 50:   */   {
/* 51:49 */     return this.mstrBrowserUserAgent;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getSecureCookie()
/* 55:   */   {
/* 56:53 */     return this.mstrSecureCookie;
/* 57:   */   }
/* 58:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.SessionDetail
 * JD-Core Version:    0.7.0.1
 */