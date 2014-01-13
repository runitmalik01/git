/*   1:    */ package com.opus.epg.sfa.java;
/*   2:    */ 
/*   3:    */ public class MPIData
/*   4:    */ {
/*   5: 14 */   private String mstrPurchaseAmount = null;
/*   6: 22 */   private String mstrDisplayAmount = null;
/*   7: 30 */   private String mstrCurrencyVal = null;
/*   8: 39 */   private String mstrExponent = null;
/*   9: 48 */   private String mstrOrderDesc = null;
/*  10: 55 */   private String mstrRecurFreq = null;
/*  11: 62 */   private String mstrRecurEnd = null;
/*  12: 69 */   private String mstrInstallment = null;
/*  13: 76 */   private String mstrDeviceCategory = null;
/*  14: 83 */   private String mstrWhatIUse = null;
/*  15: 92 */   private String mstrAcceptHdr = null;
/*  16:105 */   private String mstrAgentHdr = null;
/*  17:109 */   private String mstrShoppingContext = null;
/*  18:116 */   private String mstrVBVStatus = null;
/*  19:122 */   private String mstrCAVV = null;
/*  20:128 */   private String mstrECI = null;
/*  21:134 */   private String mstrXID = null;
/*  22:    */   
/*  23:    */   public String getECI()
/*  24:    */   {
/*  25:139 */     return this.mstrECI;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getXID()
/*  29:    */   {
/*  30:144 */     return this.mstrXID;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getVBVStatus()
/*  34:    */   {
/*  35:149 */     return this.mstrVBVStatus;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setMPIRequestDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
/*  39:    */   {
/*  40:158 */     this.mstrPurchaseAmount = paramString1;
/*  41:159 */     this.mstrDisplayAmount = paramString2;
/*  42:160 */     this.mstrCurrencyVal = paramString3;
/*  43:161 */     this.mstrExponent = paramString4;
/*  44:162 */     this.mstrOrderDesc = paramString5;
/*  45:163 */     this.mstrRecurFreq = paramString6;
/*  46:164 */     this.mstrRecurEnd = paramString7;
/*  47:165 */     this.mstrInstallment = paramString8;
/*  48:166 */     this.mstrDeviceCategory = paramString9;
/*  49:167 */     this.mstrWhatIUse = paramString10;
/*  50:168 */     this.mstrAcceptHdr = paramString11;
/*  51:169 */     this.mstrAgentHdr = paramString12;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setMPIResponseDetails(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
/*  55:    */   {
/*  56:178 */     this.mstrECI = paramString1;
/*  57:179 */     this.mstrXID = paramString2;
/*  58:180 */     this.mstrVBVStatus = paramString3;
/*  59:181 */     this.mstrCAVV = paramString4;
/*  60:182 */     this.mstrShoppingContext = paramString5;
/*  61:183 */     this.mstrPurchaseAmount = paramString6;
/*  62:184 */     this.mstrCurrencyVal = paramString7;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getCAVV()
/*  66:    */   {
/*  67:190 */     return this.mstrCAVV;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getPurchaseAmount()
/*  71:    */   {
/*  72:196 */     return this.mstrPurchaseAmount;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getDisplayAmount()
/*  76:    */   {
/*  77:201 */     return this.mstrDisplayAmount;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getCurrencyVal()
/*  81:    */   {
/*  82:206 */     return this.mstrCurrencyVal;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getExponent()
/*  86:    */   {
/*  87:211 */     return this.mstrExponent;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getOrderDesc()
/*  91:    */   {
/*  92:216 */     return this.mstrOrderDesc;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getRecurFreq()
/*  96:    */   {
/*  97:221 */     return this.mstrRecurFreq;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getRecurEnd()
/* 101:    */   {
/* 102:226 */     return this.mstrRecurEnd;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getInstallment()
/* 106:    */   {
/* 107:231 */     return this.mstrInstallment;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getDeviceCategory()
/* 111:    */   {
/* 112:236 */     return this.mstrDeviceCategory;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getWhatIUse()
/* 116:    */   {
/* 117:241 */     return this.mstrWhatIUse;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getAcceptHdr()
/* 121:    */   {
/* 122:246 */     return this.mstrAcceptHdr;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getAgentHdr()
/* 126:    */   {
/* 127:251 */     return this.mstrAgentHdr;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getShoppingContext()
/* 131:    */   {
/* 132:255 */     return this.mstrShoppingContext;
/* 133:    */   }
/* 134:    */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.MPIData
 * JD-Core Version:    0.7.0.1
 */