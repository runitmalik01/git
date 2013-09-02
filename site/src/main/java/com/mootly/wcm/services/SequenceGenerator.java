package com.mootly.wcm.services;

public interface SequenceGenerator {
	public final String SEQUENCE_FOLDER_NAME = "folderSequence";
	public final String SEQUENCE_INVOICE = "invoiceSequence";
	public final String SEQUENCE_PAYMENT = "paymentIdSequence";
	long getNextId(String sequenceName);
	
}
