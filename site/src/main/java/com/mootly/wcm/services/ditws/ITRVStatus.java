package com.mootly.wcm.services.ditws;

public enum ITRVStatus {
	RECEIVED("ITR-V received"),NOT_RECEIVED("ITR-V not received");
	
	String returnSOAPResponse;
	
	private ITRVStatus (String returnSOAPResponse) {
		this.returnSOAPResponse = returnSOAPResponse;
	}
	
	public String getReturnSOAPResponse() {
		return returnSOAPResponse;
	}

	public static ITRVStatus getBySOAPResponse(String soapResponse) {
		if (soapResponse == null) return null;
		for (ITRVStatus aStatus:ITRVStatus.values()) {
			if (aStatus.getReturnSOAPResponse().equalsIgnoreCase(soapResponse)) {
				return aStatus;
			}
		}
		return null;
	}
}
