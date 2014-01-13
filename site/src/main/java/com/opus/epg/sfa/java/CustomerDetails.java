/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class CustomerDetails
/*  4:   */   extends Address
/*  5:   */ {
/*  6: 4 */   private Address mstrOfficeAddress = null;
/*  7: 5 */   private Address mstrHomeAddress = null;
/*  8: 6 */   private String mstrMobileNo = null;
/*  9: 7 */   private String mstrFirstName = null;
/* 10: 8 */   private String mstrLastName = null;
/* 11: 9 */   private String mstrRegDate = null;
/* 12:10 */   private String mstrIsBillNShipAddrMatch = null;
/* 13:11 */   private String custIsAvailable = null;
/* 14:   */   
/* 15:   */   public void setCustomerDetails(String paramString1, String paramString2, Address paramAddress1, Address paramAddress2, String paramString3, String paramString4, String paramString5)
/* 16:   */   {
/* 17:15 */     this.mstrOfficeAddress = paramAddress1;
/* 18:16 */     this.mstrHomeAddress = paramAddress2;
/* 19:17 */     this.mstrMobileNo = paramString3;
/* 20:18 */     this.mstrFirstName = paramString1;
/* 21:19 */     this.mstrLastName = paramString2;
/* 22:20 */     this.mstrRegDate = paramString4;
/* 23:21 */     this.mstrIsBillNShipAddrMatch = paramString5;
/* 24:22 */     this.custIsAvailable = "YES";
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getFirstName()
/* 28:   */   {
/* 29:26 */     return this.mstrFirstName;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getCustAvailFlag()
/* 33:   */   {
/* 34:30 */     return this.custIsAvailable;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getLastName()
/* 38:   */   {
/* 39:34 */     return this.mstrLastName;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getMobileNo()
/* 43:   */   {
/* 44:38 */     return this.mstrMobileNo;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getRegDate()
/* 48:   */   {
/* 49:42 */     return this.mstrRegDate;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getBillNShipAddrMatch()
/* 53:   */   {
/* 54:46 */     return this.mstrIsBillNShipAddrMatch;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Address getOfficeAddress()
/* 58:   */   {
/* 59:51 */     return this.mstrOfficeAddress;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Address getHomeAddress()
/* 63:   */   {
/* 64:55 */     return this.mstrHomeAddress;
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.CustomerDetails
 * JD-Core Version:    0.7.0.1
 */