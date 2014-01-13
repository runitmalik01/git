/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ public class ShipToAddress
/*  4:   */   extends Address
/*  5:   */ {
/*  6:   */   public String toString()
/*  7:   */   {
/*  8:10 */     return "The Ship  address is \nStreet   \t " + this.mstrAddLine1 + "\n" + "        \t " + this.mstrAddLine2 + "\n" + "       \t " + this.mstrAddLine3 + "\n" + "City\t\t " + this.mstrCity + "\n" + "State\t \t " + this.mstrState + "\n" + "Zip\t\t " + this.mstrZip + "\n" + "CountryAlphaCode    \t " + this.mstrCountryAlphaCode;
/*  9:   */   }
/* 10:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.ShipToAddress
 * JD-Core Version:    0.7.0.1
 */