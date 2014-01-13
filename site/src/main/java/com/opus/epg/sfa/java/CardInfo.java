/*   1:    */ package com.opus.epg.sfa.java;
/*   2:    */ 
/*   3:    */ public class CardInfo
/*   4:    */ {
/*   5:    */   private String mstrCardType;
/*   6:    */   private String mstrCardNum;
/*   7:    */   private String mstrExpDtYr;
/*   8:    */   private String mstrExpDtMon;
/*   9:    */   private String mstrCVVNum;
/*  10:    */   private String mstrNameOnCard;
/*  11:    */   private String mstrInstrType;
/*  12:    */   
/*  13:    */   public void setCardDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
/*  14:    */   {
/*  15: 67 */     this.mstrCardType = paramString1;
/*  16: 68 */     this.mstrCardNum = paramString2;
/*  17: 69 */     this.mstrCVVNum = paramString3;
/*  18: 70 */     this.mstrExpDtYr = paramString4;
/*  19: 71 */     this.mstrExpDtMon = paramString5;
/*  20: 72 */     this.mstrNameOnCard = paramString6;
/*  21: 73 */     this.mstrInstrType = paramString7;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public String getCardType()
/*  25:    */   {
/*  26: 78 */     return this.mstrCardType;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public String getCardNum()
/*  30:    */   {
/*  31: 83 */     return this.mstrCardNum;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getCVVNum()
/*  35:    */   {
/*  36: 88 */     return this.mstrCVVNum;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getExpDtYr()
/*  40:    */   {
/*  41: 93 */     return this.mstrExpDtYr;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getExpDtMon()
/*  45:    */   {
/*  46: 98 */     return this.mstrExpDtMon;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getNameOnCard()
/*  50:    */   {
/*  51:103 */     return this.mstrNameOnCard;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getInstrType()
/*  55:    */   {
/*  56:108 */     return this.mstrInstrType;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String toString()
/*  60:    */   {
/*  61:113 */     return "The Card Details are \nCardType   \t " + this.mstrCardType + "\n" + "CardNumber \t " + this.mstrCardNum + "\n" + "CV Num\t\t " + this.mstrCVVNum + "\n" + "Card Name\t " + this.mstrNameOnCard;
/*  62:    */   }
/*  63:    */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.CardInfo
 * JD-Core Version:    0.7.0.1
 */