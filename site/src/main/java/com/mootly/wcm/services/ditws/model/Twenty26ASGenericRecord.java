package com.mootly.wcm.services.ditws.model;

public abstract class Twenty26ASGenericRecord {
	
	Boolean hasAlreadyBeenImported = false;
	
	public final Boolean getHasAlreadyBeenImported() {
		return hasAlreadyBeenImported;
	}

	public final void setHasAlreadyBeenImported(Boolean hasAlreadyBeenImported) {
		this.hasAlreadyBeenImported = hasAlreadyBeenImported;
	}	
	
}
