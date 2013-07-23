package com.mootly.wcm.model;

public enum ITRForm {
	ITR1("ITR-1",new ITRServiceDelivery[] {ITRServiceDelivery.DIY,ITRServiceDelivery.Assisted}),
	ITR2("ITR-2",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR3("ITR-3",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR4("ITR-4",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR4S("ITR-4S",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR5("ITR-5",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR6("ITR-6",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR7("ITR-7",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	ITR8("ITR-8",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted}),
	UNKNOWN;
	
	String whoCanAndWhoCannot;
	String displayName;
	Boolean hasDIY = Boolean.FALSE;
	ITRServiceDelivery[] serviceDeliveryOptions;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	ITRForm() {
	}
	
	ITRForm(String displayName) {
		this.displayName = displayName;
		this.hasDIY = false;
	}
	
	ITRForm(String displayName,Boolean hasDIY) {
		this.displayName = displayName;
		this.hasDIY = true;
	}
	
	ITRForm(String displayName,ITRServiceDelivery[] serviceDeliveryOptions) {
		this.displayName = displayName;
		this.serviceDeliveryOptions = serviceDeliveryOptions;
		this.hasDIY = false;
		if (serviceDeliveryOptions != null && serviceDeliveryOptions.length >0) {
			for (ITRServiceDelivery serviceDelivery:serviceDeliveryOptions) {
				if (serviceDelivery == ITRServiceDelivery.DIY) {
					this.hasDIY = true;
				}
			}
		}
	}
	
	public Boolean getHasDIY() {
		return hasDIY;
	}
	
	public ITRServiceDelivery[] getServiceDeliveryOptions() {
		return this.serviceDeliveryOptions;
	}
	
	public static ITRForm getEnumByDisplayName(String displayName) {
		if (displayName == null) return UNKNOWN;
		for (ITRForm aStatus:ITRForm.values()) {
			if (displayName.equals(aStatus.getDisplayName())) {
				return aStatus;
			}
		}
		return UNKNOWN;
	}
	
}
