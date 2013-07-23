package com.mootly.wcm.it.workflow;

public class Attachment {
	String mime;
	String fileName;
	String base64Data;
	
	public Attachment(String mime,String fileName,String base64Data) {
		this.mime = mime;
		this.fileName = fileName;
		this.base64Data = base64Data;
	}
	
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBase64Data() {
		return base64Data;
	}
	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}
	
	
}
