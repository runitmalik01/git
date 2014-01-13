/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class BillToAddress
/*  4:   */   extends Address
/*  5:   */ {
/*  6:10 */   private String mstrEmail = null;
/*  7:11 */   private String mstrCustomerId = null;
/*  8:12 */   private String mstrCustomerName = null;
/*  9:   */   
/* 10:   */   public void setAddressDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
/* 11:   */   {
/* 12:18 */     this.mstrCustomerId = paramString1;
/* 13:19 */     this.mstrCustomerName = paramString2;
/* 14:20 */     this.mstrEmail = paramString10;
/* 15:21 */     super.setAddressDetails(paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getEmail()
/* 19:   */   {
/* 20:26 */     return this.mstrEmail;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getCustomerId()
/* 24:   */   {
/* 25:31 */     return this.mstrCustomerId;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getName()
/* 29:   */   {
/* 30:36 */     return this.mstrCustomerName;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String toString()
/* 34:   */   {
/* 35:42 */     return "The Bill to address is \nCustomerId \t " + this.mstrCustomerId + "\n" + "CustomerName\t " + this.mstrCustomerName + "\n" + "Street   \t " + this.mstrAddLine1 + "\n" + "        \t " + this.mstrAddLine2 + "\n" + "       \t " + this.mstrAddLine3 + "\n" + "City\t\t " + this.mstrCity + "\n" + "State\t \t " + this.mstrState + "\n" + "Zip\t\t " + this.mstrZip + "\n" + "CountryAlphaCode    \t " + this.mstrCountryAlphaCode + "\n" + "Email\t \t " + this.mstrEmail;
/* 36:   */   }
/* 37:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.BillToAddress
 * JD-Core Version:    0.7.0.1
 */