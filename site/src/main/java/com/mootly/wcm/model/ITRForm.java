package com.mootly.wcm.model;

public enum ITRForm {
	ITR1("ITR-1",new ITRServiceDelivery[] {ITRServiceDelivery.DIY,ITRServiceDelivery.Assisted},1),
	ITR2("ITR-2",new ITRServiceDelivery[] {ITRServiceDelivery.DIY,ITRServiceDelivery.Assisted},2),
	ITR3("ITR-3",new ITRServiceDelivery[] {ITRServiceDelivery.DIY,ITRServiceDelivery.Assisted},3),
	ITR4("ITR-4",new ITRServiceDelivery[] {ITRServiceDelivery.DIY,ITRServiceDelivery.Assisted},4),
	ITR4S("ITR-4S",new ITRServiceDelivery[] {ITRServiceDelivery.DIY, ITRServiceDelivery.Assisted},5),
	ITR5("ITR-5",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted},6),
	ITR6("ITR-6",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted},7),
	ITR7("ITR-7",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted},8),
	ITR8("ITR-8",new ITRServiceDelivery[] {ITRServiceDelivery.Assisted},9),
	UNKNOWN;

	String whoCanAndWhoCannot;
	String displayName;
	Boolean hasDIY = Boolean.FALSE;
	ITRServiceDelivery[] serviceDeliveryOptions;
	int priority;

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
	ITRForm(String displayName,ITRServiceDelivery[] serviceDeliveryOptions,int priority) {
		this.displayName = displayName;
		this.serviceDeliveryOptions = serviceDeliveryOptions;
		this.hasDIY = false;
		this.priority = priority;
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

	public int getPriority() {
		return this.priority;
	}

}
