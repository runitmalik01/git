/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class MerchanDise
/*  4:   */ {
/*  5: 4 */   private String mstrItemPurchased = null;
/*  6: 5 */   private String mstrBuyersName = null;
/*  7: 6 */   private String mstrModelNumber = null;
/*  8: 7 */   private String mstrBrand = null;
/*  9: 8 */   private String mstrQuantity = null;
/* 10: 9 */   private String mstrIsCardNameNBuyerNameMatch = null;
/* 11:10 */   private String mstrDiseIsAvailable = null;
/* 12:   */   
/* 13:   */   public void setMerchanDiseDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
/* 14:   */   {
/* 15:17 */     this.mstrItemPurchased = paramString1;
/* 16:18 */     this.mstrQuantity = paramString2;
/* 17:19 */     this.mstrBrand = paramString3;
/* 18:20 */     this.mstrModelNumber = paramString4;
/* 19:21 */     this.mstrBuyersName = paramString5;
/* 20:22 */     this.mstrIsCardNameNBuyerNameMatch = paramString6;
/* 21:23 */     this.mstrDiseIsAvailable = "YES";
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getMerchantFlag()
/* 25:   */   {
/* 26:28 */     return this.mstrDiseIsAvailable;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getItemPurchased()
/* 30:   */   {
/* 31:32 */     return this.mstrItemPurchased;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getQuantity()
/* 35:   */   {
/* 36:36 */     return this.mstrQuantity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getBrand()
/* 40:   */   {
/* 41:40 */     return this.mstrBrand;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getModelNumber()
/* 45:   */   {
/* 46:44 */     return this.mstrModelNumber;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getBuyersName()
/* 50:   */   {
/* 51:49 */     return this.mstrBuyersName;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getIsCardNameNBuyerNameMatch()
/* 55:   */   {
/* 56:53 */     return this.mstrIsCardNameNBuyerNameMatch;
/* 57:   */   }
/* 58:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.MerchanDise
 * JD-Core Version:    0.7.0.1
 */