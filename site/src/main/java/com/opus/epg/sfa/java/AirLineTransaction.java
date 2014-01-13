/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class AirLineTransaction
/*  4:   */ {
/*  5: 4 */   private String mstrBookingDate = null;
/*  6: 5 */   private String mstrFlightDate = null;
/*  7: 6 */   private String mstrFlightTime = null;
/*  8: 7 */   private String mstrFlightNumber = null;
/*  9: 8 */   private String mstrPassengerName = null;
/* 10: 9 */   private String mstrNumberOfTickets = null;
/* 11:10 */   private String mstrIsCardNameNCustomerNameMatch = null;
/* 12:11 */   private String msrtPNR = null;
/* 13:12 */   private String mstrSectorFrom = null;
/* 14:13 */   private String mstrSectorTo = null;
/* 15:14 */   private String airLineInfoIsAvailable = null;
/* 16:   */   
/* 17:   */   public void setAirLineTransactionDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
/* 18:   */   {
/* 19:21 */     this.mstrBookingDate = paramString1;
/* 20:22 */     this.mstrFlightDate = paramString2;
/* 21:23 */     this.mstrFlightTime = paramString3;
/* 22:24 */     this.mstrFlightNumber = paramString4;
/* 23:25 */     this.mstrPassengerName = paramString5;
/* 24:26 */     this.mstrNumberOfTickets = paramString6;
/* 25:27 */     this.mstrIsCardNameNCustomerNameMatch = paramString7;
/* 26:28 */     this.msrtPNR = paramString8;
/* 27:29 */     this.mstrSectorFrom = paramString9;
/* 28:30 */     this.mstrSectorTo = paramString10;
/* 29:31 */     this.airLineInfoIsAvailable = "YES";
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getBookingDate()
/* 33:   */   {
/* 34:36 */     return this.mstrBookingDate;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getAirLineFlag()
/* 38:   */   {
/* 39:40 */     return this.airLineInfoIsAvailable;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getFlightDate()
/* 43:   */   {
/* 44:44 */     return this.mstrFlightDate;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getFlighttime()
/* 48:   */   {
/* 49:48 */     return this.mstrFlightTime;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getFlightNumber()
/* 53:   */   {
/* 54:52 */     return this.mstrFlightNumber;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getPassengerName()
/* 58:   */   {
/* 59:56 */     return this.mstrPassengerName;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public String getNumberOfTickets()
/* 63:   */   {
/* 64:60 */     return this.mstrNumberOfTickets;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getIsCardNameNCustomerNameMatch()
/* 68:   */   {
/* 69:64 */     return this.mstrIsCardNameNCustomerNameMatch;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public String getPNR()
/* 73:   */   {
/* 74:68 */     return this.msrtPNR;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public String getSectorFrom()
/* 78:   */   {
/* 79:72 */     return this.mstrSectorFrom;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public String getSecotrTo()
/* 83:   */   {
/* 84:76 */     return this.mstrSectorTo;
/* 85:   */   }
/* 86:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.AirLineTransaction
 * JD-Core Version:    0.7.0.1
 */