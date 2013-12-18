package com.mootly.wcm.services;

public interface SequenceGenerator {
	public final String SEQUENCE_FOLDER_NAME = "folderSequence";
	public final String SEQUENCE_INVOICE = "invoiceSequence";
	public final String SEQUENCE_PAYMENT = "paymentIdSequence";
	public final String SEQUENCE_DOCUMENT = "documentSequence";
	
	public final String SEQUENCE_HELP_DESK_TICKET = "ticketSequence";
	public final String SEQUENCE_SERVICE_REQUEST = "serviceRequest";
	Long getNextId(String sequenceName);
	
}
