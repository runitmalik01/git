package com.mootly.wcm.services;

public interface SequenceGenerator {
	public final String SEQUENCE_FOLDER_NAME = "folderSequence";
	long getNextId(String sequenceName);
	
}
