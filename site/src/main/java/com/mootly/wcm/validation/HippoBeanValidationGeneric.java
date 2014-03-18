package com.mootly.wcm.validation;

import org.hippoecm.hst.content.beans.standard.HippoDocument;

public class HippoBeanValidationGeneric  {
	
	public enum ACTION {DISPLAY_NOTICE,REDIRECT,DISPLAY_DIALOG,FREEZE_INCOMETAX_RETURN}
	public enum ACTION_REASON {SUCCESSFUL_SUBMISSION,UNKNOWN_REASON,VERIFICATION_PENDING}
	public enum REDIRECT_TARGET {REF_ID,ABSOLUTE_URL,RELATIVE_URL};
	public enum TYPE {INFORMATION,ERROR,WARNING,PROMOTION,ACTION};
	
	String[] messageArgs = null;
	String message;
	String messageKey;
	TYPE type;
	ACTION action;
	ACTION_REASON actionReason;
	String uuid;
	String screenHead;
	Class<? extends HippoDocument> hippoDocumentClass;
	
	public HippoBeanValidationGeneric() {
		// TODO Auto-generated constructor stub
		this.type = TYPE.INFORMATION;
	}

	public HippoBeanValidationGeneric(String message) {
		this.type = TYPE.INFORMATION;
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	
	public HippoBeanValidationGeneric(TYPE type,String message) {
		this.type = type;
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	
	public HippoBeanValidationGeneric(String messageKey,String message,TYPE type) {
		this.messageKey = messageKey;
		this.message = message;
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	public ACTION_REASON getActionReason() {
		return actionReason;
	}

	public void setActionReason(ACTION_REASON actionReason) {
		this.actionReason = actionReason;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public ACTION getAction() {
		return action;
	}

	public void setAction(ACTION action) {
		this.action = action;
	}

	public String[] getMessageArgs() {
		return messageArgs;
	}

	public void setMessageArgs(String[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	public Class<? extends HippoDocument> getHippoDocumentClass() {
		return hippoDocumentClass;
	}

	public void setHippoDocumentClass(
			Class<? extends HippoDocument> hippoDocumentClass) {
		this.hippoDocumentClass = hippoDocumentClass;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getScreenHead() {
		return screenHead;
	}

	public void setScreenHead(String screenHead) {
		this.screenHead = screenHead;
	}
	
}
