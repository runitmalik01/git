/*  1:   */ package com.opus.epg.sfa.java;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.io.PrintWriter;
/*  5:   */ 
/*  6:   */ public class SFAApplicationException
/*  7:   */   extends Exception
/*  8:   */ {
/*  9:   */   private Throwable monestedException;
/* 10:   */   private String mstrerrorCode;
/* 11:   */   
/* 12:   */   public SFAApplicationException(String paramString)
/* 13:   */   {
/* 14:11 */     this(null, paramString, null);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public SFAApplicationException(String paramString1, String paramString2)
/* 18:   */   {
/* 19:15 */     this(paramString1, paramString2, null);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public SFAApplicationException(String paramString1, String paramString2, Throwable paramThrowable)
/* 23:   */   {
/* 24:20 */     super(paramString2);
/* 25:21 */     this.mstrerrorCode = paramString1;
/* 26:22 */     this.monestedException = paramThrowable;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getErrorCode()
/* 30:   */   {
/* 31:26 */     return this.mstrerrorCode;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Throwable getNestedException()
/* 35:   */   {
/* 36:30 */     return this.monestedException;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String toString()
/* 40:   */   {
/* 41:34 */     return getClass().getName() + ": " + (this.mstrerrorCode == null ? "" : new StringBuffer().append(this.mstrerrorCode).append(": ").toString()) + getMessage();
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void printStackTrace()
/* 45:   */   {
/* 46:40 */     if (this.monestedException != null) {
/* 47:41 */       this.monestedException.printStackTrace();
/* 48:   */     }
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void printStackTrace(PrintWriter paramPrintWriter)
/* 52:   */   {
/* 53:46 */     if (this.monestedException != null) {
/* 54:47 */       this.monestedException.printStackTrace(paramPrintWriter);
/* 55:   */     }
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void printStackTrace(PrintStream paramPrintStream)
/* 59:   */   {
/* 60:52 */     if (this.monestedException != null) {
/* 61:53 */       this.monestedException.printStackTrace(paramPrintStream);
/* 62:   */     }
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Amit\Downloads\JAVA\JAVA\SFAClient\SFAClient\SFA\sfa\
 * Qualified Name:     com.opus.epg.sfa.java.SFAApplicationException
 * JD-Core Version:    0.7.0.1
 */