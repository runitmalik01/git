/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.StringTokenizer;
/*  5:   */ 
/*  6:   */ public class PGSearchResponse
/*  7:   */ {
/*  8:   */   private String mstrRespCode;
/*  9:   */   private String mstrRespMessage;
/* 10:   */   ArrayList moPGResponseObjects;
/* 11:   */   private static final String TXN_SUCCESS_RESP = "0";
/* 12:   */   
/* 13:   */   public PGSearchResponse() {}
/* 14:   */   
/* 15:   */   public String getRespCode()
/* 16:   */   {
/* 17:20 */     return this.mstrRespCode;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setRespCode(String paramString)
/* 21:   */   {
/* 22:24 */     this.mstrRespCode = paramString;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getRespMessage()
/* 26:   */   {
/* 27:28 */     return this.mstrRespMessage;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setRespMessage(String paramString)
/* 31:   */   {
/* 32:32 */     this.mstrRespMessage = paramString;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public ArrayList getPGResponseObjects()
/* 36:   */   {
/* 37:36 */     return this.moPGResponseObjects;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setPGResponseObjects(ArrayList paramArrayList)
/* 41:   */   {
/* 42:40 */     this.moPGResponseObjects = paramArrayList;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public PGSearchResponse(String paramString)
/* 46:   */   {
/* 47:46 */     StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "\n");
/* 48:47 */     int i = 1;
/* 49:   */     try
/* 50:   */     {
/* 51:50 */       while (localStringTokenizer.hasMoreElements())
/* 52:   */       {
/* 53:51 */         String str = localStringTokenizer.nextToken();
/* 54:52 */         PGResponse localPGResponse = new PGResponse(str);
/* 55:53 */         if (i == 1)
/* 56:   */         {
/* 57:54 */           this.mstrRespCode = localPGResponse.getRespCode();
/* 58:55 */           this.mstrRespMessage = localPGResponse.getRespMessage();
/* 59:56 */           if (!this.mstrRespCode.equals("0")) {
/* 60:   */             break;
/* 61:   */           }
/* 62:57 */           this.moPGResponseObjects = new ArrayList();
/* 63:   */         }
/* 64:   */         else
/* 65:   */         {
/* 66:64 */           this.moPGResponseObjects.add(localPGResponse);
/* 67:   */         }
/* 68:66 */         i++;
/* 69:   */       }
/* 70:   */     }
/* 71:   */     catch (Exception localException) {}finally {}
/* 72:   */   }
/* 73:   */   
/* 74:   */   public String toString()
/* 75:   */   {
/* 76:78 */     String str1 = "mstrRespCode: " + this.mstrRespCode + "\n" + "mstrRespMessage : " + this.mstrRespMessage + "\n";
/* 77:   */     
/* 78:80 */     String str2 = "";
/* 79:82 */     if (this.moPGResponseObjects != null) {
/* 80:83 */       for (int i = 0; i < this.moPGResponseObjects.size(); i++) {
/* 81:84 */         str2 = str2 + ((PGResponse)this.moPGResponseObjects.get(i)).toString() + "\n";
/* 82:   */       }
/* 83:   */     }
/* 84:88 */     return str1 + str2;
/* 85:   */   }
/* 86:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.PGSearchResponse
 * JD-Core Version:    0.7.0.1
 */